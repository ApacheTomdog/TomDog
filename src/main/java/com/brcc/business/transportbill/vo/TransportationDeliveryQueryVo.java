package com.brcc.business.transportbill.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 调度单预警列表查询条件封装类
 * @Auther: gemaochao
 * @Date:Created in 10:27 2018/12/5
 */
public class TransportationDeliveryQueryVo extends BaseQueryVo {
    private Long deliveryId;
    private String deliveryNum;
    private String publishNum;
    private Long transId;
    private String transNum;
    private Double weight;
    private Double amount;
    private Date createDate;
    private String businessMode;
    private String robDeliveryType;

    public String getBusinessMode() {
        return businessMode;
    }

    public void setBusinessMode(String businessMode) {
        this.businessMode = businessMode;
    }

    public String getRobDeliveryType() {
        return robDeliveryType;
    }

    public void setRobDeliveryType(String robDeliveryType) {
        this.robDeliveryType = robDeliveryType;
    }

    private Long companyId;
    private String startPlate;
    private String endPlate;
    private Long driverId;
    private Long vehicleId;
    private String createPerson;
    private String platformId;
    private String status;
    private Double departureLng;
    private Double departureLat;
    private Double destinationLng;
    private Double destinationLat;
    private Double getOrderAddressLng;
    private Double getOrderAddressLat;
    private String getOrderPlate;
    private String departure;
    private String destination;
    private String getOrderAddress;
    private String sender;
    private String senderMobile;
    private String receiverMobile;
    private String receiver;
    private String billSender;
    private String billSenderMobile;
    private String billTaker;
    private String billTakerMobile;
    private String updateDate;
    private String updatePerson;
    private Long goodType;
    private String goodTypeDesc;
    private Double qty;
    private Double price;
    private Date pickupDate;
    private Date billTime;
    private Date deliveryTime;
    private Date finishTime;
    private Long publishCompanyId;
    private String operateType;
    private String docuSource;
    private Double settleWeight;
    private Double settlePrice;
    private Double settleAmount;
    private String ortherFlag;
    private String loadingId;
    private String ifDriverJudge;
    private String ifFdJudge;
    private String verifyCode;
    private Long fdUserId;
    private String ifCanShow;
    private String ifFeidan;
    private String comfirmPicLocal;
    private String comfirmPicRemote;
    private String receiptVerifyCode;
    private Date receiptOperDate;
    private String remark;
    private Date zcSureDate;
    private Date shSureDate;
    private Double truckLoadingWeight;
    private Double takeDeliveryWeight;
    private String settleStatus;
    private String oilCardNo;
    private Double oilCardAmount;
    private String zfId;
    private String zfNum;
    private Long carryCompanyId;
    private String insuranceFlag;
    private String insuranceNo;
    private Double insuranceAmount;
    private String comfirmPic1Local;
    private String comfirmPic1Remote;
    private String comfirmPic2Local;
    private String comfirmPic2Remote;
    private Long priPublishId;
    private String ifCyJudge;
    private String jsRemark;
    private String jsType;
    private BigDecimal oilRatio;
    private String payOidId;
    private String payOidNum;
    private String ifAlreadyPrint;
    private String printPerson;
    private Date dataPrint;
    private String ifSend;
    private String result;
    private String resourceId;
    private String failCode;
    private String failMessage;
    private String jkFinsh;
    private String floatType;
    private Double floatPrice;
    private String ifJkpay;
    private String ifSendlocation;
    private BigDecimal standardTax;
    private BigDecimal priceTax;
    private String ifTaxTransport;
    private Long vatFlowMasterId;
    private String ifUploadReceiptFlag;
    private String ifInvoice;
    private BigDecimal dzZcWeight;
    private Date dzZcTime;
    private String zcWeightFrom;
    private String brokerPeopleTollType;
    private BigDecimal brokerPeopleTollAmount;
    private BigDecimal brokerPeopleTollRatio;
    private String ifBrokerPeopleTollFlag;
    private Long qdShDiffTime;
    private Long groupId;
    private String groupName;
    private Date hdZcShTime;
    private Long hdZcShModifyPersonId;
    private BigDecimal creditPrice;
    private String ownerAdjustFlag;
    private String ownerAdjustType;
    private BigDecimal ownerAdjustAmt;
    private Double infoPrice;
    private String ifZntsFlag;
    private String poundLocation;
    private String poundNum;
    private Date shippingTime;
    private String dzStatus;
    private Date dzStatusUpdateTime;
    private BigDecimal goodPrice;
    private String lossType;
    private BigDecimal lossRatio;
    private BigDecimal lossWeight;

    private String pinDanNum;




    //创建时间
    private Date createDateStart;
    private Date createDateEnd;

    //车牌号
    private String vehicleNum;

    //是否拼单  1拼单  2非拼单
    private String pinDan;

    //单据来源
    private String fromType;

    //处理标记
    private String deFlag;

    // 承运单位
    private String carriCompany;

    //品种描述
    private String prodDesc;

    //单据号
    private String dependNum;
    private String fromPlatName;

    public String getFromPlatName() {
        return fromPlatName;
    }

    public void setFromPlatName(String fromPlatName) {
        this.fromPlatName = fromPlatName;
    }

    private Long publishId;
    private String Card;
    private Date createTime;
    private String companyName;
    private String contactMobile;
    private String contactName;
    private String idNum;
    private String name;
    private String phone;
    private String statusDesc;
    private String ifFly;
    private String totalTime;
    private String dependNum1;
    private String consignorName;

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String card) {
        Card = card;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIfFly() {
        return ifFly;
    }

    public void setIfFly(String ifFly) {
        this.ifFly = ifFly;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getDependNum1() {
        return dependNum1;
    }

    public void setDependNum1(String dependNum1) {
        this.dependNum1 = dependNum1;
    }

    public String getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(String pinDanNum) {
        this.pinDanNum = pinDanNum;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getCarriCompany() {
        return carriCompany;
    }

    public void setCarriCompany(String carriCompany) {
        this.carriCompany = carriCompany;
    }

    public String getDeFlag() {
        return deFlag;
    }

    public void setDeFlag(String deFlag) {
        this.deFlag = deFlag;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getPinDan() {
        return pinDan;
    }

    public void setPinDan(String pinDan) {
        this.pinDan = pinDan;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getReceiptVerifyCode() {
        return receiptVerifyCode;
    }

    public void setReceiptVerifyCode(String receiptVerifyCode) {
        this.receiptVerifyCode = receiptVerifyCode;
    }

    public Date getReceiptOperDate() {
        return receiptOperDate;
    }

    public void setReceiptOperDate(Date receiptOperDate) {
        this.receiptOperDate = receiptOperDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getZcSureDate() {
        return zcSureDate;
    }

    public void setZcSureDate(Date zcSureDate) {
        this.zcSureDate = zcSureDate;
    }

    public Date getShSureDate() {
        return shSureDate;
    }

    public void setShSureDate(Date shSureDate) {
        this.shSureDate = shSureDate;
    }

    public Double getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(Double truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    public Double getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(Double takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public String getOilCardNo() {
        return oilCardNo;
    }

    public void setOilCardNo(String oilCardNo) {
        this.oilCardNo = oilCardNo;
    }

    public Double getOilCardAmount() {
        return oilCardAmount;
    }

    public void setOilCardAmount(Double oilCardAmount) {
        this.oilCardAmount = oilCardAmount;
    }

    public String getZfId() {
        return zfId;
    }

    public void setZfId(String zfId) {
        this.zfId = zfId;
    }

    public String getZfNum() {
        return zfNum;
    }

    public void setZfNum(String zfNum) {
        this.zfNum = zfNum;
    }

    public Long getCarryCompanyId() {
        return carryCompanyId;
    }

    public void setCarryCompanyId(Long carryCompanyId) {
        this.carryCompanyId = carryCompanyId;
    }

    public String getInsuranceFlag() {
        return insuranceFlag;
    }

    public void setInsuranceFlag(String insuranceFlag) {
        this.insuranceFlag = insuranceFlag;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public Double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public String getComfirmPic1Local() {
        return comfirmPic1Local;
    }

    public void setComfirmPic1Local(String comfirmPic1Local) {
        this.comfirmPic1Local = comfirmPic1Local;
    }

    public String getComfirmPic1Remote() {
        return comfirmPic1Remote;
    }

    public void setComfirmPic1Remote(String comfirmPic1Remote) {
        this.comfirmPic1Remote = comfirmPic1Remote;
    }

    public String getComfirmPic2Local() {
        return comfirmPic2Local;
    }

    public void setComfirmPic2Local(String comfirmPic2Local) {
        this.comfirmPic2Local = comfirmPic2Local;
    }

    public String getComfirmPic2Remote() {
        return comfirmPic2Remote;
    }

    public void setComfirmPic2Remote(String comfirmPic2Remote) {
        this.comfirmPic2Remote = comfirmPic2Remote;
    }

    public Long getPriPublishId() {
        return priPublishId;
    }

    public void setPriPublishId(Long priPublishId) {
        this.priPublishId = priPublishId;
    }

    public String getIfCyJudge() {
        return ifCyJudge;
    }

    public void setIfCyJudge(String ifCyJudge) {
        this.ifCyJudge = ifCyJudge;
    }

    public String getJsRemark() {
        return jsRemark;
    }

    public void setJsRemark(String jsRemark) {
        this.jsRemark = jsRemark;
    }

    public String getJsType() {
        return jsType;
    }

    public void setJsType(String jsType) {
        this.jsType = jsType;
    }

    public BigDecimal getOilRatio() {
        return oilRatio;
    }

    public void setOilRatio(BigDecimal oilRatio) {
        this.oilRatio = oilRatio;
    }

    public String getPayOidId() {
        return payOidId;
    }

    public void setPayOidId(String payOidId) {
        this.payOidId = payOidId;
    }

    public String getPayOidNum() {
        return payOidNum;
    }

    public void setPayOidNum(String payOidNum) {
        this.payOidNum = payOidNum;
    }

    public String getIfAlreadyPrint() {
        return ifAlreadyPrint;
    }

    public void setIfAlreadyPrint(String ifAlreadyPrint) {
        this.ifAlreadyPrint = ifAlreadyPrint;
    }

    public String getPrintPerson() {
        return printPerson;
    }

    public void setPrintPerson(String printPerson) {
        this.printPerson = printPerson;
    }

    public Date getDataPrint() {
        return dataPrint;
    }

    public void setDataPrint(Date dataPrint) {
        this.dataPrint = dataPrint;
    }

    public String getIfSend() {
        return ifSend;
    }

    public void setIfSend(String ifSend) {
        this.ifSend = ifSend;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getJkFinsh() {
        return jkFinsh;
    }

    public void setJkFinsh(String jkFinsh) {
        this.jkFinsh = jkFinsh;
    }

    public String getFloatType() {
        return floatType;
    }

    public void setFloatType(String floatType) {
        this.floatType = floatType;
    }

    public Double getFloatPrice() {
        return floatPrice;
    }

    public void setFloatPrice(Double floatPrice) {
        this.floatPrice = floatPrice;
    }

    public String getIfJkpay() {
        return ifJkpay;
    }

    public void setIfJkpay(String ifJkpay) {
        this.ifJkpay = ifJkpay;
    }

    public String getIfSendlocation() {
        return ifSendlocation;
    }

    public void setIfSendlocation(String ifSendlocation) {
        this.ifSendlocation = ifSendlocation;
    }

    public BigDecimal getStandardTax() {
        return standardTax;
    }

    public void setStandardTax(BigDecimal standardTax) {
        this.standardTax = standardTax;
    }

    public BigDecimal getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
    }

    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
    }

    public Long getVatFlowMasterId() {
        return vatFlowMasterId;
    }

    public void setVatFlowMasterId(Long vatFlowMasterId) {
        this.vatFlowMasterId = vatFlowMasterId;
    }

    public String getIfUploadReceiptFlag() {
        return ifUploadReceiptFlag;
    }

    public void setIfUploadReceiptFlag(String ifUploadReceiptFlag) {
        this.ifUploadReceiptFlag = ifUploadReceiptFlag;
    }

    public String getIfInvoice() {
        return ifInvoice;
    }

    public void setIfInvoice(String ifInvoice) {
        this.ifInvoice = ifInvoice;
    }

    public BigDecimal getDzZcWeight() {
        return dzZcWeight;
    }

    public void setDzZcWeight(BigDecimal dzZcWeight) {
        this.dzZcWeight = dzZcWeight;
    }

    public Date getDzZcTime() {
        return dzZcTime;
    }

    public void setDzZcTime(Date dzZcTime) {
        this.dzZcTime = dzZcTime;
    }

    public String getZcWeightFrom() {
        return zcWeightFrom;
    }

    public void setZcWeightFrom(String zcWeightFrom) {
        this.zcWeightFrom = zcWeightFrom;
    }

    public String getBrokerPeopleTollType() {
        return brokerPeopleTollType;
    }

    public void setBrokerPeopleTollType(String brokerPeopleTollType) {
        this.brokerPeopleTollType = brokerPeopleTollType;
    }

    public BigDecimal getBrokerPeopleTollAmount() {
        return brokerPeopleTollAmount;
    }

    public void setBrokerPeopleTollAmount(BigDecimal brokerPeopleTollAmount) {
        this.brokerPeopleTollAmount = brokerPeopleTollAmount;
    }

    public BigDecimal getBrokerPeopleTollRatio() {
        return brokerPeopleTollRatio;
    }

    public void setBrokerPeopleTollRatio(BigDecimal brokerPeopleTollRatio) {
        this.brokerPeopleTollRatio = brokerPeopleTollRatio;
    }

    public String getIfBrokerPeopleTollFlag() {
        return ifBrokerPeopleTollFlag;
    }

    public void setIfBrokerPeopleTollFlag(String ifBrokerPeopleTollFlag) {
        this.ifBrokerPeopleTollFlag = ifBrokerPeopleTollFlag;
    }

    public Long getQdShDiffTime() {
        return qdShDiffTime;
    }

    public void setQdShDiffTime(Long qdShDiffTime) {
        this.qdShDiffTime = qdShDiffTime;
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

    public Date getHdZcShTime() {
        return hdZcShTime;
    }

    public void setHdZcShTime(Date hdZcShTime) {
        this.hdZcShTime = hdZcShTime;
    }

    public Long getHdZcShModifyPersonId() {
        return hdZcShModifyPersonId;
    }

    public void setHdZcShModifyPersonId(Long hdZcShModifyPersonId) {
        this.hdZcShModifyPersonId = hdZcShModifyPersonId;
    }

    public BigDecimal getCreditPrice() {
        return creditPrice;
    }

    public void setCreditPrice(BigDecimal creditPrice) {
        this.creditPrice = creditPrice;
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

    public Double getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(Double infoPrice) {
        this.infoPrice = infoPrice;
    }

    public String getIfZntsFlag() {
        return ifZntsFlag;
    }

    public void setIfZntsFlag(String ifZntsFlag) {
        this.ifZntsFlag = ifZntsFlag;
    }

    public String getPoundLocation() {
        return poundLocation;
    }

    public void setPoundLocation(String poundLocation) {
        this.poundLocation = poundLocation;
    }

    public String getPoundNum() {
        return poundNum;
    }

    public void setPoundNum(String poundNum) {
        this.poundNum = poundNum;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getDzStatus() {
        return dzStatus;
    }

    public void setDzStatus(String dzStatus) {
        this.dzStatus = dzStatus;
    }

    public Date getDzStatusUpdateTime() {
        return dzStatusUpdateTime;
    }

    public void setDzStatusUpdateTime(Date dzStatusUpdateTime) {
        this.dzStatusUpdateTime = dzStatusUpdateTime;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
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

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(String deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(String publishNum) {
        this.publishNum = publishNum;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
    }

    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDepartureLng() {
        return departureLng;
    }

    public void setDepartureLng(Double departureLng) {
        this.departureLng = departureLng;
    }

    public Double getDepartureLat() {
        return departureLat;
    }

    public void setDepartureLat(Double departureLat) {
        this.departureLat = departureLat;
    }

    public Double getDestinationLng() {
        return destinationLng;
    }

    public void setDestinationLng(Double destinationLng) {
        this.destinationLng = destinationLng;
    }

    public Double getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(Double destinationLat) {
        this.destinationLat = destinationLat;
    }

    public Double getGetOrderAddressLng() {
        return getOrderAddressLng;
    }

    public void setGetOrderAddressLng(Double getOrderAddressLng) {
        this.getOrderAddressLng = getOrderAddressLng;
    }

    public Double getGetOrderAddressLat() {
        return getOrderAddressLat;
    }

    public void setGetOrderAddressLat(Double getOrderAddressLat) {
        this.getOrderAddressLat = getOrderAddressLat;
    }

    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getGetOrderAddress() {
        return getOrderAddress;
    }

    public void setGetOrderAddress(String getOrderAddress) {
        this.getOrderAddress = getOrderAddress;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderMobile() {
        return senderMobile;
    }

    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    public String getBillSenderMobile() {
        return billSenderMobile;
    }

    public void setBillSenderMobile(String billSenderMobile) {
        this.billSenderMobile = billSenderMobile;
    }

    public String getBillTaker() {
        return billTaker;
    }

    public void setBillTaker(String billTaker) {
        this.billTaker = billTaker;
    }

    public String getBillTakerMobile() {
        return billTakerMobile;
    }

    public void setBillTakerMobile(String billTakerMobile) {
        this.billTakerMobile = billTakerMobile;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Long getGoodType() {
        return goodType;
    }

    public void setGoodType(Long goodType) {
        this.goodType = goodType;
    }

    public String getGoodTypeDesc() {
        return goodTypeDesc;
    }

    public void setGoodTypeDesc(String goodTypeDesc) {
        this.goodTypeDesc = goodTypeDesc;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Long getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(Long publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getDocuSource() {
        return docuSource;
    }

    public void setDocuSource(String docuSource) {
        this.docuSource = docuSource;
    }

    public Double getSettleWeight() {
        return settleWeight;
    }

    public void setSettleWeight(Double settleWeight) {
        this.settleWeight = settleWeight;
    }

    public Double getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(Double settlePrice) {
        this.settlePrice = settlePrice;
    }

    public Double getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(Double settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getOrtherFlag() {
        return ortherFlag;
    }

    public void setOrtherFlag(String ortherFlag) {
        this.ortherFlag = ortherFlag;
    }

    public String getLoadingId() {
        return loadingId;
    }

    public void setLoadingId(String loadingId) {
        this.loadingId = loadingId;
    }

    public String getIfDriverJudge() {
        return ifDriverJudge;
    }

    public void setIfDriverJudge(String ifDriverJudge) {
        this.ifDriverJudge = ifDriverJudge;
    }

    public String getIfFdJudge() {
        return ifFdJudge;
    }

    public void setIfFdJudge(String ifFdJudge) {
        this.ifFdJudge = ifFdJudge;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getFdUserId() {
        return fdUserId;
    }

    public void setFdUserId(Long fdUserId) {
        this.fdUserId = fdUserId;
    }

    public String getIfCanShow() {
        return ifCanShow;
    }

    public void setIfCanShow(String ifCanShow) {
        this.ifCanShow = ifCanShow;
    }

    public String getIfFeidan() {
        return ifFeidan;
    }

    public void setIfFeidan(String ifFeidan) {
        this.ifFeidan = ifFeidan;
    }

    public String getComfirmPicLocal() {
        return comfirmPicLocal;
    }

    public void setComfirmPicLocal(String comfirmPicLocal) {
        this.comfirmPicLocal = comfirmPicLocal;
    }

    public String getComfirmPicRemote() {
        return comfirmPicRemote;
    }

    public void setComfirmPicRemote(String comfirmPicRemote) {
        this.comfirmPicRemote = comfirmPicRemote;
    }
}
