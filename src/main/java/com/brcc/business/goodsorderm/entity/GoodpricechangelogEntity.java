package com.brcc.business.goodsorderm.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goodpricechangelog database table.
 * 货源货物调价实体类
 */
@Entity
@DynamicInsert
@Table(name="goodpricechangelog")
@NamedQuery(name="GoodpricechangelogEntity.findAll", query="SELECT g FROM GoodpricechangelogEntity g")
public class GoodpricechangelogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="good_price_id")
	private Long goodPriceId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="loss_ratio")
	private BigDecimal lossRatio;

	@Column(name="loss_ratio_old")
	private BigDecimal lossRatioOld;

	@Column(name="loss_type")
	private String lossType;

	@Column(name="loss_type_old")
	private String lossTypeOld;

	@Column(name="loss_weight")
	private BigDecimal lossWeight;

	@Column(name="loss_weight_old")
	private BigDecimal lossWeightOld;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="modify_status")
	private String modifyStatus;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_company_name")
	private String publishCompanyName;

	@Column(name="publish_good_price_new")
	private BigDecimal publishGoodPriceNew;

	@Column(name="publish_good_price_old")
	private BigDecimal publishGoodPriceOld;

	@Column(name="publish_id")
	private Long publishId;

	public GoodpricechangelogEntity() {
	}

	public Long getGoodPriceId() {
		return this.goodPriceId;
	}

	public void setGoodPriceId(Long goodPriceId) {
		this.goodPriceId = goodPriceId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public BigDecimal getLossRatio() {
		return this.lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public BigDecimal getLossRatioOld() {
		return this.lossRatioOld;
	}

	public void setLossRatioOld(BigDecimal lossRatioOld) {
		this.lossRatioOld = lossRatioOld;
	}

	public String getLossType() {
		return this.lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getLossTypeOld() {
		return this.lossTypeOld;
	}

	public void setLossTypeOld(String lossTypeOld) {
		this.lossTypeOld = lossTypeOld;
	}

	public BigDecimal getLossWeight() {
		return this.lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public BigDecimal getLossWeightOld() {
		return this.lossWeightOld;
	}

	public void setLossWeightOld(BigDecimal lossWeightOld) {
		this.lossWeightOld = lossWeightOld;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getModifyStatus() {
		return this.modifyStatus;
	}

	public void setModifyStatus(String modifyStatus) {
		this.modifyStatus = modifyStatus;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getPublishCompanyId() {
		return this.publishCompanyId;
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

	public BigDecimal getPublishGoodPriceNew() {
		return this.publishGoodPriceNew;
	}

	public void setPublishGoodPriceNew(BigDecimal publishGoodPriceNew) {
		this.publishGoodPriceNew = publishGoodPriceNew;
	}

	public BigDecimal getPublishGoodPriceOld() {
		return this.publishGoodPriceOld;
	}

	public void setPublishGoodPriceOld(BigDecimal publishGoodPriceOld) {
		this.publishGoodPriceOld = publishGoodPriceOld;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}