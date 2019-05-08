package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 17:54
 */
@Entity
@Table(name = "goodsorderexecutelog")
public class GoodsorderexecutelogEntity {

    private String exeDesc;
    private Long publishId;
    private Long seqId;
    private Long transId;
    private Long deliveryId;
    private Date createTime;

    @Basic
    @Column(name = "exe_desc", nullable = false, length = 200)
    public String getExeDesc() {
        return exeDesc;
    }

    public void setExeDesc(String exeDesc) {
        this.exeDesc = exeDesc;
    }

    @Basic
    @Column(name = "publish_id", nullable = true)
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    @Id
    @Column(name = "seq_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    @Basic
    @Column(name = "trans_id", nullable = true)
    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
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
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsorderexecutelogEntity that = (GoodsorderexecutelogEntity) o;
        return seqId == that.seqId &&
                Objects.equals(exeDesc, that.exeDesc) &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(exeDesc, publishId, seqId, transId, deliveryId, createTime);
    }
}