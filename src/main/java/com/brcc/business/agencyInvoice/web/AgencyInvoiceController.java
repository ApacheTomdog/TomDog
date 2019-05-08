package com.brcc.business.agencyInvoice.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.agencyInvoice.entity.ReinvoicedetailEntity;
import com.brcc.business.agencyInvoice.entity.ReinvoicemasterEntity;
import com.brcc.business.agencyInvoice.service.AgencyInvoiceService;
import com.brcc.business.agencyInvoice.service.ReinvoiceDetailService;
import com.brcc.business.agencyInvoice.service.ReinvoiceMasterService;
import com.brcc.business.agencyInvoice.vo.AddAgencyInvoiceVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceQueryVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceUploadVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceVo;
import com.brcc.business.agencyInvoice.vo.DealPrintFlagVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * 代开票管理
 * 
 * @author hui.liu
 * @date 2018年12月13日
 */
@RestController
@RequestMapping("/business/agencyInvoice")
public class AgencyInvoiceController {

    Logger logger = LoggerFactory.getLogger(AgencyInvoiceController.class);

    @Autowired
    private AgencyInvoiceService agencyInvoiceService;
    
    @Autowired
    private ReinvoiceDetailService reinvoiceDetailService;
    
    @Autowired
    private ReinvoiceMasterService reinvoiceMasterService;

    @RequestMapping(value = "/queryAgencyInvoiceList", method = RequestMethod.POST)
    public Page<AgencyInvoiceVo> queryAgencyInvoiceList(@RequestBody AgencyInvoiceQueryVo queryVo){
    	logger.info("queryAgencyInvoiceList,{}", queryVo.toString());
        return agencyInvoiceService.queryAgencyInvoiceList(queryVo);
    }
    
    @RequestMapping(value = "/getReinvoiceDetailList")
    public List<ReinvoicedetailEntity> getReinvoiceDetailList(@RequestParam("reinvoiceMasterId") Long reinvoiceMasterId, 
    		@RequestParam("platformId") String platformId){
    	logger.info("getReinvoiceDetailList,reinvoiceMasterId:{},platformId:{}", reinvoiceMasterId, platformId);
        return reinvoiceDetailService.getReinvoiceDetailList(reinvoiceMasterId, platformId);
    }
    
    @RequestMapping(value = "/getReinvoiceMaster")
    public ReinvoicemasterEntity getReinvoiceMaster(@RequestParam("reinvoiceMasterId") Long reinvoiceMasterId, 
    		@RequestParam("platformId") String platformId){
    	logger.info("getReinvoiceMaster,reinvoiceMasterId:{},platformId:{}", reinvoiceMasterId, platformId);
        return reinvoiceMasterService.getReinvoiceMaster(reinvoiceMasterId, platformId);
    }
    
    /**
	 * 	新增代开票
	 */
	@RequestMapping(value = "/addAgencyInvoice", method = RequestMethod.POST)
	public WebReturnMessage addAgencyInvoice(@RequestBody AddAgencyInvoiceVo addVo) {
		logger.info("addAgencyInvoice,{}", addVo.toString());
		try {
			agencyInvoiceService.addAgencyInvoice(addVo);
		} catch (Exception e) {
			logger.error("addAgencyInvoice individual,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	/**
	 * 	批量修改代开票打印标记
	 */
	@RequestMapping(value = "/dealPrintFlag", method = RequestMethod.POST)
	public WebReturnMessage dealPrintFlag(@RequestBody DealPrintFlagVo dealPrintFlagVo) {
		logger.info("dealPrintFlag,{}", dealPrintFlagVo.toString());
		try {
			reinvoiceMasterService.dealPrintFlag(dealPrintFlagVo);
		} catch (Exception e) {
			logger.error("dealPrintFlag individual,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "操作成功");
	}
	
	/**
	 * 	上传发票编号
	 */
	@RequestMapping(value = "/upLoadInvoiceNo", method = RequestMethod.POST)
    public WebReturnMessage upLoadInvoiceNo(@RequestBody List<AgencyInvoiceUploadVo> uploadVoList, 
    		@RequestParam("platformId") String platformId, @RequestParam("userId") Long userId, @RequestParam("userName") String userName){
		Assert.isTrue(!CollectionUtils.isEmpty(uploadVoList), "上传数据不能为空");
		logger.info("upLoadInvoiceNo,uploadVoList size:{},platformId:{}, userId:{}, userName:{}", uploadVoList.size(), platformId, userId, userName);
		
		int afterRows = uploadVoList.size();
		int count = 0;
		int successCount = 0;
		List<AgencyInvoiceUploadVo> upLoadInvoiceNoList = new ArrayList<>();
		for(AgencyInvoiceUploadVo uploadVo : uploadVoList) {
			if(StringUtils.isEmpty(uploadVo.getReinvoiceMasterNum()) || StringUtils.isEmpty(uploadVo.getReinvoiceNo())) {
				continue;
			}
			
			String reinvoiceAgreeTimeStr = uploadVo.getReinvoiceAgreeTimeStr();
			if(!StringUtils.isEmpty(reinvoiceAgreeTimeStr)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					uploadVo.setReinvoiceAgreeTime(dateFormat.parse(reinvoiceAgreeTimeStr));
				} catch (ParseException e) {
					logger.error("日期转换错误，", reinvoiceAgreeTimeStr);
				}
			}
			
			upLoadInvoiceNoList.add(uploadVo);
		}
		
		try {
			if(!CollectionUtils.isEmpty(upLoadInvoiceNoList)) {
				count = upLoadInvoiceNoList.size();
				successCount = agencyInvoiceService.upLoadInvoiceNo(upLoadInvoiceNoList, platformId, userId, userName);
			}
		} catch (Exception e) {
			logger.error("upLoadInvoiceNo individual,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
		return new WebReturnMessage(true, "总共：" + afterRows + "条，导入成功：" + count + "条！  业务处理成功：" + successCount + "条！");
    }
}
