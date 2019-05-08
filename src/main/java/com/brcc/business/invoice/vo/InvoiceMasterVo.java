package com.brcc.business.invoice.vo;

import java.math.BigDecimal;

import com.brcc.business.invoice.entity.InvoicemasterEntity;

/**
 * @Description 发票数据vo
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:06:59
 */
public class InvoiceMasterVo extends InvoicemasterEntity {

	private static final long serialVersionUID = 6397958236821568229L;
	
	private String invoiceStatusDesc;
	private BigDecimal sumykAmount;
	private BigDecimal sumykWeight;
	private BigDecimal sumyfAmount;
	private BigDecimal sumyfWeight;
	private String ticketOpeningMarkDesc;
	
	private String ifAmountSplitCompleted;
	private String ifWeightSplitCompleted;
	
	// 已开发票金额，重量合计
	private BigDecimal invoicedAmount;
	private BigDecimal invoicedWeight;
	
	public BigDecimal getInvoicedAmount() {
		return invoicedAmount;
	}
	public void setInvoicedAmount(BigDecimal invoicedAmount) {
		this.invoicedAmount = invoicedAmount;
	}
	public BigDecimal getInvoicedWeight() {
		return invoicedWeight;
	}
	public void setInvoicedWeight(BigDecimal invoicedWeight) {
		this.invoicedWeight = invoicedWeight;
	}
	public String getIfAmountSplitCompleted() {
		return ifAmountSplitCompleted;
	}
	public void setIfAmountSplitCompleted(String ifAmountSplitCompleted) {
		this.ifAmountSplitCompleted = ifAmountSplitCompleted;
	}
	public String getIfWeightSplitCompleted() {
		return ifWeightSplitCompleted;
	}
	public void setIfWeightSplitCompleted(String ifWeightSplitCompleted) {
		this.ifWeightSplitCompleted = ifWeightSplitCompleted;
	}
	public String getInvoiceStatusDesc() {
		return invoiceStatusDesc;
	}
	public void setInvoiceStatusDesc(String invoiceStatusDesc) {
		this.invoiceStatusDesc = invoiceStatusDesc;
	}
	public BigDecimal getSumykAmount() {
		return sumykAmount;
	}
	public void setSumykAmount(BigDecimal sumykAmount) {
		this.sumykAmount = sumykAmount;
	}
	public BigDecimal getSumykWeight() {
		return sumykWeight;
	}
	public void setSumykWeight(BigDecimal sumykWeight) {
		this.sumykWeight = sumykWeight;
	}
	public BigDecimal getSumyfAmount() {
		return sumyfAmount;
	}
	public void setSumyfAmount(BigDecimal sumyfAmount) {
		this.sumyfAmount = sumyfAmount;
	}
	public BigDecimal getSumyfWeight() {
		return sumyfWeight;
	}
	public void setSumyfWeight(BigDecimal sumyfWeight) {
		this.sumyfWeight = sumyfWeight;
	}
	public String getTicketOpeningMarkDesc() {
		return ticketOpeningMarkDesc;
	}
	public void setTicketOpeningMarkDesc(String ticketOpeningMarkDesc) {
		this.ticketOpeningMarkDesc = ticketOpeningMarkDesc;
	}
	
}
