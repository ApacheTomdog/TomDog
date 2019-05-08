package com.brcc.business.agencyInvoice.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.brcc.business.agencyInvoice.entity.ReinvoicemasterEntity;
import com.brcc.business.agencyInvoice.repository.ReinvoicemasterRepository;
import com.brcc.business.agencyInvoice.service.ReinvoiceMasterService;
import com.brcc.business.agencyInvoice.vo.DealPrintFlagVo;

/**
 * 	代开票主项数据
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
@Service
public class ReinvoiceMasterServiceImpl implements ReinvoiceMasterService {

    Logger logger = LoggerFactory.getLogger(ReinvoiceMasterServiceImpl.class);
    
    @Autowired
    private ReinvoicemasterRepository repository;

	@Override
	public ReinvoicemasterEntity getReinvoiceMaster(Long reinvoiceMasterId, String platformId) {
		logger.info("getReinvoicemaster,reinvoiceMasterId:{},platformId:{}", reinvoiceMasterId, platformId);
		
		Optional<ReinvoicemasterEntity> optional = repository.findById(reinvoiceMasterId);
		Assert.isTrue(optional != null && optional.get() != null, "记录不存在");
		
		ReinvoicemasterEntity reinvoicemasterEntity = optional.get();
		Assert.isTrue(reinvoicemasterEntity.getPlatformId().equals(platformId), "记录不存在");
		
		return reinvoicemasterEntity;
	}

	@Override
	@Transactional
	public void dealPrintFlag(DealPrintFlagVo dealPrintFlagVo) {
		Assert.notNull(dealPrintFlagVo, "参数不能为空");
		logger.info("DealPrintFlagVo,{}", dealPrintFlagVo.toString());
		
		Integer ifPrint = dealPrintFlagVo.getIfPrint();
		Assert.isTrue(ifPrint != null && (ifPrint == 0 || ifPrint == 1), "打印标记错误");
		
		List<Long> reinvoiceMasterIdList = dealPrintFlagVo.getReinvoiceMasterIdList();
		Assert.isTrue(!CollectionUtils.isEmpty(reinvoiceMasterIdList), "需修改打印标记的单据不能为空");
		
		repository.dealPrintFlag(ifPrint, dealPrintFlagVo.getPlatformId(), reinvoiceMasterIdList);
	}

	@Override
	public List<ReinvoicemasterEntity> getReinvoiceMasterList(List<String> reinvoiceMasterNumList, String platformId) {
		logger.info("getReinvoiceMasterList, reinvoiceMasterNumList size:{}", reinvoiceMasterNumList.size());
		return repository.getReinvoiceMasterList(platformId, reinvoiceMasterNumList);
	}

	@Override
	@Transactional
	public void saveBetch(List<ReinvoicemasterEntity> reinvoiceMasterList) {
		logger.info("saveBetch, reinvoiceMasterList size:{}", reinvoiceMasterList.size());
		
		repository.saveAll(reinvoiceMasterList);
	}

}
