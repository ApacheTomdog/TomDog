package com.brcc.business.goodsordermautoprice.vo;

import java.math.BigDecimal;
import java.util.Date;

public class AutoPriceVo {
	private Long gAId;
	private String platformId;// 平台id
	private Long companyId;
	private String companyName;
	private String companyStatus;
	private Date lastTime;
	private Long priceType;
	private BigDecimal price;
	private Date createDate;
	private Long createPersonId;
	private String createPersonName;
	private Date modifyDate;
	private Long modifyPersonId;
	private Long publishId;
	private String modifyPersonName;
	private Date timingTypeTime;
	private String lastResultReason;
	private String publishInfo;
	
	public String getPublishInfo() {
		return publishInfo;
	}

	public void setPublishInfo(String publishInfo) {
		this.publishInfo = publishInfo;
	}

	public String getLastResultReason() {
		return lastResultReason;
	}

	public void setLastResultReason(String lastResultReason) {
		this.lastResultReason = lastResultReason;
	}

	public Date getTimingTypeTime() {
		return timingTypeTime;
	}

	public void setTimingTypeTime(Date timingTypeTime) {
		this.timingTypeTime = timingTypeTime;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Long getgAId() {
		return gAId;
	}

	public void setgAId(Long gAId) {
		this.gAId = gAId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Long getPriceType() {
		return priceType;
	}

	public void setPriceType(Long priceType) {
		this.priceType = priceType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

}
