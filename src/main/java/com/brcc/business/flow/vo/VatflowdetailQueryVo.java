package com.brcc.business.flow.vo;

import com.esteel.common.vo.BaseQueryVo;


/**
 * @Description 流程明细数据查询类
*  @author TangYong
*  @Date 2018-11-14
*/
public class VatflowdetailQueryVo extends BaseQueryVo {
	private static final long serialVersionUID = 1L;
	
	// 发货公司id
	private Long publishCompanyId;
	
	public Long getPublishCompanyId() {
		return publishCompanyId;
	}
	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

}
