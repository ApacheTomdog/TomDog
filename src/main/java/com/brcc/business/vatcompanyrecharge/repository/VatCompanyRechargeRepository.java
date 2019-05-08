package com.brcc.business.vatcompanyrecharge.repository;

import com.brcc.business.vatcompanyrecharge.entity.VatcompanyrechargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @Description: 委托方充值申请数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 16:27 2018/11/13
 */
public interface VatCompanyRechargeRepository extends JpaRepository<VatcompanyrechargeEntity,Long>,IVatCompanyRechargeRepository {
    
    

    VatcompanyrechargeEntity findByVatCompanyRechargeId(Long id);

    VatcompanyrechargeEntity findByVatCompanyRechargeIdAndPlatformId(Long rechargeId,String platformId);

    /**
     * @Description  更新承运方充值审核单单据状态为红冲状态
     * @Param [String  status,Long createPersonId,String createPersonName,Long vatCompanyRechargeId]
     * @return java.lang.Integer
     **/
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update vatcompanyrecharge t\r\n" +
            "		set t.status = ?1,\r\n" +
            "		    t.audit_person_id=?2,\r\n" +
            "		    t.audit_person_name=?3,\r\n" +
            "		    t.audit_date=now()\r\n" +
            "		where t.vat_company_recharge_id = ?4",nativeQuery = true)
    Integer updateStatusm(String  status,Long createPersonId,String createPersonName,Long vatCompanyRechargeId);
}