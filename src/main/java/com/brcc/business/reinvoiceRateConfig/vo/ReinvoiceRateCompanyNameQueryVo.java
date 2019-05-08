package com.brcc.business.reinvoiceRateConfig.vo;

import com.esteel.common.vo.BaseQueryVo;

public class ReinvoiceRateCompanyNameQueryVo extends BaseQueryVo{

	
	private static final long serialVersionUID = 1L;
	
	 private String platformId;
	 
	 private String companyName;

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	 
	 

}
