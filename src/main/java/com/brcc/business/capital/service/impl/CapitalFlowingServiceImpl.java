package com.brcc.business.capital.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.capital.entity.CapitalFlowingEntity;
import com.brcc.business.capital.repository.CapitalFlowingRepository;
import com.brcc.business.capital.service.CapitalFlowingService;


/**
 * 资金流水业务逻辑接口实现 
 * @author TangYong
 * @Date   2018-12-11
 */
@Service
@Transactional
public class CapitalFlowingServiceImpl implements  CapitalFlowingService {

    Logger logger = LoggerFactory.getLogger(CapitalFlowingServiceImpl.class);

    @Autowired
    CapitalFlowingRepository  capitalFlowingRepository;

	@Override
	public CapitalFlowingEntity save(CapitalFlowingEntity capitalFlowingEntity) {
		logger.info("save the capital flow entity");
		return capitalFlowingRepository.save(capitalFlowingEntity);
	}

	@Override
	public CapitalFlowingEntity findById(Long capitalFlowingId) {
		logger.info("query the capitalFlowing entity,capitalFlowingId:{}",capitalFlowingId);
		return capitalFlowingRepository.getOne(capitalFlowingId);
	}

}
