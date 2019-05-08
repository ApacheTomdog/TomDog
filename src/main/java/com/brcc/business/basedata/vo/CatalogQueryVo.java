package com.brcc.business.basedata.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Desc货物品种查询类
 * @author: TangYong
 * Date:    2018-11-19
 */
public class CatalogQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	/**大品种id*/
	private Long catalogId;
	/**层级*/
	private String layer; 
	/**货物类型*/
	private Long goodType;
	/**货物类型名称*/
	private String goodTypeDesc;
	
	private String status;
	
	private String name;
	
	private String platformId;
	
    public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	public Long getGoodType() {
		return goodType;
	}
	public void setGoodType(Long goodType) {
		this.goodType = goodType;
	}
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
