package com.brcc.business.brokerTax.web;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.brokerTax.service.BrokerTaxCycleService;
import com.brcc.business.brokerTax.service.BrokerTaxDetailService;
import com.brcc.business.brokerTax.service.BrokerTaxMasterService;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxDetailVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterQueryVo;
import com.brcc.business.brokerTax.vo.BrokerTaxMasterVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * 	 经纪人季度收入统计
 * 
 * @author hui.liu
 * @date 2018年11月29日
 */
@RestController
@RequestMapping("/business/brokerTax")
public class BrokerTaxController {
	Logger logger = LoggerFactory.getLogger(BrokerTaxController.class);
	
	@Autowired
	private BrokerTaxMasterService brokerTaxMasterService;
	
	@Autowired
	private BrokerTaxCycleService brokerTaxCycleService;
	
	@Autowired
	private BrokerTaxDetailService brokerTaxDetailService;

	/**
	 * 	经纪人季度收入统计列表
	 */
	@RequestMapping(value = "/queryPage", method = RequestMethod.POST)
	public Page<BrokerTaxMasterVo> queryPage(@RequestBody BrokerTaxMasterQueryVo queryVo) {
		logger.info("queryPage,{}", queryVo.toString());
		return brokerTaxMasterService.queryPage(queryVo);
	}
	
	/**
	 * 	获取季度配置中的季度列表
	 */
	@RequestMapping(value = "/queryCycleList", method = RequestMethod.GET)
	public List<BrokerTaxCycleVo> queryCycleList() {
		logger.info("queryCycleList");
		return brokerTaxCycleService.queryCycleList();
	}

	/**
	 * 	经纪人季度收入统计列表明细
	 */
	@RequestMapping(value = "/queryDetailPage", method = RequestMethod.POST)
	public Page<BrokerTaxDetailVo> queryDetailPage(@RequestBody BrokerTaxDetailQueryVo queryVo) {
		Assert.notNull(queryVo.getBrokerId(), "经纪人ID不能为空");
		Assert.isTrue(!StringUtils.isEmpty(queryVo.getBrokerTaxQuarter()), "季度不能为空");
		
		logger.info("queryDetailPage,{}", queryVo.toString());
		return brokerTaxDetailService.queryDetailPage(queryVo);
	}
	
	/**
	 * 单个经纪人季度收入统计列表
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public Page<BrokerTaxMasterVo> queryList(@RequestBody BrokerTaxMasterQueryVo queryVo) {
		logger.info("queryList,{}", queryVo.toString());		
		Assert.notNull(queryVo.getBrokerId(), "经纪人ID不能为空");
		return brokerTaxMasterService.queryList(queryVo);
	}
	
	/**
	 * 单个经纪人的净收入金额
	 */
	@ResponseBody
	@RequestMapping(value ="/totProfitAmtpage")
	public WebReturnMessage totProfitAmt(@RequestBody BrokerTaxMasterQueryVo queryVo) {
		logger.info("totProfitAmt,{}", queryVo.getBrokerId());		
		Assert.notNull(queryVo.getBrokerId(), "经纪人ID不能为空");
		
		try {
			brokerTaxMasterService.totProfitAmt(queryVo);
		} catch (Exception e) {
			return new WebReturnMessage(false, e.getMessage());
		}
		BigDecimal totProfitAmt=brokerTaxMasterService.totProfitAmt(queryVo);
		if(totProfitAmt==null) {
			totProfitAmt= new BigDecimal("0");
		}
		return new WebReturnMessage(true,totProfitAmt.toString());
	}
}
