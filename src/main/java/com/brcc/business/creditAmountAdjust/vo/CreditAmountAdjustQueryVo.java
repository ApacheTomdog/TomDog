/**
 * 
 */
package com.brcc.business.creditAmountAdjust.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月3日
 * 
 */
public class CreditAmountAdjustQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;

	private String platformId;
	
	private String clientName;
	
	private String creditStatus;

	private Long companyId;
	
	private Long credAmtAdjId;
	
	private String[] creditStatusRange;
	
	public String[] getCreditStatusRange() {
		return creditStatusRange;
	}

	public void setCreditStatusRange(String[] creditStatusRange) {
		this.creditStatusRange = creditStatusRange;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getCredAmtAdjId() {
		return credAmtAdjId;
	}

	public void setCredAmtAdjId(Long credAmtAdjId) {
		this.credAmtAdjId = credAmtAdjId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	
	
}
