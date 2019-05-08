/**
 * 
 */
package com.brcc.business.flow.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.flow.entity.VatplatflowmasterEntity;
import com.brcc.business.flow.vo.VatplatflowmasterQueryVo;
import com.brcc.business.util.QueryKeyValue;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatplatflowmasterService {

	Page<VatplatflowmasterEntity> searchVatplatflowmaster(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);
	
	Page<QueryKeyValue> searchSpecialClient(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);
	
	VatplatflowmasterEntity findSingle(Long vatPlatFlowMasterId);
	
	VatplatflowmasterEntity saveSingle(VatplatflowmasterEntity vatplatflowmasterEntity);
	
	VatplatflowmasterEntity editSingle(VatplatflowmasterEntity vatplatflowmasterEntity);
	
	void processStatus(VatplatflowmasterEntity vatplatflowmasterEntity);
	
	List<QueryKeyValue> searchInvoiceCompany(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);

	boolean existsByPlatformIdAndvAndVatPlatFlowMasterIdAndVatStatus(String platformId,Long vatPlatFlowMasterId,String status);

}
