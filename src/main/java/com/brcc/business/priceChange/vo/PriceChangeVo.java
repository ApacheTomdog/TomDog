package com.brcc.business.priceChange.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.priceChange.entity.PriceChangeEntity;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public class PriceChangeVo extends PriceChangeEntity{

	private BigDecimal fPrice;//成本价
	private BigDecimal price; //原抢单价
	private String pindan;
	private String getAmountS ;
	private String  getAmountE ;
	private String  carNum ;
	private String goodsType ;
	private String appointTeam;
	private String talkPrice ;
	private String companyName;
	private String appointTeamType;
	private String dependNum;
	private String dependNum2;
	private String docuPriSec;
	private String docuType;
	private String dqFlag;
	private String dsIfSettle;
	private String endPlate;
	private String fromType;
	private String getOrderPlate;
	private BigDecimal goodPrice;
	private String goodTypeDesc;
	private String ifTaxTransport;
	private BigDecimal initQty;
	private BigDecimal initWeight;
	private String isAutoDisplay;
	private BigDecimal lossRatio;
	private String lossType;
	private BigDecimal lossWeight;
	private String ownerAdjustFlag;
	private Date pickupDate;
	private Integer pinDanNum;
	private String prodDesc;
	private String qbType;
	private String startPlate;
	private String status;
	private String vehicleStyleVar;
	private String statusDesc;
	private String ifTaxTransportDesc;
	private String lossWeightDesc;
	
	
	
	public String getLossWeightDesc() {
		return lossWeightDesc;
	}
	public BigDecimal getfPrice() {
		return fPrice;
	}
	public void setfPrice(BigDecimal fPrice) {
		this.fPrice = fPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPindan() {
		return pindan;
	}
	public void setPindan(String pindan) {
		this.pindan = pindan;
	}
	public String getGetAmountS() {
		return getAmountS;
	}
	public void setGetAmountS(String getAmountS) {
		this.getAmountS = getAmountS;
	}
	public String getGetAmountE() {
		return getAmountE;
	}
	public void setGetAmountE(String getAmountE) {
		this.getAmountE = getAmountE;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getAppointTeam() {
		return appointTeam;
	}
	public void setAppointTeam(String appointTeam) {
		this.appointTeam = appointTeam;
	}
	public String getTalkPrice() {
		return talkPrice;
	}
	public void setTalkPrice(String talkPrice) {
		this.talkPrice = talkPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAppointTeamType() {
		return appointTeamType;
	}
	public void setAppointTeamType(String appointTeamType) {
		this.appointTeamType = appointTeamType;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public String getDependNum2() {
		return dependNum2;
	}
	public void setDependNum2(String dependNum2) {
		this.dependNum2 = dependNum2;
	}
	public String getDocuPriSec() {
		return docuPriSec;
	}
	public void setDocuPriSec(String docuPriSec) {
		this.docuPriSec = docuPriSec;
	}
	public String getDocuType() {
		return docuType;
	}
	public void setDocuType(String docuType) {
		this.docuType = docuType;
	}
	public String getDqFlag() {
		return dqFlag;
	}
	public void setDqFlag(String dqFlag) {
		this.dqFlag = dqFlag;
	}
	public String getDsIfSettle() {
		return dsIfSettle;
	}
	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
	}
	public String getEndPlate() {
		return endPlate;
	}
	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public String getGetOrderPlate() {
		return getOrderPlate;
	}
	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}
	public String getIfTaxTransport() {
		return ifTaxTransport;
	}
	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}
	public BigDecimal getInitQty() {
		return initQty;
	}
	public void setInitQty(BigDecimal initQty) {
		this.initQty = initQty;
	}
	public BigDecimal getInitWeight() {
		return initWeight;
	}
	public void setInitWeight(BigDecimal initWeight) {
		this.initWeight = initWeight;
	}
	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}
	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}
	public BigDecimal getLossRatio() {
		return lossRatio;
	}
	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
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
	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}
	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Integer getPinDanNum() {
		return pinDanNum;
	}
	public void setPinDanNum(Integer pinDanNum) {
		this.pinDanNum = pinDanNum;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getQbType() {
		return qbType;
	}
	public void setQbType(String qbType) {
		this.qbType = qbType;
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
	public String getVehicleStyleVar() {
		return vehicleStyleVar;
	}
	public void setVehicleStyleVar(String vehicleStyleVar) {
		this.vehicleStyleVar = vehicleStyleVar;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getIfTaxTransportDesc() {
		return ifTaxTransportDesc;
	}
	public void setIfTaxTransportDesc(String ifTaxTransportDesc) {
		this.ifTaxTransportDesc = ifTaxTransportDesc;
	}


	
	
}
