package com.brcc.business.agencyInvoice.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 	修改代开票打印状态
 * 
 * @author hui.liu
 * @date 2018年12月17日
 */
public class DealPrintFlagVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String platformId;
	private Integer ifPrint;
	private List<Long> reinvoiceMasterIdList;

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Integer getIfPrint() {
		return ifPrint;
	}

	public void setIfPrint(Integer ifPrint) {
		this.ifPrint = ifPrint;
	}

	public List<Long> getReinvoiceMasterIdList() {
		return reinvoiceMasterIdList;
	}

	public void setReinvoiceMasterIdList(List<Long> reinvoiceMasterIdList) {
		this.reinvoiceMasterIdList = reinvoiceMasterIdList;
	}

	@Override
	public String toString() {
		return "DealPrintFlagVo [platformId=" + platformId + ", ifPrint=" + ifPrint + ", reinvoiceMasterIdList="
				+ reinvoiceMasterIdList + "]";
	}

}
