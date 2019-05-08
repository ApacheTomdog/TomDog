package com.brcc.business.home.vo;

import com.esteel.common.vo.BaseQueryVo;

public class GoodsCarQueryVo extends BaseQueryVo {

	private String billSender;
	private String startPlate;
	private String endPlate;

	private String dataType;
	private String privinceId;
	private String fatherType;
	
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getPrivinceId() {
		return privinceId;
	}

	public void setPrivinceId(String privinceId) {
		this.privinceId = privinceId;
	}

	public String getFatherType() {
		return fatherType;
	}

	public void setFatherType(String fatherType) {
		this.fatherType = fatherType;
	}

	public String getBillSender() {
		return billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}

}
