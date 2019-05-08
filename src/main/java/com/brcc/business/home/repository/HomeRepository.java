package com.brcc.business.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.home.entity.HomeEntity;
import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;

public interface HomeRepository extends JpaRepository<HomeEntity, Long>,IHomeRepository{
	@Query(value="SELECT COUNT(1)  FROM apptms.loginverify t "
			+ "WHERE t.login_type = 'APP' "
			+ " AND t.user_type = 'GR' "
			+ " AND t. STATUS = '20' "
			+ " AND DATE_FORMAT(t.last_login_time,'%Y-%m-%d') = ? "
			+ " ",nativeQuery=true)
	Long getOnlineDriverNum(String today);

	
	
}
