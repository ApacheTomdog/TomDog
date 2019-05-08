package com.brcc.business.brokerTax.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import com.brcc.business.brokerTax.repository.IBrokerTaxDetailRepository;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailVo;
import com.esteel.common.dao.PageQuery;

/**
 *	 经纪人税额明细
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxDetailRepositoryImpl implements IBrokerTaxDetailRepository{
	
	@Autowired
    private PageQuery pageQuery;
    
	@Override
	public Page<BrokerTaxDetailVo> queryDetailPage(BrokerTaxDetailQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select");
		sql.append(" b.broker_tax_detail_id,");
		sql.append(" b.broker_tax_master_id,");
		sql.append(" b.pay_bill_num,");
		sql.append(" b.publish_id,");
		sql.append(" b.publish_depend_num,");
		sql.append(" b.trans_id,");
		sql.append(" b.delivery_id,");
		sql.append(" b.broker_tax_quarter,");
		sql.append(" b.broker_id,");
		sql.append(" b.broker_name,");
		sql.append(" b.broker_mobile,");
		sql.append(" b.publish_company_id,");
		sql.append(" b.publish_company_name,");
		sql.append(" b.publish_company_tele,");
		sql.append(" b.driver_id,");
		sql.append(" b.driver_name,");
		sql.append(" b.vehicle_id,");
		sql.append(" b.vehicle_num,");
		sql.append(" b.payed_amt,");
		sql.append(" b.payed_tax,");
		sql.append(" b.profit_amt,");
		sql.append(" b.profit_tax,");
		sql.append(" b.if_stat,");
		sql.append(" t.good_type_desc,");
		sql.append(" t.price,");
		sql.append(" t.amount,");
		sql.append(" t.get_order_plate,");
		sql.append(" t.start_plate,");
		sql.append(" t.end_plate");
		sql.append(" from broker_tax_detail b, transportationdelivery t");
		sql.append(" where b.delivery_id = t.delivery_id");
		
		sql.append(" and b.broker_id = ?");
		params.add(queryVo.getBrokerId());
		
		sql.append(" and b.broker_tax_quarter = ?");
		params.add(queryVo.getBrokerTaxQuarter());
		
		if(!StringUtils.isEmpty(queryVo.getPayBillNum())) {
			sql.append(" and b.pay_bill_num like concat('%', ?, '%')");
			params.add(queryVo.getPayBillNum());
		}
		
		if(queryVo.getPublishId() != null) {
			sql.append(" and b.publish_id like concat('%', ?, '%')");
			params.add(queryVo.getPublishId());
		}
		
		if(queryVo.getTransId() != null) {
			sql.append(" and b.trans_id like concat('%', ?, '%')");
			params.add(queryVo.getTransId());
		}
		
		if(queryVo.getDeliveryId() != null) {
			sql.append(" and b.delivery_id like concat('%', ?, '%')");
			params.add(queryVo.getDeliveryId());
		}
		
		if(!StringUtils.isEmpty(queryVo.getPublishCompanyName())) {
			sql.append(" and b.publish_company_name like concat('%', ?, '%')");
			params.add(queryVo.getPublishCompanyName());
		}
		
		if(!StringUtils.isEmpty(queryVo.getDriverName())) {
			sql.append(" and b.driver_name like concat('%', ?, '%')");
			params.add(queryVo.getDriverName());
		}
		
		sql.append(" order by b.broker_tax_detail_id desc");
		Page<BrokerTaxDetailVo> page = pageQuery.query(sql.toString(), params, queryVo, BrokerTaxDetailVo.class);
		return page;
	}

}
