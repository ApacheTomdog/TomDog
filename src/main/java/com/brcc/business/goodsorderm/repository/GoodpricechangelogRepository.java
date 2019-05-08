package com.brcc.business.goodsorderm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;

/**
* @Desc   货源单货物单价修改记录数据处理
* @author TangYong
* @Date   2018-12-05
*/

public interface GoodpricechangelogRepository extends JpaRepository<GoodpricechangelogEntity,Long>,IGoodpricechangelogRepository{

	
}
