package com.brcc.business.priceClientRate.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.priceClientRate.vo.PriceClientRateQueryVo;
import com.brcc.business.priceClientRate.vo.PriceClientRateVo;
import com.brcc.business.priceClientRate.vo.QueryCompanyVo;

/**
 * 委托承运成本税率维护
 * 
 * @author panyinfang
 *
 */
@Service
public interface PriceClientRateService {
	
	/**
	 * 委托承运成本税率维护列表
	 * 
	 * @param queryvo
	 * @return
	 */
	Page<PriceClientRateVo> listDataPage(PriceClientRateQueryVo queryvo);

	/**
	 * 删除
	 */
	void delPriceClientRateId(Long priceClientRateId);
	
	/**
	 * 新增
	 */
	void savePriceClientRate(PriceClientRateVo vo);
	
	/**
	 * 查看公司列表
	 */
	Page<QueryCompanyVo> queryCompanyName(PriceClientRateQueryVo queryVo);

}
