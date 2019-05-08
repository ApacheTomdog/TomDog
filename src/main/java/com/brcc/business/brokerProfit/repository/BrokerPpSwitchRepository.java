package com.brcc.business.brokerProfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brcc.business.brokerProfit.entity.BrokerPpSwitchEntity;

/**
 * 经纪人分润支付开关数据查询
 * @author TangYong
 * @date 2019-02-13
 */
@Repository
public interface BrokerPpSwitchRepository extends JpaRepository<BrokerPpSwitchEntity, Long> {

	/**查询经纪人调度分润情况*/
	@Query(value="select count(1) from broker_pp_switch where broker_id = ? and if_profit_control = 0 and tbl_status = '20'",nativeQuery=true)
	Integer queryIfProfitControl(Long brokerId);
	
	BrokerPpSwitchEntity findByBrokerIdAndTblStatus(Long companyId, String status);

}
