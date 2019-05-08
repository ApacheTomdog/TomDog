package com.brcc.business.transportSettle.service;

import com.brcc.business.transportSettle.entity.ConfigOwnerLossEntity;

import java.util.List;

/**
 * @author: ywb
 * @date: 2019-02-26
 */
public interface ConfigOwnerLossService {

    List<ConfigOwnerLossEntity> findByCompanyId(Long companyId);
}
