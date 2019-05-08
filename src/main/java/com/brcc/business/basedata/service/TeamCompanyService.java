package com.brcc.business.basedata.service;

import com.brcc.business.basedata.entity.TeamCompanyEntity;
import com.brcc.business.basedata.vo.TeamCompanyVo;

import java.util.List;

/**
 * @Desc:  承运组业务逻辑接口
 * @author TangYong
 * @Date   2018-11-19
 */
public interface TeamCompanyService {

	/**
	 * @Desc  查询定向组的信息
	 * @param appointTeamId
	 * @param platformId
	 */
	TeamCompanyEntity findByTeamId(String appointTeamId, String platformId);

	/**
	 * 获取承运司机信息
	 * @param teamId
	 * @return
	 */
	List<TeamCompanyVo> queryDriverVehicleInfo(Long teamId);
	
	/**
	 * @Desc  查询定向组的信息
	 * @param cyCompanyId
	 * @param fdCompanyId
	 * @param platformId
	 */
	TeamCompanyEntity findTeamId(Integer cyCompanyId, Integer fdCompanyId,String platformId);

}
