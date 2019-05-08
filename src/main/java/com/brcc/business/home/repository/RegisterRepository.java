package com.brcc.business.home.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.home.entity.RegisterEntity;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Long>, IRegisterRepository {

	@Query(value=" SELECT a.app_team as platformId FROM	AppSpec a WHERE a.web =? limit 1 ",nativeQuery=true)
	String getPlatformId(String platformFlag);

	@Query(value=" SELECT count(1)  FROM LoginUpLog a WHERE a.login_name = ? AND a.platform_id = ? " ,nativeQuery=true)
	Long queryLoginLogIsHas(String loginName, String platformId);

	@Query(value="SELECT CONCAT(max(a.seq_id),'')	  from Register a where a.login_name = ? ",nativeQuery=true)
	Integer getMaxSeqId(String loginName);
	@Query(value="SELECT *  from Register a where a.seq_id = ? ",nativeQuery=true)
	RegisterEntity findBySeqId(Integer regId);



	

}
