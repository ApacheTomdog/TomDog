package com.brcc.business.brokerProfit.service.impl;

import java.math.BigDecimal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.brokerProfit.entity.BrokerProfitConfigEntity;
import com.brcc.business.brokerProfit.repository.BrokerProfitConfigRepository;
import com.brcc.business.brokerProfit.service.BrokerProfitConfigService;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigAddVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigModifyVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigVo;

/**
 * 经纪人最高分润配置接口实现
 * @author dzj
 * @date 2019-01-29
 */
@Service
public class BrokerProfitConfigServiceImpl implements BrokerProfitConfigService {
	Logger logger = LoggerFactory.getLogger(BrokerProfitConfigServiceImpl.class);

	@Autowired
	private BrokerProfitConfigRepository brokerProfitConfigRepository;

	@Override
	public Page<BrokerProfitConfigVo> data(BrokerProfitConfigQueryVo queryVo) {
		return brokerProfitConfigRepository.getPageData(queryVo);
	}

	@Override
	@Transactional
	public void add(BrokerProfitConfigAddVo addVo) {
		BrokerProfitConfigEntity entity = new BrokerProfitConfigEntity();
		BeanUtils.copyProperties(addVo, entity);
		entity.setBrokerProfitRate(entity.getBrokerProfitRate().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
		entity.setBrokerProfitConfigStatus("10");
		entity.setModifyDate(entity.getCreateDate());
		entity.setModifyPersonId(entity.getCreatePersonId());
		entity.setModifyPersonName(entity.getCreatePersonName());
		entity.setIfUploadCapitalFlow(entity.getIfSpecialCase());
		brokerProfitConfigRepository.save(entity);
	}

	@Override
	@Transactional
	public void modify(BrokerProfitConfigModifyVo modifyVo) {
		Optional<BrokerProfitConfigEntity> optional = brokerProfitConfigRepository.findById(modifyVo.getBrokerProfitConfigId());
		if (!optional.isPresent()) {
			throw new RuntimeException("当前配置信息不存在!");
		}
		BrokerProfitConfigEntity entity = optional.get();
		if (!"10".equals(entity.getBrokerProfitConfigStatus())) {
			throw new RuntimeException("当前配置信息不是新增状态!");
		}
		entity.setIfSpecialCase(modifyVo.getIfSpecialCase());
		entity.setSpecialBrokerId(modifyVo.getSpecialBrokerId());
		entity.setSpecialBrokerName(modifyVo.getSpecialBrokerName());
		entity.setSpecialRemark(modifyVo.getSpecialRemark());
		entity.setSpecialAttachment(modifyVo.getSpecialAttachment());
		entity.setBrokerProfitRate(modifyVo.getBrokerProfitRate().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
		entity.setModifyDate(modifyVo.getModifyDate());
		entity.setModifyPersonId(modifyVo.getModifyPersonId());
		entity.setModifyPersonName(modifyVo.getModifyPersonName());
		entity.setIfUploadCapitalFlow(entity.getIfSpecialCase());
		brokerProfitConfigRepository.save(entity);
	}

	@Override
	@Transactional
	public BrokerProfitConfigEntity findOne(BrokerProfitConfigEntity brokerProfitConfigEntity) {
		BrokerProfitConfigEntity entity = new BrokerProfitConfigEntity();
		entity.setBrokerProfitRate(brokerProfitConfigEntity.getBrokerProfitRate());
		entity.setIfSpecialCase(brokerProfitConfigEntity.getIfSpecialCase());
		entity.setSpecialBrokerId(brokerProfitConfigEntity.getSpecialBrokerId());
		Example<BrokerProfitConfigEntity> example = Example.of(entity);
		return brokerProfitConfigRepository.findOne(example).orElse(null);
	}

	@Override
	@Transactional
	public void cancel(BrokerProfitConfigModifyVo modifyVo) {
		Optional<BrokerProfitConfigEntity> optional = brokerProfitConfigRepository.findById(modifyVo.getBrokerProfitConfigId());
		if (!optional.isPresent()) {
			throw new RuntimeException("当前配置信息不存在!");
		}
		BrokerProfitConfigEntity entity = optional.get();
		entity.setCancelDate(modifyVo.getModifyDate());
		entity.setCancelPersonId(modifyVo.getModifyPersonId());
		entity.setCancelPersonName(modifyVo.getModifyPersonName());
		entity.setModifyDate(modifyVo.getModifyDate());
		entity.setModifyPersonId(modifyVo.getModifyPersonId());
		entity.setModifyPersonName(modifyVo.getModifyPersonName());
		entity.setBrokerProfitConfigStatus("00");
		brokerProfitConfigRepository.save(entity);
	}

	@Override
	@Transactional
	public void audit(BrokerProfitConfigModifyVo modifyVo) {
		Optional<BrokerProfitConfigEntity> optional = brokerProfitConfigRepository.findById(modifyVo.getBrokerProfitConfigId());
		if (!optional.isPresent()) {
			throw new RuntimeException("当前配置信息不存在!");
		}
		BrokerProfitConfigEntity entity = optional.get();
		if (!"10".equals(entity.getBrokerProfitConfigStatus())) {
			throw new RuntimeException("当前配置信息不是新增状态!");
		}
		entity.setAuditDate(modifyVo.getModifyDate());
		entity.setAuditPersonId(modifyVo.getModifyPersonId());
		entity.setAuditPersonName(modifyVo.getModifyPersonName());
		entity.setModifyDate(modifyVo.getModifyDate());
		entity.setModifyPersonId(modifyVo.getModifyPersonId());
		entity.setModifyPersonName(modifyVo.getModifyPersonName());
		entity.setBrokerProfitConfigStatus("20");
		brokerProfitConfigRepository.save(entity);
		if ("1".equals(entity.getIfSpecialCase())) {
			// 作废特例经纪人
			brokerProfitConfigRepository.cancelSpecial(entity.getModifyDate(), entity.getModifyPersonId(), entity.getModifyPersonName(), entity.getSpecialBrokerId(), entity.getBrokerProfitConfigId());
		} else {
			// 作废普通
			brokerProfitConfigRepository.cancelNormal(entity.getModifyDate(), entity.getModifyPersonId(), entity.getModifyPersonName(), entity.getBrokerProfitConfigId());
		}
	}

	public BrokerProfitConfigEntity querySpecialCase(BrokerProfitConfigQueryVo queryVo) {
		logger.info("Query if Special Case, by special_broker_id {}", queryVo.getSpecialBrokerId());
		BrokerProfitConfigEntity brokerProfitConfigEntity = brokerProfitConfigRepository.querySpecialCase(queryVo.getSpecialBrokerId(),queryVo.getBrokerProfitConfigStatus(),queryVo.getIfSpecialCase());
		return brokerProfitConfigEntity;
	}

	@Override
	public BrokerProfitConfigEntity queryNormalCase() {
		logger.info("Query query Normal Case");
		BrokerProfitConfigEntity brokerProfitConfigEntity = brokerProfitConfigRepository.queryNormalCase();
		return brokerProfitConfigEntity;
	}
	
	@Override
	public BrokerProfitConfigEntity findOne(Long companyId) {
		BrokerProfitConfigEntity brokerProfitConfigEntity = brokerProfitConfigRepository.findBySpecialBrokerIdAndBrokerProfitConfigStatus(companyId, "20");
		return null;
	}
}
