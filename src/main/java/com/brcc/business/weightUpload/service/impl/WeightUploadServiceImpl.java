package com.brcc.business.weightUpload.service.impl;

import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import com.brcc.business.dispatchorder.service.GoodsOrderExecuteLogService;
import com.brcc.business.transorder.service.TransOrderDetailService;
import com.brcc.business.transorder.service.TransOrderDispatchDetailService;
import com.brcc.business.transorder.service.TransOrderService;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.weightUpload.entity.UploadweightEntity;
import com.brcc.business.weightUpload.repository.WeightUploadRepository;
import com.brcc.business.weightUpload.service.WeightUploadService;
import com.brcc.business.weightUpload.vo.WeightUploadExcelVo;
import com.brcc.business.weightUpload.vo.WeightUploadSearchVo;
import com.brcc.business.weightUpload.vo.WeightUploadVo;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 描述:
 * 装卸货重量业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-28 16:29
 */
@Service
public class WeightUploadServiceImpl implements WeightUploadService {

    @Autowired
    private WeightUploadRepository weightUploadRepository;

    @Autowired
    private TransOrderDispatchDetailService transOrderDispatchDetailService;

    @Autowired
    private TransOrderService transOrderService;

    @Autowired
    private TransOrderDetailService transOrderDetailService;

    @Autowired
    private GoodsOrderExecuteLogService goodsOrderExecuteLogService;

    @Override
    public Page<WeightUploadVo> queryDelieryImport(WeightUploadSearchVo vo) {
        return weightUploadRepository.queryDelieryImport(vo);
    }

    @Override
    public UploadweightEntity queryBatchId() {
        return weightUploadRepository.queryBatchId();
    }

    @Override
    @Transactional
    public String excelUpload(List<WeightUploadExcelVo> weightUploadExcelVoList, Map<String, String> hashMap, WeightUploadSearchVo queryVo) throws Exception {
        String msg = "";
        List<UploadweightEntity> list=new ArrayList<>();

        int count = 0;   //记录成功的条数
        TransOrderDispatchDetailVo transOrderDispatchDetailVo = null;
        String checkStr = "";
        // 循环数据行
        int i = 0;
        for(WeightUploadExcelVo excelVo : weightUploadExcelVoList){
            i++;
            if (excelVo.getDeliveryId() == null || "".equals(excelVo.getDeliveryId()) || excelVo.getDeliveryId() == 0) {
                checkStr = "第" + i + "条数据,调度单号不能为空！";
            }else{
                transOrderDispatchDetailVo = transOrderDispatchDetailService.queryDelieryWeight(excelVo.getDeliveryId().longValue(), queryVo.getPlatformId());
                checkStr = checkParam(excelVo,queryVo,i,transOrderDispatchDetailVo);
            }
//            checkMap.putAll(map);
            if(checkStr != ""){
                msg += checkStr;
                continue;
            }

            UploadweightEntity uploadweightEntity = new UploadweightEntity();
            uploadweightEntity.setBatchId(queryVo.getBatchId());
            uploadweightEntity.setPublishCompanyId(queryVo.getCompanyId());
            uploadweightEntity.setDeliveryId(transOrderDispatchDetailVo.getDeliveryId());
            uploadweightEntity.setTruckLoadingWeight(excelVo.getDeliveryWeight());
            uploadweightEntity.setTruckLoadingDate(excelVo.getDeliveryIdDate());
            uploadweightEntity.setTakeDeliveryWeight(excelVo.getFinishWeight());
            uploadweightEntity.setTakeDeliveryDate(excelVo.getFinishDate());
            uploadweightEntity.setStatus("10");
            uploadweightEntity.setCreatePerson(queryVo.getUserId());
            uploadweightEntity.setCreateDate(new Date());
            uploadweightEntity.setPlatformId(queryVo.getPlatformId());
            weightUploadRepository.save(uploadweightEntity);

            list.add(uploadweightEntity);
        }

        //更新对应业务数据
        count = updateDeliveryWeight(list, transOrderDispatchDetailVo);
//        return "总共：" + weightUploadExcelVoList.size() + "条，成功：" + count + "条！  "+ msg;
        return "总共：" + weightUploadExcelVoList.size() + "条，成功：" + count + "条！";

    }

    /**
     * 对导入的数据进行修改
     * @param list
     * @return
     */
    public int updateDeliveryWeight(List<UploadweightEntity> list, TransOrderDispatchDetailVo transOrderDispatchDetailVo){
        int count=0;
        for (UploadweightEntity entity : list) {
            int updateFlag = transOrderDispatchDetailService.updateDelieryWeight(entity.getTakeDeliveryWeight(), entity.getTruckLoadingWeight(),
                    entity.getTruckLoadingDate(), entity.getTakeDeliveryDate(), entity.getCreatePerson(), entity.getDeliveryId(), entity.getPlatformId());
            HashMap checkMap = new HashMap();
            if(updateFlag != 0){
                checkMap.put("userId", entity.getCreatePerson());
                checkMap.put("platformId", entity.getPlatformId());
                checkMap.put("from_type", transOrderDispatchDetailVo.getFromType());
                checkMap.put("company_id", transOrderDispatchDetailVo.getCompanyId());
                checkMap.put("status", transOrderDispatchDetailVo.getStatus());
                checkMap.put("transId", transOrderDispatchDetailVo.getTransId());
                checkMap.put("publishId", transOrderDispatchDetailVo.getPublishId());
                checkMap.put("deliveryId", transOrderDispatchDetailVo.getDeliveryId());
                checkMap.put("settleStatus", transOrderDispatchDetailVo.getSettleStatus());

                //完成对应的运输订单
                TransOrderDispatchDetailVo complateWeightWithTransId = transOrderDispatchDetailService.getComplateWeightWithTransId(transOrderDispatchDetailVo.getTransId().toString(), entity.getPlatformId());
//                HashMap checkWeight=(HashMap) dao.queryMap("transportBill.getComplateWeight2", checkMap);
                BigDecimal sumWeight2 = complateWeightWithTransId.getSumWeight();
                BigDecimal init_weight2 = complateWeightWithTransId.getInitWeight();
                BigDecimal sumQty2 = complateWeightWithTransId.getSumQty();
                BigDecimal init_qty2 = complateWeightWithTransId.getInitQty();
                if ((sumWeight2.compareTo(init_weight2)) == 0 && (sumQty2.compareTo(init_qty2)) == 0) {
                    TransOrderSearchVo vo = new TransOrderSearchVo();
                    vo.setStatus("30");
                    vo.setTransId(transOrderDispatchDetailVo.getTransId().toString());
                    vo.setPlatformId(entity.getPlatformId());
                    vo.setUserId(entity.getCreatePerson());
                    transOrderService.updateStatus(vo);
//                    this.dao.update("putIn.updateStatus", transMap);
                }

                //完成相应的货源单
                TransOrderDispatchDetailVo complateWeightWithPublishId =
                        transOrderDispatchDetailService.getComplateWeightWithpublishId(transOrderDispatchDetailVo.getPublishId().toString(), entity.getPlatformId());

                BigDecimal sumWeight = complateWeightWithPublishId.getSumWeight();
                BigDecimal init_weight = complateWeightWithPublishId.getInitWeight();
                BigDecimal sumQty = complateWeightWithPublishId.getSumQty();
                BigDecimal init_qty = complateWeightWithPublishId.getInitQty();
                if ((sumWeight.compareTo(init_weight) == 0) && (sumQty.compareTo(init_qty) == 0)) {
                    transOrderDetailService.updateGoodsOrderMStatus(transOrderDispatchDetailVo.getPublishId().toString());
                }
                checkMap.put("exeDesc", "货主导入更新了装车,收货重量!");

                GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
                goodsorderexecutelogEntity.setCreateTime(new Date());
                goodsorderexecutelogEntity.setExeDesc("货主导入更新了装车,收货重量!");
                goodsorderexecutelogEntity.setPublishId(transOrderDispatchDetailVo.getPublishId());
                goodsorderexecutelogEntity.setTransId(transOrderDispatchDetailVo.getTransId());
                goodsorderexecutelogEntity.setDeliveryId(transOrderDispatchDetailVo.getDeliveryId());
                goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);

                entity.setProcResult("处理成功!");
                entity.setStatus("20");
            }else{
                entity.setProcResult("数据处理失败,请检查导入的数据!");
                entity.setStatus("00");
            }
            entity.setProcDate(new Date());
            weightUploadRepository.save(entity);

            List<UploadweightEntity> uploadweightEntityList =
                    weightUploadRepository.queryDelieryWeightExist(transOrderDispatchDetailVo.getCompanyId().longValue(), entity.getPlatformId(), new Date(), entity.getTakeDeliveryWeight());
            Assert.isTrue(uploadweightEntityList.size() <= 5, "导入的收货重量为：" + entity.getTakeDeliveryWeight() + "吨的数据已经有5单，不能导入请核对数据后再导入，确保业务的真实性！");
            count ++;
        }
        return count;
    }

    private String checkParam(WeightUploadExcelVo excelVo, WeightUploadSearchVo queryVo, int i, TransOrderDispatchDetailVo transOrderDispatchDetailVo) {
        String str = "";
        if (excelVo.getDeliveryId() == null || "".equals(excelVo.getDeliveryId()) || excelVo.getDeliveryId() == 0) {
            str += "第" + i + "条数据,调度单号不能为空！";
        }
        Long companyId = queryVo.getCompanyId();
        if (companyId.longValue() != transOrderDispatchDetailVo.getCompanyId().longValue()) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",此单据的不是来自当前的发单公司！";
            } else {
                str += "第" + i + "条数据,此单据的不是来自当前的发单公司！";
            }
            return str;
        }
        if (!"PT".equals(transOrderDispatchDetailVo.getFromType())) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",只有平台发的单子才可以做导入！";
            } else {
                str += "第" + i + "条数据,只有平台发的单子才可以做导入！";
            }
            return str;
        }
        String stu = transOrderDispatchDetailVo.getStatus();
        String settleStatus = transOrderDispatchDetailVo.getSettleStatus();
        if ("00".equals(stu)) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",该单据已经撤销！";
            } else {
                str += "第" + i + "条数据,该单据已经撤销！";
            }
            return str;
        }
        if ("10".equals(stu)) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",该单据尚未做取单确认！";
            } else {
                str += "第" + i + "条数据,该单据尚未做取单确认！";
            }
            return str;
        }
        if ("20".equals(settleStatus)) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",该单据已结算不能导入收货重量！";
            } else {
                str += "第" + i + "条数据,该单据已结算不能导入收货重量！";
            }
            return str;
        }

        BigDecimal truckLoadingWeight = excelVo.getDeliveryWeight();
        BigDecimal takeDeliveryWeight = excelVo.getFinishWeight();
        if (truckLoadingWeight == null || takeDeliveryWeight == null) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",装车重量或收货重量不能为空！";
            } else {
                str += "第" + i + "条数据,装车重量或收货重量不能为空！";
            }
            return str;
        }

        if (excelVo.getDeliveryIdDate() == null) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",装车时间不能为空！";
            } else {
                str += "第" + i + "条数据,装车时间不能为空！";
            }
            return str;
        }
        if (excelVo.getFinishDate() == null) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",收货时间不能为空！";
            } else {
                str += "第" + i + "条数据,收货时间不能为空！";
            }
            return str;
        }

        if (excelVo.getDeliveryIdDate().getTime() >= excelVo.getFinishDate().getTime()) {
            if (str.indexOf("第" + i + "条数据") != -1) {
                str += ",收货时间不能小于等于装车时间！";
            } else {
                str += "第" + i + "条数据,收货时间不能小于等于装车时间!";
            }
            return str;
        }

        return str;
    }
}