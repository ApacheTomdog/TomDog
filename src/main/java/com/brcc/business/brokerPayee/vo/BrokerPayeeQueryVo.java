package com.brcc.business.brokerPayee.vo;

import java.util.Date;
import com.esteel.common.vo.BaseQueryVo;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
public class BrokerPayeeQueryVo extends BaseQueryVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String companyPayeeStatus;
	private Date rqStart;
	private Date rqEnd;
	private String companyPayeeName;
	private Long companyPayeeId;
	private Long modifyPersonId;
	private Long createPersonId;
	private String createPersonName;
	private String modifyPersonName;
	private String companyPayeeNum;
	private Long companyId;
	private String companyName;
	private String companyPayeeCardNum;
	
	

	public String getCompanyPayeeCardNum() {
		return companyPayeeCardNum;
	}
	
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}
	public String getCreatePersonName() {
		return createPersonName;
	}
	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}
	public String getCompanyPayeeNum() {
		return companyPayeeNum;
	}
	public void setCompanyPayeeNum(String companyPayeeNum) {
		this.companyPayeeNum = companyPayeeNum;
	}
	public Long getModifyPersonId() {
		return modifyPersonId;
	}
	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}
	public String getModifyPersonName() {
		return modifyPersonName;
	}
	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}
	public Long getCompanyPayeeId() {
		return companyPayeeId;
	}
	public void setCompanyPayeeId(Long companyPayeeId) {
		this.companyPayeeId = companyPayeeId;
	}
	public String getCompanyPayeeStatus() {
		return companyPayeeStatus;
	}
	public void setCompanyPayeeStatus(String companyPayeeStatus) {
		this.companyPayeeStatus = companyPayeeStatus;
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
	public String getCompanyPayeeName() {
		return companyPayeeName;
	}
	public void setCompanyPayeeName(String companyPayeeName) {
		this.companyPayeeName = companyPayeeName;
	}

}
