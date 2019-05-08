package com.brcc.business.blackbroker.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.blackbroker.vo.blackBrokerVo;

public interface IBlackbrokerRepository {

	Page<BlackbrokerEntity> searchBlackBroker(blackBrokerQueryVo queryVo);
	
	Page<blackBrokerVo> findCompanyName(blackBrokerQueryVo queryVo);
	
	List<BlackbrokerEntity> onlyOne(BlackbrokerEntity blackbrokerEntity);
}
