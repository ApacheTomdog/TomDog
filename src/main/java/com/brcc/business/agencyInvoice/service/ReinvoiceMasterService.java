package com.brcc.business.agencyInvoice.service;

import java.util.List;

import com.brcc.business.agencyInvoice.entity.ReinvoicemasterEntity;
import com.brcc.business.agencyInvoice.vo.DealPrintFlagVo;

/**
 * 	代开票主项数据
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoiceMasterService {

    /**
     * 	代开票明细列表
     */
	ReinvoicemasterEntity getReinvoiceMaster(Long reinvoiceMasterId, String platformId);
	
	/**
	 * 	批量修改打印状态
	 */
	void dealPrintFlag(DealPrintFlagVo dealPrintFlagVo);
	
	/**
	 * 	根据代开票号获取代开票主项数据列表
	 */
	List<ReinvoicemasterEntity> getReinvoiceMasterList(List<String> reinvoiceMasterNumList, String platformId);
	
	/**
	 *	 批量保存
	 */
	void saveBetch(List<ReinvoicemasterEntity> reinvoiceMasterList);
}
