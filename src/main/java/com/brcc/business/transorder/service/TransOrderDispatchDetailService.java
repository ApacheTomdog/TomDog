package com.brcc.business.transorder.service;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单调度详情业务逻辑接口
 *
 * @author yushaohua
 * @create 2018-11-02 11:26
 */
public interface TransOrderDispatchDetailService {

    /**
     * 查询平台运输单调度信息
     * @param vo
     * @return
     */
    TransOrderDispatchDetailVo findOrderDetail(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取平台调度预警列表
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findWarningList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取货主级别调度预警列表
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findPublisherWarningListData(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取货主级别调度预警列表
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findPublisherWarningList(TransOrderDispatchDetailSearchVo vo);

    /**
     * 获取平台调度预警列表
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> findAllWarningList(TransOrderDispatchDetailSearchVo vo);

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
     * 查询数据
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> queryDeliveryInfo(Long transId);

    /**
     * 判断是否已经完成
     * @return
     */
    List<TransportationdeliveryEntity> completedTransportBill(String platformId, Long transId);

    /**
     * 判断是否装车
     * @param platformId
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> onCarTransportBill(String platformId, Long transId);

    /**
     * 作废调度单
     * @param platformId
     * @param transId
     */
    void cancelAllDelivery(String platformId, Long transId);

    /**
     * 根据transId获取对象
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> findByTransId(Long transId);

    /**
     * 保存调度单
     * @param paramMap
     * @return
     */
    void saveNewOrder(Map<String, Object> paramMap);

    /**
     * 查询相关ID
     * @param deliveryId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo queryDelieryWeight(Long deliveryId, String platformId);

    /**
     * 更新装货重量
     * @param finishWeight
     * @param deliveryWeight
     * @param deliveryIdDate
     * @param finishDate
     * @param createPersonId
     * @param deliveryId
     * @param platformId
     */
    int updateDelieryWeight(BigDecimal finishWeight, BigDecimal deliveryWeight, Date deliveryIdDate, Date finishDate,
                             Long createPersonId, Long deliveryId, String platformId);

    /**
     * 获取卸货重量
     * @param transId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo getComplateWeightWithTransId(String transId, String platformId);

    /**
     * 获取卸货重量
     * @param publishId
     * @param platformId
     * @return
     */
    TransOrderDispatchDetailVo getComplateWeightWithpublishId(String publishId, String platformId);

    /**
     * 未完成订单查询
     * @param platformId
     * @param driverId
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> noCompleteCount(String platformId, Long driverId, Long transId);

    /**
     * 大宗撤单数据
     * @param deliveryId
     * @param platformId
     * @return
     */
    DzCancelDataForCancelVo queryDzCancelData(String deliveryId, String platformId);

    /**
     * 根据条件获取数据
     * @param platformId
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> verifyDelivery(String platformId, Long transId);
    
    /**
     * 获取承运级调度预警列表
     * @param vo
     * @return
     */
    Page<TransOrderDispatchDetailVo> findCarriagePage(TransOrderDispatchDetailSearchVo vo);
    
    /**
     * 导出承运级调度预警列表
     * @param vo
     * @return
     */
    List<TransOrderDispatchDetailVo> excelCarriageWarningList(TransOrderDispatchDetailSearchVo vo);

    int updateDeliveryPrice(BigDecimal newPrice, Long transId, String platformId);

    List<TransportationdeliveryEntity> getCarCount(String platformId, Long vehicleId, Long transId);

    /**
     * 查询状态
     * @param deliveryId
     * @param platformId
     * @return
     */
    DzCancelDataVo queryStatue(String deliveryId, String platformId);

    /**
     * 根据deliveryId、platformId获取对象
     * @param deliveryId
     * @param platformId
     * @return
     */
    TransportationdeliveryEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId);

    TransportationdeliveryEntity save(TransportationdeliveryEntity entity);

    /**
     *
     * @param platformId
     * @param transId
     * @return
     */
    List<TransportationdeliveryEntity> activeTransportBill(String platformId, Long transId);

    /**
     * 根据条件查询数据
     * @return
     */
    List<TransportationdeliveryEntity> unCompleteTransportBill(String platformId, Long transId);

    /**
     * 根据transId查找运单
     * @param driveId
     * @param transId
     * @return
     */
    TransportationdeliveryEntity findDeliveryMyself(Long driveId, Long transId);

    /**
     * 查询调度信息
     * @param deliveryId
     * @return
     */
    TransOrderDispatchDetailVo queryMessageInfo(Long deliveryId);
}