package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 15:31
 */
@Repository
public interface TransportationDeliveryUploadRepository extends JpaRepository<TransportationdeliveryuploadEntity,Long>,ITransportationDeliveryUploadRepository {

    /**
     * 查询调度单上传情况
     * @param deliveryId
     * @return
     */
    @Query(value="SELECT COUNT(1) AS COUNT FROM transportationdeliveryupload WHERE delivery_id= ? AND STATUS='30' AND is_upload_ec='1'",nativeQuery=true)
    int queryIfUpload(String deliveryId);

    /**
     * 更新upload状态
     * @param deliveryId
     */
    @Query(value="update transportationdeliveryupload set is_upload_ec='-1' WHERE delivery_id=? and STATUS='30'",nativeQuery=true)
    void updateUploadEc(String deliveryId);

//    /**
//     * 更新upload状态
//     * @param isUploadEc
//     * @param interfaceOutReason
//     * @param uploadId
//     */
//    @Query(value="update transportationdeliveryupload set is_upload_ec=?,interface_out_reason=? WHERE upload_id=? ",nativeQuery=true)
//    void updateUploadEc(String isUploadEc,String interfaceOutReason,String uploadId);



}