package com.brcc.business.paybillgoods.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.paybillgoods.entity.PayBillGoodEntity;
import com.brcc.business.paybillgoods.repository.PayBillGoodsRepository;
import com.brcc.business.paybillgoods.service.PayBillGoodsService;

/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月15日 下午4:12:22
 */
@Transactional
@Service
public class PayBillGoodsServiceImpl implements PayBillGoodsService {
	
	Logger logger = LoggerFactory.getLogger(PayBillGoodsServiceImpl.class);
	
	@Autowired
	PayBillGoodsRepository payBillGoodsRepository;

	@Override
	public void save(PayBillGoodEntity payBillGoodEntity) {
		payBillGoodsRepository.save(payBillGoodEntity);
	}
	
}
