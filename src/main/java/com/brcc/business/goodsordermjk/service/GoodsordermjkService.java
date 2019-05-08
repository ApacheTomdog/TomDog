package com.brcc.business.goodsordermjk.service;
import org.springframework.data.domain.Page;

import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkQueryVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.esteel.common.controller.WebReturnMessage;

import java.math.BigDecimal;


/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 上午9:10:37
* @Description 外部接口查询
*/
public interface GoodsordermjkService {
	
	/**
	* @author PanJianYang
	* @Description 外部接口电商查询
	* @return Page<GoodsordermjkVo>
	* @param GoodsordermjkQueryVo
	*/
	Page<GoodsordermjkVo> list(GoodsordermjkQueryVo vo);
	
	/**
	* @author PanJianYang
	* @Description 外部接口采购查询
	* @return Page<GoodsordermjkVo>
	* @param GoodsordermjkQueryVo
	*/
	Page<GoodsordermjkVo> cgList(GoodsordermjkQueryVo vo);
	
	/**
	* @author PanJianYang
	* @Description 外部接口电商拼单页面查询
	* @return Page<GoodsordermjkVo>
	* @param GoodsordermjkQueryVo
	*/
	Page<GoodsordermjkVo> pinDanList(GoodsordermjkQueryVo vo);
	
	/**
	* @author PanJianYang
	* @Description 电商单据加入拼单池
	* @return WebReturnMessage
	* @param GoodsordermjkQueryVo
	*/
	WebReturnMessage addPool(GoodsordermjkQueryVo vo);
	/**
	* @author PanJianYang
	* @Description 从拼单池移除单据
	* @return WebReturnMessage
	* @param GoodsordermjkQueryVo
	*/
	WebReturnMessage deleteFromPool(GoodsordermjkQueryVo vo);
	/**
	* @author PanJianYang
	* @Description 对拼单池里面的单据做拼单操作
	* @return WebReturnMessage
	* @param GoodsordermjkQueryVo
	*/
	WebReturnMessage doPinDan(GoodsordermjkQueryVo vo);

	/**
	* @author TangYong
	* @Description 保存常用路线
	* @return WebReturnMessage
	* @param GoodsordermjkQueryVo
	*/
	void saveAddress(GoodsordermjkVo vo);

	/**
	* @author TangYong
	* @Description 查询单据信息
	* @return GoodsordermjkVo
	* @param GoodsordermjkQueryVo
	*/
	GoodsordermjkVo queryGoodOrderMJK(GoodsordermjkQueryVo vo);
	
	/**
     * 保存所有相同拼单号的货源信息
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
	WebReturnMessage savePinDanInfo(GoodsordermjkVo vo);
	
	/**
     * 撤销外部接口货源
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
	Integer revokeGoodsordermjk(Long publishId);

	 /**
     * 保存货源单据信息(单条)
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
	WebReturnMessage saveCompleteInfo(GoodsordermjkVo vo);
	
	GoodsordermjkEntity findById(Long importId);
	
	GoodsordermjkEntity save(GoodsordermjkEntity goodsordermjkEntity);

	/**
     * 根据单据号查询是否为新增的货源单据(statu=10)
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
	GoodsordermjkEntity queryActive(GoodsordermjkVo vo);

	/**
	 * 货源单据的经纬度调整
	 * @param vo 
	 */
	void updateGoodsOrdermjkLngLat(GoodsordermjkVo vo);

	/**
	 * 外部接口电商货源单发布
	 * @param vo 
	 */
	void agree(GoodsordermjkVo vo);

	/**
	 * 计算含税价格
	 * @param vo 
	 */
	void getPriceTax(GoodsordermjkVo vo);

	/**
	 * 外部接口电商货源单拼单发布
	 * @param vo 
	 */
	void publishPinDan(GoodsordermjkVo vo);
	
	/**
	 * 校验采购单据是否都是委托承运或者非委托承运
	 * @param param 
	 */
	GoodsordermEntity checkIfTaxTransport(GoodsordermjkVo param);

	/**
	 * 获取大品种信息
	 * @param vo 
	 */
	CatalogInfoVo getCatalogId(GoodsordermjkQueryVo vo);

	/**
	 * 电商  -- 批量发布
	 * @param vo 
	 */
	void publishByBatch(GoodsordermjkVo vo);
	
	/**
	 * 采购  -- 批量发布
	 * @param vo 
	 */
	void publishForU8ByBatch(GoodsordermjkVo vo);

	/**
	 * 根据货源单查询外部货源信息
	 * @param publishId 
	 * @param platformId 
	 */
	GoodsordermjkEntity findByPublishIdAndPlatformId(Long publishId, String platformId);

	/**
     * @Desc: 单据的开启、关闭
     * @param GoodsordermjkVo
     */
	void updateOnOff(GoodsordermjkVo vo);

	/**
	 * @Description  更新外部接口货源单状态
	 * @Param  publishId
	 * @return Integer
	 **/
	void updateStatusJk(Long publishId, String platformId);

	/**
	 * @Description  更新外部接口货源单信息
	 * @Param  publishId
	 * @return Integer
	 **/
	void updateGoodInfo(BigDecimal goodWeight, Long importId);

	/**消息推送*/
	void orderPush(GoodsordermjkVo vo);

	/**电商货源批量完善*/
	void saveCompleteInfoByBatch(GoodsordermjkVo vo);

	/** 保存合同号*/
	void saveContractNumber(GoodsordermjkVo vo);

	/** 删除 */
    void delete(GoodsordermjkEntity goodsordermjkEntity);
    /**
     * 检测是否有重复的dependID
     * @param ret2
     * @param ret1
     * @return
     */
    GoodsordermjkEntity findByRet2AndRet1(String ret2,String ret1);
}
