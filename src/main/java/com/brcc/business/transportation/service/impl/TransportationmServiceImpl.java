package com.brcc.business.transportation.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportation.repository.TransportationmRepository;
import com.brcc.business.transportation.service.TransportationmService;


/**
 * 运单业务逻辑接口实现
 * @author 
 * @Date: 2018-11-05
 */
@Service
public class TransportationmServiceImpl implements TransportationmService {

    Logger logger = LoggerFactory.getLogger(TransportationmServiceImpl.class);

    @Autowired
    TransportationmRepository transportationmRepository;

	@Override
	public List<TransportationmEntity> findByPublishId(Long publishId) {
		logger.info("query TransportationmEntity list by publishId:{}",publishId);
		return transportationmRepository.findByPublishId(publishId);
	}

	@Override
	public TransportationmEntity findById(Long transId) {
		logger.info("query TransportationmEntity  by transId:{}",transId);
		return transportationmRepository.findById(transId).get();
	}

	@Override
	public TransportationmEntity save(TransportationmEntity tran) {
		logger.info("save TransportationmEntity");
		return transportationmRepository.save(tran);
	}

	@Override
	public List<TransportationmEntity> listTransportationDetails(GoodsordermQueryVo vo) {
		logger.info("query TransportationmEntity list,by PublishId:{},PlatFormId:{}"
				,vo.getPublishId(),vo.getPlatformId());
		return transportationmRepository.findByPublishIdAndPlatformId(vo.getPublishId(),vo.getPlatformId());
	}


}
