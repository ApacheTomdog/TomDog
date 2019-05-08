/**
 * 
 */
package com.brcc.business.creditBill.service.impl;

import com.brcc.business.creditBill.entity.CreditBillDetailEntity;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.creditBill.repository.CreditBillDetailRepository;
import com.brcc.business.creditBill.service.CreditBillDetailService;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
@Service
public class CreditBillDetailServiceImpl implements CreditBillDetailService {

	@Autowired
	CreditBillDetailRepository creditBillDetailRepository;

	@Override
	public Page<CreditBillDetailEntity> queryBillDetail(CreditBillQueryVo vo) {
		return creditBillDetailRepository.queryBillDetail(vo);
	}
}
