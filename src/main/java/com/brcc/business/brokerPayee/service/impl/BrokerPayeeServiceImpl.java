package com.brcc.business.brokerPayee.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.brokerPayee.entity.BrokerPayeeEntity;
import com.brcc.business.brokerPayee.repository.BrokerPayeeRepository;
import com.brcc.business.brokerPayee.service.BrokerPayeeService;
import com.brcc.business.brokerPayee.vo.BrokerPayeeQueryVo;
import com.brcc.business.brokerPayee.vo.BrokerPayeeVo;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
@Service
@Transactional
public class BrokerPayeeServiceImpl implements BrokerPayeeService{
	
	@Autowired
	BrokerPayeeRepository brokerPayeeRepository;
	

	@Override
	public Page<BrokerPayeeVo> listDataPage(BrokerPayeeQueryVo queryvo) {
		
		return brokerPayeeRepository.listDataPage(queryvo);
	}

	@Override
	public void agreeBrokerPayee(BrokerPayeeQueryVo queryvo) {
		
		BrokerPayeeEntity entity = brokerPayeeRepository.findById(queryvo.getCompanyPayeeId()).get();
		if("20".equals(queryvo.getCompanyPayeeStatus())) {
			int num=brokerPayeeRepository.checkAll(entity.getCompanyPayeeName(), entity.getCompanyPayeeNum());
			Assert.isTrue(num==0, "操作失败：只能有一条生效的单据信息！");
		}
		brokerPayeeRepository.agreeBrokerPayee(queryvo.getCompanyPayeeStatus(), queryvo.getModifyPersonId(), queryvo.getModifyPersonName(), queryvo.getCompanyPayeeId());
	}

	@Override
	public void save(BrokerPayeeQueryVo queryvo) {
		BrokerPayeeEntity entity = new BrokerPayeeEntity();		
		BeanUtils.copyProperties(queryvo, entity);
		String companyName =brokerPayeeRepository.getCompanyName(queryvo.getCompanyId());
		entity.setCompanyName(companyName);
		entity.setModifyDate(new Date());
		entity.setCreateDate(new Date());
		brokerPayeeRepository.save(entity);
		
	}

	@Override
	public void update(BrokerPayeeQueryVo queryvo) {
		BrokerPayeeEntity entity = brokerPayeeRepository.findById(queryvo.getCompanyPayeeId()).get();
		entity.setModifyPersonId(queryvo.getModifyPersonId());
		entity.setModifyPersonName(queryvo.getModifyPersonName());
		entity.setCompanyPayeeName(queryvo.getCompanyPayeeName());
		entity.setCompanyPayeeNum(queryvo.getCompanyPayeeNum());
		brokerPayeeRepository.save(entity);
	}

	@Override
	public BrokerPayeeEntity findById(Long companyPayeeId) {
		BrokerPayeeEntity entity = brokerPayeeRepository.findById(companyPayeeId).get();
		return entity;
	}

	@Override
	public Page<BrokerPayeeVo> list(BrokerPayeeQueryVo queryvo) {
		return brokerPayeeRepository.list(queryvo);
	}

	@Override
	public Long checkIfExist(Long companyId,String companyPayeeName,String companyPayeeNum ,String companyPayeeStatus){
		return brokerPayeeRepository.checkIfExist(companyId,companyPayeeName,companyPayeeNum,companyPayeeStatus);
	}
	@Override
	public BrokerPayeeEntity saveEntity(BrokerPayeeEntity entity){
		return  brokerPayeeRepository.save(entity);
	}
}
