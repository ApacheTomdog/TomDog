package com.brcc.business.dispatchorder.web;

import com.brcc.business.dispatchorder.service.DispatchOrderDetailService;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderSumVo;
import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.web.TransOrderDetailController;
import com.esteel.common.controller.WebReturnMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 描述:
 * 平台调度单详单
 *
 * @author yushaohua
 * @create 2018-11-06 10:44
 */
@RestController
@RequestMapping("/business/dispatchOrderDetail/")
public class DispatchOrderDetailController {

    Logger logger = LoggerFactory.getLogger(DispatchOrderDetailController.class);

    @Autowired
    private DispatchOrderDetailService dispatchOrderDetailService;

    /**
     * 查询平台调度单详单
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<DispatchOrderDetailVo> pageData(@RequestBody DispatchOrderDetailSearchVo vo){
        logger.info("Query dispatch order detail pagination page");

        return dispatchOrderDetailService.findAllPage(vo);
    }

    /**
     * 查询平台调度单统计
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/sum", method = RequestMethod.POST)
    public DispatchOrderSumVo orderSum(@RequestBody DispatchOrderDetailSearchVo vo){
        logger.info("Query dispatch order summary data");

        return dispatchOrderDetailService.findOrderSum(vo);
    }

    /**
     * 确认/撤销调度单
     * @param vo
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public WebReturnMessage operate(@RequestBody DispatchOrderDetailSearchVo vo) throws JsonProcessingException {
        logger.info("dispatch order operate");

        //如果单据来源于建邦大宗需要先判断对方是否可以撤销单据
        if("30".equals(vo.getCurStu()) && "00".equals(vo.getStatus()) && "1".equals(vo.getDeliveryInfoZdwlSource())){
            Map resultMap = dispatchOrderDetailService.checkDzIfCancel(vo);
            Assert.isTrue("1".equals(resultMap.get("returnFlag")), resultMap.get("returnInfor").toString());
        }
        dispatchOrderDetailService.updateStatus(vo);

        // 收货完成时，生成个体工商注册申请
        if ("90".equals(vo.getStatus())) {
            dispatchOrderDetailService.genBusinessReg(vo);
        }

        return WebReturnMessage.sucess;
    }

    /**
     * 单据处理
     * @param vo
     * @return
     */
    @RequestMapping(value = "/dealFlag", method = RequestMethod.POST)
    public WebReturnMessage dealFlag(@RequestBody DispatchOrderDetailSearchVo vo){
        logger.info("deal flag with dispatch order");
        TransportationdeliveryEntity transportationdeliveryEntity = dispatchOrderDetailService.findById(Long.parseLong(vo.getDeliveryId()));
        if(transportationdeliveryEntity != null){
            transportationdeliveryEntity.setOrtherFlag("1");
            dispatchOrderDetailService.save(transportationdeliveryEntity);
        }

        return WebReturnMessage.sucess;
    }

}