package com.brcc.business.agencyInvoice.service;

import java.util.List;

import com.brcc.business.agencyInvoice.entity.ReinvoicedetailEntity;

/**
 * 	代开票明细数据
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoiceDetailService {

    /**
     * 	代开票明细列表
     */
	List<ReinvoicedetailEntity> getReinvoiceDetailList(Long reinvoiceMasterId, String platformId);
	
	/**
     * 	根据代开票ID列表获取代开票明细列表
     */
	List<ReinvoicedetailEntity> getReinvoiceDetailList(List<Long> reinvoiceMasterIdList, String platformId);
	
	/**
	 *	 批量保存
	 */
	void saveBetch(List<ReinvoicedetailEntity> detailList);
}
