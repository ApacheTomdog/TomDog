package com.brcc.business.transportbill.web;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.CheckFreightVo;
import com.brcc.business.transportbill.vo.CompanyModelVo;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationBillOperatorVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:25
 */
@RestController
@RequestMapping("/transportBill/")
public class TransportationDeliveryController {

    Logger logger = LoggerFactory.getLogger(TransportationDeliveryController.class);
//测试
    @Autowired
    TransportationDeliveryService transportationDeliveryService;

    @RequestMapping("/pageData")
    public Page<TransportationDeliveryVo> queryPage(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("queryPage Data : ");
        return transportationDeliveryService.queryPage(transportBillQueryVo);
    }

    @RequestMapping("/hzPageData")
    public Page<TransportationDeliveryVo> queryHzPage(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("queryPage Data : ");
        return transportationDeliveryService.queryHzPage(transportBillQueryVo);
    }

    @RequestMapping("/listHzData")
    public List<TransportationDeliveryVo> queryHzList(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("query list Data : ");
        return transportationDeliveryService.queryHzList(transportBillQueryVo);
    }

    @RequestMapping("/listCyData")
    public List<TransportationDeliveryVo> queryCyList(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("query list Data : ");
        return transportationDeliveryService.queryCyList(transportBillQueryVo);
    }

    @RequestMapping("/listData")
    public List<TransportationDeliveryVo> queryList(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("query list Data : ");
        return transportationDeliveryService.queryList(transportBillQueryVo);
    }

    @RequestMapping("/updateStatus")
    public WebReturnMessage updateStatus(@RequestBody TransportationBillOperatorVo transportationBillOperatorVo){
        logger.info("update transport bill status ");
        String msg = transportationDeliveryService.updateStatus(transportationBillOperatorVo);
        return new WebReturnMessage(true, msg);
    }

    @RequestMapping("/dealFlag")
    public boolean dealFlag(@RequestBody TransportationBillOperatorVo transportationBillOperatorVo){
        logger.info("transportation delivery deal flag ");
        transportationDeliveryService.dealFlag(transportationBillOperatorVo);
        return true;
    }

    /**
     * @Description  查询调度单预警列表
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.transportbill.vo.TransportationDeliveryQueryVo>
     **/
    @RequestMapping("/listWarningForPublisher")
    Page<TransportationDeliveryQueryVo> queryListWarning(@RequestBody TransportationDeliveryQueryVo vo){
        logger.info(" query list warning for publisher，platformId:{},publishCompanyId:{}",vo.getPlatformId(),vo.getPublishCompanyId());
        Assert.notNull(vo.getPlatformId(),"参数platformId不能为空！");
        Assert.notNull(vo.getPublishCompanyId(),"参数publishCompanyId不能为空！");
        return transportationDeliveryService.queryListWarning(vo);
    }

    /**upda
     * 保存回单截图地址
     * @param vo
     * @return
     */
    @RequestMapping("/saveReceipt")
    public WebReturnMessage saveReceipt(@RequestBody TransportBillQueryVo vo){
        logger.info("save Receipt ");
        transportationDeliveryService.saveReceipt(vo);
        return WebReturnMessage.sucess;
    }

    /**
     * 更新装车确认状态
     * @param vo
     * @return
     */
    @RequestMapping("/saveZcConfirm")
    public WebReturnMessage saveZcConfirm(@RequestBody TransportBillQueryVo vo){
        logger.info("save Zc Confirm ");
        vo.setStatus("30");
        transportationDeliveryService.zcConfirm(vo);
        return WebReturnMessage.sucess;
    }

    /**
     * 修改装车、收货重量
     * @param vo
     * @return
     */
    @RequestMapping("/saveWeight")
    public WebReturnMessage saveWeight(@RequestBody TransportBillQueryVo vo){
        logger.info("save Zc Confirm ");
        transportationDeliveryService.saveWeight(vo);
        return WebReturnMessage.sucess;
    }

    /**
     * 派车单打印
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/orderPrint")
    public TransportationDeliveryVo orderPrint(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("query list Data : ");
        return transportationDeliveryService.queryPublisherId(transportBillQueryVo);
    }

    /**
     * 撤单申请校验
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/deliveryCancelCheck")
    public WebReturnMessage deliveryCancelCheck(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("delivery Cancel check ");
        return transportationDeliveryService.deliveryCancel(transportBillQueryVo);
    }

    /**
     * 撤单申请
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/deliveryCancel")
    public WebReturnMessage deliveryCancel(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("delivery Cancel ");
        transportationDeliveryService.saveDeliveryCancel(transportBillQueryVo);
        return WebReturnMessage.sucess;
    }

    /**
     * 撤单申请
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/findById")
    public TransportationDeliveryEntity findById(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("delivery Cancel ");
        return transportationDeliveryService.findById(transportBillQueryVo.getDeliveryId());
    }

    /**
     * 合并装车收货重量
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/saveAgreement")
    public WebReturnMessage saveAgreement(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("delivery Cancel ");
        transportationDeliveryService.saveAgreement(transportBillQueryVo);
        return WebReturnMessage.sucess;
    }

    /**
     * 查询承运级调度单分页数据
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/cyPageData")
    public Page<TransportationDeliveryVo> queryCyPage(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("queryPage Data : ");
        return transportationDeliveryService.queryCyPage(transportBillQueryVo);
    }

    /**
     * 经纪人运费分配
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/changeBroker")
    public WebReturnMessage changeBroker(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("delivery Cancel ");
        String result = transportationDeliveryService.changeBroker(transportBillQueryVo);
        return new WebReturnMessage(true, result);
    }

    /**
     * 运单打印
     * @param transportBillQueryVo
     * @return
     */
    @RequestMapping("/transPrint")
    public TransportationDeliveryVo transPrint(@RequestBody TransportBillQueryVo transportBillQueryVo){
        logger.info("query list Data : ");
        return transportationDeliveryService.lookContracts(transportBillQueryVo);
    }
    /**
     * 查看运费
     * @param CheckFreightVo
     * @return
     */
    @RequestMapping("/checkFreight")
    public List<CheckFreightVo> checkFreight(@RequestBody Long deliveryId){
        logger.info("queryPage Data : ");
        return transportationDeliveryService.checkFreight(deliveryId);
    }

    /**
     * 修改货主备注
     * @param vo
     * @return
     */
    @RequestMapping("/updateGoodsOwnerPs")
    public WebReturnMessage updateGoodsOwnerPs(@RequestBody TransportBillQueryVo vo){
        logger.info("updateGoodsOwnerPs ");
        transportationDeliveryService.updateGoodsOwnerPs(vo);
        return WebReturnMessage.sucess;
    }

    @RequestMapping("/findModelById")
    public CompanyModelVo findModelById(@RequestBody Long companyId) {
        return transportationDeliveryService.findModelById(companyId);
    }



    @RequestMapping("/updateSignStatus")
    public WebReturnMessage updateSignStatus(@RequestBody TransportBillQueryVo transportBillQueryVo) {
        transportationDeliveryService.updateSignStatus(transportBillQueryVo);
        return WebReturnMessage.sucess;
    }
}
