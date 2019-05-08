package com.brcc.business.basedata.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the push_owner_catalog database table.
 * @Desc 平台大品种智能推送设置表
 */
@Entity
@Table(name="push_owner_catalog")
@NamedQuery(name="PushOwnerCatalogEntity.findAll", query="SELECT p FROM PushOwnerCatalogEntity p")
public class PushOwnerCatalogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="push_owner_catalog_id")
	private Long pushOwnerCatalogId;

	@Column(name="catalog_id")
	private Long catalogId;

	@Column(name="catalog_name")
	private String catalogName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="push_distance")
	private Integer pushDistance;

	@Column(name="push_status")
	private String pushStatus;

	@Column(name="rob_day_cycle")
	private BigDecimal robDayCycle;

	@Column(name="rob_day_time")
	private String robDayTime;

	@Column(name="robbing_second")
	private Integer robbingSecond;

	public PushOwnerCatalogEntity() {
	}

	public Long getPushOwnerCatalogId() {
		return this.pushOwnerCatalogId;
	}

	public void setPushOwnerCatalogId(Long pushOwnerCatalogId) {
		this.pushOwnerCatalogId = pushOwnerCatalogId;
	}

	public Long getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
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

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Integer getPushDistance() {
		return this.pushDistance;
	}

	public void setPushDistance(Integer pushDistance) {
		this.pushDistance = pushDistance;
	}

	public String getPushStatus() {
		return this.pushStatus;
	}

	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}

	public BigDecimal getRobDayCycle() {
		return this.robDayCycle;
	}

	public void setRobDayCycle(BigDecimal robDayCycle) {
		this.robDayCycle = robDayCycle;
	}

	public String getRobDayTime() {
		return this.robDayTime;
	}

	public void setRobDayTime(String robDayTime) {
		this.robDayTime = robDayTime;
	}

	public Integer getRobbingSecond() {
		return this.robbingSecond;
	}

	public void setRobbingSecond(Integer robbingSecond) {
		this.robbingSecond = robbingSecond;
	}

}