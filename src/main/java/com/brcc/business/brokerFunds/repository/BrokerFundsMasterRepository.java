package com.brcc.business.brokerFunds.repository;

import com.brcc.business.brokerFunds.entity.BrokerfundscontrolmasterEntity;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
public interface BrokerFundsMasterRepository extends JpaRepository<BrokerfundscontrolmasterEntity,Long>, IBrokerFundsMasterRepository{
    /**
     * @Description  检测当前资金流水主表下未审核完成的流水明细
     * @Param [fundsControlMasterId]
     * @return java.lang.Long
     **/
    @Query(value = "select COUNT(1) from brokerfundscontroldetail a where  a.funds_control_master_id=?1 and a.platform_id=?2 and a.detail_status not in ('05','30')",nativeQuery = true)
    Integer queryNoFinishCount(Long fundsControlMasterId,String platformId);
}
