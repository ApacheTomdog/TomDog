package com.brcc.business.capital.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.capital.entity.CapitalBalanceEntity;

/**
 * @Desc:    程云资金数据接口
 * @author:  TangYong
 * @Date:    2018-12-11
 */
public interface CapitalBalanceRepository extends JpaRepository<CapitalBalanceEntity,Long>{

	/**
	 * @Desc:  查询承运资金
	 * @param  platformId 
	 * @param  companyId 
	 * @return CapitalBalanceEntity
	 */
	CapitalBalanceEntity findByCompanyIdAndPlatformId(Long companyId, String platformId);

	/**
	 * @Desc:  查询去除服务费后承运资金是否充足
	 * @param  platformId 
	 * @param  companyId 
	 * @return CapitalBalanceEntity
	 */
	@Query(value="select * from capital_balance WHERE seq_id = ? and balance >= ?",nativeQuery=true)
	CapitalBalanceEntity findBySeqIdAndBalance(Long seqId, BigDecimal grabMoney);


}
