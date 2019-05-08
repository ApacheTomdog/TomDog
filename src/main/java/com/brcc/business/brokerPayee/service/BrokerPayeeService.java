package com.brcc.business.brokerPayee.service;

import org.springframework.data.domain.Page;
import com.brcc.business.brokerPayee.entity.BrokerPayeeEntity;
import com.brcc.business.brokerPayee.vo.BrokerPayeeQueryVo;
import com.brcc.business.brokerPayee.vo.BrokerPayeeVo;

/**
 * 分配收款人管理
 * @author panyifang
 *
 */
public interface BrokerPayeeService {
	
	/**
	 * 分配收款人管理列表
	 * 
	 * @param queryvo
	 * @return
	 */
	Page<BrokerPayeeVo> listDataPage(BrokerPayeeQueryVo queryvo);

	/**
	 * 生效和作废状态
	 */
	void agreeBrokerPayee(BrokerPayeeQueryVo queryvo);
	
	/**
	 * 新增
	 */
	void save(BrokerPayeeQueryVo queryvo);
	
	/**
	 * 修改
	 */
	void update(BrokerPayeeQueryVo queryvo);
	/**
	 * 查找单个
	 * @return
	 */
	BrokerPayeeEntity findById(Long companyPayeeId);
	
	Page<BrokerPayeeVo> list(BrokerPayeeQueryVo queryvo);

	Long checkIfExist(Long companyId,String companyPayeeName,String companyPayeeNum,String companyPayeeStatus);

	BrokerPayeeEntity saveEntity(BrokerPayeeEntity entity);

}
