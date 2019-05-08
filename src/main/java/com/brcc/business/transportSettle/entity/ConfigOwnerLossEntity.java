package com.brcc.business.transportSettle.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: ywb
 * @Date: 2019-02-26
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "config_owner_loss")
public class ConfigOwnerLossEntity {
    private Long configOwnerLossId;
    private Integer configOwnerLossFlag;
    private Long ownerCompanyId;
    private String ownerCompanyName;
    private String configOwnerLossStatus;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;

    @Id
    @Column(name = "config_owner_loss_id", nullable = true)
    public Long getConfigOwnerLossId() {
        return configOwnerLossId;
    }

    public void setConfigOwnerLossId(Long configOwnerLossId) {
        this.configOwnerLossId = configOwnerLossId;
    }

    @Basic
    @Column(name = "config_owner_loss_flag", nullable = true)
    public Integer getConfigOwnerLossFlag() {
        return configOwnerLossFlag;
    }

    public void setConfigOwnerLossFlag(Integer configOwnerLossFlag) {
        this.configOwnerLossFlag = configOwnerLossFlag;
    }

    @Basic
    @Column(name = "owner_company_id", nullable = true)
    public Long getOwnerCompanyId() {
        return ownerCompanyId;
    }

    public void setOwnerCompanyId(Long ownerCompanyId) {
        this.ownerCompanyId = ownerCompanyId;
    }

    @Basic
    @Column(name = "owner_company_name", nullable = true, length = 50)
    public String getOwnerCompanyName() {
        return ownerCompanyName;
    }

    public void setOwnerCompanyName(String ownerCompanyName) {
        this.ownerCompanyName = ownerCompanyName;
    }

    @Basic
    @Column(name = "config_owner_loss_status", nullable = true, length = 2)
    public String getConfigOwnerLossStatus() {
        return configOwnerLossStatus;
    }

    public void setConfigOwnerLossStatus(String configOwnerLossStatus) {
        this.configOwnerLossStatus = configOwnerLossStatus;
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
    @Column(name = "create_person_name", nullable = true, length = 80)
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
    @Column(name = "modify_person_name", nullable = true, length = 80)
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigOwnerLossEntity that = (ConfigOwnerLossEntity) o;
        return Objects.equals(configOwnerLossId, that.configOwnerLossId) &&
                Objects.equals(configOwnerLossFlag, that.configOwnerLossFlag) &&
                Objects.equals(ownerCompanyId, that.ownerCompanyId) &&
                Objects.equals(ownerCompanyName, that.ownerCompanyName) &&
                Objects.equals(configOwnerLossStatus, that.configOwnerLossStatus) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configOwnerLossId, configOwnerLossFlag, ownerCompanyId, ownerCompanyName, configOwnerLossStatus, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName);
    }
}
