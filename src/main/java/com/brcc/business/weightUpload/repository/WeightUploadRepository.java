package com.brcc.business.weightUpload.repository;

import com.brcc.business.weightUpload.entity.UploadweightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 装卸货重量数据接口类
 *
 * @author yushaohua
 * @create 2018-11-28 16:12
 */
@Repository
public interface WeightUploadRepository extends JpaRepository<UploadweightEntity,Long>, IWeightUploadRepository {

    /**
     * 获取最大batchId
     * @return
     */
    @Query(value="SELECT * FROM uploadweight ORDER BY BATCH_ID DESC LIMIT 1", nativeQuery=true)
    UploadweightEntity queryBatchId();

    /**
     * 查询导入的单据是否有重量一直的问题
     * @return
     */
    @Query(value="SELECT * FROM uploadweight u WHERE u.publish_company_id = ? AND u.platform_id = ? AND u.create_date >= ? AND u.take_delivery_weight=? AND u.status= '20'", nativeQuery=true)
    List<UploadweightEntity> queryDelieryWeightExist(Long publishCompanyId, String platformId, Date toDay, BigDecimal finishWeight);
}