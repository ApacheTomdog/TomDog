package com.brcc.business.brokerTax.vo;

import java.io.Serializable;

/**
 * 	季度配置
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxCycleVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String brokerTaxCycleName;

	public String getBrokerTaxCycleName() {
		return brokerTaxCycleName;
	}

	public void setBrokerTaxCycleName(String brokerTaxCycleName) {
		this.brokerTaxCycleName = brokerTaxCycleName;
	}
	
}
