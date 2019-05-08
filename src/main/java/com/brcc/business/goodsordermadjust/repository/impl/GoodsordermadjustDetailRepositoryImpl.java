package com.brcc.business.goodsordermadjust.repository.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsordermadjust.repository.IGoodsordermadjustDetailRepository;
import com.esteel.common.dao.PageQuery;


/**
 * @Description 源单运费调整明细
 * @author TangYong
 * @date 2019-02-19
 */
public class GoodsordermadjustDetailRepositoryImpl implements IGoodsordermadjustDetailRepository {
	
	@Autowired
	PageQuery pageQuery;
	
	@Override
	public List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	m.min_price,");
		sql.append("	m.max_price,");
		sql.append("	m.credit_add_price,");
		sql.append("	x.owner_adjust_type as 'adjPriceStyle',");
		sql.append("	m.cred_adj_d_id,");
		sql.append("	m.cred_adj_m_id,");
		sql.append("	m.publish_id,");
		sql.append("	m.create_person_name,");
		sql.append("	m.create_date ");
		sql.append("FROM ");
		sql.append("	goodsordermadjustdetail m, ");
		sql.append("    goodsorderm x ");
		sql.append("WHERE ");
		sql.append("	m.publish_id= ? ");
		sql.append("	AND m.publish_id=x.publish_id ");
		sql.append("	AND x.platform_id= ? ");
		sql.append("	AND x.owner_adjust_flag='Y' ");
		args.add(vo.getPublishId());
		args.add(vo.getPlatformId());
		return pageQuery.list(sql.toString(),args,GoodsordermadjustdetailVo.class);
	}

}
