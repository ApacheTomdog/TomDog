package com.brcc.business.brokerFunds.vo;

import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class TransfiniteDispatchQueryVo extends BaseQueryVo{

	private static final long serialVersionUID = 1L;
	
	private Long companyId;
	
	private String platformId;
	
	private Long publishId;
	
	private Long transId;
	
	private Long deliveryId;
	
	private String ifFundsControlFlag;
	
	private Date rqStart;

    private Date rqEnd;

    private String zfNum;

	private String publishCompanyName;

	private String detailStatus;

	public Date getRqStart() {
		return rqStart;
	}

	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}

	public Date getRqEnd() {
		return rqEnd;
	}

	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}

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

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getIfFundsControlFlag() {
		return ifFundsControlFlag;
	}

	public void setIfFundsControlFlag(String ifFundsControlFlag) {
		this.ifFundsControlFlag = ifFundsControlFlag;
	}

	public String getZfNum() {
		return zfNum;
	}

	public String getPublishCompanyName() {
		return publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}

	public String getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}
}
