package com.brcc.business.vatPartBusiness.service;

import com.brcc.business.vatPartBusiness.entity.VatPartBusinessEntity;

/**
 * @Description: 业务分离配置
 * @Auther: gemaochao
 * @Date:Created in 10:44 2018/11/14
 */
public interface VatPartBusinessService {

    /**
     * @Description  查询公司是否业务分离
     * @Param [platformId, clientId]
     * @return com.brcc.business.vatPartBusiness.entity.VatPartBusinessEntity
     **/
    VatPartBusinessEntity findByPlatformIdAndCompanyId(String platformId, Long clientId);

}
