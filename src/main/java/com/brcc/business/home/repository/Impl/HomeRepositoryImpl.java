package com.brcc.business.home.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.brcc.business.home.repository.IHomeRepository;
import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;
import com.esteel.common.dao.PageQuery;

public class HomeRepositoryImpl implements IHomeRepository {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PageQuery pageQuery;
	
	@Override
	public List<HomeVo> getRealTimeDate(HomeQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT  t.total_deal_ton,t.total_deal_vehicle_num,t.total_register_num,t.yesterday_deal_vehicle_num FROM apptms.firstpagedisplay t WHERE ");
	
		sql.append(" t.first_page_date =?");
		params.add(queryVo.getYesterday());
		//sql.append(" AND t.platform_id = (SELECT a.app_team FROM appspec a WHERE a.web = ?)");
		//params.add(queryVo.getDomain());
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}

	@Override
	public List<HomeVo> getMenuId(HomeQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT m.menu_id FROM apptms.menuuser_new m WHERE ");
	
		sql.append("  m.user_id =?");
		params.add(queryVo.getUserId());
		sql.append("  AND m.menu_id=?");
		params.add(queryVo.getMenuId());
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}

	@Override
	public List<HomeVo> getRegisterCount(HomeQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT count(1) as count,"
				+ "(SELECT count(1) from company c1 where c1.`status`='10' and ifnull(c1.if_publish,'N') != 'Y' AND c1.create_date >= CURDATE()) as count2,"
				+ "(SELECT count(1) from company c1 where c1.`status`='20' and ifnull(c1.if_publish,'N') != 'Y'  AND c1.create_date >= CURDATE()) as count1 "
				+ "FROM	company c WHERE 1 = 1 "
				+ "and ifnull(c.if_publish,'N') != 'Y' "
				+ "AND c.create_date >= CURDATE()" );
		sql.append("  and c.platform_id =?");
		params.add(queryVo.getPlatformId());
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}

	@Override
	public List<HomeVo> getCarry(HomeQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		logger.info(queryVo.getCompanyId()+">>>>>>>>>>>>>>>.");
			sql.append("SELECT count(1) AS count3,ifnull(SUM(t.init_weight), 0) AS weightsum FROM transportationm t WHERE 1 = 1");
		
			
		sql.append("  and t.platform_id =?");
		params.add(queryVo.getPlatformId());
		
		if (!ObjectUtils.isEmpty(queryVo.getCompanyId())) {
			sql.append(" AND t.company_id = ? ");
			params.add(queryVo.getCompanyId());
		}
		
		if (!ObjectUtils.isEmpty(queryVo.getAccountFrom()) && queryVo.getAccountFrom().equals("DS") ) {
			sql.append(" AND t.fd_user_id = ? ");
			params.add(queryVo.getUserId());
		}
		/*if (!ObjectUtils.isEmpty(queryVo.getPublishCompanyId())) {
			sql.append(" AND t.publish_company_id = ? ");
			params.add(queryVo.getPublishCompanyId());
		} */
		sql.append(" AND t.create_date >= CURDATE()");
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}

	@Override
	public List<HomeVo> getMapPointDate() {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT floor(count(1) * 2.65) AS vehicle,"
				+ "floor(count(1) * 2.65 * 1.5) AS driver,"
				+ "a.province_name AS text,"
				+ "a.province_sn_py AS `name` "
				+ "FROM`vehicle` v LEFT JOIN area_province_vehicle a ON a.province_sn = v.province_sn "
				+ "WHERE a.province_sn_py IS NOT NULL "
				+ " AND v.platform_id = 'SX*HSY*0001' "
				+ " GROUP BY v.province_sn " );
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}

	@Override
	public List<HomeVo> getSender(HomeQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		logger.info(queryVo.getCompanyId()+">>>>>>>>>>>>>>>.");
		
	
			sql.append("SELECT count(1) AS count4,ifnull(SUM(t.init_weight), 0) AS weightsum1 FROM transportationm t WHERE 1 = 1");
		
			
		sql.append("  and t.platform_id =?");
		params.add(queryVo.getPlatformId());
		
		/*if (!ObjectUtils.isEmpty(queryVo.getCompanyId())) {
			sql.append(" AND t.company_id = ? ");
			params.add(queryVo.getCompanyId());
		}*/
		
		if (!ObjectUtils.isEmpty(queryVo.getAccountFrom()) && queryVo.getAccountFrom().equals("DS") ) {
			sql.append(" AND t.fd_user_id = ? ");
			params.add(queryVo.getUserId());
		}
		if (!ObjectUtils.isEmpty(queryVo.getPublishCompanyId())) {
			sql.append(" AND t.publish_company_id = ? ");
			params.add(queryVo.getPublishCompanyId());
		} 
		sql.append(" AND t.create_date >= CURDATE()");
		return pageQuery.list(sql.toString(), params, HomeVo.class);
	}


	
	
}
