package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 车辆业务逻辑类
 *
 * @author yushaohua
 * @create 2018-12-04 10:32
 */
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity,Long>, IVehicleRepository {

    VehicleEntity findByPlatformIdAndVehicleId(String platform, Long vehicleId);
}