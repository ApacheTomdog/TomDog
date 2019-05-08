package com.brcc.business.reinvoiceRateConfig.vo;

import com.esteel.common.vo.BaseQueryVo;

public class ReinvoiceRateConfigQueryVo extends BaseQueryVo{

	private static final long serialVersionUID = 1L;
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
