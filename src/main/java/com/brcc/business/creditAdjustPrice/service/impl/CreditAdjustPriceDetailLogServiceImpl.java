package com.brcc.business.creditAdjustPrice.service.impl;

import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailLogEntity;
import com.brcc.business.creditAdjustPrice.repository.CreditAdjustPriceDetailLogRepository;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 10:22 2018/11/23
 */
@Service
public class CreditAdjustPriceDetailLogServiceImpl implements CreditAdjustPriceDetailLogService {

    @Autowired
    CreditAdjustPriceDetailLogRepository creditAdjustPriceDetailLogRepository;

    @Override
    public CreditAdjustPriceDetailLogEntity save(CreditAdjustPriceDetailLogEntity vo) {
        return creditAdjustPriceDetailLogRepository.save(vo);
    }
}
