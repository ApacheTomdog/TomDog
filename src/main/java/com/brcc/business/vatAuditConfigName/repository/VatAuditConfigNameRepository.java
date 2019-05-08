package com.brcc.business.vatAuditConfigName.repository;

import com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 17:26 2018/11/14
 */
public interface VatAuditConfigNameRepository extends JpaRepository<VatAuditConfigNameEntity,Long>,IVatAuditConfigNameRepository {


    /**
     * @Description  查询 vat_audit_name,
     * 		vat_director_name,
     * @Param [companyId]
     * @return com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity
     **/
    @Query(value = "select * from vat_audit_config_name a where a.vat_company_id=?1 and a.vat_status='20'",nativeQuery = true)
    VatAuditConfigNameEntity queryAudName(Long companyId);
}