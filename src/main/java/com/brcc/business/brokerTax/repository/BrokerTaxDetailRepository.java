package com.brcc.business.brokerTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.brokerTax.entity.BrokerTaxDetailEntity;

/**
 *	 经纪人税额明细
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface BrokerTaxDetailRepository extends JpaRepository<BrokerTaxDetailEntity, Long>, IBrokerTaxDetailRepository{
	
}
