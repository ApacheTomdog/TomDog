package com.brcc.business.goodsorderm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;
import com.brcc.business.goodsorderm.repository.GoodsorderquotationRepository;
import com.brcc.business.goodsorderm.service.GoodsorderquotationService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;

/**
* @Desc   货源单报价记录逻辑
* @author TangYong
* @Date   2018-12-05
*/
@Service
public class GoodsorderquotationServiceImpl implements GoodsorderquotationService {
	Logger logger = LoggerFactory.getLogger(GoodsorderquotationServiceImpl.class);
	 
	@Autowired
	GoodsorderquotationRepository goodsorderquotationRepository;

	@Override
	public List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo) {
		logger.info("query GoodsorderquotationVo list,publishId is:{}",vo.getPublishId());
		return goodsorderquotationRepository.getBaoJiaList(vo);
	}

	@Override
	public Long queryBaojiaCounts(GoodsorderquotationQueryVo queryVo) {
		logger.info("query the bid times,publishId is:{},companyId:{}",queryVo.getPublishId(),queryVo.getCompanyId());
		return goodsorderquotationRepository.queryBaojiaCounts(queryVo.getPublishId(),queryVo.getPlatFormId(),queryVo.getCompanyId());
	}

	@Override
	public GoodsorderquotationEntity save(GoodsorderquotationEntity quotationEntity) {
		logger.info("save GoodsorderquotationEntity records");
		return goodsorderquotationRepository.save(quotationEntity);
	}

	@Override
	public GoodsorderquotationEntity findById(Long quotationId) {
		logger.info("query GoodsorderquotationEntity records by quatationId:{}",quotationId);
		return goodsorderquotationRepository.findById(quotationId).get();
	}

	@Override
	public GoodsorderquotationVo getBaojiaInfo(GoodsorderquotationQueryVo vo) {
		logger.info("query GoodsorderquotationVo records by quatationId:{}",vo.getQuotationId());
		return goodsorderquotationRepository.getBaojiaInfo(vo);
	}

	@Override
	public List<GoodsorderquotationVo> getOtherBaojiaMessage(GoodsorderquotationVo vo) {
		logger.info("query GoodsorderquotationVo other records by quatationId:{}",vo.getQuotationId());
		return goodsorderquotationRepository.getOtherBaojiaMessage(vo);
	}
	
}
