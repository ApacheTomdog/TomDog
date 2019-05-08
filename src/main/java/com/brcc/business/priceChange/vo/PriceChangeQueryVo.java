package com.brcc.business.priceChange.vo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public class PriceChangeQueryVo extends BaseQueryVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String priceChangeType;
	private Long priceChangeId;
	private Long carryId;
	private String carryName;
	private BigDecimal carryPrice;
	private Long clientId;
	private String clientName;
	private BigDecimal clientPrice;
	/*private Date createDate;*/
	private Date rqStart;
	private Date rqEnd;
	private Long createPersonId;
	private String createPersonName;
	private BigDecimal diffPrice;
	private Date modifyDate;
	private Long modifyPersonId;
	private String modifyPersonName;
	private String platformId;
	private String priceChangeStatus;
	private Long publishId;
	private BigDecimal fPrice;//成本价
	private BigDecimal price; //原抢单价
	private String pinDanNum;
	private String fromType;
	private String dependNum2;
	private String dependNum;
	private String getOrderPlate;
	private String startPlate;
	private String endPlate;
	private String goodTypeDesc;
	private String prodDesc;
	private String ifTaxTransport;
	private String goodPrice;
	private String lossType;
	private String lossWeight;
	private String lossRatio;	
	private String status;
	private String pindan;
	private String getAmountS ;
	private String  getAmountE ;
	private String  carNum ;
	private String docuType ;
	private String dsIfSettle ;
	private String goodsType ;
	private String appointTeam;
	private String isAutoDisplay ;
	private String talkPrice ;
	private String ownerAdjustFlag ;
	private String vehicleStyleVar;
	private String appointTeamType;
	private String qbType;
	private String docuPriSec;
	private String dqFlag;;
	private String initQty;
	private String pickupDate;
	private String statusDesc;
	private String consignorName;
	


	public String getVehicleStyleVar() {
		return vehicleStyleVar;
	}

	public void setVehicleStyleVar(String vehicleStyleVar) {
		this.vehicleStyleVar = vehicleStyleVar;
	}

	public String getAppointTeamType() {
		return appointTeamType;
	}

	public void setAppointTeamType(String appointTeamType) {
		this.appointTeamType = appointTeamType;
	}

	public String getQbType() {
		return qbType;
	}

	public void setQbType(String qbType) {
		this.qbType = qbType;
	}

	public String getDocuPriSec() {
		return docuPriSec;
	}

	public void setDocuPriSec(String docuPriSec) {
		this.docuPriSec = docuPriSec;
	}

	public String getDqFlag() {
		return dqFlag;
	}

	public void setDqFlag(String dqFlag) {
		this.dqFlag = dqFlag;
	}

	public String getInitQty() {
		return initQty;
	}

	public void setInitQty(String initQty) {
		this.initQty = initQty;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

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

	public String getPinDanNum() {
		return pinDanNum;
	}

	public void setPinDanNum(String pinDanNum) {
		this.pinDanNum = pinDanNum;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getDependNum2() {
		return dependNum2;
	}

	public void setDependNum2(String dependNum2) {
		this.dependNum2 = dependNum2;
	}

	public String getDependNum() {
		return dependNum;
	}

	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
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

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public String getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getLossWeight() {
		return lossWeight;
	}

	public void setLossWeight(String lossWeight) {
		this.lossWeight = lossWeight;
	}

	public String getLossRatio() {
		return lossRatio;
	}

	public void setLossRatio(String lossRatio) {
		this.lossRatio = lossRatio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDocuType() {
		return docuType;
	}

	public void setDocuType(String docuType) {
		this.docuType = docuType;
	}

	public String getDsIfSettle() {
		return dsIfSettle;
	}

	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
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

	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}

	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}

	public String getTalkPrice() {
		return talkPrice;
	}

	public void setTalkPrice(String talkPrice) {
		this.talkPrice = talkPrice;
	}

	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}

	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
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


	public Date getRqStart() {
		return rqStart;
	}

	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}

	public Date getRqEnd() {
		return rqEnd;
	}

	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}

	public Long getPriceChangeId() {
		return this.priceChangeId;
	}

	public void setPriceChangeId(Long priceChangeId) {
		this.priceChangeId = priceChangeId;
	}

	public Long getCarryId() {
		return this.carryId;
	}

	public void setCarryId(Long carryId) {
		this.carryId = carryId;
	}

	public String getCarryName() {
		return this.carryName;
	}

	public void setCarryName(String carryName) {
		this.carryName = carryName;
	}

	public BigDecimal getCarryPrice() {
		return this.carryPrice;
	}

	public void setCarryPrice(BigDecimal carryPrice) {
		this.carryPrice = carryPrice;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BigDecimal getClientPrice() {
		return this.clientPrice;
	}

	public void setClientPrice(BigDecimal clientPrice) {
		this.clientPrice = clientPrice;
	}

	/*public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}*/

	public Long getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public BigDecimal getDiffPrice() {
		return this.diffPrice;
	}

	public void setDiffPrice(BigDecimal diffPrice) {
		this.diffPrice = diffPrice;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getPriceChangeStatus() {
		return this.priceChangeStatus;
	}

	public void setPriceChangeStatus(String priceChangeStatus) {
		this.priceChangeStatus = priceChangeStatus;
	}

	public String getPriceChangeType() {
		return this.priceChangeType;
	}

	public void setPriceChangeType(String priceChangeType) {
		this.priceChangeType = priceChangeType;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}
