package com.brcc.business.priceChange.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.priceChange.entity.PriceChangeEntity;
import com.brcc.business.priceChange.service.PriceChangeService;
import com.brcc.business.priceChange.vo.PriceChangeQueryVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
@RestController
@RequestMapping("/priceChange")
public class PriceChangeController {
	
	Logger logger = LoggerFactory.getLogger(PriceChangeController.class);
	@Autowired
	PriceChangeService priceChangeService;
	
	
	/**
	 * 委托承运货源审核管理列表
	 * 
	 * @param queryvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/listDataList", method = RequestMethod.POST)
	public Page<PriceChangeVo> listDataList(@RequestBody PriceChangeQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<PriceChangeVo> page = priceChangeService.listDataList(queryvo);
		return page;
	}
	
	/**
	 * 委托承运调价管理列表
	 * 
	 * @param queryvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public Page<PriceChangeVo> queryList(@RequestBody PriceChangeQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<PriceChangeVo> page = priceChangeService.queryList(queryvo);
		return page;
	}
	
	
	/**
	 * 插入
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public WebReturnMessage save(@RequestBody PriceChangeVo vo) {
		logger.info("save PriceChange,ibId:{}", vo.getPriceChangeId());
		try {
			priceChangeService.save(vo);
		} catch (Exception e) {
			logger.error("save PriceChange,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	/**
	 * 委托承运货源审核管理作废
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delPriceChange")
	public WebReturnMessage delPriceChange(@RequestBody PriceChangeVo vo) {
		logger.info("save PriceChange,ibId:{}", vo.getPriceChangeId());
		try {
			priceChangeService.delPriceChange(vo);
		} catch (Exception e) {
			logger.error("save PriceChange,message:{}", e.getMessage());
			return new WebReturnMessage(false,"操作失败");
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	/**
	 * 委托承运调价管理 保存
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveUpdate")
	public WebReturnMessage saveUpdate(@RequestBody PriceChangeVo vo) {
		logger.info("save PriceChange,ibId:{}", vo.getPriceChangeId());
		try {
			priceChangeService.saveUpdate(vo);
		} catch (Exception e) {
			logger.error("save PriceChange,message:{}", e.getMessage());
			return new WebReturnMessage(false, "操作失败");
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	
	/**
	 * 委托承运货源审核管理查询价格
	 */
	@ResponseBody
	@RequestMapping(value = "/getPrice", method = RequestMethod.POST)
	public PriceChangeVo getPrice(@RequestBody PriceChangeVo voo) {
		PriceChangeVo vo = priceChangeService.getPrice(voo);
		return vo;
	}

	
	/**
	 * 委托承运调价管理查询价格
	 */
	@ResponseBody
	@RequestMapping(value = "/getPriceTJ", method = RequestMethod.POST)
	public PriceChangeVo getPriceTJ(@RequestBody PriceChangeVo voo) {
		PriceChangeVo vo = priceChangeService.getPriceTJ(voo);
		return vo;
	}

}
