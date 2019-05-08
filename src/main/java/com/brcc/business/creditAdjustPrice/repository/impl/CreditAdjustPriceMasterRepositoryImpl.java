package com.brcc.business.creditAdjustPrice.repository.impl;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.repository.ICreditAdjustPriceMasterRepository;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.esteel.common.dao.PageQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 授信调价配置数据操作类
 * @Auther: gemaochao
 * @Date:Created in 17:43 2018/11/3
 */
public class CreditAdjustPriceMasterRepositoryImpl implements ICreditAdjustPriceMasterRepository {

    @Autowired
    PageQuery pageQuery;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Page<CreditAdjustPriceMasterEntity> showCreditAdjustMaster(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT    *  from credit_adjust_price_master   where credit_plat_company_id = ?");
        arg.add(creditAdjustPriceQuerySearchVo.getCreditPlatCompanyId());
        sql.append("    AND  platform_id = ?");
        arg.add(creditAdjustPriceQuerySearchVo.getPlatformId());
        if (!(StringUtils.isEmpty(creditAdjustPriceQuerySearchVo.getPublishCompanyName()))){
            sql.append("    AND publish_company_name like ?");
            arg.add("%"+ creditAdjustPriceQuerySearchVo.getPublishCompanyName()+"%");
        }
        if (!(StringUtils.isEmpty(creditAdjustPriceQuerySearchVo.getAdjPriceStatus()))){
            sql.append("    AND adj_price_status = ?");
            arg.add(creditAdjustPriceQuerySearchVo.getAdjPriceStatus());
        }
        if (creditAdjustPriceQuerySearchVo.getCreateStartDate() != null){
            sql.append("    and create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            arg.add(creditAdjustPriceQuerySearchVo.getCreateStartDate());
        }
        if (creditAdjustPriceQuerySearchVo.getCreateEndDate() != null){
            sql.append("    and create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(creditAdjustPriceQuerySearchVo.getCreateEndDate());
        }
        return pageQuery.query(sql.toString(),arg, creditAdjustPriceQuerySearchVo,CreditAdjustPriceMasterEntity.class);
    }
    
    @Override
    public List<CreditAdjustPriceMasterEntity> queryCreditAdjustPriceList(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT     c.adj_price_style ,c.cred_adj_m_id from credit_adjust_price_master c,company z");
        sql.append(" where 1=1");
        sql.append(" AND  c.adj_price_status = '90'");
        if (!(StringUtils.isEmpty(creditAdjustPriceQuerySearchVo.getPublishCompanyId()))){
            sql.append("    AND publish_company_id = ?");
            arg.add(creditAdjustPriceQuerySearchVo.getPublishCompanyId());
        }
        sql.append(" AND  c.platform_id = ?");
        arg.add(creditAdjustPriceQuerySearchVo.getPlatformId());
        sql.append(" and c.credit_plat_company_id=z.create_company_id"); 
        sql.append(" and c.publish_company_id=z.seq_id"); 
        return pageQuery.list(sql.toString(),arg,CreditAdjustPriceMasterEntity.class);
    }
}
