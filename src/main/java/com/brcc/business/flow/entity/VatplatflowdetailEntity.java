package com.brcc.business.flow.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="vatplatflowdetail")
public class VatplatflowdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vat_plat_flow_detail_id")
	private Long vatPlatFlowDetailId;

	@Column(name="if_begin")
	private String ifBegin;

	@Column(name="if_end")
	private String ifEnd;

	@Column(name="vat_carry_id")
	private Long vatCarryId;

	@Column(name="vat_carry_name")
	private String vatCarryName;

	@Column(name="vat_in_turn")
	private Long vatInTurn;

	@Column(name="vat_plat_flow_master_id")
	private Long vatPlatFlowMasterId;

	@Column(name="vat_policy_rate")
	private BigDecimal vatPolicyRate;

	public VatplatflowdetailEntity() {
	}

	public Long getVatPlatFlowDetailId() {
		return this.vatPlatFlowDetailId;
	}

	public void setVatPlatFlowDetailId(Long vatPlatFlowDetailId) {
		this.vatPlatFlowDetailId = vatPlatFlowDetailId;
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

	public Long getVatInTurn() {
		return this.vatInTurn;
	}

	public void setVatInTurn(Long vatInTurn) {
		this.vatInTurn = vatInTurn;
	}

	public Long getVatPlatFlowMasterId() {
		return this.vatPlatFlowMasterId;
	}

	public void setVatPlatFlowMasterId(Long vatPlatFlowMasterId) {
		this.vatPlatFlowMasterId = vatPlatFlowMasterId;
	}

	public BigDecimal getVatPolicyRate() {
		return this.vatPolicyRate;
	}

	public void setVatPolicyRate(BigDecimal vatPolicyRate) {
		this.vatPolicyRate = vatPolicyRate;
	}

}