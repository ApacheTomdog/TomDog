package com.brcc.business.brokerFunds.service;

import com.brcc.business.brokerFunds.vo.BrokerFundsDetailQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsDetailVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsQueryVo;
import com.brcc.business.brokerFunds.vo.BrokerFundsVo;
import org.springframework.data.domain.Page;

/**
 * @author PanJianYang
 * @version 创建时间：2018年12月27日 上午9:10:37
 * @Description 经纪人资金流水单上传
 */
public interface BrokerFundsService {
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
    /**
     * 	增加经纪人上传流水
     */
    void addBrokerFunds(BrokerFundsVo vo);
    /**
     * 	增加经纪人上传流水明细
     */
    void addDetailToBrokerFunds(BrokerFundsDetailQueryVo vo);
    /**
     * 	删除经纪人上传的流水明细
     */
    void deleteBrokerFundsDetail(BrokerFundsDetailQueryVo vo);
}
