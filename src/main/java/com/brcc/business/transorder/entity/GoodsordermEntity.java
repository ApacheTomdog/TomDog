package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-01 16:24
 */
@Entity
@Table(name = "goodsorderm")
public class GoodsordermEntity {

    private Long publishId;
    private String publishNum;
    private BigDecimal weight;
    private BigDecimal qty;
    private BigDecimal amount;
    private String status;
    private String platformId;
    private Date createDate;
    private String limitTime;
    private String remark;
    private String dependNum;
    private BigDecimal price;
    private String startPlate;
    private String getOrderPlate;
    private String endPlate;
    private String departure;
    private String destination;
    private String getOrderAddress;
    private Long companyId;
    private Long userId;
    private BigDecimal departureLng;
    private BigDecimal departureLat;
    private BigDecimal destinationLng;
    private BigDecimal destinationLat;
    private BigDecimal getOrderAddressLng;
    private BigDecimal getOrderAddressLat;
    private Integer sendKm;
    private String sender;
    private String senderMobile;
    private String receiverMobile;
    private String receiver;
    private Integer goodType;
    private String goodTypeDesc;
    private String billSender;
    private String billSenderMobile;
    private String billTaker;
    private String billTakerMobile;
    private String detachable;
    private BigDecimal heavyPiece;
    private String ifConfirm;
    private BigDecimal initWeight;
    private BigDecimal initQty;
    private BigDecimal initAmount;
    private Date pickupDate;
    private String vehicleStyleVar;
    private String prodDesc;
    private Long appointCompanyId;
    private String ifPartition;
    private BigDecimal saleWeight;
    private BigDecimal saleQty;
    private BigDecimal saleAmount;
    private String dependNum2;
    private String qbType;
    private BigDecimal floorPrice;
    private String ifAutoConfirm;
    private String ifShowFloorPrice;
    private Integer priceTimeCycle;
    private Integer bidTimes;
    private String startPlateProvince;
    private String startPlateCity;
    private String startPlateCountry;
    private String getOrderPlateProvince;
    private String getOrderPlateCity;
    private String getOrderPlateCountry;
    private String endPlateProvince;
    private String endPlateCity;
    private String endPlateCountry;
    private String appointTeamId;
    private String sendGroup;
    private BigDecimal maxPrice;
    private BigDecimal estimateKm;
    private String ifBjToQd;
    private String appointTeamType;
    private String ps;
    private String fromType;
    private String isAutoToTrans;
    private String webCanGrab;
    private String ps2;
    private String ps3;
    private String ps4;
    private String ps5;
    private String ps1;
    private String docuType;
    private String docuPriSec;
    private Long priPublishId;
    private Integer combinedNumber;
    private Integer pinDanNum;
    private BigDecimal singleCarWeight;
    private Long fdUserId;
    private String ifCanShow;
    private Long goodsOwnerId;
    private Date takeDeliveryDate;
    private Date tmingRelease;
    private String importId;
    private Date startTakeDeliveryDate;
    private String lossType;
    private BigDecimal lossRatio;
    private BigDecimal lossWeight;
    private BigDecimal goodPrice;
    private BigDecimal rovokeWeight;
    private String takeType;
    private String entrustCompany;
    private String ifAutoTransSys;
    private String ifFragment;
    private String updatePerson;
    private Date updateDate;
    private String appointPersonInfo;
    private String jsType;
    private String isAutoDisplay;
    private String dsIfSettle;
    private String prodArea;
    private BigDecimal priceTax;
    private BigDecimal standardTax;
    private String ifTaxTransport;
    private Long vatFlowMasterId;
    private Date adjustPriceDate;
    private Long adjustPersonId;
    private String adjustPersonName;
    private BigDecimal listingPrice;
    private BigDecimal chargePrice;
    private String chargePriceType;
    private String ifPayment;
    private String pickUpGoodsName;
    private String logisticsMark;
    private String fromPlatName;
    private String oilFlag;
    private Integer oilAmount;
    private BigDecimal oilRatio;
    private Long groupId;
    private String groupName;
    private Integer ifSavePublish;
    private String ifAutoPrice;
    private String ownerAdjustFlag;
    private String ownerAdjustType;
    private BigDecimal ownerAdjustAmt;
    private String dqFlag;
    private Date dqSttDate;
    private Date dqEndDate;
    private Long catalogId;
    private String catalogName;
    private String ifOwnerTaxpriceMf;
    private String asdsMark;
    private String dsDzFlag;
	private String contractNumber;
	private String ifAudit;

	@Id
    @Column(name = "publish_id", nullable = false)
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "publish_num", nullable = true, length = 20)
    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 6)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "qty", nullable = true, precision = 6)
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 6)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "platform_id", nullable = true, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "limit_time", nullable = true, length = 20)
    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 3000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "depend_num", nullable = true, length = 40)
    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "start_plate", nullable = true, length = 200)
    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    @Basic
    @Column(name = "get_order_plate", nullable = true, length = 200)
    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
    }

    @Basic
    @Column(name = "end_plate", nullable = true, length = 200)
    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    @Basic
    @Column(name = "departure", nullable = true, length = 300)
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "destination", nullable = true, length = 300)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "get_order_address", nullable = true, length = 300)
    public String getGetOrderAddress() {
        return getOrderAddress;
    }

    public void setGetOrderAddress(String getOrderAddress) {
        this.getOrderAddress = getOrderAddress;
    }

    @Basic
    @Column(name = "company_id", nullable = true)
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "departure_lng", nullable = true, precision = 10)
    public BigDecimal getDepartureLng() {
        return departureLng;
    }

    public void setDepartureLng(BigDecimal departureLng) {
        this.departureLng = departureLng;
    }

    @Basic
    @Column(name = "departure_lat", nullable = true, precision = 10)
    public BigDecimal getDepartureLat() {
        return departureLat;
    }

    public void setDepartureLat(BigDecimal departureLat) {
        this.departureLat = departureLat;
    }

    @Basic
    @Column(name = "destination_lng", nullable = true, precision = 10)
    public BigDecimal getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(BigDecimal destinationLng) {
        this.destinationLng = destinationLng;
    }

    @Basic
    @Column(name = "destination_lat", nullable = true, precision = 10)
    public BigDecimal getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(BigDecimal destinationLat) {
        this.destinationLat = destinationLat;
    }

    @Basic
    @Column(name = "get_order_address_lng", nullable = true, precision = 10)
    public BigDecimal getGetOrderAddressLng() {
        return getOrderAddressLng;
    }

    public void setGetOrderAddressLng(BigDecimal getOrderAddressLng) {
        this.getOrderAddressLng = getOrderAddressLng;
    }

    @Basic
    @Column(name = "get_order_address_lat", nullable = true, precision = 10)
    public BigDecimal getGetOrderAddressLat() {
        return getOrderAddressLat;
    }

    public void setGetOrderAddressLat(BigDecimal getOrderAddressLat) {
        this.getOrderAddressLat = getOrderAddressLat;
    }

    @Basic
    @Column(name = "sendKM", nullable = true)
    public Integer getSendKm() {
        return sendKm;
    }

    public void setSendKm(Integer sendKm) {
        this.sendKm = sendKm;
    }

    @Basic
    @Column(name = "sender", nullable = true, length = 50)
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "sender_mobile", nullable = true, length = 20)
    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    @Basic
    @Column(name = "receiver_mobile", nullable = true, length = 20)
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    @Basic
    @Column(name = "receiver", nullable = true, length = 20)
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "good_type", nullable = true)
    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    @Basic
    @Column(name = "good_type_desc", nullable = true, length = 20)
    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    @Basic
    @Column(name = "bill_sender", nullable = true, length = 20)
    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    @Basic
    @Column(name = "bill_sender_mobile", nullable = true, length = 20)
    public String getBillSenderMobile() {
        return billSenderMobile;
    }

    public void setBillSenderMobile(String billSenderMobile) {
        this.billSenderMobile = billSenderMobile;
    }

    @Basic
    @Column(name = "bill_taker", nullable = true, length = 20)
    public String getBillTaker() {
        return billTaker;
    }

    public void setBillTaker(String billTaker) {
        this.billTaker = billTaker;
    }

    @Basic
    @Column(name = "bill_taker_mobile", nullable = true, length = 20)
    public String getBillTakerMobile() {
        return billTakerMobile;
    }

    public void setBillTakerMobile(String billTakerMobile) {
        this.billTakerMobile = billTakerMobile;
    }

    @Basic
    @Column(name = "detachable", nullable = false, length = 1)
    public String getDetachable() {
        return detachable;
    }

    public void setDetachable(String detachable) {
        this.detachable = detachable;
    }

    @Basic
    @Column(name = "heavy_piece", nullable = true, precision = 3)
    public BigDecimal getHeavyPiece() {
        return heavyPiece;
    }

    public void setHeavyPiece(BigDecimal heavyPiece) {
        this.heavyPiece = heavyPiece;
    }

    @Basic
    @Column(name = "if_confirm", nullable = false, length = 1)
    public String getIfConfirm() {
        return ifConfirm;
    }

    public void setIfConfirm(String ifConfirm) {
        this.ifConfirm = ifConfirm;
    }

    @Basic
    @Column(name = "init_weight", nullable = true, precision = 6)
    public BigDecimal getInitWeight() {
        return initWeight;
    }

    public void setInitWeight(BigDecimal initWeight) {
        this.initWeight = initWeight;
    }

    @Basic
    @Column(name = "init_qty", nullable = true, precision = 6)
    public BigDecimal getInitQty() {
        return initQty;
    }

    public void setInitQty(BigDecimal initQty) {
        this.initQty = initQty;
    }

    @Basic
    @Column(name = "init_amount", nullable = true, precision = 6)
    public BigDecimal getInitAmount() {
        return initAmount;
    }

    public void setInitAmount(BigDecimal initAmount) {
        this.initAmount = initAmount;
    }

    @Basic
    @Column(name = "pickup_date", nullable = true)
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    @Basic
    @Column(name = "vehicle_style_var", nullable = true, length = 200)
    public String getVehicleStyleVar() {
        return vehicleStyleVar;
    }

    public void setVehicleStyleVar(String vehicleStyleVar) {
        this.vehicleStyleVar = vehicleStyleVar;
    }

    @Basic
    @Column(name = "prod_desc", nullable = true, length = 200)
    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    @Basic
    @Column(name = "appoint_company_id", nullable = true)
    public Long getAppointCompanyId() {
        return appointCompanyId;
    }

    public void setAppointCompanyId(Long appointCompanyId) {
        this.appointCompanyId = appointCompanyId;
    }

    @Basic
    @Column(name = "if_partition", nullable = true, length = 20)
    public String getIfPartition() {
        return ifPartition;
    }

    public void setIfPartition(String ifPartition) {
        this.ifPartition = ifPartition;
    }

    @Basic
    @Column(name = "sale_weight", nullable = true, precision = 6)
    public BigDecimal getSaleWeight() {
        return saleWeight;
    }

    public void setSaleWeight(BigDecimal saleWeight) {
        this.saleWeight = saleWeight;
    }

    @Basic
    @Column(name = "sale_qty", nullable = true, precision = 6)
    public BigDecimal getSaleQty() {
        return saleQty;
    }

    public void setSaleQty(BigDecimal saleQty) {
        this.saleQty = saleQty;
    }

    @Basic
    @Column(name = "sale_amount", nullable = true, precision = 6)
    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    @Basic
    @Column(name = "depend_num2", nullable = true, length = 40)
    public String getDependNum2() {
        return dependNum2;
    }

    public void setDependNum2(String dependNum2) {
        this.dependNum2 = dependNum2;
    }

    @Basic
    @Column(name = "qb_type", nullable = true, length = 1)
    public String getQbType() {
        return qbType;
    }

    public void setQbType(String qbType) {
        this.qbType = qbType;
    }

    @Basic
    @Column(name = "floor_price", nullable = true, precision = 6)
    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    @Basic
    @Column(name = "if_auto_confirm", nullable = true, length = 1)
    public String getIfAutoConfirm() {
        return ifAutoConfirm;
    }

    public void setIfAutoConfirm(String ifAutoConfirm) {
        this.ifAutoConfirm = ifAutoConfirm;
    }

    @Basic
    @Column(name = "if_show_floor_price", nullable = true, length = 1)
    public String getIfShowFloorPrice() {
        return ifShowFloorPrice;
    }

    public void setIfShowFloorPrice(String ifShowFloorPrice) {
        this.ifShowFloorPrice = ifShowFloorPrice;
    }

    @Basic
    @Column(name = "price_time_cycle", nullable = true)
    public Integer getPriceTimeCycle() {
        return priceTimeCycle;
    }

    public void setPriceTimeCycle(Integer priceTimeCycle) {
        this.priceTimeCycle = priceTimeCycle;
    }

    @Basic
    @Column(name = "bid_times", nullable = true)
    public Integer getBidTimes() {
        return bidTimes;
    }

    public void setBidTimes(Integer bidTimes) {
        this.bidTimes = bidTimes;
    }

    @Basic
    @Column(name = "start_plate_province", nullable = true, length = 30)
    public String getStartPlateProvince() {
        return startPlateProvince;
    }

    public void setStartPlateProvince(String startPlateProvince) {
        this.startPlateProvince = startPlateProvince;
    }

    @Basic
    @Column(name = "start_plate_city", nullable = true, length = 40)
    public String getStartPlateCity() {
        return startPlateCity;
    }

    public void setStartPlateCity(String startPlateCity) {
        this.startPlateCity = startPlateCity;
    }

    @Basic
    @Column(name = "start_plate_country", nullable = true, length = 50)
    public String getStartPlateCountry() {
        return startPlateCountry;
    }

    public void setStartPlateCountry(String startPlateCountry) {
        this.startPlateCountry = startPlateCountry;
    }

    @Basic
    @Column(name = "get_order_plate_province", nullable = true, length = 30)
    public String getGetOrderPlateProvince() {
        return getOrderPlateProvince;
    }

    public void setGetOrderPlateProvince(String getOrderPlateProvince) {
        this.getOrderPlateProvince = getOrderPlateProvince;
    }

    @Basic
    @Column(name = "get_order_plate_city", nullable = true, length = 40)
    public String getGetOrderPlateCity() {
        return getOrderPlateCity;
    }

    public void setGetOrderPlateCity(String getOrderPlateCity) {
        this.getOrderPlateCity = getOrderPlateCity;
    }

    @Basic
    @Column(name = "get_order_plate_country", nullable = true, length = 50)
    public String getGetOrderPlateCountry() {
        return getOrderPlateCountry;
    }

    public void setGetOrderPlateCountry(String getOrderPlateCountry) {
        this.getOrderPlateCountry = getOrderPlateCountry;
    }

    @Basic
    @Column(name = "end_plate_province", nullable = true, length = 30)
    public String getEndPlateProvince() {
        return endPlateProvince;
    }

    public void setEndPlateProvince(String endPlateProvince) {
        this.endPlateProvince = endPlateProvince;
    }

    @Basic
    @Column(name = "end_plate_city", nullable = true, length = 40)
    public String getEndPlateCity() {
        return endPlateCity;
    }

    public void setEndPlateCity(String endPlateCity) {
        this.endPlateCity = endPlateCity;
    }

    @Basic
    @Column(name = "end_plate_country", nullable = true, length = 50)
    public String getEndPlateCountry() {
        return endPlateCountry;
    }

    public void setEndPlateCountry(String endPlateCountry) {
        this.endPlateCountry = endPlateCountry;
    }

    @Basic
    @Column(name = "appoint_team_id", nullable = false, length = 20)
    public String getAppointTeamId() {
        return appointTeamId;
    }

    public void setAppointTeamId(String appointTeamId) {
        this.appointTeamId = appointTeamId;
    }

    @Basic
    @Column(name = "send_group", nullable = false, length = 3)
    public String getSendGroup() {
        return sendGroup;
    }

    public void setSendGroup(String sendGroup) {
        this.sendGroup = sendGroup;
    }

    @Basic
    @Column(name = "max_price", nullable = true, precision = 6)
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "estimateKM", nullable = true, precision = 6)
    public BigDecimal getEstimateKm() {
        return estimateKm;
    }

    public void setEstimateKm(BigDecimal estimateKm) {
        this.estimateKm = estimateKm;
    }

    @Basic
    @Column(name = "if_bj_to_qd", nullable = true, length = 1)
    public String getIfBjToQd() {
        return ifBjToQd;
    }

    public void setIfBjToQd(String ifBjToQd) {
        this.ifBjToQd = ifBjToQd;
    }

    @Basic
    @Column(name = "appoint_team_type", nullable = false, length = 2)
    public String getAppointTeamType() {
        return appointTeamType;
    }

    public void setAppointTeamType(String appointTeamType) {
        this.appointTeamType = appointTeamType;
    }

    @Basic
    @Column(name = "ps", nullable = true, length = 500)
    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Basic
    @Column(name = "from_type", nullable = true, length = 20)
    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    @Basic
    @Column(name = "is_auto_to_trans", nullable = true, length = 2)
    public String getIsAutoToTrans() {
        return isAutoToTrans;
    }

    public void setIsAutoToTrans(String isAutoToTrans) {
        this.isAutoToTrans = isAutoToTrans;
    }

    @Basic
    @Column(name = "web_can_grab", nullable = true, length = 2)
    public String getWebCanGrab() {
        return webCanGrab;
    }

    public void setWebCanGrab(String webCanGrab) {
        this.webCanGrab = webCanGrab;
    }

    @Basic
    @Column(name = "ps2", nullable = true, length = 500)
    public String getPs2() {
        return ps2;
    }

    public void setPs2(String ps2) {
        this.ps2 = ps2;
    }

    @Basic
    @Column(name = "ps3", nullable = true, length = 500)
    public String getPs3() {
        return ps3;
    }

    public void setPs3(String ps3) {
        this.ps3 = ps3;
    }

    @Basic
    @Column(name = "ps4", nullable = true, length = 500)
    public String getPs4() {
        return ps4;
    }

    public void setPs4(String ps4) {
        this.ps4 = ps4;
    }

    @Basic
    @Column(name = "ps5", nullable = true, length = 1000)
    public String getPs5() {
        return ps5;
    }

    public void setPs5(String ps5) {
        this.ps5 = ps5;
    }

    @Basic
    @Column(name = "ps1", nullable = true, length = 500)
    public String getPs1() {
        return ps1;
    }

    public void setPs1(String ps1) {
        this.ps1 = ps1;
    }

    @Basic
    @Column(name = "docu_type", nullable = true, length = 1)
    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
    }

    @Basic
    @Column(name = "docu_pri_sec", nullable = true, length = 2)
    public String getDocuPriSec() {
        return docuPriSec;
    }

    public void setDocuPriSec(String docuPriSec) {
        this.docuPriSec = docuPriSec;
    }

    @Basic
    @Column(name = "pri_publish_id", nullable = true)
    public Long getPriPublishId() {
        return priPublishId;
    }

    public void setPriPublishId(Long priPublishId) {
        this.priPublishId = priPublishId;
    }

    @Basic
    @Column(name = "combined_number", nullable = true)
    public Integer getCombinedNumber() {
        return combinedNumber;
    }

    public void setCombinedNumber(Integer combinedNumber) {
        this.combinedNumber = combinedNumber;
    }

    @Basic
    @Column(name = "pin_dan_num", nullable = true)
    public Integer getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(Integer pinDanNum) {
        this.pinDanNum = pinDanNum;
    }

    @Basic
    @Column(name = "single_car_weight", nullable = true, precision = 0)
    public BigDecimal getSingleCarWeight() {
        return singleCarWeight;
    }

    public void setSingleCarWeight(BigDecimal singleCarWeight) {
        this.singleCarWeight = singleCarWeight;
    }

    @Basic
    @Column(name = "fd_user_id", nullable = true)
    public Long getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(Long fdUserId) {
        this.fdUserId = fdUserId;
    }

    @Basic
    @Column(name = "if_can_show", nullable = true, length = 1)
    public String getIfCanShow() {
        return ifCanShow;
    }

    public void setIfCanShow(String ifCanShow) {
        this.ifCanShow = ifCanShow;
    }

    @Basic
    @Column(name = "goods_owner_id", nullable = true)
    public Long getGoodsOwnerId() {
        return goodsOwnerId;
    }

    public void setGoodsOwnerId(Long goodsOwnerId) {
        this.goodsOwnerId = goodsOwnerId;
    }

    @Basic
    @Column(name = "take_delivery_date", nullable = true)
    public Date getTakeDeliveryDate() {
        return takeDeliveryDate;
    }

    public void setTakeDeliveryDate(Date takeDeliveryDate) {
        this.takeDeliveryDate = takeDeliveryDate;
    }

    @Basic
    @Column(name = "tming_release", nullable = true)
    public Date getTmingRelease() {
        return tmingRelease;
    }

    public void setTmingRelease(Date tmingRelease) {
        this.tmingRelease = tmingRelease;
    }

    @Basic
    @Column(name = "import_id", nullable = true, length = 20)
    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    @Basic
    @Column(name = "start_take_delivery_date", nullable = true)
    public Date getStartTakeDeliveryDate() {
        return startTakeDeliveryDate;
    }

    public void setStartTakeDeliveryDate(Date startTakeDeliveryDate) {
        this.startTakeDeliveryDate = startTakeDeliveryDate;
    }

    @Basic
    @Column(name = "loss_type", nullable = true, length = 1)
    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    @Basic
    @Column(name = "loss_ratio", nullable = true, precision = 3)
    public BigDecimal getLossRatio() {
        return lossRatio;
    }

    public void setLossRatio(BigDecimal lossRatio) {
        this.lossRatio = lossRatio;
    }

    @Basic
    @Column(name = "loss_weight", nullable = true, precision = 4)
    public BigDecimal getLossWeight() {
        return lossWeight;
    }

    public void setLossWeight(BigDecimal lossWeight) {
        this.lossWeight = lossWeight;
    }

    @Basic
    @Column(name = "good_price", nullable = true, precision = 2)
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    @Basic
    @Column(name = "rovoke_weight", nullable = true, precision = 0)
    public BigDecimal getRovokeWeight() {
        return rovokeWeight;
    }

    public void setRovokeWeight(BigDecimal rovokeWeight) {
        this.rovokeWeight = rovokeWeight;
    }

    @Basic
    @Column(name = "take_type", nullable = true, length = 2)
    public String getTakeType() {
        return takeType;
    }

    public void setTakeType(String takeType) {
        this.takeType = takeType;
    }

    @Basic
    @Column(name = "entrust_company", nullable = true, length = 20)
    public String getEntrustCompany() {
        return entrustCompany;
    }

    public void setEntrustCompany(String entrustCompany) {
        this.entrustCompany = entrustCompany;
    }

    @Basic
    @Column(name = "if_auto_trans_sys", nullable = true, length = 1)
    public String getIfAutoTransSys() {
        return ifAutoTransSys;
    }

    public void setIfAutoTransSys(String ifAutoTransSys) {
        this.ifAutoTransSys = ifAutoTransSys;
    }

    @Basic
    @Column(name = "if_fragment", nullable = true, length = 1)
    public String getIfFragment() {
        return ifFragment;
    }

    public void setIfFragment(String ifFragment) {
        this.ifFragment = ifFragment;
    }

    @Basic
    @Column(name = "update_person", nullable = true, length = 45)
    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "appoint_person_info", nullable = true, length = 200)
    public String getAppointPersonInfo() {
        return appointPersonInfo;
    }

    public void setAppointPersonInfo(String appointPersonInfo) {
        this.appointPersonInfo = appointPersonInfo;
    }

    @Basic
    @Column(name = "js_type", nullable = true, length = 2)
    public String getJsType() {
        return jsType;
    }

    public void setJsType(String jsType) {
        this.jsType = jsType;
    }

    @Basic
    @Column(name = "is_auto_display", nullable = true, length = 1)
    public String getIsAutoDisplay() {
        return isAutoDisplay;
    }

    public void setIsAutoDisplay(String isAutoDisplay) {
        this.isAutoDisplay = isAutoDisplay;
    }

    @Basic
    @Column(name = "ds_if_settle", nullable = true, length = 1)
    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

    @Basic
    @Column(name = "prod_area", nullable = true, length = 50)
    public String getProdArea() {
        return prodArea;
    }

    public void setProdArea(String prodArea) {
        this.prodArea = prodArea;
    }

    @Basic
    @Column(name = "price_tax", nullable = true, precision = 2)
    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
    }

    @Basic
    @Column(name = "standard_tax", nullable = true, precision = 6)
    public BigDecimal getStandardTax() {
        return standardTax;
    }

    public void setStandardTax(BigDecimal standardTax) {
        this.standardTax = standardTax;
    }

    @Basic
    @Column(name = "if_tax_transport", nullable = true, length = 1)
    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
    }

    @Basic
    @Column(name = "vat_flow_master_id", nullable = true)
    public Long getVatFlowMasterId() {
        return vatFlowMasterId;
    }

    public void setVatFlowMasterId(Long vatFlowMasterId) {
        this.vatFlowMasterId = vatFlowMasterId;
    }

    @Basic
    @Column(name = "adjust_price_date", nullable = true)
    public Date getAdjustPriceDate() {
        return adjustPriceDate;
    }

    public void setAdjustPriceDate(Date adjustPriceDate) {
        this.adjustPriceDate = adjustPriceDate;
    }

    @Basic
    @Column(name = "adjust_person_id", nullable = true)
    public Long getAdjustPersonId() {
        return adjustPersonId;
    }

    public void setAdjustPersonId(Long adjustPersonId) {
        this.adjustPersonId = adjustPersonId;
    }

    @Basic
    @Column(name = "adjust_person_name", nullable = true, length = 100)
    public String getAdjustPersonName() {
        return adjustPersonName;
    }

    public void setAdjustPersonName(String adjustPersonName) {
        this.adjustPersonName = adjustPersonName;
    }

    @Basic
    @Column(name = "listing_price", nullable = true, precision = 2)
    public BigDecimal getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(BigDecimal listingPrice) {
        this.listingPrice = listingPrice;
    }

    @Basic
    @Column(name = "charge_price", nullable = true, precision = 2)
    public BigDecimal getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(BigDecimal chargePrice) {
        this.chargePrice = chargePrice;
    }

    @Basic
    @Column(name = "charge_price_type", nullable = true, length = 1)
    public String getChargePriceType() {
        return chargePriceType;
    }

    public void setChargePriceType(String chargePriceType) {
        this.chargePriceType = chargePriceType;
    }

    @Basic
    @Column(name = "if_payment", nullable = true, length = 1)
    public String getIfPayment() {
        return ifPayment;
    }

    public void setIfPayment(String ifPayment) {
        this.ifPayment = ifPayment;
    }

    @Basic
    @Column(name = "pick_up_goods_name", nullable = true, length = 50)
    public String getPickUpGoodsName() {
        return pickUpGoodsName;
    }

    public void setPickUpGoodsName(String pickUpGoodsName) {
        this.pickUpGoodsName = pickUpGoodsName;
    }

    @Basic
    @Column(name = "logistics_mark", nullable = true, length = 1)
    public String getLogisticsMark() {
        return logisticsMark;
    }

    public void setLogisticsMark(String logisticsMark) {
        this.logisticsMark = logisticsMark;
    }

    @Basic
    @Column(name = "from_plat_name", nullable = true, length = 50)
    public String getFromPlatName() {
        return fromPlatName;
    }

    public void setFromPlatName(String fromPlatName) {
        this.fromPlatName = fromPlatName;
    }

    @Basic
    @Column(name = "oil_flag", nullable = true, length = 1)
    public String getOilFlag() {
        return oilFlag;
    }

    public void setOilFlag(String oilFlag) {
        this.oilFlag = oilFlag;
    }

    @Basic
    @Column(name = "oil_amount", nullable = true, precision = 0)
    public Integer getOilAmount() {
        return oilAmount;
    }

    public void setOilAmount(Integer oilAmount) {
        this.oilAmount = oilAmount;
    }

    @Basic
    @Column(name = "oil_ratio", nullable = true, precision = 2)
    public BigDecimal getOilRatio() {
        return oilRatio;
    }

    public void setOilRatio(BigDecimal oilRatio) {
        this.oilRatio = oilRatio;
    }

    @Basic
    @Column(name = "group_id", nullable = true)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name", nullable = true, length = 100)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "if_save_publish", nullable = true)
    public Integer getIfSavePublish() {
        return ifSavePublish;
    }

    public void setIfSavePublish(Integer ifSavePublish) {
        this.ifSavePublish = ifSavePublish;
    }

    @Basic
    @Column(name = "if_auto_price", nullable = true, length = 1)
    public String getIfAutoPrice() {
        return ifAutoPrice;
    }

    public void setIfAutoPrice(String ifAutoPrice) {
        this.ifAutoPrice = ifAutoPrice;
    }

    @Basic
    @Column(name = "owner_adjust_flag", nullable = true, length = 1)
    public String getOwnerAdjustFlag() {
        return ownerAdjustFlag;
    }

    public void setOwnerAdjustFlag(String ownerAdjustFlag) {
        this.ownerAdjustFlag = ownerAdjustFlag;
    }

    @Basic
    @Column(name = "owner_adjust_type", nullable = true, length = 2)
    public String getOwnerAdjustType() {
        return ownerAdjustType;
    }

    public void setOwnerAdjustType(String ownerAdjustType) {
        this.ownerAdjustType = ownerAdjustType;
    }

    @Basic
    @Column(name = "owner_adjust_amt", nullable = true, precision = 2)
    public BigDecimal getOwnerAdjustAmt() {
        return ownerAdjustAmt;
    }

    public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
        this.ownerAdjustAmt = ownerAdjustAmt;
    }

    @Basic
    @Column(name = "dq_flag", nullable = true, length = 1)
    public String getDqFlag() {
        return dqFlag;
    }

    public void setDqFlag(String dqFlag) {
        this.dqFlag = dqFlag;
    }

    @Basic
    @Column(name = "dq_stt_date", nullable = true)
    public Date getDqSttDate() {
        return dqSttDate;
    }

    public void setDqSttDate(Date dqSttDate) {
        this.dqSttDate = dqSttDate;
    }

    @Basic
    @Column(name = "dq_end_date", nullable = true)
    public Date getDqEndDate() {
        return dqEndDate;
    }

    public void setDqEndDate(Date dqEndDate) {
        this.dqEndDate = dqEndDate;
    }

    @Basic
    @Column(name = "catalog_id", nullable = true)
    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "catalog_name", nullable = true, length = 20)
    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Basic
    @Column(name = "if_owner_taxprice_mf", nullable = true, length = 1)
    public String getIfOwnerTaxpriceMf() {
        return ifOwnerTaxpriceMf;
    }

    public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
        this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
    }

    @Basic
    @Column(name = "asds_mark", nullable = true, length = 1)
    public String getAsdsMark() {
        return asdsMark;
    }

    public void setAsdsMark(String asdsMark) {
        this.asdsMark = asdsMark;
    }

    @Basic
    @Column(name = "ds_dz_flag", nullable = true, length = 1)
    public String getDsDzFlag() {
        return dsDzFlag;
    }

    public void setDsDzFlag(String dsDzFlag) {
        this.dsDzFlag = dsDzFlag;
    }

	@Basic
    @Column(name = "if_audit", nullable = true, length = 1)
	public String getIfAudit() {
		return ifAudit;
	}

	public void setIfAudit(String ifAudit) {
		this.ifAudit = ifAudit;
	}
	
	@Basic
    @Column(name = "contract_number", nullable = true, length = 30)
    public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsordermEntity that = (GoodsordermEntity) o;
        return publishId == that.publishId &&
                Objects.equals(publishNum, that.publishNum) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(status, that.status) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(limitTime, that.limitTime) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(dependNum, that.dependNum) &&
                Objects.equals(price, that.price) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(getOrderPlate, that.getOrderPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(getOrderAddress, that.getOrderAddress) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(departureLng, that.departureLng) &&
                Objects.equals(departureLat, that.departureLat) &&
                Objects.equals(destinationLng, that.destinationLng) &&
                Objects.equals(destinationLat, that.destinationLat) &&
                Objects.equals(getOrderAddressLng, that.getOrderAddressLng) &&
                Objects.equals(getOrderAddressLat, that.getOrderAddressLat) &&
                Objects.equals(sendKm, that.sendKm) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(senderMobile, that.senderMobile) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(billSender, that.billSender) &&
                Objects.equals(billSenderMobile, that.billSenderMobile) &&
                Objects.equals(billTaker, that.billTaker) &&
                Objects.equals(billTakerMobile, that.billTakerMobile) &&
                Objects.equals(detachable, that.detachable) &&
                Objects.equals(heavyPiece, that.heavyPiece) &&
                Objects.equals(ifConfirm, that.ifConfirm) &&
                Objects.equals(initWeight, that.initWeight) &&
                Objects.equals(initQty, that.initQty) &&
                Objects.equals(initAmount, that.initAmount) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(vehicleStyleVar, that.vehicleStyleVar) &&
                Objects.equals(prodDesc, that.prodDesc) &&
                Objects.equals(appointCompanyId, that.appointCompanyId) &&
                Objects.equals(ifPartition, that.ifPartition) &&
                Objects.equals(saleWeight, that.saleWeight) &&
                Objects.equals(saleQty, that.saleQty) &&
                Objects.equals(saleAmount, that.saleAmount) &&
                Objects.equals(dependNum2, that.dependNum2) &&
                Objects.equals(qbType, that.qbType) &&
                Objects.equals(floorPrice, that.floorPrice) &&
                Objects.equals(ifAutoConfirm, that.ifAutoConfirm) &&
                Objects.equals(ifShowFloorPrice, that.ifShowFloorPrice) &&
                Objects.equals(priceTimeCycle, that.priceTimeCycle) &&
                Objects.equals(bidTimes, that.bidTimes) &&
                Objects.equals(startPlateProvince, that.startPlateProvince) &&
                Objects.equals(startPlateCity, that.startPlateCity) &&
                Objects.equals(startPlateCountry, that.startPlateCountry) &&
                Objects.equals(getOrderPlateProvince, that.getOrderPlateProvince) &&
                Objects.equals(getOrderPlateCity, that.getOrderPlateCity) &&
                Objects.equals(getOrderPlateCountry, that.getOrderPlateCountry) &&
                Objects.equals(endPlateProvince, that.endPlateProvince) &&
                Objects.equals(endPlateCity, that.endPlateCity) &&
                Objects.equals(endPlateCountry, that.endPlateCountry) &&
                Objects.equals(appointTeamId, that.appointTeamId) &&
                Objects.equals(sendGroup, that.sendGroup) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(estimateKm, that.estimateKm) &&
                Objects.equals(ifBjToQd, that.ifBjToQd) &&
                Objects.equals(appointTeamType, that.appointTeamType) &&
                Objects.equals(ps, that.ps) &&
                Objects.equals(fromType, that.fromType) &&
                Objects.equals(isAutoToTrans, that.isAutoToTrans) &&
                Objects.equals(webCanGrab, that.webCanGrab) &&
                Objects.equals(ps2, that.ps2) &&
                Objects.equals(ps3, that.ps3) &&
                Objects.equals(ps4, that.ps4) &&
                Objects.equals(ps5, that.ps5) &&
                Objects.equals(ps1, that.ps1) &&
                Objects.equals(docuType, that.docuType) &&
                Objects.equals(docuPriSec, that.docuPriSec) &&
                Objects.equals(priPublishId, that.priPublishId) &&
                Objects.equals(combinedNumber, that.combinedNumber) &&
                Objects.equals(pinDanNum, that.pinDanNum) &&
                Objects.equals(singleCarWeight, that.singleCarWeight) &&
                Objects.equals(fdUserId, that.fdUserId) &&
                Objects.equals(ifCanShow, that.ifCanShow) &&
                Objects.equals(goodsOwnerId, that.goodsOwnerId) &&
                Objects.equals(takeDeliveryDate, that.takeDeliveryDate) &&
                Objects.equals(tmingRelease, that.tmingRelease) &&
                Objects.equals(importId, that.importId) &&
                Objects.equals(startTakeDeliveryDate, that.startTakeDeliveryDate) &&
                Objects.equals(lossType, that.lossType) &&
                Objects.equals(lossRatio, that.lossRatio) &&
                Objects.equals(lossWeight, that.lossWeight) &&
                Objects.equals(goodPrice, that.goodPrice) &&
                Objects.equals(rovokeWeight, that.rovokeWeight) &&
                Objects.equals(takeType, that.takeType) &&
                Objects.equals(entrustCompany, that.entrustCompany) &&
                Objects.equals(ifAutoTransSys, that.ifAutoTransSys) &&
                Objects.equals(ifFragment, that.ifFragment) &&
                Objects.equals(updatePerson, that.updatePerson) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(appointPersonInfo, that.appointPersonInfo) &&
                Objects.equals(jsType, that.jsType) &&
                Objects.equals(isAutoDisplay, that.isAutoDisplay) &&
                Objects.equals(dsIfSettle, that.dsIfSettle) &&
                Objects.equals(prodArea, that.prodArea) &&
                Objects.equals(priceTax, that.priceTax) &&
                Objects.equals(standardTax, that.standardTax) &&
                Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(adjustPriceDate, that.adjustPriceDate) &&
                Objects.equals(adjustPersonId, that.adjustPersonId) &&
                Objects.equals(adjustPersonName, that.adjustPersonName) &&
                Objects.equals(listingPrice, that.listingPrice) &&
                Objects.equals(chargePrice, that.chargePrice) &&
                Objects.equals(chargePriceType, that.chargePriceType) &&
                Objects.equals(ifPayment, that.ifPayment) &&
                Objects.equals(pickUpGoodsName, that.pickUpGoodsName) &&
                Objects.equals(logisticsMark, that.logisticsMark) &&
                Objects.equals(fromPlatName, that.fromPlatName) &&
                Objects.equals(oilFlag, that.oilFlag) &&
                Objects.equals(oilAmount, that.oilAmount) &&
                Objects.equals(oilRatio, that.oilRatio) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(ifSavePublish, that.ifSavePublish) &&
                Objects.equals(ifAutoPrice, that.ifAutoPrice) &&
                Objects.equals(ownerAdjustFlag, that.ownerAdjustFlag) &&
                Objects.equals(ownerAdjustType, that.ownerAdjustType) &&
                Objects.equals(ownerAdjustAmt, that.ownerAdjustAmt) &&
                Objects.equals(dqFlag, that.dqFlag) &&
                Objects.equals(dqSttDate, that.dqSttDate) &&
                Objects.equals(dqEndDate, that.dqEndDate) &&
                Objects.equals(catalogId, that.catalogId) &&
                Objects.equals(catalogName, that.catalogName) &&
                Objects.equals(ifOwnerTaxpriceMf, that.ifOwnerTaxpriceMf) &&
                Objects.equals(asdsMark, that.asdsMark) &&
                Objects.equals(dsDzFlag, that.dsDzFlag) &&
                Objects.equals(contractNumber, that.contractNumber) &&
                Objects.equals(ifAudit, that.ifAudit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(publishId, publishNum, weight, qty, amount, status, platformId, createDate, limitTime, remark, dependNum, price, startPlate, getOrderPlate, endPlate, departure, destination, getOrderAddress, companyId, userId, departureLng, departureLat, destinationLng, destinationLat, getOrderAddressLng, getOrderAddressLat, sendKm, sender, senderMobile, receiverMobile, receiver, goodType, goodTypeDesc, billSender, billSenderMobile, billTaker, billTakerMobile, detachable, heavyPiece, ifConfirm, initWeight, initQty, initAmount, pickupDate, vehicleStyleVar, prodDesc, appointCompanyId, ifPartition, saleWeight, saleQty, saleAmount, dependNum2, qbType, floorPrice, ifAutoConfirm, ifShowFloorPrice, priceTimeCycle, bidTimes, startPlateProvince, startPlateCity, startPlateCountry, getOrderPlateProvince, getOrderPlateCity, getOrderPlateCountry, endPlateProvince, endPlateCity, endPlateCountry, appointTeamId, sendGroup, maxPrice, estimateKm, ifBjToQd, appointTeamType, ps, fromType, isAutoToTrans, webCanGrab, ps2, ps3, ps4, ps5, ps1, docuType, docuPriSec, priPublishId, combinedNumber, pinDanNum, singleCarWeight, fdUserId, ifCanShow, goodsOwnerId, takeDeliveryDate, tmingRelease, importId, startTakeDeliveryDate, lossType, lossRatio, lossWeight, goodPrice, rovokeWeight, takeType, entrustCompany, ifAutoTransSys, ifFragment, updatePerson, updateDate, appointPersonInfo, jsType, isAutoDisplay, dsIfSettle, prodArea, priceTax, standardTax, ifTaxTransport, vatFlowMasterId, adjustPriceDate, adjustPersonId, adjustPersonName, listingPrice, chargePrice, chargePriceType, ifPayment, pickUpGoodsName, logisticsMark, fromPlatName, oilFlag, oilAmount, oilRatio, groupId, groupName, ifSavePublish, ifAutoPrice, ownerAdjustFlag, ownerAdjustType, ownerAdjustAmt, dqFlag, dqSttDate, dqEndDate, catalogId, catalogName, ifOwnerTaxpriceMf, asdsMark, dsDzFlag,contractNumber,ifAudit);
    }
}