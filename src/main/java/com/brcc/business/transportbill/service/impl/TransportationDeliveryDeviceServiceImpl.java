package com.brcc.business.transportbill.service.impl;

import com.brcc.business.transportbill.entity.TransportationDeliveryDeviceEntity;
import com.brcc.business.transportbill.repository.TransportationDeliveryDeviceRepository;
import com.brcc.business.transportbill.service.TransportationDeliveryDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-15 14:11
 */
@Transactional
@Service
public class TransportationDeliveryDeviceServiceImpl implements TransportationDeliveryDeviceService {

    @Autowired
    private TransportationDeliveryDeviceRepository transportationDeliveryDeviceRepository;

    @Override
    public TransportationDeliveryDeviceEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId) {
        return transportationDeliveryDeviceRepository.findByDeliveryIdAndPlatformId(deliveryId, platformId);
    }

    @Override
    public TransportationDeliveryDeviceEntity save(TransportationDeliveryDeviceEntity entity) {
        return transportationDeliveryDeviceRepository.save(entity);
    }
}