package com.brcc.business.transportSettle.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.transportSettle.entity.VNewPayBillEntity;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;

/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月8日 下午5:20:27
 */
public interface IPayBillChildRepository {
	
	/**
	 * 查询结算单明细数据
	 * @param vo
	 * @return
	 */
	Page<VNewPayBillEntity> findPayDetailData(TransportBillQueryVo vo);
	
}
