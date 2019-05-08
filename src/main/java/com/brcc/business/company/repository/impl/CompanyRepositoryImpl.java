package com.brcc.business.company.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.brcc.business.company.repository.ICompanyRepositiry;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.oilManager.vo.OilManagerQueryVo;
import com.brcc.business.oilManager.vo.OilManagerVo;
import com.esteel.common.dao.PageQuery;

/**
 * @Description: 委托方公司数据操作  
 * @Auther: gemaochao
 * @Date:Created in 16:24 2018/11/1
 */
public class CompanyRepositoryImpl implements ICompanyRepositiry {

    @Autowired
    PageQuery pageQuery;
    @Override
    public Page<CreditConfigAddCompanyVo> creditCompany(CreditConfigQueryVo creditConfigQueryVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer(" SELECT c.seq_id as 'queryKey',c.company_name as 'queryValue' FROM company c  ");
        sql.append("    where c.if_publish='Y' and IFNULL(c.if_part_plat_admin,'N')='N'");
        sql.append("    and c.platform_id = ?");
        arg.add(creditConfigQueryVo.getPlatformId());
        if (!StringUtils.isEmpty(creditConfigQueryVo.getCompanyId())) {
            sql.append("   and  c.create_company_id= ?");
            arg.add(creditConfigQueryVo.getCompanyId());
        }
        if (!StringUtils.isEmpty(creditConfigQueryVo.getQueryValue())){
            sql.append("    and c.company_name like ?");
            arg.add("%"+creditConfigQueryVo.getQueryValue()+"%");
        }
        return pageQuery.query(sql.toString(),arg,creditConfigQueryVo,CreditConfigAddCompanyVo.class);
    }

    @Override
    public Page<CompanyVo> findPersonTeam(CompanySearchVo vo) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t2.team_id AS queryKey, ");
        sql.append("  CONCAT( ");
        sql.append("    t.company_name, ");
        sql.append("    ' ，手机号：', ");
        sql.append("    t.contact_mobile, ");
        sql.append("    ' ，车牌号：', ");
        sql.append("    IFNULL( ");
        sql.append("      (SELECT ");
        sql.append("        v.vehicle_num ");
        sql.append("      FROM ");
        sql.append("        Vehicle v ");
        sql.append("      WHERE v.vehicle_id = t1.vehicle_id), ");
        sql.append("      '' ");
        sql.append("    ) ");
        sql.append("  ) AS queryValue ");
        sql.append("FROM ");
        sql.append("  Company t, ");
        sql.append("  TeamCompany t2, ");
        sql.append("  LoginVerify t1 ");
        sql.append("WHERE 1 = 1 ");
        sql.append("  AND t.status = '20' ");
        sql.append("  AND t.seq_id = t1.company_id ");
        sql.append("  AND t1.if_admin = 'Y' ");
        sql.append("  AND t.seq_id = t2.cy_company_id ");
        sql.append("  AND t2.fd_company_id = ? ");
        sql.append("  AND t2.platform_id = t.platform_id ");
        sql.append("  AND t2.if_system = 'Y' ");
        sql.append("  AND t1.user_type = 'GR' ");
        sql.append("  AND t.platform_id = ? ");

        List<Object> arg = new ArrayList<>();
        arg.add(vo.getParentCompanyId());
        arg.add(vo.getPlatformId());

        // 货源单
        if (!ObjectUtils.isEmpty(vo.getQueryValue())){
            sql.append(" AND CONCAT(t.company_name,t.contact_mobile,ifnull((select t2.vehicle_num from Vehicle t2 where t2.vehicle_id = t1.vehicle_id),'')) like CONCAT('%' , ? ,'%') ");
            arg.add(vo.getQueryValue());
        }

        return pageQuery.query(sql.toString(), arg, vo, CompanyVo.class);
    }

	@Override
	public CompanyVo findDriverFdrBlack(CompanySearchVo companySearchVo) {
        StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	count(1) as count,");
		sql.append("	c.contact_mobile,");
		sql.append("	c.company_name ");
		sql.append("FROM ");
		sql.append("	blackfdrfordriver b LEFT JOIN goodsorderm m ");
		sql.append("	ON(b.platform_id = m.platform_id AND m.company_id = b.fd_company_id) ");
		sql.append("	LEFT JOIN company c ON (b.platform_id = c.platform_id AND c.seq_id = b.fd_company_id) ");
		sql.append("WHERE  ");
		sql.append("	b.platform_id = ? ");
		sql.append("	AND m.publish_id = ? ");
		sql.append("	AND b.cy_company_id = ? ");
		sql.append("	AND b.`status`='20'  ");
		args.add(companySearchVo.getPlatformId());
		args.add(companySearchVo.getPublishId());
		args.add(companySearchVo.getCompanyId());
		List<CompanyVo> list = pageQuery.list(sql.toString(), args, CompanyVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public CompanyVo queryGrabMoney(Long publishId, String platformId) {
		StringBuffer sql = new StringBuffer();
        List<Object> args = new ArrayList<>();
        sql.append("SELECT ");
        sql.append("    IF(IFNULL(s.switch_value, '0') = '1',");
        sql.append("        IF(c.if_grab_money = 'Y', 'Y', 'N'),");
        sql.append("        'N') AS ifGrabMoney,");
        sql.append("    IFNULL(c.grab_money, 0) AS grabMoney ");
        sql.append("FROM");
        sql.append("    apptms.goodsorderm g ");
        sql.append("LEFT JOIN ");
        sql.append("    apptms.company c ON (g.company_id = c.seq_id) ");
        sql.append("LEFT JOIN ");
        sql.append("    apptms.switchconfig s ON (c.platform_id = s.plat_form_id");
        sql.append("    and s.switch_type = 'DS_GRAB_MONEY') ");
        sql.append("WHERE 1=1 ");
        sql.append("    and g.publish_id = ? ");
        sql.append("    and g.platform_id = ? ");
        args.add(publishId);
        args.add(platformId);
        List<CompanyVo> list = pageQuery.list(sql.toString(), args, CompanyVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}


    @Override
    public Page<CompanyVo> queryCompanyForSalesman(CompanySearchVo vo) {
        StringBuilder sql = new StringBuilder();
        List<Object> arg = new ArrayList<>();
        sql.append("     SELECT c.seq_id as queryKey,c.company_name as queryValue " );
        sql.append("   		  FROM company c " );
        sql.append("   		  WHERE 1=1 " );
        sql.append("   			  and c.platform_id= ? ");
        arg.add(vo.getPlatformId());
        sql.append("   			  and  c.if_publish='Y' " );
        if (!StringUtils.isEmpty(vo.getQueryValue())){
            sql.append("    and c.company_name like ?");
            arg.add("%"+vo.getQueryValue()+"%");
        }
        return pageQuery.query(sql.toString(),arg,vo,CompanyVo.class);
    }
    
    @Override
    public  Page<OilManagerVo> findIfVirtualCompany(OilManagerQueryVo vo){
    	StringBuilder sql = new StringBuilder();
    	 List<Object> args = new ArrayList<>();
    	 sql.append("select t.company_name, ");
    	 sql.append("t.seq_id, ");
    	 sql.append("t.contact_name, ");
    	 sql.append("t.contact_mobile, ");
    	 sql.append("t.platform_id, ");
    	 sql.append(" ifnull(t.if_virtual_company,'0') as ifVirtualCompany, ");
    	 sql.append("t.create_date ");
    	 sql.append(" FROM company t where 1=1 AND t.platform_id =?  ");
    	 args.add(vo.getPlatformId());
    	 sql.append(" and t.if_publish ='Y' ");
    	 sql.append(" and t.if_invoice_company !='1' ");
    	 sql.append("  and t.if_tax_transport ='Y' ");
    	 if (!StringUtils.isEmpty(vo.getIfVirtualCompany())){
             sql.append("   and t.if_virtual_company = ? ");
             args.add(vo.getIfVirtualCompany());
         }
    	 if(vo.getRqStart() !=null) {
    		 sql.append(" and t.create_date >= ? ");
    		 args.add(vo.getRqStart());
    	 }
    	 if(vo.getRqStart() !=null) {
    		 sql.append(" and t.create_date <= ? ");  		
    		 args.add(vo.getRqEnd());
    	 }
    	 if(!StringUtils.isEmpty(vo.getCompanyName())) {
    		 sql.append(" and t.company_name like ?");
    		 args.add("%" + vo.getCompanyName()+ "%");
    	 }
    	 return pageQuery.query(sql.toString(),args,vo,OilManagerVo.class);
    }
}
