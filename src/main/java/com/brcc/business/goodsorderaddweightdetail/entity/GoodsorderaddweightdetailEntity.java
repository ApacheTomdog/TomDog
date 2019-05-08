package com.brcc.business.goodsorderaddweightdetail.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author: ywb
 * @date: 2019-04-16
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "goodsorderaddweightdetail")
public class GoodsorderaddweightdetailEntity {
    private Long addWeightDetailId;
    private Long publishId;
    private BigDecimal addWeight;
    private Date createDate;
    private Integer addCarnum;
    private String addWeightType;
    private Date pickupDate;
    private Date takeDeliveryDate;
    private Long createPersonId;
    private String createPersonName;
    private BigDecimal addQty;

    @Id
    @Column(name = "add_weight_detail_id", nullable = false)
    public Long getAddWeightDetailId() {
        return addWeightDetailId;
    }

    public void setAddWeightDetailId(Long addWeightDetailId) {
        this.addWeightDetailId = addWeightDetailId;
    }

    @Basic
    @Column(name = "publish_id", nullable = true)
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "add_weight", nullable = true, precision = 6)
    public BigDecimal getAddWeight() {
        return addWeight;
    }

    public void setAddWeight(BigDecimal addWeight) {
        this.addWeight = addWeight;
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
    @Column(name = "add_carnum", nullable = true)
    public Integer getAddCarnum() {
        return addCarnum;
    }

    public void setAddCarnum(Integer addCarnum) {
        this.addCarnum = addCarnum;
    }

    @Basic
    @Column(name = "add_weight_type", nullable = true, length = 3)
    public String getAddWeightType() {
        return addWeightType;
    }

    public void setAddWeightType(String addWeightType) {
        this.addWeightType = addWeightType;
    }

    @Basic
    @Column(name = "pickup_date", nullable = true)
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
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
    @Column(name = "create_person_id", nullable = true)
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name", nullable = true, length = 100)
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "add_qty", nullable = true, precision = 6)
    public BigDecimal getAddQty() {
        return addQty;
    }

    public void setAddQty(BigDecimal addQty) {
        this.addQty = addQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsorderaddweightdetailEntity that = (GoodsorderaddweightdetailEntity) o;
        return Objects.equals(addWeightDetailId, that.addWeightDetailId) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(addWeight, that.addWeight) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(addCarnum, that.addCarnum) &&
                Objects.equals(addWeightType, that.addWeightType) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(takeDeliveryDate, that.takeDeliveryDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(addQty, that.addQty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addWeightDetailId, publishId, addWeight, createDate, addCarnum, addWeightType, pickupDate, takeDeliveryDate, createPersonId, createPersonName, addQty);
    }
}
