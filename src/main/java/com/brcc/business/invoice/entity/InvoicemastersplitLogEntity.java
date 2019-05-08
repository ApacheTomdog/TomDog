package com.brcc.business.invoice.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "invoicemastersplit_log")
public class InvoicemastersplitLogEntity {
    private Long invoiceSplitLogId;
    private Long invoiceSplitId;
    private String invoiceSplitNum;
    private Long invoiceMasterId;
    private String invoiceNo;
    private BigDecimal invoicePlanAmount;
    private BigDecimal invoiceActualAmount;
    private BigDecimal invoiceActualWeight;
    private Long invoiceTitleId;
    private String invoiceTitleName;
    private Long invoiceClientId;
    private String invoiceClientName;
    private String invoiceStatus;
    private Date createDate;
    private Long createPersonId;
    private String createPersonName;
    private Date modifyDate;
    private Long modifyPersonId;
    private String modifyPersonName;
    private String platformId;
    private String remark;
    private Date invoiceAgreeTime;
    private String ifShowFlag;
    private String type;
    private Long printNum;
    private Long groupId;
    private String groupName;
    private Long ticketOpeningMark;
    private Date logCreateDate;
    private Long logCreatePersonId;
    private String logCreatePersonName;

    @Id
    @Column(name = "invoice_split_log_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getInvoiceSplitLogId() {
        return invoiceSplitLogId;
    }

    public void setInvoiceSplitLogId(Long invoiceSplitLogId) {
        this.invoiceSplitLogId = invoiceSplitLogId;
    }

    @Basic
    @Column(name = "invoice_split_id")
    public Long getInvoiceSplitId() {
        return invoiceSplitId;
    }

    public void setInvoiceSplitId(Long invoiceSplitId) {
        this.invoiceSplitId = invoiceSplitId;
    }

    @Basic
    @Column(name = "invoice_split_num")
    public String getInvoiceSplitNum() {
        return invoiceSplitNum;
    }

    public void setInvoiceSplitNum(String invoiceSplitNum) {
        this.invoiceSplitNum = invoiceSplitNum;
    }

    @Basic
    @Column(name = "invoice_master_id")
    public Long getInvoiceMasterId() {
        return invoiceMasterId;
    }

    public void setInvoiceMasterId(Long invoiceMasterId) {
        this.invoiceMasterId = invoiceMasterId;
    }

    @Basic
    @Column(name = "invoice_no")
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Basic
    @Column(name = "invoice_plan_amount")
    public BigDecimal getInvoicePlanAmount() {
        return invoicePlanAmount;
    }

    public void setInvoicePlanAmount(BigDecimal invoicePlanAmount) {
        this.invoicePlanAmount = invoicePlanAmount;
    }

    @Basic
    @Column(name = "invoice_actual_amount")
    public BigDecimal getInvoiceActualAmount() {
        return invoiceActualAmount;
    }

    public void setInvoiceActualAmount(BigDecimal invoiceActualAmount) {
        this.invoiceActualAmount = invoiceActualAmount;
    }

    @Basic
    @Column(name = "invoice_actual_weight")
    public BigDecimal getInvoiceActualWeight() {
        return invoiceActualWeight;
    }

    public void setInvoiceActualWeight(BigDecimal invoiceActualWeight) {
        this.invoiceActualWeight = invoiceActualWeight;
    }

    @Basic
    @Column(name = "invoice_title_id")
    public Long getInvoiceTitleId() {
        return invoiceTitleId;
    }

    public void setInvoiceTitleId(Long invoiceTitleId) {
        this.invoiceTitleId = invoiceTitleId;
    }

    @Basic
    @Column(name = "invoice_title_name")
    public String getInvoiceTitleName() {
        return invoiceTitleName;
    }

    public void setInvoiceTitleName(String invoiceTitleName) {
        this.invoiceTitleName = invoiceTitleName;
    }

    @Basic
    @Column(name = "invoice_client_id")
    public Long getInvoiceClientId() {
        return invoiceClientId;
    }

    public void setInvoiceClientId(Long invoiceClientId) {
        this.invoiceClientId = invoiceClientId;
    }

    @Basic
    @Column(name = "invoice_client_name")
    public String getInvoiceClientName() {
        return invoiceClientName;
    }

    public void setInvoiceClientName(String invoiceClientName) {
        this.invoiceClientName = invoiceClientName;
    }

    @Basic
    @Column(name = "invoice_status")
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_person_id")
    public Long getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(Long createPersonId) {
        this.createPersonId = createPersonId;
    }

    @Basic
    @Column(name = "create_person_name")
    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    @Basic
    @Column(name = "modify_date")
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "modify_person_id")
    public Long getModifyPersonId() {
        return modifyPersonId;
    }

    public void setModifyPersonId(Long modifyPersonId) {
        this.modifyPersonId = modifyPersonId;
    }

    @Basic
    @Column(name = "modify_person_name")
    public String getModifyPersonName() {
        return modifyPersonName;
    }

    public void setModifyPersonName(String modifyPersonName) {
        this.modifyPersonName = modifyPersonName;
    }

    @Basic
    @Column(name = "platform_id")
    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "invoice_agree_time")
    public Date getInvoiceAgreeTime() {
        return invoiceAgreeTime;
    }

    public void setInvoiceAgreeTime(Date invoiceAgreeTime) {
        this.invoiceAgreeTime = invoiceAgreeTime;
    }

    @Basic
    @Column(name = "if_show_flag")
    public String getIfShowFlag() {
        return ifShowFlag;
    }

    public void setIfShowFlag(String ifShowFlag) {
        this.ifShowFlag = ifShowFlag;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "print_num")
    public Long getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Long printNum) {
        this.printNum = printNum;
    }

    @Basic
    @Column(name = "group_id")
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "ticket_opening_mark")
    public Long getTicketOpeningMark() {
        return ticketOpeningMark;
    }

    public void setTicketOpeningMark(Long ticketOpeningMark) {
        this.ticketOpeningMark = ticketOpeningMark;
    }

    @Basic
    @Column(name = "log_create_date")
    public Date getLogCreateDate() {
        return logCreateDate;
    }

    public void setLogCreateDate(Date logCreateDate) {
        this.logCreateDate = logCreateDate;
    }

    @Basic
    @Column(name = "log_create_person_id")
    public Long getLogCreatePersonId() {
        return logCreatePersonId;
    }

    public void setLogCreatePersonId(Long logCreatePersonId) {
        this.logCreatePersonId = logCreatePersonId;
    }

    @Basic
    @Column(name = "log_create_person_name")
    public String getLogCreatePersonName() {
        return logCreatePersonName;
    }

    public void setLogCreatePersonName(String logCreatePersonName) {
        this.logCreatePersonName = logCreatePersonName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicemastersplitLogEntity that = (InvoicemastersplitLogEntity) o;
        return invoiceSplitLogId == that.invoiceSplitLogId &&
                Objects.equals(invoiceSplitId, that.invoiceSplitId) &&
                Objects.equals(invoiceSplitNum, that.invoiceSplitNum) &&
                Objects.equals(invoiceMasterId, that.invoiceMasterId) &&
                Objects.equals(invoiceNo, that.invoiceNo) &&
                Objects.equals(invoicePlanAmount, that.invoicePlanAmount) &&
                Objects.equals(invoiceActualAmount, that.invoiceActualAmount) &&
                Objects.equals(invoiceActualWeight, that.invoiceActualWeight) &&
                Objects.equals(invoiceTitleId, that.invoiceTitleId) &&
                Objects.equals(invoiceTitleName, that.invoiceTitleName) &&
                Objects.equals(invoiceClientId, that.invoiceClientId) &&
                Objects.equals(invoiceClientName, that.invoiceClientName) &&
                Objects.equals(invoiceStatus, that.invoiceStatus) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(createPersonId, that.createPersonId) &&
                Objects.equals(createPersonName, that.createPersonName) &&
                Objects.equals(modifyDate, that.modifyDate) &&
                Objects.equals(modifyPersonId, that.modifyPersonId) &&
                Objects.equals(modifyPersonName, that.modifyPersonName) &&
                Objects.equals(platformId, that.platformId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(invoiceAgreeTime, that.invoiceAgreeTime) &&
                Objects.equals(ifShowFlag, that.ifShowFlag) &&
                Objects.equals(type, that.type) &&
                Objects.equals(printNum, that.printNum) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(ticketOpeningMark, that.ticketOpeningMark) &&
                Objects.equals(logCreateDate, that.logCreateDate) &&
                Objects.equals(logCreatePersonId, that.logCreatePersonId) &&
                Objects.equals(logCreatePersonName, that.logCreatePersonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceSplitLogId, invoiceSplitId, invoiceSplitNum, invoiceMasterId, invoiceNo, invoicePlanAmount, invoiceActualAmount, invoiceActualWeight, invoiceTitleId, invoiceTitleName, invoiceClientId, invoiceClientName, invoiceStatus, createDate, createPersonId, createPersonName, modifyDate, modifyPersonId, modifyPersonName, platformId, remark, invoiceAgreeTime, ifShowFlag, type, printNum, groupId, groupName, ticketOpeningMark, logCreateDate, logCreatePersonId, logCreatePersonName);
    }
}
