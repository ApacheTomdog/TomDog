package com.brcc.business.goodsorderm.service;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;

/**
* @Desc   货源单货物单价修改记录逻辑接口
* @author TangYong
* @Date   2018-12-05
*/
public interface GoodpricechangelogService {

	/**保存实体*/
	void save(GoodpricechangelogEntity goodpricechangelogEntity);

	/**货源单货物单价调整列表数据*/
	Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo);
	 
}
