package com.brcc.business.invoice.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @Description 发票查询vo
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:04:18
 */
public class InvoiceQueryVo extends BaseQueryVo {
	
	private static final long serialVersionUID = -1939029452181653080L;
	
	private String platformId;
	private Long companyId;
	private Long groupId;
	private String groupName;
	private String ifGroupCompany;
	private Long invoiceTitleId;
	private Long invoiceClientId;
	private String invoiceClientName;
	private String invoiceTitleName;
	private String invoiceNo;
	private Long invoiceMasterId;
	private String ticketOpeningMarkDesc;
	private String status;
	private Date rqStart;
	private Date rqEnd;
	private Date agreeTimeStart;
	private Date agreeTimeEnd;
	private Date rqApplyStart;
	private Date rqApplyEnd;
	private Integer applyFlag;
	
	private Long vatCarryId;
	private Long vatClientId;
	
	// 新增发票字段
	private Long invoiceCarryId;
	private String invoiceCarryName;
	private Integer ticketOpeningMark;
	private String invoiceDesc;
	private String remark;
	
	// 添加明细查询条件
	private String ifOwnerTaxpriceMf;
	private Long deliveryId;
	private Long transId;
	private Long publishId;
	private String zfNum;
	private String startPlat;
	private String endPlat;
	private String billSender;
	private Date zcRqStart;
	private Date zcRqEnd;
	private String companyName;
	private String dependNum;
	private BigDecimal priceTax;
	private String vatClientName;
	private String goodStyle;
	private Date finishTimeStart;
	private Date finishTimeEnd;
	
	//添加明细
	private String zfIdStr;
	private Long zfId;
	
	//查看发票明细
	private String invoiceStatus;
	private String invoiceMasterNum;
	
	// 查看发票明细查询条件
	private String flag;
	private String invoiceSplitNum;
	private String ifInvoice;
	
	//删除发票明细
	private Long invoiceDetailId;
	private String invoiceDetailIdStr;
	
	//发票拆分
	private String detailIds;
	private BigDecimal detailAmtSum;
	private String type;//ZD：自动拆分，SD：手动拆分
	
	//发票维护
	private Long invoiceSplitId;
	private BigDecimal invoiceActualAmount;
	private BigDecimal invoiceActualWeight;
	private Date invoiceAgreeTime;
	
	//页面名称
	private String pageName;
	
	//发票申请总金额/发票申请总吨位区间查询
	private BigDecimal invoiceActualAmountS;
	private BigDecimal invoiceActualAmountE;
	private BigDecimal invoiceActualWeightS;
	private BigDecimal invoiceActualWeightE;
	//冲红发票号
	private String  redInvoiceNo;
	//冲红开票日期
	private Date redAgreeTimeStart;
	private Date redAgreeTimeEnd;
	//发票类型 'ZF代表作废发票，HC代表红冲发票',
	private String invoiceType;
	private Date redInvoiceDate;
	private Long invoiceSplitSrrId;
	//合同编号
	private String contractNumber;

	//合同类型
	private String contractType;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getInvoiceDesc() {
		return invoiceDesc;
	}
	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}
	public BigDecimal getInvoiceActualAmountS() {
		return invoiceActualAmountS;
	}
	public void setInvoiceActualAmountS(BigDecimal invoiceActualAmountS) {
		this.invoiceActualAmountS = invoiceActualAmountS;
	}
	public BigDecimal getInvoiceActualAmountE() {
		return invoiceActualAmountE;
	}
	public void setInvoiceActualAmountE(BigDecimal invoiceActualAmountE) {
		this.invoiceActualAmountE = invoiceActualAmountE;
	}
	public BigDecimal getInvoiceActualWeightS() {
		return invoiceActualWeightS;
	}
	public void setInvoiceActualWeightS(BigDecimal invoiceActualWeightS) {
		this.invoiceActualWeightS = invoiceActualWeightS;
	}
	public BigDecimal getInvoiceActualWeightE() {
		return invoiceActualWeightE;
	}
	public void setInvoiceActualWeightE(BigDecimal invoiceActualWeightE) {
		this.invoiceActualWeightE = invoiceActualWeightE;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public Date getInvoiceAgreeTime() {
		return invoiceAgreeTime;
	}
	public void setInvoiceAgreeTime(Date invoiceAgreeTime) {
		this.invoiceAgreeTime = invoiceAgreeTime;
	}
	public BigDecimal getInvoiceActualAmount() {
		return invoiceActualAmount;
	}
	public void setInvoiceActualAmount(BigDecimal invoiceActualAmount) {
		this.invoiceActualAmount = invoiceActualAmount;
	}
	public BigDecimal getInvoiceActualWeight() {
		return invoiceActualWeight;
	}
	public void setInvoiceActualWeight(BigDecimal invoiceActualWeight) {
		this.invoiceActualWeight = invoiceActualWeight;
	}
	public Long getInvoiceSplitId() {
		return invoiceSplitId;
	}
	public void setInvoiceSplitId(Long invoiceSplitId) {
		this.invoiceSplitId = invoiceSplitId;
	}
	public String getIfInvoice() {
		return ifInvoice;
	}
	public void setIfInvoice(String ifInvoice) {
		this.ifInvoice = ifInvoice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetailIds() {
		return detailIds;
	}
	public void setDetailIds(String detailIds) {
		this.detailIds = detailIds;
	}
	public BigDecimal getDetailAmtSum() {
		return detailAmtSum;
	}
	public void setDetailAmtSum(BigDecimal detailAmtSum) {
		this.detailAmtSum = detailAmtSum;
	}
	public Long getInvoiceDetailId() {
		return invoiceDetailId;
	}
	public void setInvoiceDetailId(Long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	public String getInvoiceDetailIdStr() {
		return invoiceDetailIdStr;
	}
	public void setInvoiceDetailIdStr(String invoiceDetailIdStr) {
		this.invoiceDetailIdStr = invoiceDetailIdStr;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getInvoiceSplitNum() {
		return invoiceSplitNum;
	}
	public void setInvoiceSplitNum(String invoiceSplitNum) {
		this.invoiceSplitNum = invoiceSplitNum;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getInvoiceMasterNum() {
		return invoiceMasterNum;
	}
	public void setInvoiceMasterNum(String invoiceMasterNum) {
		this.invoiceMasterNum = invoiceMasterNum;
	}
	public Long getZfId() {
		return zfId;
	}
	public void setZfId(Long zfId) {
		this.zfId = zfId;
	}
	public String getZfIdStr() {
		return zfIdStr;
	}
	public void setZfIdStr(String zfIdStr) {
		this.zfIdStr = zfIdStr;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public Long getPublishId() {
		return publishId;
	}
	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}
	public String getZfNum() {
		return zfNum;
	}
	public void setZfNum(String zfNum) {
		this.zfNum = zfNum;
	}
	public String getStartPlat() {
		return startPlat;
	}
	public void setStartPlat(String startPlat) {
		this.startPlat = startPlat;
	}
	public String getEndPlat() {
		return endPlat;
	}
	public void setEndPlat(String endPlat) {
		this.endPlat = endPlat;
	}
	public String getBillSender() {
		return billSender;
	}
	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}
	public Date getZcRqStart() {
		return zcRqStart;
	}
	public void setZcRqStart(Date zcRqStart) {
		this.zcRqStart = zcRqStart;
	}
	public Date getZcRqEnd() {
		return zcRqEnd;
	}
	public void setZcRqEnd(Date zcRqEnd) {
		this.zcRqEnd = zcRqEnd;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public BigDecimal getPriceTax() {
		return priceTax;
	}
	public void setPriceTax(BigDecimal priceTax) {
		this.priceTax = priceTax;
	}
	public String getVatClientName() {
		return vatClientName;
	}
	public void setVatClientName(String vatClientName) {
		this.vatClientName = vatClientName;
	}
	public String getGoodStyle() {
		return goodStyle;
	}
	public void setGoodStyle(String goodStyle) {
		this.goodStyle = goodStyle;
	}
	public Date getFinishTimeStart() {
		return finishTimeStart;
	}
	public void setFinishTimeStart(Date finishTimeStart) {
		this.finishTimeStart = finishTimeStart;
	}
	public Date getFinishTimeEnd() {
		return finishTimeEnd;
	}
	public void setFinishTimeEnd(Date finishTimeEnd) {
		this.finishTimeEnd = finishTimeEnd;
	}
	public String getIfOwnerTaxpriceMf() {
		return ifOwnerTaxpriceMf;
	}
	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}
	public String getInvoiceCarryName() {
		return invoiceCarryName;
	}
	public void setInvoiceCarryName(String invoiceCarryName) {
		this.invoiceCarryName = invoiceCarryName;
	}
	public Long getVatCarryId() {
		return vatCarryId;
	}
	public void setVatCarryId(Long vatCarryId) {
		this.vatCarryId = vatCarryId;
	}
	public Long getVatClientId() {
		return vatClientId;
	}
	public void setVatClientId(Long vatClientId) {
		this.vatClientId = vatClientId;
	}
	public Long getInvoiceCarryId() {
		return invoiceCarryId;
	}
	public void setInvoiceCarryId(Long invoiceCarryId) {
		this.invoiceCarryId = invoiceCarryId;
	}
	public Integer getTicketOpeningMark() {
		return ticketOpeningMark;
	}
	public void setTicketOpeningMark(Integer ticketOpeningMark) {
		this.ticketOpeningMark = ticketOpeningMark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getInvoiceClientId() {
		return invoiceClientId;
	}
	public void setInvoiceClientId(Long invoiceClientId) {
		this.invoiceClientId = invoiceClientId;
	}
	public String getInvoiceClientName() {
		return invoiceClientName;
	}
	public void setInvoiceClientName(String invoiceClientName) {
		this.invoiceClientName = invoiceClientName;
	}
	public String getInvoiceTitleName() {
		return invoiceTitleName;
	}
	public void setInvoiceTitleName(String invoiceTitleName) {
		this.invoiceTitleName = invoiceTitleName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Long getInvoiceMasterId() {
		return invoiceMasterId;
	}
	public void setInvoiceMasterId(Long invoiceMasterId) {
		this.invoiceMasterId = invoiceMasterId;
	}
	public String getTicketOpeningMarkDesc() {
		return ticketOpeningMarkDesc;
	}
	public void setTicketOpeningMarkDesc(String ticketOpeningMarkDesc) {
		this.ticketOpeningMarkDesc = ticketOpeningMarkDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRqStart() {
		return rqStart;
	}
	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}
	public Date getRqEnd() {
		return rqEnd;
	}
	public void setRqEnd(Date rqEnd) {
		this.rqEnd = rqEnd;
	}
	public Date getAgreeTimeStart() {
		return agreeTimeStart;
	}
	public void setAgreeTimeStart(Date agreeTimeStart) {
		this.agreeTimeStart = agreeTimeStart;
	}
	public Date getAgreeTimeEnd() {
		return agreeTimeEnd;
	}
	public void setAgreeTimeEnd(Date agreeTimeEnd) {
		this.agreeTimeEnd = agreeTimeEnd;
	}
	public Date getRqApplyStart() {
		return rqApplyStart;
	}
	public void setRqApplyStart(Date rqApplyStart) {
		this.rqApplyStart = rqApplyStart;
	}
	public Date getRqApplyEnd() {
		return rqApplyEnd;
	}
	public void setRqApplyEnd(Date rqApplyEnd) {
		this.rqApplyEnd = rqApplyEnd;
	}
	public Integer getApplyFlag() {
		return applyFlag;
	}
	public void setApplyFlag(Integer applyFlag) {
		this.applyFlag = applyFlag;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getIfGroupCompany() {
		return ifGroupCompany;
	}
	public void setIfGroupCompany(String ifGroupCompany) {
		this.ifGroupCompany = ifGroupCompany;
	}
	public Long getInvoiceTitleId() {
		return invoiceTitleId;
	}
	public void setInvoiceTitleId(Long invoiceTitleId) {
		this.invoiceTitleId = invoiceTitleId;
	}

	public String getRedInvoiceNo() {
		return redInvoiceNo;
	}

	public void setRedInvoiceVo(String redInvoiceNo) {
		this.redInvoiceNo = redInvoiceNo;
	}

	public Date getRedAgreeTimeStart() {
		return redAgreeTimeStart;
	}

	public void setRedAgreeTimeStart(Date redAgreeTimeStart) {
		this.redAgreeTimeStart = redAgreeTimeStart;
	}

	public Date getRedAgreeTimeEnd() {
		return redAgreeTimeEnd;
	}

	public void setRedAgreeTimeEnd(Date redAgreeTimeEnd) {
		this.redAgreeTimeEnd = redAgreeTimeEnd;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setRedInvoiceNo(String redInvoiceNo) {
		this.redInvoiceNo = redInvoiceNo;
	}

	public Date getRedInvoiceDate() {
		return redInvoiceDate;
	}

	public void setRedInvoiceDate(Date redInvoiceDate) {
		this.redInvoiceDate = redInvoiceDate;
	}

	public Long getInvoiceSplitSrrId() {
		return invoiceSplitSrrId;
	}

	public void setInvoiceSplitSrrId(Long invoiceSplitSrrId) {
		this.invoiceSplitSrrId = invoiceSplitSrrId;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
}
