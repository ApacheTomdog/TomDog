package com.brcc.business.agencyInvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.agencyInvoice.entity.ReinvoicetempEntity;

/**
 * 	代开票发票导入日志交互接口
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoicetempRepository extends JpaRepository<ReinvoicetempEntity, Long>{

}
