package com.brcc.business.creditAdjustPrice.repository;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 授信调价明细表数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 10:32 2018/11/5
 */
public interface CreditAdjustPriceDetailLogRepository  extends JpaRepository<CreditAdjustPriceDetailLogEntity,String>,ICreditAdjustPriceDetailLogRepository {
}