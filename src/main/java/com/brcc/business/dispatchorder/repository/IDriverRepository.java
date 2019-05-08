package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.DriverEntity;
import com.brcc.business.dispatchorder.vo.DriverVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import org.springframework.data.domain.Page;

/**
 * 描述:
 * 司机数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-12-04 14:00
 */
public interface IDriverRepository {

    /**
     * 查询司机信息
     * @return
     */
    Page<DriverVo> findDriverInfo(TransOrderSearchVo vo);
}