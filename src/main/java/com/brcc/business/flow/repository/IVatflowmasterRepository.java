/**
 * 
 */
package com.brcc.business.flow.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.flow.vo.VatflowmasterVo;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;


/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface IVatflowmasterRepository {
	Page<VatflowmasterVo> findVatflowmasterByCompanyId(GoodsordermQueryVo vo);
}
