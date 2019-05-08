package com.brcc.business.reinvoiceRateConfig.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigEntity;
import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigLogEntity;
import com.brcc.business.reinvoiceRateConfig.repository.ReinvoiceRateConfigLogRepository;
import com.brcc.business.reinvoiceRateConfig.repository.ReinvoiceRateConfigRepository;
import com.brcc.business.reinvoiceRateConfig.service.ReinvoiceRateConfigService;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigAddVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigUpdateVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigVo;

@Service
public class ReinvoiceRateConfigServiceImpl implements ReinvoiceRateConfigService{
	
	@Autowired
	private ReinvoiceRateConfigRepository reinvoiceRateConfigRepository;
	@Autowired
	private ReinvoiceRateConfigLogRepository reinvoiceRateConfigLogRepository;
	
	/**
	 * 展示全部竪鋸
	 */
	@Override
	public Page<ReinvoiceRateConfigVo> ReinvoiceRateConfigPage(ReinvoiceRateConfigQueryVo vo) {
		return reinvoiceRateConfigRepository.ReinvoiceRateConfigPage(vo);
	}
	
	/**
	 * 添加開票數據
	 */
	@Override
	@Transactional
	public void saveReinvoiceRateConfig(ReinvoiceRateConfigAddVo vo) {
		int num=reinvoiceRateConfigRepository.checkReinvoiceRateConfig(vo.getCompanyId());
		Assert.isTrue(num==0, "每个代开票公司只能维护一条数据，请勿多次添加！");
		ReinvoiceRateConfigEntity entity=new ReinvoiceRateConfigEntity();
		if(vo.getTaxRate()==null) {
			vo.setTaxRate(new BigDecimal("0.0491"));
		}
		BeanUtils.copyProperties(vo, entity);
		reinvoiceRateConfigRepository.save(entity);
	}
	
	/**
	 * 查询公司公司列表
	 */
	@Override
	public Page<ReinvoiceRateCompanyNameVo> queryCompanyNameList(ReinvoiceRateCompanyNameQueryVo vo) {
		Page<ReinvoiceRateCompanyNameVo> list = reinvoiceRateConfigRepository.queryCompanyNameList(vo);
		return list;
	}
	
	/**
	 * 删除开票税率
	 */
	@Override
	@Transactional
	public void deleteReinvoiceRateConfig(Long reinvoiceRateConfigId) {
		Assert.notNull(reinvoiceRateConfigId, "没有要删除的开票税率");
		ReinvoiceRateConfigEntity entity=findById(reinvoiceRateConfigId);
		ReinvoiceRateConfigLogEntity reinvoiceRateConfigLogEntity=new ReinvoiceRateConfigLogEntity();
		BeanUtils.copyProperties(entity, reinvoiceRateConfigLogEntity);
		reinvoiceRateConfigLogRepository.save(reinvoiceRateConfigLogEntity);
		reinvoiceRateConfigRepository.deleteById(reinvoiceRateConfigId);
	}

	@Override
	public ReinvoiceRateConfigEntity findById(Long reinvoiceRateConfigId) {
		return reinvoiceRateConfigRepository.findById(reinvoiceRateConfigId).get();
	}
	
	/**
	 * 修改
	 */
	@Override
	@Transactional
	public void updateReinvoiceRateConfig(ReinvoiceRateConfigUpdateVo vo) {
		Assert.notNull(vo.getReinvoiceRateConfigId(), "没有要修改的开票税率");
		ReinvoiceRateConfigEntity reinvoiceRateConfigEntity=findById(vo.getReinvoiceRateConfigId());
		BeanUtils.copyProperties(vo, reinvoiceRateConfigEntity);
		reinvoiceRateConfigRepository.save(reinvoiceRateConfigEntity);
	}

}
