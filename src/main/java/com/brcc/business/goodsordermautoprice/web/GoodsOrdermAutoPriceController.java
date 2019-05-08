package com.brcc.business.goodsordermautoprice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.goodsordermautoprice.entity.GoodsordermautopriceEntity;
import com.brcc.business.goodsordermautoprice.service.GoodsordermautopriceService;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceQueryVo;
import com.brcc.business.goodsordermautoprice.vo.AutoPriceVo;
import com.esteel.common.controller.WebReturnMessage;
/**
 * 货主自动调价管理
 * @author mwb
 *
 */
@RestController
@RequestMapping("/goodsordermAutoPrice")
public class GoodsOrdermAutoPriceController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	GoodsordermautopriceService goodsordermautopriceService;
	
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public Page<GoodsordermautopriceEntity> searchList(@RequestBody AutoPriceQueryVo queryVo) {

		logger.info("searchList params:", queryVo.toString());

		return goodsordermautopriceService.searchGoodsordermAutoPrice(queryVo);
	}
	
	@RequestMapping("/change")
	public WebReturnMessage change(@RequestBody GoodsordermautopriceEntity entity) {
		
		logger.info("change params:" + entity.toString());
		goodsordermautopriceService.change(entity);
		
		return WebReturnMessage.sucess;
	}
	@RequestMapping(value = "/publilshIdList", method = RequestMethod.POST)
	public Page<AutoPriceVo> publilshIdList(@RequestBody AutoPriceQueryVo queryVo) {

		logger.info("searchList params:"+queryVo.getPublishInfo());

		return goodsordermautopriceService.publilshIdList(queryVo);
	}
	@RequestMapping("/saveOne")
	public WebReturnMessage saveOne(@RequestBody GoodsordermautopriceEntity entity) {
		
		logger.info("saveOne params:" + entity.toString());
		
		goodsordermautopriceService.save(entity);
		
		return WebReturnMessage.sucess;
	}
	@RequestMapping("/findById")
	public GoodsordermautopriceEntity findById(@RequestBody Long gAId) {
		
		return goodsordermautopriceService.findById(gAId);
	}
	
	@RequestMapping("/update")
	public WebReturnMessage update(@RequestBody GoodsordermautopriceEntity entity) {
		
		
		goodsordermautopriceService.update(entity);
		
		return WebReturnMessage.sucess;
	}
}
