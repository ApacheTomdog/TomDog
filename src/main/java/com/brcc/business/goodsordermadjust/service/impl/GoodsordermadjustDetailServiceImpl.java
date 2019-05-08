package com.brcc.business.goodsordermadjust.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;
import com.brcc.business.goodsordermadjust.repository.GoodsordermadjustDetailRepository;
import com.brcc.business.goodsordermadjust.service.GoodsordermadjustDetailService;

/**
* @Desc   货源单调价明细逻辑接口实现
* @author TangYong
* @Date   2018-11-24
*/
@Service
public class GoodsordermadjustDetailServiceImpl implements GoodsordermadjustDetailService{

    Logger logger = LoggerFactory.getLogger(GoodsordermadjustDetailServiceImpl.class);
    
    @Autowired
    GoodsordermadjustDetailRepository goodsordermadjustDetailRepository;
    
	@Override
	public void save(GoodsordermadjustdetailEntity enity) {
		logger.info("save GoodsordermadjustdetailEntity");
		goodsordermadjustDetailRepository.save(enity);
	}
   
	@Override
	public List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo) {
		logger.info("query GoodsordermadjustdetailVo list,publishId is:{}",vo.getPublishId());	
		return goodsordermadjustDetailRepository.lookSxDatilList(vo);
	}
}
