package com.brcc.business.brokerFunds.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
/**
 * @Description 资金流水明细实体类
 * @Author pjy
 * @Date
 **/
@Entity
@Table(name = "brokerfundscontroldetail")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="BrokerfundscontroldetailEntity.findAll", query="SELECT g FROM BrokerfundscontroldetailEntity g")
public class BrokerfundscontroldetailEntity {
    private Long fundsControlDetailId;
    private String platformId;
    private Long fundsControlMasterId;
    private String fundsControlMasterNum;
    private Long publishId;
    private Long transId;
    private Long deliveryId;
    private Long publishCompanyId;
    private String publishCompanyName;
    private Integer goodType;
    private String goodTypeDesc;
    private String driverName;
    private Integer driverId;
    private String driverPhone;
    private Integer vehicleId;
    private String vehicleNum;
    private String vehicleType;
    private String carAxle;
    private String startPlate;
    private String endPlate;
    private BigDecimal estimateKM;
    private Date qdCreateDate;
    private Date qdFinishDate;
    private Integer useMinute;
    private Long createPersonId;
    private String createPersonName;
    private Date createDate;
    private Long firstAuditId;
    private String firstAuditName;
    private Date firstAuditDate;
    private Long secondAuditId;
    private String secondAuditName;
    private Date secondAuditDate;
    private String fcCarryName;
    private BigDecimal fcCarryAmount;
    private Integer fcIfUpload;
    private Long payBillId;
    private String detailStatus;
    private String detailStatusRemark;
    private String brokerTaxCycleName;
    private Integer companyOwnerId;

    @Id
    @Column(name = "funds_control_detail_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getFundsControlDetailId() {
        return fundsControlDetailId;
    }

    public void setFundsControlDetailId(Long fundsControlDetailId) {
        this.fundsControlDetailId = fundsControlDetailId;
    }

    @Basic
    @Column(name = "platform_id")
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "funds_control_master_id")
    public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
    }

    @Basic
    @Column(name = "funds_control_master_num")
    public String getFundsControlMasterNum() {
        return fundsControlMasterNum;
    }

    public void setFundsControlMasterNum(String fundsControlMasterNum) {
        this.fundsControlMasterNum = fundsControlMasterNum;
    }

    @Basic
    @Column(name = "publish_id")
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "trans_id")
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    @Basic
    @Column(name = "delivery_id")
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "publish_company_id")
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "publish_company_name")
    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    @Basic
    @Column(name = "good_type")
    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    @Basic
    @Column(name = "good_type_desc")
    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    @Basic
    @Column(name = "driver_name")
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Basic
    @Column(name = "driver_id")
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "driver_phone")
    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    @Basic
    @Column(name = "vehicle_id")
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "vehicle_num")
    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    @Basic
    @Column(name = "vehicle_type")
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Basic
    @Column(name = "car_axle")
    public String getCarAxle() {
        return carAxle;
    }

    public void setCarAxle(String carAxle) {
        this.carAxle = carAxle;
    }

    @Basic
    @Column(name = "start_plate")
    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    @Basic
    @Column(name = "end_plate")
    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    @Basic
    @Column(name = "estimateKM")
    public BigDecimal getEstimateKM() {
        return estimateKM;
    }

    public void setEstimateKM(BigDecimal estimateKM) {
        this.estimateKM = estimateKM;
    }

    @Basic
    @Column(name = "qd_create_date")
    public Date getQdCreateDate() {
        return qdCreateDate;
    }

    public void setQdCreateDate(Date qdCreateDate) {
        this.qdCreateDate = qdCreateDate;
    }

    @Basic
    @Column(name = "qd_finish_date")
    public Date getQdFinishDate() {
        return qdFinishDate;
    }

    public void setQdFinishDate(Date qdFinishDate) {
        this.qdFinishDate = qdFinishDate;
    }

    @Basic
    @Column(name = "use_minute")
    public Integer getUseMinute() {
        return useMinute;
    }

    public void setUseMinute(Integer useMinute) {
        this.useMinute = useMinute;
    }

    @Basic
    @Column(name = "create_person_id")
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name")
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "first_audit_id")
    public Long getFirstAuditId() {
        return firstAuditId;
    }

    public void setFirstAuditId(Long firstAuditId) {
        this.firstAuditId = firstAuditId;
    }
    @Basic
    @Column(name = "first_audit_name")
    public String getFirstAuditName() {
        return firstAuditName;
    }

    public void setFirstAuditName(String firstAuditName) {
        this.firstAuditName = firstAuditName;
    }
    @Basic
    @Column(name = "first_audit_date")
    public Date getFirstAuditDate() {
        return firstAuditDate;
    }

    public void setFirstAuditDate(Date firstAuditDate) {
        this.firstAuditDate = firstAuditDate;
    }
    @Basic
    @Column(name = "second_audit_id")
    public Long getSecondAuditId() {
        return secondAuditId;
    }

    public void setSecondAuditId(Long secondAuditId) {
        this.secondAuditId = secondAuditId;
    }
    @Basic
    @Column(name = "second_audit_name")
    public String getSecondAuditName() {
        return secondAuditName;
    }

    public void setSecondAuditName(String secondAuditName) {
        this.secondAuditName = secondAuditName;
    }
    @Basic
    @Column(name = "second_audit_date")
    public Date getSecondAuditDate() {
        return secondAuditDate;
    }

    public void setSecondAuditDate(Date secondAuditDate) {
        this.secondAuditDate = secondAuditDate;
    }
    @Basic
    @Column(name = "fc_carry_name")
    public String getFcCarryName() {
        return fcCarryName;
    }

    public void setFcCarryName(String fcCarryName) {
        this.fcCarryName = fcCarryName;
    }
    @Basic
    @Column(name = "fc_carry_amount")
    public BigDecimal getFcCarryAmount() {
        return fcCarryAmount;
    }

    public void setFcCarryAmount(BigDecimal fcCarryAmount) {
        this.fcCarryAmount = fcCarryAmount;
    }
    @Basic
    @Column(name = "fc_if_upload")
    public Integer getFcIfUpload() {
        return fcIfUpload;
    }

    public void setFcIfUpload(Integer fcIfUpload) {
        this.fcIfUpload = fcIfUpload;
    }
    @Basic
    @Column(name = "pay_bill_id")
    public Long getPayBillId() {
        return payBillId;
    }

    public void setPayBillId(Long payBillId) {
        this.payBillId = payBillId;
    }
    @Basic
    @Column(name = "detail_status")
    public String getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus;
    }
    @Basic
    @Column(name = "detail_status_remark")
    public String getDetailStatusRemark() {
        return detailStatusRemark;
    }

    public void setDetailStatusRemark(String detailStatusRemark) {
        this.detailStatusRemark = detailStatusRemark;
    }

    @Basic
    @Column(name = "broker_tax_cycle_name")
    public String getBrokerTaxCycleName() {
        return brokerTaxCycleName;
    }

    public void setBrokerTaxCycleName(String brokerTaxCycleName) {
        this.brokerTaxCycleName = brokerTaxCycleName;
    }
    @Basic
    @Column(name = "company_owner_id")
    public Integer getCompanyOwnerId() {
        return companyOwnerId;
    }

    public void setCompanyOwnerId(Integer companyOwnerId) {
        this.companyOwnerId = companyOwnerId;
    }
}
