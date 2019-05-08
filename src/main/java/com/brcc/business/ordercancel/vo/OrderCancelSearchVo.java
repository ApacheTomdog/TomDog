package com.brcc.business.ordercancel.vo;

import com.esteel.common.vo.BaseQueryVo;

import java.util.Date;

/**
 * 描述:
 * 撤单审核查询参数封装类
 *
 * @author yushaohua
 * @create 2018-11-06 21:49
 */
public class OrderCancelSearchVo extends BaseQueryVo {

    private String deliveryCancelType;

    private String publishId;

    private String transId;

    private String deliveryId;

    private String vehicleNum;

    private String driverName;

    private Date rqStart;

    private Date rqEnd;

    private String platformId;

    private String carryCompanyName;

    private Long deliveryCancelId;

    private String status;

    private String ifShowAdmin;

    private String accountFrom;

    private Long companyId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDeliveryCancelId() {
        return deliveryCancelId;
    }

    public void setDeliveryCancelId(Long deliveryCancelId) {
        this.deliveryCancelId = deliveryCancelId;
    }

    public String getCarryCompanyName() {
        return carryCompanyName;
    }

    public void setCarryCompanyName(String carryCompanyName) {
        this.carryCompanyName = carryCompanyName;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getDeliveryCancelType() {
        return deliveryCancelType;
    }

    public void setDeliveryCancelType(String deliveryCancelType) {
        this.deliveryCancelType = deliveryCancelType;
    }

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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
}