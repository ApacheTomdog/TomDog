package com.brcc.business.creditConfig.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:31 2018/10/31
 */

@Entity
@Table(name = "credit_config")
@DynamicInsert
public class CreditConfigEntity {

    private Long creditConfigId;

    private Long publishCompanyId;

    private String publishCompanyName;

    private BigDecimal creditAmount;

    private Long creditDuration;

    private String creditStatus;

    private Date createDate;

    private String createPersonId;

    private String createPersonName;

    private Date modifyDate;

    private Long modifyPersonId;

    private String modifyPersonName;

    private String remark;

    private String platformId;

    private Long creditPlatCompanyId;

    private String creditFdStatus;

    @Id
    @Column(name = "credit_config_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCreditConfigId() {
        return creditConfigId;
    }

    public void setCreditConfigId(Long creditConfigId) {
        this.creditConfigId = creditConfigId;
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
    @Column(name = "credit_amount")
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Basic
    @Column(name = "credit_duration")
    public Long getCreditDuration() {
        return creditDuration;
    }

    public void setCreditDuration(Long creditDuration) {
        this.creditDuration = creditDuration;
    }

    @Basic
    @Column(name = "credit_status")
    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
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
    @Column(name = "create_person_id")
    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
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
    @Column(name = "modify_date")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "modify_person_id")
    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name")
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "credit_plat_company_id")
    public Long getCreditPlatCompanyId() {
        return creditPlatCompanyId;
    }

    public void setCreditPlatCompanyId(Long creditPlatCompanyId) {
        this.creditPlatCompanyId = creditPlatCompanyId;
    }

    @Basic
    @Column(name = "credit_fd_status")
    public String getCreditFdStatus() {
        return creditFdStatus;
    }

    public void setCreditFdStatus(String creditFdStatus) {
        this.creditFdStatus = creditFdStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditConfigEntity that = (CreditConfigEntity) o;
        return creditConfigId == that.creditConfigId &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(publishCompanyName, that.publishCompanyName) &&
                Objects.equals(creditAmount, that.creditAmount) &&
                Objects.equals(creditDuration, that.creditDuration) &&
                Objects.equals(creditStatus, that.creditStatus) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(creditPlatCompanyId, that.creditPlatCompanyId) &&
                Objects.equals(creditFdStatus, that.creditFdStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditConfigId, publishCompanyId, publishCompanyName, creditAmount, creditDuration, creditStatus, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, remark, platformId, creditPlatCompanyId, creditFdStatus);
    }
}
