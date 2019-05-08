package com.brcc.business.home.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.home.repository.HomeRepository;
import com.brcc.business.home.service.HomeService;
import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.HomeVo;

@Transactional
@Service
public class HomeServiceImpl implements HomeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	HomeRepository homeRepository;

	@Override
	public List<HomeVo> getRealTimeDate(HomeQueryVo queryVo) {
		HomeVo vo = new HomeVo();

		Long onlineDriverNum = homeRepository.getOnlineDriverNum(queryVo.getToday());
		onlineDriverNum +=onlineDriverNum+12033;
		List<HomeVo> list = homeRepository.getRealTimeDate(queryVo);
		if(list.size() >0) {
			list.get(0).setOnlineDriverNum(onlineDriverNum);
		}
		return list;
	}

	@Override
	public List<HomeVo> getRegisterCount(HomeQueryVo queryVo) {
		// 查询是否有查单权限
		List<HomeVo> list = homeRepository.getMenuId(queryVo);
		if (list.size() > 0) {
			List<HomeVo> list1 = homeRepository.getRegisterCount(queryVo);
			return list1;
		} else {
			HomeVo vo = new HomeVo();
			vo.setMenuId(Long.valueOf("000"));
			list.add(vo);
			return list;
		}
	}

	@Override
	public List<HomeVo> getCarry(HomeQueryVo queryVo) {
		// 查询是否有查单权限
		List<HomeVo> list = homeRepository.getMenuId(queryVo);
		if (list.size() > 0) {
			List<HomeVo> list1 = homeRepository.getCarry(queryVo);
			return list1;
		} else {
			HomeVo vo = new HomeVo();
			vo.setMenuId(Long.valueOf("000"));
			list.add(vo);
			return list;
		}
	}

	@Override
	public List<HomeVo> getMapPointDate() {

		return homeRepository.getMapPointDate();
	}

	@Override
	public List<HomeVo> getSender(HomeQueryVo queryVo) {
		// 查询是否有查单权限
		List<HomeVo> list = homeRepository.getMenuId(queryVo);
		if (list.size() > 0) {
			List<HomeVo> list1 = homeRepository.getSender(queryVo);
			return list1;
		} else {
			HomeVo vo = new HomeVo();
			vo.setMenuId(Long.valueOf("000"));
			list.add(vo);
			return list;
		}
	}

}
