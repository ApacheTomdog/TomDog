package com.brcc.business.agencyInvoice.service;

import java.util.List;

import com.brcc.business.agencyInvoice.entity.ReinvoicetempEntity;

/**
 * 	代开票发票导入日志
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoiceTempService {
	/**
	 *	 批量保存日志
	 */
	void saveBetch(List<ReinvoicetempEntity> tempList);
}
