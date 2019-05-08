package com.brcc.business.transportSettle.service;

import java.util.List;

import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;

/**
 * @Desc 批量运费计算逻辑接口
 * @author yangwenbin
 * @version 创建时间：2019年1月22日 下午4:23:52
 */
public interface PayCalcBatchService {

	void saveAll(List<PayCalcBatchEntity> payCalcBatchEntityList);

}
