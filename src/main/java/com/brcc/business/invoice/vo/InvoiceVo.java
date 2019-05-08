package com.brcc.business.invoice.vo;

import java.math.BigDecimal;

/**
 * @Description 
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 下午4:26:57
 */
public class InvoiceVo {
	
	private Long vatClientId;
	private String vatClientName;
	private Long vatCarryId;
	private String vatCarryName;
	private BigDecimal invoiceConfigAmount;
	private String invoiceTitleName;
	private String invoiceClientName;
	private String ifBegin;
	private String ifEnd;
	
	// 发票拆分
	private Long invoiceTitleId;
	private Long invoiceClientId;
	private BigDecimal invoiceAmount;
	private BigDecimal invoiceWeight;
	private Long groupId;
	private String groupName;
	private Integer ticketOpeningMark;
	
	public Long getInvoiceTitleId() {
		return invoiceTitleId;
	}
	public void setInvoiceTitleId(Long invoiceTitleId) {
		this.invoiceTitleId = invoiceTitleId;
	}
	public Long getInvoiceClientId() {
		return invoiceClientId;
	}
	public void setInvoiceClientId(Long invoiceClientId) {
		this.invoiceClientId = invoiceClientId;
	}
	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public BigDecimal getInvoiceWeight() {
		return invoiceWeight;
	}
	public void setInvoiceWeight(BigDecimal invoiceWeight) {
		this.invoiceWeight = invoiceWeight;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getTicketOpeningMark() {
		return ticketOpeningMark;
	}
	public void setTicketOpeningMark(Integer ticketOpeningMark) {
		this.ticketOpeningMark = ticketOpeningMark;
	}
	public String getInvoiceTitleName() {
		return invoiceTitleName;
	}
	public void setInvoiceTitleName(String invoiceTitleName) {
		this.invoiceTitleName = invoiceTitleName;
	}
	public String getInvoiceClientName() {
		return invoiceClientName;
	}
	public void setInvoiceClientName(String invoiceClientName) {
		this.invoiceClientName = invoiceClientName;
	}
	public String getIfBegin() {
		return ifBegin;
	}
	public void setIfBegin(String ifBegin) {
		this.ifBegin = ifBegin;
	}
	public String getIfEnd() {
		return ifEnd;
	}
	public void setIfEnd(String ifEnd) {
		this.ifEnd = ifEnd;
	}
	public Long getVatClientId() {
		return vatClientId;
	}
	public void setVatClientId(Long vatClientId) {
		this.vatClientId = vatClientId;
	}
	public String getVatClientName() {
		return vatClientName;
	}
	public void setVatClientName(String vatClientName) {
		this.vatClientName = vatClientName;
	}
	public Long getVatCarryId() {
		return vatCarryId;
	}
	public void setVatCarryId(Long vatCarryId) {
		this.vatCarryId = vatCarryId;
	}
	public String getVatCarryName() {
		return vatCarryName;
	}
	public void setVatCarryName(String vatCarryName) {
		this.vatCarryName = vatCarryName;
	}
	public BigDecimal getInvoiceConfigAmount() {
		return invoiceConfigAmount;
	}
	public void setInvoiceConfigAmount(BigDecimal invoiceConfigAmount) {
		this.invoiceConfigAmount = invoiceConfigAmount;
	}
}
