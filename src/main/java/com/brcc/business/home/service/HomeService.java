package com.brcc.business.home.service;

import java.util.List;

import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;

public interface HomeService {

	List<HomeVo> getRealTimeDate(HomeQueryVo queryVo);

	List<HomeVo> getRegisterCount(HomeQueryVo queryVo);

	List<HomeVo> getCarry(HomeQueryVo queryVo);

	List<HomeVo> getMapPointDate();

	List<HomeVo> getSender(HomeQueryVo queryVo);

}
