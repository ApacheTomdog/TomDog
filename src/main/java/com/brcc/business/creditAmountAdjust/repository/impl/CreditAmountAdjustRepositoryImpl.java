package com.brcc.business.creditAmountAdjust.repository.impl;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.repository.ICreditAmountAdjustRepository;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.esteel.common.dao.PageQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 委托方授信明细数据操作类
 * @Auther: gemaochao
 * @Date:Created in 20:43 2018/11/1
 */
public class CreditAmountAdjustRepositoryImpl implements ICreditAmountAdjustRepository {

    @Autowired
    PageQuery pageQuery;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo) {

        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select t.* from credit_amount_adjust t");
        sql.append("    where t.platform_id =?");
        arg.add(creditConfigQueryVo.getPlatformId());
        sql.append("    AND t.credit_plat_company_id = ?");
        arg.add(creditConfigQueryVo.getCreditPlatCompanyId());
        sql.append("    AND t.credit_config_id = ?");
        arg.add(creditConfigQueryVo.getCreditConfigId());
        logger.info("sql:{},arg:{}",sql,arg);
        return pageQuery.query(sql.toString(),arg,creditConfigQueryVo,CreditAmountAdjustEntity.class);
    }


	@Override
	public Page<CreditAmountAdjustEntity> searchCreditAmountAdjust(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from credit_amount_adjust where ");

		sql.append(" credit_plat_company_id = ? ");
		params.add(creditAmountAdjustQueryVo.getCompanyId());

		sql.append(" and platform_id = ? ");
		params.add(creditAmountAdjustQueryVo.getPlatformId());

		if(!ObjectUtils.isEmpty(creditAmountAdjustQueryVo.getCreditStatus())) {
			 sql.append(" and credit_adj_status = ? ");
			 params.add(creditAmountAdjustQueryVo.getCreditStatus());
		}

		if(!ObjectUtils.isEmpty(creditAmountAdjustQueryVo.getClientName())) {
			 sql.append(" and publish_company_name like ? ");
			 params.add("%" + creditAmountAdjustQueryVo.getClientName() + "%");
		}
		
		if(creditAmountAdjustQueryVo.getCreditStatusRange() != null) {
			
			if(creditAmountAdjustQueryVo.getCreditStatusRange().length == 0) {
				sql.append(" and credit_adj_status in ('10','90','00') ");
			}else{
				String creditStatusSql = "(";
				for(int i=0;i<creditAmountAdjustQueryVo.getCreditStatusRange().length;i++) {
					String creditStatusStr = creditAmountAdjustQueryVo.getCreditStatusRange()[i];
					if(i==0)
						creditStatusSql = creditStatusSql + "'" + creditStatusStr + "'";
					else
						creditStatusSql = creditStatusSql + ",'" + creditStatusStr + "'";
				}
				creditStatusSql = creditStatusSql + ")";
				
				sql.append(" and credit_adj_status in " + creditStatusSql);
			}
		}
		
		return pageQuery.query(sql.toString(),params,creditAmountAdjustQueryVo,CreditAmountAdjustEntity.class);
	}
}
