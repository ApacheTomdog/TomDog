package com.brcc.business.brokerProfit.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 新增条件
 * @author duanzongjie
 * @date 2019-01-29
 */
public class BrokerProfitConfigAddVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分配比率（20%）为0.2
	 */
	private BigDecimal brokerProfitRate;

	/**
	 * '0'代表常规，'1'代表特例
	 */
	private String ifSpecialCase;

	/**
	 * 特例经纪人
	 */
	private Integer specialBrokerId;

	/**
	 * 特例经纪人
	 */
	private String specialBrokerName;

	/**
	 * 平台id
	 */
	private String platformId;

	/**
	 * 特例备注
	 */
	private String specialRemark;

	/**
	 * 特例附件
	 */
	private String specialAttachment;

	private Date createDate;

	private Integer createPersonId;

	private String createPersonName;

	public BigDecimal getBrokerProfitRate() {
		return brokerProfitRate;
	}

	public void setBrokerProfitRate(BigDecimal brokerProfitRate) {
		this.brokerProfitRate = brokerProfitRate;
	}

	public String getIfSpecialCase() {
		return ifSpecialCase;
	}

	public void setIfSpecialCase(String ifSpecialCase) {
		this.ifSpecialCase = ifSpecialCase;
	}

	public Integer getSpecialBrokerId() {
		return specialBrokerId;
	}

	public void setSpecialBrokerId(Integer specialBrokerId) {
		this.specialBrokerId = specialBrokerId;
	}

	public String getSpecialBrokerName() {
		return specialBrokerName;
	}

	public void setSpecialBrokerName(String specialBrokerName) {
		this.specialBrokerName = specialBrokerName;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getSpecialRemark() {
		return specialRemark;
	}

	public void setSpecialRemark(String specialRemark) {
		this.specialRemark = specialRemark;
	}

	public String getSpecialAttachment() {
		return specialAttachment;
	}

	public void setSpecialAttachment(String specialAttachment) {
		this.specialAttachment = specialAttachment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(Integer createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	@Override
	public String toString() {
		return "BrokerProfitConfigAddVo [brokerProfitRate=" + brokerProfitRate + ", ifSpecialCase=" + ifSpecialCase + ", specialBrokerId=" + specialBrokerId + ", specialBrokerName=" + specialBrokerName + ", platformId=" + platformId + ", specialRemark=" + specialRemark + ", specialAttachment=" + specialAttachment + ", createDate=" + createDate + ", createPersonId=" + createPersonId + ", createPersonName=" + createPersonName + "]";
	}
}