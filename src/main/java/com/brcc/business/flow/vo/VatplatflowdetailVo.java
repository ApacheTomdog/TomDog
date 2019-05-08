package com.brcc.business.flow.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class VatplatflowdetailVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long vatPlatFlowDetailId;

	private String ifBegin;

	private String ifEnd;

	private Long vatCarryId;

	private String vatCarryName;

	private Long vatInTurn;

	private Long vatPlatFlowMasterId;

	private BigDecimal vatPolicyRate;
	private BigDecimal vatStandardRate;
	private String vatStatus;
	private String platformId;


	public BigDecimal getVatStandardRate() {
		return vatStandardRate;
	}

	public void setVatStandardRate(BigDecimal vatStandardRate) {
		this.vatStandardRate = vatStandardRate;
	}

	public String getVatStatus() {
		return vatStatus;
	}

	public void setVatStatus(String vatStatus) {
		this.vatStatus = vatStatus;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public VatplatflowdetailVo() {
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