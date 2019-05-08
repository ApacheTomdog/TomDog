package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.BrokerPeopleConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 * 经纪人数据接口类
 *
 * @author yushaohua
 * @create 2018-12-04 10:42
 */
@Repository
public interface BrokerPeopleConfigRepository extends JpaRepository<BrokerPeopleConfigEntity,Long>, IBrokerPeopleConfigRepository {

}