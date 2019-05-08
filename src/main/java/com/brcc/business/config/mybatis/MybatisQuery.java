package com.brcc.business.config.mybatis;
import com.esteel.common.vo.BaseQueryVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * 针对mybatis的查询方法
 *
 * User: zhangxiuzhi
 * Date: 2018-10-30
 * Time: 17:11
 */
@Component
public class MybatisQuery {

    Logger logger = LoggerFactory.getLogger(MybatisQuery.class);

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    @Qualifier("readSqlSessionTemplate")
    SqlSessionTemplate readSqlSessionTemplate;


    /**
     * 查询list的处理方式
     * @param statement
     * @param parameter
     * @param <E>
     * @return
     */
    public <E> List<E> list(String statement, Object parameter) {
        return sqlSessionTemplate.selectList(statement, parameter);
    }

    /**
     * 查询list的处理方式 查询只读数据库
     * @param statement
     * @param parameter
     * @param <E>
     * @return
     */
    public <E> List<E> readList(String statement, Object parameter) {
        return readSqlSessionTemplate.selectList(statement, parameter);
    }

    /**
     * 查询分页数据
     * @param statement
     * @param parameter
     * @param <E>
     * @return
     */
    public <E> Page<E> page(String statement, Object parameter) {

        try {
            Long total = this.selectOne(statement+"Count",parameter);
            PageReustDto pageReustDto = new PageReustDto(total);
            PageLocal.setPage(pageReustDto);
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }

        if (parameter instanceof BaseQueryVo){
            BaseQueryVo baseQueryVo = (BaseQueryVo)parameter;
            PageLocal.set(baseQueryVo);
        }

        List<E> list = this.list(statement,parameter);

        PageReustDto page = PageLocal.getPage();

        //清理掉threadlocal中的值
        PageLocal.set(null);
        PageLocal.setPage(null);

        if (page!=null){
            return new PageImpl<>(list,page.getPageable(),page.getTotal());
        }
        return new PageImpl<>(list);
    }

    /**
     * 查询分页数据 查询只读库
     * @param statement
     * @param parameter
     * @param <E>
     * @return
     */
    public <E> Page<E> readPage(String statement, Object parameter) {

        try {
            Long total = this.readSelectOne(statement+"Count",parameter);
            PageReustDto pageReustDto = new PageReustDto(total);
            PageLocal.setPage(pageReustDto);
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }

        if (parameter instanceof BaseQueryVo){
            BaseQueryVo baseQueryVo = (BaseQueryVo)parameter;
            PageLocal.set(baseQueryVo);
        }

        List<E> list = this.readList(statement,parameter);

        PageReustDto page = PageLocal.getPage();

        //清理掉threadlocal中的值
        PageLocal.set(null);
        PageLocal.setPage(null);

        if (page!=null){
            return new PageImpl<>(list,page.getPageable(),page.getTotal());
        }
        return new PageImpl<>(list);
    }

    /**
     * 查询单个数据
     * @param statement
     * @param parameter
     * @return
     */
    public <E> E selectOne(String statement, Object parameter) {
        return sqlSessionTemplate.selectOne(statement, parameter);
    }

    /**
     * 查询单个数据  查询只读库
     * @param statement
     * @param parameter
     * @return
     */
    public <E> E readSelectOne(String statement, Object parameter) {
        return readSqlSessionTemplate.selectOne(statement, parameter);
    }

    /**
     * 调用存储过程
     * @description:
     * @author:陈利
     * @date:2018年11月13日
     * @param statement
     * @param parameter
     */
    public void executePro(String statement, Object parameter) {
    	sqlSessionTemplate.update(statement, parameter);
    }

    /**
     * 调用存储过程 只读库
     * @description:
     * @author:陈利
     * @date:2018年11月13日
     * @param statement
     * @param parameter
     */
    public void readExecutePro(String statement, Object parameter) {
        readSqlSessionTemplate.update(statement, parameter);
    }
}
