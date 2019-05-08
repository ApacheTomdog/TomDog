package com.brcc.business.brokerTax.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerTax.repository.BrokerTaxDetailRepository;
import com.brcc.business.brokerTax.service.BrokerTaxDetailService;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailVo;

@Service
public class BrokerTaxDetailServiceImpl implements BrokerTaxDetailService {
	Logger logger = LoggerFactory.getLogger(BrokerTaxDetailServiceImpl.class);

	@Autowired
	private BrokerTaxDetailRepository repository;
	
	@Override
	public Page<BrokerTaxDetailVo> queryDetailPage(BrokerTaxDetailQueryVo queryVo) {
		logger.info("queryDetailPage,{}", queryVo.toString());
		return repository.queryDetailPage(queryVo);
	}
	
}
