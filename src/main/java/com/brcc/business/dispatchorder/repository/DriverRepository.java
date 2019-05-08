package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * 司机数据接口类
 *
 * @author yushaohua
 * @create 2018-11-12 13:39
 */
@Repository
public interface DriverRepository extends JpaRepository<DriverEntity,Long>, IDriverRepository {

    /**
     * 获取对象
     * @param id
     * @param fromPlatId
     * @return
     */
    DriverEntity findByIdAndFromPlatId(Long id, String fromPlatId);

}