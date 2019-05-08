package com.brcc.business.priceClientRate.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class PriceClientRateQueryVo extends BaseQueryVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long priceClientRateId;
	private String platformId;
	private Long carryId;
	private String  carryName;
	private Long clientId;
	private String clientName;
	private BigDecimal clientRate;
	private String clientRateType;
	/*private String createDate;*/
	private Date rqStart;
	private Date rqEnd;
	private Long createPersonId;
	private String createPersonName;
	private Date modifyDate;
	private Long modifyPersonId;
	private String modifyPersonName;
	private String queryKey;
	private String queryValue;

	public Long getCarryId() {
		return carryId;
	}

	public void setCarryId(Long carryId) {
		this.carryId = carryId;
	}

	public String getCarryName() {
		return carryName;
	}

	public void setCarryName(String carryName) {
		this.carryName = carryName;
	}

	public Long getPriceClientRateId() {
		return priceClientRateId;
	}

	public void setPriceClientRateId(Long priceClientRateId) {
		this.priceClientRateId = priceClientRateId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BigDecimal getClientRate() {
		return clientRate;
	}

	public void setClientRate(BigDecimal clientRate) {
		this.clientRate = clientRate;
	}

	public String getClientRateType() {
		return clientRateType;
	}

	public void setClientRateType(String clientRateType) {
		this.clientRateType = clientRateType;
	}

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

	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

}
