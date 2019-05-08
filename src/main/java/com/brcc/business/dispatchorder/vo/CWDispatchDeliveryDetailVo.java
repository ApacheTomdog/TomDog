package com.brcc.business.dispatchorder.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:
 * 川威调度单下发VO
 *
 * @author chk
 * @create 2018-04-23 15:58
 */
public class CWDispatchDeliveryDetailVo {

    private Long uploadId;
    private Long deliveryId;
    private String dependNum;
    private String dependId;
    private String status;
    private String endPlateProvince;
    private String endPlateCity;
    private String endPlateCountry;
    private String receiver;
    private String receiverMobile;
    private BigDecimal price;
    private BigDecimal zcWeight;
    private String remark;

//    private String platformId;
//    private String isUploadEc;
//    private String pinDanNum;
//    private String dsPlatName;


    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
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

    public String getDependId() {
        return dependId;
    }

    public void setDependId(String dependId) {
        this.dependId = dependId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndPlateProvince() {
        return endPlateProvince;
    }

    public void setEndPlateProvince(String endPlateProvince) {
        this.endPlateProvince = endPlateProvince;
    }

    public String getEndPlateCity() {
        return endPlateCity;
    }

    public void setEndPlateCity(String endPlateCity) {
        this.endPlateCity = endPlateCity;
    }

    public String getEndPlateCountry() {
        return endPlateCountry;
    }

    public void setEndPlateCountry(String endPlateCountry) {
        this.endPlateCountry = endPlateCountry;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getZcWeight() {
        return zcWeight;
    }

    public void setZcWeight(BigDecimal zcWeight) {
        this.zcWeight = zcWeight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    public String getPlatformId() {
//        return platformId;
//    }
//
//    public void setPlatformId(String platformId) {
//        this.platformId = platformId;
//    }
//
//    public String getIsUploadEc() {
//        return isUploadEc;
//    }
//
//    public void setIsUploadEc(String isUploadEc) {
//        this.isUploadEc = isUploadEc;
//    }
//
//    public String getPinDanNum() {
//        return pinDanNum;
//    }
//
//    public void setPinDanNum(String pinDanNum) {
//        this.pinDanNum = pinDanNum;
//    }
//
//    public String getDsPlatName() {
//        return dsPlatName;
//    }
//
//    public void setDsPlatName(String dsPlatName) {
//        this.dsPlatName = dsPlatName;
//    }
}