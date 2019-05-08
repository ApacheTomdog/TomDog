package com.brcc.business.transportbill.repository;

import com.brcc.business.transportbill.entity.TransportationDeliveryDeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-15 14:02
 */
@Repository
public interface TransportationDeliveryDeviceRepository extends JpaRepository<TransportationDeliveryDeviceEntity,Long> {

    TransportationDeliveryDeviceEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId);
}