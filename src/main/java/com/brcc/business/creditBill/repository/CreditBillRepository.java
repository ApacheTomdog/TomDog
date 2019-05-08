package com.brcc.business.creditBill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.creditBill.entity.CreditBillEntity;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface CreditBillRepository extends JpaRepository<CreditBillEntity,Long>,ICreditBillRepository {

	//CreditBillEntity findByVatFlowMasterId(Long creditBillId);
}
