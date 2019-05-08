/**
 * 
 */
package com.brcc.business.flow.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.brcc.business.flow.vo.VatflowdetailCompanyNameVo;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.vatcompanyrecharge.vo.VatCompanyRechargeQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.repository.IVatflowdetailRepository;
import com.esteel.common.dao.PageQuery;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class VatflowdetailRepositoryImpl implements IVatflowdetailRepository {

	@Autowired
	PageQuery pageQuery;
	
	@Override
	public List<VatflowdetailEntity> listByPulishCompanyId(Long publishCompanyId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append(" 	v.vat_flow_master_id,");
		sql.append(" 	d.vat_rate_chose,");
		sql.append(" 	d.vat_standard_rate,");
		sql.append(" 	d.vat_policy_rate,");
		sql.append(" 	d.vat_acc_type ");
		sql.append("FROM ");
		sql.append(" 	apptms.company c,");
		sql.append(" 	apptms.vatplatflowmaster m,");
		sql.append(" 	apptms.vatflowmaster v,");
		sql.append(" 	apptms.vatflowdetail d ");
		sql.append("WHERE ");
		sql.append(" 	c.create_company_id = m.vat_company_id ");
		sql.append(" 	AND m.vat_plat_flow_master_id = v.vat_plat_flow_master_id ");
		sql.append("    AND m.vat_status = '20' ");
		sql.append("    AND v.vat_status = '20' ");
		sql.append("    and v.vat_flow_master_id = d.vat_flow_master_id ");
		sql.append("    and d.if_begin = 'Y' ");
		sql.append("    AND ( ");
		sql.append(" 	CASE ");
		sql.append(" 	WHEN ( ");
		sql.append(" 		SELECT ");
		sql.append(" 			count(1) "); 
		sql.append(" 		FROM ");
		sql.append(" 			apptms.company c1, ");
		sql.append(" 			apptms.vatplatflowmaster m1,");
		sql.append(" 			apptms.vatflowmaster v1" );
		sql.append(" 		WHERE ");
		sql.append(" 			c1.create_company_id = m1.vat_company_id ");
		sql.append(" 		AND m1.vat_plat_flow_master_id = v1.vat_plat_flow_master_id ");
		sql.append(" 		AND m1.vat_status = '20' ");
		sql.append(" 		AND v1.vat_status = '20' ");
		sql.append(" 		AND c1.seq_id = v1.vat_company_id ");
		sql.append(" 		AND v1.vat_company_id = ?");
		args.add(publishCompanyId);
		sql.append(" 		AND m1.if_special_case = '1' ");
		sql.append(" 	) > 0 THEN ");
		sql.append(" 		c.seq_id = m.special_client_id ");
		sql.append(" 	ELSE ");
		sql.append(" 		1 = 1 ");
		sql.append(" 	END ");
		sql.append(" ) ");
		sql.append(" AND c.seq_id = v.vat_company_id ");
		sql.append(" AND v.vat_company_id = ? "); 
		args.add(publishCompanyId);
		List<VatflowdetailEntity> list = pageQuery.list(sql.toString(),args,VatflowdetailEntity.class);
		return ObjectUtils.isEmpty(list) ? null : list;
	}
	
	@Override
	public List<VatflowdetailCompanyNameVo> queryForCompanyName(VatCompanyRechargeQueryVo vo) {
		List<Object> arg  = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT d.vat_carry_id as \"seq_id\",d.vat_client_id,d.vat_client_name,d.vat_carry_id,d.vat_carry_name ");
		sql.append("    FROM  vatflowmaster m, vatflowdetail d ");
		sql.append("    WHERE  m.vat_flow_master_id = d.vat_flow_master_id");
		sql.append("    AND m.vat_status = '20' and d.vat_client_id =?");
		arg.add(vo.getClientId());
		sql.append("    and m.platform_id =?");
		arg.add(vo.getPlatformId());
		sql.append("    group by d.vat_carry_id,d.vat_carry_name");
		return pageQuery.list(sql.toString(),arg,VatflowdetailCompanyNameVo.class);
	}
	
	@Override
	public List<VatflowdetailVo> queryForCompanyName(Long pulishCompanyId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT  ");
		sql.append("	v.vat_flow_master_id AS 'vatFlowMasterId', ");
		sql.append("	d.vat_rate_chose AS 'vatRateChose', ");
		sql.append("	d.vat_standard_rate AS 'vatStandardRate', ");
		sql.append("	d.vat_policy_rate AS 'vatPolicyRate', ");
		sql.append("	d.vat_acc_type AS 'vatAccType' ");
		sql.append("FROM ");
		sql.append("	apptms.company c, ");
		sql.append("	apptms.vatplatflowmaster m, ");
		sql.append("	apptms.vatflowmaster v, ");
		sql.append("	apptms.vatflowdetail d ");
		sql.append("WHERE ");
		sql.append("	c.create_company_id = m.vat_company_id ");
		sql.append("AND m.vat_plat_flow_master_id = v.vat_plat_flow_master_id ");
		sql.append("AND m.vat_status = '20' ");
		sql.append("AND v.vat_status = '20' ");
		sql.append("and v.vat_flow_master_id = d.vat_flow_master_id ");
		sql.append("and d.if_begin = 'Y' ");
		sql.append("AND ( ");
		sql.append("	CASE ");
		sql.append("	WHEN ( ");
		sql.append("		SELECT ");
		sql.append("			count(1) ");
		sql.append("		FROM ");
		sql.append("			apptms.company c1, ");
		sql.append("			apptms.vatplatflowmaster m1, ");
		sql.append("			apptms.vatflowmaster v1 ");
		sql.append("		WHERE ");
		sql.append("		c1.create_company_id = m1.vat_company_id ");
		sql.append("		AND m1.vat_plat_flow_master_id = v1.vat_plat_flow_master_id ");
		sql.append("		AND m1.vat_status = '20' ");
		sql.append("		AND v1.vat_status = '20' ");
		sql.append("		AND c1.seq_id = v1.vat_company_id ");
		sql.append("		AND v1.vat_company_id = ? ");
		sql.append("		AND m1.if_special_case = '1' ");
		sql.append("	) > 0 THEN ");
		sql.append("		c.seq_id = m.special_client_id ");
		sql.append("	ELSE ");
		sql.append("		1 = 1 ");
		sql.append("	END ");
		sql.append(") ");
		sql.append("AND c.seq_id = v.vat_company_id ");
		sql.append("AND v.vat_company_id = ? ");
		args.add(pulishCompanyId);
		args.add(pulishCompanyId);
		List<VatflowdetailVo> list = pageQuery.list(sql.toString(),args,VatflowdetailVo.class);
		return ObjectUtils.isEmpty(list) ? null : list;	
	}

	@Override
	public List<VatflowdetailVo> queryTaxRate(VatflowmasterQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT");
		sql.append("	t.vat_flow_master_id,");
		sql.append("	t.vat_flow_master_name,");
		sql.append("	d.vat_rate_chose,");
		sql.append("	d.vat_standard_rate,");
		sql.append("	d.vat_policy_rate,");
		sql.append("	d.vat_acc_type ");
		sql.append("FROM");
		sql.append("	vatflowmaster t, vatflowdetail d ");
		sql.append("WHERE t.vat_flow_master_id = d.vat_flow_master_id ");
		sql.append("	AND d.if_begin = 'Y' ");
		sql.append("	AND	t.platform_id = ? ");
		sql.append("	AND t.vat_company_id = ? ");
		sql.append("	AND t.vat_status = '20'");
		args.add(vo.getPlatformId());
		args.add(vo.getVatCompanyId());
		List<VatflowdetailVo> list = pageQuery.list(sql.toString(),args,VatflowdetailVo.class);
		return ObjectUtils.isEmpty(list) ? null : list;	
	};
}
