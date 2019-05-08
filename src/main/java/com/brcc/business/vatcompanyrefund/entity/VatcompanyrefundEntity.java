package com.brcc.business.vatcompanyrefund.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 9:57 2018/11/16
 */
@Entity
@Table(name = "vatcompanyrefund")
public class VatcompanyrefundEntity {

    @Id
    @Column(name = "vat_company_refund_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vatCompanyRefundId;

    @Basic
    @Column(name = "vat_company_refund_num")
    private String vatCompanyRefundNum;

    @Basic
    @Column(name = "platform_id")
    private String platformId;

    @Basic
    @Column(name = "client_id")
    private Long clientId;

    @Basic
    @Column(name = "client_name")
    private String clientName;

    @Basic
    @Column(name = "carry_id")
    private Long carryId;

    @Basic
    @Column(name = "carry_name")
    private String carryName;

    @Basic
    @Column(name = "refund_status")
    private String refundStatus;

    @Basic
    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    @Basic
    @Column(name = "refund_amount_pic")
    private String refundAmountPic;

    @Basic
    @Column(name = "create_remark")
    private String createRemark;

    @Basic
    @Column(name = "create_person_id")
    private Long createPersonId;

    @Basic
    @Column(name = "create_person_name")
    private String createPersonName;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "audit_remark")
    private String auditRemark;

    @Basic
    @Column(name = "audit_person_id")
    private Long auditPersonId;

    @Basic
    @Column(name = "audit_person_name")
    private String auditPersonName;

    @Basic
    @Column(name = "audit_date")
    private Date auditDate;


    public Long getVatCompanyRefundId() {
        return vatCompanyRefundId;
    }

    public void setVatCompanyRefundId(Long vatCompanyRefundId) {
        this.vatCompanyRefundId = vatCompanyRefundId;
    }

    public String getVatCompanyRefundNum() {
        return vatCompanyRefundNum;
    }

    public void setVatCompanyRefundNum(String vatCompanyRefundNum) {
        this.vatCompanyRefundNum = vatCompanyRefundNum;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getCarryId() {
        return carryId;
    }

    public void setCarryId(Long carryId) {
        this.carryId = carryId;
    }

    public String getCarryName() {
        return carryName;
    }

    public void setCarryName(String carryName) {
        this.carryName = carryName;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundAmountPic() {
        return refundAmountPic;
    }

    public void setRefundAmountPic(String refundAmountPic) {
        this.refundAmountPic = refundAmountPic;
    }

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
    }

    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Long getAuditPersonId() {
        return auditPersonId;
    }

    public void setAuditPersonId(Long auditPersonId) {
        this.auditPersonId = auditPersonId;
    }

    public String getAuditPersonName() {
        return auditPersonName;
    }

    public void setAuditPersonName(String auditPersonName) {
        this.auditPersonName = auditPersonName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatcompanyrefundEntity that = (VatcompanyrefundEntity) o;
        return vatCompanyRefundId == that.vatCompanyRefundId &&
                Objects.equals(vatCompanyRefundNum, that.vatCompanyRefundNum) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(carryId, that.carryId) &&
                Objects.equals(carryName, that.carryName) &&
                Objects.equals(refundStatus, that.refundStatus) &&
                Objects.equals(refundAmount, that.refundAmount) &&
                Objects.equals(refundAmountPic, that.refundAmountPic) &&
                Objects.equals(createRemark, that.createRemark) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(auditRemark, that.auditRemark) &&
                Objects.equals(auditPersonId, that.auditPersonId) &&
                Objects.equals(auditPersonName, that.auditPersonName) &&
                Objects.equals(auditDate, that.auditDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatCompanyRefundId, vatCompanyRefundNum, platformId, clientId, clientName, carryId, carryName, refundStatus, refundAmount, refundAmountPic, createRemark, createPersonId, createPersonName, createDate, auditRemark, auditPersonId, auditPersonName, auditDate);
    }
}
