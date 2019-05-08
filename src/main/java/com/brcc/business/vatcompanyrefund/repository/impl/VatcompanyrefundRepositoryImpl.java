package com.brcc.business.vatcompanyrefund.repository.impl;

import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;
import com.brcc.business.vatcompanyrefund.repository.IVatcompanyrefundRepository;
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
 * @Date:Created in 10:07 2018/11/16
 */
public class VatcompanyrefundRepositoryImpl implements IVatcompanyrefundRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<VatcompanyrefundEntity> queryRefund(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   SELECT * " );
        sql.append("   		FROM vatcompanyrefund t" );
        sql.append("   		WHERE 1=1" );
        sql.append("   		and t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		and	t.carry_id =?" );
        arg.add(vo.getClientId());
        if (!(StringUtils.isEmpty(vo.getRefundStatus()))){
            sql.append("   	and		t.refund_status=?" );
            arg.add(vo.getRefundStatus());
        }
        if (!(StringUtils.isEmpty(vo.getCarryName()))) {
            sql.append("   	and		t.carry_name like ? ");
            arg.add("%"+vo.getCarryName()+"%");
        }
        if (vo.getModifyStart() != null){
            sql.append("    and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            arg.add(vo.getModifyStart());
        }
        if (vo.getModifyEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getModifyEnd());
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcompanyrefundEntity.class);
    }

    @Override
    public Page<VatcompanyrefundEntity> queryForClient(VatCompanyRefundQueryVo vo) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("   ");
        sql.append("   SELECT" );
        sql.append("   	*" );
        sql.append("   		FROM vatcompanyrefund t" );
        sql.append("   		WHERE " );
        sql.append("   		 t.platform_id =?" );
        arg.add(vo.getPlatformId());
        sql.append("   		AND	t.carry_id =?" );
        arg.add(vo.getCarryId());
        if (!StringUtils.isEmpty(vo.getRefundStatus())) {
            sql.append("   	     AND   t.refund_status=?");
            arg.add(vo.getRefundStatus());
        }
        if (!StringUtils.isEmpty(vo.getClientName())) {
            sql.append("   	      AND t.client_name like ?");
            arg.add("%"+vo.getClientName()+"%");
        }
        if (vo.getModifyStart() != null){
            sql.append("    and t.create_date >= DATE_FORMAT(?,'%Y-%m-%d 00:00:00') ");
            arg.add(vo.getModifyStart());
        }
        if (vo.getModifyEnd() != null){
            sql.append("    and t.create_date <= DATE_FORMAT(?,'%Y-%m-%d 23:59:59')");
            arg.add(vo.getModifyEnd());
        }
        return pageQuery.query(sql.toString(),arg,vo,VatcompanyrefundEntity.class);
    }
}


