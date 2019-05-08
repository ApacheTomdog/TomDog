package com.brcc.business.capital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.capital.entity.CapitalFlowingEntity;

/**
 * @Desc:    资金流水数据接口
 * @author:  TangYong
 * @Date:    2018-12-11
 */
public interface CapitalFlowingRepository extends JpaRepository<CapitalFlowingEntity,Long>{


}
