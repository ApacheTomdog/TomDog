package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.LoginverifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-25 16:20
 */
@Repository
public interface LoginVerifyRepository extends JpaRepository<LoginverifyEntity,Long> {

    @Query(value="SELECT * FROM loginverify l, teamcompany t WHERE if_admin = 'Y' AND l.company_id = t.cy_company_id AND t.team_id = ?", nativeQuery=true)
    LoginverifyEntity findInfo(Long teamId);

    @Query(value="SELECT * FROM apptms.loginverify t WHERE t.driver_id = ? AND t.status = '20' AND EXISTS(SELECT 1 FROM apptms.company t1 WHERE t1.seq_id = t.company_id AND t1.platform_id = ? and t1.status = '20')", nativeQuery=true)
    List<LoginverifyEntity> checkCYRStatus(Long driverId, String platformId);

    @Query(value="select count(1) from vehicle t where t.vehicle_id = ?1 and t.platform_id = ?2 and t.status = '02'", nativeQuery=true)
    Long checkCYRVehicleStatus(Long vehicleId, String platformId);
}