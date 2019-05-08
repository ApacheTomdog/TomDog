package com.brcc.business.creditAdjustPrice.repository;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 授信调价明细数据操作接口
 * @Auther: gemaochao
 * @Date:Created in 20:17 2018/11/3
 */
public interface CreditAdjustPriceDetailRepository extends JpaRepository<CreditAdjustPriceDetailEntity,String>,ICreditAdjustPriceDetailRepository {


    /**
     * @Description  根据CredAdjDId返回明细
     * @Param [credAdjDId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    CreditAdjustPriceDetailEntity findByCredAdjDId(Long credAdjDId);
    
    /**
     * @Description  删除指定credAdjDId明细
     * @Param [credAdjDId]
     * @return com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity
     **/
    Integer deleteByCredAdjDId(Long credAdjDId);


    /**
     * @Description  判断该授信调价下是否存在子记录
     * @Param [mid]
     * @return boolean
     **/
    boolean existsByCredAdjMId(Long mid);
}