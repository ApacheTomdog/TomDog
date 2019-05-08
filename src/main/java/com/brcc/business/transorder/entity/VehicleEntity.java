package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-12-04 10:27
 */
@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    private Long vehicleId;
    private String vehicleNum;
    private String contactName;
    private String contactMobile;
    private BigDecimal tonnage;
    private String platformId;
    private Date createDate;
    private String status;
    private String isAvailable;
    private String createPerson;
    private String vehicleType;
    private String frameUmber;
    private BigDecimal meter;
    private String cardPicLocal;
    private String cardPicRemote;
    private String vehiclePicLocal;
    private String vehiclePicRemote;
    private Integer vehicleTypeId;
    private String carAxle;
    private String annualDate;
    private String roadPicLocal;
    private String roadPicRemote;
    private String imei;
    private String gpsMobile;
    private String updatePerson;
    private Date updateDate;
    private String remark;
    private String isBindingGps;
    private Date bindingDate;
    private Date unbindingDate;
    private String gcCardPicLocal;
    private String gcCardPicRemote;
    private String gcTransPicLocal;
    private String gcTransPicRemote;
    private String zcTransPicLocal;
    private String zcTransPicRemote;
    private Date carAuditDate;
    private String vehicleTypeCode;
    private String vehicleLicenseCode;
    private String vehicleLicenseName;
    private String ifHandCar;
    private String handCarNo;
    private String roadTransNo;
    private String ifSecondAudit;
    private String hazardousVehiclePicLocal;
    private String hazardousTransportPicLocal;
    private String hazardousVehiclePicRemote;
    private String hazardousTransportPicRemote;
    private String carAxleUpdatePerson;
    private Date carAxleUpdateDate;
    private String carAxleUpdatePersonName;
    private String carAxleRemark;
    private String cardPicRemark;
    private String cardPicCheck;
    private Date cardPicAuditDate;
    private String cardPicAuditPerson;
    private String vehiclePicCheck;
    private String vehiclePicRemark;
    private Date vehiclePicAuditDate;
    private String vehiclePicAuditPerson;
    private String ifUploadWccyr;
    private Date ifUploadWccyrDate;
    private Integer auditPersonId;
    private String auditPersonName;
    private Date auditDate;
    private String wccyrNetworkAbnormality;
    private Date wccyrZcTransDate;
    private Date wccyrSaveDate;
    private Integer wccyrSavePersonId;
    private String wccyrSavePersonName;
    private String wccyrSelfRemark;
    private String provinceSn;
    private String dumpTruckFlag;

    @Id
    @Column(name = "vehicle_id", nullable = false)
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "vehicle_num", nullable = true, length = 20)
    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    @Basic
    @Column(name = "contact_name", nullable = true, length = 20)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contact_mobile", nullable = true, length = 20)
    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    @Basic
    @Column(name = "tonnage", nullable = true, precision = 0)
    public BigDecimal getTonnage() {
        return tonnage;
    }

    public void setTonnage(BigDecimal tonnage) {
        this.tonnage = tonnage;
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
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "is_available", nullable = true, length = 20)
    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Basic
    @Column(name = "create_person", nullable = true, length = 20)
    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    @Basic
    @Column(name = "vehicle_type", nullable = true, length = 20)
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Basic
    @Column(name = "Frame_umber", nullable = true, length = 20)
    public String getFrameUmber() {
        return frameUmber;
    }

    public void setFrameUmber(String frameUmber) {
        this.frameUmber = frameUmber;
    }

    @Basic
    @Column(name = "meter", nullable = true, precision = 2)
    public BigDecimal getMeter() {
        return meter;
    }

    public void setMeter(BigDecimal meter) {
        this.meter = meter;
    }

    @Basic
    @Column(name = "card_pic_local", nullable = true, length = 200)
    public String getCardPicLocal() {
        return cardPicLocal;
    }

    public void setCardPicLocal(String cardPicLocal) {
        this.cardPicLocal = cardPicLocal;
    }

    @Basic
    @Column(name = "card_pic_remote", nullable = true, length = 200)
    public String getCardPicRemote() {
        return cardPicRemote;
    }

    public void setCardPicRemote(String cardPicRemote) {
        this.cardPicRemote = cardPicRemote;
    }

    @Basic
    @Column(name = "vehicle_pic_local", nullable = true, length = 200)
    public String getVehiclePicLocal() {
        return vehiclePicLocal;
    }

    public void setVehiclePicLocal(String vehiclePicLocal) {
        this.vehiclePicLocal = vehiclePicLocal;
    }

    @Basic
    @Column(name = "vehicle_pic_remote", nullable = true, length = 200)
    public String getVehiclePicRemote() {
        return vehiclePicRemote;
    }

    public void setVehiclePicRemote(String vehiclePicRemote) {
        this.vehiclePicRemote = vehiclePicRemote;
    }

    @Basic
    @Column(name = "vehicle_type_id", nullable = true)
    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Basic
    @Column(name = "car_axle", nullable = true, length = 10)
    public String getCarAxle() {
        return carAxle;
    }

    public void setCarAxle(String carAxle) {
        this.carAxle = carAxle;
    }

    @Basic
    @Column(name = "annual_date", nullable = true, length = 10)
    public String getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(String annualDate) {
        this.annualDate = annualDate;
    }

    @Basic
    @Column(name = "road_pic_local", nullable = true, length = 200)
    public String getRoadPicLocal() {
        return roadPicLocal;
    }

    public void setRoadPicLocal(String roadPicLocal) {
        this.roadPicLocal = roadPicLocal;
    }

    @Basic
    @Column(name = "road_pic_remote", nullable = true, length = 200)
    public String getRoadPicRemote() {
        return roadPicRemote;
    }

    public void setRoadPicRemote(String roadPicRemote) {
        this.roadPicRemote = roadPicRemote;
    }

    @Basic
    @Column(name = "imei", nullable = true, length = 45)
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Basic
    @Column(name = "gps_mobile", nullable = true, length = 20)
    public String getGpsMobile() {
        return gpsMobile;
    }

    public void setGpsMobile(String gpsMobile) {
        this.gpsMobile = gpsMobile;
    }

    @Basic
    @Column(name = "update_person", nullable = true, length = 20)
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
    @Column(name = "remark", nullable = true, length = 2000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "is_binding_gps", nullable = true, length = 1)
    public String getIsBindingGps() {
        return isBindingGps;
    }

    public void setIsBindingGps(String isBindingGps) {
        this.isBindingGps = isBindingGps;
    }

    @Basic
    @Column(name = "binding_date", nullable = true)
    public Date getBindingDate() {
        return bindingDate;
    }

    public void setBindingDate(Date bindingDate) {
        this.bindingDate = bindingDate;
    }

    @Basic
    @Column(name = "unbinding_date", nullable = true)
    public Date getUnbindingDate() {
        return unbindingDate;
    }

    public void setUnbindingDate(Date unbindingDate) {
        this.unbindingDate = unbindingDate;
    }

    @Basic
    @Column(name = "gc_card_pic_local", nullable = true, length = 200)
    public String getGcCardPicLocal() {
        return gcCardPicLocal;
    }

    public void setGcCardPicLocal(String gcCardPicLocal) {
        this.gcCardPicLocal = gcCardPicLocal;
    }

    @Basic
    @Column(name = "gc_card_pic_remote", nullable = true, length = 200)
    public String getGcCardPicRemote() {
        return gcCardPicRemote;
    }

    public void setGcCardPicRemote(String gcCardPicRemote) {
        this.gcCardPicRemote = gcCardPicRemote;
    }

    @Basic
    @Column(name = "gc_trans_pic_local", nullable = true, length = 200)
    public String getGcTransPicLocal() {
        return gcTransPicLocal;
    }

    public void setGcTransPicLocal(String gcTransPicLocal) {
        this.gcTransPicLocal = gcTransPicLocal;
    }

    @Basic
    @Column(name = "gc_trans_pic_remote", nullable = true, length = 200)
    public String getGcTransPicRemote() {
        return gcTransPicRemote;
    }

    public void setGcTransPicRemote(String gcTransPicRemote) {
        this.gcTransPicRemote = gcTransPicRemote;
    }

    @Basic
    @Column(name = "zc_trans_pic_local", nullable = true, length = 200)
    public String getZcTransPicLocal() {
        return zcTransPicLocal;
    }

    public void setZcTransPicLocal(String zcTransPicLocal) {
        this.zcTransPicLocal = zcTransPicLocal;
    }

    @Basic
    @Column(name = "zc_trans_pic_remote", nullable = true, length = 200)
    public String getZcTransPicRemote() {
        return zcTransPicRemote;
    }

    public void setZcTransPicRemote(String zcTransPicRemote) {
        this.zcTransPicRemote = zcTransPicRemote;
    }

    @Basic
    @Column(name = "car_audit_date", nullable = true)
    public Date getCarAuditDate() {
        return carAuditDate;
    }

    public void setCarAuditDate(Date carAuditDate) {
        this.carAuditDate = carAuditDate;
    }

    @Basic
    @Column(name = "vehicle_type_code", nullable = true, length = 20)
    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    public void setVehicleTypeCode(String vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    @Basic
    @Column(name = "vehicle_license_code", nullable = true, length = 20)
    public String getVehicleLicenseCode() {
        return vehicleLicenseCode;
    }

    public void setVehicleLicenseCode(String vehicleLicenseCode) {
        this.vehicleLicenseCode = vehicleLicenseCode;
    }

    @Basic
    @Column(name = "vehicle_license_name", nullable = true, length = 100)
    public String getVehicleLicenseName() {
        return vehicleLicenseName;
    }

    public void setVehicleLicenseName(String vehicleLicenseName) {
        this.vehicleLicenseName = vehicleLicenseName;
    }

    @Basic
    @Column(name = "if_hand_car", nullable = true, length = 1)
    public String getIfHandCar() {
        return ifHandCar;
    }

    public void setIfHandCar(String ifHandCar) {
        this.ifHandCar = ifHandCar;
    }

    @Basic
    @Column(name = "hand_car_no", nullable = true, length = 20)
    public String getHandCarNo() {
        return handCarNo;
    }

    public void setHandCarNo(String handCarNo) {
        this.handCarNo = handCarNo;
    }

    @Basic
    @Column(name = "road_trans_no", nullable = true, length = 30)
    public String getRoadTransNo() {
        return roadTransNo;
    }

    public void setRoadTransNo(String roadTransNo) {
        this.roadTransNo = roadTransNo;
    }

    @Basic
    @Column(name = "if_second_audit", nullable = true, length = 1)
    public String getIfSecondAudit() {
        return ifSecondAudit;
    }

    public void setIfSecondAudit(String ifSecondAudit) {
        this.ifSecondAudit = ifSecondAudit;
    }

    @Basic
    @Column(name = "hazardous_vehicle_pic_local", nullable = true, length = 200)
    public String getHazardousVehiclePicLocal() {
        return hazardousVehiclePicLocal;
    }

    public void setHazardousVehiclePicLocal(String hazardousVehiclePicLocal) {
        this.hazardousVehiclePicLocal = hazardousVehiclePicLocal;
    }

    @Basic
    @Column(name = "hazardous_transport_pic_local", nullable = true, length = 200)
    public String getHazardousTransportPicLocal() {
        return hazardousTransportPicLocal;
    }

    public void setHazardousTransportPicLocal(String hazardousTransportPicLocal) {
        this.hazardousTransportPicLocal = hazardousTransportPicLocal;
    }

    @Basic
    @Column(name = "hazardous_vehicle_pic_remote", nullable = true, length = 200)
    public String getHazardousVehiclePicRemote() {
        return hazardousVehiclePicRemote;
    }

    public void setHazardousVehiclePicRemote(String hazardousVehiclePicRemote) {
        this.hazardousVehiclePicRemote = hazardousVehiclePicRemote;
    }

    @Basic
    @Column(name = "hazardous_transport_pic_remote", nullable = true, length = 200)
    public String getHazardousTransportPicRemote() {
        return hazardousTransportPicRemote;
    }

    public void setHazardousTransportPicRemote(String hazardousTransportPicRemote) {
        this.hazardousTransportPicRemote = hazardousTransportPicRemote;
    }

    @Basic
    @Column(name = "car_axle_update_person", nullable = true, length = 255)
    public String getCarAxleUpdatePerson() {
        return carAxleUpdatePerson;
    }

    public void setCarAxleUpdatePerson(String carAxleUpdatePerson) {
        this.carAxleUpdatePerson = carAxleUpdatePerson;
    }

    @Basic
    @Column(name = "car_axle_update_date", nullable = true)
    public Date getCarAxleUpdateDate() {
        return carAxleUpdateDate;
    }

    public void setCarAxleUpdateDate(Date carAxleUpdateDate) {
        this.carAxleUpdateDate = carAxleUpdateDate;
    }

    @Basic
    @Column(name = "car_axle_update_person_name", nullable = true, length = 255)
    public String getCarAxleUpdatePersonName() {
        return carAxleUpdatePersonName;
    }

    public void setCarAxleUpdatePersonName(String carAxleUpdatePersonName) {
        this.carAxleUpdatePersonName = carAxleUpdatePersonName;
    }

    @Basic
    @Column(name = "car_axle_remark", nullable = true, length = 500)
    public String getCarAxleRemark() {
        return carAxleRemark;
    }

    public void setCarAxleRemark(String carAxleRemark) {
        this.carAxleRemark = carAxleRemark;
    }

    @Basic
    @Column(name = "card_pic_remark", nullable = true, length = 50)
    public String getCardPicRemark() {
        return cardPicRemark;
    }

    public void setCardPicRemark(String cardPicRemark) {
        this.cardPicRemark = cardPicRemark;
    }

    @Basic
    @Column(name = "card_pic_check", nullable = true, length = 1)
    public String getCardPicCheck() {
        return cardPicCheck;
    }

    public void setCardPicCheck(String cardPicCheck) {
        this.cardPicCheck = cardPicCheck;
    }

    @Basic
    @Column(name = "card_pic_audit_date", nullable = true)
    public Date getCardPicAuditDate() {
        return cardPicAuditDate;
    }

    public void setCardPicAuditDate(Date cardPicAuditDate) {
        this.cardPicAuditDate = cardPicAuditDate;
    }

    @Basic
    @Column(name = "card_pic_audit_person", nullable = true, length = 100)
    public String getCardPicAuditPerson() {
        return cardPicAuditPerson;
    }

    public void setCardPicAuditPerson(String cardPicAuditPerson) {
        this.cardPicAuditPerson = cardPicAuditPerson;
    }

    @Basic
    @Column(name = "vehicle_pic_check", nullable = true, length = 1)
    public String getVehiclePicCheck() {
        return vehiclePicCheck;
    }

    public void setVehiclePicCheck(String vehiclePicCheck) {
        this.vehiclePicCheck = vehiclePicCheck;
    }

    @Basic
    @Column(name = "vehicle_pic_remark", nullable = true, length = 100)
    public String getVehiclePicRemark() {
        return vehiclePicRemark;
    }

    public void setVehiclePicRemark(String vehiclePicRemark) {
        this.vehiclePicRemark = vehiclePicRemark;
    }

    @Basic
    @Column(name = "vehicle_pic_audit_date", nullable = true)
    public Date getVehiclePicAuditDate() {
        return vehiclePicAuditDate;
    }

    public void setVehiclePicAuditDate(Date vehiclePicAuditDate) {
        this.vehiclePicAuditDate = vehiclePicAuditDate;
    }

    @Basic
    @Column(name = "vehicle_pic_audit_person", nullable = true, length = 100)
    public String getVehiclePicAuditPerson() {
        return vehiclePicAuditPerson;
    }

    public void setVehiclePicAuditPerson(String vehiclePicAuditPerson) {
        this.vehiclePicAuditPerson = vehiclePicAuditPerson;
    }

    @Basic
    @Column(name = "if_upload_wccyr", nullable = true, length = 1)
    public String getIfUploadWccyr() {
        return ifUploadWccyr;
    }

    public void setIfUploadWccyr(String ifUploadWccyr) {
        this.ifUploadWccyr = ifUploadWccyr;
    }

    @Basic
    @Column(name = "if_upload_wccyr_date", nullable = true)
    public Date getIfUploadWccyrDate() {
        return ifUploadWccyrDate;
    }

    public void setIfUploadWccyrDate(Date ifUploadWccyrDate) {
        this.ifUploadWccyrDate = ifUploadWccyrDate;
    }

    @Basic
    @Column(name = "audit_person_id", nullable = true)
    public Integer getAuditPersonId() {
        return auditPersonId;
    }

    public void setAuditPersonId(Integer auditPersonId) {
        this.auditPersonId = auditPersonId;
    }

    @Basic
    @Column(name = "audit_person_name", nullable = true, length = 50)
    public String getAuditPersonName() {
        return auditPersonName;
    }

    public void setAuditPersonName(String auditPersonName) {
        this.auditPersonName = auditPersonName;
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
    @Column(name = "wccyr_network_abnormality", nullable = true, length = 2)
    public String getWccyrNetworkAbnormality() {
        return wccyrNetworkAbnormality;
    }

    public void setWccyrNetworkAbnormality(String wccyrNetworkAbnormality) {
        this.wccyrNetworkAbnormality = wccyrNetworkAbnormality;
    }

    @Basic
    @Column(name = "wccyr_zc_trans_date", nullable = true)
    public Date getWccyrZcTransDate() {
        return wccyrZcTransDate;
    }

    public void setWccyrZcTransDate(Date wccyrZcTransDate) {
        this.wccyrZcTransDate = wccyrZcTransDate;
    }

    @Basic
    @Column(name = "wccyr_save_date", nullable = true)
    public Date getWccyrSaveDate() {
        return wccyrSaveDate;
    }

    public void setWccyrSaveDate(Date wccyrSaveDate) {
        this.wccyrSaveDate = wccyrSaveDate;
    }

    @Basic
    @Column(name = "wccyr_save_person_id", nullable = true)
    public Integer getWccyrSavePersonId() {
        return wccyrSavePersonId;
    }

    public void setWccyrSavePersonId(Integer wccyrSavePersonId) {
        this.wccyrSavePersonId = wccyrSavePersonId;
    }

    @Basic
    @Column(name = "wccyr_save_person_name", nullable = true, length = 100)
    public String getWccyrSavePersonName() {
        return wccyrSavePersonName;
    }

    public void setWccyrSavePersonName(String wccyrSavePersonName) {
        this.wccyrSavePersonName = wccyrSavePersonName;
    }

    @Basic
    @Column(name = "wccyr_self_remark", nullable = true, length = 10)
    public String getWccyrSelfRemark() {
        return wccyrSelfRemark;
    }

    public void setWccyrSelfRemark(String wccyrSelfRemark) {
        this.wccyrSelfRemark = wccyrSelfRemark;
    }

    @Basic
    @Column(name = "province_sn", nullable = true, length = 20)
    public String getProvinceSn() {
        return provinceSn;
    }

    public void setProvinceSn(String provinceSn) {
        this.provinceSn = provinceSn;
    }

    @Basic
    @Column(name = "dump_truck_flag", nullable = true, length = 1)
    public String getDumpTruckFlag() {
        return dumpTruckFlag;
    }

    public void setDumpTruckFlag(String dumpTruckFlag) {
        this.dumpTruckFlag = dumpTruckFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return vehicleId == that.vehicleId &&
                Objects.equals(vehicleNum, that.vehicleNum) &&
                Objects.equals(contactName, that.contactName) &&
                Objects.equals(contactMobile, that.contactMobile) &&
                Objects.equals(tonnage, that.tonnage) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(isAvailable, that.isAvailable) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(vehicleType, that.vehicleType) &&
                Objects.equals(frameUmber, that.frameUmber) &&
                Objects.equals(meter, that.meter) &&
                Objects.equals(cardPicLocal, that.cardPicLocal) &&
                Objects.equals(cardPicRemote, that.cardPicRemote) &&
                Objects.equals(vehiclePicLocal, that.vehiclePicLocal) &&
                Objects.equals(vehiclePicRemote, that.vehiclePicRemote) &&
                Objects.equals(vehicleTypeId, that.vehicleTypeId) &&
                Objects.equals(carAxle, that.carAxle) &&
                Objects.equals(annualDate, that.annualDate) &&
                Objects.equals(roadPicLocal, that.roadPicLocal) &&
                Objects.equals(roadPicRemote, that.roadPicRemote) &&
                Objects.equals(imei, that.imei) &&
                Objects.equals(gpsMobile, that.gpsMobile) &&
                Objects.equals(updatePerson, that.updatePerson) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(isBindingGps, that.isBindingGps) &&
                Objects.equals(bindingDate, that.bindingDate) &&
                Objects.equals(unbindingDate, that.unbindingDate) &&
                Objects.equals(gcCardPicLocal, that.gcCardPicLocal) &&
                Objects.equals(gcCardPicRemote, that.gcCardPicRemote) &&
                Objects.equals(gcTransPicLocal, that.gcTransPicLocal) &&
                Objects.equals(gcTransPicRemote, that.gcTransPicRemote) &&
                Objects.equals(zcTransPicLocal, that.zcTransPicLocal) &&
                Objects.equals(zcTransPicRemote, that.zcTransPicRemote) &&
                Objects.equals(carAuditDate, that.carAuditDate) &&
                Objects.equals(vehicleTypeCode, that.vehicleTypeCode) &&
                Objects.equals(vehicleLicenseCode, that.vehicleLicenseCode) &&
                Objects.equals(vehicleLicenseName, that.vehicleLicenseName) &&
                Objects.equals(ifHandCar, that.ifHandCar) &&
                Objects.equals(handCarNo, that.handCarNo) &&
                Objects.equals(roadTransNo, that.roadTransNo) &&
                Objects.equals(ifSecondAudit, that.ifSecondAudit) &&
                Objects.equals(hazardousVehiclePicLocal, that.hazardousVehiclePicLocal) &&
                Objects.equals(hazardousTransportPicLocal, that.hazardousTransportPicLocal) &&
                Objects.equals(hazardousVehiclePicRemote, that.hazardousVehiclePicRemote) &&
                Objects.equals(hazardousTransportPicRemote, that.hazardousTransportPicRemote) &&
                Objects.equals(carAxleUpdatePerson, that.carAxleUpdatePerson) &&
                Objects.equals(carAxleUpdateDate, that.carAxleUpdateDate) &&
                Objects.equals(carAxleUpdatePersonName, that.carAxleUpdatePersonName) &&
                Objects.equals(carAxleRemark, that.carAxleRemark) &&
                Objects.equals(cardPicRemark, that.cardPicRemark) &&
                Objects.equals(cardPicCheck, that.cardPicCheck) &&
                Objects.equals(cardPicAuditDate, that.cardPicAuditDate) &&
                Objects.equals(cardPicAuditPerson, that.cardPicAuditPerson) &&
                Objects.equals(vehiclePicCheck, that.vehiclePicCheck) &&
                Objects.equals(vehiclePicRemark, that.vehiclePicRemark) &&
                Objects.equals(vehiclePicAuditDate, that.vehiclePicAuditDate) &&
                Objects.equals(vehiclePicAuditPerson, that.vehiclePicAuditPerson) &&
                Objects.equals(ifUploadWccyr, that.ifUploadWccyr) &&
                Objects.equals(ifUploadWccyrDate, that.ifUploadWccyrDate) &&
                Objects.equals(auditPersonId, that.auditPersonId) &&
                Objects.equals(auditPersonName, that.auditPersonName) &&
                Objects.equals(auditDate, that.auditDate) &&
                Objects.equals(wccyrNetworkAbnormality, that.wccyrNetworkAbnormality) &&
                Objects.equals(wccyrZcTransDate, that.wccyrZcTransDate) &&
                Objects.equals(wccyrSaveDate, that.wccyrSaveDate) &&
                Objects.equals(wccyrSavePersonId, that.wccyrSavePersonId) &&
                Objects.equals(wccyrSavePersonName, that.wccyrSavePersonName) &&
                Objects.equals(wccyrSelfRemark, that.wccyrSelfRemark) &&
                Objects.equals(provinceSn, that.provinceSn) &&
                Objects.equals(dumpTruckFlag, that.dumpTruckFlag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleId, vehicleNum, contactName, contactMobile, tonnage, platformId, createDate, status, isAvailable, createPerson, vehicleType, frameUmber, meter, cardPicLocal, cardPicRemote, vehiclePicLocal, vehiclePicRemote, vehicleTypeId, carAxle, annualDate, roadPicLocal, roadPicRemote, imei, gpsMobile, updatePerson, updateDate, remark, isBindingGps, bindingDate, unbindingDate, gcCardPicLocal, gcCardPicRemote, gcTransPicLocal, gcTransPicRemote, zcTransPicLocal, zcTransPicRemote, carAuditDate, vehicleTypeCode, vehicleLicenseCode, vehicleLicenseName, ifHandCar, handCarNo, roadTransNo, ifSecondAudit, hazardousVehiclePicLocal, hazardousTransportPicLocal, hazardousVehiclePicRemote, hazardousTransportPicRemote, carAxleUpdatePerson, carAxleUpdateDate, carAxleUpdatePersonName, carAxleRemark, cardPicRemark, cardPicCheck, cardPicAuditDate, cardPicAuditPerson, vehiclePicCheck, vehiclePicRemark, vehiclePicAuditDate, vehiclePicAuditPerson, ifUploadWccyr, ifUploadWccyrDate, auditPersonId, auditPersonName, auditDate, wccyrNetworkAbnormality, wccyrZcTransDate, wccyrSaveDate, wccyrSavePersonId, wccyrSavePersonName, wccyrSelfRemark, provinceSn, dumpTruckFlag);
    }
}