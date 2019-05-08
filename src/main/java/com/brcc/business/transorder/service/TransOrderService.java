package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.TransportationmEntity;
import com.brcc.business.transorder.vo.TransOrderSearchVo;
import com.brcc.business.transorder.vo.TransOrderVo;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述:
 * 平台运输单逻辑接口类
 *
 * @author yushaohua
 * @create 2018-10-31 17:50
 */
public interface TransOrderService {

    /**
     * 分页查询平台运输单数据
     * @param vo
     * @return
     */
    Page<TransOrderVo> pageData(TransOrderSearchVo vo);

    /**
     * 查询平台运输单数据
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
     * 分页查询货主运输单
     * @param vo
     * @return
     */
    List<TransOrderVo> findPublisherListData(TransOrderSearchVo vo);

    void updateStatus(TransOrderSearchVo vo);

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
     * 飞单
     * @param vo
     */
    void flyOrder(TransOrderSearchVo vo);

    /**
     * 验证调度单环境
     * @param vo
     */
    TransportationmEntity verifyDelivery(TransOrderSearchVo vo);

    /**
     * 运费修改
     * @param vo
     */
    void modifyPrice(TransOrderSearchVo vo);

    /**
     * 更新货源单数据
     * @param deliveryId
     * @param transId
     * @param platformId
     */
    void dispatchWeightBack( String deliveryId, String transId, String platformId);

    /**
     * 调度
     * @param vo
     */
    String dispatch(TransOrderSearchVo vo);

    /**
     * 获取对象
     * @param transId
     * @param platformId
     * @return
     */
    TransportationmEntity findByTransIdAndPlatformId(Long transId, String platformId);

    void updateStatus(String status, Long userId, BigDecimal deliveryWeight, BigDecimal deliveryQty, BigDecimal deliveryAmount, String transId, String platformId);

    /**
     * 根据运单号查询运单数据
     * @param transIdStr
     */
    List<TransportationmEntity> getTransorderList(String transIdStr);

    /**
     * 拼单调度
     * @param String
     */
    String pindanDispatch(TransOrderSearchVo vo) throws Exception;
}