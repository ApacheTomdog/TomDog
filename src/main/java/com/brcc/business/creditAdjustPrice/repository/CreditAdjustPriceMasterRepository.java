package com.brcc.business.creditAdjustPrice.repository;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 授信调价配置数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 17:38 2018/11/3
 */
public interface CreditAdjustPriceMasterRepository extends JpaRepository<CreditAdjustPriceMasterEntity,String>,ICreditAdjustPriceMasterRepository {

    /**
     * @Description 根据  credAdjMId和publishCompanyId查询指定的委托方授信调价信息
     * @Param [credAdjMId, publishCompanyId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    CreditAdjustPriceMasterEntity findByCredAdjMIdAndPublishCompanyId(Long credAdjMId,Long publishCompanyId);
    
    /**
     * @Description  判断指定publishCompanyId 委托方是否存在指定adjPriceStatus状态信息
     * @Param [publishCompanyId, adjPriceStatus]
     * @return boolean
     **/
    boolean existsByPublishCompanyIdAndAdjPriceStatus(Long publishCompanyId,String adjPriceStatus);
    
    /**
     * @Description  查询指定credAdjMId授信调价信息
     * @Param [credAdjMId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity
     **/
    CreditAdjustPriceMasterEntity findByCredAdjMId(Long credAdjMId);
}