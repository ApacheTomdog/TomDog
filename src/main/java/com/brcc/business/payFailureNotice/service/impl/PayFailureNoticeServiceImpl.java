package com.brcc.business.payFailureNotice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.payFailureNotice.repository.PayFailureNoticeRepository;
import com.brcc.business.payFailureNotice.service.PayFailureNoticeService;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeQueryVo;
import com.brcc.business.payFailureNotice.vo.PayFailureNoticeVo;

@Service
public class PayFailureNoticeServiceImpl implements PayFailureNoticeService {
	
	Logger logger = LoggerFactory.getLogger(PayFailureNoticeServiceImpl.class);
	 
	@Autowired
	PayFailureNoticeRepository payFailureNoticeRepository;
	

	@Override
	public Page<PayFailureNoticeVo> queryList(PayFailureNoticeQueryVo vo) {
		return payFailureNoticeRepository.queryListPage(vo);
	}


}
