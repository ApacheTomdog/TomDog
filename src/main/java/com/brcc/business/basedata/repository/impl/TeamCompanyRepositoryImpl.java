package com.brcc.business.basedata.repository.impl;

import com.brcc.business.basedata.repository.ITeamCompanyRepository;
import com.brcc.business.basedata.vo.TeamCompanyVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 承运组数据接口实现类
 *
 * @author yushaohua
 * @create 2018-11-23 16:02
 */
public class TeamCompanyRepositoryImpl implements ITeamCompanyRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public List<TeamCompanyVo> queryDriverVehicleInfo(Long teamId) {
        StringBuffer sql = new StringBuffer("SELECT ");
        sql.append("  t.team_id AS teamId, ");
        sql.append("  t.cy_company_id AS companyId, ");
        sql.append("  t1.driver_id AS driverId, ");
        sql.append("  t1.vehicle_id AS vehicleId, ");
        sql.append("  t2.company_name AS companyName, ");
        sql.append("  t3.name AS driverName, ");
        sql.append("  t3.phone AS driverMobile ");
        sql.append("FROM ");
        sql.append("  teamcompany t ");
        sql.append("  JOIN loginverify t1 ");
        sql.append("  JOIN company t2 ");
        sql.append("  JOIN driver t3 ");
        sql.append("WHERE t.cy_company_id = t1.company_id ");
        sql.append("  AND t2.seq_id = t.cy_company_id ");
        sql.append("  AND t1.driver_id = t3.id ");
        sql.append("  AND t.team_id = ? LIMIT 0 , 1 ");

        List<Object> args = new ArrayList<Object>();
        args.add(teamId);

        return pageQuery.list(sql.toString(), args, TeamCompanyVo.class);
    }

}