package com.brcc.business.transportSettle.service.impl;

import com.brcc.business.transportSettle.entity.ConfigOwnerLossEntity;
import com.brcc.business.transportSettle.repository.ConfigOwnerLossRepository;
import com.brcc.business.transportSettle.service.ConfigOwnerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ywb
 * @date: 2019-02-26
 */
@Transactional
@Service
public class ConfigOwnerLossServiceImpl implements ConfigOwnerLossService {

    @Autowired
    ConfigOwnerLossRepository configOwnerLossRepository;

    @Override
    public List<ConfigOwnerLossEntity> findByCompanyId(Long companyId) {
        return configOwnerLossRepository.findByOwnerCompanyIdAndConfigOwnerLossStatusAndConfigOwnerLossFlag(companyId, "20", 1);
    }
}
