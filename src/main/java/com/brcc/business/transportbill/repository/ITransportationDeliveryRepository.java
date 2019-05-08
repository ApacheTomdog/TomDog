package com.brcc.business.transportbill.repository;

import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.vo.*;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhangxiuzhi
 * Date: 2018-11-02
 * Time: 16:23
 */
public interface ITransportationDeliveryRepository {
    /**
     * 查询调度单
     * @param transportBillQueryVo
     * @return
     */
    Page<TransportationDeliveryVo> queryPage(TransportBillQueryVo transportBillQueryVo);

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
     * 查询调度单列表
     * @param transportBillQueryVo
     * @return
     */
    List<TransportationDeliveryVo> queryList(TransportBillQueryVo transportBillQueryVo);
    
    /**
     * @Desc 查询单个货源单下的调度单列表
     * @param GoodsordermQueryVo
     * @return List<TransportationDeliveryVo>
     */
    List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo);

    /**
     * 查询对应公司的查询间隔
     * @param deliveryId
     * @return
     */
    IntervalTimeVo intervalTime(Long deliveryId);

    /**
     * 查询已经完成的 运输订单的数量
     * @param transId
     * @param platformId
     * @return
     */
    DeliveryComplateWeightVo findCompleteWeightByTransId(Long transId, String platformId);

    /**
     * 查询已经完成的货源单的数量信息
     * @param publishId
     * @param platformId
     * @return
     */
    DeliveryComplateWeightVo findCompleteWeightByPublishId(Long publishId, String platformId);


    /**
     * @Description  查询调度单预警列表
     * @Param [vo]
     * @return org.springframework.data.domain.Page<com.brcc.business.transportbill.vo.TransportationDeliveryQueryVo>
     **/
    Page<TransportationDeliveryQueryVo> queryListWarning(TransportationDeliveryQueryVo vo);
    
    /**
     * 查询待装货的运单数
     * @param transQuery[companyId]
     */
    Long checkGrab(TransportBillQueryVo transQuery);

    /**
     * 查询调度单(打印用)
     * @param transportBillQueryVo
     * @return
     */
    TransportationDeliveryVo queryPublisherId(TransportBillQueryVo transportBillQueryVo);

    /**
     * 查询撤单申请状态
     * @param transportBillQueryVo
     * @return
     */
    TransportationDeliveryVo deliveryCheck(TransportBillQueryVo transportBillQueryVo);

    /**
     * 查询承运级调度单
     * @param transportBillQueryVo
     * @return
     */
    Page<TransportationDeliveryVo> queryCyPage(TransportBillQueryVo transportBillQueryVo);

    /**
     * 查询承运级调度单列表
     * @param transportBillQueryVo
     * @return
     */
    List<TransportationDeliveryVo> queryCyList(TransportBillQueryVo transportBillQueryVo);

    TransportationDeliveryVo lookContracts(TransportBillQueryVo transportBillQueryVo);
    
    /**
     * 查看运费
     */
    List<CheckFreightVo> checkFreight (Long deliveryId);

    /**回单审查分页数据*/
    Page<TransportationComfirmPicVo> comfirmPicData(TransportationComfirmPicQueryVo queryVo);

    /**回单审查导出数据*/
    List<TransportationComfirmPicVo> excelDeliveryComfirmPicList(TransportationComfirmPicQueryVo queryVo);
}
