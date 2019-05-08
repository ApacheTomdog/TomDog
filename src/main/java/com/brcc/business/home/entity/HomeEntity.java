package com.brcc.business.home.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="firstpagedisplay")
@DynamicInsert
@NamedQuery(name="HomeEntity.findAll", query="SELECT g FROM HomeEntity g")
public class HomeEntity implements Serializable {

	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="key_id")
	private Long keyId;
	
	@Column(name="first_page_date")
	private String firstPageDate;
	
	@Column(name="platform_id")
	private String platformId;
	
	@Column(name="yesterday_deal_vehicle_num")
	private Long yesterdayDealVehicleNum;
	
	@Column(name="total_deal_vehicle_num")
	private Long totalDealVehicleNum;
	
	@Column(name="total_register_num")
	private Long totalRegisterNum;
	
	@Column(name="total_deal_ton")
	private BigDecimal totalDealTon;

	public Long getKeyId() {
		return keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public String getFirstPageDate() {
		return firstPageDate;
	}

	public void setFirstPageDate(String firstPageDate) {
		this.firstPageDate = firstPageDate;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getYesterdayDealVehicleNum() {
		return yesterdayDealVehicleNum;
	}

	public void setYesterdayDealVehicleNum(Long yesterdayDealVehicleNum) {
		this.yesterdayDealVehicleNum = yesterdayDealVehicleNum;
	}

	public Long getTotalDealVehicleNum() {
		return totalDealVehicleNum;
	}

	public void setTotalDealVehicleNum(Long totalDealVehicleNum) {
		this.totalDealVehicleNum = totalDealVehicleNum;
	}

	public Long getTotalRegisterNum() {
		return totalRegisterNum;
	}

	public void setTotalRegisterNum(Long totalRegisterNum) {
		this.totalRegisterNum = totalRegisterNum;
	}

	public BigDecimal getTotalDealTon() {
		return totalDealTon;
	}

	public void setTotalDealTon(BigDecimal totalDealTon) {
		this.totalDealTon = totalDealTon;
	}
	
	
}
