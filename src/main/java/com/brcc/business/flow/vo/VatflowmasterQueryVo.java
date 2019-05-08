package com.brcc.business.flow.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
* @author PanJianYang
* @version 创建时间：2018年12月7日 上午10:43:37
* @ClassName 类名称
* @Description 类描述
*/
public class VatflowmasterQueryVo extends BaseQueryVo{
	
	private static final long serialVersionUID = 1L;
	
	private Long vatCompanyId;
	
	private String platformId;
	
	private Long vatFlowMasterId;
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getVatCompanyId() {
		return vatCompanyId;
	}
	public void setVatCompanyId(Long vatCompanyId) {
		this.vatCompanyId = vatCompanyId;
	}
	public Long getVatFlowMasterId() {
		return vatFlowMasterId;
	}
	public void setVatFlowMasterId(Long vatFlowMasterId) {
		this.vatFlowMasterId = vatFlowMasterId;
	}
	
}
