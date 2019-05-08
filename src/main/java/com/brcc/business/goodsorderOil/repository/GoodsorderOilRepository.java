package com.brcc.business.goodsorderOil.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;
import com.brcc.business.transorder.entity.GoodsordermEntity;

public interface GoodsorderOilRepository extends JpaRepository<GoodsordermEntity, Long>,IGoodsorderOilRepository{

	GoodsordermEntity findByPublishId(Long publishId);

}
