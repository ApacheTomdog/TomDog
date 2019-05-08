package com.brcc.business.brokerPayee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="broker_payee")
public class BrokerPayeeEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_payee_id")
	private Long companyPayeeId;

	@Column(name="company_id")
	private Long companyId;

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_payee_name")
	private String companyPayeeName;

	@Column(name="company_payee_num")
	private String companyPayeeNum;
	
	@Column(name="company_payee_status")
	private String companyPayeeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;
	
	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;
	
	@Column(name="company_payee_card_num")
	private String companyPayeeCardNum;
	
	

	public String getCompanyPayeeCardNum() {
		return companyPayeeCardNum;
	}

	public void setCompanyPayeeCardNum(String companyPayeeCardNum) {
		this.companyPayeeCardNum = companyPayeeCardNum;
	}

	public Long getCompanyPayeeId() {
		return companyPayeeId;
	}

	public void setCompanyPayeeId(Long companyPayeeId) {
		this.companyPayeeId = companyPayeeId;
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

	public String getCompanyPayeeName() {
		return companyPayeeName;
	}

	public void setCompanyPayeeName(String companyPayeeName) {
		this.companyPayeeName = companyPayeeName;
	}

	public String getCompanyPayeeNum() {
		return companyPayeeNum;
	}

	public void setCompanyPayeeNum(String companyPayeeNum) {
		this.companyPayeeNum = companyPayeeNum;
	}

	public String getCompanyPayeeStatus() {
		return companyPayeeStatus;
	}

	public void setCompanyPayeeStatus(String companyPayeeStatus) {
		this.companyPayeeStatus = companyPayeeStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
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

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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
	
	
	

}
