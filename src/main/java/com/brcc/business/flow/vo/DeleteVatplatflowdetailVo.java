package com.brcc.business.flow.vo;

import java.io.Serializable;

public class DeleteVatplatflowdetailVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long vatPlatFlowMasterId;
	
	private String vatPlatFlowDetailIdStr;

	public Long getVatPlatFlowMasterId() {
		return vatPlatFlowMasterId;
	}

	public void setVatPlatFlowMasterId(Long vatPlatFlowMasterId) {
		this.vatPlatFlowMasterId = vatPlatFlowMasterId;
	}

	public String getVatPlatFlowDetailIdStr() {
		return vatPlatFlowDetailIdStr;
	}

	public void setVatPlatFlowDetailIdStr(String vatPlatFlowDetailIdStr) {
		this.vatPlatFlowDetailIdStr = vatPlatFlowDetailIdStr;
	}
	
}