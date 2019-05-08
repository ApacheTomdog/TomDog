package com.brcc.business.priceChange.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.brcc.business.priceChange.entity.PriceChangeEntity;
import com.brcc.business.priceChange.vo.PriceChangeVo;
import com.brcc.business.priceChange.vo.CompanyVo;

/**
 * 委托承运货源审核管理,委托承运调价管理
 * @author panyinfang
 *
 */
public interface PriceChangeRepository extends JpaRepository<PriceChangeEntity,Long>,IPriceChangeRepository{

	/**
	 * 委托承运货源审核管理作废
	 */
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update goodsorderm set status='00',update_date = now(),update_person = ? where publish_id = ? and platform_id = ?" ,nativeQuery=true) 
	Integer delectPrice(String username,Long publishId,String platformId);
	
	/**
	 * 委托承运调价管理 保存
	 * 
	 */
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update price_change set carry_price=?,diff_price=?,modify_date = now(),modify_person_id = ?,modify_person_name=? where price_change_id = ?" ,nativeQuery=true) 
	Integer saveUpdate(BigDecimal carryPrice,BigDecimal diffPrice,Long modifyPersonId,String modifyPersonMame,Long priceChangeId);
	
	/**
	 * 委托承运货源审核管理查询价格
	 */	
	@Query(value="SELECT\r\n" + 
			"IF (m. STATUS = '10', 0.00, m.price) AS carry_price,\r\n" + 
			" (m.price + m.owner_adjust_amt) AS client_price,\r\n" + 
			"IF (\r\n" + 
			"	t.client_rate_type = '1',\r\n" + 
			"	TRUNCATE (\r\n" + 
			"		(m.price + m.owner_adjust_amt) / (1 + client_rate),\r\n" + 
			"		2\r\n" + 
			"	),\r\n" + 
			"	TRUNCATE (\r\n" + 
			"		(m.price + m.owner_adjust_amt) * (1 - client_rate),\r\n" + 
			"		2\r\n" + 
			"	)\r\n" + 
			") AS fPrice,\r\n" + 
			" m.publish_id,\r\n" + 
			" m.price,\r\n" + 
			" m.owner_adjust_amt\r\n" + 
			"FROM\r\n" + 
			"	apptms.price_client_rate t,\r\n" + 
			"	apptms.goodsorderm m\r\n" + 
			"WHERE\r\n" + 
			"	t.client_id = m.company_id\r\n" + 
			"AND m.publish_id = ?1 \r\n" + 
			"AND t.carry_id = ?2 ", nativeQuery=true)
	PriceChangeEntity getPrice(Long publishId,Long carryId);
	
	
	
	/**
	 * 委托承运调价管理查询价格
	 */
	@Query(value="SELECT\r\n" + 
			"	IF (m. STATUS = '10', 0.00, m.price) AS carry_price1,\r\n" + 
			"	 (m.price + m.owner_adjust_amt) client_price1,\r\n" + 
			"	IF (\r\n" + 
			"		t.client_rate_type = '1',\r\n" + 
			"		TRUNCATE (\r\n" + 
			"			(p.client_price) / (1 + client_rate),\r\n" + 
			"			2\r\n" + 
			"		),\r\n" + 
			"		TRUNCATE (\r\n" + 
			"			(p.client_price) * (1 - client_rate),\r\n" + 
			"			2\r\n" + 
			"		)\r\n" + 
			"	) AS fPrice,\r\n" + 
			"	 m.publish_id,\r\n" + 
			"	 m.company_id,\r\n" + 
			"	 m.price,\r\n" + 
			"	 m.owner_adjust_amt,\r\n" + 
			"	 p.price_change_id,\r\n" + 
			"	 p.carry_price,\r\n" + 
			"	 p.client_price,\r\n" + 
			"	 p.diff_price\r\n" + 
			"	FROM\r\n" + 
			"		apptms.price_client_rate t,\r\n" + 
			"		apptms.goodsorderm m,\r\n" + 
			"		apptms.price_change p\r\n" + 
			"	WHERE\r\n" + 
			"		t.client_id = m.company_id\r\n" + 
			"	AND m.publish_id = ?1 \r\n" + 
			"	AND t.carry_id = ?2 \r\n" + 
			"	AND p.price_change_id = ?3 ", nativeQuery=true)
	PriceChangeEntity getPriceTJ(Long publishId,Long carryId,Long priceChangeId);

}
