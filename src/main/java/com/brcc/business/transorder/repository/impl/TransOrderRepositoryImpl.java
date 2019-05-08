package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.repository.ITransOrderRepository;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.TransOrderVo;
import com.esteel.common.dao.PageQuery;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单数据接口实现类
 *
 * @author yushaohua
 * @create 2018-10-31 17:05
 */
public class TransOrderRepositoryImpl implements ITransOrderRepository {

    @Autowired
    PageQuery pageQuery;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Page<TransOrderVo> findAllPage(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer(" SELECT ");
        sql.append("   t.trans_id, ");
        sql.append("   t.good_type_desc, ");
        sql.append("   g.prod_desc AS prod_desc, ");
        sql.append("   '' AS publish_num, ");
        sql.append("   t.publish_id, ");
        sql.append("   g.depend_num AS depend_num, ");
        sql.append("   g.floor_price AS floor_price, ");
        sql.append("   g.ps AS remark, ");
        sql.append("   (SELECT ");
        sql.append("     t2.company_name ");
        sql.append("   FROM ");
        sql.append("     company t2 ");
        sql.append("   WHERE g.company_id = t2.seq_id) AS consignor, ");
        sql.append("   t.weight, ");
        sql.append("   t.qty, ");
        sql.append("   t.price, ");
        sql.append("   (SELECT ");
        sql.append("     SUM(b.weight) ");
        sql.append("   FROM ");
        sql.append("     transportationdelivery b ");
        sql.append("   WHERE t.trans_id = b.trans_id ");
        sql.append("     AND t.status != '00' ");
        sql.append("     AND b.status != '00') 'dispatchWeight', ");
        sql.append("   (SELECT ");
        sql.append("     SUM(b.amount) ");
        sql.append("   FROM ");
        sql.append("     transportationdelivery b ");
        sql.append("   WHERE t.trans_id = b.trans_id ");
        sql.append("     AND b.status != '00') 'dispatchAmount', ");
        sql.append("   t.amount, ");
        sql.append("   t.create_date, ");
        sql.append("   t.update_date, ");
        sql.append("   (SELECT ");
        sql.append("     t1.user_name ");
        sql.append("   FROM ");
        sql.append("     loginverify t1 ");
        sql.append("   WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("   t.company_id, ");
        sql.append("   (SELECT ");
        sql.append("     t1.company_name ");
        sql.append("   FROM ");
        sql.append("     company t1 ");
        sql.append("   WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("   (SELECT ");
        sql.append("     t1.contact_mobile ");
        sql.append("   FROM ");
        sql.append("     company t1 ");
        sql.append("   WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("   t.start_plate, ");
        sql.append("   t.end_plate, ");
        sql.append("   t.init_weight, ");
        sql.append("   t.init_amount, ");
        sql.append("   t.status, ");
        sql.append("   t.good_type_desc, ");
        sql.append("   IF( ");
        sql.append("     t.status = '00', ");
        sql.append("     '无效', ");
        sql.append("     IF( ");
        sql.append("       t.status = '10', ");
        sql.append("       '新增', ");
        sql.append("       IF( ");
        sql.append("         t.status = '20', ");
        sql.append("         '生效', ");
        sql.append("         IF( ");
        sql.append("           t.status = '30', ");
        sql.append("           '完成', ");
        sql.append("           IF(t.status = '60', '终止', '未知') ");
        sql.append("         ) ");
        sql.append("       ) ");
        sql.append("     ) ");
        sql.append("   ) AS status_desc, ");
        sql.append("   t.receiver, ");
        sql.append("   t.receiver_mobile, ");
        sql.append("   t.bill_sender_mobile, ");
        sql.append("   t.bill_sender, ");
        sql.append("   t.prod_desc, ");
        sql.append("   g.pin_dan_num AS pinDanNum, ");
        sql.append("   IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("   g.docu_type AS docu_type, ");
        sql.append("   g.docu_pri_sec AS docu_pri_sec, ");
        sql.append("   g.ds_if_settle AS dsIfSettle, ");
        sql.append("   IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("   if(g.from_type = 'JK_U9', '新大宗采购',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), if(g.from_type = 'DS', '销售电商', if(g.from_type = 'PT', '平台货源',if(g.from_type = 'JK_U8' or g.from_type = 'JK_U10', if(g.logistics_mark='X', '大宗销售', '大宗采购'), '平台货源'))))) as docOrigin, ");
        sql.append("   t.standard_tax AS standard_tax, ");
        sql.append("   t.if_tax_transport, ");
        sql.append("   IFNULL(t.good_price, IFNULL(g.good_price, 0)) AS good_price, ");
        sql.append("   IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("   IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("   IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("   IF( ");
        sql.append("     t.`loss_type` = '1', ");
        sql.append("     '定额', ");
        sql.append("     '定率' ");
        sql.append("   ) AS loss_type_desc, ");
        sql.append("   IF( ");
        sql.append("     t.`loss_type` = '1', ");
        sql.append("     CONCAT( ");
        sql.append("       IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("       '（kg/车）' ");
        sql.append("     ), ");
        sql.append("     CONCAT( ");
        sql.append("       IFNULL(t.loss_ratio, g.loss_ratio) * 1000, ");
        sql.append("       '（‰/车）' ");
        sql.append("     ) ");
        sql.append("   ) AS loss_weight_desc,");
        sql.append("    g.contract_type,");
        sql.append("    t.rob_delivery_type, ");
        sql.append("    t.business_mode, ");
        sql.append("    g.company_id as fdCompanyId ");
        sql.append(" FROM ");
        sql.append("   transportationm AS t ");
        sql.append("   JOIN goodsorderm g ");
        sql.append("     ON g.publish_id = t.publish_id ");
        sql.append(" WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        // 公司ID
        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '30')) ");
            args.add(vo.getCompanyId());
        }

        // 货源单
        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
            args.add(vo.getPublishId());
        }

        // 单据号
        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num like CONCAT('%',?,'%')) ");
            args.add(vo.getDependNum());
        }

        // 承运单位
        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%', ?, '%')) ");
            args.add(vo.getCarriCompany());
        }

        // 运输订单
        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
            args.add(vo.getTransId());
        }

        // 取单地
        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getGetOrderPlate());
        }

        // 装货地
        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getStartPlate());
        }

        // 目的地
        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getEndPlate());
        }

        // 创建日期（开始）
        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        // 创建日期（结束）
        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        // 订单状态
        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        // 拼单单据筛选
        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null) ");
            }
        }

        // 是否为飞单
        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        // 调度状态
        if (!ObjectUtils.isEmpty(vo.getTranStatue())){
            if("30".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND (t.status ='30' or t.weight = 0) ");
            }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND t.weight > 0  and  (t.status = '20' or t.status = '10') ");
            }
        }

        // 委托人
        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%', ?, '%') ");
            args.add(vo.getBillSender());
        }

        // 品种描述
        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND t.prod_desc like CONCAT('%', ?,'%') ");
            args.add(vo.getProdDesc());
        }

        // 电商配送
        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        // 是否委托承运
        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        //合同编号
        if (!StringUtils.isEmpty(vo.getContractNumber())){
            sql.append("    and g.contract_number like ?");
            args.add("%"+vo.getContractNumber()+"%");
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, TransOrderVo.class);
    }

    @Override
    public List<TransOrderVo> findAll(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer(" SELECT ");
        sql.append("   t.trans_id, ");
        sql.append("   t.good_type_desc, ");
        sql.append("   g.prod_desc AS prod_desc, ");
        sql.append("   '' AS publish_num, ");
        sql.append("   t.publish_id, ");
        sql.append("   g.depend_num AS depend_num, ");
        sql.append("   g.floor_price AS floor_price, ");
        sql.append("   g.ps AS remark, ");
        sql.append("   (SELECT ");
        sql.append("     t2.company_name ");
        sql.append("   FROM ");
        sql.append("     company t2 ");
        sql.append("   WHERE g.company_id = t2.seq_id) AS consignor, ");
        sql.append("   t.weight, ");
        sql.append("   t.qty, ");
        sql.append("   t.price, ");
        sql.append("   (SELECT ");
        sql.append("     SUM(b.weight) ");
        sql.append("   FROM ");
        sql.append("     transportationdelivery b ");
        sql.append("   WHERE t.trans_id = b.trans_id ");
        sql.append("     AND t.status != '00' ");
        sql.append("     AND b.status != '00') 'dispatchWeight', ");
        sql.append("   (SELECT ");
        sql.append("     SUM(b.amount) ");
        sql.append("   FROM ");
        sql.append("     transportationdelivery b ");
        sql.append("   WHERE t.trans_id = b.trans_id ");
        sql.append("     AND b.status != '00') 'dispatchAmount', ");
        sql.append("   t.amount, ");
        sql.append("   t.create_date, ");
        sql.append("   t.update_date, ");
        sql.append("   (SELECT ");
        sql.append("     t1.user_name ");
        sql.append("   FROM ");
        sql.append("     loginverify t1 ");
        sql.append("   WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("   t.company_id, ");
        sql.append("   (SELECT ");
        sql.append("     t1.company_name ");
        sql.append("   FROM ");
        sql.append("     company t1 ");
        sql.append("   WHERE t1.seq_id = t.company_id) AS company_name, ");
        sql.append("   (SELECT ");
        sql.append("     t1.contact_mobile ");
        sql.append("   FROM ");
        sql.append("     company t1 ");
        sql.append("   WHERE t1.seq_id = t.company_id) AS contact_mobile, ");
        sql.append("   t.start_plate, ");
        sql.append("   t.end_plate, ");
        sql.append("   t.init_weight, ");
        sql.append("   t.init_amount, ");
        sql.append("   t.status, ");
        sql.append("   t.good_type_desc, ");
        sql.append("   IF( ");
        sql.append("     t.status = '00', ");
        sql.append("     '无效', ");
        sql.append("     IF( ");
        sql.append("       t.status = '10', ");
        sql.append("       '新增', ");
        sql.append("       IF( ");
        sql.append("         t.status = '20', ");
        sql.append("         '生效', ");
        sql.append("         IF( ");
        sql.append("           t.status = '30', ");
        sql.append("           '完成', ");
        sql.append("           IF(t.status = '60', '终止', '未知') ");
        sql.append("         ) ");
        sql.append("       ) ");
        sql.append("     ) ");
        sql.append("   ) AS status_desc, ");
        sql.append("   t.receiver, ");
        sql.append("   t.receiver_mobile, ");
        sql.append("   t.bill_sender_mobile, ");
        sql.append("   t.bill_sender, ");
        sql.append("   t.prod_desc, ");
        sql.append("   g.pin_dan_num AS pinDanNum, ");
        sql.append("   IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("   g.docu_type AS docu_type, ");
        sql.append("   g.docu_pri_sec AS docu_pri_sec, ");
        sql.append("   g.ds_if_settle AS dsIfSettle, ");
        sql.append("   IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("   if(g.from_type = 'JK_U9', '新大宗采购',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), if(g.from_type = 'DS', '销售电商', if(g.from_type = 'PT', '平台货源',if(g.from_type = 'JK_U8' or g.from_type = 'JK_U10', if(g.logistics_mark='X', '大宗销售', '大宗采购'), '平台货源'))))) as docOrigin, ");
        sql.append("   t.standard_tax AS standard_tax, ");
        sql.append("   t.if_tax_transport, ");
        sql.append("   IFNULL(t.good_price, IFNULL(g.good_price, 0)) AS good_price, ");
        sql.append("   IFNULL(t.loss_type, g.loss_type) AS loss_type, ");
        sql.append("   IFNULL(t.loss_ratio, g.loss_ratio) AS loss_ratio, ");
        sql.append("   IFNULL(t.loss_weight, g.loss_weight) AS loss_weight, ");
        sql.append("   IF( ");
        sql.append("     t.`loss_type` = '1', ");
        sql.append("     '定额', ");
        sql.append("     '定率' ");
        sql.append("   ) AS loss_type_desc, ");
        sql.append("   IF( ");
        sql.append("     t.`loss_type` = '1', ");
        sql.append("     CONCAT( ");
        sql.append("       IFNULL(t.loss_weight, g.loss_weight) * 1000, ");
        sql.append("       '（kg/车）' ");
        sql.append("     ), ");
        sql.append("     CONCAT( ");
        sql.append("       IFNULL(t.loss_ratio, g.loss_ratio) * 1000, ");
        sql.append("       '（‰/车）' ");
        sql.append("     ) ");
        sql.append("   ) AS loss_weight_desc ");
        sql.append(" FROM ");
        sql.append("   transportationm AS t ");
        sql.append("   JOIN goodsorderm g ");
        sql.append("     ON g.publish_id = t.publish_id ");
        sql.append(" WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        // 公司ID
        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.company_id = ? and (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '30')) ");
            args.add(vo.getCompanyId());
        }

        // 货源单
        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
            args.add(vo.getPublishId());
        }

        // 单据号
        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num like CONCAT('%',?,'%')) ");
            args.add(vo.getDependNum());
        }

        // 承运单位
        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%', ?, '%')) ");
            args.add(vo.getCarriCompany());
        }

        // 运输订单
        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
            args.add(vo.getTransId());
        }

        // 取单地
        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getGetOrderPlate());
        }

        // 装货地
        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getStartPlate());
        }

        // 目的地
        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%', ?, '%') ");
            args.add(vo.getEndPlate());
        }

        // 创建日期（开始）
        if (!ObjectUtils.isEmpty(vo.getRqStart())){
            sql.append(" AND t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            args.add(vo.getRqStart());
        }

        // 创建日期（结束）
        if (!ObjectUtils.isEmpty(vo.getRqEnd())){
            sql.append(" AND t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
            args.add(vo.getRqEnd());
        }

        // 订单状态
        if (!ObjectUtils.isEmpty(vo.getStatus())){
            sql.append(" AND t.status = ? ");
            args.add(vo.getStatus());
        }

        // 拼单单据筛选
        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null) ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null) ");
            }
        }

        // 是否为飞单
        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        // 调度状态
        if (!ObjectUtils.isEmpty(vo.getTranStatue())){
            if("30".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND (t.status ='30' or t.weight = 0) ");
            }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND t.weight > 0  and  (t.status = '20' or t.status = '10') ");
            }
        }

        // 委托人
        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%', ?, '%') ");
            args.add(vo.getBillSender());
        }

        // 品种描述
        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND t.prod_desc like CONCAT('%', ?,'%') ");
            args.add(vo.getProdDesc());
        }

        // 电商配送
        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        // 是否委托承运
        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.list(sql.toString(), args, TransOrderVo.class);
    }

    @Override
    public Page<TransOrderVo> findPublisherAllPage(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.trans_id, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.publish_id, ");
        sql.append("  g.floor_price AS floor_price, ");
        sql.append("  g.ps AS remark, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  t.weight, ");
        sql.append("  t.qty, ");
        sql.append("  t.price, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(IFNULL(b.weight, 0)) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND t.status != '00' ");
        sql.append("    AND b.status != '00') dispatchWeight, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(IFNULL(b.amount, 0)) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND b.status != '00') dispatchAmount, ");
        sql.append("  t.amount, ");
        sql.append("  '10' AS deliveryStatus, ");
        sql.append("  t.create_date, ");
        sql.append("  t.update_date, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
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
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.init_weight, ");
        sql.append("  t.init_amount, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  t.prod_desc, ");
        sql.append("  t.status, ");
        sql.append("  t.bill_sender, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  if(g.from_type = 'JK_U9', '新大宗采购',IF(g.from_type = 'JK_U11', IF( g.logistics_mark = 'X', '销售物流', '采购物流' ), if(g.from_type = 'DS', '销售电商', if(g.from_type = 'PT', '平台货源',if(g.from_type = 'JK_U8' or g.from_type = 'JK_U10', if(g.logistics_mark='X', '大宗销售', '大宗采购'), '平台货源'))))) as docOrigin, ");
        sql.append("  g.from_type AS fromType, ");        
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  IF( ");
        sql.append("    t.status = '00', ");
        sql.append("    '无效', ");
        sql.append("    IF( ");
        sql.append("      t.status = '10', ");
        sql.append("      '新增', ");
        sql.append("      IF( ");
        sql.append("        t.status = '20', ");
        sql.append("        '生效', ");
        sql.append("        IF( ");
        sql.append("          t.status = '30', ");
        sql.append("          '完成', ");
        sql.append("          IF(t.status = '60', '终止', '未知') ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS status_desc, ");
        sql.append("  (SELECT ");
        sql.append("    t1.company_name ");
        sql.append("  FROM ");
        sql.append("    Company t1 ");
        sql.append("  WHERE t1.seq_id = t.publish_company_id) AS consignor, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    t.standard_tax, ");
        sql.append("    '' ");
        sql.append("  ) AS standard_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND(t.price_tax, 2), ");
        sql.append("    '' ");
        sql.append("  ) AS price_tax, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    ROUND( ");
        sql.append("      ROUND(t.price_tax, 2) * t.init_weight, ");
        sql.append("      2 ");
        sql.append("    ), ");
        sql.append("    '' ");
        sql.append("  ) AS taxAmount, ");
        sql.append("  t.if_tax_transport, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport, ");
        sql.append("  t.carry_company_id, ");
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
        sql.append("      IFNULL(t.loss_ratio, g.loss_ratio) * 1000, ");
        sql.append("      '（‰/车）' ");
        sql.append("    ) ");
        sql.append("  ) AS loss_weight_desc, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      company_name ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE c.seq_id = t.carry_company_id ");
        sql.append("      AND c.platform_id = t.platform_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryCompanyName, ");
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    (SELECT ");
        sql.append("      contact_mobile ");
        sql.append("    FROM ");
        sql.append("      company c ");
        sql.append("    WHERE c.seq_id = t.carry_company_id ");
        sql.append("      AND c.platform_id = t.platform_id), ");
        sql.append("    '' ");
        sql.append("  ) AS carryContactMobile ");
        sql.append("    ,g.contract_number ");
        sql.append("FROM ");
        sql.append("  TransportationM AS t ");
        sql.append("  JOIN goodsorderm g ");
        sql.append("    ON g.publish_id = t.publish_id ");
        sql.append("WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getIfShowAdmin())){
            if("N".equalsIgnoreCase(vo.getIfShowAdmin())){
                if (!ObjectUtils.isEmpty(vo.getIfShowAdmin())){
                    if("TMS".equalsIgnoreCase(vo.getAccountFrom())){
                        sql.append(" AND t.if_can_show ='Y' ");
                    }else if("DS".equalsIgnoreCase(vo.getAccountFrom())){
                        sql.append(" AND t.if_can_show ='N' and t.fd_user_id = ? ");
                        args.add(vo.getUserId());
                    }
                }
            }
        }

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND t.publish_company_id = ? ");
            args.add(vo.getCompanyId());
        }

        if (!ObjectUtils.isEmpty(vo.getIsAutoDisplay())){
            if("0".equalsIgnoreCase(vo.getIsAutoDisplay())){
                sql.append(" AND g.is_auto_display = '0' ");
            }else if("1".equalsIgnoreCase(vo.getIsAutoDisplay())){
                sql.append(" AND g.is_auto_display = '1' ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(vo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num like CONCAT('%',?,'%')) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
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

        if (!ObjectUtils.isEmpty(vo.getFromType())){
            sql.append(" AND exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
            args.add(vo.getFromType());
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)  ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null)  ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getTranStatue())){
            if("30".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND (t.status ='30' or t.weight = 0) ");
            }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND t.weight > 0  and  (t.status = '20' or t.status = '10') ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND t.prod_desc like CONCAT('%',?,'%') ");
            args.add(vo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getIfTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getIfTaxTransport());
        }

        //合同编号
        if (!StringUtils.isEmpty(vo.getContractNumber())){
            sql.append("    and g.contract_number like ?");
            args.add("%"+vo.getContractNumber()+"%");
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, TransOrderVo.class);
    }

    @Override
    public List<TransOrderVo> findPublisherListData(TransOrderSearchVo vo) {
        {
            StringBuffer sql = new StringBuffer("SELECT ");
            sql.append("  t.trans_id, ");
            sql.append("  '' AS publish_num, ");
            sql.append("  t.publish_id, ");
            sql.append("  g.floor_price AS floor_price, ");
            sql.append("  g.ps AS remark, ");
            sql.append("  g.depend_num AS depend_num, ");
            sql.append("  t.weight, ");
            sql.append("  t.qty, ");
            sql.append("  t.price, ");
            sql.append("  IFNULL((SELECT ");
            sql.append("    SUM(IFNULL(b.weight, 0)) ");
            sql.append("  FROM ");
            sql.append("    TransportationDelivery b ");
            sql.append("  WHERE t.trans_id = b.trans_id ");
            sql.append("    AND t.status != '00' ");
            sql.append("    AND b.status != '00'), 0) dispatchWeight, ");
            sql.append("  (SELECT ");
            sql.append("    SUM(IFNULL(b.amount, 0)) ");
            sql.append("  FROM ");
            sql.append("    TransportationDelivery b ");
            sql.append("  WHERE t.trans_id = b.trans_id ");
            sql.append("    AND b.status != '00') dispatchAmount, ");
            sql.append("  t.amount, ");
            sql.append("  '10' AS deliveryStatus, ");
            sql.append("  t.create_date, ");
            sql.append("  t.update_date, ");
            sql.append("  (SELECT ");
            sql.append("    t1.user_name ");
            sql.append("  FROM ");
            sql.append("    loginverify t1 ");
            sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
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
            sql.append("  t.start_plate, ");
            sql.append("  t.end_plate, ");
            sql.append("  t.init_weight, ");
            sql.append("  t.init_amount, ");
            sql.append("  t.good_type_desc, ");
            sql.append("  t.prod_desc, ");
            sql.append("  t.status, ");
            sql.append("  t.bill_sender, ");
            sql.append("  g.pin_dan_num AS pinDanNum, ");
            sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
            sql.append("  IF( ");
            sql.append("    t.status = '00', ");
            sql.append("    '无效', ");
            sql.append("    IF( ");
            sql.append("      t.status = '10', ");
            sql.append("      '新增', ");
            sql.append("      IF( ");
            sql.append("        t.status = '20', ");
            sql.append("        '生效', ");
            sql.append("        IF( ");
            sql.append("          t.status = '30', ");
            sql.append("          '完成', ");
            sql.append("          IF(t.status = '60', '终止', '未知') ");
            sql.append("        ) ");
            sql.append("      ) ");
            sql.append("    ) ");
            sql.append("  ) AS status_desc, ");
            sql.append("  (SELECT ");
            sql.append("    t1.company_name ");
            sql.append("  FROM ");
            sql.append("    Company t1 ");
            sql.append("  WHERE t1.seq_id = t.publish_company_id) AS consignor, ");
            sql.append("  g.ds_if_settle AS dsIfSettle, ");
            sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    t.standard_tax, ");
            sql.append("    '' ");
            sql.append("  ) AS standard_tax, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    ROUND(t.price_tax, 2), ");
            sql.append("    '' ");
            sql.append("  ) AS price_tax, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    ROUND( ");
            sql.append("      ROUND(t.price_tax, 2) * t.init_weight, ");
            sql.append("      2 ");
            sql.append("    ), ");
            sql.append("    '' ");
            sql.append("  ) AS taxAmount, ");
            sql.append("  t.if_tax_transport, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    '是', ");
            sql.append("    '否' ");
            sql.append("  ) AS ifTaxTransport, ");
            sql.append("  t.carry_company_id, ");
            sql.append("  IFNULL(IFNULL(t.good_price, g.good_price), 0) AS good_price, ");
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
            sql.append("      IFNULL(t.loss_ratio, g.loss_ratio) * 1000, ");
            sql.append("      '（‰/车）' ");
            sql.append("    ) ");
            sql.append("  ) AS loss_weight_desc, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    (SELECT ");
            sql.append("      company_name ");
            sql.append("    FROM ");
            sql.append("      company c ");
            sql.append("    WHERE c.seq_id = t.carry_company_id ");
            sql.append("      AND c.platform_id = t.platform_id), ");
            sql.append("    '' ");
            sql.append("  ) AS carryCompanyName, ");
            sql.append("  IF( ");
            sql.append("    t.if_tax_transport = 'Y', ");
            sql.append("    (SELECT ");
            sql.append("      contact_mobile ");
            sql.append("    FROM ");
            sql.append("      company c ");
            sql.append("    WHERE c.seq_id = t.carry_company_id ");
            sql.append("      AND c.platform_id = t.platform_id), ");
            sql.append("    '' ");
            sql.append("  ) AS carryContactMobile ");
            sql.append("FROM ");
            sql.append("  TransportationM AS t ");
            sql.append("  JOIN goodsorderm g ");
            sql.append("    ON g.publish_id = t.publish_id ");
            sql.append("WHERE 1 = 1 ");
            sql.append(" AND t.platform_id = ? ");

            List<Object> args = new ArrayList<>();
            args.add(vo.getPlatformId());

            if (!ObjectUtils.isEmpty(vo.getIfShowAdmin())){
                if("N".equalsIgnoreCase(vo.getIfShowAdmin())){
                    if (!ObjectUtils.isEmpty(vo.getIfShowAdmin())){
                        if("TMS".equalsIgnoreCase(vo.getAccountFrom())){
                            sql.append(" AND t.if_can_show ='Y' ");
                        }else if("DS".equalsIgnoreCase(vo.getAccountFrom())){
                            sql.append(" AND t.if_can_show ='N' and t.fd_user_id = ? ");
                            args.add(vo.getUserId());
                        }
                    }
                }
            }

            if (!ObjectUtils.isEmpty(vo.getCompanyId())){
                sql.append(" AND t.publish_company_id = ? ");
                args.add(vo.getCompanyId());
            }

            if (!ObjectUtils.isEmpty(vo.getIsAutoDisplay())){
                if("0".equalsIgnoreCase(vo.getIsAutoDisplay())){
                    sql.append(" AND g.is_auto_display = '0' ");
                }else if("1".equalsIgnoreCase(vo.getIsAutoDisplay())){
                    sql.append(" AND g.is_auto_display = '1' ");
                }
            }

            if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
                sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
                args.add(vo.getCarriCompany());
            }

            if (!ObjectUtils.isEmpty(vo.getDependNum())){
                sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
                args.add(vo.getDependNum());
            }

            if (!ObjectUtils.isEmpty(vo.getTransId())){
                sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
                args.add(vo.getTransId());
            }

            if (!ObjectUtils.isEmpty(vo.getPublishId())){
                sql.append(" AND t.publish_id like CONCAT('%',?,'%') ");
                args.add(vo.getPublishId());
            }

            if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
                sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
                args.add(vo.getGetOrderPlate());
            }

            if (!ObjectUtils.isEmpty(vo.getStartPlate())){
                sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
                args.add(vo.getStartPlate());
            }

            if (!ObjectUtils.isEmpty(vo.getEndPlate())){
                sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
                args.add(vo.getEndPlate());
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

            if (!ObjectUtils.isEmpty(vo.getFromType())){
                sql.append(" AND exists(select 1 from GoodSorderm g where g.publish_id = t.publish_id and g.from_type = ?) ");
                args.add(vo.getFromType());
            }

            if (!ObjectUtils.isEmpty(vo.getIffly())){
                sql.append(" AND t.if_feidan = ? ");
                args.add(vo.getIffly());
            }

            if (!ObjectUtils.isEmpty(vo.getPinDan())){
                if("1".equalsIgnoreCase(vo.getPinDan())){
                    sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)  ");
                }else if("2".equalsIgnoreCase(vo.getPinDan())){
                    sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null)  ");
                }
            }

            if (!ObjectUtils.isEmpty(vo.getTranStatue())){
                if("30".equalsIgnoreCase(vo.getTranStatue())){
                    sql.append(" AND (t.status ='30' or t.weight = 0) ");
                }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                    sql.append(" AND t.weight &gt; 0  and  (t.status = '20' or t.status = '10') ");
                }
            }

            if (!ObjectUtils.isEmpty(vo.getProdDesc())){
                sql.append(" AND t.prod_desc like CONCAT('%',?,'%') ");
                args.add(vo.getProdDesc());
            }

            if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
                sql.append(" AND g.ds_if_settle = ? ");
                args.add(vo.getDsIfSettle());
            }

            if (!ObjectUtils.isEmpty(vo.getIfTaxTransport())){
                sql.append(" AND t.if_tax_transport = ? ");
                args.add(vo.getIfTaxTransport());
            }

            sql.append(" order by t.CREATE_DATE desc ");

            return pageQuery.list(sql.toString(), args, TransOrderVo.class);
        }
    }

    @Override
    public Page<TransOrderVo> findTaxTransportationmPage(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.trans_id, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  g.prod_desc AS prod_desc, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.publish_id, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  g.floor_price AS floor_price, ");
        sql.append("  g.ps AS remark, ");
        sql.append("  v.vat_client_name AS consignor, ");
        sql.append("  t.weight, ");
        sql.append("  t.qty, ");
        sql.append("  t.price, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(b.weight) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND t.status != '00' ");
        sql.append("    AND b.status != '00') dispatchWeight, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(b.amount) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND b.status != '00') dispatchAmount, ");
        sql.append("  t.amount, ");
        sql.append("  t.create_date, ");
        sql.append("  t.update_date, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  t.company_id, ");
        sql.append("  c1.company_name AS company_name, ");
        sql.append("  v1.vat_carry_name AS taxCompany, ");
        sql.append("  c1.contact_mobile AS contactMobile, ");
        sql.append("  c.contact_mobile AS TaxContactMobile, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.init_weight, ");
        sql.append("  t.init_amount, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.status = '00', ");
        sql.append("    '无效', ");
        sql.append("    IF( ");
        sql.append("      t.status = '10', ");
        sql.append("      '新增', ");
        sql.append("      IF( ");
        sql.append("        t.status = '20', ");
        sql.append("        '生效', ");
        sql.append("        IF( ");
        sql.append("          t.status = '30', ");
        sql.append("          '完成', ");
        sql.append("          IF(t.status = '60', '终止', '未知') ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS status_desc, ");
        sql.append("  t.receiver, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.prod_desc, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  g.docu_type AS docu_type, ");
        sql.append("  g.docu_pri_sec AS docu_pri_sec, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
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
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport ");
        sql.append("FROM ");
        sql.append("  vatflowdetail v ");
        sql.append("  JOIN ( ");
        sql.append("      TransportationM AS t ");
        sql.append("      JOIN goodsorderm g ");
        sql.append("        ON g.publish_id = t.publish_id ");
        sql.append("        AND t.if_tax_transport = 'Y' ");
        sql.append("    ) ");
        sql.append("    ON (t.vat_flow_master_id = v.vat_flow_master_id ");
        sql.append("    AND v.vat_carry_id = ?) ");
        sql.append("     LEFT JOIN vatflowdetail v1 ");
        sql.append("      ON (t.vat_flow_master_id = v1.vat_flow_master_id ");
        sql.append("      AND v1.vat_client_id = ?) ");
        sql.append("       LEFT JOIN company c ");
        sql.append("        ON (v1.vat_carry_id = c.seq_id ");
        sql.append("        AND v1.vat_client_id = ?) ");
        sql.append("         LEFT JOIN company c1 ");
        sql.append("          ON (t.company_id = c1.seq_id) WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getCompanyId());
        args.add(vo.getCompanyId());
        args.add(vo.getCompanyId());
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '30')) ");
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(vo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
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
            sql.append(" AND t.status =  ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)  ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null)  ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getTranStatue())){
            if("30".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND (t.status ='30' or t.weight = 0) ");
            }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND t.weight > 0  and  (t.status = '20' or t.status = '10') ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
            args.add(vo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND t.prod_desc like CONCAT('%',?,'%') ");
            args.add(vo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.query(sql.toString(), args, vo, TransOrderVo.class);
    }

    @Override
    public List<TransOrderVo> findTaxTransportationmList(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.trans_id, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  g.prod_desc AS prod_desc, ");
        sql.append("  '' AS publish_num, ");
        sql.append("  t.publish_id, ");
        sql.append("  g.depend_num AS depend_num, ");
        sql.append("  g.floor_price AS floor_price, ");
        sql.append("  g.ps AS remark, ");
        sql.append("  v.vat_client_name AS consignor, ");
        sql.append("  t.weight, ");
        sql.append("  t.qty, ");
        sql.append("  t.price, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(b.weight) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND t.status != '00' ");
        sql.append("    AND b.status != '00') dispatchWeight, ");
        sql.append("  (SELECT ");
        sql.append("    SUM(b.amount) ");
        sql.append("  FROM ");
        sql.append("    TransportationDelivery b ");
        sql.append("  WHERE t.trans_id = b.trans_id ");
        sql.append("    AND b.status != '00') dispatchAmount, ");
        sql.append("  t.amount, ");
        sql.append("  t.create_date, ");
        sql.append("  t.update_date, ");
        sql.append("  (SELECT ");
        sql.append("    t1.user_name ");
        sql.append("  FROM ");
        sql.append("    loginverify t1 ");
        sql.append("  WHERE t1.user_id = t.update_person) AS update_person_name, ");
        sql.append("  t.company_id, ");
        sql.append("  c1.company_name AS company_name, ");
        sql.append("  v1.vat_carry_name AS taxCompany, ");
        sql.append("  c1.contact_mobile AS contactMobile, ");
        sql.append("  c.contact_mobile AS TaxContactMobile, ");
        sql.append("  t.start_plate, ");
        sql.append("  t.end_plate, ");
        sql.append("  t.init_weight, ");
        sql.append("  t.init_amount, ");
        sql.append("  t.status, ");
        sql.append("  t.good_type_desc, ");
        sql.append("  IF( ");
        sql.append("    t.status = '00', ");
        sql.append("    '无效', ");
        sql.append("    IF( ");
        sql.append("      t.status = '10', ");
        sql.append("      '新增', ");
        sql.append("      IF( ");
        sql.append("        t.status = '20', ");
        sql.append("        '生效', ");
        sql.append("        IF( ");
        sql.append("          t.status = '30', ");
        sql.append("          '完成', ");
        sql.append("          IF(t.status = '60', '终止', '未知') ");
        sql.append("        ) ");
        sql.append("      ) ");
        sql.append("    ) ");
        sql.append("  ) AS status_desc, ");
        sql.append("  t.receiver, ");
        sql.append("  t.receiver_mobile, ");
        sql.append("  t.bill_sender_mobile, ");
        sql.append("  t.bill_sender, ");
        sql.append("  t.prod_desc, ");
        sql.append("  g.pin_dan_num AS pinDanNum, ");
        sql.append("  IF(t.if_feidan = 'Y', '是', '不是') AS iffly, ");
        sql.append("  g.docu_type AS docu_type, ");
        sql.append("  g.docu_pri_sec AS docu_pri_sec, ");
        sql.append("  g.ds_if_settle AS dsIfSettle, ");
        sql.append("  IF(g.ds_if_settle = 0, '否', '是') AS dsIfSettleDesc, ");
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
        sql.append("  IF( ");
        sql.append("    t.if_tax_transport = 'Y', ");
        sql.append("    '是', ");
        sql.append("    '否' ");
        sql.append("  ) AS ifTaxTransport ");
        sql.append("FROM ");
        sql.append("  vatflowdetail v ");
        sql.append("  JOIN ( ");
        sql.append("      TransportationM AS t ");
        sql.append("      JOIN goodsorderm g ");
        sql.append("        ON g.publish_id = t.publish_id ");
        sql.append("        AND t.if_tax_transport = 'Y' ");
        sql.append("    ) ");
        sql.append("    ON (t.vat_flow_master_id = v.vat_flow_master_id ");
        sql.append("    AND v.vat_carry_id = ?) ");
        sql.append("     LEFT JOIN vatflowdetail v1 ");
        sql.append("      ON (t.vat_flow_master_id = v1.vat_flow_master_id ");
        sql.append("      AND v1.vat_client_id = ?) ");
        sql.append("       LEFT JOIN company c ");
        sql.append("        ON (v1.vat_carry_id = c.seq_id ");
        sql.append("        AND v1.vat_client_id = ?) ");
        sql.append("         LEFT JOIN company c1 ");
        sql.append("          ON (t.company_id = c1.seq_id) WHERE 1 = 1 ");
        sql.append(" AND t.platform_id = ? ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getCompanyId());
        args.add(vo.getCompanyId());
        args.add(vo.getCompanyId());
        args.add(vo.getPlatformId());

        if (!ObjectUtils.isEmpty(vo.getCompanyId())){
            sql.append(" AND (g.is_auto_display = '1' or (g.is_auto_display = '0' and t.status != '30')) ");
        }

        if (!ObjectUtils.isEmpty(vo.getPublishId())){
            sql.append(" AND t.publish_id = ? ");
            args.add(vo.getPublishId());
        }

        if (!ObjectUtils.isEmpty(vo.getDependNum())){
            sql.append(" AND t.publish_id in (select t1.publish_id from GoodsOrderM t1 where t1.depend_num = ?) ");
            args.add(vo.getDependNum());
        }

        if (!ObjectUtils.isEmpty(vo.getCarriCompany())){
            sql.append(" AND t.company_id IN (select t3.seq_id from Company t3 where t3.company_name like CONCAT('%',?,'%')) ");
            args.add(vo.getCarriCompany());
        }

        if (!ObjectUtils.isEmpty(vo.getTransId())){
            sql.append(" AND t.trans_id like CONCAT('%',?,'%') ");
            args.add(vo.getTransId());
        }

        if (!ObjectUtils.isEmpty(vo.getGetOrderPlate())){
            sql.append(" AND t.get_order_plate like CONCAT('%',?,'%') ");
            args.add(vo.getGetOrderPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getStartPlate())){
            sql.append(" AND t.start_plate like CONCAT('%',?,'%') ");
            args.add(vo.getStartPlate());
        }

        if (!ObjectUtils.isEmpty(vo.getEndPlate())){
            sql.append(" AND t.end_plate like CONCAT('%',?,'%') ");
            args.add(vo.getEndPlate());
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
            sql.append(" AND t.status =  ? ");
            args.add(vo.getStatus());
        }

        if (!ObjectUtils.isEmpty(vo.getPinDan())){
            if("1".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is not null)  ");
            }else if("2".equalsIgnoreCase(vo.getPinDan())){
                sql.append(" AND exists(SELECT 1 FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.pin_dan_num is  null)  ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getIffly())){
            sql.append(" AND t.if_feidan = ? ");
            args.add(vo.getIffly());
        }

        if (!ObjectUtils.isEmpty(vo.getTranStatue())){
            if("30".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND (t.status ='30' or t.weight = 0) ");
            }else if("50".equalsIgnoreCase(vo.getTranStatue())){
                sql.append(" AND t.weight > 0  and  (t.status = '20' or t.status = '10') ");
            }
        }

        if (!ObjectUtils.isEmpty(vo.getBillSender())){
            sql.append(" AND (select t2.company_name from GoodsOrderM t1 , Company t2 where t1.publish_id = t.publish_id and t1.company_id = t2.seq_id) like CONCAT('%',?,'%') ");
            args.add(vo.getBillSender());
        }

        if (!ObjectUtils.isEmpty(vo.getProdDesc())){
            sql.append(" AND t.prod_desc like CONCAT('%',?,'%') ");
            args.add(vo.getProdDesc());
        }

        if (!ObjectUtils.isEmpty(vo.getDsIfSettle())){
            sql.append(" AND g.ds_if_settle = ? ");
            args.add(vo.getDsIfSettle());
        }

        if (!ObjectUtils.isEmpty(vo.getTaxTransport())){
            sql.append(" AND t.if_tax_transport = ? ");
            args.add(vo.getTaxTransport());
        }

        sql.append(" order by t.CREATE_DATE desc ");

        return pageQuery.list(sql.toString(), args, TransOrderVo.class);
    }

    @Override
    public void saveNewOrder(Map<String, Object> paramMap) {
        sqlSessionTemplate.insert("transportationm.insert", paramMap);
    }
}