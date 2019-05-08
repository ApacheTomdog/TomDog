package com.brcc.business.blackbroker.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.service.BlackbrokerService;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.blackbroker.vo.blackBrokerVo;
import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.esteel.common.controller.WebReturnMessage;
@RestController
@RequestMapping("/blackBroker")
public class BlackBrokerController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BlackbrokerService blackbrokerService;
	
	
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public Page<BlackbrokerEntity> searchList(@RequestBody blackBrokerQueryVo queryVo) {

		logger.info("searchList params:", queryVo.toString());

		return blackbrokerService.searchBlackBroker(queryVo);
	}
	
	@RequestMapping(value = "/findCompanyName", method = RequestMethod.POST)
	public Page<blackBrokerVo> findCompanyName(@RequestBody blackBrokerQueryVo queryVo) {

		logger.info("findCompanyName params:", queryVo.toString());

		return blackbrokerService.findCompanyName(queryVo);
	}
	
	@RequestMapping("/saveOne")
	public WebReturnMessage saveOne(@RequestBody BlackbrokerEntity BlackbrokerEntity) {
		
		logger.info("searchOne params:" + BlackbrokerEntity.toString());
		
		blackbrokerService.save(BlackbrokerEntity);
		
		return WebReturnMessage.sucess;
	}
	
	@RequestMapping("/change")
	public WebReturnMessage change(@RequestBody BlackbrokerEntity BlackbrokerEntity) {
		
		logger.info("change params:" + BlackbrokerEntity.toString());
		blackbrokerService.change(BlackbrokerEntity);
		
		return WebReturnMessage.sucess;
	}
}
