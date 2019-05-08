package com.brcc.business.priceClientRate.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "price_client_rate")
// @NamedQuery(name="PriceClientRate.findAll", query="SELECT p FROM PriceClientRate p")
public class PriceClientRateEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_client_rate_id")
	private Long priceClientRateId;

	@Column(name = "carry_id")
	private Long carryId;

	@Column(name = "carry_name")
	private String carryName;

	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_rate")
	private BigDecimal clientRate;

	@Column(name = "client_rate_type")
	private String clientRateType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "create_person_id")
	private Long createPersonId;

	@Column(name = "create_person_name")
	private String createPersonName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	@Column(name = "modify_person_id")
	private Long modifyPersonId;

	@Column(name = "modify_person_name")
	private String modifyPersonName;

	@Column(name = "platform_id")
	private String platformId;

	public PriceClientRateEntity() {
		}

	public Long getPriceClientRateId() {
		return this.priceClientRateId;
	}

	public void setPriceClientRateId(Long priceClientRateId) {
		this.priceClientRateId = priceClientRateId;
	}

	public Long getCarryId() {
		return this.carryId;
	}

	public void setCarryId(Long carryId) {
		this.carryId = carryId;
	}

	public String getCarryName() {
		return this.carryName;
	}

	public void setCarryName(String carryName) {
		this.carryName = carryName;
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public BigDecimal getClientRate() {
		return this.clientRate;
	}

	public void setClientRate(BigDecimal clientRate) {
		this.clientRate = clientRate;
	}

	public String getClientRateType() {
		return this.clientRateType;
	}

	public void setClientRateType(String clientRateType) {
		this.clientRateType = clientRateType;
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

}