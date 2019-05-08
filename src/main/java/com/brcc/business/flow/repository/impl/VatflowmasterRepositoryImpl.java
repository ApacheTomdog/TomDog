/**
 * 
 */
package com.brcc.business.flow.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.flow.repository.IVatflowmasterRepository;
import com.brcc.business.flow.vo.VatflowmasterVo;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.esteel.common.dao.PageQuery;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class VatflowmasterRepositoryImpl implements IVatflowmasterRepository {
	@Autowired
    PageQuery pageQuery;
	@Override
	public Page<VatflowmasterVo> findVatflowmasterByCompanyId(GoodsordermQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("v.vat_flow_master_id , ");
		sql.append("v.vat_flow_master_name , ");
		sql.append("d.vat_rate_chose , ");
		sql.append("d.vat_standard_rate , ");
		sql.append("d.vat_policy_rate, ");
		sql.append("d.vat_acc_type ");
		sql.append("FROM ");
		sql.append("apptms.company c, ");
		sql.append("apptms.vatplatflowmaster m, ");
		sql.append("apptms.vatflowmaster v, ");
		sql.append("apptms.vatflowdetail d ");
		sql.append("WHERE ");
		sql.append(" c.create_company_id = m.vat_company_id " );
		sql.append(" AND v.vat_company_id = c.seq_id " );
		sql.append(" AND m.vat_plat_flow_master_id = v.vat_plat_flow_master_id ");
		sql.append(" AND m.vat_status = '20' ");
		sql.append(" AND v.vat_status = '20' ");
		sql.append(" AND v.vat_flow_master_id = d.vat_flow_master_id ");
		sql.append(" AND d.if_begin = 'Y' ");
		//发单公司id
		if(!ObjectUtils.isEmpty(vo.getCompanyId())) {
			sql.append("AND c.seq_id = ? ");
			args.add(vo.getCompanyId());
		}
		sql.append(" order by m.if_special_case desc ");
		
		return pageQuery.query(sql.toString(), args, vo, VatflowmasterVo.class);
	}

}
