package com.brcc.business.basedata.vo;

import com.brcc.business.basedata.entity.BasedataEntity;

/**
 * @Desc: 省市区数据
 * @author: mawanting
 * @Date: 2019-01-10
 */
public class BaseDataForeignVo extends BasedataEntity {

	private static final long serialVersionUID = 1L;
	
	/**自治区省和直辖市代码*/
	private String provinceCode;
	
	/**自治区省和直辖市名称*/
	private String provinceName;
	
	/**省所在人民政府经度*/
	private Double provinceLng;
	
	/**省所在人民政府纬度*/
	private Double provinceLat;
	
	/**市代码*/
	private String cityCode;
	
	/**市名称*/
	private String cityName;
	
	/**市所在人民政府经度*/
	private Double cityLng;
	
	/**市所在人民政府纬度*/
	private Double cityLat;
	
	/**区县代码*/
	private String countryCode;
	
	/**区县名称*/
	private String countryName;

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Double getProvinceLng() {
		return provinceLng;
	}

	public void setProvinceLng(Double provinceLng) {
		this.provinceLng = provinceLng;
	}

	public Double getProvinceLat() {
		return provinceLat;
	}

	public void setProvinceLat(Double provinceLat) {
		this.provinceLat = provinceLat;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getCityLng() {
		return cityLng;
	}

	public void setCityLng(Double cityLng) {
		this.cityLng = cityLng;
	}

	public Double getCityLat() {
		return cityLat;
	}

	public void setCityLat(Double cityLat) {
		this.cityLat = cityLat;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
    
    

}
