package com.brcc.business.vatcompanyRechargeBusiness.service.impl;

import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import com.brcc.business.vatcompanyRechargeBusiness.repository.VatcompanyRechargeBusinessRepository;
import com.brcc.business.vatcompanyRechargeBusiness.service.VatcompanyRechargeBusinessService;
import com.brcc.business.vatcompanyRechargeBusiness.vo.CompanyNameQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:11 2018/11/14
 */
@Service
public class VatcompanyRechargeBusinessServiceImpl implements VatcompanyRechargeBusinessService {

    @Autowired
    VatcompanyRechargeBusinessRepository vatcompanyRechargeBusinessRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<CompanyNameQueryVo> queryCompanyName(Long clientId, String platformId) {
        return vatcompanyRechargeBusinessRepository.queryCompanyName(clientId,platformId);
    }

    @Override
    public VatcompanyRechargeBusinessEntity findByPlatformIdAndBusinessNum(String platformId, String businessNum) {
        return vatcompanyRechargeBusinessRepository.findByPlatformIdAndBusinessNum(platformId,businessNum);
    }

    @Override
    public VatcompanyRechargeBusinessEntity save(VatcompanyRechargeBusinessEntity vo) {
        return vatcompanyRechargeBusinessRepository.save(vo);
    }

    @Override
    public VatcompanyRechargeBusinessEntity updateStatus(String businessNum, String platformId) {

        logger.info("update status,businessNum:{},platformId:{}",businessNum,platformId);

        return vatcompanyRechargeBusinessRepository.updateStatus(businessNum,platformId);
    }
}
