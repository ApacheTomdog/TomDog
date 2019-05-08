package com.brcc.business.brokerFunds.repository.impl;

import com.brcc.business.brokerFunds.repository.BrokerFundsDetailRepository;
import com.brcc.business.brokerFunds.repository.IBrokerFundsDetailRepository;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author pjy
 * @Date 2018-12-28
 **/
public class BrokerFundsDetailRepositoryImpl implements IBrokerFundsDetailRepository {
    @Autowired
    PageQuery pageQuery;
    @Override
    public BrokerFundsDetailVo queryDeliveryDetail(BrokerFundsDetailQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append( "select t.platform_id, ");
        sql.append( "t.publish_id, ");
        sql.append( "t.trans_id, ");
        sql.append( "t.delivery_id, ");
        sql.append( "t.publish_company_id, ");
        sql.append( "c.company_name as 'publishCompanyName', ");
        sql.append( "t.good_type, ");
        sql.append( "t.good_type_desc, ");
        sql.append( "d.name as 'driverName', ");
        sql.append( "t.driver_id, ");
        sql.append( "d.phone as 'driverPhone', ");
        sql.append( "t.vehicle_id, ");
        sql.append( "v.vehicle_num, ");
        sql.append( "v.vehicle_type, ");
        sql.append( "v.car_axle, ");
        sql.append( "g.start_plate, ");
        sql.append( "g.end_plate, ");
        sql.append( "g.estimateKM, ");
        sql.append( "t.create_date as 'qdCreateDate', ");
        sql.append( "ifnull(t.finish_time,t.shSure_date) as 'qdFinishDate', ");
        sql.append( "TIMESTAMPDIFF(MINUTE,t.create_date,ifnull(t.finish_time,t.shSure_date)) as 'useMinute' ");
        sql.append( "from   transportationdelivery t,	 ");
        sql.append( "company c, ");
        sql.append( "driver d, ");
        sql.append( "vehicle v, ");
        sql.append( "goodsorderm g ");
        sql.append( "WHERE	 ");
        sql.append( "1=1  ");
        sql.append( "and t.publish_company_id = c.seq_id ");
        sql.append( "AND d.id = t.driver_id ");
        sql.append( "AND v.vehicle_id = t.vehicle_id ");
        sql.append( "AND g.publish_id = t.publish_id ");
        sql.append( "AND t.status = '90' ");
        sql.append( "and t.delivery_id = ? ");
        args.add(vo.getDeliveryId());
        sql.append( "and g.platform_id = t.platform_id  ");
        sql.append( "and g.platform_id = ?  ");
        args.add(vo.getPlatformId());
        List<BrokerFundsDetailVo> list= pageQuery.list(sql.toString(),args,BrokerFundsDetailVo.class);
        return ObjectUtils.isEmpty(list) ? new BrokerFundsDetailVo():list.get(0);
    }
}

