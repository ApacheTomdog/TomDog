package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.TransOrderVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-10-31 17:01
 */
public interface ITransOrderRepository {

    /**
     * 分页查询平台运输单
     * @param vo
     * @return
     */
    Page<TransOrderVo> findAllPage(TransOrderSearchVo vo);

    /**
     * 查询平台运输单
     * @param vo
     * @return
     */
    List<TransOrderVo> findAll(TransOrderSearchVo vo);

    /**
     * 分页查询货主运输单
     * @param vo
     * @return
     */
    Page<TransOrderVo> findPublisherAllPage(TransOrderSearchVo vo);

    /**
     * 查询货主运输单列表
     * @param vo
     * @return
     */
    List<TransOrderVo> findPublisherListData(TransOrderSearchVo vo);

    /**
     * 分页查询委托承运运输订单
     * @param vo
     * @return
     */
    Page<TransOrderVo> findTaxTransportationmPage(TransOrderSearchVo vo);

    /**
     * 查询委托承运运输订单列表
     * @param vo
     * @return
     */
    List<TransOrderVo> findTaxTransportationmList(TransOrderSearchVo vo);

    /**
     * 保存运输单
     * @param paramMap
     */
    void saveNewOrder(Map<String, Object> paramMap);
}