package com.brcc.business.goodsorderOil.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;

public interface IGoodsorderOilRepository {
	Page<GoodsorderOilVo> searchGoodsorderOil(GoodsorderOilQueryVo queryVo);
	List<GoodsorderOilVo> changeOliTypeList(GoodsorderOilQueryVo queryVo);
	List<GoodsorderOilVo> goodsorderOilListExcel(GoodsorderOilQueryVo vo);

}
