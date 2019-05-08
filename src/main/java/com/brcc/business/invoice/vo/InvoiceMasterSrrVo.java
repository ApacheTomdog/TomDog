package com.brcc.business.invoice.vo;

import com.brcc.business.invoice.entity.InvoicemastersplitSrrEntity;

import java.math.BigDecimal;

/**
 * @Description 作废、红冲发票的接收类
 * @Author pjy
 * @Date
 **/
public class InvoiceMasterSrrVo extends InvoicemastersplitSrrEntity {
    //发票的不含税金额
    private BigDecimal noTaxAmount;
    //发票的状态
    private String invoiceStatusDesc;
    private String ticketOpeningMarkDesc;
    private String invoiceTypeDesc;
    public BigDecimal getNoTaxAmount() {
        return noTaxAmount;
    }

    public void setNoTaxAmount(BigDecimal noTaxAmount) {
        this.noTaxAmount = noTaxAmount;
    }

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

    public String getInvoiceTypeDesc() {
        return invoiceTypeDesc;
    }

    public void setInvoiceTypeDesc(String invoiceTypeDesc) {
        this.invoiceTypeDesc = invoiceTypeDesc;
    }
}
