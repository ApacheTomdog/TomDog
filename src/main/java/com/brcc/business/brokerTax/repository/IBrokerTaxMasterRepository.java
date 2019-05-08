package com.brcc.business.brokerTax.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.brokerTax.vo.BrokerTaxMasterQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterVo;

/**
 *	 经纪人税额
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface IBrokerTaxMasterRepository {

	Page<BrokerTaxMasterVo> queryPage(BrokerTaxMasterQueryVo queryVo);
	
}
