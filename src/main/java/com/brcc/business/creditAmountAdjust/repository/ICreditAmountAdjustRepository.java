package com.brcc.business.creditAmountAdjust.repository;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import org.springframework.data.domain.Page;

/**
 * @Description: 委托方授信明细
 * @Auther: gemaochao
 * @Date:Created in 20:42 2018/11/1
 */
public interface ICreditAmountAdjustRepository {
    /**
     * @Author gemaochao
     * @Description //TODO 返回委托方授信明细
     * @Date  2018/11/1
     * @Param [creditConfigQueryVo]
     * @return org.springframework.data.domain.Page<com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity>
     **/
    Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo);
    
    /**
     * 
     * @author:陈利
     * @date:2018年11月3日
     * @param creditAmountAdjustQueryVo
     * @return
     */
    Page<CreditAmountAdjustEntity> searchCreditAmountAdjust(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo);
    
}