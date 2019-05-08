package com.brcc.business.vatcompanyRechargeBusiness.repository;

import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;

import java.util.List;

/**
 * @Description:委托业务充值申请表
 * @Auther: gemaochao
 * @Date:Created in 11:02 2018/11/14
 */
public interface IVatcompanyRechargeBusinessRepository {

    /**
     * @Description  查询业务分离公司充值承运公司信息
     * @Param [clientId, platformId]
     * @return java.util.List<com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo>
     **/
    List<CompanyNameQueryVo> queryCompanyName(Long clientId,String platformId);
}
