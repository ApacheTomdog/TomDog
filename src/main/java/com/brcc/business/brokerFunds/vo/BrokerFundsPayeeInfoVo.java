package com.brcc.business.brokerFunds.vo;

import com.brcc.business.brokerFunds.entity.BrokerFundsPayeeInfoEntity;

import java.math.BigDecimal;

/**
 * @Description
 * @Author pjy
 * @Date 经纪人流水分配接收表
 **/
public class BrokerFundsPayeeInfoVo extends BrokerFundsPayeeInfoEntity {
    private String  brokerFundsPayeeInfoIdStr;

    private String masterStatus;

    private BigDecimal quarterPayeeAmount;

    public String getBrokerFundsPayeeInfoIdStr() {
        return brokerFundsPayeeInfoIdStr;
    }

    public void setBrokerFundsPayeeInfoIdStr(String brokerFundsPayeeInfoIdStr) {
        this.brokerFundsPayeeInfoIdStr = brokerFundsPayeeInfoIdStr;
    }

    public String getMasterStatus() {
        return masterStatus;
    }

    public BigDecimal getQuarterPayeeAmount() {
        return quarterPayeeAmount;
    }

    public void setQuarterPayeeAmount(BigDecimal quarterPayeeAmount) {
        this.quarterPayeeAmount = quarterPayeeAmount;
    }

    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }
}
