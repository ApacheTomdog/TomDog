package com.brcc.business.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.invoice.entity.InvoicemasterEntity;

/**
 * @Description 发票通知单数据接口
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:01:55
 */
public interface InvoiceMasterRepository extends JpaRepository<InvoicemasterEntity,Long> {


}
