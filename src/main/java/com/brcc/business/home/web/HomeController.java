package com.brcc.business.home.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.home.service.HomeService;
import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;

@RestController
@RequestMapping("/home")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HomeService homeService;
	
	/**
	 * 获取成交车次和在线司机数据
	 * @param domain
	 * @return
	 */
	@RequestMapping("/getRealTimeDate")
	public List<HomeVo> getRealTimeDate(@RequestBody HomeQueryVo queryVo) {
		logger.info("获取成交车次和在线司机数据查询条件>>>"+queryVo);
		return homeService.getRealTimeDate(queryVo);
	}
	
	/**
	 * 今日总注册数，已审核的注册数，未审核的注册数
	 */
	@RequestMapping("/getRegisterCount")
	public List<HomeVo> getRegisterCount(@RequestBody HomeQueryVo queryVo) {
		logger.info("今日总注册数>>>"+queryVo.getUserId()+"<<<"+queryVo.getMenuId());
		
		return homeService.getRegisterCount(queryVo);
		
	}
	
	/**
	 * 查詢今日抢单车数--承运方
	 */
	@RequestMapping("/getCarry")
	public List<HomeVo> getCarry(@RequestBody HomeQueryVo queryVo) {
		logger.info("今日总注册数>>>"+queryVo);
		
		return homeService.getCarry(queryVo);
		
	}
	/**
	 * 查詢今日抢单车数--发单人
	 */
	@RequestMapping("/getSender")
	public List<HomeVo> getSender(@RequestBody HomeQueryVo queryVo) {
		logger.info("今日总注册数>>>"+queryVo);
		
		return homeService.getSender(queryVo);
		
	}
	
	/**
	 * 获取数据中心车辆分布点位图数据
	 * @return
	 */
	@RequestMapping("/getMapPointDate")
	public List<HomeVo> getMapPointDate() {
		return homeService.getMapPointDate();
		
	}
}
