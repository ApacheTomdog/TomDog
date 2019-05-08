package com.brcc.business.goodsorderm.vo;

import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;

/**
* @Desc   授信价格明细封装类
* @author TangYong
* @Date   2019-01-19
*/
public class GoodsordermadjustdetailVo extends GoodsordermadjustdetailEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String adjPriceStyle;

	public String getAdjPriceStyle() {
		return adjPriceStyle;
	}

	public void setAdjPriceStyle(String adjPriceStyle) {
		this.adjPriceStyle = adjPriceStyle;
	}
	
}
