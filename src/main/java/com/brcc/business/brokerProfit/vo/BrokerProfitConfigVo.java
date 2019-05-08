package com.brcc.business.brokerProfit.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经纪人最高分润配置
 * @author dzj
 * @Date 2019-01-29
 */
public class BrokerProfitConfigVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer brokerProfitConfigId;
	
	/**
	 * 利益分配名
	 */
	private String brokerProfitConfigName;
	
	/**
	 * 平台id
	 */
	private String platformId;
	
	/**
	 * 分配比率（20%）为0.2
	 */
	private BigDecimal brokerProfitRate;
	
	/**
	 * 0代表不需要，1代表需要
	 */
	private String ifUploadCapitalFlow;
	
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
	
	private Date createDate;
	
	private Integer createPersonId;
	
	private String createPersonName;
	 
	private Date modifyDate;
	
	private Integer modifyPersonId;
	
	private String modifyPersonName;
	
	private Date systemTimestamp;

	public Integer getBrokerProfitConfigId() {
		return brokerProfitConfigId;
	}

	public void setBrokerProfitConfigId(Integer brokerProfitConfigId) {
		this.brokerProfitConfigId = brokerProfitConfigId;
	}

	public String getBrokerProfitConfigName() {
		return brokerProfitConfigName;
	}

	public void setBrokerProfitConfigName(String brokerProfitConfigName) {
		this.brokerProfitConfigName = brokerProfitConfigName;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public BigDecimal getBrokerProfitRate() {
		return brokerProfitRate;
	}

	public void setBrokerProfitRate(BigDecimal brokerProfitRate) {
		this.brokerProfitRate = brokerProfitRate;
	}

	public String getIfUploadCapitalFlow() {
		return ifUploadCapitalFlow;
	}

	public void setIfUploadCapitalFlow(String ifUploadCapitalFlow) {
		this.ifUploadCapitalFlow = ifUploadCapitalFlow;
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

	public Date getSystemTimestamp() {
		return systemTimestamp;
	}

	public void setSystemTimestamp(Date systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	@Override
	public String toString() {
		return "BrokerProfitConfigVo [brokerProfitConfigId=" + brokerProfitConfigId + ", brokerProfitConfigName=" + brokerProfitConfigName + ", platformId=" + platformId + ", brokerProfitRate=" + brokerProfitRate + ", ifUploadCapitalFlow=" + ifUploadCapitalFlow + ", ifSpecialCase=" + ifSpecialCase + ", specialBrokerId=" + specialBrokerId + ", specialBrokerName=" + specialBrokerName + ", specialRemark=" + specialRemark + ", specialAttachment=" + specialAttachment + ", brokerProfitConfigStatus="
				+ brokerProfitConfigStatus + ", createDate=" + createDate + ", createPersonId=" + createPersonId + ", createPersonName=" + createPersonName + ", modifyDate=" + modifyDate + ", modifyPersonId=" + modifyPersonId + ", modifyPersonName=" + modifyPersonName + ", systemTimestamp=" + systemTimestamp + "]";
	}
}