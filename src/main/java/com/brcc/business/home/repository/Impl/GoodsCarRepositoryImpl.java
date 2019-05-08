package com.brcc.business.home.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.home.repository.IGoodsCarRepository;
import com.brcc.business.home.vo.GoodsCarQueryVo;
import com.brcc.business.home.vo.GoodsCarVo;
import com.esteel.common.dao.PageQuery;

public class GoodsCarRepositoryImpl implements IGoodsCarRepository{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PageQuery pageQuery;
	
	@Override
	public Page<GoodsCarVo> goodsCarRepository(GoodsCarQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("  SELECT g.publish_id,"
				+ "if(g.detachable='1','可拆','不可拆') as detachable,"
				+ "CONCAT(LEFT(g.bill_sender_mobile,3),'****',RIGHT(g.bill_sender_mobile,4)) as mobile,"
				+ " if(g.from_type='DS',g.bill_sender,c.company_name) as bill_sender,	"
				+ "FORMAT(ROUND(if(g.detachable='1',g.single_car_weight,g.weight)*g.price,0),0) as amount,"
				+ "FORMAT(ROUND(g.price,0),0)as price,"
				+ "IFNULL(CONCAT(g.start_plate_city,g.start_plate_country),g.start_plate) as start_plate,	"
				+ "IFNULL(CONCAT(g.end_plate_city,g.end_plate_country),g.end_plate) as end_plate,"
				+ "g.good_type_desc,CASE g.detachable WHEN '0' THEN ROUND(g.weight,0)ELSE ROUND(g.single_car_weight,0) END as weight ,"
				+ "(UNIX_TIMESTAMP(g.pickup_date)-UNIX_TIMESTAMP(NOW())) as dif_second "
				+ "FROM goodsorderm g,company c WHERE "
				+ " g.company_id = c.seq_id "
				+ " AND	(g.create_date > DATE_SUB(now(),INTERVAL 7 DAY) or (g.pickup_date > now() and g.weight > 0))"
				+ " AND g.`status` = '20'"
				+ " AND g.price > 10 "
				+ " AND g.pin_dan_num is NULL "
				+ " AND g.platform_id = 'SX*HSY*0001'"
				+ " AND g.appoint_team_type = '1'"
				+ " AND g.pickup_date > now() ");
		
		if(!ObjectUtils.isEmpty(queryVo.getBillSender())) {
			sql.append(" and if(g.from_type='DS',g.bill_sender,c.company_name)  like  ? ");
			args.add("%"+queryVo.getBillSender()+"%");
		}
		
		if(!ObjectUtils.isEmpty(queryVo.getStartPlate())) {
			sql.append(" and g.start_plate  like  ? ");
			args.add("%"+queryVo.getStartPlate()+"%");
		}
		
		if(!ObjectUtils.isEmpty(queryVo.getEndPlate())) {
			sql.append(" and g.end_plate   like  ? ");
			args.add("%"+queryVo.getEndPlate()+"%");
		}
		sql.append(" ORDER BY if(g.if_tax_transport='Y',1,0) desc,g.create_date desc ");
		return pageQuery.query(sql.toString(), args, queryVo,GoodsCarVo.class);
	}

	@Override
	public Page<GoodsCarVo> pageListCars(GoodsCarQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT v.vehicle_num,"
				+ "v.contact_name,"
				+ "CONCAT(LEFT (v.contact_mobile, 3),'****',RIGHT (v.contact_mobile, 4)) AS contact_mobile,	"
				+ "v.tonnage,	"
				+ "v.meter,	"
				+ "v.vehicle_type,	"
				+ "v.vehicle_license_name,	"
				+ "v.car_axle "
				+ "FROM	vehicle v WHERE "
				+ " v.`status` = '02' "
				+ " AND v.platform_id = 'SX*HSY*0001' "
				+ " AND v.audit_date >= DATE_SUB(NOW(), INTERVAL 60 DAY) "
				+ "ORDER BY v.audit_date ASC");
		return pageQuery.query(sql.toString(), args, queryVo,GoodsCarVo.class);
	}

	@Override
	public List<GoodsCarVo> getCity(GoodsCarQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" SELECT t.KEY AS queryKey,t.key_value AS queryValue FROM BaseData t WHERE 1 = 1 ");
		if(!ObjectUtils.isEmpty(queryVo.getDataType())) {
			sql.append(" and t.data_type   =  ? ");
			args.add(queryVo.getDataType());
		}
		
		if(!ObjectUtils.isEmpty(queryVo.getPrivinceId())) {
			sql.append(" and t.father_key   =  ? ");
			args.add(queryVo.getPrivinceId());
		}
		
		if(!ObjectUtils.isEmpty(queryVo.getFatherType())) {
			sql.append(" and t.father_type   =  ? ");
			args.add(queryVo.getFatherType());
		}
		return pageQuery.list(sql.toString(), args, GoodsCarVo.class);
	}

}
