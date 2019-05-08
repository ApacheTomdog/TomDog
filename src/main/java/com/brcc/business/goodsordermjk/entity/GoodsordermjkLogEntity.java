package com.brcc.business.goodsordermjk.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author: ywb
 * @date: 2019-04-23
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "goodsordermjk_log")
public class GoodsordermjkLogEntity {
    private Long importId;
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
    private String startPlateLng;
    private String startPlateLat;
    private String endPlateLng;
    private String endPlateLat;
    private String getOrderPlateLng;
    private String getOrderPlateLat;
    private Integer sendKM;
    private String sender;
    private String senderMobile;
    private String receiverMobile;
    private String receiver;
    private Long goodType;
    private String fromType;
    private Integer batchId;
    private String goodTypeDesc;
    private String dependNum2;
    private Long publishId;
    private String ret1;
    private String ret2;
    private String ret3;
    private String billSender;
    private String billSenderMobile;
    private String billTaker;
    private String billTakerMobile;
    private String detachable;
    private String heavyPiece;
    private Date approveTime;
    private String approveUserId;
    private Date pickupDate;
    private String prodDesc;
    private Long companyId;
    private BigDecimal maxPrice;
    private String qbType;
    private String sendGroup;
    private String docuType;
    private String ps1;
    private String ps2;
    private String ps3;
    private String ps4;
    private String ps5;
    private String taxNum;
    private String appointCompanyId;
    private String appointCompanyName;
    private Integer pinDanNum;
    private Date putinDate;
    private Long userId;
    private Date logCreateDate;
    private Long seqId;
    private Integer logBatchId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_id", nullable = false)
    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "import_id", nullable = true)
    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
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
    @Column(name = "qty", nullable = true, precision = 2)
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
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
    @Column(name = "remark", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "depend_num", nullable = true, length = 20)
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
    @Column(name = "start_plate_lng", nullable = true, length = 20)
    public String getStartPlateLng() {
        return startPlateLng;
    }

    public void setStartPlateLng(String startPlateLng) {
        this.startPlateLng = startPlateLng;
    }

    @Basic
    @Column(name = "start_plate_lat", nullable = true, length = 20)
    public String getStartPlateLat() {
        return startPlateLat;
    }

    public void setStartPlateLat(String startPlateLat) {
        this.startPlateLat = startPlateLat;
    }

    @Basic
    @Column(name = "end_plate_lng", nullable = true, length = 20)
    public String getEndPlateLng() {
        return endPlateLng;
    }

    public void setEndPlateLng(String endPlateLng) {
        this.endPlateLng = endPlateLng;
    }

    @Basic
    @Column(name = "end_plate_lat", nullable = true, length = 20)
    public String getEndPlateLat() {
        return endPlateLat;
    }

    public void setEndPlateLat(String endPlateLat) {
        this.endPlateLat = endPlateLat;
    }

    @Basic
    @Column(name = "get_order_plate_lng", nullable = true, length = 20)
    public String getGetOrderPlateLng() {
        return getOrderPlateLng;
    }

    public void setGetOrderPlateLng(String getOrderPlateLng) {
        this.getOrderPlateLng = getOrderPlateLng;
    }

    @Basic
    @Column(name = "get_order_plate_lat", nullable = true, length = 20)
    public String getGetOrderPlateLat() {
        return getOrderPlateLat;
    }

    public void setGetOrderPlateLat(String getOrderPlateLat) {
        this.getOrderPlateLat = getOrderPlateLat;
    }

    @Basic
    @Column(name = "sendKM", nullable = true)
    public Integer getSendKm() {
        return sendKM;
    }

    public void setSendKm(Integer sendKM) {
        this.sendKM = sendKM;
    }

    @Basic
    @Column(name = "sender", nullable = true, length = 20)
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
    public Long getGoodType() {
        return goodType;
    }

    public void setGoodType(Long goodType) {
        this.goodType = goodType;
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
    @Column(name = "batch_id")
    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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
    @Column(name = "depend_num2", nullable = true, length = 30)
    public String getDependNum2() {
        return dependNum2;
    }

    public void setDependNum2(String dependNum2) {
        this.dependNum2 = dependNum2;
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
    @Column(name = "ret_1", nullable = true, length = 50)
    public String getRet1() {
        return ret1;
    }

    public void setRet1(String ret1) {
        this.ret1 = ret1;
    }

    @Basic
    @Column(name = "ret_2", nullable = true, length = 30)
    public String getRet2() {
        return ret2;
    }

    public void setRet2(String ret2) {
        this.ret2 = ret2;
    }

    @Basic
    @Column(name = "ret_3", nullable = true, length = 20)
    public String getRet3() {
        return ret3;
    }

    public void setRet3(String ret3) {
        this.ret3 = ret3;
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
    @Column(name = "detachable", nullable = true, length = 20)
    public String getDetachable() {
        return detachable;
    }

    public void setDetachable(String detachable) {
        this.detachable = detachable;
    }

    @Basic
    @Column(name = "heavy_piece", nullable = true, length = 20)
    public String getHeavyPiece() {
        return heavyPiece;
    }

    public void setHeavyPiece(String heavyPiece) {
        this.heavyPiece = heavyPiece;
    }

    @Basic
    @Column(name = "approve_time", nullable = true)
    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    @Basic
    @Column(name = "approve_user_id", nullable = true, length = 20)
    public String getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(String approveUserId) {
        this.approveUserId = approveUserId;
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
    @Column(name = "prod_desc", nullable = true, length = 200)
    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
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
    @Column(name = "max_price", nullable = true, precision = 6)
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "qb_type", nullable = true, length = 2)
    public String getQbType() {
        return qbType;
    }

    public void setQbType(String qbType) {
        this.qbType = qbType;
    }

    @Basic
    @Column(name = "send_group", nullable = true, length = 10)
    public String getSendGroup() {
        return sendGroup;
    }

    public void setSendGroup(String sendGroup) {
        this.sendGroup = sendGroup;
    }

    @Basic
    @Column(name = "docu_type", nullable = true, length = 20)
    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
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
    @Column(name = "ps5", nullable = true, length = 500)
    public String getPs5() {
        return ps5;
    }

    public void setPs5(String ps5) {
        this.ps5 = ps5;
    }

    @Basic
    @Column(name = "tax_num", nullable = true, length = 20)
    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    @Basic
    @Column(name = "appoint_company_id", nullable = true, length = 20)
    public String getAppointCompanyId() {
        return appointCompanyId;
    }

    public void setAppointCompanyId(String appointCompanyId) {
        this.appointCompanyId = appointCompanyId;
    }

    @Basic
    @Column(name = "appoint_company_name", nullable = true, length = 200)
    public String getAppointCompanyName() {
        return appointCompanyName;
    }

    public void setAppointCompanyName(String appointCompanyName) {
        this.appointCompanyName = appointCompanyName;
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
    @Column(name = "putin_date", nullable = true)
    public Date getPutinDate() {
        return putinDate;
    }

    public void setPutinDate(Date putinDate) {
        this.putinDate = putinDate;
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
    @Column(name = "log_create_date", nullable = true)
    public Date getLogCreateDate() {
        return logCreateDate;
    }

    public void setLogCreateDate(Date logCreateDate) {
        this.logCreateDate = logCreateDate;
    }

    @Basic
    @Column(name = "log_batch_id", nullable = true)
    public Integer getLogBatchId() {
        return logBatchId;
    }

    public void setLogBatchId(Integer logBatchId) {
        this.logBatchId = logBatchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsordermjkLogEntity that = (GoodsordermjkLogEntity) o;
        return Objects.equals(importId, that.importId) &&
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
                Objects.equals(startPlateLng, that.startPlateLng) &&
                Objects.equals(startPlateLat, that.startPlateLat) &&
                Objects.equals(endPlateLng, that.endPlateLng) &&
                Objects.equals(endPlateLat, that.endPlateLat) &&
                Objects.equals(getOrderPlateLng, that.getOrderPlateLng) &&
                Objects.equals(getOrderPlateLat, that.getOrderPlateLat) &&
                Objects.equals(sendKM, that.sendKM) &&
                Objects.equals(sender, that.sender) &&
                Objects.equals(senderMobile, that.senderMobile) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(receiver, that.receiver) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(fromType, that.fromType) &&
                Objects.equals(batchId, that.batchId) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(dependNum2, that.dependNum2) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(ret1, that.ret1) &&
                Objects.equals(ret2, that.ret2) &&
                Objects.equals(ret3, that.ret3) &&
                Objects.equals(billSender, that.billSender) &&
                Objects.equals(billSenderMobile, that.billSenderMobile) &&
                Objects.equals(billTaker, that.billTaker) &&
                Objects.equals(billTakerMobile, that.billTakerMobile) &&
                Objects.equals(detachable, that.detachable) &&
                Objects.equals(heavyPiece, that.heavyPiece) &&
                Objects.equals(approveTime, that.approveTime) &&
                Objects.equals(approveUserId, that.approveUserId) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(prodDesc, that.prodDesc) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(qbType, that.qbType) &&
                Objects.equals(sendGroup, that.sendGroup) &&
                Objects.equals(docuType, that.docuType) &&
                Objects.equals(ps1, that.ps1) &&
                Objects.equals(ps2, that.ps2) &&
                Objects.equals(ps3, that.ps3) &&
                Objects.equals(ps4, that.ps4) &&
                Objects.equals(ps5, that.ps5) &&
                Objects.equals(taxNum, that.taxNum) &&
                Objects.equals(appointCompanyId, that.appointCompanyId) &&
                Objects.equals(appointCompanyName, that.appointCompanyName) &&
                Objects.equals(pinDanNum, that.pinDanNum) &&
                Objects.equals(putinDate, that.putinDate) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(logCreateDate, that.logCreateDate) &&
                Objects.equals(seqId, that.seqId) &&
                Objects.equals(logBatchId, that.logBatchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importId, weight, qty, amount, status, platformId, createDate, limitTime, remark, dependNum, price, startPlate, getOrderPlate, endPlate, startPlateLng, startPlateLat, endPlateLng, endPlateLat, getOrderPlateLng, getOrderPlateLat, sendKM, sender, senderMobile, receiverMobile, receiver, goodType, fromType, batchId, goodTypeDesc, dependNum2, publishId, ret1, ret2, ret3, billSender, billSenderMobile, billTaker, billTakerMobile, detachable, heavyPiece, approveTime, approveUserId, pickupDate, prodDesc, companyId, maxPrice, qbType, sendGroup, docuType, ps1, ps2, ps3, ps4, ps5, taxNum, appointCompanyId, appointCompanyName, pinDanNum, putinDate, userId, logCreateDate, seqId, logBatchId);
    }
}
