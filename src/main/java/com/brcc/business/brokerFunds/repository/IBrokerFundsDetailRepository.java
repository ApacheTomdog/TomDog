package com.brcc.business.brokerFunds.repository;

import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;

public interface IBrokerFundsDetailRepository {
    BrokerFundsDetailVo queryDeliveryDetail(BrokerFundsDetailQueryVo vo);
}
