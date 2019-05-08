package com.brcc.business.basedata.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.basedata.entity.CatalogEntity;
import com.brcc.business.basedata.repository.ICatalogRepository;
import com.brcc.business.basedata.vo.CatalogQueryVo;
import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.esteel.common.dao.PageQuery;


/**
 * @Desc:    货物类型数据接口实现类
 * @author: TangYong
 * @Date:   2018-11-19
 */
public class CatalogRepositoryImpl implements ICatalogRepository {

    @Autowired
    PageQuery pageQuery;
    public Page<CatalogEntity> findCatalogPage(CatalogQueryVo vo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT * "); 
	    sql.append("FROM ");
	    sql.append("  catalog  ");
	    sql.append("WHERE 1=1   ");
	    sql.append("  AND status = 20 ");
	    
	    // layer区分大小品种
		if(StringUtils.isNotEmpty(vo.getLayer())) {
			sql.append(" AND layer = ? ");
			args.add(vo.getLayer());
		}
		// 品名
		if(StringUtils.isNotEmpty(vo.getName())) {
			sql.append(" AND name like ? ");
			args.add("%"+ vo.getName() +"%");
		}
		// 平台ID
		if(StringUtils.isNotEmpty(vo.getPlatformId())) {
			sql.append(" AND platform_id = ? ");
			args.add(vo.getPlatformId());
		}
		
		return pageQuery.query(sql.toString(), args, vo,CatalogEntity.class);
	}
    
	@Override
	public CatalogInfoVo queryCatalogIdAndName(CatalogQueryVo catalogQueryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	c1.id as catalogId,");
		sql.append("	c1.name as catalogName "); 
		sql.append("FROM ");
		sql.append("	catalog c,");
		sql.append("	catalog c1 ");
		sql.append("WHERE 1=1 ");
		sql.append("AND c1.id = c.parent_id ");
		sql.append("AND (? = c.id or ? =c.name) ");
		args.add(catalogQueryVo.getGoodType());
		args.add(catalogQueryVo.getGoodTypeDesc());
		sql.append("AND c.status = '20' ");
		sql.append("AND c1.status = '20' ");
		sql.append("AND c1.layer='1' ");
		sql.append("AND c.platform_id= ? ");
		args.add(catalogQueryVo.getPlatformId());
		sql.append("LIMIT 0,1");
		List<CatalogInfoVo> list = pageQuery.list(sql.toString(), args, CatalogInfoVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}

	@Override
	public CatalogInfoVo getCatalogInfo(CatalogQueryVo queryVo) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append("SELECT ");
		sql.append("	c.id,"); 
		sql.append("	c.name,");
		sql.append("	d.id as 'goodType' ");
		sql.append("from catalog c,catalog d ");
		sql.append("where c.id = d.parent_id ");
		sql.append("	and   d.id = ? ");
		sql.append("	and  c.platform_id = ? ");
		sql.append("	and  d.platform_id = ? ");
		sql.append("	and  d.status ='20' ");
		args.add(queryVo.getGoodType());
		args.add(queryVo.getPlatformId());
		args.add(queryVo.getPlatformId());
		List<CatalogInfoVo> list = pageQuery.list(sql.toString(), args, CatalogInfoVo.class);
		return ObjectUtils.isEmpty(list) ? null : list.get(0);
	}
	
	
}
