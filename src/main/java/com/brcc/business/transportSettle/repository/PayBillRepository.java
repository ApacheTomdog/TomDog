package com.brcc.business.transportSettle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.transportSettle.entity.PayBillEntity;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 * 结算单数据交互接口
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:35:26
 */
public interface PayBillRepository extends JpaRepository<PayBillEntity,Long>,IPayBillRepository {

	/**
	 * 根据货源单ID查找该货源单下调度单结算记录
	 * @param publishId
	 * @return
	 */
	@Query(value="select count(*) from pay_bill where status!='00' and publish_id=?",nativeQuery=true)
	Integer queryActiveCount(Long publishId);
	
	/**
	 * 根据货源单ID查找该货源单下调度单付款申请记录条数
	 * @param publishId
	 * @return
	 */
	@Query(value="select count(*) from pay_bill where status!='00' and owner_payapply_flag='1' and publish_id=?",nativeQuery=true)
	Integer queryActivePayApplyCount(Long publishId);

	/**
	 * @Desc: 根据publishId获取结算单信息
	 * @param publishId
	 * @return  List<PayBillEntity>
	 */
	List<PayBillEntity> findByPublishId(Long publishId);

	/** 
	 * @Desc: 调度单是否结算
	 * @param deliveryId
	 */
	Integer queryCountByDeliveryId(Long deliveryId);
	
	/**
	 * 判断调度单是否正在支付处理中
	 * @param deliveryId
	 * @param status
	 * @return
	 */
	Integer countByDeliveryIdAndStatus(Long deliveryId, String status);
	
	/**
	 * 根据调度单查询有效的计算单
	 * @param deliveryId
	 * @return
	 */
	@Query(value="select * from pay_bill where status !='00' and delivery_id = ?", nativeQuery=true)
	List<PayBillEntity> queryActivedPayBill(Long deliveryId);

	/**
	 * 判断调度单是否有生效的结算单(并且已支付、未开票)
	 * @param deliveryId
	 * @return PayBillEntity
	 */
	PayBillEntity findByStatusAndIfInvoiceAndDeliveryId(int i, int j, Long deliveryId);
	
	/**
	 * 作废计算单
	 * @param zfId
	 * @param platformId
	 * @param status
	 * @param preStatus
	 * @param userId
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE pay_bill t\r\n" + 
				 "SET t. STATUS = ?3, t.update_date = now(), t.update_person = ?5\r\n" + 
				 "WHERE t.platform_id = ?2\r\n" + 
				 "AND t.zf_id = ?1\r\n" + 
				 "AND t. STATUS = ?4", nativeQuery=true)
	Integer updatePayBill(Long zfId, String platformId, String status, String preStatus, Long userId);

	/**
	 * 查询货主是否需要做付款申请
	 * @param createCompanyId
	 * @param platformId
	 * @return
	 */
	@Query(value="SELECT count(*) FROM goodsownernopayapply a WHERE a.data_status = '20' AND a.platform_id = ?2 AND a.no_apply_flag = '1' AND a.publish_company_id = ?1", nativeQuery=true)
	Long queryIfAutoApplyPay(Long createCompanyId, String platformId);

	/**
	 * 根据调度单查询有效的计算单数
	 * @param deliveryId
	 * @return
	 */
	@Query(value="select count(*) from pay_bill where status !='00' and delivery_id = ?", nativeQuery=true)
	Long queryActivedPayBillCount(Long deliveryId);
	
}
