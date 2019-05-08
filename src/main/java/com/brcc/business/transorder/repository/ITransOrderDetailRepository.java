package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.vo.TransOrderDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDetailVo;

import java.util.List;

/**
 * 描述:
 * 平台运输单详情数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-11-01 16:48
 */
public interface ITransOrderDetailRepository {

    /**
     * 查询平台运输单详情(含税委托方查看)
     * @param vo
     * @return
     */
    List<TransOrderDetailVo> findTaxOrderDetail(TransOrderDetailSearchVo vo);

    /**
     * 查询平台运输单详情
     * @param vo
     * @return
     */
    List<TransOrderDetailVo> findOrderDetail(TransOrderDetailSearchVo vo);
}