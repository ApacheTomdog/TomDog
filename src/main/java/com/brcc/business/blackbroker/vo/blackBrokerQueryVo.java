package com.brcc.business.blackbroker.vo;

import com.esteel.common.vo.BaseQueryVo;

public class blackBrokerQueryVo extends BaseQueryVo {
	private String platformId;
	private String blockBrokerStatus;
	private String brokerCompanyName;
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getBlockBrokerStatus() {
		return blockBrokerStatus;
	}
	public void setBlockBrokerStatus(String blockBrokerStatus) {
		this.blockBrokerStatus = blockBrokerStatus;
	}
	public String getBrokerCompanyName() {
		return brokerCompanyName;
	}
	public void setBrokerCompanyName(String brokerCompanyName) {
		this.brokerCompanyName = brokerCompanyName;
	}
	
}
