package com.brcc.business.transportbill.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc：   回单图片审查列表数据接受类
 * @author: TangYong
 * @Date:   2019-04-15
 */
public class TransportationComfirmPicVo {
    /**货源单号*/
    private Long publishId;
    /**调度单号*/
    private Long deliveryId;
    /**货主名称*/
    private String publisher;
    /**车牌号*/
    private String vehicleNum;
    /**起终地*/
    private String startPlate;
    /**目的地*/
    private String endPlate;
    /**装车重量*/
    private BigDecimal truckLoadingWeight;
    /**收货重量*/
    private BigDecimal takeDeliveryWeight;
    /**创建时间*/
    private Date createDate;
    /**收货时间*/
    private Date finishTime;
    /**支付时间*/
    private Date payDate;
    /**回单图片*/
    private String comfirmPic1Local;
    /**审核状态*/
    private String riskAuditStatus;
    /**异常类型*/
    private String riskAuditType;
    /**货源发单时间*/
    private Date publishDate;
    /**调度单完成时间*/
    private Date deliveryFinishTime;

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public String getStartPlate() {
        return startPlate;
    }

    public void setStartPlate(String startPlate) {
        this.startPlate = startPlate;
    }

    public String getEndPlate() {
        return endPlate;
    }

    public void setEndPlate(String endPlate) {
        this.endPlate = endPlate;
    }

    public BigDecimal getTruckLoadingWeight() {
        return truckLoadingWeight;
    }

    public void setTruckLoadingWeight(BigDecimal truckLoadingWeight) {
        this.truckLoadingWeight = truckLoadingWeight;
    }

    public BigDecimal getTakeDeliveryWeight() {
        return takeDeliveryWeight;
    }

    public void setTakeDeliveryWeight(BigDecimal takeDeliveryWeight) {
        this.takeDeliveryWeight = takeDeliveryWeight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFinishTime() {return finishTime; }

    public void setFinishTime(Date finishTime) { this.finishTime = finishTime; }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getComfirmPic1Local() {
        return comfirmPic1Local;
    }

    public void setComfirmPic1Local(String comfirmPic1Local) {
        this.comfirmPic1Local = comfirmPic1Local;
    }

    public String getRiskAuditStatus() {return riskAuditStatus; }

    public void setRiskAuditStatus(String riskAuditStatus) {this.riskAuditStatus = riskAuditStatus; }

    public String getRiskAuditType() {return riskAuditType; }

    public void setRiskAuditType(String riskAuditType) {this.riskAuditType = riskAuditType; }

    public Date getPublishDate() { return publishDate; }

    public void setPublishDate(Date publishDate) {this.publishDate = publishDate; }

    public Date getDeliveryFinishTime() {return deliveryFinishTime; }

    public void setDeliveryFinishTime(Date deliveryFinishTime) {this.deliveryFinishTime = deliveryFinishTime; }
}
