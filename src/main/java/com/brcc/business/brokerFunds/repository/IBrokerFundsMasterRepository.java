package com.brcc.business.brokerFunds.repository;

import com.brcc.business.brokerFunds.vo.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
public interface IBrokerFundsMasterRepository {
	
	Page<BrokerFundsDetailVo> brokerFundsMasterAuditList(BrokerFundsDetailQueryVo queryvo);
	
	//超限调度单查询
	Page<TransfiniteDispatchVo>transfiniteDispatchPage(TransfiniteDispatchQueryVo queryVo);

	//根据计算单号找到对应的调度单详情
	BrokerFundsDetailVo getBrokerFundsDetailVo(BrokerFundsVo brokerFundsVo);
	//经纪人资金流水批量上传查询
	Page<BrokerFundsVo> brokerFundsMasterList(BrokerFundsQueryVo queryvo);
	/**
	 * 	查询可以添加进入资金流水明细的调度单信息
	 */
	Page<BrokerFundsDetailVo> addBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo);
	/**
	 * 	查询添加进入经纪人资金流水明细的调度单信息
	 */
	Page<BrokerFundsDetailVo>lookBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo);
    /**
     * 	导出资金流水单明细
     */
    List<BrokerFundsDetailVo> excelBrokerFunds(BrokerFundsDetailQueryVo vo);

	ArrayList saveSecondAuditPro(Integer asPkId, String asType,String userId, String userName);

	//经纪人资金流水主单审核
	Page<BrokerFundsVo> masterAuditList(BrokerFundsQueryVo queryvo);

	ArrayList checkPayeeAmountPro(Integer asPkId ,String userId, String userName);

}
