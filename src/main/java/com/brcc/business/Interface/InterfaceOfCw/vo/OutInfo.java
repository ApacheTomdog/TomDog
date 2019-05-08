package com.brcc.business.Interface.InterfaceOfCw.vo;

import java.math.BigDecimal;

public class OutInfo {
	
	private Long deliveryId;
	
	private String dependId;
	
	private BigDecimal outWeight;
	
	private String outTime;
	
	private String dsPlatName;

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDependId() {
		return dependId;
	}

	public void setDependId(String dependId) {
		this.dependId = dependId;
	}

	public BigDecimal getOutWeight() {
		return outWeight;
	}

	public void setOutWeight(BigDecimal outWeight) {
		this.outWeight = outWeight;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getDsPlatName() {
		return dsPlatName;
	}

	public void setDsPlatName(String dsPlatName) {
		this.dsPlatName = dsPlatName;
	}
	
}
