package com.brcc.business.priceChange.entity;
/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;



/**
 * The persistent class for the price_change database table.
 * 
 */
@Entity
@Table(name="price_change")
@NamedQuery(name="PriceChangeEntity.findAll", query="SELECT p FROM PriceChangeEntity p")
public class PriceChangeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="price_change_id", unique=true, nullable=false)
	private Long priceChangeId;

	@Column(name="carry_id")
	private Long carryId;

	@Column(name="carry_name", length=200)
	private String carryName;

	@Column(name="carry_price", precision=10, scale=2)
	private BigDecimal carryPrice;

	@Column(name="client_id")
	private Long clientId;

	@Column(name="client_name", length=200)
	private String clientName;

	@Column(name="client_price", precision=10, scale=2)
	private BigDecimal clientPrice;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name", length=100)
	private String createPersonName;

	@Column(name="diff_price", precision=10, scale=2)
	private BigDecimal diffPrice;

	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name", length=100)
	private String modifyPersonName;

	@Column(name="platform_id", length=20)
	private String platformId;

	@Column(name="price_change_status", length=2)
	private String priceChangeStatus;

	@Column(name="price_change_type")
	private Integer priceChangeType;

	@Column(name="publish_id")
	private Long publishId;

	public PriceChangeEntity() {
	}

	public Long getPriceChangeId() {
		return this.priceChangeId;
	}

	public void setPriceChangeId(Long priceChangeId) {
		this.priceChangeId = priceChangeId;
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

	public BigDecimal getCarryPrice() {
		return this.carryPrice;
	}

	public void setCarryPrice(BigDecimal carryPrice) {
		this.carryPrice = carryPrice;
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

	public BigDecimal getClientPrice() {
		return this.clientPrice;
	}

	public void setClientPrice(BigDecimal clientPrice) {
		this.clientPrice = clientPrice;
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

	public BigDecimal getDiffPrice() {
		return this.diffPrice;
	}

	public void setDiffPrice(BigDecimal diffPrice) {
		this.diffPrice = diffPrice;
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

	public String getPriceChangeStatus() {
		return this.priceChangeStatus;
	}

	public void setPriceChangeStatus(String priceChangeStatus) {
		this.priceChangeStatus = priceChangeStatus;
	}

	public Integer getPriceChangeType() {
		return this.priceChangeType;
	}

	public void setPriceChangeType(Integer priceChangeType) {
		this.priceChangeType = priceChangeType;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}