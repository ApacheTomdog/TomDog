package com.brcc.business.commonaddress.service;

import org.springframework.data.domain.Page;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.vo.CommonaddressQueryVo;

/**
 * @Desc:常用路线业务逻辑接口
 * @author TangYong
 * @Date 2018-11-12
 */
public interface Commonaddresservice {

	/**
	 * @Desc  查询常用路线是否存在
	 */
	CommonaddressEntity checkExist(String province, String city, String country, String plate,
			String contactName, String contactTele, String addressType, Long companyId, Long createUserId);
	/**
	 * @Desc  保存常用路线
	 * @param saveEntity 
	 * @return 
	 */
	CommonaddressEntity save(CommonaddressEntity saveEntity);
	 /**
     * 常用地址信息分页列表
     * @param vo 查询封装的接收类
     * @return CommonaddressQueryVo
     */
	Page<CommonaddressEntity> addressList(CommonaddressQueryVo vo);
	/**
	 * @Desc  删除常用路线
	 * @param vo 
	 * @return 
	 */
	void deleteAddress(CommonaddressQueryVo vo);
}
