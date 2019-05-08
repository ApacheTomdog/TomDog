package com.brcc.business.brokerTax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.brokerTax.entity.BrokerTaxCycleEntity;
import org.springframework.data.jpa.repository.Query;

/**
 *	季度配置
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface BrokerTaxCycleRepository extends JpaRepository<BrokerTaxCycleEntity, Long>, IBrokerTaxCycleRepository{
    /**
     * @Description  查询对应季度名的周期区间
     * @Param [brokerTaxCycleName]
     * @return java.lang.String
     **/
    @Query(value = "select min(b.broker_tax_year_month) from broker_tax_cycle b where b.broker_tax_cycle_name=?1 ",nativeQuery = true)
    String getTaxCycle(String  brokerTaxCycleName);

    /**
     * @Description  查询字符串格式的日期查找对应的季度
     * @Param [brokerTaxYearMonth]
     * @return java.lang.String
     **/
    @Query(value = "select broker_tax_cycle_name from broker_tax_cycle b where b.broker_tax_year_month=?1 ",nativeQuery = true)
    String getBrokerTaxCycleName(String  brokerTaxYearMonth);
}
