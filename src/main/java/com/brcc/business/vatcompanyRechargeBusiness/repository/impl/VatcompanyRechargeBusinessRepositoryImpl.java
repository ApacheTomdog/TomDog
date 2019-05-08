package com.brcc.business.vatcompanyRechargeBusiness.repository.impl;

import com.brcc.business.vatcompanyRechargeBusiness.repository.IVatcompanyRechargeBusinessRepository;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:02 2018/11/14
 */
public class VatcompanyRechargeBusinessRepositoryImpl implements IVatcompanyRechargeBusinessRepository {

    @Autowired
    PageQuery pageQuery;


    @Override
    public List<CompanyNameQueryVo> queryCompanyName(Long clientId, String platformId) {
        List<Object> arg = new ArrayList<>();
        StringBuffer sql = new StringBuffer("SELECT    a.id ,a.client_id,a.client_name, a.business_num,a.carry_name,a.carry_id,a.surplus_amount,    a.create_remark");
        sql.append("    FROM     vatcompany_recharge_business a    WHERE     a.client_id = ?");
        arg.add(clientId);
        sql.append("     AND a.platform_id =?");
        arg.add(platformId);
        sql.append("    AND a.`status` = '30'    AND a.surplus_amount > 0");

        return pageQuery.list(sql.toString(),arg,CompanyNameQueryVo.class);
    }
}
