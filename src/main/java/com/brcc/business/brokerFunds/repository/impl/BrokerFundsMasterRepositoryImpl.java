package com.brcc.business.brokerFunds.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.brcc.business.brokerFunds.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.brokerFunds.repository.IBrokerFundsMasterRepository;
import com.esteel.common.dao.PageQuery;
import org.springframework.util.StringUtils;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
public class BrokerFundsMasterRepositoryImpl implements IBrokerFundsMasterRepository{
	
	@Autowired
    PageQuery pageQuery;
    @Autowired
    EntityManager entityManager;

	@Override
	public Page<BrokerFundsDetailVo> brokerFundsMasterAuditList(BrokerFundsDetailQueryVo queryvo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT ");
        sql.append("m.funds_control_master_id,");
        sql.append("v.funds_control_detail_id,");
        sql.append("v.publish_id,");
        sql.append("v.trans_id,");
        sql.append("v.delivery_id,");
        sql.append("v.pay_bill_id,");
        sql.append("p.zf_num,");
        sql.append("v.start_plate,");
        sql.append("v.end_plate,");
        sql.append("v.publish_company_name,");
        sql.append("c.contact_mobile,");
        sql.append("v.good_type,");
        sql.append("v.good_type_desc,");
        sql.append("t.weight,");
        sql.append("t.truck_loading_weight,");
        sql.append("t.take_delivery_weight,");
        sql.append("t.settle_weight,");
        sql.append("t.good_price ,");
        sql.append("t.loss_type, ");
        sql.append("t.loss_ratio, ");
        sql.append("t.loss_weight, ");
        sql.append("v.driver_id, ");
        sql.append("v.driver_name, ");
        sql.append("v.driver_phone, ");
        sql.append("v.vehicle_num, ");
        sql.append("v.vehicle_id, ");
        sql.append("v.vehicle_type, ");
        sql.append("v.car_axle, ");
        sql.append("p.price, ");
        sql.append("p.pay_amount, ");
        sql.append("t.broker_people_toll_type, ");
        sql.append("t.broker_people_toll_amount, ");
        sql.append("t.broker_people_toll_ratio, ");
        sql.append("v.fc_carry_name, ");
        sql.append("v.fc_carry_amount, ");
        sql.append("m.funds_pic, ");
        sql.append("m.funds_pic_sec, ");
        sql.append("m.funds_pic_thi, ");
        sql.append("v.detail_status, ");
        sql.append("v.detail_status_remark, ");
        sql.append("v.first_audit_date, ");
        sql.append("v.first_audit_id, ");
        sql.append("v.first_audit_name, ");
        sql.append("v.second_audit_date, ");
        sql.append("v.second_audit_id, ");
        sql.append("v.second_audit_name, ");
        sql.append("m.funds_control_master_num, ");
        sql.append("p.company_name, ");
        sql.append("v.qd_create_date ");
        sql.append("FROM ");
        sql.append("brokerfundscontrolmaster m, ");
        sql.append("brokerfundscontroldetail v, ");
        sql.append("pay_bill p, ");
        sql.append("company c, ");
        sql.append("transportationdelivery t ");
        sql.append(" where ");
        sql.append("  m.funds_control_master_id = v.funds_control_master_id ");
        sql.append("AND m.master_status IN ('30', '40','50') ");
        sql.append("AND v.fc_if_upload = '1' ");   //0代表未上传，1代表已上传
        sql.append("AND p.zf_id = v.pay_bill_id ");
        sql.append("AND p.status = '20' ");
        sql.append("AND c.seq_id = v.publish_company_id ");
        sql.append("AND t.delivery_id = v.delivery_id ");
        sql.append("and m.platform_id =v.platform_id ");
        sql.append("and m.platform_id = p.platform_id ");
        sql.append("and p.platform_id=? ");
        args.add(queryvo.getPlatformId() );        
        
        if(queryvo.getPublishId() !=null){
        	sql.append(" and v.publish_id =?  ");
            args.add(queryvo.getPublishId());
        }
        if(queryvo.getDeliveryId() !=null){
            sql.append("and v.delivery_id = ? ");
            args.add(queryvo.getDeliveryId());
        }
        if(queryvo.getTransId() !=null){
            sql.append("and v.trans_id = ? ");
            args.add(queryvo.getTransId());
        }       
        // 一审时间
        if (!ObjectUtils.isEmpty(queryvo.getFirstAuditDateStart())) {
        	sql.append(" AND v.first_audit_date >= ? ");
        	args.add(queryvo.getFirstAuditDateStart());
        }
        // 结束时间
        if (!ObjectUtils.isEmpty(queryvo.getFirstAuditDateEnd())) {
        	sql.append(" AND v.first_audit_date < ? ");
        	args.add(queryvo.getFirstAuditDateEnd());
        }	
        // 二审时间
        if (!ObjectUtils.isEmpty(queryvo.getSecondAuditDateStart())) {
        	sql.append(" AND v.second_audit_date >= ? ");
        	args.add(queryvo.getSecondAuditDateStart());
        }
        // 结束时间
        if (!ObjectUtils.isEmpty(queryvo.getSecondAuditDateEnd())) {
        	sql.append(" AND v.second_audit_date <= ? ");
        	args.add(queryvo.getSecondAuditDateEnd());
        }
        if(!StringUtils.isEmpty(queryvo.getDetailStatus())){
            sql.append(" and v.detail_status= ? ");
            args.add(queryvo.getDetailStatus());
        }

        if (!ObjectUtils.isEmpty(queryvo.getQdRqStart())) {
            sql.append(" AND v.qd_create_date >= ? ");
            args.add(queryvo.getQdRqStart());
        }
        if (!ObjectUtils.isEmpty(queryvo.getQdRqEnd())) {
            sql.append(" AND v.qd_create_date <= ? ");
            args.add(queryvo.getQdRqEnd());
        }

        if(!StringUtils.isEmpty(queryvo.getDetailStatus())){
            sql.append(" and v.detail_status= ? ");
            args.add(queryvo.getDetailStatus());
        }

        return pageQuery.query(sql.toString(), args, queryvo, BrokerFundsDetailVo.class);
	}
	
	
	//超限调度单查询
	@Override
	public Page<TransfiniteDispatchVo> transfiniteDispatchPage(TransfiniteDispatchQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select ");
        sql.append(" t.platform_id,");
        sql.append(" t.publish_id,");
        sql.append(" t.trans_id,");
        sql.append(" t.delivery_id,");
        sql.append(" p.zf_id,");
        sql.append(" p.zf_num,");
        sql.append("t.weight,");
        sql.append("t.truck_loading_weight,");
        sql.append("t.take_delivery_weight,");
        sql.append("t.good_price ,");
        sql.append("t.loss_type, ");
        sql.append("t.loss_ratio, ");
        sql.append("t.loss_weight, ");
        sql.append(" t.if_funds_control_flag,");
        sql.append(" t.publish_company_id,");
        sql.append(" c.company_name AS \"publishCompanyName\",");
        sql.append(" c.contact_mobile,");
        sql.append(" t.good_type,");
        sql.append(" t.good_type_desc,");
        sql.append(" g.start_plate,");
        sql.append(" g.end_plate,");
        sql.append(" g.get_order_plate,");
        sql.append(" p.price,");
        sql.append(" p.pay_amount,");
        sql.append(" g.depend_num,");
        sql.append(" DATE_FORMAT(t.create_date,'%Y-%m-%d %H:%i:%s') AS createDate,");
        sql.append(" DATE_FORMAT(ifnull(t.finish_time,t.shSure_date),'%Y-%m-%d %H:%i:%s') AS finishTime,");
        sql.append(" TIMESTAMPDIFF(\r\n" + 
        		"		MINUTE,\r\n" + 
        		"		t.create_date,\r\n" + 
        		"		ifnull(\r\n" + 
        		"			t.finish_time,\r\n" + 
        		"			t.shSure_date\r\n" + 
        		"		)\r\n" + 
        		"	) AS \"useMinute\",");
        sql.append(" t.driver_id,");
        sql.append(" d. NAME AS \"driverName\",");
        sql.append(" d.phone AS \"driverPhone\","); 
        sql.append(" t.vehicle_id,");
        sql.append(" v.vehicle_num,");
        sql.append(" v.vehicle_type,");
        sql.append(" v.car_axle,");
        sql.append(" g.estimateKM,");
        sql.append(" pc.pay_amount_act as 'payJjrAmount'," );//支付给经纪人的资金
        sql.append(" p.pay_carry_min_amt");//经纪人需要支付给司机的最低金额
        sql.append(" FROM");
        sql.append(" transportationdelivery t,");
        sql.append(" company c,");
        sql.append(" driver d,");
        sql.append(" vehicle v,");
        sql.append(" goodsorderm g,");
        sql.append(" pay_bill p,");
        sql.append("pay_bill_child pc ");
        sql.append(" WHERE 1 = 1 ");
        sql.append(" AND t.publish_company_id = c.seq_id");
        sql.append(" AND d.id = t.driver_id");
        sql.append(" AND v.vehicle_id = t.vehicle_id");
        sql.append(" AND g.publish_id = t.publish_id");
        sql.append(" AND p.delivery_id = t.delivery_id");
        sql.append(" AND p. STATUS = '20'");
        sql.append(" AND t.company_id = ?");
        args.add(queryVo.getCompanyId());
        sql.append(" AND t.if_funds_control_flag >'0'");
        sql.append(" AND t.`status` = '90'");
        sql.append(" AND t.platform_id = ?");
        args.add(queryVo.getPlatformId() );
        sql.append(" AND g.platform_id = t.platform_id");
        sql.append(" AND t.if_tax_transport = 'Y'");
        sql.append(" and p.zf_id = pc.zf_id ");
        sql.append(" and pc.pay_from_type='1' ");
        if(!ObjectUtils.isEmpty(queryVo.getPublishId())){
            sql.append(" and t.publish_id like ?");
            args.add("%" + queryVo.getPublishId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getTransId())){
            sql.append(" and t.trans_id like ?");
            args.add("%" + queryVo.getTransId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like ?");
            args.add("%" + queryVo.getDeliveryId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getZfNum())){
            sql.append(" and p.zf_num like ?");
            args.add("%" + queryVo.getZfNum()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getPublishCompanyName())){
            sql.append(" and c.company_name like ?");
            args.add("%" + queryVo.getPublishCompanyName()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getIfFundsControlFlag())) {
        	sql.append(" and  if_funds_control_flag =?");
        	args.add(queryVo.getIfFundsControlFlag());
        }
        if(queryVo.getRqStart()!=null) {
        	 sql.append(" and  t.create_date >= ? ");
             args.add(queryVo.getRqStart());
        }
        if(queryVo.getRqEnd()!=null) {
        	 sql.append(" and  t.create_date < ? ");
             args.add(queryVo.getRqEnd());
        }
		return pageQuery.query(sql.toString(), args, queryVo, TransfiniteDispatchVo.class);
	}
    //根据计算单号找到对应的调度单详情
    @Override
    public BrokerFundsDetailVo getBrokerFundsDetailVo(BrokerFundsVo brokerFundsVo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select ");
        sql.append(" t.platform_id,");
        sql.append(" t.publish_id,");
        sql.append(" t.trans_id,");
        sql.append(" t.delivery_id,");
        sql.append(" p.zf_id as 'payBillId',");
        sql.append(" p.zf_num as 'payBillNum',");
        sql.append("t.weight,");
        sql.append("t.truck_loading_weight,");
        sql.append("t.take_delivery_weight,");
        sql.append("t.good_price ,");
        sql.append("t.loss_type, ");
        sql.append("t.loss_ratio, ");
        sql.append("t.loss_weight, ");
        sql.append(" t.if_funds_control_flag,");
        sql.append(" t.publish_company_id,");
        sql.append(" c.company_name AS \"publishCompanyName\",");
        sql.append(" c.contact_mobile,");
        sql.append(" t.good_type,");
        sql.append(" t.good_type_desc,");
        sql.append(" g.start_plate,");
        sql.append(" g.end_plate,");
        sql.append(" g.get_order_plate,");
        sql.append(" p.price,");
        sql.append(" p.pay_amount,");
        sql.append(" g.depend_num,");
        sql.append(" DATE_FORMAT(t.create_date,'%Y-%m-%d %H:%i:%s') AS qdCreateDate,");
        sql.append(" DATE_FORMAT(ifnull(t.finish_time,t.shSure_date),'%Y-%m-%d %H:%i:%s') AS qdFinishDate,");
        sql.append(" TIMESTAMPDIFF(\r\n" +
                "		MINUTE,\r\n" +
                "		t.create_date,\r\n" +
                "		ifnull(\r\n" +
                "			t.finish_time,\r\n" +
                "			t.shSure_date\r\n" +
                "		)\r\n" +
                "	) AS \"useMinute\",");
        sql.append(" t.driver_id,");
        sql.append(" d. NAME AS \"driverName\",");
        sql.append(" d.phone AS \"driverPhone\",");
        sql.append(" t.vehicle_id,");
        sql.append(" v.vehicle_num,");
        sql.append(" v.vehicle_type,");
        sql.append(" v.car_axle,");
        sql.append(" g.estimateKM,");
        sql.append(" pc.pay_amount_act as 'payJjrAmount'," );//支付给经纪人的资金
        sql.append(" p.pay_carry_min_amt, ");//经纪人需要支付给司机的最低金额
        sql.append(" p.pay_finish_date, ");
        sql.append(" ifnull(pc.company_owner_id,0) as 'companyOwnerId'  ");
        sql.append(" FROM");
        sql.append(" transportationdelivery t,");
        sql.append(" company c,");
        sql.append(" driver d,");
        sql.append(" vehicle v,");
        sql.append(" goodsorderm g,");
        sql.append(" pay_bill p,");
        sql.append("pay_bill_child pc ");
        sql.append(" WHERE 1 = 1 ");
        sql.append(" AND t.publish_company_id = c.seq_id");
        sql.append(" AND d.id = t.driver_id");
        sql.append(" AND v.vehicle_id = t.vehicle_id");
        sql.append(" AND g.publish_id = t.publish_id");
        sql.append(" AND p.delivery_id = t.delivery_id");
        sql.append(" AND p. STATUS = '20'");
        sql.append(" AND t.company_id = ?");
        args.add(brokerFundsVo.getBorkerCompanyId());
        sql.append(" AND t.`status` = '90'");
        sql.append(" AND t.platform_id = ?");
        args.add(brokerFundsVo.getPlatformId() );
        sql.append(" AND g.platform_id = t.platform_id");
        sql.append(" AND t.if_tax_transport = 'Y'");
        sql.append(" and p.zf_id = pc.zf_id ");
        sql.append(" and pc.pay_from_type='1' ");
        sql.append(" and p.zf_id = ? ");
        args.add(brokerFundsVo.getZfId());
        List<BrokerFundsDetailVo> list= pageQuery.list(sql.toString(),args,BrokerFundsDetailVo.class);
        return ObjectUtils.isEmpty(list) ? new BrokerFundsDetailVo():list.get(0);
    }

    @Override
    public Page<BrokerFundsVo> brokerFundsMasterList(BrokerFundsQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select b.* , ");
     //   sql.append("ifnull(c.tot_audited_amt,0) as 'quarterPayeeAmount',");
        sql.append("(select sum(pc.pay_amount_act) from brokerfundscontroldetail d,pay_bill_child pc  where d.funds_control_master_id=b.funds_control_master_id and pc.zf_id = d.pay_bill_id and pc.pay_from_type ='1') as 'companyPayeeAmount' ");
        sql.append(" from brokerfundscontrolmaster b ");
     //   sql.append(" left join broker_payee_capital c on (c.company_payee_id=p.company_payee_id and c.quarter_name= b.broker_tax_cycle_name and c.company_id = b.borker_company_id)");
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
        if(!StringUtils.isEmpty(vo.getMasterStatus())){
            sql.append("and  b.master_status = ? ");
            args.add(vo.getMasterStatus());
        }
        if(!StringUtils.isEmpty(vo.getCompanyPayeeName())){
            sql.append("and  p.company_payee_name like ? ");
            args.add("%" + vo.getCompanyPayeeName()+ "%");
        }
        sql.append(" order by b.create_date desc");
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsVo.class);
    }

    //查询可以添加进入到资金流水单的调度单明细
    @Override
    public Page<BrokerFundsDetailVo> addBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo queryVo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select ");
        sql.append(" t.platform_id,");
        sql.append(" t.publish_id,");
        sql.append(" t.trans_id,");
        sql.append(" t.delivery_id,");
        sql.append(" p.zf_id as 'payBillId',");
        sql.append(" p.zf_num as 'payBillNum',");
        sql.append("t.weight,");
        sql.append("t.truck_loading_weight,");
        sql.append("t.take_delivery_weight,");
        sql.append("t.good_price ,");
        sql.append("t.loss_type, ");
        sql.append("t.loss_ratio, ");
        sql.append("t.loss_weight, ");
        sql.append(" t.if_funds_control_flag,");
        sql.append(" t.publish_company_id,");
        sql.append(" c.company_name AS \"publishCompanyName\",");
        sql.append(" c.contact_mobile,");
        sql.append(" t.good_type,");
        sql.append(" t.good_type_desc,");
        sql.append(" g.start_plate,");
        sql.append(" g.end_plate,");
        sql.append(" g.get_order_plate,");
        sql.append(" p.price,");
        sql.append(" p.pay_amount,");
        sql.append(" g.depend_num,");
        sql.append(" DATE_FORMAT(t.create_date,'%Y-%m-%d %H:%i:%s') AS qdCreateDate,");
        sql.append(" DATE_FORMAT(ifnull(t.finish_time,t.shSure_date),'%Y-%m-%d %H:%i:%s') AS qdFinishTime,");
        sql.append(" TIMESTAMPDIFF(\r\n" +
                "		MINUTE,\r\n" +
                "		t.create_date,\r\n" +
                "		ifnull(\r\n" +
                "			t.finish_time,\r\n" +
                "			t.shSure_date\r\n" +
                "		)\r\n" +
                "	) AS \"useMinute\",");
        sql.append(" t.driver_id,");
        sql.append(" d. NAME AS \"driverName\",");
        sql.append(" d.phone AS \"driverPhone\",");
        sql.append(" t.vehicle_id,");
        sql.append(" v.vehicle_num,");
        sql.append(" v.vehicle_type,");
        sql.append(" v.car_axle,");
        sql.append(" g.estimateKM,");
        sql.append(" pc.pay_amount_act as 'payJjrAmount'," );//支付给经纪人的资金
        sql.append(" p.pay_carry_min_amt,");//经纪人需要支付给司机的最低金额
        sql.append(" pc.rece_bank_owner,");
        sql.append(" pc.rece_bank_num, ");
        sql.append(" p.pay_finish_date, ");
        sql.append(" pc.company_owner_id ");
        sql.append(" FROM");
        sql.append(" transportationdelivery t,");
        sql.append(" company c,");
        sql.append(" driver d,");
        sql.append(" vehicle v,");
        sql.append(" goodsorderm g,");
        sql.append(" pay_bill p,");
        sql.append("pay_bill_child pc ");
        sql.append(" WHERE 1 = 1 ");
        sql.append(" AND t.publish_company_id = c.seq_id");
        sql.append(" AND d.id = t.driver_id");
        sql.append(" AND v.vehicle_id = t.vehicle_id");
        sql.append(" AND g.publish_id = t.publish_id");
        sql.append(" AND p.delivery_id = t.delivery_id");
        sql.append(" AND p. STATUS = '20'");
        sql.append(" AND t.company_id = ?");
        args.add(queryVo.getCompanyId());
        sql.append(" AND t.if_funds_control_flag ='1'");
        sql.append(" AND t.`status` = '90'");
        sql.append(" AND t.platform_id = ?");
        args.add(queryVo.getPlatformId() );
        sql.append(" AND g.platform_id = t.platform_id");
        sql.append(" AND t.if_tax_transport = 'Y'");
        sql.append(" and p.zf_id = pc.zf_id ");
        sql.append(" and pc.pay_from_type='1' ");
        if(!ObjectUtils.isEmpty(queryVo.getPublishId())){
            sql.append(" and t.publish_id like ?");
            args.add("%" + queryVo.getPublishId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getTransId())){
            sql.append(" and t.trans_id like ?");
            args.add("%" + queryVo.getTransId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getDeliveryId())){
            sql.append(" and t.delivery_id like ?");
            args.add("%" + queryVo.getDeliveryId()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getPayBillNum())){
            sql.append(" and p.zf_num like ?");
            args.add("%" + queryVo.getPayBillNum()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getPublishCompanyName())){
            sql.append(" and c.company_name like ?");
            args.add("%" + queryVo.getPublishCompanyName()+ "%");
        }

        if(!ObjectUtils.isEmpty(queryVo.getGoodTypeDesc())){
            sql.append(" and t.good_type_desc like ? ");
            args.add("%" + queryVo.getGoodTypeDesc()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getDriverPhone())){
            sql.append(" and d.phone like ? ");
            args.add("%" + queryVo.getDriverPhone()+ "%");
        }
        if(!ObjectUtils.isEmpty(queryVo.getVehicleNum())){
            sql.append(" and v.vehicle_num like ? ");
            args.add("%" + queryVo.getVehicleNum()+ "%");
        }

        if(!ObjectUtils.isEmpty(queryVo.getStartPlate())){
            sql.append(" and t.start_plate like ? ");
            args.add("%" + queryVo.getStartPlate()+ "%");
        }

        if(!ObjectUtils.isEmpty(queryVo.getEndPlate())){
            sql.append(" and t.end_plate like ? ");
            args.add("%" + queryVo.getEndPlate()+ "%");
        }

        if(!ObjectUtils.isEmpty(queryVo.getDriverName())) {
            sql.append(" and  d.name like ?");
            args.add("%" + queryVo.getDriverName() + "%");
        }
        if(queryVo.getRqStart()!=null) {
            sql.append(" and  t.create_date >= ? ");
            args.add(queryVo.getRqStart());
        }
        if(queryVo.getRqEnd()!=null) {
            sql.append(" and  t.create_date <= ? ");
            args.add(queryVo.getRqEnd());
        }
        if(!StringUtils.isEmpty(queryVo.getReceBankOwner())){
            sql.append(" and pc.rece_bank_owner like ? ");
            args.add("%"+queryVo.getReceBankOwner() + "%");
        }
        if(queryVo.getPayStart()!=null){
            sql.append(" and p.pay_finish_date >= ?");
            args.add(queryVo.getPayStart());
        }
        if(queryVo.getPayEnd()!=null){
            sql.append(" and p.pay_finish_date < ?");
            args.add(queryVo.getPayEnd());
        }
        sql.append(" order by p.pay_finish_date desc");
        return pageQuery.query(sql.toString(), args, queryVo, BrokerFundsDetailVo.class);

    }

    @Override
    public Page<BrokerFundsDetailVo> lookBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select t.* , ");
        sql.append("g.depend_num, ");
        sql.append("g.get_order_plate, ");
        sql.append("p.price, ");
        sql.append("p.pay_amount, ");
        sql.append("p.pay_carry_min_amt, ");
        sql.append("p.zf_num as 'payBillNum', ");
        sql.append("pc.pay_amount_act as 'payJjrAmount',  ");
        sql.append("c.contact_mobile, ");
        sql.append("m.master_status, ");
        sql.append(" pc.rece_bank_owner,");
        sql.append(" pc.rece_bank_num");
        sql.append(" from brokerfundscontroldetail t, " );
        sql.append("  brokerfundscontrolmaster m, " );
        sql.append(" company c, ");
        sql.append(" goodsorderm g, " );
        sql.append(" pay_bill p ,");
        sql.append(" pay_bill_child pc ");
        sql.append(" WHERE 1=1 ");
        sql.append(" and t.pay_bill_id = p.zf_id ");
        sql.append(" and t.funds_control_master_id = m.funds_control_master_id ");
        sql.append(" and t.publish_company_id = c.seq_id ");
        sql.append(" and g.publish_id = t.publish_id");
        sql.append(" and p.zf_id =pc.zf_id");
        sql.append(" and pc.pay_from_type ='1'");
        sql.append(" and t.funds_control_master_id = ? ");
        args.add(vo.getFundsControlMasterId());
        if(!ObjectUtils.isEmpty(vo.getDetailStatus())){
            sql.append(" and t.detail_status = ?");
            args.add(vo.getDetailStatus());
        }
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
        sql.append(" order by t.create_date desc");
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsDetailVo.class);
    }
    @Override
    public List<BrokerFundsDetailVo> excelBrokerFunds(BrokerFundsDetailQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select t.* , ");
        sql.append("g.depend_num, ");
        sql.append("g.get_order_plate, ");
        sql.append("p.price, ");
        sql.append("p.pay_carry_min_amt, ");
        sql.append("p.pay_amount, ");
        sql.append("p.zf_num as 'payBillNum', ");
        sql.append("pc.pay_amount_act as 'payJjrAmount',  ");
        sql.append("c.contact_mobile ");
        sql.append(" from brokerfundscontroldetail t, " );
        sql.append(" company c, ");
        sql.append(" goodsorderm g, " );
        sql.append(" pay_bill p ,");
        sql.append(" pay_bill_child pc ");
        sql.append(" WHERE 1=1 ");
        sql.append(" and t.pay_bill_id = p.zf_id ");
        sql.append(" and t.publish_company_id = c.seq_id ");
        sql.append(" and g.publish_id = t.publish_id");
        sql.append(" and p.zf_id =pc.zf_id");
        sql.append(" and pc.pay_from_type ='1'");
        sql.append(" and t.funds_control_master_id = ? ");
        args.add(vo.getFundsControlMasterId());
        if(!ObjectUtils.isEmpty(vo.getDetailStatus())){
            sql.append(" and t.detail_status = ?");
            args.add(vo.getDetailStatus());
        }
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
        List<BrokerFundsDetailVo> list= pageQuery.list(sql.toString(),args,BrokerFundsDetailVo.class);
        return ObjectUtils.isEmpty(list) ? new ArrayList<>():list;
    }

    @Override
    public ArrayList saveSecondAuditPro(Integer asPkId, String asType,String userId, String userName) {
        StoredProcedureQuery docuNo = entityManager.createNamedStoredProcedureQuery("pro_broker_tax_process");
        docuNo.setParameter("asPkId",asPkId);
        docuNo.setParameter("asType",asType);
        docuNo.setParameter("userId",userId);
        docuNo.setParameter("userName",userName);
        ArrayList resultList = (ArrayList) docuNo.getResultList();
        return resultList;
      //  return null;
    }


    @Override
    public ArrayList checkPayeeAmountPro(Integer asPkId,String userId, String userName) {
        StoredProcedureQuery docuNo = entityManager.createNamedStoredProcedureQuery("pro_broker_payee_process");
        docuNo.setParameter("asPkId",asPkId);
        docuNo.setParameter("userId",userId);
        docuNo.setParameter("userName",userName);
        ArrayList resultList = (ArrayList) docuNo.getResultList();
        return resultList;
    }

    @Override
    public Page<BrokerFundsVo> masterAuditList(BrokerFundsQueryVo vo){
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<Object>();
        sql.append("select b.* , ");
        sql.append("(select sum(pc.pay_amount_act) from brokerfundscontroldetail d,pay_bill_child pc  where d.funds_control_master_id=b.funds_control_master_id and pc.zf_id = d.pay_bill_id and pc.pay_from_type ='1') as 'companyPayeeAmount' ");
        sql.append(" from brokerfundscontrolmaster b ");

        sql.append(" where 1=1 ");
        sql.append(" and b.master_status in ('05','15','20','30') ");
        sql.append(" and b.platform_id=? ");
        args.add(vo.getPlatformId() );
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
        if(!StringUtils.isEmpty(vo.getMasterStatus())){
            sql.append("and  b.master_status = ? ");
            args.add(vo.getMasterStatus());
        }
//        if(!StringUtils.isEmpty(vo.getCompanyPayeeName())){
//            sql.append("and  p.company_payee_name like ? ");
//            args.add("%" + vo.getCompanyPayeeName()+ "%");
//        }
//        if(!StringUtils.isEmpty(vo.getCompanyPayeeName())){
//            sql.append("and  p.company_payee_name like ? ");
//            args.add("%" + vo.getCompanyPayeeName()+ "%");
//        }
        if(!StringUtils.isEmpty(vo.getBorkerCompanyName())){
            sql.append("and  b.borker_company_name like ? ");
            args.add("%" + vo.getBorkerCompanyName()+ "%");
        }
        sql.append(" order by b.create_date desc");
        return pageQuery.query(sql.toString(), args, vo, BrokerFundsVo.class);
    }
}
