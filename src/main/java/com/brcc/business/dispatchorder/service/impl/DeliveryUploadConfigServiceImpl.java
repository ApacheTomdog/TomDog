package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.DeliveryuploadConfigEntity;
import com.brcc.business.dispatchorder.repository.DeliveryUploadConfigRepository;
import com.brcc.business.dispatchorder.service.DeliveryUploadConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 15:31
 */
@Service
public class DeliveryUploadConfigServiceImpl implements DeliveryUploadConfigService {

    Logger logger = LoggerFactory.getLogger(DeliveryUploadConfigServiceImpl.class);

    @Autowired
    DeliveryUploadConfigRepository deliveryUploadConfigRepository;

    @Override
    public DeliveryuploadConfigEntity findByJkName(String jkName) {
        logger.info("find by jk name jkName:{}",jkName);
        return deliveryUploadConfigRepository.findFirstByJkName(jkName);
    }
}
