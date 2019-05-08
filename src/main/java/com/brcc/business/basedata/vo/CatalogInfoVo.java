package com.brcc.business.basedata.vo;

import com.brcc.business.basedata.entity.CatalogEntity;

/**
 * @Desc  货物品种扩展类
 * @Date: 2018-11-19
 */


public class CatalogInfoVo extends CatalogEntity{

	private static final long serialVersionUID = 1L;
	// 品种Id
    private Long catalogId;
	// 品种名称
	private String catalogName;
	// 货物类型Id
	private Long goodType;
	
	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Long getGoodType() {
		return goodType;
	}

	public void setGoodType(Long goodType) {
		this.goodType = goodType;
	}
	
}
