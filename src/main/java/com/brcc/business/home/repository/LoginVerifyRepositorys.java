package com.brcc.business.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;
import com.brcc.business.transorder.entity.LoginverifyEntity;

public interface LoginVerifyRepositorys extends JpaRepository<LoginverifyEntity,Long> {

	@Query(value="SELECT CONCAT(max(a.user_id),'')  from LoginVerify a where a.login_name = ? ",nativeQuery=true)
	Long getMaxUserId(String loginName);

	@Query(value="SELECT * from LoginVerify where user_id = ? ",nativeQuery=true)
	LoginverifyEntity findByUserId(Long maxUserId);
	
	@Query(value="SELECT * from LoginVerify where if_plat_admin='Y' and platform_id = ? ",nativeQuery=true)
	List<LoginverifyEntity> getMobile(String platformId);
	@Query(value="SELECT * from LoginVerify where login_name = ?  and mobile=? ",nativeQuery=true)
	List<LoginverifyEntity> updateVerifCodeAndRemark(String loginName, String companyMobile);

	@Query(value="SELECT * from LoginVerify where login_name = ?  and mobile=?  and verif_code=?  ORDER BY create_date DESC ",nativeQuery=true)
	LoginverifyEntity getDetailInfo(String loginName, String companyMobile, String code);


	

}
