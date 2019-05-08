package com.brcc.business.transorder.service.impl;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import com.brcc.business.transorder.repository.TransOrderDispatchDetailRepository;
import com.brcc.business.transorder.service.TransOrderDispatchDetailService;
import com.brcc.business.transorder.vo.DzCancelDataForCancelVo;
import com.brcc.business.transorder.vo.DzCancelDataVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailSearchVo;
import com.brcc.business.transorder.vo.TransOrderDispatchDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 平台运输单调度详情业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-02 11:27
 */
@Service
public class TransOrderDispatchDetailServiceImpl implements TransOrderDispatchDetailService {

    Logger logger = LoggerFactory.getLogger(TransOrderDispatchDetailServiceImpl.class);

    @Autowired
    private TransOrderDispatchDetailRepository transOrderDispatchDetailRepository;

    @Override
    public TransOrderDispatchDetailVo findOrderDetail(TransOrderDispatchDetailSearchVo vo) {
        logger.info("query trans order dispatch detail ");

        List<TransOrderDispatchDetailVo> list = null;
        if(vo.getVatCarryId() != null && !"".equals(vo.getVatCarryId())){
            list = transOrderDispatchDetailRepository.findOrderDetailForCarrier(vo);
        }else{
            list = transOrderDispatchDetailRepository.findOrderDetai(vo);
        }

        if(list != null && list.size() > 0){
            return list.get(0);
        }

        return null;
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findWarningList(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findWarningList(vo);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findAllWarningList(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findAllWarningList(vo);
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findCarrierPage(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findCarrierPage(vo);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findCarrierList(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findCarrierList(vo);
    }

    @Override
    public List<TransportationdeliveryEntity> queryDeliveryInfo(Long transId) {
        return transOrderDispatchDetailRepository.queryDeliveryInfo(transId);
    }

    @Override
    public List<TransportationdeliveryEntity> completedTransportBill(String platformId, Long transId) {
        return transOrderDispatchDetailRepository.completedTransportBill(platformId, transId);
    }

    @Override
    public List<TransportationdeliveryEntity> onCarTransportBill(String platformId, Long transId) {
        return transOrderDispatchDetailRepository.onCarTransportBill(platformId, transId);
    }

    @Override
    public void cancelAllDelivery(String platformId, Long transId) {
        transOrderDispatchDetailRepository.cancelAllDelivery(platformId, transId);
    }

    @Override
    public List<TransportationdeliveryEntity> findByTransId(Long transId) {
        return transOrderDispatchDetailRepository.findByTransId(transId);
    }

    @Override
    public void saveNewOrder(Map<String, Object> paramMap) {
        transOrderDispatchDetailRepository.saveNewOrder(paramMap);
    }

    @Override
    public TransOrderDispatchDetailVo queryDelieryWeight(Long deliveryId, String platformId) {
        return transOrderDispatchDetailRepository.queryDelieryWeight(deliveryId, platformId);
    }

    @Override
    public int updateDelieryWeight(BigDecimal finishWeight, BigDecimal deliveryWeight, Date deliveryIdDate,
                                    Date finishDate, Long createPersonId, Long deliveryId, String platformId) {
        return transOrderDispatchDetailRepository.updateDelieryWeight(finishWeight, deliveryWeight, deliveryIdDate,
                                                    finishDate, createPersonId, deliveryId, platformId);
    }

    @Override
    public TransOrderDispatchDetailVo getComplateWeightWithTransId(String transId, String platformId) {
        return transOrderDispatchDetailRepository.getComplateWeightWithTransId(transId, platformId);
    }

    @Override
    public TransOrderDispatchDetailVo getComplateWeightWithpublishId(String publishId, String platformId) {
        return transOrderDispatchDetailRepository.getComplateWeightWithpublishId(publishId, platformId);
    }

    @Override
    public DzCancelDataForCancelVo queryDzCancelData(String deliveryId, String platformId) {
        logger.info("query dz cancel data deliveryId:{}, platformId:{}",deliveryId,platformId);
        return this.transOrderDispatchDetailRepository.queryDzCancelData(deliveryId, platformId);
    }

    @Override
    public Page<TransOrderDispatchDetailVo> findPublisherWarningList(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findAllPublisherWarningList(vo);
    }

    @Override
    public List<TransOrderDispatchDetailVo> findPublisherWarningListData(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findAllPublisherWarningListData(vo);
    }

    @Override
    public List<TransportationdeliveryEntity> noCompleteCount(String platformId, Long driverId, Long transId) {
        if(null == transId){
            // 拼单调度
            return transOrderDispatchDetailRepository.noCompleteCountBatch(platformId, driverId);
        }else{
            return transOrderDispatchDetailRepository.noCompleteCount(platformId, driverId, transId);
        }

    }

    @Override
    public List<TransportationdeliveryEntity> verifyDelivery(String platformId, Long transId) {
        return transOrderDispatchDetailRepository.verifyDelivery(platformId, transId);
    }
    
    /**
     * 查询承运级调度单预警列表
     */
	@Override
	public Page<TransOrderDispatchDetailVo> findCarriagePage(TransOrderDispatchDetailSearchVo vo) {
		return transOrderDispatchDetailRepository.findWarningList(vo);
	}
	
	/**
     * 导出承运级调度单预警列表
     */
	@Override
    public List<TransOrderDispatchDetailVo> excelCarriageWarningList(TransOrderDispatchDetailSearchVo vo) {
        return transOrderDispatchDetailRepository.findAllWarningList(vo);
    }

    @Override
    public int updateDeliveryPrice(BigDecimal newPrice, Long transId, String platformId) {
        return transOrderDispatchDetailRepository.updateDeliveryPrice(newPrice, transId, platformId);
    }

    @Override
    public List<TransportationdeliveryEntity> getCarCount(String platformId, Long vehicleId, Long transId) {
        return transOrderDispatchDetailRepository.getCarCount(platformId, vehicleId, transId);
    }

    @Override
    public DzCancelDataVo queryStatue(String deliveryId, String platformId) {
        return transOrderDispatchDetailRepository.queryStatue(deliveryId, platformId);
    }

    @Override
    public TransportationdeliveryEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId) {
        return transOrderDispatchDetailRepository.findByDeliveryIdAndPlatformId(deliveryId, platformId);
    }

    @Override
    public TransportationdeliveryEntity save(TransportationdeliveryEntity entity) {
        return transOrderDispatchDetailRepository.save(entity);
    }

    @Override
    public List<TransportationdeliveryEntity> activeTransportBill(String platformId, Long transId) {
        return transOrderDispatchDetailRepository.activeTransportBill(platformId, transId);
    }

    @Override
    public List<TransportationdeliveryEntity> unCompleteTransportBill(String platformId, Long transId) {
        return transOrderDispatchDetailRepository.unCompleteTransportBill(platformId, transId);
    }

    @Override
    public TransportationdeliveryEntity findDeliveryMyself(Long driveId, Long transId) {
        return transOrderDispatchDetailRepository.findDeliveryMyself(driveId, transId);
    }

    @Override
    public TransOrderDispatchDetailVo queryMessageInfo(Long deliveryId) {
        return transOrderDispatchDetailRepository.queryMessageInfo(deliveryId);
    }
}