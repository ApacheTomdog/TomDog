package com.brcc.business.adjustPrice.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brcc.business.adjustPrice.entity.GoodsordermAdjustPriceEntity;
import com.brcc.business.adjustPrice.service.GoodsordermAdjustPriceService;
import com.brcc.business.adjustPrice.vo.GoodsordermAdjustPriceQueryVo;

@RestController
@RequestMapping("/goodsordermAdjustPrice")
public class GoodsordermAdjustPriceController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GoodsordermAdjustPriceService goodsordermAdjustPriceService;
	
	/**
	 * 
	 * @author lijiangying
	 * @date 2018年12月5日
	 * @param goodsordermAdjustPriceQueryVo
	 * @return
	 */
	@RequestMapping(value = "/listAdjustPrice")
	public Page<GoodsordermAdjustPriceEntity> listAdjustPrice(@RequestBody GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo){
		logger.info("listAdjustPrice params:", goodsordermAdjustPriceQueryVo.toString());
		Page<GoodsordermAdjustPriceEntity> page = goodsordermAdjustPriceService.listAdjustPrice(goodsordermAdjustPriceQueryVo);
		return page;
	}
	/**
	 * 
	 * @author lijiangying
	 * @date 2018年12月5日
	 * @param goodsordermAdjustPriceQueryVo
	 * @return 导出记录
	 */
	@RequestMapping(value = "/exportAdjustPrice")
	public List<GoodsordermAdjustPriceEntity>exportAdjustPrice(@RequestBody GoodsordermAdjustPriceQueryVo goodsordermAdjustPriceQueryVo){
		return goodsordermAdjustPriceService.exportAdjustPrice(goodsordermAdjustPriceQueryVo);
	}
}
