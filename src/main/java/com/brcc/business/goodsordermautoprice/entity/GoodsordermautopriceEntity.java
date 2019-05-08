package com.brcc.business.goodsordermautoprice.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goodsordermautoprice database table.
 * 
 */
@Entity
@Table(name="goodsordermautoprice")
@DynamicInsert
@NamedQuery(name="GoodsordermautopriceEntity.findAll", query="SELECT g FROM GoodsordermautopriceEntity g")
public class GoodsordermautopriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="g_a_id")
	private Long gAId;

	@Column(name="auto_price_range")
	private String autoPriceRange;

	@Column(name="auto_price_timing_type")
	private String autoPriceTimingType;

	@Column(name="company_id")
	private Long companyId;

	@Column(name="company_name")
	private String companyName;

	@Column(name="company_status")
	private String companyStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="last_result")
	private String lastResult;

	@Column(name="last_result_reason")
	private String lastResultReason;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_time")
	private Date lastTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="next_type_time")
	private Date nextTypeTime;

	@Column(name="platform_id")
	private String platformId;

	private BigDecimal price;

	@Column(name="price_type")
	private int priceType;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="publish_info")
	private String publishInfo;

	@Column(name="timing_cycle")
	private int timingCycle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timing_type_time")
	private Date timingTypeTime;

	public GoodsordermautopriceEntity() {
	}

	public String getAutoPriceRange() {
		return this.autoPriceRange;
	}

	public void setAutoPriceRange(String autoPriceRange) {
		this.autoPriceRange = autoPriceRange;
	}

	public String getAutoPriceTimingType() {
		return this.autoPriceTimingType;
	}

	public void setAutoPriceTimingType(String autoPriceTimingType) {
		this.autoPriceTimingType = autoPriceTimingType;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyStatus() {
		return this.companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
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

	public String getLastResult() {
		return this.lastResult;
	}

	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
	}

	public String getLastResultReason() {
		return this.lastResultReason;
	}

	public void setLastResultReason(String lastResultReason) {
		this.lastResultReason = lastResultReason;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	
	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public Date getNextTypeTime() {
		return this.nextTypeTime;
	}

	public void setNextTypeTime(Date nextTypeTime) {
		this.nextTypeTime = nextTypeTime;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPriceType() {
		return this.priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	

	public Long getgAId() {
		return gAId;
	}

	public void setgAId(Long gAId) {
		this.gAId = gAId;
	}

	public Long getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public String getPublishInfo() {
		return this.publishInfo;
	}

	public void setPublishInfo(String publishInfo) {
		this.publishInfo = publishInfo;
	}

	public int getTimingCycle() {
		return this.timingCycle;
	}

	public void setTimingCycle(int timingCycle) {
		this.timingCycle = timingCycle;
	}

	public Date getTimingTypeTime() {
		return this.timingTypeTime;
	}

	public void setTimingTypeTime(Date timingTypeTime) {
		this.timingTypeTime = timingTypeTime;
	}

}