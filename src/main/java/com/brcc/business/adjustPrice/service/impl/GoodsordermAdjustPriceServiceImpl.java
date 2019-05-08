package com.brcc.business.adjustPrice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;
import com.brcc.business.adjustPrice.repository.GoodsordermAdjustPriceRepository;
import com.brcc.business.adjustPrice.service.GoodsordermAdjustPriceService;
import com.brcc.business.adjustPrice.vo.GoodsordermAdjustPriceQueryVo;

/**
 * @Description 货主调价记录
 * @Auther lijiangying
 * @Date Created in 14:01 2018/12/5
 */
@Service
public class GoodsordermAdjustPriceServiceImpl implements GoodsordermAdjustPriceService{
	
	@Autowired
	private GoodsordermAdjustPriceRepository goodsordermAdjustPriceRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Page<GoodsordermAdjustPriceEntity> listAdjustPrice(
			GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo) {
		return goodsordermAdjustPriceRepository.listAdjustPrice(goodsordermAdjustPriceQueryVo);
	}

	@Override
	public List<GoodsordermAdjustPriceEntity> exportAdjustPrice(
			GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo) {
		return goodsordermAdjustPriceRepository.queryAdjustPrice(goodsordermAdjustPriceQueryVo);
	}

}
