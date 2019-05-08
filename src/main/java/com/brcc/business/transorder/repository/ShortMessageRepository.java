package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.ShortmessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * SMS信息数据接口类
 *
 * @author yushaohua
 * @create 2018-11-25 14:32
 */
@Repository
public interface ShortMessageRepository extends JpaRepository<ShortmessageEntity,Long> {

}