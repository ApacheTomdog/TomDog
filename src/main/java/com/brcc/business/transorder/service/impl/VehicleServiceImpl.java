package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.VehicleEntity;
import com.brcc.business.transorder.repository.VehicleRepository;
import com.brcc.business.transorder.service.VehicleService;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.VehicleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 车辆业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 10:36
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Page<VehicleVo> queryVehicleId(TransOrderSearchVo vo) {
        return vehicleRepository.queryVehicleId(vo);
    }

    @Override
    public VehicleEntity findByPlatformIdAndVehicleId(String platform, Long vehicleId) {
        return vehicleRepository.findByPlatformIdAndVehicleId(platform, vehicleId);
    }
}