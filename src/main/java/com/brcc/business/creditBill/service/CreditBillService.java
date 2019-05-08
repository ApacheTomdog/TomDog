/**
 * 
 */
package com.brcc.business.creditBill.service;

import org.springframework.data.domain.Page;
import com.brcc.business.creditBill.entity.CreditBillEntity;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface CreditBillService {

	Page<CreditBillEntity> searchCreditBill(CreditBillQueryVo creditBillQueryVo);

	/**
	 * @Description  委托级垫资账单查询
	 * @Param [vo]
	 * @return org.springframework.data.domain.Page<com.brcc.business.creditBill.entity.CreditBillEntity>
	 **/
	Page<CreditBillEntity>  queryCreditBill(CreditBillQueryVo vo);
}
