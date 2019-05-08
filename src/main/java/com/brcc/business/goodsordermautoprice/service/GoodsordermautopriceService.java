package com.brcc.business.goodsordermautoprice.service;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceVo;

public interface GoodsordermautopriceService {

	Page<GoodsordermautopriceEntity> searchGoodsordermAutoPrice(AutoPriceQueryVo queryVo);

	void change(GoodsordermautopriceEntity entity);

	Page<AutoPriceVo> publilshIdList(AutoPriceQueryVo queryVo);

	void save(GoodsordermautopriceEntity entity);

	GoodsordermautopriceEntity findById(Long gAId);

	void update(GoodsordermautopriceEntity entity);

}
