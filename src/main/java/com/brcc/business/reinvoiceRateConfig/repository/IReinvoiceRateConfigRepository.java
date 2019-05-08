package com.brcc.business.reinvoiceRateConfig.repository;

import org.springframework.data.domain.Page;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigVo;

/**
 * 描述:
 * 代开票税率管理
 *
 * @author lijiangying
 * @create 2018-12-11 18:09
 */
public interface IReinvoiceRateConfigRepository {
	
	/**
	 * 展示全部
	 */
	 Page<ReinvoiceRateConfigVo> ReinvoiceRateConfigPage(ReinvoiceRateConfigQueryVo vo);
	 
	 /**
	  * 查詢公司列表
	  */
	 public Page<ReinvoiceRateCompanyNameVo> queryCompanyNameList(ReinvoiceRateCompanyNameQueryVo vo);

}
