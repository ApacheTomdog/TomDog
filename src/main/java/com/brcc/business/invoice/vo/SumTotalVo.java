package com.brcc.business.invoice.vo;

import java.math.BigDecimal;

/**
 * @Description 合计数据接收vo
 * @author yangwenbin
 * @version 创建时间：2018年12月7日 下午2:57:04
 */
public class SumTotalVo {
	
	// 支付单合计
	private BigDecimal payAmountActTaxSum;
	private BigDecimal settleWeightSum;
	private BigDecimal deductAmountSum;
	private BigDecimal truckWeightSum;
	private BigDecimal takeWeightSum;
	
	// 发票明细合计
	private BigDecimal invoiceAmtSum;
	private BigDecimal invoiceWeightSum;
	
	// 查看发票明细合计
	private BigDecimal invoiceActualAmountSum;
	private BigDecimal invoiceActualWeightSum;
	private String ticketOpeningMarkDesc;
	
	// 作废剩余量合计
	private BigDecimal invalidInvoiceAmountSum;
	private BigDecimal invalidInvoiceWeightSum;
	
	public BigDecimal getInvalidInvoiceAmountSum() {
		return invalidInvoiceAmountSum;
	}
	public void setInvalidInvoiceAmountSum(BigDecimal invalidInvoiceAmountSum) {
		this.invalidInvoiceAmountSum = invalidInvoiceAmountSum;
	}
	public BigDecimal getInvalidInvoiceWeightSum() {
		return invalidInvoiceWeightSum;
	}
	public void setInvalidInvoiceWeightSum(BigDecimal invalidInvoiceWeightSum) {
		this.invalidInvoiceWeightSum = invalidInvoiceWeightSum;
	}
	public String getTicketOpeningMarkDesc() {
		return ticketOpeningMarkDesc;
	}
	public void setTicketOpeningMarkDesc(String ticketOpeningMarkDesc) {
		this.ticketOpeningMarkDesc = ticketOpeningMarkDesc;
	}
	public BigDecimal getPayAmountActTaxSum() {
		return payAmountActTaxSum;
	}
	public void setPayAmountActTaxSum(BigDecimal payAmountActTaxSum) {
		this.payAmountActTaxSum = payAmountActTaxSum;
	}
	public BigDecimal getInvoiceWeightSum() {
		return invoiceWeightSum;
	}
	public void setInvoiceWeightSum(BigDecimal invoiceWeightSum) {
		this.invoiceWeightSum = invoiceWeightSum;
	}
	public BigDecimal getInvoiceActualAmountSum() {
		return invoiceActualAmountSum;
	}
	public void setInvoiceActualAmountSum(BigDecimal invoiceActualAmountSum) {
		this.invoiceActualAmountSum = invoiceActualAmountSum;
	}
	public BigDecimal getInvoiceActualWeightSum() {
		return invoiceActualWeightSum;
	}
	public void setInvoiceActualWeightSum(BigDecimal invoiceActualWeightSum) {
		this.invoiceActualWeightSum = invoiceActualWeightSum;
	}
	public BigDecimal getInvoiceAmtSum() {
		return invoiceAmtSum;
	}
	public void setInvoiceAmtSum(BigDecimal invoiceAmtSum) {
		this.invoiceAmtSum = invoiceAmtSum;
	}
	public BigDecimal getSettleWeightSum() {
		return settleWeightSum;
	}
	public void setSettleWeightSum(BigDecimal settleWeightSum) {
		this.settleWeightSum = settleWeightSum;
	}
	public BigDecimal getDeductAmountSum() {
		return deductAmountSum;
	}
	public void setDeductAmountSum(BigDecimal deductAmountSum) {
		this.deductAmountSum = deductAmountSum;
	}
	public BigDecimal getTruckWeightSum() {
		return truckWeightSum;
	}
	public void setTruckWeightSum(BigDecimal truckWeightSum) {
		this.truckWeightSum = truckWeightSum;
	}
	public BigDecimal getTakeWeightSum() {
		return takeWeightSum;
	}
	public void setTakeWeightSum(BigDecimal takeWeightSum) {
		this.takeWeightSum = takeWeightSum;
	}
}
