package com.brcc.business.goodsordermjk.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;

/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 上午9:08:18
* @ClassName 类名称
* @Description 类描述
*/
public interface GoodsordermjkRepository extends JpaRepository<GoodsordermjkEntity,Long>, IGoodsordermjkRepository{
	/**
	 * 根据外部接口电商importId拼接数据判断当前单据下的含税情况
	 * @param importIdStr
	 * @return
	 */
	@Query(value="select count(*) from goodsordermjk m where m.import_id in (?1) and m.if_tax_transport='Y'",nativeQuery=true)
	Integer queryGoodsorderjkTaxCount(List<String>  importIdList);
	
	/**
	 * 根据外部接口电商importIdStr判断单据是否来自同一个电商
	 * @param importIdStr
	 * @return
	 */		
	@Query(value="select count(DISTINCT SUBSTR(t.ret_2, 1, 2) ) as c FROM goodsordermjk t WHERE t.import_id in (?) ",nativeQuery=true)		
	Integer queryCountFromDifferntEc(String importIdStr);
	
	/** 校验是否存在有电商配送的单据(有拼单号)*/
	@Query(value="select count(1) FROM goodsordermjk t WHERE (t.import_id = ? or pin_dan_num= ?) and status != ? and ds_if_settle = ?",nativeQuery=true)		
	Integer countPublish(Long importId, Integer pinDanNum, String status, String dsIfSettle);
			
	/** 校验是否存在有电商配送的单据(无拼单号)*/		
	Integer countByImportIdAndStatusNotAndDsIfSettle(Long importId, String status, String dsIfSettle);
	
	/**
     * @Description  作废外部接口货源单
     * @Param  publishId
     * @return Integer
     **/
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update goodsordermjk t set t.status = '10',t.if_info_complete= 'N' where t.publish_id = ?" ,nativeQuery = true)
    Integer revokeGoodsordermjk(Long publishId);

    /** 查询电商配送的单据(有拼单号)*/
	List<GoodsordermjkEntity> findByPinDanNumAndStatusNot(Integer pinDanNum, String Status);
	
	/** 查询电商配送的单据(无拼单号)*/
	List<GoodsordermjkEntity> findByImportIdAndStatusNot(Long importId,String Status);

	/** 查询电商配送的单是否是新增的*/
	GoodsordermjkEntity findByStatusAndImportId(String string, Long importId);

	/**
	 * @Description  更新外部接口货源单状态
	 * @Param  publishId
	 * @return Integer
	 **/
	@Modifying(clearAutomatically=true)
	@Query(value = "update goodsordermjk t set t.status = '10', t.publish_id = null where t.publish_id = ? and  t.platform_id = ?" ,nativeQuery = true)
	void updateStatusJk(Long publishId, String platformId);

	/**
	 * @Description  更新外部接口货源单信息
	 * @Param  publishId
	 * @return Integer
	 **/
	@Modifying(clearAutomatically=true)
	@Query(value = "update goodsordermjk t set t.status = '10', t.init_spilt_weight = t.init_spilt_weight + ? where t.import_id = ?" ,nativeQuery = true)
	void updateGoodInfo(BigDecimal goodWeight, Long importId);

	GoodsordermjkEntity findByPublishIdAndPlatformId(Long publishId, String platformId);

	GoodsordermjkEntity findByImportIdAndStatus(Long importId,String status);

	@Query(value = "SELECT 	CONCAT( IFNULL( max( a.batch_id ), 0 ) + 1, '' ) as batchId  FROM  	NotifyRecord a " ,nativeQuery = true)
	String queryNotifyRecordBatchId();

	/**
	 * @Description  检测货源单下是否有调度单完成
	 * @Param
	 * @return java.lang.Long
	 **/
	@Query(value=" select count(1) from goodsordermjk t1  " +
			" JOIN goodsorderm t2 on ((t1.import_id=t2.import_id ) and (t1.platform_id=t2.platform_id)) " +
			" where t1.import_id=?2 and t1.platform_id=?1 " ,nativeQuery = true)
	Integer checkDiaoDD(String platformId,Long importId);
	
	GoodsordermjkEntity findByRet2AndRet1(String ret2,String ret1);
}
