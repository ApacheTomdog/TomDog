package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-14 16:28
 */
@Entity
@Table(name = "view_abnormal")
public class ViewAbnormalEntity {
    @Id

    private Long deliveryId;
    private Long publishId;
    private Long transId;
    private String billSender;
    private String billSenderMobile;
    private Integer companyId;
    private Date createDate;
    private Date finishTime;
    private Date billTime;
    private String billTaker;
    private String billTakerMobile;
    private String getOrderPlate;
    private String startPlate;
    private String endPlate;
    private Integer driverId;
    private Long vehicleId;
    private String platformId;
    private Integer goodType;
    private String goodTypeDesc;
    private BigDecimal price;
    private BigDecimal weight;
    private BigDecimal amount;
    private String ifTaxTransport;
    private Long publishCompanyId;
    private BigDecimal qty;
    private Long vatFlowMasterId;
    private BigDecimal truckLoadingWeight;
    private BigDecimal takeDeliveryWeight;
    private String dependNum;
    private String fromType;
    private String logisticsMark;
    private String prodDesc;
    private BigDecimal minTime;
    private BigDecimal maxTime;
    private BigDecimal actualTime;

    @Basic
    @Column(name = "delivery_id", nullable = false)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
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
    @Column(name = "trans_id", nullable = true)
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
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
    @Column(name = "company_id", nullable = true)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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
    @Column(name = "finish_time", nullable = true)
    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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
    @Column(name = "get_order_plate", nullable = true, length = 200)
    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
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
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
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
    @Column(name = "platform_id", nullable = true, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    @Column(name = "if_tax_transport", nullable = true, length = 1)
    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
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
    @Column(name = "qty", nullable = true, precision = 2)
    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
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
    @Column(name = "depend_num", nullable = true, length = 40)
    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
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
    @Column(name = "logistics_mark", nullable = true, length = 1)
    public String getLogisticsMark() {
        return logisticsMark;
    }

    public void setLogisticsMark(String logisticsMark) {
        this.logisticsMark = logisticsMark;
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
    @Column(name = "min_time", nullable = false, precision = 0)
    public BigDecimal getMinTime() {
        return minTime;
    }

    public void setMinTime(BigDecimal minTime) {
        this.minTime = minTime;
    }

    @Basic
    @Column(name = "max_time", nullable = false, precision = 0)
    public BigDecimal getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(BigDecimal maxTime) {
        this.maxTime = maxTime;
    }

    @Basic
    @Column(name = "actual_time", nullable = false, precision = 1)
    public BigDecimal getActualTime() {
        return actualTime;
    }

    public void setActualTime(BigDecimal actualTime) {
        this.actualTime = actualTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewAbnormalEntity that = (ViewAbnormalEntity) o;
        return deliveryId == that.deliveryId &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(billSender, that.billSender) &&
                Objects.equals(billSenderMobile, that.billSenderMobile) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(finishTime, that.finishTime) &&
                Objects.equals(billTime, that.billTime) &&
                Objects.equals(billTaker, that.billTaker) &&
                Objects.equals(billTakerMobile, that.billTakerMobile) &&
                Objects.equals(getOrderPlate, that.getOrderPlate) &&
                Objects.equals(startPlate, that.startPlate) &&
                Objects.equals(endPlate, that.endPlate) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(goodType, that.goodType) &&
                Objects.equals(goodTypeDesc, that.goodTypeDesc) &&
                Objects.equals(price, that.price) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(ifTaxTransport, that.ifTaxTransport) &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(vatFlowMasterId, that.vatFlowMasterId) &&
                Objects.equals(truckLoadingWeight, that.truckLoadingWeight) &&
                Objects.equals(takeDeliveryWeight, that.takeDeliveryWeight) &&
                Objects.equals(dependNum, that.dependNum) &&
                Objects.equals(fromType, that.fromType) &&
                Objects.equals(logisticsMark, that.logisticsMark) &&
                Objects.equals(prodDesc, that.prodDesc) &&
                Objects.equals(minTime, that.minTime) &&
                Objects.equals(maxTime, that.maxTime) &&
                Objects.equals(actualTime, that.actualTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deliveryId, publishId, transId, billSender, billSenderMobile, companyId, createDate, finishTime, billTime, billTaker, billTakerMobile, getOrderPlate, startPlate, endPlate, driverId, vehicleId, platformId, goodType, goodTypeDesc, price, weight, amount, ifTaxTransport, publishCompanyId, qty, vatFlowMasterId, truckLoadingWeight, takeDeliveryWeight, dependNum, fromType, logisticsMark, prodDesc, minTime, maxTime, actualTime);
    }
}