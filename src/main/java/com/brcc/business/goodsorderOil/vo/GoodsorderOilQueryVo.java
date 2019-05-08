package com.brcc.business.goodsorderOil.vo;

import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class GoodsorderOilQueryVo extends BaseQueryVo{

	private Long publishId;
	private String platformId;
	private String vatFlowMasterName;
	private String isAutoDisplay;// 是否显示
	private Date rqStart;
	private String startPlate;
	// 货源单状态
	private String status;
	// 取单地
	private String getOrderPlate;
	// 目的地
	private String endPlate;
	// 业务单号
	private String dependNum;
	// 品种代码
	private Integer goodType;
	private String pinDanNum;
	private Date rqEnd;
	private String ownerAdjustFlag;
	private String billSender;
	private String prodDesc;
	private String goodTypeDesc;
	private String consignorName;
	
	public String getConsignorName() {
		return consignorName;
	}
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getBillSender() {
		return billSender;
	}
	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}
	public Date getRqStart() {
		return rqStart;
	}
	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}
	public String getStartPlate() {
		return startPlate;
	}
	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGetOrderPlate() {
		return getOrderPlate;
	}
	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}
	public String getEndPlate() {
		return endPlate;
	}
	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public Integer getGoodType() {
		return goodType;
	}
	public void setGoodType(Integer goodType) {
		this.goodType = goodType;
	}
	public String getPinDanNum() {
		return pinDanNum;
	}
	public void setPinDanNum(String pinDanNum) {
		this.pinDanNum = pinDanNum;
	}
	public Date getRqEnd() {
		return rqEnd;
	}
	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}
	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}
	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}
	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}
	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}
	public String getVatFlowMasterName() {
		return vatFlowMasterName;
	}
	public void setVatFlowMasterName(String vatFlowMasterName) {
		this.vatFlowMasterName = vatFlowMasterName;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
}
