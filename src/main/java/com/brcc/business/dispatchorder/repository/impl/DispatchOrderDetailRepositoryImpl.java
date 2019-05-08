package com.brcc.business.dispatchorder.repository.impl;

import com.brcc.business.dispatchorder.repository.IDispatchOrderDetailRepository;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderSumVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 平台调度单详单数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-06 9:39
 */
public class DispatchOrderDetailRepositoryImpl implements IDispatchOrderDetailRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<DispatchOrderDetailVo> findAllPage(DispatchOrderDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  * ");
        sql.append("FROM ");
        sql.append("  (SELECT ");
        sql.append("    t.delivery_id, ");
        sql.append("    t.publish_id, ");
        sql.append("    (SELECT ");
        sql.append("      t2.company_name ");
        sql.append("    FROM ");
        sql.append("      Company t2 ");
        sql.append("    WHERE g.company_id = t2.seq_id) AS bill_senders, ");
        sql.append("    t.trans_id, ");
        sql.append("    t.weight, ");
        sql.append("    t.amount, ");
        sql.append("    t.price, ");
        sql.append("    ROUND(t.weight * t.price, 2) AS amountForPlat, ");
        sql.append("    d.id_num AS Card, ");
        sql.append("    t.qty, ");
        sql.append("    t.bill_taker, ");
        sql.append("    t.bill_taker_mobile, ");
        sql.append("    t.comfirm_pic_local, ");
        sql.append("    t.receiver_mobile, ");
        sql.append("    t.create_date, ");
        sql.append("    t.company_id, ");
        sql.append("    (SELECT ");
        sql.append("      t1.company_name ");
        sql.append("    FROM ");
        sql.append("      Company t1 ");
        sql.append("    WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("    (SELECT ");
        sql.append("      t1.contact_mobile ");
        sql.append("    FROM ");
        sql.append("      Company t1 ");
        sql.append("    WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("    d.id_num AS id_num, ");
        sql.append("    t.start_plate, ");
        sql.append("    t.end_plate, ");
        sql.append("    t.get_order_plate, ");
        sql.append("    t.driver_id, ");
        sql.append("    d.`name` AS NAME, ");
        sql.append("    d.`phone` AS phone, ");
        sql.append("    t.vehicle_id, ");
        sql.append("    v.vehicle_num AS vehicle_num, ");
        sql.append("    t.status, ");
        sql.append("    t.good_type_desc, ");
        sql.append("    t.bill_sender, ");
        sql.append("    t.bill_sender_mobile, ");
        sql.append("    t.take_delivery_weight, ");
        sql.append("    d.phone AS driver_mobile, ");
        sql.append("    IF( ");
        sql.append("      t.status = '10', ");
        sql.append("      '待取单', ");
        sql.append("      IF( ");
        sql.append("        t.status = '20', ");
        sql.append("        '待装货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '30', ");
        sql.append("          '待收货', ");
        sql.append("          IF( ");
        sql.append("            t.status = '90', ");
        sql.append("            '已完成', ");
        sql.append("            IF( ");
        sql.append("              t.status = '00', ");
        sql.append("              '已作废', ");
        sql.append("              '待取单' ");
        sql.append("            ) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) AS statusDesc, ");
        sql.append("    t.settle_weight, ");
        sql.append("    t.settle_amount, ");
        sql.append("    t.settle_status, ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '10', ");
        sql.append("      '未结算', ");
        sql.append("      IF( ");
        sql.append("        t.settle_status = '20', ");
        sql.append("        '已结算', ");
        sql.append("        '未结算' ");
        sql.append("      ) ");
        sql.append("    ) AS settleStatus, ");
        sql.append("    t.orther_flag, ");
        sql.append("    t.if_fd_judge, ");
        sql.append("    IF( ");
        sql.append("      t.orther_flag = '1', ");
        sql.append("      '已处理', ");
        sql.append("      '未处理' ");
        sql.append("    ) AS orther_flag_name, ");
        sql.append("    IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("    tm.prod_desc AS prod_desc, ");
        sql.append("    g.from_type AS from_type, ");
        sql.append("    g.logistics_mark, ");
        sql.append("    IF( ");
        sql.append("      g.from_type = 'DS', ");
        sql.append("      '销售电商', IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ),");
        sql.append("      IF( ");
        sql.append("        g.from_type = 'PT', ");
        sql.append("        '平台货源', ");
        sql.append("        IF( ");
        sql.append("          g.from_type = 'JK_U8', ");
        sql.append("          IF( ");
        sql.append("            g.logistics_mark = 'X', ");
        sql.append("            '大宗销售', ");
        sql.append("            '大宗采购' ");
        sql.append("          ), ");
        sql.append("          '平台货源' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    )) AS docOrigin, ");
        sql.append("    (SELECT ");
        sql.append("      t1.user_name ");
        sql.append("    FROM ");
        sql.append("      loginverify t1 ");
        sql.append("    WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("    g.pin_dan_num AS pinDanNum, ");
        sql.append("    t.delivery_time AS zcSureDate, ");
        sql.append("    t.update_date, ");
        sql.append("    t.pickup_date, ");
        sql.append("    t.finish_time, ");
        sql.append("    g.depend_num AS depend_num, ");
        sql.append("    t.standard_tax AS standard_tax, ");
        sql.append("    t.if_tax_transport, ");
        sql.append("    IF( ");
        sql.append("      t.if_tax_transport = 'Y', ");
        sql.append("      '是', ");
        sql.append("      '否' ");
        sql.append("    ) AS ifTaxTransport, ");
        sql.append("    c.early_warning_days AS early_warning_days, ");
        sql.append("    IF( ");
        sql.append("      t.if_tax_transport = 'Y', ");
        sql.append("      v1.vat_carry_name, ");
        sql.append("      c.company_name ");
        sql.append("    ) AS finally_pay, ");
        sql.append("    t.remark, ");
        sql.append("    IF( ");
        sql.append("      'p.trece_bank_type=1', ");
        sql.append("      '发单人维护账号', ");
        sql.append("      '承运人银行账号' ");
        sql.append("    ) AS receBankType, ");
        sql.append("    g.ds_if_settle AS dsIfSettle, ");
        sql.append("    IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("    IFNULL(t.truck_loading_weight, 0) AS zcWeight, ");
        sql.append("    IFNULL(t.take_delivery_weight, 0) AS shWeight, ");
        sql.append("    t.if_upload_receipt_flag, ");
        sql.append("    t.comfirm_pic1_local, ");
        sql.append("    IFNULL(j.dz_jk_cancel, 0) AS dz_jk_cancel, ");
        sql.append("    IFNULL( ");
        sql.append("      j.delivery_info_zdwl_source, ");
        sql.append("      '0' ");
        sql.append("    ) AS delivery_info_zdwl_source, ");
        sql.append("    t.operate_type, ");
        sql.append("    b.status AS driverStatus, ");
        sql.append("    IF( ");
        sql.append("      IFNULL(b.status, '10') > '10', ");
        sql.append("      'Y', ");
        sql.append("      'N' ");
        sql.append("    ) AS if_dengji_info, ");
        sql.append("    IF( ");
        sql.append("      IFNULL(b.status, '10') > '10', ");
        sql.append("      '是', ");
        sql.append("      '否' ");
        sql.append("    ) AS if_dengji_info_desc, ");
        sql.append("    IF( ");
        sql.append("      IFNULL(b.status, '10') = '30', ");
        sql.append("      'Y', ");
        sql.append("      'N' ");
        sql.append("    ) AS if_gs_info, ");
        sql.append("    IF( ");
        sql.append("      IFNULL(b.status, '10') = '30', ");
        sql.append("      '是', ");
        sql.append("      '否' ");
        sql.append("    ) AS if_gs_info_desc, ");
        sql.append("    IF( ");
        sql.append("      b.status = '10', ");
        sql.append("      '未申请', ");
        sql.append("      IF( ");
        sql.append("        b.status = '20', ");
        sql.append("        '申请中', ");
        sql.append("        IF( ");
        sql.append("          b.status = '30', ");
        sql.append("          '已开户', ");
        sql.append("          IF( ");
        sql.append("            b.status = '25', ");
        sql.append("            '已申请', ");
        sql.append("            '未知' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) AS driverStatusDesc, ");
        sql.append("    v1.vat_carry_name, ");
        sql.append("    IF( ");
        sql.append("      t.if_tax_transport = 'Y', ");
        sql.append("      (SELECT ");
        sql.append("        t1.company_name ");
        sql.append("      FROM ");
        sql.append("        company t1 ");
        sql.append("      WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("      '' ");
        sql.append("    ) AS carryCompanyName ");
        sql.append("  FROM ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        ( ");
        sql.append("          TransportationDelivery AS t ");
        sql.append("          LEFT JOIN driver d ");
        sql.append("            ON t.driver_id = d.id ");
        sql.append("        ) ");
        sql.append("        LEFT JOIN goodsorderm g ");
        sql.append("          ON t.publish_id = g.publish_id ");
        sql.append("      ) ");
        sql.append("      JOIN TransportationM tm ");
        sql.append("        ON t.trans_id = tm.trans_id ");
        sql.append("    ) ");
        sql.append("    LEFT JOIN vehicle v ");
        sql.append("      ON t.vehicle_id = v.vehicle_id ");
        sql.append("    LEFT JOIN goodsordermjksetplat j ");
        sql.append("      ON ( ");
        sql.append("        j.tms_fd_company_id = t.publish_company_id ");
        sql.append("        AND j.tms_from_type = g.from_type ");
        sql.append("        AND j.tms_platform_id = t.platform_id ");
        sql.append("        AND j.tms_from_type = 'JK_U8' ");
        sql.append("        AND j.ec_plat_name = g.from_plat_name ");
        sql.append("      ) ");
        sql.append("    LEFT JOIN vatflowdetail v1 ");
        sql.append("      ON ( ");
        sql.append("        v1.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("        AND t.if_tax_transport = 'Y' ");
        sql.append("        AND v1.if_end = 'Y' ");
        sql.append("      ) ");
        sql.append("    LEFT JOIN company c ");
        sql.append("      ON (c.seq_id = t.publish_company_id) ");
        sql.append("    LEFT JOIN business_registration b ");
        sql.append("      ON (d.id_num = b.id_num) ");
        sql.append("  WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(vo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getPublisherCompanyId())){
            sql.append(" AND t.publish_company_id = ? ");
            args.add(vo.getPublisherCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= ? ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= ? ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status in (?) ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getShWeight())){
            if("0".equalsIgnoreCase(vo.getShWeight())){
                sql.append(" AND t.take_delivery_weight = '0' ");
            }else if("1".equalsIgnoreCase(vo.getShWeight())){
                sql.append(" AND (t.take_delivery_weight IS NULL or t.take_delivery_weight !='0') ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getDeFlag())){
            sql.append(" AND t.orther_flag = ? ");
            args.add(vo.getDeFlag());
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND t.bill_sender like CONCAT('%',?,'%') ");
            args.add(vo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(vo.getEvaluate())){
            if("N".equalsIgnoreCase(vo.getEvaluate())){
                sql.append(" AND t.if_fd_judge is null or t.if_fd_judge = 'N' ");
            }else if("Y".equalsIgnoreCase(vo.getEvaluate())){
                sql.append(" AND t.if_fd_judge = 'Y' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getPayType())){
            sql.append(" AND ifnull(t.settle_status,10) = ? ");
            args.add(vo.getPayType());
        }

        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle=? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverStatus())){
            sql.append(" AND b.status= ? ");
            args.add(vo.getDriverStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getIfDengjiInfo())){
            if("Y".equalsIgnoreCase(vo.getIfDengjiInfo())){
                sql.append(" AND ifnull(b.status,'10') > '10' ");
            }else if("N".equalsIgnoreCase(vo.getIfDengjiInfo())){
                sql.append(" AND ifnull(b.status,'10') <= '10' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getIfGsInfo())){
            if("Y".equalsIgnoreCase(vo.getIfGsInfo())){
                sql.append(" AND ifnull(b.status,'10') = '30' ");
            }else if("N".equalsIgnoreCase(vo.getIfGsInfo())){
                sql.append(" AND ifnull(b.status,'10') <> '30' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getFinallyPay())){
            sql.append(" AND if(t.if_tax_transport='Y',v1.vat_carry_name , c.company_name) like CONCAT('%',?,'%') ");
            args.add(vo.getFinallyPay());
        }

        sql.append("limit 30 )AS t order by t.CREATE_DATE desc");

        return pageQuery.query(sql.toString(), args, vo, DispatchOrderDetailVo.class);

    }

    @Override
    public DispatchOrderSumVo findOrderSum(DispatchOrderDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  ROUND(SUM(IFNULL(t.weight, 0)), 3) AS sumWeight, ");
        sql.append("  ROUND( ");
        sql.append("    SUM(IFNULL(t.truck_loading_weight, 0)), ");
        sql.append("    3 ");
        sql.append("  ) AS sumZcWeight, ");
        sql.append("  ROUND( ");
        sql.append("    SUM(IFNULL(t.take_delivery_weight, 0)), ");
        sql.append("    3 ");
        sql.append("  ) AS sumShWeight ");
        sql.append("FROM ");
        sql.append("  (SELECT ");
        sql.append("    t.weight, ");
        sql.append("    t.truck_loading_weight, ");
        sql.append("    t.take_delivery_weight ");
        sql.append("  FROM ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        ( ");
        sql.append("          TransportationDelivery AS t ");
        sql.append("          LEFT JOIN driver d ");
        sql.append("            ON t.driver_id = d.id ");
        sql.append("        ) ");
        sql.append("        LEFT JOIN goodsorderm g ");
        sql.append("          ON t.publish_id = g.publish_id ");
        sql.append("      ) ");
        sql.append("      JOIN TransportationM tm ");
        sql.append("        ON t.trans_id = tm.trans_id ");
        sql.append("    ) ");
        sql.append("    LEFT JOIN vehicle v ");
        sql.append("      ON t.vehicle_id = v.vehicle_id ");
        sql.append("    LEFT JOIN goodsordermjksetplat j ");
        sql.append("      ON ( ");
        sql.append("        j.tms_fd_company_id = t.publish_company_id ");
        sql.append("        AND j.tms_from_type = g.from_type ");
        sql.append("        AND j.tms_platform_id = t.platform_id ");
        sql.append("        AND j.tms_from_type = 'JK_U8' ");
        sql.append("        AND j.ec_plat_name = g.from_plat_name ");
        sql.append("      ) ");
        sql.append("    LEFT JOIN vatflowdetail v1 ");
        sql.append("      ON ( ");
        sql.append("        v1.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("        AND t.if_tax_transport = 'Y' ");
        sql.append("        AND v1.if_end = 'Y' ");
        sql.append("      ) ");
        sql.append("    LEFT JOIN company c ");
        sql.append("      ON (c.seq_id = t.publish_company_id) ");
        sql.append("    LEFT JOIN business_registration b ");
        sql.append("      ON (d.id_num = b.id_num) ");
        sql.append("  WHERE 1 = 1 ");

        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(vo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getPublisherCompanyId())){
            sql.append(" AND t.publish_company_id = ? ");
            args.add(vo.getPublisherCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= ? ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= ? ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status in (?) ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getShWeight())){
            if("0".equalsIgnoreCase(vo.getShWeight())){
                sql.append(" AND t.take_delivery_weight = '0' ");
            }else if("1".equalsIgnoreCase(vo.getShWeight())){
                sql.append(" AND (t.take_delivery_weight IS NULL or t.take_delivery_weight !='0') ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getDeFlag())){
            sql.append(" AND t.orther_flag = ? ");
            args.add(vo.getDeFlag());
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND t.bill_sender like CONCAT('%',?,'%') ");
            args.add(vo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(vo.getEvaluate())){
            if("N".equalsIgnoreCase(vo.getEvaluate())){
                sql.append(" AND t.if_fd_judge is null or t.if_fd_judge = 'N' ");
            }else if("Y".equalsIgnoreCase(vo.getEvaluate())){
                sql.append(" AND t.if_fd_judge = 'Y' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getPayType())){
            sql.append(" AND ifnull(t.settle_status,10) = ? ");
            args.add(vo.getPayType());
        }

        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle=? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        if (!ObjectUtils.isEmpty(vo.getDriverStatus())){
            sql.append(" AND b.status= ? ");
            args.add(vo.getDriverStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getIfDengjiInfo())){
            if("Y".equalsIgnoreCase(vo.getIfDengjiInfo())){
                sql.append(" AND ifnull(b.status,'10') > '10' ");
            }else if("N".equalsIgnoreCase(vo.getIfDengjiInfo())){
                sql.append(" AND ifnull(b.status,'10') <= '10' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getIfGsInfo())){
            if("Y".equalsIgnoreCase(vo.getIfGsInfo())){
                sql.append(" AND ifnull(b.status,'10') = '30' ");
            }else if("N".equalsIgnoreCase(vo.getIfGsInfo())){
                sql.append(" AND ifnull(b.status,'10') <> '30' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getFinallyPay())){
            sql.append(" AND if(t.if_tax_transport='Y',v1.vat_carry_name , c.company_name) like CONCAT('%',?,'%') ");
            args.add(vo.getFinallyPay());
        }

        sql.append("limit 30 )AS t ");

        List<DispatchOrderSumVo> list = pageQuery.list(sql.toString(), args, DispatchOrderSumVo.class);

        if(list != null){
            return list.get(0);
        }

        return null;
    }
}