package com.brcc.business.home.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.home.repository.GoodsCarRepository;
import com.brcc.business.home.service.GoodsCarService;
import com.brcc.business.home.vo.GoodsCarQueryVo;
import com.brcc.business.home.vo.GoodsCarVo;

@Transactional
@Service
public class GoodsCarServiceImpl implements GoodsCarService{

	@Autowired
	GoodsCarRepository  goodsCarRepository;
	@Override
	public Page<GoodsCarVo> pageListGoods(GoodsCarQueryVo queryVo) {
		// TODO Auto-generated method stub
		return goodsCarRepository.goodsCarRepository(queryVo);
	}

	@Override
	public Page<GoodsCarVo> pageListCars(GoodsCarQueryVo queryVo) {
		// TODO Auto-generated method stub
		return goodsCarRepository.pageListCars(queryVo);
	}

	@Override
	public List<GoodsCarVo> getCity(GoodsCarQueryVo queryVo){
		return goodsCarRepository.getCity(queryVo);
	}
}
