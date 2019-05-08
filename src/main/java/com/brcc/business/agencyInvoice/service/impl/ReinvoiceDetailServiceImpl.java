package com.brcc.business.agencyInvoice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.agencyInvoice.entity.ReinvoicedetailEntity;
import com.brcc.business.agencyInvoice.repository.ReinvoicedetailRepository;
import com.brcc.business.agencyInvoice.service.ReinvoiceDetailService;

/**
 * 	代开票明细数据
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
@Service
public class ReinvoiceDetailServiceImpl implements ReinvoiceDetailService {

    Logger logger = LoggerFactory.getLogger(ReinvoiceDetailServiceImpl.class);
    
    @Autowired
    private ReinvoicedetailRepository repository;

	@Override
	public List<ReinvoicedetailEntity> getReinvoiceDetailList(Long reinvoiceMasterId, String platformId) {
		logger.info("getReinvoiceDetailList,reinvoiceMasterId:{},platformId:{}", reinvoiceMasterId, platformId);
		return repository.findByReinvoiceMasterIdAndPlatformId(reinvoiceMasterId, platformId);
	}

	@Override
	public List<ReinvoicedetailEntity> getReinvoiceDetailList(List<Long> reinvoiceMasterIdList, String platformId) {
		logger.info("getReinvoiceDetailList,reinvoiceMasterIdList size:{},platformId:{}", reinvoiceMasterIdList.size(), platformId);
		return repository.getReinvoiceDetailList(platformId, reinvoiceMasterIdList);
	}

	@Override
	@Transactional
	public void saveBetch(List<ReinvoicedetailEntity> detailList) {
		logger.info("saveBetch, detailList size:{}", detailList.size());
		
		repository.saveAll(detailList);
	}

}
