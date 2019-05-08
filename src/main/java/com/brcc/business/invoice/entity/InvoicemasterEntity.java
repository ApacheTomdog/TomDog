package com.brcc.business.invoice.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the invoicemaster database table.
 * 
 */
@Entity
@Table(name="invoicemaster")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name="InvoicemasterEntity.findAll", query="SELECT i FROM InvoicemasterEntity i")
public class InvoicemasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_master_id")
	private Long invoiceMasterId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="apply_date")
	private Date applyDate;

	@Column(name="apply_flag")
	private Integer applyFlag = 0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="group_id")
	private Long groupId = 0L;

	@Column(name="group_name")
	private String groupName;

	@Column(name="if_default")
	private String ifDefault = "N";

	@Column(name="if_show_flag")
	private String ifShowFlag = "0";

	@Column(name="invoice_actual_amount")
	private BigDecimal invoiceActualAmount;

	@Column(name="invoice_actual_weight")
	private BigDecimal invoiceActualWeight;

	@Column(name="invoice_agree_amount")
	private BigDecimal invoiceAgreeAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_agree_time")
	private Date invoiceAgreeTime;

	@Column(name="invoice_agree_weight")
	private BigDecimal invoiceAgreeWeight;

	@Column(name="invoice_client_id")
	private Long invoiceClientId;

	@Column(name="invoice_client_name")
	private String invoiceClientName;

	@Column(name="invoice_master_num")
	private String invoiceMasterNum;

	@Column(name="invoice_split_amount")
	private BigDecimal invoiceSplitAmount;

	@Column(name="invoice_split_weight")
	private BigDecimal invoiceSplitWeight;

	@Column(name="invoice_status")
	private String invoiceStatus;

	@Column(name="invoice_title_id")
	private Long invoiceTitleId;

	@Column(name="invoice_title_name")
	private String invoiceTitleName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="platform_id")
	private String platformId;

	private String remark;

	@Column(name="ticket_opening_mark")
	private Integer ticketOpeningMark;
	
	@Column(name="invoice_desc")
	private String invoiceDesc;

	public InvoicemasterEntity() {
	}

	public Long getInvoiceMasterId() {
		return this.invoiceMasterId;
	}

	public void setInvoiceMasterId(Long invoiceMasterId) {
		this.invoiceMasterId = invoiceMasterId;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApplyFlag() {
		return this.applyFlag;
	}

	public void setApplyFlag(Integer applyFlag) {
		this.applyFlag = applyFlag;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIfDefault() {
		return this.ifDefault;
	}

	public void setIfDefault(String ifDefault) {
		this.ifDefault = ifDefault;
	}

	public String getIfShowFlag() {
		return this.ifShowFlag;
	}

	public void setIfShowFlag(String ifShowFlag) {
		this.ifShowFlag = ifShowFlag;
	}

	public BigDecimal getInvoiceActualAmount() {
		return this.invoiceActualAmount;
	}

	public void setInvoiceActualAmount(BigDecimal invoiceActualAmount) {
		this.invoiceActualAmount = invoiceActualAmount;
	}

	public BigDecimal getInvoiceActualWeight() {
		return this.invoiceActualWeight;
	}

	public void setInvoiceActualWeight(BigDecimal invoiceActualWeight) {
		this.invoiceActualWeight = invoiceActualWeight;
	}

	public BigDecimal getInvoiceAgreeAmount() {
		return this.invoiceAgreeAmount;
	}

	public void setInvoiceAgreeAmount(BigDecimal invoiceAgreeAmount) {
		this.invoiceAgreeAmount = invoiceAgreeAmount;
	}

	public Date getInvoiceAgreeTime() {
		return this.invoiceAgreeTime;
	}

	public void setInvoiceAgreeTime(Date invoiceAgreeTime) {
		this.invoiceAgreeTime = invoiceAgreeTime;
	}

	public BigDecimal getInvoiceAgreeWeight() {
		return this.invoiceAgreeWeight;
	}

	public void setInvoiceAgreeWeight(BigDecimal invoiceAgreeWeight) {
		this.invoiceAgreeWeight = invoiceAgreeWeight;
	}

	public Long getInvoiceClientId() {
		return this.invoiceClientId;
	}

	public void setInvoiceClientId(Long invoiceClientId) {
		this.invoiceClientId = invoiceClientId;
	}

	public String getInvoiceClientName() {
		return this.invoiceClientName;
	}

	public void setInvoiceClientName(String invoiceClientName) {
		this.invoiceClientName = invoiceClientName;
	}

	public String getInvoiceMasterNum() {
		return this.invoiceMasterNum;
	}

	public void setInvoiceMasterNum(String invoiceMasterNum) {
		this.invoiceMasterNum = invoiceMasterNum;
	}

	public BigDecimal getInvoiceSplitAmount() {
		return this.invoiceSplitAmount;
	}

	public void setInvoiceSplitAmount(BigDecimal invoiceSplitAmount) {
		this.invoiceSplitAmount = invoiceSplitAmount;
	}

	public BigDecimal getInvoiceSplitWeight() {
		return this.invoiceSplitWeight;
	}

	public void setInvoiceSplitWeight(BigDecimal invoiceSplitWeight) {
		this.invoiceSplitWeight = invoiceSplitWeight;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Long getInvoiceTitleId() {
		return this.invoiceTitleId;
	}

	public void setInvoiceTitleId(Long invoiceTitleId) {
		this.invoiceTitleId = invoiceTitleId;
	}

	public String getInvoiceTitleName() {
		return this.invoiceTitleName;
	}

	public void setInvoiceTitleName(String invoiceTitleName) {
		this.invoiceTitleName = invoiceTitleName;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTicketOpeningMark() {
		return this.ticketOpeningMark;
	}

	public void setTicketOpeningMark(Integer ticketOpeningMark) {
		this.ticketOpeningMark = ticketOpeningMark;
	}

	public String getInvoiceDesc() {
		return invoiceDesc;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}
}