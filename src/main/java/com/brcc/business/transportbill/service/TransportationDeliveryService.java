package com.brcc.business.transportbill.service;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.vo.*;

import java.util.List;

import com.esteel.common.controller.WebReturnMessage;
import org.springframework.data.domain.Page;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:24
 */
public interface TransportationDeliveryService {


	/**
	 * 调度单查询
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> queryPage(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询调度单列表
	 * @param transportBillQueryVo
	 * @return
	 */
	List<TransportationDeliveryVo> queryList(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 运费计算
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> settleList(TransportBillQueryVo transportBillQueryVo);

	/**
	 * @Desc 查询单个货源单下的调度单列表
	 * @param VatflowdetailQueryVo
	 * @return List<TransportationDeliveryVo>
	 */
	List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo);

	/**
	 * 保存计算备注
	 * @param vo
	 */
	void saveJsRemark(TransportBillQueryVo vo);

	/**
	 * 保存回单图片
	 * @param vo
	 */
	void saveConfirmPic(TransportBillQueryVo vo);

	/**
	 * @Desc 查询单个运输单下的调度单列表
	 * @param VatflowdetailQueryVo
	 * @return List<TransportationDeliveryVo>
	 */
	List<TransportationDeliveryEntity> queryDeliveryDetail(TransportBillQueryVo vo);

	/**
	 * 查询单个调度单
	 * @param deliveryId
	 * @return
	 */
	TransportationDeliveryEntity findById(Long deliveryId);

	/**
	 * 保存调度单
	 * @param transportationDeliveryEntity
	 * @return
	 */
	TransportationDeliveryEntity save(TransportationDeliveryEntity transportationDeliveryEntity);

	/**
	 * 查询运费计算导出信息
	 * @param queryVo
	 * @return
	 */
	List<TransportationDeliveryVo> querySettleInfo(TransportBillQueryVo queryVo);

	/**
	 * 查询登记页面初始展示数据
	 * @param queryVo
	 * @return
	 */
	TransportationDeliveryVo queryDeliveryVo(TransportBillQueryVo queryVo);

	/**
	 * 统一运费计算
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> settleListForGroup(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询统一运费计算导出信息
	 * @param queryVo
	 * @return
	 */
	List<TransportationDeliveryVo> querySettleInfoForGroup(TransportBillQueryVo queryVo);

	/**
	 * 查询登记页面初始展示数据（集团）
	 * @param queryVo
	 * @return
	 */
	TransportationDeliveryVo queryDeliveryVoForGroup(TransportBillQueryVo queryVo);

	/**
	 * 更新调度单状态
	 * @param transportationBillOperatorVo
	 * @return
	 */
	String updateStatus(TransportationBillOperatorVo transportationBillOperatorVo);

	/**
	 * 查询已经完成的 运输订单的数量
	 * @param transId
	 * @param platformId
	 * @return
	 */
	DeliveryComplateWeightVo findCompleteWeightByTransId(Long transId, String platformId);

	/**
	 * 查询已经完成的 货源单 的数量
	 * @param publishId
	 * @param platformId
	 * @return
	 */
	DeliveryComplateWeightVo findCompleteWeightByPublishId(Long publishId, String platformId);

	/**
	 * 处理标记
	 * @param transportationBillOperatorVo
	 * @return
	 */
	boolean dealFlag(TransportationBillOperatorVo transportationBillOperatorVo);


	/**
	 * @Description  查询调度单预警列表
	 * @Param [vo]
	 * @return org.springframework.data.domain.Page<com.brcc.business.transportbill.vo.TransportationDeliveryQueryVo>
	 **/
	Page<TransportationDeliveryQueryVo> queryListWarning(TransportationDeliveryQueryVo vo);

	/**
	 * 查询委托承运付款指令撤销审核数据
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> listDataForCancelAudit(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询待装货的运单数(公司)
	 * @param transQuery[companyId]
	 */
	Long checkGrab(TransportBillQueryVo transQuery);

	/**
	 * 查询待装货的运单数(个人)
	 * @param transQuery[companyId]
	 */
	Long checkDriverBill(String platformId, Long companyId);

	/**
	 * 保存回单截图地址
	 * @param vo
	 * @return
	 */
	boolean saveReceipt(TransportBillQueryVo vo);

	/**
	 * 装车确认
	 * @param vo
	 * @return
	 */
	boolean zcConfirm(TransportBillQueryVo vo);

	/**
	 * 修改装车、收货重量
	 * @param vo
	 * @return
	 */
	boolean saveWeight(TransportBillQueryVo vo);

	/**
	 * 查询调度单(打印用)
	 * @param transportBillQueryVo
	 * @return
	 */
	TransportationDeliveryVo queryPublisherId(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 撤单申请检查
	 * @param transportBillQueryVo
	 * @return
	 */
	WebReturnMessage deliveryCancel(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 保存撤单申请记录
	 */
	void saveDeliveryCancel(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 合并装车收货重量
	 * @param transportBillQueryVo
	 */
	void saveAgreement(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询承运级调度单
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> queryCyPage(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 经纪人运费分配
	 * @param transportBillQueryVo
	 */
	String changeBroker(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询货主级调度单
	 * @param transportBillQueryVo
	 * @return
	 */
	Page<TransportationDeliveryVo> queryHzPage(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询货主级调度单列表
	 * @param transportBillQueryVo
	 * @return
	 */
	List<TransportationDeliveryVo> queryHzList(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 查询承运级调度单列表
	 * @param transportBillQueryVo
	 * @return
	 */
	List<TransportationDeliveryVo> queryCyList(TransportBillQueryVo transportBillQueryVo);

	/**
	 * @Desc 查询是否有未扣杂实重量
	 * @param queryVo
	 * @return
	 * @author yangwenbin
	 * @version 创建时间：2019年1月21日 上午10:23:43
	 */
	TransportationDeliveryVo queryBatchCalcCondition(TransportBillQueryVo queryVo);

	/**
	 * @Desc  通过资金流水单号查询所有的调度单信息
	 * @param brokerFundsControlMasterId
	 * @return
	 * @author panjianyang
	 * @version 创建时间：2019年2月12日
	 */
	List<TransportationDeliveryEntity> findByBrokerFundsControlMasterId(Long brokerFundsControlMasterId);

	TransportationDeliveryVo lookContracts(TransportBillQueryVo transportBillQueryVo);
	/**
	 * 查看运费
	 * @param transportBillQueryVo
	 * @return
	 */
	List<CheckFreightVo> checkFreight(Long deliveryId);

	/**
	 * 修改货主备注
	 */
	void updateGoodsOwnerPs(TransportBillQueryVo vo);

	/**
	 * 查询该公司是什么模式
	 */
	CompanyModelVo findModelById(Long companyId);
	/***
	 * 保存确认上传回单
	 */
	/**
	 * 修改签收状态
	 */
	void updateSignStatus(TransportBillQueryVo transportBillQueryVo);

	/**
	 * 回单审查分页数据
	 */
	Page<TransportationComfirmPicVo> comfirmPicData(TransportationComfirmPicQueryVo queryVo);

	/**
	 * 回单审查导出数据
	 */
	List<TransportationComfirmPicVo> excelDeliveryComfirmPicList(TransportationComfirmPicQueryVo queryVo);

	/**
	 * 功能描述: <br>
	 * 〈批量审核回单〉
	 * @!param status (00代表审核不通过，10代表未审核，20代表审核通过)
	 */
	int auditBybatch(List<Long> ids,String status);

	/**
	 * 功能描述: <br>
	 *  更新不成功原因
	 *  @param cause 不通过原因 （10重量异常、20车牌号异常、30时间异常、40回单信息异常、50品名异常）
	 */
	int rejectBybatch(List<Long> ids,String cause);

	/**
	 * 查找拼单单据
	 * @param vo
	 * @return List<TransportationDeliveryEntity>
	 */
	public List<TransportationDeliveryEntity> findAllBySpellListNum(String spellListNum);

}
