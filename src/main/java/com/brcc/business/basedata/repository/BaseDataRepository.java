package com.brcc.business.basedata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brcc.business.basedata.entity.BasedataEntity;


/**
 * Description:省市区数据接口
 * @author: TangYong
 * @Date: 2018-11-18
 */
public interface BaseDataRepository extends JpaRepository<BasedataEntity,String> {

	/**
	 * @Desc:获取地址的经纬度信息
	 * @param baseDataQueryVo
	 */
	BasedataEntity findByKeyValueAndFatherKeyValue(String keyValue, String fatherKeyValue);

}
