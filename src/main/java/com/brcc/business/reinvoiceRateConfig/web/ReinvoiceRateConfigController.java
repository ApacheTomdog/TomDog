package com.brcc.business.reinvoiceRateConfig.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.reinvoiceRateConfig.entity.ReinvoiceRateConfigEntity;
import com.brcc.business.reinvoiceRateConfig.service.ReinvoiceRateConfigService;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigAddVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigUpdateVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigVo;
import com.esteel.common.controller.WebReturnMessage;


@RestController
@RequestMapping("/reinvoiceRateConfig")
public class ReinvoiceRateConfigController {
	 Logger logger = LoggerFactory.getLogger(ReinvoiceRateConfigController.class);
	 
	 @Autowired
	 private ReinvoiceRateConfigService reinvoiceRateConfigService;
	 
	 @RequestMapping(value = "/reinvoiceRateConfigPage", method = RequestMethod.POST)
	 public Page<ReinvoiceRateConfigVo> ReinvoiceRateConfigPage(@RequestBody ReinvoiceRateConfigQueryVo vo){
		 return reinvoiceRateConfigService.ReinvoiceRateConfigPage(vo);
	 }
	 
	 /**
		 * 添加開票公司
		 */
		@ResponseBody
		@RequestMapping("/saveReinvoiceRateConfig")
		public WebReturnMessage saveReinvoiceRateConfig(@RequestBody ReinvoiceRateConfigAddVo vo) {
			logger.info("save reinvoice_rate_config,ibId:{}", vo.getCompanyId());
			try {
				reinvoiceRateConfigService.saveReinvoiceRateConfig(vo);
			} catch (Exception e) {
				logger.error("save individual_business,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
			return new WebReturnMessage(true, "添加成功");
		}
		
		/**
		 * 查询公司列表 
		 */
		@RequestMapping(value = "/queryCompanyNameList", method = RequestMethod.POST)
		public Page<ReinvoiceRateCompanyNameVo> queryCompanyNameList(@RequestBody ReinvoiceRateCompanyNameQueryVo vo){
			return reinvoiceRateConfigService.queryCompanyNameList(vo);
		}
		
		/**
		 * 删除开票
		 */
		@ResponseBody
		@RequestMapping("/deleteReinvoiceRateConfig")
		public WebReturnMessage deleteReinvoiceRateConfig(@RequestBody Long reinvoiceRateConfigId) {
			logger.info("delete reinvoice_rate_config,ibId:{}", reinvoiceRateConfigId);
			try {
				reinvoiceRateConfigService.deleteReinvoiceRateConfig(reinvoiceRateConfigId);
			} catch (Exception e) {
				logger.error("delete individual_business,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
			return new WebReturnMessage(true, "删除成功");
		}
		/**
		 * 修改
		 */
		@ResponseBody
		@RequestMapping("/updateReinvoiceRateConfig")
		public WebReturnMessage updateReinvoiceRateConfig(@RequestBody ReinvoiceRateConfigUpdateVo vo) {
			logger.info("delete reinvoice_rate_config,ibId:{}", vo.getReinvoiceRateConfigId());
			try {
				reinvoiceRateConfigService.updateReinvoiceRateConfig(vo);
			} catch (Exception e) {
				logger.error("update individual_business,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
			return new WebReturnMessage(true, "修改成功");
		}
		/**
		 * 查询详情
		 */
		@ResponseBody
		@RequestMapping("/findById")
		 public ReinvoiceRateConfigEntity findById(@RequestBody Long reinvoiceRateConfigId) {
			 return reinvoiceRateConfigService.findById(reinvoiceRateConfigId);
		 }
}
