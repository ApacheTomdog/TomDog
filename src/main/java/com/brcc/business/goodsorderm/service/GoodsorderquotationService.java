package com.brcc.business.goodsorderm.service;

import java.util.List;

import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;
import com.brcc.business.transorder.entity.ShortmessageEntity;

/**
* @Desc   货源单货物单价报价记录逻辑接口
* @author TangYong
* @Date   2018-12-05
*/
public interface GoodsorderquotationService {

	/**货源单报价list查询*/
	List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo);

	/**查询报价次数*/
	Long queryBaojiaCounts(GoodsorderquotationQueryVo quotationQueryVo);

	/**保存报价记录*/
	GoodsorderquotationEntity save(GoodsorderquotationEntity quotationEntity);

	/**根据id查询保存报价记录*/
	GoodsorderquotationEntity findById(Long quotationId);

	/**查询报价记录*/
	GoodsorderquotationVo getBaojiaInfo(GoodsorderquotationQueryVo vo);

	/**查询其他报价记录*/
	List<GoodsorderquotationVo> getOtherBaojiaMessage(GoodsorderquotationVo vo);
	
	 
}
