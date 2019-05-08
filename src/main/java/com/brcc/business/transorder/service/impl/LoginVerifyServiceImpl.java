package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.LoginverifyEntity;
import com.brcc.business.transorder.repository.LoginVerifyRepository;
import com.brcc.business.transorder.service.LoginVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-12-04 18:32
 */
@Service
public class LoginVerifyServiceImpl implements LoginVerifyService {

    @Autowired
    private LoginVerifyRepository loginVerifyRepository;

    @Override
    public List<LoginverifyEntity> checkCYRStatus(Long driverId, String platformId) {
        return loginVerifyRepository.checkCYRStatus(driverId, platformId);
    }

    @Override
    public Long checkCYRVehicleStatus(Long vehicleId, String platformId) {
        return loginVerifyRepository.checkCYRVehicleStatus(vehicleId, platformId);
    }

    @Override
    public LoginverifyEntity findInfo(Long teamId) {
        return loginVerifyRepository.findInfo(teamId);
    }
}