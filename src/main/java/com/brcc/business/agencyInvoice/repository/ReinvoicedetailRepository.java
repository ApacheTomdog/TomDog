package com.brcc.business.agencyInvoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brcc.business.agencyInvoice.entity.ReinvoicedetailEntity;

/**
 * 	代开票明细数据交互接口
 * 
 * @author hui.liu
 * @date 2018年12月14日
 */
public interface ReinvoicedetailRepository extends JpaRepository<ReinvoicedetailEntity, Long>{

	List<ReinvoicedetailEntity> findByReinvoiceMasterIdAndPlatformId(Long reinvoiceMasterId, String platformId);
	
	@Query(value="select * from reinvoicedetail where platform_id = :platformId and reinvoice_master_id in :reinvoiceMasterIdList", nativeQuery=true)
	List<ReinvoicedetailEntity> getReinvoiceDetailList(@Param("platformId") String platformId, @Param("reinvoiceMasterIdList") List<Long> reinvoiceMasterIdList);
}
