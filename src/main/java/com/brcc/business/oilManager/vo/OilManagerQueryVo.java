package com.brcc.business.oilManager.vo;
/**
* @author PanJianYang
* @version 创建时间：2018年12月21日 上午11:25:52
*/

import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class OilManagerQueryVo extends BaseQueryVo{
	private Date rqStart;
	private Date rqEnd;
	private String platformId;
	private String companyName;
	private String ifVirtualCompany;
	private Long seqId;
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
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIfVirtualCompany() {
		return ifVirtualCompany;
	}
	public void setIfVirtualCompany(String ifVirtualCompany) {
		this.ifVirtualCompany = ifVirtualCompany;
	}
	public Long getSeqId() {
		return seqId;
	}
	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}
}
