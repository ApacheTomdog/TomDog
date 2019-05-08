package com.brcc.business.flow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.flow.entity.VatplatflowmasterEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatplatflowmasterRepository extends JpaRepository<VatplatflowmasterEntity,Long>,IVatplatflowmasterRepository {

	VatplatflowmasterEntity findByVatPlatFlowMasterId(Long vatPlatFlowMasterId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="update apptms.vatplatflowmaster t  " + 
			"set t.vat_status = '10' " + 
			"where  t.vat_status='20' " + 
			"and t.if_special_case='0' " + 
			"and t.platform_id=?1 " + 
			"and t.vat_company_id=?2 ", nativeQuery=true)
	Integer updateNormalMasterStatus(String platformId, Long vatCompanyId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="update apptms.vatplatflowmaster t  " + 
			"set t.vat_status = '10' " + 
			"where  t.vat_status='20' " + 
			"and t.if_special_case='1' " + 
			"and t.platform_id=?1 " + 
			"and t.vat_company_id=?2 " + 
			"and t.special_client_id=?3 ", nativeQuery=true)
	Integer updateSpecialMasterStatus(String platformId, Long vatCompanyId,Long specialClientId);

	boolean existsByPlatformIdAndVatPlatFlowMasterIdAndVatStatus(String platformId,Long vatPlatFlowMasterId,String status);
}
