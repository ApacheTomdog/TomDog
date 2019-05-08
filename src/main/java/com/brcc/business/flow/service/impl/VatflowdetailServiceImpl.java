/**
 * 
 */
package com.brcc.business.flow.service.impl;
import java.util.List;

import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.repository.VatflowdetailRepository;
import com.brcc.business.flow.service.VatflowdetailService;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class VatflowdetailServiceImpl implements VatflowdetailService {
	
	Logger logger = LoggerFactory.getLogger(VatflowdetailServiceImpl.class);
	@Autowired
	VatflowdetailRepository vatflowdetailRepository;
	
	@Override
	public List<VatflowdetailEntity> listByPulishCompanyId(Long publishCompanyId) {
		logger.info("query VatflowdetailEntity list,by pulishCompanyId:{}",publishCompanyId);
		return vatflowdetailRepository.listByPulishCompanyId(publishCompanyId);
	}

	@Override
	public List<VatflowdetailCompanyNameVo> queryCompanyName(VatCompanyRechargeQueryVo vo) {
		logger.info("query for Company Name");
		return vatflowdetailRepository.queryForCompanyName(vo);
	}

	@Override
	public List<VatflowdetailVo> queryFlowInfo(Long pulishCompanyId) {
		logger.info("query VatflowdetailVo info,by pulishCompanyId:{}",pulishCompanyId);
		return vatflowdetailRepository.queryForCompanyName(pulishCompanyId);
	}

	@Override
	public VatflowdetailEntity queryBeginFlow(Long vatFlowMasterId) {
		logger.info("query VatflowdetailEntity info which begin is 'Y',by vatFlowMasterId:{}",vatFlowMasterId);
		return vatflowdetailRepository.findByVatFlowMasterIdAndIfBegin(vatFlowMasterId,"Y");
	}

	@Override
	public List<VatflowdetailVo> queryTaxRate(VatflowmasterQueryVo vo) {
		logger.info("query flow list,vatcompanyId is:{}",vo.getVatCompanyId());
		return vatflowdetailRepository.queryTaxRate(vo);
	}
}
