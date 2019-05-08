package com.brcc.business.reinvoiceRateConfig.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.esteel.common.vo.BaseQueryVo;

public class ReinvoiceRateConfigVo extends BaseQueryVo{

	
	private static final long serialVersionUID = 1L;
	
	private Long reinvoiceRateConfigId;
	
	
	private Long companyId;
	
	
	private String companyName;
	
	
	private String platformId;
	
	
	private BigDecimal taxRate;
	
	
	private Date createDate;
	
	
	private Long createPersonId;
	
	
	private String createPersonName;
	
	
	private Date modifyDate;
	
	
	private Long modifyPersonId;
	
	
	private String modifyPersonName;


	public Long getReinvoiceRateConfigId() {
		return reinvoiceRateConfigId;
	}


	public void setReinvoiceRateConfigId(Long reinvoiceRateConfigId) {
		this.reinvoiceRateConfigId = reinvoiceRateConfigId;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getPlatformId() {
		return platformId;
	}


	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}


	public BigDecimal getTaxRate() {
		return taxRate;
	}


	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Long getCreatePersonId() {
		return createPersonId;
	}


	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}


	public String getCreatePersonName() {
		return createPersonName;
	}


	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}


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
	
	

}
