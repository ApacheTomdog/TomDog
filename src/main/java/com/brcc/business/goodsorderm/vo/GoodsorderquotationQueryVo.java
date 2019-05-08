package com.brcc.business.goodsorderm.vo;

import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;

/**
* @Desc   货源单货物单价报价数据封装类
* @author TangYong
* @Date   2018-12-05
*/
public class GoodsorderquotationQueryVo extends GoodsorderquotationEntity {
	
	private static final long serialVersionUID = 1L;
	private String userType;
	private String contactMobile;
	private String statusDesc;
	private String isTransport;
	private String tranNum;
	private String tranStatus;
	// 报价单id
	private Long quotationId;
	// 公司名称
	private String consignorName;
	
	private String platformId;
	
	private String platName;
	
	private Long userId;
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getIsTransport() {
		return isTransport;
	}
	public void setIsTransport(String isTransport) {
		this.isTransport = isTransport;
	}
	public String getTranNum() {
		return tranNum;
	}
	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	public Long getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}
	public String getConsignorName() {
		return consignorName;
	}
	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getPlatName() {
		return platName;
	}
	public void setPlatName(String platName) {
		this.platName = platName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
