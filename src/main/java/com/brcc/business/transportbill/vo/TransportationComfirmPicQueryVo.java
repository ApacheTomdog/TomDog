package com.brcc.business.transportbill.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * @Desc：   回单图片审查列表查询类
 * @author: TangYong
 * @Date:   2019-04-15
 */
public class TransportationComfirmPicQueryVo extends BaseQueryVo {

    /**单据来源*/
    private String fromType;
    /**委托人*/
    private String billSender;
    /**审核日期*/
    private Date startAuditDate;
    private Date endAuditDate;
    /**审核状态*/
    private String auditStatus;
    /**异常原因*/
    private String auditType;
    /**支付日期*/
    private Date startPayDate;
    private Date endPayDate;
    /**货源单号*/
    private Long publishId;
    /**调度单号*/
    private Long deliveryId;

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    public Date getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(Date startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public Date getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(Date endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Date getStartPayDate() {
        return startPayDate;
    }

    public void setStartPayDate(Date startPayDate) {
        this.startPayDate = startPayDate;
    }

    public Date getEndPayDate() {
        return endPayDate;
    }

    public void setEndPayDate(Date endPayDate) {
        this.endPayDate = endPayDate;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }
}
