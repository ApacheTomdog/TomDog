package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 14:11
 */
@Entity
@Table(name = "deliveryupload")
public class DeliveryUploadEntity implements Serializable {

    private Long uploadId;
    private String platformId;
    private String publishId;
    private Long deliveryId;
    private String deliveryNum;
    private String weight;
    private BigDecimal amount;
    private String qty;
    private String driverName;
    private Long driverId;
    private String pickUpWeight;
    private String companyName;
    private Date createDate;
    private String idNum;
    private String carNum;
    private String status;
    private String ret1;
    private String ret2;
    private String ret3;
    private String ret4;
    private String ret5;
    private String ifUpload;
    private String returnMsg;
    private Date returnTime;

    @Id
    @Column(name = "upload_id", nullable = false)
    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    @Basic
    @Column(name = "platform_id", nullable = true, length = 50)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "publish_id", nullable = true, length = 50)
    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "delivery_id", nullable = true)
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
    @Column(name = "weight", nullable = true, length = 32)
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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
    @Column(name = "qty", nullable = true, length = 20)
    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "driver_name", nullable = true, length = 50)
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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
    @Column(name = "pick_up_weight", nullable = true, length = 50)
    public String getPickUpWeight() {
        return pickUpWeight;
    }

    public void setPickUpWeight(String pickUpWeight) {
        this.pickUpWeight = pickUpWeight;
    }

    @Basic
    @Column(name = "company_name", nullable = true, length = 50)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
    @Column(name = "id_num", nullable = true, length = 50)
    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Basic
    @Column(name = "car_num", nullable = true, length = 50)
    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ret1", nullable = true, length = 50)
    public String getRet1() {
        return ret1;
    }

    public void setRet1(String ret1) {
        this.ret1 = ret1;
    }

    @Basic
    @Column(name = "ret2", nullable = true, length = 50)
    public String getRet2() {
        return ret2;
    }

    public void setRet2(String ret2) {
        this.ret2 = ret2;
    }

    @Basic
    @Column(name = "ret3", nullable = true, length = 50)
    public String getRet3() {
        return ret3;
    }

    public void setRet3(String ret3) {
        this.ret3 = ret3;
    }

    @Basic
    @Column(name = "ret4", nullable = true, length = 50)
    public String getRet4() {
        return ret4;
    }

    public void setRet4(String ret4) {
        this.ret4 = ret4;
    }

    @Basic
    @Column(name = "ret5", nullable = true, length = 50)
    public String getRet5() {
        return ret5;
    }

    public void setRet5(String ret5) {
        this.ret5 = ret5;
    }

    @Basic
    @Column(name = "if_upload", nullable = true, length = 1)
    public String getIfUpload() {
        return ifUpload;
    }

    public void setIfUpload(String ifUpload) {
        this.ifUpload = ifUpload;
    }

    @Basic
    @Column(name = "return_msg", nullable = true, length = 500)
    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Basic
    @Column(name = "return_time", nullable = true)
    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryUploadEntity that = (DeliveryUploadEntity) o;
        return uploadId == that.uploadId &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(deliveryNum, that.deliveryNum) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(driverName, that.driverName) &&
                Objects.equals(driverId, that.driverId) &&
                Objects.equals(pickUpWeight, that.pickUpWeight) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(idNum, that.idNum) &&
                Objects.equals(carNum, that.carNum) &&
                Objects.equals(status, that.status) &&
                Objects.equals(ret1, that.ret1) &&
                Objects.equals(ret2, that.ret2) &&
                Objects.equals(ret3, that.ret3) &&
                Objects.equals(ret4, that.ret4) &&
                Objects.equals(ret5, that.ret5) &&
                Objects.equals(ifUpload, that.ifUpload) &&
                Objects.equals(returnMsg, that.returnMsg) &&
                Objects.equals(returnTime, that.returnTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uploadId, platformId, publishId, deliveryId, deliveryNum, weight, amount, qty, driverName, driverId, pickUpWeight, companyName, createDate, idNum, carNum, status, ret1, ret2, ret3, ret4, ret5, ifUpload, returnMsg, returnTime);
    }
}