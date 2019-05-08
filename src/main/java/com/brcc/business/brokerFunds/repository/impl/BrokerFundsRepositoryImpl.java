package com.brcc.business.brokerFunds.repository.impl;

import com.brcc.business.brokerFunds.repository.IBrokerFundsRepository;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import com.esteel.common.dao.PageQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 经纪人资金流水上传Repository
 * @Author pjy
 * @Date 2018/12/27
 **/
public class BrokerFundsRepositoryImpl implements IBrokerFundsRepository {
    @Autowired
    PageQuery pageQuery;
    @Override
    public Page<BrokerFundsVo> brokerFundsList(BrokerFundsQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select b.* from apptms.brokerfundscontrolmaster b");
        sql.append(" where 1=1 ");
        sql.append(" and b.platform_id=? ");
        args.add(vo.getPlatformId() );
        sql.append(" and  b.borker_company_id =?  ");
        args.add(vo.getCompanyId());
        if(vo.getFundsControlMasterId() !=null){
            sql.append("and  b.funds_control_master_id = ? ");
            args.add(vo.getFundsControlMasterId());
        }
        if(vo.getRqStart()!=null){
            sql.append("and  b.create_date >= ? ");
            args.add(vo.getRqStart());
        }
        if(vo.getRqEnd()!=null){
            sql.append("and  b.create_date <= ? ");
            args.add(vo.getRqEnd());
        }
        sql.append(" order by b.create_date desc");
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsVo.class);
    }
    @Override
    public Page<BrokerFundsDetailVo> addBrokerFundsDetailList(BrokerFundsDetailQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select  t.platform_id," );
        sql.append("	t.publish_id,");
        sql.append("	t.trans_id,");
        sql.append("	t.delivery_id,");
        sql.append("	t.publish_company_id,");
        sql.append("	c.company_name as 'publishCompanyName',");
        sql.append("	t.good_type,");
        sql.append("	t.good_type_desc,");
        sql.append("	t.driver_id,");
        sql.append("	d.name as 'driverName',");
        sql.append("	d.phone as 'driverPhone',");
        sql.append("	t.vehicle_id,");
        sql.append("	v.vehicle_num,");
        sql.append("	v.vehicle_type,");
        sql.append("	v.car_axle,");
        sql.append("	g.start_plate,");
        sql.append("	g.end_plate,");
        sql.append("	g.estimateKM,");
        sql.append("	t.create_date as 'qdCreateDate',");
        sql.append("	ifnull(t.finish_time,t.shSure_date) AS 'qdFinishDate',");
        sql.append("	TIMESTAMPDIFF(MINUTE,t.create_date,ifnull(t.finish_time,t.shSure_date)) AS 'useMinute' ");
        sql.append(" from transportationdelivery t, ");
        sql.append("	company c,");
        sql.append("	driver d,");
        sql.append("	vehicle v,");
        sql.append("	goodsorderm g ");
        sql.append("WHERE 1=1 ");
        sql.append("	and t.publish_company_id = c.seq_id");
        sql.append("	AND d.id = t.driver_id");
        sql.append("	AND v.vehicle_id = t.vehicle_id");
        sql.append("	AND g.publish_id = t.publish_id");
        sql.append("	AND t.company_id = ? ");
        args.add(vo.getCompanyId());
        sql.append("	and t.if_funds_control_flag ='1'");
        sql.append("	and t.status = '90'");
        sql.append("	and t.platform_id = ? ");
        args.add(vo.getPlatformId());
        sql.append("	and g.platform_id = t.platform_id");
        sql.append("	and t.if_tax_transport ='Y'");
        sql.append("	and not exists(select 1 from pay_bill p where p.delivery_id = t.delivery_id and p.status > '10')");
        sql.append("	and t.if_funds_control_flag ='1'");
        if(!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" and d.name like ?");
            args.add("%" +vo.getDriverName()+ "%");
        }
        if(vo.getDeliveryId()!=null){
            sql.append(" and t.delivery_id like ?");
            args.add("%" + vo.getDeliveryId()+ "%");
        }
        if(vo.getPublishId() !=null){
           sql.append(" and t.publish_id like ?");
           args.add("%" + vo.getPublishId()+ "%");
       }
        if(!ObjectUtils.isEmpty(vo.getPublishCompanyName())){
            sql.append(" and c.company_name like ?");
            args.add("%" + vo.getPublishCompanyName()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getGoodTypeDesc())){
            sql.append(" and t.good_type_desc like ? ");
            args.add("%" + vo.getGoodTypeDesc()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getDriverPhone())){
            sql.append(" and d.phone like ? ");
            args.add("%" + vo.getDriverPhone()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" and v.vehicle_num like ? ");
            args.add("%" + vo.getVehicleNum()+ "%");
        }

        if(!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" and t.start_plate like ? ");
            args.add("%" + vo.getStartPlate()+ "%");
        }

        if(!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" and t.end_plate like ? ");
            args.add("%" + vo.getEndPlate()+ "%");
        }
        if(vo.getRqStart()!=null){
            sql.append("and  t.create_date >= ? ");
            args.add(vo.getRqStart());
        }
        if(vo.getRqEnd()!=null){
            sql.append("and  t.create_date <= ? ");
            args.add(vo.getRqEnd());
        }
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsDetailVo.class);
    }

    @Override
    public Page<BrokerFundsDetailVo> lookBrokerFundsDetailList(BrokerFundsDetailQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select  * from brokerfundscontroldetail t " );
        sql.append(" WHERE 1=1 ");
        sql.append(" and t.funds_control_master_id = ? ");
        args.add(vo.getFundsControlMasterId());
        if(!ObjectUtils.isEmpty(vo.getDriverName())){
            sql.append(" and t.driver_name like ?");
            args.add("%" +vo.getDriverName()+ "%");
        }
        if(vo.getDeliveryId()!=null){
            sql.append(" and t.delivery_id like ?");
            args.add("%" + vo.getDeliveryId()+ "%");
        }
        if(vo.getPublishId() !=null){
            sql.append(" and t.publish_id like ?");
            args.add("%" + vo.getPublishId()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getPublishCompanyName())){
            sql.append(" and t.publish_company_name like ?");
            args.add("%" + vo.getPublishCompanyName()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getGoodTypeDesc())){
            sql.append(" and t.good_type_desc like ? ");
            args.add("%" + vo.getGoodTypeDesc()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getDriverPhone())){
            sql.append(" and t.driver_phone like ? ");
            args.add("%" + vo.getDriverPhone()+ "%");
        }
        if(!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" and t.vehicle_num like ? ");
            args.add("%" + vo.getVehicleNum()+ "%");
        }

        if(!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" and t.start_plate like ? ");
            args.add("%" + vo.getStartPlate()+ "%");
        }

        if(!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" and t.end_plate like ? ");
            args.add("%" + vo.getEndPlate()+ "%");
        }
        if(vo.getRqStart()!=null){
            sql.append("and  t.create_date >= ? ");
            args.add(vo.getRqStart());
        }
        if(vo.getRqEnd()!=null){
            sql.append("and  t.create_date <= ? ");
            args.add(vo.getRqEnd());
        }
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsDetailVo.class);
    }
}
