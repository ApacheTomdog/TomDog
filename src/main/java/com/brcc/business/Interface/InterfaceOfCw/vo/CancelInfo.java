package com.brcc.business.Interface.InterfaceOfCw.vo;

public class CancelInfo {
	
	private String pinDanNum;
	
	private String cancelType;
	
	private Long deliveryId;

	public String getPinDanNum() {
		return pinDanNum;
	}

	public void setPinDanNum(String pinDanNum) {
		this.pinDanNum = pinDanNum;
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
}
