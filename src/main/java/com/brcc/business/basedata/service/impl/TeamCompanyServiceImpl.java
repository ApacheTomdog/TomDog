package com.brcc.business.basedata.service.impl;

import com.brcc.business.basedata.vo.TeamCompanyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.basedata.entity.TeamCompanyEntity;
import com.brcc.business.basedata.repository.TeamCompanyRepository;
import com.brcc.business.basedata.service.TeamCompanyService;

import java.util.List;


/**
 * @Desc:  承运组业务逻辑接口实现类
 * @author TangYong
 * @Date   2018-11-16
 */
@Service
public class TeamCompanyServiceImpl implements TeamCompanyService {

    Logger logger = LoggerFactory.getLogger(TeamCompanyServiceImpl.class);

    @Autowired
    TeamCompanyRepository  teamCompanyRepository;

	@Override
	public TeamCompanyEntity findByTeamId(String appointTeamId, String platformId) {
		logger.info("query teamcompany by appointTeamId and platformId",appointTeamId,platformId);
		return teamCompanyRepository.findByTeamId(appointTeamId,platformId);
	}

	@Override
	public List<TeamCompanyVo> queryDriverVehicleInfo(Long teamId) {
		return teamCompanyRepository.queryDriverVehicleInfo(teamId);
	}

	@Override
	public TeamCompanyEntity findTeamId(Integer cyCompanyId, Integer fdCompanyId, String platformId) {
		TeamCompanyEntity entity = teamCompanyRepository.findByCyCompanyIdAndFdCompanyIdAndPlatformIdAndTypeAndIfSystem(cyCompanyId, fdCompanyId, platformId, "2", "Y");
		return entity;
	}
}
