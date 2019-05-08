package com.brcc.business.goodsorderm.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;


/**
* @Desc   货源单货物单价修改记录数据处理扩展类
* @author TangYong
* @Date   2019-02-19
*/
public interface IGoodpricechangelogRepository {

	/**货源单货物单价调整列表数据*/
	Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo);  
}
