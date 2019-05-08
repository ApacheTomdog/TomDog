package com.brcc.business.commonaddress.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.repository.ICommonaddressRepository;
import com.brcc.business.commonaddress.vo.CommonaddressQueryVo;
import com.esteel.common.dao.PageQuery;

/**
 * @Description:常用路线数据接口实现
 * @author: TangYong
 * @Date: 2018-11-15
 */
public class CommonaddressRepositoryImpl implements ICommonaddressRepository {
	
	@Autowired
	PageQuery pageQuery;	

	@Override
	public Page<CommonaddressEntity> addressList(CommonaddressQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append(" 	t.address_id,");
		sql.append("	t.company_id,");
		sql.append("	t.company_name,");
		sql.append("	date_format( t.create_date, '%Y-%m-%d %H:%i' ),");
		sql.append("	t.create_person_id,");
		sql.append("	t.create_person_name,");
		sql.append("	t.platform_id,");
		sql.append("	t.province_name,");
		sql.append("	t.province_id,");
		sql.append("	t.city_name,");
		sql.append("	t.city_id,");
		sql.append("	t.country_name,");
		sql.append("	t.country_id,");
		sql.append("	t.address,");
		sql.append("	t.contact_name,");
		sql.append("	t.contact_tele,");
		sql.append("IF(");
		sql.append("	( t.plate_lng IS NULL )"); 
		sql.append("		OR ( CAST( t.plate_lng AS DECIMAL ) = 0 ),");
		sql.append("		b.lng,");
		sql.append("		t.plate_lng"); 
		sql.append("	) AS plate_lng,");
		sql.append("IF(");
		sql.append("	( t.plate_lat IS NULL )"); 
		sql.append("		OR ( CAST( t.plate_lat AS DECIMAL ) = 0 ),");
		sql.append("		b.lat,");
		sql.append("		t.plate_lat"); 
		sql.append("	) AS plateLat,");
		sql.append("	t.address_type,");
		sql.append("	t.country_name,");
		sql.append("	t.country_id "); 
		sql.append("FROM "); 
		sql.append("	commonaddress t "); 
		sql.append("	LEFT JOIN basedata b ON ( t.country_name = b.key_value AND t.city_name = b.father_key_value ) ");  
		sql.append("WHERE "); 
		sql.append("	1 = 1 "); 
		// 发货公司id
		sql.append("	AND t.company_id = ? ");
		args.add(vo.getCompanyId());
		// 创建人
		sql.append("	AND t.create_person_id = ? ");
		args.add(vo.getUserId());
		// 地址类型(出发地,取单地,目的地等)
		sql.append("	AND t.address_type = ? ");
		args.add(vo.getAddressType());
		// 平台
		sql.append("	AND t.platform_id = ? ");
		args.add(vo.getPlatformId());
		// 省名
		if(StringUtils.isNotEmpty(vo.getProvinceName())) {
			sql.append("  AND (t.province_name like ? or t.city_name like ? or t.contact_name like ? or t.contact_tele like ? or t.address like ?)");
			args.add("%"+ vo.getProvinceName() +"%");
			args.add("%"+ vo.getProvinceName() +"%");
			args.add("%"+ vo.getProvinceName() +"%");
			args.add("%"+ vo.getProvinceName() +"%");
			args.add("%"+ vo.getProvinceName() +"%");
		}
		sql.append("ORDER BY ");
		sql.append("	t.create_date DESC ");
		return pageQuery.query(sql.toString(), args, vo, CommonaddressEntity.class);
	}

	
}
