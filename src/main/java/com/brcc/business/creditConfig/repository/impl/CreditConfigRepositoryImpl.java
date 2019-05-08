package com.brcc.business.creditConfig.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.creditConfig.entity.CreditConfigEntity;
import com.brcc.business.creditConfig.repository.ICreditConfigRepositpory;
import com.brcc.business.creditConfig.vo.CreditConfigAddCompanyVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;
import com.esteel.common.dao.PageQuery;

/**
 * @Description: 委托方授信管理数据操作实现类
 * @Auther: gemaochao
 * @Date:Created in 11:42 2018/10/31
 */
public class CreditConfigRepositoryImpl implements ICreditConfigRepositpory {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PageQuery pageQuery;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
    @Autowired
    MybatisQuery mybatisQuery;

    @Override
    public Page<CreditConfigEntity> queryCreditConfig(CreditConfigQueryVo creditConfigQueryVo) {
        logger.info("query credit config");
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT * FROM credit_config WHERE credit_plat_company_id = ?");
        arg.add(creditConfigQueryVo.getCompanyId());
        sql.append("    AND platform_id = ?");
        arg.add(creditConfigQueryVo.getPlatformId());
        //发单公司名称
        if (!(StringUtils.isEmpty(creditConfigQueryVo.getPublishCompanyName()))){
            sql.append("    and publish_company_name like ?");
            arg.add("%"+creditConfigQueryVo.getPublishCompanyName()+"%");
        }
        if (creditConfigQueryVo.getCreateStartDate() != null){
            sql.append("    and create_date>= DATE_FORMAT(?,'%Y-%m-%d 00:00:00')");
            arg.add(creditConfigQueryVo.getCreateStartDate());
        }
        if (creditConfigQueryVo.getCreateEndDate() != null){
            sql.append("    and create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(creditConfigQueryVo.getCreateEndDate());
        }
        if (!(StringUtils.isEmpty(creditConfigQueryVo.getCreditStatus()))){
            sql.append("    and credit_status = ?");
            arg.add(creditConfigQueryVo.getCreditStatus());
        }




        return pageQuery.query(sql.toString(),arg,creditConfigQueryVo,CreditConfigEntity.class);
    }


    @Override
    public Page<CreditConfigAddCompanyVo> queryAddAdjustPriceCompanyName(CreditConfigQueryVo creditConfigQueryVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT  t.publish_company_id as 'queryKey', t.publish_company_name as 'queryValue' FROM credit_config t");
        sql.append("    where  t.credit_status = '90'");
        sql.append("    and t.credit_plat_company_id = ?");
        arg.add(creditConfigQueryVo.getCreditPlatCompanyId());
        sql.append("    and t.platform_id = ?");
        arg.add(creditConfigQueryVo.getPlatformId());
        if (!(StringUtils.isEmpty(creditConfigQueryVo.getQueryValue()))){
            sql.append(" and t.publish_company_name like ?");
            arg.add("%"+creditConfigQueryVo.getQueryValue()+"%");
        }
        return pageQuery.query(sql.toString(),arg,creditConfigQueryVo,CreditConfigAddCompanyVo.class);
    }


	@Override
	public void proCreditAmountAdjust(HashMap<String, Object> procMap) {
		
		mybatisQuery.executePro("credit.proCreditAmountAdjust", procMap);
		
	}


	@Override
	public List<CreditConfigVo> queryCreditConfigList(CreditConfigQueryVo configQueryVo) {
        StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	m.publish_company_id,");
		sql.append("	m.publish_company_name,");
		sql.append("	m.adj_price_style,");
		sql.append("	t.credit_fd_status ");
		sql.append("FROM ");
		sql.append("	apptms.credit_config t,");
		sql.append("	apptms.credit_adjust_price_master m ");
		sql.append("WHERE 1=1 ");
		sql.append("AND t.publish_company_id = m.publish_company_id ");
		sql.append("AND t.platform_id = m.platform_id ");
		// 平台
		if(!StringUtils.isEmpty(configQueryVo.getPlatformId())) {
			sql.append("AND t.platform_id = ? ");
			args.add(configQueryVo.getPlatformId());
		}
		// 发单公司
		if(null != configQueryVo.getCompanyId()) {
			sql.append("AND t.publish_company_id = ? ");
			args.add(configQueryVo.getCompanyId());
		}
		// 授信状态
		if(!StringUtils.isEmpty(configQueryVo.getCreditStatus())) {
			sql.append("AND t.credit_status = '90' ");

		}
		// 调价状态
		if(!StringUtils.isEmpty(configQueryVo.getAdjPriceStatus())) {
			sql.append("AND m.adj_price_status = '90' ");

		}
		return pageQuery.list(sql.toString(), args, CreditConfigVo.class);
	}
	
	
	@Override
	public List<CreditConfigVo> queryCreditConfigStatus(CreditConfigQueryVo configQueryVo) {
        StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	c.credit_fd_status");
		sql.append("  FROM ");
		sql.append("  credit_config c,company z");
		sql.append("  WHERE 1=1 ");
		sql.append("  AND c.publish_company_id = ? ");
		args.add(configQueryVo.getPublishCompanyId());
		sql.append("  and c.credit_status = '90' ");
		// 平台
		if(!StringUtils.isEmpty(configQueryVo.getPlatformId())) {
			sql.append("  AND c.platform_id = ? ");
			args.add(configQueryVo.getPlatformId());
		}
		sql.append("  and c.credit_plat_company_id=z.create_company_id ");
		sql.append("  and c.publish_company_id=z.seq_id");
		return pageQuery.list(sql.toString(), args, CreditConfigVo.class);
	}
}
