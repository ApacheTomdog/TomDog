package com.brcc.business.invoice.repository;
import com.brcc.business.invoice.entity.InvoicemastersplitLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description 发票日志表
 * @author pjy
 * @version 创建时间：2019年3月25日 上午11:01:55
 */
public interface InvoicemastersplitLogRepository extends JpaRepository<InvoicemastersplitLogEntity,Long> {
}
