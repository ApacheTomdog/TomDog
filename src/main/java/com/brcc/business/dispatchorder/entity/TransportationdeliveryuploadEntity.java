package com.brcc.business.dispatchorder.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 15:29
 */
@Entity
@Table(name = "transportationdeliveryupload")
public class TransportationdeliveryuploadEntity {

    private Long publishId;
    private Long transId;
    private Long deliveryId;
    private String status;
    private Date createDate;
    private String createPerson;
    private String isUploadEc;
    private Long uploadId;
    private String batchId;
    private String platFormId;
    private String operateType;
    private String fromType;
    private String canUpload;
    private String spellListNum;
    private String spellListPas;
    private String ifSpellList;

    @Basic
    @Column(name = "publish_id", nullable = true)
    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
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
    @Column(name = "status", nullable = true, length = 2)
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
    @Column(name = "create_person", nullable = true, length = 20)
    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    @Basic
    @Column(name = "is_upload_ec", nullable = true, length = 2)
    public String getIsUploadEc() {
        return isUploadEc;
    }

    public void setIsUploadEc(String isUploadEc) {
        this.isUploadEc = isUploadEc;
    }

    @Id
    @Column(name = "upload_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    @Basic
    @Column(name = "batch_id", nullable = true, length = 50)
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "plat_form_id", nullable = true, length = 200)
    public String getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(String platFormId) {
        this.platFormId = platFormId;
    }

    @Basic
    @Column(name = "operate_type", nullable = true, length = 20)
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
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
    @Column(name = "can_upload", nullable = true, length = 2)
    public String getCanUpload() {
        return canUpload;
    }

    public void setCanUpload(String canUpload) {
        this.canUpload = canUpload;
    }

    @Basic
    @Column(name = "spell_list_num")
    public String getSpellListNum() {
        return spellListNum;
    }

    public void setSpellListNum(String spellListNum) {
        this.spellListNum = spellListNum;
    }

    @Basic
    @Column(name = "spell_list_pas")
    public String getSpellListPas() {
        return spellListPas;
    }

    public void setSpellListPas(String spellListPas) {
        this.spellListPas = spellListPas;
    }

    @Basic
    @Column(name = "if_spell_list")
    public String getIfSpellList() {
        return ifSpellList;
    }

    public void setIfSpellList(String ifSpellList) {
        this.ifSpellList = ifSpellList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportationdeliveryuploadEntity that = (TransportationdeliveryuploadEntity) o;
        return uploadId == that.uploadId &&
                Objects.equals(publishId, that.publishId) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(deliveryId, that.deliveryId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPerson, that.createPerson) &&
                Objects.equals(isUploadEc, that.isUploadEc) &&
                Objects.equals(batchId, that.batchId) &&
                Objects.equals(platFormId, that.platFormId) &&
                Objects.equals(operateType, that.operateType) &&
                Objects.equals(fromType, that.fromType) &&
                Objects.equals(canUpload, that.canUpload);
    }

    @Override
    public int hashCode() {

        return Objects.hash(publishId, transId, deliveryId, status, createDate, createPerson, isUploadEc, uploadId, batchId, platFormId, operateType, fromType, canUpload);
    }
}