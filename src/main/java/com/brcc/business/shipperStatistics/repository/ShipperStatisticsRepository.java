package com.brcc.business.shipperStatistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.priceClientRate.entity.PriceClientRateEntity;

public interface ShipperStatisticsRepository extends JpaRepository<PriceClientRateEntity,Long>,IShipperStatisticsRepository{

}
