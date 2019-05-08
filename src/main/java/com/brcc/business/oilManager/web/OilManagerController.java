package com.brcc.business.oilManager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brcc.business.oilManager.service.OilManagerService;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;
import com.esteel.common.controller.WebReturnMessage;
import com.esteel.common.util.RestPageImpl;

/**
 * @author PanJianYang
 * @version 创建时间：2018年12月21日 下午1:01:16
 */
@Controller
@RequestMapping("/business/oilManager")
public class OilManagerController {
	Logger logger = LoggerFactory.getLogger(OilManagerController.class);
	@Autowired
	OilManagerService oilManagerService;

	@ResponseBody
	@RequestMapping(value = "/invoiceCompanyList")
	public Page<OilManagerVo> invoiceCompanyList(@RequestBody OilManagerQueryVo vo) {
		logger.info("oil Manager company list ui,vo:{}", vo.toString());
		return oilManagerService.invoiceCompanyList(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/changeIfVirtualCompany")
	public WebReturnMessage changeIfVirtualCompany(@RequestBody OilManagerQueryVo vo) {
		try {
			Assert.notNull(vo.getSeqId(), "未获取到具体变更的公司id");
			logger.info("change Company IfVirtual status,seqId:{}",vo.getSeqId());
			oilManagerService.changeIfVirtualCompany(vo);
			return new WebReturnMessage(true,"操作成功!");
		}
		catch(Exception e) {
			logger.error("change Company IfVirtual status error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

}
