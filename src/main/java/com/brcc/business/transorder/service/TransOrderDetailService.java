package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.GoodsordermEntity;
import com.brcc.business.transorder.vo.TransOrderDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDetailVo;

import java.math.BigDecimal;

/**
 * 描述:
 * 平台运输单详情业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-01 17:08
 */
public interface TransOrderDetailService {

    /**
     * 查询平台运输单详情
     * @param vo
     * @return
     */
    TransOrderDetailVo findOrderDetail(TransOrderDetailSearchVo vo);

    /**
     * 更新状态
     * @param publishId
     */
    void updateGoodsOrderMStatus(String publishId);

    /**
     * 作废运输订单将量返回货源单（货源单未终止）
     * @param weight
     * @param qty
     * @param amount
     * @param publishId
     * @param platformId
     */
    void updateResource(BigDecimal weight, BigDecimal qty, BigDecimal amount, String publishId, String platformId);

    /**
     *  作废运输订单将量返回货源单（货源单已终止）
     * @param weight
     * @param qty
     * @param amount
     * @param publishId
     * @param platformId
     */
    void updateSaleResource(BigDecimal weight, BigDecimal qty, BigDecimal amount, String publishId, String platformId);

    /**
     * 获取对象
     * @param publishId
     * @param platformId
     * @return
     */
    GoodsordermEntity findByPublishIdAndPlatformId(Long publishId, String platformId);

    GoodsordermEntity findById(Long publishId);

    GoodsordermEntity save(GoodsordermEntity goodsordermEntity);

    void updateGoodsStatus(String status, Long updatePerson, String remark, Long publishId, String platformId);
}