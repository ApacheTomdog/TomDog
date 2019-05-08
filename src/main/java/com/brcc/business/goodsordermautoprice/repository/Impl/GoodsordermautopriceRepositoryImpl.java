package com.brcc.business.goodsordermautoprice.repository.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.vo.blackBrokerVo;
import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.repository.IGoodsordermautopriceRepository;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceVo;
import com.esteel.common.dao.PageQuery;

public class GoodsordermautopriceRepositoryImpl implements IGoodsordermautopriceRepository {

	@Autowired
	PageQuery pageQuery;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Page<GoodsordermautopriceEntity> searchGoodsordermAutoPrice(AutoPriceQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from goodsordermautoprice where ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sql.append("  platform_id = ? ");
		sql.append(" and company_id = ? ");
		params.add(queryVo.getPlatformId());
		params.add(queryVo.getCompanyId());
		// 注册开始时间
		if (!ObjectUtils.isEmpty(queryVo.getRqStart())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') >= ? ");
			params.add(sdf.format(queryVo.getRqStart()));
		}
		// 注册结束时间
		if (!ObjectUtils.isEmpty(queryVo.getRqEnd())) {
			sql.append(" AND DATE_FORMAT(create_date,'%Y-%m-%d') <= ? ");
			params.add(sdf.format(queryVo.getRqEnd()));
		}

		if (!ObjectUtils.isEmpty(queryVo.getCompanyStatus())) {
			sql.append(" and company_status = ? ");
			params.add(queryVo.getCompanyStatus());
		}

		if (!ObjectUtils.isEmpty(queryVo.getPublishId())) {
			sql.append(" and publish_id like ? ");
			params.add("%" + queryVo.getPublishId() + "%");
		}

		return pageQuery.query(sql.toString(), params, queryVo, GoodsordermautopriceEntity.class);
	}

	@Override
	public Page<AutoPriceVo> publilshIdList(AutoPriceQueryVo queryVo) {
		
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT publish_id as publishId,CONCAT('货源单号:',m.publish_id,'/','单价:',m.price) AS publishInfo,m.price AS price FROM goodsorderm m WHERE m.`status` = '20'  ");

		sql.append(" and  platform_id = ? ");
		sql.append(" and company_id = ? ");
		sql.append(" and pickup_date >NOW()  ");
		params.add(queryVo.getPlatformId());
		params.add(queryVo.getCompanyId());
		logger.info(queryVo.getPublishInfo()+">>>>>>>>>>>>>>");
		if(!ObjectUtils.isEmpty(queryVo.getPublishInfo())) {
			 sql.append(" and (m.publish_id  like  ? or m.price like ?)");
			// sql.append(" ");
			 params.add("%" + queryVo.getPublishInfo() + "%");
			 params.add("%" + queryVo.getPublishInfo() + "%");
		}
		
		return pageQuery.query(sql.toString(),params,queryVo,AutoPriceVo.class);
	}

	@Override
	public List<GoodsordermautopriceEntity> onlyOne(GoodsordermautopriceEntity entity) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from goodsordermautoprice where ");
		sql.append("  platform_id = ? ");
		params.add(entity.getPlatformId());
		sql.append(" and publish_id = ? ");
		params.add(entity.getPublishId());
		sql.append(" and company_status !='00' ");
		return pageQuery.list(sql.toString(), params, GoodsordermautopriceEntity.class);
	}

}
