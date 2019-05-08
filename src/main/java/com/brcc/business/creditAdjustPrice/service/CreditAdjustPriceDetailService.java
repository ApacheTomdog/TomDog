package com.brcc.business.creditAdjustPrice.service;

import java.util.List;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Desc:   授信调价明细业务逻辑接口
 * @author: TangYong
 * @Date:   2018-11-19
 */
public interface CreditAdjustPriceDetailService {
	


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
	 * @Desc   根据货源单发布价查询具体授信详情
	 * @Param  CreditAdjustPriceDetailQueryVo priceDetailQueryVo
	 * @return List<CreditAdjustPriceDetailVo>
	 */
	List<CreditAdjustPriceDetailVo> queryCreditDetailPriceList(CreditAdjustPriceDetailQueryVo priceDetailQueryVo); 
	/**
	 * @Description  根据CredAdjDId返回明细
	 * @Param [credAdjDId]
	 * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
	 **/
	CreditAdjustPriceDetailEntity findByCredAdjDId(Long credAdjDId);

	/**
	 * @Description  删除指定credAdjDId明细
	 * @Param [credAdjDId]
	 * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
	 **/
	Integer deleteByCredAdjDId(Long credAdjDId);

	CreditAdjustPriceDetailEntity save(CreditAdjustPriceDetailEntity v);

	/**
	 * @Description  判断该授信调价下是否存在子记录
	 * @Param [mid]
	 * @return boolean
	 **/
	boolean existsByCredAdjMId(Long mid);
}