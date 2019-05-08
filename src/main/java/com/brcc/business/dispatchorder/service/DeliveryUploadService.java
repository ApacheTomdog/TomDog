package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.DeliveryUploadEntity;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 17:56
 */
public interface DeliveryUploadService {

    /**
     * 保存 取消 日志
     * @param returnFlag
     * @param returnInfo
     * @param deliveryId
     */
    void insertDeliveryCancelLog(String returnFlag, String returnInfo, String deliveryId);

    DeliveryUploadEntity save(DeliveryUploadEntity deliveryuploadEntity);
}
