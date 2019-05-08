package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 *
 * @author chk
 * @create 2018-11-11 15:31
 */
@Repository
public interface ITransportationDeliveryUploadRepository {

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

    /**
     * 更新状态
     * @param isUploadEc
     * @param interfaceOutReason
     * @param uploadId
     */
    void updateUploadEc(String isUploadEc,String interfaceOutReason,String uploadId);

}