package com.brcc.business.vatAuditConfigName.service;

import com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 17:28 2018/11/14
 */
public interface VatAuditConfigNameService {


    /**
     * @Description  查询 vat_audit_name,
     * 		vat_director_name,
     * @Param [companyId]
     * @return com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity
     **/
    VatAuditConfigNameEntity queryAudName(Long companyId);
}