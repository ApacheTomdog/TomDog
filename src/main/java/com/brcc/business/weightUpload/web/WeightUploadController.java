package com.brcc.business.weightUpload.web;

import com.brcc.business.weightUpload.entity.UploadweightEntity;
import com.brcc.business.weightUpload.service.WeightUploadService;
import com.brcc.business.weightUpload.vo.WeightUploadExcelVo;
import com.brcc.business.weightUpload.vo.WeightUploadSearchVo;
import com.brcc.business.weightUpload.vo.WeightUploadVo;
import com.esteel.common.controller.WebReturnMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 描述:
 * 装卸货重量
 *
 * @author yushaohua
 * @create 2018-11-28 16:30
 */
@RestController
@RequestMapping("/business/weightUpload/")
public class WeightUploadController {

    Logger logger = LoggerFactory.getLogger(WeightUploadController.class);

    @Autowired
    private WeightUploadService weightUploadService;

    /**
     * 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @RequestMapping(value = "/pageData", method = RequestMethod.POST)
    public Page<WeightUploadVo> pageData(@RequestBody WeightUploadSearchVo vo){
        logger.info("Query trans order pagination page");

        return weightUploadService.queryDelieryImport(vo);
    }

    /**
     * 装货收货重量导入
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public WeightUploadVo excelImport(@RequestBody List<WeightUploadExcelVo> excelVoList, @RequestParam("userId") Long userId, @RequestParam("platformId") String platformId, @RequestParam("companyId") Long companyId) throws Exception {
        logger.info("Query trans order pagination page");

        HashMap map=new LinkedHashMap();
        map.put("0","deliveryId");
        map.put("1","deliveryWeight");
        map.put("2","deliveryIdDate");
        map.put("3","finishWeight");
        map.put("4","finishDate");

        WeightUploadSearchVo queryVo = new WeightUploadSearchVo();
        queryVo.setToDay(new Date());
        queryVo.setUserId(userId);
        queryVo.setPlatformId(platformId);
        queryVo.setCompanyId(companyId);

        UploadweightEntity uploadweightEntity = weightUploadService.queryBatchId();
        queryVo.setBatchId(uploadweightEntity.getBatchId() + 1);

        String msg = weightUploadService.excelUpload(excelVoList, map, queryVo);
        WeightUploadVo weightUploadVo = new WeightUploadVo();
        weightUploadVo.setMsg(msg);

        return weightUploadVo;
    }

}