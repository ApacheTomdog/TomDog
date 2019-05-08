/**
 * 
 */
package com.brcc.business.flow.service.impl;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brcc.business.flow.vo.VatplatflowdetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.flow.entity.VatplatflowdetailEntity;
import com.brcc.business.flow.entity.VatplatflowmasterEntity;
import com.brcc.business.flow.repository.VatplatflowdetailRepository;
import com.brcc.business.flow.service.VatplatflowdetailService;
import com.brcc.business.flow.service.VatplatflowmasterService;
import com.brcc.business.flow.vo.DeleteVatplatflowdetailVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class VatplatflowdetailServiceImpl implements VatplatflowdetailService {

	@Autowired
	VatplatflowdetailRepository vatplatflowdetailRepository;
	
	@Autowired
	VatplatflowmasterService vatplatflowmasterService;
	
	@Override
	public VatplatflowdetailEntity saveSingle(VatplatflowdetailEntity vatplatflowdetailEntity) {
		
		return vatplatflowdetailRepository.save(vatplatflowdetailEntity);
		
	}
	
	@Override
	@Transactional
	public void addDetails(List<VatplatflowdetailEntity> list) {
		for(VatplatflowdetailEntity vatplatflowdetailEntity : list){
			List<VatplatflowdetailEntity> vfeList = vatplatflowdetailRepository.findByVatPlatFlowMasterIdAndVatCarryId(vatplatflowdetailEntity.getVatPlatFlowMasterId(), vatplatflowdetailEntity.getVatCarryId());
			
			Assert.isTrue(vfeList.size() == 0, "操作失败：同一公司不允许添加多次");
			
			vatplatflowdetailRepository.save(vatplatflowdetailEntity);
			
		}
		
		vatplatflowdetailRepository.flush();
		
		if(list.size() > 0)
		
			processDetailsTurn(list.get(0).getVatPlatFlowMasterId());
	}

	@Override
	public List<VatplatflowdetailEntity> detailList(Long vatPlatFlowMasterId) {
		
		return vatplatflowdetailRepository.findByVatPlatFlowMasterId(vatPlatFlowMasterId);
	}

	@Override
	@Transactional
	public void updateDetailStandardRate(Long vatPlatFlowMasterId, BigDecimal vatStandardRate) {
		
		vatplatflowdetailRepository.updateDetailStandardRate(vatPlatFlowMasterId,vatStandardRate.divide(new BigDecimal(100)));
	}
	
	public void processDetailsTurn(Long vatPlatFlowMasterId) {
		
		List<VatplatflowdetailEntity> detailList = vatplatflowdetailRepository.findByVatPlatFlowMasterId(vatPlatFlowMasterId);
		
		for(int i = 0 ; i < detailList.size() ; i++) {
			
			VatplatflowdetailEntity detail = detailList.get(i);
			
			Integer j = i + 1;
			
			detail.setVatInTurn(j.longValue());
		}
		
		vatplatflowdetailRepository.saveAll(detailList);
	}

	@Override
	public void deleteDetails(DeleteVatplatflowdetailVo deleteVatplatflowdetailVo) {
		
		VatplatflowmasterEntity  vatplatflowmasterEntity = vatplatflowmasterService.findSingle(deleteVatplatflowdetailVo.getVatPlatFlowMasterId());
		
		Assert.isTrue(!"1".equals(vatplatflowmasterEntity.getIfOldStatus()), "以前生效过则无法修改的流程无法修改");
		
		String[] vatPlatFlowDetailIdArr = deleteVatplatflowdetailVo.getVatPlatFlowDetailIdStr().split(",");
		
		for(String vatPlatFlowDetailId : vatPlatFlowDetailIdArr) {
			
			vatplatflowdetailRepository.deleteById(Long.valueOf(vatPlatFlowDetailId));
		}
		
	}

	@Override
	public VatplatflowdetailEntity findByVatPlatFlowDetailId(Long vatPlatFlowDetailId) {
		return vatplatflowdetailRepository.findByVatPlatFlowDetailId(vatPlatFlowDetailId);
	}

	@Override
	public VatplatflowdetailEntity editSave(VatplatflowdetailVo vo) {
		Assert.notNull(!vatplatflowmasterService.existsByPlatformIdAndvAndVatPlatFlowMasterIdAndVatStatus(vo.getPlatformId(),vo.getVatPlatFlowMasterId(),vo.getVatStatus()),"当前主项已生效不能修改！");
		VatplatflowdetailEntity entity = vatplatflowdetailRepository.findByVatPlatFlowDetailId(vo.getVatPlatFlowDetailId());
		Assert.notNull(entity,"页面数据出错，请刷新重试！");
		entity.setVatPolicyRate(vo.getVatPolicyRate());
		vatplatflowdetailRepository.save(entity);
		return entity;
	}
}
