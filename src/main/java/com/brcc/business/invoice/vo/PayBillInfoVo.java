package com.brcc.business.invoice.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月20日 下午4:34:23
 */
public class PayBillInfoVo {
	private Long deliveryId;
	private Long transId;
	private Long publishId;
	private String startPlate;
	private String endPlate;
	private String goodTypeName;
	private String goodTypeDesc;
	private BigDecimal price;
	private BigDecimal ownerAdjustAmt;
	private String ownerAdjustFlag;
	private String ownerAdjustType;
	private BigDecimal ownerAdjustTotAmt;
	private BigDecimal priceTax;
	private BigDecimal settleWeight;
	private BigDecimal truckLoadingWeight;
	private BigDecimal takeDeliveryWeight;
	private BigDecimal deductAmount;
	private BigDecimal payAmountActTax;
	private Long driverId;
	private String driverName;
	private Long vehicleId;
	private String vehicleNum;
	private Long zfId;
	private String zfNum;
	private Date payDate;
	private String vatClientName;
	private String companyName;
	private String dependNum2;
	private Date finishTime;
	private BigDecimal payFeeAmount;
	private Long vatFlowMasterId;
	private String billSender;
	private Date deliveryTime;
	
	//添加明细数据
	private BigDecimal outAmount;
	private Long vatCapitalDetailId;
	//合同编号
	private String contractNumber;
	//合同类型
	private String contractType;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public BigDecimal getOutAmount() {
		return outAmount;
	}
	public void setOutAmount(BigDecimal outAmount) {
		this.outAmount = outAmount;
	}
	public Long getVatCapitalDetailId() {
		return vatCapitalDetailId;
	}
	public void setVatCapitalDetailId(Long vatCapitalDetailId) {
		this.vatCapitalDetailId = vatCapitalDetailId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
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
	public String getGoodTypeName() {
		return goodTypeName;
	}
	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}
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
	public BigDecimal getOwnerAdjustAmt() {
		return ownerAdjustAmt;
	}
	public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
		this.ownerAdjustAmt = ownerAdjustAmt;
	}
	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}
	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}
	public String getOwnerAdjustType() {
		return ownerAdjustType;
	}
	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}
	public BigDecimal getOwnerAdjustTotAmt() {
		return ownerAdjustTotAmt;
	}
	public void setOwnerAdjustTotAmt(BigDecimal ownerAdjustTotAmt) {
		this.ownerAdjustTotAmt = ownerAdjustTotAmt;
	}
	public BigDecimal getPriceTax() {
		return priceTax;
	}
	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}
	public BigDecimal getSettleWeight() {
		return settleWeight;
	}
	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
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
	public BigDecimal getDeductAmount() {
		return deductAmount;
	}
	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}
	public BigDecimal getPayAmountActTax() {
		return payAmountActTax;
	}
	public void setPayAmountActTax(BigDecimal payAmountActTax) {
		this.payAmountActTax = payAmountActTax;
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
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getVatClientName() {
		return vatClientName;
	}
	public void setVatClientName(String vatClientName) {
		this.vatClientName = vatClientName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDependNum2() {
		return dependNum2;
	}
	public void setDependNum2(String dependNum2) {
		this.dependNum2 = dependNum2;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public BigDecimal getPayFeeAmount() {
		return payFeeAmount;
	}
	public void setPayFeeAmount(BigDecimal payFeeAmount) {
		this.payFeeAmount = payFeeAmount;
	}
	public Long getVatFlowMasterId() {
		return vatFlowMasterId;
	}
	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}
	public String getBillSender() {
		return billSender;
	}
	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
}
