package com.brcc.business.basedata.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Desc: 省市区（县）查询类
 * @author: mawanting
 * Date: 2019-01-10
 */
public class BaseDataForeignQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	
	/**自治区省和直辖市*/
	private String dataName;
	
	/**自治区省和直辖市代码*/
	private String provinceCode;
	
	/**自治区省和直辖市名称*/
	private String provinceName;
	
	/**市代码*/
	private String cityCode;
	
	/**市名称*/
	private String cityName;
	
	/**区县名称*/
	private String countryName;
	
	/**当前页数*/
	private Integer pageNum;
	
	/**当前条数*/
	private Integer pageSize;

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
