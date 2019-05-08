/**
 * 
 */
package com.brcc.business.creditAmountAdjust.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.service.CreditAmountAdjustService;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigModifyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月3日
 * 
 */
@RestController
@RequestMapping("/creditAmountAdjust")
public class CreditAmountAdjustController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CreditAmountAdjustService creditAmountAdjustService;

	/**
	 * 
	 * @author:陈利
	 * @date:2018年11月3日
	 * @param creditAmountAdjustQueryVo
	 * @return
	 */
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public Page<CreditAmountAdjustEntity> searchCreditAmountAdjust(@RequestBody CreditAmountAdjustQueryVo creditAmountAdjustQueryVo) {

		logger.info("searchList params:", creditAmountAdjustQueryVo.toString());

		return creditAmountAdjustService.searchCreditAmountAdjust(creditAmountAdjustQueryVo);
	}

	/**
	 * 
	 * @author:陈利
	 * @date:2018年11月3日
	 * @param creditAmountAdjustQueryVo
	 * @return
	 */
	@RequestMapping(value = "/searchByOne", method = RequestMethod.POST)
	public CreditAmountAdjustEntity searchByOne(@RequestBody CreditAmountAdjustQueryVo creditAmountAdjustQueryVo) {
		
		logger.info("searchOne params:" + creditAmountAdjustQueryVo.toString());
		
		Assert.isTrue(creditAmountAdjustQueryVo.getCredAmtAdjId() != null, "主键不能为空!");
		
		return creditAmountAdjustService.searchByOne(creditAmountAdjustQueryVo);
	}

	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月5日
	 * @param creditAmountAdjustEntity
	 * @return
	 */
	@RequestMapping("/saveOne")
	public WebReturnMessage saveObject(@RequestBody CreditAmountAdjustEntity creditAmountAdjustEntity) {
		
		logger.info("searchOne params:" + creditAmountAdjustEntity.toString());
		
		creditAmountAdjustService.save(creditAmountAdjustEntity);
		
		return WebReturnMessage.sucess;
	}

	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月5日
	 * @param creditAmountAdjustEntity
	 * @return
	 */
	@RequestMapping("/modifyOne")
	public WebReturnMessage modifyObject(@RequestBody CreditAmountAdjustEntity creditAmountAdjustEntity) {
		
		logger.info("modifyOne params:" + creditAmountAdjustEntity.toString());
		
		Assert.isTrue(creditAmountAdjustEntity.getCredAmtAdjId() != null, "主键不能为空!");
		
		creditAmountAdjustService.modify(creditAmountAdjustEntity);
		
		return WebReturnMessage.sucess;
	}
	
	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月13日
	 * @param creditAmountAdjustEntity
	 * @return
	 */
	@RequestMapping("/cancelOne")
	public WebReturnMessage cancelObject(@RequestBody CreditAmountAdjustEntity creditAmountAdjustEntity) {
		
		logger.info("cancelOne params:" + creditAmountAdjustEntity.toString());
		
		Assert.isTrue(creditAmountAdjustEntity.getCredAmtAdjId() != null, "主键不能为空!");
		
		creditAmountAdjustService.modifyStatus(creditAmountAdjustEntity);
		
		return WebReturnMessage.sucess;
	}	
	
	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月5日
	 * @param creditAmountAdjustEntity
	 * @return
	 */
	@RequestMapping("/auditOne")
	public WebReturnMessage auditOne(@RequestBody CreditAmountAdjustEntity creditAmountAdjustEntity) {

		logger.info("auditOne params:" + creditAmountAdjustEntity.toString());
		
		Assert.isTrue(creditAmountAdjustEntity.getCredAmtAdjId() != null, "主键不能为空!");
		
		creditAmountAdjustService.modifyStatus(creditAmountAdjustEntity);
		
		return WebReturnMessage.sucess;
		
	}
}
