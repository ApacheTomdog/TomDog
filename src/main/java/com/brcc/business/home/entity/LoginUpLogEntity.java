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
@Table(name="loginuplog")
@DynamicInsert
@NamedQuery(name="LoginUpLogEntity.findAll", query="SELECT g FROM LoginUpLogEntity g")
public class LoginUpLogEntity {
	
	@Column(name="login_name")
	private String loginName;
	
	@Column(name="user_passwd")
	private String userPasswd;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="platform_id")
	private String platformId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="upTime")
	private Date up_time;



	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
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

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUp_time() {
		return up_time;
	}

	public void setUp_time(Date up_time) {
		this.up_time = up_time;
	}
	
	
}
