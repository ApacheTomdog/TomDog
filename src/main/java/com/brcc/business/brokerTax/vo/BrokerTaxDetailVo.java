package com.brcc.business.brokerTax.vo;

import java.math.BigDecimal;

import com.brcc.business.brokerTax.entity.BrokerTaxDetailEntity;

/**
 * 经纪人季度收入统计明细
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxDetailVo extends BrokerTaxDetailEntity {

	private static final long serialVersionUID = 1L;

	private String goodTypeDesc;
	private BigDecimal price;
	private BigDecimal amount;
	private String getOrderPlate;
	private String startPlate;
	private String endPlate;

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getGetOrderPlate() {
		return getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

}
