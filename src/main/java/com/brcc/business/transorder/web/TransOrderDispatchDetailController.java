package com.brcc.business.transorder.web;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.service.TransOrderDispatchDetailService;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
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
 * 平台运输单调度详情
 *
 * @author yushaohua
 * @create 2018-11-02 14:09
 */
@RestController
@RequestMapping("/business/transOrderDispatch/")
public class TransOrderDispatchDetailController {

    Logger logger = LoggerFactory.getLogger(TransOrderDispatchDetailController.class);

    @Autowired
    private TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    private CompanyService companyService;

    /**
     * 查询平台运输单调度详情
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public TransOrderDispatchDetailVo detail(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch detail");

        return transOrderDispatchDetailService.findOrderDetail(vo);
    }

    /**
     * 获取承运公司
     * @param vo
     * @return
     */
    @RequestMapping(value = "/companyIfTransport", method = RequestMethod.POST)
    public List<CompanyEntity> companyIfTransport(TransOrderDispatchDetailSearchVo vo){
        return companyService.companyIfTransport(vo.getPlatformId(), vo.getCompanyId());
    }

    /**
     * 查询平台运调度单预警列表分页数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<TransOrderDispatchDetailVo> pageData(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch page data");

        return transOrderDispatchDetailService.findWarningList(vo);
    }

    /**
     * 查询货主级别运调度单预警列表分页数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherPageData", method = RequestMethod.POST)
    public Page<TransOrderDispatchDetailVo> publisherPageData(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch page data");

        return transOrderDispatchDetailService.findPublisherWarningList(vo);
    }

    /**
     * 查询平台运调度单预警列表
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/publisherListData", method = RequestMethod.POST)
    public List<TransOrderDispatchDetailVo> publisherListData(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch page data");

        return transOrderDispatchDetailService.findPublisherWarningListData(vo);
    }

    /**
     * 导出平台运调度单预警列表
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public List<TransOrderDispatchDetailVo> excel(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch page data");

        return transOrderDispatchDetailService.findAllWarningList(vo);
    }

    /**
     * 委托承运调度单分页数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/carrierPageData", method = RequestMethod.POST)
    public Page<TransOrderDispatchDetailVo> carrierPageData(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query carrier dispatch order page data");

        return transOrderDispatchDetailService.findCarrierPage(vo);
    }

    /**
     * 委托承运调度单分页数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/carrierListData", method = RequestMethod.POST)
    public List<TransOrderDispatchDetailVo> carrierListData(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query carrier dispatch order list data");

        return transOrderDispatchDetailService.findCarrierList(vo);
    }

    /**
     * 根据条件查询数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/verifyDelivery", method = RequestMethod.POST)
    public List<TransportationdeliveryEntity> verifyDelivery(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query carrier dispatch order list data");

        return transOrderDispatchDetailService.verifyDelivery(vo.getPlatformId(), Long.parseLong(vo.getTransId()));
    }
    
    /**
     * 查询承运级调度单预警列表分页数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/findCarriagePage", method = RequestMethod.POST)
    public Page<TransOrderDispatchDetailVo> findCarriagePage(@RequestBody TransOrderDispatchDetailSearchVo vo){
        logger.info("Query trans order dispatch page data");

        return transOrderDispatchDetailService.findCarriagePage(vo);
    }
    /**
     * 导出承运级调度预警列表
     * @param vo
     * @return
     */
    @RequestMapping(value = "/excelCarriageWarningList", method = RequestMethod.POST)
    public List<TransOrderDispatchDetailVo> excelCarriageWarningList(@RequestBody TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailService.excelCarriageWarningList(vo);
    }
}