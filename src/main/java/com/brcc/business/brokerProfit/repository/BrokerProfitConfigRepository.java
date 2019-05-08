package com.brcc.business.brokerProfit.repository;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.brcc.business.brokerProfit.entity.BrokerProfitConfigEntity;

/**
 * 经纪人最高分润配置操作
 * @author dzj
 * @date 2019-01-29
 */
@Repository
public interface BrokerProfitConfigRepository extends JpaRepository<BrokerProfitConfigEntity, Integer>, IBrokerProfitConfigRepository {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update BrokerProfitConfigEntity bpc "
			+ "set bpc.brokerProfitConfigStatus = '00', "
			+ "bpc.cancelDate = :modifyDate, "
			+ "bpc.cancelPersonId = :modifyPersonId, "
			+ "bpc.cancelPersonName = :modifyPersonName, "
			+ "bpc.modifyDate = :modifyDate, "
			+ "bpc.modifyPersonId = :modifyPersonId, "
			+ "bpc.modifyPersonName = :modifyPersonName "
			+ "where bpc.ifSpecialCase = '1' "
			+ "and bpc.brokerProfitConfigStatus = '20' "
			+ "and bpc.specialBrokerId = :specialBrokerId "
			+ "and bpc.brokerProfitConfigId <> :brokerProfitConfigId ")
	Integer cancelSpecial(@Param("modifyDate") Date modifyDate, @Param("modifyPersonId") Integer modifyPersonId, @Param("modifyPersonName") String modifyPersonName, @Param("specialBrokerId") Integer specialBrokerId, @Param("brokerProfitConfigId") Integer brokerProfitConfigId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update BrokerProfitConfigEntity bpc "
			+ "set bpc.brokerProfitConfigStatus = '00', " 
			+ "bpc.cancelDate = :modifyDate, "
			+ "bpc.cancelPersonId = :modifyPersonId, "
			+ "bpc.cancelPersonName = :modifyPersonName, "
			+ "bpc.modifyDate = :modifyDate, "
			+ "bpc.modifyPersonId = :modifyPersonId, "
			+ "bpc.modifyPersonName = :modifyPersonName "			
			+ "where bpc.ifSpecialCase = '0' "
			+ "and bpc.brokerProfitConfigStatus = '20' "
			+ "and bpc.brokerProfitConfigId <> :brokerProfitConfigId ")
	Integer cancelNormal(@Param("modifyDate") Date modifyDate, @Param("modifyPersonId") Integer modifyPersonId, @Param("modifyPersonName") String modifyPersonName, @Param("brokerProfitConfigId") Integer brokerProfitConfigId);

	/**查询经纪人是否是特例配置*/
	@Query(value="select * from broker_profit_config where special_broker_id = ? and broker_profit_config_status = ? and if_special_case = ?",nativeQuery=true)
	BrokerProfitConfigEntity querySpecialCase(Long specialBrokerId,String brokerProfitConfigStatus,String ifSpecialCase);

	/**查询经纪人的常规配置(平台统一)*/
	@Query(value="select * from broker_profit_config where broker_profit_config_status = '20' and if_special_case = '0'",nativeQuery=true)
	BrokerProfitConfigEntity queryNormalCase();
	
	BrokerProfitConfigEntity findBySpecialBrokerIdAndBrokerProfitConfigStatus(Long companyId, String status);
}
