package com.brcc.business.payCalcBatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;

/**
 * 批量运费计算结果
 * @author panyinfang
 *
 */
public interface PayCalcBatchRepository extends JpaRepository<PayCalcBatchEntity,Long>,IPayCalcBatchRepository{

}
