package com.brcc.business.dispatchorder.service;

import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.repository.TransportationDeliveryUploadRepository;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-23 15:08
 */
public interface TransportationDeliveryUploadService {

    /**
     * 保存对象
     * @param entity
     * @return
     */
    TransportationdeliveryuploadEntity save(TransportationdeliveryuploadEntity entity);

    /**
     * 查询调度单上传情况
     * @param deliveryId
     * @return
     */
    int queryIfUpload(String deliveryId);

    /**
     * 更新upload状态
     * @param deliveryId
     */
    void updateUploadEc(String deliveryId);

    /**
     * 更新upload状态
     * @param isUploadEc
     * @param interfaceOutReason
     * @param uploadId
     */
    void updateUploadEc(String isUploadEc,String interfaceOutReason,String uploadId);

    /**
     * 川威电商调度信息查询（主单）
     * @param vo
     */
    List<CWDispatchDeliveryVo> queryDispatch(CWDispatchDeliveryQueryVo vo);

    /**
     * 川威电商调度信息查询（子单）
     * @param vo
     */
    List<CWDispatchDeliveryDetailVo> queryDispatchDetail(CWDispatchDeliveryDetailQueryVo vo);
}