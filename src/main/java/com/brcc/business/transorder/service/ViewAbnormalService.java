package com.brcc.business.transorder.service;

import com.brcc.business.transorder.vo.ViewAbnormalSearchVo;
import com.brcc.business.transorder.vo.ViewAbnormalVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 描述:
 * 平台调度单异常列表业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-14 17:12
 */
public interface ViewAbnormalService {

    /**
     * 分页查询平台调度单异常列表分页数据
     * @param vo
     * @return
     */
    Page<ViewAbnormalVo> findAllPage(ViewAbnormalSearchVo vo);

    /**
     * 分页查询平台调度单异常列表数据
     * @param vo
     * @return
     */
    List<ViewAbnormalVo> listData(ViewAbnormalSearchVo vo);
}