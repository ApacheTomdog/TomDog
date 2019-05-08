package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.TransportationmEntity;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台运输订单查询结果封装类
 *
 * @author yushaohua
 * @create 2018-10-31 14:54
 */
public class TransOrderVo extends TransportationmEntity {

    /**
     * 单据号
     */
    private String dependNum;

    /**
     * 低价
     */
    private BigDecimal floorPrice;

    /**
     * 委托人
     */
    private String consignor;

    /**
     * 已调度重量
     */
    private String dispatchWeight;

    /**
     * 承运人手机号
     */
    private String contactMobile;

    /**
     * 状态
     */
    private String statusDesc;

    /**
     * 拼单号
     */
    private String pinDanNum;

    /**
     * 是否为飞单
     */
    private String iffly;

    /**
     * 是否为电商配送
     */
    private String dsIfSettle;

    /**
     * 操作员
     */
    private String updatePersonName;

    /**
     * 路耗类型
     */
    private String lossTypeDesc;

    /**
     * 路耗信息
     */
    private String lossWeightDesc;

    /**
     * 电商配送
     */
    private String dsIfSettleDesc;

    private BigDecimal dispatchAmount;

    private String deliveryStatus;

    private String docOrigin;

    private String taxAmount;

    private String carryCompanyName;

    private String carryContactMobile;

    private String taxCompany;

    private String taxContactMobile;

    private String docuType;

    private String docuPriSec;

    private String vatAccType;

    private String vatRateChose;

    private String standardRate;

    private String vatPolicyRate;

    // 合同编号
    private String contractNumber;

    // 合同类型
    private String contractType;

    //单据类型
    private String fromType;

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    // 发单公司id
    private Long fdCompanyId;

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

    public String getDocuType() {
        return docuType;
    }

    public void setDocuType(String docuType) {
        this.docuType = docuType;
    }

    public String getDocuPriSec() {
        return docuPriSec;
    }

    public void setDocuPriSec(String docuPriSec) {
        this.docuPriSec = docuPriSec;
    }

    public String getVatAccType() {
        return vatAccType;
    }

    public void setVatAccType(String vatAccType) {
        this.vatAccType = vatAccType;
    }

    public String getVatRateChose() {
        return vatRateChose;
    }

    public void setVatRateChose(String vatRateChose) {
        this.vatRateChose = vatRateChose;
    }

    public String getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(String standardRate) {
        this.standardRate = standardRate;
    }

    public String getVatPolicyRate() {
        return vatPolicyRate;
    }

    public void setVatPolicyRate(String vatPolicyRate) {
        this.vatPolicyRate = vatPolicyRate;
    }

    public String getTaxContactMobile() {
        return taxContactMobile;
    }

    public void setTaxContactMobile(String taxContactMobile) {
        this.taxContactMobile = taxContactMobile;
    }

    public String getTaxCompany() {
        return taxCompany;
    }

    public void setTaxCompany(String taxCompany) {
        this.taxCompany = taxCompany;
    }

    public BigDecimal getDispatchAmount() {
        return dispatchAmount;
    }

    public void setDispatchAmount(BigDecimal dispatchAmount) {
        this.dispatchAmount = dispatchAmount;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDocOrigin() {
        return docOrigin;
    }

    public void setDocOrigin(String docOrigin) {
        this.docOrigin = docOrigin;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCarryCompanyName() {
        return carryCompanyName;
    }

    public void setCarryCompanyName(String carryCompanyName) {
        this.carryCompanyName = carryCompanyName;
    }

    public String getCarryContactMobile() {
        return carryContactMobile;
    }

    public void setCarryContactMobile(String carryContactMobile) {
        this.carryContactMobile = carryContactMobile;
    }

    public String getDsIfSettleDesc() {
        return dsIfSettleDesc;
    }

    public void setDsIfSettleDesc(String dsIfSettleDesc) {
        this.dsIfSettleDesc = dsIfSettleDesc;
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

    public String getUpdatePersonName() {
        return updatePersonName;
    }

    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(String dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(String pinDanNum) {
        this.pinDanNum = pinDanNum;
    }

    public String getIffly() {
        return iffly;
    }

    public void setIffly(String iffly) {
        this.iffly = iffly;
    }

    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

    public Long getFdCompanyId() { return fdCompanyId; }

    public void setFdCompanyId(Long fdCompanyId) {this.fdCompanyId = fdCompanyId; }
}