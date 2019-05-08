package com.brcc.business.brokerProfit.service;

import org.springframework.stereotype.Service;

import com.brcc.business.brokerProfit.entity.BrokerPpSwitchEntity;
import com.brcc.business.brokerProfit.vo.BrokerPpSwitchQueryVo;

/**
 * 经纪人分润支付开关接口
 * @author TangYong
 * @date 2019-02-13
 */
@Service
public interface BrokerPpSwitchService {

	/**
	 *	查询经纪人调度分润情况
	 */
	Integer queryIfProfitControl(BrokerPpSwitchQueryVo brokerPpSwitchQueryVo);
	
	BrokerPpSwitchEntity findOne(Long companyId);
	
}