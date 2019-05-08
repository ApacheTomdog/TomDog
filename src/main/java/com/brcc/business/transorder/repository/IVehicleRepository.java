package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.VehicleVo;
import org.springframework.data.domain.Page;

/**
 * 描述:
 * 车辆信息数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-12-04 14:10
 */
public interface IVehicleRepository  {

    /**
     * 获取车辆信息
     * @return
     */
    Page<VehicleVo> queryVehicleId(TransOrderSearchVo vo);

}