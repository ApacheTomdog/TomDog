package com.brcc.business.creditAmountAdjust.repository;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @Description:
 * @author:陈利
 * @date:2018年11月3日
 *
 */
public interface CreditAmountAdjustRepository extends JpaRepository<CreditAmountAdjustEntity,String>,ICreditAmountAdjustRepository {
	
	CreditAmountAdjustEntity findByCredAmtAdjId(Long credAmtAdjId);
	
	CreditAmountAdjustEntity findByCreditConfigId(Long creditConfigId);
}