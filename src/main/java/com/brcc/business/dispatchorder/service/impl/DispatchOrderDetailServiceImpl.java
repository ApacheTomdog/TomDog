package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.*;
import com.brcc.business.dispatchorder.repository.*;
import com.brcc.business.dispatchorder.service.*;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderSumVo;
import com.brcc.business.transorder.entity.GoodsordermEntity;
import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.entity.TransportationmEntity;
import com.brcc.business.transorder.service.TransOrderDetailService;
import com.brcc.business.transorder.service.TransOrderDispatchDetailService;
import com.brcc.business.transorder.service.TransOrderService;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:
 * 平台调度单业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-06 10:40
 */
@Service
public class DispatchOrderDetailServiceImpl implements DispatchOrderDetailService {

    Logger logger = LoggerFactory.getLogger(DispatchOrderDetailServiceImpl.class);

    @Autowired
    private DispatchOrderDetailRepository dispatchOrderDetailRepository;

    @Autowired
    private DeliveryUploadConfigService deliveryUploadConfigService;

    @Autowired
    private TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    private DeliveryUploadService deliveryUploadService;

    @Autowired
    private OperateConfigService operateConfigService;

    @Autowired
    private TransportationDeliveryUploadService transportationDeliveryUploadService;

    @Autowired
    private TransOrderService transOrderService;

    @Autowired
    private TransOrderDetailService transOrderDetailService;

    @Autowired
    private GoodsOrderExecuteLogService goodsOrderExecuteLogService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private BusinessRegistrationService businessRegistrationService;

    @Override
    public Page<DispatchOrderDetailVo> findAllPage(DispatchOrderDetailSearchVo vo) {
        logger.info("query dispatch order detail page ");

        return dispatchOrderDetailRepository.findAllPage(vo);
    }

    @Override
    public DispatchOrderSumVo findOrderSum(DispatchOrderDetailSearchVo vo) {
        logger.info("query dispatch order summary ");

        return dispatchOrderDetailRepository.findOrderSum(vo);
    }

    @Override
    public Map checkDzIfCancel(DispatchOrderDetailSearchVo vo) throws JsonProcessingException {
        logger.info("check da zong if cancel  ");

        DeliveryuploadConfigEntity deliveryuploadConfigEntity = deliveryUploadConfigService.findByJkName("update_PaiCheMX");
        DzCancelDataForCancelVo dzCancelDataVo = transOrderDispatchDetailService.queryDzCancelData(vo.getDeliveryId(), vo.getPlatformId());

        Map<String, Object> map = new HashMap<>();
        map.put("publish_id", dzCancelDataVo.getPublish_id());
        map.put("delivery_id", dzCancelDataVo.getDelivery_id());
        map.put("delivery_num", dzCancelDataVo.getDelivery_num());
        map.put("docu_type", dzCancelDataVo.getDocu_type());
        map.put("ret1", dzCancelDataVo.getRet1());
        map.put("ret2", dzCancelDataVo.getRet2());
        map.put("ret3", dzCancelDataVo.getRet3());
        map.put("ret4", dzCancelDataVo.getRet4());
        map.put("ret5", dzCancelDataVo.getRet5());

        ObjectMapper mapper = new ObjectMapper();
        String requestStr = mapper.writeValueAsString(map);

        Map resultMap = sendDeliveryCancelXml(requestStr, deliveryuploadConfigEntity);

        deliveryUploadService.insertDeliveryCancelLog((String) resultMap.get("returnFlag"), (String) resultMap.get("returnInfor"), vo.getDeliveryId());

        return resultMap;
    }

    @Override
    @Transactional
    public void updateStatus(DispatchOrderDetailSearchVo vo) {
        logger.info("update status  ");
        DzCancelDataVo dzCancelDataVo = transOrderDispatchDetailService.queryStatue(vo.getDeliveryId(), vo.getPlatformId());
        if ("20".equals(dzCancelDataVo.getStatus())) {
            String jkCount = dzCancelDataVo.getJkCount();
            Assert.isTrue(!"Y".equalsIgnoreCase(jkCount),"此单据来源于电商平台，不能进行此操作！");
        }

        if ("90".equals(vo.getStatus())) {
            long intervalTime = 0;
            Date startDate = null;
            String msg = "";
            OperateconfigEntity operateconfigEntity = operateConfigService.queryIntervalTime(vo.getDeliveryId());
            if (operateconfigEntity == null) {
                intervalTime = 20;
                startDate = dzCancelDataVo.getBillTime();
                msg = "操作失败,请在取单"+ intervalTime + "分钟后再操作！";
            } else {
                intervalTime = operateconfigEntity.getTimes();
                startDate = dzCancelDataVo.getDeliveryTime();
                msg = "操作失败," + operateconfigEntity.getPublishCompanyName() + "的调度单,请在装车"+ intervalTime + "分钟后再操作！";
            }

            startDate = startDate == null ? new Date() : startDate;
            Date now = new Date();
            Long result = Long.valueOf(now.getTime() - startDate.getTime());
            if (result.longValue() / 1000L/60L < intervalTime) {
                throw new RuntimeException(msg);
            }
        }

        //JK_U9立恒新大宗撤销
        if("JK_U9".equals(vo.getFromType())&& "00".equals(vo.getStatus())) {
            //查询30调度单是否已上传
            int count = transportationDeliveryUploadService.queryIfUpload(vo.getDeliveryId());
            //1表示已上传，0表示未上传
            if(count == 1) {
                vo.setCanUpload(1);
                TransportationdeliveryuploadEntity entity = new TransportationdeliveryuploadEntity();
                entity.setPublishId(Long.valueOf(vo.getPublishId()));
                entity.setTransId(Long.valueOf(vo.getTransId()));
                entity.setDeliveryId(Long.valueOf(vo.getDeliveryId()));
                entity.setStatus(vo.getStatus());
                entity.setCreateDate(new Date());
                entity.setCreatePerson(vo.getUserId().toString());
                entity.setIsUploadEc("0");
                entity.setBatchId("");
                entity.setPlatFormId(vo.getPlatformId());
                entity.setOperateType("WEB");
                entity.setCanUpload(String.valueOf(vo.getCanUpload()));

                transportationDeliveryUploadService.save(entity);
            }else {
                vo.setCanUpload(0);
                TransportationdeliveryuploadEntity entity = new TransportationdeliveryuploadEntity();
                entity.setPublishId(Long.valueOf(vo.getPublishId()));
                entity.setTransId(Long.valueOf(vo.getTransId()));
                entity.setDeliveryId(Long.valueOf(vo.getDeliveryId()));
                entity.setStatus(vo.getStatus());
                entity.setCreateDate(new Date());
                entity.setCreatePerson(vo.getUserId().toString());
                entity.setIsUploadEc("0");
                entity.setBatchId("");
                entity.setPlatFormId(vo.getPlatformId());
                entity.setOperateType("WEB");
                entity.setCanUpload(String.valueOf(vo.getCanUpload()));

                transportationDeliveryUploadService.save(entity);
                //设置30调度单is_upload_ec 为-1
                transportationDeliveryUploadService.updateUploadEc(vo.getDeliveryId());
            }

        }else {
            TransportationdeliveryuploadEntity entity = new TransportationdeliveryuploadEntity();
            entity.setPublishId(Long.valueOf(vo.getPublishId()));
            entity.setTransId(Long.valueOf(vo.getTransId()));
            entity.setDeliveryId(Long.valueOf(vo.getDeliveryId()));
            entity.setStatus(vo.getStatus());
            entity.setCreateDate(new Date());
            entity.setCreatePerson(vo.getUserId().toString());
            entity.setIsUploadEc("0");
            entity.setBatchId("");
            entity.setPlatFormId(vo.getPlatformId());
            entity.setOperateType("WEB");
            entity.setCanUpload(String.valueOf(vo.getCanUpload()));

            transportationDeliveryUploadService.save(entity);
        }

        TransportationdeliveryEntity transportationdeliveryEntity = transOrderDispatchDetailService.findByDeliveryIdAndPlatformId(Long.parseLong(vo.getDeliveryId()), vo.getPlatformId());
        transportationdeliveryEntity.setStatus(vo.getStatus());
        transportationdeliveryEntity.setUpdatePerson(vo.getUserId());
        transportationdeliveryEntity.setUpdateDate(new Date());
        if("20".equalsIgnoreCase(vo.getStatus())){
            transportationdeliveryEntity.setBillTime(new Date());
        }else if("30".equalsIgnoreCase(vo.getStatus())){
            transportationdeliveryEntity.setDeliveryTime(new Date());
            transportationdeliveryEntity.setZcSureDate(new Date());
        }else if("90".equalsIgnoreCase(vo.getStatus())){
            transportationdeliveryEntity.setFinishTime(new Date());
            transportationdeliveryEntity.setTakeDeliveryWeight(new BigDecimal(vo.getShWeight()));
            transportationdeliveryEntity.setShSureDate(new Date());
        }
        transOrderDispatchDetailService.save(transportationdeliveryEntity);

        if ("00".equals(vo.getStatus())) {
            transOrderService.dispatchWeightBack(vo.getDeliveryId(), vo.getTransId(), vo.getPlatformId());
            if("APP".equals(vo.getOperateType())&&"1".equals(vo.getDzJkCancel())){
                //更新货源单信息
                TransportationmEntity transportationmEntity = transOrderService.findByTransIdAndPlatformId(Long.parseLong(vo.getTransId()), vo.getPlatformId());

                Assert.isNull(transportationmEntity, "此运单数据异常,请联系管理员！");
                Assert.isTrue(!"60".equalsIgnoreCase(transportationmEntity.getStatus()), "此运单已经终止,不能操作,请刷新页面重试！");

                //运输订单返回货源单
                transOrderDetailService.updateResource(transportationmEntity.getWeight(), transportationmEntity.getQty(),
                        transportationmEntity.getAmount(), transportationmEntity.getPublishId().toString(), transportationmEntity.getPlatformId());
                //作废运输订单
                transOrderService.updateStatus(vo.getStatus(), vo.getUserId(), transportationmEntity.getDeliveryWeight(), transportationmEntity.getDeliveryQty(), transportationmEntity.getDeliveryAmount(), vo.getTransId(), vo.getPlatformId());

                // 作废运输订单时，查看货源单是否是定抢资源
                GoodsordermEntity goodsordermEntity = transOrderDetailService.findByPublishIdAndPlatformId(Long.parseLong(vo.getPublishId()), vo.getPlatformId());
                if (goodsordermEntity != null) {
                    vo.setDqFlag(goodsordermEntity.getDqFlag());
                }
            }
        }

        if ("90".equals(vo.getStatus())) {
            TransOrderDispatchDetailVo transOrderDispatchDetailVo = transOrderDispatchDetailService.getComplateWeightWithTransId(vo.getTransId(), vo.getPlatformId());

            BigDecimal sumWeight2 = transOrderDispatchDetailVo.getSumWeight();
            BigDecimal initWeight2 = transOrderDispatchDetailVo.getInitWeight();
            BigDecimal sumQty2 = transOrderDispatchDetailVo.getSumQty();
            BigDecimal initQty2 = transOrderDispatchDetailVo.getInitQty();
            if (sumWeight2 != null && sumQty2!= null && (sumWeight2.compareTo(initWeight2)) == 0 && (sumQty2.compareTo(initQty2) == 0)) {
                transOrderService.updateStatus("30", vo.getUserId(), null, null, null, vo.getTransId(), vo.getPlatformId());
            }

            TransOrderDispatchDetailVo detailVo = transOrderDispatchDetailService.getComplateWeightWithpublishId(vo.getTransId(), vo.getPlatformId());

            BigDecimal sumWeight = detailVo.getSumWeight();
            BigDecimal initWeight = detailVo.getInitWeight();
            BigDecimal sumQty = detailVo.getSumQty();
            BigDecimal initQty = detailVo.getInitQty();
            if ((sumWeight == initWeight) && (sumQty == initQty)) {
                transOrderDetailService.updateGoodsOrderMStatus(vo.getPublishId());
            }
        }

        String stu = vo.getStatus();
        if ("30".equals(stu)) {
            vo.setStatus("4");
        } else if ("90".equals(stu)) {
//      param.put("status", "5");
//      this.dao.update("transportBill.updateDriver", param);
        } else if ("00".equals(stu)) {
//      param.put("status", "5");
//      this.dao.update("transportBill.updateDriver", param);
        }

        if ("30".equals(stu))
            vo.setExeDesc("司机 " + vo.getDriverName() + " 已装车");
        else if ("90".equals(stu))
            vo.setExeDesc("司机 " + vo.getDriverName() + " 已送达");
        else if ("00".equals(stu))
            vo.setExeDesc("该调度单被撤销，等待重新安排司机");
        else if ("20".equals(stu)) {
            vo.setExeDesc("司机 " + vo.getDriverName() + " 已取单");
        }

        GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
        goodsorderexecutelogEntity.setCreateTime(new Date());
        goodsorderexecutelogEntity.setExeDesc(vo.getExeDesc());
        goodsorderexecutelogEntity.setPublishId(Long.parseLong(vo.getPublishId()));
        goodsorderexecutelogEntity.setTransId(Long.parseLong(vo.getTransId()));
        goodsorderexecutelogEntity.setDeliveryId(Long.parseLong(vo.getDeliveryId()));
        goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);
    }

    @Transactional
    @Override
    public void genBusinessReg(DispatchOrderDetailSearchVo vo) {
        //查询司机是否有资格申请个体工商注册
        DriverEntity driverEntity = driverService.findByIdAndFromPlatId(Long.parseLong(vo.getDriverId()), vo.getPlatformId());
        if (driverEntity == null || !"1".equals(driverEntity.getIfIcQualification())
                || !"1".equals(driverEntity.getIfTransport())){
            return ;
        }

        //判断司机是否已申请
        if (driverEntity.getIdNum() == null || "".equals(driverEntity.getIdNum())) {
            return ;
        }

        List<BusinessRegistrationEntity> list = businessRegistrationService.findByIdNumAndPlatformId(driverEntity.getIdNum(), vo.getPlatformId());
        if(list != null && list.size() > 0){
            return ;
        }

        //Long maxRegId = businessRegistrationService.findMaxRegId();
        vo.setIdNum(driverEntity.getIdNum());
        vo.setRegName("");

        /**
        List<BusinessRegistrationEntity> businessRegistrationEntityList = businessRegistrationService.findByRegName(vo.getRegName());
        if(businessRegistrationEntityList.size() > 0){
            vo.setRegName("莆田市湄洲湾北岸经济开发区忠门" + toChinese(vo.getDriverId()) + "*" + String.valueOf(businessRegistrationEntityList.size()) + "物流服务部");
        }
        **/
        
       int id = businessRegistrationService.insertBusinessRegistration(vo.getRegName(), vo.getPlatformId(), vo.getUserId(), vo.getUserName(), Long.parseLong(vo.getDriverId()));

        dispatchOrderDetailRepository.flush();

       list = businessRegistrationService.findByIdNumAndPlatformId(driverEntity.getIdNum(), vo.getPlatformId());
       if(list != null && list.size() == 1){
           BusinessRegistrationEntity businessRegistrationEntity = list.get(0);
           vo.setRegName("莆田市湄洲湾北岸经济开发区忠门" + toChinese(businessRegistrationEntity.getRegId().toString()) + "物流服务部");
           businessRegistrationService.updateRegName(businessRegistrationEntity.getRegId(), vo.getRegName());
       }
    }

    private String toChinese(String string) {
        String[] s1 = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String result = "";
        int n = string.length();
        for (int i = 0; i < n; i++) {
            int num = string.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                result += s1[num];
            } else {
                result += s1[num];
            }
        }
        return result;
    }

    @Override
    public HashMap sendDeliveryCancelXml(String requestStr, DeliveryuploadConfigEntity deliveryuploadConfigEntity){
        OutputStream out = null ;
        InputStream in = null;
        HashMap resultMap = new HashMap();
        resultMap.put("returnFlag", "1");
        resultMap.put("returnInfor", "发送成功");

        try{
            String url = deliveryuploadConfigEntity.getJkValue();
            //  String url = "http://60.221.230.31:9091/WebServiceDzwz.asmx";
            URL urlS = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlS.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            String soapAction = deliveryuploadConfigEntity.getParamValue1();
            String soapBody = deliveryuploadConfigEntity.getParamValue2();
            //  String soapAction = "http://tempuri.org/add_ds_PaiCheMX";
            connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
            connection.setRequestProperty("SOAPAction", soapAction);
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            String requestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            requestBody = requestBody   +  "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
            requestBody = requestBody   + "<soap:Body><" + soapBody + " xmlns=\"http://tempuri.org/\"><str>" ;
            requestBody = requestBody   + requestStr + "</str></" + soapBody +"></soap:Body></soap:Envelope>";
            System.out.println("requestBody=" + requestBody);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(requestBody.getBytes("UTF-8"));
            byte[] b = bout.toByteArray();
            connection.setRequestProperty("Content-Length", String
                    .valueOf(b.length));
            connection.connect();
            out = connection.getOutputStream();
            out.write(b);
            String strLine = "";
            String result = "";
            String result1="";
            in = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            int resultCode=connection.getResponseCode();
            if(HttpURLConnection.HTTP_OK==resultCode){
                System.out.println("========================");
            }
            while ((strLine = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("<update_PaiCheMXResult>(.*)</update_PaiCheMXResult>");
                Matcher matcher = pattern.matcher(strLine);
                result1 = result1 + strLine;
                while (matcher.find()) {
                    result = matcher.group(1);
                }
                System.out.println("result============" + result1);
            }
            ObjectMapper mapper = new ObjectMapper();
            HashMap map = mapper.readValue(result, HashMap.class);
            resultMap.put("returnFlag", map.get("returnFlag"));
            resultMap.put("returnInfor", map.get("returnInfor"));
            return resultMap;
        }
        catch(Exception e){
            e.printStackTrace();
            resultMap.put("returnFlag", "0");
            resultMap.put("returnInfor", e.getMessage());
        }
        finally {
            // 关闭输出流、输入流
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultMap;
    }

    @Override
    public TransportationdeliveryEntity findById(Long deliveryId) {
        Optional<TransportationdeliveryEntity> optional = dispatchOrderDetailRepository.findById(deliveryId);
        return optional.get();
    }

    @Override
    public TransportationdeliveryEntity save(TransportationdeliveryEntity entity) {
        return dispatchOrderDetailRepository.save(entity);
    }
}