package com.brcc.business.goodsordermjk.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.goodsordermjk.entity.NotifyrecordEntity;
import com.brcc.business.goodsordermjk.repository.NotifyrecordRepository;
import com.brcc.business.goodsordermjk.service.NotifyrecordService;

@Service
@Transactional
public class NotifyrecordServiceImpl implements NotifyrecordService{

    Logger logger = LoggerFactory.getLogger(NotifyrecordServiceImpl.class);
    
    @Autowired
    NotifyrecordRepository notifyrecordRepository;
    
	@Override
	@Transactional
	public void saveList(List<NotifyrecordEntity> notifyrecordList) {
		logger.info("asve NotifyrecordEntity list");
		notifyrecordRepository.saveAll(notifyrecordList);
	}
}   