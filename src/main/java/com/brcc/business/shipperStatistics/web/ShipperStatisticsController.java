package com.brcc.business.shipperStatistics.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.shipperStatistics.service.ShipperStatisticsService;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsQueryVo;
import com.brcc.business.shipperStatistics.vo.ShipperStatisticsVo;

/**
 * 货主登录的首页面，展示日、周、月统计三栏
 * @author lijiangying
 */
@RestController
@RequestMapping("shipperStatistics")
public class ShipperStatisticsController {
	
	Logger logger = LoggerFactory.getLogger(ShipperStatisticsController.class);
	
	@Autowired
	private ShipperStatisticsService shipperStatisticsService;
	
	/**
	 * 查询每天的数据
	 */
	@ResponseBody
	@RequestMapping(value = "/getDay", method = RequestMethod.POST)
	public ShipperStatisticsVo getDay(@RequestBody ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsService.getDay(queryVo);
	}
	/**
	 * 查询每个星期的数据
	 */
	@ResponseBody
	@RequestMapping(value = "/getWeek", method = RequestMethod.POST)
	public ShipperStatisticsVo getWeek(@RequestBody ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsService.getWeek(queryVo);
	}
	/**
	 * 查询每个月的数据
	 */
	@ResponseBody
	@RequestMapping(value = "/getMonth", method = RequestMethod.POST)
	public ShipperStatisticsVo getMonth(@RequestBody ShipperStatisticsQueryVo queryVo) {
		return shipperStatisticsService.getMonth(queryVo);
	}
}
