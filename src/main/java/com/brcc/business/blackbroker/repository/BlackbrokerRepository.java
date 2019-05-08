package com.brcc.business.blackbroker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;


/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月15日 下午4:09:42
 */
public interface BlackbrokerRepository extends JpaRepository<BlackbrokerEntity, Long>,IBlackbrokerRepository {

	BlackbrokerEntity findByBlackBrokerId(Long blackBrokerId);

	/**
	 * @Desc 查询经纪人生效的黑名单配置
	 * @param companyId
	 * @param status
	 * @param platformId
	 * @return
	 * @author yangwenbin
	 * @version 创建时间：2018年12月27日 下午3:55:30
	 */
	@Query(value="SELECT " + 
			"	t.* " + 
			"FROM " + 
			"	apptms.blackbroker t " + 
			"WHERE " + 
			"	t.block_broker_status = ?2 " + 
			"AND t.broker_company_id = ?1 " + 
			"AND t.platform_id = ?3", nativeQuery=true)
	List<BlackbrokerEntity> findActivedBlackBroker(Long companyId, String status, String platformId);

}
