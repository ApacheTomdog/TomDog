package com.brcc.business.home.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.home.service.RegisterService;
import com.brcc.business.home.vo.RegisterQueryVo;
import com.brcc.business.home.vo.RegisterVo;

/**
 * 注册相关验证
 * 
 * @author mwb
 *
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RegisterService registerService;

	/**
	 * 用户名重复认证
	 */
	@RequestMapping(value="/registerName", method = RequestMethod.POST)
	@ResponseBody
	public HashMap registerName(@RequestBody RegisterQueryVo queryVo) {
		logger.info(queryVo.getLoginName());
		return registerService.registerName(queryVo);
	}

	/**
	 * 
	 * 公司名重复认证
	 * 
	 * @return
	 */
	@RequestMapping(value="/registerCompany", method = RequestMethod.POST)
	@ResponseBody
	public HashMap registerCompany(@RequestBody RegisterQueryVo QueryVo) {

		return registerService.registerCompany(QueryVo);
	}
	
	/**
	 * 用户注册返回msg
	 */

	@RequestMapping(value="/registerInfo", method = RequestMethod.POST)
	@ResponseBody
	public HashMap registerInfo(@RequestBody RegisterQueryVo QueryVo) {
		HashMap map = registerService.registerInfo(QueryVo);
		return map;
	}
	
	/**
	 * 短信验证码处理
	 */
	@RequestMapping(value="/getVerifCode", method = RequestMethod.POST)
	@ResponseBody
	public HashMap getVerifCode(@RequestBody RegisterQueryVo QueryVo) {
		HashMap map = registerService.getVerifCode(QueryVo);
		return map;
	}
	
	/**
	 * 忘记密码,重置密码
	 */
	@RequestMapping(value="/restPassword", method = RequestMethod.POST)
	@ResponseBody
	public HashMap restPassword(@RequestBody RegisterQueryVo QueryVo) {
		HashMap map = registerService.restPassword(QueryVo);
		return map;
	}
}
