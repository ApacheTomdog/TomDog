package com.brcc.business.home.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.home.vo.GoodsCarQueryVo;
import com.brcc.business.home.vo.GoodsCarVo;

public interface IGoodsCarRepository {

	Page<GoodsCarVo> goodsCarRepository(GoodsCarQueryVo queryVo);

	Page<GoodsCarVo> pageListCars(GoodsCarQueryVo queryVo);
	
	List<GoodsCarVo> getCity(GoodsCarQueryVo queryVo);
}
