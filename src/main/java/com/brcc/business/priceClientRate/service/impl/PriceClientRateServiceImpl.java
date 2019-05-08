package com.brcc.business.priceClientRate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.priceClientRate.entity.PriceClientRateEntity;
import com.brcc.business.priceClientRate.repository.PriceClientRateRepository;
import com.brcc.business.priceClientRate.service.PriceClientRateService;
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
@Transactional
public class PriceClientRateServiceImpl implements PriceClientRateService{
	Logger logger = LoggerFactory.getLogger(PriceClientRateServiceImpl.class);
	@Autowired
	PriceClientRateRepository priceClientRateRepository;

	@Override
	public Page<PriceClientRateVo> listDataPage(PriceClientRateQueryVo queryvo) {
		
		return priceClientRateRepository.listDataPage(queryvo);
	}

	@Override
	public void delPriceClientRateId(Long priceClientRateId) {
		
		priceClientRateRepository.deleteById(priceClientRateId);
	}

	@Override
	public void savePriceClientRate(PriceClientRateVo vo) {
		int num=priceClientRateRepository.checkCompany(vo.getClientId(), vo.getCarryId());
		Assert.isTrue(num == 0, "每个货主公司只能维护一条信息，请勿多次添加！");
		PriceClientRateEntity entity = new PriceClientRateEntity();		
		BeanUtils.copyProperties(vo, entity);		
		priceClientRateRepository.save(entity);
		
	}

	@Override
	public Page<QueryCompanyVo> queryCompanyName(PriceClientRateQueryVo queryVo) {
		
		return priceClientRateRepository.queryCompanyName(queryVo);
	}

}
