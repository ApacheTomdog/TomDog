package com.brcc.business.transorder.service.impl;

import com.brcc.business.basedata.service.TeamCompanyService;
import com.brcc.business.basedata.vo.TeamCompanyVo;
import com.brcc.business.brokerProfit.entity.BrokerProfitConfigEntity;
import com.brcc.business.brokerProfit.service.BrokerPpSwitchService;
import com.brcc.business.brokerProfit.service.BrokerProfitConfigService;
import com.brcc.business.brokerProfit.vo.BrokerPpSwitchQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.service.GoodsOrderExecuteLogService;
import com.brcc.business.dispatchorder.service.TransportationDeliveryUploadService;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsordermjk.service.GoodsordermjkService;
import com.brcc.business.ordercancel.service.OrderCancelService;
import com.brcc.business.transorder.entity.*;
import com.brcc.business.transorder.repository.*;
import com.brcc.business.transorder.service.*;
import com.brcc.business.transorder.vo.DispatchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.TransOrderVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:
 * 平台运输单逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-10-31 17:50
 */
@Service
public class TransOrderServiceImpl implements TransOrderService {

    Logger logger = LoggerFactory.getLogger(TransOrderServiceImpl.class);

    @Autowired
    private TransOrderRepository transOrderRepository;

    @Autowired
    private TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    private TransOrderDetailService transOrderDetailService;

    @Autowired
    private GoodsordermjkService goodsordermjkService;

    @Autowired
    GoodsordermService goodsordermService;

    @Autowired
    private OrderCancelService orderCancelService;

    @Autowired
    private TransportationDeliveryUploadService TransportationDeliveryUploadService;

    @Autowired
    private TeamCompanyService teamCompanyService;

    @Autowired
    private GoodsOrderExecuteLogService goodsOrderExecuteLogService;

    @Autowired
    private ShortmessageService shortmessageService;

    @Autowired
    private LoginVerifyService loginVerifyService;

    @Autowired
    private TransportationmHisPriceService transportationmHisPriceService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private BrokerPpSwitchService brokerPpSwitchService;

    @Autowired
    private BrokerProfitConfigService brokerProfitConfigService;

    @Autowired
    MybatisQuery mybatisQuery;

    @Override
    public Page<TransOrderVo> pageData(TransOrderSearchVo vo) {
        return transOrderRepository.findAllPage(vo);
    }

    @Override
    public List<TransOrderVo> findAll(TransOrderSearchVo vo) {
        logger.info("query trans order ");

        return transOrderRepository.findAll(vo);
    }

    @Override
    public Page<TransOrderVo> findPublisherAllPage(TransOrderSearchVo vo) {
        return transOrderRepository.findPublisherAllPage(vo);
    }

    @Override
    public List<TransOrderVo> findPublisherListData(TransOrderSearchVo vo) {
        return transOrderRepository.findPublisherListData(vo);
    }

    @Override
    public Page<TransOrderVo> findTaxTransportationmPage(TransOrderSearchVo vo) {
        return transOrderRepository.findTaxTransportationmPage(vo);
    }

    @Override
    public List<TransOrderVo> findTaxTransportationmList(TransOrderSearchVo vo) {
        return transOrderRepository.findTaxTransportationmList(vo);
    }

    @Override
    @Transactional
    public void updateStatus(TransOrderSearchVo vo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //终止
        if ("60".equals(vo.getStatus())) {
            List<TransportationdeliveryEntity> activeTransportBillList = transOrderDispatchDetailService.activeTransportBill(vo.getPlatformId(), Long.parseLong(vo.getTransId()));

            Assert.isTrue(activeTransportBillList == null || activeTransportBillList.size() == 0, "此运单已有调度单已完成或还有在途调度单，不允许终止！");

        } else if ("30".equals(vo.getStatus())) { // 完成
            List<TransportationdeliveryEntity> unCompleteTransportBillList  = transOrderDispatchDetailService.unCompleteTransportBill(vo.getPlatformId(), Long.parseLong(vo.getTransId()));
            Assert.isTrue(unCompleteTransportBillList == null || unCompleteTransportBillList.size() == 0, "此运单还有未完成的调度单，不能完成！");

            List<TransportationdeliveryEntity> completedTransportBillList  = transOrderDispatchDetailService.completedTransportBill(vo.getPlatformId(), Long.parseLong(vo.getTransId()));
            Assert.isTrue(completedTransportBillList != null && completedTransportBillList.size() > 0, "此运单无已完成的调度单，不能完成！");
        }
        //更新货源单信息
        Optional<TransportationmEntity> transportationmEntityOptional = transOrderRepository.findById(Long.parseLong(vo.getTransId()));
        TransportationmEntity transportationmEntity = transportationmEntityOptional.get();
        vo.setPublishId(transportationmEntity.getPublishId().toString());
        GoodsordermEntity goodsordermEntity = transOrderDetailService.findById(Long.parseLong(vo.getPublishId()));

        Assert.isTrue(transportationmEntity != null, "此运单数据异常,请联系管理员！");

        Assert.isTrue(!"60".equalsIgnoreCase(transportationmEntity.getStatus()), "此运单已经终止,不能操作,请刷新页面重试！");

//        goodsordermEntity.setWeight(transportationmEntity.getWeight());
//        goodsordermEntity.setQty(transportationmEntity.getQty());
//        goodsordermEntity.setAmount(transportationmEntity.getAmount());
        //将运输订单上的量返回到货源单,如果货源单的状态已经终止，则不做此操作
        transOrderDetailService.updateResource(transportationmEntity.getWeight(), transportationmEntity.getQty(), transportationmEntity.getAmount(), transportationmEntity.getPublishId().toString(), transportationmEntity.getPlatformId());
        //更新运输订单的状态
        transOrderRepository.updateStatus(vo.getStatus(), vo.getUserId(), null, null, null, vo.getTransId(), vo.getPlatformId());
        //终止，且作废货源单
        if ("60".equals(vo.getStatus()) && "0".equals(vo.getFlag())) {
            // 查看货源单下是否有有效的运输订单
            List<TransportationmEntity> transportationmEntityList = transOrderRepository.activeTransBill(Long.parseLong(vo.getPublishId()), vo.getPlatformId());
            if (transportationmEntityList == null || transportationmEntityList.size() == 0) {
//                goodsordermEntity.setStatus("00");
//                goodsordermEntity.setUpdatePerson(vo.getUserId().toString());
//                goodsordermEntity.setUpdateDate(new Date());
//                goodsordermEntity.setRemark(sdf.format(new Date()) + "通过运输订单作废by" + vo.getUserId());
                transOrderDetailService.updateGoodsStatus("00", vo.getUserId(), sdf.format(new Date()) + "通过运输订单作废by" + vo.getUserId(), transportationmEntity.getPublishId(), transportationmEntity.getPlatformId());
                goodsordermjkService.updateStatusJk(Long.parseLong(vo.getPublishId()), vo.getPlatformId());

                if("JK_U8".equalsIgnoreCase(goodsordermEntity.getFromType()) || "JK_U9".equalsIgnoreCase(goodsordermEntity.getFromType()) || "JK_U10".equalsIgnoreCase(goodsordermEntity.getFromType())){
                    vo.setGoodWeight(goodsordermEntity.getWeight().add(transportationmEntity.getWeight()));
                    vo.setImportId(Long.parseLong(goodsordermEntity.getImportId()));
                    goodsordermjkService.updateGoodInfo(vo.getGoodWeight(), vo.getImportId());
                }
                //JK_U11，则撤销jk表的单据
                if ("JK_U11".equalsIgnoreCase(goodsordermEntity.getFromType())) {
                    goodsordermService.invalidGoodsordermjk(Long.parseLong(goodsordermEntity.getImportId()));
                }

            }
        }
        if("30".equals(vo.getStatus())){
            goodsordermEntity.setUpdatePerson(vo.getUserId().toString());
            goodsordermEntity.setUpdateDate(new Date());
            goodsordermEntity.setRemark(sdf.format(new Date()) + "通过运输订单完成by" + vo.getUserId());
            transOrderDetailService.save(goodsordermEntity);
        }
        transOrderRepository.updateDatePerson(vo.getUserId(), vo.getPlatformId(), Long.parseLong(vo.getTransId()));
    }

    @Override
    @Transactional
    public void flyOrder(TransOrderSearchVo vo) {
        //检查
        LoginverifyEntity loginverifyEntity = loginVerifyService.findInfo(vo.getTeamId());
        List<TransportationdeliveryEntity> transportationdeliveryEntityList = transOrderDispatchDetailService.noCompleteCount(vo.getPlatformId(), loginverifyEntity.getDriverId(), Long.parseLong(vo.getTransId()));
        TransportationdeliveryEntity transportationdeliveryEntity = transOrderDispatchDetailService.findDeliveryMyself(loginverifyEntity.getDriverId(), Long.parseLong(vo.getTransId()));
        List<TransportationdeliveryEntity> transportationdeliveryEntityList1 = transOrderDispatchDetailService.getCarCount(vo.getPlatformId(), loginverifyEntity.getVehicleId(), Long.parseLong(vo.getTransId()));
        Assert.isTrue(transportationdeliveryEntity == null, "您选择的司机和当前运输单据下的承运的司机相同不能飞单！");
        Assert.isTrue(transportationdeliveryEntityList1 == null || transportationdeliveryEntityList1.size() == 0, "您选择的司机和当前运输单据下的承运的司机相同不能飞单！");
        Assert.isTrue(transportationdeliveryEntityList.size() == 0, "您选择的司机现在还有"+ transportationdeliveryEntityList.size() +"份运单未完成,车辆还有" + transportationdeliveryEntityList1.size() + "份运单未完成");

        // 检查黑名单
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("platformId", vo.getPlatformId());
        paramMap.put("userId", vo.getUserId());
        paramMap.put("userName", vo.getUserName());
        paramMap.put("transId", vo.getTransId());
        orderCancelService.saveOrderCancel(paramMap);

        Map<String, Object> resultMap = orderCancelService.blackListCheck((Long)paramMap.get("deliveryCancelId"));
        if(resultMap != null && "0".equalsIgnoreCase((String) resultMap.get("as_out_result"))){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        List<TransportationmEntity> transportationmEntityList = transOrderRepository.queryMultiTransId(vo.getTransId());
        Assert.isTrue(transportationmEntityList.size() > 0 , "数据异常！");

        Map<String, Long> map = null;
        for(TransportationmEntity transportationmEntity : transportationmEntityList){
            map = flyTrans(transportationmEntity, vo);
        }

        List<TeamCompanyVo> teamCompanyVoList = teamCompanyService.queryDriverVehicleInfo(vo.getTeamId());
        TeamCompanyVo teamCompanyVo = teamCompanyVoList.get(0);
        Assert.isTrue(teamCompanyVo.getDriverName() != null, "飞单成功,但司机手机号为空,通知短信无法收到！");
        Assert.isTrue(!"".equalsIgnoreCase(teamCompanyVo.getDriverName()), "飞单成功,但司机手机号为空,通知短信无法收到！");

        ShortmessageEntity shortmessageEntity = new ShortmessageEntity();
        shortmessageEntity.setReceiver(teamCompanyVo.getDriverMobile());
        shortmessageEntity.setMessage(vo.getCompanyName() + "将一张运单调度给您，请登录"+vo.getPlatName()+"找货app查看详情！");
        shortmessageEntity.setPlatformId(vo.getPlatformId());
        shortmessageEntity.setSendType("01");
        shortmessageEntity.setCreateTime(new Date());
        shortmessageService.save(shortmessageEntity);

        Optional<TransportationmEntity> optional = transOrderRepository.findById((Long)map.get("transId"));
        TransportationmEntity transEntity = optional.get();
        Assert.isTrue(transEntity.getReceiver() != null, "飞单成功,但收货人手机号为空,通知短信无法收到！");
        Assert.isTrue(!"".equalsIgnoreCase(transEntity.getReceiver()), "飞单成功,但收货人手机号为空,通知短信无法收到！");
        Assert.isTrue(transEntity.getReceiverMobile() != null, "飞单成功,但收货人手机号为空,通知短信无法收到！");
        Assert.isTrue(!"".equalsIgnoreCase(transEntity.getReceiverMobile()), "飞单成功,但收货人手机号为空,通知短信无法收到！");

        String msg = "";
        TransOrderDispatchDetailVo transOrderDispatchDetailVo = transOrderDispatchDetailService.queryMessageInfo(map.get("deliveryId"));
        if(transOrderDispatchDetailVo != null){
            if(transOrderDispatchDetailVo.getDependNum() != null && !"".equalsIgnoreCase(transOrderDispatchDetailVo.getDependNum())){
                msg = "(手机号：" + teamCompanyVo.getDriverMobile() + "，车牌号：" + transOrderDispatchDetailVo.getVehicleNum() + "，提单号：" + transOrderDispatchDetailVo.getDependNum() + ")" ;
            }else{
                msg = "(手机号：" + teamCompanyVo.getDriverMobile() + "，车牌号：" + transOrderDispatchDetailVo.getVehicleNum() + ")" ;
            }
            ShortmessageEntity shortMessage = new ShortmessageEntity();
            shortMessage.setReceiver(transEntity.getReceiverMobile());
            shortMessage.setMessage("亲爱的" + transEntity.getReceiver() + "，您的宝贝已由司机" + teamCompanyVo.getDriverName() + msg + "护送起航，若无绑匪出没，不日便可到达！");
            shortMessage.setPlatformId(vo.getPlatformId());
            shortMessage.setSendType("01");
            shortmessageService.save(shortMessage);
        }
    }

    public Map<String, Long> flyTrans(TransportationmEntity transportationmEntity, TransOrderSearchVo vo){
        // 检查是否满足飞单条件
        checkFlyCondition(transportationmEntity);

        // 作废所有调度单
        transOrderDispatchDetailService.cancelAllDelivery(transportationmEntity.getPlatformId(), transportationmEntity.getTransId());

        List<TransportationdeliveryEntity> transportationdeliveryEntityList = transOrderDispatchDetailService.findByTransId(transportationmEntity.getTransId());
        for(TransportationdeliveryEntity transportationdeliveryEntity : transportationdeliveryEntityList){
            TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();
            transportationdeliveryuploadEntity.setPublishId(transportationdeliveryEntity.getPublishId());
            transportationdeliveryuploadEntity.setTransId(transportationdeliveryEntity.getTransId());
            transportationdeliveryuploadEntity.setDeliveryId(transportationdeliveryEntity.getDeliveryId());
            transportationdeliveryuploadEntity.setStatus(transportationdeliveryEntity.getStatus());
            transportationdeliveryuploadEntity.setCreateDate(new Date());
            transportationdeliveryuploadEntity.setCreatePerson(vo.getUserId().toString());
            transportationdeliveryuploadEntity.setIsUploadEc("0");
            transportationdeliveryuploadEntity.setBatchId("");
            transportationdeliveryuploadEntity.setPlatFormId(transportationdeliveryEntity.getPlatformId());
            transportationdeliveryuploadEntity.setOperateType("WEB");
            TransportationDeliveryUploadService.save(transportationdeliveryuploadEntity);
        }

        // 作废此运输订单
        transOrderRepository.updateStatus("00", vo.getUserId(), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), transportationmEntity.getTransId().toString(), transportationmEntity.getPlatformId());

        List<TeamCompanyVo> teamCompanyVoList = teamCompanyService.queryDriverVehicleInfo(vo.getTeamId());
        Assert.isTrue(teamCompanyVoList.size() > 0, "未找到司机信息");

        TeamCompanyVo teamCompanyVo = teamCompanyVoList.get(0);

        // 生成运输单
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("grabWeight", transportationmEntity.getInitWeight());
        paramMap.put("grabQty", transportationmEntity.getInitQty());
        paramMap.put("outPrice", transportationmEntity.getPrice());
        paramMap.put("companyId", teamCompanyVo.getCompanyId());
        paramMap.put("userId", vo.getUserId());
        paramMap.put("platformId", vo.getPlatformId());
        paramMap.put("companyName", teamCompanyVo.getCompanyName());
        paramMap.put("ifFly", "Y");
        paramMap.put("standardTax", transportationmEntity.getStandardTax());
        paramMap.put("priceTax", transportationmEntity.getPriceTax());
        paramMap.put("ifTaxTransport", transportationmEntity.getIfTaxTransport());
        paramMap.put("vatFlowMasterId", transportationmEntity.getVatFlowMasterId());
        paramMap.put("publishId", transportationmEntity.getPublishId());
        transOrderRepository.saveNewOrder(paramMap);

        // 创建调度单
        transOrderRepository.updateTransWeight((BigDecimal) paramMap.get("grabWeight"), (BigDecimal) paramMap.get("grabQty"), (Long)paramMap.get("transId"), (String)paramMap.get("platformId"));

        paramMap.put("dispatchWeight", transportationmEntity.getInitWeight());
        paramMap.put("dispatchQty", transportationmEntity.getInitQty());
        paramMap.put("driverId", teamCompanyVo.getDriverId());
        paramMap.put("vehicleId", teamCompanyVo.getVehicleId());
        paramMap.put("userId", vo.getUserId());
        paramMap.put("platformId", vo.getPlatformId());
        paramMap.put("docuSource", "0");
        paramMap.put("ifFly", "Y");
        transOrderDispatchDetailService.saveNewOrder(paramMap);

        GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
        goodsorderexecutelogEntity.setCreateTime(new Date());
        goodsorderexecutelogEntity.setExeDesc("运单号："+ paramMap.get("transId")+"已安排司机 "+teamCompanyVo.getDriverName()+" 运输 "+paramMap.get("grabWeight")+" 吨/"+paramMap.get("grabQty")+"件,正等待司机装货。");
        goodsorderexecutelogEntity.setPublishId((Long)paramMap.get("publishId"));
        goodsorderexecutelogEntity.setTransId((Long)paramMap.get("transId"));
        goodsorderexecutelogEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
        goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);

        TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();
        transportationdeliveryuploadEntity.setPublishId((Long)paramMap.get("publishId"));
        transportationdeliveryuploadEntity.setTransId((Long)paramMap.get("transId"));
        transportationdeliveryuploadEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
        transportationdeliveryuploadEntity.setStatus("20");
        transportationdeliveryuploadEntity.setCreateDate(new Date());
        transportationdeliveryuploadEntity.setCreatePerson(vo.getUserId().toString());
        transportationdeliveryuploadEntity.setIsUploadEc("0");
        transportationdeliveryuploadEntity.setBatchId("");
        transportationdeliveryuploadEntity.setPlatFormId(vo.getPlatformId());
        transportationdeliveryuploadEntity.setOperateType("WEB");
        TransportationDeliveryUploadService.save(transportationdeliveryuploadEntity);

        Map<String, Long> map = new HashMap<>();
        map.put("transId", (Long)paramMap.get("transId"));
        map.put("deliveryId", (Long)paramMap.get("deliveryId"));

        return map;
    }

    private void checkFlyCondition(TransportationmEntity transportationmEntity) {
        Optional<TransportationmEntity> optional = transOrderRepository.findById(transportationmEntity.getTransId());
        TransportationmEntity entity = optional.get();

        Assert.isTrue(entity != null, "未找到运输订单");

        Assert.isTrue("20".equals(entity.getStatus()), "只有生效状态的运输订单才能飞单");

        List<TransportationdeliveryEntity> transportationdeliveryEntityList = transOrderDispatchDetailService.queryDeliveryInfo(transportationmEntity.getTransId());
        Assert.isTrue(transportationdeliveryEntityList.size() == 1, "运输订单必须只有一张有效调度单");

        TransportationdeliveryEntity transportationdeliveryEntity = transportationdeliveryEntityList.get(0);
        if(entity.getInitWeight() != null && transportationdeliveryEntity.getWeight() != null){
            Assert.isTrue(entity.getInitWeight().compareTo(transportationdeliveryEntity.getWeight()) == 0, "调度单重量和运输订单重量不一致");
        }

        List<TransportationdeliveryEntity> deliveryEntityList = transOrderDispatchDetailService.completedTransportBill(transportationmEntity.getPlatformId(), transportationmEntity.getTransId());
        Assert.isTrue(deliveryEntityList.size() == 0, "此运输订单有调度单已完成调度，不能飞单");

        List<TransportationdeliveryEntity> transportationdeliveryEntities = transOrderDispatchDetailService.onCarTransportBill(transportationmEntity.getPlatformId(), transportationmEntity.getTransId());
        Assert.isTrue(transportationdeliveryEntities.size() == 0, "此运输订单有调度单已装车，不能飞单");
    }

    @Override
    public TransportationmEntity verifyDelivery(TransOrderSearchVo vo) {
        Optional<TransportationmEntity> optional = transOrderRepository.findById(Long.parseLong(vo.getTransId()));
        TransportationmEntity transportationmEntity = optional.get();

        return transportationmEntity;
    }

    @Override
    @Transactional
    public void modifyPrice(TransOrderSearchVo vo) {
        transOrderRepository.modifyPrice(vo.getNewPrice(), Long.parseLong(vo.getTransId()), vo.getPlatformId());

        TransportationmHisPriceEntity transportationmHisPriceEntity = new TransportationmHisPriceEntity();
        transportationmHisPriceEntity.setTransId(Long.parseLong(vo.getTransId()));
        transportationmHisPriceEntity.setPrice(vo.getNewPrice());
        transportationmHisPriceEntity.setCreateDate(new Date());
        transportationmHisPriceEntity.setCreatePerson(vo.getUserId().toString());
        transportationmHisPriceEntity.setPlatformId(vo.getPlatformId());
        transportationmHisPriceService.save(transportationmHisPriceEntity);

        transOrderDispatchDetailService.updateDeliveryPrice(vo.getNewPrice(), Long.parseLong(vo.getTransId()), vo.getPlatformId());
    }

    @Override
    @Transactional
    public String dispatch(TransOrderSearchVo vo) {
        VehicleEntity vehicleEntity = vehicleService.findByPlatformIdAndVehicleId(vo.getPlatformId(), vo.getVehicleId());
        if(vehicleEntity == null || !"02".equalsIgnoreCase(vehicleEntity.getStatus())){
            return "调度车辆已冻结或未审核，不能进行调度！";
        }

        TransportationmEntity transportationmEntity = transOrderRepository.queryIsHasTransWeight(Long.parseLong(vo.getTransId()));
        if(transportationmEntity == null){
            return "此运单状态不合法，不能调度！";
        }
        // 判断当前登录信息
        if(transportationmEntity.getCompanyId().longValue() != vo.getCompanyId().longValue()){
            return "当前登陆账号不正确，不能调度！";
        }
        BigDecimal weight = transportationmEntity.getWeight();
        BigDecimal qty = transportationmEntity.getQty() == null ? BigDecimal.ZERO : transportationmEntity.getQty();

        if(vo.getDispatchWeight().compareTo(BigDecimal.ZERO) == 0){
            return "此次调度量为0，请修改调度量！";
        }

        if(weight.compareTo(vo.getDispatchWeight()) == -1){
            return "该运单仅剩余："+weight+"吨，请修改调度量！";
        }

        if(qty.compareTo(vo.getDispatchQty() == null ? BigDecimal.ZERO : vo.getDispatchQty()) == -1){
            return "该运单仅剩余："+qty+"件，请修改调度件数！";
        }

        List<TransportationdeliveryEntity> transportationdeliveryEntityList =
                transOrderDispatchDetailService.noCompleteCount(vo.getPlatformId(), vo.getDriverId(), Long.parseLong(vo.getTransId()));
        if(transportationdeliveryEntityList != null && transportationdeliveryEntityList.size() > 0){
            return "该司机已安排调度，不能再调度！";
        }

        List<TransportationdeliveryEntity> transportationdeliveryEntityList1 =
                transOrderDispatchDetailService.getCarCount(vo.getPlatformId(), vo.getVehicleId(), Long.parseLong(vo.getTransId()));
        if(transportationdeliveryEntityList1 != null && transportationdeliveryEntityList1.size() > 0){
            return "该车辆已安排调度，不能再调度！";
        }

        // 创建调度单
        transOrderRepository.updateTransWeight(vo.getDispatchWeight(),
                vo.getDispatchQty() == null ? BigDecimal.ZERO : vo.getDispatchQty(), Long.parseLong(vo.getTransId()), vo.getPlatformId());

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("dispatchWeight", vo.getDispatchWeight());
        paramMap.put("dispatchQty", vo.getDispatchQty() == null ? BigInteger.ZERO : vo.getDispatchQty());
        paramMap.put("driverId", vo.getDriverId());
        paramMap.put("vehicleId", vo.getVehicleId());
        paramMap.put("userId", vo.getUserId());
        paramMap.put("platformId", vo.getPlatformId());
        paramMap.put("docuSource", "1");
        paramMap.put("transId", vo.getTransId());
        paramMap.put("brokerPeopleType", StringUtils.isEmpty(vo.getBrokerPeopleType()) ? "dj" : vo.getBrokerPeopleType());
        if ("Y".equals(vo.getIfBrokerPeople())) {

            // 特例经纪人判断(防止页面未分配权限时没有值的情况)
            BrokerProfitConfigQueryVo profitVo = new BrokerProfitConfigQueryVo();
            profitVo.setSpecialBrokerId(vo.getCompanyId());
            profitVo.setBrokerProfitConfigStatus("20");
            profitVo.setIfSpecialCase("1");
            BrokerProfitConfigEntity brokerProfitConfigEntity = brokerProfitConfigService.querySpecialCase(profitVo);
            if (brokerProfitConfigEntity != null) {
                paramMap.put("brokerPeopleType", "dl");
                paramMap.put("tollRatio", brokerProfitConfigEntity.getBrokerProfitRate());
                paramMap.put("tollAmount", 0);
            }else {
                if ("dj".equals(vo.getBrokerPeopleType())) {
                    double tollAmount = Double.parseDouble(vo.getTollAmount() == null ? "0" : vo.getTollAmount().toString());
                    paramMap.put("tollAmount", tollAmount);
                    paramMap.put("tollRatio", 0);
                } else if ("dl".equals(vo.getBrokerPeopleType())) {
                    double tollRatio = Double.parseDouble(vo.getTollRatio() == null ? "0" : vo.getTollRatio().toString());
                    tollRatio = tollRatio / 100;
                    paramMap.put("tollRatio", tollRatio);
                    paramMap.put("tollAmount", 0);
                } else {
                    paramMap.put("brokerPeopleType", "dj");
                    paramMap.put("tollRatio", 0);
                    paramMap.put("tollAmount", 0);
                }
            }
        }

        // 查询经纪人调度分润情况
        BrokerPpSwitchQueryVo brokerPpSwitchQueryVo = new BrokerPpSwitchQueryVo();
        brokerPpSwitchQueryVo.setBrokerId(vo.getCompanyId());
        Integer count =  brokerPpSwitchService.queryIfProfitControl(brokerPpSwitchQueryVo);
        if(count == 1) {
            paramMap.put("ifFundsControlFlag", "0");
        }else {
            // 如果是特例经纪人
            paramMap.put("ifFundsControlFlag", "Y".equals(vo.getIfSpecial()) ? "1" : "0");
        }

        // 川威模式
        String pinDanNum = "";
        if("2".equals(transportationmEntity.getBusinessMode())){
            // 调用存储过程获取的拼单号
            pinDanNum = getSeqNum("34");
            // 拼单号
            paramMap.put("spellListNum", pinDanNum);
            // 1代表主单，2代表次单
            paramMap.put("spellListPas", "1");
            // N代表不拼单单据，Y代表拼单单据
            paramMap.put("ifSpellList", "N");
            // 调度类型
            paramMap.put("robDeliveryType", "1");
            // 川威模式（2）
            paramMap.put("businessMode", "2");
        }

        transOrderDispatchDetailService.saveNewOrder(paramMap);

        GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
        goodsorderexecutelogEntity.setCreateTime(new Date());
        goodsorderexecutelogEntity.setExeDesc("运单号："+ paramMap.get("transId")+"已安排司机 "+vo.getDriverName()+" 运输 "+paramMap.get("dispatchWeight")+" 吨/"+paramMap.get("dispatchQty")+"件,正等待司机装货。");
        goodsorderexecutelogEntity.setPublishId(Long.parseLong(vo.getPublishId()));
        goodsorderexecutelogEntity.setTransId(Long.parseLong(vo.getTransId()));
        goodsorderexecutelogEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
        goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);

        TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();
        transportationdeliveryuploadEntity.setPublishId(Long.parseLong(vo.getPublishId()));
        transportationdeliveryuploadEntity.setTransId(Long.parseLong(vo.getTransId()));
        transportationdeliveryuploadEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
        transportationdeliveryuploadEntity.setStatus("10");
        transportationdeliveryuploadEntity.setCreateDate(new Date());
        transportationdeliveryuploadEntity.setCreatePerson(vo.getUserId().toString());
        transportationdeliveryuploadEntity.setIsUploadEc("0");
        transportationdeliveryuploadEntity.setBatchId("");
        transportationdeliveryuploadEntity.setPlatFormId(vo.getPlatformId());
        transportationdeliveryuploadEntity.setOperateType("WEB");
        if("2".equals(transportationmEntity.getBusinessMode())) {
            // 拼单信息，同上调度单
            transportationdeliveryuploadEntity.setSpellListNum(pinDanNum);
            transportationdeliveryuploadEntity.setSpellListPas("1");
            transportationdeliveryuploadEntity.setIfSpellList("N");
        }
        TransportationDeliveryUploadService.save(transportationdeliveryuploadEntity);

        if (vo.getDriverPhone()!=null && !vo.getDriverPhone().equals("")) {
            ShortmessageEntity shortMessage = new ShortmessageEntity();
            shortMessage.setReceiver(vo.getDriverPhone());
            shortMessage.setMessage(vo.getCompanyName()+"将一张运单调度给您，请登录"+vo.getPlatName()+"找货app查看详情！");
            shortMessage.setPlatformId(vo.getPlatformId());
            shortMessage.setSendType("01");
            shortmessageService.save(shortMessage);
        }

        return "操作成功";
    }

    @Override
    public void dispatchWeightBack(String deliveryId, String transId, String platformId) {
        this.transOrderRepository.dispatchWeightBack(deliveryId, transId, platformId);
    }

    @Override
    public TransportationmEntity findByTransIdAndPlatformId(Long transId, String platformId) {
        return transOrderRepository.findByTransIdAndPlatformId(transId, platformId);
    }

    @Override
    public void updateStatus(String status, Long userId, BigDecimal deliveryWeight, BigDecimal deliveryQty, BigDecimal deliveryAmount, String transId, String platformId) {
        transOrderRepository.updateStatus(status, userId, deliveryWeight, deliveryQty, deliveryAmount, transId, platformId);
    }

    @Override
    public List<TransportationmEntity> getTransorderList(String transIdStr) {
        logger.info("Query trans order list data by transId string");
        List<TransportationmEntity> transOrderVoList = new ArrayList<>();
        String[] transIds = transIdStr.split(",");
        for (String transId : transIds) {
            TransportationmEntity transportationmEntity = transOrderRepository.findById(Long.valueOf(transId)).get();
            transOrderVoList.add(transportationmEntity);
        }
        return transOrderVoList;
    }

    @Override
    @Transactional
    public String pindanDispatch(TransOrderSearchVo vo)  {
        VehicleEntity vehicleEntity = vehicleService.findByPlatformIdAndVehicleId(vo.getPlatformId(), vo.getVehicleId());
        if(vehicleEntity == null || !"02".equalsIgnoreCase(vehicleEntity.getStatus())){
            return "调度车辆已冻结或未审核，不能进行调度！";
        }

        List<TransportationdeliveryEntity> transportationdeliveryEntityList1 =
                transOrderDispatchDetailService.getCarCount(vo.getPlatformId(), vo.getVehicleId(), null);
        if(transportationdeliveryEntityList1 != null && transportationdeliveryEntityList1.size() > 0){
            return "该车辆已安排调度，不能再调度！";
        }

        List<TransportationdeliveryEntity> transportationdeliveryEntityList =
                transOrderDispatchDetailService.noCompleteCount(vo.getPlatformId(), vo.getDriverId(),null);
        if(transportationdeliveryEntityList != null && transportationdeliveryEntityList.size() > 0){
            return "该司机已安排调度，不能再调度！";
        }

        if(null != vo.getDispatchWeightList() && vo.getDispatchWeightList().size() > 0){
            // 查询经纪人调度分润情况
            BrokerPpSwitchQueryVo brokerPpSwitchQueryVo = new BrokerPpSwitchQueryVo();
            brokerPpSwitchQueryVo.setBrokerId(vo.getCompanyId());
            Integer count =  brokerPpSwitchService.queryIfProfitControl(brokerPpSwitchQueryVo);

            Map<String, Object> paramMap = new HashMap<>();
            if ("Y".equals(vo.getIfBrokerPeople())) {
                // 特例经纪人判断(防止页面未分配权限时没有值的情况)
                BrokerProfitConfigQueryVo profitVo = new BrokerProfitConfigQueryVo();
                profitVo.setSpecialBrokerId(vo.getCompanyId());
                profitVo.setBrokerProfitConfigStatus("20");
                profitVo.setIfSpecialCase("1");
                BrokerProfitConfigEntity brokerProfitConfigEntity = brokerProfitConfigService.querySpecialCase(profitVo);
                if (brokerProfitConfigEntity != null) {
                    paramMap.put("brokerPeopleType", "dl");
                    paramMap.put("tollRatio", brokerProfitConfigEntity.getBrokerProfitRate());
                    paramMap.put("tollAmount", 0);
                }else {
                    if ("dj".equals(vo.getBrokerPeopleType())) {
                        double tollAmount = Double.parseDouble(vo.getTollAmount() == null ? "0" : vo.getTollAmount().toString());
                        paramMap.put("tollAmount", tollAmount);
                        paramMap.put("tollRatio", 0);
                    } else if ("dl".equals(vo.getBrokerPeopleType())) {
                        double tollRatio = Double.parseDouble(vo.getTollRatio() == null ? "0" : vo.getTollRatio().toString());
                        tollRatio = tollRatio / 100;
                        paramMap.put("tollRatio", tollRatio);
                        paramMap.put("tollAmount", 0);
                    } else {
                        paramMap.put("brokerPeopleType", "dj");
                        paramMap.put("tollRatio", 0);
                        paramMap.put("tollAmount", 0);
                    }
                }
            }
            if(count == 1) {
                paramMap.put("ifFundsControlFlag", "0");
            }else {
                // 如果是特例经纪人
                paramMap.put("ifFundsControlFlag", "Y".equals(vo.getIfSpecial()) ? "1" : "0");
            }

            // 调度
            List<DispatchVo> dispatchinfoList = vo.getDispatchWeightList();
            // 调用存储过程获取的拼单号
            String pinDanNum = getSeqNum("34");
            for (int i = 0 ;i < dispatchinfoList.size();i++) {

                DispatchVo dispatchVo = dispatchinfoList.get(i);
                TransportationmEntity transportationmEntity = transOrderRepository.queryIsHasTransWeight(dispatchVo.getTransId());
                if(transportationmEntity == null){
                    throw new RuntimeException("此运单状态不合法，不能调度！");
                }
                // 判断当前登录信息
                if(transportationmEntity.getCompanyId().longValue() != vo.getCompanyId().longValue()){
                    throw new RuntimeException("当前登陆账号不正确，不能调度！");
                }
                BigDecimal weight = transportationmEntity.getWeight();
                BigDecimal qty = transportationmEntity.getQty();

                if(dispatchVo.getDispatchWeight().compareTo(BigDecimal.ZERO) == 0){
                    throw new RuntimeException("此次调度量为0，请修改调度量！");
                }

                if(weight.compareTo(dispatchVo.getDispatchWeight()) == -1){
                    throw new RuntimeException("运单号:"+ dispatchVo.getTransId() +"仅剩余："+weight+"吨，请修改调度量！");
                }

                /*if(qty.compareTo(vo.getDispatchQty()) == -1){
                    return "该运单仅剩余："+qty+"件，请修改调度件数！";
                }*/


                // 创建调度单
                transOrderRepository.updateTransWeight(dispatchVo.getDispatchWeight(), vo.getQty() == null ? BigDecimal.ZERO : vo.getQty() , dispatchVo.getTransId(), vo.getPlatformId());

                paramMap.put("dispatchWeight", dispatchVo.getDispatchWeight());
                paramMap.put("dispatchQty", transportationmEntity.getQty() == null ? BigDecimal.ZERO : transportationmEntity.getQty());
                paramMap.put("driverId", vo.getDriverId());
                paramMap.put("vehicleId", vo.getVehicleId());
                paramMap.put("userId", vo.getUserId());
                paramMap.put("platformId", vo.getPlatformId());
                paramMap.put("docuSource", "1");
                paramMap.put("transId", dispatchVo.getTransId());
                paramMap.put("brokerPeopleType", StringUtils.isEmpty(vo.getBrokerPeopleType()) ? "dl" : vo.getBrokerPeopleType());
                // 拼单号
                paramMap.put("spellListNum", pinDanNum);
                String spellListPas = "2";
                if(i == 0) {spellListPas = "1";}
                // 1代表主单，2代表次单
                paramMap.put("spellListPas", spellListPas);
                // N代表不拼单单据，Y代表拼单单据
                paramMap.put("ifSpellList", "Y");
                // 调度类型
                paramMap.put("robDeliveryType", "1");
                // 川威模式（2）
                paramMap.put("businessMode", "2");

                transOrderDispatchDetailService.saveNewOrder(paramMap);

                GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
                goodsorderexecutelogEntity.setCreateTime(new Date());
                goodsorderexecutelogEntity.setExeDesc("运单号："+ paramMap.get("transId")+"已安排司机 "+vo.getDriverName()+" 运输 "+paramMap.get("dispatchWeight")+" 吨,正等待司机装货。");
                goodsorderexecutelogEntity.setPublishId(transportationmEntity.getPublishId());
                goodsorderexecutelogEntity.setTransId(dispatchVo.getTransId());
                goodsorderexecutelogEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
                goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);

                TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();
                transportationdeliveryuploadEntity.setPublishId(transportationmEntity.getPublishId());
                transportationdeliveryuploadEntity.setTransId(dispatchVo.getTransId());
                transportationdeliveryuploadEntity.setDeliveryId((Long)paramMap.get("deliveryId"));
                transportationdeliveryuploadEntity.setStatus("10");
                transportationdeliveryuploadEntity.setCreateDate(new Date());
                transportationdeliveryuploadEntity.setCreatePerson(vo.getUserId().toString());
                transportationdeliveryuploadEntity.setIsUploadEc("0");
                transportationdeliveryuploadEntity.setBatchId("");
                transportationdeliveryuploadEntity.setPlatFormId(vo.getPlatformId());
                transportationdeliveryuploadEntity.setOperateType("WEB");
                // 拼单信息，同上调度单
                transportationdeliveryuploadEntity.setSpellListNum(pinDanNum);
                transportationdeliveryuploadEntity.setSpellListPas(spellListPas);
                transportationdeliveryuploadEntity.setIfSpellList("Y");
                TransportationDeliveryUploadService.save(transportationdeliveryuploadEntity);

                if (vo.getDriverPhone() != null && !vo.getDriverPhone().equals("")) {
                    ShortmessageEntity shortMessage = new ShortmessageEntity();
                    shortMessage.setReceiver(vo.getDriverPhone());
                    shortMessage.setMessage(vo.getCompanyName()+"将一张运单调度给您，请登录"+vo.getPlatName()+"找货app查看详情！");
                    shortMessage.setPlatformId(vo.getPlatformId());
                    shortMessage.setSendType("01");
                    shortmessageService.save(shortMessage);
                }
            }
        }else{
            return "未接收到拼单调度信息！";
        }
        return "操作成功";
    }

    /**
     * 获取编号
     * @param typeId
     * @return
     */
    public String getSeqNum(String typeId) {
        logger.info("call generate_docu_no pro,typeId:{}",typeId);
        HashMap<String, Object> propMap = new HashMap<String, Object>();
        propMap.put("typeId", typeId);
        propMap.put("seqNum", "");
        mybatisQuery.executePro("transportSettle.getSeqNumPro", propMap);
        String seqNum = (String) propMap.get("seqNum");
        logger.info("call generate_docu_no pro,seqNum:{}",seqNum);
        return seqNum;
    }
}