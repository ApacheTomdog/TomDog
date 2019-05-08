package com.brcc.business.transorder.service;

import java.util.List;

import com.brcc.business.transorder.entity.ShortmessageEntity;

/**
* @Desc   短信存储逻辑接口
* @author TangYong
* @Date   2018-12-10
*/
public interface ShortmessageService {

	/**保存实体*/
	void save(ShortmessageEntity shortmessageEntity);
	/**保存实体list*/
	void saveList(List<ShortmessageEntity> shortMessageList);
	 
}
