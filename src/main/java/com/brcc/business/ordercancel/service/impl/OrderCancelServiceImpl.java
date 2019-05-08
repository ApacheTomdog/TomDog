package com.brcc.business.ordercancel.service.impl;

import com.brcc.business.ordercancel.entity.DeliverycancelauditEntity;
import com.brcc.business.ordercancel.repository.OrderCancelRepository;
import com.brcc.business.ordercancel.service.OrderCancelService;
import com.brcc.business.ordercancel.vo.OrderCancelSearchVo;
import com.brcc.business.ordercancel.vo.OrderCancelVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.*;


/**
 * 描述:
 * 撤单审核业务逻辑接口实现类
 *
 * @author yushaohua
 * @create 2018-11-06 22:32
 */
@Service
public class OrderCancelServiceImpl implements OrderCancelService {

    Logger logger = LoggerFactory.getLogger(OrderCancelServiceImpl.class);

    @Autowired
    private OrderCancelRepository orderCancelRepository;

    @Override
    public Page<OrderCancelVo> findAllPage(OrderCancelSearchVo vo) {
        return orderCancelRepository.findAllPage(vo);
    }

    @Override
    public DeliverycancelauditEntity save(DeliverycancelauditEntity entity) {
        return orderCancelRepository.save(entity);
    }

    @Override
    @Transactional
    public Map<String , Object> orderCancel(DeliverycancelauditEntity entity) {
        logger.info("do order cancel process ");

        Optional<DeliverycancelauditEntity> optional = orderCancelRepository.findById(entity.getDeliveryCancelId());
        DeliverycancelauditEntity oleEntity = optional.get();

        oleEntity.setPlatformId(entity.getPlatformId());
        oleEntity.setAuditPersonId(entity.getAuditPersonId());
        oleEntity.setAuditPersonName(entity.getAuditPersonName());
        oleEntity.setDeliveryCancelType(entity.getDeliveryCancelType());
        if(entity.getAuditRemark() != null){
            oleEntity.setAuditRemark(entity.getAuditRemark());
        }
        oleEntity.setAuditDate(new Date());
        orderCancelRepository.save(oleEntity);

        // 如果是拼单的，撤销相关拼单的申请
        orderCancelRepository.orderCancel(oleEntity.getDeliveryCancelId(), oleEntity.getDeliveryCancelType(), oleEntity.getAuditPersonId(), oleEntity.getAuditPersonName(), oleEntity.getAuditRemark(), oleEntity.getPlatformId());

        Map<String, Object> result = null;
        if("20".equalsIgnoreCase(oleEntity.getDeliveryCancelType())){
            result = orderCancelRepository.cancelDeliveryPro(oleEntity.getDeliveryCancelId());
            if(result != null &&!"1".equalsIgnoreCase((String) result.get("as_out_result"))){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return result;
    }

    @Override
    public List<OrderCancelVo> findAll(OrderCancelSearchVo vo) {
        return orderCancelRepository.findAll(vo);
    }

    @Override
    public void saveOrderCancel(Map<String, Object> paramMap) {
        orderCancelRepository.saveOrderCancel(paramMap);
    }

    @Override
    public Map<String, Object> blackListCheck(Long deliveryCancelId) {
        return orderCancelRepository.blackListCheck(deliveryCancelId);
    }

    @Override
    public Page<OrderCancelVo> findAllPublisherPage(OrderCancelSearchVo vo) {
        return orderCancelRepository.findAllPublisherPage(vo);
    }

    @Override
    @Transactional
    public void updateStatus(OrderCancelSearchVo vo) {
        orderCancelRepository.updateStatus(vo.getDeliveryCancelType(),vo.getUserId(),vo.getUserName(), vo.getPlatformId(), vo.getDeliveryCancelId());
    }

    @Override
    public List<OrderCancelVo> findAllPublisherList(OrderCancelSearchVo vo) {
        return orderCancelRepository.findAllPublisherList(vo);
    }

    @Override
    public List<DeliverycancelauditEntity> deliveryCancelCheck(Long deliveryId, String platformId) {
        return orderCancelRepository.deliveryCancelCheck(deliveryId, platformId);
    }
}