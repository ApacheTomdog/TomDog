package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.DeliveryUploadEntity;
import com.brcc.business.dispatchorder.repository.DeliveryUploadRepository;
import com.brcc.business.dispatchorder.service.DeliveryUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 17:57
 */
@Service
public class DeliveryUploadServiceImpl implements DeliveryUploadService {

    Logger logger = LoggerFactory.getLogger(DeliveryUploadServiceImpl.class);

    @Autowired
    DeliveryUploadRepository deliveryUploadRepository;

    @Override
    public void insertDeliveryCancelLog(String returnFlag, String returnInfo, String deliveryId) {
        logger.info(" insertDeliveryCancelLog deliveryId:{},returnFlag:{},returnInfo:{}",deliveryId,returnFlag,returnInfo);
        deliveryUploadRepository.insertDeliveryCancelLog(returnFlag, returnInfo, deliveryId);
    }

    @Override
    public DeliveryUploadEntity save(DeliveryUploadEntity deliveryuploadEntity){
        logger.info("save DeliveryUploadEntity ");
        return deliveryUploadRepository.save(deliveryuploadEntity);
    }

}
