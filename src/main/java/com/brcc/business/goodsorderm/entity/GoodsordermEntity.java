package com.brcc.business.goodsorderm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * The persistent class for the goodsorderm database table.
 *
 */
@Entity
@Table(name="goodsorderm")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="GoodsordermEntity.findAll", query="SELECT g FROM GoodsordermEntity g")
public class GoodsordermEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="publish_id")
	private Long publishId;

	@Column(name="adjust_person_id")
	private Integer adjustPersonId;

	@Column(name="adjust_person_name")
	private String adjustPersonName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="adjust_price_date")
	private Date adjustPriceDate;

	private BigDecimal amount;

	@Column(name="appoint_company_id")
	private Integer appointCompanyId;

	@Column(name="appoint_person_info")
	private String appointPersonInfo;

	@Column(name="appoint_team_id")
	private String appointTeamId;

	@Column(name="appoint_team_type")
	private String appointTeamType;

	@Column(name="asds_mark")
	private String asdsMark;

	@Column(name="bid_times")
	private Integer bidTimes;

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

	@Column(name="charge_price")
	private BigDecimal chargePrice;

	@Column(name="charge_price_type")
	private String chargePriceType;

	@Column(name="combined_number")
	private Integer combinedNumber;

	@Column(name="company_id")
	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String departure;

	@Column(name="departure_lat")
	private BigDecimal departureLat;

	@Column(name="departure_lng")
	private BigDecimal departureLng;

	@Column(name="depend_num")
	private String dependNum;

	@Column(name="depend_num2")
	private String dependNum2;

	private String destination;

	@Column(name="destination_lat")
	private BigDecimal destinationLat;

	@Column(name="destination_lng")
	private BigDecimal destinationLng;

	private String detachable;

	@Column(name="docu_pri_sec",columnDefinition="vachar default 1")
	private String docuPriSec;

	@Column(name="docu_type")
	private String docuType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dq_end_date")
	private Date dqEndDate;

	@Column(name="dq_flag")
	private String dqFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dq_stt_date")
	private Date dqSttDate;

	@Column(name="ds_dz_flag")
	private String dsDzFlag;

	@Column(name="ds_if_settle")
	private String dsIfSettle;

	@Column(name="end_plate")
	private String endPlate;

	@Column(name="end_plate_city")
	private String endPlateCity;

	@Column(name="end_plate_country")
	private String endPlateCountry;

	@Column(name="end_plate_province")
	private String endPlateProvince;

	@Column(name="entrust_company")
	private String entrustCompany;

	private BigDecimal estimateKM;

	@Column(name="fd_user_id")
	private Long fdUserId;

	@Column(name="floor_price")
	private BigDecimal floorPrice;

	@Column(name="from_plat_name")
	private String fromPlatName;

	@Column(name="from_type")
	private String fromType;

	@Column(name="get_order_address")
	private String getOrderAddress;

	@Column(name="get_order_address_lat")
	private BigDecimal getOrderAddressLat;

	@Column(name="get_order_address_lng")
	private BigDecimal getOrderAddressLng;

	@Column(name="get_order_plate")
	private String getOrderPlate;

	@Column(name="get_order_plate_city")
	private String getOrderPlateCity;

	@Column(name="get_order_plate_country")
	private String getOrderPlateCountry;

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
	private BigDecimal heavyPiece;

	@Column(name="if_auto_confirm")
	private String ifAutoConfirm;

	@Column(name="if_auto_price")
	private String ifAutoPrice;

	@Column(name="if_auto_trans_sys",columnDefinition="vachar default 0")
	private String ifAutoTransSys;

	@Column(name="if_bj_to_qd")
	private String ifBjToQd;

	@Column(name="if_can_show")
	private String ifCanShow;

	@Column(name="if_confirm")
	private String ifConfirm;

	@Column(name="if_fragment",columnDefinition="vachar default 0")
	private String ifFragment;

	@Column(name="if_owner_taxprice_mf")
	private String ifOwnerTaxpriceMf;

	@Column(name="if_partition")
	private String ifPartition;

	@Column(name="if_payment")
	private String ifPayment;

	@Column(name="if_save_publish")
	private Integer ifSavePublish;

	@Column(name="if_show_floor_price")
	private String ifShowFloorPrice;

	@Column(name="if_tax_transport")
	private String ifTaxTransport;

	@Column(name="import_id")
	private Long importId;

	@Column(name="init_amount")
	private BigDecimal initAmount;

	@Column(name="init_qty")
	private BigDecimal initQty;

	@Column(name="init_weight")
	private BigDecimal initWeight;

	@Column(name="is_auto_display")
	private String isAutoDisplay;

	@Column(name="is_auto_to_trans")
	private String isAutoToTrans;

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

	@Column(name="owner_adjust_amt")
	private BigDecimal ownerAdjustAmt;

	@Column(name="owner_adjust_flag")
	private String ownerAdjustFlag;

	@Column(name="owner_adjust_type")
	private String ownerAdjustType;

	@Column(name="pick_up_goods_name")
	private String pickUpGoodsName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pickup_date")
	private Date pickupDate;

	@Column(name="pin_dan_num")
	private Integer pinDanNum;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="pri_publish_id")
	private Long priPublishId;

	private BigDecimal price;

	@Column(name="price_tax")
	private BigDecimal priceTax;

	@Column(name="price_time_cycle")
	private Integer priceTimeCycle;

	@Column(name="prod_area")
	private String prodArea;

	@Column(name="prod_desc")
	private String prodDesc;

	private String ps;

	private String ps1;

	private String ps2;

	private String ps3;

	private String ps4;

	private String ps5;

	@Column(name="publish_num")
	private String publishNum;

	@Column(name="qb_type")
	private String qbType;

	private BigDecimal qty;

	private String receiver;

	@Column(name="receiver_mobile")
	private String receiverMobile;

	private String remark;

	@Column(name="rovoke_weight")
	private BigDecimal rovokeWeight;

	@Column(name="sale_amount")
	private BigDecimal saleAmount;

	@Column(name="sale_qty")
	private BigDecimal saleQty;

	@Column(name="sale_weight")
	private BigDecimal saleWeight;

	@Column(name="send_group")
	private String sendGroup;

	private String sender;

	@Column(name="sender_mobile")
	private String senderMobile;

	private Integer sendKM;

	@Column(name="single_car_weight")
	private BigDecimal singleCarWeight;

	@Column(name="standard_tax")
	private BigDecimal standardTax;

	@Column(name="start_plate")
	private String startPlate;

	@Column(name="start_plate_city")
	private String startPlateCity;

	@Column(name="start_plate_country")
	private String startPlateCountry;

	@Column(name="start_plate_province")
	private String startPlateProvince;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_take_delivery_date")
	private Date startTakeDeliveryDate;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="take_delivery_date")
	private Date takeDeliveryDate;

	@Column(name="take_type")
	private String takeType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tming_release")
	private Date tmingRelease;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person")
	private Long updatePerson;

	@Column(name="user_id")
	private Long userId;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name="vehicle_style_var")
	private String vehicleStyleVar;

	@Column(name="web_can_grab")
	private String webCanGrab;

	private BigDecimal weight;

	// 0代表不需要平台审核，1代表需要平台审核(抢单调价)
	@Column(name="if_audit")
	private String ifAudit;

	@Column(name="contract_number")
	private String contractNumber;

	@Column(name="add_weight_type")
	private String addWeightType;

	@Column(name="add_weight_flag")
	private String addWeightFlag;

	@Column(name="business_mode")
	private String businessMode;

	@Column(name="max_trans_days")
	private Integer maxTransDays;

	@Column(name="contract_type")
	private String contractType;

	@Column(name="rob_delivery_type")
	private String robDeliveryType;

	public GoodsordermEntity() {
	}


	public Long getPublishId() {
		return publishId;
	}


	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}


	public Integer getAdjustPersonId() {
		return this.adjustPersonId;
	}

	public void setAdjustPersonId(Integer adjustPersonId) {
		this.adjustPersonId = adjustPersonId;
	}

	public String getAdjustPersonName() {
		return this.adjustPersonName;
	}

	public void setAdjustPersonName(String adjustPersonName) {
		this.adjustPersonName = adjustPersonName;
	}

	public Date getAdjustPriceDate() {
		return this.adjustPriceDate;
	}

	public void setAdjustPriceDate(Date adjustPriceDate) {
		this.adjustPriceDate = adjustPriceDate;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAppointPersonInfo() {
		return this.appointPersonInfo;
	}

	public void setAppointPersonInfo(String appointPersonInfo) {
		this.appointPersonInfo = appointPersonInfo;
	}

	public String getAppointTeamId() {
		return this.appointTeamId;
	}

	public void setAppointTeamId(String appointTeamId) {
		this.appointTeamId = appointTeamId;
	}

	public String getAppointTeamType() {
		return this.appointTeamType;
	}

	public void setAppointTeamType(String appointTeamType) {
		this.appointTeamType = appointTeamType;
	}

	public String getAsdsMark() {
		return this.asdsMark;
	}

	public void setAsdsMark(String asdsMark) {
		this.asdsMark = asdsMark;
	}

	public Integer getBidTimes() {
		return this.bidTimes;
	}

	public void setBidTimes(Integer bidTimes) {
		this.bidTimes = bidTimes;
	}

	public String getBillSender() {
		return this.billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getBillSenderMobile() {
		return this.billSenderMobile;
	}

	public void setBillSenderMobile(String billSenderMobile) {
		this.billSenderMobile = billSenderMobile;
	}

	public String getBillTaker() {
		return this.billTaker;
	}

	public void setBillTaker(String billTaker) {
		this.billTaker = billTaker;
	}

	public String getBillTakerMobile() {
		return this.billTakerMobile;
	}

	public void setBillTakerMobile(String billTakerMobile) {
		this.billTakerMobile = billTakerMobile;
	}

	public Long getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public BigDecimal getChargePrice() {
		return this.chargePrice;
	}

	public void setChargePrice(BigDecimal chargePrice) {
		this.chargePrice = chargePrice;
	}

	public String getChargePriceType() {
		return this.chargePriceType;
	}

	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
	}

	public Integer getCombinedNumber() {
		return this.combinedNumber;
	}

	public void setCombinedNumber(Integer combinedNumber) {
		this.combinedNumber = combinedNumber;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeparture() {
		return this.departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public BigDecimal getDepartureLat() {
		return this.departureLat;
	}

	public void setDepartureLat(BigDecimal departureLat) {
		this.departureLat = departureLat;
	}

	public BigDecimal getDepartureLng() {
		return this.departureLng;
	}

	public void setDepartureLng(BigDecimal departureLng) {
		this.departureLng = departureLng;
	}

	public String getDependNum() {
		return this.dependNum;
	}

	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}

	public String getDependNum2() {
		return this.dependNum2;
	}

	public void setDependNum2(String dependNum2) {
		this.dependNum2 = dependNum2;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDestinationLat() {
		return this.destinationLat;
	}

	public void setDestinationLat(BigDecimal destinationLat) {
		this.destinationLat = destinationLat;
	}

	public BigDecimal getDestinationLng() {
		return this.destinationLng;
	}

	public void setDestinationLng(BigDecimal destinationLng) {
		this.destinationLng = destinationLng;
	}

	public String getDetachable() {
		return this.detachable;
	}

	public void setDetachable(String detachable) {
		this.detachable = detachable;
	}

	public String getDocuPriSec() {
		return this.docuPriSec;
	}

	public void setDocuPriSec(String docuPriSec) {
		this.docuPriSec = docuPriSec;
	}

	public String getDocuType() {
		return this.docuType;
	}

	public void setDocuType(String docuType) {
		this.docuType = docuType;
	}

	public Date getDqEndDate() {
		return this.dqEndDate;
	}

	public void setDqEndDate(Date dqEndDate) {
		this.dqEndDate = dqEndDate;
	}

	public String getDqFlag() {
		return this.dqFlag;
	}

	public void setDqFlag(String dqFlag) {
		this.dqFlag = dqFlag;
	}

	public Date getDqSttDate() {
		return this.dqSttDate;
	}

	public void setDqSttDate(Date dqSttDate) {
		this.dqSttDate = dqSttDate;
	}

	public String getDsDzFlag() {
		return this.dsDzFlag;
	}

	public void setDsDzFlag(String dsDzFlag) {
		this.dsDzFlag = dsDzFlag;
	}

	public String getDsIfSettle() {
		return this.dsIfSettle;
	}

	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
	}

	public String getEndPlate() {
		return this.endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

	public String getEndPlateCity() {
		return this.endPlateCity;
	}

	public void setEndPlateCity(String endPlateCity) {
		this.endPlateCity = endPlateCity;
	}

	public String getEndPlateCountry() {
		return this.endPlateCountry;
	}

	public void setEndPlateCountry(String endPlateCountry) {
		this.endPlateCountry = endPlateCountry;
	}

	public String getEndPlateProvince() {
		return this.endPlateProvince;
	}

	public void setEndPlateProvince(String endPlateProvince) {
		this.endPlateProvince = endPlateProvince;
	}

	public String getEntrustCompany() {
		return this.entrustCompany;
	}

	public void setEntrustCompany(String entrustCompany) {
		this.entrustCompany = entrustCompany;
	}

	public BigDecimal getEstimateKM() {
		return this.estimateKM;
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


	public String getFromPlatName() {
		return this.fromPlatName;
	}

	public void setFromPlatName(String fromPlatName) {
		this.fromPlatName = fromPlatName;
	}

	public String getFromType() {
		return this.fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getGetOrderAddress() {
		return this.getOrderAddress;
	}

	public void setGetOrderAddress(String getOrderAddress) {
		this.getOrderAddress = getOrderAddress;
	}

	public BigDecimal getGetOrderAddressLat() {
		return this.getOrderAddressLat;
	}

	public void setGetOrderAddressLat(BigDecimal getOrderAddressLat) {
		this.getOrderAddressLat = getOrderAddressLat;
	}

	public BigDecimal getGetOrderAddressLng() {
		return this.getOrderAddressLng;
	}

	public void setGetOrderAddressLng(BigDecimal getOrderAddressLng) {
		this.getOrderAddressLng = getOrderAddressLng;
	}

	public String getGetOrderPlate() {
		return this.getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

	public String getGetOrderPlateCity() {
		return this.getOrderPlateCity;
	}

	public void setGetOrderPlateCity(String getOrderPlateCity) {
		this.getOrderPlateCity = getOrderPlateCity;
	}

	public String getGetOrderPlateCountry() {
		return this.getOrderPlateCountry;
	}

	public void setGetOrderPlateCountry(String getOrderPlateCountry) {
		this.getOrderPlateCountry = getOrderPlateCountry;
	}

	public String getGetOrderPlateProvince() {
		return this.getOrderPlateProvince;
	}

	public void setGetOrderPlateProvince(String getOrderPlateProvince) {
		this.getOrderPlateProvince = getOrderPlateProvince;
	}

	public BigDecimal getGoodPrice() {
		return this.goodPrice;
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
		return this.goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public Integer getGoodsOwnerId() {
		return this.goodsOwnerId;
	}

	public void setGoodsOwnerId(Integer goodsOwnerId) {
		this.goodsOwnerId = goodsOwnerId;
	}



	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}


	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public BigDecimal getHeavyPiece() {
		return this.heavyPiece;
	}

	public void setHeavyPiece(BigDecimal heavyPiece) {
		this.heavyPiece = heavyPiece;
	}

	public String getIfAutoConfirm() {
		return this.ifAutoConfirm;
	}

	public void setIfAutoConfirm(String ifAutoConfirm) {
		this.ifAutoConfirm = ifAutoConfirm;
	}

	public String getIfAutoPrice() {
		return this.ifAutoPrice;
	}

	public void setIfAutoPrice(String ifAutoPrice) {
		this.ifAutoPrice = ifAutoPrice;
	}

	public String getIfAutoTransSys() {
		return this.ifAutoTransSys;
	}

	public void setIfAutoTransSys(String ifAutoTransSys) {
		this.ifAutoTransSys = ifAutoTransSys;
	}

	public String getIfBjToQd() {
		return this.ifBjToQd;
	}

	public void setIfBjToQd(String ifBjToQd) {
		this.ifBjToQd = ifBjToQd;
	}

	public String getIfCanShow() {
		return this.ifCanShow;
	}

	public void setIfCanShow(String ifCanShow) {
		this.ifCanShow = ifCanShow;
	}

	public String getIfConfirm() {
		return this.ifConfirm;
	}

	public void setIfConfirm(String ifConfirm) {
		this.ifConfirm = ifConfirm;
	}

	public String getIfFragment() {
		return this.ifFragment;
	}

	public void setIfFragment(String ifFragment) {
		this.ifFragment = ifFragment;
	}

	public String getIfOwnerTaxpriceMf() {
		return this.ifOwnerTaxpriceMf;
	}

	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}

	public String getIfPartition() {
		return this.ifPartition;
	}

	public void setIfPartition(String ifPartition) {
		this.ifPartition = ifPartition;
	}

	public String getIfPayment() {
		return this.ifPayment;
	}

	public void setIfPayment(String ifPayment) {
		this.ifPayment = ifPayment;
	}

	public Integer getIfSavePublish() {
		return this.ifSavePublish;
	}

	public void setIfSavePublish(Integer ifSavePublish) {
		this.ifSavePublish = ifSavePublish;
	}

	public String getIfShowFloorPrice() {
		return this.ifShowFloorPrice;
	}

	public void setIfShowFloorPrice(String ifShowFloorPrice) {
		this.ifShowFloorPrice = ifShowFloorPrice;
	}

	public String getIfTaxTransport() {
		return this.ifTaxTransport;
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
		return this.initAmount;
	}

	public void setInitAmount(BigDecimal initAmount) {
		this.initAmount = initAmount;
	}

	public BigDecimal getInitQty() {
		return this.initQty;
	}

	public void setInitQty(BigDecimal initQty) {
		this.initQty = initQty;
	}

	public BigDecimal getInitWeight() {
		return this.initWeight;
	}

	public void setInitWeight(BigDecimal initWeight) {
		this.initWeight = initWeight;
	}

	public String getIsAutoDisplay() {
		return this.isAutoDisplay;
	}

	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}

	public String getIsAutoToTrans() {
		return this.isAutoToTrans;
	}

	public void setIsAutoToTrans(String isAutoToTrans) {
		this.isAutoToTrans = isAutoToTrans;
	}

	public String getJsType() {
		return this.jsType;
	}

	public void setJsType(String jsType) {
		this.jsType = jsType;
	}

	public String getLimitTime() {
		return this.limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public BigDecimal getListingPrice() {
		return this.listingPrice;
	}

	public void setListingPrice(BigDecimal listingPrice) {
		this.listingPrice = listingPrice;
	}

	public String getLogisticsMark() {
		return this.logisticsMark;
	}

	public void setLogisticsMark(String logisticsMark) {
		this.logisticsMark = logisticsMark;
	}

	public BigDecimal getLossRatio() {
		return this.lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public String getLossType() {
		return this.lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public BigDecimal getLossWeight() {
		return this.lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public BigDecimal getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getOilAmount() {
		return this.oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getOilFlag() {
		return this.oilFlag;
	}

	public void setOilFlag(String oilFlag) {
		this.oilFlag = oilFlag;
	}

	public BigDecimal getOilRatio() {
		return this.oilRatio;
	}

	public void setOilRatio(BigDecimal oilRatio) {
		this.oilRatio = oilRatio;
	}

	public BigDecimal getOwnerAdjustAmt() {
		return this.ownerAdjustAmt;
	}

	public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
		this.ownerAdjustAmt = ownerAdjustAmt;
	}

	public String getOwnerAdjustFlag() {
		return this.ownerAdjustFlag;
	}

	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}

	public String getOwnerAdjustType() {
		return this.ownerAdjustType;
	}

	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}

	public String getPickUpGoodsName() {
		return this.pickUpGoodsName;
	}

	public void setPickUpGoodsName(String pickUpGoodsName) {
		this.pickUpGoodsName = pickUpGoodsName;
	}

	public Date getPickupDate() {
		return this.pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Integer getPinDanNum() {
		return this.pinDanNum;
	}

	public void setPinDanNum(Integer pinDanNum) {
		this.pinDanNum = pinDanNum;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getPriPublishId() {
		return this.priPublishId;
	}

	public void setPriPublishId(Long priPublishId) {
		this.priPublishId = priPublishId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceTax() {
		return this.priceTax;
	}

	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}

	public Integer getPriceTimeCycle() {
		return this.priceTimeCycle;
	}

	public void setPriceTimeCycle(Integer priceTimeCycle) {
		this.priceTimeCycle = priceTimeCycle;
	}

	public String getProdArea() {
		return this.prodArea;
	}

	public void setProdArea(String prodArea) {
		this.prodArea = prodArea;
	}

	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getPs() {
		return this.ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getPs1() {
		return this.ps1;
	}

	public void setPs1(String ps1) {
		this.ps1 = ps1;
	}

	public String getPs2() {
		return this.ps2;
	}

	public void setPs2(String ps2) {
		this.ps2 = ps2;
	}

	public String getPs3() {
		return this.ps3;
	}

	public void setPs3(String ps3) {
		this.ps3 = ps3;
	}

	public String getPs4() {
		return this.ps4;
	}

	public void setPs4(String ps4) {
		this.ps4 = ps4;
	}

	public String getPs5() {
		return this.ps5;
	}

	public void setPs5(String ps5) {
		this.ps5 = ps5;
	}

	public String getPublishNum() {
		return this.publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public String getQbType() {
		return this.qbType;
	}

	public void setQbType(String qbType) {
		this.qbType = qbType;
	}

	public BigDecimal getQty() {
		return this.qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverMobile() {
		return this.receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getRovokeWeight() {
		return this.rovokeWeight;
	}

	public void setRovokeWeight(BigDecimal rovokeWeight) {
		this.rovokeWeight = rovokeWeight;
	}

	public BigDecimal getSaleAmount() {
		return this.saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getSaleQty() {
		return this.saleQty;
	}

	public void setSaleQty(BigDecimal saleQty) {
		this.saleQty = saleQty;
	}

	public BigDecimal getSaleWeight() {
		return this.saleWeight;
	}

	public void setSaleWeight(BigDecimal saleWeight) {
		this.saleWeight = saleWeight;
	}

	public String getSendGroup() {
		return this.sendGroup;
	}

	public void setSendGroup(String sendGroup) {
		this.sendGroup = sendGroup;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderMobile() {
		return this.senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public Integer getSendKM() {
		return this.sendKM;
	}

	public void setSendKM(Integer sendKM) {
		this.sendKM = sendKM;
	}

	public BigDecimal getSingleCarWeight() {
		return this.singleCarWeight;
	}

	public void setSingleCarWeight(BigDecimal singleCarWeight) {
		this.singleCarWeight = singleCarWeight;
	}

	public BigDecimal getStandardTax() {
		return this.standardTax;
	}

	public void setStandardTax(BigDecimal standardTax) {
		this.standardTax = standardTax;
	}

	public String getStartPlate() {
		return this.startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getStartPlateCity() {
		return this.startPlateCity;
	}

	public void setStartPlateCity(String startPlateCity) {
		this.startPlateCity = startPlateCity;
	}

	public String getStartPlateCountry() {
		return this.startPlateCountry;
	}

	public void setStartPlateCountry(String startPlateCountry) {
		this.startPlateCountry = startPlateCountry;
	}

	public String getStartPlateProvince() {
		return this.startPlateProvince;
	}

	public void setStartPlateProvince(String startPlateProvince) {
		this.startPlateProvince = startPlateProvince;
	}

	public Date getStartTakeDeliveryDate() {
		return this.startTakeDeliveryDate;
	}

	public void setStartTakeDeliveryDate(Date startTakeDeliveryDate) {
		this.startTakeDeliveryDate = startTakeDeliveryDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTakeDeliveryDate() {
		return this.takeDeliveryDate;
	}

	public void setTakeDeliveryDate(Date takeDeliveryDate) {
		this.takeDeliveryDate = takeDeliveryDate;
	}

	public String getTakeType() {
		return this.takeType;
	}

	public void setTakeType(String takeType) {
		this.takeType = takeType;
	}

	public Date getTmingRelease() {
		return this.tmingRelease;
	}

	public void setTmingRelease(Date tmingRelease) {
		this.tmingRelease = tmingRelease;
	}

	public Date getUpdateDate() {
		return this.updateDate;
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
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVatFlowMasterId() {
		return this.vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public String getVehicleStyleVar() {
		return this.vehicleStyleVar;
	}

	public void setVehicleStyleVar(String vehicleStyleVar) {
		this.vehicleStyleVar = vehicleStyleVar;
	}

	public String getWebCanGrab() {
		return this.webCanGrab;
	}

	public void setWebCanGrab(String webCanGrab) {
		this.webCanGrab = webCanGrab;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}


	public Integer getAppointCompanyId() {
		return appointCompanyId;
	}


	public void setAppointCompanyId(Integer appointCompanyId) {
		this.appointCompanyId = appointCompanyId;
	}


	public BigDecimal getFloorPrice() {
		return floorPrice;
	}


	public void setFloorPrice(BigDecimal floorPrice) {
		this.floorPrice = floorPrice;
	}


	public String getIfAudit() {
		return ifAudit;
	}


	public void setIfAudit(String ifAudit) {
		this.ifAudit = ifAudit;
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

	public String getAddWeightFlag() {
		return addWeightFlag;
	}

	public void setAddWeightFlag(String addWeightFlag) {
		this.addWeightFlag = addWeightFlag;
	}

	public String getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}

	public Integer getMaxTransDays() {
		return maxTransDays;
	}

	public void setMaxTransDays(Integer maxTransDays) {
		this.maxTransDays = maxTransDays;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getRobDeliveryType() {
		return robDeliveryType;
	}

	public void setRobDeliveryType(String robDeliveryType) {
		this.robDeliveryType = robDeliveryType;
	}
}