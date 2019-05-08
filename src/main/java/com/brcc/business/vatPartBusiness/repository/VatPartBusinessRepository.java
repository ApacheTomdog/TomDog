package com.brcc.business.vatPartBusiness.repository;

import com.brcc.business.vatPartBusiness.entity.VatPartBusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 业务分离配置
 * @Auther: gemaochao
 * @Date:Created in 10:41 2018/11/14
 */
public interface VatPartBusinessRepository extends JpaRepository<VatPartBusinessEntity,Long>,IVatPartBusinessRepository {

    
    /**
     * @Description  查询公司是否业务分离
     * @Param [platformId, clientId]
     * @return com.brcc.business.vatPartBusiness.entity.VatPartBusinessEntity
     **/
    VatPartBusinessEntity findByPlatformIdAndCompanyId(String platformId,Long clientId);
}