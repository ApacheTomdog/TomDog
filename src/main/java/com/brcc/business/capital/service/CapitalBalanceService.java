package com.brcc.business.capital.service;

import java.math.BigDecimal;

import com.brcc.business.capital.entity.CapitalBalanceEntity;

/**
 * @Desc:  承运资金业务逻辑接口
 * @author TangYong
 * @Date   2018-12-11
 */
public interface CapitalBalanceService {
	
	/**
	 * @Desc:  查询承运资金
	 * @param  platformId 
	 * @param  companyId 
	 * @return CapitalBalanceEntity
	 */
	CapitalBalanceEntity findByCompanyIdAndPlatformId(Long companyId, String platformId);

	/**
	 * @Desc:  查询收取服务费后承运资金是否充足
	 * @param  seqId 
	 * @param  grabMoney 服务费 
	 * @return CapitalBalanceEntity
	 */
	CapitalBalanceEntity findByCapitalSeqIdAndAmount(Long seqId, BigDecimal grabMoney);	
  
}
