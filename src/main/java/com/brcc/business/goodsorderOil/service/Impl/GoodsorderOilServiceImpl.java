package com.brcc.business.goodsorderOil.service.Impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.goodsorderOil.repository.GoodsorderOilRepository;
import com.brcc.business.goodsorderOil.service.GoodsorderOilService;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;
import com.brcc.business.transorder.entity.GoodsordermEntity;

import ch.qos.logback.classic.Logger;

@Transactional
@Service
public class GoodsorderOilServiceImpl implements  GoodsorderOilService {
	Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	@Autowired
	GoodsorderOilRepository goodsorderOilRepository;
	@Override
	public Page<GoodsorderOilVo> searchGoodsorderOil(GoodsorderOilQueryVo queryVo) {
		// TODO Auto-generated method stub
		return goodsorderOilRepository.searchGoodsorderOil(queryVo);
	}
	@Override
	public GoodsorderOilVo changeOliType(GoodsorderOilQueryVo queryVo) {
		List <GoodsorderOilVo> list = goodsorderOilRepository.changeOliTypeList(queryVo);
		GoodsorderOilVo vo = list.get(0);
		return vo;
	}
	
	@Override
	public void updateOilType(GoodsordermEntity vo) {
		GoodsordermEntity oldGoodsordermEntity = goodsorderOilRepository.findByPublishId(vo.getPublishId());
		oldGoodsordermEntity.setJsType(vo.getJsType());
		oldGoodsordermEntity.setOilAmount(vo.getOilAmount());
		oldGoodsordermEntity.setOilFlag(vo.getOilFlag());
		oldGoodsordermEntity.setOilRatio(vo.getOilRatio());
		goodsorderOilRepository.save(oldGoodsordermEntity);
	}
	@Override
	public List<GoodsorderOilVo> goodsorderOilListExcel(GoodsorderOilQueryVo vo) {
	
		
		return goodsorderOilRepository.goodsorderOilListExcel(vo);
	}

}
