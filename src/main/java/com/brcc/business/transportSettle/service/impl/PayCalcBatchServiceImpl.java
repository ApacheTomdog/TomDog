package com.brcc.business.transportSettle.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;
import com.brcc.business.payCalcBatch.repository.PayCalcBatchRepository;
import com.brcc.business.transportSettle.service.PayCalcBatchService;

/**
 * @Desc 批量运费计算逻辑接口实现
 * @author yangwenbin
 * @version 创建时间：2019年1月22日 下午4:23:26
 */
@Transactional
@Service("payCalcBatchServiceImpl2")
public class PayCalcBatchServiceImpl implements PayCalcBatchService {

    Logger logger = LoggerFactory.getLogger(PayCalcBatchServiceImpl.class);

    @Autowired
    PayCalcBatchRepository payCalcBatchRepository;

	@Override
	public void saveAll(List<PayCalcBatchEntity> payCalcBatchEntityList) {
		payCalcBatchRepository.saveAll(payCalcBatchEntityList);
	}

}
