package com.brcc.business.brokerTax.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import com.brcc.business.brokerTax.repository.IBrokerTaxMasterRepository;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterVo;
import com.esteel.common.dao.PageQuery;

/**
 *	 经纪人税额
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxMasterRepositoryImpl implements IBrokerTaxMasterRepository{
	
	@Autowired
    private PageQuery pageQuery;
    
	@Override
	public Page<BrokerTaxMasterVo> queryPage(BrokerTaxMasterQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select");
		sql.append(" broker_tax_quarter,");
		sql.append(" broker_id,");
		sql.append(" broker_name,");
		sql.append(" broker_login_name,");
		sql.append(" broker_tele,");
		sql.append(" broker_no,");
		sql.append(" SUM(tot_payed_amt) as tot_payed_amt,");
		sql.append(" SUM(tot_payed_tax) as tot_payed_tax,");
		sql.append(" SUM(tot_profit_amt) as tot_profit_amt,");
		sql.append(" SUM(tot_profit_tax) as tot_profit_tax,");
		sql.append(" SUM(tot_drawback_tax) as tot_drawback_tax,");
		sql.append(" tbl_status,");
		sql.append(" drawback_tax_bill_flag,");
		sql.append(" person_tax_bill_flag");
		sql.append(" from broker_tax_master");
		sql.append(" where 1 = 1");
		
		if(!StringUtils.isEmpty(queryVo.getBrokerId())) {
			sql.append(" and broker_id = ?");
			params.add(queryVo.getBrokerId());
		}
		
		if(!StringUtils.isEmpty(queryVo.getTblStatus())) {
			sql.append(" and tbl_status = ?");
			params.add(queryVo.getTblStatus());
		}
		
		if(!StringUtils.isEmpty(queryVo.getBrokerTaxQuarter())) {
			sql.append(" and broker_tax_quarter = ?");
			params.add(queryVo.getBrokerTaxQuarter());
		}
		
		if(!StringUtils.isEmpty(queryVo.getBrokerName())) {
			sql.append(" and broker_name like concat('%', ?, '%')");
			params.add(queryVo.getBrokerName());
		}
		
		if(!StringUtils.isEmpty(queryVo.getBrokerTele())) {
			sql.append(" and broker_tele like concat('%', ?, '%')");
			params.add(queryVo.getBrokerTele());
		}
		
		sql.append(" GROUP BY broker_tax_quarter, broker_id");
		sql.append(" order by broker_tax_quarter desc, broker_tax_master_id");
		Page<BrokerTaxMasterVo> page = pageQuery.query(sql.toString(), params, queryVo, BrokerTaxMasterVo.class);
		return page;
	}

}
