package com.brcc.business.basedata.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.basedata.repository.CatalogRepository;
import com.brcc.business.basedata.service.CatalogService;
import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.basedata.vo.CatalogQueryVo;


/**
 * 货物类型业务逻辑接口实现 
 * @author TangYong
 * @Date   2018-11-19
 */
@Service
@Transactional
public class CatalogServiceImpl implements  CatalogService {

    Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Autowired
    CatalogRepository  catalogRepository;

	@Override
	public CatalogInfoVo queryCatalogIdAndName(CatalogQueryVo catalogQueryVo) {
		logger.info("query catalog , by goodType:{},goodTypeDesc:{}",catalogQueryVo.getGoodType(),catalogQueryVo.getGoodTypeDesc());
		return catalogRepository.queryCatalogIdAndName(catalogQueryVo);
	}

	@Override
	public CatalogInfoVo getCatalogInfo(CatalogQueryVo queryVo) {
		logger.info("query parent catalog information");
		return catalogRepository.getCatalogInfo(queryVo);
	}


}
