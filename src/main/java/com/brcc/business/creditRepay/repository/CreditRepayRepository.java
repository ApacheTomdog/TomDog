package com.brcc.business.creditRepay.repository;

import com.brcc.business.creditRepay.entity.CreditRepayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 授信还款数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:42 2018/11/7
 */
public interface CreditRepayRepository extends JpaRepository<CreditRepayEntity,Long>,ICreditRepayRepository {

    /**
     * @Description  查询指定repayId授信还款信息
     * @Param [creditRepayId]
     * @return com.brcc.business.creditRepay.entity.CreditRepayEntity
     **/
    CreditRepayEntity findByCreditRepayId(Long creditRepayId);
}