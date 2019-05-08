package com.brcc.business.transportSettle.repository;

import com.brcc.business.transportSettle.entity.ConfigOwnerLossEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ywb
 * @date 2019/2/26
 */
public interface ConfigOwnerLossRepository extends JpaRepository<ConfigOwnerLossEntity,Long> {
    List<ConfigOwnerLossEntity> findByOwnerCompanyIdAndConfigOwnerLossStatusAndConfigOwnerLossFlag(Long companyId, String status, Integer flag);
}
