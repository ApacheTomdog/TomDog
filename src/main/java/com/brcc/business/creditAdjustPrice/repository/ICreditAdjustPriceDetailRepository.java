package com.brcc.business.creditAdjustPrice.repository;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description: 授信调价明细数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 20:18 2018/11/3
 */
public interface ICreditAdjustPriceDetailRepository {

    /**
     * @Description  返回指定credAdjMId 授信调价明细信息
     * @Param [credAdjMId]
     * @return java.util.List<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);
    
    /**
     * @Description  以List形式返回指定credAdjMId 授信调价明细信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return java.util.List<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity>
     **/
    List<CreditAdjustPriceDetailEntity> findListByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);

    /**
	 * @Desc   查询授信加价 
	 * @Param  CreditAdjustPriceDetailQueryVo priceDetailQueryVo
	 * @return List<CreditAdjustPriceDetailVo>
	 */
    
    List<CreditAdjustPriceDetailVo> queryCreditAddPrice(CreditAdjustPriceDetailQueryVo priceDetailQueryVo);
    /**
	 * @Desc    根据货源单发布价查询具体授信详情
	 * @Param  CreditAdjustPriceDetailQueryVo priceDetailQueryVo
	 * @return List<CreditAdjustPriceDetailVo>
	 */
    List<CreditAdjustPriceDetailVo>queryCreditDetailPriceList(CreditAdjustPriceDetailQueryVo priceDetailQueryVo);
}