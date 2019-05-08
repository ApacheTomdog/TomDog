package com.brcc.business.basedata.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Desc: 省市区（县）信息查询类
 * @author: TangYong
 * @Date: 2018-11-18
 */
public class BaseDataQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	/**地区key*/
	private String keyValue;
	/**父类地区key*/
	private String fatherKeyValue;
	
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getFatherKeyValue() {
		return fatherKeyValue;
	}
	public void setFatherKeyValue(String fatherKeyValue) {
		this.fatherKeyValue = fatherKeyValue;
	}

	
}
