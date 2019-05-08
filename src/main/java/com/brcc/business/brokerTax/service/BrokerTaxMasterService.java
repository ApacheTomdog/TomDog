package com.brcc.business.brokerTax.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerTax.vo.BrokerTaxMasterQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterVo;

/**
 *	 经纪人税额
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
@Service
public interface BrokerTaxMasterService {
	
	/**
	 * 	经纪人季度收入统计
	 * @param queryVo 查询条件
	 * @return 经纪人季度收入统计列表
	 */
	Page<BrokerTaxMasterVo> queryPage(BrokerTaxMasterQueryVo queryVo);
	
	/**
	 * 	单个经纪人季度收入统计
	 * @param queryVo 查询条件
	 * @return 单个经纪人季度收入统计列表
	 */
	
	Page<BrokerTaxMasterVo> queryList(BrokerTaxMasterQueryVo queryVo);
	
	/**
	 * 单个经纪人的净收入金额
	 */
	public BigDecimal totProfitAmt(BrokerTaxMasterQueryVo queryVo);

}
