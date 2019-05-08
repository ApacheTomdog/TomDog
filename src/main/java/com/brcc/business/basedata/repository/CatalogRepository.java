package com.brcc.business.basedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.basedata.entity.CatalogEntity;

/**
 * @Desc:    货物类型数据接口
 * @author: TangYong
 * @Date:    2018-11-19
 */
public interface CatalogRepository extends JpaRepository<CatalogEntity,Long>,ICatalogRepository {


}
