package com.brcc.business.basedata.service;

import com.brcc.business.basedata.entity.BasedataEntity;
import com.brcc.business.basedata.vo.BaseDataQueryVo;

/**
 * @Desc:省市区信息业务逻辑接口
 * @author TangYong
 * @Date 2018-11-18
 */
public interface BaseDataService {

	/**
	 * @Desc:获取地址的经纬度信息
	 * @param baseDataQueryVo
	 */
	BasedataEntity getPlatLngLat(BaseDataQueryVo baseDataQueryVo);
	
	
  
}
