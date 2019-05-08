package com.brcc.business.shipperStatistics.vo;

import com.esteel.common.vo.BaseQueryVo;

public class ShipperStatisticsQueryVo extends BaseQueryVo{

	
	private static final long serialVersionUID = 1L;
	
	private Long companyId;
	
	private String platformId;

	
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	

}
