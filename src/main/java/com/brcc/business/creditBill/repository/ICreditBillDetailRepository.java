/**
 * 
 */
package com.brcc.business.creditBill.repository;

import java.util.List;

import com.brcc.business.creditBill.entity.CreditBillDetailEntity;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;
import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public interface ICreditBillDetailRepository {


    Page<CreditBillDetailEntity> queryBillDetail(CreditBillQueryVo vo);
}
