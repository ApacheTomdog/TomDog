package com.brcc.business.brokerTax.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.brokerTax.vo.BrokerTaxDetailQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailVo;

/**
 *	 经纪人税额明细
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
@Service
public interface BrokerTaxDetailService {
	
	/**
	 * 	经纪人季度收入统计明细
	 * @param queryVo 查询条件
	 * @return 经纪人季度收入统计列表明细
	 */
	Page<BrokerTaxDetailVo> queryDetailPage(BrokerTaxDetailQueryVo queryVo);
}
