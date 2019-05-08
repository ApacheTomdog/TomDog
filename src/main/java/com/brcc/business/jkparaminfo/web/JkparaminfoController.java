package com.brcc.business.jkparaminfo.web;

import com.brcc.business.jkparaminfo.service.JkparaminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jkparaminfo")
public class JkparaminfoController {

	@Autowired
	JkparaminfoService jkparaminfoService;

	/**获取接口地址*/
	@RequestMapping(value = "/getJkUrl")
	public String getJkUrl(@RequestBody Long id) {
		return jkparaminfoService.findById(id).getUrl();
	}

}
