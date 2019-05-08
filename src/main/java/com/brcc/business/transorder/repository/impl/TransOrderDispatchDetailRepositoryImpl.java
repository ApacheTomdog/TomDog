package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.repository.ITransOrderDispatchDetailRepository;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import com.esteel.common.dao.PageQuery;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单调度数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-02 10:40
 */
public class TransOrderDispatchDetailRepositoryImpl implements ITransOrderDispatchDetailRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    PageQuery readPageQuery;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<TransOrderDispatchDetailVo> findOrderDetailForCarrier(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("  d.id_num AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  d.`name` AS NAME, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  d.phone AS driver_mobile, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.settle_weight, ");
        sql.append("  t.settle_amount, ");
        sql.append("  t.settle_status, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未结算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已结算', ");
        sql.append("      '未结算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatus, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.delivery_time, ");
        sql.append("    '%Y-%m-%d %H:%i' ");
        sql.append("  ) AS zcSureDate, ");
        sql.append("  DATE_FORMAT(t.update_date, '%Y-%m-%d %H:%i') AS update_date, ");
        sql.append("  DATE_FORMAT(t.pickup_date, '%Y-%m-%d %H:%i') AS pickup_date, ");
        sql.append("  DATE_FORMAT(t.finish_time, '%Y-%m-%d %H:%i') AS finish_time, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    c.early_warning_days ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE t.publish_company_id = c.seq_id) AS early_warning_days, ");
        sql.append("  t.remark, ");
        sql.append("  IF( ");
        sql.append("    'p.trece_bank_type=1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    '承运人银行账号' ");
        sql.append("  ) AS receBankType, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  t.truck_loading_weight AS zcWeight, ");
        sql.append("  t.take_delivery_weight AS shWeight, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  vat.if_end, ");
        sql.append("  ROUND( ");
        sql.append("    IF( ");
        sql.append("      vat.vat_acc_type = '1' ");
        sql.append("      AND vat.vat_rate_chose = '1', ");
        sql.append("      t.price * (1+ vat.vat_standard_rate), ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '2', ");
        sql.append("        t.price * (1+ vat.vat_policy_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '2' ");
        sql.append("          AND vat.vat_rate_chose = '1', ");
        sql.append("          t.price / (1- vat.vat_standard_rate), ");
        sql.append("          t.price / (1- vat.vat_policy_rate) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS price_tax, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS amount_tax, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  (SELECT ");
        sql.append("    va.vat_carry_name ");
        sql.append("  FROM ");
        sql.append("    vatflowdetail va ");
        sql.append("  WHERE va.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("    AND va.vat_client_id = ?) AS carryCompanyName, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  vatm.vat_company_name AS 'goodOwner' ");
        sql.append("FROM ");
        sql.append("  ( ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        ( ");
        sql.append("          transportationdelivery AS t ");
        sql.append("          LEFT JOIN driver d ");
        sql.append("            ON t.driver_id = d.id ");
        sql.append("        ) ");
        sql.append("        JOIN goodsorderm g ");
        sql.append("          ON t.publish_id = g.publish_id ");
        sql.append("      ) ");
        sql.append("      JOIN transportationm tm ");
        sql.append("        ON t.trans_id = tm.trans_id ");
        sql.append("    ) ");
        sql.append("    LEFT JOIN vatflowdetail vat ");
        sql.append("      ON vat.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN vatflowmaster vatm ");
        sql.append("    ON vatm.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.if_tax_transport = 'Y' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getVatCarryId());
        args.add(vo.getPlatformId());

        // transId
        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findOrderDetai(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_name ");
        sql.append("  FROM ");
        sql.append("    company t2 ");
        sql.append("  WHERE g.company_id = t2.seq_id) AS consignor_name, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  ROUND(t.weight * t.price, 2) AS amountForPlat, ");
        sql.append("  d.id_num AS Card, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("  d.id_num AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.get_order_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  d.`name` AS NAME, ");
        sql.append("  d.`phone` AS phone, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  d.phone AS driver_mobile, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.settle_weight, ");
        sql.append("  t.settle_amount, ");
        sql.append("  t.settle_status, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未结算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已结算', ");
        sql.append("      '未结算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatus, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  g.logistics_mark, ");
        sql.append("  IF( ");
        sql.append("    g.from_type = 'JK_U9', ");
        sql.append("    '立恒新大宗',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), ");
        sql.append("    IF( ");
        sql.append("      g.from_type = 'DS', ");
        sql.append("      '销售电商', ");
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
        sql.append("    ) ");
        sql.append("  )) AS docOrigin, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  t.delivery_time AS zcSureDate, ");
        sql.append("  t.update_date, ");
        sql.append("  t.pickup_date, ");
        sql.append("  t.finish_time, ");
        sql.append("  IFNULL(t.broker_people_toll_type, 'dj') AS broker_people_toll_type, ");
        sql.append("  IFNULL( ");
        sql.append("    t.broker_people_toll_amount, ");
        sql.append("    '0.00' ");
        sql.append("  ) AS broker_people_toll_amount, ");
        sql.append("  IFNULL( ");
        sql.append("    t.broker_people_toll_ratio, ");
        sql.append("    '0.00' ");
        sql.append("  ) AS broker_people_toll_ratio, ");
        sql.append("  t.if_broker_people_toll_flag, ");
        sql.append("  IF( ");
        sql.append("    t.broker_people_toll_type = 'dj', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS brokerPeopleTollType, ");
        sql.append("  IF( ");
        sql.append("    t.broker_people_toll_type = 'dj', ");
        sql.append("    t.broker_people_toll_amount, ");
        sql.append("    ROUND( ");
        sql.append("      t.broker_people_toll_ratio * t.amount, ");
        sql.append("      2 ");
        sql.append("    ) ");
        sql.append("  ) AS brokerPeopleTollAmount, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("   t.standard_tax AS standard_tax, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  c.early_warning_days AS early_warning_days, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    v1.vat_carry_name, ");
        sql.append("    c.company_name ");
        sql.append("  ) AS finally_pay, ");
        sql.append("  t.remark, ");
        sql.append("  IF( ");
        sql.append("    'p.trece_bank_type=1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    '承运人银行账号' ");
        sql.append("  ) AS receBankType, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  t.truck_loading_weight AS zcWeight, ");
        sql.append("  t.take_delivery_weight AS shWeight, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(j.dz_jk_cancel, 0) AS dz_jk_cancel, ");
        sql.append("  IFNULL( ");
        sql.append("    j.delivery_info_zdwl_source, ");
        sql.append("    '0' ");
        sql.append("  ) AS delivery_info_zdwl_source, ");
        sql.append("  t.operate_type, ");
        sql.append("  b.status AS driverStatus, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(b.status, '10') > '10', ");
        sql.append("    'Y', ");
        sql.append("    'N' ");
        sql.append("  ) AS if_dengji_info, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(b.status, '10') > '10', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS if_dengji_info_desc, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(b.status, '10') = '30', ");
        sql.append("    'Y', ");
        sql.append("    'N' ");
        sql.append("  ) AS if_gs_info, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(b.status, '10') = '30', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS if_gs_info_desc, ");
        sql.append("  IF( ");
        sql.append("    b.status = '10', ");
        sql.append("    '未申请', ");
        sql.append("    IF( ");
        sql.append("      b.status = '20', ");
        sql.append("      '申请中', ");
        sql.append("      IF( ");
        sql.append("        b.status = '30', ");
        sql.append("        '已开户', ");
        sql.append("        IF( ");
        sql.append("          b.status = '25', ");
        sql.append("          '已申请', ");
        sql.append("          '未知' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS driverStatusDesc, ");
        sql.append("  v1.vat_carry_name, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      t1.company_name ");
        sql.append("    FROM ");
        sql.append("      company t1 ");
        sql.append("    WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryCompanyName, ");
        sql.append("  t.owner_adjust_flag, ");
        sql.append("  t.owner_adjust_type, ");
        sql.append("  t.owner_adjust_amt, ");
        sql.append("  t.dz_status, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.loss_type, '0') = 0, ");
        sql.append("    g.loss_ratio, ");
        sql.append("    t.loss_ratio ");
        sql.append("  ) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc ");
        sql.append("FROM ");
        sql.append("  ( ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        transportationdelivery AS t ");
        sql.append("        LEFT JOIN driver d ");
        sql.append("          ON t.driver_id = d.id ");
        sql.append("      ) ");
        sql.append("      LEFT JOIN goodsorderm g ");
        sql.append("        ON t.publish_id = g.publish_id ");
        sql.append("    ) ");
        sql.append("    JOIN transportationm tm ");
        sql.append("      ON t.trans_id = tm.trans_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("  LEFT JOIN goodsordermjksetplat j ");
        sql.append("    ON ( ");
        sql.append("      j.tms_fd_company_id = t.publish_company_id ");
        sql.append("      AND j.tms_from_type = g.from_type ");
        sql.append("      AND j.tms_platform_id = t.platform_id ");
        sql.append("      AND j.tms_from_type IN ('JK_U8', 'JK_U9') ");
        sql.append("      AND j.ec_plat_name = g.from_plat_name ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN vatflowdetail v1 ");
        sql.append("    ON ( ");
        sql.append("      v1.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("      AND t.if_tax_transport = 'Y' ");
        sql.append("      AND v1.if_end = 'Y' ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN company c ");
        sql.append("    ON (c.seq_id = t.publish_company_id) ");
        sql.append("  LEFT JOIN business_registration b ");
        sql.append("    ON (d.id_num = b.id_num) ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        // transId
        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        return readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
    }

    @Override
    public DzCancelDataForCancelVo queryDzCancelData(String deliveryId, String platformId) {
        String sql = "SELECT g.depend_num as publish_id, t.delivery_id, t.delivery_num, '00' as docu_type, '' as ret1, '' as ret2, '' as ret3, '' as ret4, '' as ret5 from goodsorderm g , transportationdelivery t where g.publish_id = t.publish_id and t.delivery_id = ? and g.platform_id = ?";

        List<Object> args = new ArrayList<>();
        args.add(deliveryId);
        args.add(platformId);

        List<DzCancelDataForCancelVo> list = readPageQuery.list(sql, args, DzCancelDataForCancelVo.class);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public DzCancelDataVo queryStatue(String deliveryId, String platformId) {
        String sql = "select t.status, t.bill_time,t.delivery_time,t.create_date, (select if(count(1)>0,'Y','N') from apptms.goodsorderm t1 where t1.publish_id=t.publish_id and t1.from_type='DS') as jk_count, t2.from_type as fromType, t2.estimateKM from TransportationDelivery t left join goodsorderm t2 on t2.publish_id=t.publish_id WHERE t.delivery_id = ? and t.platform_id = ? for update";

        List<Object> args = new ArrayList<>();
        args.add(deliveryId);
        args.add(platformId);

        List<DzCancelDataVo> list = readPageQuery.list(sql, args, DzCancelDataVo.class);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public TransOrderDispatchDetailVo getComplateWeightWithTransId(String transId, String platformId) {
        String sql = "SELECT sum(t.weight) as sumWeight,sum(t.qty) as sumQty,t1.init_weight,t1.init_qty FROM apptms.transportationdelivery t ,transportationm t1 where t.platform_id = t1.platform_id and t.trans_id = t1.trans_id and t.trans_id = ? and t.platform_id = ? and t.status = '90'";

        List<Object> args = new ArrayList<>();
        args.add(transId);
        args.add(platformId);

        List<TransOrderDispatchDetailVo> list = readPageQuery.list(sql, args, TransOrderDispatchDetailVo.class);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public TransOrderDispatchDetailVo getComplateWeightWithpublishId(String publishId, String platformId) {
        String sql = "SELECT sum(t.weight) as sumWeight, sum(t.qty) as sumQty,t1.init_weight, t1.init_qty FROM apptms.transportationdelivery t ,goodsorderm t1 where t.platform_id = t1.platform_id and t.publish_id = t1.publish_id and t.publish_id = ? and t.platform_id = ? and t.status = '90'";

        List<Object> args = new ArrayList<>();
        args.add(publishId);
        args.add(platformId);

        List<TransOrderDispatchDetailVo> list = readPageQuery.list(sql, args, TransOrderDispatchDetailVo.class);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findWarningList(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_name ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1, ");
        sql.append("    Company t2 ");
        sql.append("  WHERE t1.publish_id = t.publish_id ");
        sql.append("    AND t1.company_id = t2.seq_id) AS bill_sender, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  d.id_num AS card, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactMobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactName, ");
        sql.append("  (SELECT ");
        sql.append("    t1.id_num ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`name` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS NAME, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`phone` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS phone, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.vehicle_num ");
        sql.append("  FROM ");
        sql.append("    Vehicle t1 ");
        sql.append("  WHERE t.vehicle_id = t1.vehicle_id) AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  CONCAT( ");
        sql.append("    DATEDIFF(NOW(), t.create_date), ");
        sql.append("    '天' ");
        sql.append("  ) AS totalTime, ");
        sql.append("  (SELECT ");
        sql.append("    t1.prod_desc ");
        sql.append("  FROM ");
        sql.append("    TransportationM t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS prod_desc, ");
        sql.append("  (SELECT ");
        sql.append("    t1.from_type ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS from_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.depend_num ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.pin_dan_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  t.remark ");
        sql.append("FROM ");
        sql.append("  TransportationDelivery AS t, ");
        sql.append("  driver d ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.driver_id = d.id ");
        sql.append("  AND t.status > '00' ");
        sql.append("  AND t.status < '90' ");
        sql.append("  AND t.create_date <= DATE_SUB( ");
        sql.append("    NOW(), ");
        sql.append("    INTERVAL ");
        sql.append("    (SELECT ");
        sql.append("      c.early_warning_days ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE t.publish_company_id = c.seq_id) DAY ");
        sql.append("  ) ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND (select t1.vehicle_num from Vehicle t1 where t.vehicle_id = t1.vehicle_id) like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%')");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND exists(select 1 from Company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
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
            sql.append(" AND t.publish_id = ?");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
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
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
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

        return readPageQuery.query(sql.toString(), args, vo, TransOrderDispatchDetailVo.class);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findAllWarningList(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_name ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1, ");
        sql.append("    Company t2 ");
        sql.append("  WHERE t1.publish_id = t.publish_id ");
        sql.append("    AND t1.company_id = t2.seq_id) AS bill_sender, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  d.id_num AS card, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactMobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactName, ");
        sql.append("  (SELECT ");
        sql.append("    t1.id_num ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`name` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS NAME, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`phone` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS phone, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.vehicle_num ");
        sql.append("  FROM ");
        sql.append("    Vehicle t1 ");
        sql.append("  WHERE t.vehicle_id = t1.vehicle_id) AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  CONCAT( ");
        sql.append("    DATEDIFF(NOW(), t.create_date), ");
        sql.append("    '天' ");
        sql.append("  ) AS totalTime, ");
        sql.append("  (SELECT ");
        sql.append("    t1.prod_desc ");
        sql.append("  FROM ");
        sql.append("    TransportationM t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS prod_desc, ");
        sql.append("  (SELECT ");
        sql.append("    t1.from_type ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS from_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.depend_num ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.pin_dan_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  t.remark ");
        sql.append("FROM ");
        sql.append("  TransportationDelivery AS t, ");
        sql.append("  driver d ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.driver_id = d.id ");
        sql.append("  AND t.status > '00' ");
        sql.append("  AND t.status < '90' ");
        sql.append("  AND t.create_date <= DATE_SUB( ");
        sql.append("    NOW(), ");
        sql.append("    INTERVAL ");
        sql.append("    (SELECT ");
        sql.append("      c.early_warning_days ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE t.publish_company_id = c.seq_id) DAY ");
        sql.append("  ) ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',?,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND (select t1.vehicle_num from Vehicle t1 where t.vehicle_id = t1.vehicle_id) like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%')");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND exists(select 1 from Company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
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
            sql.append(" AND t.publish_id = ?");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
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
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
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

        sql.append(" order by t.CREATE_DATE desc ");

        return readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findCarrierPage(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("  d.id_num AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  d.name AS NAME, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  d.phone AS driver_mobile, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.settle_weight, ");
        sql.append("  t.settle_amount, ");
        sql.append("  t.settle_status, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未结算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已结算', ");
        sql.append("      '未结算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatus, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  t.delivery_time AS zcSureDate, ");
        sql.append("  t.update_date, ");
        sql.append("  t.pickup_date, ");
        sql.append("  t.finish_time, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    c.early_warning_days ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE t.publish_company_id = c.seq_id) AS early_warning_days, ");
        sql.append("  t.remark, ");
        sql.append("  IF( ");
        sql.append("    'p.trece_bank_type=1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    '承运人银行账号' ");
        sql.append("  ) AS receBankType, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  t.truck_loading_weight AS zcWeight, ");
        sql.append("  t.take_delivery_weight AS shWeight, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  vat.if_end, ");
        sql.append("  ROUND( ");
        sql.append("    IF( ");
        sql.append("      vat.vat_acc_type = '1' ");
        sql.append("      AND vat.vat_rate_chose = '1', ");
        sql.append("      t.price * (1+ vat.vat_standard_rate), ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '2', ");
        sql.append("        t.price * (1+ vat.vat_policy_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '2' ");
        sql.append("          AND vat.vat_rate_chose = '1', ");
        sql.append("          t.price / (1- vat.vat_standard_rate), ");
        sql.append("          t.price / (1- vat.vat_policy_rate) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS price_tax, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS amount_tax, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append(" vat.vat_carry_name AS carryCompanyName, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  vatm.vat_company_name AS goodOwner ");
        sql.append("FROM ");
        sql.append("  ( ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        ( ");
        sql.append("          TransportationDelivery AS t ");
        sql.append("          LEFT JOIN driver d ");
        sql.append("            ON t.driver_id = d.id ");
        sql.append("        ) ");
        sql.append("        left JOIN goodsorderm g ");
        sql.append("          ON t.publish_id = g.publish_id ");
        sql.append("      ) ");
        sql.append("      left JOIN TransportationM tm ");
        sql.append("        ON t.trans_id = tm.trans_id ");
        sql.append("    ) ");
        sql.append("    LEFT JOIN vatflowdetail vat ");
        sql.append("      ON vat.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN vatflowmaster vatm ");
        sql.append("    ON vatm.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.if_tax_transport = 'Y' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getVatCarryId())){
            sql.append(" AND vat.vat_carry_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(vo.getVatCarryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',? ,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getGoodOwner())){
            sql.append(" AND vatm.vat_company_name like CONCAT('%',?,'%') ");
            args.add(vo.getGoodOwner());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND g.depend_num = ? ");
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
            sql.append(" AND exists(select 1 from Company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
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
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        //早期预警
        if (!ObjectUtils.isEmpty(vo.getEarlyWarning())) {
            if ("Y".equalsIgnoreCase(vo.getEarlyWarning())){
                sql.append(" and t.create_date <= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            } else if("N".equalsIgnoreCase(vo.getEarlyWarning())){
                sql.append(" and t.create_date >= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getDeFlag())){
            if("1".equalsIgnoreCase(vo.getDeFlag())){
                sql.append(" AND t.orther_flag = '1' ");
            }else if("0".equalsIgnoreCase(vo.getDeFlag())){
                sql.append(" AND (t.orther_flag <> '1' or t.orther_flag IS NULL) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1, Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%')");
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
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getWtBillSender())){
            sql.append(" AND t.bill_sender like concat('%',?,'%') ");
            args.add(vo.getWtBillSender());
        }

        return readPageQuery.query(sql.toString(), args, vo, TransOrderDispatchDetailVo.class);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findCarrierList(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.weight, ");
        sql.append("  t.amount, ");
        sql.append("  t.price, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  t.qty, ");
        sql.append("  t.bill_taker, ");
        sql.append("  t.bill_taker_mobile, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("  d.id_num AS id_num, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  d.name AS NAME, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  d.phone AS driver_mobile, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.settle_weight, ");
        sql.append("  t.settle_amount, ");
        sql.append("  t.settle_status, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未结算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已结算', ");
        sql.append("      '未结算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatus, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  t.delivery_time AS zcSureDate, ");
        sql.append("  t.update_date, ");
        sql.append("  t.pickup_date, ");
        sql.append("  t.finish_time, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  (SELECT ");
        sql.append("    c.early_warning_days ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE t.publish_company_id = c.seq_id) AS early_warning_days, ");
        sql.append("  t.remark, ");
        sql.append("  IF( ");
        sql.append("    'p.trece_bank_type=1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    '承运人银行账号' ");
        sql.append("  ) AS receBankType, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  t.truck_loading_weight AS zcWeight, ");
        sql.append("  t.take_delivery_weight AS shWeight, ");
        sql.append("  vat.vat_policy_rate, ");
        sql.append("  vat.if_end, ");
        sql.append("  ROUND( ");
        sql.append("    IF( ");
        sql.append("      vat.vat_acc_type = '1' ");
        sql.append("      AND vat.vat_rate_chose = '1', ");
        sql.append("      t.price * (1+ vat.vat_standard_rate), ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '2', ");
        sql.append("        t.price * (1+ vat.vat_policy_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '2' ");
        sql.append("          AND vat.vat_rate_chose = '1', ");
        sql.append("          t.price / (1- vat.vat_standard_rate), ");
        sql.append("          t.price / (1- vat.vat_policy_rate) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS price_tax, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  ROUND( ");
        sql.append("    t.weight * ROUND( ");
        sql.append("      IF( ");
        sql.append("        vat.vat_acc_type = '1' ");
        sql.append("        AND vat.vat_rate_chose = '1', ");
        sql.append("        t.price * (1+ vat.vat_standard_rate), ");
        sql.append("        IF( ");
        sql.append("          vat.vat_acc_type = '1' ");
        sql.append("          AND vat.vat_rate_chose = '2', ");
        sql.append("          t.price * (1+ vat.vat_policy_rate), ");
        sql.append("          IF( ");
        sql.append("            vat.vat_acc_type = '2' ");
        sql.append("            AND vat.vat_rate_chose = '1', ");
        sql.append("            t.price / (1- vat.vat_standard_rate), ");
        sql.append("            t.price / (1- vat.vat_policy_rate) ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ), ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS amount_tax, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append(" vat.vat_carry_name AS carryCompanyName, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    '定额', ");
        sql.append("    '定率' ");
        sql.append("  ) AS loss_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.`loss_type` = '1', ");
        sql.append("    CONCAT( ");
        sql.append("      IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("      '（kg/车）' ");
        sql.append("    ), ");
        sql.append("    CONCAT( ");
        sql.append("      t.loss_ratio * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  vatm.vat_company_name AS goodOwner ");
        sql.append("FROM ");
        sql.append("  ( ");
        sql.append("    ( ");
        sql.append("      ( ");
        sql.append("        ( ");
        sql.append("          TransportationDelivery AS t ");
        sql.append("          LEFT JOIN driver d ");
        sql.append("            ON t.driver_id = d.id ");
        sql.append("        ) ");
        sql.append("        JOIN goodsorderm g ");
        sql.append("          ON t.publish_id = g.publish_id ");
        sql.append("      ) ");
        sql.append("      JOIN TransportationM tm ");
        sql.append("        ON t.trans_id = tm.trans_id ");
        sql.append("    ) ");
        sql.append("    LEFT JOIN vatflowdetail vat ");
        sql.append("      ON vat.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN vatflowmaster vatm ");
        sql.append("    ON vatm.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.if_tax_transport = 'Y' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getVatCarryId())){
            sql.append(" AND vat.vat_carry_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(vo.getVatCarryId());
        }

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%',? ,'%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getGoodOwner())){
            sql.append(" AND vatm.vat_company_name like CONCAT('%',?,'%') ");
            args.add(vo.getGoodOwner());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND g.depend_num = ? ");
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
            sql.append(" AND exists(select 1 from Company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
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
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getEarlyWarning())){
            if("Y".equalsIgnoreCase(vo.getEarlyWarning())){
                sql.append(" AND t.create_date <= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status > 00 AND t.status < 90 ");
            }else if("N".equalsIgnoreCase(vo.getEarlyWarning())){
                sql.append(" AND t.create_date >= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
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
            sql.append(" AND (select t2.company_name from GoodsOrderM t1, Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%')");
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
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getWtBillSender())){
            sql.append(" AND t.bill_sender like concat('%',?,'%') ");
            args.add(vo.getWtBillSender());
        }

        return readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
    }

    @Override
    public TransOrderDispatchDetailVo queryMessageInfo(Long deliveryId) {
        String sql = "SELECT (SELECT t1.vehicle_num FROM vehicle t1 WHERE t1.vehicle_id = t.vehicle_id) AS vehicleNum, (SELECT t2.depend_num FROM goodsorderm t2 WHERE  t2.publish_id = t.publish_id) AS dependNum FROM transportationdelivery t WHERE t.delivery_id = ?";

        List<Object> args = new ArrayList<>();
        args.add(deliveryId);
        List<TransOrderDispatchDetailVo> transOrderDispatchDetailVoList = readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
        if(transOrderDispatchDetailVoList != null){
            return transOrderDispatchDetailVoList.get(0);
        }
        return null;
    }

    @Override
    public void saveNewOrder(Map<String, Object> paramMap) {
        sqlSessionTemplate.insert("transportationdelivery.insert", paramMap);
    }

    @Override
    public TransOrderDispatchDetailVo queryDelieryWeight(Long deliveryId, String platformId) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  m.from_type, ");
        sql.append("  m.company_id, ");
        sql.append("  t.status, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  t.delivery_id, ");
        sql.append("  IFNULL(t.settle_status, '10') AS settleStatus ");
        sql.append("FROM ");
        sql.append("  transportationdelivery t ");
        sql.append("  LEFT JOIN goodsorderm m ");
        sql.append("    ON (t.publish_id = m.publish_id) ");
        sql.append("WHERE t.delivery_id = ?  ");
        sql.append("AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(deliveryId);
        args.add(platformId);

        List<TransOrderDispatchDetailVo> list = readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
        if(list != null){
            return list.get(0);
        }

        return null;
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findAllPublisherWarningList(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  d.id_num AS Card, ");
        sql.append("  t.weight, ");
        sql.append("  t.price, ");
        sql.append("  t.amount, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactMobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactName, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`name` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS NAME, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_id ");
        sql.append("  FROM ");
        sql.append("    loginverify t2 ");
        sql.append("  WHERE t2.platform_id = t.platform_id ");
        sql.append("    AND t2.driver_id = t.driver_id) AS driver_company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.vehicle_num ");
        sql.append("  FROM ");
        sql.append("    Vehicle t1 ");
        sql.append("  WHERE t.vehicle_id = t1.vehicle_id) AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  (SELECT ");
        sql.append("    t2.phone ");
        sql.append("  FROM ");
        sql.append("    Driver t2 ");
        sql.append("  WHERE t2.id = t.driver_id) AS phone, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.price, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.good_type, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  (SELECT ");
        sql.append("    t1.prod_desc ");
        sql.append("  FROM ");
        sql.append("    TransportationM t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS prod_desc, ");
        sql.append("  (SELECT ");
        sql.append("    t1.from_type ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS from_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.depend_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS depend_num, ");
        sql.append("  t.publish_company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.publish_company_id) AS consignor_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.pin_dan_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  t.good_price AS good_price, ");
        sql.append("  (SELECT ");
        sql.append("    g.prod_desc ");
        sql.append("  FROM ");
        sql.append("    goodsorderm g ");
        sql.append("  WHERE t.publish_id = g.publish_id) AS prod_desc, ");
        sql.append("  CONCAT( ");
        sql.append("    DATEDIFF(NOW(), t.create_date), ");
        sql.append("    '天' ");
        sql.append("  ) AS totalTime, ");
        sql.append("  IF( ");
        sql.append("    t.finish_time IS NULL ");
        sql.append("    OR t.finish_time = '', ");
        sql.append("    DATE_FORMAT( ");
        sql.append("      t.shSure_date, ");
        sql.append("      '%Y-%m-%d %H:%i:%s' ");
        sql.append("    ), ");
        sql.append("    DATE_FORMAT( ");
        sql.append("      t.finish_time, ");
        sql.append("      '%Y-%m-%d %H:%i:%s' ");
        sql.append("    ) ");
        sql.append("  ) AS finish_time, ");
        sql.append("  t.remark ");
        sql.append("FROM ");
        sql.append("  TransportationDelivery AS t ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON t.driver_id = d.id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("   AND t.status > 00 ");
        sql.append("  AND t.status < 90 ");
        sql.append("  AND t.create_date <= DATE_SUB( ");
        sql.append("    NOW(), ");
        sql.append("    INTERVAL ");
        sql.append("    (SELECT ");
        sql.append("      c.early_warning_days ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE t.publish_company_id = c.seq_id) DAY ");
        sql.append("  ) ");
        sql.append("  AND t.publish_company_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%', ?, '%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getAccessFlag())){
            if("N".equalsIgnoreCase(vo.getAccessFlag())){
                sql.append(" AND (t.if_fd_judge is null or t.if_fd_judge='N') ");
            }else if("Y".equalsIgnoreCase(vo.getAccessFlag())){
                sql.append(" AND t.if_fd_judge='Y' ");
            }
            sql.append(" AND and (t.status='00' || t.status='90') ");
        }

        if (!ObjectUtils.isEmpty(vo.getSettleflag())){
            if("10".equalsIgnoreCase(vo.getSettleflag())){
                sql.append(" AND t.settle_amount = 0 ");
            }else if("20".equalsIgnoreCase(vo.getSettleflag())){
                sql.append(" AND t.settle_amount > 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getSettleStatus())){
            if("10".equalsIgnoreCase(vo.getSettleStatus())){
                sql.append(" AND (t.settle_status = '10' or t.settle_status is null) ");
            }else if("20".equalsIgnoreCase(vo.getSettleStatus())){
                sql.append(" AND t.settle_status = '20' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND (select t1.vehicle_num from Vehicle t1 where t.vehicle_id = t1.vehicle_id) like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND (select company_name from Company a where a.platform_id = t.platform_id and a.seq_id = t.company_id) like concat('%', ? ,'%') ");
            args.add(vo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(vo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getFromType())){
            sql.append(" AND exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
            args.add(vo.getFromType());
        }

        if (!ObjectUtils.isEmpty(vo.getDeFlag())){
            sql.append(" AND t.orther_flag = ? ");
            args.add(vo.getDeFlag());
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getSender())){
            sql.append(" AND (select g.sender from goodsorderm g where t.publish_id = g.publish_id) like CONCAT ('%',?,'%') ");
            args.add(vo.getSender());
        }

        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id) like CONCAT('%',?,'%') ");
            args.add(vo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num like CONCAT('%',?,'%')) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%', ?, '%') ");
            args.add(vo.getBillSender());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return readPageQuery.query(sql.toString(), args, vo, TransOrderDispatchDetailVo.class);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findAllPublisherWarningListData(TransOrderDispatchDetailSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  d.id_num AS Card, ");
        sql.append("  t.weight, ");
        sql.append("  t.price, ");
        sql.append("  t.amount, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.create_date, ");
        sql.append("    '%Y-%m-%d %H:%i:%s' ");
        sql.append("  ) AS create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_mobile ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactMobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.contact_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS contactName, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  (SELECT ");
        sql.append("    t1.`name` ");
        sql.append("  FROM ");
        sql.append("    Driver t1 ");
        sql.append("  WHERE t1.id = t.driver_id) AS NAME, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_id ");
        sql.append("  FROM ");
        sql.append("    loginverify t2 ");
        sql.append("  WHERE t2.platform_id = t.platform_id ");
        sql.append("    AND t2.driver_id = t.driver_id) AS driver_company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.vehicle_num ");
        sql.append("  FROM ");
        sql.append("    Vehicle t1 ");
        sql.append("  WHERE t.vehicle_id = t1.vehicle_id) AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  (SELECT ");
        sql.append("    t2.phone ");
        sql.append("  FROM ");
        sql.append("    Driver t2 ");
        sql.append("  WHERE t2.id = t.driver_id) AS phone, ");
        sql.append("  IF( ");
        sql.append("    t.status = '10', ");
        sql.append("    '待取单', ");
        sql.append("    IF( ");
        sql.append("      t.status = '20', ");
        sql.append("      '待装货', ");
        sql.append("      IF( ");
        sql.append("        t.status = '30', ");
        sql.append("        '待收货', ");
        sql.append("        IF( ");
        sql.append("          t.status = '90', ");
        sql.append("          '已完成', ");
        sql.append("          IF( ");
        sql.append("            t.status = '00', ");
        sql.append("            '已作废', ");
        sql.append("            '待取单' ");
        sql.append("          ) ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS statusDesc, ");
        sql.append("  t.price, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.good_type, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  (SELECT ");
        sql.append("    t1.prod_desc ");
        sql.append("  FROM ");
        sql.append("    TransportationM t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS prod_desc, ");
        sql.append("  (SELECT ");
        sql.append("    t1.from_type ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS from_type, ");
        sql.append("  (SELECT ");
        sql.append("    t1.depend_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS depend_num, ");
        sql.append("  t.publish_company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.publish_company_id) AS consignor_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  (SELECT ");
        sql.append("    t1.pin_dan_num ");
        sql.append("  FROM ");
        sql.append("    goodsorderm t1 ");
        sql.append("  WHERE t.publish_id = t1.publish_id) AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  t.good_price AS good_price, ");
        sql.append("  (SELECT ");
        sql.append("    g.prod_desc ");
        sql.append("  FROM ");
        sql.append("    goodsorderm g ");
        sql.append("  WHERE t.publish_id = g.publish_id) AS prod_desc, ");
        sql.append("  CONCAT( ");
        sql.append("    DATEDIFF(NOW(), t.create_date), ");
        sql.append("    '天' ");
        sql.append("  ) AS totalTime, ");
        sql.append("  IF( ");
        sql.append("    t.finish_time IS NULL ");
        sql.append("    OR t.finish_time = '', ");
        sql.append("    DATE_FORMAT( ");
        sql.append("      t.shSure_date, ");
        sql.append("      '%Y-%m-%d %H:%i:%s' ");
        sql.append("    ), ");
        sql.append("    DATE_FORMAT( ");
        sql.append("      t.finish_time, ");
        sql.append("      '%Y-%m-%d %H:%i:%s' ");
        sql.append("    ) ");
        sql.append("  ) AS finish_time, ");
        sql.append("  t.remark ");
        sql.append("FROM ");
        sql.append("  TransportationDelivery AS t ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON t.driver_id = d.id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("   AND t.status > 00 ");
        sql.append("  AND t.status < 90 ");
        sql.append("  AND t.create_date <= DATE_SUB( ");
        sql.append("    NOW(), ");
        sql.append("    INTERVAL ");
        sql.append("    (SELECT ");
        sql.append("      c.early_warning_days ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE t.publish_company_id = c.seq_id) DAY ");
        sql.append("  ) ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getDeliveryId())){
            sql.append(" AND t.delivery_id like CONCAT('%', ?, '%') ");
            args.add(vo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(vo.getAccessFlag())){
            if("N".equalsIgnoreCase(vo.getAccessFlag())){
                sql.append(" AND (t.if_fd_judge is null or t.if_fd_judge='N') ");
            }else if("Y".equalsIgnoreCase(vo.getAccessFlag())){
                sql.append(" AND t.if_fd_judge='Y' ");
            }
            sql.append(" AND and (t.status='00' || t.status='90') ");
        }

        if (!ObjectUtils.isEmpty(vo.getSettleflag())){
            if("10".equalsIgnoreCase(vo.getSettleflag())){
                sql.append(" AND t.settle_amount = 0 ");
            }else if("20".equalsIgnoreCase(vo.getSettleflag())){
                sql.append(" AND t.settle_amount > 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getSettleStatus())){
            if("10".equalsIgnoreCase(vo.getSettleStatus())){
                sql.append(" AND (t.settle_status = '10' or t.settle_status is null) ");
            }else if("20".equalsIgnoreCase(vo.getSettleStatus())){
                sql.append(" AND t.settle_status = '20' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getName())){
            sql.append(" AND (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(vo.getName());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND (select t1.vehicle_num from Vehicle t1 where t.vehicle_id = t1.vehicle_id) like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id = ? ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyName())){
            sql.append(" AND (select company_name from Company a where a.platform_id = t.platform_id and a.seq_id = t.company_id) like concat('%', ? ,'%') ");
            args.add(vo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(vo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getFromType())){
            sql.append(" AND exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
            args.add(vo.getFromType());
        }

        if (!ObjectUtils.isEmpty(vo.getDeFlag())){
            sql.append(" AND t.orther_flag = ? ");
            args.add(vo.getDeFlag());
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getSender())){
            sql.append(" AND (select g.sender from goodsorderm g where t.publish_id = g.publish_id) like CONCAT ('%',?,'%') ");
            args.add(vo.getSender());
        }

        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id) like CONCAT('%',?,'%') ");
            args.add(vo.getProdDesc());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return readPageQuery.list(sql.toString(), args, TransOrderDispatchDetailVo.class);
    }
}