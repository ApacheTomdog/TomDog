package com.brcc.business.reinvoiceRateConfig.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import com.brcc.business.reinvoiceRateConfig.repository.IReinvoiceRateConfigRepository;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateCompanyNameVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigQueryVo;
import com.brcc.business.reinvoiceRateConfig.vo.ReinvoiceRateConfigVo;
import com.esteel.common.dao.PageQuery;

public class ReinvoiceRateConfigRepositoryImpl implements IReinvoiceRateConfigRepository{
	
	@Autowired
    PageQuery pageQuery;

	@Override
	public Page<ReinvoiceRateConfigVo> ReinvoiceRateConfigPage(ReinvoiceRateConfigQueryVo vo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select s.* from reinvoice_rate_config s where 1=1 ");
		if(!StringUtils.isEmpty(vo.getCompanyName())) {
			sql.append(" and s.company_name like CONCAT('%', ? ,'%') ");
			params.add(vo.getCompanyName());
		}
		sql.append(" order by s.create_date desc ");
		return pageQuery.query(sql.toString(), params, vo, ReinvoiceRateConfigVo.class);
	}

	@Override
	public Page<ReinvoiceRateCompanyNameVo> queryCompanyNameList(ReinvoiceRateCompanyNameQueryVo vo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select t.seq_id as companyId,t.company_name as companyName from company t ");
		sql.append(" where t.if_invoice_company = '1' ");
		sql.append(" and t.platform_id =? ");
		params.add(vo.getPlatformId());
		if(!StringUtils.isEmpty(vo.getCompanyName())) {
			sql.append(" and t.company_name like CONCAT('%', ? ,'%') ");
			params.add(vo.getCompanyName());
		}
		return pageQuery.query(sql.toString(), params, vo, ReinvoiceRateCompanyNameVo.class);
	}
}
