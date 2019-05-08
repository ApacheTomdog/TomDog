package com.brcc.business.weightUpload.repository;

import com.brcc.business.weightUpload.vo.WeightUploadSearchVo;
import com.brcc.business.weightUpload.vo.WeightUploadVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述:
 * 装卸货重量数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-11-28 16:12
 */
public interface IWeightUploadRepository {

    /**
     * 查询装卸货重量
     * @param vo
     * @return
     */
    Page<WeightUploadVo> queryDelieryImport(WeightUploadSearchVo vo);

}