package com.brcc.business.goodsordermadjust.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;

/**
* @Desc   货源单调价明细逻数据接口
* @author TangYong
* @Date   2018-11-24
*/
public interface GoodsordermadjustDetailRepository extends JpaRepository<GoodsordermadjustdetailEntity,Long>,IGoodsordermadjustDetailRepository{

	/**
	 * 根据外部接口电商importId拼接数据判断当前单据下的含税情况
	 * @param importIdStr
	 * @return
	 */

}
