package com.brcc.business.creditConfig.vo;

import com.brcc.business.creditConfig.entity.CreditConfigEntity;

/**
 * @Desc:   委托方授信封装数据扩展类
 * @author: TangYong
 * @Date:   2018-11-19
 */
public class CreditConfigVo extends  CreditConfigEntity{

	/**调价方式*/
    private String adjPriceStyle;

	public String getAdjPriceStyle() {
		return adjPriceStyle;
	}

	public void setAdjPriceStyle(String adjPriceStyle) {
		this.adjPriceStyle = adjPriceStyle;
	}

    

   
}
