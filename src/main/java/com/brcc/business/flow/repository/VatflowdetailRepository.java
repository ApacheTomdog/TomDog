package com.brcc.business.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.flow.entity.VatflowdetailEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatflowdetailRepository extends JpaRepository<VatflowdetailEntity,Long>,IVatflowdetailRepository{

	VatflowdetailEntity findByVatFlowDetailId(Long vatFlowDetailId);

	/**
	 * 根据主流程id查找一级流程节点
	 * @Param vatFlowMasterId
	 * @return VatflowdetailEntity
	 */
	VatflowdetailEntity findByVatFlowMasterIdAndIfBegin(Long vatFlowMasterId, String string);

	
}
