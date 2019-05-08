package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.repository.ITransOrderDetailRepository;
import com.brcc.business.transorder.vo.TransOrderDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDetailVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 平台运输单详情数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-01 16:51
 */
public class TransOrderDetailRepositoryImpl implements ITransOrderDetailRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public List<TransOrderDetailVo> findOrderDetail(TransOrderDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.appoint_person_info, ");
        sql.append("  t.publish_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.qty, ");
        sql.append("  t.amount, ");
        sql.append("  t.`status`, ");
        sql.append("  t.platform_id, ");
        sql.append("  t.create_date, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS createDate, ");
        sql.append("  t.pickup_date, ");
        sql.append("  IF(t.pickup_date < NOW(), 'Y', 'N') AS isTimeOut, ");
        sql.append("  t.limit_time, ");
        sql.append("  t.ps AS remark, ");
        sql.append("  t.depend_num, ");
        sql.append("  t.price, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.from_type, ");
        sql.append("  t.prod_desc, ");
        sql.append("  t.init_qty, ");
        sql.append("  CAST(t.init_amount AS DECIMAL (18, 2)) AS init_amount, ");
        sql.append("  CAST( ");
        sql.append("    (t.init_weight * t.price_tax) AS DECIMAL (18, 2) ");
        sql.append("  ) AS init_amount_tax, ");
        sql.append("  t.get_order_plate, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.init_weight, ");
        sql.append("  t.sendKM, ");
        sql.append("  t.`sender`, ");
        sql.append("  t.`sender_mobile`, ");
        sql.append("  t.`receiver_mobile`, ");
        sql.append("  t.`receiver`, ");
        sql.append("  t.`bill_sender`, ");
        sql.append("  t.`bill_sender_mobile`, ");
        sql.append("  t.`bill_taker`, ");
        sql.append("  t.`bill_taker_mobile`, ");
        sql.append("  t.vehicle_style_var, ");
        sql.append("  t.`prod_desc`, ");
        sql.append("  t.`heavy_piece`, ");
        sql.append("  t.good_price, ");
        sql.append("  t.`loss_type`, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_weight * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  t.loss_ratio, ");
        sql.append("  t.loss_weight, ");
        sql.append("  t.`detachable`, ");
        sql.append("  IF( ");
        sql.append("    t.detachable = 0, ");
        sql.append("    '不可拆', ");
        sql.append("    IF( ");
        sql.append("      t.detachable = 1, ");
        sql.append("      '可拆', ");
        sql.append("      '不可拆' ");
        sql.append("    ) ");
        sql.append("  ) AS detachable_desc, ");
        sql.append("  t.`depend_num2`, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.sale_weight, ");
        sql.append("  t.sale_weight AS bill_weight, ");
        sql.append("  IF( ");
        sql.append("    t.status = '00', ");
        sql.append("    '已作废', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      IF( ");
        sql.append("        t.sale_weight > 0, ");
        sql.append("        '已抢单', ");
        sql.append("        '未抢单' ");
        sql.append("      ), ");
        sql.append("      IF( ");
        sql.append("        t.`status` = '30', ");
        sql.append("        '已完成', ");
        sql.append("        IF( ");
        sql.append("          t.`status` = '60', ");
        sql.append("          '已终止', ");
        sql.append("          '未知' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS status_desc, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(t1.weight) ");
        sql.append("  FROM ");
        sql.append("    transportationdelivery t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id ");
        sql.append("    AND t.status != '00' ");
        sql.append("    AND t1.status != '00' ");
        sql.append("    AND t1.platform_id = t.platform_id) AS trans_weight, ");
        sql.append("  IF(t.appoint_company_id = '', 'N', 'Y') appoint_flag, ");
        sql.append("  t.qb_type, ");
        sql.append("  t.max_price, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id ");
        sql.append("    AND t1.platform_id = t.platform_id) AS consignor_name, ");
        sql.append("  t.appoint_team_type, ");
        sql.append("  t.estimateKM, ");
        sql.append("  t.appoint_team_id, ");
        sql.append("  t.send_group AS send_group_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.team_name ");
        sql.append("  FROM ");
        sql.append("    teamcompany t1 ");
        sql.append("  WHERE t1.team_id = t.appoint_team_id ");
        sql.append("  LIMIT 0, 1) AS appoint_team_name, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.send_group, '') = 'ALL', ");
        sql.append("    '全部', ");
        sql.append("    IF( ");
        sql.append("      IFNULL(t.send_group, '') = 'WEB', ");
        sql.append("      'WEB用户', ");
        sql.append("      IF( ");
        sql.append("        IFNULL(t.send_group, '') = 'APP', ");
        sql.append("        '手机APP用户', ");
        sql.append("        '' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS send_group, ");
        sql.append("  t.ps2, ");
        sql.append("  t.ps3, ");
        sql.append("  t.ps4, ");
        sql.append("  t.ps5, ");
        sql.append("  t.ps1, ");
        sql.append("  t.company_id AS fd_company_id, ");
        sql.append("  t.docu_pri_sec, ");
        sql.append("  t.docu_type, ");
        sql.append("  t.pin_dan_num, ");
        sql.append("  t.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(t.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransportDesc, ");
        sql.append("  t.price_tax, ");
        sql.append("  t.vat_flow_master_id, ");
        sql.append("  t.listing_price AS listingPrice, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.charge_price_type, 0) = 0, ");
        sql.append("    '元/每车', ");
        sql.append("    '元/吨' ");
        sql.append("  ) AS chargePriceType, ");
        sql.append("  IFNULL(t.charge_price, 0) AS chargePrice, ");
        sql.append("  t.pick_up_goods_name AS pickUpGoodsName, ");
        sql.append("  IF( ");
        sql.append("    t.from_type = 'JK_U9', ");
        sql.append("    '新大宗采购',IF(t.from_type = 'JK_U11', IF( t.logistics_mark = 'X', '销售物流', '采购物流' ), ");
        sql.append("    IF( ");
        sql.append("      t.from_type = 'DS', ");
        sql.append("      '销售电商', ");
        sql.append("      IF( ");
        sql.append("        t.from_type = 'PT', ");
        sql.append("        '平台货源', ");
        sql.append("        IF( ");
        sql.append("          t.from_type = 'JK_U8', ");
        sql.append("          IF( ");
        sql.append("            t.logistics_mark = 'X', ");
        sql.append("            '大宗销售', ");
        sql.append("            '大宗采购' ");
        sql.append("          ), ");
        sql.append("          '平台货源' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  )) AS docOrigin, ");
        sql.append("  IFNULL(v.vat_flow_master_name, '') AS vatFlowMasterName, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.owner_adjust_flag, ");
        sql.append("  t.owner_adjust_type, ");
        sql.append("  t.owner_adjust_amt, ");
        sql.append("  t.dq_flag, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.dq_stt_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS dq_stt_date, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.dq_end_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS dq_end_date ");
        sql.append("FROM ");
        sql.append("  goodsorderm AS t ");
        sql.append("  LEFT JOIN vatflowmaster v ");
        sql.append("    ON ( ");
        sql.append("      t.vat_flow_master_id = v.vat_flow_master_id ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN company t1 ");
        sql.append("    ON ( ");
        sql.append("      t1.seq_id = t.company_id ");
        sql.append("      AND t1.platform_id = t.platform_id ");
        sql.append("    ) ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.status != '10' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        // 公司ID
        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? ");
            args.add(vo.getCompanyId());
        }

        // 货源单ID
        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? limit 0,1");
            args.add(vo.getPublishId());
        }

        return pageQuery.list(sql.toString(), args, TransOrderDetailVo.class);
    }

    @Override
    public List<TransOrderDetailVo> findTaxOrderDetail(TransOrderDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.appoint_person_info, ");
        sql.append("  t.publish_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.qty, ");
        sql.append("  t.amount, ");
        sql.append("  t.`status`, ");
        sql.append("  t.platform_id, ");
        sql.append("  t.create_date, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS createDate, ");
        sql.append("  t.pickup_date, ");
        sql.append("  IF(t.pickup_date < NOW(), 'Y', 'N') AS isTimeOut, ");
        sql.append("  t.limit_time, ");
        sql.append("  t.ps AS remark, ");
        sql.append("  t.depend_num, ");
        sql.append("  ROUND(t.price, 2) AS price, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.from_type, ");
        sql.append("  t.prod_desc, ");
        sql.append("  t.init_qty, ");
        sql.append("  t.init_amount, ");
        sql.append("  t.get_order_plate, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.init_weight, ");
        sql.append("  t.sendKM, ");
        sql.append("  t.`sender`, ");
        sql.append("  t.`sender_mobile`, ");
        sql.append("  t.`receiver_mobile`, ");
        sql.append("  t.`receiver`, ");
        sql.append("  t.`bill_sender`, ");
        sql.append("  t.`bill_sender_mobile`, ");
        sql.append("  t.`bill_taker`, ");
        sql.append("  t.`bill_taker_mobile`, ");
        sql.append("  t.vehicle_style_var, ");
        sql.append("  t.`prod_desc`, ");
        sql.append("  t.`heavy_piece`, ");
        sql.append("  t.good_price, ");
        sql.append("  t.`loss_type`, ");
        sql.append("  t.loss_ratio, ");
        sql.append("  t.loss_weight, ");
        sql.append("  t.`detachable`, ");
        sql.append("  IF( ");
        sql.append("    t.detachable = 0, ");
        sql.append("    '不可拆', ");
        sql.append("    IF( ");
        sql.append("      t.detachable = 1, ");
        sql.append("      '可拆', ");
        sql.append("      '不可拆' ");
        sql.append("    ) ");
        sql.append("  ) AS detachable_desc, ");
        sql.append("  t.`depend_num2`, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.sale_weight, ");
        sql.append("  t.sale_weight AS bill_weight, ");
        sql.append("  IF( ");
        sql.append("    t.status = '00', ");
        sql.append("    '已作废', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      IF( ");
        sql.append("        t.sale_weight > 0, ");
        sql.append("        '已抢单', ");
        sql.append("        '未抢单' ");
        sql.append("      ), ");
        sql.append("      IF( ");
        sql.append("        t.`status` = '30', ");
        sql.append("        '已完成', ");
        sql.append("        '终止' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS status_desc, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(t1.weight) ");
        sql.append("  FROM ");
        sql.append("    transportationdelivery t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id ");
        sql.append("    AND t.status != '00' ");
        sql.append("    AND t1.status != '00' ");
        sql.append("    AND t1.platform_id = t.platform_id) AS trans_weight, ");
        sql.append("  IF(t.appoint_company_id = '', 'N', 'Y') appoint_flag, ");
        sql.append("  t.qb_type, ");
        sql.append("  ROUND(t.max_price, 2) AS max_price, ");
        sql.append("  v.vat_client_name AS consignor_name, ");
        sql.append("  c.contact_mobile AS consignor_name_phone, ");
        sql.append("  t.appoint_team_type, ");
        sql.append("  t.estimateKM, ");
        sql.append("  t.appoint_team_id, ");
        sql.append("  t.send_group AS send_group_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.team_name ");
        sql.append("  FROM ");
        sql.append("    teamcompany t1 ");
        sql.append("  WHERE t1.team_id = t.appoint_team_id ");
        sql.append("  LIMIT 0, 1) AS appoint_team_name, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.send_group, '') = 'ALL', ");
        sql.append("    '全部', ");
        sql.append("    IF( ");
        sql.append("      IFNULL(t.send_group, '') = 'WEB', ");
        sql.append("      'WEB用户', ");
        sql.append("      IF( ");
        sql.append("        IFNULL(t.send_group, '') = 'APP', ");
        sql.append("        '手机APP用户', ");
        sql.append("        '' ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS send_group, ");
        sql.append("  t.ps2, ");
        sql.append("  t.ps3, ");
        sql.append("  t.ps4, ");
        sql.append("  t.ps5, ");
        sql.append("  t.ps1, ");
        sql.append("  t.company_id AS fd_company_id, ");
        sql.append("  t.docu_pri_sec, ");
        sql.append("  t.docu_type, ");
        sql.append("  t.pin_dan_num, ");
        sql.append("  t.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(t.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  v.vat_acc_type, ");
        sql.append("  v.vat_rate_chose, ");
        sql.append("  v.vat_standard_rate AS standard_rate, ");
        sql.append("  v.vat_policy_rate, ");
        sql.append("  IF( ");
        sql.append("    v.vat_acc_type = '1', ");
        sql.append("    IF( ");
        sql.append("      v.vat_rate_chose = '1', ");
        sql.append("      ROUND( ");
        sql.append("        t.price * (1 + v.vat_standard_rate), ");
        sql.append("        2 ");
        sql.append("      ), ");
        sql.append("      ROUND(t.price * (1 + v.vat_policy_rate), 2) ");
        sql.append("    ), ");
        sql.append("    IF( ");
        sql.append("      v.vat_rate_chose = '1', ");
        sql.append("      ROUND( ");
        sql.append("        t.price / (1 - v.vat_standard_rate), ");
        sql.append("        2 ");
        sql.append("      ), ");
        sql.append("      ROUND(t.price / (1 - v.vat_policy_rate), 2) ");
        sql.append("    ) ");
        sql.append("  ) AS price_tax, ");
        sql.append("  IF( ");
        sql.append("    v.vat_acc_type = '1', ");
        sql.append("    IF( ");
        sql.append("      v.vat_rate_chose = '1', ");
        sql.append("      ROUND( ");
        sql.append("        t.init_weight * ROUND( ");
        sql.append("          t.price * (1 + v.vat_standard_rate), ");
        sql.append("          2 ");
        sql.append("        ), ");
        sql.append("        2 ");
        sql.append("      ), ");
        sql.append("      ROUND( ");
        sql.append("        t.init_weight * ROUND(t.price * (1 + v.vat_policy_rate), 2), ");
        sql.append("        2 ");
        sql.append("      ) ");
        sql.append("    ), ");
        sql.append("    IF( ");
        sql.append("      v.vat_rate_chose = '1', ");
        sql.append("      ROUND( ");
        sql.append("        t.init_weight * ROUND( ");
        sql.append("          t.price / (1 - v.vat_standard_rate), ");
        sql.append("          2 ");
        sql.append("        ), ");
        sql.append("        2 ");
        sql.append("      ), ");
        sql.append("      ROUND( ");
        sql.append("        t.init_weight * ROUND(t.price / (1 - v.vat_policy_rate), 2), ");
        sql.append("        2 ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransportDesc, ");
        sql.append("  t.vat_flow_master_id, ");
        sql.append("  t.listing_price AS listingPrice, ");
        sql.append("  t.dq_flag, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_weight * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.dq_stt_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS dq_stt_date, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.dq_end_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS dq_end_date ");
        sql.append("FROM ");
        sql.append("  (vatflowdetail v, goodsorderm t) ");
        sql.append("  LEFT JOIN company c ");
        sql.append("    ON (c.seq_id = v.vat_client_id) ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("   AND t.if_tax_transport = 'Y' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        // 公司ID
        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? ");
            args.add(vo.getCompanyId());
        }

        // 货源单ID
        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? limit 0,1");
            args.add(vo.getPublishId());
        }

        return pageQuery.list(sql.toString(), args, TransOrderDetailVo.class);
    }

}