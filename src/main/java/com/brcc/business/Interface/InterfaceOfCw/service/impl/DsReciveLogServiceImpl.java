package com.brcc.business.Interface.InterfaceOfCw.service.impl;

import com.brcc.business.Interface.InterfaceOfCw.entity.DsReceiveLogEntity;
import com.brcc.business.Interface.InterfaceOfCw.repository.DsReceiveLogRepositorys;
import com.brcc.business.Interface.InterfaceOfCw.service.DsReciveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: zoujinsong
 * @Date: 2019/4/25/025 13
 */
@Service
public class DsReciveLogServiceImpl implements DsReciveLogService {
    @Autowired
    private DsReceiveLogRepositorys dsReceiveLogRepositorys;
    @Override
    public Long record(DsReceiveLogEntity dsReceiveLogEntity) {
        dsReceiveLogRepositorys.saveAndFlush(dsReceiveLogEntity);
        return dsReceiveLogEntity.getId();
    }
}
