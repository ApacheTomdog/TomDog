package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.DeliveryuploadConfigEntity;

/**
 * ESTeel
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-12-03
 * Time: 15:31
 */
public interface DeliveryUploadConfigService {
    /**
     * 根据接口名称获取对象
     * @param jkName
     * @return
     */
    DeliveryuploadConfigEntity findByJkName(String jkName);
}
