package com.brcc.business.vatcompanyRechargeBusiness.service;

import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:10 2018/11/14
 */
public interface VatcompanyRechargeBusinessService {

    /**
     * @Description  查询业务分离公司充值承运公司信息
     * @Param [clientId, platformId]
     * @return java.util.List<com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo>
     **/
    List<CompanyNameQueryVo> queryCompanyName(Long clientId, String platformId);

    VatcompanyRechargeBusinessEntity findByPlatformIdAndBusinessNum(String platformId, String businessNum);

    VatcompanyRechargeBusinessEntity save(VatcompanyRechargeBusinessEntity vo);

    /**
     * @Description  更新状态
     * @Param [businessNum, platformId]
     * @return com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity
     **/
    VatcompanyRechargeBusinessEntity updateStatus(String businessNum,String platformId);
}
