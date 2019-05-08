package com.brcc.business.goodsorderm.repository;

import java.util.List;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;

/**
* @Desc   货源单货物单价报价记录数据扩展接口
* @author TangYong
* @Date   2018-12-05
*/
public interface IGoodsorderquotationRepository {
	 /**
     * 货源单报价列表
     * @param vo
     * @return
     */
	List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo); 
	
	/**查询报价记录*/
	GoodsorderquotationVo getBaojiaInfo(GoodsorderquotationQueryVo vo);

	/**查询其他的报价记录*/
	List<GoodsorderquotationVo> getOtherBaojiaMessage(GoodsorderquotationVo vo);

}
