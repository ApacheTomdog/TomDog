package com.brcc.business.goodsorderm.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.goodsorderm.entity.GoodsordermEntity;

/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午8:56:37
* @Description 数据接受类
*/
public class GoodsordermVo extends GoodsordermEntity {
	private static final long serialVersionUID = 1L;
	private String isTimeOut;
	
	private BigDecimal initAmountTax;
	
	private String lossTypeDesc;
	
	private String lossWeightDesc;
	
	private String detachableDesc;
	
	private String statusDesc;
	// 已运输量
	private BigDecimal transWeight;
	
	private String appointFlag;
	
	private String consignorName;
	
	private String sendGroupType;
	
	private String appointTeamName;
	
	private Integer fdCompanyId;
	
	private String dsIfSettleDesc;
	
	private String ifTaxTransportDesc;
	
	private String chargePriceType;
	
	private String docOrigin;
	
	private String vatFlowMasterName;

	private String OrderTaxDetail;
	
	private Integer afterDays;
	
	private BigDecimal curPrice;
	
	private Long credAdjDId;
	
	private String provinceName;
	
	private String cityName;
	
	private String countryName;
	
	private String provinceId;
	
	private String cityId;
	
	private String countryId;
	
	private String contactName;
	
	private String contactMobile;
	
	private String address;
	
	private String plateLng;
	
	private String plateLat;
	
	private String addressType;
			
	private Integer orderCount;

	private String vatRateChose;
	
	private BigDecimal vatStandardRate;
	
	private BigDecimal vatPolicyRate;
	
	private String vatAccType;
	
	// 货源单报价
	private BigDecimal outPrice;
	// 抢单重量
	private BigDecimal grabWeight;
	// 用户身份(GS公司,GR个人)
	private String userType;
	// 姓名
	private String userName;
	// 公司名字
	private String companyName;
	// 电话
	private String phone;		
	// 外部货源的提单号
	private String ret2;
	// 抢单数量
	private BigDecimal grabQty;
	// 报价id
	private Long quotationId;
	//外部接口货源单的老的状态
	private String preStatus;
	//查询相同货源单的开始时间
	private Date rqStart;
	//新的货源单id
	private Long newPublishId;
	//返回的操作结果
	private String returnMsg;
	// 单数
	private Integer maxBillNum;
	// 运单号
	private Long transId;
	// 是否是飞单
	private String ifFly;
	
	private BigDecimal billWeight;
	
	private String consignorNameMobile;

	// 是否收取服务费
	private String ifGrabMoney;
	// 服务费
	private BigDecimal grabMoney;
	// 操作类型
	private String operationType;
	// 资金流水id
	private Long capitalFlowingId;

	// 已装车重量
	private BigDecimal loadingWeight;
	// 已装车数量
	private Integer loadingNum;
	
	// 已收货重量
	private BigDecimal deliveryWeight;
	// 已收货数量
	private Integer deliveryNum;
	// 合同号
	private String contractNumber;
	// 增发类型
	private String addWeightType;
	// 已增发量
	private BigDecimal addWeight;
	// 已增发车数
	private Integer addCarCount;

	public Integer getLoadingNum() {
		return loadingNum;
	}

	public void setLoadingNum(Integer loadingNum) {
		this.loadingNum = loadingNum;
	}

	public Integer getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(Integer deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public BigDecimal getLoadingWeight() {
		return loadingWeight;
	}

	public void setLoadingWeight(BigDecimal loadingWeight) {
		this.loadingWeight = loadingWeight;
	}

	public BigDecimal getDeliveryWeight() {
		return deliveryWeight;
	}

	public void setDeliveryWeight(BigDecimal deliveryWeight) {
		this.deliveryWeight = deliveryWeight;
	}

	public String getIsTimeOut() {
		return isTimeOut;
	}

	public void setIsTimeOut(String isTimeOut) {
		this.isTimeOut = isTimeOut;
	}

	public BigDecimal getInitAmountTax() {
		return initAmountTax;
	}

	public void setInitAmountTax(BigDecimal initAmountTax) {
		this.initAmountTax = initAmountTax;
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

	public String getDetachableDesc() {
		return detachableDesc;
	}

	public void setDetachableDesc(String detachableDesc) {
		this.detachableDesc = detachableDesc;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public BigDecimal getTransWeight() {
		return transWeight;
	}

	public void setTransWeight(BigDecimal transWeight) {
		this.transWeight = transWeight;
	}

	public String getAppointFlag() {
		return appointFlag;
	}

	public void setAppointFlag(String appointFlag) {
		this.appointFlag = appointFlag;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public String getSendGroupType() {
		return sendGroupType;
	}

	public void setSendGroupType(String sendGroupType) {
		this.sendGroupType = sendGroupType;
	}

	public String getAppointTeamName() {
		return appointTeamName;
	}

	public void setAppointTeamName(String appointTeamName) {
		this.appointTeamName = appointTeamName;
	}

	public Integer getFdCompanyId() {
		return fdCompanyId;
	}

	public void setFdCompanyId(Integer fdCompanyId) {
		this.fdCompanyId = fdCompanyId;
	}

	public String getDsIfSettleDesc() {
		return dsIfSettleDesc;
	}

	public void setDsIfSettleDesc(String dsIfSettleDesc) {
		this.dsIfSettleDesc = dsIfSettleDesc;
	}

	public String getIfTaxTransportDesc() {
		return ifTaxTransportDesc;
	}

	public void setIfTaxTransportDesc(String ifTaxTransportDesc) {
		this.ifTaxTransportDesc = ifTaxTransportDesc;
	}

	public String getChargePriceType() {
		return chargePriceType;
	}

	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
	}

	public String getDocOrigin() {
		return docOrigin;
	}

	public void setDocOrigin(String docOrigin) {
		this.docOrigin = docOrigin;
	}

	public String getVatFlowMasterName() {
		return vatFlowMasterName;
	}

	public void setVatFlowMasterName(String vatFlowMasterName) {
		this.vatFlowMasterName = vatFlowMasterName;
	}

	public String getOrderTaxDetail() {
		return OrderTaxDetail;
	}

	public void setOrderTaxDetail(String orderTaxDetail) {
		OrderTaxDetail = orderTaxDetail;
	}

	public BigDecimal getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(BigDecimal curPrice) {
		this.curPrice = curPrice;
	}

	public Long getCredAdjDId() {
		return credAdjDId;
	}

	public Integer getAfterDays() {
		return afterDays;
	}

	public void setAfterDays(Integer afterDays) {
		this.afterDays = afterDays;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlateLng() {
		return plateLng;
	}

	public void setPlateLng(String plateLng) {
		this.plateLng = plateLng;
	}

	public String getPlateLat() {
		return plateLat;
	}

	public void setPlateLat(String plateLat) {
		this.plateLat = plateLat;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setType(String addressType) {
		this.addressType = addressType;
	}

	public void setCredAdjDId(Long credAdjDId) {
		this.credAdjDId = credAdjDId;
	}

	
	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
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

	public BigDecimal getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(BigDecimal outPrice) {
		this.outPrice = outPrice;
	}

	public BigDecimal getGrabWeight() {
		return grabWeight;
	}

	public void setGrabWeight(BigDecimal grabWeight) {
		this.grabWeight = grabWeight;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRet2() {
		return ret2;
	}

	public void setRet2(String ret2) {
		this.ret2 = ret2;
	}

	public BigDecimal getGrabQty() {
		return grabQty;
	}

	public void setGrabQty(BigDecimal grabQty) {
		this.grabQty = grabQty;
	}

	public Long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Long quotationId) {
		this.quotationId = quotationId;
	}

	public String getPreStatus() {
		return preStatus;
	}

	public void setPreStatus(String preStatus) {
		this.preStatus = preStatus;
	}

	public Date getRqStart() {
		return rqStart;
	}

	public void setRqStart(Date rqStart) {
		this.rqStart = rqStart;
	}

	public Long getNewPublishId() {
		return newPublishId;
	}

	public void setNewPublishId(Long newPublishId) {
		this.newPublishId = newPublishId;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public Integer getMaxBillNum() {
		return maxBillNum;
	}

	public void setMaxBillNum(Integer maxBillNum) {
		this.maxBillNum = maxBillNum;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getIfFly() {
		return ifFly;
	}

	public void setIfFly(String ifFly) {

		this.ifFly = ifFly;
	}

	public BigDecimal getBillWeight() {
		return billWeight;
	}

	public void setBillWeight(BigDecimal billWeight) {
		this.billWeight = billWeight;
	}

	public String getConsignorNameMobile() {
		return consignorNameMobile;
	}

	public void setConsignorNameMobile(String consignorNameMobile) {
		this.consignorNameMobile = consignorNameMobile;
	}
	public String getIfGrabMoney() {
		return ifGrabMoney;
	}

	public void setIfGrabMoney(String ifGrabMoney) {
		this.ifGrabMoney = ifGrabMoney;
	}

	public BigDecimal getGrabMoney() {
		return grabMoney;
	}

	public void setGrabMoney(BigDecimal grabMoney) {
		this.grabMoney = grabMoney;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Long getCapitalFlowingId() {
		return capitalFlowingId;
	}

	public void setCapitalFlowingId(Long capitalFlowingId) {
		this.capitalFlowingId = capitalFlowingId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getAddWeightType() {
		return addWeightType;
	}

	public void setAddWeightType(String addWeightType) {
		this.addWeightType = addWeightType;
	}

	public BigDecimal getAddWeight() {
		return addWeight;
	}

	public void setAddWeight(BigDecimal addWeight) {
		this.addWeight = addWeight;
	}

	public Integer getAddCarCount() {
		return addCarCount;
	}

	public void setAddCarCount(Integer addCarCount) {
		this.addCarCount = addCarCount;
	}
}
