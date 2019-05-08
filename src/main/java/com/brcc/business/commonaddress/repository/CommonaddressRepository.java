package com.brcc.business.commonaddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.commonaddress.entity.CommonaddressEntity;

/**
 * @Description:常用路线数据接口
 * @author: TangYong
 * @Date: 2018-11-12
 */
public interface CommonaddressRepository extends JpaRepository<CommonaddressEntity,Long>, ICommonaddressRepository {
	@Query(value="select * from commonaddress WHERE province_name = ? and city_name = ? and country_name = ? "
			+ "and address = ? and contact_name = ? and contact_tele = ? and address_type = ? "
			+ "and company_id = ? and create_person_id = ?",nativeQuery = true)
	CommonaddressEntity checkExist(String provinceName, String cityName, String countryName, String address, String contactName,
			String contactTele, String addressType, Long companyId, Long createPersonId);
	
	
}
