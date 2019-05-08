package com.brcc.business.creditAdjustPrice.vo;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;

/**
 * @Desc   授信调价明细扩展类
 * @author TangYong
 * @Date   2018-11-19
 */
public class CreditAdjustPriceDetailVo extends CreditAdjustPriceDetailEntity {

	// 发货公司id
	private String publishCompanyId;
	// 发货公司名称
	private String publishCompanyName;
	// 调价类型
	private String adjPriceStyle;
	// 授信状态
	private String credit_fd_status;
	
	public String getPublishCompanyId() {
		return publishCompanyId;
	}
	public void setPublishCompanyId(String publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}
	public String getPublishCompanyName() {
		return publishCompanyName;
	}
	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}
	public String getAdjPriceStyle() {
		return adjPriceStyle;
	}
	public void setAdjPriceStyle(String adjPriceStyle) {
		this.adjPriceStyle = adjPriceStyle;
	}
	public String getCredit_fd_status() {
		return credit_fd_status;
	}
	public void setCredit_fd_status(String credit_fd_status) {
		this.credit_fd_status = credit_fd_status;
	}

	
}
