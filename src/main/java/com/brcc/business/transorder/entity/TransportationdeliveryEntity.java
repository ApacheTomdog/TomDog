package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-02 9:55
 */
@Entity
@Table(name = "transportationdelivery")
public class TransportationdeliveryEntity {

    private Long deliveryId;
    private String deliveryNum;
    private Long publishId;
    private String publishNum;
    private Long transId;
    private String transNum;
    private BigDecimal weight;
    private BigDecimal amount;
    private Date createDate;
    private Integer companyId;
    private String startPlate;
    private String endPlate;
    private Long driverId;
    private Long vehicleId;
    private Long createPerson;
    private String platformId;
    private String status;
    private BigDecimal departureLng;
    private BigDecimal departureLat;
    private BigDecimal destinationLng;
    private BigDecimal destinationLat;
    private BigDecimal getOrderAddressLng;
    private BigDecimal getOrderAddressLat;
    private String getOrderPlate;
    private String departure;
    private String destination;
    private String getOrderAddress;
    private String sender;
    private String senderMobile;
    private String receiverMobile;
    private String receiver;
    private String billSender;
    private String billSenderMobile;
    private String billTaker;
    private String billTakerMobile;
    private Date updateDate;
    private Long updatePerson;
    private Integer goodType;
    private String goodTypeDesc;
    private BigDecimal qty;
    private BigDecimal price;
    private Date pickupDate;
    private Date billTime;
    private Date deliveryTime;
    private Date finishTime;
    private Integer publishCompanyId;
    private String operateType;
    private String docuSource;
    private BigDecimal settleWeight;
    private BigDecimal settlePrice;
    private BigDecimal settleAmount;
    private String ortherFlag;
    private String loadingId;
    private String ifDriverJudge;
    private String ifFdJudge;
    private String verifyCode;
    private Long fdUserId;
    private String ifCanShow;
    private String ifFeidan;
    private String comfirmPicLocal;
    private String comfirmPicRemote;
    private String receiptVerifyCode;
    private Date receiptOperDate;
    private String remark;
    private Date zcSureDate;
    private Date shSureDate;
    private BigDecimal truckLoadingWeight;
    private BigDecimal takeDeliveryWeight;
    private String settleStatus;
    private String oilCardNo;
    private BigDecimal oilCardAmount;
    private String zfId;
    private String zfNum;
    private Long carryCompanyId;
    private String insuranceFlag;
    private String insuranceNo;
    private BigDecimal insuranceAmount;
    private String comfirmPic1Local;
    private String comfirmPic1Remote;
    private String comfirmPic2Local;
    private String comfirmPic2Remote;
    private Long priPublishId;
    private String ifCyJudge;
    private String jsRemark;
    private String jsType;
    private BigDecimal oilRatio;
    private String payOidId;
    private String payOidNum;
    private String ifAlreadyPrint;
    private Integer printPerson;
    private Date dataPrint;
    private String ifSend;
    private String result;
    private String resourceId;
    private String failCode;
    private String failMessage;
    private String jkFinsh;
    private String floatType;
    private BigDecimal floatPrice;
    private String ifJkpay;
    private String ifSendlocation;
    private BigDecimal standardTax;
    private BigDecimal priceTax;
    private String ifTaxTransport;
    private Long vatFlowMasterId;
    private String ifUploadReceiptFlag;
    private String ifInvoice;
    private BigDecimal dzZcWeight;
    private Date dzZcTime;
    private String zcWeightFrom;
    private String brokerPeopleTollType;
    private BigDecimal brokerPeopleTollAmount;
    private BigDecimal brokerPeopleTollRatio;
    private String ifBrokerPeopleTollFlag;
    private Integer qdShDiffTime;
    private Long groupId;
    private String groupName;
    private Date hdZcShTime;
    private Long hdZcShModifyPersonId;
    private BigDecimal creditPrice;
    private String ownerAdjustFlag;
    private String ownerAdjustType;
    private BigDecimal ownerAdjustAmt;
    private BigDecimal infoPrice;
    private String ifZntsFlag;
    private String poundLocation;
    private String poundNum;
    private Date shippingTime;
    private String dzStatus;
    private Date dzStatusUpdateTime;
    private BigDecimal goodPrice;
    private String lossType;
    private BigDecimal lossRatio;
    private BigDecimal lossWeight;

    @Id
    @Column(name = "delivery_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "delivery_num", nullable = true, length = 20)
    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    @Basic
    @Column(name = "publish_id", nullable = true, length = 20)
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
    @Column(name = "trans_id", nullable = true)
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    @Basic
    @Column(name = "trans_num", nullable = true, length = 20)
    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    @Basic
    @Column(name = "weight", nullable = true, precision = 3)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    @Column(name = "company_id", nullable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
    @Column(name = "end_plate", nullable = true, length = 200)
    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    @Basic
    @Column(name = "driver_id", nullable = true)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "vehicle_id", nullable = true)
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "create_person", nullable = true)
    public Long getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Long createPerson) {
        this.createPerson = createPerson;
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
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "get_order_plate", nullable = true, length = 200)
    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
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
    @Column(name = "update_date", nullable = true)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "update_person", nullable = true)
    public Long getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Long updatePerson) {
        this.updatePerson = updatePerson;
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
    @Column(name = "good_type_desc", nullable = true, length = 200)
    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    @Basic
    @Column(name = "qty", nullable = true, precision = 2)
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
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
    @Column(name = "pickup_date", nullable = true)
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    @Basic
    @Column(name = "bill_time", nullable = true)
    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    @Basic
    @Column(name = "delivery_time", nullable = true)
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Basic
    @Column(name = "finish_time", nullable = true)
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "publish_company_id", nullable = true)
    public Integer getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Integer publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "operate_type", nullable = true, length = 20)
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "docu_source", nullable = true, length = 20)
    public String getDocuSource() {
        return docuSource;
    }

    public void setDocuSource(String docuSource) {
        this.docuSource = docuSource;
    }

    @Basic
    @Column(name = "settle_weight", nullable = true, precision = 0)
    public BigDecimal getSettleWeight() {
        return settleWeight;
    }

    public void setSettleWeight(BigDecimal settleWeight) {
        this.settleWeight = settleWeight;
    }

    @Basic
    @Column(name = "settle_price", nullable = true, precision = 0)
    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    @Basic
    @Column(name = "settle_amount", nullable = true, precision = 0)
    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    @Basic
    @Column(name = "orther_flag", nullable = true, length = 2)
    public String getOrtherFlag() {
        return ortherFlag;
    }

    public void setOrtherFlag(String ortherFlag) {
        this.ortherFlag = ortherFlag;
    }

    @Basic
    @Column(name = "loading_id", nullable = true, length = 50)
    public String getLoadingId() {
        return loadingId;
    }

    public void setLoadingId(String loadingId) {
        this.loadingId = loadingId;
    }

    @Basic
    @Column(name = "if_driver_judge", nullable = true, length = 1)
    public String getIfDriverJudge() {
        return ifDriverJudge;
    }

    public void setIfDriverJudge(String ifDriverJudge) {
        this.ifDriverJudge = ifDriverJudge;
    }

    @Basic
    @Column(name = "if_fd_judge", nullable = true, length = 1)
    public String getIfFdJudge() {
        return ifFdJudge;
    }

    public void setIfFdJudge(String ifFdJudge) {
        this.ifFdJudge = ifFdJudge;
    }

    @Basic
    @Column(name = "verify_code", nullable = true, length = 20)
    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
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
    @Column(name = "if_feidan", nullable = true, length = 1)
    public String getIfFeidan() {
        return ifFeidan;
    }

    public void setIfFeidan(String ifFeidan) {
        this.ifFeidan = ifFeidan;
    }

    @Basic
    @Column(name = "comfirm_pic_local", nullable = true, length = 500)
    public String getComfirmPicLocal() {
        return comfirmPicLocal;
    }

    public void setComfirmPicLocal(String comfirmPicLocal) {
        this.comfirmPicLocal = comfirmPicLocal;
    }

    @Basic
    @Column(name = "comfirm_pic_remote", nullable = true, length = 500)
    public String getComfirmPicRemote() {
        return comfirmPicRemote;
    }

    public void setComfirmPicRemote(String comfirmPicRemote) {
        this.comfirmPicRemote = comfirmPicRemote;
    }

    @Basic
    @Column(name = "receipt_verify_code", nullable = true, length = 10)
    public String getReceiptVerifyCode() {
        return receiptVerifyCode;
    }

    public void setReceiptVerifyCode(String receiptVerifyCode) {
        this.receiptVerifyCode = receiptVerifyCode;
    }

    @Basic
    @Column(name = "receipt_oper_date", nullable = true)
    public Date getReceiptOperDate() {
        return receiptOperDate;
    }

    public void setReceiptOperDate(Date receiptOperDate) {
        this.receiptOperDate = receiptOperDate;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 4000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "zcSure_date", nullable = true)
    public Date getZcSureDate() {
        return zcSureDate;
    }

    public void setZcSureDate(Date zcSureDate) {
        this.zcSureDate = zcSureDate;
    }

    @Basic
    @Column(name = "shSure_date", nullable = true)
    public Date getShSureDate() {
        return shSureDate;
    }

    public void setShSureDate(Date shSureDate) {
        this.shSureDate = shSureDate;
    }

    @Basic
    @Column(name = "truck_loading_weight", nullable = true, precision = 0)
    public BigDecimal getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    @Basic
    @Column(name = "take_delivery_weight", nullable = true, precision = 0)
    public BigDecimal getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    @Basic
    @Column(name = "settle_status", nullable = true, length = 2)
    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    @Basic
    @Column(name = "oil_card_no", nullable = true, length = 100)
    public String getOilCardNo() {
        return oilCardNo;
    }

    public void setOilCardNo(String oilCardNo) {
        this.oilCardNo = oilCardNo;
    }

    @Basic
    @Column(name = "oil_card_amount", nullable = true, precision = 2)
    public BigDecimal getOilCardAmount() {
        return oilCardAmount;
    }

    public void setOilCardAmount(BigDecimal oilCardAmount) {
        this.oilCardAmount = oilCardAmount;
    }

    @Basic
    @Column(name = "zf_id", nullable = true, length = 20)
    public String getZfId() {
        return zfId;
    }

    public void setZfId(String zfId) {
        this.zfId = zfId;
    }

    @Basic
    @Column(name = "zf_num", nullable = true, length = 20)
    public String getZfNum() {
        return zfNum;
    }

    public void setZfNum(String zfNum) {
        this.zfNum = zfNum;
    }

    @Basic
    @Column(name = "carry_company_id", nullable = true)
    public Long getCarryCompanyId() {
        return carryCompanyId;
    }

    public void setCarryCompanyId(Long carryCompanyId) {
        this.carryCompanyId = carryCompanyId;
    }

    @Basic
    @Column(name = "insurance_flag", nullable = true, length = 1)
    public String getInsuranceFlag() {
        return insuranceFlag;
    }

    public void setInsuranceFlag(String insuranceFlag) {
        this.insuranceFlag = insuranceFlag;
    }

    @Basic
    @Column(name = "insurance_no", nullable = true, length = 30)
    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    @Basic
    @Column(name = "insurance_amount", nullable = true, precision = 2)
    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    @Basic
    @Column(name = "comfirm_pic1_local", nullable = true, length = 500)
    public String getComfirmPic1Local() {
        return comfirmPic1Local;
    }

    public void setComfirmPic1Local(String comfirmPic1Local) {
        this.comfirmPic1Local = comfirmPic1Local;
    }

    @Basic
    @Column(name = "comfirm_pic1_remote", nullable = true, length = 500)
    public String getComfirmPic1Remote() {
        return comfirmPic1Remote;
    }

    public void setComfirmPic1Remote(String comfirmPic1Remote) {
        this.comfirmPic1Remote = comfirmPic1Remote;
    }

    @Basic
    @Column(name = "comfirm_pic2_local", nullable = true, length = 500)
    public String getComfirmPic2Local() {
        return comfirmPic2Local;
    }

    public void setComfirmPic2Local(String comfirmPic2Local) {
        this.comfirmPic2Local = comfirmPic2Local;
    }

    @Basic
    @Column(name = "comfirm_pic2_remote", nullable = true, length = 500)
    public String getComfirmPic2Remote() {
        return comfirmPic2Remote;
    }

    public void setComfirmPic2Remote(String comfirmPic2Remote) {
        this.comfirmPic2Remote = comfirmPic2Remote;
    }

    @Basic
    @Column(name = "pri_publish_id", nullable = false)
    public Long getPriPublishId() {
        return priPublishId;
    }

    public void setPriPublishId(Long priPublishId) {
        this.priPublishId = priPublishId;
    }

    @Basic
    @Column(name = "if_cy_judge", nullable = true, length = 2)
    public String getIfCyJudge() {
        return ifCyJudge;
    }

    public void setIfCyJudge(String ifCyJudge) {
        this.ifCyJudge = ifCyJudge;
    }

    @Basic
    @Column(name = "js_remark", nullable = true, length = 200)
    public String getJsRemark() {
        return jsRemark;
    }

    public void setJsRemark(String jsRemark) {
        this.jsRemark = jsRemark;
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
    @Column(name = "oil_ratio", nullable = true, precision = 2)
    public BigDecimal getOilRatio() {
        return oilRatio;
    }

    public void setOilRatio(BigDecimal oilRatio) {
        this.oilRatio = oilRatio;
    }

    @Basic
    @Column(name = "pay_oid_id", nullable = true, length = 20)
    public String getPayOidId() {
        return payOidId;
    }

    public void setPayOidId(String payOidId) {
        this.payOidId = payOidId;
    }

    @Basic
    @Column(name = "pay_oid_num", nullable = true, length = 20)
    public String getPayOidNum() {
        return payOidNum;
    }

    public void setPayOidNum(String payOidNum) {
        this.payOidNum = payOidNum;
    }

    @Basic
    @Column(name = "if_already_print", nullable = true, length = 1)
    public String getIfAlreadyPrint() {
        return ifAlreadyPrint;
    }

    public void setIfAlreadyPrint(String ifAlreadyPrint) {
        this.ifAlreadyPrint = ifAlreadyPrint;
    }

    @Basic
    @Column(name = "print_person", nullable = true)
    public Integer getPrintPerson() {
        return printPerson;
    }

    public void setPrintPerson(Integer printPerson) {
        this.printPerson = printPerson;
    }

    @Basic
    @Column(name = "data_print", nullable = true)
    public Date getDataPrint() {
        return dataPrint;
    }

    public void setDataPrint(Date dataPrint) {
        this.dataPrint = dataPrint;
    }

    @Basic
    @Column(name = "if_send", nullable = true, length = 2)
    public String getIfSend() {
        return ifSend;
    }

    public void setIfSend(String ifSend) {
        this.ifSend = ifSend;
    }

    @Basic
    @Column(name = "result", nullable = true, length = 2)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "resourceId", nullable = true, length = 50)
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "failCode", nullable = true, length = 255)
    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    @Basic
    @Column(name = "failMessage", nullable = true, length = 255)
    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    @Basic
    @Column(name = "jk_finsh", nullable = true, length = 2)
    public String getJkFinsh() {
        return jkFinsh;
    }

    public void setJkFinsh(String jkFinsh) {
        this.jkFinsh = jkFinsh;
    }

    @Basic
    @Column(name = "float_type", nullable = true, length = 4)
    public String getFloatType() {
        return floatType;
    }

    public void setFloatType(String floatType) {
        this.floatType = floatType;
    }

    @Basic
    @Column(name = "float_price", nullable = true, precision = 2)
    public BigDecimal getFloatPrice() {
        return floatPrice;
    }

    public void setFloatPrice(BigDecimal floatPrice) {
        this.floatPrice = floatPrice;
    }

    @Basic
    @Column(name = "if_jkpay", nullable = true, length = 255)
    public String getIfJkpay() {
        return ifJkpay;
    }

    public void setIfJkpay(String ifJkpay) {
        this.ifJkpay = ifJkpay;
    }

    @Basic
    @Column(name = "if_sendlocation", nullable = true, length = 2)
    public String getIfSendlocation() {
        return ifSendlocation;
    }

    public void setIfSendlocation(String ifSendlocation) {
        this.ifSendlocation = ifSendlocation;
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
    @Column(name = "price_tax", nullable = true, precision = 2)
    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
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
    @Column(name = "if_upload_receipt_flag", nullable = true, length = 1)
    public String getIfUploadReceiptFlag() {
        return ifUploadReceiptFlag;
    }

    public void setIfUploadReceiptFlag(String ifUploadReceiptFlag) {
        this.ifUploadReceiptFlag = ifUploadReceiptFlag;
    }

    @Basic
    @Column(name = "if_invoice", nullable = true, length = 1)
    public String getIfInvoice() {
        return ifInvoice;
    }

    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

    @Basic
    @Column(name = "dz_zc_weight", nullable = true, precision = 6)
    public BigDecimal getDzZcWeight() {
        return dzZcWeight;
    }

    public void setDzZcWeight(BigDecimal dzZcWeight) {
        this.dzZcWeight = dzZcWeight;
    }

    @Basic
    @Column(name = "dz_zc_time", nullable = true)
    public Date getDzZcTime() {
        return dzZcTime;
    }

    public void setDzZcTime(Date dzZcTime) {
        this.dzZcTime = dzZcTime;
    }

    @Basic
    @Column(name = "zc_weight_from", nullable = true, length = 1)
    public String getZcWeightFrom() {
        return zcWeightFrom;
    }

    public void setZcWeightFrom(String zcWeightFrom) {
        this.zcWeightFrom = zcWeightFrom;
    }

    @Basic
    @Column(name = "broker_people_toll_type", nullable = true, length = 2)
    public String getBrokerPeopleTollType() {
        return brokerPeopleTollType;
    }

    public void setBrokerPeopleTollType(String brokerPeopleTollType) {
        this.brokerPeopleTollType = brokerPeopleTollType;
    }

    @Basic
    @Column(name = "broker_people_toll_amount", nullable = true, precision = 2)
    public BigDecimal getBrokerPeopleTollAmount() {
        return brokerPeopleTollAmount;
    }

    public void setBrokerPeopleTollAmount(BigDecimal brokerPeopleTollAmount) {
        this.brokerPeopleTollAmount = brokerPeopleTollAmount;
    }

    @Basic
    @Column(name = "broker_people_toll_ratio", nullable = true, precision = 3)
    public BigDecimal getBrokerPeopleTollRatio() {
        return brokerPeopleTollRatio;
    }

    public void setBrokerPeopleTollRatio(BigDecimal brokerPeopleTollRatio) {
        this.brokerPeopleTollRatio = brokerPeopleTollRatio;
    }

    @Basic
    @Column(name = "if_broker_people_toll_flag", nullable = true, length = 1)
    public String getIfBrokerPeopleTollFlag() {
        return ifBrokerPeopleTollFlag;
    }

    public void setIfBrokerPeopleTollFlag(String ifBrokerPeopleTollFlag) {
        this.ifBrokerPeopleTollFlag = ifBrokerPeopleTollFlag;
    }

    @Basic
    @Column(name = "qd_sh_diff_time", nullable = true)
    public Integer getQdShDiffTime() {
        return qdShDiffTime;
    }

    public void setQdShDiffTime(Integer qdShDiffTime) {
        this.qdShDiffTime = qdShDiffTime;
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
    @Column(name = "hd_zc_sh_time", nullable = true)
    public Date getHdZcShTime() {
        return hdZcShTime;
    }

    public void setHdZcShTime(Date hdZcShTime) {
        this.hdZcShTime = hdZcShTime;
    }

    @Basic
    @Column(name = "hd_zc_sh_modify_person_id", nullable = true)
    public Long getHdZcShModifyPersonId() {
        return hdZcShModifyPersonId;
    }

    public void setHdZcShModifyPersonId(Long hdZcShModifyPersonId) {
        this.hdZcShModifyPersonId = hdZcShModifyPersonId;
    }

    @Basic
    @Column(name = "credit_price", nullable = true, precision = 2)
    public BigDecimal getCreditPrice() {
        return creditPrice;
    }

    public void setCreditPrice(BigDecimal creditPrice) {
        this.creditPrice = creditPrice;
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
    @Column(name = "info_price", nullable = true, precision = 2)
    public BigDecimal getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(BigDecimal infoPrice) {
        this.infoPrice = infoPrice;
    }

    @Basic
    @Column(name = "if_znts_flag", nullable = true, length = 1)
    public String getIfZntsFlag() {
        return ifZntsFlag;
    }

    public void setIfZntsFlag(String ifZntsFlag) {
        this.ifZntsFlag = ifZntsFlag;
    }

    @Basic
    @Column(name = "pound_location", nullable = true, length = 300)
    public String getPoundLocation() {
        return poundLocation;
    }

    public void setPoundLocation(String poundLocation) {
        this.poundLocation = poundLocation;
    }

    @Basic
    @Column(name = "pound_num", nullable = true, length = 30)
    public String getPoundNum() {
        return poundNum;
    }

    public void setPoundNum(String poundNum) {
        this.poundNum = poundNum;
    }

    @Basic
    @Column(name = "shipping_time", nullable = true)
    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    @Basic
    @Column(name = "dz_status", nullable = true, length = 50)
    public String getDzStatus() {
        return dzStatus;
    }

    public void setDzStatus(String dzStatus) {
        this.dzStatus = dzStatus;
    }

    @Basic
    @Column(name = "dz_status_update_time", nullable = true)
    public Date getDzStatusUpdateTime() {
        return dzStatusUpdateTime;
    }

    public void setDzStatusUpdateTime(Date dzStatusUpdateTime) {
        this.dzStatusUpdateTime = dzStatusUpdateTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportationdeliveryEntity that = (TransportationdeliveryEntity) o;
        return deliveryId == that.deliveryId &&
                priPublishId == that.priPublishId &&
                Objects.equals(deliveryNum, that.deliveryNum) &&
                Objects.equals(publishNum, that.publishNum) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(transNum, that.transNum) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(departureLng, that.departureLng) &&
                Objects.equals(departureLat, that.departureLat) &&
                Objects.equals(destinationLng, that.destinationLng) &&
                Objects.equals(destinationLat, that.destinationLat) &&
                Objects.equals(getOrderAddressLng, that.getOrderAddressLng) &&
                Objects.equals(getOrderAddressLat, that.getOrderAddressLat) &&
                Objects.equals(getOrderPlate, that.getOrderPlate) &&
                Objects.equals(departure, that.departure) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(getOrderAddress, that.getOrderAddress) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(senderMobile, that.senderMobile) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(billSender, that.billSender) &&
                Objects.equals(billSenderMobile, that.billSenderMobile) &&
                Objects.equals(billTaker, that.billTaker) &&
                Objects.equals(billTakerMobile, that.billTakerMobile) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updatePerson, that.updatePerson) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(price, that.price) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(billTime, that.billTime) &&
                Objects.equals(deliveryTime, that.deliveryTime) &&
                Objects.equals(finishTime, that.finishTime) &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(operateType, that.operateType) &&
                Objects.equals(docuSource, that.docuSource) &&
                Objects.equals(settleWeight, that.settleWeight) &&
                Objects.equals(settlePrice, that.settlePrice) &&
                Objects.equals(settleAmount, that.settleAmount) &&
                Objects.equals(ortherFlag, that.ortherFlag) &&
                Objects.equals(loadingId, that.loadingId) &&
                Objects.equals(ifDriverJudge, that.ifDriverJudge) &&
                Objects.equals(ifFdJudge, that.ifFdJudge) &&
                Objects.equals(verifyCode, that.verifyCode) &&
                Objects.equals(fdUserId, that.fdUserId) &&
                Objects.equals(ifCanShow, that.ifCanShow) &&
                Objects.equals(ifFeidan, that.ifFeidan) &&
                Objects.equals(comfirmPicLocal, that.comfirmPicLocal) &&
                Objects.equals(comfirmPicRemote, that.comfirmPicRemote) &&
                Objects.equals(receiptVerifyCode, that.receiptVerifyCode) &&
                Objects.equals(receiptOperDate, that.receiptOperDate) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(zcSureDate, that.zcSureDate) &&
                Objects.equals(shSureDate, that.shSureDate) &&
                Objects.equals(truckLoadingWeight, that.truckLoadingWeight) &&
                Objects.equals(takeDeliveryWeight, that.takeDeliveryWeight) &&
                Objects.equals(settleStatus, that.settleStatus) &&
                Objects.equals(oilCardNo, that.oilCardNo) &&
                Objects.equals(oilCardAmount, that.oilCardAmount) &&
                Objects.equals(zfId, that.zfId) &&
                Objects.equals(zfNum, that.zfNum) &&
                Objects.equals(carryCompanyId, that.carryCompanyId) &&
                Objects.equals(insuranceFlag, that.insuranceFlag) &&
                Objects.equals(insuranceNo, that.insuranceNo) &&
                Objects.equals(insuranceAmount, that.insuranceAmount) &&
                Objects.equals(comfirmPic1Local, that.comfirmPic1Local) &&
                Objects.equals(comfirmPic1Remote, that.comfirmPic1Remote) &&
                Objects.equals(comfirmPic2Local, that.comfirmPic2Local) &&
                Objects.equals(comfirmPic2Remote, that.comfirmPic2Remote) &&
                Objects.equals(ifCyJudge, that.ifCyJudge) &&
                Objects.equals(jsRemark, that.jsRemark) &&
                Objects.equals(jsType, that.jsType) &&
                Objects.equals(oilRatio, that.oilRatio) &&
                Objects.equals(payOidId, that.payOidId) &&
                Objects.equals(payOidNum, that.payOidNum) &&
                Objects.equals(ifAlreadyPrint, that.ifAlreadyPrint) &&
                Objects.equals(printPerson, that.printPerson) &&
                Objects.equals(dataPrint, that.dataPrint) &&
                Objects.equals(ifSend, that.ifSend) &&
                Objects.equals(result, that.result) &&
                Objects.equals(resourceId, that.resourceId) &&
                Objects.equals(failCode, that.failCode) &&
                Objects.equals(failMessage, that.failMessage) &&
                Objects.equals(jkFinsh, that.jkFinsh) &&
                Objects.equals(floatType, that.floatType) &&
                Objects.equals(floatPrice, that.floatPrice) &&
                Objects.equals(ifJkpay, that.ifJkpay) &&
                Objects.equals(ifSendlocation, that.ifSendlocation) &&
                Objects.equals(standardTax, that.standardTax) &&
                Objects.equals(priceTax, that.priceTax) &&
                Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(ifUploadReceiptFlag, that.ifUploadReceiptFlag) &&
                Objects.equals(ifInvoice, that.ifInvoice) &&
                Objects.equals(dzZcWeight, that.dzZcWeight) &&
                Objects.equals(dzZcTime, that.dzZcTime) &&
                Objects.equals(zcWeightFrom, that.zcWeightFrom) &&
                Objects.equals(brokerPeopleTollType, that.brokerPeopleTollType) &&
                Objects.equals(brokerPeopleTollAmount, that.brokerPeopleTollAmount) &&
                Objects.equals(brokerPeopleTollRatio, that.brokerPeopleTollRatio) &&
                Objects.equals(ifBrokerPeopleTollFlag, that.ifBrokerPeopleTollFlag) &&
                Objects.equals(qdShDiffTime, that.qdShDiffTime) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(hdZcShTime, that.hdZcShTime) &&
                Objects.equals(hdZcShModifyPersonId, that.hdZcShModifyPersonId) &&
                Objects.equals(creditPrice, that.creditPrice) &&
                Objects.equals(ownerAdjustFlag, that.ownerAdjustFlag) &&
                Objects.equals(ownerAdjustType, that.ownerAdjustType) &&
                Objects.equals(ownerAdjustAmt, that.ownerAdjustAmt) &&
                Objects.equals(infoPrice, that.infoPrice) &&
                Objects.equals(ifZntsFlag, that.ifZntsFlag) &&
                Objects.equals(poundLocation, that.poundLocation) &&
                Objects.equals(poundNum, that.poundNum) &&
                Objects.equals(shippingTime, that.shippingTime) &&
                Objects.equals(dzStatus, that.dzStatus) &&
                Objects.equals(dzStatusUpdateTime, that.dzStatusUpdateTime) &&
                Objects.equals(goodPrice, that.goodPrice) &&
                Objects.equals(lossType, that.lossType) &&
                Objects.equals(lossRatio, that.lossRatio) &&
                Objects.equals(lossWeight, that.lossWeight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deliveryId, deliveryNum, publishNum, transId, transNum, weight, amount, createDate, companyId, startPlate, endPlate, driverId, vehicleId, createPerson, platformId, status, departureLng, departureLat, destinationLng, destinationLat, getOrderAddressLng, getOrderAddressLat, getOrderPlate, departure, destination, getOrderAddress, sender, senderMobile, receiverMobile, receiver, billSender, billSenderMobile, billTaker, billTakerMobile, updateDate, updatePerson, goodType, goodTypeDesc, qty, price, pickupDate, billTime, deliveryTime, finishTime, publishCompanyId, operateType, docuSource, settleWeight, settlePrice, settleAmount, ortherFlag, loadingId, ifDriverJudge, ifFdJudge, verifyCode, fdUserId, ifCanShow, ifFeidan, comfirmPicLocal, comfirmPicRemote, receiptVerifyCode, receiptOperDate, remark, zcSureDate, shSureDate, truckLoadingWeight, takeDeliveryWeight, settleStatus, oilCardNo, oilCardAmount, zfId, zfNum, carryCompanyId, insuranceFlag, insuranceNo, insuranceAmount, comfirmPic1Local, comfirmPic1Remote, comfirmPic2Local, comfirmPic2Remote, priPublishId, ifCyJudge, jsRemark, jsType, oilRatio, payOidId, payOidNum, ifAlreadyPrint, printPerson, dataPrint, ifSend, result, resourceId, failCode, failMessage, jkFinsh, floatType, floatPrice, ifJkpay, ifSendlocation, standardTax, priceTax, ifTaxTransport, vatFlowMasterId, ifUploadReceiptFlag, ifInvoice, dzZcWeight, dzZcTime, zcWeightFrom, brokerPeopleTollType, brokerPeopleTollAmount, brokerPeopleTollRatio, ifBrokerPeopleTollFlag, qdShDiffTime, groupId, groupName, hdZcShTime, hdZcShModifyPersonId, creditPrice, ownerAdjustFlag, ownerAdjustType, ownerAdjustAmt, infoPrice, ifZntsFlag, poundLocation, poundNum, shippingTime, dzStatus, dzStatusUpdateTime, goodPrice, lossType, lossRatio, lossWeight);
    }
}