package com.brcc.business.capital.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.capital.entity.CapitalBalanceEntity;
import com.brcc.business.capital.repository.CapitalBalanceRepository;
import com.brcc.business.capital.service.CapitalBalanceService;


/**
 * 承运资金业务逻辑接口实现 
 * @author TangYong
 * @Date   2018-12-11
 */
@Service
@Transactional
public class CapitalBalanceServiceImpl implements  CapitalBalanceService {

    Logger logger = LoggerFactory.getLogger(CapitalBalanceServiceImpl.class);

    @Autowired
    CapitalBalanceRepository  capitalBalanceRepository;

	@Override
	public CapitalBalanceEntity findByCompanyIdAndPlatformId(Long companyId, String platformId) {
		logger.info("query the CapitalBalanceEntity,companyId:{}",companyId);
		return capitalBalanceRepository.findByCompanyIdAndPlatformId(companyId,platformId);
	}

	@Override
	public CapitalBalanceEntity findByCapitalSeqIdAndAmount(Long seqId, BigDecimal grabMoney) {
		logger.info("query the CapitalBalanceEntity'banlance is enough,seqId:{},grabMoney",seqId,grabMoney);
		return capitalBalanceRepository.findBySeqIdAndBalance(seqId,grabMoney);
	}

}
