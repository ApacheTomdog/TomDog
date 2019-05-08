package com.brcc.business.goodsorderm.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

/**
 * @author PanJianYang
 * @version 创建时间：2018年10月30日 下午8:56:55
 * @Description 平台货源单查询条件信息
 */
public class GoodsordermQueryVo extends BaseQueryVo {
	// 货源单号
	private Long orderId;
	// 货源单号
	private Long priPublishId;
	private Long publishId;
	// 货源单号
	// 登陆者的性质
	private String ifShowAdmin;
	// 公司id
	private Long companyId;
	//公司名字
	private String companyName;
	// 流程名
	private String vatFlowMasterName;
	// 车牌号
	private String carNum;
	// 定向组
	private String appointTeam;
	// 可抢单量最小值
	private BigDecimal getAmountS;
	// 是否委托承运
	private String taxTransport;
	// 自动调价标记
	private String ownerAdjustFlag;
	// 可抢单量最大值
	private BigDecimal getAmountE;
	// 委托人
	private String billSender;
	// 货源单状态
	private String status;
	//起始地
	private String startPlate;
	// 取单地
	private String getOrderPlate;
	// 目的地
	private String endPlate;
	// 创建开始时间
	private Date rqStart;
	// 创建结束时间
	private Date rqEnd;
	// 货源单号
	private Long publishIdD;
	// 业务单号
	private String dependNum;
	// 品种代码
	private Integer goodType;
	// 单据来源
	private String fromType;
	//是否显示
	private String isAutoDisplay;
	//平台id
	private String platformId;
	//账号来源
	private String accountFrom;
	//导出类型
	private String excelType;
	//发单人的userid
	private Integer fdUserId;
	//父级公司id
	private Long parentCompanyId;
	//查询货源单明细类型
	private String type;
	//判断是否为委托承运类型的
	private String orderTaxDetail;
	// 外部货源单据号
	private Long importId;
	// 拼单号
	private String pinDanNum;
	// 是否拼单
	private String pinDan;
	// 货品描述
	private String prodDesc;
	// 单据类型
	private String docuType;
	// 是否报价
	private String talkPrice;
	// 是否电商结算
	private String dsIfSettle;
	// 是否可拆单
	private String detachable;
	// 是否含税运输
	private String ifTaxTransport;
	private String goodsType;
	// 修改后的价格
	private BigDecimal newPrice;
	private BigDecimal newLossRatio;
	private BigDecimal newLossWeight;
	private String newLossType;
	private BigDecimal goodPrice;
	private BigDecimal lossRatio;
	private BigDecimal lossWeight;
	private String lossType;
	// 是否投放给所有平台承运人（Y 是、N 否）
	private String IfAllCompany;
	// 是否冻结
	private String IfFreeze;
	// 是否否可抢单
	private String IfGrab;
	// 大品种id
	private Long catalogId;
	//含税单价是否抹零
	private String ifOwnerTaxpriceMf;
	//集团号
	private Long groupId;
	//集团名字
	private String groupName;
	// 是否是经纪人
	private String ifBrokerPeople;
	//限制货源单的导出条数防止内存溢出
	private Integer fromRow;
	private Integer toRow;
	//单车重量
/*	private  BigDecimal singleCarWeight;

	public BigDecimal getSingleCarWeight() {
		return singleCarWeight;
	}

	public void setSingleCarWeight(BigDecimal singleCarWeight) {
		this.singleCarWeight = singleCarWeight;
	}*/

	//货源查看方式
	private String goodsSet;

	//合同编号
	private String contractNumber;


	public String getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(String goodsSet) {
		this.goodsSet = goodsSet;
	}

	public Integer getFromRow() {
		return fromRow;
	}

	public void setFromRow(Integer fromRow) {
		this.fromRow = fromRow;
	}

	public Integer getToRow() {
		return toRow;
	}

	public void setToRow(Integer toRow) {
		this.toRow = toRow;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public Long getImportId() {
		return importId;
	}

	public void setImportId(Long importId) {
		this.importId = importId;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}

	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}

	public Long getPublishIdD() {
		return publishIdD;
	}

	public void setPublishIdD(Long publishIdD) {
		this.publishIdD = publishIdD;
	}

	public String getDependNum() {
		return dependNum;
	}

	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}

	public Integer getGoodType() {
		return goodType;
	}

	public void setGoodType(Integer goodType) {
		this.goodType = goodType;
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

	public String getPinDan() {
		return pinDan;
	}

	public void setPinDan(String pinDan) {
		this.pinDan = pinDan;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getDocuType() {
		return docuType;
	}

	public void setDocuType(String docuType) {
		this.docuType = docuType;
	}

	public String getTalkPrice() {
		return talkPrice;
	}

	public void setTalkPrice(String talkPrice) {
		this.talkPrice = talkPrice;
	}

	public String getDsIfSettle() {
		return dsIfSettle;
	}

	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
	}

	public String getDetachable() {
		return detachable;
	}

	public void setDetachable(String detachable) {
		this.detachable = detachable;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public String getIfShowAdmin() {
		return ifShowAdmin;
	}

	public void setIfShowAdmin(String ifShowAdmin) {
		this.ifShowAdmin = ifShowAdmin;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getVatFlowMasterName() {
		return vatFlowMasterName;
	}

	public void setVatFlowMasterName(String vatFlowMasterName) {
		this.vatFlowMasterName = vatFlowMasterName;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getAppointTeam() {
		return appointTeam;
	}

	public void setAppointTeam(String appointTeam) {
		this.appointTeam = appointTeam;
	}

	public BigDecimal getGetAmountS() {
		return getAmountS;
	}

	public void setGetAmountS(BigDecimal getAmountS) {
		this.getAmountS = getAmountS;
	}

	public String getTaxTransport() {
		return taxTransport;
	}

	public void setTaxTransport(String taxTransport) {
		this.taxTransport = taxTransport;
	}

	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}

	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
	}

	public BigDecimal getGetAmountE() {
		return getAmountE;
	}

	public void setGetAmountE(BigDecimal getAmountE) {
		this.getAmountE = getAmountE;
	}

	public String getBillSender() {
		return billSender;
	}

	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGetOrderPlate() {
		return getOrderPlate;
	}

	public void setGetOrderPlate(String getOrderPlate) {
		this.getOrderPlate = getOrderPlate;
	}

	public String getEndPlate() {
		return endPlate;
	}

	public void setEndPlate(String endPlate) {
		this.endPlate = endPlate;
	}
	
	public String getStartPlate() {
		return startPlate;
	}

	public void setStartPlate(String startPlate) {
		this.startPlate = startPlate;
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

	public String getExcelType() {
		return excelType;
	}

	public void setExcelType(String excelType) {
		this.excelType = excelType;
	}

	public Integer getFdUserId() {
		return fdUserId;
	}

	public void setFdUserId(Integer fdUserId) {
		this.fdUserId = fdUserId;
	}

	public Long getParentCompanyId() {
		return parentCompanyId;
	}

	public void setParentCompanyId(Long parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderTaxDetail() {
		return orderTaxDetail;
	}

	public void setOrderTaxDetail(String orderTaxDetail) {
		this.orderTaxDetail = orderTaxDetail;
	}

	public BigDecimal getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	public String getIfOwnerTaxpriceMf() {
		return ifOwnerTaxpriceMf;
	}

	public void setIfOwnerTaxpriceMf(String ifOwnerTaxpriceMf) {
		this.ifOwnerTaxpriceMf = ifOwnerTaxpriceMf;
	}


	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public BigDecimal getNewLossRatio() {
		return newLossRatio;
	}

	public void setNewLossRatio(BigDecimal newLossRatio) {
		this.newLossRatio = newLossRatio;
	}

	public BigDecimal getNewLossWeight() {
		return newLossWeight;
	}

	public void setNewLossWeight(BigDecimal newLossWeight) {
		this.newLossWeight = newLossWeight;
	}

	public String getNewLossType() {
		return newLossType;
	}

	public void setNewLossType(String newLossType) {
		this.newLossType = newLossType;
	}

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public BigDecimal getLossRatio() {
		return lossRatio;
	}

	public void setLossRatio(BigDecimal lossRatio) {
		this.lossRatio = lossRatio;
	}

	public BigDecimal getLossWeight() {
		return lossWeight;
	}

	public void setLossWeight(BigDecimal lossWeight) {
		this.lossWeight = lossWeight;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIfAllCompany() {
		return IfAllCompany;
	}

	public void setIfAllCompany(String ifAllCompany) {
		IfAllCompany = ifAllCompany;
	}

	public String getIfFreeze() {
		return IfFreeze;
	}

	public void setIfFreeze(String ifFreeze) {
		IfFreeze = ifFreeze;
	}

	public String getIfGrab() {
		return IfGrab;
	}

	public void setIfGrab(String ifGrab) {
		IfGrab = ifGrab;
	}

	public Long getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getIfBrokerPeople() {
		return ifBrokerPeople;
	}

	public void setIfBrokerPeople(String ifBrokerPeople) {
		this.ifBrokerPeople = ifBrokerPeople;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Long getPriPublishId() {
		return priPublishId;
	}

	public void setPriPublishId(Long priPublishId) {
		this.priPublishId = priPublishId;
	}
	
}
