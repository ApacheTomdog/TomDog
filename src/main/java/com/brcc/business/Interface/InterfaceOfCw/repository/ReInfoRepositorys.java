package com.brcc.business.Interface.InterfaceOfCw.repository;

import com.brcc.business.Interface.InterfaceOfCw.entity.ReInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReInfoRepositorys extends JpaRepository<ReInfoEntity, Long> {

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update reinfotocw set isupload=-1 where isupload=0",nativeQuery = true)
    void updatereinfotocwbefore();

    @Query(value="SELECT cwinterfaceId,deliveryId,lng,lat,address,arriveTime,imageAddress from reinfotocw  where isupload = -1 and ec_plat_name=? ",nativeQuery=true)
    List<ReInfoEntity> reinfotocw(@Param("ecPlatName")String ecPlatName);

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update reinfotocw set isupload=1 where isupload=-1",nativeQuery = true)
    void updatereinfotocwafter();

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update reinfotocw set isupload=-2 where isupload=-1",nativeQuery = true)
    void updatefail();
}