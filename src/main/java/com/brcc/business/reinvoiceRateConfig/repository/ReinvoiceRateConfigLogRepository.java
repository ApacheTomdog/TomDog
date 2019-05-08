package com.brcc.business.reinvoiceRateConfig.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigLogEntity;

public interface ReinvoiceRateConfigLogRepository extends JpaRepository<ReinvoiceRateConfigLogEntity,Long>, IReinvoiceRateConfigLogRepository{

}
