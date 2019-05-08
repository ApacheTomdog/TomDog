package com.brcc.business.transportbill.repository;

import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.vo.TransportationDeliveryQueryVo;
import com.esteel.common.controller.WebReturnMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:22
 */
public interface TransportationDeliveryRepository extends JpaRepository<TransportationDeliveryEntity,Long>,ITransportationDeliveryRepository {

	/**
	 * 根据运输单查找对应的调度单
	 * @param transId
	 * */
	List<TransportationDeliveryEntity> findByTransId(Long transId);

	/**
	 * 根据货源单号查找对应的调度单
	 * @param deliveryId
	 * */
	TransportationDeliveryEntity findByDeliveryIdAndPlatformId(Long deliveryId, String platformId);

	/**
	 * 查询待装货的运单数(个人)
	 * @param companyId
	 */
	@Query(value="SELECT count(1) FROM apptms.transportationdelivery t "
			+ "where 1=1 and t.status != '00' and t.status != '90' and "
			+ "t.platform_id = ? and  t.company_id = ?",nativeQuery=true)
	Long checkDriverBill(String platformId, Long companyId);

	/**
	 * 更新装车状态
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="update transportationdelivery t set t.truck_loading_weight=?, t.zc_weight_from ='1', t.status = ?, t.update_date=now(), t.update_person=?, t.zcSure_date = now(), t.delivery_time = now() WHERE t.delivery_id=?",nativeQuery=true)
	void zcWeight(BigDecimal truckLoadingWeight, String status, Long userId, Long deliveryId);

	/**
	 * 修改装车重量
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE transportationdelivery t SET t.truck_loading_weight = ?, t.zc_weight_from = ?, t.remark = ?, t.update_date=now(), t.update_person=? WHERE t.delivery_id = ? and ifNull(t.settle_status,'10') = '10'",nativeQuery=true)
	void changeZcWeight(BigDecimal truckLoadingWeight, String zcWeightFrom, String remark, Long userId, Long deliveryId);

	/**
	 * 修改收货重量
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE transportationdelivery t SET t.take_delivery_weight = ?, t.remark = ?, t.update_date=now(), t.update_person=? WHERE t.delivery_id = ? and ifNull(t.settle_status,'10') = '10'",nativeQuery=true)
	void changeShWeight(BigDecimal takeDeliveryWeight, String remark, Long userId, Long deliveryId);

	/**
	 * 拼单状态检查
	 * @param pinDanNum
	 * @param platformId
	 * @return
	 */
	@Query(value="select * from transportationdelivery t,goodsorderm g where 1=1 and t.publish_id = g.publish_id and g.pin_dan_num = ? and g.platform_id = ? and t.status > '10'",nativeQuery=true)
	List<TransportationDeliveryEntity> pinDanCheck(String pinDanNum, String platformId);

	/**
	 * 保存撤单申请记录
	 * @param remark
	 * @param userId
	 * @param userName
	 * @param platformId
	 * @param deliveryId
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="INSERT INTO deliverycancelaudit ( platform_id, publish_id, trans_id, delivery_id, delivery_cancel_type, remark, " +
			"create_date, create_person_id, create_person_name, modify_date, modify_person_id, modify_person_name, carry_company_id, " +
			"carry_company_name, driver_id, driver_name, vehicle_id, vehicle_num, fd_company_id, fd_user_id, if_can_show) " +
			"select :platformId, t.publish_id, t.trans_id, t.delivery_id, '10', :remark, now(), :userId, :userName, " +
			"now(), :userId, :userName, t.company_id, (select c.company_name from company c where c.seq_id = t.company_id), " +
			"t.driver_id, (select d.name from driver d where d.id = t.driver_id), t.vehicle_id, (select v.vehicle_num " +
			"from vehicle v where v.vehicle_id = t.vehicle_id ), t.publish_company_id, t.fd_user_id, t.if_can_show " +
			"from transportationdelivery t where t.delivery_id = :deliveryId and t.platform_id = :platformId",nativeQuery=true)
	void saveDeliveryCancel(@Param("remark")String remark, @Param("userId")Long userId, @Param("userName")String userName, @Param("platformId")String platformId, @Param("deliveryId")Long deliveryId);


/*	@Modifying(clearAutomatically = true)
	@Query(value = "select * from transportationdelivery where delivery_id = ?1",nativeQuery = true)
	TransportationDeliveryQueryVo findByDeliveryId(@Param("deliveryId")Long deliveryId);*/
	/***
	 * 保存川威上传回单信息
	 */
	@Modifying(clearAutomatically = true)
	@Query(value = "insert into reinfotocw( deliveryId,lng,lat,address,arriveTime,imageAddress,isupload,ec_plat_name) values (?,?,?,?,?,?,'0',?)",nativeQuery = true)
	int insertToReInfoToCW(@Param("deliveryId")Long deliveryId,
						   @Param("lng")Double destinationLng,
						   @Param("lat")Double destinationLat,
						   @Param("address")String address,
						   @Param("arriveTime") Date arriveTime,
						   @Param("imageAddress")String imageAddress,
						   @Param("ecPlatName")String ecPlatName);


	/**
	 * 合并装车收货重量
	 * @param userId
	 * @param platformId
	 * @param deliveryId
	 * @param truckLoadingWeight
	 * @param takeDeliveryWeight
	 * @param comfirmPic1Local
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE transportationdelivery tr SET  tr.hd_zc_sh_time=now(), tr.hd_zc_sh_modify_person_id=:userId, tr.if_upload_receipt_flag='1', tr.truck_loading_weight=:truckLoadingWeight, tr.take_delivery_weight=:takeDeliveryWeight, tr.comfirm_pic1_local=:comfirmPic1Local where tr.delivery_id=:deliveryId and tr.platform_id=:platformId and tr.`status`='90' and ifnull(tr.settle_status,'10')='10'",nativeQuery=true)
	void saveAgreement(@Param("userId")Long userId, @Param("platformId")String platformId, @Param("deliveryId")Long deliveryId, @Param("truckLoadingWeight")BigDecimal truckLoadingWeight, @Param("takeDeliveryWeight")BigDecimal takeDeliveryWeight, @Param("comfirmPic1Local")String comfirmPic1Local);

	/**
	 * 经纪人运费定额分配
	 * @param brokerPeopleType
	 * @param tollAmount
	 * @param userId
	 * @param deliveryId
	 * @param platformId
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE transportationdelivery t SET t.broker_people_toll_type = :brokerPeopleType, t.broker_people_toll_amount = :tollAmount, t.broker_people_toll_ratio=0, t.update_date = now(), t.update_person = :userId WHERE t.delivery_id = :deliveryId AND t.platform_id = :platformId AND t.if_broker_people_toll_flag = 'Y' AND ifnull(t.settle_status,'10')='10' AND t.`status` > '00' AND t.amount >= :tollAmount",nativeQuery=true)
	int changeDjBroker(@Param("brokerPeopleType")String brokerPeopleType, @Param("tollAmount")BigDecimal tollAmount, @Param("userId")Long userId, @Param("deliveryId")Long deliveryId, @Param("platformId")String platformId);

	/**
	 * 经纪人运费定率分配
	 * @param brokerPeopleType
	 * @param tollRatio
	 * @param userId
	 * @param deliveryId
	 * @param platformId
	 */
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE transportationdelivery t SET t.broker_people_toll_type = :brokerPeopleType, t.broker_people_toll_amount =0, t.broker_people_toll_ratio = (:tollRatio/100), t.update_date = now(), t.update_person = :userId WHERE t.delivery_id = :deliveryId AND t.platform_id = :platformId AND t.if_broker_people_toll_flag = 'Y' AND ifnull(t.settle_status,'10')='10' AND t.`status`>'00' AND t.amount>=(t.amount*(:tollRatio/100))",nativeQuery=true)
	int changeDlBroker(@Param("brokerPeopleType")String brokerPeopleType, @Param("tollRatio")BigDecimal tollRatio, @Param("userId")Long userId, @Param("deliveryId")Long deliveryId, @Param("platformId")String platformId);

	/**
	 * @Desc 查询是否有未扣杂实重量
	 * @param companyId
	 * @param platformId
	 * @return
	 * @author yangwenbin
	 * @version 创建时间：2019年1月21日 下午1:33:36
	 */
	@Query(value="SELECT count(1) AS num FROM goodsordermjksetplat s WHERE s.tms_fd_company_id = :companyId AND s.tms_platform_id = :platformId AND s.if_rough_weight_cal = '1'",nativeQuery=true)
	Long queryBatchCalcCondition(@Param("companyId") Long companyId, @Param("platformId") String platformId);

	/**
	 * 根据资金流水单号查询下面的所有调度单信息
	 * @param brokerFundsControlMasterId
	 * */
	List<TransportationDeliveryEntity> findByBrokerFundsControlMasterId(Long brokerFundsControlMasterId);

	/**
	 * 功能描述: <br>
	 * 〈批量审批回单〉
	 */
	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query(value = "update transportationdelivery t SET t.risk_audit_status = ?2,t.risk_audit_date = now() WHERE t.delivery_id IN (?1)",nativeQuery = true)
	int updateRiskAuditStatus(@Param(value = "deliveryIds") Collection<Long> deliveryIds, @Param(value = "status")String status);

	/**
	 * 功能描述: <br>
	 * 〈更新回单不通过原因〉
	 */
	@Modifying
	@Transactional(rollbackFor = Exception.class)
	@Query(value = "update transportationdelivery t SET t.risk_audit_type = ?2 ,t.risk_audit_date = now() WHERE t.delivery_id IN (?1)",nativeQuery = true)
	int updateRiskAuditType(@Param(value = "deliveryIds") Collection<Long> deliveryIds, @Param(value = "cause")String cause);
	/**
	 * 查找拼单单据
	 * @param vo
	 * @return List<TransportationDeliveryEntity>
	 */
	List<TransportationDeliveryEntity> findAllBySpellListNum(String spellListNum);

}
