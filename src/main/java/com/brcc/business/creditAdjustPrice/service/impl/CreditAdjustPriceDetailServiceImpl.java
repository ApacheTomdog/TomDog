package com.brcc.business.creditAdjustPrice.service.impl;

import java.util.List;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.creditAdjustPrice.repository.CreditAdjustPriceDetailRepository;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailService;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;

/**
 * @Desc:   授信调价明细业务逻辑实现类
 * @author: TangYong
 * @Date:   2018-11-19
 */
@Service
public class CreditAdjustPriceDetailServiceImpl implements CreditAdjustPriceDetailService {

	Logger logger = LoggerFactory.getLogger(CreditAdjustPriceDetailServiceImpl.class);

    @Autowired
    CreditAdjustPriceDetailRepository creditAdjustPriceDetailRepository;

	@Override
	public List<CreditAdjustPriceDetailVo> queryCreditAddPrice(CreditAdjustPriceDetailQueryVo priceDetailQueryVo) {
		logger.info("query CreditAdjustPriceDetailVo list ,companyId:{}",priceDetailQueryVo.getCompanyId());
		return creditAdjustPriceDetailRepository.queryCreditAddPrice(priceDetailQueryVo);
	}
	
	@Override
	public List<CreditAdjustPriceDetailVo> queryCreditDetailPriceList(CreditAdjustPriceDetailQueryVo priceDetailQueryVo) {
		logger.info("query CreditAdjustPriceDetailVo list ,companyId:{}",priceDetailQueryVo.getCompanyId());
		return creditAdjustPriceDetailRepository.queryCreditDetailPriceList(priceDetailQueryVo);
	}

	@Override
	public CreditAdjustPriceDetailEntity findByCredAdjDId(Long credAdjDId) {
		return creditAdjustPriceDetailRepository.findByCredAdjDId(credAdjDId);
	}

	@Override
	public Integer deleteByCredAdjDId(Long credAdjDId) {
		return creditAdjustPriceDetailRepository.deleteByCredAdjDId(credAdjDId);
	}

	@Override
	public List<CreditAdjustPriceDetailEntity> findListByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
		return creditAdjustPriceDetailRepository.findListByCredAdjMId(creditAdjustPriceQuerySearchVo);
	}

	@Override
	public Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
		return creditAdjustPriceDetailRepository.findByCredAdjMId(creditAdjustPriceQuerySearchVo);
	}

	@Override
	public CreditAdjustPriceDetailEntity save(CreditAdjustPriceDetailEntity v) {
		return creditAdjustPriceDetailRepository.save(v);
	}

	@Override
	public boolean existsByCredAdjMId(Long mid) {
		return creditAdjustPriceDetailRepository.existsByCredAdjMId(mid);
	}
}
