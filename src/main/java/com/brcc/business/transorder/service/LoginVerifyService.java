package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.LoginverifyEntity;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-12-04 18:31
 */
public interface LoginVerifyService {

    List<LoginverifyEntity> checkCYRStatus(Long driverId, String platformId);

    Long checkCYRVehicleStatus(Long vehicleId, String platformId);

    LoginverifyEntity findInfo(Long teamId);
}