package com.brcc.business.goodsorderm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.repository.GoodpricechangelogRepository;
import com.brcc.business.goodsorderm.service.GoodpricechangelogService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;

/**
* @Desc   货源单货物单价修改记录逻辑
* @author TangYong
* @Date   2018-12-05
*/
@Service
public class GoodpricechangelogServiceImpl implements GoodpricechangelogService {
	Logger logger = LoggerFactory.getLogger(GoodpricechangelogServiceImpl.class);
	 
	@Autowired
	GoodpricechangelogRepository goodpricechangelogRepository;

	@Override
	public void save(GoodpricechangelogEntity goodpricechangelogEntity) {
		logger.info("save goodorderm's price modify records!");
		goodpricechangelogRepository.save(goodpricechangelogEntity);
	}

	@Override
	public Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm goods’s price page data,publishId:{}",vo.getPublishId());
		return goodpricechangelogRepository.getGoodPriceLogPageList(vo);
	}
	
}
