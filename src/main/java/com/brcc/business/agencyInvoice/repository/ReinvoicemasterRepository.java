package com.brcc.business.agencyInvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brcc.business.agencyInvoice.entity.ReinvoicemasterEntity;

/**
 * 	代开票数据交互接口
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoicemasterRepository extends JpaRepository<ReinvoicemasterEntity, Long>{
	
	@Modifying
	@Query(value="update reinvoicemaster set if_print = :ifPrint where platform_id = :platformId and reinvoice_master_id in :reinvoiceMasterIdList", nativeQuery=true)
	void dealPrintFlag(@Param("ifPrint") Integer ifPrint, @Param("platformId") String platformId, @Param("reinvoiceMasterIdList") List<Long> reinvoiceMasterIdList);
	
	@Query(value="select * from reinvoicemaster where platform_id = :platformId and reinvoice_master_num in :reinvoiceMasterNumList", nativeQuery=true)
	List<ReinvoicemasterEntity> getReinvoiceMasterList(@Param("platformId") String platformId, @Param("reinvoiceMasterNumList") List<String> reinvoiceMasterNumList);
}
