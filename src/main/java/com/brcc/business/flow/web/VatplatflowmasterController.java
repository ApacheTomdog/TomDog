package com.brcc.business.flow.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.brcc.business.flow.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.flow.entity.VatplatflowdetailEntity;
import com.brcc.business.flow.entity.VatplatflowmasterEntity;
import com.brcc.business.flow.service.VatplatflowdetailService;
import com.brcc.business.flow.service.VatplatflowmasterService;
import com.brcc.business.util.QueryKeyValue;
import com.esteel.common.controller.WebReturnMessage;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月3日
 * 
 */
@RestController
@RequestMapping("/vatplatflowmaster")
public class VatplatflowmasterController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	VatplatflowmasterService vatplatflowmasterService;

	@Autowired
	VatplatflowdetailService vatplatflowdetailService;
	
	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月14日
	 * @param vatplatflowmasterQueryVo
	 * @return
	 */
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public Page<VatplatflowmasterEntity> searchVatplatflowmaster(@RequestBody VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {

		logger.info("searchList params:", vatplatflowmasterQueryVo.toString());

		return vatplatflowmasterService.searchVatplatflowmaster(vatplatflowmasterQueryVo);
	}
	
	@RequestMapping(value = "/searchSpecialClient", method = RequestMethod.POST)
	public Page<QueryKeyValue> searchSpecialClient(@RequestBody VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {

		logger.info("searchSpecialClient params:", vatplatflowmasterQueryVo.toString());

		return vatplatflowmasterService.searchSpecialClient(vatplatflowmasterQueryVo);
	}

	@RequestMapping(value = "/searchInvoiceCompany", method = RequestMethod.POST)
	public List<QueryKeyValue> searchInvoiceCompany(@RequestBody VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {

		logger.info("searchInvoiceCompany params:", vatplatflowmasterQueryVo.toString());

		return vatplatflowmasterService.searchInvoiceCompany(vatplatflowmasterQueryVo);
	}
	
	@RequestMapping("/findSingle")
	public VatplatflowmasterEntity findSingle(@RequestBody Long vatPlatFlowMasterId) {
		
		logger.info("findSingle params:" + vatPlatFlowMasterId);
		
		return vatplatflowmasterService.findSingle(vatPlatFlowMasterId);
		
	}
	
	/**
	 * 
	 * @description:
	 * @author:陈利
	 * @date:2018年11月5日
	 * @param creditAmountAdjustEntity
	 * @return
	 */
	@RequestMapping("/saveSingle")
	public WebReturnMessage saveSingle(@RequestBody VatplatflowmasterEntity vatplatflowmasterEntity) {
		
		logger.info("saveSingle params:" + vatplatflowmasterEntity.toString());
		
		vatplatflowmasterService.saveSingle(vatplatflowmasterEntity);
		
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
	@RequestMapping("/editSingle")
	public WebReturnMessage editSingle(@RequestBody VatplatflowmasterEntity vatplatflowmasterEntity) {
		
		logger.info("editSingle params:" + vatplatflowmasterEntity.toString());
		
		vatplatflowmasterService.editSingle(vatplatflowmasterEntity);
		
		return WebReturnMessage.sucess;
	}
	
	/**
	 * 
	 * @description:生效
	 * @author:陈利
	 * @date:2018年11月16日
	 * @param vatplatflowmasterEntity
	 * @return
	 */
    @RequestMapping(value = "/auditSingle",method = RequestMethod.POST)
    WebReturnMessage auditSingle(@RequestBody VatplatflowmasterEntity vatplatflowmasterEntity) {
    	
    	logger.info("auditSingle params:" + vatplatflowmasterEntity.toString());
		
		vatplatflowmasterService.processStatus(vatplatflowmasterEntity);
		
    	return WebReturnMessage.sucess;
    }
    
	/**
	 * 
	 * @description:作废
	 * @author:陈利
	 * @date:2018年11月16日
	 * @param vatplatflowmasterEntity
	 * @return
	 */
    @RequestMapping(value = "/cancelSingle",method = RequestMethod.POST)
    WebReturnMessage cancelSingle(@RequestBody VatplatflowmasterEntity vatplatflowmasterEntity) {
    	
    	logger.info("cancelSingle params:" + vatplatflowmasterEntity.toString());
		
		vatplatflowmasterService.processStatus(vatplatflowmasterEntity);
		
    	return WebReturnMessage.sucess;
    }
    
	/**
	 * 
	 * @description:还原
	 * @author:陈利
	 * @date:2018年11月16日
	 * @param vatplatflowmasterEntity
	 * @return
	 */
    @RequestMapping(value = "/undoSingle",method = RequestMethod.POST)
    WebReturnMessage undoSingle(@RequestBody VatplatflowmasterEntity vatplatflowmasterEntity) {
    	
    	logger.info("undoSingle params:" + vatplatflowmasterEntity.toString());
		
		vatplatflowmasterService.processStatus(vatplatflowmasterEntity);
		
    	return WebReturnMessage.sucess;
    }
    
    @RequestMapping(value = "/addDetails",method = RequestMethod.POST)
    WebReturnMessage addDetails(@RequestBody ArrayList<VatplatflowdetailEntity> detailList) {
    	
    	logger.info("addDetails params:" + detailList.toString());
    	
    	vatplatflowdetailService.addDetails(detailList);
    	
    	return WebReturnMessage.sucess;
    }
    
    @RequestMapping(value = "/detailList",method = RequestMethod.POST)
    public List<VatplatflowdetailEntity> detailList(@RequestBody Long vatPlatFlowMasterId){
    	
    	logger.info("logger info detailList");
    	
    	List<VatplatflowdetailEntity> list = vatplatflowdetailService.detailList(vatPlatFlowMasterId);
    	
        return vatplatflowdetailService.detailList(vatPlatFlowMasterId);
        
        
    }
    
    @RequestMapping(value = "/deleteDetails",method = RequestMethod.POST)
    void deleteDetails(@RequestBody DeleteVatplatflowdetailVo deleteVatplatflowdetailVo){
    	
    	logger.info("logger info deleteDetails");
    	
    	vatplatflowdetailService.deleteDetails(deleteVatplatflowdetailVo);
        
    }
    @RequestMapping("/findByVatPlatFlowDetailId")
	VatplatflowdetailEntity findByVatPlatFlowDetailId(@RequestBody Long vatPlatFlowDetailId){

    	logger.info("findByVatPlatFlowDetailId",vatPlatFlowDetailId);

    	return  vatplatflowdetailService.findByVatPlatFlowDetailId(vatPlatFlowDetailId);
	}


	@RequestMapping("/editSave")
	VatplatflowdetailEntity editSave(@RequestBody VatplatflowdetailVo vo){

    	logger.info("edit save",vo.toString());

		Assert.notNull(vo.getPlatformId(),"数据异常,刷新重试！");
		Assert.notNull(vo.getVatStatus(),"数据异常,刷新重试！");
		Assert.notNull(vo.getVatPlatFlowMasterId(),"数据异常,刷新重试！");
		Assert.notNull(vo.getVatPolicyRate(),"数据异常,刷新重试！");


    	return vatplatflowdetailService.editSave(vo);
	}

}
