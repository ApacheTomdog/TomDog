package com.brcc.business.transorder.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * 描述:
 * 平台运输单详情查询封装类
 *
 * @author yushaohua
 * @create 2018-10-31 16:26
 */
public class TransOrderDispatchDetailSearchVo extends BaseQueryVo {

    private String platformId;

    private String transId;

    private Date rqStart;

    private Date rqEnd;

    private String vatCarryId;

    private Long deliveryId;

    private String dependNum;

    private String vehicleNum;

    private Long companyId;

    private String endPlate;

    private String name;

    private String companyName;

    private Long publisherCompanyId;

    private Long publishId;

    private String pinDan;

    private String status;

    private String deFlag;

    private String iffly;

    private String billSender;

    private String evaluate;

    private String payType;

    private Long vatClientId;

    private String goodOwner;

    private String earlyWarning;

    private String dsIfSettle;

    private String wtBillSender;

    private String companyTaxId;

    private String companyIds;

    private String accessFlag;

    private String settleflag;

    private String settleStatus;

    private String carriCompany;

    private String startPlate;

    private String fromType;

    private String sender;

    private String prodDesc;

    private String accountFrom;

    private String ifShowAdmin;

    private Long parentCompanyId;

    public Long getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Long parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
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

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    public String getCarriCompany() {
        return carriCompany;
    }

    public void setCarriCompany(String carriCompany) {
        this.carriCompany = carriCompany;
    }

    public String getSettleStatus() {
        return settleStatus;
    }

    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    public String getSettleflag() {
        return settleflag;
    }

    public void setSettleflag(String settleflag) {
        this.settleflag = settleflag;
    }

    public String getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(String accessFlag) {
        this.accessFlag = accessFlag;
    }

    public String getCompanyTaxId() {
        return companyTaxId;
    }

    public void setCompanyTaxId(String companyTaxId) {
        this.companyTaxId = companyTaxId;
    }

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    public String getWtBillSender() {
        return wtBillSender;
    }

    public void setWtBillSender(String wtBillSender) {
        this.wtBillSender = wtBillSender;
    }

    public String getDsIfSettle() {
        return dsIfSettle;
    }

    public void setDsIfSettle(String dsIfSettle) {
        this.dsIfSettle = dsIfSettle;
    }

    public String getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(String earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public String getGoodOwner() {
        return goodOwner;
    }

    public void setGoodOwner(String goodOwner) {
        this.goodOwner = goodOwner;
    }

    public Long getVatClientId() {
        return vatClientId;
    }

    public void setVatClientId(Long vatClientId) {
        this.vatClientId = vatClientId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDependNum() {
        return dependNum;
    }

    public void setDependNum(String dependNum) {
        this.dependNum = dependNum;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getPublisherCompanyId() {
        return publisherCompanyId;
    }

    public void setPublisherCompanyId(Long publisherCompanyId) {
        this.publisherCompanyId = publisherCompanyId;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getPinDan() {
        return pinDan;
    }

    public void setPinDan(String pinDan) {
        this.pinDan = pinDan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBillSender() {
        return billSender;
    }

    public void setBillSender(String billSender) {
        this.billSender = billSender;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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

    public String getVatCarryId() {
        return vatCarryId;
    }

    public void setVatCarryId(String vatCarryId) {
        this.vatCarryId = vatCarryId;
    }
}