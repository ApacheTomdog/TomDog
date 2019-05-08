package com.brcc.business.goodsorderToPayInfo.repository;

import com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 收款账号配置数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 14:18 2018/11/12
 */
public interface GoodsorderToPayInfoRepository extends JpaRepository<GoodsorderToPayInfoEntity,Long>, IGoodsorderToPayInfoRepository {
    
    /**
     * @Description  查询指定Id收款配置信息
     * @Param [seqId]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/
    GoodsorderToPayInfoEntity findBySeqId(Long seqId);
    
    /**
     * @Description  删除指定id收款账号信息
     * @Param [seqId]
     * @return com.brcc.business.goodsorderToPayInfo.entity.GoodsorderToPayInfoEntity
     **/

    void deleteBySeqId(Long seqId);

    
    /**
     * @Description  检测货源单号是否已存在收款账号
     * @Param [companyId, platformId, publishId]
     * @return java.lang.Long
     **/
    @Query(value = "select count(1) from goodsorder_to_pay_info a where  a.company_id=?1 and  a.platform_id=?2 and a.publish_id=?3",nativeQuery = true)
    Long verifyPayInfo(Long companyId,String platformId,Long publishId);
}