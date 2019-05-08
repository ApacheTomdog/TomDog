package com.brcc.business.brokerTax.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.brokerTax.entity.BrokerTaxMasterEntity;

/**
 *	 经纪人税额
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface BrokerTaxMasterRepository extends JpaRepository<BrokerTaxMasterEntity, Long>, IBrokerTaxMasterRepository{
	
	/**
	 * 单个经纪人的净收入金额
	 */
	@Transactional
	@Query(value="select sum(t.tot_payed_amt) as 'totPayedAmt' from apptms.broker_tax_master t,apptms.broker_tax_cycle c \r\n"
			+ "where t.broker_tax_quarter = c.broker_tax_cycle_name "
			+ "and c.broker_tax_year_month = DATE_FORMAT(CURRENT_DATE,'%Y-%m') and t.broker_id = ?" ,nativeQuery=true) 
	BigDecimal totProfitAmt(Long BrokerId);
	
}
