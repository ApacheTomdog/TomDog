package com.brcc.business.brokerProfit.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 经纪人最高分润配置
 * 
 * @author dzj
 * @date 2019-01-29
 */
@Entity
@Table(name = "broker_profit_config")
@DynamicInsert
@DynamicUpdate
@NamedQuery(name = "BrokerProfitConfigEntity.findAll", query = "SELECT a FROM BrokerProfitConfigEntity a")
public class BrokerProfitConfigEntity {
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

	private Date auditDate;

	private Integer auditPersonId;

	private String auditPersonName;

	private Date cancelDate;

	private Integer cancelPersonId;

	private String cancelPersonName;

	private Date modifyDate;

	private Integer modifyPersonId;

	private String modifyPersonName;

	private Date systemTimestamp;

	@Id
	@Column(name = "broker_profit_config_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBrokerProfitConfigId() {
		return brokerProfitConfigId;
	}

	public void setBrokerProfitConfigId(Integer brokerProfitConfigId) {
		this.brokerProfitConfigId = brokerProfitConfigId;
	}

	@Basic
	@Column(name = "broker_profit_config_name")
	public String getBrokerProfitConfigName() {
		return brokerProfitConfigName;
	}

	public void setBrokerProfitConfigName(String brokerProfitConfigName) {
		this.brokerProfitConfigName = brokerProfitConfigName;
	}

	@Basic
	@Column(name = "platform_id")
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	@Basic
	@Column(name = "broker_profit_rate")
	public BigDecimal getBrokerProfitRate() {
		return brokerProfitRate;
	}

	public void setBrokerProfitRate(BigDecimal brokerProfitRate) {
		this.brokerProfitRate = brokerProfitRate;
	}

	@Basic
	@Column(name = "if_upload_capital_flow")
	public String getIfUploadCapitalFlow() {
		return ifUploadCapitalFlow;
	}

	public void setIfUploadCapitalFlow(String ifUploadCapitalFlow) {
		this.ifUploadCapitalFlow = ifUploadCapitalFlow;
	}

	@Basic
	@Column(name = "if_special_case")
	public String getIfSpecialCase() {
		return ifSpecialCase;
	}

	public void setIfSpecialCase(String ifSpecialCase) {
		this.ifSpecialCase = ifSpecialCase;
	}

	@Basic
	@Column(name = "special_broker_id")
	public Integer getSpecialBrokerId() {
		return specialBrokerId;
	}

	public void setSpecialBrokerId(Integer specialBrokerId) {
		this.specialBrokerId = specialBrokerId;
	}

	@Basic
	@Column(name = "special_broker_name")
	public String getSpecialBrokerName() {
		return specialBrokerName;
	}

	public void setSpecialBrokerName(String specialBrokerName) {
		this.specialBrokerName = specialBrokerName;
	}

	@Basic
	@Column(name = "special_remark")
	public String getSpecialRemark() {
		return specialRemark;
	}

	public void setSpecialRemark(String specialRemark) {
		this.specialRemark = specialRemark;
	}

	@Basic
	@Column(name = "special_attachment")
	public String getSpecialAttachment() {
		return specialAttachment;
	}

	public void setSpecialAttachment(String specialAttachment) {
		this.specialAttachment = specialAttachment;
	}

	@Basic
	@Column(name = "broker_profit_config_status")
	public String getBrokerProfitConfigStatus() {
		return brokerProfitConfigStatus;
	}

	public void setBrokerProfitConfigStatus(String brokerProfitConfigStatus) {
		this.brokerProfitConfigStatus = brokerProfitConfigStatus;
	}

	@Basic
	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Basic
	@Column(name = "create_person_id")
	public Integer getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(Integer createPersonId) {
		this.createPersonId = createPersonId;
	}

	@Basic
	@Column(name = "create_person_name")
	public String getCreatePersonName() {
		return createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	@Basic
	@Column(name = "audit_date")
	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	@Basic
	@Column(name = "audit_person_id")
	public Integer getAuditPersonId() {
		return auditPersonId;
	}

	public void setAuditPersonId(Integer auditPersonId) {
		this.auditPersonId = auditPersonId;
	}

	@Basic
	@Column(name = "audit_person_name")
	public String getAuditPersonName() {
		return auditPersonName;
	}

	public void setAuditPersonName(String auditPersonName) {
		this.auditPersonName = auditPersonName;
	}

	@Basic
	@Column(name = "cancel_date")
	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	@Basic
	@Column(name = "cancel_person_id")
	public Integer getCancelPersonId() {
		return cancelPersonId;
	}

	public void setCancelPersonId(Integer cancelPersonId) {
		this.cancelPersonId = cancelPersonId;
	}

	@Basic
	@Column(name = "cancel_person_name")
	public String getCancelPersonName() {
		return cancelPersonName;
	}

	public void setCancelPersonName(String cancelPersonName) {
		this.cancelPersonName = cancelPersonName;
	}

	@Basic
	@Column(name = "modify_date")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Basic
	@Column(name = "modify_person_id")
	public Integer getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Integer modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	@Basic
	@Column(name = "modify_person_name")
	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	@Basic
	@Column(name = "system_timestamp")
	public Date getSystemTimestamp() {
		return systemTimestamp;
	}

	public void setSystemTimestamp(Date systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	@Override
	public String toString() {
		return "BrokerProfitConfigVo [brokerProfitConfigId=" + brokerProfitConfigId + ", brokerProfitConfigName="
				+ brokerProfitConfigName + ", platformId=" + platformId + ", brokerProfitRate=" + brokerProfitRate
				+ ", ifUploadCapitalFlow=" + ifUploadCapitalFlow + ", ifSpecialCase=" + ifSpecialCase
				+ ", specialBrokerId=" + specialBrokerId + ", specialBrokerName=" + specialBrokerName
				+ ", specialRemark=" + specialRemark + ", specialAttachment=" + specialAttachment
				+ ", brokerProfitConfigStatus=" + brokerProfitConfigStatus + ", createDate=" + createDate
				+ ", createPersonId=" + createPersonId + ", createPersonName=" + createPersonName + ", auditDate="
				+ auditDate + ", auditPersonId=" + auditPersonId + ", auditPersonName=" + auditPersonName
				+ ", cancelDate=" + cancelDate + ", cancelPersonId=" + cancelPersonId + ", cancelPersonName="
				+ cancelPersonName + ", modifyDate=" + modifyDate + ", modifyPersonId=" + modifyPersonId
				+ ", modifyPersonName=" + modifyPersonName + ", systemTimestamp=" + systemTimestamp + "]";
	}

}