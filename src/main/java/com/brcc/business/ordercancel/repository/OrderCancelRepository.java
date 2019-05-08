package com.brcc.business.ordercancel.repository;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * 撤单审核数据接口类
 *
 * @author yushaohua
 * @create 2018-11-06 22:18
 */
@Repository
public interface OrderCancelRepository extends JpaRepository<DeliverycancelauditEntity,Long>, IOrderCancelRepository {

    /**
     * 撤单审核通过
     * @param deliveryCancelId
     * @param deliveryCancelType
     * @param modifyPersonId
     * @param modifyPersonName
     * @param PlatformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update deliverycancelaudit d ,(SELECT z.delivery_id FROM apptms.transportationdelivery z WHERE z.pri_publish_id = (SELECT y.pri_publish_id FROM apptms.deliverycancelaudit x, apptms.transportationdelivery y WHERE y.delivery_id = x.delivery_id AND x.delivery_cancel_id = ? LIMIT 1)) a set d.delivery_cancel_type =?, d.audit_person_id =?,d.audit_person_name=?,d.audit_date =now(), d.audit_remark =? where  1=1 AND  d.platform_id = ? and  d.delivery_id = a.delivery_id and  d.delivery_cancel_type='10'",nativeQuery=true)
    void orderCancel(Long deliveryCancelId, String deliveryCancelType, Long modifyPersonId, String modifyPersonName, String auditRemark, String PlatformId);

    /**
     * 更新状态
     * @param deliveryCancelId
     * @param deliveryCancelType
     * @param modifyPersonId
     * @param modifyPersonName
     * @param PlatformId
     */
    @Modifying(clearAutomatically = true)
    @Query(value="update deliverycancelaudit d set d.delivery_cancel_type = ?, d.modify_person_id = ?, d.modify_person_name= ?, d.modify_date =now() where  1=1 AND  d.platform_id = ? and  d.delivery_cancel_id = ? and d.docu_type ='1' and delivery_cancel_type='10'",nativeQuery=true)
    void updateStatus(String deliveryCancelType, Long modifyPersonId, String modifyPersonName, String PlatformId, Long deliveryCancelId);

    /**
     * 撤单状态
     * @param deliveryId
     * @param platformId
     * @return
     */
    @Query(value="select * from deliverycancelaudit d where d.delivery_id in (select g.delivery_id from transportationdelivery g where g.pri_publish_id =(select t.pri_publish_id from transportationdelivery t where t.delivery_id = ? limit 1) and g.status='10') and d.platform_id = ?",nativeQuery=true)
    List<DeliverycancelauditEntity> deliveryCancelCheck(Long deliveryId, String platformId);
}