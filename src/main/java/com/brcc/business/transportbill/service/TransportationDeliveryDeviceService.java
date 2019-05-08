package com.brcc.business.transportbill.service;

import com.brcc.business.transportbill.entity.TransportationDeliveryDeviceEntity;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-15 14:10
 */
public interface TransportationDeliveryDeviceService {

    TransportationDeliveryDeviceEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId);

    TransportationDeliveryDeviceEntity save(TransportationDeliveryDeviceEntity entity);

}