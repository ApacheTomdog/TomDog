package com.brcc.business.goodsordermautoprice.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.repository.GoodsordermautopriceRepository;
import com.brcc.business.goodsordermautoprice.service.GoodsordermautopriceService;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceVo;

@Transactional
@Service
public class GoodsordermautopriceServiceImpl implements GoodsordermautopriceService{

	@Autowired
	GoodsordermautopriceRepository goodsordermautopriceRepository;
	@Override
	public Page<GoodsordermautopriceEntity> searchGoodsordermAutoPrice(AutoPriceQueryVo queryVo) {
		return goodsordermautopriceRepository.searchGoodsordermAutoPrice(queryVo);
	}
	@Override
	public void change(GoodsordermautopriceEntity entity) {
		GoodsordermautopriceEntity oldGoodsordermautopriceEntity  =  goodsordermautopriceRepository.findByGAId(entity.getgAId());
		oldGoodsordermautopriceEntity.setCompanyStatus(entity.getCompanyStatus());
		oldGoodsordermautopriceEntity.setModifyDate(new Date());
		oldGoodsordermautopriceEntity.setModifyPersonId(entity.getModifyPersonId());
		oldGoodsordermautopriceEntity.setModifyPersonName(entity.getModifyPersonName());
		goodsordermautopriceRepository.save(oldGoodsordermautopriceEntity);
	}
	@Override
	public Page<AutoPriceVo> publilshIdList(AutoPriceQueryVo queryVo) {
		return goodsordermautopriceRepository.publilshIdList(queryVo);
	}
	@Override
	public void save(GoodsordermautopriceEntity entity) {
//		List<GoodsordermautopriceEntity> list  = goodsordermautopriceRepository.onlyOne(entity);
//		Assert.isTrue(list.size() == 0, "操作失败：存在重复的记录！");
		goodsordermautopriceRepository.save(entity);
	}
	@Override
	public GoodsordermautopriceEntity findById(Long gAId) {
		// TODO Auto-generated method stub
		return goodsordermautopriceRepository.findByGAId(gAId);
	}
	@Override
	public void update(GoodsordermautopriceEntity entity) {
		GoodsordermautopriceEntity oldGoodsordermautopriceEntity  =  goodsordermautopriceRepository.findByGAId(entity.getgAId());
		oldGoodsordermautopriceEntity.setModifyDate(new Date());
		oldGoodsordermautopriceEntity.setModifyPersonId(entity.getModifyPersonId());
		oldGoodsordermautopriceEntity.setModifyPersonName(entity.getModifyPersonName());
		oldGoodsordermautopriceEntity.setTimingTypeTime(entity.getTimingTypeTime());
		oldGoodsordermautopriceEntity.setAutoPriceTimingType(entity.getAutoPriceTimingType());
		oldGoodsordermautopriceEntity.setAutoPriceRange("1");
		oldGoodsordermautopriceEntity.setPriceType(entity.getPriceType());
		oldGoodsordermautopriceEntity.setPrice(entity.getPrice());
		oldGoodsordermautopriceEntity.setTimingCycle(entity.getTimingCycle());
		goodsordermautopriceRepository.save(oldGoodsordermautopriceEntity);
	}

}
