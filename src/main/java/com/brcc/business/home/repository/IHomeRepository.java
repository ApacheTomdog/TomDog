package com.brcc.business.home.repository;

import java.util.List;

import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;

public interface IHomeRepository {

	List<HomeVo> getRealTimeDate(HomeQueryVo queryVo);
	List<HomeVo> getMenuId(HomeQueryVo queryVo);
	List<HomeVo> getRegisterCount(HomeQueryVo queryVo);
	List<HomeVo> getCarry(HomeQueryVo queryVo);
	List<HomeVo> getMapPointDate();
	List<HomeVo> getSender(HomeQueryVo queryVo);
}
