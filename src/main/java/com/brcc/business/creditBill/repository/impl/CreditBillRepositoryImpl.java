/**
 * 
 */
package com.brcc.business.creditBill.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.creditBill.entity.CreditBillEntity;
import com.brcc.business.creditBill.repository.ICreditBillRepository;
import com.brcc.business.creditBill.vo.CreditBillQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.util.StringUtils;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class CreditBillRepositoryImpl implements ICreditBillRepository {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PageQuery pageQuery;

	@Override
	public Page<CreditBillEntity> searchCreditBill(CreditBillQueryVo creditBillQueryVo) {

		List<Object> arg = new ArrayList<>();

		StringBuffer sql = new StringBuffer(" select t.* from credit_bill t ");

		sql.append(" where t.platform_id = ? ");
		arg.add(creditBillQueryVo.getPlatformId());

		if (!ObjectUtils.isEmpty(creditBillQueryVo.getCreditCompanyId())) {
			sql.append(" and t.credit_company_id = ? ");
			arg.add(creditBillQueryVo.getCreditCompanyId());
		}

		if (!ObjectUtils.isEmpty(creditBillQueryVo.getInvestCompanyId())) {
			sql.append(" and t.invest_company_id = ? ");
			arg.add(creditBillQueryVo.getInvestCompanyId());
		}
		if (!StringUtils.isEmpty(creditBillQueryVo.getCreditBillDiesFlag())){
			sql.append("	AND t.credit_bill_dies_flag=? ");
			arg.add(creditBillQueryVo.getCreditBillDiesFlag());
			sql.append("	and t.credit_bill_status != '0'");
		}

		if (!StringUtils.isEmpty(creditBillQueryVo.getCreditBillStatus())){
			sql.append("	AND t.credit_bill_status=?");
			arg.add(creditBillQueryVo.getCreditBillStatus());
		}
		if (!ObjectUtils.isEmpty(creditBillQueryVo.getCreateDateStart())) {
			sql.append(" and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
			arg.add(creditBillQueryVo.getCreateDateStart());
		}

		if (!ObjectUtils.isEmpty(creditBillQueryVo.getCreateDateEnd())) {
			sql.append(" and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59') ");
			arg.add(creditBillQueryVo.getCreateDateEnd());
		}

		logger.info("sql:{},arg:{}", sql, arg);

		return pageQuery.query(sql.toString(), arg, creditBillQueryVo, CreditBillEntity.class);
	}

	@Override
	public Page<CreditBillEntity> queryCreditBill(CreditBillQueryVo vo) {
		List<Object> arg = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("    SELECT  " );
		sql.append("    t.credit_bill_id,  " );
		sql.append("    t.credit_bill_no,   " );
		sql.append("   t.platform_id,  " );
		sql.append("    t.credit_company_id,  " );
		sql.append("    t.credit_company_name,  " );
		sql.append("    t.invest_company_id,   " );
		sql.append("   t.invest_company_name,  " );
		sql.append("    t.credit_bill_date_str, " );
		sql.append("    DATE_FORMAT(t.credit_bill_dies_date,'%Y-%m-%d') as 'credit_bill_dies_date', " );
		sql.append("     t.credit_bill_dies_flag,   " );
		sql.append("   t.credit_bill_amt,  " );
		sql.append("    t.credit_bill_repay_amt, " );
		sql.append("    t.credit_bill_status, " );
		sql.append("     t.create_date,  " );
		sql.append("   t.modify_date " );
		sql.append("    from   credit_bill t   " );
		sql.append("   where t.platform_id=?     " );
		arg.add(vo.getPlatformId());
		sql.append("    and      t.invest_company_id=?        " );
		arg.add(vo.getInvestCompanyId());
		if (!StringUtils.isEmpty(vo.getCreditBillStatus())) {
			sql.append("    and      t.credit_bill_status=?      ");
			arg.add(vo.getCreditBillStatus());
		}
		if (!StringUtils.isEmpty(vo.getCreditBillDiesFlag())) {
			sql.append("   and t.credit_bill_dies_flag = ?");
			arg.add(vo.getCreditBillDiesFlag());
			sql.append("	and t.credit_bill_status != '0'");
		}

		if (vo.getCreateDateStart() != null) {
			sql.append("   AND    t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
			arg.add(vo.getCreateDateStart());
		}
		if (vo.getCreateDateEnd() != null) {
			sql.append("   AND    t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
			arg.add(vo.getCreateDateEnd());
		}
		return pageQuery.query(sql.toString(),arg,vo,CreditBillEntity.class);
	}
}
