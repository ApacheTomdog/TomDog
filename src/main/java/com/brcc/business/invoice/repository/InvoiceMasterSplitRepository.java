package com.brcc.business.invoice.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.invoice.entity.InvoicemastersplitEntity;

/**
 * @Description 发票拆分表数据接口
 * @author yangwenbin
 * @version 创建时间：2018年11月27日 下午3:13:14
 */
public interface InvoiceMasterSplitRepository extends JpaRepository<InvoicemastersplitEntity,Long> {

	/**
	 * 更新发票号，开票时间，开票状态
	 * @param invoiceSplitId
	 * @param invoiceNo
	 * @param invoiceAgreeTime
	 * @param status
	 * @param userId
	 * @param userName
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE invoicemastersplit " + 
			"SET invoice_status = ?4, modify_date = now(), " + 
			" modify_person_id = ?5, modify_person_name = ?6, invoice_no = ?2, invoice_agree_time = ?3 " + 
			"WHERE " + 
			"	invoice_split_id = ?1 " + 
			"AND " + 
			"(IF ( " + 
			"	ifnull(invoice_plan_amount, 0) = 0, " + 
			"	ifnull(invoice_actual_amount, 0), " + 
			"	invoice_plan_amount - ifnull(invoice_actual_amount, 0) " + 
			")) >= 0", nativeQuery=true)
	Integer updateInvoiceMasterSplit(Long invoiceSplitId, String invoiceNo, Date invoiceAgreeTime, String status,
			Long userId, String userName);


}
