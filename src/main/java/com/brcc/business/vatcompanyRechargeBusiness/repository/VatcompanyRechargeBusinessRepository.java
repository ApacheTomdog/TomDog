package com.brcc.business.vatcompanyRechargeBusiness.repository;

import com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description: 委托业务充值申请表
 * @Auther: gemaochao
 * @Date:Created in 11:01 2018/11/14
 */
public interface VatcompanyRechargeBusinessRepository extends JpaRepository<VatcompanyRechargeBusinessEntity,Long>,IVatcompanyRechargeBusinessRepository {

    VatcompanyRechargeBusinessEntity findByPlatformIdAndBusinessNum(String platformId,String businessNum);

    /**
     * @Description  更新状态
     * @Param [businessNum, platformId]
     * @return com.brcc.business.vatcompanyRechargeBusiness.entity.VatcompanyRechargeBusinessEntity
     **/
    @Query(value = " update vatcompany_recharge_business set  status='90' where business_num=?1 and platform_id =?2",nativeQuery = true)
    VatcompanyRechargeBusinessEntity updateStatus(String businessNum,String platformId);
}
