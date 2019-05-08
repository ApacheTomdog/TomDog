package com.brcc.business.commonaddress.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.repository.CommonaddressRepository;
import com.brcc.business.commonaddress.service.Commonaddresservice;
import com.brcc.business.commonaddress.vo.CommonaddressQueryVo;


/**
 * 常用路线业务逻辑接口实现 
 * @author TangYong
 * @Date 2018-11-12
 */
@Service
@Transactional
public class CommonaddressServiceImpl implements  Commonaddresservice {

    Logger logger = LoggerFactory.getLogger(CommonaddressServiceImpl.class);

    @Autowired
    CommonaddressRepository  commonaddressRepository;

	@Override
	public CommonaddressEntity checkExist(String provinceName, String cityName, String countryName, String address,
			String contactName, String contactTele, String addressType, Long companyId, Long createPersonId) {
		logger.info("Check the address is exist or not!");
		return commonaddressRepository.checkExist(provinceName,cityName,countryName,address,
				contactName,contactTele,addressType,companyId,createPersonId);
				
	}

	@Override
	public CommonaddressEntity save(CommonaddressEntity saveEntity) {
		logger.info("save the CommonaddressEntity");
		return commonaddressRepository.save(saveEntity);
	}

	@Override
	public Page<CommonaddressEntity> addressList(CommonaddressQueryVo vo) {
		logger.info("Query common used address");
		return commonaddressRepository.addressList(vo);
	}

	@Override
	public void deleteAddress(CommonaddressQueryVo vo) {
		logger.info("delete Commonaddress info by addressId:{}",vo.getAddressId());
		commonaddressRepository.deleteById(vo.getAddressId());
	}

}
