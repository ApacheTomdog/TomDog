package com.brcc.business.invoice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.invoice.entity.InvoicedetailLogEntity;

/**
 * @Description 发票明细日志数据接口
 * @author yangwenbin
 * @version 创建时间：2018年11月21日 下午5:29:36
 */
public interface InvoiceDetailLogRepository extends JpaRepository<InvoicedetailLogEntity,Long> {

}
