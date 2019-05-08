package com.brcc.business.vatAuditConfigName.service.impl;

import com.brcc.business.vatAuditConfigName.entity.VatAuditConfigNameEntity;
import com.brcc.business.vatAuditConfigName.repository.VatAuditConfigNameRepository;
import com.brcc.business.vatAuditConfigName.service.VatAuditConfigNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 17:28 2018/11/14
 */
@Service
public class VatAuditConfigNameServiceImpl implements VatAuditConfigNameService {

    @Autowired
    VatAuditConfigNameRepository vatAuditConfigNameRepository;


    @Override
    public VatAuditConfigNameEntity queryAudName(Long companyId) {
        return vatAuditConfigNameRepository.queryAudName(companyId);
    }
}
