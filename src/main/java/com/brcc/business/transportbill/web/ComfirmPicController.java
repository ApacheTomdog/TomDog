package com.brcc.business.transportbill.web;

import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.TransportationComfirmPicQueryVo;
import com.brcc.business.transportbill.vo.TransportationComfirmPicVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc：   回单图片审查controller
 * @author: TangYong
 * @Date:   2019-04-15
 */
@RestController
@RequestMapping("/transportBill/comfirmPic")
public class ComfirmPicController {

    Logger logger = LoggerFactory.getLogger(ComfirmPicController.class);
    @Autowired
    private TransportationDeliveryService transportationDeliveryService;

    @RequestMapping("/comfirmPicData")
    public Page<TransportationComfirmPicVo> pageData(@RequestBody TransportationComfirmPicQueryVo queryVo ){
        // 回单数据
        logger.info("query transport comfirmPic page data");
        return transportationDeliveryService.comfirmPicData(queryVo);
    }

    /**
     * 导出审核数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/excelDeliveryComfirmPicList")
    public List<TransportationComfirmPicVo> excelDeliveryComfirmPicList(@RequestBody TransportationComfirmPicQueryVo queryVo){
        logger.info("query transport comfirmPic list data");
        return transportationDeliveryService.excelDeliveryComfirmPicList(queryVo);
    }

    /**
     * 功能描述: <br>
     * 更新回单审核状态 (00代表审核不通过，10代表未审核，20代表审核通过)
     * @param deliveryIds deliveryIds字符串
     * @param status 回单状态
     */
    @PostMapping("/audit")
    public WebReturnMessage auditBybatch(String deliveryIds,String status){
        logger.info("update transport risk_audit_status list data");
        List<Long> deliveryIdList = Arrays.asList(deliveryIds.split(",")).stream().map(id -> Long.valueOf(id)).collect(Collectors.toList());
        transportationDeliveryService.auditBybatch(deliveryIdList,status);
        return new WebReturnMessage(true,"审核成功！");
    }

    /**
     * 功能描述: <br>
     * 回单审核不通过 (00代表审核不通过，10代表未审核，20代表审核通过)
     * @param deliveryIds  deliveryId字符串集
     * @param cause 不通过原因 （10重量异常、20车牌号异常、30时间异常、40回单信息异常、50品名异常）
     */
    @PostMapping("/reject")
    WebReturnMessage rejectBybatch(String deliveryIds,String cause){
        logger.info("reject transport risk_audit_status list data");
        List<Long> deliveryIdList = Arrays.asList(deliveryIds.split(",")).stream().map(id -> Long.valueOf(id)).collect(Collectors.toList());
        transportationDeliveryService.rejectBybatch(deliveryIdList,cause);
        return WebReturnMessage.sucess;
    }

}
