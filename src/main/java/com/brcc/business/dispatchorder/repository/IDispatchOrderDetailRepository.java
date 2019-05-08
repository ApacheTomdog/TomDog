package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderSumVo;
import org.springframework.data.domain.Page;

/**
 * 描述:
 * 平台调度单详单数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-11-05 20:25
 */
public interface IDispatchOrderDetailRepository {

    /**
     * 分页查询平台运输单详单
     * @param vo
     * @return
     */
    Page<DispatchOrderDetailVo> findAllPage(DispatchOrderDetailSearchVo vo);

    /**
     * 平台调度单统计
     * @param vo
     * @return
     */
    DispatchOrderSumVo findOrderSum(DispatchOrderDetailSearchVo vo);
}