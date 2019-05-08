package com.brcc.business.brokerFunds.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TransfiniteDispatchVo {
	
	private String platformId;
	private Long publishId;
	private Long transId;
	private Long deliveryId;
	private Long zfId;
	private String zfNum;
	private String dependNum;
	private String ifFundsControlFlag;
	private String publishCompanyId;
	private String publishCompanyName;
	private String contactMobile;
	private String goodType;
	private String goodTypeDesc;
	private String startPlate;
	private String endPlate;
	private String getOrderPlate;
	private BigDecimal price;
	private BigDecimal payAmount;
	private Date createDate;
	private Date finishTime;
	private Long useMinute;
	private Long driverId;
	private String driverName;
	private String driverPhone;
	private Long vehicleId;
	private String vehicleNum;
	private String vehicleType;
	private String carAxle;
	//预计里程
	private BigDecimal estimateKM;
	private BigDecimal weight;
	private BigDecimal truckLoadingWeight;
	private BigDecimal takeDeliveryWeight;
	private BigDecimal goodPrice;
	private String lossType;
	private BigDecimal lossWeight;
	private BigDecimal lossRatio;
	private BigDecimal payJjrAmount;
	private BigDecimal payCarryMinAmt;
	
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getTruckLoadingWeight() {
		return truckLoadingWeight;
	}
	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
	}
	public BigDecimal getTakeDeliveryWeight() {
		return takeDeliveryWeight;
	}
	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getLossType() {
		return lossType;
	}
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
	public BigDecimal getLossWeight() {
		return lossWeight;
	}
	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}
	public BigDecimal getLossRatio() {
		return lossRatio;
	}
	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getZfId() {
		return zfId;
	}
	public void setZfId(Long zfId) {
		this.zfId = zfId;
	}
	public String getZfNum() {
		return zfNum;
	}
	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}
	public String getIfFundsControlFlag() {
		return ifFundsControlFlag;
	}
	public void setIfFundsControlFlag(String ifFundsControlFlag) {
		this.ifFundsControlFlag = ifFundsControlFlag;
	}
	public String getPublishCompanyId() {
		return publishCompanyId;
	}
	public void setPublishCompanyId(String publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}
	public String getPublishCompanyName() {
		return publishCompanyName;
	}
	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
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
	public String getGetOrderPlate() {
		return getOrderPlate;
	}
	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Long getUseMinute() {
		return useMinute;
	}
	public void setUseMinute(Long useMinute) {
		this.useMinute = useMinute;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCarAxle() {
		return carAxle;
	}
	public void setCarAxle(String carAxle) {
		this.carAxle = carAxle;
	}
	public BigDecimal getEstimateKM() {
		return estimateKM;
	}
	public void setEstimateKM(BigDecimal estimateKM) {
		this.estimateKM = estimateKM;
	}
	public BigDecimal getPayJjrAmount() { return payJjrAmount; }
	public void setPayJjrAmount(BigDecimal payJjrAmount) { this.payJjrAmount = payJjrAmount; }
	public BigDecimal getPayCarryMinAmt() { return payCarryMinAmt; }
	public void setPayCarryMinAmt(BigDecimal payCarryMinAmt) { this.payCarryMinAmt = payCarryMinAmt; }
}
