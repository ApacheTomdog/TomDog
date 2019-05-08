package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.BusinessRegistrationEntity;
import com.brcc.business.dispatchorder.repository.BusinessRegistrationRepository;
import com.brcc.business.dispatchorder.service.BusinessRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-06 13:42
 */
@Service
public class BusinessRegistrationServiceImpl implements BusinessRegistrationService {

    @Autowired
    private BusinessRegistrationRepository businessRegistrationRepository;

    @Override
    public List<BusinessRegistrationEntity> findByIdNumAndPlatformId(String idNum, String platformId) {
        return businessRegistrationRepository.findByIdNumAndPlatformId(idNum, platformId);
    }

    @Override
    public List<BusinessRegistrationEntity> findByRegName(String regName) {
        return businessRegistrationRepository.findByRegName(regName);
    }

    @Override
    public int insertBusinessRegistration(String regName, String platformId, Long userId, String userName, Long driverId) {
        return businessRegistrationRepository.insertBusinessRegistration(regName, platformId, userId, userName, driverId);
    }

    @Override
    public Long findMaxRegId() {
        return businessRegistrationRepository.findMaxRegId();
    }

    @Override
    public void updateRegName(Long regId, String regName) {
        businessRegistrationRepository.updateRegName(regId, regName);
    }
}