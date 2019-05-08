package com.brcc.business.flow.service.impl;

import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.flow.entity.VatplatflowdetailEntity;
import com.brcc.business.flow.entity.VatplatflowmasterEntity;
import com.brcc.business.flow.repository.VatplatflowmasterRepository;
import com.brcc.business.flow.service.VatplatflowdetailService;
import com.brcc.business.flow.service.VatplatflowmasterService;
import com.brcc.business.flow.vo.VatplatflowmasterQueryVo;
import com.brcc.business.util.QueryKeyValue;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class VatplatflowmasterServiceImpl implements VatplatflowmasterService {

	@Autowired
	VatplatflowmasterRepository vatplatflowmasterRepository;
	
	@Autowired
	VatplatflowdetailService vatplatflowdetailService;
	
	
	@Override
	public Page<VatplatflowmasterEntity> searchVatplatflowmaster(VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {
		
		return vatplatflowmasterRepository.searchVatplatflowmaster(vatplatflowmasterQueryVo);
		
	}

	@Override
	public Page<QueryKeyValue> searchSpecialClient(VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {
		
		return vatplatflowmasterRepository.searchSpecialClient(vatplatflowmasterQueryVo);
	}

	
	@Override
	public VatplatflowmasterEntity findSingle(Long vatPlatFlowMasterId) {
		
		Assert.isTrue(vatPlatFlowMasterId!=null, "操作失败：主键ID不能为空！");
		
		VatplatflowmasterEntity vatplatflowmasterEntity = vatplatflowmasterRepository.findByVatPlatFlowMasterId(vatPlatFlowMasterId);
		
		processEncapsulation(vatplatflowmasterEntity,"2");
		
		return vatplatflowmasterEntity;
		
	}
	
	@Override
	@Transactional
	public VatplatflowmasterEntity saveSingle(VatplatflowmasterEntity vatplatflowmasterEntity) {
		
		processEncapsulation(vatplatflowmasterEntity,"1");
		
		vatplatflowmasterEntity = vatplatflowmasterRepository.save(vatplatflowmasterEntity);
		
		//对于第一次插入，子表中必须落地一条
		VatplatflowdetailEntity vatplatflowdetailEntity = new VatplatflowdetailEntity();
		
		vatplatflowdetailEntity.setVatPlatFlowMasterId(vatplatflowmasterEntity.getVatPlatFlowMasterId());
		
		vatplatflowdetailEntity.setIfBegin("Y");
		
		vatplatflowdetailEntity.setIfEnd("Y");
		
		vatplatflowdetailEntity.setVatInTurn(new Long(1));
		
		vatplatflowdetailEntity.setVatPolicyRate(vatplatflowmasterEntity.getVatStandardRate());
		
		vatplatflowdetailEntity.setVatCarryId(vatplatflowmasterEntity.getVatCompanyId());
		
		vatplatflowdetailEntity.setVatCarryName(vatplatflowmasterEntity.getVatCompanyName());
		
		vatplatflowdetailService.saveSingle(vatplatflowdetailEntity);
		
		return vatplatflowmasterEntity;
		
	}

	@Override
	@Transactional
	public VatplatflowmasterEntity editSingle(VatplatflowmasterEntity vatplatflowmasterEntity) {
		
		Assert.isTrue(vatplatflowmasterEntity.getVatPlatFlowMasterId()!=null, "操作失败：主键ID不能为空！");
		
		VatplatflowmasterEntity vatplatflowmasterEntityFind = vatplatflowmasterRepository.findByVatPlatFlowMasterId(vatplatflowmasterEntity.getVatPlatFlowMasterId());
		
		Assert.isTrue("10".equals(vatplatflowmasterEntityFind.getVatStatus()), "操作失败：只有新增的单据，才能做修改！");
		
		vatplatflowmasterEntityFind.setVatPlatFlowMasterName(vatplatflowmasterEntity.getVatPlatFlowMasterName());
		
		vatplatflowmasterEntityFind.setVatRateChose(vatplatflowmasterEntity.getVatRateChose());
		
		vatplatflowmasterEntityFind.setVatStandardRate(vatplatflowmasterEntity.getVatStandardRate());
		
		vatplatflowmasterEntityFind.setVatAccType(vatplatflowmasterEntity.getVatAccType());
		
		vatplatflowmasterEntityFind.setIfSpecialCase(vatplatflowmasterEntity.getIfSpecialCase());
		
		vatplatflowmasterEntityFind.setSpecialClientId(vatplatflowmasterEntity.getSpecialClientId());
		
		vatplatflowmasterEntityFind.setSpecialClientName(vatplatflowmasterEntity.getSpecialClientName());
		
		vatplatflowmasterEntityFind.setSpecialLoginName(vatplatflowmasterEntity.getSpecialLoginName());
		
		vatplatflowmasterEntityFind.setIfWcMonitor(vatplatflowmasterEntity.getIfWcMonitor());
		
		vatplatflowmasterEntityFind.setModifyDate(vatplatflowmasterEntity.getModifyDate());
		
		vatplatflowmasterEntityFind.setModifyPersonId(vatplatflowmasterEntity.getModifyPersonId());
		
		vatplatflowmasterEntityFind.setModifyPersonName(vatplatflowmasterEntity.getModifyPersonName());
		
		processEncapsulation(vatplatflowmasterEntityFind,"1");

		vatplatflowmasterRepository.save(vatplatflowmasterEntityFind);
		
		vatplatflowmasterRepository.flush();
		
		vatplatflowdetailService.updateDetailStandardRate(vatplatflowmasterEntity.getVatPlatFlowMasterId(),vatplatflowmasterEntity.getVatStandardRate());
		
		return vatplatflowmasterEntityFind;
	}

	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月15日
	 * @param vatplatflowmasterEntity
	 * @param type 1为数据来自页面，插入数据库预处理 ；2为数据来自数据库，做页面展示
	 */
	private void processEncapsulation(VatplatflowmasterEntity vatplatflowmasterEntity,String type) {
		
		//税率处理
		if("1".equals(type)) {
			BigDecimal vatStandardRate = vatplatflowmasterEntity.getVatStandardRate();
		
			BigDecimal vatPercent = new BigDecimal(100);
		
			BigDecimal realRate = vatStandardRate.divide(vatPercent, 4, BigDecimal.ROUND_HALF_UP);
		
			vatplatflowmasterEntity.setVatStandardRate(realRate);
		}else {
			BigDecimal vatStandardRate = vatplatflowmasterEntity.getVatStandardRate();
			
			BigDecimal vatPercent = new BigDecimal(100.00);
		
			BigDecimal realRate = vatStandardRate.multiply(vatPercent);
		
			vatplatflowmasterEntity.setVatStandardRate(realRate);
		}
		
		// 公司名与登录账号处理
		if("1".equals(type)) {
			if ("1".equals(vatplatflowmasterEntity.getIfSpecialCase())) {
				
				String specialClientName = vatplatflowmasterEntity.getSpecialClientName();
				
				String[] specialClientNameArr = specialClientName.split("/");
				
				if(specialClientNameArr.length == 2) {
					
					vatplatflowmasterEntity.setSpecialClientName(specialClientNameArr[0]);
					
					vatplatflowmasterEntity.setSpecialLoginName(specialClientNameArr[1]);
				}
			}else {
				vatplatflowmasterEntity.setSpecialClientId(null);
				
				vatplatflowmasterEntity.setSpecialClientName(null);
				
				vatplatflowmasterEntity.setSpecialLoginName(null);
			}
		}else {
			if ("1".equals(vatplatflowmasterEntity.getIfSpecialCase())) {
				
				String specialClientName = vatplatflowmasterEntity.getSpecialClientName();
				
				String specialLoginName = vatplatflowmasterEntity.getSpecialLoginName();
				
				vatplatflowmasterEntity.setSpecialClientName(specialClientName + "/" + specialLoginName);
			}else {
				vatplatflowmasterEntity.setSpecialClientId(null);
				
				vatplatflowmasterEntity.setSpecialClientName(null);
				
				vatplatflowmasterEntity.setSpecialLoginName(null);
			}
		}
	}

	@Override
	@Transactional
	public void processStatus(VatplatflowmasterEntity vatplatflowmasterEntity) {
		
		Long vatPlatFlowMasterId = vatplatflowmasterEntity.getVatPlatFlowMasterId();
		
		Assert.isTrue(vatPlatFlowMasterId!=null, "操作失败：主键ID不能为空！");
		
		String vatStatus = vatplatflowmasterEntity.getVatStatus();
		
		VatplatflowmasterEntity vatplatflowmasterEntityFind = vatplatflowmasterRepository.findByVatPlatFlowMasterId(vatPlatFlowMasterId);
		
		if("00".equals(vatStatus)) {
			Assert.isTrue("10".equals(vatplatflowmasterEntityFind.getVatStatus()), "操作失败：只有新增的单据，才能作废！");
		}else if("10".equals(vatStatus)) {
			Assert.isTrue("20".equals(vatplatflowmasterEntityFind.getVatStatus()), "操作失败：只有生效的单据，才能还原！");
		}else if("20".equals(vatStatus)) {
			Assert.isTrue("10".equals(vatplatflowmasterEntityFind.getVatStatus()), "操作失败：只有新增的单据，才能生效！");
		}else {
			Assert.isTrue(false, "操作失败：单据状态传入错误！");
		}
		
		vatplatflowmasterEntityFind.setVatStatus(vatStatus);
		
		vatplatflowmasterEntityFind.setModifyDate(vatplatflowmasterEntity.getModifyDate());
		
		vatplatflowmasterEntityFind.setModifyPersonId(vatplatflowmasterEntity.getModifyPersonId());
		
		vatplatflowmasterEntityFind.setModifyPersonName(vatplatflowmasterEntity.getModifyPersonName());
		
		if("00".equals(vatStatus) || "10".equals(vatStatus)) {
			
			vatplatflowmasterRepository.save(vatplatflowmasterEntityFind);
		}else if("20".equals(vatStatus)){
			
			if("1".equals(vatplatflowmasterEntityFind.getIfSpecialCase()))
				vatplatflowmasterRepository.updateSpecialMasterStatus(vatplatflowmasterEntityFind.getPlatformId(), 
						vatplatflowmasterEntityFind.getVatCompanyId(), vatplatflowmasterEntityFind.getSpecialClientId());
			else
				vatplatflowmasterRepository.updateNormalMasterStatus(vatplatflowmasterEntityFind.getPlatformId(), 
						vatplatflowmasterEntityFind.getVatCompanyId());
			
			vatplatflowmasterRepository.flush();
			
			/**
			 * 调用存储过程
			 */
			HashMap<String,Object> proMap = new HashMap<String,Object>();
			
			proMap.put("vatPlatFlowMasterId", vatPlatFlowMasterId);
			
			proMap.put("outResult","");
			
			proMap.put("outResultReason","");
			
			vatplatflowmasterRepository.proVatPlatFlow(proMap);
			
			Assert.isTrue("1".equals((String)proMap.get("outResult")), (String)proMap.get("outResultReason"));
			
		}
	}

	@Override
	public List<QueryKeyValue> searchInvoiceCompany(VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {
		
		return vatplatflowmasterRepository.searchInvoiceCompany(vatplatflowmasterQueryVo);
	}

	@Override
	public boolean existsByPlatformIdAndvAndVatPlatFlowMasterIdAndVatStatus(String platformId, Long vatPlatFlowMasterId, String status) {
		return vatplatflowmasterRepository.existsByPlatformIdAndVatPlatFlowMasterIdAndVatStatus(platformId,vatPlatFlowMasterId,status);
	}
}
