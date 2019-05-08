package com.brcc.business.priceClientRate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.priceClientRate.entity.PriceClientRateEntity;

public interface PriceClientRateRepository extends JpaRepository<PriceClientRateEntity,Long>,IPriceClientRateRepository{
	
	/**
	 * 检查是否有存在的公司
	 * @param clientId
	 * @param carryId
	 * @return
	 */
	@Query(value="select count(1) from price_client_rate  where 1 = 1 AND client_id = ? and carry_id= ?", nativeQuery=true)
	Integer checkCompany(Long clientId,Long carryId);
	


}
