package com.brcc.business.priceClientRate.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import com.brcc.business.priceClientRate.repository.IPriceClientRateRepository;
import com.brcc.business.priceClientRate.vo.PriceClientRateQueryVo;
import com.brcc.business.priceClientRate.vo.PriceClientRateVo;
import com.brcc.business.priceClientRate.vo.QueryCompanyVo;
import com.esteel.common.dao.PageQuery;

public class PriceClientRateRepositoryImpl implements IPriceClientRateRepository{

	@Autowired
	PageQuery pageQuery;

	@Override
	public Page<PriceClientRateVo> listDataPage(PriceClientRateQueryVo queryvo) {
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append(" SELECT ");
		sql.append(" price_client_rate_id, ");
		sql.append(" platform_id, ");
		sql.append(" client_id, ");
		sql.append(" client_name, ");
		sql.append(" carry_id, ");
		sql.append(" carry_name, ");
		sql.append(" client_rate, ");
		sql.append(" client_rate_type, ");
		sql.append(" date_format(create_date,\"%Y-%m-%d %H:%i:%s\") as create_date, ");
		sql.append(" create_person_id, ");
		sql.append(" create_person_name, ");
		sql.append(" date_format(modify_date,\"%Y-%m-%d %H:%i:%s\") as modify_date,");
		sql.append(" modify_person_id, ");
		sql.append(" modify_person_name ");
		sql.append(" from price_client_rate ");
		sql.append(" where 1=1 ");
		sql.append(" AND platform_id = ? ");
		params.add(queryvo.getPlatformId());
		sql.append(" AND carry_id = ? ");
		params.add(queryvo.getCarryId());

		if (!StringUtils.isEmpty(queryvo.getClientName())) {
			sql.append(" and client_name like  ? ");
			params.add("%" + queryvo.getClientName() + "%");
		}
		sql.append("order by create_date desc ");
		
		Page<PriceClientRateVo> page = pageQuery.query(sql.toString(), params, queryvo, PriceClientRateVo.class);
		return page;
	}

	@Override
	public Page<QueryCompanyVo> queryCompanyName(PriceClientRateQueryVo queryVo) {
		List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer(" select t.seq_id as \"queryKey\",");
        sql.append("    CONCAT(t.company_name,'/',l.login_name) as \"queryValue\"");
        sql.append("    from apptms.company t,loginverify l");
        sql.append("    where");
        sql.append("    t.if_tax_transport= 'Y' ");
        sql.append("    and t.seq_id =l.company_id ");
        sql.append("    and l.platform_id = t.platform_id ");
        sql.append("    and l.if_admin = 'Y' ");
        sql.append("    and t.create_company_id= ?");
        arg.add(queryVo.getClientId());
        
        if (!(StringUtils.isEmpty(queryVo.getClientName()))){
            sql.append(" and t.company_name like ?");
            arg.add("%"+queryVo.getClientName()+"%");
        }
        Page<QueryCompanyVo> page=pageQuery.query(sql.toString(), arg,queryVo, QueryCompanyVo.class);
        return page;
	}

}
