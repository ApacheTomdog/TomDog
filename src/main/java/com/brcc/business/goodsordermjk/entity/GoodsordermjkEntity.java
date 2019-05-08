package com.brcc.business.goodsordermjk.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goodsordermjk database table.
 * 
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="goodsordermjk")
@NamedQuery(name="GoodsordermjkEntity.findAll", query="SELECT g FROM GoodsordermjkEntity g")
public class GoodsordermjkEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="import_id")
	private Long importId;

	private BigDecimal amount;

	@Column(name="appoint_company_id")
	private String appointCompanyId;

	@Column(name="appoint_company_name")
	private String appointCompanyName;

	@Column(name="appoint_person_info")
	private String appointPersonInfo;

	@Column(name="appoint_team_id")
	private String appointTeamId;

	@Column(name="appoint_team_type")
	private String appointTeamType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="approve_time")
	private Date approveTime;

	@Column(name="approve_user_id")
	private String approveUserId;

	@Column(name="asds_mark")
	private String asdsMark;

	@Column(name="batch_id")
	private Integer batchId;

	@Column(name="bill_sender")
	private String billSender;

	@Column(name="bill_sender_mobile")
	private String billSenderMobile;

	@Column(name="bill_taker")
	private String billTaker;

	@Column(name="bill_taker_mobile")
	private String billTakerMobile;

	@Column(name="catalog_id")
	private Long catalogId;

	@Column(name="catalog_name")
	private String catalogName;

	@Column(name="cg_save_remark")
	private String cgSaveRemark;

	@Column(name="charge_price")
	private BigDecimal chargePrice;

	@Column(name="charge_price_type")
	private String chargePriceType;

	@Column(name="company_id")
	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="depend_num")
	private String dependNum;

	@Column(name="depend_num2")
	private String dependNum2;

	private String detachable;

	@Column(name="docu_type")
	private String docuType;

	@Column(name="ds_dz_flag")
	private String dsDzFlag;

	@Column(name="ds_if_settle")
	private String dsIfSettle;

	@Column(name="end_plate")
	private String endPlate;

	@Column(name="end_plate_address")
	private String endPlateAddress;

	@Column(name="end_plate_city")
	private String endPlateCity;

	@Column(name="end_plate_country")
	private String endPlateCountry;

	@Column(name="end_plate_detail")
	private String endPlateDetail;

	@Column(name="end_plate_lat")
	private String endPlateLat;

	@Column(name="end_plate_lng")
	private String endPlateLng;

	@Column(name="end_plate_province")
	private String endPlateProvince;

	private BigDecimal estimateKM;

	@Column(name="fd_user_id")
	private Long fdUserId;

	@Column(name="from_type")
	private String fromType;

	@Column(name="get_order_plate")
	private String getOrderPlate;

	@Column(name="get_order_plate_city")
	private String getOrderPlateCity;

	@Column(name="get_order_plate_country")
	private String getOrderPlateCountry;

	@Column(name="get_order_plate_detail")
	private String getOrderPlateDetail;

	@Column(name="get_order_plate_lat")
	private String getOrderPlateLat;

	@Column(name="get_order_plate_lng")
	private String getOrderPlateLng;

	@Column(name="get_order_plate_province")
	private String getOrderPlateProvince;

	@Column(name="good_price")
	private BigDecimal goodPrice;

	@Column(name="good_type")
	private Long goodType;

	@Column(name="good_type_desc")
	private String goodTypeDesc;

	@Column(name="goods_owner_id")
	private Integer goodsOwnerId;

	@Column(name="group_id")
	private Long groupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="heavy_piece")
	private String heavyPiece;

	@Column(name="if_can_show")
	private String ifCanShow;

	@Column(name="if_info_complete")
	private String ifInfoComplete;

	@Column(name="if_on_off")
	private Integer ifOnOff;

	@Column(name="if_payment")
	private String ifPayment;

	@Column(name="if_tax_transport")
	private String ifTaxTransport;

	@Column(name="init_spilt_weight")
	private BigDecimal initSpiltWeight;

	@Column(name="is_auto_display")
	private String isAutoDisplay;

	@Column(name="jk_level_flag")
	private String jkLevelFlag;

	@Column(name="jk_operator_id")
	private Integer jkOperatorId;

	@Column(name="jk_operator_name")
	private String jkOperatorName;

	@Column(name="js_type")
	private String jsType;

	@Column(name="limit_time")
	private String limitTime;

	@Column(name="listing_price")
	private BigDecimal listingPrice;

	@Column(name="logistics_mark")
	private String logisticsMark;

	@Column(name="loss_ratio")
	private BigDecimal lossRatio;

	@Column(name="loss_type")
	private String lossType;

	@Column(name="loss_weight")
	private BigDecimal lossWeight;

	@Column(name="max_price")
	private BigDecimal maxPrice;

	@Column(name="oil_amount")
	private BigDecimal oilAmount;

	@Column(name="oil_flag")
	private String oilFlag;

	@Column(name="oil_ratio")
	private BigDecimal oilRatio;

	@Column(name="pick_up_goods_name")
	private String pickUpGoodsName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pickup_date")
	private Date pickupDate;

	@Column(name="pin_dan_num")
	private Integer pinDanNum;

	@Column(name="platform_id")
	private String platformId;

	private BigDecimal price;

	@Column(name="price_tax")
	private BigDecimal priceTax;

	@Column(name="prod_area")
	private String prodArea;

	@Column(name="prod_desc")
	private String prodDesc;

	private String ps1;

	private String ps2;

	private String ps3;

	private String ps4;

	private String ps5;

	@Column(name="publish_batch_id")
	private String publishBatchId;

	@Column(name="publish_id")
	private Long publishId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="putin_date")
	private Date putinDate;

	@Column(name="qb_type")
	private String qbType;

	private BigDecimal qty;

	private String receiver;

	@Column(name="receiver_mobile")
	private String receiverMobile;

	private String remark;

	@Column(name="ret_1")
	private String ret1;

	@Column(name="ret_2")
	private String ret2;

	@Column(name="ret_3")
	private String ret3;

	@Column(name="send_group")
	private String sendGroup;

	private String sender;

	@Column(name="sender_mobile")
	private String senderMobile;

	private Integer sendKM;

	@Column(name="settle_amount")
	private BigDecimal settleAmount;

	@Column(name="settle_price")
	private BigDecimal settlePrice;

	@Column(name="settle_status")
	private String settleStatus;

	@Column(name="settle_weight")
	private BigDecimal settleWeight;

	@Column(name="single_car_weight")
	private BigDecimal singleCarWeight;

	@Column(name="spilt_type")
	private String spiltType;

	@Column(name="standard_tax")
	private BigDecimal standardTax;

	@Column(name="start_plate")
	private String startPlate;

	@Column(name="start_plate_city")
	private String startPlateCity;

	@Column(name="start_plate_country")
	private String startPlateCountry;

	@Column(name="start_plate_detail")
	private String startPlateDetail;

	@Column(name="start_plate_lat")
	private String startPlateLat;

	@Column(name="start_plate_lng")
	private String startPlateLng;

	@Column(name="start_plate_province")
	private String startPlateProvince;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_take_delivery_date")
	private Date startTakeDeliveryDate;

	private String status;

	@Column(name="tax_num")
	private String taxNum;

	@Column(name="total_weight")
	private BigDecimal totalWeight;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person_id")
	private String updatePersonId;

	@Column(name="user_id")
	private Long userId;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name="vehicle_style_var")
	private String vehicleStyleVar;

	private BigDecimal weight;

	@Column(name="contract_number")
	private String contractNumber;

	@Column(name="take_goods_type")
	private String takeGoodsType;
	
	@Column(name="inter_code")
	private String interCode;

	@Column(name="add_weight_type")
	private String addWeightType;
	
	@Column(name="rob_delivery_type")
	private String robDeliveryType;
	
	@Column(name="business_mode")
	private String businessMode;

	public String getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}

	public String getRobDeliveryType() {
		return robDeliveryType;
	}

	public void setRobDeliveryType(String robDeliveryType) {
		this.robDeliveryType = robDeliveryType;
	}

	public String getInterCode() {
		return interCode;
	}

	public void setInterCode(String interCode) {
		this.interCode = interCode;
	}

	public String getTakeGoodsType() {
		return takeGoodsType;
	}

	public void setTakeGoodsType(String takeGoodsType) {
		this.takeGoodsType = takeGoodsType;
	}

	public Long getImportId() {
		return importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAppointCompanyId() {
		return appointCompanyId;
	}

	public void setAppointCompanyId(String appointCompanyId) {
		this.appointCompanyId = appointCompanyId;
	}

	public String getAppointCompanyName() {
		return appointCompanyName;
	}

	public void setAppointCompanyName(String appointCompanyName) {
		this.appointCompanyName = appointCompanyName;
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

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getApproveUserId() {
		return approveUserId;
	}

	public void setApproveUserId(String approveUserId) {
		this.approveUserId = approveUserId;
	}

	public String getAsdsMark() {
		return asdsMark;
	}

	public void setAsdsMark(String asdsMark) {
		this.asdsMark = asdsMark;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
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

	public String getCgSaveRemark() {
		return cgSaveRemark;
	}

	public void setCgSaveRemark(String cgSaveRemark) {
		this.cgSaveRemark = cgSaveRemark;
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

	public String getDetachable() {
		return detachable;
	}

	public void setDetachable(String detachable) {
		this.detachable = detachable;
	}

	public String getDocuType() {
		return docuType;
	}

	public void setDocuType(String docuType) {
		this.docuType = docuType;
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

	public String getEndPlateAddress() {
		return endPlateAddress;
	}

	public void setEndPlateAddress(String endPlateAddress) {
		this.endPlateAddress = endPlateAddress;
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

	public String getEndPlateDetail() {
		return endPlateDetail;
	}

	public void setEndPlateDetail(String endPlateDetail) {
		this.endPlateDetail = endPlateDetail;
	}

	public String getEndPlateLat() {
		return endPlateLat;
	}

	public void setEndPlateLat(String endPlateLat) {
		this.endPlateLat = endPlateLat;
	}

	public String getEndPlateLng() {
		return endPlateLng;
	}

	public void setEndPlateLng(String endPlateLng) {
		this.endPlateLng = endPlateLng;
	}

	public String getEndPlateProvince() {
		return endPlateProvince;
	}

	public void setEndPlateProvince(String endPlateProvince) {
		this.endPlateProvince = endPlateProvince;
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

	public String getGetOrderPlateDetail() {
		return getOrderPlateDetail;
	}

	public void setGetOrderPlateDetail(String getOrderPlateDetail) {
		this.getOrderPlateDetail = getOrderPlateDetail;
	}

	public String getGetOrderPlateLat() {
		return getOrderPlateLat;
	}

	public void setGetOrderPlateLat(String getOrderPlateLat) {
		this.getOrderPlateLat = getOrderPlateLat;
	}

	public String getGetOrderPlateLng() {
		return getOrderPlateLng;
	}

	public void setGetOrderPlateLng(String getOrderPlateLng) {
		this.getOrderPlateLng = getOrderPlateLng;
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

	public String getHeavyPiece() {
		return heavyPiece;
	}

	public void setHeavyPiece(String heavyPiece) {
		this.heavyPiece = heavyPiece;
	}

	public String getIfCanShow() {
		return ifCanShow;
	}

	public void setIfCanShow(String ifCanShow) {
		this.ifCanShow = ifCanShow;
	}

	public String getIfInfoComplete() {
		return ifInfoComplete;
	}

	public void setIfInfoComplete(String ifInfoComplete) {
		this.ifInfoComplete = ifInfoComplete;
	}

	public Integer getIfOnOff() {
		return ifOnOff;
	}

	public void setIfOnOff(Integer ifOnOff) {
		this.ifOnOff = ifOnOff;
	}

	public String getIfPayment() {
		return ifPayment;
	}

	public void setIfPayment(String ifPayment) {
		this.ifPayment = ifPayment;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public BigDecimal getInitSpiltWeight() {
		return initSpiltWeight;
	}

	public void setInitSpiltWeight(BigDecimal initSpiltWeight) {
		this.initSpiltWeight = initSpiltWeight;
	}

	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}

	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}

	public String getJkLevelFlag() {
		return jkLevelFlag;
	}

	public void setJkLevelFlag(String jkLevelFlag) {
		this.jkLevelFlag = jkLevelFlag;
	}

	public Integer getJkOperatorId() {
		return jkOperatorId;
	}

	public void setJkOperatorId(Integer jkOperatorId) {
		this.jkOperatorId = jkOperatorId;
	}

	public String getJkOperatorName() {
		return jkOperatorName;
	}

	public void setJkOperatorName(String jkOperatorName) {
		this.jkOperatorName = jkOperatorName;
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

	public String getPublishBatchId() {
		return publishBatchId;
	}

	public void setPublishBatchId(String publishBatchId) {
		this.publishBatchId = publishBatchId;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Date getPutinDate() {
		return putinDate;
	}

	public void setPutinDate(Date putinDate) {
		this.putinDate = putinDate;
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

	public String getRet1() {
		return ret1;
	}

	public void setRet1(String ret1) {
		this.ret1 = ret1;
	}

	public String getRet2() {
		return ret2;
	}

	public void setRet2(String ret2) {
		this.ret2 = ret2;
	}

	public String getRet3() {
		return ret3;
	}

	public void setRet3(String ret3) {
		this.ret3 = ret3;
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

	public BigDecimal getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}

	public BigDecimal getSettlePrice() {
		return settlePrice;
	}

	public void setSettlePrice(BigDecimal settlePrice) {
		this.settlePrice = settlePrice;
	}

	public String getSettleStatus() {
		return settleStatus;
	}

	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}

	public BigDecimal getSettleWeight() {
		return settleWeight;
	}

	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}

	public BigDecimal getSingleCarWeight() {
		return singleCarWeight;
	}

	public void setSingleCarWeight(BigDecimal singleCarWeight) {
		this.singleCarWeight = singleCarWeight;
	}

	public String getSpiltType() {
		return spiltType;
	}

	public void setSpiltType(String spiltType) {
		this.spiltType = spiltType;
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

	public String getStartPlateDetail() {
		return startPlateDetail;
	}

	public void setStartPlateDetail(String startPlateDetail) {
		this.startPlateDetail = startPlateDetail;
	}

	public String getStartPlateLat() {
		return startPlateLat;
	}

	public void setStartPlateLat(String startPlateLat) {
		this.startPlateLat = startPlateLat;
	}

	public String getStartPlateLng() {
		return startPlateLng;
	}

	public void setStartPlateLng(String startPlateLng) {
		this.startPlateLng = startPlateLng;
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

	public String getTaxNum() {
		return taxNum;
	}

	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdatePersonId() {
		return updatePersonId;
	}

	public void setUpdatePersonId(String updatePersonId) {
		this.updatePersonId = updatePersonId;
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

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getAddWeightType() {
		return addWeightType;
	}

	public void setAddWeightType(String addWeightType) {
		this.addWeightType = addWeightType;
	}
}