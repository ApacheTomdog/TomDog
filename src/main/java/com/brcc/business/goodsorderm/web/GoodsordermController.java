package com.brcc.business.goodsorderm.web;

import java.util.List;

import com.brcc.business.goodsorderaddweightdetail.entity.GoodsorderaddweightdetailEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;
import com.brcc.business.goodsorderm.vo.GoodsownerfdconfigVo;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.esteel.common.controller.WebReturnMessage;


/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午8:48:52
* @Description 货源单查询
*/
@RestController
@RequestMapping("/business/goodsorderm")
public class GoodsordermController {
	 Logger logger = LoggerFactory.getLogger(GoodsordermController.class);

	    @Autowired
	    GoodsordermService goodsordermService;
	      
	    /**
	     * 平台分页列表数据
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/listForPlat")
	    public Page<GoodsordermVo> listForPlat(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
	    	Page<GoodsordermVo> page = goodsordermService.listForPlat(vo);
	        return page;
	    }
	    
	    /**
	     * 货主分页列表数据
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/listForPublisher")
	    public Page<GoodsordermVo> listForPublisher(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
	    	Page<GoodsordermVo> page = goodsordermService.listForPublisher(vo);
	        return page;
	    }
	    
	    /**
	     * 货主分页列表数据
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/querySavePublish")
	    public Page<GoodsordermVo> querySavePublish(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("querySavePublish GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
	    	Page<GoodsordermVo> page = goodsordermService.querySavePublish(vo);
	        return page;
	    }
	    
	    
	    /**
	     * 导出对应的数据
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/excel")
	    public List<GoodsordermVo> queryList(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
	    	List<GoodsordermVo> list = goodsordermService.queryList(vo);
	        return list;
	    }
	        
	    /**
	     * @Desc 查询货源单详情
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/goodsordermDetail")
	    public GoodsordermVo goodsordermDetail(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm details list,by publishId:{},orderTaxDetail:{},type:{}",vo.getPublishId(),vo.getOrderTaxDetail(),vo.getType());
	    	vo.setPublishIdD(vo.getPublishId());
	    	GoodsordermVo goodsordermVo =goodsordermService.goodsordermDetail(vo);
	    	return goodsordermVo;
	    }
	    
		/**
	     * @Desc 货源单下调度单明细数据
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/listDeliveryDetails")
	    public List<TransportationDeliveryVo> listDeliveryDetails(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm delivery details list,by publishId:{}",vo.getPublishId());
	    	Assert.notNull(vo.getPublishId(),"货源单号不存在！"); 	
	        List<TransportationDeliveryVo> listDeliveryDetails = goodsordermService.listDeliveryDetails(vo);
	        return listDeliveryDetails;
	    }
	    
	    /**
	     * @Desc 货源单下物流跟踪(运输单)明细数据
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/listTransportationDetails")
	    public List<TransportationmEntity> listTransportationDetails(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm ransportation details list,by publishId:{}",vo.getPublishId());
	    	Assert.notNull(vo.getPublishId(),"货源单号不存在！");
	        List<TransportationmEntity> listTransportationDetails = goodsordermService.listTransportationDetails(vo);
	        return listTransportationDetails;
	    }
	    
	    /**
	     * @Desc 运输单单下调度单明细数据
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/deliveryDetail")
	    public List<TransportationDeliveryEntity> deliveryDetail(@RequestBody TransportBillQueryVo vo){
	    	logger.info("Query goodsorderm ransportation details list,by transId:{}",vo.getTransId());
	    	Assert.notNull(vo.getTransId(),"运输单号不存在！");	    	
	    	 List<TransportationDeliveryEntity> deliveryDetail = goodsordermService.deliveryDetail(vo);
	    	 return deliveryDetail;
	    }
	    
	    /**
		 * 
		 * @Description: 对货源单做撤销操作
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/revoke")
		public WebReturnMessage revoke(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("revoke goodsordrm ,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.revoke(vo);				
				return new WebReturnMessage(true,"操作成功!");
				
			} catch (Exception e) {
				logger.error("revoke goodsorderm  error,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		
		/**
		 * 
		 * @Description: 对货源单做作废剩余量
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/revokeOther")
		public WebReturnMessage revokeOther(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("revoke other goodsordrm weight,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.revokeOther(vo);
				// TODO 缺少对redis的操作
				return new WebReturnMessage(true,"操作成功!");
				
			} catch (Exception e) {
				logger.error("revoke other goodsorderm error,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		
		/**
		 * 
		 * @Description: 对货源单做终止操作
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/stopPublish")
		public WebReturnMessage stopPublish(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("stop goodsordrm ,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.stopPublish(vo);
				// TODO 缺少对redis的操作
				return new WebReturnMessage(true,"操作成功!");
				
			} catch (Exception e) {
				logger.error("add pool error,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		 /**
	     * 委托承运货源单分页列表数据
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/listTaxGoodOrderBill")
	    public Page<GoodsordermVo> listTaxGoodBill(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query vat GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
	    	Page<GoodsordermVo> page = goodsordermService.listTaxGoodBill(vo);
	        return page;
	    }
	    
	    /**
		 * 调价
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/changePrice")
		public WebReturnMessage changePrice (@RequestBody GoodsordermQueryVo vo) {
			try {
				logger.info("adjust GoodsOrderm's price new price is:{}",vo.getNewPrice());
				goodsordermService.changePrice(vo);
				return new WebReturnMessage(true, "调价成功!");
			} catch (Exception e) {
				e.printStackTrace();
				return new WebReturnMessage(true, e.getMessage());
			}
		}
	/***
	 * 手动增发
	 */
	@ResponseBody
	@RequestMapping("/saveIncresment")
	public WebReturnMessage saveIncresment (@RequestBody GoodsorderaddweightdetailEntity vo) {
		System.out.println(vo.getPublishId());
		try {
//			logger.info("adjust GoodsOrderm's price new price is:{}",vo.getNewPrice());
			goodsordermService.saveIncresment(vo);
			goodsordermService.updateAddWeight(vo);
			return new WebReturnMessage(true, "增发成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(true, e.getMessage());
		}
	}
	/**
		 * 挂牌价修改
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/changeGpPrice")
		public WebReturnMessage changeGpPrice (@RequestBody GoodsordermQueryVo vo) {
			try {
				logger.info("adjust GoodsOrderm's listing_price new price is:{}",vo.getNewPrice());
				goodsordermService.changeGpPrice(vo);
				return new WebReturnMessage(true, "挂牌价修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				return new WebReturnMessage(true, e.getMessage());
			}
	
		}
		
		/**
		 * 
		 * @Description:作废货主货源发布中的货源单剧
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/deletePublish")
		public WebReturnMessage deletePublish(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("revoke goodsordrm ,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.deletePublish(vo);
				return new WebReturnMessage(true,"当前单据作废成功!");
				
			} catch (Exception e) {
				logger.error("deletePublish,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		
		/**
		 * 
		 * @Description:复制货主货源发布中的货源单剧
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/copyPublish")
		public WebReturnMessage copyPublish(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("copy goodsordrm ,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.copyPublish(vo);
				return new WebReturnMessage(true,"当前货源单复制成功!");
				
			} catch (Exception e) {
				logger.error("copy publish,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		
		/**
		 * 
		 * @Description:发布货主货源发布中的货源单剧
		 * @param vo
		 * @return WebReturnMessage
		 */
		@ResponseBody
		@RequestMapping(value = "/effectPublish")
		public WebReturnMessage effectPublish(@RequestBody GoodsordermQueryVo vo) {
			Assert.notNull(vo.getPublishId(), "未获取到单据号");
	    	logger.info("effect goodsordrm ,publishId:{}",vo.getPublishId());
			try {
				Assert.notNull(vo, "参数不能为空");
				goodsordermService.effectPublish(vo);
				return new WebReturnMessage(true,"发布成功!");
				
			} catch (Exception e) {
				logger.error("copy publish,message:{}", e.getMessage());
				return new WebReturnMessage(false, e.getMessage());
			}
		}
		 /**
	     * @Desc 查询货源单价格信息
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/queryGoodPrice")
	    public GoodsordermVo queryGoodPrice(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm goods price details,by publishId:{}",vo.getPublishId());
	    	GoodsordermVo goodsordermVo = goodsordermService.queryGoodPrice(vo);
	    	return goodsordermVo;
	    }
	    
	    /**
		 * 货源单货物单价修改
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/updateGoodPrice")
		public WebReturnMessage updateGoodPrice (@RequestBody GoodsordermQueryVo vo) {
			try {
				logger.info("adjust GoodsOrderm goods price new price is:{}",vo.getNewPrice());
				goodsordermService.updateGoodPrice(vo);
				return new WebReturnMessage(true, "修改成功!");
			} catch (Exception e) {
				e.printStackTrace();
				return new WebReturnMessage(true, e.getMessage());
			}	
		}
		
		/**
	     * @Desc: 源单报价列表数据
	     * @return
	     */
		@ResponseBody
		@RequestMapping("/getBaoJiaList")
		public List<GoodsorderquotationVo> getBaoJiaList(@RequestBody GoodsordermQueryVo vo) {
			logger.info("query GoodsorderquotationVo list,publishId is:{}",vo.getPublishId());
			return goodsordermService.getBaoJiaList(vo);
		}
		
		 /**
	     * @Desc: 抢单列表分页数据
	     * @return page
	     */
	    @ResponseBody
	    @RequestMapping(value = "/queryGrabList")
	    public Page<GoodsordermVo> queryGrabList(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query vat goodsorderm pagination page");
	        return goodsordermService.queryGrabList(vo);
	    }
	    
	    /**
	     * @Desc: 源单报价列表数据
	     * @return
	     */
		@ResponseBody
		@RequestMapping("/queryEffectFlow")
		public List<VatflowdetailEntity> queryEffectFlow(@RequestBody VatflowmasterQueryVo vo) {
			logger.info("query queryEffectFlow list,vatcompanyId is:{}",vo.getVatCompanyId());
			return goodsordermService.queryEffectFlow(vo);
		}
		
		/**
	     * @return 
		 * @Desc: 查询对应货主的装车增加时间
	     * @return
	     */
		@ResponseBody
		@RequestMapping("/queryGoodsownerfdconfigVo")
		public GoodsownerfdconfigVo  queryGoodsownerfdconfigVo(@RequestBody GoodsordermQueryVo vo) {
			logger.info(" queryGoodsownerfdconfigVo list,companyId ,platformId is:{}",vo.getCompanyId(),vo.getPlatformId());
			return goodsordermService.queryGoodsownerfdconfigVo(vo);
		}
		
		/**
	     * 保存常用信息(目的地址)
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping("/saveAddress")
	    public WebReturnMessage saveAddress(@RequestBody GoodsordermVo vo){
	    	try {
	    		Assert.notNull(vo.getAddress(), "未获取到地址信息！");
	    		logger.info("Save the frequently used addresses,which is address:{}",vo.getAddress());
	    		goodsordermService.saveAddress(vo);
				return new WebReturnMessage(true,"保存成功"); 
			} catch (Exception e) {
				logger.error("Save the frequently used addresses error,message:{}",e.getMessage());
				return new WebReturnMessage(false,e.getMessage());
			}
	    }
	    
	    /**
	     * 保存新的货源单
	     * @param vo 查询封装的接收类
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping("/addNewGoodsorderm")
	    public WebReturnMessage addNewGoodsorderm(@RequestBody GoodsordermVo vo){
	    	try {
	    		logger.info("add new goodsorderm,by vo:{}",vo.toString());
	    		Assert.notNull(vo,"货源单发布信息不能为空");
	    		for(int orderCount =0;orderCount < vo.getOrderCount(); orderCount++ ) {
	    			//发布新的主单
	    			goodsordermService.addNewGoodsorderm(vo);
	    			//保存新的主单
	    			goodsordermService.addNewPtGoodsorderm(vo);
	    		}
	    		return new WebReturnMessage(true,vo.getReturnMsg()); 
	    	}catch(Exception e) {
	    		logger.error("add new goodsorderm error,message:{}",e.getMessage());
				return new WebReturnMessage(false,e.getMessage());
	    	}
	    }
	    	

		/** 
		 * 校验:经纪人才可以抢委托承运单
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/checkGrabPer")
		public WebReturnMessage checkGrabPer(@RequestBody GoodsordermQueryVo vo) {
			try {
				logger.info("check if can grab the order");
				return goodsordermService.checkGrabPer(vo);
			} catch (Exception e) {
				e.printStackTrace();
				return new WebReturnMessage(false,e.getMessage());
			}
			
		}	
	    
		/**
		 * 抢单确认
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/grabBill")
		public WebReturnMessage grabBill(@RequestBody GoodsordermVo vo) {
			try {
				Assert.notNull(vo,"数据异常：请刷新页面重新抢单!");
				return goodsordermService.grabBill(vo);
			} catch (Exception e) {
				e.printStackTrace();
				if ("1".equals(vo.getQbType())) {
					String msg =  e.getMessage();
					if (msg.length() > 100) {
						msg = "报价异常！";
					} 
					vo.setRemark(msg);
					if(null != vo.getQuotationId()){
						goodsordermService.setGoodsOrderQuotationRemark(vo);
					}
				}
				return new WebReturnMessage(false,e.getMessage());
			}
		}
		
		/**
	     * @Desc 查询货源单详情
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/getGoodsordermDetail")
	    public GoodsordermVo getGoodsordermDetail(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm details list,by publishId:{}",vo.getPublishId());
	    	GoodsordermVo goodsordermVo =goodsordermService.getGoodsordermDetail(vo);
	    	return goodsordermVo;
	    }
	    /**
	     * @Desc 修改货源单详情
	     * @param vo 
	     * @return
	     */
	    @ResponseBody
	    @RequestMapping(value = "/updateGoodsorderm")
	    public WebReturnMessage updateGoodsorderm(@RequestBody GoodsordermVo vo){
	    	try {
	    		Assert.notNull(vo.getPublishId(),"数据异常：请刷新页面!");
	    		logger.info("update goodsorderm,by publishId",vo.getPublishId());
	    		goodsordermService.updateGoodsorderm(vo);
	    		return new WebReturnMessage(true, "修改成功!");
	    } catch(Exception e) {
	    		e.printStackTrace();
	    		return new WebReturnMessage(false,e.getMessage());
	    	}
	    }
	    
	    /**
	     * 货主货源发布含税价格计算
	     * @param vo
	     * @return GoodsordermjkVo
	     */
	    @ResponseBody
	    @RequestMapping("/getPriceTax")
	    public GoodsordermVo getPriceTax(@RequestBody GoodsordermVo vo){
	    	logger.error("calculate the price tax,companyId:{}",vo.getCompanyId());
	    	goodsordermService.getPriceTax(vo);
			return vo;
	    }
	    
	    /**
	     * @Desc 委托承运流程查询 
	     * @param vo
	     */
	    @ResponseBody
		@RequestMapping("/queryTaxRate")
		public List<VatflowdetailVo> queryTaxRate(@RequestBody VatflowmasterQueryVo vo) {
			logger.info("query flow list,vatcompanyId is:{}",vo.getVatCompanyId());
			return goodsordermService.queryTaxRate(vo);
		}
	    
	    /**委托人选择报价生成运输订单*/
		@ResponseBody
		@RequestMapping("/createTransBill")
		public WebReturnMessage createTransBill(@RequestBody GoodsorderquotationQueryVo vo) {
			try {
				goodsordermService.createTransBill(vo);
				return new WebReturnMessage(true,"恭喜你，运单已生成！");
			} catch (Exception e) {
				e.printStackTrace();
				return new WebReturnMessage(false,e.getMessage());
			}
		}
		
		/**
	     * 货源单货物单价调整列表数据
	     * @param vo 
	     * @return Page
	     */
	    @ResponseBody
	    @RequestMapping(value = "/getGoodPriceLogPageList")
	    public Page<GoodpricechangelogEntity> getGoodPriceLogPageList(@RequestBody GoodsordermQueryVo vo){
	    	logger.info("Query goodsorderm goods’s price page data,publishId:{}",vo.getPublishId());
	    	Page<GoodpricechangelogEntity> page = goodsordermService.getGoodPriceLogPageList(vo);
	        return page;
	    }
	    
	    /**
	     * @Desc 货源单授信调价明细 
	     * @param vo
	     */
	    @ResponseBody
		@RequestMapping("/lookSxDatilList")
		public List<GoodsordermadjustdetailVo> lookSxDatilList(@RequestBody GoodsordermQueryVo vo) {
	    	logger.info("query GoodsordermadjustdetailVo list,publishId is:{}",vo.getPublishId());
			return goodsordermService.lookSxDatilList(vo);
		}
}
