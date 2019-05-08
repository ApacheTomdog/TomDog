/**
 * 
 */
package com.brcc.business.flow.repository;

import java.util.HashMap;
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
public interface IVatplatflowmasterRepository {

	Page<VatplatflowmasterEntity> searchVatplatflowmaster(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);
	
	Page<QueryKeyValue> searchSpecialClient(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);
	
	 void proVatPlatFlow(HashMap<String, Object> proMap);
	 
	 List<QueryKeyValue> searchInvoiceCompany(VatplatflowmasterQueryVo vatplatflowmasterQueryVo);
		
}
