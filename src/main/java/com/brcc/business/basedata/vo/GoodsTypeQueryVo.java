package com.brcc.business.basedata.vo;

import com.esteel.common.vo.BaseQueryVo;

public class GoodsTypeQueryVo extends BaseQueryVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String goodsTypeDesc;
	
	private String platformId;

	public String getGoodsTypeDesc() {
		return goodsTypeDesc;
	}

	public void setGoodsTypeDesc(String goodsTypeDesc) {
		this.goodsTypeDesc = goodsTypeDesc;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
}
