package com.brcc.business.commonaddress.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.service.Commonaddresservice;
import com.brcc.business.commonaddress.vo.CommonaddressQueryVo;
import com.esteel.common.controller.WebReturnMessage;


/**
* @Desc: 查询外部接口货源发布详情
* @author TangYong
* @Date 2018-11-14
*/
@RestController
@RequestMapping("/business/commomaddress")
public class CommonaddressController {
	
	Logger logger = LoggerFactory.getLogger(CommonaddressController.class);
	
	@Autowired
	Commonaddresservice  commonaddresservice;
    /**
     * @Description: 常用地址分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addressList")
    public Page<CommonaddressEntity> addressList(@RequestBody CommonaddressQueryVo vo){
    	logger.info("Query Commonaddress list pagination page");
    	Page<CommonaddressEntity> page = commonaddresservice.addressList(vo);
        return page;
    }
    
    /**
     * @Description: 常用地址分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAddress")
    public WebReturnMessage deleteAddress(@RequestBody CommonaddressQueryVo vo){
    	try {
			logger.info("delete Commonaddress info by addressId:{}",vo.getAddressId());
			commonaddresservice.deleteAddress(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(false,e.getMessage());
		}
        return new WebReturnMessage(true,"删除成功!");
    }
  
}    
