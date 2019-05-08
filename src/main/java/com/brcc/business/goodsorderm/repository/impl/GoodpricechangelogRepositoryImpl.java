package com.brcc.business.goodsorderm.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.repository.IGoodpricechangelogRepository;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.esteel.common.dao.PageQuery;

/**
* @Desc   货源单货物单价修改记录数据处理接口实现
* @author TangYong
* @Date   2019-02-19
*/
public class GoodpricechangelogRepositoryImpl implements IGoodpricechangelogRepository {
	
	@Autowired
	PageQuery pageQuery;
	
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
	public Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo) {
		
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	g.publish_id, ");
		sql.append("	g.publish_good_price_old, ");
		sql.append("	g.publish_good_price_new, ");
		sql.append("	g.create_date, ");
		sql.append("	g.create_person_name, ");
		sql.append("	g.modify_date, ");
		sql.append("	g.modify_person_name, ");
		sql.append("	g.loss_type, ");
		sql.append("	g.loss_ratio, ");
		sql.append("	g.loss_weight, ");
		sql.append("	g.loss_type_old, ");
		sql.append("	g.loss_ratio_old, ");
		sql.append("	g.loss_weight_old ");
		sql.append("FROM ");
		sql.append("	goodpricechangelog g ");
		sql.append("	WHERE ");
		sql.append("	g.publish_id = ? ");
		sql.append("	AND g.platform_id= ? ");
		sql.append("	AND g.publish_company_id= ? ");
		sql.append("	AND g.modify_status = '20' ");
		sql.append("	order by g.create_date desc ");
		args.add(vo.getPublishId());
		args.add(vo.getPlatformId());
		args.add(vo.getCompanyId());
		Page<GoodpricechangelogEntity> pageList = pageQuery.query(sql.toString(), args,vo, GoodpricechangelogEntity.class);
		return pageList;
	}

}
