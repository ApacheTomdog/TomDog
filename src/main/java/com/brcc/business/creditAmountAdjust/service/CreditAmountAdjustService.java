package com.brcc.business.creditAmountAdjust.service;

import com.brcc.business.creditAmountAdjust.entity.CreditAmountAdjustEntity;
import com.brcc.business.creditAmountAdjust.vo.CreditAmountAdjustQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Description: 授信明细逻辑接口
 * @Auther: gemaochao
 * @Date:Created in 10:21 2018/11/2
 */
@Service
public interface CreditAmountAdjustService {

    Page<CreditAmountAdjustEntity> findCreditAmountAdjust(CreditConfigQueryVo creditConfigQueryVo);

    Page<CreditAmountAdjustEntity> searchCreditAmountAdjust(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo);

    CreditAmountAdjustEntity searchByOne(CreditAmountAdjustQueryVo creditAmountAdjustQueryVo);

    void modify(CreditAmountAdjustEntity creditAmountAdjustEntity);

    CreditAmountAdjustEntity save(CreditAmountAdjustEntity creditAmountAdjustEntity);
    
    void modifyStatus(CreditAmountAdjustEntity creditAmountAdjustEntity);
    
    CreditAmountAdjustEntity searchByCreditConfigId(Long creditConfigId);
}