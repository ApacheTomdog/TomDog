package com.brcc.business.transportbill.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ESTeel
 * Description:
 * 调度单 操作处理类
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 14:36
 */
public class TransportationBillOperatorVo implements Serializable {

    private Long  deliveryId;
    private String status;
    private Long publishId;
    private Long driverId;
    private String driverName;
    private Long  transId;
    private String curStu;
    private String dzJkCancel;
    private String operateType;
    private String deliveryInfoZdwlSource;
    private String fromType;

    private BigDecimal shWeight;

    //操作人信息

    private Long userId;
    private String userName;

    private String platformId;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getTransId() {
        return transId;
    }

    public void setTransId(Long transId) {
        this.transId = transId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getShWeight() {
        return shWeight;
    }

    public void setShWeight(BigDecimal shWeight) {
        this.shWeight = shWeight;
    }
}
