package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.DeliveryuploadConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 建邦大宗上传接口
 *
 * @author yushaohua
 * @create 2018-11-11 11:43
 */
@Repository
public interface DeliveryUploadConfigRepository extends JpaRepository<DeliveryuploadConfigEntity,Long> {

    /**
     * 根据接口名称获取对象
     * @param jkName
     * @return
     */
    DeliveryuploadConfigEntity findFirstByJkName(String jkName);

}