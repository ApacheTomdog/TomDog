package com.brcc.business.transorder.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-12-04 10:39
 */
@Entity
@Table(name = "broker_people_config")
public class BrokerPeopleConfigEntity {

    private Long brokerPeopleConfig;
    private String brokerPeopleCompanyId;
    private String brokerPeopleCompanyName;
    private String brokerPeopleTollType;
    private BigDecimal brokerPeopleTollAmount;
    private BigDecimal brokerPeopleTollRatio;
    private String status;
    private Date createDate;
    private Integer createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Integer modifyPersonId;
    private String modifyPersonName;
    private String platformId;

    @Id
    @Column(name = "broker_people_config", nullable = false)
    public Long getBrokerPeopleConfig() {
        return brokerPeopleConfig;
    }

    public void setBrokerPeopleConfig(Long brokerPeopleConfig) {
        this.brokerPeopleConfig = brokerPeopleConfig;
    }

    @Basic
    @Column(name = "broker_people_company_id", nullable = true, length = 50)
    public String getBrokerPeopleCompanyId() {
        return brokerPeopleCompanyId;
    }

    public void setBrokerPeopleCompanyId(String brokerPeopleCompanyId) {
        this.brokerPeopleCompanyId = brokerPeopleCompanyId;
    }

    @Basic
    @Column(name = "broker_people_company_name", nullable = true, length = 255)
    public String getBrokerPeopleCompanyName() {
        return brokerPeopleCompanyName;
    }

    public void setBrokerPeopleCompanyName(String brokerPeopleCompanyName) {
        this.brokerPeopleCompanyName = brokerPeopleCompanyName;
    }

    @Basic
    @Column(name = "broker_people_toll_type", nullable = true, length = 2)
    public String getBrokerPeopleTollType() {
        return brokerPeopleTollType;
    }

    public void setBrokerPeopleTollType(String brokerPeopleTollType) {
        this.brokerPeopleTollType = brokerPeopleTollType;
    }

    @Basic
    @Column(name = "broker_people_toll_amount", nullable = true, precision = 2)
    public BigDecimal getBrokerPeopleTollAmount() {
        return brokerPeopleTollAmount;
    }

    public void setBrokerPeopleTollAmount(BigDecimal brokerPeopleTollAmount) {
        this.brokerPeopleTollAmount = brokerPeopleTollAmount;
    }

    @Basic
    @Column(name = "broker_people_toll_ratio", nullable = true, precision = 3)
    public BigDecimal getBrokerPeopleTollRatio() {
        return brokerPeopleTollRatio;
    }

    public void setBrokerPeopleTollRatio(BigDecimal brokerPeopleTollRatio) {
        this.brokerPeopleTollRatio = brokerPeopleTollRatio;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public Integer getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Integer createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name", nullable = true, length = 255)
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
    public Integer getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Integer modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name", nullable = true, length = 255)
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "platform_id", nullable = true, length = 20)
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
        BrokerPeopleConfigEntity that = (BrokerPeopleConfigEntity) o;
        return brokerPeopleConfig == that.brokerPeopleConfig &&
                Objects.equals(brokerPeopleCompanyId, that.brokerPeopleCompanyId) &&
                Objects.equals(brokerPeopleCompanyName, that.brokerPeopleCompanyName) &&
                Objects.equals(brokerPeopleTollType, that.brokerPeopleTollType) &&
                Objects.equals(brokerPeopleTollAmount, that.brokerPeopleTollAmount) &&
                Objects.equals(brokerPeopleTollRatio, that.brokerPeopleTollRatio) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(platformId, that.platformId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brokerPeopleConfig, brokerPeopleCompanyId, brokerPeopleCompanyName, brokerPeopleTollType, brokerPeopleTollAmount, brokerPeopleTollRatio, status, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, platformId);
    }
}