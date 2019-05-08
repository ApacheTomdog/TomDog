package com.brcc.business.brokerTax.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brcc.business.brokerTax.repository.IBrokerTaxCycleRepository;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;
import com.esteel.common.dao.PageQuery;

/**
 *	季度配置
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxCycleRepositoryImpl implements IBrokerTaxCycleRepository{
	
	@Autowired
    private PageQuery pageQuery;
    
	@Override
	public List<BrokerTaxCycleVo> queryCycleList() {
		String sql = "SELECT DISTINCT broker_tax_cycle_name as brokerTaxCycleName from broker_tax_cycle ORDER BY broker_tax_year_month desc";
		return pageQuery.list(sql, BrokerTaxCycleVo.class);
	}

}
