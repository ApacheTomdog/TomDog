package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.OperateconfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 15:10
 */
@Repository
public interface OperateConfigRepository extends JpaRepository<OperateconfigEntity,Long> {

    /**
     * 根据delivery_id查询记录
     * @param deliveryId
     * @return
     */
    @Query(value="SELECT oc.times AS times,oc.publish_company_name as publishCompanyName FROM transportationdelivery t, goodsorderm g, operateconfig oc WHERE t.publish_id = g.publish_id AND t.publish_company_id = oc.publish_company_id AND g.from_type = oc.from_type AND g.logistics_mark = oc.logistics_mark AND oc.oc_status = '20' and oc.type = '02' AND t.delivery_id = ? LIMIT 1",nativeQuery=true)
    OperateconfigEntity queryIntervalTime(String deliveryId);
}