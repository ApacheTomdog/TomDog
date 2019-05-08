package com.brcc.business.flow.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="vatflowdetail")
public class VatflowdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vat_flow_detail_id")
	private Long vatFlowDetailId;

	@Column(name="if_begin")
	private String ifBegin;

	@Column(name="if_end")
	private String ifEnd;

	@Column(name="vat_acc_type")
	private String vatAccType;

	@Column(name="vat_carry_id")
	private Long vatCarryId;

	@Column(name="vat_carry_name")
	private String vatCarryName;

	@Column(name="vat_client_id")
	private Long vatClientId;

	@Column(name="vat_client_name")
	private String vatClientName;

	@Column(name="vat_flow_master_id")
	private Long vatFlowMasterId;

	@Column(name="vat_in_turn")
	private Long vatInTurn;

	@Column(name="vat_policy_rate")
	private BigDecimal vatPolicyRate;

	@Column(name="vat_rate_chose")
	private String vatRateChose;

	@Column(name="vat_standard_rate")
	private BigDecimal vatStandardRate;

	public VatflowdetailEntity() {
	}

	public Long getVatFlowDetailId() {
		return this.vatFlowDetailId;
	}

	public void setVatFlowDetailId(Long vatFlowDetailId) {
		this.vatFlowDetailId = vatFlowDetailId;
	}

	public String getIfBegin() {
		return this.ifBegin;
	}

	public void setIfBegin(String ifBegin) {
		this.ifBegin = ifBegin;
	}

	public String getIfEnd() {
		return this.ifEnd;
	}

	public void setIfEnd(String ifEnd) {
		this.ifEnd = ifEnd;
	}

	public String getVatAccType() {
		return this.vatAccType;
	}

	public void setVatAccType(String vatAccType) {
		this.vatAccType = vatAccType;
	}

	public Long getVatCarryId() {
		return this.vatCarryId;
	}

	public void setVatCarryId(Long vatCarryId) {
		this.vatCarryId = vatCarryId;
	}

	public String getVatCarryName() {
		return this.vatCarryName;
	}

	public void setVatCarryName(String vatCarryName) {
		this.vatCarryName = vatCarryName;
	}

	public Long getVatClientId() {
		return this.vatClientId;
	}

	public void setVatClientId(Long vatClientId) {
		this.vatClientId = vatClientId;
	}

	public String getVatClientName() {
		return this.vatClientName;
	}

	public void setVatClientName(String vatClientName) {
		this.vatClientName = vatClientName;
	}

	public Long getVatFlowMasterId() {
		return this.vatFlowMasterId;
	}

	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}

	public Long getVatInTurn() {
		return this.vatInTurn;
	}

	public void setVatInTurn(Long vatInTurn) {
		this.vatInTurn = vatInTurn;
	}

	public BigDecimal getVatPolicyRate() {
		return this.vatPolicyRate;
	}

	public void setVatPolicyRate(BigDecimal vatPolicyRate) {
		this.vatPolicyRate = vatPolicyRate;
	}

	public String getVatRateChose() {
		return this.vatRateChose;
	}

	public void setVatRateChose(String vatRateChose) {
		this.vatRateChose = vatRateChose;
	}

	public BigDecimal getVatStandardRate() {
		return this.vatStandardRate;
	}

	public void setVatStandardRate(BigDecimal vatStandardRate) {
		this.vatStandardRate = vatStandardRate;
	}

}