package com.brcc.business.agencyInvoice.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 代开票管理查询条件
 * 
 * @author hui.liu
 * @date 2018年12月13日
 */
public class AgencyInvoiceQueryVo extends BaseQueryVo {
	private static final long serialVersionUID = 1L;

	private String platformId;
	private Long companyId;
	private String reinvoiceMasterNum;
	private String reinvoiceStatus;
	private Integer ifPrint;
	private Integer ifFkPrint;
	private Integer taxRegistrationFlag;
	private Integer withholdProtocolFlag;
	private String reinvoiceNo;
	private String rqStart;
	private String rqEnd;
	private String reinvoiceTimeStart;
	private String reinvoiceTimeEnd;
	private String ifTaxNum;

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

	public String getReinvoiceMasterNum() {
		return reinvoiceMasterNum;
	}

	public void setReinvoiceMasterNum(String reinvoiceMasterNum) {
		this.reinvoiceMasterNum = reinvoiceMasterNum;
	}

	public String getReinvoiceStatus() {
		return reinvoiceStatus;
	}

	public void setReinvoiceStatus(String reinvoiceStatus) {
		this.reinvoiceStatus = reinvoiceStatus;
	}

	public Integer getIfPrint() {
		return ifPrint;
	}

	public void setIfPrint(Integer ifPrint) {
		this.ifPrint = ifPrint;
	}

	public Integer getIfFkPrint() {
		return ifFkPrint;
	}

	public void setIfFkPrint(Integer ifFkPrint) {
		this.ifFkPrint = ifFkPrint;
	}

	public Integer getTaxRegistrationFlag() {
		return taxRegistrationFlag;
	}

	public void setTaxRegistrationFlag(Integer taxRegistrationFlag) {
		this.taxRegistrationFlag = taxRegistrationFlag;
	}

	public Integer getWithholdProtocolFlag() {
		return withholdProtocolFlag;
	}

	public void setWithholdProtocolFlag(Integer withholdProtocolFlag) {
		this.withholdProtocolFlag = withholdProtocolFlag;
	}

	public String getReinvoiceNo() {
		return reinvoiceNo;
	}

	public void setReinvoiceNo(String reinvoiceNo) {
		this.reinvoiceNo = reinvoiceNo;
	}

	public String getRqStart() {
		return rqStart;
	}

	public void setRqStart(String rqStart) {
		this.rqStart = rqStart;
	}

	public String getRqEnd() {
		return rqEnd;
	}

	public void setRqEnd(String rqEnd) {
		this.rqEnd = rqEnd;
	}

	public String getReinvoiceTimeStart() {
		return reinvoiceTimeStart;
	}

	public void setReinvoiceTimeStart(String reinvoiceTimeStart) {
		this.reinvoiceTimeStart = reinvoiceTimeStart;
	}

	public String getReinvoiceTimeEnd() {
		return reinvoiceTimeEnd;
	}

	public void setReinvoiceTimeEnd(String reinvoiceTimeEnd) {
		this.reinvoiceTimeEnd = reinvoiceTimeEnd;
	}

	public String getIfTaxNum() {
		return ifTaxNum;
	}

	public void setIfTaxNum(String ifTaxNum) {
		this.ifTaxNum = ifTaxNum;
	}

	@Override
	public String toString() {
		return "AgencyInvoiceQueryVo [platformId=" + platformId + ", companyId=" + companyId + ", reinvoiceMasterNum="
				+ reinvoiceMasterNum + ", reinvoiceStatus=" + reinvoiceStatus + ", ifPrint=" + ifPrint + ", ifFkPrint="
				+ ifFkPrint + ", taxRegistrationFlag=" + taxRegistrationFlag + ", withholdProtocolFlag="
				+ withholdProtocolFlag + ", reinvoiceNo=" + reinvoiceNo + ", rqStart=" + rqStart + ", rqEnd=" + rqEnd
				+ ", reinvoiceTimeStart=" + reinvoiceTimeStart + ", reinvoiceTimeEnd=" + reinvoiceTimeEnd
				+ ", ifTaxNum=" + ifTaxNum + "]";
	}

}
