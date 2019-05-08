/**
 * 
 */
package com.brcc.business.creditBill.service;


import com.brcc.business.creditBill.entity.CreditBillDetailEntity;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface CreditBillDetailService {


    Page<CreditBillDetailEntity> queryBillDetail(CreditBillQueryVo vo);

}
