package com.brcc.business.creditBill.web;

import com.brcc.business.creditBill.entity.CreditBillDetailEntity;
import com.brcc.business.creditBill.service.CreditBillDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.creditBill.entity.CreditBillEntity;
import com.brcc.business.creditBill.service.CreditBillService;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月3日
 *
 */
@RestController
@RequestMapping("/creditBill")
public class CreditBillController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CreditBillService creditBillService;
	
	@Autowired
	CreditBillDetailService creditBillDetailService;

	/**
	 *
	 * @author:陈利
	 * @date:2018年11月3日
	 * @param creditBillQueryVo
	 * @return
	 */
	@RequestMapping(value = "/searchCreditBill", method = RequestMethod.POST)
	public Page<CreditBillEntity> searchCreditBill(@RequestBody CreditBillQueryVo creditBillQueryVo) {

		logger.info("searchCreditBill params:", creditBillQueryVo.toString());

		Assert.notNull(creditBillQueryVo.getPlatformId(),"参数platformId不能为空！");
		Assert.notNull(creditBillQueryVo.getCreditCompanyId(),"参数creditCompanyId不能为空！");
		return creditBillService.searchCreditBill(creditBillQueryVo);
	}

	/**
	 * @Description  返回委托方授信账单明细
	 * @Param [vo]
	 * @return org.springframework.data.domain.Page<com.brcc.business.creditBill.entity.CreditBillDetailEntity>
	 **/
	@RequestMapping("/queryBillDetail")
	Page<CreditBillDetailEntity>  queryBillDetail(@RequestBody CreditBillQueryVo vo){

		logger.info("query credit bill detail,credit bill id:{},platformId:{}",vo.getCreditBillId(),vo.getPlatformId());

		Assert.notNull(vo.getCreditBillId(),"参数creditBillId不能为空！");
		Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
		return creditBillDetailService.queryBillDetail(vo);
	}




	/**
	 * @Description  委托级垫资账单查询
	 * @Param [vo]
	 * @return org.springframework.data.domain.Page<com.brcc.business.creditBill.entity.CreditBillEntity>
	 **/
	@RequestMapping("/creditBillList")
	Page<CreditBillEntity>  queryCreditBill(@RequestBody CreditBillQueryVo vo){

		logger.info("query invest ,platformId:{},investCompanyId:{}",vo.getPlatformId(),vo.getInvestCompanyId());

		Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
		Assert.notNull(vo.getInvestCompanyId(),"参数investCompanyId不能为空！");
		return creditBillService.queryCreditBill(vo);
	}

}
