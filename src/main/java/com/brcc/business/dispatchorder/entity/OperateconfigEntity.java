package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 15:08
 */
@Entity
@Table(name = "operateconfig")
public class OperateconfigEntity {

    private Long ocId;
    private Integer publishCompanyId;
    private String publishCompanyName;
    private String fromType;
    private String logisticsMark;
    private String ocStatus;
    private String type;
    private Integer times;
    private String platformId;

    @Id
    @Column(name = "oc_id", nullable = false)
    public Long getOcId() {
        return ocId;
    }

    public void setOcId(Long ocId) {
        this.ocId = ocId;
    }

    @Basic
    @Column(name = "publish_company_id", nullable = true)
    public Integer getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Integer publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "publish_company_name", nullable = true, length = 100)
    public String getPublishCompanyName() {
        return publishCompanyName;
    }

    public void setPublishCompanyName(String publishCompanyName) {
        this.publishCompanyName = publishCompanyName;
    }

    @Basic
    @Column(name = "from_type", nullable = true, length = 20)
    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    @Basic
    @Column(name = "logistics_mark", nullable = true, length = 1)
    public String getLogisticsMark() {
        return logisticsMark;
    }

    public void setLogisticsMark(String logisticsMark) {
        this.logisticsMark = logisticsMark;
    }

    @Basic
    @Column(name = "oc_status", nullable = true, length = 2)
    public String getOcStatus() {
        return ocStatus;
    }

    public void setOcStatus(String ocStatus) {
        this.ocStatus = ocStatus;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 2)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "times", nullable = true)
    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
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
        OperateconfigEntity that = (OperateconfigEntity) o;
        return ocId == that.ocId &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(publishCompanyName, that.publishCompanyName) &&
                Objects.equals(fromType, that.fromType) &&
                Objects.equals(logisticsMark, that.logisticsMark) &&
                Objects.equals(ocStatus, that.ocStatus) &&
                Objects.equals(type, that.type) &&
                Objects.equals(times, that.times) &&
                Objects.equals(platformId, that.platformId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ocId, publishCompanyId, publishCompanyName, fromType, logisticsMark, ocStatus, type, times, platformId);
    }
}