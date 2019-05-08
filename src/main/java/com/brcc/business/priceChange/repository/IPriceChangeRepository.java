package com.brcc.business.priceChange.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.priceChange.vo.CompanyVo;
import com.brcc.business.priceChange.vo.PriceChangeQueryVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public interface IPriceChangeRepository {
	/**
	 * 委托承运货源审核管理列表
	 */
	Page<PriceChangeVo> listDataPage(PriceChangeQueryVo queryvo);
	/**
	 * 委托承运调价管理列表
	 */
	Page<PriceChangeVo> queryList(PriceChangeQueryVo queryvo);

	/**
	 * 查询公司名和id
	 */
	CompanyVo getCompany(Long publishId);
	

}
