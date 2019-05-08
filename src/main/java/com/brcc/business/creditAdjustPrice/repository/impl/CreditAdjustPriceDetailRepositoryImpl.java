package com.brcc.business.creditAdjustPrice.repository.impl;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.repository.ICreditAdjustPriceDetailRepository;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;
import com.esteel.common.dao.PageQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 授信调价明细数据操作
 * @Auther: gemaochao
 * @Date:Created in 20:17 2018/11/3
 */
public class CreditAdjustPriceDetailRepositoryImpl implements ICreditAdjustPriceDetailRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<CreditAdjustPriceDetailEntity> findByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        StringBuffer sql = new StringBuffer("select * from credit_adjust_price_detail where cred_adj_m_id = ?");
        List<Object> arg = new ArrayList<>();
        arg.add(creditAdjustPriceQuerySearchVo.getCredAdjMId());
     return    pageQuery.query(sql.toString(),arg, creditAdjustPriceQuerySearchVo,CreditAdjustPriceDetailEntity.class);
    }

    @Override
    public List<CreditAdjustPriceDetailEntity> findListByCredAdjMId(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo) {
        StringBuffer sql = new StringBuffer("select * from credit_adjust_price_detail where cred_adj_m_id = ?");
        List<Object> arg = new ArrayList<>();
        arg.add(creditAdjustPriceQuerySearchVo.getCredAdjMId());
        return pageQuery.list(sql.toString(),arg,CreditAdjustPriceDetailEntity.class);
    }

	@Override
	public List<CreditAdjustPriceDetailVo> queryCreditAddPrice(CreditAdjustPriceDetailQueryVo priceDetailQueryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	m.publish_company_id,");
		sql.append("	m.publish_company_name,");
		sql.append("	m.adj_price_style,");
		sql.append("	d.cred_adj_d_id,");
		sql.append("	d.cred_adj_m_id,");
		sql.append("	d.min_price,");
		sql.append("	d.max_price,");
		sql.append("	d.credit_add_price,");
		sql.append("	t.credit_fd_status ");
		sql.append("FROM ");
		sql.append("	apptms.credit_config t,");
		sql.append("	apptms.credit_adjust_price_master m,");
		sql.append("	apptms.credit_adjust_price_detail d ");
		sql.append("WHERE 1=1 ");
		sql.append("AND m.cred_adj_m_id = d.cred_adj_m_id ");
		sql.append("AND t.publish_company_id = m.publish_company_id ");
		sql.append("AND t.platform_id = m.platform_id ");
		// 发货公司
		if(null != priceDetailQueryVo.getCompanyId()) {
			sql.append("AND	t.publish_company_id = ? ");
			args.add(priceDetailQueryVo.getCompanyId());
		}
		if(StringUtils.isNotEmpty(priceDetailQueryVo.getPlatformId())) {
			sql.append("AND t.platform_id = ? "); 
			args.add(priceDetailQueryVo.getPlatformId());
		}		
		if(StringUtils.isNotEmpty(priceDetailQueryVo.getCreditStatus())) {
			sql.append("AND t.credit_status = ? ");
			args.add(priceDetailQueryVo.getCreditStatus());
		}
		if(StringUtils.isNotEmpty(priceDetailQueryVo.getAdjPriceStatus())) {
			sql.append("AND m.adj_price_status = ? ");
			args.add(priceDetailQueryVo.getAdjPriceStatus());
		}
		// 调整区间
		if(null != priceDetailQueryVo.getCurPrice()) {
			sql.append("AND d.min_price  <= ? ");
			args.add(priceDetailQueryVo.getCurPrice());
			sql.append("AND d.max_price > ? ");
			args.add(priceDetailQueryVo.getCurPrice());
		}
		return pageQuery.list(sql.toString(),args,CreditAdjustPriceDetailVo.class);
	}
	
	@Override
	public List<CreditAdjustPriceDetailVo> queryCreditDetailPriceList(CreditAdjustPriceDetailQueryVo priceDetailQueryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<>();
		sql.append("SELECT ");
		sql.append("	c.adj_price_style,");
		sql.append("	d.cred_adj_d_id,");
		sql.append("	d.cred_adj_m_id,");
		sql.append("	d.min_price,");
		sql.append("	d.max_price,");
		sql.append("	d.credit_add_price");
		
		sql.append(" FROM ");
		sql.append("	apptms.company z,");
		sql.append("	apptms.credit_adjust_price_master c,");
		sql.append("	apptms.credit_adjust_price_detail d ");
		sql.append("	WHERE 1=1 ");
		sql.append("	AND c.cred_adj_m_id = d.cred_adj_m_id ");
		sql.append("	AND c.adj_price_status = '90' ");
		sql.append("	AND c.publish_company_id =? ");
		args.add(priceDetailQueryVo.getCompanyId());
		sql.append("	AND c.platform_id = ? ");
		args.add(priceDetailQueryVo.getPlatformId());
		sql.append("	AND c.credit_plat_company_id=z.create_company_id");
		sql.append("	AND c.publish_company_id=z.seq_id");
		// 调整区间
		if(null != priceDetailQueryVo.getCurPrice()) {
			sql.append(" AND d.min_price <= ? ");
			args.add(priceDetailQueryVo.getCurPrice());
			sql.append(" AND d.max_price > ? ");
			args.add(priceDetailQueryVo.getCurPrice());
		}
		return pageQuery.list(sql.toString(),args,CreditAdjustPriceDetailVo.class);
	}
	
	
}