package com.brcc.business.ordercancel.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-06 21:38
 */
@Entity
@Table(name = "deliverycancelaudit")
public class DeliverycancelauditEntity {

    private Long deliveryCancelId;
    private String platformId;
    private Long publishId;
    private Long transId;
    private Long deliveryId;
    private String deliveryCancelType;
    private Long carryCompanyId;
    private String carryCompanyName;
    private Long driverId;
    private String driverName;
    private Long vehicleId;
    private String vehicleNum;
    private String docuType;
    private String remark;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private String auditRemark;
    private Date auditDate;
    private Long auditPersonId;
    private String auditPersonName;
    private Long fdCompanyId;
    private Long fdUserId;
    private String ifCanShow;

    @Id
    @Column(name = "delivery_cancel_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDeliveryCancelId() {
        return deliveryCancelId;
    }

    public void setDeliveryCancelId(Long deliveryCancelId) {
        this.deliveryCancelId = deliveryCancelId;
    }

    @Basic
    @Column(name = "platform_id", nullable = false, length = 20)
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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
    @Column(name = "trans_id", nullable = false)
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
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
    @Column(name = "delivery_cancel_type", nullable = false, length = 2)
    public String getDeliveryCancelType() {
        return deliveryCancelType;
    }

    public void setDeliveryCancelType(String deliveryCancelType) {
        this.deliveryCancelType = deliveryCancelType;
    }

    @Basic
    @Column(name = "carry_company_id", nullable = false)
    public Long getCarryCompanyId() {
        return carryCompanyId;
    }

    public void setCarryCompanyId(Long carryCompanyId) {
        this.carryCompanyId = carryCompanyId;
    }

    @Basic
    @Column(name = "carry_company_name", nullable = false, length = 100)
    public String getCarryCompanyName() {
        return carryCompanyName;
    }

    public void setCarryCompanyName(String carryCompanyName) {
        this.carryCompanyName = carryCompanyName;
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
    @Column(name = "driver_name", nullable = false, length = 100)
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Basic
    @Column(name = "vehicle_id", nullable = false)
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "vehicle_num", nullable = false, length = 20)
    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    @Basic
    @Column(name = "docu_type", nullable = true, length = 10)
    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
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
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_person_id", nullable = true)
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name", nullable = true, length = 100)
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "modify_date", nullable = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "modify_person_id", nullable = true)
    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name", nullable = true, length = 100)
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "audit_remark", nullable = true, length = 500)
    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Basic
    @Column(name = "audit_date", nullable = true)
    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    @Basic
    @Column(name = "audit_person_id", nullable = true)
    public Long getAuditPersonId() {
        return auditPersonId;
    }

    public void setAuditPersonId(Long auditPersonId) {
        this.auditPersonId = auditPersonId;
    }

    @Basic
    @Column(name = "audit_person_name", nullable = true, length = 100)
    public String getAuditPersonName() {
        return auditPersonName;
    }

    public void setAuditPersonName(String auditPersonName) {
        this.auditPersonName = auditPersonName;
    }

    @Basic
    @Column(name = "fd_company_id", nullable = false)
    public Long getFdCompanyId() {
        return fdCompanyId;
    }

    public void setFdCompanyId(Long fdCompanyId) {
        this.fdCompanyId = fdCompanyId;
    }

    @Basic
    @Column(name = "fd_user_id", nullable = false)
    public Long getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(Long fdUserId) {
        this.fdUserId = fdUserId;
    }

    @Basic
    @Column(name = "if_can_show", nullable = false, length = 2)
    public String getIfCanShow() {
        return ifCanShow;
    }

    public void setIfCanShow(String ifCanShow) {
        this.ifCanShow = ifCanShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliverycancelauditEntity that = (DeliverycancelauditEntity) o;
        return deliveryCancelId == that.deliveryCancelId &&
                publishId == that.publishId &&
                transId == that.transId &&
                deliveryId == that.deliveryId &&
                carryCompanyId == that.carryCompanyId &&
                driverId == that.driverId &&
                vehicleId == that.vehicleId &&
                fdCompanyId == that.fdCompanyId &&
                fdUserId == that.fdUserId &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(deliveryCancelType, that.deliveryCancelType) &&
                Objects.equals(carryCompanyName, that.carryCompanyName) &&
                Objects.equals(driverName, that.driverName) &&
                Objects.equals(vehicleNum, that.vehicleNum) &&
                Objects.equals(docuType, that.docuType) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(auditRemark, that.auditRemark) &&
                Objects.equals(auditDate, that.auditDate) &&
                Objects.equals(auditPersonId, that.auditPersonId) &&
                Objects.equals(auditPersonName, that.auditPersonName) &&
                Objects.equals(ifCanShow, that.ifCanShow);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deliveryCancelId, platformId, publishId, transId, deliveryId, deliveryCancelType, carryCompanyId, carryCompanyName, driverId, driverName, vehicleId, vehicleNum, docuType, remark, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, auditRemark, auditDate, auditPersonId, auditPersonName, fdCompanyId, fdUserId, ifCanShow);
    }
}