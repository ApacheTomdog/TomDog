package com.brcc.business.basedata.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brcc.business.basedata.entity.CatalogEntity;
import com.brcc.business.basedata.entity.DependForDsWeightjkEntity;
import com.brcc.business.basedata.entity.GoodsOrdermjkSetplatEntity;
import com.brcc.business.basedata.vo.BaseDataForeignQueryVo;
import com.brcc.business.basedata.vo.BaseDataForeignVo;
import com.brcc.business.basedata.vo.GoodsOrdermjkSetplatQueryVo;
import com.brcc.business.basedata.vo.GoodsTypeQueryVo;
import com.brcc.business.basedata.vo.UserQueryVo;
import com.brcc.business.basedata.vo.UserVo;

/**
* 
* 
* @author 万强
*
* 2019年4月22日
*/
@FeignClient(name = "base-server",path = "/base/JsonLog",url="${ms.server.base}")
public interface JsonLogClient {
	
	@RequestMapping(value = "/chack", method = RequestMethod.POST)
	List<GoodsOrdermjkSetplatEntity> chack(GoodsOrdermjkSetplatQueryVo vo);
	
	@RequestMapping(value = "/queryGoodsType", method = RequestMethod.POST)
	CatalogEntity queryGoodsType(GoodsTypeQueryVo vo);
	
	@RequestMapping(value = "/queryFdUserInfo", method = RequestMethod.POST)
	UserVo queryFdUserInfo(UserQueryVo vo);
	
	@RequestMapping(value = "/getBatchId", method = RequestMethod.POST)
	Integer getBatchId(UserQueryVo vo);
	
	@RequestMapping(value = "/getOutBatchId", method = RequestMethod.POST)
	Integer getOutBatchId(UserQueryVo vo);
	
	@RequestMapping(value = "/getProvinceName", method = RequestMethod.POST)
	BaseDataForeignVo getProvinceName(BaseDataForeignQueryVo vo);
	
	@RequestMapping(value = "/getCity", method = RequestMethod.POST)
	List<BaseDataForeignVo> getCity(BaseDataForeignQueryVo vo);
	
	@RequestMapping(value = "/saveOutWeightInfo", method = RequestMethod.POST)
	DependForDsWeightjkEntity saveOutWeightInfo(DependForDsWeightjkEntity vo);
}
