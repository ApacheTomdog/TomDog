package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.OperateconfigEntity;
import org.springframework.data.jpa.repository.Query;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-06 13:26
 */
public interface OperateConfigService {

    /**
     * 根据delivery_id查询记录
     * @param deliveryId
     * @return
     */
    OperateconfigEntity queryIntervalTime(String deliveryId);
}