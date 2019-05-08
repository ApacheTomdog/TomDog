package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.BusinessRegistrationEntity;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-06 13:42
 */
public interface BusinessRegistrationService {

    /**
     * 根据身份证号获取对象
     * @param regName
     * @return
     */
    List<BusinessRegistrationEntity> findByIdNumAndPlatformId(String idNum, String platformId);

    /**
     * 根据名字获取对象
     * @param regName
     * @return
     */
    List<BusinessRegistrationEntity> findByRegName(String regName);

    /**
     * 保存对象
     * @param regName
     * @param platformId
     * @param userId
     * @param userName
     * @param driverId
     */
    int insertBusinessRegistration(String regName, String platformId, Long userId, String userName, Long driverId);

    /**
     * 查询个体工商户注册表中最大的reg_id
     * @return
     */
    Long findMaxRegId();

    /**
     * 更新个体工商户注册名
     * @param regId
     * @param regName
     */
    void updateRegName(Long regId, String regName);
}