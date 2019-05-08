package com.brcc.business.dispatchorder.repository;

import com.brcc.business.transorder.entity.TransportationdeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 平台调度单详单数据接口类
 *
 * @author yushaohua
 * @create 2018-11-05 20:24
 */
@Repository
public interface DispatchOrderDetailRepository extends JpaRepository<TransportationdeliveryEntity,Long>, IDispatchOrderDetailRepository {

}