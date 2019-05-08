package com.brcc.business.Interface.InterfaceOfCw.vo;

import java.util.List;

public class GoodsUploadVo {
	
	private LoginInfo loginInfo;
	
	private List<DataInfo> dataInfo;

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	public List<DataInfo> getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(List<DataInfo> dataInfo) {
		this.dataInfo = dataInfo;
	}
	
	
}
