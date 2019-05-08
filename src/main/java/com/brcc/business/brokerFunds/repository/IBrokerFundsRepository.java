package com.brcc.business.brokerFunds.repository;

import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import org.springframework.data.domain.Page;

public interface IBrokerFundsRepository {
    /**
     * 经纪人资金流水单上传列表查询
     */
      Page<BrokerFundsVo> brokerFundsList(BrokerFundsQueryVo vo);
    /**
     * 	查询可以添加进入资金流水明细的调度单信息
     */
    Page<BrokerFundsDetailVo> addBrokerFundsDetailList(BrokerFundsDetailQueryVo vo);
    /**
     * 	查询添加进入经纪人资金流水明细的调度单信息
     */
    Page<BrokerFundsDetailVo>lookBrokerFundsDetailList(BrokerFundsDetailQueryVo vo);
}
