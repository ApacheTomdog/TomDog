package com.brcc.business.agencyInvoice.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 代开票管理
 * 
 * @author hui.liu
 * @date 2018年12月13日
 */
public class AgencyInvoiceVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long reinvoiceMasterId;
	private String reinvoiceMasterNum;
	private String reinvoiceNo;
	private BigDecimal reinvoiceAmount;
	private BigDecimal reinvoiceWeight;
	private Long reinvoiceTitleId;
	private String reinvoiceTitleName;
	private String memo;
	private String taxNum;
	private String platformId;
	private String reinvoiceStatus;
	private String drawerName;
	private String drawerMobile;
	private String drawerAddress;
	private String drawerNo;
	private String createDate;
	private Long createPersonId;
	private String createPersonName;
	private String modifyDate;
	private Long modifyPersonId;
	private String inVoiceFlag;
	private String modifyPersonName;
	private String year;
	private String month;
	private String day;
	private Integer ifPrint;
	private String printFlag;
	private Integer printNum;
	private Integer ifFkPrint;
	private Integer fkPrintNum;
	private String reinvoiceTime;
	private String registrationTaxNum;
	private Integer taxRegistrationFlag;
	private Integer withholdProtocolFlag;
	private String startPlate;
	private String endPlate;
	private String vehicleNum;
	private String goodTypeDesc;
	private BigDecimal noTaxAmount;
	private BigDecimal taxRate;

	public Long getReinvoiceMasterId() {
		return reinvoiceMasterId;
	}

	public void setReinvoiceMasterId(Long reinvoiceMasterId) {
		this.reinvoiceMasterId = reinvoiceMasterId;
	}

	public String getReinvoiceMasterNum() {
		return reinvoiceMasterNum;
	}

	public void setReinvoiceMasterNum(String reinvoiceMasterNum) {
		this.reinvoiceMasterNum = reinvoiceMasterNum;
	}

	public String getReinvoiceNo() {
		return reinvoiceNo;
	}

	public void setReinvoiceNo(String reinvoiceNo) {
		this.reinvoiceNo = reinvoiceNo;
	}

	public BigDecimal getReinvoiceAmount() {
		return reinvoiceAmount;
	}

	public void setReinvoiceAmount(BigDecimal reinvoiceAmount) {
		this.reinvoiceAmount = reinvoiceAmount;
	}

	public BigDecimal getReinvoiceWeight() {
		return reinvoiceWeight;
	}

	public void setReinvoiceWeight(BigDecimal reinvoiceWeight) {
		this.reinvoiceWeight = reinvoiceWeight;
	}

	public Long getReinvoiceTitleId() {
		return reinvoiceTitleId;
	}

	public void setReinvoiceTitleId(Long reinvoiceTitleId) {
		this.reinvoiceTitleId = reinvoiceTitleId;
	}

	public String getReinvoiceTitleName() {
		return reinvoiceTitleName;
	}

	public void setReinvoiceTitleName(String reinvoiceTitleName) {
		this.reinvoiceTitleName = reinvoiceTitleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getTaxNum() {
		return taxNum;
	}

	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getReinvoiceStatus() {
		return reinvoiceStatus;
	}

	public void setReinvoiceStatus(String reinvoiceStatus) {
		this.reinvoiceStatus = reinvoiceStatus;
	}

	public String getDrawerName() {
		return drawerName;
	}

	public void setDrawerName(String drawerName) {
		this.drawerName = drawerName;
	}

	public String getDrawerMobile() {
		return drawerMobile;
	}

	public void setDrawerMobile(String drawerMobile) {
		this.drawerMobile = drawerMobile;
	}

	public String getDrawerAddress() {
		return drawerAddress;
	}

	public void setDrawerAddress(String drawerAddress) {
		this.drawerAddress = drawerAddress;
	}

	public String getDrawerNo() {
		return drawerNo;
	}

	public void setDrawerNo(String drawerNo) {
		this.drawerNo = drawerNo;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
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

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getInVoiceFlag() {
		return inVoiceFlag;
	}

	public void setInVoiceFlag(String inVoiceFlag) {
		this.inVoiceFlag = inVoiceFlag;
	}

	public String getModifyPersonName() {
		return modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getIfPrint() {
		return ifPrint;
	}

	public void setIfPrint(Integer ifPrint) {
		this.ifPrint = ifPrint;
	}

	public String getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}

	public Integer getPrintNum() {
		return printNum;
	}

	public void setPrintNum(Integer printNum) {
		this.printNum = printNum;
	}

	public Integer getIfFkPrint() {
		return ifFkPrint;
	}

	public void setIfFkPrint(Integer ifFkPrint) {
		this.ifFkPrint = ifFkPrint;
	}

	public Integer getFkPrintNum() {
		return fkPrintNum;
	}

	public void setFkPrintNum(Integer fkPrintNum) {
		this.fkPrintNum = fkPrintNum;
	}

	public String getReinvoiceTime() {
		return reinvoiceTime;
	}

	public void setReinvoiceTime(String reinvoiceTime) {
		this.reinvoiceTime = reinvoiceTime;
	}

	public String getRegistrationTaxNum() {
		return registrationTaxNum;
	}

	public void setRegistrationTaxNum(String registrationTaxNum) {
		this.registrationTaxNum = registrationTaxNum;
	}

	public Integer getTaxRegistrationFlag() {
		return taxRegistrationFlag;
	}

	public void setTaxRegistrationFlag(Integer taxRegistrationFlag) {
		this.taxRegistrationFlag = taxRegistrationFlag;
	}

	public Integer getWithholdProtocolFlag() {
		return withholdProtocolFlag;
	}

	public void setWithholdProtocolFlag(Integer withholdProtocolFlag) {
		this.withholdProtocolFlag = withholdProtocolFlag;
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

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public BigDecimal getNoTaxAmount() {
		return noTaxAmount;
	}

	public void setNoTaxAmount(BigDecimal noTaxAmount) {
		this.noTaxAmount = noTaxAmount;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

}
