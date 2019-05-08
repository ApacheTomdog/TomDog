package com.brcc.business.transportbill.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.esteel.common.vo.BaseQueryVo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:26
 */
public class TransportBillQueryVo extends BaseQueryVo {

	private String platformId;
	private Long companyId;
	private String consignorName;
	private String ifShowAdmin;
	private String accountFrom;
	private Long fdUserId;
	private Boolean ifPayment;
	private Boolean ifCan;
	private String isAutoDisplay;
	private String ifBrokerPeopleTollFlag;
	private String billSender;
	private Long deliveryId;
	private Long transportationdeliveryId;
	private Long payPublishId;
	private String accessFlag;
	private String dependNum;
	private String settleflag;
	private String settleStatus;
	private String name;
	private String vehicleNum;
	private String ps;
	private Long transId;
	private String companyName;
	private String invoiceNo;
	private Long publishId;
	private Boolean pinDan;
	private String ifPaid;
	private String carriCompany;
	private Boolean earlyWarning;
	private Date rqStart;
	private Date rqEnd;
	private Date receRqStart;
	private Date receRqEnd;
	private String startPlate;
	private String endPlate;
	private String status;
	private String fromType;
	private String deFlag;
	private String iffly;
	private String sender;
	private String prodDesc;
	private String dsIfSettle;
	//是否委托托运
	private String ifTaxTransport;
	private String ifSaveImage;
	private String goodTypeDesc;
	private String settlePage;
	private String ifInvoice;
	//计算备注
	private String jsRemark;
	//图片路径
	private String imgPath;
	//计算单id
    private Long zfId;
    
    // 接收运费计算页面提交数据
    private Long publishCompanyId;
	private String publishCompanyName;
	private Long payCompanyId;
	private String payCompanyName;
	private Long driverCompanyId;
	private String goodType;
	private BigDecimal price;
	private BigDecimal settleWeight;
	private BigDecimal takeDeliveryWeight;
	private BigDecimal truckLoadingWeight;
	private BigDecimal goodPrice;
	private BigDecimal lossRatio;
	private BigDecimal lossWeight;
	private BigDecimal lossTons;
	private BigDecimal deductAmount;
	private BigDecimal payAmount;
	private String remark;
	private String lossType;
	private Long driverId;
	private String driverName;
	private Long vehicleId;
	private Date createDate;
	private String goodTypeName;
	private Date finishTime;
	private BigDecimal oilAmount;
	private BigDecimal transAmount;
	private BigDecimal oilRatio;
	private Long oilCardId;
	private String oilCardName;
	private String jsType;
	private String oilFlag;
	private BigDecimal chargePriceTotal;
	private BigDecimal chargePrice;
	private String chargePriceType;
	private BigDecimal creditPrice;
	private BigDecimal transportationAmount;
	private BigDecimal eraseAmount;
	private String ownerAdjustFlag;
	private String ownerAdjustType;
	private BigDecimal ownerAdjustAmt;
	private BigDecimal ownerAdjustAmount;
	private String ifDumpTruckCharge;
	private BigDecimal dumpTruckCharge;
	private String ifSameFlag;
	private Long createCompanyId;
	private String createCompanyName;
	private Long groupId;
	private String groupName;
	private String receBankType;
	private String ifOwnerLoss;

	//处理标记
	private String otherFlag;

	//是否飞单
	private Boolean feidan;

    //货主
    private String goodOwner;

    //委托人
    private String wtBillSender;

    //创建时间 开始
    Date startCreateDate;

    //创建时间 结束
    Date endCreateDate;

    private Long vatCarryId;

    //取单地
    private String getOrderPlate;

    //完成时间 查询
    Date startFinishTime;
    Date endFinishTime;

    //装车重量是否维护
    Boolean ifHaveZcWeight;
    //收货重量是否维护
    Boolean ifHaveShWeight;

    //司机状态
    private String driverStatus;

    //司机是否登记工商注册信息
    private Boolean ifBusinessInfo;

    //是否是工商户
    private Boolean ifGsInfo;

    //最后付款人
    private String finallyPay;
    //业务备注
  	private String businessMemo;
  	//付款申请标记
  	private String ownerPayapplyFlag;
    //访问渠道 plat publisher carrier
  	private String channel;
    //付款申请批量撤销审核
  	private String zfIdStr;
  	private String orderPlate;

  	private String zcWeightFrom;

  	private String payType;

	private String brokerPeopleType;

	private BigDecimal tollAmount;

	private BigDecimal tollRatio;

	private String deliveryIds;

	private String payStatus;
	private String ownerPayApplyFlag;
	
	// 批量运费计算
	private Integer settleWeightType;
	private Integer payAmountType;
	private BigDecimal minPayAmount;
	private BigDecimal maxPayAmount;
	private Integer deductType;
	private BigDecimal deductWeight;
	private BigDecimal deductRatio;

	private Integer bankIfSettleFlag;
	
	private String goodsOwnerPs;

	public String getGoodsOwnerPs() {
		return goodsOwnerPs;
	}

	public void setGoodsOwnerPs(String goodsOwnerPs) {
		this.goodsOwnerPs = goodsOwnerPs;
	}
	
	private String signStatus;
	
	private Date signTime;
	
	private Long signPersonId;
	
	private String signPersonName;
	//合同编号
	private String contractNumber;

	//合同类型
	private String contractType;


	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Long getSignPersonId() {
		return signPersonId;
	}

	public void setSignPersonId(Long signPersonId) {
		this.signPersonId = signPersonId;
	}

	public String getSignPersonName() {
		return signPersonName;
	}

	public void setSignPersonName(String signPersonName) {
		this.signPersonName = signPersonName;
	}

	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}

	public Integer getBankIfSettleFlag() {
		return bankIfSettleFlag;
	}

	public void setBankIfSettleFlag(Integer bankIfSettleFlag) {
		this.bankIfSettleFlag = bankIfSettleFlag;
	}

	private String mWeightFlags;	
	// 批量修改标记(经纪人运费分配调整区分单条和批量,Y代表批量)
    private String batchFlag;
    // 平台经纪人分润常规比率
    private BigDecimal normalRate;

	public String getIfOwnerLoss() {
		return ifOwnerLoss;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public void setIfOwnerLoss(String ifOwnerLoss) {
		this.ifOwnerLoss = ifOwnerLoss;
	}

	public BigDecimal getLossTons() {
		return lossTons;
	}

	public void setLossTons(BigDecimal lossTons) {
		this.lossTons = lossTons;
	}

	public Integer getSettleWeightType() {
		return settleWeightType;
	}

	public void setSettleWeightType(Integer settleWeightType) {
		this.settleWeightType = settleWeightType;
	}

	public Integer getPayAmountType() {
		return payAmountType;
	}

	public void setPayAmountType(Integer payAmountType) {
		this.payAmountType = payAmountType;
	}

	public BigDecimal getMinPayAmount() {
		return minPayAmount;
	}

	public void setMinPayAmount(BigDecimal minPayAmount) {
		this.minPayAmount = minPayAmount;
	}

	public BigDecimal getMaxPayAmount() {
		return maxPayAmount;
	}

	public void setMaxPayAmount(BigDecimal maxPayAmount) {
		this.maxPayAmount = maxPayAmount;
	}

	public Integer getDeductType() {
		return deductType;
	}

	public void setDeductType(Integer deductType) {
		this.deductType = deductType;
	}

	public BigDecimal getDeductWeight() {
		return deductWeight;
	}

	public void setDeductWeight(BigDecimal deductWeight) {
		this.deductWeight = deductWeight;
	}

	public BigDecimal getDeductRatio() {
		return deductRatio;
	}

	public void setDeductRatio(BigDecimal deductRatio) {
		this.deductRatio = deductRatio;
	}

	public String getmWeightFlags() {
		return mWeightFlags;
	}

	public void setmWeightFlags(String mWeightFlags) {
		this.mWeightFlags = mWeightFlags;
	}

	public String getDeliveryIds() {
		return deliveryIds;
	}

	public void setDeliveryIds(String deliveryIds) {
		this.deliveryIds = deliveryIds;
	}

	public String getBrokerPeopleType() {
		return brokerPeopleType;
	}

	public void setBrokerPeopleType(String brokerPeopleType) {
		this.brokerPeopleType = brokerPeopleType;
	}

	public BigDecimal getTollAmount() {
		return tollAmount;
	}

	public void setTollAmount(BigDecimal tollAmount) {
		this.tollAmount = tollAmount;
	}

	public BigDecimal getTollRatio() {
		return tollRatio;
	}

	public void setTollRatio(BigDecimal tollRatio) {
		this.tollRatio = tollRatio;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getZcWeightFrom() {
		return zcWeightFrom;
	}

	public void setZcWeightFrom(String zcWeightFrom) {
		this.zcWeightFrom = zcWeightFrom;
	}

	public String getZfIdStr() {
		return zfIdStr;
	}
	public void setZfIdStr(String zfIdStr) {
		this.zfIdStr = zfIdStr;
	}

    // 回单图片
    private String comfirmPic1Local;

	public String getComfirmPic1Local() {
		return comfirmPic1Local;
	}

	public void setComfirmPic1Local(String comfirmPic1Local) {
		this.comfirmPic1Local = comfirmPic1Local;
	}

	public String getOrderPlate() {
        return orderPlate;
    }

    public void setOrderPlate(String orderPlate) {
        this.orderPlate = orderPlate;
    }

    public String getOwnerPayapplyFlag() {
		return ownerPayapplyFlag;
	}
	public void setOwnerPayapplyFlag(String ownerPayapplyFlag) {
		this.ownerPayapplyFlag = ownerPayapplyFlag;
	}
    public String getBusinessMemo() {
		return businessMemo;
	}
	public void setBusinessMemo(String businessMemo) {
		this.businessMemo = businessMemo;
	}
	public String getReceBankType() {
		return receBankType;
	}
	public void setReceBankType(String receBankType) {
		this.receBankType = receBankType;
	}
	public Long getPublishCompanyId() {
		return publishCompanyId;
	}
	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}
	public String getPublishCompanyName() {
		return publishCompanyName;
	}
	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
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
	public Long getDriverCompanyId() {
		return driverCompanyId;
	}
	public void setDriverCompanyId(Long driverCompanyId) {
		this.driverCompanyId = driverCompanyId;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSettleWeight() {
		return settleWeight;
	}
	public void setSettleWeight(BigDecimal settleWeight) {
		this.settleWeight = settleWeight;
	}
	public BigDecimal getTakeDeliveryWeight() {
		return takeDeliveryWeight;
	}
	public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
		this.takeDeliveryWeight = takeDeliveryWeight;
	}
	public BigDecimal getTruckLoadingWeight() {
		return truckLoadingWeight;
	}
	public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
		this.truckLoadingWeight = truckLoadingWeight;
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
	public BigDecimal getDeductAmount() {
		return deductAmount;
	}
	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLossType() {
		return lossType;
	}
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
	public Long getDriverId() {
		return driverId;
	}
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getGoodTypeName() {
		return goodTypeName;
	}
	public void setGoodTypeName(String goodTypeName) {
		this.goodTypeName = goodTypeName;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public BigDecimal getOilAmount() {
		return oilAmount;
	}
	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}
	public BigDecimal getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(BigDecimal transAmount) {
		this.transAmount = transAmount;
	}
	public BigDecimal getOilRatio() {
		return oilRatio;
	}
	public void setOilRatio(BigDecimal oilRatio) {
		this.oilRatio = oilRatio;
	}
	public Long getOilCardId() {
		return oilCardId;
	}
	public void setOilCardId(Long oilCardId) {
		this.oilCardId = oilCardId;
	}
	public String getOilCardName() {
		return oilCardName;
	}
	public void setOilCardName(String oilCardName) {
		this.oilCardName = oilCardName;
	}
	public String getJsType() {
		return jsType;
	}
	public void setJsType(String jsType) {
		this.jsType = jsType;
	}
	public String getOilFlag() {
		return oilFlag;
	}
	public void setOilFlag(String oilFlag) {
		this.oilFlag = oilFlag;
	}
	public BigDecimal getChargePriceTotal() {
		return chargePriceTotal;
	}
	public void setChargePriceTotal(BigDecimal chargePriceTotal) {
		this.chargePriceTotal = chargePriceTotal;
	}
	public BigDecimal getChargePrice() {
		return chargePrice;
	}
	public void setChargePrice(BigDecimal chargePrice) {
		this.chargePrice = chargePrice;
	}
	public String getChargePriceType() {
		return chargePriceType;
	}
	public void setChargePriceType(String chargePriceType) {
		this.chargePriceType = chargePriceType;
	}
	public BigDecimal getCreditPrice() {
		return creditPrice;
	}
	public void setCreditPrice(BigDecimal creditPrice) {
		this.creditPrice = creditPrice;
	}
	public BigDecimal getTransportationAmount() {
		return transportationAmount;
	}
	public void setTransportationAmount(BigDecimal transportationAmount) {
		this.transportationAmount = transportationAmount;
	}
	public BigDecimal getEraseAmount() {
		return eraseAmount;
	}
	public void setEraseAmount(BigDecimal eraseAmount) {
		this.eraseAmount = eraseAmount;
	}
	public String getOwnerAdjustFlag() {
		return ownerAdjustFlag;
	}
	public void setOwnerAdjustFlag(String ownerAdjustFlag) {
		this.ownerAdjustFlag = ownerAdjustFlag;
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
	public BigDecimal getOwnerAdjustAmount() {
		return ownerAdjustAmount;
	}
	public void setOwnerAdjustAmount(BigDecimal ownerAdjustAmount) {
		this.ownerAdjustAmount = ownerAdjustAmount;
	}
	public String getIfDumpTruckCharge() {
		return ifDumpTruckCharge;
	}
	public void setIfDumpTruckCharge(String ifDumpTruckCharge) {
		this.ifDumpTruckCharge = ifDumpTruckCharge;
	}
	public BigDecimal getDumpTruckCharge() {
		return dumpTruckCharge;
	}
	public void setDumpTruckCharge(BigDecimal dumpTruckCharge) {
		this.dumpTruckCharge = dumpTruckCharge;
	}
	public String getIfSameFlag() {
		return ifSameFlag;
	}
	public void setIfSameFlag(String ifSameFlag) {
		this.ifSameFlag = ifSameFlag;
	}
	public Long getCreateCompanyId() {
		return createCompanyId;
	}
	public void setCreateCompanyId(Long createCompanyId) {
		this.createCompanyId = createCompanyId;
	}
	public String getCreateCompanyName() {
		return createCompanyName;
	}
	public void setCreateCompanyName(String createCompanyName) {
		this.createCompanyName = createCompanyName;
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
	public Long getTransportationdeliveryId() {
		return transportationdeliveryId;
	}
	public void setTransportationdeliveryId(Long transportationdeliveryId) {
		this.transportationdeliveryId = transportationdeliveryId;
	}
	public Long getZfId() {
		return zfId;
	}
	public void setZfId(Long zfId) {
		this.zfId = zfId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getJsRemark() {
		return jsRemark;
	}
	public void setJsRemark(String jsRemark) {
		this.jsRemark = jsRemark;
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
	public Date getReceRqStart() {
		return receRqStart;
	}
	public void setReceRqStart(Date receRqStart) {
		this.receRqStart = receRqStart;
	}
	public Date getReceRqEnd() {
		return receRqEnd;
	}
	public void setReceRqEnd(Date receRqEnd) {
		this.receRqEnd = receRqEnd;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getFdUserId() {
		return fdUserId;
	}
	public void setFdUserId(Long fdUserId) {
		this.fdUserId = fdUserId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getPayPublishId() {
		return payPublishId;
	}
	public void setPayPublishId(Long payPublishId) {
		this.payPublishId = payPublishId;
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
	public String getIfInvoice() {
		return ifInvoice;
	}
	public void setIfInvoice(String ifInvoice) {
		this.ifInvoice = ifInvoice;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	public String getIfShowAdmin() {
		return ifShowAdmin;
	}
	public void setIfShowAdmin(String ifShowAdmin) {
		this.ifShowAdmin = ifShowAdmin;
	}
	public String getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}
	
	public Boolean getIfPayment() {
		return ifPayment;
	}
	public void setIfPayment(Boolean ifPayment) {
		this.ifPayment = ifPayment;
	}
	public Boolean getIfCan() {
		return ifCan;
	}
	public void setIfCan(Boolean ifCan) {
		this.ifCan = ifCan;
	}
	public String getIsAutoDisplay() {
		return isAutoDisplay;
	}
	public void setIsAutoDisplay(String isAutoDisplay) {
		this.isAutoDisplay = isAutoDisplay;
	}
	public String getIfBrokerPeopleTollFlag() {
		return ifBrokerPeopleTollFlag;
	}
	public void setIfBrokerPeopleTollFlag(String ifBrokerPeopleTollFlag) {
		this.ifBrokerPeopleTollFlag = ifBrokerPeopleTollFlag;
	}
	public String getBillSender() {
		return billSender;
	}
	public void setBillSender(String billSender) {
		this.billSender = billSender;
	}
	
	public String getAccessFlag() {
		return accessFlag;
	}
	public void setAccessFlag(String accessFlag) {
		this.accessFlag = accessFlag;
	}
	public String getDependNum() {
		return dependNum;
	}
	public void setDependNum(String dependNum) {
		this.dependNum = dependNum;
	}
	public String getSettleflag() {
		return settleflag;
	}
	public void setSettleflag(String settleflag) {
		this.settleflag = settleflag;
	}
	public String getSettleStatus() {
		return settleStatus;
	}
	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	public Boolean getPinDan() {
		return pinDan;
	}
	public void setPinDan(Boolean pinDan) {
		this.pinDan = pinDan;
	}
	public String getIfPaid() {
		return ifPaid;
	}
	public void setIfPaid(String ifPaid) {
		this.ifPaid = ifPaid;
	}
	public String getCarriCompany() {
		return carriCompany;
	}
	public void setCarriCompany(String carriCompany) {
		this.carriCompany = carriCompany;
	}
	public Boolean getEarlyWarning() {
		return earlyWarning;
	}
	public void setEarlyWarning(Boolean earlyWarning) {
		this.earlyWarning = earlyWarning;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public String getDeFlag() {
		return deFlag;
	}
	public void setDeFlag(String deFlag) {
		this.deFlag = deFlag;
	}
	public String getIffly() {
		return iffly;
	}
	public void setIffly(String iffly) {
		this.iffly = iffly;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getDsIfSettle() {
		return dsIfSettle;
	}
	public void setDsIfSettle(String dsIfSettle) {
		this.dsIfSettle = dsIfSettle;
	}

	public String getIfTaxTransport() {
		return ifTaxTransport;
	}

	public void setIfTaxTransport(String ifTaxTransport) {
		this.ifTaxTransport = ifTaxTransport;
	}

	public String getIfSaveImage() {
		return ifSaveImage;
	}
	public void setIfSaveImage(String ifSaveImage) {
		this.ifSaveImage = ifSaveImage;
	}
	public String getGoodTypeDesc() {
		return goodTypeDesc;
	}
	public void setGoodTypeDesc(String goodTypeDesc) {
		this.goodTypeDesc = goodTypeDesc;
	}
	public String getSettlePage() {
		return settlePage;
	}
	public void setSettlePage(String settlePage) {
		this.settlePage = settlePage;
	}

    public String getOtherFlag() {
        return otherFlag;
    }

    public void setOtherFlag(String otherFlag) {
        this.otherFlag = otherFlag;
    }

    public Boolean getFeidan() {
        return feidan;
    }

    public void setFeidan(Boolean feidan) {
        this.feidan = feidan;
    }

    public String getGoodOwner() {
        return goodOwner;
    }

    public void setGoodOwner(String goodOwner) {
        this.goodOwner = goodOwner;
    }

    public String getWtBillSender() {
        return wtBillSender;
    }

    public void setWtBillSender(String wtBillSender) {
        this.wtBillSender = wtBillSender;
    }

    public Date getStartCreateDate() {
        return startCreateDate;
    }

    public void setStartCreateDate(Date startCreateDate) {
        this.startCreateDate = startCreateDate;
    }

    public Date getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public Long getVatCarryId() {
        return vatCarryId;
    }

    public void setVatCarryId(Long vatCarryId) {
        this.vatCarryId = vatCarryId;
    }

    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
    }

    public Date getStartFinishTime() {
        return startFinishTime;
    }

    public void setStartFinishTime(Date startFinishTime) {
        this.startFinishTime = startFinishTime;
    }

    public Date getEndFinishTime() {
        return endFinishTime;
    }

    public void setEndFinishTime(Date endFinishTime) {
        this.endFinishTime = endFinishTime;
    }

    public Boolean getIfHaveZcWeight() {
        return ifHaveZcWeight;
    }

    public void setIfHaveZcWeight(Boolean ifHaveZcWeight) {
        this.ifHaveZcWeight = ifHaveZcWeight;
    }

    public Boolean getIfHaveShWeight() {
        return ifHaveShWeight;
    }

    public void setIfHaveShWeight(Boolean ifHaveShWeight) {
        this.ifHaveShWeight = ifHaveShWeight;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Boolean getIfBusinessInfo() {
        return ifBusinessInfo;
    }

    public void setIfBusinessInfo(Boolean ifBusinessInfo) {
        this.ifBusinessInfo = ifBusinessInfo;
    }

    public Boolean getIfGsInfo() {
        return ifGsInfo;
    }

    public void setIfGsInfo(Boolean ifGsInfo) {
        this.ifGsInfo = ifGsInfo;
    }

    public String getFinallyPay() {
        return finallyPay;
    }

    public void setFinallyPay(String finallyPay) {
        this.finallyPay = finallyPay;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getOwnerPayApplyFlag() {
		return ownerPayApplyFlag;
	}

	public void setOwnerPayApplyFlag(String ownerPayApplyFlag) {
		this.ownerPayApplyFlag = ownerPayApplyFlag;
	}

	public String getBatchFlag() {
		return batchFlag;
	}

	public void setBatchFlag(String batchFlag) {
		this.batchFlag = batchFlag;
	}

	public BigDecimal getNormalRate() {
		return normalRate;
	}

	public void setNormalRate(BigDecimal normalRate) {
		this.normalRate = normalRate;
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
