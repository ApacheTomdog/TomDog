package com.brcc.business.adjustPrice.vo;

import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class GoodsordermAdjustPriceQueryVo extends BaseQueryVo{

	private static final long serialVersionUID = 1L;
	
	private Long publishId;
	//开始时间
	private Date rqStart;
	//结束时间
	private Date rqEnd;
	//是否是管理员
	private String ifAdmin;
	//公司id
	private Long companyId;

	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public Date getRqStart() {
		return rqStart;
	}
	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}
	public Date getRqEnd() {
		return rqEnd;
	}
	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}
	public String getIfAdmin() {return ifAdmin;}
	public void setIfAdmin(String ifAdmin) {this.ifAdmin = ifAdmin;}
	public Long getCompanyId() {return companyId;}
	public void setCompanyId(Long companyId) {this.companyId = companyId;}
	

}
