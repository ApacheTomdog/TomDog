package com.brcc.business.creditRepay.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 16:36 2018/11/7
 */
@Entity
@Table(name = "credit_repay")
public class CreditRepayEntity {

    @Id
    @Column(name = "credit_repay_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditRepayId;

    @Basic
    @Column(name = "credit_repay_no")
    private String creditRepayNo;

    @Basic
    @Column(name = "platform_id")
    private String platformId;

    @Basic
    @Column(name = "credit_company_id")
    private Long creditCompanyId;

    @Basic
    @Column(name = "credit_company_name")
    private String creditCompanyName;

    @Basic
    @Column(name = "invest_company_id")
    private Long investCompanyId;

    @Basic
    @Column(name = "invest_company_name")
    private String investCompanyName;

    @Basic
    @Column(name = "credit_repay_amt")
    private BigDecimal creditRepayAmt;

    @Basic
    @Column(name = "credit_repay_pic")
    private String creditRepayPic;

    @Basic
    @Column(name = "credit_repay_status")
    private String creditRepayStatus;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "create_person_id")
    private Long createPersonId;

    @Basic
    @Column(name = "create_person_name")
    private String createPersonName;

    @Basic
    @Column(name = "create_remark")
    private String createRemark;

    @Basic
    @Column(name = "modify_date")
    private Date modifyDate;

    @Basic
    @Column(name = "modify_person_id")
    private Long modifyPersonId;

    @Basic
    @Column(name = "modify_person_name")
    private String modifyPersonName;

    @Basic
    @Column(name = "audit_date")
    private Date auditDate;

    @Basic
    @Column(name = "audit_person_id")
    private Long auditPersonId;

    @Basic
    @Column(name = "audit_person_name")
    private String auditPersonName;

    @Basic
    @Column(name = "audit_remark")
    private String auditRemark;


    public Long getCreditRepayId() {
        return creditRepayId;
    }

    public void setCreditRepayId(Long creditRepayId) {
        this.creditRepayId = creditRepayId;
    }

    public String getCreditRepayNo() {
        return creditRepayNo;
    }

    public void setCreditRepayNo(String creditRepayNo) {
        this.creditRepayNo = creditRepayNo;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getCreditCompanyId() {
        return creditCompanyId;
    }

    public void setCreditCompanyId(Long creditCompanyId) {
        this.creditCompanyId = creditCompanyId;
    }

    public String getCreditCompanyName() {
        return creditCompanyName;
    }

    public void setCreditCompanyName(String creditCompanyName) {
        this.creditCompanyName = creditCompanyName;
    }

    public Long getInvestCompanyId() {
        return investCompanyId;
    }

    public void setInvestCompanyId(Long investCompanyId) {
        this.investCompanyId = investCompanyId;
    }

    public String getInvestCompanyName() {
        return investCompanyName;
    }

    public void setInvestCompanyName(String investCompanyName) {
        this.investCompanyName = investCompanyName;
    }

    public BigDecimal getCreditRepayAmt() {
        return creditRepayAmt;
    }

    public void setCreditRepayAmt(BigDecimal creditRepayAmt) {
        this.creditRepayAmt = creditRepayAmt;
    }

    public String getCreditRepayPic() {
        return creditRepayPic;
    }

    public void setCreditRepayPic(String creditRepayPic) {
        this.creditRepayPic = creditRepayPic;
    }

    public String getCreditRepayStatus() {
        return creditRepayStatus;
    }

    public void setCreditRepayStatus(String creditRepayStatus) {
        this.creditRepayStatus = creditRepayStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditRepayEntity that = (CreditRepayEntity) o;
        return creditRepayId == that.creditRepayId &&
                Objects.equals(creditRepayNo, that.creditRepayNo) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(creditCompanyId, that.creditCompanyId) &&
                Objects.equals(creditCompanyName, that.creditCompanyName) &&
                Objects.equals(investCompanyId, that.investCompanyId) &&
                Objects.equals(investCompanyName, that.investCompanyName) &&
                Objects.equals(creditRepayAmt, that.creditRepayAmt) &&
                Objects.equals(creditRepayPic, that.creditRepayPic) &&
                Objects.equals(creditRepayStatus, that.creditRepayStatus) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(createRemark, that.createRemark) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(auditDate, that.auditDate) &&
                Objects.equals(auditPersonId, that.auditPersonId) &&
                Objects.equals(auditPersonName, that.auditPersonName) &&
                Objects.equals(auditRemark, that.auditRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditRepayId, creditRepayNo, platformId, creditCompanyId, creditCompanyName, investCompanyId, investCompanyName, creditRepayAmt, creditRepayPic, creditRepayStatus, createDate, createPersonId, createPersonName, createRemark, modifyDate, modifyPersonId, modifyPersonName, auditDate, auditPersonId, auditPersonName, auditRemark);
    }
}
