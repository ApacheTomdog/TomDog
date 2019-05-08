package com.brcc.business.brokerFunds.repository;
import com.brcc.business.brokerFunds.entity.BrokerFundsPayeeInfoEntity;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BrokerFundsPayeeInfoRepository extends JpaRepository<BrokerFundsPayeeInfoEntity,Long>, IBrokerFundsPayeeInfoRepository{
    /**
     * @Description  保存
     * @Param [BrokerFundsPayeeInfoEntity]
     * @return BrokerFundsPayeeInfoEntity
     **/
    BrokerFundsPayeeInfoEntity save(BrokerFundsPayeeInfoEntity entity);

    /**
     * @Description  通过流水单id和收款人id判断是否存在
     * @Param [Long fundsControlMasterId,Long companyPayeeId]
     * @return BrokerFundsPayeeInfoEntity
     **/
    BrokerFundsPayeeInfoEntity findByFundsControlMasterIdAndCompanyPayeeId(Long fundsControlMasterId,Long companyPayeeId);

    void deleteById(Long brokerFundsPayeeInfoId);

    Integer countByFundsControlMasterId(Long fundsControlMasterId);

    List<BrokerFundsPayeeInfoEntity> findByFundsControlMasterId(Long fundsControlMasterId);

    @Query(value = "select ifnull(sum(p.company_payee_amount),0) from broker_funds_payee_info p  where p.funds_control_master_id=?1",nativeQuery = true)
    BigDecimal getPayeeInfoAmount(Long fundsControlMasterId);
}
