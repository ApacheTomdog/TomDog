package com.brcc.business.brokerFunds.repository;

import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BrokerFundsDetailRepository extends JpaRepository<BrokerfundscontroldetailEntity,Long>, IBrokerFundsDetailRepository{
    /**
     * @Description  更新调度单上的资金流水单标记
     * @Param fundsControlDetailId
     * @return java.lang.Long
     **/
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update transportationdelivery t,brokerfundscontrolmaster b, brokerfundscontroldetail m" +
            "     set t.funds_control_pic = null,\n" +
            "       t.if_funds_control_flag ='1',\n" +
            "       t.broker_funds_control_master_id =null\n" +
            "     where t.delivery_id = m.delivery_id\n" +
            "     and m.funds_control_detail_id =?1\n" +
            "     and m.funds_control_master_id = b.funds_control_master_id ",nativeQuery = true)
    void updateDeliveryFundsFlag(Long fundsControlDetailId);

    /**
     * 根据资金流水主单查询对应的明细
     * @param fundsControlMasterId
     * @return
     */
    List<BrokerfundscontroldetailEntity> findByFundsControlMasterId(Long fundsControlMasterId);
    /**
     * 根据资金流水主单id对所有的明细进行删除
     * @param fundsControlMasterId
     * @return
     */
    void deleteAllByFundsControlMasterId(Long fundsControlMasterId);
    /**
     * 根据资金流水主单id判断是否所有的明细都已为维护过分润
     * @param fundsControlMasterId，fcIfUpload
     * @return
     */
    Integer countByFundsControlMasterIdAndFcIfUpload(Long fundsControlMasterId,Integer fcIfUpload);

    /**
     * 根据资金流水主单id判断主表下的明细
     * @param fundsControlMasterId
     * @return
     */
    Integer countByFundsControlMasterId(Long fundsControlMasterId);

    /**
     * @Description  //查询删除部分明细后查看主单下面是否存在不为0或者null的明细
     * @Param fundsControlMasterId
     * @return java.lang.Long
     **/
    @Transactional
    @Query(value = "select * from brokerfundscontroldetail d where d.funds_control_master_id =?1 and d.company_owner_id !=0 and d.company_owner_id is not null",nativeQuery = true)
    List<BrokerfundscontroldetailEntity> findAllDetailInfo(Long fundsControlMasterId);

    @Query(value = "select ifnull(sum(p.pay_amount_act),0) from pay_bill_child p ,brokerfundscontroldetail b where b.pay_bill_id = p.zf_id and p.pay_from_type='1' and  b.funds_control_master_id=?1",nativeQuery = true)
    BigDecimal getDetailAmount(Long fundsControlMasterId);
}
