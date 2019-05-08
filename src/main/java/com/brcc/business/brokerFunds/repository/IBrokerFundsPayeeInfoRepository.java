package com.brcc.business.brokerFunds.repository;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsPayeeInfoVo;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface IBrokerFundsPayeeInfoRepository {
    Page<BrokerFundsPayeeInfoVo> lookPayeeDetail(BrokerFundsPayeeInfoQueryVo vo);

    ArrayList checkPayeeAmountPro(Integer asPkId ,String asType, String userId, String userName);
}
