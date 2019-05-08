package com.brcc.business.goodsorderm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;

/**
* @Desc   货源单货物单价报价记录数据处理接口
* @author TangYong
* @Date   2018-12-05
*/

public interface GoodsorderquotationRepository extends JpaRepository<GoodsorderquotationEntity,Long>,IGoodsorderquotationRepository{

	/**查询报价次数*/
	@Query(value="select count(1) from GoodsOrderQuotation a where a.publish_id = ? and	"
			+ "a.plat_form_id = ? and a.company_id = ? and	a.status != '20'",nativeQuery=true)
	Long queryBaojiaCounts(Long publishId, String platFormId, Long long2);


}
