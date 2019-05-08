package com.brcc.business.brokerTax.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.brokerTax.vo.BrokerTaxDetailQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailVo;

/**
 *	 经纪人税额明细
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface IBrokerTaxDetailRepository {

	Page<BrokerTaxDetailVo> queryDetailPage(BrokerTaxDetailQueryVo queryVo);
	
}	
