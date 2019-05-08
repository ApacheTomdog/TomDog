package com.brcc.business.agencyInvoice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.agencyInvoice.entity.ReinvoicetempEntity;
import com.brcc.business.agencyInvoice.repository.ReinvoicetempRepository;
import com.brcc.business.agencyInvoice.service.ReinvoiceTempService;

/**
 * 	代开票主项数据
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
@Service
public class ReinvoiceTempServiceImpl implements ReinvoiceTempService {

    Logger logger = LoggerFactory.getLogger(ReinvoiceTempServiceImpl.class);
    
    @Autowired
    private ReinvoicetempRepository repository;

	@Override
	@Transactional
	public void saveBetch(List<ReinvoicetempEntity> tempList) {
		logger.info("saveBetch, tempList size:{}", tempList.size());
		
		repository.saveAll(tempList);
	}

}
