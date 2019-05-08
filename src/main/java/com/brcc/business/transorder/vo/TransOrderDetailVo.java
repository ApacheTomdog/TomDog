package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.GoodsordermEntity;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台运输单详情查询结果封装类
 *
 * @author yushaohua
 * @create 2018-11-01 16:29
 */
public class TransOrderDetailVo extends GoodsordermEntity {

    private String isTimeOut;

    private String remark;

    private String detachableDesc;

    private BigDecimal billWeight;

    private String statusDesc;

    private BigDecimal transWeight;

    private String appointFlag;

    private String consignorName;

    private String consignorNamePhone;

    private String sendGroupType;

    private String appointTeamName;

    private String sendGroup;

    private String fdCompanyId;

    private String dsIfSettleDesc;

    private String vatAccType;

    private String vatRateChose;

    private String standardRate;

    private String vatPolicyRate;

    private BigDecimal priceTax;

    private BigDecimal taxAmount;

    private String ifTaxTransportDesc;

    private String lossTypeDesc;

    private String lossWeightDesc;

    private String orderTaxDetail;

    private String type;

    public String getOrderTaxDetail() {
        return orderTaxDetail;
    }

    public void setOrderTaxDetail(String orderTaxDetail) {
        this.orderTaxDetail = orderTaxDetail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsTimeOut() {
        return isTimeOut;
    }

    public void setIsTimeOut(String isTimeOut) {
        this.isTimeOut = isTimeOut;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDetachableDesc() {
        return detachableDesc;
    }

    public void setDetachableDesc(String detachableDesc) {
        this.detachableDesc = detachableDesc;
    }

    public BigDecimal getBillWeight() {
        return billWeight;
    }

    public void setBillWeight(BigDecimal billWeight) {
        this.billWeight = billWeight;
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

    public String getConsignorNamePhone() {
        return consignorNamePhone;
    }

    public void setConsignorNamePhone(String consignorNamePhone) {
        this.consignorNamePhone = consignorNamePhone;
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

    @Override
    public String getSendGroup() {
        return sendGroup;
    }

    @Override
    public void setSendGroup(String sendGroup) {
        this.sendGroup = sendGroup;
    }

    public String getFdCompanyId() {
        return fdCompanyId;
    }

    public void setFdCompanyId(String fdCompanyId) {
        this.fdCompanyId = fdCompanyId;
    }

    public String getDsIfSettleDesc() {
        return dsIfSettleDesc;
    }

    public void setDsIfSettleDesc(String dsIfSettleDesc) {
        this.dsIfSettleDesc = dsIfSettleDesc;
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

    @Override
    public BigDecimal getPriceTax() {
        return priceTax;
    }

    @Override
    public void setPriceTax(BigDecimal priceTax) {
        this.priceTax = priceTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getIfTaxTransportDesc() {
        return ifTaxTransportDesc;
    }

    public void setIfTaxTransportDesc(String ifTaxTransportDesc) {
        this.ifTaxTransportDesc = ifTaxTransportDesc;
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
}