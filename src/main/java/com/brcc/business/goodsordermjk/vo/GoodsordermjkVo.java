package com.brcc.business.goodsordermjk.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;

/**
 * @author PanJianYang
 * @version 创建时间：2018年11月6日 上午9:12:46
 * @ClassName 类名称
 * @Description 类描述
 */
public class GoodsordermjkVo extends GoodsordermjkEntity {
	private static final long serialVersionUID = 1L;
	// 外部货源单据号拼接字符串(以,间隔)
	private String importIdStr;
	// 状态描述
	private String statusDesc;
	//起始地目的地取单地对应的金纬度
	private String startPlateLngDesc;
	private String startPlateLatDesc;
	private String endPlateLngDesc;
	private String endPlateLatDesc;
	private String getOrderPlateLngDesc;
	private String getOrderPlateLatDesc;
	//是否可拆单
	private String detachableDesc;
	//是否已完善信息
	private String ifInfoCompleteDesc;
	private String chargePriceTypedesc;
	private String appointType;
	// 省市区(县)的id
	private String provinceId;
	private String cityId;
	private String countryId;
	// 10代表装货地,30代表目的地
	private String addressType;
	// 登陆用户
	private String userName;
	// 公司名称
	private String companyName;
	// 单据类型:('single':表示单个单据信息保存;否则代表相同拼单信息保存)
	private String type;	
	// 1代表含税单价抹分，四舍五入;0代表不处理
	private String ifOwnerTaxpriceMf;
	// 是否含税运输的货源(货源发布的标记)
	private String flagTax;
	// 货主运费调整标记(Y:需要调整，N：不需要调整)
	private String ownerAdjustFlag;
	// 是否自动生成运单
	private String isAutoToTrans;
	// 车型
	private String carStyle;
	// 是否隐藏
	private String ifShow;
	// 发布量
	private BigDecimal sendWeight;
	// 货主运费调整方式(01：单价调整，02：单车调整)
	private String ownerAdjustType;
	// 货主运费调整金额
	private BigDecimal ownerAdjustAmt;
	// 调整区间价格
	private BigDecimal curPrice;
	// 消息类型
	private String messageType;
	private String importIdTax;
	// 拼单的主单id
	private Long priPublishId;
	// 单据主次，1为主单，2为次单
	private String docuPriSec;
	// 合并单据数
	private Integer combinedNumber;
	// 调整明细id
	private Long credAdjDId;
	// 投放单可出价次数
	private Integer bidTimes;
	// 定向信息
	private String appointTeamName;
	// 公司电话
	private String companyMobile;
	// 智能推荐
	private String ifZntjFlag;
	//采购单据是否智能推送
	private String dqFlag;
	//定抢开始结束时间
	private Date robDayTime;
	private Date robEndTime;
	// 大品种Id
	private Long catalogId;
	// 大品种名字
	private String catalogName;
	// 是否是智能推送的单据
    private String qdFlag;
	// 废钢采购合同号
	private String contractNumber;
	// 增发类型
	private String addWeightType;

	private Long fdCompanyId;
	// 合同类型
	private String contractType;


	public String getImportIdStr() {
		return importIdStr;
	}

	public void setImportIdStr(String importIdStr) {
		this.importIdStr = importIdStr;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getStartPlateLngDesc() {
		return startPlateLngDesc;
	}

	public void setStartPlateLngDesc(String startPlateLngDesc) {
		this.startPlateLngDesc = startPlateLngDesc;
	}

	public String getStartPlateLatDesc() {
		return startPlateLatDesc;
	}

	public void setStartPlateLatDesc(String startPlateLatDesc) {
		this.startPlateLatDesc = startPlateLatDesc;
	}

	public String getEndPlateLngDesc() {
		return endPlateLngDesc;
	}

	public void setEndPlateLngDesc(String endPlateLngDesc) {
		this.endPlateLngDesc = endPlateLngDesc;
	}

	public String getEndPlateLatDesc() {
		return endPlateLatDesc;
	}

	public void setEndPlateLatDesc(String endPlateLatDesc) {
		this.endPlateLatDesc = endPlateLatDesc;
	}

	public String getGetOrderPlateLngDesc() {
		return getOrderPlateLngDesc;
	}

	public void setGetOrderPlateLngDesc(String getOrderPlateLngDesc) {
		this.getOrderPlateLngDesc = getOrderPlateLngDesc;
	}

	public String getGetOrderPlateLatDesc() {
		return getOrderPlateLatDesc;
	}

	public void setGetOrderPlateLatDesc(String getOrderPlateLatDesc) {
		this.getOrderPlateLatDesc = getOrderPlateLatDesc;
	}

	public String getDetachableDesc() {
		return detachableDesc;
	}

	public void setDetachableDesc(String detachableDesc) {
		this.detachableDesc = detachableDesc;
	}

	public String getIfInfoCompleteDesc() {
		return ifInfoCompleteDesc;
	}

	public void setIfInfoCompleteDesc(String ifInfoCompleteDesc) {
		this.ifInfoCompleteDesc = ifInfoCompleteDesc;
	}

	public String getChargePriceTypedesc() {
		return chargePriceTypedesc;
	}

	public void setChargePriceTypedesc(String chargePriceTypedesc) {
		this.chargePriceTypedesc = chargePriceTypedesc;
	}

	public String getAppointType() {
		return appointType;
	}

	public void setAppointType(String appointType) {
		this.appointType = appointType;
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIfOwnerTaxpriceMf() {
		return ifOwnerTaxpriceMf;
	}

	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}

	public String getFlagTax() {
		return flagTax;
	}

	public void setFlagTax(String flagTax) {
		this.flagTax = flagTax;
	}

	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}

	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}

	public String getIsAutoToTrans() {
		return isAutoToTrans;
	}

	public void setIsAutoToTrans(String isAutoToTrans) {
		this.isAutoToTrans = isAutoToTrans;
	}

	public String getCarStyle() {
		return carStyle;
	}

	public void setCarStyle(String carStyle) {
		this.carStyle = carStyle;
	}

	public String getIfShow() {
		return ifShow;
	}

	public void setIfShow(String ifShow) {
		this.ifShow = ifShow;
	}

	public BigDecimal getSendWeight() {
		return sendWeight;
	}

	public void setSendWeight(BigDecimal sendWeight) {
		this.sendWeight = sendWeight;
	}

	public String getOwnerAdjustType() {
		return ownerAdjustType;
	}

	public void setOwnerAdjustType(String ownerAdjustType) {
		this.ownerAdjustType = ownerAdjustType;
	}

	public BigDecimal getOwnerAdjustAmt() {
		return ownerAdjustAmt;
	}

	public void setOwnerAdjustAmt(BigDecimal ownerAdjustAmt) {
		this.ownerAdjustAmt = ownerAdjustAmt;
	}

	public BigDecimal getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(BigDecimal curPrice) {
		this.curPrice = curPrice;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getImportIdTax() {
		return importIdTax;
	}

	public void setImportIdTax(String importIdTax) {
		this.importIdTax = importIdTax;
	}

	public Long getPriPublishId() {
		return priPublishId;
	}

	public void setPriPublishId(Long priPublishId) {
		this.priPublishId = priPublishId;
	}

	public String getDocuPriSec() {
		return docuPriSec;
	}

	public void setDocuPriSec(String docuPriSec) {
		this.docuPriSec = docuPriSec;
	}

	public Integer getCombinedNumber() {
		return combinedNumber;
	}

	public void setCombinedNumber(Integer combinedNumber) {
		this.combinedNumber = combinedNumber;
	}

	public Long getCredAdjDId() {
		return credAdjDId;
	}

	public void setCredAdjDId(Long credAdjDId) {
		this.credAdjDId = credAdjDId;
	}

	public Integer getBidTimes() {
		return bidTimes;
	}

	public void setBidTimes(Integer bidTimes) {
		this.bidTimes = bidTimes;
	}

	public String getAppointTeamName() {
		return appointTeamName;
	}

	public void setAppointTeamName(String appointTeamName) {
		this.appointTeamName = appointTeamName;
	}

	public String getCompanyMobile() {
		return companyMobile;
	}

	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}

	public String getIfZntjFlag() {
		return ifZntjFlag;
	}

	public void setIfZntjFlag(String ifZntjFlag) {
		this.ifZntjFlag = ifZntjFlag;
	}

	public String getDqFlag() {
		return dqFlag;
	}

	public void setDqFlag(String dqFlag) {
		this.dqFlag = dqFlag;
	}

	public Date getRobDayTime() {
		return robDayTime;
	}

	public void setRobDayTime(Date robDayTime) {
		this.robDayTime = robDayTime;
	}

	public Date getRobEndTime() {
		return robEndTime;
	}

	public void setRobEndTime(Date robEndTime) {
		this.robEndTime = robEndTime;
	}

	@Override
	public Long getCatalogId() {
		return catalogId;
	}

	@Override
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String getCatalogName() {
		return catalogName;
	}

	@Override
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getQdFlag() {
		return qdFlag;
	}

	public void setQdFlag(String qdFlag) {
		this.qdFlag = qdFlag;
	}

	@Override
	public String getContractNumber() {
		return contractNumber;
	}

	@Override
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getAddWeightType() {
		return addWeightType;
	}

	public void setAddWeightType(String addWeightType) {
		this.addWeightType = addWeightType;
	}

	public Long getFdCompanyId() {
		return fdCompanyId;
	}

	public void setFdCompanyId(Long fdCompanyId) {
		this.fdCompanyId = fdCompanyId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
}
