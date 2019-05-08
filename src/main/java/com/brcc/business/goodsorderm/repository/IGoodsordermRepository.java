package com.brcc.business.goodsorderm.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;


/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午9:02:44
* @ClassName 类名称
* @Description 货源单的相关拓展接口
*/
public interface IGoodsordermRepository {
	 /**
     * 分页查询平台货源单数据
     * @param vo
     * @return
     */
    Page<GoodsordermVo> findAllPage(GoodsordermQueryVo vo);
    
    Page<GoodsordermVo> getGoodOrderBillPage(GoodsordermQueryVo vo);
    
    /**校验采购单据是否都是委托承运或者非委托承运*/
    GoodsordermEntity queryEntity(GoodsordermQueryVo queryVo);
    /**查询当天所有地址信息相同的货源单**/
    Long queryAllSameGoodsorderm(GoodsordermVo Vo);
    /**查询所有发单池里面相同信息的货源单**/
    Long queryAllSameAddressNewGoodsorderm(GoodsordermVo Vo);
    /**查询货源单价格、亏吨等信息*/
    GoodsordermVo queryGoodPrice(GoodsordermQueryVo vo);
    
    /**抢单列表分页数据*/
    Page<GoodsordermVo> queryGrabList(GoodsordermQueryVo vo);
    
    /**校验:经纪人才可以抢委托承运单*/
    GoodsordermVo queryTaxTransportInfo(GoodsordermQueryVo vo);
  
    /**查询可抢单量*/
	GoodsordermVo queryIsHas(Long publishId);
	
	/** 查询捆绑货源(如拼单货源) */
	List<GoodsordermVo> queryHasChildGood(Long publishId);
	/** 打开货源单修改明细页面 */
	GoodsordermVo getGoodsordermDetail(Long publishId,String platformId);

}
