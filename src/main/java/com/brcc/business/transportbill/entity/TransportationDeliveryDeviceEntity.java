package com.brcc.business.transportbill.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-15 13:59
 */
@Entity
@Table(name = "transportation_delivery_device")
public class TransportationDeliveryDeviceEntity {

    private Long id;
    private String deviceId;
    private Long publishCompanyId;
    private Long groupId;
    private Long driverId;
    private Long publishId;
    private Long deliveryId;
    private String platformId;
    private String deliveryStatus;
    private String operateType;
    private String status;
    private Date updateDate;
    private Date createDate;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_id", nullable = false, length = 128)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "publish_company_id", nullable = false)
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "group_id", nullable = false)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "driver_id", nullable = false)
    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "publish_id", nullable = false)
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "delivery_id", nullable = false)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "platform_id", nullable = false, length = 128)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "delivery_status", nullable = true, length = 128)
    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Basic
    @Column(name = "operate_type", nullable = true, length = 128)
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 128)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportationDeliveryDeviceEntity that = (TransportationDeliveryDeviceEntity) o;
        return id == that.id &&
                publishCompanyId == that.publishCompanyId &&
                groupId == that.groupId &&
                driverId == that.driverId &&
                publishId == that.publishId &&
                deliveryId == that.deliveryId &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(deliveryStatus, that.deliveryStatus) &&
                Objects.equals(operateType, that.operateType) &&
                Objects.equals(status, that.status) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deviceId, publishCompanyId, groupId, driverId, publishId, deliveryId, platformId, deliveryStatus, operateType, status, updateDate, createDate);
    }
}