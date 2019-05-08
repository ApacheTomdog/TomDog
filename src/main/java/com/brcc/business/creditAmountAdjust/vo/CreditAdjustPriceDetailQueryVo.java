/**
 * 
 */
package com.brcc.business.creditAmountAdjust.vo;

import java.math.BigDecimal;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description: 授信调价明细查询类
 * @author:      TangYong
 * @Date:        2018-11-19
 * 
 */
public class CreditAdjustPriceDetailQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	// 平台
	private String platformId;
	// 发货公司
	private Long companyId;
	// 授信状态
	private String creditStatus;
	// 调价状态
	private String adjPriceStatus;
	// 调整价格
	private BigDecimal curPrice;
	
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getAdjPriceStatus() {
		return adjPriceStatus;
	}
	public void setAdjPriceStatus(String adjPriceStatus) {
		this.adjPriceStatus = adjPriceStatus;
	}
	public BigDecimal getCurPrice() {
		return curPrice;
	}
	public void setCurPrice(BigDecimal curPrice) {
		this.curPrice = curPrice;
	}
	
}
