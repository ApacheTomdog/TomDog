package com.brcc.business.goodsordermjk.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;
import com.brcc.business.goodsordermjk.service.GoodsordermjkService;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkQueryVo;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.esteel.common.controller.WebReturnMessage;


/**
* @author PanJianYang
* @version 创建时间：2018年11月6日 上午9:13:03
* @Description 查询外部接口货源发布详情
*/
@RestController
@RequestMapping("/business/goodsordermjk")
public class GoodsordermjkController {
	
	Logger logger = LoggerFactory.getLogger(GoodsordermjkController.class);
	
	@Autowired
	GoodsordermjkService  goodsordermjkservice;
	
	/*@Autowired
	RedisTemplate<Object,Object> redisTemplate;*/
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

    @Value("${spring.redis.host}")
    String redisHost ;

    private static String mobileZntjKey = "MOBILE_ZNTJ_TIME_REDIS";

    @RequestMapping("/test")
    public String test(){
        return redisHost;
    }


	/**
     * @Description: 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public Page<GoodsordermjkVo> list(@RequestBody GoodsordermjkQueryVo vo){
    	logger.info("Query ds GoodsOrdermjk pagination page,orderId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
    	Page<GoodsordermjkVo> page = goodsordermjkservice.list(vo);
        return page;
    }
    
    /**
     * @Description: 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cgList")
    public Page<GoodsordermjkVo> cgList(@RequestBody GoodsordermjkQueryVo vo){
    	logger.info("Query cg GoodsOrdermjk pagination page,orderId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
    	Page<GoodsordermjkVo> page = goodsordermjkservice.cgList(vo);
        return page;
    }
    
    /**
     * @Description: 分页列表数据
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pinDanList")
    public Page<GoodsordermjkVo> pinDanList(@RequestBody GoodsordermjkQueryVo vo){
    	logger.info("Query goodsordermjk pinDanList pagination page,pinDanNum:{},rqStart:{},rqEnd:{}",vo.getPinDanNum(),vo.getRqStart(),vo.getRqEnd()); 	
    	Page<GoodsordermjkVo> page = goodsordermjkservice.pinDanList(vo);
        return page;
    }
    
    /**
	 * 
	 * @Description: 对单据进行加入拼单池操作
	 * @param vo
	 * @return WebReturnMessage
	 */
	@ResponseBody
	@RequestMapping(value = "/addPool")
	public WebReturnMessage addPool(@RequestBody GoodsordermjkQueryVo vo) {
		logger.info("add goodsordrmjk pool,importIdStr:{}", vo.getImportIdStr());
		try {
			Assert.notNull(vo, "参数不能为空");
			return goodsordermjkservice.addPool(vo);
		} catch (Exception e) {
			logger.error("add pool error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}

	/**
	 * 
	 * @Description: 对单据进行加入拼单池操作
	 * @param vo
	 * @return WebReturnMessage
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteFromPool")
	public WebReturnMessage deleteFromPool(@RequestBody GoodsordermjkQueryVo vo) {
		logger.info("delete goodsordrmjk pool,importIdStr:{}", vo.getImportIdStr());
		try {
			Assert.notNull(vo, "参数不能为空");
			return goodsordermjkservice.deleteFromPool(vo);
		} catch (Exception e) {
			logger.error("add pool error,message:{}", e.getMessage());
			return new WebReturnMessage(false, e.getMessage());
		}
	}
	
	 /**
	 * 
	 * @Description: 对拼单池单据做拼单操作
	 * @param vo
	 * @return WebReturnMessage
	 */
	@ResponseBody
	@RequestMapping(value = "/doPinDan")
	public WebReturnMessage doPinDan(@RequestBody GoodsordermjkQueryVo vo) {
		logger.info("ds goodsordrmjk doPinDan,importIdStr:{}",vo.getImportIdStr());
		try {
			Assert.notNull(vo, "参数不能为空");
			goodsordermjkservice.doPinDan(vo);
			return new WebReturnMessage(true,"拼单成功!");
		} catch (Exception e) {
			logger.error("do pin dan error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
	}
		
	/**
     * 保存常用信息(目的地址)
     * @param vo 查询封装的接收类
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveAddress")
    public WebReturnMessage saveAddress(@RequestBody GoodsordermjkVo vo){
    	try {
    		Assert.notNull(vo.getEndPlate(), "未获取到目的地信息！");
    		logger.info("Save the frequently used addresses,which is endPlate:{}",vo.getEndPlate());
			goodsordermjkservice.saveAddress(vo);
			return new WebReturnMessage(true,"保存成功"); 
		} catch (Exception e) {
			logger.error("Save the frequently used addresses error,message:{}",e.getMessage());
			return new WebReturnMessage(false,e.getMessage());
		}
    }	
    
    /**
     * 查询单据信息
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/queryGoodOrderMJK")
    public GoodsordermjkVo queryGoodOrderMJK(@RequestBody GoodsordermjkQueryVo vo){
		logger.info("query the queryGoodOrderMJK information,by importId",vo.getImportId());
		return goodsordermjkservice.queryGoodOrderMJK(vo);  	
    }
    
    /**
     * 保存所有相同拼单号的货源信息
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/savePinDanInfo")
    public WebReturnMessage savePinDanInfo(@RequestBody GoodsordermjkVo vo){
    	try {
			logger.info("save queryGoodOrderMJK information has the same pinDanNum",vo.getPinDanNum());
			return goodsordermjkservice.savePinDanInfo(vo); 
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new WebReturnMessage(true,e.getMessage());
    	}	
    }	
    
    /**
     * 保存货源单据信息(单条)
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/saveCompleteInfo")
    public WebReturnMessage saveCompleteInfo(@RequestBody GoodsordermjkVo vo){
    	try {
			logger.info("save the queryGoodOrderMJK information,by importId",vo.getImportId());
			return goodsordermjkservice.saveCompleteInfo(vo);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new WebReturnMessage(true,e.getMessage());
    	}	
    }
    
    /**
     * 保存货源单据信息(批量完善)
     * @param vo 查询封装的接收类
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/saveCompleteInfoByBatch")
    public WebReturnMessage saveCompleteInfoByBatch(@RequestBody GoodsordermjkVo vo){
    	try {
    		logger.info("save the queryGoodOrderMJK information by batch,where imprtIdStr:{}",vo.getImportIdStr());
    		goodsordermjkservice.saveCompleteInfoByBatch(vo);
    		return  new WebReturnMessage(true,"保存成功!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		return new WebReturnMessage(true,e.getMessage());
    	}	
    }
        
    /**
     * 外部接口货源发布
     * @param vo
     * @return WebReturnMessage
     */
    @ResponseBody
    @RequestMapping("/publishOrder")
    public WebReturnMessage publishOrder(@RequestBody GoodsordermjkVo vo){
    	try {
			logger.info("publish  the  Goodsordermjk,by importId",vo.getImportId());

		    // 校验是否重复发布
			GoodsordermjkEntity isActive = goodsordermjkservice.queryActive(vo);
			Assert.notNull(isActive,"1".equals(vo.getSpiltType()) ? "所有量都已经发布了，不能再发布了！" : "只有待审核状态才能发布！");
			goodsordermjkservice.updateGoodsOrdermjkLngLat(vo);	
			
			goodsordermjkservice.agree(vo);
			//TODO 定抢资源发布后，清除redis缓存
			if("1".equals(vo.getDqFlag())) {
	    		// TODO 缺少对redis的操作
	    		//redisTemplate.delete(mobileZntjKey);
				stringRedisTemplate.delete(mobileZntjKey);
	    	}
			// 推送消息的类型
			vo.setMessageType("DSFB");
			//TODO 消息推送(已经不用)
			//goodsordermjkservice.orderPush(vo);
			return new WebReturnMessage(true,"发布成功!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.error("Save the frequently used addresses error,message:{}",e.getMessage());
    		return new WebReturnMessage(true,e.getMessage());
	   }
    }
    
    /**
     * 外部接口电商货源含税价格计算
     * @param vo
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/getPriceTax")
    public GoodsordermjkVo getPriceTax(@RequestBody GoodsordermjkVo vo){
    	logger.error("calculate the price tax,companyId:{}",vo.getCompanyId());
    	goodsordermjkservice.getPriceTax(vo);
		return vo;
    }
    
    /**
     * 外部接口电商货源拼单发布
     * @param vo
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/publishPinDan")
    public WebReturnMessage publishPinDan(@RequestBody GoodsordermjkVo vo){
    	try {
	    	logger.error("publish the pindan order,importIdStr:{}",vo.getImportIdStr());
	    	goodsordermjkservice.publishPinDan(vo);
	    	// 推送消息的类型
			vo.setMessageType("DSFB");
			// TODO 消息推送
			//goodsordermjkservice.orderPush(vo);
			return new WebReturnMessage(true,"发布成功!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.error("Save the frequently used addresses error,message:{}",e.getMessage());
    		return new WebReturnMessage(true,e.getMessage());
	   }	
    }
    
    /**
     * 外部接口大宗货源信息完善
     * @param vo
     * @return GoodsordermjkVo
     */
    @ResponseBody
    @RequestMapping("/savePurchaseInfo")
    public WebReturnMessage savePurchaseInfo(@RequestBody GoodsordermjkVo vo){
    	try {
    		logger.error("save the purchase order(DaZong),importIdStr:{}",vo.getImportIdStr());
    		// 校验采购单据是否都是委托承运或者非委托承运
			checkIfTaxTransport(vo);
			vo.setCgSaveRemark("by" + vo.getUserName() + vo.getUserId() + "完善采购信息at" + new Date());
			goodsordermjkservice.updateGoodsOrdermjkLngLat(vo);
    		return new WebReturnMessage(true,"保存成功!");
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.error("Save the frequently used addresses error,message:{}",e.getMessage());
    		return new WebReturnMessage(false,e.getMessage());
    	}	
    }
    
    /**
	 * 校验采购单据是否都是委托承运或者非委托承运
	 * @param param
	 */
	private void checkIfTaxTransport(@RequestBody GoodsordermjkVo param) {		
		GoodsordermEntity entity = goodsordermjkservice.checkIfTaxTransport(param);
		if (entity != null && !(entity.getIfTaxTransport().equals(param.getIfTaxTransport())) && param.getIfTaxTransport() != null && !"".equals(param.getIfTaxTransport())) {
			switch(entity.getIfTaxTransport()) {
				case "Y" : Assert.isTrue(false,"该采购单据已发布过委托承运货源，不能再发布非委托承运货源！"); 
				case "N" : Assert.isTrue(false,"该采购单据已发布过非委托承运货源，不能再发布委托承运货源！"); 
			}
		}
	}
    
	/**
	 * 查询大品种信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCatalogId") 
	public CatalogInfoVo getCatalogId(@RequestBody GoodsordermjkQueryVo vo) {
		logger.info("query catalog info ,by goodType:{}",vo.getGoodType());	
		CatalogInfoVo catalogInfoVo =  goodsordermjkservice.getCatalogId(vo);	
		return catalogInfoVo;
	}
	
	/**
	 * 电商  -- 批量发布
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/publishByBatch")
	public WebReturnMessage publishByBatch(@RequestBody GoodsordermjkVo vo) {
		try {
			logger.info("publish order(DianShang) by batch");	
			goodsordermjkservice.publishByBatch(vo);
			return new WebReturnMessage(true,"发布成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(true,e.getMessage());
		}		
	}
	
	/**
	 * 采购  -- 批量发布
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/publishForU8ByBatch")
	public WebReturnMessage publishForU8ByBatch(@RequestBody GoodsordermjkVo vo) {
		try {
			logger.info("publish purchase order by batch");	
			goodsordermjkservice.publishForU8ByBatch(vo);
			return new WebReturnMessage(true,"发布成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(false,e.getMessage());
		}		
		
	}
	
	/**
     * @Desc: 单据的开启、关闭
     * @param vo
     */
	@ResponseBody
	@RequestMapping("/updateOnOff")
	public WebReturnMessage updateOnOff(@RequestBody GoodsordermjkVo vo) {
		try {
			logger.info("update order's field named if_on_off, by importId:{}", vo.getImportId());	
			goodsordermjkservice.updateOnOff(vo);
			return new WebReturnMessage(true,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(true,e.getMessage());
		}		
	}

	/**
	 * 保存合同号
	 * @param vo
	 */
	@ResponseBody
	@RequestMapping("/saveContractNumber")
	public WebReturnMessage saveContractNumber(@RequestBody GoodsordermjkVo vo) {
		try {
			goodsordermjkservice.saveContractNumber(vo);
			return new WebReturnMessage(true,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new WebReturnMessage(true,e.getMessage());
		}
	}




}
