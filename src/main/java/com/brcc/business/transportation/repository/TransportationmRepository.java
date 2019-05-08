package com.brcc.business.transportation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.transportation.entity.TransportationmEntity;


/**
 * 运单数据交互接口
 * @author 
 * @Date: 2018-11-05
 */
public interface TransportationmRepository extends JpaRepository<TransportationmEntity,Long>,ITransportationmRepository {

	/**
	 * 根据货源单ID查找运输单
	 * @param publishId
	 * @return
	 */
	List<TransportationmEntity> findByPublishId(Long publishId);
	
	/**
	 * 查找运输单
	 */
	List<TransportationmEntity> findByPublishIdAndPlatformId(Long publishId, String platformId);

}
