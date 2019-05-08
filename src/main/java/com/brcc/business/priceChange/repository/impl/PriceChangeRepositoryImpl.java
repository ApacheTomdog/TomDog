package com.brcc.business.priceChange.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.brcc.business.priceChange.repository.IPriceChangeRepository;
import com.brcc.business.priceChange.vo.CompanyVo;
import com.brcc.business.priceChange.vo.PriceChangeQueryVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import com.esteel.common.dao.PageQuery;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public class PriceChangeRepositoryImpl implements IPriceChangeRepository{
	@Autowired
	PageQuery pageQuery;

	@Override
	public Page<PriceChangeVo> listDataPage(PriceChangeQueryVo queryvo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" t.appoint_person_info,");
		sql.append(" t.publish_id, ");
		sql.append(" t.weight, ");
		sql.append(" t.qty, ");
		sql.append(" t.amount, ");
		sql.append(" t.status, ");
		sql.append(" t.platform_id, ");
		sql.append(" c.company_name, ");
		sql.append(" date_format(t.create_date,'%Y-%m-%d %H:%i') as create_date , ");
		sql.append(" date_format(t.create_date,'%Y-%m-%d %H:%i:%s') as createDate , ");
		sql.append(" date_format(t.pickup_date,'%Y-%m-%d %H:%i') as pickup_date , ");
		sql.append(" if(t.pickup_date < now(),'Y','N') as isTimeOut,");
		sql.append(" t.limit_time, ");
		sql.append(" t.ps as remark, ");
		sql.append(" t.depend_num, ");
		sql.append(" round(t.price, 2) as price, ");
		sql.append(" t.start_plate, ");
		sql.append(" t.end_plate,  ");
		sql.append(" t.from_type, ");
		sql.append(" t.prod_desc, ");
		sql.append(" t.init_qty, ");
		sql.append(" t.init_amount, ");
		sql.append(" t.get_order_plate, ");
		sql.append(" t.good_type_desc, ");
		sql.append(" t.init_weight,  ");
		sql.append(" t.sendKM,");
		sql.append(" t.sender, ");
		sql.append(" t.sender_mobile,  ");
		sql.append(" t.receiver_mobile, ");
		sql.append(" t.receiver, ");
		sql.append(" t.bill_sender, ");
		sql.append(" t.bill_sender_mobile, ");
		sql.append(" t.bill_taker, ");
		sql.append(" t.bill_taker_mobile, ");
		sql.append(" t.vehicle_style_var, ");
		sql.append(" t.prod_desc, ");		
		sql.append(" t.heavy_piece, ");
		sql.append(" t.good_price, ");
		sql.append(" t.loss_type, ");		
		sql.append(" t.loss_ratio, ");
		sql.append(" t.loss_weight, ");
		sql.append(" t.detachable, ");
		sql.append(" if(t.detachable = 0,'不可拆',if(t.detachable = 1,'可拆','不可拆')) as detachable_desc, ");
		sql.append(" t.depend_num2, ");		
		sql.append(" '' as publish_num, ");
		sql.append(" t.sale_weight, ");
		sql.append(" t.sale_weight as bill_weight, ");
		sql.append(" if(t.appoint_company_id='','N','Y')  \"appoint_flag\", ");
		sql.append(" t.qb_type,");
		sql.append(" c.contact_mobile  as \"consignor_name_phone\",");
		sql.append(" t.appoint_team_type,");
		sql.append(" t.estimateKM,");
		sql.append(" t.appoint_team_id,");
		sql.append(" t.send_group as send_group_type,");
		/*sql.append(" (SELECT t1.team_name FROM TeamCompany t1 where t1.team_id = t.appoint_team_id limit 0,1) as appoint_team_name,");
		sql.append(" if(ifnull(t.send_group,'') = 'ALL','全部', if(ifnull(t.send_group,'') = 'WEB','WEB用户',if(ifnull(t.send_group,'') = 'APP','手机APP用户',''))) as send_group,");*/
		sql.append(" t.ps2,");
		sql.append(" t.ps3,");
		sql.append(" t.ps4,");
		sql.append(" t.ps5,");
		sql.append(" t.ps1,");
		sql.append(" t.company_id,");
		sql.append(" t.docu_pri_sec,");
		sql.append(" t.docu_type,");
		sql.append(" t.pin_dan_num");
		sql.append(" t.ds_if_settle as \"dsIfSettle\",");
		sql.append(" if(t.ds_if_settle=0,'否','是') as \"dsIfSettleDesc\",");
		sql.append(" t.if_tax_transport,");
		sql.append(" if(t.if_tax_transport='Y','是','否') as \"ifTaxTransportDesc\",");
		sql.append(" t.vat_flow_master_id,");
		sql.append(" t.listing_price as \"listingPrice\",");
		sql.append(" t.dq_flag,");
		sql.append(" if(t.loss_type='1','定额','定率') as \"loss_type_desc\",");
		sql.append(" if(t.loss_type='1',CONCAT(t.loss_weight*1000,'（kg/车）'),CONCAT(t.loss_ratio*1000,'（‰/车）')) as \"loss_weight_desc\"");
		sql.append(" FROM  goodsorderm t,company c");
		sql.append(" WHERE t.company_id = c.seq_id");
		sql.append(" and t.platform_id = ? ");
		params.add(queryvo.getPlatformId());
		sql.append(" and t.if_tax_transport = 'Y'");
		sql.append("  and t.status = '10'");
		sql.append(" and t.if_audit = '1'");
		params.add(queryvo.getClientId());//user.getCompanyId
		/*if (!ObjectUtils.isEmpty(queryvo.getPublishId())) {
			sql.append(" and t.publish_id like ? ");
			params.add(queryvo.getPublishId());
		}
		if (!ObjectUtils.isEmpty(queryvo.getRqStart())) {
			sql.append(" AND t.create_date >=  STR_TO_DATE(CONCAT( ? ,' 00:00'),'%Y-%m-%d %H:%i') ");
			params.add(queryvo.getRqStart());
		}
		if (!ObjectUtils.isEmpty(queryvo.getRqEnd())) {
			sql.append(" AND t.create_date <= STR_TO_DATE(CONCAT( ? ,' 23:59'),'%Y-%m-%d %H:%i') ");
			params.add(queryvo.getRqEnd());
		}*/
		/*// 开始时间
		if (!ObjectUtils.isEmpty(queryvo.getRqStart())) {
			sql.append(" AND DATE_FORMAT(b.CREATE_DATE,'%Y-%m-%d') >= ? ");
			params.add(queryvo.getRqStart());
		}
		// 结束时间
		if (!ObjectUtils.isEmpty(queryvo.getRqEnd())) {
			sql.append(" AND DATE_FORMAT(b.CREATE_DATE,'%Y-%m-%d') <= ? ");
			params.add(queryvo.getRqEnd());
		}*/		
		/*if (!StringUtils.isEmpty(queryvo.getClientName())) {
			sql.append(" and client_name like  ? ");
			params.add("%" + queryvo.getClientName() + "%");
		}*/
		sql.append("order by t.create_date desc ");		
		Page<PriceChangeVo> page = pageQuery.query(sql.toString(), params, queryvo, PriceChangeVo.class);
		return page;
	}

	@Override
	public Page<PriceChangeVo> queryList(PriceChangeQueryVo queryvo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" p.price_change_id, ");
		sql.append(" p.platform_id, ");
		sql.append(" p.publish_id, ");
		sql.append(" p.price_change_type, ");
		sql.append(" p.client_id, ");
		sql.append(" p.client_name, ");
		sql.append(" p.carry_id, ");
		sql.append(" p.carry_name, ");
		sql.append(" p.price_change_status,");
		sql.append(" p.client_price, ");
		sql.append(" p.carry_price, ");
		sql.append(" p.diff_price,");
		sql.append(" p.create_date, ");
		sql.append(" p.create_person_id, ");
		sql.append(" p.create_person_name, ");
		sql.append(" p.modify_person_id, ");
		sql.append(" p.modify_person_name, ");
		sql.append(" p.modify_date ");
		sql.append(" FROM ");
		sql.append(" price_change p ");
		sql.append(" where 1=1 ");
		sql.append(" AND p.platform_id = ? ");
		params.add(queryvo.getPlatformId());
		sql.append(" AND p.carry_id = ? ");
		params.add(queryvo.getCarryId());
		if (!ObjectUtils.isEmpty(queryvo.getPublishId())) {
			sql.append(" and p.publish_id like ? ");
			params.add(queryvo.getPublishId());
		}		
		// 开始时间
		if (!ObjectUtils.isEmpty(queryvo.getRqStart())) {
			sql.append(" AND p.CREATE_DATE >= ? ");
			params.add(queryvo.getRqStart());
		}
		// 结束时间
		if (!ObjectUtils.isEmpty(queryvo.getRqEnd())) {
			sql.append(" AND p.CREATE_DATE < ? ");
			params.add(queryvo.getRqEnd());
		}	

		sql.append("order by p.create_date desc ");
		
		Page<PriceChangeVo> page = pageQuery.query(sql.toString(), params, queryvo, PriceChangeVo.class);
		return page;
	}

	@Override
	public CompanyVo getCompany(Long publishId) {

		 List<Object> args = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select c.seq_id as clientId,c.company_name as clientName from apptms.goodsorderm g,company c ");
        sql.append(" where g.publish_id = ? and g.company_id = c.seq_id ");
        args.add(publishId);
        List<CompanyVo> list = pageQuery.list(sql.toString(), args, CompanyVo.class);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
      
	}

}
