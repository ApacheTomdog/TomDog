package com.brcc.business.creditRepay.vo;

import com.esteel.common.vo.BaseQueryVo;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 授信还款筛选封装类
 * @Auther: gemaochao
 * @Date:Created in 16:49 2018/11/7
 */
public class CreditRepaySearchQueryVo extends BaseQueryVo {

    private Long creditRepayId;

    private String creditRepayNo;

    private String platformId;

    private Long creditCompanyId;

    private String creditCompanyName;

    private Long investCompanyId;

    private String investCompanyName;

    private BigDecimal creditRepayAmt;

    private String creditRepayPic;

    private String creditRepayStatus;

    private Date createDate;

    private Long createPersonId;

    private String createPersonName;

    private String createRemark;

    private Date modifyDate;

    private Long modifyPersonId;

    private String modifyPersonName;

    private Date auditDate;

    private Long auditPersonId;

    private String auditPersonName;

    private String auditRemark;

    private Date createStart;
    private Date createEnd;

    public Date getCreateStart() {
        return createStart;
    }

    public void setCreateStart(Date createStart) {
        this.createStart = createStart;
    }

    public Date getCreateEnd() {
        return createEnd;
    }

    public void setCreateEnd(Date createEnd) {
        this.createEnd = createEnd;
    }

    public Long getCreditRepayId() {
        return creditRepayId;
    }

    public void setCreditRepayId(Long creditRepayId) {
        this.creditRepayId = creditRepayId;
    }

    public String getCreditRepayNo() {
        return creditRepayNo;
    }

    public void setCreditRepayNo(String creditRepayNo) {
        this.creditRepayNo = creditRepayNo;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getCreditCompanyId() {
        return creditCompanyId;
    }

    public void setCreditCompanyId(Long creditCompanyId) {
        this.creditCompanyId = creditCompanyId;
    }

    public String getCreditCompanyName() {
        return creditCompanyName;
    }

    public void setCreditCompanyName(String creditCompanyName) {
        this.creditCompanyName = creditCompanyName;
    }

    public Long getInvestCompanyId() {
        return investCompanyId;
    }

    public void setInvestCompanyId(Long investCompanyId) {
        this.investCompanyId = investCompanyId;
    }

    public String getInvestCompanyName() {
        return investCompanyName;
    }

    public void setInvestCompanyName(String investCompanyName) {
        this.investCompanyName = investCompanyName;
    }

    public BigDecimal getCreditRepayAmt() {
        return creditRepayAmt;
    }

    public void setCreditRepayAmt(BigDecimal creditRepayAmt) {
        this.creditRepayAmt = creditRepayAmt;
    }

    public String getCreditRepayPic() {
        return creditRepayPic;
    }

    public void setCreditRepayPic(String creditRepayPic) {
        this.creditRepayPic = creditRepayPic;
    }

    public String getCreditRepayStatus() {
        return creditRepayStatus;
    }

    public void setCreditRepayStatus(String creditRepayStatus) {
        this.creditRepayStatus = creditRepayStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public String getCreateRemark() {
        return createRemark;
    }

    public void setCreateRemark(String createRemark) {
        this.createRemark = createRemark;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
}
