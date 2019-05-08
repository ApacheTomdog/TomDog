package com.brcc.business.transorder.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.transorder.entity.ShortmessageEntity;
import com.brcc.business.transorder.repository.ShortMessageRepository;
import com.brcc.business.transorder.service.ShortmessageService;

/**
* @Desc   货源单报价记录逻辑
* @author TangYong
* @Date   2018-12-05
*/
@Service
public class ShortmessageServiceI implements ShortmessageService {
	Logger logger = LoggerFactory.getLogger(ShortmessageServiceI.class);
	 
	@Autowired
	ShortMessageRepository shortMessageRepository;

	@Override
	public void save(ShortmessageEntity entity) {
		logger.info("save or update ShortmessageEntity");
		shortMessageRepository.save(entity);
	}

	@Override
	public void saveList(List<ShortmessageEntity> shortMessageList) {
		logger.info("save or update ShortmessageEntity list");
		shortMessageRepository.saveAll(shortMessageList);
	}
	
}
