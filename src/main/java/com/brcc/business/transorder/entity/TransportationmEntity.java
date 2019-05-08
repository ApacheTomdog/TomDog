package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-01 10:32
 */
@Entity
@Table(name = "transportationm")
public class TransportationmEntity {

    private Long transId;
    private String transNum;
    private Long publishId;
    private String publishNum;
    private BigDecimal weight;
    private BigDecimal amount;
    private Date createDate;
    private Long companyId;
    private String startPlate;
    private String endPlate;
    private String getOrderPlate;
    private Long createPerson;
    private String platformId;
    private String companyName;
    private BigDecimal departureLng;
    private BigDecimal departureLat;
    private BigDecimal destinationLng;
    private BigDecimal destinationLat;
    private BigDecimal getOrderAddressLng;
    private BigDecimal getOrderAddressLat;
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
    private String status;
    private Integer goodType;
    private String goodTypeDesc;
    private BigDecimal qty;
    private BigDecimal price;
    private Date pickupDate;
    private BigDecimal initWeight;
    private BigDecimal initAmount;
    private BigDecimal initQty;
    private String prodDesc;
    private Date completeDate;
    private BigDecimal deliveryWeight;
    private BigDecimal deliveryQty;
    private BigDecimal deliveryAmount;
    private Long publishCompanyId;
    private String operateType;
    private String docuSource;
    private Long fdUserId;
    private String ifCanShow;
    private String ifFeidan;
    private Long carryCompanyId;
    private Long priPublishId;
    private String remark;
    private BigDecimal standardTax;
    private BigDecimal priceTax;
    private String ifTaxTransport;
    private Long vatFlowMasterId;
    private Long groupId;
    private String groupName;
    private String ownerAdjustFlag;
    private String ownerAdjustType;
    private BigDecimal ownerAdjustAmt;
    private String goodsorderquotation;
    private BigDecimal goodPrice;
    private String lossType;
    private BigDecimal lossRatio;
    private BigDecimal lossWeight;
    private String robDeliveryType;
    private String businessMode;

    @Id
    @Column(name = "trans_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "publish_id", nullable = true)
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
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
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
    @Column(name = "get_order_plate", nullable = true, length = 200)
    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
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
    @Column(name = "company_name", nullable = true, length = 200)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "init_weight", nullable = true, precision = 6)
    public BigDecimal getInitWeight() {
        return initWeight;
    }

    public void setInitWeight(BigDecimal initWeight) {
        this.initWeight = initWeight;
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
    @Column(name = "init_qty", nullable = true, precision = 6)
    public BigDecimal getInitQty() {
        return initQty;
    }

    public void setInitQty(BigDecimal initQty) {
        this.initQty = initQty;
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
    @Column(name = "complete_date", nullable = true)
    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    @Basic
    @Column(name = "delivery_weight", nullable = true, precision = 6)
    public BigDecimal getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(BigDecimal deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }

    @Basic
    @Column(name = "delivery_qty", nullable = true, precision = 6)
    public BigDecimal getDeliveryQty() {
        return deliveryQty;
    }

    public void setDeliveryQty(BigDecimal deliveryQty) {
        this.deliveryQty = deliveryQty;
    }

    @Basic
    @Column(name = "delivery_amount", nullable = true, precision = 6)
    public BigDecimal getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(BigDecimal deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    @Basic
    @Column(name = "publish_company_id", nullable = true)
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
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
    @Column(name = "carry_company_id", nullable = true)
    public Long getCarryCompanyId() {
        return carryCompanyId;
    }

    public void setCarryCompanyId(Long carryCompanyId) {
        this.carryCompanyId = carryCompanyId;
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
    @Column(name = "remark", nullable = true, length = 2000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "goodsorderquotation", nullable = true, length = 255)
    public String getGoodsorderquotation() {
        return goodsorderquotation;
    }

    public void setGoodsorderquotation(String goodsorderquotation) {
        this.goodsorderquotation = goodsorderquotation;
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
    @Column(name = "loss_type", nullable = true, length = 2)
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
    @Column(name = "rob_delivery_type")
    public String getRobDeliveryType() {return robDeliveryType; }

    public void setRobDeliveryType(String robDeliveryType) {this.robDeliveryType = robDeliveryType; }

    @Basic
    @Column(name = "business_mode")
    public String getBusinessMode() {
        return businessMode;
    }

    public void setBusinessMode(String businessMode) {
        this.businessMode = businessMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportationmEntity that = (TransportationmEntity) o;
        return transId == that.transId &&
                priPublishId == that.priPublishId &&
                Objects.equals(transNum, that.transNum) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(publishNum, that.publishNum) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(getOrderPlate, that.getOrderPlate) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(departureLng, that.departureLng) &&
                Objects.equals(departureLat, that.departureLat) &&
                Objects.equals(destinationLng, that.destinationLng) &&
                Objects.equals(destinationLat, that.destinationLat) &&
                Objects.equals(getOrderAddressLng, that.getOrderAddressLng) &&
                Objects.equals(getOrderAddressLat, that.getOrderAddressLat) &&
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
                Objects.equals(status, that.status) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(price, that.price) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(initWeight, that.initWeight) &&
                Objects.equals(initAmount, that.initAmount) &&
                Objects.equals(initQty, that.initQty) &&
                Objects.equals(prodDesc, that.prodDesc) &&
                Objects.equals(completeDate, that.completeDate) &&
                Objects.equals(deliveryWeight, that.deliveryWeight) &&
                Objects.equals(deliveryQty, that.deliveryQty) &&
                Objects.equals(deliveryAmount, that.deliveryAmount) &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(operateType, that.operateType) &&
                Objects.equals(docuSource, that.docuSource) &&
                Objects.equals(fdUserId, that.fdUserId) &&
                Objects.equals(ifCanShow, that.ifCanShow) &&
                Objects.equals(ifFeidan, that.ifFeidan) &&
                Objects.equals(carryCompanyId, that.carryCompanyId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(standardTax, that.standardTax) &&
                Objects.equals(priceTax, that.priceTax) &&
                Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(ownerAdjustFlag, that.ownerAdjustFlag) &&
                Objects.equals(ownerAdjustType, that.ownerAdjustType) &&
                Objects.equals(ownerAdjustAmt, that.ownerAdjustAmt) &&
                Objects.equals(goodsorderquotation, that.goodsorderquotation) &&
                Objects.equals(goodPrice, that.goodPrice) &&
                Objects.equals(lossType, that.lossType) &&
                Objects.equals(lossRatio, that.lossRatio) &&
                Objects.equals(lossWeight, that.lossWeight);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transId, transNum, publishId, publishNum, weight, amount, createDate, companyId, startPlate, endPlate, getOrderPlate, createPerson, platformId, companyName, departureLng, departureLat, destinationLng, destinationLat, getOrderAddressLng, getOrderAddressLat, departure, destination, getOrderAddress, sender, senderMobile, receiverMobile, receiver, billSender, billSenderMobile, billTaker, billTakerMobile, updateDate, updatePerson, status, goodType, goodTypeDesc, qty, price, pickupDate, initWeight, initAmount, initQty, prodDesc, completeDate, deliveryWeight, deliveryQty, deliveryAmount, publishCompanyId, operateType, docuSource, fdUserId, ifCanShow, ifFeidan, carryCompanyId, priPublishId, remark, standardTax, priceTax, ifTaxTransport, vatFlowMasterId, groupId, groupName, ownerAdjustFlag, ownerAdjustType, ownerAdjustAmt, goodsorderquotation, goodPrice, lossType, lossRatio, lossWeight);
    }
}