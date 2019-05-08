package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述:
 * 经纪人业务逻辑接口类
 *
 * @author yushaohua
 * @create 2018-12-04 10:47
 */
public interface BrokerPeopleConfigService {

    /**
     * 获取经纪人信息
     * @return
     */
    BrokerPeopleConfigEntity queryUse(TransOrderSearchVo vo);
}