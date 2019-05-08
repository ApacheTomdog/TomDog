package com.brcc.business.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.company.entity.CompanyEntity;

public interface CompanyRepositorys extends JpaRepository<CompanyEntity, Long>{

	@Query(value="SELECT CONCAT(max(a.seq_id),'')	  from Company a where a.user_id = ? ",nativeQuery=true)
	Long getMaxCompanyId(Long maxUserId);

}
