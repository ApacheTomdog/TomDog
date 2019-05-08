package com.brcc.business.dispatchorder.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * 描述:
 * 平台调度单详单检索接口封装类
 *
 * @author yushaohua
 * @create 2018-11-05 20:29
 */
public class DispatchOrderDetailSearchVo extends BaseQueryVo {

    private String deliveryId;

    private String vehicleNum;

    private String orderPlate;

    private String billSender;

    private Date rqStart;

    private Date rqEnd;

    private String status;

    private String shWeight;

    private String getOrderPlate;

    private String startPlate;

    private String endPlate;

    private String dependNum;

    private String transId;

    private String publishId;

    private String companyName;

    private String platformId;

    private Long companyId;

    private String name;

    private String publisherCompanyId;

    private String pinDan;

    private String deFlag;

    private String iffly;

    private String evaluate;

    private String payType;

    private String dsIfSettle;

    private String taxTransport;

    private String driverStatus;

    private String ifDengjiInfo;

    private String ifGsInfo;

    private String finallyPay;

    private String driverId;

    private String driverName;

    private String curStu;

    private String dzJkCancel;

    private String operateType;

    private String deliveryInfoZdwlSource;

    private String fromType;

    private int canUpload;

    private String dqFlag;

    private String exeDesc;

    private String idNum;

    private String regName;

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getExeDesc() {
        return exeDesc;
    }

    public void setExeDesc(String exeDesc) {
        this.exeDesc = exeDesc;
    }

    public String getDqFlag() {
        return dqFlag;
    }

    public void setDqFlag(String dqFlag) {
        this.dqFlag = dqFlag;
    }

    public int getCanUpload() {
        return canUpload;
    }

    public void setCanUpload(int canUpload) {
        this.canUpload = canUpload;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCurStu() {
        return curStu;
    }

    public void setCurStu(String curStu) {
        this.curStu = curStu;
    }

    public String getDzJkCancel() {
        return dzJkCancel;
    }

    public void setDzJkCancel(String dzJkCancel) {
        this.dzJkCancel = dzJkCancel;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getDeliveryInfoZdwlSource() {
        return deliveryInfoZdwlSource;
    }

    public void setDeliveryInfoZdwlSource(String deliveryInfoZdwlSource) {
        this.deliveryInfoZdwlSource = deliveryInfoZdwlSource;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getFinallyPay() {
        return finallyPay;
    }

    public void setFinallyPay(String finallyPay) {
        this.finallyPay = finallyPay;
    }

    public String getIfGsInfo() {
        return ifGsInfo;
    }

    public void setIfGsInfo(String ifGsInfo) {
        this.ifGsInfo = ifGsInfo;
    }

    public String getIfDengjiInfo() {
        return ifDengjiInfo;
    }

    public void setIfDengjiInfo(String ifDengjiInfo) {
        this.ifDengjiInfo = ifDengjiInfo;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getTaxTransport() {
        return taxTransport;
    }

    public void setTaxTransport(String taxTransport) {
        this.taxTransport = taxTransport;
    }

    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getIffly() {
        return iffly;
    }

    public void setIffly(String iffly) {
        this.iffly = iffly;
    }

    public String getDeFlag() {
        return deFlag;
    }

    public void setDeFlag(String deFlag) {
        this.deFlag = deFlag;
    }

    public String getPinDan() {
        return pinDan;
    }

    public void setPinDan(String pinDan) {
        this.pinDan = pinDan;
    }

    public String getPublisherCompanyId() {
        return publisherCompanyId;
    }

    public void setPublisherCompanyId(String publisherCompanyId) {
        this.publisherCompanyId = publisherCompanyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getOrderPlate() {
        return orderPlate;
    }

    public void setOrderPlate(String orderPlate) {
        this.orderPlate = orderPlate;
    }

    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
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

    public String getShWeight() {
        return shWeight;
    }

    public void setShWeight(String shWeight) {
        this.shWeight = shWeight;
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

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}