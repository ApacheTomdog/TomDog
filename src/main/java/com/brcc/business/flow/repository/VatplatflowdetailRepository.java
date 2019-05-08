package com.brcc.business.flow.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.flow.entity.VatplatflowdetailEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatplatflowdetailRepository extends JpaRepository<VatplatflowdetailEntity,Long>,IVatplatflowdetailRepository {

	VatplatflowdetailEntity findByVatPlatFlowDetailId(Long vatPlatFlowDetailId);
	
	@Query(value = "select * from vatplatflowdetail where vat_plat_flow_master_id = ?1 order by vat_plat_flow_detail_id asc",nativeQuery = true)
	List<VatplatflowdetailEntity> findByVatPlatFlowMasterId(Long vatPlatFlowMasterId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="update apptms.vatplatflowdetail t,apptms.vatplatflowmaster m  " + 
			" set t.vat_policy_rate = ?2 " + 
			" where t.vat_plat_flow_master_id = m.vat_plat_flow_master_id " + 
			" and if(m.vat_rate_chose='1', 1=1, t.if_begin='Y')" +
			" and t.vat_plat_flow_master_id = ?1 ", nativeQuery=true)
	Integer updateDetailStandardRate(Long vatPlatFlowMasterId,BigDecimal vatStandardRate);

	List<VatplatflowdetailEntity> findByVatPlatFlowMasterIdAndVatCarryId(Long vatPlatFlowMasterId,Long vatCarryId);




}
