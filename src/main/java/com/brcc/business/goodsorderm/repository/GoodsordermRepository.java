package com.brcc.business.goodsorderm.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.goodsorderm.entity.GoodsordermEntity;

/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午9:01:18
* @Descripe 货源单
*/

public interface GoodsordermRepository extends JpaRepository<GoodsordermEntity,Long>,IGoodsordermRepository{

    /**
     * @Description  检测是否是自己的货源单号
     * @Param [companyId, userId, platformId, publishId]
     * @return java.lang.Long
     **/
    @Query(value = "select COUNT(1) from goodsOrderm a where  a.company_id=?1 and a.user_id=?2 and  a.platform_id=?3 and a.publish_id=?4",nativeQuery = true)
    Long verifyPublishId(Long companyId,Long userId,String platformId,Long publishId);


    /**
     * @Description  检测货源单号状态
     * @Param [platformId, publishId]
     * @return java.lang.String
     **/
    @Query(value = "select a.status from goodsorderm a  where  a.platform_id=?1 and a.publish_id=?2",nativeQuery = true)
    String checkStatus(String platformId,Long publishId);
    
    /**
     * @Description  检测货源单下运输单的详情
     * @Param [platformId, publishId]
     * @return java.lang.String
     **/
    @Query(value = "select  count(*) from transportationm t where t.publish_id = ?2 and t.status not in ('00','60') and t.platform_id = ?1",nativeQuery = true)
    Integer checkTransWeight(String platformId,Long publishId);
    
    /**
     * @Description  作废货源单
     * @Param [platformId, publishId]
     * @return java.lang.String
     **/
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update GoodsOrderM t\r\n" + 
    		"		set t.status = '00',\r\n" + 
    		"		    t.update_person=?3,\r\n" + 
    		"		    t.update_date=now(),\r\n" + 
    		"		    t.remark=concat(now(),'被作废by',?3)\r\n" + 
    		"		where t.publish_id = ?2\r\n" + 
    		"		and  t.platform_id = ?1 ",nativeQuery = true)
    Integer revokeGoodsorderm(String platformId,Long publishId,Long userId);
    
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = " update goodsorderm t\n" + 
    		"        set \n" + 
    		"        t.rovoke_weight = t.weight,\n" + 
    		"        t.weight=0,\n" + 
    		"        t.qty=0,\n" + 
    		"        t.amount=0,\n" + 
    		"        t.init_weight=t.sale_weight,\n" + 
    		"        t.init_qty =t.sale_qty,\n" + 
    		"        t.init_amount =t.sale_amount,\n" + 
    		"        t.update_person=?3,\n" + 
    		"		t.update_date=now(),\n" + 
    		"		t.remark=concat(now(),'被作废剩余量by',?3)\n" + 
    		"        where t.publish_id = ?2\n" + 
    		"        and t.platform_id = ?1",nativeQuery = true)
    Integer updateOtherWeight(String platformId,Long publishId,Long userId);
    
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "UPDATE goodsorderm m\n" + 
    		"			SET m.`status` = '00',\n" + 
    		"			 m.update_date = now(),\n" + 
    		"			 m.update_person = ?3\n" + 
    		"			where m.platform_id= ?1\n" + 
    		"			and m.publish_id= ?2 \n" + 
    		"			and m.status='10'",nativeQuery = true)
    Integer deletePublish(String platformId,Long publishId,Long userId);

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE goodsorderm m\n" + 
    		"			SET m.status = '60',\n" +
    		"			 m.update_date = now(),\n" + 
    		"			 m.update_person = ?3 \n" +
    		"		where m.platform_id=?1 \n" + 
    		"			and m.publish_id=?2 \n" + 
    		"			and m.status > '00'\n" +
    		"			and m.status < '30'\n" +
    		"			and m.detachable='1'\n" + 
    		"			and m.sale_weight >0",nativeQuery = true)
    Integer updateStopPublish(String platformId,Long publishId,Long userId);
    
    /**
	 * @Desc: 查询是否已发布过有效的委托承运单据
	 * @param importId
	 */
    @Query(value = "select  count(*) from goodsorderm t where t.import_id = ? and t.if_tax_transport='Y' and t.`status` in('30','20')",nativeQuery = true)
	Integer findGoodCountTax(Long importId);

    /**
	 * @Desc: 查询是否已发布过有效的非委托承运单据
	 * @param importId
	 */
    @Query(value = "select  count(*) from goodsorderm t where t.import_id = ? and t.if_tax_transport='N' and t.`status` in('30','20')",nativeQuery = true)
	Integer findGoodCount(Long importId);

    /** 调价 */
    @Modifying(clearAutomatically=true)
    @Query(value = "update goodsorderm set "+
		"adjust_price_date = now(), "+
		"adjust_person_id = ?1, "+
		"adjust_person_name = ?2, "+
		"price = ?3, "+
		"amount = round(?4 * weight,2), "+
		"if_auto_price = '1' "+
		"where publish_id = ?5 "+
		"and platform_id = ?6 "+
		"and  status ='20' "+
		"and weight > 0",nativeQuery = true)
	Integer changePrice(Long userId,String userName,BigDecimal newPrice,BigDecimal newPrice1,Long publishId,String platformId);

    /**手动增发*/
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value = "insert into " +
			       "goodsorderaddweightdetail(publish_id,add_weight,create_date,add_carnum,add_weight_type,pickup_date,take_delivery_date,create_person_id,create_person_name,add_qty) " +
			       "values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)"
			       ,nativeQuery = true)
	Integer saveIncresment(Long publishId, BigDecimal addWeight,Date createDate, Integer addCarnum, String addWeightType, Date pickupDate,Date takeDeliveryDate,Long createPersonId,String createPersonName,BigDecimal addQty);

    @Transactional
    @Modifying(clearAutomatically=true)
	@Query(value = "update goodsorderm t " +
                   "set t.weight= round(t.weight+?2), " +
                   "t.add_weight_type = 'SD', " +
                   "t.add_weight_flag = 'Y', " +
                   "t.update_date= ?3, " +
                   "t.update_person= ?4  ," +
                   "t.pickup_date=?5 , " +
                   "t.take_delivery_date=?6 , " +
                   "t.amount = (t.amount + t.price * ?2) , " +
                   "t.qty= (t.qty + ?7)  " +
                   "where t.publish_id= ?1 "
                   ,nativeQuery = true)
	Integer updateAddWeight(Long publishId,BigDecimal addWeight,Date createDate,Long createPersonId,Date pickupDate,Date takeDeliveryDate,BigDecimal addQty);


	/** 修改挂牌牌价*/
    @Modifying(clearAutomatically=true)
    @Query(value = "update goodsorderm set "+
		"adjust_price_date = now(), "+
		"adjust_person_id = ?1, "+
		"adjust_person_name = ?2, "+
		"listing_price = ?3 "+
		"where publish_id = ?4 "+
		"and platform_id = ?5 "+
		"and  status ='20' "+
		"and weight > 0",nativeQuery = true)
	Integer changeGpPrice(Long userId,String userName,BigDecimal newPrice,Long publishId,String platformId);

	@Query(value = "select * from goodsorderm g where g.pri_publish_id=?1 and g.status > ?2",nativeQuery = true)
	List<GoodsordermEntity> findByPriPublishIdAndStatusGreaterThan(Long publishId, String string);


	 /**
     * @Desc 修改外部接口货源单的状态
     */
    @Modifying(clearAutomatically=true)
    @Query(value = "update GoodsOrderMJK t\n" + 
    			   "set t.status = ?1,\n" + 
    		       "t.publish_id = ?2,\n" + 
    		       "t.approve_time = now(),\n" + 
    		       "t.approve_user_id = ?3\n" + 
    		       "where t.import_id = ?4\n" +
    		       "and t.status = ?5",nativeQuery = true)
	Integer updateGoodsordermjkStatus(String newStatus ,Long publishId ,Long userId,Long importId,String preStatus);

//	List<GoodsordermEntity> findByPriPublishIdAndStatusGreaterThan(Long publishId, String string);

	/** 定向校验 */
	@Query(value = "select count(*)  from goodsorderm  t1,teamcompany t2 where t1.appoint_team_id=t2.team_id and t1.publish_id = ? and t2.cy_company_id = ? and t1.platform_id =t2.platform_id and t2.if_system ='Y'",nativeQuery = true)
	Long countTeamId(Long publishId, Long companyId);

	Optional<GoodsordermEntity> findByPublishIdAndStatus(Long publishId, String string);


}
