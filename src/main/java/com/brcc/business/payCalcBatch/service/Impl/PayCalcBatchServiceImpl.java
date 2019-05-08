package com.brcc.business.payCalcBatch.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;
import com.brcc.business.payCalcBatch.repository.PayCalcBatchRepository;
import com.brcc.business.payCalcBatch.service.PayCalcBatchService;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchQueryVo;
import com.brcc.business.payCalcBatch.vo.PayCalcBatchVo;


/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
@Service
@Transactional
public class PayCalcBatchServiceImpl implements PayCalcBatchService{

	Logger logger = LoggerFactory.getLogger(PayCalcBatchServiceImpl.class);

	@Autowired
	PayCalcBatchRepository payCalcBatchRepository;
	
	@Override
	public Page<PayCalcBatchVo> listDataList(PayCalcBatchQueryVo queryvo) {
		Page<PayCalcBatchVo> page = payCalcBatchRepository.listDataList(queryvo);
		return page;
	}

	@Override
	public void saveAll(List<PayCalcBatchEntity> payCalcBatchEntityList) {
		payCalcBatchRepository.saveAll(payCalcBatchEntityList);
	}
}
