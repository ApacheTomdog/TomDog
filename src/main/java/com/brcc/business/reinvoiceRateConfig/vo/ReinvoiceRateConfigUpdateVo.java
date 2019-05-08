package com.brcc.business.reinvoiceRateConfig.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

public class ReinvoiceRateConfigUpdateVo extends BaseQueryVo{


	private static final long serialVersionUID = 1L;
	
	private Date modifyDate;
	
	private Long modifyPersonId;
	
	private String modifyPersonName;
	
	private Long reinvoiceRateConfigId;
	
	private BigDecimal taxRate;

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

	public Long getReinvoiceRateConfigId() {
		return reinvoiceRateConfigId;
	}

	public void setReinvoiceRateConfigId(Long reinvoiceRateConfigId) {
		this.reinvoiceRateConfigId = reinvoiceRateConfigId;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	
	

}
