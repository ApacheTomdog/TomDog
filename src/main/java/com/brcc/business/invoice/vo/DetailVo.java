package com.brcc.business.invoice.vo;

import java.math.BigDecimal;

/**
 * @Description 明细vo
 * @author yangwenbin
 * @version 创建时间：2018年11月27日 上午9:52:46
 */
public class DetailVo implements Comparable<DetailVo>{
	private Long invoiceDetailId;
	private BigDecimal invoiceDetailAmount;
	
	public Long getInvoiceDetailId() {
		return invoiceDetailId;
	}
	public void setInvoiceDetailId(Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	public BigDecimal getInvoiceDetailAmount() {
		return invoiceDetailAmount;
	}
	public void setInvoiceDetailAmount(BigDecimal invoiceDetailAmount) {
		this.invoiceDetailAmount = invoiceDetailAmount;
	}
	
	@Override
	public int compareTo(DetailVo o) {
		return this.invoiceDetailAmount.compareTo(o.invoiceDetailAmount);
	}
	
	@Override
	public String toString() {
		return "DetailVo [invoiceDetailId=" + invoiceDetailId + ", invoiceDetailAmount=" + invoiceDetailAmount + "]";
	}
}
