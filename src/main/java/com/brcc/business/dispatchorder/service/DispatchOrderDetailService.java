package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.DeliveryuploadConfigEntity;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailSearchVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderDetailVo;
import com.brcc.business.dispatchorder.vo.DispatchOrderSumVo;
import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 平台调度单详单业务逻辑接口类
 *
 * @author yushaohua
 * @create 2018-11-06 10:38
 */
public interface DispatchOrderDetailService {

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

    /**
     * 如果单据来源于建邦大宗需要先判断对方是否可以撤销单据
     * @param vo
     */
    Map checkDzIfCancel(DispatchOrderDetailSearchVo vo) throws JsonProcessingException;

    /**
     * 更新状态
     * @param vo
     */
    void updateStatus(DispatchOrderDetailSearchVo vo);

    /**
     * 调度单完成时，生成个体工商户开户申请
     * @param vo
     */
    void genBusinessReg(DispatchOrderDetailSearchVo vo);

    HashMap sendDeliveryCancelXml(String requestStr, DeliveryuploadConfigEntity deliveryuploadConfigEntity);

    /**
     * 根据ID获取对象
     * @param deliveryId
     * @return
     */
    TransportationdeliveryEntity findById(Long deliveryId);

    /**
     * 保存对象
     * @param entity
     * @return
     */
    TransportationdeliveryEntity save(TransportationdeliveryEntity entity);
}