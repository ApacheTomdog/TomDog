package com.brcc.business.payCalcBatch.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchQueryVo;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchVo;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
public interface PayCalcBatchService {
	
	Page<PayCalcBatchVo> listDataList(PayCalcBatchQueryVo queryvo);
	
	void saveAll(List<PayCalcBatchEntity> payCalcBatchEntityList);

}
