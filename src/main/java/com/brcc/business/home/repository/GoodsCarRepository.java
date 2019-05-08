package com.brcc.business.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.goodsorderm.entity.GoodsordermEntity;

public interface GoodsCarRepository extends JpaRepository<GoodsordermEntity, Long> ,IGoodsCarRepository{

	


}
