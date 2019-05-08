package com.brcc.business.brokerFunds.vo;
import java.math.BigDecimal;
import java.util.Date;
public class BrokerFundsUploadVo {

    private String fundsControlDetailId;

    private String payBillNum;

    private String dependNum;

    private Long publishId;

    private Long transId;

    private Long deliveryId;

    private String detailStatus;

    private String publishCompanyName;

    private String contactMobile; // 货主手机号

    private String goodTypeDesc;

    private String getOrderPlate;

    private String startPlate;

    private String endPlate;

    private BigDecimal price;

    private BigDecimal payAmount;

    private Date qdCreateDate;

    private Date qdFinishDate;

    private String driverName;

    private String driverPhone;

    private String vehicleNum;

    private String vehicleType;

    private String carAxle;

    private String fcCarryName;

    private BigDecimal fcCarryAmount;

    public String getFundsControlDetailId() {
        return fundsControlDetailId;
    }

    public void setFundsControlDetailId(String fundsControlDetailId) {
        this.fundsControlDetailId = fundsControlDetailId;
    }

    public String getPayBillNum() {
        return payBillNum;
    }

    public void setPayBillNum(String payBillNum) {
        this.payBillNum = payBillNum;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getQdCreateDate() {
        return qdCreateDate;
    }

    public void setQdCreateDate(Date qdCreateDate) {
        this.qdCreateDate = qdCreateDate;
    }

    public Date getQdFinishDate() {
        return qdFinishDate;
    }

    public void setQdFinishDate(Date qdFinishDate) {
        this.qdFinishDate = qdFinishDate;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCarAxle() {
        return carAxle;
    }

    public void setCarAxle(String carAxle) {
        this.carAxle = carAxle;
    }

    public String getFcCarryName() {
        return fcCarryName;
    }

    public void setFcCarryName(String fcCarryName) {
        this.fcCarryName = fcCarryName;
    }

    public BigDecimal getFcCarryAmount() {
        return fcCarryAmount;
    }

    public void setFcCarryAmount(BigDecimal fcCarryAmount) {
        this.fcCarryAmount = fcCarryAmount;
    }
}
