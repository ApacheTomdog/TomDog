package com.brcc.business.vatcapital.repository.impl;

import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import com.brcc.business.vatcapital.repository.IVatCapitalMasterRepository;
import com.brcc.business.vatcompanyrefund.vo.VatCompanyRefundQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:42 2018/11/16
 */
public class VatCapitalMasterRepositoryImpl implements IVatCapitalMasterRepository {


    @Autowired
    PageQuery pageQuery;


    @Override
    public List<VatcapitalmasterEntity> queryCompanyName(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   SELECT" );
        sql.append("   			*" );
        sql.append("   		FROM vatcapitalmaster t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		and t.total_use_amount > 0" );
        sql.append("   		and	t.carry_id =?" );
        arg.add(vo.getCarryId());
        return pageQuery.list(sql.toString(),arg,VatcapitalmasterEntity.class);
    }

    @Override
    public List<VatcapitalmasterEntity> queryTotalInAmount(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   		SELECT" );
        sql.append("     			ROUND(ifnull(sum(t.total_in_amount),0),2) as 'totalInAmount'" );
        sql.append("   		FROM vatcapitalmaster t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		AND	t.carry_id =?" );
        arg.add(vo.getCarryId());
        if (!StringUtils.isEmpty(vo.getRefundStatus())) {
            sql.append("   	     AND   t.status=?");
            arg.add(vo.getRefundStatus());
        }
        if (!StringUtils.isEmpty(vo.getClientName())) {
            sql.append("   	      AND t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        return pageQuery.list(sql.toString(),arg,VatcapitalmasterEntity.class);
    }

    @Override
    public Page<VatcapitalmasterEntity> queryForCarry(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   		SELECT *" );
        sql.append("   		FROM vatcapitalmaster t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		AND	t.carry_id =?" );
        arg.add(vo.getCarryId());
        if (!StringUtils.isEmpty(vo.getRefundStatus())) {
            sql.append("   	     AND   t.status=?");
            arg.add(vo.getRefundStatus());
        }
        if (!StringUtils.isEmpty(vo.getClientName())) {
            sql.append("   	      AND t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcapitalmasterEntity.class);
    }

    @Override
    public Page<VatcapitalmasterEntity> queryForClient(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select *   ");
        sql.append("   		FROM vatcapitalmaster t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		AND	t.client_id =?" );
        arg.add(vo.getClientId());
        if (!StringUtils.isEmpty(vo.getRefundStatus())) {
            sql.append("   	  AND      t.status=?");
            arg.add(vo.getRefundStatus());
        }
        if (!StringUtils.isEmpty(vo.getCarryName())) {
            sql.append("   	   AND    t.carry_name like ?");
            arg.add("%"+vo.getCarryName()+"%");
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcapitalmasterEntity.class);
    }
}
