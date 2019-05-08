package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.TransportationmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述:
 * 平台运输单数据接口类
 *
 * @author yushaohua
 * @create 2018-10-31 17:00
 */
@Repository
public interface TransOrderRepository extends JpaRepository<TransportationmEntity,Long>, ITransOrderRepository {

    /**
     * 更新调度单
     * @param deliveryId
     * @param transId
     * @param platformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update TransportationM a set a.weight = a.weight + ifnull((select d.weight from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId) ,0), a.qty = a.qty + ifnull((select d.qty from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId),0),a.amount = a.amount + ifnull((select d.weight from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId),0) * a.price,a.delivery_weight = a.delivery_weight - ifnull((select d.weight from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId),0), a.delivery_qty = a.delivery_qty - ifnull((select d.qty from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId),0),a.delivery_amount = a.delivery_amount - a.price * ifnull((select d.weight from TransportationDelivery d where d.platform_id = a.platform_id and d.delivery_id = :deliveryId),0) where a.trans_id = :transId and a.platform_id = :platformId",nativeQuery=true)
    void dispatchWeightBack(@Param("deliveryId") String deliveryId, @Param("transId")String transId, @Param("platformId")String platformId);

    /**
     * 获取对象
     * @param transId
     * @param platformId
     * @return
     */
    TransportationmEntity findByTransIdAndPlatformId(Long transId, String platformId);

    /**
     * 获取对象
     * @param transId
     * @return
     */
    List<TransportationmEntity> findByTransId(Long transId);

    /**
     * 作废运输订单
     * @param status
     * @param userId
     * @param deliveryWeight
     * @param deliveryQty
     * @param deliveryAmount
     * @param transId
     * @param platformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update TransportationM a set a.status = :status,a.complete_date = now(),a.update_person =:userId,a.update_date = now(), a.delivery_weight = :deliveryWeight, a.delivery_qty = :deliveryQty, a.delivery_amount = :deliveryAmount where a.trans_id = :transId and a.platform_id = :platformId and a.status <> '00' and a.status <> '60'",nativeQuery=true)
    void updateStatus(@Param("status")String status, @Param("userId")Long userId, @Param("deliveryWeight")BigDecimal deliveryWeight, @Param("deliveryQty")BigDecimal deliveryQty, @Param("deliveryAmount")BigDecimal deliveryAmount, @Param("transId")String transId, @Param("platformId")String platformId);

    /**
     * 跟新运输单状态
     * @param publishId
     * @param platformId
     */
    @Query(value="SELECT * FROM transportationm t WHERE t.publish_id = ? and t.platform_id = ? AND (t.status = '10' OR t.status = '20' OR t.status = '30')", nativeQuery=true)
    List<TransportationmEntity> activeTransBill(Long publishId, String platformId);

    /**
     * 更新操作人信息
     * @param updatePerson
     * @param platformId
     * @param transId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update TransportationM a set a.update_date = now(), a.update_person = ? WHERE a.platform_id = ? and a.trans_id = ?", nativeQuery=true)
    void updateDatePerson(Long updatePerson, String platformId, Long transId);

    /**
     * 获取状态为20的运输单
     * @param transId
     * @return
     */
    @Query(value="SELECT * FROM transportationm t WHERE t.pri_publish_id = (SELECT t2.pri_publish_id FROM transportationm t2 WHERE t2.trans_id = ?) and t.status = '20'", nativeQuery=true)
    List<TransportationmEntity> queryMultiTransId(String transId);

    /**
     * 更新调度重量
     * @param dispatchWeight
     * @param dispatchQty
     * @param transId
     * @param platformId
     */
    @Modifying
    @Transactional
    @Query(value="update TransportationM a set a.weight = a.weight - :dispatchWeight, a.qty=a.qty - :dispatchQty, " +
            "a.amount = a.amount - a.price * :dispatchWeight, a.delivery_weight = a.delivery_weight + :dispatchWeight, " +
            "a.delivery_qty = a.delivery_qty + :dispatchQty, a.delivery_amount = a.delivery_amount + a.price * :dispatchWeight " +
            "where a.trans_id = :transId and a.platform_id = :platformId", nativeQuery=true)
    void updateTransWeight(@Param("dispatchWeight")BigDecimal dispatchWeight, @Param("dispatchQty")BigDecimal dispatchQty,
                           @Param("transId")Long transId, @Param("platformId")String platformId);

    /**
     * 修改运费
     * @param price
     * @param transId
     * @param platformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update transportationm t set t.price = :price, t.init_amount = :price * t.init_weight, t.amount = :price * t.weight, t.delivery_amount = :price * t.delivery_weight where t.trans_id = :transId and t.platform_id = :platformId", nativeQuery=true)
    void modifyPrice(@Param("price")BigDecimal price, @Param("transId")Long transId, @Param("platformId")String platformId);

    @Query(value="select a.* from TransportationM a where a.trans_id = ? and a.status != '00' and a.status != '30' and a.status != '60' for update", nativeQuery=true)
    TransportationmEntity queryIsHasTransWeight(Long transId);

}