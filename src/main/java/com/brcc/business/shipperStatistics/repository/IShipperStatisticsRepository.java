package com.brcc.business.shipperStatistics.repository;

import com.brcc.business.shipperStatistics.vo.ShipperStatisticsQueryVo;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsVo;

public interface IShipperStatisticsRepository {
	
	
	/**
	 * 查询日统计
	 */
	ShipperStatisticsVo getDay (ShipperStatisticsQueryVo queryVo);
	
	/**
	 *查询周统计
	 */
	ShipperStatisticsVo getWeek (ShipperStatisticsQueryVo queryVo);
	
	/**
	 * 查询月统计
	 */
	ShipperStatisticsVo getMonth (ShipperStatisticsQueryVo queryVo);
	

}
