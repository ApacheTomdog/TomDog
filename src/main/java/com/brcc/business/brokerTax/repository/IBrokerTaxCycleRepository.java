package com.brcc.business.brokerTax.repository;

import java.util.List;

import com.brcc.business.brokerTax.entity.BrokerTaxCycleEntity;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;

/**
 *	季度配置
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
public interface IBrokerTaxCycleRepository {

	List<BrokerTaxCycleVo> queryCycleList();

}
