package com.brcc.business.brokerTax.service.impl;

import java.util.List;

import com.brcc.business.brokerTax.entity.BrokerTaxCycleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerTax.repository.BrokerTaxCycleRepository;
import com.brcc.business.brokerTax.service.BrokerTaxCycleService;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;

@Service
public class BrokerTaxCycleServiceImpl implements BrokerTaxCycleService {
	Logger logger = LoggerFactory.getLogger(BrokerTaxCycleServiceImpl.class);

	@Autowired
	private BrokerTaxCycleRepository repository;
	
	@Override
	public List<BrokerTaxCycleVo> queryCycleList() {
		logger.info("queryCycleList");
		return repository.queryCycleList();
	}

	@Override
	public String getTaxCycle(String  brokerTaxCycleName) {
		logger.info("getTaxCycle by String  brokerTaxCycleName{}:",brokerTaxCycleName);
		return repository.getTaxCycle(brokerTaxCycleName);
	}
	@Override
	public String getBrokerTaxCycleName(String brokerTaxYearMonth){
		logger.info("getBrokerTaxCycleName by String  brokerTaxYearMonth{}:",brokerTaxYearMonth);
		return repository.getBrokerTaxCycleName(brokerTaxYearMonth);
	}
}
