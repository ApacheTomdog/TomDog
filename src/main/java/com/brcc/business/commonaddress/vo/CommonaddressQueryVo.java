package com.brcc.business.commonaddress.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Desc: 常用路线查询类
 * 
 */

public class CommonaddressQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	// 省名
	private String provinceName;
	// 地址类型(例如:30为目的地)
	private String addressType;
	// 平台
	private String platformId;
	// 公司Id
	private Long companyId;
	// 地址Id
	private Long addressId;
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	
}
