package com.brcc.business.goodsorderm.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.repository.IGoodsordermRepository;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.esteel.common.dao.PageQuery;


/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午9:05:12
* @Description 货源单数据查询数据库
*/
public class GoodsordermRepositoryImpl implements IGoodsordermRepository {
	
	@Autowired
	PageQuery pageQuery;
	
	@Autowired
	PageQuery readPageQuery;


	@Override
	public Page<GoodsordermVo> findAllPage(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select t.* from apptms.goodsorderm t");
		sql.append(" where 1=1 ");
		// 货源单id
		if(!ObjectUtils.isEmpty(vo.getPublishId())) {
			sql.append(" and t.publish_id = ? ");
			args.add(vo.getPublishId());
		}
		sql.append(" order by t.create_date desc ");
		return pageQuery.query(sql.toString(), args, vo,GoodsordermVo.class);
	}

	@Override
	public Page<GoodsordermVo> getGoodOrderBillPage(GoodsordermQueryVo vo) {
		return null;
	}

	@Override
	public GoodsordermEntity queryEntity(GoodsordermQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	distinct t.if_tax_transport "); 
		sql.append("FROM ");
		sql.append("	goodsorderm t ");
		sql.append("WHERE t.import_id = ? ");
		sql.append("	AND t.status != '00' ");
		sql.append("	AND t.from_type = 'JK_U8' ");
		sql.append("	AND t.platform_id = ? ");
		args.add(queryVo.getImportId());
		args.add(queryVo.getPlatformId());
		List<GoodsordermEntity> list = pageQuery.list(sql.toString(), args, GoodsordermEntity.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}
	
	@Override
	public Long queryAllSameGoodsorderm(GoodsordermVo entity) {
	   StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select count(1) from ");
		sql.append("goodsorderm m ");
		sql.append("where m.get_order_plate_province = ? ");
		args.add(entity.getGetOrderPlateProvince());
		sql.append("and m.get_order_plate_city = ? ");
		args.add(entity.getGetOrderPlateCity());
		sql.append("and m.get_order_plate_country = ? ");
		args.add(entity.getGetOrderPlateCountry());
		sql.append("and m.end_plate_province = ? ");
		args.add(entity.getEndPlateProvince());
		sql.append("and m.end_plate_city = ? ");
		args.add(entity.getEndPlateCity());
		sql.append("and m.end_plate_country = ? ");
		args.add(entity.getEndPlateCountry());
		sql.append("and m.init_weight = ? ");
		args.add(entity.getInitWeight());
		sql.append("and m.init_amount = ? ");
		args.add(entity.getInitAmount());
		sql.append("and m.company_id = ? ");
		args.add(entity.getCompanyId());
		sql.append("and m.platform_id =?");
		args.add(entity.getPlatformId());
		/*sql.append("and m.status > '00'");
		sql.append("and m.status < '30'");*/
		sql.append("and m.status = '10'");
		sql.append("and m.create_date >= ?");
		args.add(entity.getRqStart());
		return pageQuery.count(sql.toString(), args.toArray());
	}
	
	@Override
	public Long queryAllSameAddressNewGoodsorderm(GoodsordermVo entity) {
	   StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select count(1) from ");
		sql.append("goodsorderm m ");
		sql.append("where m.get_order_plate = ? ");
		args.add(entity.getGetOrderPlateProvince() == entity.getGetOrderPlateCity() ? entity.getGetOrderPlateProvince() + entity.getGetOrderPlateCountry() + entity.getGetOrderPlate():entity.getGetOrderPlateProvince() + entity.getGetOrderPlateCity()+ entity.getGetOrderPlateCountry() + entity.getGetOrderPlate());
		sql.append("	and m.start_plate = ? ");
		args.add(entity.getStartPlateProvince() == entity.getStartPlateCity() ? entity.getStartPlateProvince() + entity.getStartPlateCountry() + entity.getStartPlate():entity.getStartPlateProvince() + entity.getStartPlateCity()+ entity.getStartPlateCountry() + entity.getStartPlate());
		sql.append("	and  m.end_plate = ? ");
		args.add(entity.getEndPlateProvince() == entity.getEndPlateCity() ? entity.getEndPlateProvince() + entity.getEndPlateCountry() + entity.getEndPlate():entity.getEndPlateProvince() + entity.getEndPlateCity()+ entity.getEndPlateCountry() + entity.getEndPlate());
		sql.append("	and m.good_type= ?");
		args.add(entity.getGoodType());
		sql.append("	and m.bill_taker= ?");
		args.add(entity.getBillTaker());
		sql.append("	and m.bill_taker_mobile = ?");
		args.add(entity.getBillTakerMobile());
		sql.append("	and m.receiver = ?");
		args.add(entity.getReceiver());
		sql.append("	and m.receiver_mobile = ?");
		args.add(entity.getReceiverMobile());
		sql.append("	and m.sender = ?");
		args.add(entity.getSender());
		sql.append("	and m.sender_mobile = ?");
		args.add(entity.getSenderMobile());	
		sql.append("	and m.company_id = ? ");
		args.add(entity.getCompanyId());
		sql.append("	and m.platform_id =?");
		args.add(entity.getPlatformId());
		sql.append("	and m.status = '10'");
		sql.append("	and m.if_tax_transport = ?");
		args.add(entity.getIfTaxTransport());
		return pageQuery.count(sql.toString(), args.toArray());
	}
	
	@Override
	public GoodsordermVo queryGoodPrice(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	t.publish_id,");
		sql.append("	t.price,");
		sql.append("	t.good_price,");
		sql.append("    t.loss_type,");
		sql.append("    t.loss_ratio,");
		sql.append("    t.loss_weight,");
		sql.append("    t.publish_id,");
		sql.append("    t.status ");
		sql.append("FROM ");
		sql.append("	goodsorderm t ");
		sql.append("WHERE ");
		sql.append("  t.publish_id = ? ");
		sql.append("  and t.platform_id = ? ");
		sql.append("  and t.pickup_date >= now();");
		args.add(vo.getPublishId());
		args.add(vo.getPlatformId());
		List<GoodsordermVo> list = pageQuery.list(sql.toString(), args, GoodsordermVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public Page<GoodsordermVo> queryGrabList(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	t.publish_id,");
		sql.append("	t.company_id,");
		sql.append("	t.weight,");
		sql.append("	t.qty,");
		sql.append("	t.amount,");
		sql.append("	t.init_weight,");
		sql.append("	t.init_qty,");
		sql.append("	cast(t.init_amount as decimal(18,2)) as init_amount,");
		sql.append("	t.`status`,");
		sql.append("	t.platform_id,");
		sql.append("	t.create_date ,");
		sql.append("	t.pickup_date ,");			
		sql.append("	t.price,");
		sql.append("	t.start_plate,");
		sql.append("	t.prod_desc,");
		sql.append("	t.good_type_desc,");
		sql.append("	t.end_plate,");
		sql.append("	t.get_order_plate,");
		sql.append("	'' as publish_num,");
		sql.append("	t.qb_type,");
		sql.append("	ifnull(t.floor_price ,t.price) as floor_price,");
		sql.append("	t.bid_times,");
		sql.append("	t.max_price,");
		sql.append("	t.appoint_team_type,");
		sql.append("	t.is_auto_to_trans,");
		sql.append("	t.detachable,");
		sql.append("	t.docu_type,");
		sql.append("	t.docu_pri_sec,");
		sql.append("	t.single_car_weight,");
		sql.append("    IF(IFNULL(s.switch_value, '0') = '1',");
		sql.append("       IF(cp.if_grab_money = 'Y', 'Y', 'N'),");
		sql.append("        'N') AS ifGrabMoney,");
		sql.append("    IFNULL(cp.grab_money, 0) AS grabMoney,");
		sql.append("    t.standard_tax as 'standardTax',");
		sql.append("    t.price_tax as 'priceTax',");
		sql.append(" 	t.if_tax_transport as 'ifTaxTransport',");
		sql.append(" 	t.vat_flow_master_id as 'vatFlowMasterId',");
		sql.append("	t.depend_num as 'dependNum',");
		sql.append("	t.business_mode as 'businessMode',");
		sql.append("	t.rob_delivery_type as 'robDeliveryType',");
		sql.append("	t.from_type as 'fromType'");
		sql.append("FROM GoodsOrderM AS t ");
		sql.append("	LEFT JOIN ");
		sql.append("apptms.company cp ON (t.company_id = cp.seq_id) ");
		sql.append("    LEFT JOIN ");
		sql.append("apptms.switchconfig s ON (cp.platform_id = s.plat_form_id ");
		sql.append("    AND s.switch_type = 'DS_GRAB_ONEY') ");
		sql.append("WHERE 1=1 ");
		sql.append("AND t.platform_id = ? ");
		sql.append("AND t.status = '20' ");
		sql.append("AND (select count(1) ");
		sql.append("		from Company c ,member_level m ");
		sql.append("		where c.seq_id = ? ");
		sql.append("		and c.status = '20'	");
		sql.append("		and ifnull(c.if_freeze, '0') != '1' ");
		sql.append("		AND c.member_level = m.level_id ");
		sql.append("   		AND DATE_ADD(t.create_date, ");
		sql.append("   		INTERVAL m.delay_grab_time HOUR_SECOND) < NOW() ");
		sql.append("	) = 1 ");
		//sql.append("and ifnull(send_group,'ALL') in ('WEB' ,'ALL') ");
		sql.append("and ifnull(t.web_can_grab, 'Y') = 'Y'");
		sql.append("and (if( (select c.if_broker_people_flag from company c where  c.seq_id = ? and c.if_transport ='Y')='N',ifnull(send_group, 'ALL') IN ('WEB', 'ALL'), ifnull(send_group, 'ALL') IN ( 'ALL','JJR')))");		
		sql.append("and t.pickup_date > NOW() ");
		sql.append("and t.weight > 0  ");
		sql.append("and t.dq_end_date < NOW() ");  
		sql.append("and	if(ifnull(t.appoint_team_id,'') = '' ,'zb' , t.appoint_team_id) = if(ifnull(t.appoint_team_id,'') = '' ,'zb' ,");
		sql.append("														(select t1.team_id ");
		sql.append("														from TeamCompany t1 ");
		sql.append("														where t.appoint_team_id = t1.team_id ");
		sql.append("														and t.platform_id = t1.platform_id ");
		sql.append("														and t1.cy_company_id = ? ");
		sql.append("														limit 0,1))");
		args.add(vo.getPlatformId());
		args.add(vo.getCompanyId());
		args.add(vo.getCompanyId());
		args.add(vo.getCompanyId());
		//货源查看方式
		if (!("0").equals(vo.getGoodsSet())){
			sql.append("	and t.company_id in (SELECT c.company_id FROM broker_company_relation c WHERE c.broker_id = ? ");
			args.add(vo.getCompanyId());
			sql.append("	AND c.display = 'Y')");
		}
		// 货源单号
		if(null != vo.getPublishId()) {
			sql.append("AND t.publish_id like ? ");
			args.add("%" + vo.getPublishId() + "%");
		}
		// 业务单据号id
		if(StringUtils.isNotEmpty(vo.getDependNum())) {
			sql.append("AND t.depend_num like ? ");
			args.add("%" + vo.getDependNum() + "%");
		}
		// 取单地     
		if(StringUtils.isNotEmpty(vo.getGetOrderPlate())) {
			sql.append("AND t.get_order_plate like ? ");
			args.add("%" + vo.getGetOrderPlate() + "%");
		}     
		// 起始地  
		if(StringUtils.isNotEmpty(vo.getStartPlate())) {
			sql.append("AND t.start_plate like ? ");
			args.add("%" + vo.getStartPlate() + "%");
		}
		// 目的地 
		if(StringUtils.isNotEmpty(vo.getEndPlate())) {
			sql.append("AND t.end_plate like ? ");
			args.add("%" + vo.getEndPlate() + "%");
		}
		// 创建时间起
		if(null != vo.getRqStart()) {
			sql.append("AND t.create_date >= ? ");
			args.add(vo.getRqStart());
		}
		// 创建时间止
		if(null != vo.getRqEnd()) {
			sql.append("AND t.create_date <= ? ");
            args.add(vo.getRqEnd());
		}
		// 大品种搜索
		if(null != vo.getCatalogId()) {
			sql.append("AND exists(select 1 from catalog c where c.parent_id= ? and c.id=t.good_type) ");
			args.add(vo.getCatalogId());
		}	
		sql.append("order by ");
		sql.append("if(t.docu_type='1'|| t.docu_type='2',");
		sql.append("	if(t.docu_pri_sec='1',");
		sql.append("			t.publish_id ,");
		sql.append("			t.pri_publish_id");
		sql.append("		) ");
		sql.append("	, t.publish_id ");
		sql.append(") desc,");
		sql.append("if(t.docu_type='1'|| t.docu_type='2',");
		sql.append("	t.docu_pri_sec*-1,");
		sql.append("	t.publish_id) desc");
		return readPageQuery.query(sql.toString(), args, vo,GoodsordermVo.class);
	}
	
	@Override
	public GoodsordermVo queryTaxTransportInfo(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT  ");
		sql.append("    t.standard_tax,");
		sql.append("    t.price_tax,");
		sql.append("    t.if_tax_transport,");
		sql.append("    t.vat_flow_master_id,");
		sql.append("    d.vat_rate_chose,");
		sql.append("    d.vat_standard_rate,");
		sql.append("    d.vat_policy_rate, ");
		sql.append("    d.vat_acc_type ");
		sql.append("FROM ");
		sql.append("    apptms.goodsorderm t  ");
		sql.append("    left join vatflowdetail d on (t.vat_flow_master_id = d.vat_flow_master_id and d.if_begin = 'Y') ");
		sql.append("WHERE ");
		sql.append("    t.publish_id = ? ");
		args.add(vo.getPublishId());
		List<GoodsordermVo> list = readPageQuery.list(sql.toString(),args,GoodsordermVo.class);
		return ObjectUtils.isEmpty(list) ? new GoodsordermVo() : list.get(0);	
	};
		
	@Override
	public GoodsordermVo queryIsHas(Long publishId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("select  ");
		sql.append("	a.weight , ");
		sql.append("	IFNULL((select sum(b.weight)  ");
		sql.append("			from TransportationM b  ");
		sql.append("			where a.publish_id = b.publish_id),0) as transWeight ");
		sql.append("from GoodsOrderM a  ");
		sql.append("where ");
		sql.append("	a.publish_id = ? ");
		sql.append("	and a.status !='00' ");
		sql.append("	and a.status !='30' ");
		sql.append("for update ");
		args.add(publishId);
		List<GoodsordermVo> list = pageQuery.list(sql.toString(),args,GoodsordermVo.class);
		return ObjectUtils.isEmpty(list) ? new GoodsordermVo() : list.get(0);			
	}

	@Override
	public List<GoodsordermVo> queryHasChildGood(Long publishId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	if(a.detachable=1, a.single_car_weight ,a.weight)  as grabWeight,");
		sql.append("	a.weight,");
		sql.append("    if(a.detachable=1, if(ceil(a.init_qty / (a.init_weight / a.single_car_weight)) > a.qty,  a.qty,  ceil(a.init_qty / (a.init_weight / a.single_car_weight))) , a.weight) as grabQty,");
		sql.append("	concat(a.price,'')	as	outPrice,");
		sql.append("	concat(a.floor_price,'') as floorPrice,");
		sql.append("	a.publish_id ");
		sql.append("FROM ");
		sql.append("	goodsorderm a ");
		sql.append("WHERE ");
		sql.append("	a.pri_publish_id = ? ");
		sql.append("AND IFNULL(a.docu_type, '0') in ('1','2') ");
		sql.append("AND ifnull(docu_pri_sec, 'zb') = '2' ");
		args.add(publishId);
		return pageQuery.list(sql.toString(),args,GoodsordermVo.class);
	}
	
	@Override
	public GoodsordermVo getGoodsordermDetail(Long publishId,String platformId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("   select t.appoint_person_info,");
		sql.append("	t.is_auto_to_trans,");
		sql.append("	t.web_can_grab,");
		sql.append("	t.publish_id,");
		sql.append("	t.weight,");
		sql.append("	t.qty,");
		sql.append("	t.amount,");
		sql.append("	t.status,");
		sql.append("	t.platform_id,");
		sql.append("	t.create_date,");
		sql.append("	t.take_delivery_date,");
		sql.append("	t.pickup_date,");
		sql.append("	if(t.pickup_date < now(),'Y','N') as isTimeOut,");
		sql.append("	t.limit_time,");
		sql.append("	t.ps as remark,");
		sql.append("	t.depend_num,");
		sql.append("	t.price,");
		sql.append("	t.start_plate,");
		sql.append("	t.end_plate,");
		sql.append("	t.from_type,");
		sql.append("	t.prod_desc,");
		sql.append("	t.init_qty,");
		sql.append("	t.init_amount ,");
		sql.append("	t.get_order_plate,");
		sql.append("	t.good_type_desc,");
		sql.append("	t.good_type,");
		sql.append("	t.init_weight,");
		sql.append("	t.sendKM,");
		sql.append("	t.sender, ");
		sql.append("	t.sender_mobile, ");
		sql.append("	t.receiver_mobile, ");
		sql.append("	t.receiver,");
		sql.append("	t.bill_sender,");
		sql.append("	t.bill_sender_mobile, ");
		sql.append("	t.bill_taker, ");
		sql.append("	t.bill_taker_mobile,");
		sql.append("	SUBSTRING(t.vehicle_style_var,1,INSTR(t.vehicle_style_var, '-')-1) as vehicleStyleVar,");
		sql.append("	t.prod_desc, ");
		sql.append("	t.heavy_piece,");
		sql.append("	t.good_price,");
		sql.append("	t.loss_type,");
		sql.append("	ifnull(t.loss_ratio,0) * 1000 as lossRatio,");
		sql.append("	ifnull(t.loss_weight,0) * 1000 as lossWeight,");
		sql.append("	t.detachable,");
		sql.append("	t.start_plate_province,");
		sql.append("	t.start_plate_city,");
		sql.append("	t.start_plate_country,");
		sql.append("	t.get_order_plate_province,");
		sql.append("	t.get_order_plate_city,");
		sql.append("	t.get_order_plate_country,");
		sql.append("	t.end_plate_province,");
		sql.append("	t.end_plate_city,");
		sql.append("	t.end_plate_country,");
		sql.append("	t.departure_lng,");
		sql.append("	t.departure_lat,");
		sql.append("	t.destination_lng,");
		sql.append("	t.destination_lat,");
		sql.append("	t.get_order_address_lng,");
		sql.append("	t.get_order_address_lat,");
		sql.append("	t.detachable,");
		sql.append("	t.single_car_weight,");
		sql.append("	if(t.detachable = 0,'不可拆',if(t.detachable = 1,'可拆','不可拆')) as detachableDesc,");
		sql.append("	t.depend_num,");
		sql.append("	'' as publish_num,");
		sql.append("	t.sale_weight,");
		sql.append("	t.sale_weight as billWeight,");
		sql.append("	if(t.appoint_company_id='','N','Y')  appointFlag,");
		sql.append("	t.qb_type,");
		sql.append("	t.max_price,");
		sql.append("	(SELECT t1.company_name FROM company t1 where t1.seq_id = t.company_id and t1.platform_id = t.platform_id) as consignorName,");
		sql.append("	(SELECT t1.contact_mobile FROM company t1 where t1.seq_id = t.company_id and t1.platform_id = t.platform_id) as consignorNameMobile,");
		sql.append("	t.appoint_team_type,");
		sql.append("	t.estimateKM,");
		sql.append("	t.appoint_team_id,");
		sql.append("	t.send_group as sendGroupType,");
		sql.append("	(SELECT t1.team_name FROM teamcompany t1 where t1.team_id = t.appoint_team_id limit 0,1) as appointTeamName,");
		sql.append("	if(ifnull(t.send_group,'') = 'ALL','全部', if(ifnull(t.send_group,'') = 'WEB','物流公司',if(ifnull(t.send_group,'') = 'JJR','经纪人',if(ifnull(t.send_group,'') = 'APP','司机',''))))as sendGroup,");
		sql.append("	t.ps2,");
		sql.append("	t.ps3,");
		sql.append("	t.ps4,");
		sql.append("	t.ps5,");
		sql.append("	t.ps1,");
		sql.append("	t.ps,");
		sql.append("	t.company_id as fdCompanyId,");
		sql.append("	t.docu_pri_sec,");
		sql.append("	t.docu_type,");
		sql.append("	t.pin_dan_num,");
		sql.append("	t.ds_if_settle ,");
		sql.append("	t.if_tax_transport,");
		sql.append("	t.price_tax,");
		sql.append("	t.vat_flow_master_id,");
		sql.append("	t.listing_price ,");
		sql.append("	t.contract_number,");
		sql.append("	if(ifnull(t.charge_price_type,0)=0,'元/每车','元/吨') as chargePriceType,");
		sql.append("       ifnull(t.charge_price,0) as chargePrice,");
		sql.append("       t.pick_up_goods_name ,");
		sql.append("       t.bill_taker_mobile,");
		sql.append("       t.good_price,");
		sql.append("       t.is_auto_display,");
		sql.append("       t.appoint_team_type,");
		sql.append("       t.business_mode,");
		sql.append("       t.max_trans_days,");
		sql.append("       (select if(t.appoint_person_info is null,'1',if(locate('车牌号',t.appoint_person_info) > 0 and locate('手机号',t.appoint_person_info) > 0,'2','1'))) as appointType");
		sql.append("  FROM goodsorderm as t");
		sql.append("  WHERE 1=1");
		sql.append("  and t.platform_id = ?");
		args.add(platformId);
		sql.append(" and t.status='10'");
		sql.append("  and t.publish_id = ?");
		args.add(publishId);
		sql.append(" and t.if_save_publish='1'");
		List<GoodsordermVo> list = pageQuery.list(sql.toString(),args,GoodsordermVo.class);
		return ObjectUtils.isEmpty(list) ? new GoodsordermVo() : list.get(0);		
	}

}
