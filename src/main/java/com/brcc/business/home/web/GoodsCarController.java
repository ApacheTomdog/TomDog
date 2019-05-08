package com.brcc.business.home.web;

import java.util.List;

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
import com.brcc.business.home.service.GoodsCarService;
import com.brcc.business.home.vo.GoodsCarQueryVo;
import com.brcc.business.home.vo.GoodsCarVo;

@RestController
@RequestMapping("/goodscar")
public class GoodsCarController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsCarService goodsCarService;
	
	@RequestMapping(value = "/pageListGoods", method = RequestMethod.POST)
	public Page<GoodsCarVo> pageListGoods(@RequestBody GoodsCarQueryVo queryVo) {

		logger.info("searchList params:", queryVo.toString());

		return goodsCarService.pageListGoods(queryVo);
	}
	
	@RequestMapping(value = "/pageListCars", method = RequestMethod.POST)
	public Page<GoodsCarVo> pageListCars(@RequestBody GoodsCarQueryVo queryVo) {

		logger.info("searchList params:", queryVo.toString());

		return goodsCarService.pageListCars(queryVo);
	}
	@RequestMapping(value = "/getCity", method = RequestMethod.POST)
	public List<GoodsCarVo> getCity(@RequestBody GoodsCarQueryVo queryVo){
		return goodsCarService.getCity(queryVo);
	}
}
