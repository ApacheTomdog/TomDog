package com.brcc.business.goodsorderToPayInfo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 14:16 2018/11/12
 */
@Entity
@Table(name = "goodsorder_to_pay_info")
public class GoodsorderToPayInfoEntity {

    @Id
    @Column(name = "seq_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqId;

    @Basic
    @Column(name = "company_id")
    private Long companyId;

    @Basic
    @Column(name = "publish_id")
    private Long publishId;

    @Basic
    @Column(name = "bank_name")
    private String bankName;

    @Basic
    @Column(name = "bank_num")
    private String bankNum;

    @Basic
    @Column(name = "bank_card_owner")
    private String bankCardOwner;

    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "create_person")
    private String createPerson;

    @Basic
    @Column(name = "update_date")
    private Date updateDate;

    @Basic
    @Column(name = "update_person")
    private String updatePerson;

    @Basic
    @Column(name = "platform_id")
    private String platformId;

    @Basic
    @Column(name = "remark")
    private String remark;


    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getBankCardOwner() {
        return bankCardOwner;
    }

    public void setBankCardOwner(String bankCardOwner) {
        this.bankCardOwner = bankCardOwner;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsorderToPayInfoEntity that = (GoodsorderToPayInfoEntity) o;
        return seqId == that.seqId &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(bankNum, that.bankNum) &&
                Objects.equals(bankCardOwner, that.bankCardOwner) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(updatePerson, that.updatePerson) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqId, companyId, publishId, bankName, bankNum, bankCardOwner, mobile, createDate, createPerson, updateDate, updatePerson, platformId, remark);
    }
}
