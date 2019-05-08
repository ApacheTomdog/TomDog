/**
 * 
 */
package com.brcc.business.creditBill.repository.impl;

import com.brcc.business.creditBill.entity.CreditBillDetailEntity;
import com.brcc.business.creditBill.repository.ICreditBillDetailRepository;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class CreditBillDetailRepositoryImpl implements ICreditBillDetailRepository {


    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<CreditBillDetailEntity> queryBillDetail(CreditBillQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("       SELECT" );
        sql.append("   		t.credit_bill_detail_id," );
        sql.append("   		t.credit_bill_id," );
        sql.append("   		t.credit_bill_no," );
        sql.append("   		t.credit_repay_id," );
        sql.append("   		t.credit_repay_no," );
        sql.append("   		t.platform_id," );
        sql.append("   		t.credit_company_id," );
        sql.append("   		t.credit_company_name," );
        sql.append("   		t.invest_company_id," );
        sql.append("   		t.invest_company_name," );
        sql.append("   		t.repay_amount," );
        sql.append("   		t.create_date," );
        sql.append("   		t.create_person_id," );
        sql.append("   		t.create_person_name," );
        sql.append("   		t.modify_date," );
        sql.append("   		t.modify_person_id," );
        sql.append("   		t.modify_person_name" );
        sql.append("   			FROM" );
        sql.append("   			credit_bill_detail AS t" );
        sql.append("   			where t.credit_bill_id=?" );
        arg.add(vo.getCreditBillId());
        sql.append("   			and t.platform_id=?	" );
        arg.add(vo.getPlatformId());
        return pageQuery.query(sql.toString(),arg,vo,CreditBillDetailEntity.class);
    }
}
