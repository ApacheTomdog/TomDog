/**
 * 
 */
package com.brcc.business.flow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.flow.repository.VatflowmasterRepository;
import com.brcc.business.flow.service.VatflowmasterService;
import com.brcc.business.flow.vo.VatflowmasterVo;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class VatflowmasterServiceImpl implements VatflowmasterService {
	
	@Autowired
	VatflowmasterRepository vatflowmasterRepository;

	@Override
	public Page<VatflowmasterVo> findVatflowmasterByCompanyId(GoodsordermQueryVo vo) {
		Page<VatflowmasterVo> page = vatflowmasterRepository.findVatflowmasterByCompanyId(vo);
		return page;
	}

}
