package com.brcc.business.creditBill.vo;

import java.io.Serializable;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class CreditBillQueryVo extends BaseQueryVo {
	
	private static final long serialVersionUID = 1L;

	private Long creditBillId;

	private Date createDateStart;

	private Date createDateEnd;
	
	private String platformId;
	
	private Long creditCompanyId;
	
	private Long investCompanyId;
	
	private String creditBillDiesFlag;
	
	private String creditBillStatus;

	public Long getCreditBillId() {
		return creditBillId;
	}

	public void setCreditBillId(Long creditBillId) {
		this.creditBillId = creditBillId;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getCreditCompanyId() {
		return creditCompanyId;
	}

	public void setCreditCompanyId(Long creditCompanyId) {
		this.creditCompanyId = creditCompanyId;
	}

	public Long getInvestCompanyId() {
		return investCompanyId;
	}

	public void setInvestCompanyId(Long investCompanyId) {
		this.investCompanyId = investCompanyId;
	}

	public String getCreditBillDiesFlag() {
		return creditBillDiesFlag;
	}

	public void setCreditBillDiesFlag(String creditBillDiesFlag) {
		this.creditBillDiesFlag = creditBillDiesFlag;
	}

	public String getCreditBillStatus() {
		return creditBillStatus;
	}

	public void setCreditBillStatus(String creditBillStatus) {
		this.creditBillStatus = creditBillStatus;
	}
	
	
}