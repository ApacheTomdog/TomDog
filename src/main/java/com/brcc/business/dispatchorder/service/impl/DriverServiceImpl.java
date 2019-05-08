package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.DriverEntity;
import com.brcc.business.dispatchorder.repository.DriverRepository;
import com.brcc.business.dispatchorder.service.DriverService;
import com.brcc.business.dispatchorder.vo.DriverVo;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 司机业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-12-04 10:06
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Page<DriverVo> findDriverInfo(TransOrderSearchVo vo) {
        return driverRepository.findDriverInfo(vo);
    }

    @Override
    public DriverEntity findById(Long id) {
        return driverRepository.findById(id).get();
    }

    @Override
    public DriverEntity findByIdAndFromPlatId(Long id, String fromPlatId) {
        return driverRepository.findByIdAndFromPlatId(id, fromPlatId);
    }
}