package com.brcc.business.brokerProfit.repository;

import org.springframework.data.domain.Page;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigVo;

/**
 * 经纪人最高分润配置操作
 * @author dzj
 * @date 2019-01-29
 */
public interface IBrokerProfitConfigRepository {

	Page<BrokerProfitConfigVo> getPageData(BrokerProfitConfigQueryVo queryVo);
}
