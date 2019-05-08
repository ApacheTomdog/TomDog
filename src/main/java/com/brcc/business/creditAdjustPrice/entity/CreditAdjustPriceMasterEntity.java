package com.brcc.business.creditAdjustPrice.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:授信调价主表实体类
 * @Auther: gemaochao
 * @Date:Created in 17:33 2018/11/3
 */
@Entity
@Table(name = "credit_adjust_price_master")
public class CreditAdjustPriceMasterEntity {

    @Id
    @Column(name = "cred_adj_m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credAdjMId;

    @Basic
    @Column(name = "publish_company_id")
    private Long publishCompanyId;

    @Basic
    @Column(name = "publish_company_name")
    private String publishCompanyName;

    @Basic
    @Column(name = "adj_price_style")
    private String adjPriceStyle;

    @Basic
    @Column(name = "adj_price_status")
    private String adjPriceStatus;

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
    @Column(name = "modify_date")
    private Date modifyDate;

    @Basic
    @Column(name = "modify_person_id")
    private Long modifyPersonId;

    @Basic
    @Column(name = "modify_person_name")
    private String modifyPersonName;

    @Basic
    @Column(name = "remark")
    private String remark;

    @Basic
    @Column(name = "credit_plat_company_id")
    private Long creditPlatCompanyId;

    @Basic
    @Column(name = "platform_id")
    private String platformId;


    public Long getCredAdjMId() {
        return credAdjMId;
    }

    public void setCredAdjMId(Long credAdjMId) {
        this.credAdjMId = credAdjMId;
    }

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    public String getAdjPriceStyle() {
        return adjPriceStyle;
    }

    public void setAdjPriceStyle(String adjPriceStyle) {
        this.adjPriceStyle = adjPriceStyle;
    }

    public String getAdjPriceStatus() {
        return adjPriceStatus;
    }

    public void setAdjPriceStatus(String adjPriceStatus) {
        this.adjPriceStatus = adjPriceStatus;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreditPlatCompanyId() {
        return creditPlatCompanyId;
    }

    public void setCreditPlatCompanyId(Long creditPlatCompanyId) {
        this.creditPlatCompanyId = creditPlatCompanyId;
    }

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
        CreditAdjustPriceMasterEntity that = (CreditAdjustPriceMasterEntity) o;
        return credAdjMId == that.credAdjMId &&
                publishCompanyId == that.publishCompanyId &&
                Objects.equals(publishCompanyName, that.publishCompanyName) &&
                Objects.equals(adjPriceStyle, that.adjPriceStyle) &&
                Objects.equals(adjPriceStatus, that.adjPriceStatus) &&
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
        return Objects.hash(credAdjMId, publishCompanyId, publishCompanyName, adjPriceStyle, adjPriceStatus, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, remark, creditPlatCompanyId, platformId);
    }
}
