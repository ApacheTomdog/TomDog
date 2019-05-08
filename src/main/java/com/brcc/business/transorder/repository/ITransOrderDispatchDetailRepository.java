package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单调度数据接口扩展类
 *
 * @author yushaohua
 * @create 2018-11-02 10:37
 */
public interface ITransOrderDispatchDetailRepository {

    /**
     * 查询平台运输单详情
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findOrderDetailForCarrier(TransOrderDispatchDetailSearchVo vo);

    /**
     * 查询平台运输单详情
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findOrderDetai(TransOrderDispatchDetailSearchVo vo);

    /**
     * 大宗撤单数据
     * @param deliveryId
     * @param platformId
     * @return
     */
    DzCancelDataForCancelVo queryDzCancelData(String deliveryId, String platformId);

    /**
     * 查询状态
     * @param deliveryId
     * @param platformId
     * @return
     */
    DzCancelDataVo queryStatue(String deliveryId, String platformId);

    /**
     *
     * @param transId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo getComplateWeightWithTransId(String transId, String platformId);

    /**
     *
     * @param publishId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo getComplateWeightWithpublishId(String publishId, String platformId);

    /**
     * 获取平台调度预警列表分页数据
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findWarningList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取平台调度预警列表
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findAllWarningList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取货主级别调度预警分页数据
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findAllPublisherWarningList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取货主级别调度预警列表
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findAllPublisherWarningListData(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取委托承运调度单分页数据
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findCarrierPage(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取委托承运调度单数据
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findCarrierList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 查询调度信息
     * @param deliveryId
     * @return
     */
    TransOrderDispatchDetailVo queryMessageInfo(Long deliveryId);

    /**
     * 保存调度单
     * @param paramMap
     */
    void saveNewOrder(Map<String, Object> paramMap);

    /**
     * 查询相关ID
     * @param deliveryId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo queryDelieryWeight(Long deliveryId, String platformId);

}