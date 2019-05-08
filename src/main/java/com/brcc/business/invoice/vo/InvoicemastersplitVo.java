package com.brcc.business.invoice.vo;

import com.brcc.business.invoice.entity.InvoicemastersplitEntity;

import java.math.BigDecimal;

/**
 * @Description 发票vo
 * @author yangwenbin
 * @version 创建时间：2018年11月23日 上午9:48:01
 */
public class InvoicemastersplitVo extends InvoicemastersplitEntity {
	private static final long serialVersionUID = 2309038212850705830L;
	
	private String invoiceStatusDesc;
	private String ticketOpeningMarkDesc;
	private BigDecimal noTaxAmount;
	
	public String getInvoiceStatusDesc() {
		return invoiceStatusDesc;
	}
	public void setInvoiceStatusDesc(String invoiceStatusDesc) {
		this.invoiceStatusDesc = invoiceStatusDesc;
	}
	public String getTicketOpeningMarkDesc() {
		return ticketOpeningMarkDesc;
	}
	public void setTicketOpeningMarkDesc(String ticketOpeningMarkDesc) {
		this.ticketOpeningMarkDesc = ticketOpeningMarkDesc;
	}
	public BigDecimal getNoTaxAmount() {
		return noTaxAmount;
	}
	public void setNoTaxAmount(BigDecimal noTaxAmount) {
		this.noTaxAmount = noTaxAmount;
	}
	
}