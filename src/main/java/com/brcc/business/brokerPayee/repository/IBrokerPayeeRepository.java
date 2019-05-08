package com.brcc.business.brokerPayee.repository;

import org.springframework.data.domain.Page;

import com.brcc.business.brokerPayee.vo.BrokerPayeeQueryVo;
import com.brcc.business.brokerPayee.vo.BrokerPayeeVo;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
public interface IBrokerPayeeRepository {
	

	/**
	 * 分配收款人管理列表
	 */
	Page<BrokerPayeeVo> listDataPage(BrokerPayeeQueryVo queryvo);
	
	Page<BrokerPayeeVo> list(BrokerPayeeQueryVo queryvo);
	

}
