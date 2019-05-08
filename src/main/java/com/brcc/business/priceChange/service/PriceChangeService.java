package com.brcc.business.priceChange.service;

import org.springframework.data.domain.Page;

import com.brcc.business.priceChange.entity.PriceChangeEntity;
import com.brcc.business.priceChange.vo.PriceChangeQueryVo;
import com.brcc.business.priceChange.vo.PriceChangeVo;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public interface PriceChangeService {
	
	/**
	 * 委托承运货源审核管理列表
	 * 
	 * @param queryvo
	 * @return
	 */
	Page<PriceChangeVo> listDataList(PriceChangeQueryVo queryvo);
	
	/**
	 * 委托承运调价管理列表
	 * 
	 * @param queryvo
	 * @return
	 */
	Page<PriceChangeVo> queryList(PriceChangeQueryVo queryvo);
	
	/**
	 * 插入
	 */
	void save(PriceChangeVo vo);
	
	/**
	 * 委托承运货源审核管理作废
	 */
	public void delPriceChange(PriceChangeVo vo);
	/**
	 * 委托承运调价管理 保存
	 * 
	 */
	public void saveUpdate(PriceChangeVo vo);
	
	/**
	 * 委托承运货源审核管理查询价格
	 */
	PriceChangeVo getPrice(PriceChangeVo vo);
	
	/**
	 * 委托承运调价管理查询价格
	 */
	PriceChangeVo getPriceTJ(PriceChangeVo vo);
	

}
