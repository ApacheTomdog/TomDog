package com.brcc.business.adjustPrice.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;
import com.brcc.business.adjustPrice.repository.IGoodsordermAdjustPriceRepository;
import com.brcc.business.adjustPrice.vo.GoodsordermAdjustPriceQueryVo;
import com.esteel.common.dao.PageQuery;

/**
 * @Description 货主调价记录
 * @Auther lijiangying
 * @Date Created in 14:01 2018/12/5
 */
public class GoodsordermAdjustPriceRepositoryImpl implements IGoodsordermAdjustPriceRepository{
	
	@Autowired
	PageQuery pageQuery;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Page<GoodsordermAdjustPriceEntity> listAdjustPrice(
			GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select t.* from goodsordermadjustprice t ");
		// 总账号可以看到子账号修改的记录（根据if_admin=‘Y’和company_id判断）
		if("Y".equals(goodsordermAdjustPriceQueryVo.getIfAdmin())){
			sql.append(" LEFT JOIN loginverify l ON t.adjust_person_id = l.user_id ");
			sql.append(" LEFT JOIN company c ON c.seq_id = l.company_id ");
		}
		sql.append(" where 1=1 ");
		if("Y".equals(goodsordermAdjustPriceQueryVo.getIfAdmin())){
			sql.append(" and c.seq_id = ? ");
			params.add(goodsordermAdjustPriceQueryVo.getCompanyId());
		}
		if("N".equals(goodsordermAdjustPriceQueryVo.getIfAdmin())){
			sql.append(" and t.adjust_person_id = ? ");
			params.add(goodsordermAdjustPriceQueryVo.getUserId());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getPublishId())) {
			 sql.append(" and t.publish_id = ? ");
			 params.add(goodsordermAdjustPriceQueryVo.getPublishId());
		}
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getRqStart())) {
			sql.append("  AND DATE_FORMAT(t.adjust_price_date ,'%Y-%m-%d')>= ?");
			params.add(sdf.format(goodsordermAdjustPriceQueryVo.getRqStart()));
		}
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getRqEnd())) {
			sql.append("  AND DATE_FORMAT( t.adjust_price_date,'%Y-%m-%d') <= ?");
			params.add(sdf.format(goodsordermAdjustPriceQueryVo.getRqEnd()));
		}
		sql.append("order By t.adjust_price_id desc");
		Page<GoodsordermAdjustPriceEntity> page = pageQuery.query(sql.toString(),params,goodsordermAdjustPriceQueryVo,GoodsordermAdjustPriceEntity.class);
		return page;
	}

	@Override
	public List<GoodsordermAdjustPriceEntity> queryAdjustPrice(
			GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo) {
		List<Object> params = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql = new StringBuffer("select t.* from goodsordermadjustprice t where ");
		sql.append(" t.adjust_person_id = ? ");
		params.add(goodsordermAdjustPriceQueryVo.getUserId());
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getPublishId())) {
			 sql.append(" and t.publish_id = ? ");
			 params.add(goodsordermAdjustPriceQueryVo.getPublishId());
		}
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getRqStart())) {
			sql.append("  AND DATE_FORMAT(t.adjust_price_date ,'%Y-%m-%d')>= ?");
			params.add(sdf.format(goodsordermAdjustPriceQueryVo.getRqStart()));
		}
		if(!ObjectUtils.isEmpty(goodsordermAdjustPriceQueryVo.getRqEnd())) {
			sql.append("  AND DATE_FORMAT( t.adjust_price_date,'%Y-%m-%d') <= ?");
			params.add(sdf.format(goodsordermAdjustPriceQueryVo.getRqEnd()));
		}
		return pageQuery.list(sql.toString(),params,GoodsordermAdjustPriceEntity.class);
	}

}
