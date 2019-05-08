package com.brcc.business.invoice.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.invoice.entity.InvoicedetailEntity;

/**
 * @Description 发票明细vo
 * @author yangwenbin
 * @version 创建时间：2018年11月21日 下午8:37:03
 */
public class InvoiceDetailVo extends InvoicedetailEntity {
	private static final long serialVersionUID = -2210527668884288731L;
	
	private String zfNum;
	private String dependNum;
	private BigDecimal ownerAdjustAmt;
	private String ownerAdjustFlag;
	private String ownerAdjustType;
	private BigDecimal ownerAdjustTotAmt;
	private BigDecimal priceTax;
	private BigDecimal deductAmount;
	private Date finishTime;
	private BigDecimal payFeeAmount;
	private String ticketOpeningMarkDesc;
	private String ifApply;
	private String poundLocation;
	private String poundNum;
	private Date shippingTime;
	private BigDecimal payAmount;
	//合同编号
	private String contractNumber;

	//合同类型
	private String contractType;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getZfNum() {
		return zfNum;
	}
	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public BigDecimal getOwnerAdjustAmt() {
		return ownerAdjustAmt;
	}
	public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
		this.ownerAdjustAmt = ownerAdjustAmt;
	}
	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}
	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}
	public String getOwnerAdjustType() {
		return ownerAdjustType;
	}
	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}
	public BigDecimal getOwnerAdjustTotAmt() {
		return ownerAdjustTotAmt;
	}
	public void setOwnerAdjustTotAmt(BigDecimal ownerAdjustTotAmt) {
		this.ownerAdjustTotAmt = ownerAdjustTotAmt;
	}
	public BigDecimal getPriceTax() {
		return priceTax;
	}
	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}
	public BigDecimal getDeductAmount() {
		return deductAmount;
	}
	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public BigDecimal getPayFeeAmount() {
		return payFeeAmount;
	}
	public void setPayFeeAmount(BigDecimal payFeeAmount) {
		this.payFeeAmount = payFeeAmount;
	}
	public String getTicketOpeningMarkDesc() {
		return ticketOpeningMarkDesc;
	}
	public void setTicketOpeningMarkDesc(String ticketOpeningMarkDesc) {
		this.ticketOpeningMarkDesc = ticketOpeningMarkDesc;
	}
	public String getIfApply() {
		return ifApply;
	}
	public void setIfApply(String ifApply) {
		this.ifApply = ifApply;
	}
	public String getPoundLocation() {
		return poundLocation;
	}
	public void setPoundLocation(String poundLocation) {
		this.poundLocation = poundLocation;
	}
	public String getPoundNum() {
		return poundNum;
	}
	public void setPoundNum(String poundNum) {
		this.poundNum = poundNum;
	}
	public Date getShippingTime() {
		return shippingTime;
	}
	public void setShippingTime(Date shippingTime) {
		this.shippingTime = shippingTime;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
}
