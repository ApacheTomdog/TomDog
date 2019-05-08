package com.brcc.business.home.vo;

import java.math.BigDecimal;

public class HomeVo {

	private Long yesterdayDealVehicleNum;
	
	private Long totalDealVehicleNum;
	
	private Long totalRegisterNum;
	
	private BigDecimal totalDealTon;
	
	private Long onlineDriverNum;

	private Long count;//今日注册总数
	private Long count1;//未审核的注册数
	private Long count2;//已审核的注册数
	private Long count3;//今日抢单总数
	private BigDecimal weightsum;//今日被抢单总重量
	private Long count4;//今日发单总数
	private BigDecimal weightsum1;//今日发单总重量
	private Long menuId;
	
	private Long vehicle;//地图分布车辆数
	
	private Long driver;//地图分布司机数
	
	private String text;//省份名称
	
	private String name;//省份简称
	
	
	public Long getVehicle() {
		return vehicle;
	}

	public void setVehicle(Long vehicle) {
		this.vehicle = vehicle;
	}

	public Long getDriver() {
		return driver;
	}

	public void setDriver(Long driver) {
		this.driver = driver;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getCount4() {
		return count4;
	}

	public void setCount4(Long count4) {
		this.count4 = count4;
	}

	public BigDecimal getWeightsum1() {
		return weightsum1;
	}

	public void setWeightsum1(BigDecimal weightsum1) {
		this.weightsum1 = weightsum1;
	}

	public Long getCount3() {
		return count3;
	}

	public void setCount3(Long count3) {
		this.count3 = count3;
	}

	public BigDecimal getWeightsum() {
		return weightsum;
	}

	public void setWeightsum(BigDecimal weightsum) {
		this.weightsum = weightsum;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getCount1() {
		return count1;
	}

	public void setCount1(Long count1) {
		this.count1 = count1;
	}

	public Long getCount2() {
		return count2;
	}

	public void setCount2(Long count2) {
		this.count2 = count2;
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

	public Long getOnlineDriverNum() {
		return onlineDriverNum;
	}

	public void setOnlineDriverNum(Long onlineDriverNum) {
		this.onlineDriverNum = onlineDriverNum;
	}
	
	
}
