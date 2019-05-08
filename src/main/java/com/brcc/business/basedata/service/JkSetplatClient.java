package com.brcc.business.basedata.service;

import com.brcc.business.basedata.entity.CatalogEntity;
import com.brcc.business.basedata.entity.GoodsOrdermjkSetplatEntity;
import com.brcc.business.basedata.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* 
* 
* @author chk
*
* 2019年4月22日
*/
@FeignClient(name = "base-server",path = "/base/jksetplat",url="${ms.server.base}")
public interface JkSetplatClient {
	
	@RequestMapping(value = "/getConfigCW", method = RequestMethod.POST)
	List<GoodsOrdermjkSetplatEntity> getConfigCW(@RequestParam("ecPlatName") String ecPlatName);
	
}
