package com.brcc.business.blackbroker.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.repository.IBlackbrokerRepository;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.blackbroker.vo.blackBrokerVo;
import com.esteel.common.dao.PageQuery;

public class BlackbrokerRepositoryImpl implements IBlackbrokerRepository{
	@Autowired
    PageQuery pageQuery;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
	@Override
	public Page<BlackbrokerEntity> searchBlackBroker(blackBrokerQueryVo queryVo) {
		
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from blackbroker where ");

		sql.append("  platform_id = ? ");
		params.add(queryVo.getPlatformId());

		if(!ObjectUtils.isEmpty(queryVo.getBlockBrokerStatus())) {
			 sql.append(" and block_broker_status = ? ");
			 params.add(queryVo.getBlockBrokerStatus());
		}

		if(!ObjectUtils.isEmpty(queryVo.getBrokerCompanyName())) {
			 sql.append(" and broker_company_name like ? ");
			 params.add("%" + queryVo.getBrokerCompanyName() + "%");
		}
		
		return pageQuery.query(sql.toString(),params,queryVo,BlackbrokerEntity.class);
	}


	@Override
	public Page<blackBrokerVo> findCompanyName(blackBrokerQueryVo queryVo) {

		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("SELECT   c.seq_id AS brokerCompanyId,   c.company_name AS brokerCompanyName  FROM   company c  WHERE   c.if_broker_people_flag = 'Y'  AND c.`status` = '20' ");

		sql.append(" and  platform_id = ? ");
		params.add(queryVo.getPlatformId());

		if(!ObjectUtils.isEmpty(queryVo.getBrokerCompanyName())) {
			 sql.append(" and company_name like ? ");
			 params.add("%" + queryVo.getBrokerCompanyName() + "%");
		}
		
		return pageQuery.query(sql.toString(),params,queryVo,blackBrokerVo.class);
	}

	@Override
	public List<BlackbrokerEntity> onlyOne(BlackbrokerEntity entity) {
		List<Object> params = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from blackbroker where ");
		sql.append("  platform_id = ? ");
		params.add(entity.getPlatformId());
		sql.append(" and broker_company_id = ? ");
		params.add(entity.getBrokerCompanyId());
		sql.append(" and block_broker_status != '00' ");
		return pageQuery.list(sql.toString(), params, BlackbrokerEntity.class);
	}

}
