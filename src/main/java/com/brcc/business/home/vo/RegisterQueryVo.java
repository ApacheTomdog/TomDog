package com.brcc.business.home.vo;

public class RegisterQueryVo {

	private String loginName;
	
	private String platformFlag;

	private String companyName;
	
	private String localPath1;
	private String localPath2;
	private String localPath3;
	private String password;
	private String companyPerson; //联系人
	private String companyMobile;// 联系电话
	private String taxNum;//身份证代码
	private String brokerPeopleFlag;
	private String platformId;
	private String remark;
	private String verifCode;//短信验证码
	private String newPassword;
	
 	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVerifCode() {
		return verifCode;
	}

	public void setVerifCode(String verifCode) {
		this.verifCode = verifCode;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyPerson() {
		return companyPerson;
	}

	public void setCompanyPerson(String companyPerson) {
		this.companyPerson = companyPerson;
	}

	public String getCompanyMobile() {
		return companyMobile;
	}

	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}

	public String getTaxNum() {
		return taxNum;
	}

	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	public String getBrokerPeopleFlag() {
		return brokerPeopleFlag;
	}

	public void setBrokerPeopleFlag(String brokerPeopleFlag) {
		this.brokerPeopleFlag = brokerPeopleFlag;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPlatformFlag() {
		return platformFlag;
	}

	public void setPlatformFlag(String platformFlag) {
		this.platformFlag = platformFlag;
	}
	
	
}
