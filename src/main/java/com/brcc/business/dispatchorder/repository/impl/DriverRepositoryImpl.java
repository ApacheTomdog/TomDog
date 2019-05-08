package com.brcc.business.dispatchorder.repository.impl;

import com.brcc.business.dispatchorder.repository.IDriverRepository;
import com.brcc.business.dispatchorder.vo.DriverVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 司机数据接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 14:01
 */
public class DriverRepositoryImpl implements IDriverRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<DriverVo> findDriverInfo(TransOrderSearchVo vo) {
        List<Object> args = new ArrayList<>();

        StringBuffer sql = new StringBuffer("select b.*, CONCAT(b.name, ', 手机号：', b.phone) as info, l.vehicle_id as ifRed ");
        sql.append(" from CompanyToDriver a LEFT JOIN Driver b on(a.driver_id = b.id) LEFT JOIN loginverify l on(l.driver_id = a.driver_id and l.platform_id=a.platform_id AND l.vehicle_id = ?) ");
        sql.append(" where a.platform_id=? and a.company_id=? and a.status = '20' ");

        if(vo.getVehicleId() == null){
            args.add(0);
        }else{
            args.add(vo.getVehicleId());
        }

        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        if (!ObjectUtils.isEmpty(vo.getInfo())){
            sql.append(" AND (b.name like CONCAT('%',?,'%') or b.phone like CONCAT('%',?,'%')) ");
            args.add(vo.getInfo());
            args.add(vo.getInfo());
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleId())){
            sql.append(" ORDER BY if(l.vehicle_id="+vo.getVehicleId()+", "+vo.getVehicleId()+", 0) DESC ");
        }else{
            sql.append(" order by CONVERT( b.name USING gbk ) COLLATE gbk_chinese_ci desc");
        }

        return pageQuery.query(sql.toString(), args, vo, DriverVo.class);
    }
}