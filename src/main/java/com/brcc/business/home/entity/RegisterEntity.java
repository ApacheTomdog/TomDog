package com.brcc.business.home.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="register")
@DynamicInsert
@NamedQuery(name="RegisterEntity.findAll", query="SELECT g FROM RegisterEntity g")
public class RegisterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seq_id")
	private Long seqId;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_mobile")
	private String contactMobile;
	
	@Column(name="contact_type")
	private String contactCype;
	
	@Column(name="from_plat_id")
	private String fromPlatId;
	
	@Column(name="from_type")
	private String fromType;
	
	@Column(name="tax_num")
	private String taxNum;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_part")
	private String userPart;
	
	@Column(name="bat_id")
	private Long batId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="login_name")
	private String loginName;
	
	@Column(name="company")
	private String company;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="car_num")
	private String carN_num;
	
	@Column(name="verify_code")
	private String verifyCode;
	
	@Column(name="local_path1")
	private String localPath1;
	
	@Column(name="local_path2")
	private String localPath2;
	
	@Column(name="local_path3")
	private String localPath3;
	
	@Column(name="remote_path1")
	private String remotePath1;
	
	@Column(name="remote_path2")
	private String remotePath2;
	
	@Column(name="remote_path3")
	private String remotePath3;
	
	@Column(name="id_card")
	private String idCard;
	
	@Column(name="status")
	private String status;
	
	@Column(name="approve")
	private Date approve;
	
	@Column(name="car_type")
	private String carType;
	
	@Column(name="catalog_id")
	private String catalogId;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="expend_department")
	private String expendDepartment;

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

	public String getContactCype() {
		return contactCype;
	}

	public void setContactCype(String contactCype) {
		this.contactCype = contactCype;
	}

	public String getFromPlatId() {
		return fromPlatId;
	}

	public void setFromPlatId(String fromPlatId) {
		this.fromPlatId = fromPlatId;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getTaxNum() {
		return taxNum;
	}

	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPart() {
		return userPart;
	}

	public void setUserPart(String userPart) {
		this.userPart = userPart;
	}

	public Long getBatId() {
		return batId;
	}

	public void setBatId(Long batId) {
		this.batId = batId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCarN_num() {
		return carN_num;
	}

	public void setCarN_num(String carN_num) {
		this.carN_num = carN_num;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getLocalPath1() {
		return localPath1;
	}

	public void setLocalPath1(String localPath1) {
		this.localPath1 = localPath1;
	}

	public String getLocalPath2() {
		return localPath2;
	}

	public void setLocalPath2(String localPath2) {
		this.localPath2 = localPath2;
	}

	public String getLocalPath3() {
		return localPath3;
	}

	public void setLocalPath3(String localPath3) {
		this.localPath3 = localPath3;
	}

	public String getRemotePath1() {
		return remotePath1;
	}

	public void setRemotePath1(String remotePath1) {
		this.remotePath1 = remotePath1;
	}

	public String getRemotePath2() {
		return remotePath2;
	}

	public void setRemotePath2(String remotePath2) {
		this.remotePath2 = remotePath2;
	}

	public String getRemotePath3() {
		return remotePath3;
	}

	public void setRemotePath3(String remotePath3) {
		this.remotePath3 = remotePath3;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApprove() {
		return approve;
	}

	public void setApprove(Date approve) {
		this.approve = approve;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getExpendDepartment() {
		return expendDepartment;
	}

	public void setExpendDepartment(String expendDepartment) {
		this.expendDepartment = expendDepartment;
	}
	
	 
	
	
	
	
	
	
	
	
	
	
}
