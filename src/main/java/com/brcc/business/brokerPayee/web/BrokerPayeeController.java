package com.brcc.business.brokerPayee.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.brcc.business.brokerPayee.entity.BrokerPayeeEntity;
import com.brcc.business.brokerPayee.service.BrokerPayeeService;
import com.brcc.business.brokerPayee.vo.BrokerPayeeQueryVo;
import com.brcc.business.brokerPayee.vo.BrokerPayeeVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
@RestController
@RequestMapping("/business/brokerPayee")
public class BrokerPayeeController {
	
	Logger logger = LoggerFactory.getLogger(BrokerPayeeController.class);
	@Autowired
	BrokerPayeeService brokerPayeeService;
	
	/**
	 * 分配收款人管理查询列表
	 */	
	@ResponseBody
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public Page<BrokerPayeeVo> queryList(@RequestBody BrokerPayeeQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<BrokerPayeeVo> page = brokerPayeeService.listDataPage(queryvo);
		return page;
	}
	

	/**
	 * 单个配置信息
	 * 
	 * @param queryvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getlist", method = RequestMethod.POST)
	public BrokerPayeeEntity getlist(@RequestBody Long companyPayeeId) {
		BrokerPayeeEntity entity = brokerPayeeService.findById(companyPayeeId);
		return entity;
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public WebReturnMessage update(@RequestBody BrokerPayeeQueryVo queryvo) {
		logger.info("save broker_payee,CompanyPayeeId:{}", queryvo.getCompanyPayeeId());
		try {
			brokerPayeeService.update(queryvo);
		} catch (Exception e) {
			logger.error("update broker_payee,,message:{}", e.getMessage());
			return new WebReturnMessage(false, "修改失败");
		}
		return new WebReturnMessage(true, "修改成功");
	}
	
	/**
	 * 新增
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public WebReturnMessage save(@RequestBody BrokerPayeeQueryVo queryvo) {
		logger.info("save broker_payee,CompanyPayeeId:{}", queryvo.getCompanyPayeeId());
		try {
			brokerPayeeService.save(queryvo);
		} catch (Exception e) {
			logger.error("save pay_erase,message:{}", e.getMessage());
			return new WebReturnMessage(false, "保存失败");
		}
		return new WebReturnMessage(true, "保存成功");
	}
	
	/**
	 * 生效和作废
	 */
	@ResponseBody
	@RequestMapping(value = "/agreeBrokerPayee", method = RequestMethod.POST)
	public WebReturnMessage agreeBrokerPayee(@RequestBody BrokerPayeeQueryVo queryvo) {
		logger.info("save broker_payee,CompanyPayeeId:{}", queryvo.getCompanyPayeeId());
		try {
			brokerPayeeService.agreeBrokerPayee(queryvo);;
		} catch (Exception e) {
			logger.error("update individual_business,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/listDate", method = RequestMethod.POST)
	public Page<BrokerPayeeVo> list(@RequestBody BrokerPayeeQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<BrokerPayeeVo> page = brokerPayeeService.list(queryvo);
		return page;
	}
	
	

}
