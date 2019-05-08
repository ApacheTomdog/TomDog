package com.brcc.business.capital.service;

import com.brcc.business.capital.entity.CapitalFlowingEntity;

/**
 * @Desc:  资金流水业务逻辑接口
 * @author TangYong
 * @Date   2018-12-11
 */
public interface CapitalFlowingService {
	
	/**
	 * @Desc: 保存资金流水
	 * @param capitalFlowingEntity
	 */
	CapitalFlowingEntity save(CapitalFlowingEntity capitalFlowingEntity);

	/**
	 * @Desc: 查询资金流水
	 * @param capitalFlowingId
	 */
	CapitalFlowingEntity findById(Long capitalFlowingId);
  
}
