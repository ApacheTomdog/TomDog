package com.brcc.business.basedata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.basedata.entity.TeamCompanyEntity;
/**
 * @Desc:  承运组数据接口
 * @author TangYong
 * @Date   2018-11-19
 */
public interface TeamCompanyRepository extends JpaRepository<TeamCompanyEntity, Long>, ITeamCompanyRepository{

	/**
	 * @Desc  查询定向组的信息
	 * @param appointTeamId
	 * @param platformId
	 */
	@Query(value="SELECT * FROM teamcompany t where t.team_id = ?  and t.platform_id = ? limit 0,1",nativeQuery=true)
	TeamCompanyEntity findByTeamId(String appointTeamId, String platformId);
	/**
	 * @Desc  查询定向组的信息
	 * @param cyCompanyId
	 * @param fdCompanyId
	 * @param platformId
	 */
	TeamCompanyEntity findByCyCompanyIdAndFdCompanyIdAndPlatformIdAndTypeAndIfSystem(Integer cyCompanyId, Integer fdCompanyId, String platformId,String type,String ifSystem);

}
