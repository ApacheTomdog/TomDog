package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.repository.ViewAbnormalRepository;
import com.brcc.business.transorder.service.ViewAbnormalService;
import com.brcc.business.transorder.vo.ViewAbnormalSearchVo;
import com.brcc.business.transorder.vo.ViewAbnormalVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * 平台调度单异常列表业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-14 17:13
 */
@Service
public class ViewAbnormalServiceImpl implements ViewAbnormalService {

    @Autowired
    private ViewAbnormalRepository viewAbnormalRepository;

    @Override
    public Page<ViewAbnormalVo> findAllPage(ViewAbnormalSearchVo vo) {
        return viewAbnormalRepository.findAllPage(vo);
    }

    @Override
    public List<ViewAbnormalVo> listData(ViewAbnormalSearchVo vo) {
        return viewAbnormalRepository.listData(vo);
    }
}