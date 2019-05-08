package com.brcc.business.dispatchorder.repository;

import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2018-11-11 17:56
 */
@Repository
public interface GoodsOrderExecuteLogRepository extends JpaRepository<GoodsorderexecutelogEntity,Long> {

}