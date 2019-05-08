package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.OperateconfigEntity;
import com.brcc.business.dispatchorder.repository.OperateConfigRepository;
import com.brcc.business.dispatchorder.service.OperateConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-06 13:27
 */
@Service
public class OperateConfigServiceImpl implements OperateConfigService {

    @Autowired
    private OperateConfigRepository operateConfigRepository;

    @Override
    public OperateconfigEntity queryIntervalTime(String deliveryId) {
        return operateConfigRepository.queryIntervalTime(deliveryId);
    }
}