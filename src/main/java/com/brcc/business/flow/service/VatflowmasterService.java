/**
 * 
 */
package com.brcc.business.flow.service;

import org.springframework.data.domain.Page;

import com.brcc.business.flow.vo.VatflowmasterVo;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;


/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatflowmasterService {
	/**
	 * 根据公司ID查询流程名称
	 * @param vo
	 * @return
	 */
	Page<VatflowmasterVo> findVatflowmasterByCompanyId(GoodsordermQueryVo vo);
}
