package com.brcc.business.home.repository;

import java.util.List;

import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.RegisterCommonVo;
import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;

public interface IRegisterRepository {
	List<RegisterVo> registerName(RegisterQueryVo queryVo);
	List<RegisterVo> registerCompany(RegisterQueryVo queryVo);

	void menuSetNew(RegisterCommonVo vo);
}
