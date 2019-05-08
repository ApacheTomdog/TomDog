package com.brcc.business.transportSettle.repository;

import com.brcc.business.transportbill.vo.TransportBillQueryVo;

import java.util.HashMap;

/**
 * 结算单数据扩展接口
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:34:41
 */
public interface IPayBillRepository {
	/**
	 * 查询调度单下生效的油卡数
	 * @param deliveryId
	 * @param platformId
	 * @return
	 */
	Integer queryActiveOilBillNum(Long deliveryId, String platformId);
	
	/**
	 * 油卡插入日志表
	 * @param vo
	 */
	void insertPayOilBillLog(TransportBillQueryVo vo);
	
	/**
	 * 删除油卡
	 * @param vo
	 */
	void deletePayOilBill(TransportBillQueryVo vo);

	/**
	 * 调用批量计算过程
	 * @param batchId
	 * @return
	 */
    HashMap<String, Object> callBatchCalcPro(String batchId);
}
