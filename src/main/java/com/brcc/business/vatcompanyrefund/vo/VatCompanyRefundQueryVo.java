package com.brcc.business.vatcompanyrefund.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 9:59 2018/11/16
 */
public class VatCompanyRefundQueryVo extends BaseQueryVo {

    private Long vatCompanyRefundId;
    private String vatCompanyRefundNum;
    private String platformId;
    private Long clientId;
    private String clientName;
    private Long carryId;
    private String carryName;
    private String refundStatus;
    private BigDecimal refundAmount;
    private String refundAmountPic;
    private String createRemark;
    private Long createPersonId;
    private String createPersonName;
    private Date createDate;
    private String auditRemark;
    private Long auditPersonId;
    private String auditPersonName;
    private Date auditDate;

    private String docuId;
    private Date modifyStart;
    private Date modifyEnd;

    public Date getModifyStart() {
        return modifyStart;
    }

    public void setModifyStart(Date modifyStart) {
        this.modifyStart = modifyStart;
    }

    public Date getModifyEnd() {
        return modifyEnd;
    }

    public void setModifyEnd(Date modifyEnd) {
        this.modifyEnd = modifyEnd;
    }

    public String getDocuId() {
        return docuId;
    }

    public void setDocuId(String docuId) {
        this.docuId = docuId;
    }

    public Long getVatCompanyRefundId() {
        return vatCompanyRefundId;
    }

    public void setVatCompanyRefundId(Long vatCompanyRefundId) {
        this.vatCompanyRefundId = vatCompanyRefundId;
    }

    public String getVatCompanyRefundNum() {
        return vatCompanyRefundNum;
    }

    public void setVatCompanyRefundNum(String vatCompanyRefundNum) {
        this.vatCompanyRefundNum = vatCompanyRefundNum;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getCarryId() {
        return carryId;
    }

    public void setCarryId(Long carryId) {
        this.carryId = carryId;
    }

    public String getCarryName() {
        return carryName;
    }

    public void setCarryName(String carryName) {
        this.carryName = carryName;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundAmountPic() {
        return refundAmountPic;
    }

    public void setRefundAmountPic(String refundAmountPic) {
        this.refundAmountPic = refundAmountPic;
    }

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    public Long getAuditPersonId() {
        return auditPersonId;
    }

    public void setAuditPersonId(Long auditPersonId) {
        this.auditPersonId = auditPersonId;
    }

    public String getAuditPersonName() {
        return auditPersonName;
    }

    public void setAuditPersonName(String auditPersonName) {
        this.auditPersonName = auditPersonName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
}
