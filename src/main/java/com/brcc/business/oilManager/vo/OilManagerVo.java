package com.brcc.business.oilManager.vo;
import java.util.Date;

/**
 * @Description
 * @Author pjy
 **/
public class OilManagerVo {
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getSeqId() {
		return seqId;
	}
	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getIfVirtualCompany() {
		return ifVirtualCompany;
	}
	public void setIfVirtualCompany(String ifVirtualCompany) {
		this.ifVirtualCompany = ifVirtualCompany;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private String companyName;
	private Long seqId;
	private String contactName;
	private String contactMobile;
	private String platformId;
	private String ifVirtualCompany;
	private Date createDate;
}
