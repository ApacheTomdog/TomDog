package com.brcc.business.weightUpload.service;

import com.brcc.business.weightUpload.entity.UploadweightEntity;
import com.brcc.business.weightUpload.vo.WeightUploadExcelVo;
import com.brcc.business.weightUpload.vo.WeightUploadSearchVo;
import com.brcc.business.weightUpload.vo.WeightUploadVo;
import org.springframework.data.domain.Page;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 装卸货重量业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-28 16:28
 */
public interface WeightUploadService {

    /**
     * 查询装卸货重量
     * @param vo
     * @return
     */
    Page<WeightUploadVo> queryDelieryImport(WeightUploadSearchVo vo);

    /**
     * 获取最大BatchId
     * @return
     */
    UploadweightEntity queryBatchId();

    /**
     * 装卸货Excel上传
     * @param map
     * @param queryVo
     * @return
     */
    String excelUpload(List<WeightUploadExcelVo> weightUploadExcelVoList, Map<String, String> map, WeightUploadSearchVo queryVo) throws Exception;
}