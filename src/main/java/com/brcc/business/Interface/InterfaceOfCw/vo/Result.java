package com.brcc.business.Interface.InterfaceOfCw.vo;

import com.brcc.business.Interface.InterfaceOfCw.entity.ReInfoEntity;

import java.util.List;
import java.util.Map;

public class Result {
	
	public String outResult;
	public String outResultReason;
	public List data;

	public String getOutResult() {
		return outResult;
	}

	public void setOutResult(String outResult) {
		this.outResult = outResult;
	}

	public String getOutResultReason() {
		return outResultReason;
	}

	public void setOutResultReason(String outResultReason) {
		this.outResultReason = outResultReason;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}
