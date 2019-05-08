package com.brcc.business.basedata.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.basedata.entity.BasedataEntity;
import com.brcc.business.basedata.repository.BaseDataRepository;
import com.brcc.business.basedata.service.BaseDataService;
import com.brcc.business.basedata.vo.BaseDataQueryVo;

/**
 * 省市区信息逻辑接口实现 
 * @author TangYong
 * @Date 2018-11-28
 */
@Service
public class BaseDataServiceImpl implements  BaseDataService {

    Logger logger = LoggerFactory.getLogger(BaseDataServiceImpl.class);

    @Autowired
    BaseDataRepository  baseDataRepository;

	@Override
	public BasedataEntity getPlatLngLat(BaseDataQueryVo vo) {
		logger.info("query lng and lat by keyValue:{},fatherKeyValue:{}",vo.getKeyValue(),vo.getFatherKeyValue());
		return baseDataRepository.findByKeyValueAndFatherKeyValue(vo.getKeyValue(),vo.getFatherKeyValue());
	}

}
