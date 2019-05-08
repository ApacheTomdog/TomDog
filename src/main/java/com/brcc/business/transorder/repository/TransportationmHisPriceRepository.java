package com.brcc.business.transorder.repository;

import com.brcc.business.transorder.entity.TransportationmHisPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author yushaohua
 * @create 2019-01-04 13:34
 */
@Repository
public interface TransportationmHisPriceRepository extends JpaRepository<TransportationmHisPriceEntity,Long> {

}