package com.brcc.business.vatcompanyrefund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.vatcompanyrefund.entity.VatcompanyrefundEntity;

/**
 * @Description: 委托方退款审核
 * @Auther: gemaochao
 * @Date:Created in 10:06 2018/11/16
 */
public interface VatcompanyrefundRepository extends JpaRepository<VatcompanyrefundEntity,Long>,IVatcompanyrefundRepository {

    VatcompanyrefundEntity findByPlatformIdAndVatCompanyRefundId(String platformId,Long refundId);

    VatcompanyrefundEntity findByVatCompanyRefundId(Long refundId);

    @Query(value = " UPDATE vatcapitalmaster t , vatcompanyrefund v SET t.total_refund_amount = t.total_refund_amount + v.refund_amount,t.total_use_amount = t.total_use_amount - v.refund_amount,t.modify_date = NOW()  WHERE   v.vat_company_refund_id = ?1 and t.carry_id = v.carry_id  and t.client_id = v.client_id and t.platform_id = v.platform_id and t.total_use_amount >= v.refund_amount",nativeQuery = true)
    int updateDetailAndRefund(Long refundId);
    
}