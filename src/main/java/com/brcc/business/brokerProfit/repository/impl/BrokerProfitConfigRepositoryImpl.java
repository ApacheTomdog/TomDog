package com.brcc.business.brokerProfit.repository.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.brcc.business.brokerProfit.repository.IBrokerProfitConfigRepository;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigQueryVo;
import com.brcc.business.brokerProfit.vo.BrokerProfitConfigVo;
import com.esteel.common.dao.PageQuery;

/**
 * 经纪人最高分润配置操作
 * @author dzj
 * @date 2019-01-29
 */
public class BrokerProfitConfigRepositoryImpl implements IBrokerProfitConfigRepository {

	Logger logger = LoggerFactory.getLogger(BrokerProfitConfigRepositoryImpl.class);

	@Autowired
	private PageQuery pageQuery;

	@Override
	public Page<BrokerProfitConfigVo> getPageData(BrokerProfitConfigQueryVo queryVo) {
		logger.info("Query BrokerProfitConfig Pagination Page,{}", queryVo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sql = new StringBuilder();
		List<Object> args = new ArrayList<Object>();
		sql.append("select * from broker_profit_config where 1=1");
		if (StringUtils.isNotBlank(queryVo.getIfSpecialCase())) {
			sql.append(" and if_special_case = ? ");
			args.add(queryVo.getIfSpecialCase());
		}
		if (StringUtils.isNotBlank(queryVo.getBrokerProfitConfigStatus())) {
			sql.append(" and broker_profit_config_status = ?");
			args.add(queryVo.getBrokerProfitConfigStatus());
		}
		if (queryVo.getModifyDateStart() != null) {
			sql.append(" and date(modify_date) >= ? ");
			args.add(sdf.format(queryVo.getModifyDateStart()));
		}
		if (queryVo.getModifyDateEnd() != null) {
			sql.append(" and date(modify_date) <= ? ");
			args.add(sdf.format(queryVo.getModifyDateEnd()));
		}
		if (StringUtils.isNotBlank(queryVo.getSpecialBrokerName())) {
			sql.append(" and special_broker_name like ? ");
			args.add("%" + queryVo.getSpecialBrokerName() + "%");
		}
		sql.append(" order by create_date desc ");
		return pageQuery.query(sql.toString(), args, queryVo, BrokerProfitConfigVo.class);
	}
}
