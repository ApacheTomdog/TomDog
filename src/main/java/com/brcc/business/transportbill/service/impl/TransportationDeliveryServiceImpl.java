package com.brcc.business.transportbill.service.impl;

import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.dispatchorder.entity.DeliveryuploadConfigEntity;
import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.service.*;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.service.OrderCancelService;
import com.brcc.business.transorder.service.TransOrderDispatchDetailService;
import com.brcc.business.transorder.service.TransOrderService;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transportSettle.entity.ConfigOwnerLossEntity;
import com.brcc.business.transportSettle.service.ConfigOwnerLossService;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportation.service.TransportationmService;
import com.brcc.business.transportbill.entity.TransportationDeliveryDeviceEntity;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.repository.TransportationDeliveryRepository;
import com.brcc.business.transportbill.service.TransportationDeliveryDeviceService;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.*;
import com.esteel.common.controller.WebReturnMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:24
 */

@Transactional
@Service
public class TransportationDeliveryServiceImpl implements TransportationDeliveryService {

    Logger logger = LoggerFactory.getLogger(TransportationDeliveryServiceImpl.class);

    @Autowired
    TransportationDeliveryRepository transportationDeliveryRepository;

    @Autowired
    DeliveryUploadConfigService deliveryUploadConfigService;

    @Autowired
    TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    DispatchOrderDetailService dispatchOrderDetailService;

    @Autowired
    DeliveryUploadService deliveryUploadService;

    @Autowired
    GoodsordermService goodsordermService;

    @Autowired
    TransportationDeliveryUploadService transportationDeliveryUploadService;

    @Autowired
    TransOrderService transOrderService;

    @Autowired
    TransportationmService transportationmService;

    @Autowired
    GoodsOrderExecuteLogService goodsOrderExecuteLogService;

    @Autowired
    OrderCancelService orderCancelService;

    @Autowired
    TransportationDeliveryDeviceService transportationDeliveryDeviceService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ConfigOwnerLossService configOwnerLossService;

    @Value("${platformId:SX*HSY*0001}")
    String platformId;

    @Autowired
    MybatisQuery mybatisQuery;

    @Override
    public Page<TransportationDeliveryVo> queryPage(TransportBillQueryVo transportBillQueryVo) {
        logger.info("query page ");
        return transportationDeliveryRepository.queryPage(transportBillQueryVo);
    }

    @Override
    public List<TransportationDeliveryVo> queryList(TransportBillQueryVo transportBillQueryVo) {
        logger.info("query page ");
        return transportationDeliveryRepository.queryList(transportBillQueryVo);
    }

    @Override
    public Page<TransportationDeliveryVo> settleList(TransportBillQueryVo transportBillQueryVo) {
        logger.info("query settleList ");
        Page<TransportationDeliveryVo> page = mybatisQuery.page("transportSettle.list", transportBillQueryVo);
        return page;
    }

    @Override
    public Page<TransportationDeliveryVo> settleListForGroup(TransportBillQueryVo transportBillQueryVo) {
        logger.info("query settleList ");
        Page<TransportationDeliveryVo> page = mybatisQuery.page("transportSettle.listForGroup", transportBillQueryVo);
        return page;
    }

    @Override
    public List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo) {
        logger.info("query transportationDelivery list,by publishId:{}", vo.getPublishId());
        return transportationDeliveryRepository.listDeliveryDetails(vo);
    }

    @Override
    public void saveJsRemark(TransportBillQueryVo vo) {
        logger.info("save jsRemark,deliveryId:{}", vo.getDeliveryId());
        Optional<TransportationDeliveryEntity> op = transportationDeliveryRepository.findById(vo.getDeliveryId());
        TransportationDeliveryEntity transportationDeliveryEntity = op.get();
        transportationDeliveryEntity.setJsRemark(vo.getJsRemark());
        transportationDeliveryEntity.setUpdatePerson(vo.userId);
        transportationDeliveryEntity.setUpdateDate(new Date());
        transportationDeliveryRepository.save(transportationDeliveryEntity);
    }

    @Override
    public void saveConfirmPic(TransportBillQueryVo vo) {
        logger.info("save confirmPic,deliveryId:{},confirmPic:{}", vo.getDeliveryId(), vo.getImgPath());
        Optional<TransportationDeliveryEntity> op = transportationDeliveryRepository.findById(vo.getDeliveryId());
        TransportationDeliveryEntity transportationDeliveryEntity = op.get();
        transportationDeliveryEntity.setComfirmPic1Local(vo.getImgPath());
        transportationDeliveryEntity.setIfUploadReceiptFlag("1");
        transportationDeliveryEntity.setUpdatePerson(vo.userId);
        transportationDeliveryEntity.setUpdateDate(new Date());

        String remark = transportationDeliveryEntity.getRemark();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer sb = new StringBuffer();
        sb.append(remark == null ? "" : remark);
        sb.append(" ");
        sb.append(vo.getUserName());
        sb.append("上传回单");
        sb.append(sdf.format(new Date()));
        transportationDeliveryEntity.setRemark(sb.toString());
        transportationDeliveryRepository.save(transportationDeliveryEntity);
    }

    public List<TransportationDeliveryEntity> queryDeliveryDetail(TransportBillQueryVo vo) {
        logger.info("query transportationDelivery list,by transId:{}", vo.getTransId());
        return transportationDeliveryRepository.findByTransId(Long.valueOf(vo.getTransId()));
    }

    @Override
    public TransportationDeliveryEntity findById(Long deliveryId) {
        return transportationDeliveryRepository.findById(deliveryId).get();
    }

    @Override
    public TransportationDeliveryEntity save(TransportationDeliveryEntity transportationDeliveryEntity) {
        return transportationDeliveryRepository.save(transportationDeliveryEntity);
    }

    @Override
    public List<TransportationDeliveryVo> querySettleInfo(TransportBillQueryVo queryVo) {
        logger.info("Query settleInfo list,{}", queryVo.toString());
        List<TransportationDeliveryVo> list = mybatisQuery.list("transportSettle.exportSettleInfolist", queryVo);
        return list;
    }

    @Override
    public TransportationDeliveryVo queryDeliveryVo(TransportBillQueryVo queryVo) {
        logger.info("query deliveryVo,transportationdeliveryId:{}", queryVo.getTransportationdeliveryId());
        List<TransportationDeliveryVo> list = mybatisQuery.list("transportSettle.list", queryVo);
        Assert.isTrue(list != null && list.size() == 1, "调度单数据异常，无法结算");
        TransportationDeliveryVo vo = list.get(0);

        TransportationDeliveryVo receiveVo = null;
        // 默认点卡配置
        receiveVo = mybatisQuery.selectOne("transportSettle.queryOilRatioInfo", queryVo);
        if (receiveVo != null) {
            vo.setOilFlag(receiveVo.getOilFlag());
            vo.setOilRatio(receiveVo.getOilRatio());
            vo.setOilAmount(receiveVo.getOilAmount());
        } else {
            vo.setOilFlag("0");
            vo.setOilRatio(new BigDecimal("0.30"));
            vo.setOilAmount(new BigDecimal("500"));
        }
        // 查询默认付款单位
        receiveVo = mybatisQuery.selectOne("transportSettle.queryDefaultPayCompany", queryVo);
        if (receiveVo != null) {
            vo.setPayCompanyId(receiveVo.getPayCompanyId());
            vo.setPayCompanyName(receiveVo.getPayCompanyName());
        }

        // 货主亏吨计算时，是否不扣除合理路损
        List<ConfigOwnerLossEntity> configList = configOwnerLossService.findByCompanyId(queryVo.getCompanyId());
        if (null != configList && configList.size() > 0) {
            vo.setIfOwnerLoss("Y");
        } else {
            vo.setIfOwnerLoss("N");
        }

        // 经纪人分润情况
        Optional<TransportationDeliveryEntity> op = transportationDeliveryRepository.findById(queryVo.getTransportationdeliveryId());
        TransportationDeliveryEntity transportationDeliveryEntity = op.get();
        vo.setBrokerPeopleTollType(transportationDeliveryEntity.getBrokerPeopleTollType());
        vo.setBrokerPeopleTollRatio(transportationDeliveryEntity.getBrokerPeopleTollRatio());
        vo.setBrokerPeopleTollAmount(transportationDeliveryEntity.getBrokerPeopleTollAmount());
        vo.setIfBrokerPeopleTollFlag(transportationDeliveryEntity.getIfBrokerPeopleTollFlag() == null ? "N" : transportationDeliveryEntity.getIfBrokerPeopleTollFlag());

        // 查询物流公司，司机，经纪人收款银行账号
        receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", vo);
        if (null != receiveVo) {
            vo.setCarrierBankName(receiveVo.getBankName());
            vo.setCarrierBankNum(receiveVo.getBankNum());
            vo.setCarrierBankOwner(receiveVo.getBankOwner());
        } else {
            vo.setCarrierBankName(null);
            vo.setCarrierBankNum(null);
            vo.setCarrierBankOwner(null);
        }

        // 如果是经纪人，则查询司机收款账号
        if ("Y".equals(transportationDeliveryEntity.getIfBrokerPeopleTollFlag())) {
            TransportationDeliveryVo transportationDeliveryVo = new TransportationDeliveryVo();
            transportationDeliveryVo.setCompanyId(vo.getDriverCompanyId());
            receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", transportationDeliveryVo);
            if (null != receiveVo) {
                vo.setDriverBankName(receiveVo.getBankName());
                vo.setDriverBankNum(receiveVo.getBankNum());
                vo.setDriverBankOwner(receiveVo.getBankOwner());
            } else {
                vo.setDriverBankName(null);
                vo.setDriverBankNum(null);
                vo.setDriverBankOwner(null);
            }
        }

        // 货主抹零配置
        receiveVo = mybatisQuery.selectOne("transportSettle.queryPayErase", queryVo);
        if (receiveVo != null) {
            vo.setEraseType(receiveVo.getEraseType());
            vo.setEraseMinAmount(receiveVo.getEraseMinAmount());
            vo.setIfPayErase("Y");
        } else {
            vo.setIfPayErase("N");
        }
        // 卸车费
        receiveVo = mybatisQuery.selectOne("transportSettle.queryDumpTruckCharge", queryVo);
        if (receiveVo != null) {
            vo.setDumpTruckCharge(receiveVo.getDumpTruckCharge());
            vo.setIfDumpTruckCharge("Y");
        } else {
            vo.setIfDumpTruckCharge("N");
        }

        return vo;
    }

    @Override
    public TransportationDeliveryVo queryDeliveryVoForGroup(TransportBillQueryVo queryVo) {
        logger.info("query deliveryVo,transportationdeliveryId:{},publishCompanyId:{}", queryVo.getTransportationdeliveryId(), queryVo.getPublishCompanyId());
        List<TransportationDeliveryVo> list = mybatisQuery.list("transportSettle.listForGroup", queryVo);
        Assert.isTrue(list != null && list.size() == 1, "调度单数据异常，无法结算");
        TransportationDeliveryVo vo = list.get(0);

        TransportationDeliveryVo receiveVo = null;
        // 默认点卡配置
        receiveVo = mybatisQuery.selectOne("transportSettle.queryOilRatioInfo", queryVo);
        if (receiveVo != null) {
            vo.setOilFlag(receiveVo.getOilFlag());
            vo.setOilRatio(receiveVo.getOilRatio());
            vo.setOilAmount(receiveVo.getOilAmount());
        } else {
            vo.setOilFlag("0");
            vo.setOilRatio(new BigDecimal("0.30"));
            vo.setOilAmount(new BigDecimal("500"));
        }
        // 查询默认付款单位
        receiveVo = mybatisQuery.selectOne("transportSettle.queryDefaultPayCompany", queryVo);
        if (receiveVo != null) {
            vo.setPayCompanyId(receiveVo.getPayCompanyId());
            vo.setPayCompanyName(receiveVo.getPayCompanyName());
        }

        // 货主亏吨计算时，是否不扣除合理路损
        List<ConfigOwnerLossEntity> configList = configOwnerLossService.findByCompanyId(queryVo.getCompanyId());
        if (null != configList && configList.size() > 0) {
            vo.setIfOwnerLoss("Y");
        } else {
            vo.setIfOwnerLoss("N");
        }

        // 经纪人分润情况
        Optional<TransportationDeliveryEntity> op = transportationDeliveryRepository.findById(queryVo.getTransportationdeliveryId());
        TransportationDeliveryEntity transportationDeliveryEntity = op.get();
        vo.setBrokerPeopleTollType(transportationDeliveryEntity.getBrokerPeopleTollType());
        vo.setBrokerPeopleTollRatio(transportationDeliveryEntity.getBrokerPeopleTollRatio());
        vo.setBrokerPeopleTollAmount(transportationDeliveryEntity.getBrokerPeopleTollAmount());
        vo.setIfBrokerPeopleTollFlag(transportationDeliveryEntity.getIfBrokerPeopleTollFlag() == null ? "N" : transportationDeliveryEntity.getIfBrokerPeopleTollFlag());

        // 查询物流公司，司机，经纪人收款银行账号
        receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", vo);
        if (null != receiveVo) {
            vo.setCarrierBankName(receiveVo.getBankName());
            vo.setCarrierBankNum(receiveVo.getBankNum());
            vo.setCarrierBankOwner(receiveVo.getBankOwner());
        } else {
            vo.setCarrierBankName(null);
            vo.setCarrierBankNum(null);
            vo.setCarrierBankOwner(null);
        }

        // 如果是经纪人，则查询司机收款账号
        if ("Y".equals(transportationDeliveryEntity.getIfBrokerPeopleTollFlag())) {
            TransportationDeliveryVo transportationDeliveryVo = new TransportationDeliveryVo();
            transportationDeliveryVo.setCompanyId(vo.getDriverCompanyId());
            receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", transportationDeliveryVo);
            if (null != receiveVo) {
                vo.setDriverBankName(receiveVo.getBankName());
                vo.setDriverBankNum(receiveVo.getBankNum());
                vo.setDriverBankOwner(receiveVo.getBankOwner());
            } else {
                vo.setDriverBankName(null);
                vo.setDriverBankNum(null);
                vo.setDriverBankOwner(null);
            }
        }

        // 货主抹零配置
        receiveVo = mybatisQuery.selectOne("transportSettle.queryPayErase", queryVo);
        if (receiveVo != null) {
            vo.setEraseType(receiveVo.getEraseType());
            vo.setEraseMinAmount(receiveVo.getEraseMinAmount());
            vo.setIfPayErase("Y");
        } else {
            vo.setIfPayErase("N");
        }
        // 卸车费
        receiveVo = mybatisQuery.selectOne("transportSettle.queryDumpTruckCharge", queryVo);
        if (receiveVo != null) {
            vo.setDumpTruckCharge(receiveVo.getDumpTruckCharge());
            vo.setIfDumpTruckCharge("Y");
        } else {
            vo.setIfDumpTruckCharge("N");
        }

        return vo;
    }

    @Override
    public String updateStatus(TransportationBillOperatorVo transportationBillOperatorVo) {
        String message = "操作成功！";
        logger.info("update transport bill state curStatus:{} new status:{}", transportationBillOperatorVo.getCurStu(), transportationBillOperatorVo.getStatus());
        //如果单据来源于建邦大宗，需要判断对方是否可以撤销单据
        Long deliveryId = transportationBillOperatorVo.getDeliveryId();
        Map map=new HashMap();
        if ("30".equals(transportationBillOperatorVo.getCurStu()) && "00".equals(transportationBillOperatorVo.getStatus()) && "1".equals(transportationBillOperatorVo.getDeliveryInfoZdwlSource())) {
            DeliveryuploadConfigEntity byJkName = deliveryUploadConfigService.findByJkName("update_PaiCheMX");
//            Assert.isTrue(byJkName != null, "数据错误，该数据为非大宗数据");
            if(byJkName == null){
                return "数据错误，该数据为非大宗数据";
            }
            DzCancelDataForCancelVo dzCancelDataVo = transOrderDispatchDetailService.queryDzCancelData(deliveryId.toString(), platformId);
            ObjectMapper objectMapper = new ObjectMapper();
            String requestStr = "";
            try {
                requestStr = objectMapper.writeValueAsString(dzCancelDataVo);
            } catch (JsonProcessingException e) {
                Assert.isTrue(false, e.getMessage());
            }

            map = dispatchOrderDetailService.sendDeliveryCancelXml(requestStr, byJkName);

            String returnFlag = ((String) map.get("returnFlag")).trim();
            logger.info("send deliveryCancel xml resultFlag:{}", returnFlag);

            String returnInfo = (String) map.get("returnInfor");

            //如果resultFlag.equals("0") 表示报错

            String savedReturnFlag = "1";

            if ("1".equals(returnFlag)) {
                savedReturnFlag = "2";
            }

            //存储接口取消操作的日志
            deliveryUploadService.insertDeliveryCancelLog(savedReturnFlag, returnInfo, deliveryId.toString());

            if("1".equalsIgnoreCase(savedReturnFlag)){
                return returnInfo;
            }
        }

        DzCancelDataVo dzCancelDataVo = transOrderDispatchDetailService.queryStatue(String.valueOf(deliveryId), platformId);
        if(dzCancelDataVo == null){
            return "没有查询到对象 数据错误";
        }

        if(!dzCancelDataVo.getStatus().equalsIgnoreCase(transportationBillOperatorVo.getCurStu())){
            return "当前数据过时，请刷新页面";
        }

        // 风控---合适时间内收货确认(判断单据来自平台,并且是待收货状态30)
        if("PT".equalsIgnoreCase(dzCancelDataVo.getFromType()) && "30".equals(dzCancelDataVo.getStatus())
                &&!ObjectUtils.isEmpty(dzCancelDataVo.getEstimateKM()) && "90".equals(transportationBillOperatorVo.getStatus())){
            // 计算合理运输时间，安全车速为60km/h
            double km = new BigDecimal(dzCancelDataVo.getEstimateKM()).divide(
                    new BigDecimal(60),2,BigDecimal.ROUND_HALF_UP).doubleValue();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(dzCancelDataVo.getCreateDate());
            cal.add(Calendar.MINUTE, (int)(km*60-120));
            if(cal.getTime().after(new Date())) {
                return "不在合理运输时间内，不允许收货确认，必须在："+format.format(cal.getTime())+"之后确认。";
            }

        }

        //货源单
        GoodsordermEntity goodsordermEntity = goodsordermService.findById(transportationBillOperatorVo.getPublishId());

        if ("20".equals(dzCancelDataVo.getStatus())) {
            if("Y".equalsIgnoreCase(dzCancelDataVo.getJkCount())){
                return "此单据来源于电商平台，不能进行此操作！";
            }
        }
        Date now = new Date();
        if ("90".equals(transportationBillOperatorVo.getStatus())) {
            String msg = "";
            Date createDate = null;
            int intervalTime = 20;

            IntervalTimeVo intervalTimeVo = this.transportationDeliveryRepository.intervalTime(deliveryId);
            if (intervalTimeVo == null) {
                intervalTime = 20;
                msg = "操作失败，请在取单20分钟后，再操作";
                createDate = dzCancelDataVo.getCreateDate();
            } else {
                intervalTime = intervalTimeVo.getTimes();
                msg = "操作失败," + intervalTimeVo.getCompanyName() + "的调度单，请在装车" + intervalTimeVo.getTimes() + "分钟后再操作！";
                createDate = dzCancelDataVo.getCreateDate();
            }

            createDate = createDate == null ? new Date() : createDate;
            Long result = Long.valueOf(now.getTime() - createDate.getTime());
            if (result.longValue() / 1000L/60L < intervalTime) {
                return msg;
            }
        }

        //JK_U9 立恒新大宗撤销

        TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();

        BeanUtils.copyProperties(transportationBillOperatorVo, transportationdeliveryuploadEntity);
        transportationdeliveryuploadEntity.setCreateDate(now);
        transportationdeliveryuploadEntity.setCreatePerson(transportationBillOperatorVo.getUserName());
        transportationdeliveryuploadEntity.setPlatFormId(platformId);
        transportationdeliveryuploadEntity.setIsUploadEc("0");
        transportationdeliveryuploadEntity.setBatchId("");
        transportationdeliveryuploadEntity.setOperateType("WEB");

//        if ("JK_U9".equals(transportationBillOperatorVo.getFromType()) && "00".equals(transportationBillOperatorVo.getStatus())) {
//            //查询调度单是否已经上传
//            int ifUpload = transportationDeliveryUploadService.queryIfUpload(transportationBillOperatorVo.getDeliveryId().toString());
//            transportationdeliveryuploadEntity.setCanUpload(new Integer(ifUpload).toString());
//
//            //1:已上传 0:未上传
//            if (ifUpload == 0 && "30".equals(transportationBillOperatorVo.getStatus())) {
//                transportationdeliveryuploadEntity.setIsUploadEc("-1");
//            }
//        }
        transportationDeliveryUploadService.save(transportationdeliveryuploadEntity);

//        deliveryEntity

        //更新调度单
        TransportationDeliveryEntity deliveryEntity = transportationDeliveryRepository.findById(deliveryId).get();
        deliveryEntity.setStatus(transportationBillOperatorVo.getStatus());
        if ("20".equals(transportationBillOperatorVo.getStatus())){
            deliveryEntity.setBillTime(now);
        }
        if ("30".equals(transportationBillOperatorVo.getStatus())){
            deliveryEntity.setDeliveryTime(now);
            deliveryEntity.setZcSureDate(now);
        }
        if ("90".equals(transportationBillOperatorVo.getStatus())){
            deliveryEntity.setFinishTime(now);
            deliveryEntity.setTakeDeliveryWeight(transportationBillOperatorVo.getShWeight());
            deliveryEntity.setShSureDate(now);
        }
        deliveryEntity.setUpdatePerson(transportationBillOperatorVo.getUserId());
        deliveryEntity.setUpdateDate(now);
        transportationDeliveryRepository.save(deliveryEntity);

        TransportationmEntity transportationmEntity = transportationmService.findById(transportationBillOperatorVo.getTransId());

        if ("00".equals(transportationBillOperatorVo.getStatus())){
            Assert.isTrue(!"JK_U11".equals(goodsordermEntity.getFromType()), "该调度单来自川威物流，不能撤销!");

            transOrderService.dispatchWeightBack(transportationBillOperatorVo.getDeliveryId().toString(),transportationBillOperatorVo.getTransId().toString(),platformId);
            transportationmEntity = transportationmService.findById(transportationBillOperatorVo.getTransId());
            CompanyEntity companyEntity = companyService.findCompanyById(deliveryEntity.getCompanyId());
            // 如果是司机撤单，同时作废运输单
            if (companyEntity != null && companyEntity.getCompanyNature() != null && "GR".equalsIgnoreCase(companyEntity.getCompanyNature())
                    && "1".equals(transportationBillOperatorVo.getDzJkCancel())) {
                Assert.notNull(transportationmEntity, "调度单不存在");
                //取消后 运输订单的数据 返回货源单
                goodsordermEntity.setWeight(goodsordermEntity.getWeight().add(transportationmEntity.getWeight()));
                goodsordermEntity.setQty(goodsordermEntity.getQty().add(transportationmEntity.getQty()));
                goodsordermEntity.setAmount(goodsordermEntity.getAmount().add(transportationmEntity.getAmount()));
                goodsordermEntity.setSaleWeight(goodsordermEntity.getSaleWeight().subtract(transportationmEntity.getWeight()));
                goodsordermEntity.setSaleQty(goodsordermEntity.getSaleQty().subtract(transportationmEntity.getQty()));
                goodsordermEntity.setSaleAmount(goodsordermEntity.getSaleAmount().subtract(transportationmEntity.getAmount()));

                goodsordermService.save(goodsordermEntity);

                //作废运输单
                transportationmEntity.setStatus(transportationBillOperatorVo.getStatus());
                transportationmEntity.setCompleteDate(now);
                transportationmEntity.setUpdatePerson(transportationBillOperatorVo.getUserId());
                transportationmEntity.setUpdateDate(now);
                transportationmService.save(transportationmEntity);
            }
        }

        transportationDeliveryRepository.flush();

//        GoodsordermEntity goodsordermEntity = goodsordermService.findById(deliveryEntity.getPublishId());
        if ("90".equals(transportationBillOperatorVo.getStatus())){
            DeliveryComplateWeightVo weightVo = this.findCompleteWeightByTransId(transportationBillOperatorVo.getTransId(), platformId);

            //与初始数据完全相同
            if (weightVo.getSumWeight().compareTo(weightVo.getInitWeight())==0&&weightVo.getSumQty().compareTo(weightVo.getInitQty())==0){
                transportationmEntity.setStatus("30");
                transportationmEntity.setCompleteDate(now);
                transportationmEntity.setUpdatePerson(transportationBillOperatorVo.getUserId());
                transportationmEntity.setUpdateDate(now);
                transportationmService.save(transportationmEntity);
            }

            DeliveryComplateWeightVo publishWeight = this.findCompleteWeightByPublishId(transportationBillOperatorVo.getPublishId(), platformId);

           /* if (publishWeight.getSumWeight().compareTo(publishWeight.getInitWeight())==0&&publishWeight.getSumQty().compareTo(publishWeight.getInitQty())==0){
                goodsordermEntity.setStatus("30");
                goodsordermService.save(goodsordermEntity);
            }*/

            GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();


            String act = "";
            String driverName = transportationBillOperatorVo.getDriverName();
            switch (transportationBillOperatorVo.getStatus()){
                case "30":{
                    act="司机"+driverName+"已装车";
                    break;
                }
                case "90":{
                    act="司机"+driverName+"已送达";
                    break;
                }
                case "00":{
                    act="该调度单被撤销，等待重新安排司机";
                    break;
                }
                case "20":{
                    act="司机"+driverName+"已取单";
                    break;
                }
            }

            goodsorderexecutelogEntity.setCreateTime(now);
            goodsorderexecutelogEntity.setDeliveryId(transportationBillOperatorVo.getDeliveryId());
            goodsorderexecutelogEntity.setExeDesc(act);
            goodsorderexecutelogEntity.setPublishId(transportationBillOperatorVo.getPublishId());
            goodsorderexecutelogEntity.setTransId(transportationBillOperatorVo.getTransId());


            goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);


        }

        // 收货完成，司机注册个体工商户
        if ("90".equals(transportationBillOperatorVo.getStatus())) {
            DispatchOrderDetailSearchVo dispatchOrderDetailSearchVo = new DispatchOrderDetailSearchVo();
            dispatchOrderDetailSearchVo.setDriverId(String.valueOf(transportationBillOperatorVo.getDriverId()));
            dispatchOrderDetailSearchVo.setPlatformId(transportationBillOperatorVo.getPlatformId());
            dispatchOrderDetailSearchVo.setUserId(transportationBillOperatorVo.getUserId());
            dispatchOrderDetailSearchVo.setUserName(transportationBillOperatorVo.getUserName());
            dispatchOrderDetailService.genBusinessReg(dispatchOrderDetailSearchVo);
        }

        // 撤销或者收货确认成功后，更新transportation_delivery_device中记录状态，解除抢单限制
        if("90".equals(transportationBillOperatorVo.getStatus()) || "00".equals(transportationBillOperatorVo.getStatus())) {
            TransportationDeliveryDeviceEntity transportationDeliveryDeviceEntity = transportationDeliveryDeviceService.findByDeliveryIdAndPlatformId(deliveryId, platformId);
            if (transportationDeliveryDeviceEntity != null) {
                transportationDeliveryDeviceEntity.setDeliveryStatus(transportationBillOperatorVo.getStatus());
                transportationDeliveryDeviceEntity.setUpdateDate(new Date());
                transportationDeliveryDeviceService.save(transportationDeliveryDeviceEntity);
            }
        }

        TransportationDeliveryQueryVo vo=mybatisQuery.selectOne("transportationdelivery.queryTDByDeliverId", transportationBillOperatorVo);
        // 川威调度单，收货确认时判断回单是否上传
        if ("90".equals(transportationBillOperatorVo.getStatus()) && vo.getBusinessMode().equals("2") && vo.getRobDeliveryType().equals("1")) {
            Assert.isTrue(!StringUtils.isEmpty(vo.getComfirmPic1Local()), "回单未上传");
            Long deliveryId1 = vo.getDeliveryId();
            Double destinationLng = vo.getDestinationLng();
            Double destinationLat = vo.getDestinationLat();
            String address = vo.getEndPlate();
            Date arriveTime = vo.getFinishTime();
            String imageAddress = vo.getComfirmPic1Local();
            Long publishId = vo.getPublishId();
            String fromPlatName = mybatisQuery.selectOne("transportationdelivery.queryGOByPublishId", publishId);
            transportationDeliveryRepository.insertToReInfoToCW(deliveryId1, destinationLng, destinationLat, address, arriveTime, imageAddress, fromPlatName);
        }
        return message;
    }

    @Override
    public DeliveryComplateWeightVo findCompleteWeightByTransId(Long transId, String platformId) {
        logger.info("findCompleteWeightByTransId transId:{} plateformId:{}",transId,platformId);
        return transportationDeliveryRepository.findCompleteWeightByTransId(transId, platformId);
    }

    @Override
    public DeliveryComplateWeightVo findCompleteWeightByPublishId(Long publishId, String platformId) {
        logger.info("findCompleteWeightByPublishId publishId:{},platformId:{}",publishId,platformId);
        return transportationDeliveryRepository.findCompleteWeightByPublishId(publishId, platformId);
    }

    @Override
    public boolean dealFlag(TransportationBillOperatorVo transportationBillOperatorVo) {
        Long deliveryId = transportationBillOperatorVo.getDeliveryId();
        logger.info("transportation delivery dealFlag deliveryId:{} ",deliveryId);
        TransportationDeliveryEntity entity = this.findById(deliveryId);
        Assert.notNull(entity,"数据错误，调度单不存在！");
        entity.setOrtherFlag("1");
        this.save(entity);
        return true;
    }

    @Override
    public List<TransportationDeliveryVo> querySettleInfoForGroup(TransportBillQueryVo queryVo) {
        logger.info("Query settleInfo for group list,{}", queryVo.toString());
        List<TransportationDeliveryVo> list = mybatisQuery.list("transportSettle.listForGroupExport", queryVo);
        return list;
    }



	@Override
	public Page<TransportationDeliveryQueryVo> queryListWarning(TransportationDeliveryQueryVo vo) {
		return transportationDeliveryRepository.queryListWarning(vo);
	}

	@Override
	public Page<TransportationDeliveryVo> listDataForCancelAudit(TransportBillQueryVo transportBillQueryVo) {
		logger.info("query list data for cancel audit ");
        Page<TransportationDeliveryVo> page = mybatisQuery.page("transportSettle.listForCancelAudit", transportBillQueryVo);
        return page;
	}

	@Override
	public Long checkGrab(TransportBillQueryVo transQuery) {
		// 待装货的运单数(公司)
		logger.info("query the count for TransportBill's status is 20,companyId:{}",transQuery.getCompanyName());
		return transportationDeliveryRepository.checkGrab(transQuery);
	}

	@Override
	public Long checkDriverBill(String platformId, Long companyId) {
		//  查询待装货的运单数(个人)
		logger.info("query the count for TransportBill's status is '00' and '90',companyId:{}",companyId);
		return transportationDeliveryRepository.checkDriverBill(platformId,companyId);
	}

    @Override
    public boolean saveReceipt(TransportBillQueryVo vo) {
        TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryRepository.findByDeliveryIdAndPlatformId(vo.getDeliveryId(), vo.getPlatformId());
        Assert.isTrue(!"20".equalsIgnoreCase(transportationDeliveryEntity.getSettleStatus()), "已结算的单据无法继续上传回单");
        transportationDeliveryEntity.setComfirmPic1Local(vo.getComfirmPic1Local());
        transportationDeliveryEntity.setIfUploadReceiptFlag("1");
        transportationDeliveryEntity.setUpdateDate(new Date());
        transportationDeliveryEntity.setUpdatePerson(vo.getUserId());
        transportationDeliveryRepository.save(transportationDeliveryEntity);
        return true;
    }

    @Override
    public boolean zcConfirm(TransportBillQueryVo vo) {
        transportationDeliveryRepository.zcWeight(vo.getTruckLoadingWeight(), vo.getStatus(), vo.getUserId(), vo.getDeliveryId());
        return true;
    }

    @Override
    public boolean saveWeight(TransportBillQueryVo vo) {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String nowDate=format.format(date);

        TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryRepository.findById(vo.getDeliveryId()).get();
        String remark = null;
        if (transportationDeliveryEntity.getRemark() != null) {
            remark = transportationDeliveryEntity.getRemark();
            if (vo.getTruckLoadingWeight() != null) {
                remark = remark  + "\n" + "操作人:" + vo.getUserName() + "," + "时间:" + nowDate + ",装车重量:" + vo.getTruckLoadingWeight().toString() ;
            }
            if (vo.getTakeDeliveryWeight() != null) {
                remark = remark  + "\n" + "操作人:" + vo.getUserName() + "," + "时间:" + nowDate +  ",收货重量:" + vo.getTakeDeliveryWeight().toString();
            }
        }else {
            if (vo.getTruckLoadingWeight() != null) {
                remark = "操作人:" + vo.getUserName() + "," + "时间:" + nowDate + ",装车重量:" + vo.getTruckLoadingWeight().toString();
            }
            if (vo.getTakeDeliveryWeight() != null) {
                remark = "操作人:" + vo.getUserName() + "," + "时间:" + nowDate + ",收货重量:" + vo.getTakeDeliveryWeight().toString();
            }
        }

        if(vo.getTruckLoadingWeight() != null) {
            transportationDeliveryRepository.changeZcWeight(vo.getTruckLoadingWeight(), vo.getZcWeightFrom(), remark, vo.getUserId(), vo.getDeliveryId());
        }
        if(vo.getTakeDeliveryWeight() != null) {
            transportationDeliveryRepository.changeShWeight(vo.getTakeDeliveryWeight(), remark, vo.getUserId(), vo.getDeliveryId());
        }

        return true;
    }

    @Override
    public TransportationDeliveryVo queryPublisherId(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.queryPublisherId(transportBillQueryVo);
    }

    @Override
    public WebReturnMessage deliveryCancel(TransportBillQueryVo transportBillQueryVo) {
        TransportationDeliveryVo transportationDeliveryVo = transportationDeliveryRepository.deliveryCheck(transportBillQueryVo);
        if (transportationDeliveryVo != null && transportationDeliveryVo.getPinDanNum() != null) {
            List<TransportationDeliveryEntity> transportationDeliveryEntityList = transportationDeliveryRepository.pinDanCheck(transportationDeliveryVo.getPinDanNum(), transportationDeliveryVo.getPlatformId());
            if (transportationDeliveryEntityList == null && transportationDeliveryEntityList.size() == 0) {
                return new WebReturnMessage(true, "拼单单据下所有的调度单都是待取单下才可以进行撤销申请操作！");
            }
        }

        List<DeliverycancelauditEntity> deliverycancelauditEntityList = orderCancelService.deliveryCancelCheck(transportBillQueryVo.getDeliveryId(), transportBillQueryVo.getPlatformId());
        for(DeliverycancelauditEntity deliverycancelauditEntity : deliverycancelauditEntityList){
            if("10".equalsIgnoreCase(deliverycancelauditEntity.getDeliveryCancelType())){
                return new WebReturnMessage(true, "此调度单或其拼单已提出撤销申请，请勿重复操作！");
            }

            if("20".equalsIgnoreCase(deliverycancelauditEntity.getDeliveryCancelType())){
                return new WebReturnMessage(true, "此调度单或其拼单的撤销申请已通过审核，请勿重复操作！");
            }
        }

        return WebReturnMessage.sucess;
    }

    @Override
    public void saveDeliveryCancel(TransportBillQueryVo transportBillQueryVo) {
        transportationDeliveryRepository.saveDeliveryCancel(transportBillQueryVo.getRemark(), transportBillQueryVo.getUserId(), transportBillQueryVo.getUserName(), transportBillQueryVo.getPlatformId(), transportBillQueryVo.getDeliveryId());
    }

    @Override
    public void saveAgreement(TransportBillQueryVo transportBillQueryVo) {
        transportationDeliveryRepository.saveAgreement(transportBillQueryVo.getUserId(), transportBillQueryVo.getPlatformId(), transportBillQueryVo.getDeliveryId(), transportBillQueryVo.getTruckLoadingWeight(), transportBillQueryVo.getTakeDeliveryWeight(), transportBillQueryVo.getComfirmPic1Local());
    }

    @Override
    public Page<TransportationDeliveryVo> queryCyPage(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.queryCyPage(transportBillQueryVo);
    }

    @Override
    @Transactional
    public String changeBroker(TransportBillQueryVo transportBillQueryVo) {
        StringBuffer result = new StringBuffer();
        String[] deliveryIds = transportBillQueryVo.getDeliveryIds().split(",");
        for(String deliveryId : deliveryIds){
            int i = 0;
            if("dj".equalsIgnoreCase(transportBillQueryVo.getBrokerPeopleType())){
            	if("Y".equals(transportBillQueryVo.getBatchFlag())) {
            		// 定额处理(判断定额是否超出平台基础值normalAmount,批量处理数据时候)
                	TransportationDeliveryEntity delivery = transportationDeliveryRepository.findById(Long.valueOf(deliveryId)).get();
                	BigDecimal normalAmount = delivery.getWeight().multiply(delivery.getPrice())
                			.multiply(transportBillQueryVo.getNormalRate());
                	if(transportBillQueryVo.getTollAmount().compareTo(normalAmount) == 1) {
                		return result.append("该单据中含有经纪人收费金额大于平台常规值的单据，不能调整!").toString();
                	}
            	} 	
                i = transportationDeliveryRepository.changeDjBroker(transportBillQueryVo.getBrokerPeopleType(), transportBillQueryVo.getTollAmount(), transportBillQueryVo.getUserId(), Long.valueOf(deliveryId), transportBillQueryVo.getPlatformId());
            }else if("dl".equalsIgnoreCase(transportBillQueryVo.getBrokerPeopleType())){
            	// 定率处理
            	i = transportationDeliveryRepository.changeDlBroker(transportBillQueryVo.getBrokerPeopleType(), transportBillQueryVo.getTollRatio(), transportBillQueryVo.getUserId(), Long.valueOf(deliveryId), transportBillQueryVo.getPlatformId());
            }
            if(i == 0){
                result.append("调度单号：" + deliveryId);
                result.append(",");
            }
        }
        if(result.length() == 0){
            result.append("经纪人运费调整成功！");
        }else{
            result.append("给经纪人分配的运费大于总运费或者是已结算请检查数据，经纪人运费调整失败，其他单据调整成功！");
        }
        return result.toString();
    }

    @Override
    public Page<TransportationDeliveryVo> queryHzPage(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.queryHzPage(transportBillQueryVo);
    }

    @Override
    public List<TransportationDeliveryVo> queryHzList(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.queryHzList(transportBillQueryVo);
    }

    @Override
    public List<TransportationDeliveryVo> queryCyList(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.queryCyList(transportBillQueryVo);
    }

	@Override
	public TransportationDeliveryVo queryBatchCalcCondition(TransportBillQueryVo queryVo) {
		logger.info("query batch calc condition");
		TransportationDeliveryVo vo = new TransportationDeliveryVo();
		Long n = transportationDeliveryRepository.queryBatchCalcCondition(queryVo.getCompanyId(), queryVo.getPlatformId());
		if (n > 0) {
			vo.setIfRoughWeightCal("1");
		} else {
			vo.setIfRoughWeightCal("0");
		}
		return vo;
	}
    @Override
    public List<TransportationDeliveryEntity> findByBrokerFundsControlMasterId(Long brokerFundsControlMasterId){
        logger.info("findByBrokerFundsControlMasterId{}",brokerFundsControlMasterId);
        return transportationDeliveryRepository.findByBrokerFundsControlMasterId(brokerFundsControlMasterId);
    }

    @Override
    public TransportationDeliveryVo lookContracts(TransportBillQueryVo transportBillQueryVo) {
        return transportationDeliveryRepository.lookContracts(transportBillQueryVo);
    }

	@Override
	public List<CheckFreightVo> checkFreight(Long deliveryId ) {		
        return transportationDeliveryRepository.checkFreight(deliveryId);
	}

	@Override
	public void updateGoodsOwnerPs(TransportBillQueryVo vo) {  
			TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryRepository.findById(vo.getDeliveryId()).get();
	        transportationDeliveryEntity.setGoodsOwnerPs(vo.getGoodsOwnerPs());
	        transportationDeliveryEntity.setUpdatePerson(vo.userId);
	        transportationDeliveryEntity.setUpdateDate(new Date());
	        transportationDeliveryRepository.save(transportationDeliveryEntity);
	}
	
	public CompanyModelVo findModelById(Long companyId) {
		CompanyEntity entity=companyService.findCompanyById(companyId);
		CompanyModelVo vo=new CompanyModelVo();
		vo.setBusinessMode(entity.getBusinessMode());
		return vo;
	}

	@Override
	public void updateSignStatus(TransportBillQueryVo transportBillQueryVo) {
		TransportationDeliveryEntity transportationDeliveryEntity =transportationDeliveryRepository.findById(transportBillQueryVo.getDeliveryId()).get();
		if("90".equals(transportationDeliveryEntity.getStatus())&&"10".equals(transportationDeliveryEntity.getSignStatus())&&transportationDeliveryEntity.getTruckLoadingWeight()!=null&&transportationDeliveryEntity.getTakeDeliveryWeight()!=null&&!transportationDeliveryEntity.getIfUploadReceiptFlag().equals("0")) {
			transportationDeliveryEntity.setSignStatus("20");
			transportationDeliveryEntity.setSignTime(new Date());
			transportationDeliveryEntity.setSignPersonId(transportBillQueryVo.getSignPersonId());
			transportationDeliveryEntity.setSignPersonName(transportBillQueryVo.getSignPersonName());
			transportationDeliveryRepository.save(transportationDeliveryEntity);
		}
	}

    @Override
    public Page<TransportationComfirmPicVo> comfirmPicData(TransportationComfirmPicQueryVo queryVo) {
        // 回单数据
        logger.info("query transport comfirmPic page data");
        return transportationDeliveryRepository.comfirmPicData(queryVo);
    }

    @Override
    public List<TransportationComfirmPicVo> excelDeliveryComfirmPicList(TransportationComfirmPicQueryVo queryVo) {
        // 回单导出数据
        logger.info("query transport comfirmPic list data");
        return transportationDeliveryRepository.excelDeliveryComfirmPicList(queryVo);
    }

    @Override
    public int auditBybatch(List<Long> ids, String status) {
        logger.info("update transport risk_audit_status list data");
        return transportationDeliveryRepository.updateRiskAuditStatus(ids,status);
    }

    @Override
    public int rejectBybatch(List<Long> ids, String cause) {
        logger.info("update transport risk_audit_status list data");
        transportationDeliveryRepository.updateRiskAuditStatus(ids,"00");
        return transportationDeliveryRepository.updateRiskAuditType(ids,cause);
    }

	@Override
	public List<TransportationDeliveryEntity> findAllBySpellListNum(String spellListNum) {
		logger.info("query TransportationDelivery List by spellListNum");
		return transportationDeliveryRepository.findAllBySpellListNum(spellListNum);
	}
}
