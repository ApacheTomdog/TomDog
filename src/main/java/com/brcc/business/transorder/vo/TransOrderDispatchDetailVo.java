package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 * 平台运输单调度明细查询返回封装类
 *
 * @author yushaohua
 * @create 2018-11-02 10:30
 */
public class TransOrderDispatchDetailVo extends TransportationdeliveryEntity {

    private String carryCompanyName;

    private String companyName;

    private String name;

    private String idNum;

    private String driverMobile;

    private String vehicleNum;

    private String updatePersonName;

    private String statusDesc;

    private BigDecimal sumWeight;

    private BigDecimal sumQty;

    private BigDecimal initWeight;

    private BigDecimal initQty;

    private String card;

    private String contactMobile;

    private String contactName;

    private String phone;

    private String iffly;

    private String totalTime;

    private String prodDesc;

    private String fromType;

    private String dependNum;

    private Long pinDanNum;

    private String ortherFlagName;

    private BigDecimal vatPolicyRate;

    private String earlyWarningDays;

    private String receBankType;

    private String dsIfSettle;

    private BigDecimal zcWeight;

    private BigDecimal shWeight;

    private String ifEnd;

    private BigDecimal taxAmount;

    private BigDecimal amountTax;

    private String ifTaxTransportStr;

    private String lossTypeDesc;

    private String lossWeightDesc;

    private String goodOwner;

    private String consignorName;

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    public String getOrtherFlagName() {
        return ortherFlagName;
    }

    public void setOrtherFlagName(String ortherFlagName) {
        this.ortherFlagName = ortherFlagName;
    }

    public BigDecimal getVatPolicyRate() {
        return vatPolicyRate;
    }

    public void setVatPolicyRate(BigDecimal vatPolicyRate) {
        this.vatPolicyRate = vatPolicyRate;
    }

    public String getEarlyWarningDays() {
        return earlyWarningDays;
    }

    public void setEarlyWarningDays(String earlyWarningDays) {
        this.earlyWarningDays = earlyWarningDays;
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

    public String getIfEnd() {
        return ifEnd;
    }

    public void setIfEnd(String ifEnd) {
        this.ifEnd = ifEnd;
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

    public String getIfTaxTransportStr() {
        return ifTaxTransportStr;
    }

    public void setIfTaxTransportStr(String ifTaxTransportStr) {
        this.ifTaxTransportStr = ifTaxTransportStr;
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

    public String getGoodOwner() {
        return goodOwner;
    }

    public void setGoodOwner(String goodOwner) {
        this.goodOwner = goodOwner;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIffly() {
        return iffly;
    }

    public void setIffly(String iffly) {
        this.iffly = iffly;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
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

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public Long getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(Long pinDanNum) {
        this.pinDanNum = pinDanNum;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public BigDecimal getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(BigDecimal sumWeight) {
        this.sumWeight = sumWeight;
    }

    public BigDecimal getSumQty() {
        return sumQty;
    }

    public void setSumQty(BigDecimal sumQty) {
        this.sumQty = sumQty;
    }

    public BigDecimal getInitWeight() {
        return initWeight;
    }

    public void setInitWeight(BigDecimal initWeight) {
        this.initWeight = initWeight;
    }

    public BigDecimal getInitQty() {
        return initQty;
    }

    public void setInitQty(BigDecimal initQty) {
        this.initQty = initQty;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public String getCarryCompanyName() {
        return carryCompanyName;
    }

    public void setCarryCompanyName(String carryCompanyName) {
        this.carryCompanyName = carryCompanyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(String driverMobile) {
        this.driverMobile = driverMobile;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }
}