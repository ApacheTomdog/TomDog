package com.brcc.business.vatcapital.repository;

import com.brcc.business.vatcapital.entity.VatcapitaldetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description:
 * @Auther: gemaochao
 * @Date:Created in 13:17 2018/11/16
 */
public interface VatCapitalDetailRepository extends JpaRepository<VatcapitaldetailEntity,Long>, IVatCapitalDetailRepository {

	/**
	 * 更新资金明细表上的开票标记
	 * @param invoiceSplitId
	 * @param platformId
	 * @param ifInvoice
	 * @param oldIfInvoice 
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE vatcapitaldetail t, " + 
			" invoicedetail i " + 
			"SET t.if_invoice = ?3 " + 
			"WHERE " + 
			"	t.vat_capital_detail_id = i.vat_capital_detail_id " + 
			"AND i.invoice_split_id = ?1 " + 
			"AND i.platform_id = ?2 " + 
			"AND ifnull(t.if_invoice, 0) = ?4", nativeQuery=true)
	Integer updateIfInvoiceFlag(Long invoiceSplitId, String platformId, String ifInvoice, String oldIfInvoice);
}