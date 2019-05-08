package com.brcc.business.basedata.repository;

import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.basedata.vo.CatalogQueryVo;

/**
 * @Desc:   货物类型数据扩展接口
 * @author: TangYong
 * @Date:   2018-11-19
 */
public interface ICatalogRepository {
	/**
	 * @param catalogQueryVo 
	 * @Desc: 查询货源的货物品种
	 * @param catalogQueryVo
	 * */
	CatalogInfoVo queryCatalogIdAndName(CatalogQueryVo catalogQueryVo);
	
	/**
	 * @Desc: 查询货源大品种信息
	 * @param queryVo
	 * */
	CatalogInfoVo getCatalogInfo(CatalogQueryVo queryVo);

}
