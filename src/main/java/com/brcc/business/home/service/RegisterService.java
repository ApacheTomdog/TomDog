package com.brcc.business.home.service;

import java.util.HashMap;
import java.util.List;

import com.brcc.business.home.vo.HomeQueryVo;
import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;

public interface RegisterService {

	HashMap registerName(RegisterQueryVo queryVo);

	HashMap registerCompany(RegisterQueryVo queryVo);

	HashMap registerInfo(RegisterQueryVo queryVo);

	HashMap getVerifCode(RegisterQueryVo queryVo);

	HashMap restPassword(RegisterQueryVo queryVo);

}
