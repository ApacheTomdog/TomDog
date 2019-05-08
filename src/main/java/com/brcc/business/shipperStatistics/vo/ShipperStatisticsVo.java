package com.brcc.business.shipperStatistics.vo;

import java.math.BigDecimal;

public class ShipperStatisticsVo {
	
	//发单量
	private BigDecimal toDayFdWeightSum;
	
	//抢单量
	private BigDecimal toDayGrabWeightSum;
	
	//实收重量
	private BigDecimal toDayTakeDeliveryWeightSum;
	
	//运费计算金额
	private BigDecimal toDayPayAmountSum;
	
	//实付金额
	private BigDecimal toDayPayAmountActSum;

	public BigDecimal getToDayFdWeightSum() {
		return toDayFdWeightSum;
	}

	public void setToDayFdWeightSum(BigDecimal toDayFdWeightSum) {
		this.toDayFdWeightSum = toDayFdWeightSum;
	}

	public BigDecimal getToDayGrabWeightSum() {
		return toDayGrabWeightSum;
	}

	public void setToDayGrabWeightSum(BigDecimal toDayGrabWeightSum) {
		this.toDayGrabWeightSum = toDayGrabWeightSum;
	}

	public BigDecimal getToDayTakeDeliveryWeightSum() {
		return toDayTakeDeliveryWeightSum;
	}

	public void setToDayTakeDeliveryWeightSum(BigDecimal toDayTakeDeliveryWeightSum) {
		this.toDayTakeDeliveryWeightSum = toDayTakeDeliveryWeightSum;
	}

	public BigDecimal getToDayPayAmountSum() {
		return toDayPayAmountSum;
	}

	public void setToDayPayAmountSum(BigDecimal toDayPayAmountSum) {
		this.toDayPayAmountSum = toDayPayAmountSum;
	}

	public BigDecimal getToDayPayAmountActSum() {
		return toDayPayAmountActSum;
	}

	public void setToDayPayAmountActSum(BigDecimal toDayPayAmountActSum) {
		this.toDayPayAmountActSum = toDayPayAmountActSum;
	}

	
	
}
