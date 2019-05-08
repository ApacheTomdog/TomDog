package com.brcc.business.blackbroker.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.vo.blackBrokerQueryVo;
import com.brcc.business.blackbroker.vo.blackBrokerVo;

/**
 * @Description
 * @author yangwenbin
 * @version 创建时间：2018年11月15日 下午4:09:30
 */
@Service
public interface BlackbrokerService {

	Page<BlackbrokerEntity> searchBlackBroker(blackBrokerQueryVo queryVo);

	BlackbrokerEntity findById(Long companyId);

	Page<blackBrokerVo> findCompanyName(blackBrokerQueryVo queryVo);

	void save(BlackbrokerEntity blackbrokerEntity);

	void change(BlackbrokerEntity blackbrokerEntity);

	/**
	 * @Desc 查询经纪人生效的黑名单配置
	 * @param companyId
	 * @param status
	 * @param platformId
	 * @return
	 * @author yangwenbin
	 * @version 创建时间：2018年12月27日 下午3:55:01
	 */
	List<BlackbrokerEntity> findActivedBlackBroker(Long companyId, String status, String platformId);

}
