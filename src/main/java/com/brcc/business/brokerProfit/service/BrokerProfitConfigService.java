package com.brcc.business.brokerProfit.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerProfit.entity.BrokerProfitConfigEntity;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigAddVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigModifyVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigVo;

/**
 * 经纪人最高分润配置接口
 * @author dzj
 * @date 2019-01-29
 */
@Service
public interface BrokerProfitConfigService {
	
	/**
	 * 获取分页数据
	 */
	Page<BrokerProfitConfigVo> data(BrokerProfitConfigQueryVo queryVo);
	
	/**
	 * 查询唯一配置
	 */
	BrokerProfitConfigEntity findOne(BrokerProfitConfigEntity brokerProfitConfigEntity);
	
	/**
	 * 新增
	 */
	void add(BrokerProfitConfigAddVo addVo);
	
	/**
	 * 修改
	 */	
	void modify(BrokerProfitConfigModifyVo modifyVo);
	
	/**
	 * 作废
	 */	
	void cancel(BrokerProfitConfigModifyVo modifyVo);
	
	/**
	 * 生效
	 */	
	void audit(BrokerProfitConfigModifyVo modifyVo);

	/**
	 *	查询经纪人是否是特例配置
	 */
	BrokerProfitConfigEntity querySpecialCase(BrokerProfitConfigQueryVo queryVo);

	/**
	 *  查询经纪人的常规配置(平台统一)
	 */
	BrokerProfitConfigEntity queryNormalCase();
	
	BrokerProfitConfigEntity findOne(Long companyId);
}