package com.brcc.business.transorder.web;

import com.brcc.business.transorder.service.ViewAbnormalService;
import com.brcc.business.transorder.vo.ViewAbnormalSearchVo;
import com.brcc.business.transorder.vo.ViewAbnormalVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 * 平台调度单异常列表
 *
 * @author yushaohua
 * @create 2018-11-14 17:14
 */
@RestController
@RequestMapping("/business/abnormal/")
public class ViewAbnormalController {

    Logger logger = LoggerFactory.getLogger(ViewAbnormalController.class);

    @Autowired
    private ViewAbnormalService viewAbnormalService;

    /**
     * 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<ViewAbnormalVo> pageData(@RequestBody ViewAbnormalSearchVo vo){
        logger.info("Query abnormal order pagination page");

        return viewAbnormalService.findAllPage(vo);
    }

    /**
     * 列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/listData", method = RequestMethod.POST)
    public List<ViewAbnormalVo> listData(@RequestBody ViewAbnormalSearchVo vo){
        logger.info("Query abnormal order list data");

        return viewAbnormalService.listData(vo);
    }
}