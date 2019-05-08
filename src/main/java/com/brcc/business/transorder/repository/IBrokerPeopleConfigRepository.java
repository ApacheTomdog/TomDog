package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.brcc.business.transorder.vo.TransOrderSearchVo;

/**
 * 描述:
 * 经纪人数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-12-04 14:06
 */
public interface IBrokerPeopleConfigRepository {

    /**
     * 获取经纪人信息
     * @return
     */
    BrokerPeopleConfigEntity queryUse(TransOrderSearchVo vo);
}