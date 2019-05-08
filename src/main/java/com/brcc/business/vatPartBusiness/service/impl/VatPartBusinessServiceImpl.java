package com.brcc.business.vatPartBusiness.service.impl;

import com.brcc.business.vatPartBusiness.entity.VatPartBusinessEntity;
import com.brcc.business.vatPartBusiness.repository.VatPartBusinessRepository;
import com.brcc.business.vatPartBusiness.service.VatPartBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 业务分离配置
 * @Auther: gemaochao
 * @Date:Created in 10:44 2018/11/14
 */
@Service
public class VatPartBusinessServiceImpl implements VatPartBusinessService {

    @Autowired
    VatPartBusinessRepository vatPartBusinessRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public VatPartBusinessEntity findByPlatformIdAndCompanyId(String platformId, Long clientId) {

        logger.info("find by platformId and companyId ,platformId:{},companyId:{}",platformId,clientId);

        return vatPartBusinessRepository.findByPlatformIdAndCompanyId(platformId,clientId);
    }
}
