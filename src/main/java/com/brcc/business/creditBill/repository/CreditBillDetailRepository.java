package com.brcc.business.creditBill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.creditBill.entity.CreditBillDetailEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface CreditBillDetailRepository extends JpaRepository<CreditBillDetailEntity,Long>,ICreditBillDetailRepository{

	CreditBillDetailEntity findByCreditBillDetailId(Long creditBillDetailId);
	
}
