package com.brcc.business.goodsordermjk.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ObjectUtils;

import com.brcc.business.basedata.vo.TeamCompanyVo;
import com.brcc.business.goodsordermjk.repository.IGoodsordermjkRepository;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkQueryVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.esteel.common.dao.PageQuery;

/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 上午9:09:25
* @ClassName 类名称
* @Description 类描述
*/
public class GoodsordermjkRepositoryImpl implements IGoodsordermjkRepository {
	@Autowired
	PageQuery pageQuery;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Page<GoodsordermjkVo> listData(GoodsordermjkQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" 			t.publish_id, ");
		sql.append(" 			t.import_id, ");
		sql.append(" 			t.weight, ");
		sql.append(" 			t.qty, ");
		sql.append(" 			t.amount, ");
		sql.append(" 			t.status, ");
		sql.append(" 		    if(t.status = '10','新增',if(t.status = '20','已审核',if(t.status = '00','已作废',if(t.status = '30','待拼单',if(t.status = '40','已拼单','未知'))))) as statusDesc, ");
		sql.append(" 			t.platform_id, ");
		sql.append(" 		    t.create_date, ");
		sql.append(" 			t.limit_time, ");
		sql.append(" 			t.remark, ");
		sql.append(" 			t.depend_num, ");
		sql.append(" 			t.depend_num2, ");
		sql.append(" 			t.price, ");
		sql.append(" 			t.start_plate, ");
		sql.append(" 			t.get_order_plate, ");
		sql.append(" 			t.end_plate, ");
		sql.append(" 			ifnull(t.start_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLngDesc, ");
		sql.append(" 	        ifnull(t.start_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLatDesc, ");
		sql.append(" 	        ifnull(t.end_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as endPlateLngDesc, ");
		sql.append(" 	        ifnull(t.end_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as end_plateLatDesc, ");
		sql.append(" 	        ifnull(t.get_order_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLngDesc, ");
		sql.append(" 	        ifnull(t.get_order_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLatDesc, ");
		sql.append(" 			t.end_plate_address, ");
		sql.append(" 			t.get_order_plate_province, ");
		sql.append(" 			t.get_order_plate_city, ");
		sql.append(" 			t.get_order_plate_detail, ");
		sql.append(" 			t.start_plate_province, ");
		sql.append(" 			t.start_plate_city, ");
		sql.append(" 			t.start_plate_detail, ");
		sql.append(" 			t.ret_2 as ret2, ");
		sql.append(" 			t.sendKM, ");
		sql.append(" 			t.sender, ");
		sql.append(" 			t.sender_mobile, ");
		sql.append(" 			t.receiver_mobile, ");
		sql.append(" 			t.receiver, ");
		sql.append(" 			t.good_type, ");
		sql.append(" 			t.from_type, ");
		sql.append(" 			t.batch_id, ");
		sql.append(" 			t.good_type_desc, ");
		sql.append(" 			t.bill_sender, ");
		sql.append(" 			t.bill_sender_mobile, ");
		sql.append(" 			t.bill_taker, ");
		sql.append(" 			t.bill_taker_mobile, ");
		sql.append(" 			t.detachable, ");
		sql.append(" 			if(t.detachable = '1','可拆',if(t.detachable = '0','不可拆','未知')) as detachableDesc, ");
		sql.append(" 			t.heavy_piece, ");
		sql.append(" 			t.approve_time, ");
		sql.append(" 			t.approve_user_id, ");
		sql.append(" 			t.prod_desc, ");
		sql.append(" 			t.pin_dan_num, ");
		sql.append(" 			t.max_price, ");
		sql.append(" 			t.if_info_complete, ");
		sql.append(" 			if(t.if_info_complete = 'Y', '已完善','未完善') as ifInfoCompleteDesc, ");
		sql.append(" 			t.end_plate_province, ");
		sql.append(" 			t.end_plate_city, ");
		sql.append(" 			t.spilt_type, ");
		sql.append(" 			t.init_spilt_weight, ");
		sql.append(" 			t.single_car_weight, ");
		sql.append(" 			t.total_weight  , ");
		sql.append(" 			t.spilt_type , ");
		sql.append(" 		    t.loss_type, ");
		sql.append(" 		    t.loss_ratio, ");
		sql.append(" 		    t.good_price , ");
		sql.append(" 		    t.loss_weight, ");
		sql.append(" 		    t.js_type, ");
		sql.append(" 		    t.ds_if_settle, ");
		sql.append(" 		    t.end_plate_country, ");
		sql.append(" 		    t.price_tax, ");
		sql.append(" 		    t.prod_area, ");
		sql.append(" 		    ifnull(t.listing_price,0) as listingPrice, ");
		sql.append(" 		    ifnull(t.charge_price_type,0) as chargePriceType, ");
		sql.append(" 		    if(ifnull(t.charge_price_type,0)=0,'元/每车','元/吨') as chargePriceTypedesc, ");
		sql.append(" 		    ifnull(t.charge_price,0) as chargePrice, ");
		sql.append(" 		    t.appoint_team_id , ");
		sql.append(" 		    t.appoint_person_info as appointTeamName, ");
		sql.append(" 		    t.if_payment, ");
		sql.append(" 		    if(t.if_payment='Y','是','否') as ifPaymentDesc, ");
		sql.append(" 		    (select if(t.appoint_person_info is null,'2',if(locate('车牌号',t.appoint_person_info) > 0 and locate('手机号',t.appoint_person_info) > 0,'2','1'))) as appointType, ");
		sql.append(" 		    t.pick_up_goods_name, ");
		sql.append(" 		    t.logistics_mark, ");
		sql.append(" 		    t.end_plate_country, ");
		sql.append(" 		    t.get_order_plate_country, ");
		sql.append(" 		    t.start_plate_country, ");
		sql.append(" 		    t.if_tax_transport, ");
		sql.append(" 		    t.vat_flow_master_id, ");
		sql.append(" 		    t.estimateKM, ");
		sql.append(" 		    t.if_on_off  ");
		sql.append(" 		FROM GoodsOrderMJK AS t , GoodsOrderMJKSetPlat t1 ");
		sql.append(" 		WHERE 1=1  ");
		sql.append(" 		and	? = t1.tms_platform_id ");
		args.add(vo.getPlatformId());
		sql.append(" 		and t.company_id = t1.tms_fd_company_id ");
		sql.append(" 		and t1.tms_fd_company_id = ? ");
		args.add(vo.getCompanyId());
		sql.append(" 		and t.platform_id = t1.tms_platform_id ");
		sql.append(" 		and t.ret_1 = t1.ec_plat_name ");
		if("N".equals(vo.getIfShowAdmin())) {
			if("TMS".equals(vo.getAccountFrom())) {
				sql.append("and t.if_can_show ='Y' ");
			}
			if("DS".equals(vo.getAccountFrom())) {
				sql.append("and t.if_can_show ='N' and t.fd_user_id = ?");
				args.add(vo.getFdUserId());
			}
		}
		
		// 单据来源
		if(!ObjectUtils.isEmpty(vo.getFromType())) {
			sql.append(" and t.from_type = ? ");
			args.add(vo.getFromType());
		}
		// 备注
		if(!ObjectUtils.isEmpty(vo.getRemark())) {
			sql.append(" and t.remark like ? ");
			args.add("%" + vo.getRemark() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getOrderId())) {
			sql.append(" and t.publish_id like ? ");
			args.add("%" + vo.getOrderId() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getSeqId())) {
			sql.append(" and t.import_id like ? ");
			args.add("%" + vo.getSeqId() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getUserId())) {
			sql.append(" and t.user_id = ? ");
			args.add(vo.getUserId());
		}
		if(!ObjectUtils.isEmpty(vo.getGetOrderPlate())) {
			sql.append(" and t.get_order_plate like ? ");
			args.add("%" + vo.getGetOrderPlate() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getStartPlate())) {
			sql.append(" and t.start_plate like ? ");
			args.add("%" + vo.getStartPlate() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getBillNum())) {
			sql.append(" and t.ret_2 like ? ");
			args.add("%" + vo.getBillNum() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getEndPlate())) {
			sql.append(" and t.end_plate like ? ");
			args.add("%" + vo.getEndPlate() + "%");
		}
		if(vo.getRqStart() != null) {
			sql.append(" and t.create_date >= ? ");
			args.add(vo.getRqStart());
		}
		if( vo.getRqEnd() != null) {
			sql.append(" and t.create_date <= ? ");
			args.add(vo.getRqEnd());
		}
		if(vo.getPutInRqStart() != null) {
			sql.append(" and t.putin_date >= ? ");
			args.add(vo.getPutInRqStart());
		}
		if(vo.getPutInRqNnd() != null) {
			sql.append(" and t.putin_end <= ? ");
			args.add(vo.getPutInRqNnd());
		}
		if(!ObjectUtils.isEmpty(vo.getStatus())) {
			sql.append(" and t.status = ? ");
			args.add(vo.getStatus());
		}
		if(!ObjectUtils.isEmpty(vo.getIfClosed())) {
			sql.append(" and t.if_closed = ? ");
			args.add(vo.getIfClosed());
		}
		if(!ObjectUtils.isEmpty(vo.getBillSenderMobile())) {
			sql.append(" and t.bill_sender_mobile = ? ");
			args.add(vo.getBillSenderMobile());
		}
		if(!ObjectUtils.isEmpty(vo.getBillSender())) {
			sql.append(" and t.bill_sender like ? ");
			args.add("%" + vo.getBillSender() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getStuStr())) {
		
			sql.append(" and t.status in ( " + vo.getStuStr() + ")");
			
		}
		if(!ObjectUtils.isEmpty(vo.getImportIdStr())) {
			sql.append(" and t.status in ( " + vo.getImportIdStr() + ")");
		}
		if(!ObjectUtils.isEmpty(vo.getPinDanNum())) {
			sql.append(" and t.pin_dan_num = ? ");
			args.add(vo.getPinDanNum());
		}
		if(!ObjectUtils.isEmpty(vo.getPinDan()) && "1".equals(vo.getPinDan())){
			sql.append(" and t.pin_dan_num is not null");
		}
		if(!ObjectUtils.isEmpty(vo.getPinDan()) && "2".equals(vo.getPinDan())){
			sql.append(" and t.pin_dan_num is  null");
		}
		
		if(!ObjectUtils.isEmpty(vo.getIfInfoComplete()) && "Y".equals(vo.getIfInfoComplete())){
			sql.append(" and  t.if_info_complete = 'Y'");
		}
		if(!ObjectUtils.isEmpty(vo.getIfInfoComplete()) && "N".equals(vo.getIfInfoComplete())){
			sql.append(" and  t.if_info_complete = 'N'");
		}
		if(!ObjectUtils.isEmpty(vo.getProdDesc())) {
			sql.append(" and t.prod_desc like ? ");
			args.add("%" + vo.getProdDesc() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getGoodTypeDesc())) {
			sql.append(" and t.good_type_desc  like ? ");
			args.add("%" + vo.getGoodTypeDesc() + "%");
		}
		if(StringUtils.isNotEmpty(vo.getDsIfSettle())) {
			sql.append(" and t.ds_if_settle =  ? ");
			args.add(vo.getDsIfSettle());
		}
		sql.append(" order by t.create_date desc ");
		return pageQuery.query(sql.toString(), args, vo,GoodsordermjkVo.class);

	}
	
	@Override
	public Page<GoodsordermjkVo> cgList(GoodsordermjkQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" 			t.publish_id, ");
		sql.append(" 			t.import_id, ");
		sql.append(" 			t.weight, ");
		sql.append(" 			t.qty, ");
		sql.append(" 			t.amount, ");
		sql.append(" 			t.status, ");
		sql.append(" 		    if(t.status = '10','新增',if(t.status = '20','已审核',if(t.status = '00','已作废',if(t.status = '30','待拼单',if(t.status = '40','已拼单','未知'))))) as statusDesc, ");
		sql.append(" 			t.platform_id, ");
		sql.append(" 		    t.create_date, ");
		sql.append(" 			t.limit_time, ");
		sql.append(" 			t.remark, ");
		sql.append(" 			t.depend_num, ");
		sql.append(" 			t.depend_num2, ");
		sql.append(" 			t.price, ");
		sql.append(" 			ifnull(t.start_plate,'') as startPlate, ");
		sql.append(" 			ifnull(t.get_order_plate,'') as getOrderPlate, ");
		sql.append(" 			ifnull(t.end_plate,'') as endPlate, ");
		sql.append(" 			ifnull(t.start_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLngDesc, ");
		sql.append(" 	        ifnull(t.start_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLatDesc, ");
		sql.append(" 	        ifnull(t.end_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as endPlateLngDesc, ");
		sql.append(" 	        ifnull(t.end_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as end_plateLatDesc, ");
		sql.append(" 	        ifnull(t.get_order_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLngDesc, ");
		sql.append(" 	        ifnull(t.get_order_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLatDesc, ");
		sql.append(" 			t.end_plate_address, ");
		sql.append(" 			t.get_order_plate_province, ");
		sql.append(" 			t.get_order_plate_city, ");
		sql.append(" 			t.get_order_plate_detail, ");
		sql.append(" 			t.start_plate_province, ");
		sql.append(" 			t.start_plate_city, ");
		sql.append(" 			t.start_plate_detail, ");
		sql.append(" 			t.ret_2 as ret2, ");
		sql.append(" 			t.sendKM, ");
		sql.append(" 			ifnull(t.sender,'') as sender, ");
		sql.append(" 			ifnull(t.sender_mobile,'') as senderMobile, ");
		sql.append(" 			t.receiver_mobile, ");
		sql.append(" 			t.receiver, ");
		sql.append(" 			t.good_type, ");
		sql.append(" 			t.from_type, ");
		sql.append(" 			t.batch_id, ");
		sql.append(" 			ifnull(t.good_type_desc,'') as goodTypeDesc, ");
		sql.append(" 			ifnull(t.bill_sender,'') as billSender, ");
		sql.append(" 			ifnull(t.bill_sender_mobile,'') as billSenderMobile, ");
		sql.append(" 			t.bill_taker, ");
		sql.append(" 			t.bill_taker_mobile, ");
		sql.append(" 			t.detachable, ");
		sql.append(" 			if(t.detachable = '1','可拆',if(t.detachable = '0','不可拆','未知')) as detachableDesc, ");
		sql.append(" 			t.heavy_piece, ");
		sql.append(" 			t.approve_time, ");
		sql.append(" 			t.approve_user_id, ");
		sql.append(" 			t.prod_desc, ");
		sql.append(" 			t.pin_dan_num, ");
		sql.append(" 			t.max_price, ");
		sql.append(" 			t.if_info_complete, ");
		sql.append(" 			if(t.if_info_complete = 'Y', '已完善','未完善') as ifInfoCompleteDesc, ");
		sql.append(" 			t.end_plate_province, ");
		sql.append(" 			t.end_plate_city, ");
		sql.append(" 			t.spilt_type, ");
		sql.append(" 			t.init_spilt_weight, ");
		sql.append(" 			t.single_car_weight, ");
		sql.append(" 			t.total_weight  , ");
		sql.append(" 			t.spilt_type , ");
		sql.append(" 		    t.loss_type, ");
		sql.append(" 		    t.loss_ratio, ");
		sql.append(" 		    t.good_price , ");
		sql.append(" 		    t.loss_weight, ");
		sql.append(" 		    t.js_type, ");
		sql.append(" 		    t.ds_if_settle, ");
		sql.append(" 		    t.end_plate_country, ");
		sql.append(" 		    t.price_tax, ");
		sql.append(" 		    t.prod_area, ");
		sql.append(" 		    ifnull(t.listing_price,0) as listingPrice, ");
		sql.append(" 		    ifnull(t.charge_price_type,0) as chargePriceType, ");
		sql.append(" 		    if(ifnull(t.charge_price_type,0)=0,'元/每车','元/吨') as chargePriceTypedesc, ");
		sql.append(" 		    ifnull(t.charge_price,0) as chargePrice, ");
		sql.append(" 		    t.appoint_team_id , ");
		sql.append(" 		    t.appoint_person_info as appointTeamName, ");
		sql.append(" 		    t.if_payment, ");
		sql.append(" 		    if(t.if_payment='Y','是','否') as ifPaymentDesc, ");
		sql.append(" 		    (select if(t.appoint_person_info is null,'2',if(locate('车牌号',t.appoint_person_info) > 0 and locate('手机号',t.appoint_person_info) > 0,'2','1'))) as appointType, ");
		sql.append(" 		    t.pick_up_goods_name, ");
		sql.append(" 		    t.logistics_mark, ");
		sql.append(" 		    t.end_plate_country, ");
		sql.append(" 		    t.get_order_plate_country, ");
		sql.append(" 		    t.start_plate_country, ");
		sql.append(" 		    t.if_tax_transport, ");
		sql.append(" 		    t.vat_flow_master_id, ");
		sql.append(" 		    t.estimateKM, ");
		sql.append(" 		    t.if_on_off, ");
		sql.append(" 		    t.catalog_id, ");
		sql.append(" 		    t.catalog_name, ");
		sql.append(" 		    t.contract_number,  ");
		sql.append(" 		    t.contract_type  ");
		sql.append(" 		FROM GoodsOrderMJK AS t , GoodsOrderMJKSetPlat t1 ");
		sql.append(" 		WHERE 1=1  ");
		sql.append(" 		and	? = t1.tms_platform_id ");
		args.add(vo.getPlatformId());
		sql.append(" 		and t1.tms_fd_company_id = ? ");
		args.add(vo.getCompanyId());
		sql.append(" 		and t.ret_1 = t1.ec_plat_name ");
		sql.append("  		and t.from_type  in ('JK_U9','JK_U8','JK_U10') ");	
		if("N".equals(vo.getIfShowAdmin())) {
			if("TMS".equals(vo.getAccountFrom())) {
				sql.append("and t.if_can_show ='Y' ");
			}
			if("DS".equals(vo.getAccountFrom())) {
				sql.append("and t.if_can_show ='N' and t.fd_user_id = ?");
				args.add(vo.getFdUserId());
			}
		}
		//采购维护的公司为空，如果已维护则只能自己看到
		sql.append("and ( t.company_id = "+ vo.getCompanyId() + " or t.company_id is null)");
		if("N".equals(vo.getIfAdmin())) {
			sql.append("and if(t.jk_level_flag='1',t.jk_operator_id," +vo.getFdUserId() + ") = " + vo.getFdUserId() );
		}
		
		if(!ObjectUtils.isEmpty(vo.getRemark())) {
			sql.append(" and t.remark like ? ");
			args.add("%" + vo.getRemark() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getOrderId())) {
			sql.append(" and t.publish_id like ? ");
			args.add("%" + vo.getOrderId() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getSeqId())) {
			sql.append(" and t.import_id like ? ");
			args.add("%" + vo.getSeqId() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getUserId())) {
			sql.append(" and t.user_id = ? ");
			args.add(vo.getUserId());
		}
		if(!ObjectUtils.isEmpty(vo.getGetOrderPlate())) {
			sql.append(" and t.get_order_plate like ? ");
			args.add("%" + vo.getGetOrderPlate() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getStartPlate())) {
			sql.append(" and t.start_plate like ? ");
			args.add("%" + vo.getStartPlate() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getBillNum())) {
			sql.append(" and t.ret_2 like ? ");
			args.add("%" + vo.getBillNum() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getEndPlate())) {
			sql.append(" and t.end_plate like ? ");
			args.add("%" + vo.getEndPlate() + "%");
		}
		if(vo.getRqStart() != null) {
			sql.append(" and t.create_date >= ? ");
			args.add(vo.getRqStart());
		}
		if( vo.getRqEnd() != null) {
			sql.append(" and t.create_date <= ? ");
			args.add(vo.getRqEnd());
		}
		if(vo.getPutInRqStart() != null) {
			sql.append(" and t.putin_date >= ? ");
			args.add(vo.getPutInRqStart());
		}
		if(vo.getPutInRqNnd() != null) {
			sql.append(" and t.putin_end <= ? ");
			args.add(vo.getPutInRqNnd());
		}
		if(!ObjectUtils.isEmpty(vo.getStatus())) {
			sql.append(" and t.status = ? ");
			args.add(vo.getStatus());
		}
		if(!ObjectUtils.isEmpty(vo.getIfClosed())) {
			sql.append(" and t.if_on_off = ? ");
			args.add(vo.getIfClosed());
		}
		if(!ObjectUtils.isEmpty(vo.getBillSenderMobile())) {
			sql.append(" and t.bill_sender_mobile = ? ");
			args.add(vo.getBillSenderMobile());
		}
		if(!ObjectUtils.isEmpty(vo.getBillSender())) {
			sql.append(" and t.bill_sender like ? ");
			args.add("%" + vo.getBillSender() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getSender())) {
			sql.append(" and t.sender like ? ");
			args.add("%" + vo.getSender() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getStuStr())) {
		
			sql.append(" and t.status in ( " + vo.getStuStr() + ")");
			
		}
		if(!ObjectUtils.isEmpty(vo.getImportIdStr())) {
			sql.append(" and t.status in ( " + vo.getImportIdStr() + ")");
		}
		if(!ObjectUtils.isEmpty(vo.getPinDanNum())) {
			sql.append("and t.pin_dan_num = ? ");
			args.add(vo.getPinDanNum());
		}
		if(!ObjectUtils.isEmpty(vo.getPinDan()) && "1".equals(vo.getPinDan())){
			sql.append(" and t.pin_dan_num is not null");
		}
		if(!ObjectUtils.isEmpty(vo.getPinDan()) && "2".equals(vo.getPinDan())){
			sql.append(" and t.pin_dan_num is  null");
		}
		
		if(!ObjectUtils.isEmpty(vo.getIfInfoComplete()) && "Y".equals(vo.getIfInfoComplete())){
			sql.append(" and  t.if_info_complete = 'Y'");
		}
		if(!ObjectUtils.isEmpty(vo.getIfInfoComplete()) && "N".equals(vo.getIfInfoComplete())){
			sql.append(" and  t.if_info_complete = 'N'");
		}
		if(!ObjectUtils.isEmpty(vo.getProdDesc())) {
			sql.append("and t.prod_desc like ? ");
			args.add("%" + vo.getProdDesc() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getGoodType())) {
			sql.append("and t.good_type = ? ");
			args.add(vo.getGoodType());
		}
		if(!ObjectUtils.isEmpty(vo.getGoodTypeDesc())) {
			sql.append("and t.good_type_desc  like ? ");
			args.add("%" + vo.getGoodTypeDesc() + "%");
		}
		if(!ObjectUtils.isEmpty(vo.getDsIfSettle())) {
			sql.append("and t.ds_if_settle =  ? ");
			args.add(vo.getDsIfSettle());
		}
		if (StringUtils.isNotEmpty(vo.getContractNumber())){
			sql.append("	and t.contract_number like ?");
			args.add("%"+vo.getContractNumber()+"%");
		}

		sql.append("  order by t.create_date desc");
		System.out.println("打印的sql为=========" +sql);
		return pageQuery.query(sql.toString(), args, vo,GoodsordermjkVo.class);

	}

	@Override
	public GoodsordermjkVo queryGoodOrderMJK(GoodsordermjkQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" 	t.publish_id,");
		sql.append(" 	t.import_id,");
		sql.append(" 	t.pin_dan_num,");
		sql.append(" 	t.start_plate_lng,");
		sql.append(" 	t.start_plate_lat,");
		sql.append(" 	t.weight,");
		sql.append(" 	t.init_spilt_weight,");
		sql.append(" 	t.qty,");
		sql.append(" 	t.amount,");
		sql.append(" 	t.remark,");
		sql.append(" 	t.price,");
		sql.append(" 	t.price_tax,");
		sql.append(" 	t.listing_price,");
		sql.append(" 	t.prod_area,");
		sql.append(" 	t.start_plate,");
		sql.append(" 	t.get_order_plate,");
		sql.append(" 	t.end_plate,");
		sql.append(" 	t.end_plate_detail,");
		sql.append(" 	t.start_plate_detail,");
		sql.append(" 	t.get_order_plate_detail,");
		sql.append(" 	t.end_plate_address,");
		sql.append(" 	ifnull(t.start_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLngDesc,");
		sql.append(" 	ifnull(t.start_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.start_plate_country and b.father_key_value=t.start_plate_city)) as startPlateLatDesc,");
		sql.append(" 	ifnull(t.end_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as endPlateLng,");
		sql.append(" 	ifnull(t.end_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.end_plate_country and b.father_key_value=t.end_plate_city)) as endPlateLat,");
		sql.append(" 	ifnull(t.get_order_plate_lng,(select b.lng from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLng,");
		sql.append(" 	ifnull(t.get_order_plate_lat,(select b.lat from basedata b WHERE b.key_value =t.get_order_plate_country and b.father_key_value=t.get_order_plate_city)) as getOrderPlateLat,");
		sql.append(" 	t.end_plate_address,");
		sql.append(" 	t.sendKM,");
		sql.append(" 	t.sender,");
		sql.append(" 	t.if_info_complete,");
		sql.append(" 	t.sender_mobile,");
		sql.append(" 	t.receiver_mobile,");
		sql.append(" 	t.receiver,");
		sql.append(" 	t.good_type,");
		sql.append(" 	t.good_type_desc,");
		sql.append(" 	t.estimateKM,");
		sql.append(" 	t.catalog_id,");
		sql.append(" 	t.catalog_name,");
		sql.append(" 	t.js_type,");
		sql.append(" 	t.ret_2,");
		sql.append(" 	t.detachable,");
		sql.append(" 	t.single_car_weight,");
		sql.append("	ifnull(t.approve_time,date_format(t.approve_time,'%Y-%m-%d %H:%i')) as approve_time,");
		sql.append("	t.approve_user_id,");
		sql.append(" 	t.heavy_piece,");
		sql.append(" 	t.ds_if_settle,");
		sql.append("	(select if(t.appoint_person_info is null,'2',if(locate('车牌号',t.appoint_person_info) > 0 and locate('手机号',t.appoint_person_info) > 0,'2','1'))) as appointType,");
		sql.append("	t.appoint_team_id as appointTeamId,");
		sql.append("	t.appoint_person_info as appointTeamName,");
		sql.append("	t.if_payment,");
		sql.append(" 	t.from_type,");
		sql.append(" 	t.bill_sender,");
		sql.append(" 	t.bill_sender_mobile,");
		sql.append(" 	t.max_price,");
		sql.append(" 	t.get_order_plate_province, ");
		sql.append(" 	t.get_order_plate_city, ");
		sql.append(" 	ifNull( t.get_order_plate_country, '' ) AS get_order_plate_country,");
		sql.append(" 	t.get_order_plate_detail, ");
		sql.append(" 	t.start_plate_province, ");
		sql.append(" 	t.start_plate_city, ");
		sql.append(" 	t.start_plate_detail, ");
		sql.append(" 	ifNull( t.start_plate_country, '' ) AS start_plate_country,");
		sql.append(" 	t.end_plate_province,");
		sql.append(" 	t.end_plate_city,");
		sql.append(" 	ifNull( t.end_plate_country, '' ) AS end_plate_country,");
		sql.append(" 	t.spilt_type,");
		sql.append(" 	t.loss_type,");
		sql.append(" 	t.good_price,");
		sql.append(" 	t.if_payment,");
		sql.append(" 	t.prod_desc,");
		sql.append(" 	ifNull(t.loss_weight,0)*1000 as loss_weight,");
		sql.append(" 	ifNull(t.loss_ratio,0)*1000 as loss_ratio,");
		sql.append(" 	t.pick_up_goods_name,");
		sql.append(" 	t.pickup_date,");
		sql.append(" 	t.appoint_team_type,");
		sql.append(" 	t.appoint_person_info,");
		sql.append(" 	t.charge_price,");
		sql.append(" 	t.send_group,");
		sql.append(" 	t.charge_price_type,");
		sql.append(" 	t.logistics_mark,");
		sql.append(" 	t.vat_flow_master_id,");
		sql.append(" 	ifnull(t.good_type_desc,'') as goodTypeDesc,");
		sql.append(" 	ifnull( t.listing_price, 0 ) AS listingPrice,");
		sql.append(" 	ifnull( t.charge_price, 0 ) AS chargePrice,");
		sql.append(" 	t.if_tax_transport, ");
		sql.append("    t.asds_mark, ");
		sql.append(" 	ifnull(t.add_weight_type,'N') as addWeightType ");
		sql.append("FROM ");
		sql.append(" 	GoodsOrderMJK AS t");
		if("JK_EC".equals(vo.getFromType())) {
			sql.append(" ,GoodsOrderMJKSetPlat t1 ");			
		}
		sql.append(" WHERE ");
		sql.append(" 	1 = 1 ");
		if("JK_EC".equals(vo.getFromType())) {
			sql.append(" 	AND t.platform_id = t1.tms_platform_id ");
			sql.append(" 	AND t.ret_1 = t1.ec_plat_name "); 	
		}
	
		// 平台id
		if(StringUtils.isNotEmpty(vo.getPlatformId()) && "JK_EC".equals(vo.getFromType())) {
			sql.append("	AND t1.tms_platform_id = ? "); 
			args.add(vo.getPlatformId());
		}
		// 公司id
		if(null != vo.getCompanyId() && "JK_EC".equals(vo.getFromType())) {
			sql.append(" 	AND t1.tms_fd_company_id = ? "); 
			args.add(vo.getCompanyId());
		}
		// 单据来源
		if(StringUtils.isNotEmpty(vo.getPlatformId())) {
			sql.append(" 	AND t.from_type = ? ");  
			args.add(vo.getFromType());
		}
		// 单据id
		if(null != vo.getImportId()) {
			sql.append(" 	AND t.import_id = ? "); 
			args.add(vo.getImportId());
		}
		sql.append(" 	ORDER BY ");
		sql.append(" 	t.create_date DESC ");
		List<GoodsordermjkVo> list = pageQuery.list(sql.toString(), args, GoodsordermjkVo.class);
		return ObjectUtils.isEmpty(list) ? new GoodsordermjkVo() : list.get(0);
	}

	@Override
	public Long findEntity(Long importId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT count(1) from goodsordermjk a ");
		sql.append(" WHERE a.import_id = ? ");
		sql.append("	and NOT EXISTS ( ");
		sql.append("		select 1 from goodsorderm g ");
		sql.append("			where g.`depend_num` = a.ret_2  ");
		sql.append("			and g.status = '20' ");
		sql.append("			and g.from_type = 'DS' ");
		sql.append("			and g.platform_id = (select s.tms_platform_id ");
		sql.append("				from goodsordermjksetplat s ");
		sql.append("				where s.ec_plat_name = a.ret_1 ");
		sql.append("				limit 0, 1))");
		args.add(importId);
		Long count = pageQuery.count(sql.toString(), args.toArray());
		return count;
	}


	@Override
	public List<TeamCompanyVo> queryPushUser(String platformId ,String appointTeamId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select c.user_id  userId,");
		sql.append("	c.platform_id  platformId,");
		sql.append("	c.client_id	clientId ");
		sql.append("from ViewGeTuiUsers c,TeamCompany b ");
		sql.append("where c.platform_id = ? ");
		sql.append("	and	  c.company_id = b.cy_company_id ");
		sql.append("	and	  b.team_id = ? ");
		args.add(platformId);
		args.add(appointTeamId);
		List<TeamCompanyVo> list = pageQuery.list(sql.toString(),args, TeamCompanyVo.class);
		return list;
	}

	@Override
	public void saveContractNumber(String platformId,Long importId,String contractNumber) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" update goodsordermjk t1,goodsorderm t2 ");
		sql.append(" set t1.contract_number=?,t2.contract_number=?  ");
		args.add(contractNumber);
		args.add(contractNumber);
		sql.append(" where t1.import_id=t2.import_id and t1.platform_id=t2.platform_id ");
		sql.append(" and t1.import_id=? ");
		args.add(importId);
		jdbcTemplate.update(sql.toString(), args.toArray());
	}

	@Override
	public void saveContractNumber1(String platformId,Long importId,String contractNumber,String contractType) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" update goodsordermjk t1 ");
		sql.append(" set t1.contract_number=? ");
		args.add(contractNumber);
		sql.append("	, t1.contract_type = ?");
		args.add(contractType);
		sql.append(" where t1.import_id=? ");
		args.add(importId);
		jdbcTemplate.update(sql.toString(), args.toArray());
	}

	@Override
	public void saveContractNumber2(String platformId,Long importId,String contractNumber) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" update goodsorderm t1 ");
		sql.append(" set t1.contract_number=? ");
		args.add(contractNumber);
		sql.append(" where t1.import_id=?  and t1.platform_id=? ");
		args.add(importId);
		args.add(platformId);
		jdbcTemplate.update(sql.toString(), args.toArray());
	}
	
}
