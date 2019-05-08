package com.brcc.business.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.home.entity.MenuRoleNewEntity;
import com.brcc.business.home.entity.MenuUserNewEntity;

public interface MenuUserRepository extends JpaRepository<MenuUserNewEntity, Long>{

	@Query(value="SELECT * FROM menurole_new WHERE role_id = ?",nativeQuery=true)
	MenuRoleNewEntity getMenuRoleNewEntityByRoleId(String roleId);

}
