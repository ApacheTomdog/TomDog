package com.brcc.business.weightUpload.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-28 16:00
 */
@Entity
@Table(name = "uploadweight")
public class UploadweightEntity {

    private Long id;
    private Long batchId;
    private Long publishCompanyId;
    private Long deliveryId;
    private BigDecimal truckLoadingWeight;
    private Date truckLoadingDate;
    private BigDecimal takeDeliveryWeight;
    private Date takeDeliveryDate;
    private String status;
    private String procResult;
    private Date procDate;
    private Long createPerson;
    private Date createDate;
    private String platformId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "batch_id", nullable = true)
    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "publish_company_id", nullable = true)
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Basic
    @Column(name = "delivery_id", nullable = true)
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Basic
    @Column(name = "truck_loading_weight", nullable = true, precision = 2)
    public BigDecimal getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    @Basic
    @Column(name = "truck_loading_date", nullable = true)
    public Date getTruckLoadingDate() {
        return truckLoadingDate;
    }

    public void setTruckLoadingDate(Date truckLoadingDate) {
        this.truckLoadingDate = truckLoadingDate;
    }

    @Basic
    @Column(name = "take_delivery_weight", nullable = true, precision = 2)
    public BigDecimal getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    @Basic
    @Column(name = "take_delivery_date", nullable = true)
    public Date getTakeDeliveryDate() {
        return takeDeliveryDate;
    }

    public void setTakeDeliveryDate(Date takeDeliveryDate) {
        this.takeDeliveryDate = takeDeliveryDate;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "proc_result", nullable = true, length = 200)
    public String getProcResult() {
        return procResult;
    }

    public void setProcResult(String procResult) {
        this.procResult = procResult;
    }

    @Basic
    @Column(name = "proc_date", nullable = true)
    public Date getProcDate() {
        return procDate;
    }

    public void setProcDate(Date procDate) {
        this.procDate = procDate;
    }

    @Basic
    @Column(name = "create_person", nullable = true)
    public Long getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Long createPerson) {
        this.createPerson = createPerson;
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
        UploadweightEntity that = (UploadweightEntity) o;
        return id == that.id &&
                Objects.equals(batchId, that.batchId) &&
                Objects.equals(publishCompanyId, that.publishCompanyId) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(truckLoadingWeight, that.truckLoadingWeight) &&
                Objects.equals(truckLoadingDate, that.truckLoadingDate) &&
                Objects.equals(takeDeliveryWeight, that.takeDeliveryWeight) &&
                Objects.equals(takeDeliveryDate, that.takeDeliveryDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(procResult, that.procResult) &&
                Objects.equals(procDate, that.procDate) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(platformId, that.platformId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, batchId, publishCompanyId, deliveryId, truckLoadingWeight, truckLoadingDate, takeDeliveryWeight, takeDeliveryDate, status, procResult, procDate, createPerson, createDate, platformId);
    }
}