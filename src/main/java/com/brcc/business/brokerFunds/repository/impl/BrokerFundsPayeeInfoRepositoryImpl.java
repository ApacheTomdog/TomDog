package com.brcc.business.brokerFunds.repository.impl;
import com.brcc.business.brokerFunds.repository.IBrokerFundsPayeeInfoRepository;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 资金流水单分配实现类
 * @Author pjy
 * @Date
 **/
public class BrokerFundsPayeeInfoRepositoryImpl implements IBrokerFundsPayeeInfoRepository {
    @Autowired
    PageQuery pageQuery;
    @Autowired
    EntityManager entityManager;

    @Override
    public Page<BrokerFundsPayeeInfoVo> lookPayeeDetail(BrokerFundsPayeeInfoQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select b.* , ");
        sql.append(" c.master_status,  ");
        sql.append(" ifnull(m.tot_inaudit_amt,0.00)+ ifnull(m.tot_audited_amt,0.00) as 'quarterPayeeAmount'");
        sql.append(" from broker_funds_payee_info b join ");
        sql.append(" brokerfundscontrolmaster c ");
        sql.append(" on (c.funds_control_master_id =b.funds_control_master_id) ");
        sql.append(" left join broker_payee_capital m on (m.company_payee_id = b.company_payee_id and m.quarter_name = c.broker_tax_cycle_name and c.borker_company_id = b.company_id) ");
        sql.append(" where 1=1 ");
        sql.append(" and  b.funds_control_master_id =?  ");
        args.add(vo.getFundsControlMasterId());
        if(!StringUtils.isEmpty(vo.getCompanyPayeeName())){
            sql.append("and  b.company_payee_name like ? ");
            args.add("%" + vo.getCompanyPayeeName()+ "%");
        }
        sql.append(" order by b.create_date desc");
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsPayeeInfoVo.class);
    }

    @Override
    public ArrayList checkPayeeAmountPro(Integer asPkId,String asType,String userId, String userName) {
        StoredProcedureQuery docuNo = entityManager.createNamedStoredProcedureQuery("pro_broker_payee_process");
        docuNo.setParameter("asPkId",asPkId);
        docuNo.setParameter("asType",asType);
        docuNo.setParameter("userId",userId);
        docuNo.setParameter("userName",userName);
        ArrayList resultList = (ArrayList) docuNo.getResultList();
        return resultList;
    }
}
