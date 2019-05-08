package com.brcc.business.creditAdjustPrice.repository;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * @Description: 授信调价配置数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 17:41 2018/11/3
 */
public interface ICreditAdjustPriceMasterRepository {
    
    
    /**
     * @Description  返回委托方授信调价页面信息
     * @Param [creditAdjustPriceQuerySearchVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity>
     **/
    Page<CreditAdjustPriceMasterEntity> showCreditAdjustMaster(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);
    
    List<CreditAdjustPriceMasterEntity> queryCreditAdjustPriceList(CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo);
}