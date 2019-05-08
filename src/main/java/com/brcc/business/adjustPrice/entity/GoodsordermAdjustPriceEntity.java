package com.brcc.business.adjustPrice.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goodsordermadjustprice")
public class GoodsordermAdjustPriceEntity {
	
	private Long adjustPriceId;
	private Long publishId;
	private String publishNum;
	private BigDecimal originalPrice;
	private BigDecimal currentPrice;
	private BigDecimal priceDif;
	private Date adjustPriceDate;
	private Long adjustPersonId;
	private String adjustPersonName;
	
	@Id
	@Column(name = "adjust_price_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getAdjustPriceId() {
		return adjustPriceId;
	}
	public void setAdjustPriceId(Long adjustPriceId) {
		this.adjustPriceId = adjustPriceId;
	}
	
	@Basic
	@Column(name = "publish_id")
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	
	@Basic
	@Column(name = "publish_num")
	public String getPublishNum() {
		return publishNum;
	}
	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}
	
	@Basic
	@Column(name = "original_price")
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	@Basic
	@Column(name = "current_price")
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	@Basic
	@Column(name = "price_dif")
	public BigDecimal getPriceDif() {
		return priceDif;
	}
	public void setPriceDif(BigDecimal priceDif) {
		this.priceDif = priceDif;
	}
	
	@Basic
	@Column(name = "adjust_price_date")
	public Date getAdjustPriceDate() {
		return adjustPriceDate;
	}
	public void setAdjustPriceDate(Date adjustPriceDate) {
		this.adjustPriceDate = adjustPriceDate;
	}
	
	@Basic
	@Column(name = "adjust_person_id")
	public Long getAdjustPersonId() {
		return adjustPersonId;
	}
	public void setAdjustPersonId(Long adjustPersonId) {
		this.adjustPersonId = adjustPersonId;
	}
	
	@Basic
	@Column(name = "adjust_person_name")
	public String getAdjustPersonName() {
		return adjustPersonName;
	}
	public void setAdjustPersonName(String adjustPersonName) {
		this.adjustPersonName = adjustPersonName;
	} 
	
	

}
