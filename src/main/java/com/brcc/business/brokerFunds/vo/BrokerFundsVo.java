package com.brcc.business.brokerFunds.vo;

import com.brcc.business.brokerFunds.entity.BrokerfundscontrolmasterEntity;

import java.math.BigDecimal;

/**
 * @Description  接收经纪人资金流水单
 * @Author pjy
 * @Date
 **/
public class BrokerFundsVo extends BrokerfundscontrolmasterEntity {


    private BigDecimal payJjrAmount;

    private String driverName;

    private BigDecimal payCarryMinAmt;

    private BigDecimal fcCarryAmount;

    private String  fcCarryName;

    private Long zfId;

    private Long deliveryId;

    private Integer totalNum;

    private Integer successNum;

    private Integer failNum;

    private BigDecimal companyPayeeAmount;

    private BigDecimal quarterPayeeAmount;

    private String companyPayeeName;

    private String companyPayeeNum;

    private String fundsControlMasterIdStr;

    private String companyPayeeCardNum;

    public BigDecimal getPayJjrAmount() {
        return payJjrAmount;
    }

    public void setPayJjrAmount(BigDecimal payJjrAmount) {
        this.payJjrAmount = payJjrAmount;
    }

    public void setFcCarryAmount(BigDecimal fcCarryAmount) {
        this.fcCarryAmount = fcCarryAmount;
    }

    public void setFcCarryName(String fcCarryName) {
        this.fcCarryName = fcCarryName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public BigDecimal getPayCarryMinAmt() {
        return payCarryMinAmt;
    }

    public void setPayCarryMinAmt(BigDecimal payCarryMinAmt) {
        this.payCarryMinAmt = payCarryMinAmt;
    }

    public BigDecimal getFcCarryAmount() {
        return fcCarryAmount;
    }


    public String getFcCarryName() {
        return fcCarryName;
    }


    public Long getZfId() {
        return zfId;
    }

    public void setZfId(Long zfId) {
        this.zfId = zfId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Integer getFailNum() {
        return failNum;
    }

    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getCompanyPayeeAmount() {
        return companyPayeeAmount;
    }

    public void setCompanyPayeeAmount(BigDecimal companyPayeeAmount) {
        this.companyPayeeAmount = companyPayeeAmount;
    }

    public BigDecimal getQuarterPayeeAmount() {
        return quarterPayeeAmount;
    }

    public String getCompanyPayeeName() {
        return companyPayeeName;
    }

    public void setCompanyPayeeName(String companyPayeeName) {
        this.companyPayeeName = companyPayeeName;
    }

    public String getCompanyPayeeNum() {
        return companyPayeeNum;
    }

    public void setCompanyPayeeNum(String companyPayeeNum) {
        this.companyPayeeNum = companyPayeeNum;
    }

    public String getFundsControlMasterIdStr() {
        return fundsControlMasterIdStr;
    }

    public void setFundsControlMasterIdStr(String fundsControlMasterIdStr) {
        this.fundsControlMasterIdStr = fundsControlMasterIdStr;
    }

    public String getCompanyPayeeCardNum() {
        return companyPayeeCardNum;
    }

    public void setCompanyPayeeCardNum(String companyPayeeCardNum) {
        this.companyPayeeCardNum = companyPayeeCardNum;
    }

    public void setQuarterPayeeAmount(BigDecimal quarterPayeeAmount) {
        this.quarterPayeeAmount = quarterPayeeAmount;
    }
}
