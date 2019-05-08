package com.brcc.business.blackbroker.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.repository.BlackbrokerRepository;
import com.brcc.business.blackbroker.service.BlackbrokerService;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.blackbroker.vo.blackBrokerVo;

/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月15日 下午4:12:22 
 */
@Transactional
@Service
public class BlackbrokerServiceImpl implements BlackbrokerService {
	
	Logger logger = LoggerFactory.getLogger(BlackbrokerServiceImpl.class);
	
	@Autowired
	BlackbrokerRepository blackbrokerRepository;
	

	@Override
	public Page<BlackbrokerEntity> searchBlackBroker(blackBrokerQueryVo queryVo) {
		// TODO Auto-generated method stub
		return blackbrokerRepository.searchBlackBroker(queryVo);
	}


	@Override
	public BlackbrokerEntity findById(Long companyId) {
		Optional<BlackbrokerEntity> op = blackbrokerRepository.findById(companyId);
		if (op.isPresent())
			return op.get();
		return null;
	}


	@Override
	public Page<blackBrokerVo> findCompanyName(blackBrokerQueryVo queryVo) {
		// TODO Auto-generated method stub
		return blackbrokerRepository.findCompanyName(queryVo);
	}


	@Override
	public void save(BlackbrokerEntity blackbrokerEntity) {
		List<BlackbrokerEntity> list = blackbrokerRepository.onlyOne(blackbrokerEntity);
		logger.info(list.size()+">>>>");
		Assert.isTrue(list.size() == 0, "操作失败：存在重复的经纪人公司！");
		blackbrokerRepository.save(blackbrokerEntity);
	}


	@Override
	public void change(BlackbrokerEntity blackbrokerEntity) {
		BlackbrokerEntity oldBlackbrokerEntity = blackbrokerRepository.findByBlackBrokerId(blackbrokerEntity.getBlackBrokerId());
		oldBlackbrokerEntity.setBlockBrokerStatus(blackbrokerEntity.getBlockBrokerStatus());
		oldBlackbrokerEntity.setModifyDate(new Date());
		oldBlackbrokerEntity.setModifyPersonId(blackbrokerEntity.getModifyPersonId());
		oldBlackbrokerEntity.setModifyPersonName(blackbrokerEntity.getModifyPersonName());
		blackbrokerRepository.save(oldBlackbrokerEntity);
	}


	@Override
	public List<BlackbrokerEntity> findActivedBlackBroker(Long companyId, String status, String platformId) {
		List<BlackbrokerEntity> list = blackbrokerRepository.findActivedBlackBroker(companyId, status, platformId);
		return list;
	}


}
