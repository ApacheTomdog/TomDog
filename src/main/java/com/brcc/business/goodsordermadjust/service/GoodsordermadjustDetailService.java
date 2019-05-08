package com.brcc.business.goodsordermadjust.service;

import java.util.List;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;

/**
* @Desc   货源单调价明细逻辑接口
* @author TangYong
* @Date   2018-11-24
*/
public interface GoodsordermadjustDetailService {

	/**
	 * 货源单调价明细新增
	 * @param enity 
	 */
	void save(GoodsordermadjustdetailEntity enity);
	
	/**货源单授信调价明细 */
	List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo);

}
