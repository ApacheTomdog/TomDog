package com.brcc.business.goodsorderOil.vo;

import java.math.BigDecimal;
import java.util.Date;


public class GoodsorderOilVo {

	private Long publishId;

	private Integer adjustPersonId;

	private String adjustPersonName;

	private Date adjustPriceDate;

	private BigDecimal amount;

	private Integer appointCompanyId;

	private String appointPersonInfo;

	private String appointTeamId;

	private String appointTeamType;

	private String asdsMark;

	private Integer bidTimes;

	private String billSender;

	private String billSenderMobile;

	private String billTaker;

	private String billTakerMobile;

	private Long catalogId;

	private String catalogName;

	private BigDecimal chargePrice;

	private String chargePriceType;

	private Integer combinedNumber;

	private Long companyId;

	private Date createDate;

	private String departure;

	private BigDecimal departureLat;

	private BigDecimal departureLng;

	private String dependNum;

	private String dependNum2;

	private String destination;

	private BigDecimal destinationLat;

	private BigDecimal destinationLng;

	private String detachable;

	private String docuPriSec;

	private String docuType;

	private Date dqEndDate;

	private String dqFlag;

	private Date dqSttDate;

	private String dsDzFlag;

	private String dsIfSettle;

	private String endPlate;

	private String endPlateCity;

	private String endPlateCountry;

	private String endPlateProvince;

	private String entrustCompany;

	private BigDecimal estimateKM;

	private Long fdUserId;

	private BigDecimal floorPrice;

	private String fromPlatName;

	private String fromType;

	private String getOrderAddress;

	private BigDecimal getOrderAddressLat;

	private BigDecimal getOrderAddressLng;

	private String getOrderPlate;

	private String getOrderPlateCity;

	private String getOrderPlateCountry;

	private String getOrderPlateProvince;

	private BigDecimal goodPrice;

	private Long goodType;

	private String goodTypeDesc;

	private Integer goodsOwnerId;

	private Long groupId;

	private String groupName;

	private BigDecimal heavyPiece;

	private String ifAutoConfirm;

	private String ifAutoPrice;

	private String ifAutoTransSys;

	private String ifBjToQd;

	private String ifCanShow;

	private String ifConfirm;

	private String ifFragment;

	private String ifOwnerTaxpriceMf;

	private String ifPartition;

	private String ifPayment;

	private Integer ifSavePublish;

	private String ifShowFloorPrice;

	private String ifTaxTransport;

	private Long importId;

	private BigDecimal initAmount;

	private BigDecimal initQty;

	private BigDecimal initWeight;

	private String isAutoDisplay;

	private String isAutoToTrans;

	private String jsType;

	private String limitTime;

	private BigDecimal listingPrice;

	private String logisticsMark;

	private BigDecimal lossRatio;

	private String lossType;

	private BigDecimal lossWeight;

	private BigDecimal maxPrice;

	private BigDecimal oilAmount;

	private String oilFlag;

	private BigDecimal oilRatio;

	private BigDecimal ownerAdjustAmt;

	private String ownerAdjustFlag;

	private String ownerAdjustType;

	private String pickUpGoodsName;

	private Date pickupDate;

	private Integer pinDanNum;

	private String platformId;

	private Long priPublishId;

	private BigDecimal price;

	private BigDecimal priceTax;

	private Integer priceTimeCycle;

	private String prodArea;

	private String prodDesc;

	private String ps;

	private String ps1;

	private String ps2;

	private String ps3;

	private String ps4;

	private String ps5;

	private String publishNum;

	private String qbType;

	private BigDecimal qty;

	private String receiver;

	private String receiverMobile;

	private String remark;

	private BigDecimal rovokeWeight;

	private BigDecimal saleAmount;

	private BigDecimal saleQty;

	private BigDecimal saleWeight;

	private String sendGroup;

	private String sender;

	private String senderMobile;

	private Integer sendKM;

	private BigDecimal singleCarWeight;

	private BigDecimal standardTax;

	private String startPlate;

	private String startPlateCity;

	private String startPlateCountry;

	private String startPlateProvince;

	private Date startTakeDeliveryDate;

	private String status;

	private Date takeDeliveryDate;

	private String takeType;

	private Date tmingRelease;

	private Date updateDate;

	private Long updatePerson;

	private Long userId;

	private Long vatFlowMasterId;

	private String vehicleStyleVar;

	private String webCanGrab;

	private BigDecimal weight;

	private String consignorName;
	private String transWeight;
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTransWeight() {
		return transWeight;
	}

	public void setTransWeight(String transWeight) {
		this.transWeight = transWeight;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Integer getAdjustPersonId() {
		return adjustPersonId;
	}

	public void setAdjustPersonId(Integer adjustPersonId) {
		this.adjustPersonId = adjustPersonId;
	}

	public String getAdjustPersonName() {
		return adjustPersonName;
	}

	public void setAdjustPersonName(String adjustPersonName) {
		this.adjustPersonName = adjustPersonName;
	}

	public Date getAdjustPriceDate() {
		return adjustPriceDate;
	}

	public void setAdjustPriceDate(Date adjustPriceDate) {
		this.adjustPriceDate = adjustPriceDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getAppointCompanyId() {
		return appointCompanyId;
	}

	public void setAppointCompanyId(Integer appointCompanyId) {
		this.appointCompanyId = appointCompanyId;
	}

	public String getAppointPersonInfo() {
		return appointPersonInfo;
	}

	public void setAppointPersonInfo(String appointPersonInfo) {
		this.appointPersonInfo = appointPersonInfo;
	}

	public String getAppointTeamId() {
		return appointTeamId;
	}

	public void setAppointTeamId(String appointTeamId) {
		this.appointTeamId = appointTeamId;
	}

	public String getAppointTeamType() {
		return appointTeamType;
	}

	public void setAppointTeamType(String appointTeamType) {
		this.appointTeamType = appointTeamType;
	}

	public String getAsdsMark() {
		return asdsMark;
	}

	public void setAsdsMark(String asdsMark) {
		this.asdsMark = asdsMark;
	}

	public Integer getBidTimes() {
		return bidTimes;
	}

	public void setBidTimes(Integer bidTimes) {
		this.bidTimes = bidTimes;
	}

	public String getBillSender() {
		return billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getBillSenderMobile() {
		return billSenderMobile;
	}

	public void setBillSenderMobile(String billSenderMobile) {
		this.billSenderMobile = billSenderMobile;
	}

	public String getBillTaker() {
		return billTaker;
	}

	public void setBillTaker(String billTaker) {
		this.billTaker = billTaker;
	}

	public String getBillTakerMobile() {
		return billTakerMobile;
	}

	public void setBillTakerMobile(String billTakerMobile) {
		this.billTakerMobile = billTakerMobile;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public BigDecimal getChargePrice() {
		return chargePrice;
	}

	public void setChargePrice(BigDecimal chargePrice) {
		this.chargePrice = chargePrice;
	}

	public String getChargePriceType() {
		return chargePriceType;
	}

	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
	}

	public Integer getCombinedNumber() {
		return combinedNumber;
	}

	public void setCombinedNumber(Integer combinedNumber) {
		this.combinedNumber = combinedNumber;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public BigDecimal getDepartureLat() {
		return departureLat;
	}

	public void setDepartureLat(BigDecimal departureLat) {
		this.departureLat = departureLat;
	}

	public BigDecimal getDepartureLng() {
		return departureLng;
	}

	public void setDepartureLng(BigDecimal departureLng) {
		this.departureLng = departureLng;
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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDestinationLat() {
		return destinationLat;
	}

	public void setDestinationLat(BigDecimal destinationLat) {
		this.destinationLat = destinationLat;
	}

	public BigDecimal getDestinationLng() {
		return destinationLng;
	}

	public void setDestinationLng(BigDecimal destinationLng) {
		this.destinationLng = destinationLng;
	}

	public String getDetachable() {
		return detachable;
	}

	public void setDetachable(String detachable) {
		this.detachable = detachable;
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

	public Date getDqEndDate() {
		return dqEndDate;
	}

	public void setDqEndDate(Date dqEndDate) {
		this.dqEndDate = dqEndDate;
	}

	public String getDqFlag() {
		return dqFlag;
	}

	public void setDqFlag(String dqFlag) {
		this.dqFlag = dqFlag;
	}

	public Date getDqSttDate() {
		return dqSttDate;
	}

	public void setDqSttDate(Date dqSttDate) {
		this.dqSttDate = dqSttDate;
	}

	public String getDsDzFlag() {
		return dsDzFlag;
	}

	public void setDsDzFlag(String dsDzFlag) {
		this.dsDzFlag = dsDzFlag;
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

	public String getEndPlateCity() {
		return endPlateCity;
	}

	public void setEndPlateCity(String endPlateCity) {
		this.endPlateCity = endPlateCity;
	}

	public String getEndPlateCountry() {
		return endPlateCountry;
	}

	public void setEndPlateCountry(String endPlateCountry) {
		this.endPlateCountry = endPlateCountry;
	}

	public String getEndPlateProvince() {
		return endPlateProvince;
	}

	public void setEndPlateProvince(String endPlateProvince) {
		this.endPlateProvince = endPlateProvince;
	}

	public String getEntrustCompany() {
		return entrustCompany;
	}

	public void setEntrustCompany(String entrustCompany) {
		this.entrustCompany = entrustCompany;
	}

	public BigDecimal getEstimateKM() {
		return estimateKM;
	}

	public void setEstimateKM(BigDecimal estimateKM) {
		this.estimateKM = estimateKM;
	}

	public Long getFdUserId() {
		return fdUserId;
	}

	public void setFdUserId(Long fdUserId) {
		this.fdUserId = fdUserId;
	}

	public BigDecimal getFloorPrice() {
		return floorPrice;
	}

	public void setFloorPrice(BigDecimal floorPrice) {
		this.floorPrice = floorPrice;
	}

	public String getFromPlatName() {
		return fromPlatName;
	}

	public void setFromPlatName(String fromPlatName) {
		this.fromPlatName = fromPlatName;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getGetOrderAddress() {
		return getOrderAddress;
	}

	public void setGetOrderAddress(String getOrderAddress) {
		this.getOrderAddress = getOrderAddress;
	}

	public BigDecimal getGetOrderAddressLat() {
		return getOrderAddressLat;
	}

	public void setGetOrderAddressLat(BigDecimal getOrderAddressLat) {
		this.getOrderAddressLat = getOrderAddressLat;
	}

	public BigDecimal getGetOrderAddressLng() {
		return getOrderAddressLng;
	}

	public void setGetOrderAddressLng(BigDecimal getOrderAddressLng) {
		this.getOrderAddressLng = getOrderAddressLng;
	}

	public String getGetOrderPlate() {
		return getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

	public String getGetOrderPlateCity() {
		return getOrderPlateCity;
	}

	public void setGetOrderPlateCity(String getOrderPlateCity) {
		this.getOrderPlateCity = getOrderPlateCity;
	}

	public String getGetOrderPlateCountry() {
		return getOrderPlateCountry;
	}

	public void setGetOrderPlateCountry(String getOrderPlateCountry) {
		this.getOrderPlateCountry = getOrderPlateCountry;
	}

	public String getGetOrderPlateProvince() {
		return getOrderPlateProvince;
	}

	public void setGetOrderPlateProvince(String getOrderPlateProvince) {
		this.getOrderPlateProvince = getOrderPlateProvince;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public Long getGoodType() {
		return goodType;
	}

	public void setGoodType(Long goodType) {
		this.goodType = goodType;
	}

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public Integer getGoodsOwnerId() {
		return goodsOwnerId;
	}

	public void setGoodsOwnerId(Integer goodsOwnerId) {
		this.goodsOwnerId = goodsOwnerId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public BigDecimal getHeavyPiece() {
		return heavyPiece;
	}

	public void setHeavyPiece(BigDecimal heavyPiece) {
		this.heavyPiece = heavyPiece;
	}

	public String getIfAutoConfirm() {
		return ifAutoConfirm;
	}

	public void setIfAutoConfirm(String ifAutoConfirm) {
		this.ifAutoConfirm = ifAutoConfirm;
	}

	public String getIfAutoPrice() {
		return ifAutoPrice;
	}

	public void setIfAutoPrice(String ifAutoPrice) {
		this.ifAutoPrice = ifAutoPrice;
	}

	public String getIfAutoTransSys() {
		return ifAutoTransSys;
	}

	public void setIfAutoTransSys(String ifAutoTransSys) {
		this.ifAutoTransSys = ifAutoTransSys;
	}

	public String getIfBjToQd() {
		return ifBjToQd;
	}

	public void setIfBjToQd(String ifBjToQd) {
		this.ifBjToQd = ifBjToQd;
	}

	public String getIfCanShow() {
		return ifCanShow;
	}

	public void setIfCanShow(String ifCanShow) {
		this.ifCanShow = ifCanShow;
	}

	public String getIfConfirm() {
		return ifConfirm;
	}

	public void setIfConfirm(String ifConfirm) {
		this.ifConfirm = ifConfirm;
	}

	public String getIfFragment() {
		return ifFragment;
	}

	public void setIfFragment(String ifFragment) {
		this.ifFragment = ifFragment;
	}

	public String getIfOwnerTaxpriceMf() {
		return ifOwnerTaxpriceMf;
	}

	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}

	public String getIfPartition() {
		return ifPartition;
	}

	public void setIfPartition(String ifPartition) {
		this.ifPartition = ifPartition;
	}

	public String getIfPayment() {
		return ifPayment;
	}

	public void setIfPayment(String ifPayment) {
		this.ifPayment = ifPayment;
	}

	public Integer getIfSavePublish() {
		return ifSavePublish;
	}

	public void setIfSavePublish(Integer ifSavePublish) {
		this.ifSavePublish = ifSavePublish;
	}

	public String getIfShowFloorPrice() {
		return ifShowFloorPrice;
	}

	public void setIfShowFloorPrice(String ifShowFloorPrice) {
		this.ifShowFloorPrice = ifShowFloorPrice;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public Long getImportId() {
		return importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	public BigDecimal getInitAmount() {
		return initAmount;
	}

	public void setInitAmount(BigDecimal initAmount) {
		this.initAmount = initAmount;
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

	public String getIsAutoToTrans() {
		return isAutoToTrans;
	}

	public void setIsAutoToTrans(String isAutoToTrans) {
		this.isAutoToTrans = isAutoToTrans;
	}

	public String getJsType() {
		return jsType;
	}

	public void setJsType(String jsType) {
		this.jsType = jsType;
	}

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public BigDecimal getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(BigDecimal listingPrice) {
		this.listingPrice = listingPrice;
	}

	public String getLogisticsMark() {
		return logisticsMark;
	}

	public void setLogisticsMark(String logisticsMark) {
		this.logisticsMark = logisticsMark;
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

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getOilAmount() {
		return oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getOilFlag() {
		return oilFlag;
	}

	public void setOilFlag(String oilFlag) {
		this.oilFlag = oilFlag;
	}

	public BigDecimal getOilRatio() {
		return oilRatio;
	}

	public void setOilRatio(BigDecimal oilRatio) {
		this.oilRatio = oilRatio;
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

	public String getPickUpGoodsName() {
		return pickUpGoodsName;
	}

	public void setPickUpGoodsName(String pickUpGoodsName) {
		this.pickUpGoodsName = pickUpGoodsName;
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

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getPriPublishId() {
		return priPublishId;
	}

	public void setPriPublishId(Long priPublishId) {
		this.priPublishId = priPublishId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceTax() {
		return priceTax;
	}

	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}

	public Integer getPriceTimeCycle() {
		return priceTimeCycle;
	}

	public void setPriceTimeCycle(Integer priceTimeCycle) {
		this.priceTimeCycle = priceTimeCycle;
	}

	public String getProdArea() {
		return prodArea;
	}

	public void setProdArea(String prodArea) {
		this.prodArea = prodArea;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getPs1() {
		return ps1;
	}

	public void setPs1(String ps1) {
		this.ps1 = ps1;
	}

	public String getPs2() {
		return ps2;
	}

	public void setPs2(String ps2) {
		this.ps2 = ps2;
	}

	public String getPs3() {
		return ps3;
	}

	public void setPs3(String ps3) {
		this.ps3 = ps3;
	}

	public String getPs4() {
		return ps4;
	}

	public void setPs4(String ps4) {
		this.ps4 = ps4;
	}

	public String getPs5() {
		return ps5;
	}

	public void setPs5(String ps5) {
		this.ps5 = ps5;
	}

	public String getPublishNum() {
		return publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public String getQbType() {
		return qbType;
	}

	public void setQbType(String qbType) {
		this.qbType = qbType;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getRovokeWeight() {
		return rovokeWeight;
	}

	public void setRovokeWeight(BigDecimal rovokeWeight) {
		this.rovokeWeight = rovokeWeight;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(BigDecimal saleQty) {
		this.saleQty = saleQty;
	}

	public BigDecimal getSaleWeight() {
		return saleWeight;
	}

	public void setSaleWeight(BigDecimal saleWeight) {
		this.saleWeight = saleWeight;
	}

	public String getSendGroup() {
		return sendGroup;
	}

	public void setSendGroup(String sendGroup) {
		this.sendGroup = sendGroup;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public Integer getSendKM() {
		return sendKM;
	}

	public void setSendKM(Integer sendKM) {
		this.sendKM = sendKM;
	}

	public BigDecimal getSingleCarWeight() {
		return singleCarWeight;
	}

	public void setSingleCarWeight(BigDecimal singleCarWeight) {
		this.singleCarWeight = singleCarWeight;
	}

	public BigDecimal getStandardTax() {
		return standardTax;
	}

	public void setStandardTax(BigDecimal standardTax) {
		this.standardTax = standardTax;
	}

	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getStartPlateCity() {
		return startPlateCity;
	}

	public void setStartPlateCity(String startPlateCity) {
		this.startPlateCity = startPlateCity;
	}

	public String getStartPlateCountry() {
		return startPlateCountry;
	}

	public void setStartPlateCountry(String startPlateCountry) {
		this.startPlateCountry = startPlateCountry;
	}

	public String getStartPlateProvince() {
		return startPlateProvince;
	}

	public void setStartPlateProvince(String startPlateProvince) {
		this.startPlateProvince = startPlateProvince;
	}

	public Date getStartTakeDeliveryDate() {
		return startTakeDeliveryDate;
	}

	public void setStartTakeDeliveryDate(Date startTakeDeliveryDate) {
		this.startTakeDeliveryDate = startTakeDeliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTakeDeliveryDate() {
		return takeDeliveryDate;
	}

	public void setTakeDeliveryDate(Date takeDeliveryDate) {
		this.takeDeliveryDate = takeDeliveryDate;
	}

	public String getTakeType() {
		return takeType;
	}

	public void setTakeType(String takeType) {
		this.takeType = takeType;
	}

	public Date getTmingRelease() {
		return tmingRelease;
	}

	public void setTmingRelease(Date tmingRelease) {
		this.tmingRelease = tmingRelease;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(Long updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVatFlowMasterId() {
		return vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public String getVehicleStyleVar() {
		return vehicleStyleVar;
	}

	public void setVehicleStyleVar(String vehicleStyleVar) {
		this.vehicleStyleVar = vehicleStyleVar;
	}

	public String getWebCanGrab() {
		return webCanGrab;
	}

	public void setWebCanGrab(String webCanGrab) {
		this.webCanGrab = webCanGrab;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
}
