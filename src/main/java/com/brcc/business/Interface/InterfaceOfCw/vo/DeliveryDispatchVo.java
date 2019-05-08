package com.brcc.business.Interface.InterfaceOfCw.vo;

import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;

import java.util.List;

public class DeliveryDispatchVo {
	
	private LoginInfo loginInfo;
	
	private List<CWDispatchDeliveryVo> dataInfo;

	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	public List<CWDispatchDeliveryVo> getDataInfo() {
		return dataInfo;
	}

	public void setDataInfo(List<CWDispatchDeliveryVo> dataInfo) {
		this.dataInfo = dataInfo;
	}
}
