package com.brcc.business.payCalcBatch.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.payCalcBatch.vo.PayCalcBatchQueryVo;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchVo;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
public interface IPayCalcBatchRepository {
	
	/**
	 * 批量运费计算结果列表
	 */
	Page<PayCalcBatchVo> listDataList(PayCalcBatchQueryVo queryvo);

}
