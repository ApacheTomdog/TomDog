package com.brcc.business.basedata.service;

import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.basedata.vo.CatalogQueryVo;

/**
 * @Desc:  货物类型业务逻辑接口
 * @author TangYong
 * @Date   2018-10-28
 */
public interface CatalogService {

	/**
	 * @Desc: 查询货源的货物品种
	 * @param catalogQueryVo
	 * */
	CatalogInfoVo queryCatalogIdAndName(CatalogQueryVo catalogQueryVo);

	/**
	 * @Desc: 查询货源的大品种品种
	 * @param catalogQueryVo
	 * */
	CatalogInfoVo getCatalogInfo(CatalogQueryVo queryVo);

	

  
}
