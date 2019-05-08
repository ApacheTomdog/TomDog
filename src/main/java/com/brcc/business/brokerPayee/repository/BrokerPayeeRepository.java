package com.brcc.business.brokerPayee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.brcc.business.brokerPayee.entity.BrokerPayeeEntity;


/**
 * 分配收款人管理
 * @author panyifang
 *
 */
public interface BrokerPayeeRepository  extends JpaRepository<BrokerPayeeEntity,Long>,IBrokerPayeeRepository{
	
	/**
	 * 生效和作废
	 * @return
	 */
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update broker_payee set company_payee_status=?1,modify_date =now(),modify_person_id =?2,modify_person_name =?3 where 1=1  AND company_payee_id=?4" ,nativeQuery=true) 
	Integer agreeBrokerPayee(String companyPayeeStatus,Long userId, String username, Long companyPayeeId);
	
	/**
	 * 查询公司名
	 */
	@Transactional
	@Query(value="SELECT  c.company_name FROM company c  where c.seq_id= ?" ,nativeQuery=true) 
	String getCompanyName(Long companyId);
	
	
	/**
	 * 
	 */
	@Query(value="select count(1) from broker_payee b where b.company_payee_name=?1 and b.company_payee_num=?2 and b.company_payee_status='20' ", nativeQuery=true)
	Integer checkAll(String companyPayeeName,String companyPayeeNum);

	@Transactional
	@Query(value="SELECT  b.company_payee_id FROM broker_payee b  where b.company_id= ?1 and b.company_payee_name=?2 and b.company_payee_num=?3 and b.company_payee_status=?4" ,nativeQuery=true)
	Long  checkIfExist(Long companyId,String companyPayeeName,String companyPayeeNum,String companyPayeeStatus);
}
