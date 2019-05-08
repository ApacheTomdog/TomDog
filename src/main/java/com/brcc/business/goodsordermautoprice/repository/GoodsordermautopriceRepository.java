package com.brcc.business.goodsordermautoprice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;

public interface GoodsordermautopriceRepository extends JpaRepository<GoodsordermautopriceEntity,Long>,IGoodsordermautopriceRepository{

	GoodsordermautopriceEntity findByGAId(Long getgAId);

}
