package com.brcc.business.dispatchorder.service.impl;

import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.repository.TransportationDeliveryUploadRepository;
import com.brcc.business.dispatchorder.service.TransportationDeliveryUploadService;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-23 15:09
 */
@Service
public class TransportationDeliveryUploadServiceImpl implements TransportationDeliveryUploadService {

    Logger logger = LoggerFactory.getLogger(TransportationDeliveryUploadServiceImpl.class);

    @Autowired
    private TransportationDeliveryUploadRepository transportationDeliveryUploadRepository;

    @Override
    public TransportationdeliveryuploadEntity save(TransportationdeliveryuploadEntity entity) {
        return transportationDeliveryUploadRepository.save(entity);
    }

    @Override
    public int queryIfUpload(String deliveryId) {
        logger.info("queryIfUpload deliveryId:{}",deliveryId);
        return transportationDeliveryUploadRepository.queryIfUpload(deliveryId);
    }

    @Override
    public void updateUploadEc(String deliveryId) {
        transportationDeliveryUploadRepository.updateUploadEc(deliveryId);
    }

    @Override
    public void updateUploadEc(String isUploadEc,String interfaceOutReason,String uploadId) {
        transportationDeliveryUploadRepository.updateUploadEc(isUploadEc, interfaceOutReason, uploadId);
    }

    @Override
    public List<CWDispatchDeliveryVo> queryDispatch(CWDispatchDeliveryQueryVo vo) {
        return transportationDeliveryUploadRepository.queryDispatch(vo);
    }

    @Override
    public List<CWDispatchDeliveryDetailVo> queryDispatchDetail(CWDispatchDeliveryDetailQueryVo vo) {
        return transportationDeliveryUploadRepository.queryDispatchDetail(vo);
    }


}