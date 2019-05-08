package com.brcc.business.transportation.service;

import java.util.List;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.transportation.entity.TransportationmEntity;

/**
 * 运单业务逻辑接口
 * @author 
 * @Date: 2018-11-05
 */
public interface TransportationmService {

	/**
	 * 根据货源单ID查找运输单
	 * @param publishId
	 * @return
	 */
	public List<TransportationmEntity> findByPublishId(Long publishId);

	/**
	 * @Title: findOne 
	 * @Description: 根据ID查找运输订单信息
	 * @param transId
	 * @return TransportationmEntity
	 */
	TransportationmEntity findById(Long transId);

	TransportationmEntity save(TransportationmEntity tran);

	/**
	 * 查找运输单
	 * @param vo
	 * @return List<TransportationmVo>
	 */
	public List<TransportationmEntity> listTransportationDetails(GoodsordermQueryVo vo);

   
}
