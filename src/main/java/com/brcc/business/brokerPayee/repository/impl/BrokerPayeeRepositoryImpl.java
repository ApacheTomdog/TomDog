package com.brcc.business.brokerPayee.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import com.brcc.business.brokerPayee.repository.IBrokerPayeeRepository;
import com.brcc.business.brokerPayee.vo.BrokerPayeeQueryVo;
import com.brcc.business.brokerPayee.vo.BrokerPayeeVo;
import com.esteel.common.dao.PageQuery;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
public class BrokerPayeeRepositoryImpl implements IBrokerPayeeRepository{
	
	@Autowired
	PageQuery pageQuery;

	@Override
	public Page<BrokerPayeeVo> listDataPage(BrokerPayeeQueryVo queryvo) {
		
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from broker_payee b where 1=1 ");
		sql.append("and b.company_id =?");
		params.add(queryvo.getCompanyId());
		
		if (!ObjectUtils.isEmpty(queryvo.getCompanyPayeeStatus())) {
			sql.append(" and b.company_payee_status = ? ");
			params.add(queryvo.getCompanyPayeeStatus());
		}
		if (!StringUtils.isEmpty(queryvo.getCompanyPayeeName())) {
			sql.append(" and b.company_payee_name like  ? ");
			params.add("%" + queryvo.getCompanyPayeeName() + "%");
		}
		// 开始时间
		if (!ObjectUtils.isEmpty(queryvo.getRqStart())) {
			sql.append(" AND b.CREATE_DATE >= ? ");
			params.add(queryvo.getRqStart());
		}
		// 结束时间
		if (!ObjectUtils.isEmpty(queryvo.getRqEnd())) {
			sql.append(" AND b.CREATE_DATE <= ? ");
			params.add(queryvo.getRqEnd());
		}
		sql.append("order by b.CREATE_DATE desc ");
		
		Page<BrokerPayeeVo> page = pageQuery.query(sql.toString(), params, queryvo, BrokerPayeeVo.class);
		return page;
	}

	@Override
	public Page<BrokerPayeeVo> list(BrokerPayeeQueryVo queryvo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from broker_payee b where 1=1 ");
		sql.append("and b.company_payee_status = '20' ");
		sql.append("and b.company_id =?");
		params.add(queryvo.getCompanyId());
		
		if (!ObjectUtils.isEmpty(queryvo.getCompanyPayeeStatus())) {
			sql.append(" and b.company_payee_num like ? ");
			params.add("%" + queryvo.getCompanyPayeeNum() + "%");
		}
		if (!StringUtils.isEmpty(queryvo.getCompanyPayeeName())) {
			sql.append(" and b.company_payee_name like  ? ");
			params.add("%" + queryvo.getCompanyPayeeName() + "%");
		}
		// 开始时间
		if (!ObjectUtils.isEmpty(queryvo.getRqStart())) {
			sql.append(" AND b.CREATE_DATE >= ? ");
			params.add(queryvo.getRqStart());
		}
		// 结束时间
		if (!ObjectUtils.isEmpty(queryvo.getRqEnd())) {
			sql.append(" AND b.CREATE_DATE <= ? ");
			params.add(queryvo.getRqEnd());
		}
		sql.append("order by b.CREATE_DATE desc ");
		
		Page<BrokerPayeeVo> page = pageQuery.query(sql.toString(), params, queryvo, BrokerPayeeVo.class);
		return page;
	}


}
