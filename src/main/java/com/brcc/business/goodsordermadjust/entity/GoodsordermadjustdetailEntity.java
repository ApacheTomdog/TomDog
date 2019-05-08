package com.brcc.business.goodsordermadjust.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goodsordermadjustdetail database table.
 * @Desc 货源单调价记录实体类
 */
@Entity
@DynamicInsert
@Table(name="goodsordermadjustdetail")
@NamedQuery(name="GoodsordermadjustdetailEntity.findAll", query="SELECT g FROM GoodsordermadjustdetailEntity g")
public class GoodsordermadjustdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="good_adj_d_id")
	private Long goodAdjDId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="cred_adj_d_id")
	private Long credAdjDId;

	@Column(name="cred_adj_m_id")
	private Long credAdjMId;

	@Column(name="credit_add_price")
	private BigDecimal creditAddPrice;

	@Column(name="max_price")
	private BigDecimal maxPrice;

	@Column(name="min_price")
	private BigDecimal minPrice;

	@Column(name="publish_id")
	private Long publishId;

	public GoodsordermadjustdetailEntity() {
	}

	public Long getGoodAdjDId() {
		return this.goodAdjDId;
	}

	public void setGoodAdjDId(Long goodAdjDId) {
		this.goodAdjDId = goodAdjDId;
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

	public Long getCredAdjDId() {
		return this.credAdjDId;
	}

	public void setCredAdjDId(Long credAdjDId) {
		this.credAdjDId = credAdjDId;
	}

	public Long getCredAdjMId() {
		return this.credAdjMId;
	}

	public void setCredAdjMId(Long credAdjMId) {
		this.credAdjMId = credAdjMId;
	}

	public BigDecimal getCreditAddPrice() {
		return this.creditAddPrice;
	}

	public void setCreditAddPrice(BigDecimal creditAddPrice) {
		this.creditAddPrice = creditAddPrice;
	}

	public BigDecimal getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

}