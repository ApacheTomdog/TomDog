package com.brcc.business.Interface.InterfaceOfCw.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.brcc.business.Interface.InterfaceOfCw.service.CwEcService;
import com.brcc.business.Interface.InterfaceOfCw.vo.CancelBillVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.GoodsUploadVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.OutWeightVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.Result;
import com.esteel.common.controller.WebReturnMessage;
/**
* 川威后台逻辑处理Controller
* 
* @author 万强
*
* 2019年4月22日
*/
@RestController
@RequestMapping("/business/CwEc")
public class CwEcController {

    Logger logger = LoggerFactory.getLogger(CwEcController.class);

    @Autowired
    CwEcService cwEcService;

    /**
     * 货源单上传
     *
     * @param vo 封装的接收类
     * @return
     */
    @RequestMapping(value = "/goodsUpload", method = RequestMethod.POST)
    public Result goodsUpload(@RequestBody GoodsUploadVo vo) {
    	Result result =null;
    	logger.info("save goodsorderm, loginInfo,dataInfo:{}",vo.getLoginInfo().toString(),vo.getDataInfo().toString());
//    	try {
    		result = cwEcService.goodsUpload(vo);
//		} catch (Exception e) {
//			logger.error("save goodsorderm,message:{}",e.getMessage());
//			result.setSuccess(false);
//			result.setMsg(e.getMessage());
//		}
        return result;
    }

    /**
     * 返单量上传
     *
     * @param vo 封装的接收类
     * @return
     */
    @RequestMapping(value = "/outWeight", method = RequestMethod.POST)
    public Result outWeight(@RequestBody OutWeightVo vo) {
    	Result result =null;
    	logger.info("save outWeight, loginInfo,outInfo:{}",vo.getLoginInfo().toString(),vo.getOutInfo().toString());
//    	try {
    		result = cwEcService.outWeight(vo);
//		} catch (Exception e) {
//			logger.error("save outWeight,message:{}",e.getMessage());
//			result.setOutResult("0");
//			result.setOutResultReason(e.getMessage());
//		}
        return result;
    }

    /**
     * 撤销单据
     *
     * @param vo 封装的接收类
     * @return
     */
    @RequestMapping(value = "/cancelBill", method = RequestMethod.POST)
    public Result cancelBill(@RequestBody CancelBillVo vo) {
    	Result result =null;    	
    	logger.info("cancel Delivery, loginInfo,cancelInfo:{}",vo.getLoginInfo().toString(),vo.getCancelInfo().toString());
//    	try {
    		result = cwEcService.cancelBill(vo);
//    	} catch (Exception e) {
//    		logger.error("cancel Delivery,message:{}",e.getMessage());
//    		result.setOutResult("0");
//			result.setOutResultReason(e.getMessage());
//		}
        return result;
    }


    /**
     * 川威电商调度信息发送
     *
     * @return
     */
    @RequestMapping(value = "/dispatchToCWEcTask", method = RequestMethod.POST)
    public void dispatchToCWEcTask() {
        cwEcService.dispatchToCWEcTask();
    }

    /***
     *
     */
    @RequestMapping(value = "/reinfotocwTask", method = RequestMethod.POST)
    public void reinfotocwTask() {
        cwEcService.reinfotocwTask();
    }
}


