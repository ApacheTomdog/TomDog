package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.brcc.business.transorder.repository.IBrokerPeopleConfigRepository;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 经纪人数据接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 14:07
 */
public class BrokerPeopleConfigRepositoryImpl implements IBrokerPeopleConfigRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public BrokerPeopleConfigEntity queryUse(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT * FROM apptms.broker_people_config b ");
        sql.append(" WHERE 1=1 and b.platform_id = ? and broker_people_company_id = ? and b.status='20' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        List<BrokerPeopleConfigEntity> list = pageQuery.list(sql.toString(), args, BrokerPeopleConfigEntity.class);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

}