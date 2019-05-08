package com.brcc.business.creditAmountAdjust.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 18:03 2018/11/1
 */
@Entity
@Table(name = "credit_amount_adjust")
public class CreditAmountAdjustEntity {
    private Long credAmtAdjId;
    private Long creditConfigId;
    private Long publishCompanyId;
    private String publishCompanyName;
    private BigDecimal creditAdjAmount;
    private String creditAdjStatus;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private String remark;
    private Long creditPlatCompanyId;
    private String platformId;

    @Id
    @Column(name = "cred_amt_adj_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCredAmtAdjId() {
        return credAmtAdjId;
    }

    public void setCredAmtAdjId(Long credAmtAdjId) {
        this.credAmtAdjId = credAmtAdjId;
    }

    @Basic
    @Column(name = "credit_config_id")
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
    @Column(name = "credit_adj_amount")
    public BigDecimal getCreditAdjAmount() {
        return creditAdjAmount;
    }

    public void setCreditAdjAmount(BigDecimal creditAdjAmount) {
        this.creditAdjAmount = creditAdjAmount;
    }

    @Basic
    @Column(name = "credit_adj_status")
    public String getCreditAdjStatus() {
        return creditAdjStatus;
    }

    public void setCreditAdjStatus(String creditAdjStatus) {
        this.creditAdjStatus = creditAdjStatus;
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
    @Column(name = "credit_plat_company_id")
    public Long getCreditPlatCompanyId() {
        return creditPlatCompanyId;
    }

    public void setCreditPlatCompanyId(Long creditPlatCompanyId) {
        this.creditPlatCompanyId = creditPlatCompanyId;
    }

    @Basic
    @Column(name = "platform_id")
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditAmountAdjustEntity that = (CreditAmountAdjustEntity) o;
        return credAmtAdjId == that.credAmtAdjId &&
                creditConfigId == that.creditConfigId &&
                publishCompanyId == that.publishCompanyId &&
                Objects.equals(publishCompanyName, that.publishCompanyName) &&
                Objects.equals(creditAdjAmount, that.creditAdjAmount) &&
                Objects.equals(creditAdjStatus, that.creditAdjStatus) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(creditPlatCompanyId, that.creditPlatCompanyId) &&
                Objects.equals(platformId, that.platformId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credAmtAdjId, creditConfigId, publishCompanyId, publishCompanyName, creditAdjAmount, creditAdjStatus, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, remark, creditPlatCompanyId, platformId);
    }
}
