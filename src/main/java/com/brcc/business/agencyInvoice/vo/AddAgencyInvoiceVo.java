package com.brcc.business.agencyInvoice.vo;

import java.io.Serializable;

/**
 *	 新增代开票
 * 
 * @author hui.liu
 * @date 2018年12月17日
 */
public class AddAgencyInvoiceVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String platformId;
	private Long companyId;
	private Long userId;
	private String userName;
	private String rqStartDlg;
	private Long minAmount;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRqStartDlg() {
		return rqStartDlg;
	}

	public void setRqStartDlg(String rqStartDlg) {
		this.rqStartDlg = rqStartDlg;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	@Override
	public String toString() {
		return "AddAgencyInvoiceVo [platformId=" + platformId + ", companyId=" + companyId + ", userId=" + userId
				+ ", userName=" + userName + ", rqStartDlg=" + rqStartDlg + ", minAmount=" + minAmount + "]";
	}

}
