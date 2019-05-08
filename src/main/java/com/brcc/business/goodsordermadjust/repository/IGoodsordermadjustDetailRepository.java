package com.brcc.business.goodsordermadjust.repository;

import java.util.List;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;

/**
 *货源单运费调整明细
 * @author TangYong
 * @date 2019-02-19 
 */
public interface IGoodsordermadjustDetailRepository {
	 /**货源单授信调价明细 */
    List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo);
    
}
