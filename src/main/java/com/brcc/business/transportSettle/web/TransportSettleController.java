package com.brcc.business.transportSettle.web;

import com.brcc.business.transportSettle.entity.PayBillEntity;
import com.brcc.business.transportSettle.entity.VNewPayBillEntity;
import com.brcc.business.transportSettle.service.PayBillService;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.brcc.business.util.JSON;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:10:10
 * @Description 运费计算
 */
@RestController
@RequestMapping("/transportSettle/")
public class TransportSettleController {
	
	Logger logger = LoggerFactory.getLogger(TransportSettleController.class);
	
	@Autowired
    PayBillService payBillService;
	
	@Autowired
    TransportationDeliveryService transportationDeliveryService;
	
	/**
	 * 运费计算列表
	 * @param transportBillQueryVo
	 * @return
	 */
    @RequestMapping("/list")
    public Page<TransportationDeliveryVo> settleList(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("queryPage Data : ");
        return transportationDeliveryService.settleList(transportBillQueryVo);
    }
    
    /**
     * 统一运费计算列表
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/listForGroup")
    public Page<TransportationDeliveryVo> settleListForGroup(@RequestBody TransportBillQueryVo transportBillQueryVo){
    	logger.info("queryPage Data : ");
    	return transportationDeliveryService.settleListForGroup(transportBillQueryVo);
    }
    
    /**
     * 查询委托承运付款指令撤销审核数据
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/listDataForCancelAudit")
    public Page<TransportationDeliveryVo> listDataForCancelAudit(@RequestBody TransportBillQueryVo transportBillQueryVo){
    	logger.info("queryPage Data : ");
    	return transportationDeliveryService.listDataForCancelAudit(transportBillQueryVo);
    }
    
    /**
     * @Desc 保存计算备注
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveJsRemark")
    public WebReturnMessage saveJsRemark(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo.getDeliveryId(), "调度单号不能为空");
    	logger.info("save jsRemark,deliveryId:{}",vo.getDeliveryId());
    	try {
    		transportationDeliveryService.saveJsRemark(vo);
		} catch (Exception e) {
			logger.error("save jsRemark,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    	return new WebReturnMessage(true, "保存成功！");
    }
    
    /**
     * 上传回单图片
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveConfirmPic")
    public WebReturnMessage saveConfirmPic(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo.getDeliveryId(), "调度单号不能为空");
    	Assert.notNull(vo.getImgPath(), "回单图片不能为空");
    	logger.info("save confirmPic,deliveryId:{},confirmPic:{}",vo.getDeliveryId(), vo.getImgPath());
    	try {
    		transportationDeliveryService.saveConfirmPic(vo);
		} catch (Exception e) {
			logger.error("save confirmPic,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    	return new WebReturnMessage(true, "保存成功！");
    }
    
    /**
     * 撤销支付单
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/revokeZFbill")
    public WebReturnMessage revokeZFbill(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo.getDeliveryId(), "调度单号不能为空");
    	Assert.notNull(vo.getZfId(), "计算单id不能为空");
    	logger.info("revoke ZFbill,deliveryId:{},zfId:{}",vo.getDeliveryId(), vo.getZfId());
    	try {
    		payBillService.revokeZFbill(vo);
		} catch (Exception e) {
			logger.error("revoke ZFbill,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    	return new WebReturnMessage(true, "撤销成功！");
    }
    
    /**
     * 查询结算单明细数据
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/listPayDetailData")
    public Page<VNewPayBillEntity> listPayDetailData(@RequestBody TransportBillQueryVo vo){
    	logger.info("query listPayDetailData page,zfId:{}", vo.getZfId());
        return payBillService.listPayDetailData(vo);
    }
    
    /**
     * 查询运费计算导出数据
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/querySettleInfo")
    public List<TransportationDeliveryVo> querySettleInfo(@RequestBody TransportBillQueryVo queryVo) {
    	logger.info("query settleInfo list, queryVo:{} ", JSON.toJson(queryVo));
        return transportationDeliveryService.querySettleInfo(queryVo);
    }


    /**
     * 查询统一运费计算导出数据
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/querySettleInfoForGroup")
    public List<TransportationDeliveryVo> querySettleInfoForGroup(@RequestBody TransportBillQueryVo queryVo) {
    	logger.info("query settleInfo for group list, queryVo:{}", JSON.toJson(queryVo));
    	return transportationDeliveryService.querySettleInfoForGroup(queryVo);
    }
	
    /**
     * 查询登记页面初始展示数据
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryDeliveryVo")
    public TransportationDeliveryVo queryDeliveryVo(@RequestBody TransportBillQueryVo queryVo) {
    	logger.info("query deliveryVo,transportationdeliveryId:{}", queryVo.getTransportationdeliveryId());
    	TransportationDeliveryVo vo = transportationDeliveryService.queryDeliveryVo(queryVo);
    	return vo;
    }
    
    /**
     * 查询登记页面初始展示数据（集团）
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryDeliveryVoForGroup")
    public TransportationDeliveryVo queryDeliveryVoForGroup(@RequestBody TransportBillQueryVo queryVo) {
    	logger.info("query deliveryVo,transportationdeliveryId:{},publishCompanyId:{}", queryVo.getTransportationdeliveryId(), queryVo.getPublishCompanyId());
    	TransportationDeliveryVo vo = transportationDeliveryService.queryDeliveryVoForGroup(queryVo);
    	return vo;
    }
    
    /**
     * @Desc 查询批量计算页面数据
     * @param queryVo
     * @return
     * @author yangwenbin
     * @version 创建时间：2019年1月21日 上午10:20:31
     */
    @RequestMapping(value = "/queryBatchCalcCondition")
    public TransportationDeliveryVo queryBatchCalcCondition(@RequestBody TransportBillQueryVo queryVo) {
    	logger.info("query batch calc condition");
    	TransportationDeliveryVo vo = transportationDeliveryService.queryBatchCalcCondition(queryVo);
    	return vo;
    }
    
    /**
     * 保存支付单
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveZFbill")
    public WebReturnMessage saveZFbill(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo, "结算信息不能为空");
    	logger.info("save ZFbill,deliveryId:{}",vo.getDeliveryId());
    	try {
    		PayBillEntity savedPayBillEntity = payBillService.saveZFbill(vo);
    		PayBillEntity payBillEntity = payBillService.findOne(savedPayBillEntity.getZfId());
    		// 委托承运流程，根据货主配置，自动付款申请
    		if ("Y".equals(payBillEntity.getIfTaxTransport())) {
    			payBillService.autoApplyPay(payBillEntity);
    		}
		} catch (Exception e) {
			logger.error("save ZFbill,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    	return new WebReturnMessage(true, "保存成功！");
    }
    
    /**
     * @Desc 批量运费计算
     * @param vo
     * @return
     * @author yangwenbin
     * @version 创建时间：2019年1月22日 下午3:03:00
     */
    @ResponseBody
    @RequestMapping("/batchCalc")
    public HashMap<String, Object> batchCalc(@RequestBody TransportBillQueryVo vo) {
    	Assert.notNull(vo.getDeliveryIds(), "调度单id不能为空");
    	logger.info("batch calc, deliveryIds:{}", vo.getDeliveryIds());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = payBillService.batchCalc(vo);
    	} catch (Exception e) {
    		logger.error("batch calc, message:{}", e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 校验是否会重复支付给司机
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkIfSamePay")
    public HashMap<String, Object> checkIfSamePay(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo.getDeliveryId(), "调度单号不能为空");
    	logger.info("check if same pay,deliveryId:{}",vo.getDeliveryId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = payBillService.checkIfSamePay(vo);
		} catch (Exception e) {
			logger.error("check if same pay,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
		}
    	return resultMap;
    }
    
    /**
     * 校验运费是否合理
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkZFbill")
    public HashMap<String, Object> checkZFbill(@RequestBody TransportBillQueryVo vo){
    	Assert.notNull(vo.getDeliveryId(), "调度单号不能为空");
    	logger.info("check zf bill,deliveryId:{}",vo.getDeliveryId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = payBillService.checkZFbill(vo);
    	} catch (Exception e) {
    		logger.error("check zf bill,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", "校验异常，是否仍计算运费？\\n\\n" + e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 撤销付款申请
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancelPayApply")
    public HashMap<String, Object> cancelPayApply(@RequestBody TransportBillQueryVo vo) {
    	Assert.notNull(vo.getZfId(), "zfId不能为空");
    	logger.info("cancel pay apply,zfId:{}",vo.getZfId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = payBillService.cancelPayApply(vo);
    	} catch (Exception e) {
    		logger.error("cancel pay apply,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    /**
     * 批量撤销付款申请
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/cancelPayApplyBatch")
    public HashMap<String, Object> cancelPayApplyBatch(@RequestBody TransportBillQueryVo vo) {
    	Assert.notNull(vo.getZfIdStr(), "zfIdStr不能为空");
    	logger.info("cancel pay apply batch,zfIdStr:{}",vo.getZfIdStr());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = payBillService.cancelPayApplyBatch(vo);
    	} catch (Exception e) {
    		logger.error("cancel pay apply batch,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 运费计算合计
     */
    @ResponseBody
    @RequestMapping(value = "/listDataSum")
    public TransportationDeliveryVo listDataSum(@RequestBody TransportBillQueryVo queryVo){
        logger.info("Query settle Transportationdelivery sum data,queryVo:{}",queryVo);
        return payBillService.listDataSum(queryVo);
    }
}
