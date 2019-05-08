package com.brcc.business.brokerTax.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 	季度配置表
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
@Entity
@Table(name="broker_tax_cycle")
public class BrokerTaxCycleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="broker_tax_cycle_id")
	private Long brokerTaxCycleId;

	@Column(name="broker_tax_year_month")
	private String brokerTaxYearMonth;
	
	@Column(name="broker_tax_cycle_name")
	private String brokerTaxCycleName;

	public Long getBrokerTaxCycleId() {
		return brokerTaxCycleId;
	}

	public void setBrokerTaxCycleId(Long brokerTaxCycleId) {
		this.brokerTaxCycleId = brokerTaxCycleId;
	}

	public String getBrokerTaxYearMonth() {
		return brokerTaxYearMonth;
	}

	public void setBrokerTaxYearMonth(String brokerTaxYearMonth) {
		this.brokerTaxYearMonth = brokerTaxYearMonth;
	}

	public String getBrokerTaxCycleName() {
		return brokerTaxCycleName;
	}

	public void setBrokerTaxCycleName(String brokerTaxCycleName) {
		this.brokerTaxCycleName = brokerTaxCycleName;
	}
	
}