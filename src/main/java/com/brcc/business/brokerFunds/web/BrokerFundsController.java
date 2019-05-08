package com.brcc.business.brokerFunds.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brcc.business.brokerFunds.service.BrokerFundsService;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import com.esteel.common.controller.WebReturnMessage;

/**
 * @Description 经纪人上传资金流水单
 * @Author pjy
 * @Date 2018-12-27
 **/
@Controller
@RequestMapping("/business/brokerFunds")
public class BrokerFundsController {
    Logger logger = LoggerFactory.getLogger(BrokerFundsController.class);
    @Autowired
    BrokerFundsService brokerFundsService;

    /**
     * @Description: 经纪人资金流水查询
     * @param vo  BrokerFundsQueryVo vo
     * @return Page<BrokerFundsVo>
     */
    @RequestMapping(value = "/brokerFundsList")
    @ResponseBody
    public Page<BrokerFundsVo> brokerFundsList(@RequestBody BrokerFundsQueryVo vo){
        logger.info(vo.toString());
        Page<BrokerFundsVo> page = brokerFundsService.brokerFundsList(vo);
        return page;

    }
    /**
     * @Description: 经纪人资金流水明细添加查询
     * @param vo 查询封装的接收类
     * @return Page<BrokerFundsDetailVo>
     */
    @RequestMapping(value = "/addBrokerFundsDetailList")
    @ResponseBody
    public Page<BrokerFundsDetailVo> addBrokerFundsDetailList(@RequestBody BrokerFundsDetailQueryVo vo){
        logger.info(vo.toString());
        Page<BrokerFundsDetailVo> page = brokerFundsService.addBrokerFundsDetailList(vo);
        return page;
    }

    /**
     * @Description: 经纪人资金流水明细查询
     * @param vo 查询封装的接收类
     * @return Page<BrokerFundsDetailVo>
     */
    @RequestMapping(value = "/lookBrokerFundsDetailList")
    @ResponseBody
    public  Page<BrokerFundsDetailVo> lookBrokerFundsDetailList(@RequestBody BrokerFundsDetailQueryVo vo){
        logger.info(vo.toString());
        Assert.notNull(vo.getFundsControlMasterId(),"丢失经纪人资金查询主键！");
        Page<BrokerFundsDetailVo> page = brokerFundsService.lookBrokerFundsDetailList(vo);
        return page;
    }

    /**
     * 	增加经纪人上传流水
     */
    @RequestMapping(value = "/addBrokerFunds")
    @ResponseBody
    public WebReturnMessage addBrokerFunds(@RequestBody BrokerFundsVo vo){
        logger.info("add BrokerFunds by fundsPic,createRemark",vo.getFundsPic(),vo.getCreateRemark());
        try{
            brokerFundsService.addBrokerFunds(vo);
            return new WebReturnMessage(true,"操作成功!");
        }catch (Exception e){
            logger.error("addBrokerFunds error,message:{}", e.getMessage());
            return new WebReturnMessage(false, e.getMessage());
        }
    }

    /**
     * 	增加经纪人上传流水明细
     */
    @RequestMapping(value = "/addDetailToBrokerFunds")
    @ResponseBody
    public WebReturnMessage addDetailToBrokerFunds(@RequestBody BrokerFundsDetailQueryVo vo){
        logger.info("addDetailToBrokerFunds by deliveryIdStr,",vo.getDeliveryIdStr(),vo.getFundsControlMasterId());
        Assert.notNull(vo.getDeliveryIdStr(),"无法获取到添加的单据明细！");
        Assert.notNull(vo.getFundsControlMasterId(),"无法获取到主单信息！");
        try{
            brokerFundsService.addDetailToBrokerFunds(vo);
            return new WebReturnMessage(true,"操作成功!");
        }catch (Exception e){
            logger.error("addDetailToBrokerFunds  error,message:{}", e.getMessage());
            return new WebReturnMessage(false, e.getMessage());
        }
    }

    /**
     * 	删除经纪人上传流水明细
     */
    @RequestMapping(value = "/deleteBrokerFundsDetail")
    @ResponseBody
    public WebReturnMessage deleteBrokerFundsDetail(@RequestBody BrokerFundsDetailQueryVo vo){
        logger.info("deleteBrokerFundsDetail by fundsControlDetailIdStr,",vo.getFundsControlDetailIdStr());
        Assert.notNull(vo.getFundsControlDetailIdStr(),"无法获取到需要删除的单据！");
        try{
            brokerFundsService.deleteBrokerFundsDetail(vo);
            return new WebReturnMessage(true,"操作成功!");
        }catch (Exception e){
            logger.error("addDetailToBrokerFunds  error,message:{}", e.getMessage());
            return new WebReturnMessage(false, e.getMessage());
        }
    }

}
