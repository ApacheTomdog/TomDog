/**
 * 
 */
package com.brcc.business.flow.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.brcc.business.flow.vo.VatplatflowdetailVo;
import org.springframework.web.bind.annotation.RequestBody;

import com.brcc.business.flow.entity.VatplatflowdetailEntity;
import com.brcc.business.flow.vo.DeleteVatplatflowdetailVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface VatplatflowdetailService {
	
	VatplatflowdetailEntity saveSingle(VatplatflowdetailEntity vatplatflowdetailEntity);
	
	void addDetails(List<VatplatflowdetailEntity> list);
	
	List<VatplatflowdetailEntity> detailList(Long vatPlatFlowMasterId);

	void updateDetailStandardRate(Long vatPlatFlowMasterId,BigDecimal vatStandardRate);
	
	void deleteDetails(DeleteVatplatflowdetailVo deleteVatplatflowdetailVo);

	VatplatflowdetailEntity findByVatPlatFlowDetailId(Long vatPlatFlowDetailId);

	VatplatflowdetailEntity editSave(VatplatflowdetailVo vo);
}
