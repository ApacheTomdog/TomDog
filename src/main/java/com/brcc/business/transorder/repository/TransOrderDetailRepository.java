package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.GoodsordermEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台运输单详情数据接口类
 *
 * @author yushaohua
 * @create 2018-11-01 16:47
 */
@Repository
public interface TransOrderDetailRepository extends JpaRepository<GoodsordermEntity, Long>, ITransOrderDetailRepository {

    /**
     * 更新对象
     * @param weight
     * @param qty
     * @param amount
     * @param publishId
     * @param platformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update goodsorderm t set t.weight =ifnull(t.weight,0) + ifnull(:weight,0),t.qty = ifnull(t.qty,0) + ifnull(:qty,0), t.amount = ifnull(t.amount,0) + ifnull(:amount,0), t.sale_weight=ifnull(t.sale_weight,0) - ifnull(:weight,0), t.sale_qty =ifnull(t.sale_qty,0) - ifnull(:qty,0),t.sale_amount =ifnull(t.sale_amount,0) - ifnull(:amount,0) where t.publish_id =:publishId and t.platform_id = :platformId",nativeQuery=true)
    void updateResource(@Param("weight")BigDecimal weight, @Param("qty")BigDecimal qty, @Param("amount")BigDecimal amount, @Param("publishId")String publishId, @Param("platformId")String platformId);


    /**
     * 更新对象
     * @param weight
     * @param qty
     * @param amount
     * @param publishId
     * @param platformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update goodsorderm t set  t.sale_weight=ifnull(t.sale_weight,0) - ifnull(:weight,0), t.sale_qty =ifnull(t.sale_qty,0) - ifnull(:qty,0),t.sale_amount =ifnull(t.sale_amount,0) - ifnull(:amount,0) where t.publish_id =:publishId and t.platform_id = :platformId",nativeQuery=true)
    void updateSaleResource(@Param("weight")BigDecimal weight, @Param("qty")BigDecimal qty, @Param("amount")BigDecimal amount, @Param("publishId")String publishId, @Param("platformId")String platformId);

    /**
     * 获取对象
     * @param publishId
     * @param platformId
     * @return
     */
    GoodsordermEntity findByPublishIdAndPlatformId(Long publishId, String platformId);

    /**
     * 更新状态
     * @param publishId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="UPDATE `goodsorderm` SET `status` = '30' WHERE `publish_id` = ?",nativeQuery=true)
    void updateGoodsOrderMStatus(String publishId);

    /**
     * 更新对象
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update goodsorderm t set t.status = :status,t.update_person = :updatePerson, t.update_date = NOW(), t.remark=:remark where t.publish_id =:publishId and t.platform_id = :platformId",nativeQuery=true)
    void updateGoodsStatus(@Param("status")String status, @Param("updatePerson")Long updatePerson, @Param("remark")String remark, @Param("publishId")Long publishId, @Param("platformId")String platformId);
}