package com.brcc.business.transportSettle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.transportSettle.entity.PayBillChildEntity;

/**
 * @Description 计算单子表交互接口
 * @author yangwenbin
 * @version 创建时间：2018年11月8日 下午1:47:50
 */
public interface PayBillChildRepository extends JpaRepository<PayBillChildEntity,Long> ,IPayBillChildRepository {
	
	/**
	 * 根据zfId查找已支付或已支付完成的子单数
	 * @param zfId
	 * @return
	 */
	@Query(value="select count(1) from pay_bill_child p where p.status > '10' and p.zf_id = ? ", nativeQuery=true)
	Integer queryPayedChildNum(Long zfId);
	
	/**
	 * 根据zfId作废支付子单
	 * @param zfId
	 * @param platformId
	 * @param status
	 * @param preStatus
	 * @param userId
	 * @param userName
	 * @return
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="UPDATE pay_bill_child t\r\n" + 
			"SET t. STATUS = ?3, t.update_date = now(),\r\n" + 
			" t.update_person_id = ?5, t.update_person_name = ?6\r\n" + 
			"WHERE t.platform_id = ?2\r\n" + 
			"AND t.zf_id = ?1\r\n" + 
			"AND t. STATUS = ?4", nativeQuery=true)
	Integer updatePayBillChild(Long zfId, String platformId, String status, String preStatus, Long userId,
			String userName);

	/**
	 * 根据zfId查询支付子单
	 * @param zfId
	 * @return
	 */
	List<PayBillChildEntity> findByZfId(Long zfId);
}
