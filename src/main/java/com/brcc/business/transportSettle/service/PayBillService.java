package com.brcc.business.transportSettle.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.transportSettle.entity.PayBillEntity;
import com.brcc.business.transportSettle.entity.VNewPayBillEntity;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;

/**
 * 结算单业务逻辑接口
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:37:04
 */
public interface PayBillService {
	/**
	 * 根据货源单ID查找该货源单下调度单结算记录条数
	 * @param publishId
	 * @return
	 */
	public Integer queryActiveCount(Long publishId);
	
	/**
	 * 根据货源单ID查找该货源单下调度单付款申请记录条数
	 * @param publishId
	 * @return
	 */
	public Integer queryActivePayApplyCount(Long publishId);
	
	/**
	 * 
	 * @Title: findOne 
	 * @Description: 根据id获取结算单信息
	 * @param zfId
	 * @return  PayBillEntity
	 */
	public PayBillEntity findOne(Long zfId);
	
	/**
	 * 
	 * @Title: save 
	 * @Description: 保存结算单信息
	 * @param payBill
	 * @return PayBillEntity
	 */
	public PayBillEntity save(PayBillEntity payBill);

	/**
	 * @Desc: 根据publishId获取结算单信息
	 * @param publishId
	 * @return  List<PayBillEntity>
	 */
	public List<PayBillEntity> findPayBillListByPublishId(Long publishId);

	/** 
	 * @Desc: 批量修改结算结算单信息
	 * @param payBillList
	 */
	public void saveList(List<PayBillEntity> payBillList);

	/** 
	 * @Desc: 调度单是否结算
	 * @param deliveryId
	 */
	public Integer queryCountByDeliveryId(Long deliveryId);
	
	/**
	 * 判断调度单是否正在支付处理中
	 * @param deliveryId
	 * @param string
	 * @return
	 */
	public Integer countByDeliveryIdAndStatus(Long deliveryId, String string);
	
	/**
	 * 根据调度单查询有效的计算单
	 * @param deliveryId
	 * @return
	 */
	public List<PayBillEntity> queryActivedPayBill(Long deliveryId);

	/**
	 * 判断调度单是否有生效的结算单(并且已支付、未开票。针对已生成资金帐的进行修改)
	 * @param deliveryId
	 * @return PayBillEntity
	 */
	public PayBillEntity findPayBillByCondition(Long deliveryId);
	
	/**
	 * 撤销支付单
	 * @param vo
	 */
	public void revokeZFbill(TransportBillQueryVo vo);

	/**
	 * 查询结算单明细数据
	 * @param vo
	 * @return
	 */
	public Page<VNewPayBillEntity> listPayDetailData(TransportBillQueryVo vo);
	
	/**
	 * 保存支付单
	 * @param vo
	 */
	public PayBillEntity saveZFbill(TransportBillQueryVo vo);
	
	/**
	 * 获取seqNum
	 * @param propMap
	 */
	public String getSeqNum(String typeId);

	/**
	 * 自动付款申请
	 * @param payBillEntity
	 */
	public void autoApplyPay(PayBillEntity payBillEntity);

	/**
	 * 校验是否会重复支付给司机
	 * @param vo
	 * @return
	 */
	public HashMap<String, Object> checkIfSamePay(TransportBillQueryVo vo);

	/**
	 * 校验运费是否合理
	 * @param vo
	 * @return
	 */
	public HashMap<String, Object> checkZFbill(TransportBillQueryVo vo);

	/**
	 * 撤销付款申请
	 * @param vo
	 * @return
	 */
	public HashMap<String, Object> cancelPayApply(TransportBillQueryVo vo);

	/**
	 * 批量撤销付款申请
	 * @param vo
	 * @return
	 */
	public HashMap<String, Object> cancelPayApplyBatch(TransportBillQueryVo vo);

	/**
	 * @Desc 批量运费计算
	 * @param vo
	 * @return
	 * @author yangwenbin
	 * @version 创建时间：2019年1月22日 下午3:04:25
	 */
	public HashMap<String, Object> batchCalc(TransportBillQueryVo vo);
	/**
	 * 运费计算合计
	 * @param queryVo
	 * @return
	 */
	TransportationDeliveryVo listDataSum(TransportBillQueryVo queryVo);
}
