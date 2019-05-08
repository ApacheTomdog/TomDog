package com.brcc.business.basedata.vo;

import com.esteel.common.vo.BaseQueryVo;

public class GoodsOrdermjkSetplatQueryVo extends BaseQueryVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String platName;
	
	private String userName;
	
	private String password;

	public String getPlatName() {
		return platName;
	}

	public void setPlatName(String platName) {
		this.platName = platName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
