package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.repository.IViewAbnormalRepository;
import com.brcc.business.transorder.vo.ViewAbnormalSearchVo;
import com.brcc.business.transorder.vo.ViewAbnormalVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 平台调度单异常信息数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-14 16:50
 */
public class ViewAbnormalRepositoryImpl implements IViewAbnormalRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<ViewAbnormalVo> findAllPage(ViewAbnormalSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  v.delivery_id, ");
        sql.append("  v.publish_id, ");
        sql.append("  v.trans_id, ");
        sql.append("  IFNULL(v.depend_num, 0) as depend_num, ");
        sql.append("  IFNULL(c.company_name, '') AS transCompanyName, ");
        sql.append("  IFNULL(c1.company_name, '') AS billCompanyName, ");
        sql.append("  IFNULL(d.name, '') as name, ");
        sql.append("  d.id_num, ");
        sql.append("  vh.vehicle_num, ");
        sql.append("  v.get_order_plate, ");
        sql.append("  v.prod_desc, ");
        sql.append("  v.end_plate, ");
        sql.append("  v.start_plate, ");
        sql.append("  v.weight, ");
        sql.append("  v.amount, ");
        sql.append("  v.price, ");
        sql.append("  v.bill_sender, ");
        sql.append("  v.bill_sender_mobile, ");
        sql.append("  v.bill_taker_mobile, ");
        sql.append("  v.bill_taker, ");
        sql.append("  v.create_date, ");
        sql.append("  v.bill_time, ");
        sql.append("  v.finish_time, ");
        sql.append("  v.good_type, ");
        sql.append("  v.good_type_desc, ");
        sql.append("  v.max_time, ");
        sql.append("  v.min_time, ");
        sql.append("  v.actual_time, ");
        sql.append("  IF( ");
        sql.append("    v.from_type = 'DS', ");
        sql.append("    '销售电商',IF(v.from_type = 'JK_U11', IF( v.logistics_mark = 'X', '销售物流', '采购物流' ), ");
        sql.append("    IF( ");
        sql.append("      v.from_type = 'PT', ");
        sql.append("      '平台货源', ");
        sql.append("      IF( ");
        sql.append("        v.from_type = 'JK_U8', ");
        sql.append("        IF( ");
        sql.append("          v.logistics_mark = 'X', ");
        sql.append("          '大宗销售', ");
        sql.append("          '大宗采购' ");
        sql.append("        ), ");
        sql.append("        '平台货源' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  )) AS docOrigin, ");
        sql.append("  IFNULL(v.take_delivery_weight, 0) shWeight, ");
        sql.append("  IFNULL(v.truck_loading_weight, 0) zcWeight, ");
        sql.append("  IFNULL(c.contact_name, '') as contact_name, ");
        sql.append("  IFNULL(c.contact_mobile, '') as contact_mobile, ");
        sql.append("  IFNULL(d.phone, '') as phone, ");
        sql.append("  IF( ");
        sql.append("    v.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS if_tax_transport ");
        sql.append("FROM ");
        sql.append("  view_abnormal v ");
        sql.append("  LEFT JOIN company c ");
        sql.append("    ON (v.company_id = c.seq_id) ");
        sql.append("  LEFT JOIN company c1 ");
        sql.append("    ON (v.publish_company_id = c1.seq_id) ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON (v.driver_id = d.id) ");
        sql.append("  LEFT JOIN vehicle vh ");
        sql.append("    ON (v.vehicle_id = vh.vehicle_id) ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND v.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND v.publish_company_id = ? ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND v.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND v.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND v.delivery_id like concat('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND vh.vehicle_num like concat('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND d.name like concat('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND v.depend_num like concat('%',?,'%') ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND c1.company_name like concat('%',?,'%') ");
            args.add(vo.getCompanyName());
        }

        sql.append(" order by v.create_date desc ");

        return pageQuery.query(sql.toString(), args, vo, ViewAbnormalVo.class);
    }

    @Override
    public List<ViewAbnormalVo> listData(ViewAbnormalSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  v.delivery_id, ");
        sql.append("  v.publish_id, ");
        sql.append("  v.trans_id, ");
        sql.append("  IFNULL(v.depend_num, 0) as depend_num, ");
        sql.append("  IFNULL(c.company_name, '') AS transCompanyName, ");
        sql.append("  IFNULL(c1.company_name, '') AS billCompanyName, ");
        sql.append("  IFNULL(d.name, '') as name, ");
        sql.append("  d.id_num, ");
        sql.append("  vh.vehicle_num, ");
        sql.append("  v.get_order_plate, ");
        sql.append("  v.prod_desc, ");
        sql.append("  v.end_plate, ");
        sql.append("  v.start_plate, ");
        sql.append("  v.weight, ");
        sql.append("  v.amount, ");
        sql.append("  v.price, ");
        sql.append("  v.bill_sender, ");
        sql.append("  v.bill_sender_mobile, ");
        sql.append("  v.bill_taker_mobile, ");
        sql.append("  v.bill_taker, ");
        sql.append("  v.create_date, ");
        sql.append("  v.bill_time, ");
        sql.append("  v.finish_time, ");
        sql.append("  v.good_type, ");
        sql.append("  v.good_type_desc, ");
        sql.append("  v.max_time, ");
        sql.append("  v.min_time, ");
        sql.append("  v.actual_time, ");
        sql.append("  IF( ");
        sql.append("    v.from_type = 'DS', ");
        sql.append("    '销售电商', ");
        sql.append("    IF(v.from_type = 'JK_U11', IF( v.logistics_mark = 'X',");
        sql.append("       '销售物流', '采购物流' )  ");
        sql.append("      ,IF( ");
        sql.append("      v.from_type = 'PT', ");
        sql.append("      '平台货源', ");
        sql.append("      IF( ");
        sql.append("        v.from_type = 'JK_U8', ");
        sql.append("        IF( ");
        sql.append("          v.logistics_mark = 'X', ");
        sql.append("          '大宗销售', ");
        sql.append("          '大宗采购' ");
        sql.append("        ), ");
        sql.append("        '平台货源' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  )) AS docOrigin, ");
        sql.append("  IFNULL(v.take_delivery_weight, 0) shWeight, ");
        sql.append("  IFNULL(v.truck_loading_weight, 0) zcWeight, ");
        sql.append("  IFNULL(c.contact_name, '') as contact_name, ");
        sql.append("  IFNULL(c.contact_mobile, '') as contact_mobile, ");
        sql.append("  IFNULL(d.phone, '') as phone, ");
        sql.append("  IF( ");
        sql.append("    v.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS if_tax_transport ");
        sql.append("FROM ");
        sql.append("  view_abnormal v ");
        sql.append("  LEFT JOIN company c ");
        sql.append("    ON (v.company_id = c.seq_id) ");
        sql.append("  LEFT JOIN company c1 ");
        sql.append("    ON (v.publish_company_id = c1.seq_id) ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON (v.driver_id = d.id) ");
        sql.append("  LEFT JOIN vehicle vh ");
        sql.append("    ON (v.vehicle_id = vh.vehicle_id) ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND v.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND v.publish_company_id = ? ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND v.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND v.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND v.delivery_id like concat('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND vh.vehicle_num like concat('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND d.name like concat('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND v.depend_num like concat('%',?,'%') ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND c1.company_name like concat('%',?,'%') ");
            args.add(vo.getCompanyName());
        }

        sql.append(" order by v.create_date desc ");

        return pageQuery.list(sql.toString(), args, ViewAbnormalVo.class);
    }
}