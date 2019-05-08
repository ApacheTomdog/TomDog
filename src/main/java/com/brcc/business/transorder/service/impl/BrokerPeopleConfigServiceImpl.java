package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.brcc.business.transorder.repository.BrokerPeopleConfigRepository;
import com.brcc.business.transorder.service.BrokerPeopleConfigService;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 经纪人业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 10:48
 */
@Service
public class BrokerPeopleConfigServiceImpl implements BrokerPeopleConfigService {

    @Autowired
    private BrokerPeopleConfigRepository brokerPeopleConfigRepository;

    @Override
    public BrokerPeopleConfigEntity queryUse(TransOrderSearchVo vo) {
        return brokerPeopleConfigRepository.queryUse(vo);
    }
}