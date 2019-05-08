package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.DeliveryUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 描述:建邦大宗上传接口
 *
 * @author yushaohua
 * @create 2018-11-11 14:13
 */
@Repository
public interface DeliveryUploadRepository extends JpaRepository<DeliveryUploadEntity,Long> {

    /**
     * 保存撤销记录
     * @param returnFlag
     * @param returnInfo
     * @param deliveryId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="insert into deliveryupload(platform_id, publish_id, delivery_id, delivery_num, weight, amount, driver_name, driver_id, pick_up_weight, company_name, create_date, id_num, car_num, status, return_time, if_upload, return_msg) select t.platform_id, g.depend_num, t.delivery_id, t.delivery_num, t.weight,t.amount, d.name, t.driver_id, t.truck_loading_weight, c.company_name, t.create_date, d.id_num,v.vehicle_num,'00',now(), ?, ? from transportationdelivery t, goodsorderm g, company c, driver d, vehicle v where t.delivery_id = ? and g.publish_id = t.publish_id and c.seq_id = t.company_id and t.vehicle_id = v.vehicle_id and t.driver_id = d.id",nativeQuery=true)
    void insertDeliveryCancelLog(String returnFlag, String returnInfo, String deliveryId);
}