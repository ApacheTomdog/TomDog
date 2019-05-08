package com.brcc.business.creditBill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.creditBill.entity.CreditBillEntity;
import com.brcc.business.creditBill.repository.CreditBillRepository;
import com.brcc.business.creditBill.service.CreditBillService;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class CreditBillServiceImpl implements CreditBillService {

	@Autowired
	CreditBillRepository creditBillRepository;

	@Override
	public Page<CreditBillEntity> searchCreditBill(CreditBillQueryVo creditBillQueryVo) {
		
		return creditBillRepository.searchCreditBill(creditBillQueryVo);
	}


	@Override
	public Page<CreditBillEntity> queryCreditBill(CreditBillQueryVo vo) {
		return creditBillRepository.queryCreditBill(vo);
	}
}
