package com.brcc.business.brokerFunds.service;

import com.brcc.business.brokerFunds.vo.*;
import com.esteel.common.controller.WebReturnMessage;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
public interface BrokerFundsMasterService {
	//资金流水单明细审核页面
	 Page<BrokerFundsDetailVo> brokerFundsMasterAuditList(BrokerFundsDetailQueryVo queryvo);
	 
	//超限调度单查询
	Page<TransfiniteDispatchVo>transfiniteDispatchPage(TransfiniteDispatchQueryVo queryVo);

	//保存单条资金流水上传记录
	void saveCapitalFlow(BrokerFundsVo brokerFundsVo);

	/**
	 * 经纪人资金流水单上传列表查询
	 */
	Page<BrokerFundsVo> brokerFundsMasterList(BrokerFundsQueryVo vo);

	/**
	 * 对单条资金流水进行第一次审核操作
	 */
	void saveFirstAudit(BrokerFundsDetailVo brokerFundsDetailVo);
	/**
	 * 对单条资金流水进行第二次审核操作
 	*/
	void saveSecondAudit(BrokerFundsDetailVo brokerFundsDetailVo);
	/**
	 * 	增加经纪人上传流水
	 */
	void addBrokerFundsMaster(BrokerFundsVo vo);

	/**
	 * 	增加经纪人流水单分配信息
	 */
	void addPayeeDetail(BrokerFundsVo vo);

	/**
	 * 	删除经纪人流水单分配信息
	 */
	void deletePayeeDetail(BrokerFundsPayeeInfoVo vo);
	/**
	 * 	作废资金流水主单
	 */
	void invalidMaster(BrokerFundsVo vo);
	/**
	 * 	提交资金流水主单
	 */
	void offerMaster(BrokerFundsVo vo);

	/**
	 * 	查询可以添加进入资金流水明细的调度单信息
	 */
	Page<BrokerFundsDetailVo> addBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo);
	/**
	 * 	查询添加进入经纪人资金流水明细的调度单信息
	 */
	Page<BrokerFundsDetailVo>lookBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo);

	/**
	 * 	增加经纪人上传流水明细
	 */
	void addDetailToBrokerFundsMaster(BrokerFundsDetailQueryVo vo);

	/**
	 * 	删除经纪人上传的流水明细
	 */
	void deleteBrokerFundsMasterDetail(BrokerFundsDetailQueryVo vo);
    /**
     * 	导出经纪人资金流水明细的调度单信息
     */
    List<BrokerFundsDetailVo> excelBrokerFunds(BrokerFundsDetailQueryVo vo);
	/**
	 * 	导入经纪人分润
	 */
    String uploadBrokerFunds(List<BrokerFundsUploadVo>excelList,Long companyId, Long fundsControlMasterId);

    void saveFpInfo(BrokerFundsDetailVo vo);

	/**
	 * 经纪人资金流水主单审核查询
	 */
	Page<BrokerFundsVo> masterAuditList(BrokerFundsQueryVo vo);

	/**
	 * 对资金流水进行第一次审核操作
	 */
	void saveFirstMasterAudit(BrokerFundsVo brokerFundsVo);
	/**
	 * 对资金流水进行第二次审核操作
	 */
	void saveSecondMasterAudit(BrokerFundsVo brokerFundsVo);

	/**
	 * 上传经纪人流水图片
	 */
    void uploadBrokerFundsPic(BrokerFundsVo vo);

	/**
	 * 删除经纪人流水图片
	 */
    void removeBrokerFundsPic(Long fundsControlMasterId);
}
