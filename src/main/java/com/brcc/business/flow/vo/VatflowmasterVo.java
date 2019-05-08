package com.brcc.business.flow.vo;

import java.math.BigDecimal;

import javax.persistence.Column;

import com.brcc.business.flow.entity.VatflowmasterEntity;


public class VatflowmasterVo extends VatflowmasterEntity {
	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;
	
	@Column(name="vat_rate_chose")
	private String vatRateChose;
	
	@Column(name="vat_standard_rate")
	private BigDecimal vatStandardRate;
	
	@Column(name="vat_policy_rate")
	private BigDecimal vatPolicyRate;
	
	@Column(name="vat_acc_type")
	private String vatAccType;

	public Long getVatFlowMasterId() {
		return vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public String getVatRateChose() {
		return vatRateChose;
	}

	public void setVatRateChose(String vatRateChose) {
		this.vatRateChose = vatRateChose;
	}

	public BigDecimal getVatStandardRate() {
		return vatStandardRate;
	}

	public void setVatStandardRate(BigDecimal vatStandardRate) {
		this.vatStandardRate = vatStandardRate;
	}

	public BigDecimal getVatPolicyRate() {
		return vatPolicyRate;
	}

	public void setVatPolicyRate(BigDecimal vatPolicyRate) {
		this.vatPolicyRate = vatPolicyRate;
	}

	public String getVatAccType() {
		return vatAccType;
	}

	public void setVatAccType(String vatAccType) {
		this.vatAccType = vatAccType;
	}
	
}
