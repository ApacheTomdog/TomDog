package com.brcc.business.basedata.repository;

import com.brcc.business.basedata.vo.TeamCompanyVo;

import java.util.List;

/**
 * 描述:
 * 承运组数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-11-23 16:00
 */
public interface ITeamCompanyRepository {

    /**
     * 获取承运司机信息
     * @param teamId
     * @return
     */
    List<TeamCompanyVo> queryDriverVehicleInfo(Long teamId);
}