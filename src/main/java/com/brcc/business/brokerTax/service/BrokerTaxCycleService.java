package com.brcc.business.brokerTax.service;
import java.util.List;

import com.brcc.business.brokerTax.entity.BrokerTaxCycleEntity;
import org.springframework.stereotype.Service;
import com.brcc.business.brokerTax.vo.BrokerTaxCycleVo;

/**
 *	 季度配置
 *
 * @author hui.liu
 * @date 2019年1月31日
 */
@Service
public interface BrokerTaxCycleService {

	 //查询对应季度名的周期区间
	 String getTaxCycle(String  brokerTaxCycleName);

	//根据日期查询对应的周期
	 String getBrokerTaxCycleName(String brokerTaxYearMonth);
	
	/**
	 * 	获取季度配置中的季度列表
	 */
	List<BrokerTaxCycleVo> queryCycleList();

}
