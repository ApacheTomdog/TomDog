package com.brcc.business.flow.vo;

import com.brcc.business.flow.entity.VatflowdetailEntity;

/**
 * @Description 流程明细数据接受类
*  @author TangYong
*  @Date 2018-11-14
*/
public class VatflowdetailVo extends VatflowdetailEntity {
	private static final long serialVersionUID = 1L;
	
	private String vatFlowMasterName;

	public String getVatFlowMasterName() {
		return vatFlowMasterName;
	}

	public void setVatFlowMasterName(String vatFlowMasterName) {
		this.vatFlowMasterName = vatFlowMasterName;
	}
	
}
