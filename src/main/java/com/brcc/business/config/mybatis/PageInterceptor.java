package com.brcc.business.config.mybatis;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.util.JdbcUtils;
import com.esteel.common.dao.MySqlPageUtils;
import com.esteel.common.dao.PageQuery;
import com.esteel.common.vo.AbstractBaseQuery;
import com.esteel.common.vo.AggregationPageImpl;
import com.esteel.common.vo.BaseQueryVo;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.type.TypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-10-30
 * Time: 11:23
 */

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
@Component
public class PageInterceptor implements Interceptor {

    Logger logger = LoggerFactory.getLogger(PageInterceptor.class);





    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        BaseQueryVo baseQueryVo = PageLocal.get();

        if (baseQueryVo != null) {

            long total = 0L;
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();

            if (PageLocal.getPage()==null) {

                //查询总条数
                logger.info("mybatis intercept sql:{}", sql);

                List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);

                if (stmtList.size() != 1) {
                    throw new IllegalArgumentException("sql not support count : " + sql);
                }

                SQLStatement stmt = stmtList.get(0);

                if (!(stmt instanceof SQLSelectStatement)) {
                    throw new IllegalArgumentException("sql not support count : " + sql);
                }

                SQLSelectStatement selectStmt = (SQLSelectStatement) stmt;

                String countSql = MySqlPageUtils.count(selectStmt.getSelect(), JdbcConstants.MYSQL);

                Connection connection = (Connection) invocation.getArgs()[0];
                PreparedStatement countStatement = connection.prepareStatement(countSql);
                ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
                try {
                    parameterHandler.setParameters(countStatement);
                } catch (TypeException ex) {
                    String slowCountSql = "select count(*) from (" + sql + ") _aaa";
                    countStatement = connection.prepareStatement(slowCountSql);
                    parameterHandler.setParameters(countStatement);

                }
                ResultSet rs = countStatement.executeQuery();

                if (rs.next()) {
                    total = rs.getLong(1);
                }
                rs.close();
            }else{
                total = PageLocal.getPage().getTotal();
            }

            Pageable pageable = baseQueryVo.getPageable();

            if (pageable.getOffset() > total) {
                //pageable
                int totalPage = (int) (total / pageable.getPageSize());
                if ((total > 0) && (total % pageable.getPageSize() == 0)) {
                    totalPage -= 1;
                }
                pageable = PageRequest.of(totalPage, pageable.getPageSize());

            }
            String pageSql = pageSql(orderSql(sql, baseQueryVo), pageable);
            metaObject.setValue("delegate.boundSql.sql", pageSql);


            PageReustDto pageReustDto = new PageReustDto(pageable,total);

            PageLocal.setPage(pageReustDto);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


    private String pageSql(String sql, Pageable pageable) {

        return PagerUtils.limit(sql, JdbcConstants.MYSQL, (int) pageable.getOffset(), pageable.getPageSize());

    }


    /**
     * 排序sql语句
     *
     * @param sql
     * @param vo
     * @return
     */
    public String orderSql(String sql, AbstractBaseQuery vo) {

        String[] sorts = vo.getSort();
        String[] orders = vo.getOrder();

        if (ObjectUtils.isEmpty(sorts) || sorts.length != orders.length) {
            return sql;
        }


        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);

        if (stmtList.size() != 1) {
            throw new IllegalArgumentException("sql not support order : " + sql);
        }

        SQLStatement stmt = stmtList.get(0);

        if (!(stmt instanceof SQLSelectStatement)) {
            throw new IllegalArgumentException("sql not support order : " + sql);
        }

        SQLSelectStatement selectStmt = (SQLSelectStatement) stmt;

        SQLSelect select = selectStmt.getSelect();

        StringBuffer sqlBuffer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        SQLASTOutputVisitor sqlVisitor = SQLUtils.createFormatOutputVisitor(sqlBuffer, stmtList, JdbcUtils.MYSQL);
        SQLASTOutputVisitor selectVisitor = SQLUtils.createFormatOutputVisitor(buffer, stmtList, JdbcUtils.MYSQL);

        SQLSelectQueryBlock query = (SQLSelectQueryBlock) select.getQuery();

        query.setOrderBy(null);
        query.accept(sqlVisitor);

        List<SQLSelectItem> selectList = query.getSelectList();
        selectList.forEach(sqlSelectItem -> {
            sqlSelectItem.accept(selectVisitor);
            buffer.append(" , ");
        });

        sqlBuffer.append(" order by ");

        //sql语句中 包含这个词
        String lowerCaseSql = buffer.toString().toLowerCase();
        for (int i = 0; i < sorts.length; i++) {
            String sort = sorts[i];
            String order = orders[i];
            if (lowerCaseSql.indexOf(sort.toLowerCase()) == -1) {
                sort = this.covertColumnName(sort);
            }

            String orderStr = " ASC ";
            if (order != null && order.toLowerCase().trim().equals("desc")) {
                orderStr = " DESC ";
            }
            sqlBuffer.append(sort).append(" ").append(orderStr);
            if (i < sorts.length - 1) {
                sqlBuffer.append(" , ");
            }
        }

        return sqlBuffer.toString();
    }


    /**
     * 按照标准的sql 命名法 讲 属性名 转换成数据库的名字
     *
     * @param name
     * @return
     */
    private String covertColumnName(String name) {

        if (name != null) {
            StringBuilder result = new StringBuilder();

            char[] chars = name.toCharArray();
            for (char c : chars) {
                if (Character.isUpperCase(c)) {
                    result.append("_");
                    result.append(c);
                } else {
                    result.append(c);
                }
            }
            return result.toString().toUpperCase();
        }
        return null;
    }


}

