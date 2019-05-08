package com.brcc.business.goodsorderm.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the goodsownerfdconfig database table.
 * 
 */
@Entity
@DynamicInsert
@Table(name="goodsownerfdconfig")
@NamedQuery(name="GoodsownerfdconfigEntity.findAll", query="SELECT g FROM GoodsownerfdconfigEntity g")
public class GoodsownerfdconfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="config_id")
	private int configId;

	@Column(name="after_days")
	private byte afterDays;

	@Column(name="after_date")
	private String afterDate;

	@Column(name="conf_status")
	private String confStatus;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="if_default_team")
	private String ifDefaultTeam;

	@Column(name="loss_ratio")
	private BigDecimal lossRatio;

	@Column(name="loss_type")
	private String lossType;

	@Column(name="loss_weight")
	private BigDecimal lossWeight;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_company_name")
	private String publishCompanyName;

	@Column(name="if_tax_transport")
	private String ifTaxTransport;

	@Column(name="send_group")
	private String sendGroup;

	@Column(name="good_price")
	private BigDecimal goodPrice;

	@Column(name="if_recommend_car_style")
	private String ifRecommendCarStyle;

	@Column(name="if_max_trans_days")
	private String ifMaxTransDays;


	public GoodsownerfdconfigEntity() {
	}

	public int getConfigId() {
		return this.configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public byte getAfterDays() {
		return this.afterDays;
	}

	public void setAfterDays(byte afterDays) {
		this.afterDays = afterDays;
	}

	public String getConfStatus() {
		return this.confStatus;
	}

	public String getAfterDate() {
		return afterDate;
	}

	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}

	public void setConfStatus(String confStatus) {
		this.confStatus = confStatus;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getIfDefaultTeam() {
		return this.ifDefaultTeam;
	}

	public void setIfDefaultTeam(String ifDefaultTeam) {
		this.ifDefaultTeam = ifDefaultTeam;
	}

	public BigDecimal getLossRatio() {
		return this.lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public String getLossType() {
		return this.lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public BigDecimal getLossWeight() {
		return this.lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	

	public Long getPublishCompanyId() {
		return publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

	public String getPublishCompanyName() {
		return this.publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public String getSendGroup() {
		return sendGroup;
	}

	public void setSendGroup(String sendGroup) {
		this.sendGroup = sendGroup;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getIfRecommendCarStyle() {
		return ifRecommendCarStyle;
	}

	public void setIfRecommendCarStyle(String ifRecommendCarStyle) {
		this.ifRecommendCarStyle = ifRecommendCarStyle;
	}

	public String getIfMaxTransDays() {
		return ifMaxTransDays;
	}

	public void setIfMaxTransDays(String ifMaxTransDays) {
		this.ifMaxTransDays = ifMaxTransDays;
	}
}