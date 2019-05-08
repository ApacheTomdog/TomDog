package com.brcc.business.transorder.repository.impl;

import com.brcc.business.transorder.repository.IVehicleRepository;
import com.brcc.business.transorder.vo.CarInfo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.VehicleVo;
import com.esteel.common.dao.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 车辆信息数据接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 14:14
 */
public class VehicleRepositoryImpl implements IVehicleRepository {

    @Autowired
    PageQuery pageQuery;

    @Override
    public Page<VehicleVo> queryVehicleId(TransOrderSearchVo vo) {
        StringBuffer sql = new StringBuffer("select *,");
        sql.append("if((select count(1) from TransportationDelivery t2 where t2.vehicle_id=b.vehicle_id and t2.status > '00' and t2.status < '90') > 0,'装载','空闲') as vehicleStatus ");
        sql.append(" from CompanyToVehicle a , Vehicle b  ");
        sql.append(" where a.vehicle_id = b.vehicle_id AND  a.platform_id = ? and a.company_id = ? and a.status = '20' ");

        List<Object> args = new ArrayList<>();
        args.add(vo.getPlatformId());
        args.add(vo.getCompanyId());

        // 川威传来的车牌号（add by TangYong）
        if(vo.getCarInfoList() != null && vo.getCarInfoList().size() > 0){
            List<CarInfo> carInfoList = vo.getCarInfoList();
            String vehicleStr = "";
            for (int i = 0; i < carInfoList.size(); i++) {
                if(i !=  carInfoList.size()-1) {
                    vehicleStr += "'" + carInfoList.get(i).getCph() + "',";
                }else {
                    vehicleStr += "'"+ carInfoList.get(i).getCph() + "'";
                }
            }
            sql.append(" AND b.vehicle_num in (");
            sql.append(""+ vehicleStr +" )");
        }

        if (!ObjectUtils.isEmpty(vo.getVehicleNum())){
            sql.append(" AND b.vehicle_num like CONCAT('%',?,'%') ");
            args.add(vo.getVehicleNum());
        }

        return pageQuery.query(sql.toString(), args, vo, VehicleVo.class);
    }
}