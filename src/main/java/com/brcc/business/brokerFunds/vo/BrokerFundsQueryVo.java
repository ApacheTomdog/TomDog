package com.brcc.business.brokerFunds.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * @Description 经纪流水单主查询条件
 * @Author pjy
 * @Date 2018/12/27
 **/
public class BrokerFundsQueryVo extends BaseQueryVo {
    private Long userId;

    private Long companyId;

    private String userName;

    private String platformId;

    private Date rqStart;

    private Date rqEnd;

    private Long fundsControlMasterId;

    private String deliveryIdStr;

    private String masterStatus;

    private String companyPayeeName;

    private String borkerCompanyName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
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

    public Long getFundsControlMasterId() {
        return fundsControlMasterId;
    }

    public void setFundsControlMasterId(Long fundsControlMasterId) {
        this.fundsControlMasterId = fundsControlMasterId;
    }

    public String getDeliveryIdStr() {
        return deliveryIdStr;
    }

    public void setDeliveryIdStr(String deliveryIdStr) {
        this.deliveryIdStr = deliveryIdStr;
    }

    public String getMasterStatus() {
        return masterStatus;
    }

    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }

    public String getCompanyPayeeName() {
        return companyPayeeName;
    }

    public String getBorkerCompanyName() {
        return borkerCompanyName;
    }

    public void setBorkerCompanyName(String borkerCompanyName) {
        this.borkerCompanyName = borkerCompanyName;
    }

    public void setCompanyPayeeName(String companyPayeeName) {
        this.companyPayeeName = companyPayeeName;
    }
}
