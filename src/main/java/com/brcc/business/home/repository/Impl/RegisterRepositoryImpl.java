package com.brcc.business.home.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import com.brcc.business.home.vo.RegisterCommonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.brcc.business.home.repository.IRegisterRepository;
import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterRepositoryImpl implements IRegisterRepository {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PageQuery pageQuery;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<RegisterVo> registerName(RegisterQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT a.login_name,a.login_type,a.user_id,a.platform_id FROM LoginVerify a WHERE");
	
		sql.append(" a.login_name =?");
		params.add(queryVo.getLoginName());
		sql.append("  and  a.platform_id =?");
		params.add(queryVo.getPlatformId());
		
		return pageQuery.list(sql.toString(), params, RegisterVo.class);
	}

	@Override
	public List<RegisterVo> registerCompany(RegisterQueryVo queryVo) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT a.company_name FROM company a WHERE");
	
		sql.append(" a.company_name =?");
		params.add(queryVo.getCompanyName());
		sql.append("  and  a.platform_id =?");
		params.add(queryVo.getPlatformId());
		
		return pageQuery.list(sql.toString(), params, RegisterVo.class);
	}

	@Override
	public void menuSetNew(RegisterCommonVo vo){
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" insert into menuuser_new(user_id,menu_id,create_date) ");
		sql.append(" select ");
		sql.append(" ?,a.menu_id,now() ");
		sql.append(" from menurole_new a ");
		sql.append(" where a.role_id = ? ");

		args.add(vo.getUserId());
		args.add(vo.getRoleId());
		jdbcTemplate.update(sql.toString(), args.toArray());
	}
}
