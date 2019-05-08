/**
 * 
 */
package com.brcc.business.flow.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.flow.entity.VatplatflowmasterEntity;
import com.brcc.business.flow.repository.IVatplatflowmasterRepository;
import com.brcc.business.flow.vo.VatplatflowmasterQueryVo;
import com.brcc.business.util.QueryKeyValue;
import com.esteel.common.dao.PageQuery;

/**
 * @Description:
 * @author:陈利
 * @date:2018年11月14日
 * 
 */
public class VatplatflowmasterRepositoryImpl implements IVatplatflowmasterRepository {

    @Autowired
    PageQuery pageQuery;

    
    @Autowired
    MybatisQuery mybatisQuery;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<VatplatflowmasterEntity> searchVatplatflowmaster(VatplatflowmasterQueryVo vatplatflowmasterQueryVo){

        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select t.* from vatplatflowmaster t");
       
        sql.append(" where platform_id = ? ");
        arg.add(vatplatflowmasterQueryVo.getPlatformId());
        
        sql.append(" and vat_company_id = ? ");
        arg.add(vatplatflowmasterQueryVo.getVatCompanyId());
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getVatStatus())) {
			 sql.append(" and vat_status = ? ");
			 arg.add(vatplatflowmasterQueryVo.getVatStatus());
		}
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getIfSpecialCase())) {
			 sql.append(" and if_special_case = ? ");
			 arg.add(vatplatflowmasterQueryVo.getIfSpecialCase());
		}
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getSpecialClientName())) {
			 sql.append(" and special_client_name like ? ");
			 arg.add("%" + vatplatflowmasterQueryVo.getSpecialClientName() + "%");
		}
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getVatPlatFlowMasterName())) {
			 sql.append(" and vat_plat_flow_master_name like ? ");
			 arg.add("%" + vatplatflowmasterQueryVo.getVatPlatFlowMasterName() + "%");
		}
        
        sql.append(" order by create_date desc ");
        
        logger.info("sql:{},arg:{}",sql,arg);
        
        return pageQuery.query(sql.toString(),arg,vatplatflowmasterQueryVo,VatplatflowmasterEntity.class);
         
    }

	@Override
	public Page<QueryKeyValue> searchSpecialClient(VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {
		
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select t.seq_id as 'queryKey',concat(t.company_name,'/',l.login_name) as 'queryValue' "
        		+ " from company t,loginverify l where t.seq_id = l.company_id "
        		+ " and t.platform_id = l.platform_id and t.if_tax_transport='Y' and l.if_admin='Y' ");
       
        sql.append(" and t.platform_id = ? ");
        arg.add(vatplatflowmasterQueryVo.getPlatformId());
        
        sql.append(" and t.create_company_id = ? ");
        arg.add(vatplatflowmasterQueryVo.getVatCompanyId());
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getSpecialClientName())) {
			 sql.append(" and t.company_name like ? ");
			 arg.add("%" + vatplatflowmasterQueryVo.getSpecialClientName() + "%");
		}
        
        logger.info("sql:{},arg:{}",sql,arg.toString());
        
        return pageQuery.query(sql.toString(),arg,vatplatflowmasterQueryVo,QueryKeyValue.class);
	}

	@Override
	public void proVatPlatFlow(HashMap<String, Object> proMap) {
		
		mybatisQuery.executePro("flow.proVatPlatFlow", proMap);
		
	}

	@Override
	public List<QueryKeyValue> searchInvoiceCompany(VatplatflowmasterQueryVo vatplatflowmasterQueryVo) {
		
		List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer(" select t.seq_id as 'queryKey',t.company_name as 'queryValue' "
        		+ " from company t where t.if_invoice_company = '1' ");
       
        sql.append(" and t.platform_id = ? ");
        arg.add(vatplatflowmasterQueryVo.getPlatformId());
        
        sql.append(" and t.seq_id != ? ");
        arg.add(vatplatflowmasterQueryVo.getVatCompanyId());
        
        if(!ObjectUtils.isEmpty(vatplatflowmasterQueryVo.getSpecialClientName())) {
			 sql.append(" and t.company_name like ? ");
			 arg.add("%" + vatplatflowmasterQueryVo.getSpecialClientName() + "%");
		}
        
        logger.info("sql:{},arg:{}",sql,arg.toString());
		
		return pageQuery.list(sql.toString(), arg, QueryKeyValue.class);
		
	}
}
