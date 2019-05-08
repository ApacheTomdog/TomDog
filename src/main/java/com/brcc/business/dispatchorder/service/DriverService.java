package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.DriverEntity;
import com.brcc.business.dispatchorder.vo.DriverVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import org.springframework.data.domain.Page;

/**
 * 描述:
 * 司机业务逻辑接口类
 *
 * @author yushaohua
 * @create 2018-12-04 10:06
 */
public interface DriverService {

    /**
     * 查询司机信息
     * @return
     */
    Page<DriverVo> findDriverInfo(TransOrderSearchVo vo);

    DriverEntity findById(Long id);

    /**
     * 获取对象
     * @param id
     * @param fromPlatId
     * @return
     */
    DriverEntity findByIdAndFromPlatId(Long id, String fromPlatId);
}