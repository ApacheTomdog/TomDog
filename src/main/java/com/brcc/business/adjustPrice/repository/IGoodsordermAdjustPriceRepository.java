

package com.brcc.business.adjustPrice.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;
import com.brcc.business.adjustPrice.vo.GoodsordermAdjustPriceQueryVo;

/**
 * @Description 货主调价记录
 * @Auther lijiangying
 * @Date Created in 14:01 2018/12/5
 */
public interface IGoodsordermAdjustPriceRepository {
	
	/**
     * @author lijiangying
     * @date:2018年12月5日
     * @param creditAmountAdjustQueryVo
     * @return
     */
	Page<GoodsordermAdjustPriceEntity> listAdjustPrice(GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo);
	
	/**
     * @author lijiangying
     * @date:2018年12月5日
     * @param creditAmountAdjustQueryVo
     * @return 导出
     */
	List<GoodsordermAdjustPriceEntity>queryAdjustPrice(GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo);

}
