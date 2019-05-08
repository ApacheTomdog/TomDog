package com.brcc.business.brokerTax.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerTax.repository.BrokerTaxMasterRepository;
import com.brcc.business.brokerTax.service.BrokerTaxMasterService;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterVo;

@Service
public class BrokerTaxMasterServiceImpl implements BrokerTaxMasterService {
	Logger logger = LoggerFactory.getLogger(BrokerTaxMasterServiceImpl.class);

	@Autowired
	private BrokerTaxMasterRepository repository;
	
	@Override
	public Page<BrokerTaxMasterVo> queryPage(BrokerTaxMasterQueryVo queryVo) {
		logger.info("queryPage,{}", queryVo.toString());
		return repository.queryPage(queryVo);
	}

	@Override
	public Page<BrokerTaxMasterVo> queryList(BrokerTaxMasterQueryVo queryVo) {
		logger.info("queryList,{}", queryVo.toString());
		return repository.queryPage(queryVo);
	}

	@Override
	public BigDecimal totProfitAmt(BrokerTaxMasterQueryVo queryVo) {
		BigDecimal totProfitAmt=repository.totProfitAmt(queryVo.getBrokerId());
		return totProfitAmt;
	}
	
}
