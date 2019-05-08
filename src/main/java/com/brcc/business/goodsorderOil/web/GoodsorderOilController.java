package com.brcc.business.goodsorderOil.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.goodsorderOil.service.GoodsorderOilService;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilQueryVo;
import com.brcc.business.goodsorderOil.vo.GoodsorderOilVo;
import com.brcc.business.transorder.entity.GoodsordermEntity;
import com.esteel.common.controller.WebReturnMessage;

@RestController
@RequestMapping("/goodsorderOil")
public class GoodsorderOilController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	GoodsorderOilService goodsorderOilService;
	
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public Page<GoodsorderOilVo> searchList(@RequestBody GoodsorderOilQueryVo queryVo) {

		logger.info("searchList params:", queryVo.toString());

		return goodsorderOilService.searchGoodsorderOil(queryVo);
	}
	
	/**
	 * 货源单结算方式修改
	 */
	@RequestMapping("/changeOliType")
	public GoodsorderOilVo changeOliType(@RequestBody GoodsorderOilQueryVo queryVo) {
		Assert.notNull(queryVo.getPublishId(),"货源单号不存在！");
		return goodsorderOilService.changeOliType(queryVo);
	}
	@RequestMapping("/updateOilType")
	public WebReturnMessage updateOilType(@RequestBody GoodsordermEntity vo) {
		goodsorderOilService.updateOilType(vo);
		return WebReturnMessage.sucess;
	}
	@RequestMapping("/goodsorderOilListExcel")
	public  List<GoodsorderOilVo> goodsorderOilListExcel(@RequestBody GoodsorderOilQueryVo vo){
		return goodsorderOilService.goodsorderOilListExcel(vo);
	}
}
