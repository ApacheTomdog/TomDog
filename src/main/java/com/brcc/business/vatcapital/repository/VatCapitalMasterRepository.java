package com.brcc.business.vatcapital.repository;

import com.brcc.business.vatcapital.entity.VatcapitalmasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 11:40 2018/11/16
 */
public interface VatCapitalMasterRepository extends JpaRepository<VatcapitalmasterEntity,Long>,IVatCapitalMasterRepository {


    @Query(value = "SELECT * FROM vatcapitalmaster t WHERE t.carry_id = ?1 and t.client_id = ?2  and t.platform_id = ?3 and t.total_use_amount >= ?4",nativeQuery = true)
    VatcapitalmasterEntity queryMaster(Long carryId,Long clientId,String platformId,BigDecimal totalUserAmount);

    /**
     * 查询资金帐信息(根据委托clientId和承运carrId)
     * @param vo
     * @return VatcapitalmasterEntity
     */
    @Query(value = "select * from vatcapitalmaster WHERE client_id = ? and carry_id = ? and platform_id =? and total_use_amount >0",nativeQuery = true)
	VatcapitalmasterEntity queryCompanyCapital(Long clientId, Long carryId, String platformId);

    /**
     * @Description  更新资金帐金额
     * @Param [BigDecimal bankAmount,Long clientId,Long carryId,String platformId]
     * @return java.lang.Integer
     **/
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update vatcapitalmaster \r\n" +
            "		set total_in_amount = total_in_amount - ?1,\r\n" +
            "		    total_use_amount=total_use_amount - ?1 \r\n" +
            "		where client_id = ?2\r\n" +
            "		and  platform_id = ?4\r\n" +
            "		and  carry_id= ?3 ",nativeQuery = true)
    Integer updateVatcapitalMaster(BigDecimal bankAmount,Long clientId,Long carryId,String platformId);
}