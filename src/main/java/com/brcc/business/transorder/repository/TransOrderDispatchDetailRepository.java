package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 平台运输单调度数据接口类
 *
 * @author yushaohua
 * @create 2018-11-02 10:36
 */
@Repository
public interface TransOrderDispatchDetailRepository extends JpaRepository<TransportationdeliveryEntity, Long>, ITransOrderDispatchDetailRepository {

    /**
     * 根据deliveryId、platformId获取对象
     * @param deliveryId
     * @param platformId
     * @return
     */
    TransportationdeliveryEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId);

    /**
     * 根据transId获取对象
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> findByTransId(Long transId);

    /**
     *
     * @param platformId
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM transportationdelivery t where 1=1 and t.platform_id = ? and t.trans_id = ? and t.status != '00' ", nativeQuery=true)
    List<TransportationdeliveryEntity> activeTransportBill(String platformId, Long transId);

    /**
     * 根据条件查询数据
     * @return
     */
    @Query(value="SELECT * FROM transportationdelivery t where 1=1 and t.platform_id = ? and t.trans_id = ? and t.status > '00' and t.status < '90' ", nativeQuery=true)
    List<TransportationdeliveryEntity> unCompleteTransportBill(String platformId, Long transId);

    /**
     * 根据条件查询数据
     * @return
     */
    @Query(value="SELECT * FROM transportationdelivery t where 1=1 and t.platform_id = ? and t.trans_id = ? and t.status = '90'  ", nativeQuery=true)
    List<TransportationdeliveryEntity> completedTransportBill(String platformId, Long transId);

    /**
     * 根据条件查询数据
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM transportationdelivery t WHERE t.trans_id = ? AND t.status != '00'", nativeQuery=true)
    List<TransportationdeliveryEntity> queryDeliveryInfo(Long transId);

    /**
     * 根据条件查询数据
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM transportationdelivery t where 1=1 and t.platform_id = ? and t.trans_id = ? and t.status = '30'", nativeQuery=true)
    List<TransportationdeliveryEntity> onCarTransportBill(String platformId, Long transId);

    /**
     * 作废所有调度单
     * @param platformId
     * @param transId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update TransportationDelivery a set a.status = '00' where a.platform_id = ? and a.trans_id = ?", nativeQuery=true)
    void cancelAllDelivery(String platformId, Long transId);

    /**
     * 未完成订单查询
     * @param platformId
     * @param driverId
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM TransportationDelivery AS t WHERE 1=1 AND t.platform_id = ? and " +
            "t.driver_id = ? and t.status > '00' and t.status < '90' AND " +
            "NOT EXISTS(SELECT * FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.detachable='0' " +
            "AND t1.pri_publish_id = ( SELECT t1.pri_publish_id FROM goodsorderm t1,transportationm t2 " +
            "WHERE t1.publish_id = t2.publish_id AND t2.trans_id = ?))", nativeQuery=true)
    List<TransportationdeliveryEntity> noCompleteCount(String platformId, Long driverId, Long transId);

    /**
     * 根据transId查找运单
     * @param driveId
     * @param transId
     * @return
     */
    @Query(value="select * from transportationdelivery t2  WHERE t2.driver_id = ? AND t2.trans_id = ? limit 0,1", nativeQuery=true)
    TransportationdeliveryEntity findDeliveryMyself(Long driveId, Long transId);

    /**
     * 获取车辆数
     * @param platformId
     * @param vehicleId
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM TransportationDelivery AS t WHERE 1=1 AND t.platform_id = ? " +
            "and t.vehicle_id = ? and t.status > '00' and t.status < '90' AND " +
            "NOT EXISTS( SELECT * FROM goodsorderm t1 WHERE t.publish_id = t1.publish_id and t1.detachable='0'" +
            " AND t1.pri_publish_id = ( SELECT t1.pri_publish_id FROM goodsorderm t1,transportationm t2 " +
            "WHERE t1.publish_id = t2.publish_id AND t2.trans_id = ?))", nativeQuery=true)
    List<TransportationdeliveryEntity> getCarCount(String platformId, Long vehicleId, Long transId);

    /**
     * 根据条件获取数据
     * @param platformId
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM  transportationdelivery t where t.trans_id = ? and t.platform_id = ? and t.status > '00' and t.settle_status= '20' ", nativeQuery=true)
    List<TransportationdeliveryEntity> verifyDelivery(String platformId, Long transId);

    /**
     * 更新装货重量
     */
    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE transportationdelivery t SET t.take_delivery_weight = REPLACE(:finishWeight,' ',''), " +
            "t.truck_loading_weight = REPLACE(:deliveryWeight,' ',''), t.delivery_time = IF(IFNULL(t.delivery_time, 'N') = 'N',:deliveryIdDate,t.delivery_time), " +
            "t.finish_time = IF(IFNULL(t.finish_time, 'N') = 'N', :finishDate,t.finish_time),t.shSure_date = IF(IFNULL(t.shSure_date, 'N') = 'N', " +
            ":finishDate,t.shSure_date),t.status = '90',t.update_date = NOW(),t.update_person = :createPersonId," +
            "t.remark = CONCAT('by',:createPersonId,' ',now(),'导入更新了装车,收货重量') " +
            "WHERE t.delivery_id = :deliveryId AND t.platform_id = :platformId AND IFNULL(t.settle_status, '10') = 10", nativeQuery=true)
    int updateDelieryWeight(@Param("finishWeight")BigDecimal finishWeight, @Param("deliveryWeight")BigDecimal deliveryWeight,
                             @Param("deliveryIdDate")Date deliveryIdDate, @Param("finishDate")Date finishDate,
                             @Param("createPersonId")Long createPersonId, @Param("deliveryId")Long deliveryId,
                             @Param("platformId")String platformId);

    @Modifying(clearAutomatically = true)
    @Query(value="update transportationdelivery t set t.price =:newPrice, t.amount =:newPrice * t.weight where t.trans_id =:transId and t.platform_id =:platformId", nativeQuery=true)
    int updateDeliveryPrice(@Param("newPrice")BigDecimal newPrice, @Param("transId")Long transId, @Param("platformId")String platformId);

    /**
     * 未完成订单查询(拼单调度时)
     * @param platformId
     * @param driverId
     * @return
     */
    @Query(value="SELECT * FROM TransportationDelivery AS t WHERE 1=1 AND t.platform_id = ? and " +
            "t.driver_id = ? and t.status > '00' and t.status < '90'", nativeQuery=true)
    List<TransportationdeliveryEntity> noCompleteCountBatch(String platformId, Long driverId);
}
