package com.brcc.business.dispatchorder.vo;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 川威调度单下发VO
 *
 * @author chk
 * @create 2018-04-23 15:58
 */
public class CWDispatchDeliveryVo {

    private String appointCompanyCode;
    private String deliveryTime;
    private Long pinDanCarNum;
    private String pinDanNum;
    private String platName;
    private String mobile;
    private String idCard;
    private String driverName;
    private String carNum;
    private String vehicleType;
    private List<CWDispatchDeliveryDetailVo> dataDetail;

    private Long uploadId;
//    private String platformId;
//    private String status;
//    private String isUploadEc;
//    private Long deliveryId;
//    private String dsPlatName;


    public String getAppointCompanyCode() {
        return appointCompanyCode;
    }

    public void setAppointCompanyCode(String appointCompanyCode) {
        this.appointCompanyCode = appointCompanyCode;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getPinDanCarNum() {
        return pinDanCarNum;
    }

    public void setPinDanCarNum(Long pinDanCarNum) {
        this.pinDanCarNum = pinDanCarNum;
    }

    public String getPinDanNum() {
        return pinDanNum;
    }

    public void setPinDanNum(String pinDanNum) {
        this.pinDanNum = pinDanNum;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<CWDispatchDeliveryDetailVo> getDataDetail() {
        return dataDetail;
    }

    public void setDataDetail(List<CWDispatchDeliveryDetailVo> dataDetail) {
        this.dataDetail = dataDetail;
    }


    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

//
//    public String getPlatformId() {
//        return platformId;
//    }
//
//    public void setPlatformId(String platformId) {
//        this.platformId = platformId;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
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
//    public Long getDeliveryId() {
//        return deliveryId;
//    }
//
//    public void setDeliveryId(Long deliveryId) {
//        this.deliveryId = deliveryId;
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