package com.brcc.business.vatcompanyrecharge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 16:26 2018/11/13
 */
@Entity
@Table(name = "vatcompanyrecharge")
public class VatcompanyrechargeEntity {

    @Id
    @Column(name = "vat_company_recharge_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vatCompanyRechargeId;

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
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "bank_amount")
    private BigDecimal bankAmount;

    @Basic
    @Column(name = "bank_amount_pic")
    private String bankAmountPic;

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

    @Basic
    @Column(name = "audit_num")
    private String auditNum;

    @Basic
    @Column(name = "business_num")
    private String businessNum;

    @Basic
    @Column(name = "vat_audit_name")
    private String vatAuditName;

    @Basic
    @Column(name = "vat_director_name")
    private String vatDirectorName;


    public Long getVatCompanyRechargeId() {
        return vatCompanyRechargeId;
    }

    public void setVatCompanyRechargeId(Long vatCompanyRechargeId) {
        this.vatCompanyRechargeId = vatCompanyRechargeId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
    }

    public String getBankAmountPic() {
        return bankAmountPic;
    }

    public void setBankAmountPic(String bankAmountPic) {
        this.bankAmountPic = bankAmountPic;
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

    public String getAuditNum() {
        return auditNum;
    }

    public void setAuditNum(String auditNum) {
        this.auditNum = auditNum;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getVatAuditName() {
        return vatAuditName;
    }

    public void setVatAuditName(String vatAuditName) {
        this.vatAuditName = vatAuditName;
    }

    public String getVatDirectorName() {
        return vatDirectorName;
    }

    public void setVatDirectorName(String vatDirectorName) {
        this.vatDirectorName = vatDirectorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatcompanyrechargeEntity that = (VatcompanyrechargeEntity) o;
        return vatCompanyRechargeId == that.vatCompanyRechargeId &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(carryId, that.carryId) &&
                Objects.equals(carryName, that.carryName) &&
                Objects.equals(status, that.status) &&
                Objects.equals(bankAmount, that.bankAmount) &&
                Objects.equals(bankAmountPic, that.bankAmountPic) &&
                Objects.equals(createRemark, that.createRemark) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(auditRemark, that.auditRemark) &&
                Objects.equals(auditPersonId, that.auditPersonId) &&
                Objects.equals(auditPersonName, that.auditPersonName) &&
                Objects.equals(auditDate, that.auditDate) &&
                Objects.equals(auditNum, that.auditNum) &&
                Objects.equals(businessNum, that.businessNum) &&
                Objects.equals(vatAuditName, that.vatAuditName) &&
                Objects.equals(vatDirectorName, that.vatDirectorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatCompanyRechargeId, platformId, clientId, clientName, carryId, carryName, status, bankAmount, bankAmountPic, createRemark, createPersonId, createPersonName, createDate, auditRemark, auditPersonId, auditPersonName, auditDate, auditNum, businessNum, vatAuditName, vatDirectorName);
    }
}
