package com.brcc.business.transorder.web;

import com.brcc.business.transorder.service.TransOrderDetailService;
import com.brcc.business.transorder.vo.TransOrderDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 * 平台运输单详情
 *
 * @author yushaohua
 * @create 2018-11-01 17:07
 */
@RestController
@RequestMapping("/business/transOrderDetail/")
public class TransOrderDetailController {

    Logger logger = LoggerFactory.getLogger(TransOrderDetailController.class);

    @Autowired
    private TransOrderDetailService transOrderDetailService;

    /**
     * 查询平台运输单详情
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public TransOrderDetailVo pageData(@RequestBody TransOrderDetailSearchVo vo){
        logger.info("Query trans order detail pagination page");

        return transOrderDetailService.findOrderDetail(vo);
    }

}