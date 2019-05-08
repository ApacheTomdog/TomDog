package com.brcc.business.invoice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.invoice.entity.InvoicedetailEntity;

/**
 * @Description 发票明细数据接口
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:03:07
 */
public interface InvoiceDetailRepository extends JpaRepository<InvoicedetailEntity,Long> {

	/**
	 * 根据发票通知单编号查询发票明细
	 * @param invoiceMasterId
	 * @return
	 */
	List<InvoicedetailEntity> findByInvoiceMasterId(Long invoiceMasterId);

	/**
	 * 取消pay_bill表上的是否开票的标记
	 * @param ifInvoice
	 * @param platformId
	 * @param invoiceMasterId
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE pay_bill p, invoicedetail i " + 
			"		SET p.if_invoice = ?1 " + 
			"		WHERE p.zf_id = i.pay_bill_id " + 
			"		AND p.platform_id = ?2 " + 
			"		AND i.invoice_master_id = ?3 " + 
			"		AND i.if_begin = 'Y'", nativeQuery=true)
	Integer updatePayBillInvoiceFlag(String ifInvoice, String platformId, Long invoiceMasterId);

	/**
	 * 取消transportationdelivery表上的是否开票的标记
	 * @param ifInvoice
	 * @param platformId
	 * @param invoiceMasterId
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE transportationdelivery p, invoicedetail i " + 
			"		SET p.if_invoice = ?1 " + 
			"		WHERE p.delivery_id = i.delivery_id " + 
			"		AND p.platform_id = ?2 " + 
			"		AND i.invoice_master_id = ?3 " + 
			"		AND i.if_begin = 'Y'", nativeQuery=true)
	Integer updateDeliveryInvoiceFlag(String ifInvoice, String platformId, Long invoiceMasterId);

	/**
	 * 根据invoiceMasterId查询未开票的发票明细
	 * @param invoiceMasterId
	 * @return
	 */
	@Query(value="select * from invoicedetail  where invoice_master_id = ? and if_invoice in ('1','0')", nativeQuery=true)
	List<InvoicedetailEntity> queryNonInvoicedDetail(Long invoiceMasterId);

	/**
	 * 根据invoiceMasterId删除未开票的发票明细
	 * @param invoiceMasterId
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="delete from invoicedetail  where invoice_master_id = ? and if_invoice in ('1','0')", nativeQuery=true)
	Integer deleteNonInvoicedDetail(Long invoiceMasterId);

	/**
	 * 根据invoiceMasterId查询已拆分或已开票的发票明细数
	 * @param invoiceMasterId
	 * @return
	 */
	@Query(value="select count(1) from invoicedetail ic where ic.invoice_master_id = ? and ic.if_invoice in ('3','2')", nativeQuery=true)
	Integer querySplitedOrInvoicedCount(Long invoiceMasterId);

	/**
	 * 更新发票明细开票状态为已拆分
	 * @param list
	 * @param splitNum
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE invoicedetail i " + 
			"SET i.if_invoice = '3', " + 
			" i.invoice_split_num = ?2 " + 
			"WHERE i.invoice_detail_id IN ?1 " + 
			"AND i.if_invoice = '1'", nativeQuery=true)
	Integer updateDetailSplitCompleted(List<String> list, String splitNum);

	/**
	 * 更新发票明细的拆分表id
	 * @param list
	 * @param invoiceSplitId
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE invoicedetail i " + 
			"SET i.invoice_split_id = ?2 " + 
			"WHERE i.invoice_detail_id IN ?1 " + 
			"AND i.if_invoice = '3'", nativeQuery=true)
	Integer updateDetailSplitId(List<String> list, Long invoiceSplitId);

	/**
	 * 更新发票明细表的发票号，开票时间，标记
	 * @param invoiceSplitId
	 * @param invoiceNo
	 * @param invoiceAgreeTime
	 * @param ifInvoice
	 * @param userId
	 * @param userName
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE invoicedetail " + 
			"SET if_invoice = ?4, modify_date = now(), " + 
			" modify_person_id = ?5, modify_person_name = ?6, invoice_no = ?2, invoice_agree_time = ?3 " + 
			"WHERE " + 
			"	invoice_split_id = ?1", nativeQuery=true)
	Integer updateInvoiceDetail(Long invoiceSplitId, String invoiceNo, Date invoiceAgreeTime, String ifInvoice,
			Long userId, String userName);

	/**
	 * 移除发票明细表的开票信息
	 * @param invoiceSplitId
	 * @param platformId
	 * @param invoiceMasterId
	 * @param userId
	 * @param userName
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE invoicedetail " + 
			"SET if_invoice = '1', " + 
			" modify_date = now(), " + 
			" modify_person_id = ?4, modify_person_name = ?5, invoice_no = NULL, " + 
			" invoice_split_num = NULL, " + 
			" invoice_agree_time = NULL, " + 
			" invoice_split_id = NULL " + 
			"WHERE " + 
			"	platform_id =?2 " + 
			"AND invoice_master_id = ?3 " + 
			"AND invoice_split_id = ?1", nativeQuery=true)
	Integer removeInvoiceInfo(Long invoiceSplitId, String platformId, Long invoiceMasterId, Long userId,
			String userName);

	/**
	 * 根据发票通知拆分编号查询发票明细
	 * @param invoiceMasterId
	 * @return
	 */
	List<InvoicedetailEntity> findByInvoiceSplitId(Long invoiceSplitId);

}
