package com.brcc.business.reinvoiceRateConfig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigEntity;

public interface ReinvoiceRateConfigRepository extends JpaRepository<ReinvoiceRateConfigEntity,Long>, IReinvoiceRateConfigRepository{
	@Query(value="select count(1) from reinvoice_rate_config s where s.company_id = ?1", nativeQuery=true)
	Integer checkReinvoiceRateConfig(Long companyId);
	
	
}
