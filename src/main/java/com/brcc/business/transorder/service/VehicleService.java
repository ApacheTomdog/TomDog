package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.VehicleEntity;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.VehicleVo;
import org.springframework.data.domain.Page;

/**
 * 描述:
 * 车辆业务逻辑接口类
 *
 * @author yushaohua
 * @create 2018-12-04 10:35
 */
public interface VehicleService {

    /**
     * 获取车辆信息
     * @return
     */
    Page<VehicleVo> queryVehicleId(TransOrderSearchVo vo);

    VehicleEntity findByPlatformIdAndVehicleId(String platform, Long vehicleId);
}