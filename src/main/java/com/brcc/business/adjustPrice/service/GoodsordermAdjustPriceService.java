
package com.brcc.business.adjustPrice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;
import com.brcc.business.adjustPrice.vo.GoodsordermAdjustPriceQueryVo;

/**
 * @Description 货主调价记录
 * @Auther lijiangying
 * @Date Created in 14:01 2018/12/5
 */
public interface GoodsordermAdjustPriceService {
	 Page<GoodsordermAdjustPriceEntity> listAdjustPrice(GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo);
	 List<GoodsordermAdjustPriceEntity>exportAdjustPrice(GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo);
}
