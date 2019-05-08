package com.brcc.business.adjustPrice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;

public interface GoodsordermAdjustPriceRepository extends JpaRepository<GoodsordermAdjustPriceEntity,String>,IGoodsordermAdjustPriceRepository{

}
