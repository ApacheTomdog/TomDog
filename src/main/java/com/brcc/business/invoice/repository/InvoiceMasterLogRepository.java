package com.brcc.business.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brcc.business.invoice.entity.InvoicemasterLogEntity;

/**
 * @Description 发票通知单日志数据接口
 * @author yangwenbin
 * @version 创建时间：2018年11月21日 下午5:28:20
 */
public interface InvoiceMasterLogRepository extends JpaRepository<InvoicemasterLogEntity,Long> {


}
