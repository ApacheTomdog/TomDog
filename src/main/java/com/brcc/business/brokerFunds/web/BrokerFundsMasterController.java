package com.brcc.business.brokerFunds.web;
import com.brcc.business.brokerFunds.service.BrokerFundsPayeeInfoService;
import com.brcc.business.brokerFunds.vo.*;
import com.brcc.business.brokerTax.entity.BrokerTaxCycleEntity;
import com.brcc.business.brokerTax.service.BrokerTaxCycleService;
import com.esteel.common.controller.WebReturnMessage;
import com.esteel.common.util.RestPageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.brcc.business.brokerFunds.service.BrokerFundsMasterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
@Controller
@RequestMapping("/business/brokerFundsMaster")
public class BrokerFundsMasterController {
	
	 Logger logger = LoggerFactory.getLogger(BrokerFundsMasterController.class);
	    @Autowired
	    BrokerFundsMasterService brokerFundsMasterService;
		@Autowired
	    BrokerTaxCycleService  brokerTaxCycleService;
		@Autowired
		BrokerFundsPayeeInfoService brokerFundsPayeeInfoService;

	    /**
	     * @Description: 资金流水单明细审核页面查询
	     * @param vo  BrokerFundsDetailVo vo
	     * @return Page<BrokerFundsDetailVo>
	     */
	    @RequestMapping(value = "/brokerFundsMasterist")
	    @ResponseBody
	    public Page<BrokerFundsDetailVo> brokerFundsMasterist(@RequestBody BrokerFundsDetailQueryVo vo){
	        logger.info(vo.toString());
	        Page<BrokerFundsDetailVo> page = brokerFundsMasterService.brokerFundsMasterAuditList(vo);
	        return page;

	    }

		/**
	 	* @Description: 超限调度单查询
	 	* @param  queryVo TransfiniteDispatchQueryVo queryVo
	 	* @return Page<TransfiniteDispatchVo>
	 	*/
	    @RequestMapping(value = "/transfiniteDispatchPage")
	    @ResponseBody
		Page<TransfiniteDispatchVo>transfiniteDispatchPage(@RequestBody TransfiniteDispatchQueryVo queryVo){
	    	return brokerFundsMasterService.transfiniteDispatchPage(queryVo);
	    }

	/**
	 * @Description:
	 * @param  brokerFundsVo BrokerFundsVo brokerFundsVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveCapitalFlow")
	@ResponseBody
	public WebReturnMessage saveCapitalFlow(@RequestBody BrokerFundsVo brokerFundsVo){
		logger.info("save CapitalFlow by deliveryId:{},zfId:{}",brokerFundsVo.getDeliveryId(),brokerFundsVo.getZfId());
		try{
			brokerFundsMasterService.saveCapitalFlow(brokerFundsVo);
			return new WebReturnMessage(true,"生成资金流水单成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("save CapitalFlow by deliveryId,zfId error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * @Description: 经纪人资金流水批量上传查询
	 * @param vo  BrokerFundsQueryVo vo
	 * @return Page<BrokerFundsVo>
	 */
	@RequestMapping(value = "/brokerFundsMasterList")
	@ResponseBody
	public Page<BrokerFundsVo> brokerFundsMasterList(@RequestBody BrokerFundsQueryVo vo){
		logger.info(vo.toString());
		Page<BrokerFundsVo> page = brokerFundsMasterService.brokerFundsMasterList(vo);
		return page;

	}

	/**
	 * @Description: 对单条资金流水进行第一次审核操作
	 * @param  brokerFundsDetailVo BrokerFundsVo brokerFundsVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveFirstAudit")
	@ResponseBody
	public WebReturnMessage saveFirstAudit(@RequestBody BrokerFundsDetailVo brokerFundsDetailVo){
		logger.info("first audit brokerfundsDetail by fundsControlDetailIdStr:{}",brokerFundsDetailVo.getFundsControlDetailIdStr());
		try{
			brokerFundsMasterService.saveFirstAudit(brokerFundsDetailVo);
			return new WebReturnMessage(true,"资金流水单一审操作成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("first audit brokerfundsDetail by fundsControlDetailIdStr error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * @Description: 对单条资金流水进行第二次审核操作
	 * @param  brokerFundsDetailVo BrokerFundsVo brokerFundsVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveSecondAudit")
	@ResponseBody
	public WebReturnMessage saveSecondAudit(@RequestBody BrokerFundsDetailVo brokerFundsDetailVo){
		logger.info("second audit brokerfundsDetail by fundsControlDetailIdStr:{}",brokerFundsDetailVo.getFundsControlDetailIdStr());
		try{
			brokerFundsMasterService.saveSecondAudit(brokerFundsDetailVo);
			return new WebReturnMessage(true,"资金流水单二审操作成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("second audit brokerfundsDetail by fundsControlDetailIdStr error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * 	增加经纪人上传流水
	 */
	@RequestMapping(value = "/addBrokerFundsMaster")
	@ResponseBody
	public WebReturnMessage addBrokerFundsMaster(@RequestBody BrokerFundsVo vo){
		logger.info("add BrokerFundsMaster by fundsPic:{},createRemark:{}",vo.getFundsPic(),vo.getCreateRemark());
		try{
			brokerFundsMasterService.addBrokerFundsMaster(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("addBrokerFunds error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * 	提交资金流水单主单
	 */
	@RequestMapping(value = "/offerMaster")
	@ResponseBody
	public WebReturnMessage offerMaster(@RequestBody BrokerFundsVo vo){
		logger.info("invalid  brokerFundsMaster  by fundsControlMasterId:{}",vo.getFundsControlMasterId());
		Assert.notNull(vo.getFundsControlMasterId(),"获取操作主单失败！");
		try{
			brokerFundsMasterService.offerMaster(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("invalid  brokerFundsMaster error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * 	作废资金流水主单
	 */
	@RequestMapping(value = "/invalidMaster")
	@ResponseBody
	public WebReturnMessage invalidMaster(@RequestBody BrokerFundsVo vo){
		logger.info("invalid  brokerFundsMaster  by fundsControlMasterId:{}",vo.getFundsControlMasterId());
		Assert.notNull(vo.getFundsControlMasterId(),"获取操作主单失败！");
		try{
			brokerFundsMasterService.invalidMaster(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("invalid  brokerFundsMaster error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * @Description: 经纪人资金流水明细添加查询
	 * @param vo 查询封装的接收类
	 * @return Page<BrokerFundsDetailVo>
	 */
	@RequestMapping(value = "/addBrokerFundsMasterDetailList")
	@ResponseBody
	public Page<BrokerFundsDetailVo> addBrokerFundsMasterDetailList(@RequestBody BrokerFundsDetailQueryVo vo)throws ParseException {
		logger.info(vo.toString());
		SimpleDateFormat sdfSearch = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!StringUtils.isEmpty(vo.getBrokerTaxCycleName())){
			String  brokerTaxYearMonth = brokerTaxCycleService.getTaxCycle(vo.getBrokerTaxCycleName());
			vo.setPayStart(sdfSearch.parse( brokerTaxYearMonth + "-01 00:00:00"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(vo.getPayStart());
			calendar.add(Calendar.MONTH,3);
			vo.setPayEnd(calendar.getTime());
		}
		Page<BrokerFundsDetailVo> page = brokerFundsMasterService.addBrokerFundsMasterDetailList(vo);
		return page;
	}

	/**
	 * @Description: 经纪人资金流水明细查询
	 * @param vo 查询封装的接收类
	 * @return Page<BrokerFundsDetailVo>
	 */
	@RequestMapping(value = "/lookBrokerFundsMasterDetailList")
	@ResponseBody
	public  Page<BrokerFundsDetailVo> lookBrokerFundsMasterDetailList(@RequestBody BrokerFundsDetailQueryVo vo){
		logger.info(vo.toString());
		Assert.notNull(vo.getFundsControlMasterId(),"丢失经纪人资金查询主键！");
		Page<BrokerFundsDetailVo> page = brokerFundsMasterService.lookBrokerFundsMasterDetailList(vo);
		return page;
	}

	/**
	 * 	增加经纪人上传流水明细
	 */
	@RequestMapping(value = "/addDetailToBrokerFundsMaster")
	@ResponseBody
	public WebReturnMessage addDetailToBrokerFunds(@RequestBody BrokerFundsDetailQueryVo vo){
		logger.info("addDetailToBrokerFunds by payBillIdStr:{}",vo.getPayBillIdStr(),vo.getFundsControlMasterId());
		Assert.notNull(vo.getPayBillIdStr(),"无法获取到添加的单据明细！");
		Assert.notNull(vo.getFundsControlMasterId(),"无法获取到主单信息！");
		try{
			brokerFundsMasterService.addDetailToBrokerFundsMaster(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("addDetailToBrokerFunds  error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * 	删除经纪人上传流水明细
	 */
	@RequestMapping(value = "/deleteBrokerFundsMasterDetail")
	@ResponseBody
	public WebReturnMessage deleteBrokerFundsMasterDetail(@RequestBody BrokerFundsDetailQueryVo vo){
		logger.info("deleteBrokerFundsMasterDetail by fundsControlDetailIdStr:{}",vo.getFundsControlDetailIdStr());
		Assert.notNull(vo.getFundsControlDetailIdStr(),"无法获取到需要删除的单据！");
		try{
			brokerFundsMasterService.deleteBrokerFundsMasterDetail(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("addDetailToBrokerFunds  error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

    /**
     * 导出对应的数据
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/excelBrokerFunds")
    public List<BrokerFundsDetailVo> excelBrokerFunds(@RequestBody BrokerFundsDetailQueryVo vo){
        logger.info("broker funds detail excel by fundsControlMasterId:{}",vo.getFundsControlMasterId());
        List<BrokerFundsDetailVo> list = brokerFundsMasterService.excelBrokerFunds(vo);
        return list;
    }

    /**
     * 导入资金流水分配详情
     * @return
     */
    @RequestMapping(value = "/uploadBrokerFunds", method = RequestMethod.POST)
	@ResponseBody
    public WebReturnMessage uploadBrokerFunds(@RequestBody List<BrokerFundsUploadVo> excelList, @RequestParam("companyId") Long companyId, @RequestParam("fundsControlMasterId")Long fundsControlMasterId){
    	logger.info("excelList",excelList);
    	try {
			String msg = brokerFundsMasterService.uploadBrokerFunds(excelList, companyId, fundsControlMasterId);
			logger.info(msg);
			return new WebReturnMessage(true, msg);
		}catch (Exception e){
			e.printStackTrace();
			logger.error("upload BrokerFunds error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    }

	/**
	 * @Description: 保存单条资金流水上传记录
	 * @param  BrokerFundsDetailVo brokerFundsDetailVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveFpInfo")
	@ResponseBody
	public WebReturnMessage saveFpInfo(@RequestBody BrokerFundsDetailVo brokerFundsDetailVo){
		logger.info("save CapitalFlow by fundscotroldetailId:{}",brokerFundsDetailVo.getFundsControlDetailId());
		Assert.notNull(brokerFundsDetailVo.getFundsControlDetailId(),"获取操作数据失败！");
		try{
			brokerFundsMasterService.saveFpInfo(brokerFundsDetailVo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("save CapitalFlow by deliveryId,zfId error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * @Description: 查询经纪人经纪单主单审核查询
	 * @param vo  BrokerFundsQueryVo vo
	 * @return Page<BrokerFundsVo>
	 */
	@RequestMapping(value = "/masterAuditList")
	@ResponseBody
	public Page<BrokerFundsVo> masterAuditList(@RequestBody BrokerFundsQueryVo vo){
		logger.info(vo.toString());
		Page<BrokerFundsVo> page = brokerFundsMasterService.masterAuditList(vo);
		return page;

	}

	/**
	 * @Description: 对资金流水进行第一次审核操作
	 * @param   BrokerFundsVo brokerFundsVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveFirstMasterAudit")
	@ResponseBody
	public WebReturnMessage saveFirstMasterAudit(@RequestBody BrokerFundsVo brokerFundsVo){
		logger.info("first audit brokerfundsMaster by fundsControlMasterIdStr:{}",brokerFundsVo.getFundsControlMasterIdStr());
		try{
			brokerFundsMasterService.saveFirstMasterAudit(brokerFundsVo);
			return new WebReturnMessage(true,"资金流水单一审操作成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("first audit brokerfundsmaster by fundsControlMasterIdStr error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * @Description: 资金流水进行第二次审核操作
	 * @param   BrokerFundsVo brokerFundsVo
	 * @return WebReturnMessage
	 */
	@RequestMapping(value = "/saveSecondMasterAudit")
	@ResponseBody
	public WebReturnMessage saveSecondMasterAudit(@RequestBody BrokerFundsVo brokerFundsVo){
		logger.info("second audit brokerfundsMaster by fundsControlMasterIdStr:{}",brokerFundsVo.getFundsControlMasterIdStr());
		try{
			brokerFundsMasterService.saveSecondMasterAudit(brokerFundsVo);
			return new WebReturnMessage(true,"资金流水单二审操作成功!");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("second audit brokerfundsmaster by fundsControlMasterIdStr error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}

	/**
	 * 	增加经纪人流水单分配信息
	 * 	*/
	@RequestMapping(value = "/addPayeeDetail")
	@ResponseBody
	public WebReturnMessage addPayeeDetail(@RequestBody BrokerFundsVo vo){
		logger.info("add addPayeeDetail by fundsControlMasterId",vo.getFundsControlMasterId());
		Assert.notNull(vo.getFundsControlMasterId(),"资金流水单id丢失！");
		try{
			brokerFundsMasterService.addPayeeDetail(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("addBrokerFunds error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}
	/**
	 * 	查看经纪人流水单分配信息
	 * 	*/
	@RequestMapping(value = "/lookPayeeDetail")
	@ResponseBody
	public Page<BrokerFundsPayeeInfoVo> lookPayeeDetail(@RequestBody BrokerFundsPayeeInfoQueryVo vo) {
		logger.info("lookPayeeDetail by fundsControlMasterId", vo.getFundsControlMasterId());
		Assert.notNull(vo.getFundsControlMasterId(), "资金流水单id丢失！");
		Page<BrokerFundsPayeeInfoVo> page = brokerFundsPayeeInfoService.lookPayeeDetail(vo);
		return page;
	}
	/**
	 * 	删除经纪人流水单分配信息
	 * 	*/
	@RequestMapping(value = "/deletePayeeDetail")
	@ResponseBody
	public WebReturnMessage deletePayeeDetail(@RequestBody BrokerFundsPayeeInfoVo vo){
		logger.info("deletePayeeDetail by getBrokerFundsPayeeInfoIdStr{}:",vo.getBrokerFundsPayeeInfoIdStr());
		Assert.notNull(vo.getFundsControlMasterId(),"资金流水单id丢失！");
		Assert.notNull(vo.getBrokerFundsPayeeInfoIdStr(),"操作单据丢失！");
		try{
			brokerFundsMasterService.deletePayeeDetail(vo);
			return new WebReturnMessage(true,"操作成功!");
		}catch (Exception e){
			logger.error("addBrokerFunds error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
     * 	上传经纪人流水图片
     */
	@RequestMapping(value = "/uploadBrokerFundsPic")
	@ResponseBody
	public WebReturnMessage uploadBrokerFundsPic(@RequestBody BrokerFundsVo vo){
		logger.info("upload BrokerFunds by fundsPic:{},createRemark:{}",vo.getFundsPic());
		Assert.notNull(vo.getFundsControlMasterId(),"资金流水单id丢失！");
		try{
			brokerFundsMasterService.uploadBrokerFundsPic(vo);
			return new WebReturnMessage(true,"上传成功!");
		}catch (Exception e){
			logger.error("addBrokerFunds error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * 	删除经纪人流水图片
	 */
	@RequestMapping(value = "/removeBrokerFundsPic")
	@ResponseBody
	public WebReturnMessage removeBrokerFundsPic(@RequestBody  Long fundsControlMasterId){
		logger.info("remove BrokerFunds by fundsPic:{},createRemark:{}",fundsControlMasterId);
		Assert.notNull(fundsControlMasterId,"资金流水单id丢失！");
		try{
			brokerFundsMasterService.removeBrokerFundsPic(fundsControlMasterId);
			return new WebReturnMessage(true,"删除成功!");
		}catch (Exception e){
			logger.error("addBrokerFunds error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}
}
