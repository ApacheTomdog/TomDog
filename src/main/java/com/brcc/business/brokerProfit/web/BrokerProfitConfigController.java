package com.brcc.business.brokerProfit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brcc.business.brokerProfit.entity.BrokerProfitConfigEntity;
import com.brcc.business.brokerProfit.service.BrokerProfitConfigService;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigAddVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigModifyVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * 经纪人最高分润配置
 * @author dzj
 * @date 2019-01-29
 */
@Controller
@RequestMapping("/broker/profit")
public class BrokerProfitConfigController {

	Logger logger = LoggerFactory.getLogger(BrokerProfitConfigController.class);

	@Autowired
	private BrokerProfitConfigService brokerProfitConfigService;

	/**
	 *	获取数据
	 */
	@ResponseBody
	@RequestMapping(value = "/data")
	public Page<BrokerProfitConfigVo> data(@RequestBody BrokerProfitConfigQueryVo queryVo) {
		logger.info("Query BrokerProfitConfig List, {}", queryVo);
		return brokerProfitConfigService.data(queryVo);
	}

	/**
	 * 	新增
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public WebReturnMessage add(@RequestBody BrokerProfitConfigAddVo addVo) {
		logger.info("Add BrokerProfitConfig, {}", addVo);
		try {
			brokerProfitConfigService.add(addVo);
		} catch (Exception e) {
			logger.error("Add BrokerProfitConfig Throw Exception, {}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "新增成功!");
	}

	/**
	 * 	修改
	 */
	@ResponseBody
	@RequestMapping(value = "/modify")
	public WebReturnMessage modify(@RequestBody BrokerProfitConfigModifyVo modifyVo) {
		logger.info("Modify BrokerProfitConfig, {}", modifyVo);
		try {
			brokerProfitConfigService.modify(modifyVo);
		} catch (Exception e) {
			logger.error("Modify BrokerProfitConfig Throw Exception, {}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "修改成功!");
	}
	
	/**
	 * 	作废
	 */
	@ResponseBody
	@RequestMapping(value = "/cancel")
	public WebReturnMessage cancel(@RequestBody BrokerProfitConfigModifyVo modifyVo) {
		logger.info("Cancel BrokerProfitConfig, {}", modifyVo);
		try {
			brokerProfitConfigService.cancel(modifyVo);
		} catch (Exception e) {
			logger.error("Cancel BrokerProfitConfig Throw Exception, {}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "作废成功!");
	}
	
	/**
	 * 	生效
	 */
	@ResponseBody
	@RequestMapping(value = "/audit")
	public WebReturnMessage audit(@RequestBody BrokerProfitConfigModifyVo modifyVo) {
		logger.info("Audit BrokerProfitConfig, {}", modifyVo);
		try {
			brokerProfitConfigService.audit(modifyVo);
		} catch (Exception e) {
			logger.error("Audit BrokerProfitConfig Throw Exception, {}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "生效成功!");
	}
	
	
	/**
	 *	查询经纪人是否是特例配置
	 */
	@ResponseBody
	@RequestMapping(value = "/querySpecialCase")
	public BrokerProfitConfigEntity querySpecialCase(@RequestBody BrokerProfitConfigQueryVo queryVo) {
		logger.info("Query if Special Case, {}", queryVo.toString());
		return brokerProfitConfigService.querySpecialCase(queryVo);
	}

	/**
	 *	询经纪人的常规配置(平台统一)
	 */
	@ResponseBody
	@RequestMapping(value = "/queryNormalCase")
	public BrokerProfitConfigEntity queryNormalCase() {
		logger.info("Query Normal Case, {}");
		return brokerProfitConfigService.queryNormalCase();
	}
}
