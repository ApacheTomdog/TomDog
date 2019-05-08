package com.brcc.business.priceClientRate.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.priceClientRate.service.PriceClientRateService;
import com.brcc.business.priceClientRate.vo.PriceClientRateQueryVo;
import com.brcc.business.priceClientRate.vo.PriceClientRateVo;
import com.brcc.business.priceClientRate.vo.QueryCompanyVo;
import com.esteel.common.controller.WebReturnMessage;
/**
 * 委托承运成本税率维护
 * 
 * @author panyinfang
 *
 */
@RestController
@RequestMapping("priceClientRate")
public class PriceClientRateController {
	
	Logger logger = LoggerFactory.getLogger(PriceClientRateController.class);
	@Autowired
	PriceClientRateService priceClientRateService;
	
	/**
	 * 委托承运成本税率维护列表
	 * 
	 * @param queryvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Page<PriceClientRateVo> queryList(@RequestBody PriceClientRateQueryVo queryvo) {
		logger.info("queryList params:", queryvo.toString());
		Page<PriceClientRateVo> page = priceClientRateService.listDataPage(queryvo);
		return page;
	}
	
	/**
	 * 新增
	 * 
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public WebReturnMessage save(@RequestBody PriceClientRateVo vo) {
		logger.info("save priceClientRate,ibId:{}", vo.getPriceClientRateId());
		try {
			priceClientRateService.savePriceClientRate(vo);;
		} catch (Exception e) {
			logger.error("save priceClientRate,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "保存成功");
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/delPriceClientRate", method = RequestMethod.POST)
	public WebReturnMessage delPriceClientRate(@RequestBody Long priceClientRateId) {
		logger.info("delete priceClientRate,priceClientRateId:{}",priceClientRateId);
		try {
			priceClientRateService.delPriceClientRateId(priceClientRateId);
		} catch (Exception e) {
			logger.error("delete priceClientRate,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "删除成功");
	}
	
	/**
	 * 查询公司
	 * @param queryvo
	 * @return
	 */
	@RequestMapping("/findCompany")
    @ResponseBody
    public Page<QueryCompanyVo> findCaaCompany(@RequestBody PriceClientRateQueryVo queryvo){
        
    	logger.info("return PriceClientRate add company name ");
        
        return priceClientRateService.queryCompanyName(queryvo);
    }
	
	
	
	

}
