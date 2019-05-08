package com.brcc.business.dispatchorder.vo;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台调度单详单数据返回封装类
 *
 * @author yushaohua
 * @create 2018-11-05 19:50
 */
public class DispatchOrderDetailVo extends TransportationdeliveryEntity {

    private String billSenders;

    private BigDecimal amountForPlat;

    private String card;

    private String companyName;

    private String contactMobile;

    private String idNum;

    private String name;

    private String phone;

    private String vehicleNum;

    private String driverMobile;

    private String statusDesc;

    private String settleStatus;

    private String ortherFlagName;

    private String iffly;

    private String prodDesc;

    private String fromType;

    private String logisticsMark;

    private String docOrigin;

    private String updatePersonName;

    private String pinDanNum;

    private String dependNum;

    private String ifTaxTransport;

    private String earlyWarningDays;

    private String finallyPay;

    private String receBankType;

    private String dsIfSettle;

    private String dsIfSettleDesc;

    private String dzJkCancel;

    private String deliveryInfoZdwlSource;

    private String driverStatus;

    private String ifDengjiInfo;

    private String ifDengjiInfoDesc;

    private String ifGsInfo;

    private String ifGsInfoDesc;

    private String driverStatusDesc;

    private String vatCarryName;

    private String carryCompanyName;

    private BigDecimal zcWeight;

    private BigDecimal shWeight;

    public BigDecimal getZcWeight() {
        return zcWeight;
    }

    public void setZcWeight(BigDecimal zcWeight) {
        this.zcWeight = zcWeight;
    }

    public BigDecimal getShWeight() {
        return shWeight;
    }

    public void setShWeight(BigDecimal shWeight) {
        this.shWeight = shWeight;
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public String getBillSenders() {
        return billSenders;
    }

    public void setBillSenders(String billSenders) {
        this.billSenders = billSenders;
    }

    public BigDecimal getAmountForPlat() {
        return amountForPlat;
    }

    public void setAmountForPlat(BigDecimal amountForPlat) {
        this.amountForPlat = amountForPlat;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
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

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String getSettleStatus() {
        return settleStatus;
    }

    @Override
    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
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

    public String getLogisticsMark() {
        return logisticsMark;
    }

    public void setLogisticsMark(String logisticsMark) {
        this.logisticsMark = logisticsMark;
    }

    public String getDocOrigin() {
        return docOrigin;
    }

    public void setDocOrigin(String docOrigin) {
        this.docOrigin = docOrigin;
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

    @Override
    public String getIfTaxTransport() {
        return ifTaxTransport;
    }

    @Override
    public void setIfTaxTransport(String ifTaxTransport) {
        this.ifTaxTransport = ifTaxTransport;
    }

    public String getEarlyWarningDays() {
        return earlyWarningDays;
    }

    public void setEarlyWarningDays(String earlyWarningDays) {
        this.earlyWarningDays = earlyWarningDays;
    }

    public String getFinallyPay() {
        return finallyPay;
    }

    public void setFinallyPay(String finallyPay) {
        this.finallyPay = finallyPay;
    }

    public String getReceBankType() {
        return receBankType;
    }

    public void setReceBankType(String receBankType) {
        this.receBankType = receBankType;
    }

    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

    public String getDsIfSettleDesc() {
        return dsIfSettleDesc;
    }

    public void setDsIfSettleDesc(String dsIfSettleDesc) {
        this.dsIfSettleDesc = dsIfSettleDesc;
    }

    public String getDzJkCancel() {
        return dzJkCancel;
    }

    public void setDzJkCancel(String dzJkCancel) {
        this.dzJkCancel = dzJkCancel;
    }

    public String getDeliveryInfoZdwlSource() {
        return deliveryInfoZdwlSource;
    }

    public void setDeliveryInfoZdwlSource(String deliveryInfoZdwlSource) {
        this.deliveryInfoZdwlSource = deliveryInfoZdwlSource;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
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

    public String getVatCarryName() {
        return vatCarryName;
    }

    public void setVatCarryName(String vatCarryName) {
        this.vatCarryName = vatCarryName;
    }

    public String getCarryCompanyName() {
        return carryCompanyName;
    }

    public void setCarryCompanyName(String carryCompanyName) {
        this.carryCompanyName = carryCompanyName;
    }
}