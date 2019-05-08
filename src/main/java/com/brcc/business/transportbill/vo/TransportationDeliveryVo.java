package com.brcc.business.transportbill.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:26goo
 */
public class TransportationDeliveryVo extends TransportationDeliveryEntity {

	//车牌号
    private String vehicleNum;
    //司机状态
    private String driverStatus;
    //承运单位
    private String companyName;
    //司机身份证号
    private String idNum;
    //司机联系号码
    private String driverMobile;
    // 承运单位
    private String carryCompanyName;
    // 姓名
    private String name;
    // 更新人
    private String updatePersonName;
    private BigDecimal payAmount;
    private String carrierBankName;
    private String carrierBankNum;
    private String carrierBankOwner;
    private Long driverCompanyId;
    private String driverBankName;
    private String driverBankNum;
    private String driverBankOwner;
    private String phone;
    private String statusDesc;
    private String accFlag;
    private String ortherFlagName;
    private String iffly;
    private String docOrigin;
    private String consignorName;
    private String settleStatusDesc;
    private BigDecimal deductLossWeight;
    private BigDecimal deductLossRatio;
    private String payStatus;
    private String receBankTypeDesc;
    private String dsIfSettle;
    private String dsIfSettleDesc;
    private String fdBankNum;
    private String fdBankName;
    private String fdBankCardOwner;
    private String userType;
    private BigDecimal taxAmount;
    private BigDecimal amountTax;
    private String ifTaxTransportDesc;
    private String carryContactMobile;
    private String ifPayment;
    private String ifPaymentDesc;
    private BigDecimal chargePrice;
    private String chargePriceType;
    private BigDecimal ownerAdjustTotAmt;
    private BigDecimal transportationAmount;
    //付款申请标记
    private String ownerPayapplyFlag;
    //付款申请撤销标记
    private String ownerPayapplyCancelFlag;
    private String dependNum;
    private String ps;
    
    private String prodDesc;
    // 单据来源类型
    private String fromType;
    private String pinDanNum;
    // 预警天数
    private Integer earlyWarningDays;
    // 支付状态
    private String payStatusDesc;
    // 支付日期
    private Date payDate;
    private String receBankType;
    private String dzJkCancel; 
    private String invoiceNo;
    private Long receCompanyId;
    private String receCompanyName;
    private String payFromType;
    private String payFromTypeDesc;
    private String receBankName;
    private String receBankNum;
    private String receBankOwner;
    private BigDecimal payDriverAmount;
    private String oilFlag;
    private BigDecimal oilAmount;
    private Long payCompanyId;
    private String payCompanyName;
    private String eraseType;
    private BigDecimal eraseMinAmount;
    private String ifPayErase;
    private BigDecimal dumpTruckCharge;
    private String ifDumpTruckCharge;
    
    // 收款银行信息
    private String bankName;
    private String bankNum;
    private String bankOwner;
    private String mobile;
    private String accountType;
    private String province;
    private String city;
    private String subbranchName;
    private String linkNum;
    
    // 含税信息
    private String vatRateChose;
    private BigDecimal vatStandardRate;
    private BigDecimal vatPolicyRate;
    private String vatAccType;
    
    // 货款支付收款银行账号信息
    private String goodsBankType;
    private String goodsBankName;
    private String goodsBankNo;
    private String goodsBankOwner;
    private String goodsBankProvince;
    private String goodsBankCity;
    private String goodsBankSubName;
    private String goodsBankSubNo;

    //发货公司Id
    private Long publishCompanyId;

    private String publishCompanyName;
    private String driverName;
    private BigDecimal avgPrice;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    private String ifEnd;

    //货主
    private String goodOwner;

    //运费
    private BigDecimal amountForPlat;

    //最终付款人
    private String finallyPay;

    private String deliveryInfoZdwlSource;

    private String logisticsMark;

    //是否开票
    private String ifInvoice;

    private String contactMobile;

    private String card;

    private String lossTypeDesc;

	private String lossWeightDesc;

	private String ifDengjiInfo;

	private String ifDengjiInfoDesc;

	private String ifGsInfo;

	private String ifGsInfoDesc;

	private String driverStatusDesc;

	private String sendKM;

	private String receiverMobile;

	private String senderMobile;

	private String billSenderMobile;

	private BigDecimal realAmount;
	
	private String ifRoughWeightCal;

	private String contactName;

	private String vehicleType;

	private String goodTypeDesc;

	private String takeDeliveryDate;

	private String finishDate;

	private BigDecimal amountp;

	private String createDateStr;

	private String createDate1Str;

	private String endDateStr;

	private BigDecimal payAmountAct;

	private String bankOwnerNum;

	private Long companyOwnerBankId;

	private Long companyOwnerId;

	private String authorityFlag;
	//运费计算合计内容
	private BigDecimal payAmountSum;
	private BigDecimal deliveryWeightSum;
	private BigDecimal settleWeightSum;
	private BigDecimal loadWeightSum;
	//货主备注
	private String goodsOwnerPs;
	
	//抢单时间
	private Date grabDate;
	
	public Date getGrabDate() {
		return grabDate;
	}

	public void setGrabDate(Date grabDate) {
		this.grabDate = grabDate;
	}

	public String getGoodsOwnerPs() {
		return goodsOwnerPs;
	}

	public void setGoodsOwnerPs(String goodsOwnerPs) {
		this.goodsOwnerPs = goodsOwnerPs;
	}

	private String signStatus;
	
	private Date signTime;
	
	private String signPersonName;

	//合同编号
	private String contractNumber;

	//合同类型
	private String contractType;



	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getSignPersonName() {
		return signPersonName;
	}

	public void setSignPersonName(String signPersonName) {
		this.signPersonName = signPersonName;
	}

	public BigDecimal getPayAmountSum() {
		return payAmountSum;
	}

	public void setPayAmountSum(BigDecimal payAmountSum) {
		this.payAmountSum = payAmountSum;
	}

	public BigDecimal getDeliveryWeightSum() {
		return deliveryWeightSum;
	}

	public void setDeliveryWeightSum(BigDecimal deliveryWeightSum) {
		this.deliveryWeightSum = deliveryWeightSum;
	}

	public BigDecimal getSettleWeightSum() {
		return settleWeightSum;
	}

	public void setSettleWeightSum(BigDecimal settleWeightSum) {
		this.settleWeightSum = settleWeightSum;
	}

	public BigDecimal getLoadWeightSum() {
		return loadWeightSum;
	}

	public void setLoadWeightSum(BigDecimal loadWeightSum) {
		this.loadWeightSum = loadWeightSum;
	}

	public String getAuthorityFlag() {
		return authorityFlag;
	}

	public void setAuthorityFlag(String authorityFlag) {
		this.authorityFlag = authorityFlag;
	}

	public String getBankOwnerNum() {
		return bankOwnerNum;
	}

	public void setBankOwnerNum(String bankOwnerNum) {
		this.bankOwnerNum = bankOwnerNum;
	}

	public Long getCompanyOwnerBankId() {
		return companyOwnerBankId;
	}

	public void setCompanyOwnerBankId(Long companyOwnerBankId) {
		this.companyOwnerBankId = companyOwnerBankId;
	}

	public Long getCompanyOwnerId() {
		return companyOwnerId;
	}

	public void setCompanyOwnerId(Long companyOwnerId) {
		this.companyOwnerId = companyOwnerId;
	}
	
	private String ifOwnerLoss;

	public String getIfOwnerLoss() {
		return ifOwnerLoss;
	}

	public void setIfOwnerLoss(String ifOwnerLoss) {
		this.ifOwnerLoss = ifOwnerLoss;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	@Override
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}

	@Override
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}

	public String getTakeDeliveryDate() {
		return takeDeliveryDate;
	}

	public void setTakeDeliveryDate(String takeDeliveryDate) {
		this.takeDeliveryDate = takeDeliveryDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public BigDecimal getAmountp() {
		return amountp;
	}

	public void setAmountp(BigDecimal amountp) {
		this.amountp = amountp;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getCreateDate1Str() {
		return createDate1Str;
	}

	public void setCreateDate1Str(String createDate1Str) {
		this.createDate1Str = createDate1Str;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public BigDecimal getPayAmountAct() {
		return payAmountAct;
	}

	public void setPayAmountAct(BigDecimal payAmountAct) {
		this.payAmountAct = payAmountAct;
	}

	public String getIfRoughWeightCal() {
		
		return ifRoughWeightCal;
	}

	public void setIfRoughWeightCal(String ifRoughWeightCal) {
		this.ifRoughWeightCal = ifRoughWeightCal;
	}

	private String ifUnloadingWeightCal;
	
	public String getIfUnloadingWeightCal() {
		return ifUnloadingWeightCal;
	}

	public void setIfUnloadingWeightCal(String ifUnloadingWeightCal) {
		this.ifUnloadingWeightCal = ifUnloadingWeightCal;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public String getSendKM() {
		return sendKM;
	}

	public void setSendKM(String sendKM) {
		this.sendKM = sendKM;
	}

	@Override
	public String getReceiverMobile() {
		return receiverMobile;
	}

	@Override
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	@Override
	public String getSenderMobile() {
		return senderMobile;
	}

	@Override
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	@Override
	public String getBillSenderMobile() {
		return billSenderMobile;
	}

	@Override
	public void setBillSenderMobile(String billSenderMobile) {
		this.billSenderMobile = billSenderMobile;
	}

	public String getIfDengjiInfo() {
		return ifDengjiInfo;
	}

	public void setIfDengjiInfo(String ifDengjiInfo) {
		this.ifDengjiInfo = ifDengjiInfo;
	}

	public String getIfDengjiInfoDesc() {
		return ifDengjiInfoDesc;
	}

	public void setIfDengjiInfoDesc(String ifDengjiInfoDesc) {
		this.ifDengjiInfoDesc = ifDengjiInfoDesc;
	}

	public String getIfGsInfo() {
		return ifGsInfo;
	}

	public void setIfGsInfo(String ifGsInfo) {
		this.ifGsInfo = ifGsInfo;
	}

	public String getIfGsInfoDesc() {
		return ifGsInfoDesc;
	}

	public void setIfGsInfoDesc(String ifGsInfoDesc) {
		this.ifGsInfoDesc = ifGsInfoDesc;
	}

	public String getDriverStatusDesc() {
		return driverStatusDesc;
	}

	public void setDriverStatusDesc(String driverStatusDesc) {
		this.driverStatusDesc = driverStatusDesc;
	}

	public String getLossTypeDesc() {
		return lossTypeDesc;
	}

	public void setLossTypeDesc(String lossTypeDesc) {
		this.lossTypeDesc = lossTypeDesc;
	}

	public String getLossWeightDesc() {
		return lossWeightDesc;
	}

	public void setLossWeightDesc(String lossWeightDesc) {
		this.lossWeightDesc = lossWeightDesc;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getOwnerPayapplyCancelFlag() {
		return ownerPayapplyCancelFlag;
	}

	public void setOwnerPayapplyCancelFlag(String ownerPayapplyCancelFlag) {
		this.ownerPayapplyCancelFlag = ownerPayapplyCancelFlag;
	}
    
    public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public String getPublishCompanyName() {
		return publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getGoodsBankType() {
		return goodsBankType;
	}

	public void setGoodsBankType(String goodsBankType) {
		this.goodsBankType = goodsBankType;
	}

	public String getGoodsBankName() {
		return goodsBankName;
	}

	public void setGoodsBankName(String goodsBankName) {
		this.goodsBankName = goodsBankName;
	}

	public String getGoodsBankNo() {
		return goodsBankNo;
	}

	public void setGoodsBankNo(String goodsBankNo) {
		this.goodsBankNo = goodsBankNo;
	}

	public String getGoodsBankOwner() {
		return goodsBankOwner;
	}

	public void setGoodsBankOwner(String goodsBankOwner) {
		this.goodsBankOwner = goodsBankOwner;
	}

	public String getGoodsBankProvince() {
		return goodsBankProvince;
	}

	public void setGoodsBankProvince(String goodsBankProvince) {
		this.goodsBankProvince = goodsBankProvince;
	}

	public String getGoodsBankCity() {
		return goodsBankCity;
	}

	public void setGoodsBankCity(String goodsBankCity) {
		this.goodsBankCity = goodsBankCity;
	}

	public String getGoodsBankSubName() {
		return goodsBankSubName;
	}

	public void setGoodsBankSubName(String goodsBankSubName) {
		this.goodsBankSubName = goodsBankSubName;
	}

	public String getGoodsBankSubNo() {
		return goodsBankSubNo;
	}

	public void setGoodsBankSubNo(String goodsBankSubNo) {
		this.goodsBankSubNo = goodsBankSubNo;
	}

	public String getVatRateChose() {
		return vatRateChose;
	}

	public void setVatRateChose(String vatRateChose) {
		this.vatRateChose = vatRateChose;
	}

	public BigDecimal getVatStandardRate() {
		return vatStandardRate;
	}

	public void setVatStandardRate(BigDecimal vatStandardRate) {
		this.vatStandardRate = vatStandardRate;
	}

	public BigDecimal getVatPolicyRate() {
		return vatPolicyRate;
	}

	public void setVatPolicyRate(BigDecimal vatPolicyRate) {
		this.vatPolicyRate = vatPolicyRate;
	}

	public String getVatAccType() {
		return vatAccType;
	}

	public void setVatAccType(String vatAccType) {
		this.vatAccType = vatAccType;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubbranchName() {
		return subbranchName;
	}

	public void setSubbranchName(String subbranchName) {
		this.subbranchName = subbranchName;
	}

	public String getLinkNum() {
		return linkNum;
	}

	public void setLinkNum(String linkNum) {
		this.linkNum = linkNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getBankOwner() {
		return bankOwner;
	}

	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfDumpTruckCharge() {
		return ifDumpTruckCharge;
	}

	public void setIfDumpTruckCharge(String ifDumpTruckCharge) {
		this.ifDumpTruckCharge = ifDumpTruckCharge;
	}

	public String getIfPayErase() {
		return ifPayErase;
	}

	public void setIfPayErase(String ifPayErase) {
		this.ifPayErase = ifPayErase;
	}

	public String getEraseType() {
		return eraseType;
	}

	public void setEraseType(String eraseType) {
		this.eraseType = eraseType;
	}

	public BigDecimal getEraseMinAmount() {
		return eraseMinAmount;
	}

	public void setEraseMinAmount(BigDecimal eraseMinAmount) {
		this.eraseMinAmount = eraseMinAmount;
	}

	public Long getPayCompanyId() {
		return payCompanyId;
	}

	public void setPayCompanyId(Long payCompanyId) {
		this.payCompanyId = payCompanyId;
	}

	public String getPayCompanyName() {
		return payCompanyName;
	}

	public void setPayCompanyName(String payCompanyName) {
		this.payCompanyName = payCompanyName;
	}

	public String getOilFlag() {
		return oilFlag;
	}

	public void setOilFlag(String oilFlag) {
		this.oilFlag = oilFlag;
	}

	public BigDecimal getOilAmount() {
		return oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getFromType() {
		return fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getPinDanNum() {
		return pinDanNum;
	}

	public void setPinDanNum(String pinDanNum) {
		this.pinDanNum = pinDanNum;
	}

	public Integer getEarlyWarningDays() {
		return earlyWarningDays;
	}

	public void setEarlyWarningDays(Integer earlyWarningDays) {
		this.earlyWarningDays = earlyWarningDays;
	}

	public String getPayStatusDesc() {
		return payStatusDesc;
	}

	public void setPayStatusDesc(String payStatusDesc) {
		this.payStatusDesc = payStatusDesc;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getReceBankType() {
		return receBankType;
	}

	public void setReceBankType(String receBankType) {
		this.receBankType = receBankType;
	}

	public String getDzJkCancel() {
		return dzJkCancel;
	}

	public void setDzJkCancel(String dzJkCancel) {
		this.dzJkCancel = dzJkCancel;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Long getReceCompanyId() {
		return receCompanyId;
	}

	public void setReceCompanyId(Long receCompanyId) {
		this.receCompanyId = receCompanyId;
	}

	public String getReceCompanyName() {
		return receCompanyName;
	}

	public void setReceCompanyName(String receCompanyName) {
		this.receCompanyName = receCompanyName;
	}

	public String getPayFromType() {
		return payFromType;
	}

	public void setPayFromType(String payFromType) {
		this.payFromType = payFromType;
	}

	public String getPayFromTypeDesc() {
		return payFromTypeDesc;
	}

	public void setPayFromTypeDesc(String payFromTypeDesc) {
		this.payFromTypeDesc = payFromTypeDesc;
	}

	public String getReceBankName() {
		return receBankName;
	}

	public void setReceBankName(String receBankName) {
		this.receBankName = receBankName;
	}

	public String getReceBankNum() {
		return receBankNum;
	}

	public void setReceBankNum(String receBankNum) {
		this.receBankNum = receBankNum;
	}

	public String getReceBankOwner() {
		return receBankOwner;
	}

	public void setReceBankOwner(String receBankOwner) {
		this.receBankOwner = receBankOwner;
	}

	public BigDecimal getPayDriverAmount() {
		return payDriverAmount;
	}

	public void setPayDriverAmount(BigDecimal payDriverAmount) {
		this.payDriverAmount = payDriverAmount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getDependNum() {
		return dependNum;
	}

	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getUpdatePersonName() {
		return updatePersonName;
	}

	public void setUpdatePersonName(String updatePersonName) {
		this.updatePersonName = updatePersonName;
	}

	public Long getDriverCompanyId() {
		return driverCompanyId;
	}

	public void setDriverCompanyId(Long driverCompanyId) {
		this.driverCompanyId = driverCompanyId;
	}

	public BigDecimal getDeductLossWeight() {
		return deductLossWeight;
	}

	public void setDeductLossWeight(BigDecimal deductLossWeight) {
		this.deductLossWeight = deductLossWeight;
	}

	public BigDecimal getDeductLossRatio() {
		return deductLossRatio;
	}

	public void setDeductLossRatio(BigDecimal deductLossRatio) {
		this.deductLossRatio = deductLossRatio;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getAmountTax() {
		return amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public BigDecimal getChargePrice() {
		return chargePrice;
	}

	public void setChargePrice(BigDecimal chargePrice) {
		this.chargePrice = chargePrice;
	}

	public BigDecimal getOwnerAdjustTotAmt() {
		return ownerAdjustTotAmt;
	}

	public void setOwnerAdjustTotAmt(BigDecimal ownerAdjustTotAmt) {
		this.ownerAdjustTotAmt = ownerAdjustTotAmt;
	}

	public BigDecimal getDumpTruckCharge() {
		return dumpTruckCharge;
	}

	public void setDumpTruckCharge(BigDecimal dumpTruckCharge) {
		this.dumpTruckCharge = dumpTruckCharge;
	}

	public BigDecimal getTransportationAmount() {
		return transportationAmount;
	}

	public void setTransportationAmount(BigDecimal transportationAmount) {
		this.transportationAmount = transportationAmount;
	}

	public String getDsIfSettle() {
		return dsIfSettle;
	}

	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getCarrierBankName() {
		return carrierBankName;
	}

	public void setCarrierBankName(String carrierBankName) {
		this.carrierBankName = carrierBankName;
	}

	public String getCarrierBankNum() {
		return carrierBankNum;
	}

	public void setCarrierBankNum(String carrierBankNum) {
		this.carrierBankNum = carrierBankNum;
	}

	public String getCarrierBankOwner() {
		return carrierBankOwner;
	}

	public void setCarrierBankOwner(String carrierBankOwner) {
		this.carrierBankOwner = carrierBankOwner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDriverBankName() {
		return driverBankName;
	}

	public void setDriverBankName(String driverBankName) {
		this.driverBankName = driverBankName;
	}

	public String getDriverBankNum() {
		return driverBankNum;
	}

	public void setDriverBankNum(String driverBankNum) {
		this.driverBankNum = driverBankNum;
	}

	public String getDriverBankOwner() {
		return driverBankOwner;
	}

	public void setDriverBankOwner(String driverBankOwner) {
		this.driverBankOwner = driverBankOwner;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getAccFlag() {
		return accFlag;
	}

	public void setAccFlag(String accFlag) {
		this.accFlag = accFlag;
	}

	public String getOrtherFlagName() {
		return ortherFlagName;
	}

	public void setOrtherFlagName(String ortherFlagName) {
		this.ortherFlagName = ortherFlagName;
	}

	public String getIffly() {
		return iffly;
	}

	public void setIffly(String iffly) {
		this.iffly = iffly;
	}

	public String getDocOrigin() {
		return docOrigin;
	}

	public void setDocOrigin(String docOrigin) {
		this.docOrigin = docOrigin;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public String getSettleStatusDesc() {
		return settleStatusDesc;
	}

	public void setSettleStatusDesc(String settleStatusDesc) {
		this.settleStatusDesc = settleStatusDesc;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getReceBankTypeDesc() {
		return receBankTypeDesc;
	}

	public void setReceBankTypeDesc(String receBankTypeDesc) {
		this.receBankTypeDesc = receBankTypeDesc;
	}

	public String getDsIfSettleDesc() {
		return dsIfSettleDesc;
	}

	public void setDsIfSettleDesc(String dsIfSettleDesc) {
		this.dsIfSettleDesc = dsIfSettleDesc;
	}

	public String getFdBankNum() {
		return fdBankNum;
	}

	public void setFdBankNum(String fdBankNum) {
		this.fdBankNum = fdBankNum;
	}

	public String getFdBankName() {
		return fdBankName;
	}

	public void setFdBankName(String fdBankName) {
		this.fdBankName = fdBankName;
	}

	public String getFdBankCardOwner() {
		return fdBankCardOwner;
	}

	public void setFdBankCardOwner(String fdBankCardOwner) {
		this.fdBankCardOwner = fdBankCardOwner;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getIfTaxTransportDesc() {
		return ifTaxTransportDesc;
	}

	public void setIfTaxTransportDesc(String ifTaxTransportDesc) {
		this.ifTaxTransportDesc = ifTaxTransportDesc;
	}


	public String getCarryContactMobile() {
		return carryContactMobile;
	}

	public void setCarryContactMobile(String carryContactMobile) {
		this.carryContactMobile = carryContactMobile;
	}

	public String getIfPayment() {
		return ifPayment;
	}

	public void setIfPayment(String ifPayment) {
		this.ifPayment = ifPayment;
	}

	public String getIfPaymentDesc() {
		return ifPaymentDesc;
	}

	public void setIfPaymentDesc(String ifPaymentDesc) {
		this.ifPaymentDesc = ifPaymentDesc;
	}

	public String getChargePriceType() {
		return chargePriceType;
	}

	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
	}

	public String getOwnerPayapplyFlag() {
		return ownerPayapplyFlag;
	}

	public void setOwnerPayapplyFlag(String ownerPayapplyFlag) {
		this.ownerPayapplyFlag = ownerPayapplyFlag;
	}
    
    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public String getCarryCompanyName() {
		return carryCompanyName;
	}

	public void setCarryCompanyName(String carryCompanyName) {
		this.carryCompanyName = carryCompanyName;
	}

    public String getIfEnd() {
        return ifEnd;
    }

    public void setIfEnd(String ifEnd) {
        this.ifEnd = ifEnd;
    }

    public String getGoodOwner() {
        return goodOwner;
    }

    public void setGoodOwner(String goodOwner) {
        this.goodOwner = goodOwner;
    }

    public BigDecimal getAmountForPlat() {
        return amountForPlat;
    }

    public void setAmountForPlat(BigDecimal amountForPlat) {
        this.amountForPlat = amountForPlat;
    }

    public String getFinallyPay() {
        return finallyPay;
    }

    public void setFinallyPay(String finallyPay) {
        this.finallyPay = finallyPay;
    }

    public String getDeliveryInfoZdwlSource() {
        return deliveryInfoZdwlSource;
    }

    public void setDeliveryInfoZdwlSource(String deliveryInfoZdwlSource) {
        this.deliveryInfoZdwlSource = deliveryInfoZdwlSource;
    }

    public String getLogisticsMark() {
        return logisticsMark;
    }

    public void setLogisticsMark(String logisticsMark) {
        this.logisticsMark = logisticsMark;
    }

    @Override
    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    @Override
    public String getIfInvoice() {
        return ifInvoice;
    }

    @Override
    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

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
}
