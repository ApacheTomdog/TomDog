package com.brcc.business.goodsorderOil.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;
import com.brcc.business.transorder.entity.GoodsordermEntity;

public interface GoodsorderOilService {

	Page<GoodsorderOilVo> searchGoodsorderOil(GoodsorderOilQueryVo queryVo);

	GoodsorderOilVo changeOliType(GoodsorderOilQueryVo queryVo);

	void updateOilType(GoodsordermEntity vo);

	List<GoodsorderOilVo> goodsorderOilListExcel(GoodsorderOilQueryVo vo);

}
