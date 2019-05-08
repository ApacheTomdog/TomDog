package com.brcc.business.goodsorderm.service;
import java.util.List;

import com.brcc.business.goodsorderaddweightdetail.entity.GoodsorderaddweightdetailEntity;
import org.springframework.data.domain.Page;

import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;
import com.brcc.business.goodsorderm.vo.GoodsownerfdconfigVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.esteel.common.controller.WebReturnMessage;


/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午8:53:41
* @ClassName 类名称
* @Description 类描述
*/
public interface GoodsordermService {
	 /**
     * 平台分页
     * @param vo
     * @return
     */
    Page<GoodsordermVo> listForPlat(GoodsordermQueryVo vo);
    
    /**
     * 货主分页
     * @param vo
     * @return
     */
    Page<GoodsordermVo> listForPublisher(GoodsordermQueryVo vo);
    
    /**
     * 货主保存，发布，修改货源列表页面
     * @param vo
     * @return
     */
    Page<GoodsordermVo> querySavePublish(GoodsordermQueryVo vo);
    
    
    /**
     * 平台导出对应的数据
     * @param vo
     * @return
     */
    List<GoodsordermVo> queryList(GoodsordermQueryVo vo);

    /**
     * 根据货源单id查询货源单的详情信息
     * @param vo
     * @return
     */
    GoodsordermVo goodsordermDetail(GoodsordermQueryVo vo);
    /**
     * 根据id获取
     * @param bankId
     * @return
     */
    GoodsordermEntity findById(Long publishId);


	/**
	 * 查询
	 * @param vo
	 * @return
	 */
	Page<GoodsordermVo> listData(GoodsordermQueryVo vo);


	/**
	 * 保存
	 * @param vo
	 */
	void save(GoodsordermVo vo);
	
	/**
	 * 保存
	 * @param vo
	 */
	GoodsordermEntity saveGoodsordermVo(GoodsordermVo vo);


	/**
	 * 根据id删除
	 * @param bankId
	 */
	void deleteById(Long publishId);


	 /**
     * @Desc 货源单下调度单明细数据
     * @param vo 
     * @return
     */
	List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo);



	 /**
     * @Desc 货源单下物流跟踪(运输单)明细数据
     * @param vo 
     * @return
     */
	List<TransportationmEntity> listTransportationDetails(GoodsordermQueryVo vo);

	 /**
     * @Desc 运输单单下调度单明细数据
     * @param vo 
     * @return
     */
	List<TransportationDeliveryEntity> deliveryDetail(TransportBillQueryVo vo);

	/**
	 * @Description  检测是否是自己的货源单号
	 * @Param [companyId, userId, platformId, publishId]
	 * @return java.lang.Long
	 **/
	Long verifyPublishId(Long companyId,Long userId,String platformId,Long publishId);

	/**
	 * @Description  检测货源单号状态
	 * @Param [platformId, publishId]
	 * @return java.lang.String
	 **/
	String checkStatus(String platformId,Long publishId);
	
	/**
	 * @Description 撤销货源单
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void revoke(GoodsordermQueryVo vo);

	/**
	 * @Description 作废货源单剩余量
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void revokeOther(GoodsordermQueryVo vo);
	
	/**
	 * @Description 终止可拆单的货源单
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void stopPublish(GoodsordermQueryVo vo);
	
	/**
	 * 查询是否已发布过有效的委托承运单据
	 */
	Integer findGoodCountTax(GoodsordermjkVo vo);
	
	/**查询是否已发布过有效的非委托承运单据*/ 
	Integer findGoodCount(GoodsordermjkVo vo);

	/**保存*/
	GoodsordermEntity save(GoodsordermEntity goodsordermEntity);

	/**校验采购单据是否都是委托承运或者非委托承运*/
	GoodsordermEntity queryEntity(GoodsordermQueryVo queryVo);
 
	/**委托承运货源单分页数据*/
	Page<GoodsordermVo> listTaxGoodBill(GoodsordermQueryVo vo);
	
	/**货源单调价*/
	void changePrice(GoodsordermQueryVo vo);

	/**手动增发*/
	void saveIncresment(GoodsorderaddweightdetailEntity vo);

	void updateAddWeight(GoodsorderaddweightdetailEntity vo);


	/**挂牌价修改*/
	void changeGpPrice(GoodsordermQueryVo vo);
	
	/**
	 * @Description 作废货主货源发布下的货源单
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void  deletePublish(GoodsordermQueryVo vo);
	/**
	 * @Description 复制货主货源发布下的货源单
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void copyPublish(GoodsordermQueryVo vo);
	/**
	 * @Description 发布货主货源发布下的货源单
	 * @Param GoodsordermQueryVo vo
	 * @return WebReturnMessage
	 **/
	void effectPublish(GoodsordermQueryVo vo);

	/**货源单价格信息查询*/
	GoodsordermVo queryGoodPrice(GoodsordermQueryVo vo);

	/**货源单价格修改*/
	void updateGoodPrice(GoodsordermQueryVo vo);

	/**货源单报价记录*/
	List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo);

	/**抢单列表分页数据*/
	Page<GoodsordermVo> queryGrabList(GoodsordermQueryVo vo);
	/**查询生效的委托流程*/
	List<VatflowdetailEntity> queryEffectFlow(VatflowmasterQueryVo vo);
	/**查询对应货主的装车推迟时间*/
	GoodsownerfdconfigVo queryGoodsownerfdconfigVo(GoodsordermQueryVo vo);
	/**保存常用地址信息**/
	void  saveAddress(GoodsordermVo vo);
	/**发布新的主单信息**/
	void addNewGoodsorderm(GoodsordermVo vo);
	/**保存新的主单信息**/
	void addNewPtGoodsorderm(GoodsordermVo vo);
	
	/**校验:经纪人才可以抢委托承运单*/
	WebReturnMessage checkGrabPer(GoodsordermQueryVo vo);
	
	/**抢单逻辑*/
	WebReturnMessage grabBill(GoodsordermVo vo);

	/**货源单发布修改页面详情**/
	GoodsordermVo getGoodsordermDetail(GoodsordermQueryVo vo);
	/**修改货源单信息*/
	void updateGoodsorderm(GoodsordermVo vo);
	/**抢单报价失败后更细报价信息*/
	void setGoodsOrderQuotationRemark(GoodsordermVo vo);
	/**计算货源单发布的含税价格*/
	void getPriceTax(GoodsordermVo vo);

	 /**
     * @Desc 委托承运流程查询 
     * @param vo
     */
	List<VatflowdetailVo> queryTaxRate(VatflowmasterQueryVo vo);

	/**生成运单*/
	void createTransBill(GoodsorderquotationQueryVo vo);

	/**货源单货物单价调整列表数据*/
	Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo);

	/**货源单授信调价明细 */
	List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo);

	/** 作废Goodsordermjk */
	void invalidGoodsordermjk(Long importId);
}
