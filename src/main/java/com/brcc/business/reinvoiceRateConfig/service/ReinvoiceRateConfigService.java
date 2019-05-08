package com.brcc.business.reinvoiceRateConfig.service;

import org.springframework.data.domain.Page;

import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigEntity;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigAddVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigUpdateVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigVo;

public interface ReinvoiceRateConfigService {
	public Page<ReinvoiceRateConfigVo> ReinvoiceRateConfigPage(ReinvoiceRateConfigQueryVo vo);
	public void saveReinvoiceRateConfig(ReinvoiceRateConfigAddVo vo);
	public Page<ReinvoiceRateCompanyNameVo> queryCompanyNameList(ReinvoiceRateCompanyNameQueryVo vo);
	public void deleteReinvoiceRateConfig(Long reinvoiceRateConfigId);
	public ReinvoiceRateConfigEntity findById(Long reinvoiceRateConfigId);
	public void updateReinvoiceRateConfig(ReinvoiceRateConfigUpdateVo vo);
}
