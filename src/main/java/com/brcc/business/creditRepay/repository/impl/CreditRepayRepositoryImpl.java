package com.brcc.business.creditRepay.repository.impl;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import com.brcc.business.creditRepay.repository.ICreditRepayRepository;
import com.brcc.business.creditRepay.vo.CreditRepaySearchQueryVo;
import com.brcc.business.creditRepay.vo.RepayCompanyVo;
import com.esteel.common.dao.PageQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 授信还款数据操作类
 * @Auther: gemaochao
 * @Date:Created in 16:44 2018/11/7
 */
public class CreditRepayRepositoryImpl implements ICreditRepayRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MybatisQuery mybatisQuery;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Page<CreditRepayEntity> queryRepay(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        logger.info("return credit repay page ,platFormId:{},CompanyId:{}",creditRepaySearchQueryVo.getPlatformId(),creditRepaySearchQueryVo.getCreditCompanyId());
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * FROM credit_repay t WHERE t.platform_id =?");
        arg.add(creditRepaySearchQueryVo.getPlatformId());
        sql.append("    and  t.credit_company_id =  ?");
        arg.add(creditRepaySearchQueryVo.getCreditCompanyId());
        if (!(StringUtils.isEmpty(creditRepaySearchQueryVo.getCreditRepayStatus()))){
            sql.append("    and  t.credit_repay_status= ?");
            arg.add(creditRepaySearchQueryVo.getCreditRepayStatus());
        }
        if (!(StringUtils.isEmpty(creditRepaySearchQueryVo.getInvestCompanyName()))){
            sql.append("    and t.invest_company_name like?");
            arg.add("%"+creditRepaySearchQueryVo.getInvestCompanyName()+"%");
        }
        if (creditRepaySearchQueryVo.getCreateStart() != null){
            sql.append("    and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            arg.add(creditRepaySearchQueryVo.getCreateStart());
        }
        if (creditRepaySearchQueryVo.getCreateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(creditRepaySearchQueryVo.getCreateEnd());
        }
        return pageQuery.query(sql.toString(),arg,creditRepaySearchQueryVo,CreditRepayEntity.class);
    }

    @Override
    public List<RepayCompanyVo> queryRepayCompany(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT m.credit_plat_company_id as \"seq_id\",c.company_name as \"company_name\"");
        sql.append("    FROM  apptms.credit_config m, apptms.company c");
        sql.append("    WHERE  m.credit_plat_company_id = c.seq_id");
        sql.append("    AND m.credit_status = '90'");
        sql.append("    and c.platform_id = ?");
        arg.add(creditRepaySearchQueryVo.getPlatformId());
        sql.append("    and m.platform_id =?");
        arg.add(creditRepaySearchQueryVo.getPlatformId());
        sql.append("    and m.publish_company_id  = ?");
        arg.add(creditRepaySearchQueryVo.getCreditCompanyId());
        return pageQuery.list(sql.toString(),arg,RepayCompanyVo.class);
    }


    @Override
    public Page<CreditRepayEntity> queryRepayAudit(CreditRepaySearchQueryVo creditRepaySearchQueryVo) {
        logger.info("return credit repay page ,platFormId:{},CompanyId:{}",creditRepaySearchQueryVo.getPlatformId(),creditRepaySearchQueryVo.getCreditCompanyId());
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * FROM credit_repay t WHERE  t.platform_id =?");
        arg.add(creditRepaySearchQueryVo.getPlatformId());
        sql.append("    AND  t.invest_company_id =  ?");
        arg.add(creditRepaySearchQueryVo.getCreditCompanyId());
        if (!(StringUtils.isEmpty(creditRepaySearchQueryVo.getCreditRepayStatus()))){
            sql.append("    and  t.credit_repay_status= ?");
            arg.add(creditRepaySearchQueryVo.getCreditRepayStatus());
        }
        if (!(StringUtils.isEmpty(creditRepaySearchQueryVo.getInvestCompanyName()))){
            sql.append("    and t.invest_company_name like?");
            arg.add("%"+creditRepaySearchQueryVo.getInvestCompanyName()+"%");
        }
        if (creditRepaySearchQueryVo.getCreateStart() != null){
            sql.append("    and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(creditRepaySearchQueryVo.getCreateStart());
        }
        if (creditRepaySearchQueryVo.getCreateEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(creditRepaySearchQueryVo.getCreateEnd());
        }
        return pageQuery.query(sql.toString(),arg,creditRepaySearchQueryVo,CreditRepayEntity.class);
    }

    @Override
    public Map<String, Object> getSeqNo(Long typeId) {
        List prList = new ArrayList();
        prList.add(new SqlParameter(Types.INTEGER));
        prList.add(new SqlOutParameter("as_pk_no", Types.VARBINARY));
        Map<String,Object> resultData = jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement callableStatement = con.prepareCall("{call generate_docu_no(?, ?)}");
                callableStatement.setLong(1,typeId);
                callableStatement.registerOutParameter(2,Types.VARCHAR);
                return callableStatement;
            }
        },prList);
        return resultData;
    }

    @Override
    public void proCreditRepay(HashMap<String, Object> param) {

        mybatisQuery.executePro("credit.proCreditRepay",param);

    }
}
