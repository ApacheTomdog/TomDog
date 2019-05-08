package com.brcc.business.brokerProfit.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerProfit.entity.BrokerPpSwitchEntity;
import com.brcc.business.brokerProfit.repository.BrokerPpSwitchRepository;
import com.brcc.business.brokerProfit.service.BrokerPpSwitchService;
import com.brcc.business.brokerProfit.vo.BrokerPpSwitchQueryVo;

/**
 * 经纪人分润支付开关接口实现
 * @author TangYong
 * @date 2019-02-13
 */
@Service
public class BrokerPpSwitchServiceImpl implements BrokerPpSwitchService {
	
	Logger logger = LoggerFactory.getLogger(BrokerPpSwitchServiceImpl.class);

    @Autowired
    private BrokerPpSwitchRepository brokerPpSwitchRepository;

	@Override
	public Integer queryIfProfitControl(BrokerPpSwitchQueryVo brokerPpSwitchQueryVo) {
		logger.info("query brokerPeople dispatch switch,brokeId:{}",brokerPpSwitchQueryVo.getBrokerId());
		return brokerPpSwitchRepository.queryIfProfitControl(brokerPpSwitchQueryVo.getBrokerId());
	}
	
	@Override
	public BrokerPpSwitchEntity findOne(Long companyId) {
		BrokerPpSwitchEntity brokerPpSwitchEntity = brokerPpSwitchRepository.findByBrokerIdAndTblStatus(companyId, "20");
		return brokerPpSwitchEntity;
	}
	 
}
