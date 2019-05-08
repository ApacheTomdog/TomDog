package com.brcc.business.priceClientRate.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.priceClientRate.vo.PriceClientRateQueryVo;
import com.brcc.business.priceClientRate.vo.PriceClientRateVo;
import com.brcc.business.priceClientRate.vo.QueryCompanyVo;

public interface IPriceClientRateRepository {
	
	/**
	 * 列表
	 */
	Page<PriceClientRateVo> listDataPage(PriceClientRateQueryVo queryvo);
	/**
	 * 查询公司
	 * @param queryVo
	 * @return
	 */
	Page<QueryCompanyVo> queryCompanyName(PriceClientRateQueryVo queryVo);

}
