package com.brcc.business.agencyInvoice.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 	代开票管理导入发票编号
 * 
 * @author hui.liu
 * @date 2018年12月17日
 */
public class AgencyInvoiceUploadVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String reinvoiceMasterNum;
	
	private String reinvoiceNo;
	
	private String reinvoiceAgreeTimeStr;
	
	private Date reinvoiceAgreeTime;

	public String getReinvoiceMasterNum() {
		return reinvoiceMasterNum;
	}

	public void setReinvoiceMasterNum(String reinvoiceMasterNum) {
		this.reinvoiceMasterNum = reinvoiceMasterNum;
	}

	public String getReinvoiceNo() {
		return reinvoiceNo;
	}

	public void setReinvoiceNo(String reinvoiceNo) {
		this.reinvoiceNo = reinvoiceNo;
	}

	public Date getReinvoiceAgreeTime() {
		return reinvoiceAgreeTime;
	}

	public void setReinvoiceAgreeTime(Date reinvoiceAgreeTime) {
		this.reinvoiceAgreeTime = reinvoiceAgreeTime;
	}

	public String getReinvoiceAgreeTimeStr() {
		return reinvoiceAgreeTimeStr;
	}

	public void setReinvoiceAgreeTimeStr(String reinvoiceAgreeTimeStr) {
		this.reinvoiceAgreeTimeStr = reinvoiceAgreeTimeStr;
	}

	@Override
	public String toString() {
		return "AgencyInvoiceUploadVo [reinvoiceMasterNum=" + reinvoiceMasterNum + ", reinvoiceNo=" + reinvoiceNo
				+ ", reinvoiceAgreeTimeStr=" + reinvoiceAgreeTimeStr + ", reinvoiceAgreeTime=" + reinvoiceAgreeTime
				+ "]";
	}
}
