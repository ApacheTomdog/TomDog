package com.brcc.business.vatcompanyrecharge.vo;


import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 16:30 2018/11/13
 */
public class VatCompanyRechargeQueryVo extends BaseQueryVo {

    private Long vatCompanyRechargeId;
    private String platformId;
    private Long clientId;
    private String clientName;
    private Long carryId;
    private String carryName;
    private String status;
    private BigDecimal bankAmount;
    private String bankAmountPic;
    private String createRemark;
    private Long createPersonId;
    private String createPersonName;
    private Date createDate;
    private String auditRemark;
    private Long auditPersonId;
    private String auditPersonName;
    private Date auditDate;
    private String auditNum;
    private String businessNum;
    private String vatAuditName;
    private String vatDirectorName;

    //新加
    private String ifParts;
    private Long id;
    private BigDecimal totalInAmount;
    private String credateTime;

    private String auditTime;

    private Date createDateStart;

    private Date createDateEnd;


    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getCredateTime() {
        return credateTime;
    }

    public void setCredateTime(String credateTime) {
        this.credateTime = credateTime;
    }

    public BigDecimal getTotalInAmount() {
        return totalInAmount;
    }

    public void setTotalInAmount(BigDecimal totalInAmount) {
        this.totalInAmount = totalInAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIfParts() {
        return ifParts;
    }

    public void setIfParts(String ifParts) {
        this.ifParts = ifParts;
    }

    public Long getVatCompanyRechargeId() {
        return vatCompanyRechargeId;
    }

    public void setVatCompanyRechargeId(Long vatCompanyRechargeId) {
        this.vatCompanyRechargeId = vatCompanyRechargeId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBankAmount() {
        return bankAmount;
    }

    public void setBankAmount(BigDecimal bankAmount) {
        this.bankAmount = bankAmount;
    }

    public String getBankAmountPic() {
        return bankAmountPic;
    }

    public void setBankAmountPic(String bankAmountPic) {
        this.bankAmountPic = bankAmountPic;
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

    public String getAuditNum() {
        return auditNum;
    }

    public void setAuditNum(String auditNum) {
        this.auditNum = auditNum;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getVatAuditName() {
        return vatAuditName;
    }

    public void setVatAuditName(String vatAuditName) {
        this.vatAuditName = vatAuditName;
    }

    public String getVatDirectorName() {
        return vatDirectorName;
    }

    public void setVatDirectorName(String vatDirectorName) {
        this.vatDirectorName = vatDirectorName;
    }
}
