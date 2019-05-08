package com.brcc.business.goodsordermautoprice.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceVo;

public interface IGoodsordermautopriceRepository {
	Page<GoodsordermautopriceEntity> searchGoodsordermAutoPrice(AutoPriceQueryVo queryVo);
	Page<AutoPriceVo> publilshIdList(AutoPriceQueryVo queryVo);
	List<GoodsordermautopriceEntity> onlyOne(GoodsordermautopriceEntity entity);
}
