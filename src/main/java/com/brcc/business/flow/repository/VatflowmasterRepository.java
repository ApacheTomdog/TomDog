package com.brcc.business.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.flow.entity.VatflowmasterEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatflowmasterRepository extends JpaRepository<VatflowmasterEntity,Long>,IVatflowmasterRepository {

	VatflowmasterEntity findByVatFlowMasterId(Long vatFlowMasterId);
}
