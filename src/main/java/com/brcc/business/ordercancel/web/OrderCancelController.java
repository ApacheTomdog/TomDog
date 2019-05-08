package com.brcc.business.ordercancel.web;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.service.OrderCancelService;
import com.brcc.business.ordercancel.vo.OrderCancelSearchVo;
import com.brcc.business.ordercancel.vo.OrderCancelVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 撤单审核业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-07 11:23
 */
@RestController
@RequestMapping("/business/orderCancel/")
public class OrderCancelController {

    Logger logger = LoggerFactory.getLogger(OrderCancelController.class);

    @Autowired
    private OrderCancelService orderCancelService;

    /**
     * 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<OrderCancelVo> pageData(@RequestBody OrderCancelSearchVo vo){
        logger.info("Query order cancel pagination page");

        return orderCancelService.findAllPage(vo);
    }

    /**
     * 分页列表数据(货主级)
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherPageData", method = RequestMethod.POST)
    public Page<OrderCancelVo> publisherPageData(@RequestBody OrderCancelSearchVo vo){
        logger.info("Query order cancel pagination page");

        return orderCancelService.findAllPublisherPage(vo);
    }

    /**
     * 列表数据(货主级)
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherListData", method = RequestMethod.POST)
    public List<OrderCancelVo> publisherListData(@RequestBody OrderCancelSearchVo vo){
        logger.info("Query order cancel pagination page");

        return orderCancelService.findAllPublisherList(vo);
    }

    /**
     * 审核撤单
     * @param entity 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public WebReturnMessage orderCancel(@RequestBody DeliverycancelauditEntity entity){
        logger.info("do order cancel process");
        Map<String, Object> resultMap = orderCancelService.orderCancel(entity);
        if(resultMap != null){
            Assert.isTrue("1".equals(resultMap.get("as_out_result")), (String) resultMap.get("as_out_result_reason"));
        }

        return WebReturnMessage.sucess;
    }

    /**
     * 获取所有数据
     * @param vo
     * @return
     */
    @RequestMapping(value = "/listData", method = RequestMethod.POST)
    public List<OrderCancelVo> findAll(@RequestBody OrderCancelSearchVo vo){
        logger.info("Query order cancel list data");
        return orderCancelService.findAll(vo);
    }

    /**
     * 更新状态
     * @param vo
     * @return
     */
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public WebReturnMessage updateStatus(@RequestBody OrderCancelSearchVo vo){
        logger.info("Query order cancel list data");
        orderCancelService.updateStatus(vo);
        return WebReturnMessage.sucess;
    }
}