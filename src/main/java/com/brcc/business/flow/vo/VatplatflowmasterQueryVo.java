package com.brcc.business.flow.vo;

import com.esteel.common.vo.BaseQueryVo;

public class VatplatflowmasterQueryVo extends BaseQueryVo {
	
	private String ifSpecialCase;

	private String platformId;

	private Long specialClientId;

	private String specialClientName;

	private String vatAccType;

	private Long vatCompanyId;

	private String vatPlatFlowMasterName;

	private String vatStatus;

	public VatplatflowmasterQueryVo() {
	}


	public String getIfSpecialCase() {
		return this.ifSpecialCase;
	}

	public void setIfSpecialCase(String ifSpecialCase) {
		this.ifSpecialCase = ifSpecialCase;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getSpecialClientId() {
		return this.specialClientId;
	}

	public void setSpecialClientId(Long specialClientId) {
		this.specialClientId = specialClientId;
	}

	public String getSpecialClientName() {
		return this.specialClientName;
	}

	public void setSpecialClientName(String specialClientName) {
		this.specialClientName = specialClientName;
	}

	public String getVatAccType() {
		return this.vatAccType;
	}

	public void setVatAccType(String vatAccType) {
		this.vatAccType = vatAccType;
	}

	public Long getVatCompanyId() {
		return this.vatCompanyId;
	}

	public void setVatCompanyId(Long vatCompanyId) {
		this.vatCompanyId = vatCompanyId;
	}

	public String getVatPlatFlowMasterName() {
		return this.vatPlatFlowMasterName;
	}

	public void setVatPlatFlowMasterName(String vatPlatFlowMasterName) {
		this.vatPlatFlowMasterName = vatPlatFlowMasterName;
	}

	public String getVatStatus() {
		return this.vatStatus;
	}

	public void setVatStatus(String vatStatus) {
		this.vatStatus = vatStatus;
	}

}