package com.brcc.business.transorder.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 平台运输订单查询封装类
 *
 * @author yushaohua
 * @create 2018-10-31 16:26
 */
public class TransOrderSearchVo extends BaseQueryVo {

    /**
     * 运输订单
     */
    private String transId;

    /**
     * 货源单
     */
    private String publishId;

    /**
     * 取单地
     */
    private String getOrderPlate;

    /**
     * 装货地
     */
    private String startPlate;

    /**
     * 目的地
     */
    private String endPlate;

    /**
     * 创建开始日期
     */
    private Date rqStart;

    /**
     * 创建结束日期
     */
    private Date rqEnd;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 承运单位
     */
    private String carriCompany;

    /**
     * 委托人
     */
    private String billSender;

    /**
     * 调度状态
     */
    private String tranStatue;

    /**
     * 是否为飞单
     */
    private String iffly;

    /**
     * 单据号
     */
    private String dependNum;

    /**
     * 拼单单据筛选
     */
    private String pinDan;

    /**
     * 电商配送
     */
    private String dsIfSettle;

    /**
     * 平台ID
     */
    private String platformId;

    /**
     * 是否委托承运
     */
    private String taxTransport;

    private String ifShowAdmin;

    private String accountFrom;

    private Long companyId;

    private String isAutoDisplay;

    private String fromType;

    private String prodDesc;

    private String ifTaxTransport;

    private BigDecimal weight;

    private BigDecimal qty;

    private BigDecimal amount;

    private String flag;

    private BigDecimal goodWeight;

    private Long importId;

    private Long teamId;

    private String companyName;

    private String platName;

    private Long driverId;

    private BigDecimal newPrice;

    private String info;

    private Long vehicleId;

    private String ifBrokerPeople;

    private BigDecimal dispatchWeight;

    private BigDecimal dispatchQty;

    private String brokerPeopleType;

    private BigDecimal tollRatio;

    private BigDecimal tollAmount;

    private String driverName;

    private String driverPhone;

    private BigDecimal price;

    private String vehicleNum;
    
    /**特例经纪人标记(Y代表特例,N代表常规)*/
    private String ifSpecial;

    //合同编号
    private String contractNumber;

    /**批量调度（重量、运单号）*/
    private List<DispatchVo> dispatchWeightList;

    /**交互码*/
    private String interCode;

    /**车辆信息（川威返回的车牌号）*/
    List<CarInfo> carInfoList;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public BigDecimal getTollRatio() {
        return tollRatio;
    }

    public void setTollRatio(BigDecimal tollRatio) {
        this.tollRatio = tollRatio;
    }

    public BigDecimal getTollAmount() {
        return tollAmount;
    }

    public void setTollAmount(BigDecimal tollAmount) {
        this.tollAmount = tollAmount;
    }

    public String getBrokerPeopleType() {
        return brokerPeopleType;
    }

    public void setBrokerPeopleType(String brokerPeopleType) {
        this.brokerPeopleType = brokerPeopleType;
    }

    public BigDecimal getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(BigDecimal dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public BigDecimal getDispatchQty() {
        return dispatchQty;
    }

    public void setDispatchQty(BigDecimal dispatchQty) {
        this.dispatchQty = dispatchQty;
    }

    public String getIfBrokerPeople() {
        return ifBrokerPeople;
    }

    public void setIfBrokerPeople(String ifBrokerPeople) {
        this.ifBrokerPeople = ifBrokerPeople;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public BigDecimal getGoodWeight() {

        return goodWeight;
    }

    public void setGoodWeight(BigDecimal goodWeight) {
        this.goodWeight = goodWeight;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
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

    public String getIsAutoDisplay() {
        return isAutoDisplay;
    }

    public void setIsAutoDisplay(String isAutoDisplay) {
        this.isAutoDisplay = isAutoDisplay;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public String getTaxTransport() {
        return taxTransport;
    }

    public void setTaxTransport(String taxTransport) {
        this.taxTransport = taxTransport;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getGetOrderPlate() {
        return getOrderPlate;
    }

    public void setGetOrderPlate(String getOrderPlate) {
        this.getOrderPlate = getOrderPlate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarriCompany() {
        return carriCompany;
    }

    public void setCarriCompany(String carriCompany) {
        this.carriCompany = carriCompany;
    }

    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    public String getTranStatue() {
        return tranStatue;
    }

    public void setTranStatue(String tranStatue) {
        this.tranStatue = tranStatue;
    }

    public String getIffly() {
        return iffly;
    }

    public void setIffly(String iffly) {
        this.iffly = iffly;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public String getPinDan() {
        return pinDan;
    }

    public void setPinDan(String pinDan) {
        this.pinDan = pinDan;
    }

    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

	public String getIfSpecial() {
		return ifSpecial;
	}

	public void setIfSpecial(String ifSpecial) {
		this.ifSpecial = ifSpecial;
	}

    public List<DispatchVo> getDispatchWeightList() {return dispatchWeightList; }

    public void setDispatchWeightList(List<DispatchVo> dispatchWeightList) {this.dispatchWeightList = dispatchWeightList; }

    public String getInterCode() { return interCode; }

    public void setInterCode(String interCode) {this.interCode = interCode; }

    public List<CarInfo> getCarInfoList() {
        return carInfoList;
    }

    public void setCarInfoList(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }
}