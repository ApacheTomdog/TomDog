package com.brcc.business.brokerProfit.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 修改条件
 * @author duanzongjie
 * @date 2019-01-29
 */
public class BrokerProfitConfigModifyVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer brokerProfitConfigId;

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

	/**
	 * '10'代表新增，'00'代表作废，'20'代表生效
	 */
	private String brokerProfitConfigStatus;

	private Date modifyDate;

	private Integer modifyPersonId;

	private String modifyPersonName;

	public Integer getBrokerProfitConfigId() {
		return brokerProfitConfigId;
	}

	public void setBrokerProfitConfigId(Integer brokerProfitConfigId) {
		this.brokerProfitConfigId = brokerProfitConfigId;
	}

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

	public String getBrokerProfitConfigStatus() {
		return brokerProfitConfigStatus;
	}

	public void setBrokerProfitConfigStatus(String brokerProfitConfigStatus) {
		this.brokerProfitConfigStatus = brokerProfitConfigStatus;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Integer modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	@Override
	public String toString() {
		return "BrokerProfitConfigModifyVo [brokerProfitConfigId=" + brokerProfitConfigId + ", brokerProfitRate=" + brokerProfitRate + ", ifSpecialCase=" + ifSpecialCase + ", specialBrokerId=" + specialBrokerId + ", specialBrokerName=" + specialBrokerName + ", platformId=" + platformId + ", specialRemark=" + specialRemark + ", specialAttachment=" + specialAttachment + ", brokerProfitConfigStatus=" + brokerProfitConfigStatus + ", modifyDate=" + modifyDate + ", modifyPersonId=" + modifyPersonId
				+ ", modifyPersonName=" + modifyPersonName + "]";
	}
}