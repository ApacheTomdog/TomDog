package com.brcc.business.transportbill.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.brcc.business.transportbill.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.transportbill.repository.ITransportationDeliveryRepository;
import com.esteel.common.dao.PageQuery;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02 
 * Time: 16:23
 */
public class TransportationDeliveryRepositoryImpl implements ITransportationDeliveryRepository {

    @Autowired
    PageQuery pageQuery;
    
    @Autowired
    PageQuery readPageQuery;
    
    @Override
    public Page<TransportationDeliveryVo> queryPage(TransportBillQueryVo transportBillQueryVo) {

        //标识 是否为 货主级查询
        boolean isPublisher = "publisher".equalsIgnoreCase(transportBillQueryVo.getChannel());
        //标识 是否为 平台级
        boolean isPlat = "plat".equals(transportBillQueryVo.getChannel());

        List<Object> args = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT t.delivery_id, ");
        sql.append("        t.publish_id, ");
        sql.append("        (SELECT t2.company_name FROM company t2 WHERE g.company_id = t2.seq_id)            AS consignor_name, ");
        sql.append("        ''                                                                                 AS publish_num, ");
        sql.append("        t.trans_id, ");
        sql.append("        t.weight, ");
        sql.append("        t.amount, ");
        sql.append("        t.price, ");
        sql.append("        round(t.weight * t.price, 2)                                                       AS amountForPlat, ");
        sql.append("        d.id_num                                                                           AS Card, ");
        sql.append("        t.qty, ");
        sql.append("        t.bill_taker, ");
        sql.append("        t.bill_taker_mobile, ");
        sql.append("        t.comfirm_pic_local, ");
        sql.append("        t.receiver_mobile, ");
        sql.append("        t.create_date, ");
        sql.append("        t.company_id, ");
        sql.append("        (SELECT t1.company_name FROM company t1 WHERE t1.seq_id = t.company_id)            AS company_name, ");
        sql.append("        (SELECT t1.contact_mobile FROM company t1 WHERE t1.seq_id = t.company_id)          AS contact_mobile, ");
        sql.append("        d.id_num                                                                           AS id_num, ");
        sql.append("        t.start_plate, ");
        sql.append("        t.end_plate, ");
        sql.append("        t.get_order_plate, ");
        sql.append("        t.driver_id, ");
        sql.append("        ''                                                                                 AS publish_num, ");
        sql.append("        d.`name`                                                                           AS name, ");
        sql.append("        d.`phone`                                                                          AS phone, ");
        sql.append("        t.vehicle_id, ");
        sql.append("        v.vehicle_num                                                                      AS vehicle_num, ");
        sql.append("        t.status, ");
        sql.append("        t.good_type_desc, ");
        sql.append("        t.bill_sender, ");
        sql.append("        t.bill_sender_mobile, ");
        sql.append("        t.take_delivery_weight, ");
        sql.append("        d.phone                                                                            AS driver_mobile, ");
        sql.append("        t.status, ");
        sql.append("        t.settle_weight, ");
        sql.append("        t.settle_amount, ");
        sql.append("        t.settle_status, ");
        sql.append("        t.orther_flag, ");
        sql.append("        t.if_fd_judge, ");
        sql.append("        IF(t.orther_flag = '1', '已处理', '未处理')                                              AS orther_flag_name, ");
        sql.append("        t.if_feidan , ");
        sql.append("        tm.prod_desc                                                                       AS prod_desc, ");
        sql.append("        g.from_type                                                                        AS from_type, ");
        sql.append("        g.depend_num                                                                       AS depend_num, ");
        sql.append("        g.logistics_mark, ");
        sql.append("        if(g.from_type = 'JK_U9', '立恒新大宗',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), if(g.from_type = 'DS', '销售电商', if(g.from_type = 'PT', '平台货源', ");
        sql.append("                                                                             if(g.from_type = 'JK_U8', ");
        sql.append("                                                                                if(g.logistics_mark = 'X', '大宗销售', '大宗采购'), ");
        sql.append("                                                                                '平台货源'))))) AS docOrigin, ");
        sql.append("        (SELECT t1.user_name FROM loginverify t1 WHERE t1.user_id = t.update_person)       AS update_person_name, ");
        sql.append("        g.pin_dan_num                                                                      AS pinDanNum, ");
        sql.append("        t.delivery_time, ");
        sql.append("        t.update_date, ");
        sql.append("        t.pickup_date, ");
        sql.append("        t.finish_time, ");
        sql.append("        v1.if_end, ");
        sql.append("        ifnull(t.broker_people_toll_type, 'dj')                                            AS broker_people_toll_type, ");
        sql.append("        ifnull(t.broker_people_toll_amount, '0.00')                                        AS broker_people_toll_amount, ");
        sql.append("        ifnull(t.broker_people_toll_ratio, '0.00')                                         AS broker_people_toll_ratio, ");
        sql.append("        t.if_broker_people_toll_flag, ");
        sql.append("        if(t.broker_people_toll_type = 'dj', '定额', '定率')                                   AS brokerPeopleTollType, ");
        sql.append("        if(t.broker_people_toll_type = 'dj', t.broker_people_toll_amount, ");
        sql.append("           round(t.broker_people_toll_ratio * t.amount, 2))                                AS brokerPeopleTollAmount, ");
        sql.append("        g.depend_num                                                                       AS depend_num, ");
        sql.append("        vatm.vat_company_name                                                              AS goodOwner, ");
        sql.append("        t.standard_tax                                                                     AS standard_tax, ");
        sql.append("        t.if_tax_transport, ");
        sql.append("        c.early_warning_days                                                               AS early_warning_days, ");
        sql.append("        c.company_name publish_company_name ,");
        sql.append("        if(t.if_tax_transport = 'Y', v1.vat_carry_name, c.company_name)                    AS finally_pay, ");
        sql.append("        t.remark, ");
        sql.append("        IF('p.trece_bank_type=1', '发单人维护账号', '承运人银行账号')                                    AS receBankType, ");
        sql.append("        g.ds_if_settle                                                                     AS dsIfSettle, ");
        sql.append("        if(g.ds_if_settle = 0, '否', '是')                                                   AS dsIfSettleDesc, ");
        sql.append("        t.truck_loading_weight, ");
        sql.append("        t.take_delivery_weight, ");
        sql.append("        t.if_upload_receipt_flag, ");
        sql.append("        t.comfirm_pic1_local, ");
        sql.append("        ifnull(j.dz_jk_cancel, 0)                                                          AS dz_jk_cancel, ");
        sql.append("        ifnull(j.delivery_info_zdwl_source, '0')                                           AS delivery_info_zdwl_source, ");
        sql.append("        t.operate_type, ");
        sql.append("        b.status                                                                           AS driverStatus, ");
        sql.append("        if(ifnull(b.status,'10') > '10','Y','N')                                           AS if_dengji_info, ");
        sql.append("        if(ifnull(b.status,'10') > '10','是','否')                                         AS if_dengji_info_desc, ");
        sql.append("        if(ifnull(b.status,'10') = '30','Y','N')                                           AS if_gs_info, ");
        sql.append("        if(ifnull(b.status,'10') = '30','是','否')                                         AS if_gs_info_desc, ");
        sql.append("        if(b.status='10','未申请',if(b.status='20','申请中',if(b.status='30','已开户',if(b.status='25','已申请','未知')))) AS driverStatusDesc, ");
        if (isPublisher){
            sql.append("    i.if_invoice , ");
            sql.append("    i.invoice_no , ");
        }
        sql.append("        v1.vat_carry_name, ");
        sql.append("        if(t.if_tax_transport = 'Y', (SELECT t1.company_name FROM company t1 WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("           '')                                                                             AS carryCompanyName, ");
        sql.append("        t.owner_adjust_flag, ");
        sql.append("        t.owner_adjust_type, ");
        sql.append("        t.owner_adjust_amt, ");
        sql.append("        t.dz_status, ");
        sql.append("        p.status as payStatus , ");
        sql.append("        round(if(v1.vat_acc_type = '1' ");
        sql.append("                   AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), if(v1.vat_acc_type = '1' ");
        sql.append("                                                                                           AND v1.vat_rate_chose = '2', ");
        sql.append("                                                                                         t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                                                                         if(v1.vat_acc_type = '2' ");
        sql.append("                                                                                              AND ");
        sql.append("                                                                                            v1.vat_rate_chose = '1', ");
        sql.append("                                                                                            t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                                                                            t.price / (1 - v1.vat_policy_rate)))), ");
        sql.append("              2)                                                                           AS price_tax, ");
        sql.append("        round(t.weight * round(if(v1.vat_acc_type = '1' ");
        sql.append("                                    AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), ");
        sql.append("                                  if(v1.vat_acc_type = '1' ");
        sql.append("                                       AND v1.vat_rate_chose = '2', t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                     if(v1.vat_acc_type = '2' ");
        sql.append("                                          AND v1.vat_rate_chose = '1', t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                        t.price / (1 - v1.vat_policy_rate)))), 2), 2)      AS taxAmount, ");
        sql.append("        round(t.weight * round(if(v1.vat_acc_type = '1' ");
        sql.append("                                    AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), ");
        sql.append("                                  if(v1.vat_acc_type = '1' ");
        sql.append("                                       AND v1.vat_rate_chose = '2', t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                     if(v1.vat_acc_type = '2' ");
        sql.append("                                          AND v1.vat_rate_chose = '1', t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                        t.price / (1 - v1.vat_policy_rate)))), 2), 2)      AS amount_tax, ");
        sql.append("        ifnull(t.good_price, g.good_price)                                                 AS good_price, ");
        sql.append("        ifnull(t.loss_type, g.loss_type)                                                   AS loss_type, ");
        sql.append("        if(ifnull(t.loss_type, '0') = 0, g.loss_ratio, t.loss_ratio)                       AS loss_ratio, ");
        sql.append("        ifnull(t.loss_weight, g.loss_weight)                                               AS loss_weight, ");
        sql.append("        if(t.`loss_type`='1','定额','定率')                                                AS loss_type_desc, ");
        sql.append("        if(t.`loss_type`='1',CONCAT(ifnull(t.loss_weight,g.loss_weight)*1000,'（kg/车）'),CONCAT(t.loss_ratio*1000,'（‰/车）')) as loss_weight_desc ");
        sql.append(" FROM transportationdelivery t ");
        sql.append("        LEFT JOIN driver d ON t.driver_id = d.id ");
        sql.append("        LEFT JOIN goodsorderm g ON t.publish_id = g.publish_id ");
        sql.append("        JOIN transportationm tm ON t.trans_id = tm.trans_id ");
        sql.append("        LEFT JOIN vehicle v ON t.vehicle_id = v.vehicle_id ");
        sql.append("        LEFT JOIN goodsordermjksetplat j ON j.tms_fd_company_id = t.publish_company_id ");
        sql.append("                                              AND j.tms_from_type = g.from_type ");
        sql.append("                                              AND j.tms_platform_id = t.platform_id ");
        sql.append("                                              AND j.tms_from_type IN ('JK_U8', 'JK_U9') ");
        sql.append("                                              AND j.ec_plat_name = g.from_plat_name ");
        sql.append("        LEFT JOIN vatflowdetail v1 ");
        sql.append("          ON v1.vat_flow_master_id = t.vat_flow_master_id and t.if_tax_transport = 'Y' and v1.if_end = 'Y' ");
        sql.append("        LEFT JOIN company c ON c.seq_id = t.publish_company_id ");
        sql.append("        LEFT JOIN business_registration b ON d.id_num = b.id_num ");
        sql.append("        LEFT JOIN vatflowmaster vatm ON vatm.vat_flow_master_id = t.vat_flow_master_id ");

//        if ((!StringUtils.isEmpty(transportBillQueryVo.getSettleStatus())&&"20".equals(transportBillQueryVo.getSettleStatus().trim()))||isPublisher) {
            sql.append("        LEFT JOIN pay_bill p on t.zf_id = p.zf_id and t.platform_id = p.platform_id ");
//        }

        if (isPublisher){
            sql.append(" LEFT JOIN invoicedetail i ON (t.delivery_id = i.delivery_id and i.invoice_title_id = "+transportBillQueryVo.getCompanyId()+" and i.if_invoice > 0) ");
        }


        sql.append("  WHERE  t.platform_id = 'SX*HSY*0001' ");

        //========  查询条件 开始 ===================

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDsIfSettle())){
            if("Y".equalsIgnoreCase(transportBillQueryVo.getDsIfSettle())){
                sql.append(" and g.ds_if_settle = '1' ");
            }else if("N".equalsIgnoreCase(transportBillQueryVo.getDsIfSettle()))
            sql.append(" and g.ds_if_settle = '0' ");
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getOrderPlate())){
            sql.append(" and g.ds_if_settle = ? ");
            args.add(transportBillQueryVo.getOrderPlate());
        }


        //发行方
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishCompanyId())){
            sql.append(" and t.publish_company_id = ? ");
            args.add(transportBillQueryVo.getPublishCompanyId());
        }

        //是否委托承运
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        //状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getStatus())) {
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVatCarryId())) {
            sql.append(" and v1.vat_carry_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '1' and t.status != '90'))");
            args.add(transportBillQueryVo.getVatCarryId());
        }

        //调度单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())) {
            sql.append(" and t.delivery_id like ? ");
            args.add("%"+transportBillQueryVo.getDeliveryId()+"%");
        }
        //车牌号
        if (!StringUtils.isEmpty(transportBillQueryVo.getVehicleNum())) {
            sql.append("and t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        //单据号
        if (!StringUtils.isEmpty(transportBillQueryVo.getDependNum())) {
            sql.append(" and g.depend_num like ? ");
            args.add("%"+transportBillQueryVo.getDependNum()+"%");
        }
        //货主
        if (!StringUtils.isEmpty(transportBillQueryVo.getGoodOwner())) {
            sql.append(" and vatm.vat_company_name like ?");
            args.add("%" + transportBillQueryVo.getGoodOwner() + "%");
        }

        //结算状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getSettleStatus())) {
            if ("10".equalsIgnoreCase(transportBillQueryVo.getSettleStatus().trim())) {
                sql.append(" and (t.settle_status = '10' or t.settle_status  is null)");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getSettleStatus().trim())) {
                sql.append(" and t.settle_status = '20' and p.owner_payapply_flag = '0' ");
            }

        }

        //司机姓名
        if (!StringUtils.isEmpty(transportBillQueryVo.getDriverName())) {
            sql.append(" and (select t1.`name` from driver t1 where t1.id = t.driver_id) like ? ");
            args.add("%" + transportBillQueryVo.getDriverName() + "%");
        }

        //处理标记
        if (!StringUtils.isEmpty(transportBillQueryVo.getOtherFlag())) {
            sql.append(" and t.orther_flag = ? ");
            args.add(transportBillQueryVo.getOtherFlag());
        }

        //是否飞单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFeidan())) {
            if (transportBillQueryVo.getFeidan()) {
                sql.append(" and t.if_feidan = 'Y' ");
            } else {
                sql.append(" and t.if_feidan = 'N' ");
            }
        }
        //早期预警
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())) {
            if (transportBillQueryVo.getEarlyWarning()) {
                sql.append(" and t.create_date <= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            } else {
                sql.append(" and t.create_date >= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            }
        }
        //是否拼单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())) {
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)");
            } else {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null)");
            }
        }

        //委托人
        if (!StringUtils.isEmpty(transportBillQueryVo.getWtBillSender())) {
            sql.append(" and t.bill_sender like concat('%',?,'%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        //创建时间
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())) {
            sql.append("    and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())) {
            sql.append("    AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        //取单地
        if (!StringUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())) {
            sql.append(" and t.get_order_plate like ? ");
            args.add("%" + transportBillQueryVo.getGetOrderPlate() + "%");
        }

        //装货地
        if (!StringUtils.isEmpty(transportBillQueryVo.getStartPlate())) {
            sql.append(" and t.start_plate like ? ");
            args.add("%" + transportBillQueryVo.getStartPlate() + "%");
        }

        //目的地
        if (!StringUtils.isEmpty(transportBillQueryVo.getEndPlate())) {
            sql.append(" and t.end_plate like ? ");
            args.add("%" + transportBillQueryVo.getEndPlate() + "%");
        }

        //完成时间
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())) {
            sql.append("    AND t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())) {
            sql.append("    AND t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        //单据来源
        if (!StringUtils.isEmpty(transportBillQueryVo.getFromType())) {
            sql.append(" and g.from_type = ? ");
            args.add(transportBillQueryVo.getFromType());
        }

        //装车重量是否维护
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveZcWeight())) {
            if (transportBillQueryVo.getIfHaveZcWeight()) {
                sql.append(" and t.truck_loading_weight is not null ");
            } else {
                sql.append(" and t.truck_loading_weight is null ");
            }
        }
        //收货重量维护
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveShWeight())) {
            if (transportBillQueryVo.getIfHaveShWeight()) {
                sql.append(" and t.take_delivery_weight is not null ");
            } else {
                sql.append(" and t.take_delivery_weight is null ");
            }
        }

        //司机工商注册状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getDriverStatus())) {
            sql.append(" and b.status = ? ");
            args.add(transportBillQueryVo.getDriverStatus());
        }

        //司机是否是工商户
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfBusinessInfo())) {
            if (transportBillQueryVo.getIfBusinessInfo()) {
                sql.append(" and ifnull(b.status,'10') > '10' ");
            } else {
                sql.append(" and ifnull(b.status,'10') <= '10' ");
            }
        }

        //是否工商户
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfGsInfo())) {
            if (transportBillQueryVo.getIfGsInfo()) {
                sql.append(" and ifnull(b.status,'10') = '30' ");
            } else {
                sql.append(" and ifnull(b.status,'10') <> '30' ");
            }
        }

        //最终付款人
        if (!StringUtils.isEmpty(transportBillQueryVo.getFinallyPay())) {
            sql.append(" and if(t.if_tax_transport='Y',v1.vat_carry_name , c.company_name) like ? ");
            args.add("%"+transportBillQueryVo.getFinallyPay()+"%");
        }

        //运输订单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id like ? ");
            args.add("%"+transportBillQueryVo.getTransId()+"%");
        }

        //或原单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id like ? ");
            args.add("%"+transportBillQueryVo.getPublishId()+"%");
        }

        //承运单位
        if (!StringUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(transportBillQueryVo.getCompanyName());
        }

        //========  查询条件 结束 ===================

        sql.append("  order by t.CREATE_DATE desc ");


        return readPageQuery.query(sql.toString(), args, transportBillQueryVo, TransportationDeliveryVo.class);

    }

    @Override
    public List<TransportationDeliveryVo> queryList(TransportBillQueryVo transportBillQueryVo) {

        //标识 是否为 货主级查询
        boolean isPublisher = "publisher".equalsIgnoreCase(transportBillQueryVo.getChannel());
        //标识 是否为 平台级
        boolean isPlat = "plat".equals(transportBillQueryVo.getChannel());

        List<Object> args = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT t.delivery_id, ");
        sql.append("        t.publish_id, ");
        sql.append("        (SELECT t2.company_name FROM company t2 WHERE g.company_id = t2.seq_id)            AS consignor_name, ");
        sql.append("        ''                                                                                 AS publish_num, ");
        sql.append("        t.trans_id, ");
        sql.append("        t.weight, ");
        sql.append("        t.amount, ");
        sql.append("        t.price, ");
        sql.append("        round(t.weight * t.price, 2)                                                       AS amountForPlat, ");
        sql.append("        d.id_num                                                                           AS Card, ");
        sql.append("        t.qty, ");
        sql.append("        t.bill_taker, ");
        sql.append("        t.bill_taker_mobile, ");
        sql.append("        t.comfirm_pic_local, ");
        sql.append("        t.receiver_mobile, ");
        sql.append("        t.create_date, ");
        sql.append("        t.company_id, ");
        sql.append("        (SELECT t1.company_name FROM company t1 WHERE t1.seq_id = t.company_id)            AS company_name, ");
        sql.append("        (SELECT t1.contact_mobile FROM company t1 WHERE t1.seq_id = t.company_id)          AS contact_mobile, ");
        sql.append("        d.id_num                                                                           AS id_num, ");
        sql.append("        t.start_plate, ");
        sql.append("        t.end_plate, ");
        sql.append("        t.get_order_plate, ");
        sql.append("        t.driver_id, ");
        sql.append("        ''                                                                                 AS publish_num, ");
        sql.append("        d.`name`                                                                           AS name, ");
        sql.append("        d.`phone`                                                                          AS phone, ");
        sql.append("        t.vehicle_id, ");
        sql.append("        v.vehicle_num                                                                      AS vehicle_num, ");
        sql.append("        t.status, ");
        sql.append("        t.good_type_desc, ");
        sql.append("        t.bill_sender, ");
        sql.append("        t.bill_sender_mobile, ");
        sql.append("        t.take_delivery_weight, ");
        sql.append("        d.phone                                                                            AS driver_mobile, ");
        sql.append("        t.status, ");
        sql.append("        IF(t.status = '10','待取单',IF(t.status = '20','待装货',IF(t.status = '30','待收货',IF(t.status = '90','已完成',IF(t.status = '00','已作废','待取单'))))) AS statusDesc, ");
        sql.append("        t.settle_weight, ");
        sql.append("        t.settle_amount, ");
        sql.append("        t.settle_status, ");
        sql.append("        t.orther_flag, ");
        sql.append("        t.if_fd_judge, ");
        sql.append("        IF(t.orther_flag = '1', '已处理', '未处理')                                              AS orther_flag_name, ");
        sql.append("        t.if_feidan , ");
        sql.append("        tm.prod_desc                                                                       AS prod_desc, ");
        sql.append("        g.from_type                                                                        AS from_type, ");
        sql.append("        g.depend_num                                                                       AS depend_num, ");
        sql.append("        g.logistics_mark, ");
        sql.append("        if(g.from_type = 'JK_U9', '立恒新大宗',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), if(g.from_type = 'DS', '销售电商', if(g.from_type = 'PT', '平台货源', ");
        sql.append("                                                                             if(g.from_type = 'JK_U8', ");
        sql.append("                                                                                if(g.logistics_mark = 'X', '大宗销售', '大宗采购'), ");
        sql.append("                                                                                '平台货源'))))) AS docOrigin, ");
        sql.append("        (SELECT t1.user_name FROM loginverify t1 WHERE t1.user_id = t.update_person)       AS update_person_name, ");
        sql.append("        g.pin_dan_num                                                                      AS pinDanNum, ");
        sql.append("        t.delivery_time, ");
        sql.append("        t.update_date, ");
        sql.append("        t.pickup_date, ");
        sql.append("        t.finish_time, ");
        sql.append("        v1.if_end, ");
        sql.append("        ifnull(t.broker_people_toll_type, 'dj')                                            AS broker_people_toll_type, ");
        sql.append("        ifnull(t.broker_people_toll_amount, '0.00')                                        AS broker_people_toll_amount, ");
        sql.append("        ifnull(t.broker_people_toll_ratio, '0.00')                                         AS broker_people_toll_ratio, ");
        sql.append("        t.if_broker_people_toll_flag, ");
        sql.append("        if(t.broker_people_toll_type = 'dj', '定额', '定率')                                   AS brokerPeopleTollType, ");
        sql.append("        if(t.broker_people_toll_type = 'dj', t.broker_people_toll_amount, ");
        sql.append("           round(t.broker_people_toll_ratio * t.amount, 2))                                AS brokerPeopleTollAmount, ");
        sql.append("        g.depend_num                                                                       AS depend_num, ");
        sql.append("        vatm.vat_company_name                                                              AS goodOwner, ");
        sql.append("        t.standard_tax                                                                     AS standard_tax, ");
        sql.append("        t.if_tax_transport, ");
        sql.append("        c.early_warning_days                                                               AS early_warning_days, ");
        sql.append("        c.company_name publish_company_name ,");
        sql.append("        if(t.if_tax_transport = 'Y', v1.vat_carry_name, c.company_name)                    AS finally_pay, ");
        sql.append("        t.remark, ");
        sql.append("        IF('p.trece_bank_type=1', '发单人维护账号', '承运人银行账号')                                    AS receBankType, ");
        sql.append("        g.ds_if_settle                                                                     AS dsIfSettle, ");
        sql.append("        if(g.ds_if_settle = 0, '否', '是')                                                   AS dsIfSettleDesc, ");
        sql.append("        t.truck_loading_weight, ");
        sql.append("        t.take_delivery_weight, ");
        sql.append("        t.if_upload_receipt_flag, ");
        sql.append("        t.comfirm_pic1_local, ");
        sql.append("        ifnull(j.dz_jk_cancel, 0)                                                          AS dz_jk_cancel, ");
        sql.append("        ifnull(j.delivery_info_zdwl_source, '0')                                           AS delivery_info_zdwl_source, ");
        sql.append("        t.operate_type, ");
        sql.append("        b.status                                                                           AS driverStatus, ");
        sql.append("        if(ifnull(b.status,'10') > '10','Y','N')                                           AS if_dengji_info, ");
        sql.append("        if(ifnull(b.status,'10') > '10','是','否')                                         AS if_dengji_info_desc, ");
        sql.append("        if(ifnull(b.status,'10') = '30','Y','N')                                           AS if_gs_info, ");
        sql.append("        if(ifnull(b.status,'10') = '30','是','否')                                         AS if_gs_info_desc, ");
        sql.append("        if(b.status='10','未申请',if(b.status='20','申请中',if(b.status='30','已开户',if(b.status='25','已申请','未知')))) AS driverStatusDesc, ");
        if (isPublisher){
            sql.append("    i.if_invoice , ");
            sql.append("    i.invoice_no , ");
        }
        sql.append("        v1.vat_carry_name, ");
        sql.append("        if(t.if_tax_transport = 'Y', (SELECT t1.company_name FROM company t1 WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("           '')                                                                             AS carryCompanyName, ");
        sql.append("        t.owner_adjust_flag, ");
        sql.append("        t.owner_adjust_type, ");
        sql.append("        t.owner_adjust_amt, ");
        sql.append("        t.dz_status, ");
        sql.append("        p.status as payStatus , ");
        sql.append("        round(if(v1.vat_acc_type = '1' ");
        sql.append("                   AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), if(v1.vat_acc_type = '1' ");
        sql.append("                                                                                           AND v1.vat_rate_chose = '2', ");
        sql.append("                                                                                         t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                                                                         if(v1.vat_acc_type = '2' ");
        sql.append("                                                                                              AND ");
        sql.append("                                                                                            v1.vat_rate_chose = '1', ");
        sql.append("                                                                                            t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                                                                            t.price / (1 - v1.vat_policy_rate)))), ");
        sql.append("              2)                                                                           AS price_tax, ");
        sql.append("        round(t.weight * round(if(v1.vat_acc_type = '1' ");
        sql.append("                                    AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), ");
        sql.append("                                  if(v1.vat_acc_type = '1' ");
        sql.append("                                       AND v1.vat_rate_chose = '2', t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                     if(v1.vat_acc_type = '2' ");
        sql.append("                                          AND v1.vat_rate_chose = '1', t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                        t.price / (1 - v1.vat_policy_rate)))), 2), 2)      AS taxAmount, ");
        sql.append("        round(t.weight * round(if(v1.vat_acc_type = '1' ");
        sql.append("                                    AND v1.vat_rate_chose = '1', t.price * (1 + v1.vat_standard_rate), ");
        sql.append("                                  if(v1.vat_acc_type = '1' ");
        sql.append("                                       AND v1.vat_rate_chose = '2', t.price * (1 + v1.vat_policy_rate), ");
        sql.append("                                     if(v1.vat_acc_type = '2' ");
        sql.append("                                          AND v1.vat_rate_chose = '1', t.price / (1 - v1.vat_standard_rate), ");
        sql.append("                                        t.price / (1 - v1.vat_policy_rate)))), 2), 2)      AS amount_tax, ");
        sql.append("        ifnull(t.good_price, g.good_price)                                                 AS good_price, ");
        sql.append("        ifnull(t.loss_type, g.loss_type)                                                   AS loss_type, ");
        sql.append("        if(ifnull(t.loss_type, '0') = 0, g.loss_ratio, t.loss_ratio)                       AS loss_ratio, ");
        sql.append("        ifnull(t.loss_weight, g.loss_weight)                                               AS loss_weight, ");
        sql.append("        if(t.`loss_type`='1','定额','定率')                                                AS loss_type_desc, ");
        sql.append("        if(t.`loss_type`='1',CONCAT(ifnull(t.loss_weight,g.loss_weight)*1000,'（kg/车）'),CONCAT(t.loss_ratio*1000,'（‰/车）')) as loss_weight_desc ");
        sql.append(" FROM transportationdelivery t ");
        sql.append("        LEFT JOIN driver d ON t.driver_id = d.id ");
        sql.append("        LEFT JOIN goodsorderm g ON t.publish_id = g.publish_id ");
        sql.append("        JOIN transportationm tm ON t.trans_id = tm.trans_id ");
        sql.append("        LEFT JOIN vehicle v ON t.vehicle_id = v.vehicle_id ");
        sql.append("        LEFT JOIN goodsordermjksetplat j ON j.tms_fd_company_id = t.publish_company_id ");
        sql.append("                                              AND j.tms_from_type = g.from_type ");
        sql.append("                                              AND j.tms_platform_id = t.platform_id ");
        sql.append("                                              AND j.tms_from_type IN ('JK_U8', 'JK_U9') ");
        sql.append("                                              AND j.ec_plat_name = g.from_plat_name ");
        sql.append("        LEFT JOIN vatflowdetail v1 ");
        sql.append("          ON v1.vat_flow_master_id = t.vat_flow_master_id and t.if_tax_transport = 'Y' and v1.if_end = 'Y' ");
        sql.append("        LEFT JOIN company c ON c.seq_id = t.publish_company_id ");
        sql.append("        LEFT JOIN business_registration b ON d.id_num = b.id_num ");
        sql.append("        LEFT JOIN vatflowmaster vatm ON vatm.vat_flow_master_id = t.vat_flow_master_id ");

//        if ((!StringUtils.isEmpty(transportBillQueryVo.getSettleStatus())&&"20".equals(transportBillQueryVo.getSettleStatus().trim()))||isPublisher) {
        sql.append("        LEFT JOIN pay_bill p on t.zf_id = p.zf_id and t.platform_id = p.platform_id ");
//        }

        if (isPublisher){
            sql.append(" LEFT JOIN invoicedetail i ON (t.delivery_id = i.delivery_id and i.invoice_title_id = "+transportBillQueryVo.getCompanyId()+" and i.if_invoice > 0) ");
        }


        sql.append("  WHERE  t.platform_id = 'SX*HSY*0001' ");

        //========  查询条件 开始 ===================


        //发行方
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishCompanyId())){
            sql.append(" and t.publish_company_id = ? ");
            args.add(transportBillQueryVo.getPublishCompanyId());
        }

        //是否委托承运
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        //状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getStatus())) {
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVatCarryId())) {
            sql.append(" and v1.vat_carry_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '1' and t.status != '90'))");
            args.add(transportBillQueryVo.getVatCarryId());
        }

        //调度单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())) {
            sql.append(" and t.delivery_id like ? ");
            args.add("%"+transportBillQueryVo.getDeliveryId()+"%");
        }
        //车牌号
        if (!StringUtils.isEmpty(transportBillQueryVo.getVehicleNum())) {
            sql.append("and t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        //单据号
        if (!StringUtils.isEmpty(transportBillQueryVo.getDependNum())) {
            sql.append(" and g.depend_num = ? ");
            args.add(transportBillQueryVo.getDependNum());
        }
        //货主
        if (!StringUtils.isEmpty(transportBillQueryVo.getGoodOwner())) {
            sql.append(" and vatm.vat_company_name like ?");
            args.add("%" + transportBillQueryVo.getGoodOwner() + "%");
        }

        //结算状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getSettleStatus())) {
            if ("10".equalsIgnoreCase(transportBillQueryVo.getSettleStatus().trim())) {
                sql.append(" and (t.settle_status = '10' or t.settle_status  is null)");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getSettleStatus().trim())) {
                sql.append(" and t.settle_status = '20' and p.owner_payapply_flag = '0' ");
            }

        }

        //司机姓名
        if (!StringUtils.isEmpty(transportBillQueryVo.getDriverName())) {
            sql.append(" and (select t1.`name` from driver t1 where t1.id = t.driver_id) like ? ");
            args.add(transportBillQueryVo.getDriverName());
        }

        //处理标记
        if (!StringUtils.isEmpty(transportBillQueryVo.getOtherFlag())) {
            sql.append(" and t.orther_flag = ? ");
            args.add(transportBillQueryVo.getOtherFlag());
        }

        //是否飞单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFeidan())) {
            if (transportBillQueryVo.getFeidan()) {
                sql.append(" and t.if_feidan = 'Y' ");
            } else {
                sql.append(" and t.if_feidan = 'N' ");
            }
        }
        //早期预警
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())) {
            if (transportBillQueryVo.getEarlyWarning()) {
                sql.append(" and t.create_date <=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            } else {
                sql.append(" and t.create_date >=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM\n" +
                        "                        company c where t.publish_company_id=c.seq_id) day)\n" +
                        "                AND t.status>00 AND t.status<90 ");
            }
        }
        //是否拼单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())) {
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)");
            } else {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null)");
            }
        }

        //委托人
        if (!StringUtils.isEmpty(transportBillQueryVo.getWtBillSender())) {
            sql.append(" and t.bill_sender like concat('%',?,'%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        //创建时间
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())) {
            sql.append("    AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())) {
            sql.append("    AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        //取单地
        if (!StringUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())) {
            sql.append(" and t.get_order_plate like ? ");
            args.add("%" + transportBillQueryVo.getGetOrderPlate() + "%");
        }

        //装货地
        if (!StringUtils.isEmpty(transportBillQueryVo.getStartPlate())) {
            sql.append(" and t.start_plate like ? ");
            args.add("%" + transportBillQueryVo.getStartPlate() + "%");
        }

        //目的地
        if (!StringUtils.isEmpty(transportBillQueryVo.getEndPlate())) {
            sql.append(" and t.end_plate like ? ");
            args.add("%" + transportBillQueryVo.getEndPlate() + "%");
        }

        //完成时间
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())) {
            sql.append("    AND t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())) {
            sql.append("    AND t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        //单据来源
        if (!StringUtils.isEmpty(transportBillQueryVo.getFromType())) {
            sql.append(" and g.from_type = ? ");
            args.add(transportBillQueryVo.getFromType());
        }

        //装车重量是否维护
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveZcWeight())) {
            if (transportBillQueryVo.getIfHaveZcWeight()) {
                sql.append(" and t.truck_loading_weight is not null ");
            } else {
                sql.append(" and t.truck_loading_weight is null ");
            }
        }
        //收货重量维护
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveShWeight())) {
            if (transportBillQueryVo.getIfHaveShWeight()) {
                sql.append(" and t.take_delivery_weight is not null ");
            } else {
                sql.append(" and t.take_delivery_weight is null ");
            }
        }

        //司机工商注册状态
        if (!StringUtils.isEmpty(transportBillQueryVo.getDriverStatus())) {
            sql.append(" and b.status = ? ");
            args.add(transportBillQueryVo.getDriverStatus());
        }

        //司机是否是工商户
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfBusinessInfo())) {
            if (transportBillQueryVo.getIfBusinessInfo()) {
                sql.append(" and ifnull(b.status,'10') > '10' ");
            } else {
                sql.append(" and ifnull(b.status,'10') <= '10' ");
            }
        }

        //是否工商户
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfGsInfo())) {
            if (transportBillQueryVo.getIfGsInfo()) {
                sql.append(" and ifnull(b.status,'10') = '30' ");
            } else {
                sql.append(" and ifnull(b.status,'10') <> '30' ");
            }
        }

        //最终付款人
        if (!StringUtils.isEmpty(transportBillQueryVo.getFinallyPay())) {
            sql.append(" and if(t.if_tax_transport='Y',v1.vat_carry_name , c.company_name) like ? ");
            args.add("%"+transportBillQueryVo.getFinallyPay()+"%");
        }

        //运输订单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id like ? ");
            args.add("%"+transportBillQueryVo.getTransId()+"%");
        }

        //或原单号
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id like ? ");
            args.add("%"+transportBillQueryVo.getPublishId()+"%");
        }

        //承运单位

        if (!StringUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(transportBillQueryVo.getCompanyName());
        }


        //========  查询条件 结束 ===================

        sql.append("  order by t.CREATE_DATE desc limit 0, 30000 ");


        return readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);

    }

    @Override
    public List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo) {

        StringBuilder sql = new StringBuilder();
        List<Object> args = new ArrayList<>();
        sql.append("SELECT ");
        sql.append("	t.delivery_id, ");
        sql.append("	t.publish_id, ");
        sql.append("	t.create_date, ");
        sql.append("	t.weight, ");
        sql.append("	t.`status`,");
        sql.append("	(SELECT t1.company_name FROM company t1 ");
        sql.append("	WHERE t1.seq_id = t.company_id) AS companyName, ");
        sql.append("	d.id_num, ");
        sql.append("	t.start_plate, ");
        sql.append("	t.end_plate, ");
        sql.append("	d.`name`, ");
        sql.append("	v.vehicle_num, ");
        sql.append("	d.phone AS driverMobile, ");
        sql.append("	if(t.if_tax_transport='Y',(SELECT t1.company_name FROM company t1 WHERE t1.seq_id = ");
        sql.append("	t.carry_company_id),'') AS carryCompanyName ");
        sql.append("FROM ");
        sql.append("	TransportationDelivery AS t ");
        sql.append("	LEFT JOIN vehicle v ON t.vehicle_id = v.vehicle_id ");
        sql.append("	LEFT JOIN driver d ON t.driver_id = d.id ");
        sql.append("	LEFT JOIN company c  ON (c.seq_id = t.publish_company_id) ");
        sql.append("WHERE 1 = 1 ");
        // 平台ID
        if (!StringUtils.isEmpty(vo.getPlatformId())) {
            sql.append(" and t.platform_id = ? ");
            args.add(vo.getPlatformId());
        }
        // 货源单ID
        if (null != vo.getPublishId()) {
            sql.append(" and t.publish_id = ? ");
            args.add(vo.getPublishId());
        }


        return readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
    }


    @Override
    public IntervalTimeVo intervalTime(Long deliveryId){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT oc.times , oc.publish_company_name ");
        sql.append(" FROM transportationdelivery t, ");
        sql.append("      goodsorderm g, ");
        sql.append("      operateconfig oc ");
        sql.append(" WHERE t.publish_id = g.publish_id ");
        sql.append("   AND t.publish_company_id = oc.publish_company_id ");
        sql.append("   AND g.from_type = oc.from_type ");
        sql.append("   AND g.logistics_mark = oc.logistics_mark ");
        sql.append("   AND oc.oc_status = '20' ");
        sql.append("   and oc.type = '02' ");
        sql.append("   AND t.delivery_id = ? ");
        sql.append(" LIMIT 1 ");

        List<Object> args = new ArrayList<>();
        args.add(deliveryId);

        List<IntervalTimeVo> list = readPageQuery.list(sql.toString(), args, IntervalTimeVo.class);

        if (list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public DeliveryComplateWeightVo findCompleteWeightByTransId(Long transId, String platformId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT sum(t.weight) as sumWeight, ");
        sql.append("        sum(t.qty) as sumQty, ");
        sql.append("        t1.init_weight, ");
        sql.append("        t1.init_qty ");
        sql.append(" FROM apptms.transportationdelivery t, ");
        sql.append("      transportationm t1 ");
        sql.append(" where t.platform_id = t1.platform_id ");
        sql.append("   and t.trans_id = t1.trans_id ");
        sql.append("   and t.trans_id = ? ");
        sql.append("   and t.platform_id = ? ");
        sql.append("   and t.status = '90' ");

        List<Object> args = new ArrayList<>();

        args.add(transId);
        args.add(platformId);

        List<DeliveryComplateWeightVo> list = readPageQuery.list(sql.toString(), args, DeliveryComplateWeightVo.class);
        if (ObjectUtils.isEmpty(list)){
            return null;
        }

        return list.get(0);
    }

    @Override
    public DeliveryComplateWeightVo findCompleteWeightByPublishId(Long publishId, String platformId) {

        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT sum(t.weight) as sumWeight, ");
        sql.append("        sum(t.qty) as sumQty, ");
        sql.append("        t1.init_weight, ");
        sql.append("        t1.init_qty ");
        sql.append(" FROM apptms.transportationdelivery t, ");
        sql.append("      goodsorderm t1 ");
        sql.append(" where t.platform_id = t1.platform_id ");
        sql.append("   and t.publish_id = t1.publish_id ");
        sql.append("   and t.publish_id = ? ");
        sql.append("   and t.platform_id = ? ");
        sql.append("   and t.status = '90' ");

        List<Object> args = new ArrayList<>();

        args.add(publishId);
        args.add(platformId);

        List<DeliveryComplateWeightVo> list = readPageQuery.list(sql.toString(), args, DeliveryComplateWeightVo.class);
        if (ObjectUtils.isEmpty(list)){
            return null;
        }

        return list.get(0);
    }
    @Override
    public Page<TransportationDeliveryQueryVo> queryListWarning(TransportationDeliveryQueryVo vo) {

        List<Object> arg = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("      SELECT   " );
        sql.append("   t.delivery_id,   t.publish_id,  " );
        sql.append("    '' as publish_num,   t.trans_id, " );
        sql.append("     d.id_num AS Card,   t.weight,  " );
        sql.append("    t.price,   t.amount,   " );
        sql.append("   date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as create_date ,  " );
        sql.append("    t.company_id,  " );
        sql.append("    (select t1.company_name from Company t1 where t1.seq_id = t.company_id) as   company_name,  " );
        sql.append("    (select t1.contact_mobile from Company t1 where t1.seq_id = t.company_id) as   contactMobile,  " );
        sql.append("    (select t1.contact_name from Company t1 where t1.seq_id = t.company_id) as   contactName,  " );
        sql.append("    t.start_plate,   t.end_plate,   t.driver_id,   t.comfirm_pic_local, " );
        sql.append("     (select t1.`name` from Driver t1 where t1.id = t.driver_id) as name,  " );
        sql.append("    (select t2.company_id from loginverify t2 where t2.platform_id =   t.platform_id and t2.driver_id = t.driver_id) as driver_company_id,  " );
        sql.append("    (select t1.vehicle_num from Vehicle t1 where t.vehicle_id =   t1.vehicle_id) as vehicle_num,   t.status,  " );
        sql.append("    (select t2.phone from Driver t2 where t2.id = t.driver_id ) as phone,  " );
        sql.append("    if(t.status = '10','待取单',if(t.status =   '20','待装货',if(t.status='30','待收货',if(t.status='90','已完成',if(t.status =   '00' ,'已作废' ,'待取单'))))) as statusDesc,  " );
        sql.append("    t.price,   t.orther_flag,   t.good_type,   t.good_type_desc,   if(t.if_feidan = 'Y','是','不是') as iffly, " );
        sql.append("     (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id)   as prod_desc, " );
        sql.append("     (SELECT t1.from_type FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id)   as from_type,  " );
        sql.append("    (SELECT t1.depend_num FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id)   as depend_num, " );
        sql.append("     t.publish_company_id,   " );
        sql.append("   (SELECT t1.company_name FROM Company t1 where t1.seq_id =   t.publish_company_id) as consignor_name, " );
        sql.append("     (SELECT t1.user_name FROM loginverify t1 WHERE t1.user_id = t.update_person)   as update_person,  " );
        sql.append("    (SELECT t1.pin_dan_num FROM goodsorderm t1 WHERE t.publish_id =   t1.publish_id) as pinDanNum,   date_format(t.update_date,'%Y-%m-%d %H:%i') as update_date,  " );
        sql.append("    t.good_price as good_price,   " );
        sql.append("   (select g.prod_desc from goodsorderm g where t.publish_id = g.publish_id) as   prod_desc ,    " );
        sql.append("     CONCAT(datediff(now(),t.create_date),'天') as totalTime,    " );
        sql.append("     if(t.finish_time is null or t.finish_time =   '',date_format(t.shSure_date,'%Y-%m-%d %H:%i:%s'),  " );
        sql.append("    date_format(t.finish_time,'%Y-%m-%d %H:%i:%s')) as finish_time, " );
        sql.append("     t.remark  " );
        sql.append("    FROM TransportationDelivery AS t " );
        sql.append("   LEFT JOIN driver d " );
        sql.append("   ON   t.driver_id = d.id   " );
        sql.append("   WHERE 1=1  " );
        sql.append("    AND t.platform_id = ?   " );
        arg.add(vo.getPlatformId());
        sql.append("   AND t.status>00   " );
        sql.append("   AND t.status<90   " );
        sql.append("   AND t.create_date <=DATE_SUB(now(),INTERVAL (select   c.early_warning_days FROM company c where   t.publish_company_id=c.seq_id) day)     " );
        sql.append("                       and t.if_can_show ='Y'                      " );
        sql.append("       AND    (          t.publish_company_id = ?  " );
        arg.add(vo.getPublishCompanyId());
        sql.append("   	)       " );
        //查询条件

        //状态
        if (!StringUtils.isEmpty(vo.getStatus())){
            sql.append("    and t.status = ?");
            arg.add(vo.getStatus());
        }

        //委托人sender
        if (!StringUtils.isEmpty(vo.getSender())){
            sql.append("    and (select g.sender from goodsorderm g where t.publish_id = g.publish_id) like ?");
            arg.add("%"+vo.getSender()+"%");
        }

        //创建日期
        if (vo.getCreateDateStart() != null){
            sql.append("        AND    t.create_date    >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')" );
            arg.add(vo.getCreateDateStart());
        }

        if (vo.getCreateDateEnd() != null) {
            sql.append("        AND    t.create_date     <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getCreateDateEnd());
        }

        //调度单号
        if (!StringUtils.isEmpty(vo.getDeliveryId())) {
            sql.append("     AND    t.delivery_id like   ?");
            arg.add("%"+vo.getDeliveryId()+"%");
        }

        //车牌号
        if (!StringUtils.isEmpty(vo.getVehicleNum())) {
            sql.append("           AND    (select t1.vehicle_num    from Vehicle t1 where t.vehicle_id = t1.vehicle_id) like    ?" );
            arg.add("%"+vo.getVehicleNum()+"%");
        }

        //是否飞单
        if (!StringUtils.isEmpty(vo.getIfFeidan())){
            sql.append("         AND    t.if_feidan = ?             " );
            arg.add(vo.getIfFeidan());
        }

        //目的地
        if (!StringUtils.isEmpty(vo.getEndPlate())){
            sql.append("             AND    t.end_plate like    ?    " );
            arg.add("%"+vo.getEndPlate()+"%");
        }

        //  是否拼单 1：拼单   2：非拼单
        if (!StringUtils.isEmpty(vo.getPinDan())){
            if (("1").equals(vo.getPinDan())){
                //拼单
                sql.append("    AND         exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and     t1.pin_dan_num is not null)         " );
            }else if (("2").equals(vo.getPinDan())){
                //非拼单
                sql.append("    AND         exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and     t1.pin_dan_num is  null)         " );
            }
        }

        //单据来源  "DS"    电商
        //			JK_U8   采购
        //			UPLOAD  导入货源
        //			PT56    发单
        if (!StringUtils.isEmpty(vo.getFromType())){
            sql.append("     AND    exists(select 1 from    GoodSorderm g where g.publish_id = t.publish_id and g.from_type =    ?" );
            arg.add(vo.getFromType());
            sql.append("     )   " );
        }

        //货源单号
        if (!StringUtils.isEmpty(vo.getPublishNum())){
            sql.append("      AND    t.publish_id like ?     " );
            arg.add("%"+vo.getPublishNum()+"%");
        }

        //处理标记
        if (!StringUtils.isEmpty(vo.getDeFlag())) {
            sql.append("  and t.orther_flag = ?");
            arg.add(vo.getDeFlag());
        }

        //承运单位
        if(!StringUtils.isEmpty(vo.getCarriCompany())){
            sql.append("        AND    t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like    ?" );
            arg.add("%"+vo.getCarriCompany()+"%");
            sql.append("   	 )    " );
        }

        //品种描述
        if (!StringUtils.isEmpty(vo.getProdDesc())){
            sql.append("    and   (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id) like ?");
            arg.add("%"+vo.getProdDesc()+"%");
        }

        //单据号
        if (!StringUtils.isEmpty(vo.getDependNum())){
            sql.append("     AND    t.publish_id in (select    t1.publish_id from GoodsOrderM t1 where t1.depend_num = ? ");
            arg.add(vo.getDependNum());
            sql.append("     )       ");
        }

        //运输订单号
        if (!StringUtils.isEmpty(vo.getTransId())){
            sql.append("       AND    t.trans_id = ?      " );
            arg.add(vo.getTransId());
        }
        return readPageQuery.query(sql.toString(),arg,vo,TransportationDeliveryQueryVo.class);
    }
    
    @Override
    public Long checkGrab(TransportBillQueryVo queryVo) {
        List<Object> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("select sum(count)  from  ");
        sql.append("	(select count(*) as count ");
        sql.append("	    from TransportationM t  ");
        sql.append("	    where 	t.weight > 0  ");
        sql.append("	    AND t.platform_id = ? ");
        args.add(queryVo.getPlatformId());
        sql.append("	    and t.status = '20' ");
        if(null != queryVo.getCompanyId()) {
        	sql.append("and t.company_id = ? ");
        	args.add(queryVo.getCompanyId());
        }
        sql.append("		GROUP BY if(t.pri_publish_id = -1, (select g.pri_publish_id from goodsorderm g where g.publish_id = t.publish_id ), t.pri_publish_id) ");
        sql.append(" 	)");
        sql.append("aa ");

		return readPageQuery.count(sql.toString(), args.toArray());
    }

    @Override
    public TransportationDeliveryVo queryPublisherId(TransportBillQueryVo vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  end_plate, ");
        sql.append("  publish_id, ");
        sql.append("  delivery_id, ");
        sql.append("  start_plate, ");
        sql.append("  good_type_desc, ");
        sql.append("  price, ");
        sql.append("  end_plate, ");
        sql.append("  (SELECT ");
        sql.append("    t1.sendKM ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS sendKM, ");
        sql.append("  (SELECT ");
        sql.append("    t1.receiver_mobile ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS receiver_mobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.sender_mobile ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS sender_mobile, ");
        sql.append("  (SELECT ");
        sql.append("    t1.bill_sender_mobile ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id) AS bill_sender_mobile, ");
        sql.append("  (SELECT ");
        sql.append("   t1.create_date ");
        sql.append("  FROM ");
        sql.append("    transportationm t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS create_date, ");
        sql.append("  (SELECT ");
        sql.append("    t1.prod_desc ");
        sql.append("  FROM ");
        sql.append("    TransportationM t1 ");
        sql.append("  WHERE t1.trans_id = t.trans_id) AS prod_desc, ");
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
        sql.append("  (SELECT ");
        sql.append("   t1.pickup_date ");
        sql.append("  FROM ");
        sql.append("    GoodsOrderM t1 ");
        sql.append("  WHERE t1.publish_id = t.publish_id ");
        sql.append("  LIMIT 1) AS pickup_date, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
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
        sql.append("  (SELECT ");
        sql.append("    t1.vehicle_num ");
        sql.append("  FROM ");
        sql.append("    Vehicle t1 ");
        sql.append("  WHERE t.vehicle_id = t1.vehicle_id) AS vehicle_num ");
        sql.append("FROM ");
        sql.append("  TransportationDelivery t ");
        sql.append("WHERE delivery_id = ? ");
        sql.append("   AND platform_id = ? ");
        sql.append("   AND publish_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getDeliveryId());
        args.add(vo.getPlatformId());
        args.add(vo.getPublishId());

        List<TransportationDeliveryVo> list = readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
        if(list != null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public TransportationDeliveryVo deliveryCheck(TransportBillQueryVo vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  g.pin_dan_num, ");
        sql.append("  t.platform_id, ");
        sql.append("  (SELECT ");
        sql.append("    IFNULL(l.user_type, 'GS') ");
        sql.append("  FROM ");
        sql.append("    loginverify l ");
        sql.append("  WHERE l.company_id = t.company_id ");
        sql.append("    AND l.driver_id = t.driver_id) AS user_type, ");
        sql.append("  g.pri_publish_id ");
        sql.append("FROM ");
        sql.append("  transportationdelivery t, ");
        sql.append("  goodsorderm g ");
        sql.append("WHERE t.delivery_id = ? ");
        sql.append("   AND t.platform_id = ? ");
        sql.append("   AND t.status = '10' ");
        sql.append("  AND t.publish_id = g.publish_id ");
        sql.append("  AND g.from_type = 'DS' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getDeliveryId());
        args.add(vo.getPlatformId());

        List<TransportationDeliveryVo> list = readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
        if(list != null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Page<TransportationDeliveryVo> queryCyPage(TransportBillQueryVo transportBillQueryVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t2 ");
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
        sql.append("  t.create_date,  ");
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
        sql.append("    t.delivery_time ");
        sql.append("  AS zcSureDate, ");
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
        sql.append("  t.truck_loading_weight, ");
        sql.append("  t.take_delivery_weight, ");
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
        sql.append("        TransportationDelivery AS t ");
        sql.append("        LEFT JOIN driver d ");
        sql.append("          ON t.driver_id = d.id ");
        sql.append("      ) ");
        sql.append("      LEFT JOIN goodsorderm g ");
        sql.append("        ON t.publish_id = g.publish_id ");
        sql.append("    ) ");
        sql.append("    JOIN TransportationM tm ");
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
        args.add(transportBillQueryVo.getPlatformId());

        //========  查询条件 开始 ===================
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFromType())){
            sql.append(" and g.from_type = ? ");
            args.add(transportBillQueryVo.getFromType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyId())){
            sql.append(" and t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(transportBillQueryVo.getCompanyId());
        }
        
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getDeliveryId());
        }
        //新增取单地筛选
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())){
            sql.append(" and t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())){
            sql.append(" and t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDependNum())){
            sql.append(" and t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(transportBillQueryVo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVehicleNum())){
            sql.append(" and t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDriverName())){
            sql.append(" and (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getDriverName());
        }

        //处理标记
        if (!StringUtils.isEmpty(transportBillQueryVo.getDeFlag())) {
            if("0".equalsIgnoreCase(transportBillQueryVo.getDeFlag())) {
                sql.append(" and (t.orther_flag = ? or t.orther_flag IS NULL) ");
                args.add(transportBillQueryVo.getDeFlag());
            }else if("1".equalsIgnoreCase(transportBillQueryVo.getDeFlag())){
                sql.append(" and t.orther_flag = ? ");
                args.add(transportBillQueryVo.getDeFlag());
            }
        }

        //是否飞单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFeidan())) {
            if (transportBillQueryVo.getFeidan()) {
                sql.append(" and t.if_feidan = 'Y' ");
            } else {
                sql.append(" and t.if_feidan = 'N' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(transportBillQueryVo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishCompanyId())){
            sql.append(" and t.publish_company_id = ? ");
            args.add(transportBillQueryVo.getPublishCompanyId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id = ? ");
            args.add(transportBillQueryVo.getTransId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id = ? ");
            args.add(transportBillQueryVo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartPlate())){
            sql.append(" and t.start_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndPlate())){
            sql.append(" and t.end_plate  like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getEndPlate());
        }

        //是否拼单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())) {
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists (SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)");
            } else {
                sql.append(" and exists (SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null)");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())){
            sql.append(" and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())){
            sql.append(" and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStatus())){
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
//            if (("10,20,30").equals(transportBillQueryVo.getStatus()) ){
//                sql.append("    and t.status !=  '90'");
//                sql.append("    and t.status !=  '00'");
//            }else {
//                sql.append(" and t.status = ? ");
//                args.add(transportBillQueryVo.getStatus());
//            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())){
            if(transportBillQueryVo.getEarlyWarning()){
                sql.append(" and t.create_date <= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }else{
                sql.append(" and t.create_date >= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id = c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIffly())){
            sql.append(" and t.if_feidan = ? ");
            args.add(transportBillQueryVo.getIffly());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getBillSender())){
            sql.append(" and (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayType())){
            sql.append(" and ifnull(t.settle_status,10) = ? ");
            args.add(transportBillQueryVo.getPayType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDsIfSettle())){
            sql.append(" and g.ds_if_settle = ? ");
            args.add(transportBillQueryVo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDriverStatus())){
            sql.append(" and b.status = ? ");
            args.add(transportBillQueryVo.getDriverStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getWtBillSender())){
            sql.append(" and t.bill_sender like concat('%',?,'%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        //========  查询条件 结束 ===================

        sql.append("  order by t.CREATE_DATE desc ");


        return readPageQuery.query(sql.toString(), args, transportBillQueryVo, TransportationDeliveryVo.class);
    }

    @Override
    public List<TransportationDeliveryVo> queryCyList(TransportBillQueryVo transportBillQueryVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.publish_id, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t2 ");
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
        sql.append("  t.create_date,  ");
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
        sql.append("    t.delivery_time ");
        sql.append("  AS zcSureDate, ");
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
        sql.append("  t.truck_loading_weight, ");
        sql.append("  t.take_delivery_weight, ");
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
        sql.append("        TransportationDelivery AS t ");
        sql.append("        LEFT JOIN driver d ");
        sql.append("          ON t.driver_id = d.id ");
        sql.append("      ) ");
        sql.append("      LEFT JOIN goodsorderm g ");
        sql.append("        ON t.publish_id = g.publish_id ");
        sql.append("    ) ");
        sql.append("    JOIN TransportationM tm ");
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
        args.add(transportBillQueryVo.getPlatformId());

        //========  查询条件 开始 ===================
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFromType())){
            sql.append(" and g.from_type = ? ");
            args.add(transportBillQueryVo.getFromType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyId())){
            sql.append(" and t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '90')) ");
            args.add(transportBillQueryVo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())){
            sql.append(" and t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())){
            sql.append(" and t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDependNum())){
            sql.append(" and t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(transportBillQueryVo.getDependNum());
        }

        //新增取单地筛选
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVehicleNum())){
            sql.append(" and t.vehicle_id in (select t1.vehicle_id from Vehicle t1 where t1.vehicle_num like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getName())){
            sql.append(" and (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and exists(select 1 from company c where c.company_name like CONCAT('%',?,'%') and c.seq_id = t.company_id) ");
            args.add(transportBillQueryVo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishCompanyId())){
            sql.append(" and t.publish_company_id = ? ");
            args.add(transportBillQueryVo.getPublishCompanyId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id = ? ");
            args.add(transportBillQueryVo.getTransId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id = ? ");
            args.add(transportBillQueryVo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartPlate())){
            sql.append(" and t.start_plate like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndPlate())){
            sql.append(" and t.end_plate  like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getEndPlate());
        }

        //是否拼单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())) {
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)");
            } else {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null)");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())){
            sql.append(" and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())){
            sql.append(" and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStatus())){
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())){
            if(transportBillQueryVo.getEarlyWarning()){
                sql.append(" and t.create_date <= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }else{
                sql.append(" and t.create_date >= DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id = c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeFlag())){
            sql.append(" and t.orther_flag = ? ");
            args.add(transportBillQueryVo.getDeFlag());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIffly())){
            sql.append(" and t.if_feidan = ? ");
            args.add(transportBillQueryVo.getIffly());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getBillSender())){
            sql.append(" and (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayType())){
            sql.append(" and ifnull(t.settle_status,10) = ? ");
            args.add(transportBillQueryVo.getPayType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDsIfSettle())){
            sql.append(" and g.ds_if_settle = ? ");
            args.add(transportBillQueryVo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDriverStatus())){
            sql.append(" and b.status = ? ");
            args.add(transportBillQueryVo.getDriverStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getWtBillSender())){
            sql.append(" and t.bill_sender like concat('%',?,'%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        //========  查询条件 结束 ===================

        sql.append("  order by t.CREATE_DATE desc limit 0, 30000 ");

        return readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
    }

    @Override
    public Page<TransportationDeliveryVo> queryHzPage(TransportBillQueryVo transportBillQueryVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.receiver, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.zcSure_date, ");
        sql.append("  t.js_remark AS jsRemark, ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.delivery_num, ");
        sql.append("  t.publish_id, ");
        sql.append("  t.publish_num AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.trans_num, ");
        sql.append("  d.id_num AS Card, ");
        sql.append("  t.weight, ");
        sql.append("  t.price, ");
        sql.append("  t.amount, ");
        sql.append("  p.pay_amount AS realAmount, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  t.get_order_plate, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  d.`name` AS NAME, ");
        sql.append("  d.phone AS driver_mobile, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_id ");
        sql.append("  FROM ");
        sql.append("    loginverify t2 ");
        sql.append("  WHERE t2.platform_id = t.platform_id ");
        sql.append("    AND t2.driver_id = t.driver_id) AS driver_company_id, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  d.phone AS phone, ");
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
        sql.append("  t.truck_loading_weight, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  t.operate_type, ");
        sql.append("  ROUND( ");
        sql.append("    ( ");
        sql.append("      t.truck_loading_weight - t.take_delivery_weight ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS lossWeight, ");
        sql.append("  FORMAT( ");
        sql.append("    ( ");
        sql.append("      FORMAT( ");
        sql.append("        ( ");
        sql.append("          t.truck_loading_weight - t.take_delivery_weight ");
        sql.append("        ), ");
        sql.append("        4 ");
        sql.append("      ) / t.truck_loading_weight ");
        sql.append("    ), ");
        sql.append("    4 ");
        sql.append("  ) AS lossRatio, ");
        sql.append("  t.settle_price, ");
        sql.append("  t.price, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.good_type, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  t.delivery_time, ");
        sql.append("  IF( ");
        sql.append("    t.if_fd_judge = 'Y', ");
        sql.append("    '已评价', ");
        sql.append("    '未评价' ");
        sql.append("  ) AS accFlag, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.ps AS ps, ");
        sql.append("  g.depend_num AS depend_num, ");
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
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未计算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已计算', ");
        sql.append("      '未计算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatusDesc, ");
        sql.append("  t.settle_status, ");
        sql.append("  t.zf_id, ");
        sql.append("  t.zf_num, ");
        sql.append("  g.prod_desc AS prod_desc, ");
        sql.append("  g.sender AS sender, ");
        sql.append("  g.js_type AS jsType, ");
        sql.append("  g.logistics_mark, ");
        sql.append("  g.asds_mark, ");
        sql.append("  IF( ");
        sql.append("    g.from_type = 'JK_U9', ");
        sql.append("    '新大宗采购', IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ),");
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
        sql.append("    c.early_warning_days ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE t.publish_company_id = c.seq_id) AS early_warning_days, ");
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
        sql.append("  t.remark, ");
        sql.append("  p.status AS pay_status, ");
        sql.append("  IF( ");
        sql.append("    (p.`status` = '10'), ");
        sql.append("    '待支付', ");
        sql.append("    IF( ");
        sql.append("      (p.`status` = '20'), ");
        sql.append("      '已支付', ");
        sql.append("      IF( ");
        sql.append("        (p.`status` = '00'), ");
        sql.append("        '已撤销', ");
        sql.append("        IF( ");
        sql.append("          (p.`status` = '30'), ");
        sql.append("          '处理中', ");
        sql.append("          '待支付' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS payStatusDesc, ");
        sql.append("  p.pay_date, ");
        sql.append("  IF( ");
        sql.append("    p.rece_bank_type = '1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    IF( ");
        sql.append("      p.rece_bank_type = '0', ");
        sql.append("      '承运人银行账号', ");
        sql.append("      '' ");
        sql.append("    ) ");
        sql.append("  ) AS receBankType, ");
        sql.append("  p.rece_bank_type, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  (SELECT ");
        sql.append("    IFNULL(l.user_type, 'GS') ");
        sql.append("  FROM ");
        sql.append("    loginverify l ");
        sql.append("  WHERE l.company_id = t.company_id ");
        sql.append("    AND l.driver_id = t.driver_id ");
        sql.append("    AND l.platform_id = t.platform_id) AS userType, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.if_tax_transport, 'N') = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(t.price_tax, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS price_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(ROUND(t.price_tax, 2) * t.weight, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(ROUND(t.price_tax, 2) * t.weight, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS amount_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    t.standard_tax, ");
        sql.append("    '' ");
        sql.append("  ) AS standard_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      t1.company_name ");
        sql.append("    FROM ");
        sql.append("      company t1 ");
        sql.append("    WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryCompanyName, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      t1.contact_mobile ");
        sql.append("    FROM ");
        sql.append("      company t1 ");
        sql.append("    WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryContactMobile, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(j.dz_jk_cancel, 0) AS dz_jk_cancel, ");
        sql.append("  IFNULL( ");
        sql.append("    j.delivery_info_zdwl_source, ");
        sql.append("    '0' ");
        sql.append("  ) AS delivery_info_zdwl_source, ");
        sql.append("  IF( ");
        sql.append("    i.if_invoice = '2', ");
        sql.append("    '已开票', ");
        sql.append("    IF( ");
        sql.append("      i.if_invoice = '1', ");
        sql.append("      '开票中', ");
        sql.append("      '未开票' ");
        sql.append("    ) ");
        sql.append("  ) AS ifInvoice, ");
        sql.append("  i.invoice_no, ");
        sql.append("  t.owner_adjust_flag, ");
        sql.append("  t.owner_adjust_type, ");
        sql.append("  t.owner_adjust_amt, ");
        sql.append("  t.pound_location, ");
        sql.append("  t.pound_num, ");
        sql.append("  t.goods_owner_ps, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    IFNULL( ");
        sql.append("      t.if_broker_people_toll_flag, ");
        sql.append("      'N' ");
        sql.append("    ) = 'N', ");
        sql.append("    '否', ");
        sql.append("    '是' ");
        sql.append("  ) AS if_broker_people_toll_flag, ");
        sql.append("  t.shipping_time, ");
        sql.append("  t.dz_status, ");
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
        sql.append("  t.sign_status, ");
        sql.append("  t.sign_time,  ");
        sql.append("  t.truck_loading_pic,  ");
        sql.append("  t.sign_person_name, ");
        sql.append("  g.contract_number, ");
        sql.append("    tm.create_date as grabDate,");
        sql.append("  g.contract_type ");
        sql.append("FROM ");
        sql.append("  ( ");
        sql.append("    TransportationDelivery AS t ");
        sql.append("    LEFT JOIN pay_bill p ");
        sql.append("      ON t.zf_id = p.zf_id ");
        sql.append("      AND t.platform_id = p.platform_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON t.driver_id = d.id ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("  LEFT JOIN goodsorderm g ");
        sql.append("    ON g.publish_id = t.publish_id ");
        sql.append("  LEFT JOIN TransportationM tm ");
        sql.append("    ON t.trans_id = tm.trans_id ");
        sql.append("  LEFT JOIN goodsordermjksetplat j ");
        sql.append("    ON ( ");
        sql.append("      j.tms_fd_company_id = t.publish_company_id ");
        sql.append("      AND j.tms_from_type = g.from_type ");
        sql.append("      AND j.tms_platform_id = t.platform_id ");
        sql.append("      AND j.tms_from_type IN ('JK_U8', 'JK_U9','JK_U10') ");
        sql.append("      AND j.ec_plat_name = g.from_plat_name ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN invoicedetail i ");
        sql.append("    ON ( ");
        sql.append("      t.delivery_id = i.delivery_id ");
        sql.append("      AND i.invoice_title_id = ? ");
        sql.append("      AND i.if_invoice > 0 ");
        sql.append("    ) ");
        sql.append("        LEFT JOIN vatflowmaster vatm ON vatm.vat_flow_master_id = t.vat_flow_master_id ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.publish_company_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(transportBillQueryVo.getCompanyId());
        args.add(transportBillQueryVo.getPlatformId());
        args.add(transportBillQueryVo.getCompanyId());

        if("N".equals(transportBillQueryVo.getIfShowAdmin())) {
			if("TMS".equals(transportBillQueryVo.getAccountFrom())) {
				sql.append("and t.if_can_show ='Y' ");
			}
			if("DS".equals(transportBillQueryVo.getAccountFrom())) {
				sql.append("and t.if_can_show ='N' and t.fd_user_id = ?");
				args.add(transportBillQueryVo.getUserId());
			}
		}
        
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIsAutoDisplay())){
            if("N".equalsIgnoreCase(transportBillQueryVo.getIsAutoDisplay())){
                sql.append(" and g.is_auto_display = '0' ");
            } else if ("Y".equalsIgnoreCase(transportBillQueryVo.getIsAutoDisplay())) {
                sql.append(" and g.is_auto_display = '1' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayPublishId())){
            sql.append(" and t.publish_id like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getPayPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getAccessFlag())){
            if ("N".equalsIgnoreCase(transportBillQueryVo.getAccessFlag())) {
                sql.append(" and (t.if_fd_judge is null or t.if_fd_judge='N') ");
            } else if ("Y".equalsIgnoreCase(transportBillQueryVo.getAccessFlag())) {
                sql.append(" and t.if_fd_judge='Y' ");
            }
            sql.append(" and (t.status='00' || t.status='90') ");
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDependNum())){
            sql.append(" and t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(transportBillQueryVo.getDependNum().trim());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getSettleflag())){
            if("10".equalsIgnoreCase(transportBillQueryVo.getSettleflag())){
                sql.append(" and t.settle_amount = 0 ");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getSettleflag())) {
                sql.append(" and t.settle_amount > 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayType())){
            if("10".equalsIgnoreCase(transportBillQueryVo.getPayType())){
                sql.append(" and (t.settle_status = '10' or t.settle_status is null) ");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getPayType())) {
                sql.append(" and t.settle_status = '20' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDriverName())){
            sql.append(" and (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVehicleNum())){
            sql.append(" and v.vehicle_num like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPs())){
            sql.append(" and (select t1.ps from goodsorderm t1 where t.publish_id = t1.publish_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getPs());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id = ? ");
            args.add(transportBillQueryVo.getTransId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and (select company_name from Company a where a.platform_id = t.platform_id and a.seq_id = t.company_id) like concat('%', ? ,'%') ");
            args.add(transportBillQueryVo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getInvoiceNo())){
            sql.append(" and i.invoice_no like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getInvoiceNo());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfInvoice())){
            sql.append(" and ifnull(i.if_invoice,0) = ? ");
            args.add(transportBillQueryVo.getIfInvoice());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id = ? ");
            args.add(transportBillQueryVo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())){
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else{
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfPaid())){
            sql.append(" and ifnull(p.status,'10') = ? ");
            args.add(transportBillQueryVo.getIfPaid());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCarriCompany())){
            sql.append(" and t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())){
            if (transportBillQueryVo.getEarlyWarning()) {
                sql.append(" and t.create_date <=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }else{
                sql.append(" and t.create_date >=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())){
            sql.append(" and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())){
            sql.append(" and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())){
            sql.append(" and t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())){
            sql.append(" and t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartPlate())){
            sql.append(" and t.start_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndPlate())){
            sql.append(" and t.end_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStatus())){
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
//            if (("10,20,30").equals(transportBillQueryVo.getStatus()) ){
//                sql.append("    and t.status !=  '90'");
//                sql.append("    and t.status !=  '00'");
//            }else {
//                sql.append(" and t.status = ? ");
//                args.add(transportBillQueryVo.getStatus());
//            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFromType())){
            sql.append(" and exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
            args.add(transportBillQueryVo.getFromType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeFlag())){
            if("0".equalsIgnoreCase(transportBillQueryVo.getDeFlag())){
                sql.append(" and (t.orther_flag = ? or t.orther_flag IS NULL)");
                args.add(transportBillQueryVo.getDeFlag());
            }else if("1".equalsIgnoreCase(transportBillQueryVo.getDeFlag())){
                sql.append(" and t.orther_flag = ?");
                args.add(transportBillQueryVo.getDeFlag());
            }

        }

        //是否飞单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFeidan())) {
            if (transportBillQueryVo.getFeidan()) {
                sql.append(" and t.if_feidan = 'Y' ");
            } else {
                sql.append(" and t.if_feidan = 'N' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfBrokerPeopleTollFlag())){
            sql.append(" and ifnull(t.if_broker_people_toll_flag, 'N') = ? ");
            args.add(transportBillQueryVo.getIfBrokerPeopleTollFlag());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getSender())){
            sql.append(" and (select g.sender from goodsorderm g where t.publish_id = g.publish_id) like CONCAT ('%', ?, '%') ");
            args.add(transportBillQueryVo.getSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getProdDesc())){
            sql.append(" and (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id) like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDsIfSettle())){
            sql.append(" and g.ds_if_settle = ? ");
            args.add(transportBillQueryVo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfSaveImage())){
            if ("1".equalsIgnoreCase(transportBillQueryVo.getIfSaveImage())) {
                sql.append(" and t.comfirm_pic1_local != '' ");
            } else if ("0".equalsIgnoreCase(transportBillQueryVo.getIfSaveImage())) {
                sql.append(" and IFNULL(t.comfirm_pic1_local,0) = 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getWtBillSender())){
            sql.append(" and t.bill_sender like concat('%', ?, '%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveZcWeight())){
            if (transportBillQueryVo.getIfHaveZcWeight()) {
                sql.append(" and t.truck_loading_weight is not null ");
            }else{
                sql.append(" and t.truck_loading_weight is null ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveShWeight())){
            if (transportBillQueryVo.getIfHaveShWeight()) {
                sql.append(" and t.take_delivery_weight is not null ");
            }else{
                sql.append(" and t.take_delivery_weight is null ");
            }
        }

        //货主
        if (!StringUtils.isEmpty(transportBillQueryVo.getGoodOwner())) {
            sql.append(" and vatm.vat_company_name like ?");
            args.add("%" + transportBillQueryVo.getGoodOwner() + "%");
        }
        
        if (!StringUtils.isEmpty(transportBillQueryVo.getSignStatus())) {
            sql.append(" and t.sign_status = ?");
            args.add(transportBillQueryVo.getSignStatus() );
        }

        //合同编号
        if (!StringUtils.isEmpty(transportBillQueryVo.getContractNumber())){
            sql.append("    and g.contract_number Like ?");
            args.add("%"+transportBillQueryVo.getContractNumber()+"%");
        }

        sql.append("  order by t.CREATE_DATE desc ");

        return readPageQuery.query(sql.toString(), args, transportBillQueryVo, TransportationDeliveryVo.class);
    }

    @Override
    public List<TransportationDeliveryVo> queryHzList(TransportBillQueryVo transportBillQueryVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.receiver, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.zcSure_date, ");
        sql.append("  t.js_remark AS jsRemark, ");
        sql.append("  t.delivery_id, ");
        sql.append("  t.delivery_time, ");
        sql.append("  t.delivery_num, ");
        sql.append("  t.publish_id, ");
        sql.append("  t.publish_num AS publish_num, ");
        sql.append("  t.trans_id, ");
        sql.append("  t.trans_num, ");
        sql.append("  d.id_num AS Card, ");
        sql.append("  t.weight, ");
        sql.append("  t.price, ");
        sql.append("  t.amount, ");
        sql.append("  p.pay_amount AS realAmount, ");
        sql.append("  t.create_date, ");
        sql.append("  t.company_id, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("  t.get_order_plate, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.driver_id, ");
        sql.append("  t.comfirm_pic_local, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  d.`name` AS NAME, ");
        sql.append("  (SELECT ");
        sql.append("    t2.company_id ");
        sql.append("  FROM ");
        sql.append("    loginverify t2 ");
        sql.append("  WHERE t2.platform_id = t.platform_id ");
        sql.append("    AND t2.driver_id = t.driver_id) AS driver_company_id, ");
        sql.append("  t.vehicle_id, ");
        sql.append("  v.vehicle_num AS vehicle_num, ");
        sql.append("  t.status, ");
        sql.append("  d.phone AS phone, ");
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
        sql.append("  t.truck_loading_weight, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  t.operate_type, ");
        sql.append("  ROUND( ");
        sql.append("    ( ");
        sql.append("      t.truck_loading_weight - t.take_delivery_weight ");
        sql.append("    ), ");
        sql.append("    2 ");
        sql.append("  ) AS lossWeight, ");
        sql.append("  FORMAT( ");
        sql.append("    ( ");
        sql.append("      FORMAT( ");
        sql.append("        ( ");
        sql.append("          t.truck_loading_weight - t.take_delivery_weight ");
        sql.append("        ), ");
        sql.append("        4 ");
        sql.append("      ) / t.truck_loading_weight ");
        sql.append("    ), ");
        sql.append("    4 ");
        sql.append("  ) AS lossRatio, ");
        sql.append("  t.settle_price, ");
        sql.append("  t.price, ");
        sql.append("  t.orther_flag, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.good_type, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.if_fd_judge, ");
        sql.append("  t.goods_owner_ps, ");
        sql.append("  IF( ");
        sql.append("    t.if_fd_judge = 'Y', ");
        sql.append("    '已评价', ");
        sql.append("    '未评价' ");
        sql.append("  ) AS accFlag, ");
        sql.append("  IF( ");
        sql.append("    t.orther_flag = '1', ");
        sql.append("    '已处理', ");
        sql.append("    '未处理' ");
        sql.append("  ) AS orther_flag_name, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  tm.prod_desc AS prod_desc, ");
        sql.append("  g.from_type AS from_type, ");
        sql.append("  g.ps AS ps, ");
        sql.append("  g.depend_num AS depend_num, ");
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
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  t.update_date, ");
        sql.append("  IF( ");
        sql.append("    t.settle_status = '10', ");
        sql.append("    '未计算', ");
        sql.append("    IF( ");
        sql.append("      t.settle_status = '20', ");
        sql.append("      '已计算', ");
        sql.append("      '未计算' ");
        sql.append("    ) ");
        sql.append("  ) AS settleStatusDesc, ");
        sql.append("  t.settle_status, ");
        sql.append("  t.zf_id, ");
        sql.append("  t.zf_num, ");
        sql.append("  g.prod_desc AS prod_desc, ");
        sql.append("  g.sender AS sender, ");
        sql.append("  g.js_type AS jsType, ");
        sql.append("  g.logistics_mark, ");
        sql.append("  g.asds_mark, ");
        sql.append("  IF( ");
        sql.append("    g.from_type = 'JK_U9', ");
        sql.append("    '新大宗采购',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), ");
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
        sql.append("    c.early_warning_days ");
        sql.append("  FROM ");
        sql.append("    company c ");
        sql.append("  WHERE t.publish_company_id = c.seq_id) AS early_warning_days, ");
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
        sql.append("  t.remark, ");
        sql.append("  p.status AS pay_status, ");
        sql.append("  IF( ");
        sql.append("    (p.`status` = '10'), ");
        sql.append("    '待支付', ");
        sql.append("    IF( ");
        sql.append("      (p.`status` = '20'), ");
        sql.append("      '已支付', ");
        sql.append("      IF( ");
        sql.append("        (p.`status` = '00'), ");
        sql.append("        '已撤销', ");
        sql.append("        IF( ");
        sql.append("          (p.`status` = '30'), ");
        sql.append("          '处理中', ");
        sql.append("          '待支付' ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS payStatusDesc, ");
        sql.append("  p.pay_date, ");
        sql.append("  IF( ");
        sql.append("    p.rece_bank_type = '1', ");
        sql.append("    '发单人维护账号', ");
        sql.append("    IF( ");
        sql.append("      p.rece_bank_type = '0', ");
        sql.append("      '承运人银行账号', ");
        sql.append("      '' ");
        sql.append("    ) ");
        sql.append("  ) AS receBankType, ");
        sql.append("  p.rece_bank_type, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  (SELECT ");
        sql.append("    IFNULL(l.user_type, 'GS') ");
        sql.append("  FROM ");
        sql.append("    loginverify l ");
        sql.append("  WHERE l.company_id = t.company_id ");
        sql.append("    AND l.driver_id = t.driver_id ");
        sql.append("    AND l.platform_id = t.platform_id) AS userType, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    IFNULL(t.if_tax_transport, 'N') = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(t.price_tax, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS price_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(ROUND(t.price_tax, 2) * t.weight, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(ROUND(t.price_tax, 2) * t.weight, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS amount_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    t.standard_tax, ");
        sql.append("    '' ");
        sql.append("  ) AS standard_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      t1.company_name ");
        sql.append("    FROM ");
        sql.append("      company t1 ");
        sql.append("    WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryCompanyName, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      t1.contact_mobile ");
        sql.append("    FROM ");
        sql.append("      company t1 ");
        sql.append("    WHERE t1.seq_id = t.carry_company_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryContactMobile, ");
        sql.append("  t.if_upload_receipt_flag, ");
        sql.append("  t.comfirm_pic1_local, ");
        sql.append("  IFNULL(j.dz_jk_cancel, 0) AS dz_jk_cancel, ");
        sql.append("  IFNULL( ");
        sql.append("    j.delivery_info_zdwl_source, ");
        sql.append("    '0' ");
        sql.append("  ) AS delivery_info_zdwl_source, ");
        sql.append("  IF( ");
        sql.append("    i.if_invoice = '2', ");
        sql.append("    '已开票', ");
        sql.append("    IF( ");
        sql.append("      i.if_invoice = '1', ");
        sql.append("      '开票中', ");
        sql.append("      '未开票' ");
        sql.append("    ) ");
        sql.append("  ) AS ifInvoice, ");
        sql.append("  i.invoice_no, ");
        sql.append("  t.owner_adjust_flag, ");
        sql.append("  t.owner_adjust_type, ");
        sql.append("  t.owner_adjust_amt, ");
        sql.append("  t.pound_location, ");
        sql.append("  t.pound_num, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
//        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
//        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("  IF( ");
        sql.append("    IFNULL( ");
        sql.append("      t.if_broker_people_toll_flag, ");
        sql.append("      'N' ");
        sql.append("    ) = 'N', ");
        sql.append("    '否', ");
        sql.append("    '是' ");
        sql.append("  ) AS if_broker_people_toll_flag, ");
        sql.append("  t.shipping_time, ");
        sql.append("  t.dz_status, ");
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
        sql.append("    TransportationDelivery AS t ");
        sql.append("    LEFT JOIN pay_bill p ");
        sql.append("      ON t.zf_id = p.zf_id ");
        sql.append("      AND t.platform_id = p.platform_id ");
        sql.append("  ) ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON t.driver_id = d.id ");
        sql.append("  LEFT JOIN vehicle v ");
        sql.append("    ON t.vehicle_id = v.vehicle_id ");
        sql.append("  LEFT JOIN goodsorderm g ");
        sql.append("    ON g.publish_id = t.publish_id ");
        sql.append("  LEFT JOIN TransportationM tm ");
        sql.append("    ON t.trans_id = tm.trans_id ");
        sql.append("  LEFT JOIN goodsordermjksetplat j ");
        sql.append("    ON ( ");
        sql.append("      j.tms_fd_company_id = t.publish_company_id ");
        sql.append("      AND j.tms_from_type = g.from_type ");
        sql.append("      AND j.tms_platform_id = t.platform_id ");
        sql.append("      AND j.tms_from_type IN ('JK_U8', 'JK_U9') ");
        sql.append("      AND j.ec_plat_name = g.from_plat_name ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN invoicedetail i ");
        sql.append("    ON ( ");
        sql.append("      t.delivery_id = i.delivery_id ");
        sql.append("      AND i.invoice_title_id = ? ");
        sql.append("      AND i.if_invoice > 0 ");
        sql.append("    ) ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.publish_company_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(transportBillQueryVo.getCompanyId());
        args.add(transportBillQueryVo.getPlatformId());
        args.add(transportBillQueryVo.getCompanyId());

        if("N".equals(transportBillQueryVo.getIfShowAdmin())) {
			if("TMS".equals(transportBillQueryVo.getAccountFrom())) {
				sql.append("and t.if_can_show ='Y' ");
			}
			if("DS".equals(transportBillQueryVo.getAccountFrom())) {
				sql.append("and t.if_can_show ='N' and t.fd_user_id = ?");
				args.add(transportBillQueryVo.getUserId());
			}
		}
        
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIsAutoDisplay())){
            if("N".equalsIgnoreCase(transportBillQueryVo.getIsAutoDisplay())){
                sql.append(" and g.is_auto_display = '0' ");
            } else if ("Y".equalsIgnoreCase(transportBillQueryVo.getIsAutoDisplay())) {
                sql.append(" and g.is_auto_display = '1' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getDeliveryId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayPublishId())){
            sql.append(" and t.publish_id like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getPayPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getAccessFlag())){
            if ("N".equalsIgnoreCase(transportBillQueryVo.getAccessFlag())) {
                sql.append(" and (t.if_fd_judge is null or t.if_fd_judge='N') ");
            } else if ("Y".equalsIgnoreCase(transportBillQueryVo.getAccessFlag())) {
                sql.append(" and t.if_fd_judge='Y' ");
            }
            sql.append(" and (t.status='00' || t.status='90') ");
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDependNum())){
            sql.append(" and t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(transportBillQueryVo.getDependNum().trim());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getSettleflag())){
            if("10".equalsIgnoreCase(transportBillQueryVo.getSettleflag())){
                sql.append(" and t.settle_amount = 0 ");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getSettleflag())) {
                sql.append(" and t.settle_amount > 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPayType())){
            if("10".equalsIgnoreCase(transportBillQueryVo.getPayType())){
                sql.append(" and (t.settle_status = '10' or t.settle_status is null) ");
            } else if ("20".equalsIgnoreCase(transportBillQueryVo.getPayType())) {
                sql.append(" and t.settle_status = '20' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDriverName())){
            sql.append(" and (select t1.`name` from Driver t1 where t1.id = t.driver_id) like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getDriverName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getVehicleNum())){
            sql.append(" and v.vehicle_num like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getVehicleNum());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPs())){
            sql.append(" and (select t1.ps from goodsorderm t1 where t.publish_id = t1.publish_id) like CONCAT('%',?,'%') ");
            args.add(transportBillQueryVo.getPs());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getTransId())){
            sql.append(" and t.trans_id = ? ");
            args.add(transportBillQueryVo.getTransId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCompanyName())){
            sql.append(" and (select company_name from Company a where a.platform_id = t.platform_id and a.seq_id = t.company_id) like concat('%', ? ,'%') ");
            args.add(transportBillQueryVo.getCompanyName());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getInvoiceNo())){
            sql.append(" and i.invoice_no like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getInvoiceNo());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfInvoice())){
            sql.append(" and ifnull(i.if_invoice,0) = ? ");
            args.add(transportBillQueryVo.getIfInvoice());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPublishId())){
            sql.append(" and t.publish_id = ? ");
            args.add(transportBillQueryVo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getPinDan())){
            if (transportBillQueryVo.getPinDan()) {
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else{
                sql.append(" and exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is null) ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfPaid())){
            sql.append(" and ifnull(p.status,'10') = ? ");
            args.add(transportBillQueryVo.getIfPaid());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getCarriCompany())){
            sql.append(" and t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(transportBillQueryVo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEarlyWarning())){
            if (transportBillQueryVo.getEarlyWarning()) {
                sql.append(" and t.create_date <=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }else{
                sql.append(" and t.create_date >=DATE_SUB(now(),INTERVAL (select c.early_warning_days FROM company c where t.publish_company_id=c.seq_id) day) AND t.status>00 AND t.status<90 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartCreateDate())){
            sql.append(" and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndCreateDate())){
            sql.append(" and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndCreateDate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartFinishTime())){
            sql.append(" and t.finish_time >= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getStartFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndFinishTime())){
            sql.append(" and t.finish_time <= DATE_FORMAT(?,'%Y-%m-%d %H:%i:%S') ");
            args.add(transportBillQueryVo.getEndFinishTime());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getGetOrderPlate())){
            sql.append(" and t.get_order_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStartPlate())){
            sql.append(" and t.start_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getEndPlate())){
            sql.append(" and t.end_plate like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getEndPlate());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getStatus())){
            sql.append(" and t.status = ? ");
            args.add(transportBillQueryVo.getStatus());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFromType())){
            sql.append(" and exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
            args.add(transportBillQueryVo.getFromType());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDeFlag())){
            if("0".equalsIgnoreCase(transportBillQueryVo.getDeFlag())){
                sql.append(" and (t.orther_flag = ? or t.orther_flag IS NULL)");
                args.add(transportBillQueryVo.getDeFlag());
            }else if("1".equalsIgnoreCase(transportBillQueryVo.getDeFlag())){
                sql.append(" and t.orther_flag = ?");
                args.add(transportBillQueryVo.getDeFlag());
            }

        }

        //是否飞单
        if (!ObjectUtils.isEmpty(transportBillQueryVo.getFeidan())) {
            if (transportBillQueryVo.getFeidan()) {
                sql.append(" and t.if_feidan = 'Y' ");
            } else {
                sql.append(" and t.if_feidan = 'N' ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfBrokerPeopleTollFlag())){
            sql.append(" and ifnull(t.if_broker_people_toll_flag, 'N') = ? ");
            args.add(transportBillQueryVo.getIfBrokerPeopleTollFlag());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getSender())){
            sql.append(" and (select g.sender from goodsorderm g where t.publish_id = g.publish_id) like CONCAT ('%', ?, '%') ");
            args.add(transportBillQueryVo.getSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getProdDesc())){
            sql.append(" and (select t1.prod_desc from TransportationM t1 where t1.trans_id = t.trans_id) like CONCAT('%', ?, '%') ");
            args.add(transportBillQueryVo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getDsIfSettle())){
            sql.append(" and g.ds_if_settle = ? ");
            args.add(transportBillQueryVo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfTaxTransport())){
            sql.append(" and t.if_tax_transport = ? ");
            args.add(transportBillQueryVo.getIfTaxTransport());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfSaveImage())){
            if ("1".equalsIgnoreCase(transportBillQueryVo.getIfSaveImage())) {
                sql.append(" and t.comfirm_pic1_local != '' ");
            } else if ("0".equalsIgnoreCase(transportBillQueryVo.getIfSaveImage())) {
                sql.append(" and IFNULL(t.comfirm_pic1_local,0) = 0 ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getWtBillSender())){
            sql.append(" and t.bill_sender like concat('%', ?, '%') ");
            args.add(transportBillQueryVo.getWtBillSender());
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveZcWeight())){
            if (transportBillQueryVo.getIfHaveZcWeight()) {
                sql.append(" and t.truck_loading_weight is not null ");
            }else{
                sql.append(" and t.truck_loading_weight is null ");
            }
        }

        if (!ObjectUtils.isEmpty(transportBillQueryVo.getIfHaveShWeight())){
            if (transportBillQueryVo.getIfHaveShWeight()) {
                sql.append(" and t.take_delivery_weight is not null ");
            }else{
                sql.append(" and t.take_delivery_weight is null ");
            }
        }

        //货主
        if (!StringUtils.isEmpty(transportBillQueryVo.getGoodOwner())) {
            sql.append(" and vatm.vat_company_name like ?");
            args.add("%" + transportBillQueryVo.getGoodOwner() + "%");
        }
        
        if (!StringUtils.isEmpty(transportBillQueryVo.getSignStatus())) {
            sql.append(" and t.sign_status = ?");
            args.add(transportBillQueryVo.getSignStatus() );
        }

        sql.append("  order by t.CREATE_DATE desc limit 0, 30000 ");

        return readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
    }

    @Override
    public TransportationDeliveryVo lookContracts(TransportBillQueryVo transportBillQueryVo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  t.delivery_id, ");
        sql.append("  c.company_name, ");
        sql.append("  c.contact_name, ");
        sql.append("  c.contact_mobile, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  d.`name`, ");
        sql.append("  d.phone, ");
        sql.append("  d.id_num, ");
        sql.append("  v2.vehicle_num, ");
        sql.append("  v2.vehicle_type, ");
        sql.append("  g.good_type, ");
        sql.append("  g.good_type_desc, ");
        sql.append("  t.take_delivery_weight, ");
        sql.append("  t.bill_taker, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    t.delivery_time, ");
        sql.append("    '%Y-%m-%d %H:%i' ");
        sql.append("  ) AS take_delivery_date, ");
        sql.append("  DATE_FORMAT(t.finish_time, '%Y-%m-%d %H:%i') AS finish_date, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.receiver, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.price, ");
        sql.append("  t.truck_loading_weight, ");
        sql.append("  ROUND( ");
        sql.append("    IFNULL(t.price, 0) * IFNULL(t.take_delivery_weight, 0), ");
        sql.append("    2 ");
        sql.append("  ) AS amountP, ");
        sql.append("  DATE_FORMAT(t.create_date, '%Y/%m/%d %H:%i') AS create_date_str, ");
        sql.append("  DATE_FORMAT(t.create_date, '%Y/%m/%d') AS create_date1_str, ");
        sql.append("  DATE_FORMAT( ");
        sql.append("    DATE_ADD(t.create_date, INTERVAL 1 YEAR), ");
        sql.append("    '%Y/%m/%d' ");
        sql.append("  ) AS end_date_str, ");
        sql.append("  pc.pay_amount, ");
        sql.append("  pc.pay_amount_act, ");
        sql.append("  pc.rece_bank_owner, ");
        sql.append("  pc.rece_bank_name, ");
        sql.append("  pc.rece_bank_num, ");
        sql.append("  IFNULL(t.good_price, g.good_price) AS good_price, ");
        sql.append("  IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("  IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("  IFNULL(t.loss_weight, g.loss_weight) AS loss_weight ");
        sql.append("FROM ");
        sql.append("  transportationdelivery t ");
        sql.append("  JOIN vatflowmaster v ");
        sql.append("    ON ( ");
        sql.append("      t.publish_company_id = v.vat_company_id ");
        sql.append("      AND t.vat_flow_master_id = v.vat_flow_master_id ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN vatflowdetail v1 ");
        sql.append("    ON ( ");
        sql.append("      t.vat_flow_master_id = v1.vat_flow_master_id ");
        sql.append("      AND v1.vat_carry_id = ? ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN vehicle v2 ");
        sql.append("    ON (v2.vehicle_id = t.vehicle_id) ");
        sql.append("  LEFT JOIN driver d ");
        sql.append("    ON (d.id = t.driver_id) ");
        sql.append("  LEFT JOIN company c ");
        sql.append("    ON (c.seq_id = v1.vat_carry_id) ");
        sql.append("  LEFT JOIN goodsorderm g ");
        sql.append("    ON (g.publish_id = t.publish_id) ");
        sql.append("  LEFT JOIN pay_bill p ");
        sql.append("    ON ( ");
        sql.append("      t.zf_id = p.zf_id ");
        sql.append("      AND t.zf_num = p.zf_num ");
        sql.append("    ) ");
        sql.append("  LEFT JOIN pay_bill_child pc ");
        sql.append("    ON ( ");
        sql.append("      t.zf_id = pc.zf_id ");
        sql.append("      AND t.zf_num = p.zf_num ");
        sql.append("      AND pc.pay_from_type = '2' ");
        sql.append("    ) ");
        sql.append("WHERE t.if_tax_transport = 'Y' ");
        sql.append("  AND t.platform_id = ? ");
        sql.append("  AND t.delivery_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(transportBillQueryVo.getCompanyId());
        args.add(transportBillQueryVo.getPlatformId());
        args.add(transportBillQueryVo.getDeliveryId());

        List<TransportationDeliveryVo> list = readPageQuery.list(sql.toString(), args, TransportationDeliveryVo.class);
        if(list != null){
            return list.get(0);
        }
        return null;
    }

    /**
     * 查看运费
     */
	@Override
	public List<CheckFreightVo> checkFreight(Long deliveryId) {
		List<Object> args = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  p.delivery_id, ");
        sql.append("  p.pay_amount, ");
        sql.append("  p.dump_truck_charge, ");
        sql.append("  p.transportation_amount, ");
        sql.append("  p.deduct_amount, ");
        sql.append("  p.settle_weight, ");
        sql.append("  p.price, ");
        sql.append("  p.good_price, ");
        sql.append("  p.loss_type, ");
        sql.append("  p.loss_ratio, ");
        sql.append("  p.loss_weight, ");
        sql.append("  p.loss_tons, ");
        sql.append("  pc.rece_bank_owner AS receCompanyName, ");
        sql.append("  pc.rece_bank_num AS receBankNum, ");
        sql.append("  pc.rece_bank_name AS receBankName, ");
        sql.append("  pc.pay_amount_act AS payAmountAct, ");
        sql.append("  pc2.oil_amount AS oilAmount,");
        sql.append("  pc2.rece_bank_owner AS receCompanyName2, ");
        sql.append("  pc2.rece_bank_num AS receBankNum2, ");
        sql.append("  pc2.rece_bank_name AS receBankName2, ");
        sql.append("  pc2.pay_amount_act AS payAmountAct2 ");
        sql.append("  FROM ");
        sql.append("  pay_bill p LEFT JOIN ");
        sql.append("  pay_bill_child pc on (p.zf_id = pc.zf_id and pc.pay_from_type = '1') ");
        sql.append("  LEFT JOIN ");
        sql.append("  pay_bill_child pc2 on (p.zf_id = pc2.zf_id and pc2.pay_from_type = '2') ");
        sql.append("  WHERE ");
        sql.append("   p.status != '00' ");
        sql.append("  AND p.delivery_id = ? ");
        args.add(deliveryId);

        List<CheckFreightVo> list = readPageQuery.list(sql.toString(), args, CheckFreightVo.class);
        return list;
	}

    @Override
    public Page<TransportationComfirmPicVo> comfirmPicData(TransportationComfirmPicQueryVo queryVo) {
        List<Object> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("	t.publish_id, ");
        sql.append("	t.delivery_id, ");
        sql.append("	v.vehicle_num, ");
        sql.append("	c.company_name AS publisher, ");
        sql.append("	t.start_plate, ");
        sql.append("	t.end_plate, ");
        sql.append("	t.truck_loading_weight, ");
        sql.append("	t.take_delivery_weight, ");
        sql.append("	t.create_date, ");
        sql.append("	t.comfirm_pic1_local, ");
        sql.append("	t.finish_time, ");
        sql.append("	t.risk_audit_type, ");
        sql.append("	t.risk_audit_status, ");
        sql.append("	p.pay_finish_date AS payDate ");
        sql.append("FROM ");
        sql.append("	( ");
        sql.append("		transportationdelivery t, ");
        sql.append("		pay_bill p ");
        sql.append("	) ");
        sql.append("LEFT JOIN vehicle v ON v.vehicle_id = t.vehicle_id ");
        sql.append("LEFT JOIN company c ON t.publish_company_id = c.seq_id ");
        sql.append("WHERE ");
        sql.append("	1 = 1 ");
        sql.append("AND p.`status` = '20' ");
        sql.append("AND t.delivery_id = p.delivery_id ");
        // 支付日期（开始）
        if (!ObjectUtils.isEmpty(queryVo.getStartPayDate())){
            sql.append(" AND p.pay_finish_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(queryVo.getStartPayDate());
        }
        // 支付日期（结束）
        if (!ObjectUtils.isEmpty(queryVo.getEndPayDate())){
            sql.append(" AND p.pay_finish_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(queryVo.getEndPayDate());
        }
        sql.append("AND EXISTS ( ");
        sql.append("	SELECT ");
        sql.append("		1 ");
        sql.append("	FROM ");
        sql.append("		goodsorderm g ");
        sql.append("	WHERE 1=1 ");
        // 单据来源
        if(!StringUtils.isEmpty(queryVo.getFromType())){
            // 电商销售
            if("DS".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type = ? ");
                args.add(queryVo.getFromType());
            }
            // 大宗采购
            if("CG".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type in ('JK_U8','JK_U9','JK_U10') ");
                sql.append(" AND g.logistics_mark = 'C' ");
            }
            // 大宗销售
            if("XS".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type in ('JK_U8','JK_U9','JK_U10') ");
                sql.append(" AND g.logistics_mark = 'X' ");
            }
            // 平台
            if("PT".equals(queryVo.getFromType())) {
                sql.append(" AND g.from_type = ? ");
                args.add(queryVo.getFromType());
            }
        }

        sql.append("	AND g.platform_id = 'SX*HSY*0001' ");
        sql.append("	AND g.publish_id = t.publish_id ");
        sql.append(") ");

        // 货主姓名
        if(!StringUtils.isEmpty(queryVo.getBillSender())){
            sql.append(" AND c.company_name like ? ");
            args.add("%" + queryVo.getBillSender() + "%");
        }
        // 审核日期（开始）
        if (!ObjectUtils.isEmpty(queryVo.getStartAuditDate())){
            sql.append(" AND t.risk_audit_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(queryVo.getStartAuditDate());
        }
        // 审核日期（结束）
        if (!ObjectUtils.isEmpty(queryVo.getEndAuditDate())){
            sql.append(" AND t.risk_audit_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(queryVo.getEndAuditDate());
        }
        // 审核状态
        if(!StringUtils.isEmpty(queryVo.getAuditStatus())){
            sql.append(" AND t.risk_audit_status = ? ");
            args.add(queryVo.getAuditStatus());
        }
        // 审核异常原因
        if(!StringUtils.isEmpty(queryVo.getAuditType())){
            sql.append(" AND t.risk_audit_type = ? ");
            args.add(queryVo.getAuditType());
        }

        // 货源单号
        if (!ObjectUtils.isEmpty(queryVo.getPublishId())){
            sql.append(" AND t.publish_id like ? ");
            args.add("%" + queryVo.getPublishId() + "%");
        }
        // 调度单号
        if (!ObjectUtils.isEmpty(queryVo.getDeliveryId())){
            sql.append(" AND t.delivery_id like ? ");
            args.add("%" + queryVo.getDeliveryId() + "%");
        }
        return readPageQuery.query(sql.toString(), args, queryVo, TransportationComfirmPicVo.class);
    }

    @Override
    public List<TransportationComfirmPicVo> excelDeliveryComfirmPicList(TransportationComfirmPicQueryVo queryVo) {
        List<Object> args = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("	t.publish_id, ");
        sql.append("	t.delivery_id, ");
        sql.append("	c.company_name AS publisher, ");
        sql.append("	t.create_date, ");
        sql.append("	t.finish_time, ");
        sql.append("	(SELECT g1.create_date from goodsorderm g1 where g1.publish_id = t.publish_id) as publishDate , ");
        sql.append("	t.risk_audit_type ");
        sql.append("FROM ");
        sql.append("	( ");
        sql.append("		transportationdelivery t, ");
        sql.append("		pay_bill p ");
        sql.append("	) ");
        sql.append("LEFT JOIN vehicle v ON v.vehicle_id = t.vehicle_id ");
        sql.append("LEFT JOIN company c ON t.publish_company_id = c.seq_id ");
        sql.append("WHERE ");
        sql.append("	1 = 1 ");
        sql.append("AND p.`status` = '20' ");
        sql.append("AND t.delivery_id = p.delivery_id ");
        // 支付日期（开始）
        if (!ObjectUtils.isEmpty(queryVo.getStartPayDate())){
            sql.append(" AND p.pay_finish_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(queryVo.getStartPayDate());
        }
        // 支付日期（结束）
        if (!ObjectUtils.isEmpty(queryVo.getEndPayDate())){
            sql.append(" AND p.pay_finish_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(queryVo.getEndPayDate());
        }
        sql.append("AND EXISTS ( ");
        sql.append("	SELECT ");
        sql.append("		1 ");
        sql.append("	FROM ");
        sql.append("		goodsorderm g ");
        sql.append("	WHERE 1=1 ");
        // 单据来源
        if(!StringUtils.isEmpty(queryVo.getFromType())){
            // 电商销售
            if("DS".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type = ? ");
                args.add(queryVo.getFromType());
            }
            // 大宗采购
            if("CG".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type in ('JK_U8','JK_U9','JK_U10') ");
                sql.append(" AND g.logistics_mark = 'C' ");
            }
            // 大宗销售
            if("XS".equals(queryVo.getFromType())){
                sql.append(" AND g.from_type in ('JK_U8','JK_U9','JK_U10') ");
                sql.append(" AND g.logistics_mark = 'X' ");
            }
            // 平台
            if("PT".equals(queryVo.getFromType())) {
                sql.append(" AND g.from_type = ? ");
                args.add(queryVo.getFromType());
            }
        }
        sql.append("	AND g.platform_id = 'SX*HSY*0001' ");
        sql.append("	AND g.publish_id = t.publish_id ");
        sql.append(") ");

        // 货主姓名
        if(!StringUtils.isEmpty(queryVo.getBillSender())){
            sql.append(" AND c.company_name like ? ");
            args.add("%" + queryVo.getBillSender() + "%");
        }

        // 审核日期（开始）
        if (!ObjectUtils.isEmpty(queryVo.getStartAuditDate())){
            sql.append(" AND t.risk_audit_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(queryVo.getStartAuditDate());
        }
        // 审核日期（结束）
        if (!ObjectUtils.isEmpty(queryVo.getEndAuditDate())){
            sql.append(" AND t.risk_audit_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(queryVo.getEndAuditDate());
        }

        // 审核状态
        if(!StringUtils.isEmpty(queryVo.getAuditStatus())){
            sql.append(" AND t.risk_audit_status = ? ");
            args.add(queryVo.getAuditStatus());
        }
        // 审核异常原因
        if(!StringUtils.isEmpty(queryVo.getAuditType())){
            sql.append(" AND t.risk_audit_type = ? ");
            args.add(queryVo.getAuditType());
        }

        // 货源单号
        if (!ObjectUtils.isEmpty(queryVo.getPublishId())){
            sql.append(" AND t.publish_id like ? ");
            args.add("%" + queryVo.getPublishId() + "%");
        }
        // 调度单号
        if (!ObjectUtils.isEmpty(queryVo.getDeliveryId())){
            sql.append(" AND t.delivery_id like ? ");
            args.add("%" + queryVo.getDeliveryId() + "%");
        }
        sql.append(" LIMIT 30000 ");
        return readPageQuery.list(sql.toString(), args, TransportationComfirmPicVo.class);
    }
}
