package com.brcc.business.shipperStatistics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brcc.business.shipperStatistics.repository.ShipperStatisticsRepository;
import com.brcc.business.shipperStatistics.service.ShipperStatisticsService;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsQueryVo;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsVo;

@Service
public class ShipperStatisticsServiceImpl implements ShipperStatisticsService{
	
	@Autowired 
	private ShipperStatisticsRepository shipperStatisticsRepository;
	
	
	@Override
	public ShipperStatisticsVo getDay(ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsRepository.getDay(queryVo);
	}

	@Override
	public ShipperStatisticsVo getWeek(ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsRepository.getWeek(queryVo);
	}

	@Override
	public ShipperStatisticsVo getMonth(ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsRepository.getMonth(queryVo);
	}

}
