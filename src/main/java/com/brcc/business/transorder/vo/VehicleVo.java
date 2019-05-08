package com.brcc.business.transorder.vo;

import com.brcc.business.transorder.entity.VehicleEntity;

/**
 * 调度车辆信息
 * @author TangYong
 * @create 2019-04-25
 */
public class VehicleVo extends VehicleEntity {

    // 车辆运输状态（装载，空闲）
    private String vehicleStatus;

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}