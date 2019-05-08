package com.brcc.business.goodsorderm.service.impl;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.brcc.business.goodsorderaddweightdetail.entity.GoodsorderaddweightdetailEntity;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkLogEntity;
import com.brcc.business.goodsordermjk.service.GoodsordermjkLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.brcc.business.basedata.service.CatalogService;
import com.brcc.business.basedata.vo.CatalogInfoVo;
import com.brcc.business.basedata.vo.CatalogQueryVo;
import com.brcc.business.capital.entity.CapitalBalanceEntity;
import com.brcc.business.capital.entity.CapitalFlowingEntity;
import com.brcc.business.capital.service.CapitalBalanceService;
import com.brcc.business.capital.service.CapitalFlowingService;
import com.brcc.business.commonaddress.entity.CommonaddressEntity;
import com.brcc.business.commonaddress.service.Commonaddresservice;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.company.vo.CompanySearchVo;
import com.brcc.business.company.vo.CompanyVo;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceDetailEntity;
import com.brcc.business.creditAdjustPrice.entity.CreditAdjustPriceMasterEntity;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceDetailService;
import com.brcc.business.creditAdjustPrice.service.CreditAdjustPriceMasterService;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceDetailVo;
import com.brcc.business.creditAdjustPrice.vo.CreditAdjustPriceQuerySearchVo;
import com.brcc.business.creditAmountAdjust.vo.CreditAdjustPriceDetailQueryVo;
import com.brcc.business.creditConfig.service.CreditConfigService;
import com.brcc.business.creditConfig.vo.CreditConfigQueryVo;
import com.brcc.business.creditConfig.vo.CreditConfigVo;
import com.brcc.business.dispatchorder.entity.GoodsorderexecutelogEntity;
import com.brcc.business.dispatchorder.entity.TransportationdeliveryuploadEntity;
import com.brcc.business.dispatchorder.service.GoodsOrderExecuteLogService;
import com.brcc.business.dispatchorder.service.TransportationDeliveryUploadService;
import com.brcc.business.flow.entity.VatflowdetailEntity;
import com.brcc.business.flow.service.VatflowdetailService;
import com.brcc.business.flow.vo.VatflowdetailVo;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.goodsorderm.entity.GoodpricechangelogEntity;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.entity.GoodsorderquotationEntity;
import com.brcc.business.goodsorderm.repository.GoodsordermRepository;
import com.brcc.business.goodsorderm.service.GoodpricechangelogService;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsorderm.service.GoodsorderquotationService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsorderm.vo.GoodsordermadjustdetailVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsorderquotationVo;
import com.brcc.business.goodsorderm.vo.GoodsownerfdconfigVo;
import com.brcc.business.goodsordermadjust.entity.GoodsordermadjustdetailEntity;
import com.brcc.business.goodsordermadjust.service.GoodsordermadjustDetailService;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;
import com.brcc.business.goodsordermjk.service.GoodsordermjkService;
import com.brcc.business.goodsordermjk.vo.GoodsordermjkVo;
import com.brcc.business.transorder.entity.ShortmessageEntity;
import com.brcc.business.transorder.service.ShortmessageService;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportation.service.TransportationmService;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.brcc.business.util.StringFactory;
import com.esteel.common.controller.WebReturnMessage;

/**
* @author PanJianYang
* @version 创建时间：2018年10月30日 下午9:51:22
* @ClassName 类名称
* @Description 类描述
*/
@Service
public class GoodsordermServiceImpl implements GoodsordermService {
	Logger logger = LoggerFactory.getLogger(GoodsordermServiceImpl.class);
	 
	@Autowired
	GoodsordermRepository goodsordermRepository;
	
	@Autowired
	TransportationDeliveryService transportationDeliveryService;
	
	@Autowired
	TransportationmService transportationmService;
	
	@Autowired
	GoodsordermjkService goodsordermjkService;

	@Autowired
	GoodsordermjkLogService goodsordermjkLogService;
	
	@Autowired
    VatflowdetailService vatflowdetailService;
	
	@Autowired
	CreditConfigService creditConfigService;
	
	@Autowired
	CreditAdjustPriceMasterService creditAdjustPriceMasterService;
	
	@Autowired
	CreditAdjustPriceDetailService creditAdjustPriceDetailService;
	
	@Autowired
	GoodsordermadjustDetailService goodsordermadjustDetailService;
	
	@Autowired
    MybatisQuery mybatisQuery;
	
	@Autowired
	GoodpricechangelogService goodpricechangelogService;
	
	@Autowired
	GoodsorderquotationService goodsorderquotationService;
	
	@Autowired
    Commonaddresservice commonaddresservice;
	
	@Autowired
	CatalogService catalogService;
	
	@Autowired
	GoodsOrderExecuteLogService  goodsOrderExecuteLogService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ShortmessageService shortMessageService;
	
	@Autowired
	CapitalFlowingService capitalFlowingService;
	
	@Autowired
	CapitalBalanceService capitalBalanceService;
	
	@Autowired
	TransportationDeliveryUploadService transportationdeliveryuploadService;
	
	/*@Autowired
    RedisTemplate<String,Object> redisTemplate;*/
	
	@Autowired
	StringRedisTemplate redisTemplate;
   	   
	private static String mobileZntjKey = "MOBILE_ZNTJ_TIME_REDIS";
	
	
	@Override
	public Page<GoodsordermVo> listForPlat(GoodsordermQueryVo vo) {
		
		Page<GoodsordermVo> page = mybatisQuery.readPage("goodsorderm.list", vo);
        return page;
	
	}
	
	@Override
	public Page<GoodsordermVo> listForPublisher(GoodsordermQueryVo vo) {
		
		Page<GoodsordermVo> page = mybatisQuery.readPage("goodsorderm.list", vo);
        return page;
	
	}
	
	@Override
	public Page<GoodsordermVo> querySavePublish(GoodsordermQueryVo vo) {
	//	Long count = mybatisQuery.selectOne("goodsorderm.querySavePublishCount",vo);
		Page<GoodsordermVo> page = mybatisQuery.readPage("goodsorderm.querySavePublish", vo);

        return page;
	
	}
	
	@Override
	public List<GoodsordermVo> queryList(GoodsordermQueryVo vo) {
		logger.info("query the Goodsorderm list to export,by excelType:{}",vo.getExcelType());
		List<GoodsordermVo> list = new ArrayList<>();
		if("ltx".equals(vo.getExcelType())) {
			// 委托承运货源单
			list = mybatisQuery.readList("goodsorderm.listTaxGoodBill", vo);
		}else if("oil".equals(vo.getExcelType())) {
			//TODO
			//list = mybatisQuery.list("goodsorderm.queryGoodsOrderOliList", vo);
		}else {
			// 平台货源单
			logger.info("===========限制导出条数" + vo.getFromRow().toString());
			logger.info("===========限制导出条数" + vo.getToRow().toString());
			list = mybatisQuery.readList("goodsorderm.list", vo);			
		}
        return list;
	
	}
	
	@Override
	public GoodsordermVo goodsordermDetail(GoodsordermQueryVo vo) {
		List<GoodsordermVo> goodsordermVoList = new ArrayList<GoodsordermVo>();
		vo.setPublishIdD(vo.getPublishId());
		if(!"".equals(vo.getOrderTaxDetail())) {
		//	vo.setCompanyId("");
			goodsordermVoList= mybatisQuery.list("goodsorderm.listTaxGoodBill", vo);
		}
		else {
			goodsordermVoList= mybatisQuery.list("goodsorderm.list", vo);
		}
		if(goodsordermVoList.size() > 1) {
			throw new RuntimeException("获取货源单详情失败！！！！！");
		}
		GoodsordermVo goodsordermVo = goodsordermVoList.get(0);
		goodsordermVo.setOrderTaxDetail(vo.getOrderTaxDetail());
		String vehicleStyleStr ="";
		String vehicleStyleVar = (String) goodsordermVo.getVehicleStyleVar();
		if(vehicleStyleVar != null && !"".equals(vehicleStyleVar)) {
			try{
				String[] vehicle_style = vehicleStyleVar.split(",");
		   		 for(int i=0;i<vehicle_style.length;i++){
		    		vehicleStyleStr += vehicle_style[i].substring(2, vehicle_style[i].length()) + ",";
		    	}
		    	vehicleStyleStr = vehicleStyleStr.substring(0,vehicleStyleStr.length() - 1);
		    	goodsordermVo.setVehicleStyleVar(vehicleStyleStr);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return goodsordermVo;
	
	}

	@Override
	public GoodsordermEntity findById(Long publishId) {
		Optional<GoodsordermEntity> op = goodsordermRepository.findById(publishId);
		GoodsordermEntity entity = op.get();
		return entity;
	}

	@Override
	public Page<GoodsordermVo> listData(GoodsordermQueryVo vo) {

		Page<GoodsordermVo> page = goodsordermRepository.findAllPage(vo);
		return page;
	}

	@Override
	public void save(GoodsordermVo vo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteById(Long publishId) {
		logger.info("delete goodsorderm,by publishId:{}",publishId);
		goodsordermRepository.deleteById(publishId);
	}

	@Override
	public List<TransportationDeliveryVo> listDeliveryDetails(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm delivery details list,by publishId:{}",vo.getPublishId());
		return transportationDeliveryService.listDeliveryDetails(vo);
	}

	
	@Override
	public List<TransportationmEntity> listTransportationDetails(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm ransportation details list,by publishId:{}",vo.getPublishId());
		return transportationmService.listTransportationDetails(vo);
	}

	@Override
	public List<TransportationDeliveryEntity> deliveryDetail(TransportBillQueryVo vo) {
		logger.info("Query goodsorderm ransportation details list,by publishId:{}",vo.getPublishId());
		return transportationDeliveryService.queryDeliveryDetail(vo);
	}

	@Override
	public Long verifyPublishId(Long companyId, Long userId, String platformId, Long publishId) {
		return goodsordermRepository.verifyPublishId(companyId,userId,platformId,publishId);
	}

	@Override
	public String checkStatus(String platformId, Long publishId) {
		return goodsordermRepository.checkStatus(platformId,publishId);
	}
	
	@Override
	@Transactional
	public void revoke(GoodsordermQueryVo vo) {
		Assert.notNull(vo.getPublishId(), "未获取到单据号");
    	logger.info("revoke goodsordrm ,publishId:{}",vo.getPublishId());
    	GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
    	Assert.isTrue(!"00".equals(goodsordermEntity.getStatus()),"单据已作废，不能进行操作！");
    	Integer checkTransWeightNum = goodsordermRepository.checkTransWeight(vo.getPlatformId(),vo.getPublishId());
    	Assert.isTrue(checkTransWeightNum ==0 || checkTransWeightNum ==null,"已生成运单,不能撤单,请先撤销运单数据，再操作！");
    	Integer revokeGoodsNum = goodsordermRepository.revokeGoodsorderm(vo.getPlatformId(), vo.getPublishId(), vo.getUserId());
    	Assert.isTrue(revokeGoodsNum==1,"单据状态已发生改变，无法完成撤销操作！");
    	if("DS".equals(vo.getFromType())) {
    		Integer revokeGoodsmjkNum =goodsordermjkService.revokeGoodsordermjk(vo.getPublishId());
    		Assert.isTrue(revokeGoodsmjkNum==1,"外部接口单据状态已发生改变，无法完成撤销操作！");
    	}
    	//如果是u8过来的单据，则撤销，回写量
    	if("JK_U8".equals(vo.getFromType()) || "JK_U9".equals(vo.getFromType()) || "JK_U10".equals(vo.getFromType())) {
    		GoodsordermjkEntity goodsordermjkEntity  = goodsordermjkService.findById(goodsordermEntity.getImportId());
    		goodsordermjkEntity.setInitSpiltWeight(goodsordermjkEntity.getInitSpiltWeight().add(goodsordermEntity.getInitWeight()));
    		goodsordermjkEntity.setStatus("10");
    		goodsordermjkService.save(goodsordermjkEntity);	
    	}

		//JK_U11，则撤销jk表的单据
		if("JK_U11".equals(vo.getFromType())) {
			invalidGoodsordermjk(goodsordermEntity.getImportId());
		}

    	if("1".equals(goodsordermEntity.getDqFlag())) {
    		// TODO 缺少对redis的操作
    		redisTemplate.delete(mobileZntjKey);
    	}
  	
	}


	private static String getTimeMillisSequence() {
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sb.append(rand);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String timeMillisSequence = sdf.format(System.currentTimeMillis()) + sb.toString();
		return timeMillisSequence;
	}
	
	
	@Override
	@Transactional
	public void revokeOther(GoodsordermQueryVo vo) {
		Assert.notNull(vo.getPublishId(), "未获取到单据号");
    	logger.info("revoke goodsordrm ,publishId:{}",vo.getPublishId());
    	GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
    	Assert.isTrue(!"00".equals(goodsordermEntity.getStatus()),"单据已作废，不能进行操作！");
    	Integer checkTransWeightNum = goodsordermRepository.checkTransWeight(vo.getPlatformId(),vo.getPublishId());
    	Assert.isTrue(checkTransWeightNum !=null && checkTransWeightNum !=0,"未生成运单，可直接进行撤销！");
    	//如果是u8过来的单据，则撤销，回写量
    	if("JK_U8".equals(vo.getFromType()) || "JK_U9".equals(vo.getFromType()) || "JK_U10".equals(vo.getFromType()) || "JK_U11".equals(vo.getFromType())) {
    		GoodsordermjkEntity  goodsordermjkEntity  = goodsordermjkService.findById(goodsordermEntity.getImportId());
    		goodsordermjkEntity.setInitSpiltWeight(goodsordermjkEntity.getInitSpiltWeight().add(goodsordermEntity.getWeight()));
    		goodsordermjkEntity.setStatus("10");
    		goodsordermjkService.save(goodsordermjkEntity);	
    	}
    	//
    	Integer revokeGoodsNum = goodsordermRepository.updateOtherWeight(vo.getPlatformId(), vo.getPublishId(), vo.getUserId());
    	Assert.isTrue(revokeGoodsNum==1,"单据状态已发生改变，无法完成作废剩余量的操作！");
    	if("1".equals(goodsordermEntity.getDqFlag())) {
    		// TODO 缺少对redis的操作
    		redisTemplate.delete(mobileZntjKey);
    	}
	}
	
	@Override
	@Transactional
	public void stopPublish(GoodsordermQueryVo vo) {
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
		//终止货源单的时候将货源单的可抢单量作废为0
    	Integer stopPublishNum = goodsordermRepository.updateStopPublish(vo.getPlatformId(), vo.getPublishId(), vo.getUserId());
    	Assert.isTrue(stopPublishNum==1,"货源单终止失败！");
    	if("1".equals(goodsordermEntity.getDqFlag())) {
    		// TODO 缺少对redis的操作
    		redisTemplate.delete(mobileZntjKey);
    	}
	}

	@SuppressWarnings("unused")
	private void checkGoodsordermStatus(Long publishId) {
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(publishId).get();
    	Assert.isTrue("00".equals(goodsordermEntity.getStatus()),"单据已作废，不能进行操作！");
	}

	@Override
	@Transactional
	public GoodsordermEntity saveGoodsordermVo(GoodsordermVo vo) {
		logger.info("save goodsordrm ,publishId:{}",vo.getPublishId());
		GoodsordermEntity entity = new GoodsordermEntity();
		BeanUtils.copyProperties(vo,entity);
		entity.setIfConfirm("0");
		return goodsordermRepository.save(entity);
	}

	@Override
	public Integer findGoodCountTax(GoodsordermjkVo vo) {
		logger.info("query goodsordrm is published or not,importId:{}",vo.getImportId());
		return goodsordermRepository.findGoodCountTax(vo.getImportId());
	}

	@Override
	public Integer findGoodCount(GoodsordermjkVo vo) {
		logger.info("query goodsordrm is published or not,importId:{}",vo.getImportId());
		return goodsordermRepository.findGoodCount(vo.getImportId());
	}

	@Override
	@Transactional
	public GoodsordermEntity save(GoodsordermEntity goodsordermEntity) {
		logger.info("save goodsordrm ,publishId:{}",goodsordermEntity.getPublishId());
		return goodsordermRepository.save(goodsordermEntity);
	}

	@Override
	public GoodsordermEntity queryEntity(GoodsordermQueryVo queryVo) {
		logger.info("query GoodsordermEntity ,importId:{}",queryVo.getImportId());
		return goodsordermRepository.queryEntity(queryVo);
	}
	
	@Override
	public Page<GoodsordermVo> listTaxGoodBill(GoodsordermQueryVo vo) {
		logger.info("Query vat GoodsOrderm pagination page,publishId:{},rqStart:{},rqEnd:{}",vo.getOrderId(),vo.getRqStart(),vo.getRqEnd());
		Page<GoodsordermVo> page = mybatisQuery.page("goodsorderm.listTaxGoodBill", vo);
        return page;
	}

	@Override
    @Transactional
	public void changePrice(GoodsordermQueryVo vo) {
		logger.info("adjust GoodsOrderm's price new price is:{}",vo.getNewPrice());
		Integer changePrice = goodsordermRepository.changePrice(vo.getUserId(),vo.getUserName(),vo.getNewPrice(),vo.getNewPrice(),vo.getPublishId(),vo.getPlatformId());
		Assert.isTrue(changePrice == 1,"单据状态已改变，请刷新页面重试!"); 
	}

	@Override
	public void saveIncresment(GoodsorderaddweightdetailEntity vo) {
		Integer saveIncresment=goodsordermRepository.saveIncresment(vo.getPublishId(),vo.getAddWeight(),vo.getCreateDate(),
				vo.getAddCarnum(),vo.getAddWeightType(),vo.getPickupDate(),vo.getTakeDeliveryDate(),vo.getCreatePersonId(),vo.getCreatePersonName(),vo.getAddQty());
	}

	@Override
	public void updateAddWeight(GoodsorderaddweightdetailEntity vo){
		Integer updateAddWeight=goodsordermRepository.updateAddWeight(vo.getPublishId(),vo.getAddWeight(),vo.getCreateDate(),vo.getCreatePersonId(),vo.getPickupDate(),vo.getTakeDeliveryDate(),vo.getAddQty());
	}

	@Override
    @Transactional
	public void changeGpPrice(GoodsordermQueryVo vo) {
		logger.info("adjust GoodsOrderm's listing_price new price is:{}",vo.getNewPrice());
		Integer changeGpPrice = goodsordermRepository.changeGpPrice(vo.getUserId(),vo.getUserName(),vo.getNewPrice(),vo.getPublishId(),vo.getPlatformId());
		Assert.isTrue(changeGpPrice == 1,"单据状态已改变，请刷新页面重试!"); 
	}

	@Override
	public GoodsordermVo queryGoodPrice(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm goods price details,by publishId:{}",vo.getPublishId());
		GoodsordermVo goodsordermVo = goodsordermRepository.queryGoodPrice(vo);
		if(null == goodsordermVo || null == goodsordermVo.getPublishId()) {
			// 单据已超时(pickupDate < now())
			return null;
		}
		// 抢单件数
		BigDecimal qty = goodsordermVo.getQty();
		BigDecimal grabQty = new BigDecimal("0");
    	if("1".equals(goodsordermVo.getDetachable())) { 
    		//可拆单 
    		BigDecimal initWeight = goodsordermVo.getInitWeight();
    		BigDecimal singleCarWeight = goodsordermVo.getSingleCarWeight();
    		BigDecimal initQty = goodsordermVo.getInitQty();	
    		BigDecimal divide = initQty.divide((initWeight.divide(singleCarWeight,10,BigDecimal.ROUND_HALF_UP)));
    		BigDecimal singleCarQty =new BigDecimal(Math.ceil(divide.doubleValue()));
    		if (singleCarQty.compareTo(qty) == 1) {
    			grabQty = qty;
    		} else {
    			grabQty = singleCarQty;
    		}
    	} else { 
    		// 不可拆单 
    		grabQty = qty;
    	}
    	goodsordermVo.setGrabQty(grabQty);
		return goodsordermVo;
	}

	@Override
	@Transactional
	public void updateGoodPrice(GoodsordermQueryVo vo) {
		logger.info("adjust GoodsOrderm goods price new price is:{}",vo.getNewPrice());
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
		goodsordermEntity.setUpdateDate(new Date());
		goodsordermEntity.setUpdatePerson(vo.getUserId());
		goodsordermEntity.setGoodPrice(vo.getNewPrice());
		goodsordermEntity.setLossType(vo.getNewLossType());
		if(vo.getNewLossRatio() != null) {
			goodsordermEntity.setLossRatio(vo.getNewLossRatio().divide(new BigDecimal("1000")));
		}
		if(vo.getNewLossWeight() != null) {
			goodsordermEntity.setLossWeight(vo.getNewLossWeight().divide(new BigDecimal("1000")));
		}
		logger.info("save GoodsOrderm goods price");
		GoodsordermEntity saveEntity = goodsordermRepository.save(goodsordermEntity);
		GoodpricechangelogEntity goodpricechangelogEntity = new GoodpricechangelogEntity();
		// 货源单号
		goodpricechangelogEntity.setPublishId(vo.getPublishId());
		goodpricechangelogEntity.setPublishCompanyId(vo.getCompanyId());
		goodpricechangelogEntity.setPublishCompanyName(vo.getCompanyName());
		goodpricechangelogEntity.setPublishCompanyName(vo.getCompanyName());
		goodpricechangelogEntity.setPublishGoodPriceOld(vo.getGoodPrice());
		goodpricechangelogEntity.setPublishGoodPriceNew(vo.getNewPrice());
		// 20,修改成功。
		goodpricechangelogEntity.setModifyStatus("20");
		goodpricechangelogEntity.setPlatformId(vo.getPlatformId());
		goodpricechangelogEntity.setCreateDate(new Date());
		goodpricechangelogEntity.setCreatePersonId(vo.getUserId());
		goodpricechangelogEntity.setCreatePersonName(vo.getUserName());
		goodpricechangelogEntity.setModifyDate(new Date());
		goodpricechangelogEntity.setModifyPersonId(vo.getUserId());
		goodpricechangelogEntity.setModifyPersonName(vo.getUserName());
		// 亏吨类型(新、老)
		goodpricechangelogEntity.setLossTypeOld(vo.getLossType());
		goodpricechangelogEntity.setLossType(vo.getNewLossType());
		// 亏吨率
		if(null != vo.getLossRatio()) {
			goodpricechangelogEntity.setLossRatioOld(vo.getLossRatio());
		}
		if(null != vo.getNewLossRatio()) {
			goodpricechangelogEntity.setLossRatio(vo.getNewLossRatio().divide(new BigDecimal("1000")));
		}
		// 亏吨额
		if(null != vo.getLossWeight()) {
			goodpricechangelogEntity.setLossWeightOld(vo.getLossWeight());
		}
		if(null != vo.getNewLossWeight()) {
			goodpricechangelogEntity.setLossWeight(vo.getNewLossWeight().divide(new BigDecimal("1000")));
		}
		goodpricechangelogService.save(goodpricechangelogEntity);
		Assert.notNull(saveEntity,"货物单价修改失败!");
	}

	@Override
	public List<GoodsorderquotationVo> getBaoJiaList(GoodsordermQueryVo vo) {
		logger.info("query GoodsorderquotationVo list,publishId is:{}",vo.getPublishId());
		return goodsorderquotationService.getBaoJiaList(vo);
	}

	@Override
	public Page<GoodsordermVo> queryGrabList(GoodsordermQueryVo vo) {
		logger.info("query vat goodsorderm pagination page");
		vo.setGoodsSet(companyService.findCompanyById(vo.getCompanyId()).getGoodsSet());
		return goodsordermRepository.queryGrabList(vo);
	}
	
	@Override
	@Transactional
	public void deletePublish(GoodsordermQueryVo vo) {
    	Integer stopPublishNum = goodsordermRepository.deletePublish(vo.getPlatformId(), vo.getPublishId(), vo.getUserId());
    	Assert.isTrue(stopPublishNum==1,"作废当前单据失败！");
	}
	
	@Override
	@Transactional
	public void copyPublish(GoodsordermQueryVo vo) {
		List <GoodsordermEntity> list= goodsordermRepository.findByPriPublishIdAndStatusGreaterThan(vo.getPublishId(),"00");
		for(GoodsordermEntity entity : list) {
			Long priPublishId =0L;
			GoodsordermVo goodsordermVo = new GoodsordermVo();
			BeanUtils.copyProperties(entity, goodsordermVo);
			goodsordermVo.setCompanyId(vo.getCompanyId());
			goodsordermVo.setRqStart(vo.getRqStart());
			Long count = goodsordermRepository.queryAllSameGoodsorderm(goodsordermVo);
			Assert.isTrue(count<= 5L,"相同方向和相同重量的货源单已存在5单了，今天之内不能再复制当前单据");
			GoodsordermEntity goodsordermEntity = new GoodsordermEntity();
	//		BeanUtils.copyProperties(entity,goodsordermEntity );
			if(entity.getIfTaxTransport() ==null || "".equals(entity.getIfTaxTransport()) || "N".equals(entity.getIfTaxTransport())) {
				 BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
		         BigDecimal priceTax = entity.getPrice().add(entity.getPrice().multiply(standardTax));
		            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
		            goodsordermVo.setStandardTax(standardTax);
		            goodsordermVo.setPriceTax(priceTax);
		            goodsordermVo.setIfTaxTransport("N");
		            goodsordermVo.setVatFlowMasterId(Long.valueOf(0));
			}
			else {
				 setInfo(goodsordermVo);
			}
			copyOldGoodsInfoToNew(goodsordermEntity,goodsordermVo);
			goodsordermEntity.setGroupId(vo.getGroupId());
			goodsordermEntity.setGroupName(vo.getGroupName());
			goodsordermEntity.setUserId(vo.getUserId());
			goodsordermEntity.setCompanyId(vo.getCompanyId());
			goodsordermEntity.setFdUserId(vo.getUserId());
		//	goodsordermEntity.setIfConfirm(entity.getIfConfirm());
			//目前老版没有设置授信设置，在单据生效的时候会进行重新设置
			if("0".equals(entity.getDocuType())) {
				goodsordermRepository.save(goodsordermEntity);
				goodsordermRepository.flush();
				goodsordermEntity = goodsordermRepository.findById(goodsordermEntity.getPublishId()).get();
				goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
				goodsordermRepository.save(goodsordermEntity);
			}
			else if("1".equals(entity.getDocuType())) {
				if("1".equals(entity.getDocuPriSec())) {
					goodsordermRepository.save(goodsordermEntity);
					goodsordermEntity = goodsordermRepository.findById(goodsordermEntity.getPublishId()).get();
					goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
					goodsordermRepository.save(goodsordermEntity);
					priPublishId = goodsordermEntity.getPublishId();
				}
				else {			
					goodsordermEntity.setPriPublishId(priPublishId);
					goodsordermRepository.save(goodsordermEntity);
				}
			}
		}
	}

	// goodsordermEntity 代表新的货源单 ，entity代表老的货源单信息 复制老的货源单属性
	private void copyOldGoodsInfoToNew(GoodsordermEntity goodsordermEntity, GoodsordermVo entity) {
		goodsordermEntity.setIfSavePublish(1);
		goodsordermEntity.setAppointPersonInfo(entity.getAppointPersonInfo());
		goodsordermEntity.setCreateDate(new Date());
		goodsordermEntity.setWeight(entity.getInitWeight());
		goodsordermEntity.setQty(entity.getInitQty());
		goodsordermEntity.setAmount(entity.getInitAmount());
		goodsordermEntity.setInitWeight(entity.getInitWeight());
		goodsordermEntity.setInitQty(entity.getInitQty());
		goodsordermEntity.setInitAmount(entity.getInitAmount());
		goodsordermEntity.setPlatformId(entity.getPlatformId());
		goodsordermEntity.setStatus("10");
		goodsordermEntity.setLimitTime(entity.getLimitTime());
		goodsordermEntity.setRemark(entity.getRemark());
		goodsordermEntity.setDependNum(entity.getDependNum());
		goodsordermEntity.setDependNum2(entity.getDependNum2());
		goodsordermEntity.setPrice(entity.getPrice());
		goodsordermEntity.setGetOrderPlate(entity.getGetOrderPlate());
		goodsordermEntity.setStartPlate(entity.getStartPlate());
		goodsordermEntity.setEndPlate(entity.getEndPlate());
		goodsordermEntity.setGetOrderAddress(entity.getGetOrderAddress());
		goodsordermEntity.setDestination(entity.getDestination());
		goodsordermEntity.setDeparture(entity.getDeparture());
		
		if (entity.getEstimateKM() == null) {
			goodsordermEntity.setEstimateKM(new BigDecimal(78));
		} else {
			goodsordermEntity.setEstimateKM(entity.getEstimateKM());
		}
		goodsordermEntity.setSendKM(entity.getSendKM());
		goodsordermEntity.setGetOrderAddressLng(entity.getGetOrderAddressLng());
		goodsordermEntity.setGetOrderAddressLat(entity.getGetOrderAddressLat());
		goodsordermEntity.setDestinationLng(entity.getDestinationLng());
		goodsordermEntity.setDestinationLat(entity.getDestinationLat());
		goodsordermEntity.setDepartureLng(entity.getDepartureLng());
		goodsordermEntity.setDepartureLat(entity.getDepartureLat());
		goodsordermEntity.setSender(entity.getSender());
		goodsordermEntity.setSenderMobile(entity.getSenderMobile());
		goodsordermEntity.setReceiver(entity.getReceiver());
		goodsordermEntity.setReceiverMobile(entity.getReceiverMobile());
		goodsordermEntity.setGoodType(entity.getGoodType());
		goodsordermEntity.setGoodTypeDesc(entity.getGoodTypeDesc());

		Calendar cal = Calendar.getInstance();
		if (entity.getPickupDate().after(new Date())) {
			cal.setTime(entity.getPickupDate());
			cal.add(Calendar.DATE, 1);
			goodsordermEntity.setPickupDate(cal.getTime());
		} else {
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 1);
			goodsordermEntity.setPickupDate(cal.getTime());
		}
		goodsordermEntity.setVehicleStyleVar(entity.getVehicleStyleVar());
		goodsordermEntity.setProdDesc(entity.getProdDesc());
		goodsordermEntity.setAppointCompanyId(entity.getAppointCompanyId());
		goodsordermEntity.setBillSender(entity.getBillSender());
		goodsordermEntity.setBillSenderMobile(entity.getBillSenderMobile());
		goodsordermEntity.setBillTaker(entity.getBillTaker());
		goodsordermEntity.setBillTakerMobile(entity.getBillTakerMobile());
		goodsordermEntity.setQbType(entity.getQbType());
		goodsordermEntity.setFloorPrice(entity.getFloorPrice());
		goodsordermEntity.setBidTimes(entity.getBidTimes());
		goodsordermEntity.setAppointTeamId(entity.getAppointTeamId());
		goodsordermEntity.setStartPlateProvince(entity.getStartPlateProvince());
		goodsordermEntity.setStartPlateCity(entity.getStartPlateCity());
		goodsordermEntity.setStartPlateCountry(entity.getStartPlateCountry());
		goodsordermEntity.setGetOrderPlateProvince(entity.getGetOrderPlateProvince());
		goodsordermEntity.setGetOrderPlateCity(entity.getGetOrderPlateCity());
		goodsordermEntity.setGetOrderPlateCountry(entity.getGetOrderPlateCountry());
		goodsordermEntity.setEndPlateProvince(entity.getEndPlateProvince());
		goodsordermEntity.setEndPlateCity(entity.getEndPlateCity());
		goodsordermEntity.setEndPlateCountry(entity.getEndPlateCountry());
		if ("APP_TO_WEB".equals(entity.getSendGroup())) {
			goodsordermEntity.setSendGroup("APP");
			goodsordermEntity.setWebCanGrab("N");
		} else {
			goodsordermEntity.setWebCanGrab("Y");
			goodsordermEntity.setSendGroup(entity.getSendGroup());
		}
		goodsordermEntity.setMaxPrice(entity.getMaxPrice());
		goodsordermEntity.setAppointTeamType(entity.getAppointTeamType());
		goodsordermEntity.setPs(entity.getPs());
		goodsordermEntity.setDetachable(entity.getDetachable());
		goodsordermEntity.setIsAutoToTrans(entity.getIsAutoToTrans());
		goodsordermEntity.setDocuType(entity.getDocuType());
		goodsordermEntity.setDocuPriSec(entity.getDocuPriSec());
		goodsordermEntity.setSingleCarWeight(entity.getSingleCarWeight());		
		goodsordermEntity.setIfCanShow("Y");
		Calendar cal2 = Calendar.getInstance();
		if (entity.getTakeDeliveryDate().after(new Date())) {
			cal2.setTime(entity.getTakeDeliveryDate());
			cal2.add(Calendar.DATE, 1);
			goodsordermEntity.setTakeDeliveryDate(cal.getTime());
		} else {
			cal2.setTime(new Date());
			cal2.add(Calendar.DATE, 1);
			goodsordermEntity.setTakeDeliveryDate(cal.getTime());
		}
		goodsordermEntity.setGoodsOwnerId(entity.getGoodsOwnerId());
		goodsordermEntity.setLossWeight(entity.getLossWeight());
		goodsordermEntity.setLossRatio(entity.getLossRatio());
		goodsordermEntity.setGoodPrice(entity.getGoodPrice());
		goodsordermEntity.setLossType(entity.getLossType());
		goodsordermEntity.setIsAutoDisplay(entity.getIsAutoDisplay());
		goodsordermEntity.setIfOwnerTaxpriceMf(entity.getIfOwnerTaxpriceMf());
		 goodsordermEntity.setStandardTax(entity.getStandardTax());
	     goodsordermEntity.setPriceTax(entity.getPriceTax());
	     goodsordermEntity.setIfTaxTransport(entity.getIfTaxTransport());
	     goodsordermEntity.setVatFlowMasterId(entity.getVatFlowMasterId());
		goodsordermEntity.setCatalogId(entity.getCatalogId());
		goodsordermEntity.setCatalogName(entity.getCatalogName());
		// 业务模式（宝丰）
		goodsordermEntity.setBusinessMode(entity.getBusinessMode());
		// 最长运输天数（宝丰）
		goodsordermEntity.setMaxTransDays(entity.getMaxTransDays());
	}
	
	
	@Override
	@Transactional
	public void effectPublish(GoodsordermQueryVo vo) {
		List <GoodsordermEntity> list= goodsordermRepository.findByPriPublishIdAndStatusGreaterThan(vo.getPublishId(),"00");
		for(GoodsordermEntity goodsordermEntity : list) {	
			GoodsordermVo goodsordermVo = new GoodsordermVo();	
			goodsordermEntity.setUserId(vo.getUserId());	
			goodsordermEntity.setFdUserId(vo.getUserId());	
			goodsordermEntity.setGroupId(vo.getGroupId());
			goodsordermEntity.setGroupName(vo.getGroupName());
			BeanUtils.copyProperties(goodsordermEntity, goodsordermVo);
			goodsordermVo.setUserName(vo.getUserName());
			if(goodsordermEntity.getIfTaxTransport() ==null || "".equals(goodsordermEntity.getIfTaxTransport()) || "N".equals(goodsordermEntity.getIfTaxTransport())) {
				 BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
		         BigDecimal priceTax = goodsordermEntity.getPrice().add(goodsordermEntity.getPrice().multiply(standardTax));
		            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
		            goodsordermEntity.setStandardTax(standardTax);
		            goodsordermEntity.setPriceTax(priceTax);
		            goodsordermEntity.setIfTaxTransport("N");
		            goodsordermEntity.setVatFlowMasterId(Long.valueOf(0));
			}
			else {
				 setInfo(goodsordermVo);
				 goodsordermEntity.setStandardTax(goodsordermVo.getStandardTax());
			     goodsordermEntity.setPriceTax(goodsordermVo.getPriceTax());
			     goodsordermEntity.setIfTaxTransport("Y");
			     goodsordermEntity.setVatFlowMasterId(goodsordermVo.getVatFlowMasterId());
				 checkCreditAdjust(goodsordermVo);
			}
			GoodsordermEntity checkEntity = goodsordermRepository.findById(vo.getPublishId()).get();
	    	Assert.isTrue("10".equals(checkEntity.getStatus()),"单据状态已经发生变化，无法完成当前操作！");
			goodsordermEntity.setStatus("20");
			goodsordermEntity.setUpdatePerson(vo.getUserId());
			goodsordermEntity.setUpdateDate(new Date());
		//	goodsordermEntity.setCreateDate(new Date());
			if(goodsordermVo.getOwnerAdjustAmt() != null) {
				goodsordermEntity.setOwnerAdjustAmt(goodsordermVo.getOwnerAdjustAmt());
			}
			if(StringUtils.isNotEmpty(goodsordermVo.getOwnerAdjustType())) {
				goodsordermEntity.setOwnerAdjustType(goodsordermVo.getOwnerAdjustType());
			}
			if(goodsordermVo.getOwnerAdjustAmt()!=null) {
				goodsordermEntity.setOwnerAdjustFlag(goodsordermVo.getOwnerAdjustFlag());
			}
			goodsordermRepository.save(goodsordermEntity);
			insertPriceAdjustDetail(goodsordermVo);	
		
		}
	}
	

	private void insertPriceAdjustDetail(GoodsordermVo vo) {
		if ("Y".equals(vo.getOwnerAdjustFlag())) {
			CreditAdjustPriceDetailEntity creditDetail = creditAdjustPriceDetailService.findByCredAdjDId(vo.getCredAdjDId());
			GoodsordermadjustdetailEntity enity = new GoodsordermadjustdetailEntity();
			// 货源发布id
			enity.setPublishId(vo.getPublishId());
			// 货主运费调价明细id
			enity.setCredAdjDId(creditDetail.getCredAdjDId());
			// 授信调价主表id
			enity.setCredAdjMId(creditDetail.getCredAdjMId());
			// 货源单单价区间起始价(包含)
			enity.setMinPrice(creditDetail.getMinPrice());
			// 货源单单价区间结束价(不包含)
			enity.setMaxPrice(creditDetail.getMaxPrice());
			// 授信加价
			enity.setCreditAddPrice(creditDetail.getCreditAddPrice());
			enity.setCreateDate(new Date());
			enity.setCreatePersonId(vo.getUserId());
			enity.setCreatePersonName(vo.getUserName());
			goodsordermadjustDetailService.save(enity);
		}
	}
	
	private void checkCreditAdjust(GoodsordermVo vo) {
		CreditConfigQueryVo configQueryVo = new CreditConfigQueryVo();
		configQueryVo.setPlatformId(vo.getPlatformId());
		configQueryVo.setPublishCompanyId((vo.getCompanyId()));
		List<CreditConfigVo> configList = creditConfigService.queryCreditConfigStatus(configQueryVo);
		if (configList != null && configList.size() == 1) {
			CreditConfigVo creditConfigVo = configList.get(0);
			Assert.isTrue(!"10".equals(creditConfigVo.getCreditFdStatus()), "您在平台授信存在问题，已被禁止发布委托业务的单据！");
			CreditAdjustPriceQuerySearchVo creditAdjustPriceQuerySearchVo = new CreditAdjustPriceQuerySearchVo();
			creditAdjustPriceQuerySearchVo.setPlatformId(vo.getPlatformId());
			creditAdjustPriceQuerySearchVo.setPublishCompanyId((vo.getCompanyId()));
			List<CreditAdjustPriceMasterEntity> creditAdjustPriceMasterEntityList = creditAdjustPriceMasterService
					.queryCreditAdjustPriceList(creditAdjustPriceQuerySearchVo);
			if (creditAdjustPriceMasterEntityList != null && creditAdjustPriceMasterEntityList.size() == 1) {
				CreditAdjustPriceMasterEntity creditAdjustPriceMasterEntity = creditAdjustPriceMasterEntityList.get(0);
				CreditAdjustPriceDetailQueryVo priceDetailQueryVo = new CreditAdjustPriceDetailQueryVo();
				priceDetailQueryVo.setPlatformId(vo.getPlatformId());
				priceDetailQueryVo.setCompanyId(vo.getCompanyId());
				priceDetailQueryVo.setCurPrice(vo.getCurPrice());
				if ("01".equals(creditAdjustPriceMasterEntity.getAdjPriceStyle())) {
					priceDetailQueryVo.setCurPrice(vo.getPrice());
				} else if ("02".equals(creditConfigVo.getAdjPriceStyle())) {
					priceDetailQueryVo.setCurPrice(vo.getAmount());
				}
				List<CreditAdjustPriceDetailVo> priceDetailList = creditAdjustPriceDetailService
						.queryCreditDetailPriceList(priceDetailQueryVo);
				if (priceDetailList != null && priceDetailList.size() == 1) {
					CreditAdjustPriceDetailVo detailVo = priceDetailList.get(0);
					vo.setOwnerAdjustFlag("Y");
					vo.setOwnerAdjustType(detailVo.getAdjPriceStyle());
					vo.setOwnerAdjustAmt(detailVo.getCreditAddPrice());
					// 调价id
					vo.setCredAdjDId(detailVo.getCredAdjDId());
				} else {
					throw new RuntimeException("不存在合适的授信调价配置!");
				}

			} else {
				throw new RuntimeException("您当前已存在有效的授信记录,但不存在授信调价配置,不能发布委托业务的单据!");
			}
		} else if (configList != null && configList.size() > 1) {
			throw new RuntimeException("您在平台存在多条有效的授信记录，不能发单！");
		} else {
			vo.setOwnerAdjustFlag("N");
			vo.setOwnerAdjustType("01");
			vo.setOwnerAdjustAmt(new BigDecimal("0"));
		}
	}
	
	 /**税率、价格的计算*/
    private void setInfo(GoodsordermVo vo) {
        // 查询公司流程是否存在(这里根据VO中的companyId)
        List<VatflowdetailEntity> flowList = vatflowdetailService.listByPulishCompanyId(vo.getCompanyId());
        Assert.isTrue(flowList!=null && flowList.size()>0 , "该单据发布的是委托承运单据，但找不到此委托承运流程");
        Assert.isTrue(flowList.size() <= 1,"该单据发布的是委托承运单据，但存在多个委托承运流程");
        VatflowdetailEntity flow = flowList.get(0);

        String vatRateChose = flow.getVatRateChose();
        BigDecimal vatStandardRate = flow.getVatStandardRate();
        BigDecimal vatPolicyRate =  flow.getVatPolicyRate();
        String vatAccType = flow.getVatAccType();

        BigDecimal price = vo.getPrice();
        BigDecimal rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
        // 选择乘法
        BigDecimal multipart = price.multiply(new BigDecimal("1").add(rate));
        // 选择除法
        BigDecimal divide = price.divide(new BigDecimal("1").subtract(rate),10,BigDecimal.ROUND_HALF_UP);
        BigDecimal priceTax = "1".equals(vatAccType) ? multipart : divide;
        // 精度
        priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
        // 货主含税运费单价抹分
        if ("1".equals(vo.getIfOwnerTaxpriceMf())) {
            priceTax = priceTax.setScale(1, BigDecimal.ROUND_HALF_UP);
        }
        vo.setStandardTax(rate);
        vo.setPriceTax(priceTax);
        vo.setIfTaxTransport("Y");
        vo.setVatFlowMasterId(flow.getVatFlowMasterId());
        
    }
    
    /*查询生效的委托流程*/
    @Override
	public List<VatflowdetailEntity> queryEffectFlow(VatflowmasterQueryVo vo) {
    	//logger.info("query queryEffectFlow list,vatcompanyId is:{}",vo.getVatCompanyId());
    	//return mybatisQuery.list("goodsorderm.queryEffectFlow", vo);
    	return vatflowdetailService.listByPulishCompanyId(vo.getVatCompanyId());
	} 
    /*查询对应货主的装车增加时间*/
    @Override
    public GoodsownerfdconfigVo queryGoodsownerfdconfigVo(GoodsordermQueryVo vo) {
    	logger.info(" queryGoodsownerfdconfigVo list,companyId ,platformId is:{}",vo.getCompanyId(),vo.getPlatformId());
    	return mybatisQuery.selectOne("goodsorderm.queryGoodsownerfdconfigVo", vo);
    }
    
    @Override
    @Transactional
    public void saveAddress(GoodsordermVo vo) {
        // 检验常用路线是否经存在
        logger.info("query the addresses is exsit or not！");
        CommonaddressEntity checkEntity = commonaddresservice.checkExist(vo.getProvinceName(),vo.getCityName(),vo.getCountryName(),vo.getAddress(),vo.getContactName(),vo.getContactMobile(),vo.getAddressType(),vo.getCompanyId(),vo.getUserId());
        Assert.isNull(checkEntity,"该路线已存在,请勿重复添加!");
        // 保存常用路线地址
        logger.info("save the frequently used addresses");
        CommonaddressEntity saveEntity = new CommonaddressEntity();
        // 封装待保存的信息到实体bean
        saveEntity.setProvinceId(vo.getProvinceId());
        saveEntity.setProvinceName(vo.getProvinceName());
        saveEntity.setCityId(vo.getCityId());
        saveEntity.setCityName(vo.getCityName());
        saveEntity.setCountryId(vo.getCountryId());
        saveEntity.setCountryName(vo.getCountryName());
        saveEntity.setAddress(vo.getAddress());
        saveEntity.setAddressType(vo.getAddressType());
        saveEntity.setPlateLng(vo.getPlateLng()==null ? null : vo.getPlateLng().toString());
        saveEntity.setPlateLat(vo.getPlateLat() ==null ? null : vo.getPlateLat().toString());
        saveEntity.setPlatformId(vo.getPlatformId());
        saveEntity.setCompanyId(vo.getCompanyId().toString());
        saveEntity.setCompanyName(vo.getCompanyName());
        saveEntity.setCreateDate(new Date());
        saveEntity.setCreatePersonId(vo.getUserId().toString());
        saveEntity.setCreatePersonName(vo.getUserName());
        saveEntity.setContactName(vo.getContactName());
        saveEntity.setContactTele(vo.getContactMobile());
        CommonaddressEntity resltEntity = commonaddresservice.save(saveEntity);
        Assert.notNull(resltEntity,"保存失败!");
    }
    @Override
    @Transactional
    public void addNewGoodsorderm(GoodsordermVo goodsordermVo) {
    	 if(goodsordermVo.getAppointTeamId() !="" && goodsordermVo.getAppointTeamId() != null && goodsordermVo.getAppointTeamId().indexOf("default")==-1) {
    		 goodsordermVo.setAppointTeamType("2");
    	 }else {
    		 goodsordermVo.setAppointTeamType("1"); //设置为全部组
    	 }
    	 if(goodsordermVo.getIfTaxTransport() ==null || "".equals(goodsordermVo.getIfTaxTransport()) || "N".equals(goodsordermVo.getIfTaxTransport())) {
			 BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
	         BigDecimal priceTax = goodsordermVo.getPrice().add(goodsordermVo.getPrice().multiply(standardTax));
	            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
	            goodsordermVo.setStandardTax(standardTax);
	            goodsordermVo.setPriceTax(priceTax);
	            goodsordermVo.setIfTaxTransport("N");
	            goodsordermVo.setVatFlowMasterId(Long.valueOf(0));
		}
		else {
			 setInfo(goodsordermVo);		 
			 checkCreditAdjust(goodsordermVo);	 
		}
    	CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
 		catalogQueryVo.setGoodType(goodsordermVo.getGoodType());
 		catalogQueryVo.setGoodTypeDesc(goodsordermVo.getGoodTypeDesc());
 		catalogQueryVo.setPlatformId(goodsordermVo.getPlatformId());
 		catalogQueryVo.setStatus("20");
 		catalogQueryVo.setLayer("1");
 		CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
 		Assert.notNull(catalog,"当前单据的货物类型对应的大品种不存在，请先维护!");
 		goodsordermVo.setCatalogId(catalog.getCatalogId());
 		goodsordermVo.setCatalogName(catalog.getCatalogName());
 		GoodsordermEntity  goodsordermEntity = new GoodsordermEntity();
 		if(goodsordermVo.getOwnerAdjustAmt() != null) {
			goodsordermEntity.setOwnerAdjustAmt(goodsordermVo.getOwnerAdjustAmt());
		}
		if(StringUtils.isNotEmpty(goodsordermVo.getOwnerAdjustType())) {
			goodsordermEntity.setOwnerAdjustType(goodsordermVo.getOwnerAdjustType());
		}
		if(goodsordermVo.getOwnerAdjustAmt() !=null) {
			goodsordermEntity.setOwnerAdjustFlag(goodsordermVo.getOwnerAdjustFlag());
		}
 		//将页面上的属性参数传入到新的entity中
 		addNewGoodsordermToEntity(goodsordermVo,goodsordermEntity);
 		goodsordermEntity.setCreateDate(new Date());
 	//	goodsordermVo.setPriPublishId(goodsordermEntity.getPublishId());
 		goodsordermRepository.save(goodsordermEntity);
 		goodsordermRepository.flush();
 		goodsordermEntity = goodsordermRepository.findById(goodsordermEntity.getPublishId()).get();
 		goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
 		goodsordermRepository.save(goodsordermEntity);
 		goodsordermVo.setPublishId(goodsordermEntity.getPublishId());
 		insertPriceAdjustDetail(goodsordermVo);
 		GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
 		goodsorderexecutelogEntity.setCreateTime(new Date());
 		goodsorderexecutelogEntity.setDeliveryId(1L);
 		goodsorderexecutelogEntity.setTransId(1L);
 		goodsorderexecutelogEntity.setPublishId(goodsordermVo.getPublishId());
 		goodsorderexecutelogEntity.setExeDesc("您的货单已提交，正在等待物流公司接单。" + "货单号:" + goodsordermVo.getPublishId().toString());
 		goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);
// 		if(goodsordermVo.getEstimateKM() == null) {
// 			 Double startLat= Double.parseDouble(goodsordermVo.getGetOrderAddressLat().toString()); 
// 			 Double startLng = Double.parseDouble(goodsordermVo.getGetOrderAddressLng().toString()); 
//			 Double endLat= Double.parseDouble(goodsordermVo.getDestinationLat().toString());  
//			 Double endLng=Double.parseDouble(goodsordermVo.getDestinationLng().toString());
//			 Double len=LatLngGetDistance.getDistance(startLat, startLng, endLat,endLng);
// 		}
 		if(goodsordermVo.getImportId() != null) {
 			int i= goodsordermRepository.updateGoodsordermjkStatus("20",goodsordermVo.getPublishId(),goodsordermVo.getUserId(),goodsordermVo.getImportId(),"10");
 			Assert.isTrue(i==1,"页面数据过时，请刷新页面重试！");
 		}
    }
    
    @Override
    @Transactional
    public void addNewPtGoodsorderm(GoodsordermVo goodsordermVo) { 
    	Long count = goodsordermRepository.queryAllSameAddressNewGoodsorderm(goodsordermVo);
    	if(count == 0L && "0".equals(goodsordermVo.getDocuType())) {
    		GoodsordermEntity oldEntity= goodsordermRepository.findById(goodsordermVo.getPublishId()).get();
        	GoodsordermEntity newEntity = new GoodsordermEntity();
      //  	oldEntity.setPublishNum(null);
        	BeanUtils.copyProperties(oldEntity, newEntity);
        	newEntity.setPublishId(null);
        	newEntity.setIfSavePublish(1);
        	newEntity.setStatus("10");
        	newEntity.setPublishNum(null);

        	//保存合同编号
			newEntity.setContractNumber(goodsordermVo.getContractNumber());

        	newEntity = goodsordermRepository.save(newEntity);
      //  	goodsordermRepository.flush();
        	newEntity.setPriPublishId(newEntity.getPublishId());
        	goodsordermRepository.save(newEntity);
        	goodsordermVo.setReturnMsg("货源单发布并保存成功！");
    	}
    	else {
    		goodsordermVo.setReturnMsg("当前货源单发布成功，系统中已保存相同装货地，装货联系人，联系电话，目的地，收货人，联系电话，货物类型的单据，此单据将不再做保存！");
    	}
    	
    }
    
    private void addNewGoodsordermToEntity(GoodsordermVo entity,GoodsordermEntity goodsordermEntity) {
		goodsordermEntity.setAppointPersonInfo(entity.getAppointTeamName());
	//	goodsordermEntity.setCreateDate(new Date());
		goodsordermEntity.setWeight(entity.getWeight());
		goodsordermEntity.setQty(entity.getQty());
		goodsordermEntity.setAmount(entity.getAmount());
		goodsordermEntity.setInitWeight(entity.getWeight());
		goodsordermEntity.setInitQty(entity.getQty());
		goodsordermEntity.setInitAmount(entity.getAmount());
		goodsordermEntity.setPlatformId(entity.getPlatformId());
		goodsordermEntity.setStatus("20");
		goodsordermEntity.setLimitTime(entity.getLimitTime());
		goodsordermEntity.setRemark(entity.getRemark());
		goodsordermEntity.setDependNum(entity.getDependNum());
		goodsordermEntity.setDependNum2(entity.getDependNum());
		goodsordermEntity.setPrice(entity.getPrice());
		if(entity.getStartPlateProvince().equals(entity.getStartPlateCity())) {
			goodsordermEntity.setStartPlate(entity.getStartPlateProvince() + entity.getStartPlateCountry() + entity.getStartPlate());
		}
		else {
			goodsordermEntity.setStartPlate(entity.getStartPlateProvince() + entity.getStartPlateCity() + entity.getStartPlateCountry() + entity.getStartPlate());
		}
		
		if(entity.getGetOrderPlateProvince().equals(entity.getGetOrderPlateCity())) {
			goodsordermEntity.setGetOrderPlate(entity.getGetOrderPlateProvince() + entity.getGetOrderPlateCountry() + entity.getGetOrderPlate());
		}
		else {
			goodsordermEntity.setGetOrderPlate(entity.getGetOrderPlateProvince() + entity.getGetOrderPlateCity() + entity.getGetOrderPlateCountry() + entity.getGetOrderPlate());
		}
		
		if(entity.getEndPlateProvince().equals(entity.getEndPlateCity())) {
			goodsordermEntity.setEndPlate(entity.getEndPlateProvince() + entity.getEndPlateCountry() + entity.getEndPlate());
		}
		else {
			goodsordermEntity.setEndPlate(entity.getEndPlateProvince() + entity.getEndPlateCity() + entity.getEndPlateCountry() + entity.getEndPlate());
		}
		goodsordermEntity.setGetOrderAddress(entity.getGetOrderAddress());
		goodsordermEntity.setDestination(entity.getDestination());
		goodsordermEntity.setDeparture(entity.getDeparture());
		goodsordermEntity.setUserId(entity.getUserId());
		goodsordermEntity.setCompanyId(entity.getCompanyId());
		goodsordermEntity.setSendKM(entity.getSendKM());
		goodsordermEntity.setGetOrderAddressLng(entity.getGetOrderAddressLng());
		goodsordermEntity.setGetOrderAddressLat(entity.getGetOrderAddressLat());
		goodsordermEntity.setDestinationLng(entity.getDestinationLng());
		goodsordermEntity.setDestinationLat(entity.getDestinationLat());
		goodsordermEntity.setDepartureLng(entity.getDepartureLng());
		goodsordermEntity.setDepartureLat(entity.getDepartureLat());
		goodsordermEntity.setSender(entity.getSender());
		goodsordermEntity.setSenderMobile(entity.getSenderMobile());
		goodsordermEntity.setReceiver(entity.getReceiver());
		goodsordermEntity.setReceiverMobile(entity.getReceiverMobile());
		if(entity.getGoodType() != null) {
			goodsordermEntity.setGoodType(entity.getGoodType());
		}
		goodsordermEntity.setGoodTypeDesc(entity.getGoodTypeDesc());
		goodsordermEntity.setPickupDate(entity.getPickupDate());
		goodsordermEntity.setVehicleStyleVar(entity.getVehicleStyleVar());
		goodsordermEntity.setProdDesc(entity.getProdDesc());
		if(entity.getAppointCompanyId() != null) {
			goodsordermEntity.setAppointCompanyId(entity.getAppointCompanyId());
		}
		goodsordermEntity.setBillSender(entity.getBillSender());
		goodsordermEntity.setBillSenderMobile(entity.getBillSenderMobile());
		goodsordermEntity.setBillTaker(entity.getBillTaker());
		goodsordermEntity.setBillTakerMobile(entity.getBillTakerMobile());
		goodsordermEntity.setQbType(entity.getQbType());
		goodsordermEntity.setFloorPrice(entity.getPrice());
		goodsordermEntity.setBidTimes(entity.getBidTimes());
		goodsordermEntity.setAppointTeamId(entity.getAppointTeamId());
		goodsordermEntity.setStartPlateProvince(entity.getStartPlateProvince());
		goodsordermEntity.setStartPlateCity(entity.getStartPlateCity());
		goodsordermEntity.setStartPlateCountry(entity.getStartPlateCountry());
		goodsordermEntity.setGetOrderPlateProvince(entity.getGetOrderPlateProvince());
		goodsordermEntity.setGetOrderPlateCity(entity.getGetOrderPlateCity());
		goodsordermEntity.setGetOrderPlateCountry(entity.getGetOrderPlateCountry());
		goodsordermEntity.setEndPlateProvince(entity.getEndPlateProvince());
		goodsordermEntity.setEndPlateCity(entity.getEndPlateCity());
		goodsordermEntity.setEndPlateCountry(entity.getEndPlateCountry());
		
		if (entity.getEstimateKM() == null) {
			goodsordermEntity.setEstimateKM(new BigDecimal(78));
			} else {
			goodsordermEntity.setEstimateKM(entity.getEstimateKM());
		}
		if ("APP_TO_WEB".equals(entity.getSendGroup())) {
			goodsordermEntity.setSendGroup("APP");
			goodsordermEntity.setWebCanGrab("N");
		} else {
			goodsordermEntity.setWebCanGrab("Y");
			goodsordermEntity.setSendGroup(entity.getSendGroup());
		}
		goodsordermEntity.setMaxPrice(entity.getMaxPrice());
		goodsordermEntity.setAppointTeamType(entity.getAppointTeamType());
		goodsordermEntity.setPs(entity.getPs());
		goodsordermEntity.setDetachable(entity.getDetachable());
		goodsordermEntity.setIsAutoToTrans(entity.getIsAutoToTrans());
		if(StringUtils.isNotEmpty(entity.getDocuType())) {
			goodsordermEntity.setDocuType(entity.getDocuType());
		}
		if(StringUtils.isNotEmpty(entity.getDocuPriSec())){
			goodsordermEntity.setDocuPriSec(entity.getDocuPriSec());
		}
		if(entity.getPriPublishId() != null) {
			goodsordermEntity.setPriPublishId(entity.getPriPublishId());
		}
		
		if(entity.getSingleCarWeight() != null) {
			goodsordermEntity.setSingleCarWeight(entity.getSingleCarWeight());
		}
		goodsordermEntity.setFdUserId(entity.getUserId());
		goodsordermEntity.setIfCanShow("Y");
		goodsordermEntity.setTakeDeliveryDate(entity.getTakeDeliveryDate());
		if(entity.getGoodsOwnerId() !=null) {
			goodsordermEntity.setGoodsOwnerId(entity.getGoodsOwnerId());
		}
		if(entity.getLossWeight()!=null) {
			goodsordermEntity.setLossWeight(entity.getLossWeight());
		}
		if(entity.getLossRatio()!=null) {
			goodsordermEntity.setLossRatio(entity.getLossRatio());
		}
		if(entity.getGoodPrice() !=null) {
			goodsordermEntity.setGoodPrice(entity.getGoodPrice());
		}
		if(StringUtils.isNotEmpty(entity.getLossType())) {
			goodsordermEntity.setLossType(entity.getLossType());
    	}
		goodsordermEntity.setVatFlowMasterId(entity.getVatFlowMasterId());
		goodsordermEntity.setPriceTax(entity.getPriceTax());
		goodsordermEntity.setIfTaxTransport(entity.getIfTaxTransport());
		goodsordermEntity.setStandardTax(entity.getStandardTax());
		goodsordermEntity.setCatalogId(entity.getCatalogId());
		goodsordermEntity.setCatalogName(entity.getCatalogName());
		goodsordermEntity.setGroupId(entity.getGroupId());
		goodsordermEntity.setGroupName(entity.getGroupName());
		goodsordermEntity.setBusinessMode(entity.getBusinessMode());
		goodsordermEntity.setMaxTransDays(entity.getMaxTransDays());

		//保存合同编号
		goodsordermEntity.setContractNumber(entity.getContractNumber());
    }

	@Override
	public WebReturnMessage checkGrabPer(GoodsordermQueryVo vo) {
		logger.info("check if can grab the order");
		GoodsordermVo goodsordermVo = goodsordermRepository.queryTaxTransportInfo(vo);
		Assert.isTrue(!"Y".equals(goodsordermVo.getIfTaxTransport()), "只有司机和经纪人才可以抢委托承运的货源单!");
		return new WebReturnMessage(true,"恭喜你，运单已生成!");
	}

	@Override
	@Transactional
	public WebReturnMessage grabBill(GoodsordermVo vo) {
		WebReturnMessage webReturnMessage = new WebReturnMessage(true,"");
		// 是否发短信
		int flag = 0;
		// 校验是否有抢单资格(未审核或者被冻结)
		checkCompanyStatus(vo);
		// 根据货源单号查询外部货源信息
		queryRet(vo);
		// 税价格等信息封装
		queryTaxTransportInfo(vo);
		// 报价场景
		if ("1".equals(vo.getQbType())) {
			insertQuotation(vo,webReturnMessage);
			// 报价小于最高价,则判断是否自动生成订单
			if (true == webReturnMessage.isSuccess()) {
				// 1：报价自动生成运输订单
				if ("1".equals(vo.getIsAutoToTrans())) {
					grabBillInfo(vo);
					// 更新报价记录
					GoodsorderquotationEntity quotationEntity = goodsorderquotationService.findById(vo.getQuotationId());
					quotationEntity.setStatus("20");
					quotationEntity.setTransId(vo.getTransId());
					goodsorderquotationService.save(quotationEntity);
					flag = 1;
				}
			}
		} else { 	
			// 直接抢单
			grabBillByCharge(vo);
			flag = 1;
		}
		if (flag == 1) {
			webReturnMessage.setSuccess(true);
			webReturnMessage.setMsg("抢单成功！");
		}
		return webReturnMessage;
	}
	
	/**直接抢单逻辑*/
	private void grabBillByCharge(GoodsordermVo vo) {
		// 检查是否在货主的黑名单中
		CompanySearchVo companySearchVo = new CompanySearchVo();
		companySearchVo.setPublishId(vo.getPublishId());
		companySearchVo.setPlatformId(vo.getPlatformId());
		companySearchVo.setCompanyId(vo.getCompanyId());
	    companyService.findDriverFdrBlack(companySearchVo);
		String result = createCapitalFlowing(vo);
		if(!"success".equals(result)) {
			throw new RuntimeException(result);
		}	
		
		grabBillInfo(vo);
		// 查询信息费收取情况
		CompanyVo companyVo = companyService.queryGrabMoney(vo.getPublishId(),vo.getPlatformId());
		if(null != companyVo && "Y".equals(companyVo.getIfGrabMoney()) && ((BigDecimal)companyVo.getGrabMoney()).doubleValue() > 0) {
			vo.setIfGrabMoney(companyVo.getIfGrabMoney());
			vo.setGrabMoney(companyVo.getGrabMoney());
			vo.setOperationType("10"); 
			// 抢单扣款
			processCapital(vo);
		}
	}

	/**处理资金信息*/
	private void processCapital(GoodsordermVo vo) {
		if (vo == null) {
			throw new RuntimeException("资金参数异常!");
		}
		// 抢单扣款
		if ("10".equals(vo.getOperationType())) {
			// 承运资金查询
			CapitalBalanceEntity capitalBalanceEntity = capitalBalanceService.findByCompanyIdAndPlatformId(vo.getCompanyId(),vo.getPlatformId());
			Assert.notNull(capitalBalanceEntity, "对不起,您的资金余额不足,请充值后再抢单!");
			if(capitalBalanceEntity.getBalance().compareTo(vo.getGrabMoney()) == -1) {
				throw new  RuntimeException("对不起,您的资金余额不足,请充值后再抢单!");
			}else {
				BigDecimal balance = capitalBalanceEntity.getBalance();
				capitalBalanceEntity.setBalance(balance.subtract(vo.getGrabMoney()));
				capitalBalanceEntity.setUpdateDate(new Date());
			}
			// 更新资金流水记录
			CapitalFlowingEntity capitalFlowingEntity = capitalFlowingService.findById(vo.getCapitalFlowingId());
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String formatDate = sd.format(date);
			capitalFlowingEntity.setUpdatePerson(vo.getUserId());
			capitalFlowingEntity.setUpdateDate(date);
			capitalFlowingEntity.setDependId(vo.getTransId().toString());
			capitalFlowingEntity.setStatus("20");
			capitalFlowingEntity.setRemark(formatDate + "抢单成功,运单id:" + vo.getPublishId() + vo.getTransId());
			capitalFlowingService.save(capitalFlowingEntity);
		}
	}

	/**资金流水情况*/
	private String createCapitalFlowing(GoodsordermVo vo) {
		String result = "success";
		// 查询信息费收取情况
		CompanyVo companyVo = companyService.queryGrabMoney(vo.getPublishId(),vo.getPlatformId());
		if(null != companyVo && "Y".equals(companyVo.getIfGrabMoney()) && ((BigDecimal)companyVo.getGrabMoney()).doubleValue() > 0) {
			vo.setIfGrabMoney(companyVo.getIfGrabMoney());
			vo.setGrabMoney(companyVo.getGrabMoney());
			vo.setOperationType("10"); 
			// 抢单扣款
			result = processCapitalPre(vo);
		}
		return result;
	}

	/**抢单扣款*/
	private String processCapitalPre(GoodsordermVo vo) {
		if (vo == null) {
			throw new RuntimeException("资金参数异常!");
		}
		String capitalFlowingNum = null;
		String result = "success";
		try {
			// 抢单扣款
			if ("10".equals(vo.getOperationType())) {	
				/**承运方扣款*/
				// 获取资金流水编号
				capitalFlowingNum = getSeqNum("8");
				// 保存资金流水记录
				CapitalFlowingEntity capitalFlowingEntity = new CapitalFlowingEntity();
				capitalFlowingEntity.setCapitalFlowingNum(capitalFlowingNum);
				capitalFlowingEntity.setCompanyId(vo.getCompanyId());
				capitalFlowingEntity.setDependId(vo.getPublishId().toString());
				capitalFlowingEntity.setAmount(vo.getGrabMoney().multiply(new BigDecimal("-1")));
				capitalFlowingEntity.setMethod("OUT");
				capitalFlowingEntity.setOperationType("10");
				capitalFlowingEntity.setOperationName("抢单扣款");
				capitalFlowingEntity.setCreatePerson(vo.getUserId());
				capitalFlowingEntity.setCreateDate(new Date());
				capitalFlowingEntity.setUpdatePerson(vo.getUserId());
				capitalFlowingEntity.setUpdateDate(new Date());
				capitalFlowingEntity.setRemark("货源单号：" + vo.getPublishId());
				capitalFlowingEntity.setPlatformId(vo.getPlatformId());
				CapitalFlowingEntity saveEntity = capitalFlowingService.save(capitalFlowingEntity);
				vo.setCapitalFlowingId(saveEntity.getCapitalFlowingId());
				
				// 承运资金查询
				CapitalBalanceEntity capitalBalanceEntity = capitalBalanceService.findByCompanyIdAndPlatformId(vo.getCompanyId(),vo.getPlatformId());
				if(null == capitalBalanceEntity) {
					Date date = new Date();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String formatDate = sd.format(date);
					capitalFlowingEntity.setRemark(formatDate + "对不起，您的资金余额不足，请充值后再抢单!");
					capitalFlowingEntity.setStatus("10");
					capitalFlowingEntity.setUpdatePerson(vo.getUserId());
					capitalFlowingEntity.setUpdateDate(date);
					capitalFlowingService.save(capitalFlowingEntity);
					result = "对不起，您的资金余额不足，请充值后再抢单!";
					return result;
				}
		
				// 判断收取服务费后资金是否充足
				CapitalBalanceEntity minusCharge = capitalBalanceService.findByCapitalSeqIdAndAmount(capitalBalanceEntity.getSeqId(),vo.getGrabMoney());
				if(null == minusCharge) {
					Date date = new Date();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					String formatDate = sd.format(date);
					capitalFlowingEntity.setRemark(formatDate + "对不起，您的资金余额不足，请充值后再抢单!");
					capitalFlowingEntity.setStatus("10");
					capitalFlowingEntity.setUpdatePerson(vo.getUserId());
					capitalFlowingEntity.setUpdateDate(date);
					capitalFlowingService.save(capitalFlowingEntity);
					result = "对不起，您的资金余额不足，请充值后再抢单!";
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = e.getMessage();
			return result;
		}
		return result;
	}

	/**抢单、报价逻辑*/
	private void grabBillInfo(GoodsordermVo vo) {
		
		// 获取可抢单量信息
		GoodsordermVo goodsordermVo = goodsordermRepository.queryIsHas(vo.getPublishId());
		// 可抢单量
		BigDecimal weight = goodsordermVo.getWeight(); 
		// 抢单量
		BigDecimal grabWeight = vo.getGrabWeight();
		if (weight.compareTo(grabWeight) == -1) {
			throw new RuntimeException("对不起，当前货源单量不足，无法生成运输订单！");
		}
		
		// 价格验证
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
	    if(!"1".equals(vo.getQbType())){
	    	if(!(goodsordermEntity.getPrice().compareTo(vo.getOutPrice()) == 0)){
	    		throw new RuntimeException("当前货源单的运费单价已经发生变化,请刷新页面重试!");
	    	}
	    }
		if (vo.getOutPrice().compareTo(vo.getFloorPrice()) == 1) {
			throw new RuntimeException("对不起，您的报价过高，请等待委托方确认！");
		}
		
		// 定向校验
		Long countTeam = goodsordermRepository.countTeamId(vo.getPublishId(),vo.getCompanyId());
		if(1 != countTeam) {
			// 查询运单的完成情况
			countTeam = checkGrab(vo,countTeam);
		}
		if(1 == countTeam) {
			// 更新货源单的数量，金额
			BigDecimal zero = new BigDecimal("0");
			BigDecimal getGrabWeight = vo.getGrabWeight() == null ? zero : vo.getGrabWeight();
			goodsordermEntity.setWeight(goodsordermEntity.getWeight().subtract(getGrabWeight));
			goodsordermEntity.setAmount(goodsordermEntity.getAmount().subtract(getGrabWeight.multiply(goodsordermEntity.getPrice())));
			goodsordermEntity.setQty(goodsordermEntity.getQty().subtract(vo.getGrabQty()));
			// 货物完成重量
			BigDecimal saleWeight = (goodsordermEntity.getSaleWeight() == null ? zero : goodsordermEntity.getSaleWeight()).add(getGrabWeight);
			goodsordermEntity.setSaleWeight(saleWeight);
			// 货物完成金额
			BigDecimal saleAmount = (goodsordermEntity.getSaleAmount()  == null ? 
					zero : goodsordermEntity.getSaleAmount()).add(getGrabWeight.multiply(goodsordermEntity.getPrice()));
			goodsordermEntity.setSaleAmount(saleAmount);
			// 货物完成件数
			BigDecimal saleQty = (goodsordermEntity.getSaleQty() == null ? zero : goodsordermEntity.getSaleQty()).add(vo.getQty() == null ? zero : vo.getQty());
			goodsordermEntity.setSaleQty(saleQty);
			// 备注(控制长度500位限制)
			String remark = goodsordermEntity.getRemark() == null ? "" : goodsordermEntity.getRemark();
			if(remark.length() > 500) {
				remark = remark.substring(remark.length()-500);
			}
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String formatDate = sd.format(date);
			remark = remark + formatDate + "被抢单by" + vo.getUserId();
			goodsordermEntity.setRemark(remark);
			goodsordermRepository.save(goodsordermEntity);
			
			// 生成运单
			TransportationmEntity transEntity = new TransportationmEntity();
			setTransInfo(transEntity,goodsordermEntity,vo);
			TransportationmEntity saveEntity = transportationmService.save(transEntity);
			
			vo.setTransId(saveEntity.getTransId());
			
			// 处理记录
			GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
			goodsorderexecutelogEntity.setCreateTime(new Date());
			goodsorderexecutelogEntity.setExeDesc("您的货单已被接单，运单号为："+saveEntity.getTransId());
			goodsorderexecutelogEntity.setPublishId(goodsordermEntity.getPublishId());
			goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);
			
			// 短信记录
			ShortmessageEntity shortmessageEntity = new ShortmessageEntity();
			shortmessageEntity.setReceiver(saveEntity.getBillSenderMobile());
			shortmessageEntity.setMessage("您的货物已被" + saveEntity.getCompanyName() + "承运,运单号为:" 
			+ saveEntity.getTransId() + ",运输路线为:从" + saveEntity.getStartPlate() + "到" + saveEntity.getEndPlate());
			shortmessageEntity.setCreateTime(new Date());
			shortmessageEntity.setPlatformId(vo.getPlatformId());
			shortmessageEntity.setSendType("01");
			shortMessageService.save(shortmessageEntity);
			
			// 查询该单据是否为捆绑货源单（如双向单），如果是，且是主单 则查出子单生成运单需要的数据
			List<GoodsordermVo> goodsordermVos = goodsordermRepository.queryHasChildGood(vo.getPublishId());
			for (GoodsordermVo goodsorderVo : goodsordermVos) {
				GoodsordermVo copyVo = new GoodsordermVo();
				BeanUtils.copyProperties(vo, copyVo);
				copyVo.setPublishId(goodsorderVo.getPublishId());
				copyVo.setFloorPrice(goodsorderVo.getFloorPrice());
				copyVo.setOutPrice(goodsorderVo.getOutPrice());
				copyVo.setGrabQty(goodsorderVo.getGrabQty());
				copyVo.setGrabWeight(goodsorderVo.getGrabWeight());
				copyVo.setWeight(goodsorderVo.getWeight());
				grabBillInfo(copyVo);
			}
			// 如果是外部货源单据,保存记录
			if(vo.getRet2() != null && vo.getRet2() != ""){
				shortmessageEntity.setMessage("单据号:" + vo.getRet2() + ",货原单号:" + vo.getPublishId() + ",已被" + vo.getUserName() + vo.getPhone() + "抢单");
				shortMessageService.save(shortmessageEntity);
			}
		}
	}


	/**封装保存运单的参数*/
	private void setTransInfo(TransportationmEntity transEntity,GoodsordermEntity goodsordermEntity,GoodsordermVo vo) {
		transEntity.setPublishId(goodsordermEntity.getPublishId());
		transEntity.setWeight(vo.getGrabWeight());
		transEntity.setQty(vo.getGrabQty());
		transEntity.setAmount(vo.getGrabWeight().multiply(vo.getOutPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
		transEntity.setCreateDate(new Date());
		transEntity.setCompanyId(vo.getCompanyId());
		transEntity.setStartPlate(goodsordermEntity.getStartPlate());
		transEntity.setEndPlate(goodsordermEntity.getEndPlate());
		transEntity.setGetOrderPlate(goodsordermEntity.getGetOrderPlate());
		transEntity.setCreatePerson(vo.getUserId());
		transEntity.setPlatformId(vo.getPlatformId());
		transEntity.setCompanyName(vo.getCompanyName());
		transEntity.setProdDesc(goodsordermEntity.getProdDesc());
		transEntity.setPrice(vo.getOutPrice());
		transEntity.setPickupDate(goodsordermEntity.getPickupDate());
		transEntity.setSender(goodsordermEntity.getSender());
		transEntity.setSenderMobile(goodsordermEntity.getSenderMobile());
		transEntity.setReceiver(goodsordermEntity.getReceiver());
		transEntity.setReceiverMobile(goodsordermEntity.getReceiverMobile());
		transEntity.setBillSender(goodsordermEntity.getBillSender());
		transEntity.setBillSenderMobile(goodsordermEntity.getBillSenderMobile());
		transEntity.setBillTaker(goodsordermEntity.getBillTaker());
		transEntity.setBillTakerMobile(goodsordermEntity.getBillTakerMobile());
		transEntity.setInitAmount(vo.getGrabWeight().multiply(vo.getOutPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
		transEntity.setInitQty(vo.getGrabQty());
		transEntity.setInitWeight(vo.getGrabWeight());
		transEntity.setStatus("20");
		transEntity.setDeparture(goodsordermEntity.getDeparture());
		transEntity.setDepartureLng(goodsordermEntity.getDepartureLng());
		transEntity.setDepartureLat(goodsordermEntity.getDepartureLat());
		transEntity.setDestination(goodsordermEntity.getDestination());
		transEntity.setDestinationLng(goodsordermEntity.getDestinationLng());
		transEntity.setDestinationLat(goodsordermEntity.getDestinationLat());
		transEntity.setGetOrderAddress(goodsordermEntity.getGetOrderAddress());
		transEntity.setGetOrderAddressLng(goodsordermEntity.getGetOrderAddressLng());
		transEntity.setGetOrderAddressLat(goodsordermEntity.getGetOrderAddressLat());
		transEntity.setGoodType(goodsordermEntity.getGoodType());
		transEntity.setGoodTypeDesc(goodsordermEntity.getGoodTypeDesc());
		transEntity.setPublishCompanyId(goodsordermEntity.getCompanyId());
		transEntity.setOperateType("WEB");
		transEntity.setUpdateDate(new Date());
		transEntity.setFdUserId(goodsordermEntity.getFdUserId());
		transEntity.setIfCanShow(goodsordermEntity.getIfCanShow());
		transEntity.setUpdatePerson(vo.getUserId());
		if(StringUtils.isNotEmpty(vo.getIfFly())) {
			transEntity.setIfFeidan(vo.getIfFly());
		}
		transEntity.setPriPublishId(goodsordermEntity.getPriPublishId());
		transEntity.setStandardTax(vo.getStandardTax());
		transEntity.setPriceTax(vo.getPriceTax());
		transEntity.setIfTaxTransport(vo.getIfTaxTransport());
		transEntity.setVatFlowMasterId(vo.getVatFlowMasterId());
		// 流程查找(含税委托承运时)
		if("Y".equals(vo.getIfTaxTransport())) {
			VatflowdetailEntity  vatflowdetailEntity = vatflowdetailService.queryBeginFlow(vo.getVatFlowMasterId());
			transEntity.setCarryCompanyId(vatflowdetailEntity.getVatCarryId());
		}else {
			transEntity.setCarryCompanyId(vo.getCompanyId());
		}
		// 集团信息
		transEntity.setGroupId(goodsordermEntity.getGroupId());
		transEntity.setGroupName(goodsordermEntity.getGroupName());
		// 调价信息
		transEntity.setOwnerAdjustFlag(goodsordermEntity.getOwnerAdjustFlag());
		transEntity.setOwnerAdjustType(goodsordermEntity.getOwnerAdjustType());
		transEntity.setOwnerAdjustAmt(goodsordermEntity.getOwnerAdjustAmt());
		transEntity.setGoodPrice(goodsordermEntity.getGoodPrice());
		transEntity.setLossType(goodsordermEntity.getLossType());
		transEntity.setLossRatio(goodsordermEntity.getLossRatio());
		transEntity.setLossWeight(goodsordermEntity.getLossWeight());
		// 业务流程模式信息
		transEntity.setBusinessMode(goodsordermEntity.getBusinessMode());
		transEntity.setRobDeliveryType(goodsordermEntity.getRobDeliveryType());

	}

	/** 查询运单的完成情况
	 * @return */
	private Long checkGrab(GoodsordermVo vo,Long countTeam) {
		int maxBillNum = 2;
		Long result = 0L;	
		
		Integer companyCount = companyService.checkCompanyStatus(vo.getPlatformId(), vo.getCompanyId());
		if(companyCount != null && companyCount > 0){
			throw new RuntimeException("您的账号还未审核或者被冻结，不能抢单！");
		}	
			
		if ("GS".equals(vo.getUserType())) {
			TransportBillQueryVo transQuery = new TransportBillQueryVo();
			transQuery.setPlatformId(vo.getPlatformId());
			transQuery.setCompanyId(vo.getCompanyId());
			// 查询待装货的运单数
		//	result = transportationDeliveryService.checkGrab(transQuery);
			result = mybatisQuery.selectOne("goodsorderm.checkGrab",transQuery);

			maxBillNum = 10;		
		} else {	
			result = transportationDeliveryService.checkDriverBill(vo.getPlatformId(),vo.getCompanyId());
			maxBillNum = 1;
		}
		
		if (result != null && result >= maxBillNum) {
			vo.setMaxBillNum(maxBillNum);
			if("GS".equals(vo.getUserType())){
				Assert.isTrue(false, "您还有"+ maxBillNum +"单运输订单未完成调度,不能抢单！");
			}else{
				Assert.isTrue(false, "您还有"+ maxBillNum +"单调度未完成，不能抢单！");
			}
		}else {
			return countTeam = 1l;
		}
		return countTeam; 
		
	}

	/**报价记录处理*/
	private void insertQuotation(GoodsordermVo vo, WebReturnMessage webReturnMessage) {	
		// 检查是否在货主的黑名单中
		CompanySearchVo companySearchVo = new CompanySearchVo();
		companySearchVo.setPublishId(vo.getPublishId());
		companySearchVo.setPlatformId(vo.getPlatformId());
		companySearchVo.setCompanyId(vo.getCompanyId());
		CompanyVo companyVo = companyService.findDriverFdrBlack(companySearchVo);
		if(null != companyVo) {
			Assert.isTrue(companyVo.getCount() <= 0, "当前货主:" + companyVo.getCompanyName() + "已经把您加入了黑名单" 
					+ " , " + "您不能抢当前货主发的单子" + " , "+"如有疑问请联系货主"+" , " + "联系电话:"+companyVo.getContactMobile());
		}

		// 报价次数限制
		GoodsorderquotationQueryVo quotationQueryVo = new GoodsorderquotationQueryVo();
		quotationQueryVo.setPlatFormId(vo.getPlatformId());
		quotationQueryVo.setPublishId(vo.getPublishId());
		quotationQueryVo.setCompanyId(vo.getCompanyId());
		Long quotationCount = goodsorderquotationService.queryBaojiaCounts(quotationQueryVo);
		Assert.isTrue(quotationCount < Long.valueOf(vo.getBidTimes()), "对不起，您已超过此委托单最高报价次数，不能再次报价！");
		
		// 找出货源单的最低最高价是否发生变化
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
		vo.setGroupId(goodsordermEntity.getGroupId());
		vo.setGroupName(goodsordermEntity.getGroupName());
		if (vo.getOutPrice().compareTo(goodsordermEntity.getMaxPrice()) == 1) {
			vo.setStatus("00");
			webReturnMessage.setSuccess(false);
			webReturnMessage.setMsg("抢单您的报价过高，系统已自动拒绝!");			
		} else if(vo.getOutPrice().compareTo(goodsordermEntity.getFloorPrice()) == -1){
			// 如果该货源单报价类型为自动成交 则低于底价不自动拒绝
			if ("1".equals(vo.getIsAutoToTrans())) {
				vo.setStatus("10");
				webReturnMessage.setSuccess(true);
				webReturnMessage.setMsg("您的报价已发出，请等待委托方确认!");			
			}else{
				vo.setStatus("00");
				webReturnMessage.setSuccess(false);
				webReturnMessage.setMsg("抢单您的报价过低，系统已自动拒绝!");	
			}		
		}else{	
			vo.setStatus("10");
			webReturnMessage.setSuccess(true);
			webReturnMessage.setMsg("您的报价已发出，请等待委托方确认!");
		}
		
		// 保存到报价记录表中 
		GoodsorderquotationEntity quotationEntity = new GoodsorderquotationEntity();
		quotationEntity.setPublishId(vo.getPublishId());
		quotationEntity.setPublishCompanyId(goodsordermEntity.getCompanyId());
		quotationEntity.setWeight(vo.getGrabWeight());
		quotationEntity.setQty(vo.getGrabQty());
		quotationEntity.setAmount(vo.getGrabWeight().multiply(vo.getOutPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));
		quotationEntity.setCreateDate(new Date());
		quotationEntity.setCreatePerson(vo.getUserId());
		quotationEntity.setUpdateDate(new Date());
		quotationEntity.setUpdatePerson(vo.getUserId());
		quotationEntity.setCompanyId(vo.getCompanyId());
		quotationEntity.setCompanyName(vo.getCompanyName());
		quotationEntity.setStatus(vo.getStatus());
		quotationEntity.setPlatFormId(vo.getPlatformId());
		quotationEntity.setPrice(vo.getOutPrice());
		quotationEntity.setOperateType("WEB");
		quotationEntity.setStandardTax(vo.getStandardTax());
		quotationEntity.setPriceTax(vo.getPriceTax());
		quotationEntity.setIfTaxTransport(vo.getIfTaxTransport());
		quotationEntity.setVatFlowMasterId(vo.getVatFlowMasterId());
		quotationEntity.setGroupId(vo.getGroupId());
		quotationEntity.setGroupName(vo.getGroupName()); 
		GoodsorderquotationEntity goodsorderquotationEntity = goodsorderquotationService.save(quotationEntity);
		vo.setQuotationId(goodsorderquotationEntity.getQuotationId());		
	}

	/** 含税价格等信息封装*/
	private void queryTaxTransportInfo(GoodsordermVo vo) {
		logger.info("set tax info");
		BigDecimal outPrcie = vo.getOutPrice();
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
		BigDecimal one = new BigDecimal("1");
		if (null != goodsordermEntity && "Y".equals(goodsordermEntity.getIfTaxTransport())) {
			
			List<VatflowdetailVo> flowList = vatflowdetailService.queryFlowInfo(goodsordermEntity.getCompanyId());
			VatflowdetailVo vatflowdetailVo = null;
			
			if(flowList.size() == 0 || null == flowList){
				Assert.isTrue(false, "该单据是委托承运单据，但找不到此委托承运流程!");
			}else if (flowList.size() > 1){
				Assert.isTrue(false, "该单据是委托承运单据，但存在多个委托承运流程!");
			}else {
				vatflowdetailVo =flowList.get(0);
			}

			String vatRateChose = vatflowdetailVo.getVatRateChose();
			BigDecimal vatStandardRate = vatflowdetailVo.getVatStandardRate();
			BigDecimal vatPolicyRate = vatflowdetailVo.getVatPolicyRate();
			String vatAccType = vatflowdetailVo.getVatAccType();
			// 税率选择(标准税率;政策税率)
			BigDecimal rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
			// 含税价格的计算方式(1表示乘法:price*(1+rate);否则是除法:price/(1-rate))
			BigDecimal priceTax = "1".equals(vatAccType) ? outPrcie.multiply(one.add(rate)).setScale(2, BigDecimal.ROUND_HALF_UP) : 
				outPrcie.divide(one.subtract(rate),2,BigDecimal.ROUND_HALF_UP);			 			
			// 货主含税运费单价抹分
			if ("1".equals(goodsordermEntity.getIfOwnerTaxpriceMf())) {
				priceTax = priceTax.setScale(1, BigDecimal.ROUND_HALF_UP);
			}
			
			vo.setStandardTax(rate);
			vo.setPriceTax(priceTax);
			vo.setIfTaxTransport(goodsordermEntity.getIfTaxTransport());
			vo.setVatFlowMasterId(goodsordermEntity.getVatFlowMasterId());
		}else if (goodsordermEntity != null) {
			BigDecimal taxRate = new BigDecimal(StringFactory.getTaxRate());
			vo.setStandardTax(taxRate);	
			vo.setPriceTax(outPrcie.multiply(one.add(taxRate)));
			vo.setIfTaxTransport("N");
			vo.setVatFlowMasterId(0L);		
		} else {
			throw new RuntimeException("货源单数据异常！");
		}
	}

	/** 根据货源单号查询外部货源信息*/
	private void queryRet(GoodsordermVo vo) {
		logger.info("query goodordermjk info,by publishId:{},platformId",vo.getPublishId(),vo.getPlatformId());
		GoodsordermjkEntity  goodsordermjk = goodsordermjkService.findByPublishIdAndPlatformId(vo.getPublishId(),vo.getPlatformId());
		if(null != goodsordermjk) {
			vo.setBillSenderMobile(goodsordermjk.getBillSenderMobile());
			vo.setRet2(goodsordermjk.getRet2());
		}
	}

	/** 校验是否有抢单资格(未审核或者被冻结)*/
	private Integer checkCompanyStatus(GoodsordermVo vo) {
		logger.info("check if the company can grab order,by companyId:{}",vo.getCompanyId());
		Integer count = companyService.checkCompanyStatus(vo.getPlatformId(),vo.getCompanyId());
		return count;
	}
	

	public  GoodsordermVo getGoodsordermDetail(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm details list,by publishId:{}",vo.getPublishId());
//		Optional<GoodsordermEntity> goodsordermEntity =goodsordermRepository.findByPublishIdAndStatus(vo.getPublishId(),"10");
//		Assert.isTrue(goodsordermEntity.isPresent(),"当前单据状态已变化，请刷新页面重试！");
		return goodsordermRepository.getGoodsordermDetail(vo.getPublishId(),vo.getPlatformId());
	}
	
	@Override
	@Transactional
	public void updateGoodsorderm(GoodsordermVo goodsordermVo) {
		Assert.notNull(goodsordermVo.getPublishId(),"数据异常：请刷新页面!");
		logger.info("update goodsorderm,by publishId",goodsordermVo.getPublishId());
		 if(goodsordermVo.getAppointTeamId() !="" && goodsordermVo.getAppointTeamId() != null && goodsordermVo.getAppointTeamId().indexOf("default")==-1) {
    		 goodsordermVo.setAppointTeamType("2");
    	 }else {
    		 goodsordermVo.setAppointTeamType("1"); //设置为全部组
    	 }
    	 if(goodsordermVo.getIfTaxTransport() ==null || "".equals(goodsordermVo.getIfTaxTransport()) || "N".equals(goodsordermVo.getIfTaxTransport())) {
			 BigDecimal standardTax = new BigDecimal(StringFactory.getTaxRate());
	         BigDecimal priceTax = goodsordermVo.getPrice().add(goodsordermVo.getPrice().multiply(standardTax));
	            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
	            goodsordermVo.setStandardTax(standardTax);
	            goodsordermVo.setPriceTax(priceTax);
	            goodsordermVo.setIfTaxTransport("N");
	            goodsordermVo.setVatFlowMasterId(Long.valueOf(0));	            
		}
		else {
			 setInfo(goodsordermVo);		 
		}
    	CatalogQueryVo catalogQueryVo = new CatalogQueryVo(); 
 		catalogQueryVo.setGoodType(goodsordermVo.getGoodType());
 		catalogQueryVo.setGoodTypeDesc(goodsordermVo.getGoodTypeDesc());
 		catalogQueryVo.setPlatformId(goodsordermVo.getPlatformId());
 		catalogQueryVo.setStatus("20");
 		catalogQueryVo.setLayer("1");
 		CatalogInfoVo catalog = catalogService.queryCatalogIdAndName(catalogQueryVo);
 		Assert.notNull(catalog,"当前单据的货物类型对应的大品种不存在，请先维护!");
 	//	BeanUtils.copyProperties(catalog, goodsordermVo);
 		goodsordermVo.setCatalogId(catalog.getCatalogId());
 		goodsordermVo.setCatalogName(catalog.getCatalogName());
 		GoodsordermEntity  goodsordermEntity = new GoodsordermEntity();
 		goodsordermEntity = goodsordermRepository.findById(goodsordermVo.getPublishId()).get();
 		addNewGoodsordermToEntity(goodsordermVo,goodsordermEntity);
 		goodsordermEntity.setStatus("10");
 		goodsordermRepository.save(goodsordermEntity);
	}

	@Override
	public void setGoodsOrderQuotationRemark(GoodsordermVo vo) {
		logger.info("update GoodsorderquotationEntity's info,by quotationId:{}",vo.getQuotationId());
		GoodsorderquotationEntity quotationEntity = goodsorderquotationService.findById(vo.getQuotationId());
		quotationEntity.setStatus("20");
		quotationEntity.setTransId(vo.getTransId());
		goodsorderquotationService.save(quotationEntity);
	}
	
	/**
	 * 获取编号
	 * @param typeId
	 * @return
	 */
	public String getSeqNum(String typeId) {
		logger.info("call generate_docu_no pro,typeId:{}",typeId);
    	HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("typeId", typeId);
    	propMap.put("seqNum", "");
    	mybatisQuery.executePro("transportSettle.getSeqNumPro", propMap);
    	String seqNum = (String) propMap.get("seqNum"); 
    	logger.info("call generate_docu_no pro,seqNum:{}",seqNum);
		return seqNum;
	}
	
	/**
	 * 计算含税价格
	 * @param typeId
	 * @return
	 */
	@Override
	public void getPriceTax(GoodsordermVo vo) {
		logger.info("calculate the price tax,companyId:{}",vo.getCompanyId());
        // 查询公司流程是否存在(这里根据VO中的companyId)
        List<VatflowdetailEntity> flowList = vatflowdetailService.listByPulishCompanyId(vo.getCompanyId());
        Assert.notNull(flowList , "该单据发布的是委托承运单据，但找不到此委托承运流程");
        Assert.isTrue(flowList.size() <= 1,"该单据发布的是委托承运单据，但存在多个委托承运流程");
        if(flowList != null && flowList.size() > 0) {
        	VatflowdetailEntity flow = flowList.get(0);

            String vatRateChose = flow.getVatRateChose();
            BigDecimal vatStandardRate = flow.getVatStandardRate();
            BigDecimal vatPolicyRate =  flow.getVatPolicyRate();
            String vatAccType = flow.getVatAccType();

            BigDecimal price = vo.getPrice();
            BigDecimal rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
            // 选择乘法
            BigDecimal multipart = price.multiply(new BigDecimal("1").add(rate));
            // 选择除法
            BigDecimal divide = price.divide(new BigDecimal("1").subtract(rate),10,BigDecimal.ROUND_HALF_UP);
            BigDecimal priceTax = "1".equals(vatAccType) ? multipart : divide;
            // 精度
            priceTax = priceTax.setScale(2, BigDecimal.ROUND_HALF_UP);
            vo.setPriceTax(priceTax);
        }
        
	}

	@Override
	public List<VatflowdetailVo> queryTaxRate(VatflowmasterQueryVo vo) {
		logger.info("query flow list,vatcompanyId is:{}",vo.getVatCompanyId());
		return vatflowdetailService.queryTaxRate(vo);
	}

	@Override
	@Transactional
	public void createTransBill(GoodsorderquotationQueryVo vo) {
		logger.info("vat create TransBill,uotationId is:{}",vo.getQuotationId());
		GoodsorderquotationVo goodsorderquotationVo = goodsorderquotationService.getBaojiaInfo(vo);
		goodsorderquotationVo.setPlatFormId(vo.getPlatformId());
		goodsorderquotationVo.setUserId(vo.getUserId());
		goodsorderquotationVo.setConsignorName(vo.getConsignorName());
		grabBillByConsignor(goodsorderquotationVo);
		
	}

	private void grabBillByConsignor(GoodsorderquotationVo vo) {
		
		/**检查可抢单量 checkWeight(vo)*/
		// 获取可抢单量
		GoodsordermVo goodsordermVo = goodsordermRepository.queryIsHas(vo.getPublishId());
		// 可抢单量
		BigDecimal weight = goodsordermVo.getWeight(); 
		// 抢单量
		BigDecimal grabWeight = vo.getGrabWeight();
		if (weight.compareTo(grabWeight) == -1) {
			throw new RuntimeException("对不起，当前货源单量不足，无法生成运输订单！");
		}
		
		// 检查是否还可生成运单: checkGrab()
		int maxBillNum = 2;
		Long result = 0L;	
		
		Integer companyCount = companyService.checkCompanyStatus(vo.getPlatFormId(), vo.getCompanyId());
		if(companyCount != null && companyCount > 0){
			throw new RuntimeException("您的账号还未审核或者被冻结，不能抢单！");
		}	
			
		if ("GS".equals(vo.getUserType())) {
			TransportBillQueryVo transQuery = new TransportBillQueryVo();
			transQuery.setPlatformId(vo.getPlatFormId());
			transQuery.setCompanyId(vo.getCompanyId());
			// 查询待装货的运单数
		//	result = transportationDeliveryService.checkGrab(transQuery);
			result = mybatisQuery.selectOne("goodsorderm.checkGrab",transQuery);

			maxBillNum = 10;		
		} else {	
			result = transportationDeliveryService.checkDriverBill(vo.getPlatFormId(),vo.getCompanyId());
			maxBillNum = 1;
		}
		
		if (result != null && result >= maxBillNum) {
			if("GS".equals(vo.getUserType())){
				Assert.isTrue(false, "您还有"+ maxBillNum +"单运输订单未完成调度,不能抢单！");
			}else{
				Assert.isTrue(false, "您还有"+ maxBillNum +"单调度未完成，不能抢单！");
			}
		}

		// 生成运单
		//createTransBill(vo);
		GoodsordermEntity goodsordermEntity = goodsordermRepository.findById(vo.getPublishId()).get();
		// 更新货源单的数量，金额
		BigDecimal zero = new BigDecimal("0");
		BigDecimal getGrabWeight = vo.getGrabWeight() == null ? zero : vo.getGrabWeight();
		goodsordermEntity.setWeight(goodsordermEntity.getWeight().subtract(getGrabWeight));
		goodsordermEntity.setAmount(goodsordermEntity.getAmount().subtract(getGrabWeight.multiply(goodsordermEntity.getPrice())));
		goodsordermEntity.setQty(goodsordermEntity.getQty().subtract(vo.getGrabQty()));
		// 货物完成重量
		BigDecimal saleWeight = (goodsordermEntity.getSaleWeight() == null ? zero : goodsordermEntity.getSaleWeight()).add(getGrabWeight);
		goodsordermEntity.setSaleWeight(saleWeight);
		// 货物完成金额
		BigDecimal saleAmount = (goodsordermEntity.getSaleAmount()  == null ? 
				zero : goodsordermEntity.getSaleAmount()).add(getGrabWeight.multiply(goodsordermEntity.getPrice()));
		goodsordermEntity.setSaleAmount(saleAmount);
		// 货物完成件数
		BigDecimal saleQty = (goodsordermEntity.getSaleQty() == null ? zero : goodsordermEntity.getSaleQty()).add(vo.getQty() == null ? zero : vo.getQty());
		goodsordermEntity.setSaleQty(saleQty);
		// 备注(控制长度500位限制)
		String remark = goodsordermEntity.getRemark() == null ? "" : goodsordermEntity.getRemark();
		if(remark.length() > 500) {
			remark = remark.substring(remark.length()-500);
		}
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formatDate = sd.format(date);
		remark = remark + formatDate + "被抢单by" + vo.getUserId();
		goodsordermEntity.setRemark(remark);
		goodsordermRepository.save(goodsordermEntity);
		
		TransportationmEntity transEntity = new TransportationmEntity();
		transEntity.setPublishId(goodsordermEntity.getPublishId());
		transEntity.setWeight(vo.getGrabWeight());
		transEntity.setQty(vo.getGrabQty());
		transEntity.setAmount(vo.getGrabWeight().multiply(vo.getOutPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
		transEntity.setCreateDate(new Date());
		transEntity.setCompanyId(vo.getCompanyId());
		transEntity.setStartPlate(goodsordermEntity.getStartPlate());
		transEntity.setEndPlate(goodsordermEntity.getEndPlate());
		transEntity.setGetOrderPlate(goodsordermEntity.getGetOrderPlate());
		transEntity.setCreatePerson(vo.getUserId());
		transEntity.setPlatformId(vo.getPlatFormId());
		transEntity.setCompanyName(vo.getCompanyName());
		transEntity.setProdDesc(goodsordermEntity.getProdDesc());
		transEntity.setPrice(vo.getOutPrice());
		transEntity.setPickupDate(goodsordermEntity.getPickupDate());
		transEntity.setSender(goodsordermEntity.getSender());
		transEntity.setSenderMobile(goodsordermEntity.getSenderMobile());
		transEntity.setReceiver(goodsordermEntity.getReceiver());
		transEntity.setReceiverMobile(goodsordermEntity.getReceiverMobile());
		transEntity.setBillSender(goodsordermEntity.getBillSender());
		transEntity.setBillSenderMobile(goodsordermEntity.getBillSenderMobile());
		transEntity.setBillTaker(goodsordermEntity.getBillTaker());
		transEntity.setBillTakerMobile(goodsordermEntity.getBillTakerMobile());
		transEntity.setInitAmount(vo.getGrabWeight().multiply(vo.getOutPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
		transEntity.setInitQty(vo.getGrabQty());
		transEntity.setInitWeight(vo.getGrabWeight());
		transEntity.setStatus("20");
		transEntity.setDeparture(goodsordermEntity.getDeparture());
		transEntity.setDepartureLng(goodsordermEntity.getDepartureLng());
		transEntity.setDepartureLat(goodsordermEntity.getDepartureLat());
		transEntity.setDestination(goodsordermEntity.getDestination());
		transEntity.setDestinationLng(goodsordermEntity.getDestinationLng());
		transEntity.setDestinationLat(goodsordermEntity.getDestinationLat());
		transEntity.setGetOrderAddress(goodsordermEntity.getGetOrderAddress());
		transEntity.setGetOrderAddressLng(goodsordermEntity.getGetOrderAddressLng());
		transEntity.setGetOrderAddressLat(goodsordermEntity.getGetOrderAddressLat());
		transEntity.setGoodType(goodsordermEntity.getGoodType());
		transEntity.setGoodTypeDesc(goodsordermEntity.getGoodTypeDesc());
		transEntity.setPublishCompanyId(goodsordermEntity.getCompanyId());
		transEntity.setOperateType("WEB");
		transEntity.setUpdateDate(new Date());
		transEntity.setFdUserId(goodsordermEntity.getFdUserId());
		transEntity.setIfCanShow(goodsordermEntity.getIfCanShow());
		transEntity.setUpdatePerson(vo.getUserId());
		transEntity.setPriPublishId(goodsordermEntity.getPriPublishId());
		transEntity.setStandardTax(vo.getStandardTax());
		transEntity.setPriceTax(vo.getPriceTax());
		transEntity.setIfTaxTransport(vo.getIfTaxTransport());
		transEntity.setVatFlowMasterId(vo.getVatFlowMasterId());
		// 流程查找(含税委托承运时)
		if("Y".equals(vo.getIfTaxTransport())) {
			VatflowdetailEntity  vatflowdetailEntity = vatflowdetailService.queryBeginFlow(vo.getVatFlowMasterId());
			transEntity.setCarryCompanyId(vatflowdetailEntity.getVatCarryId());
		}else {
			transEntity.setCarryCompanyId(vo.getCompanyId());
		}
		// 集团信息
		transEntity.setGroupId(goodsordermEntity.getGroupId());
		transEntity.setGroupName(goodsordermEntity.getGroupName());
		// 调价信息
		transEntity.setOwnerAdjustFlag(goodsordermEntity.getOwnerAdjustFlag());
		transEntity.setOwnerAdjustType(goodsordermEntity.getOwnerAdjustType());
		transEntity.setOwnerAdjustAmt(goodsordermEntity.getOwnerAdjustAmt());
		transEntity.setGoodPrice(goodsordermEntity.getGoodPrice());
		transEntity.setLossType(goodsordermEntity.getLossType());
		transEntity.setLossRatio(goodsordermEntity.getLossRatio());
		transEntity.setLossWeight(goodsordermEntity.getLossWeight());
        // 业务流程模式信息
        transEntity.setBusinessMode(goodsordermEntity.getBusinessMode());
        transEntity.setRobDeliveryType(goodsordermEntity.getRobDeliveryType());
		// 保存运单
		TransportationmEntity saveEntity = transportationmService.save(transEntity);
		// 运单ID
		vo.setTransId(saveEntity.getTransId());

		// 处理记录
		GoodsorderexecutelogEntity goodsorderexecutelogEntity = new GoodsorderexecutelogEntity();
		goodsorderexecutelogEntity.setCreateTime(new Date());
		goodsorderexecutelogEntity.setExeDesc("您的货单已被接单，运单号为："+saveEntity.getTransId());
		goodsorderexecutelogEntity.setPublishId(goodsordermEntity.getPublishId());
		goodsOrderExecuteLogService.save(goodsorderexecutelogEntity);
		
		// 短信记录
		ShortmessageEntity shortmessageEntity = new ShortmessageEntity();
		shortmessageEntity.setReceiver(saveEntity.getBillSenderMobile());
		shortmessageEntity.setMessage("您的货物已被" + saveEntity.getCompanyName() + "承运,运单号为:" 
		+ saveEntity.getTransId() + ",运输路线为:从" + saveEntity.getStartPlate() + "到" + saveEntity.getEndPlate());
		shortmessageEntity.setCreateTime(new Date());
		shortmessageEntity.setPlatformId(vo.getPlatFormId());
		shortmessageEntity.setSendType("01");
		shortMessageService.save(shortmessageEntity);	
		
		// 将报价单置为生效状态
		//setGoodsOrderQuotationEffect(param);
		GoodsorderquotationEntity goodsorderquotationEntity = goodsorderquotationService.findById(vo.getQuotationId());
		goodsorderquotationEntity.setStatus("20");
		goodsorderquotationService.save(goodsorderquotationEntity);
		
		// 如果是个人，就自动生成调度单
		if ("GR".equals(vo.getUserType())) {
			// 自己调度给自己
			vo.setDocuSource("0"); 
			// 修改运单重量
			saveEntity.setWeight(saveEntity.getWeight().subtract(vo.getDispatchWeight()));
			saveEntity.setQty(saveEntity.getQty().subtract(vo.getDispatchQty()));
			saveEntity.setAmount(saveEntity.getAmount().subtract(saveEntity.getPrice().multiply(vo.getDispatchWeight())));
			saveEntity.setDeliveryWeight((saveEntity.getDeliveryWeight() == null ? zero : saveEntity.getDeliveryWeight()).add(vo.getDispatchWeight()));
			saveEntity.setDeliveryQty((saveEntity.getDeliveryQty() == null ? zero : saveEntity.getDeliveryQty()).add(vo.getDispatchQty()));
			saveEntity.setDeliveryAmount((saveEntity.getDeliveryAmount() == null ? zero : saveEntity.getDeliveryAmount()).add(saveEntity.getPrice().multiply(vo.getDispatchWeight())));
			transportationmService.save(saveEntity);	
			// 生成调度单
			TransportationDeliveryEntity transportationDelivery =  new TransportationDeliveryEntity(); 
			transportationDelivery.setCreateDate(new Date());
			transportationDelivery.setTransId(vo.getTransId());
			transportationDelivery.setPublishId(vo.getPublishId());
			transportationDelivery.setWeight(vo.getDispatchWeight());
			transportationDelivery.setQty(vo.getDispatchQty());
			transportationDelivery.setAmount(saveEntity.getPrice().multiply(vo.getDispatchWeight().setScale(2, BigDecimal.ROUND_HALF_UP)));
			transportationDelivery.setCompanyId(saveEntity.getCompanyId());
			transportationDelivery.setDriverId(vo.getDriverId());
			transportationDelivery.setVehicleId(vo.getVehicleId());
			transportationDelivery.setCreatePerson(vo.getUserId());
			transportationDelivery.setPlatformId(vo.getPlatFormId());
			transportationDelivery.setStartPlate(saveEntity.getStartPlate());
			transportationDelivery.setEndPlate(saveEntity.getEndPlate());
			transportationDelivery.setGetOrderPlate(saveEntity.getGetOrderPlate());
			transportationDelivery.setBillSender(saveEntity.getBillSender());
			transportationDelivery.setBillSenderMobile(saveEntity.getBillSenderMobile());
			transportationDelivery.setBillTaker(saveEntity.getBillTaker());
			transportationDelivery.setBillTakerMobile(saveEntity.getBillTakerMobile());
			transportationDelivery.setGoodType(saveEntity.getGoodType());
			transportationDelivery.setGoodTypeDesc(saveEntity.getGoodTypeDesc());
			transportationDelivery.setReceiver(saveEntity.getReceiver());
			transportationDelivery.setReceiverMobile(saveEntity.getReceiverMobile());
			transportationDelivery.setSender(saveEntity.getSender());
			transportationDelivery.setSenderMobile(saveEntity.getSenderMobile());
			transportationDelivery.setStatus("10");
			transportationDelivery.setDeparture(saveEntity.getDeparture());
			transportationDelivery.setDepartureLng(Double.valueOf(saveEntity.getDepartureLng().toString()));
			transportationDelivery.setDepartureLat(Double.valueOf(saveEntity.getDepartureLat().toString()));
			transportationDelivery.setDestination(saveEntity.getDestination());
			transportationDelivery.setDestinationLng(Double.valueOf(saveEntity.getDestinationLng().toString()));
			transportationDelivery.setDestinationLat(Double.valueOf(saveEntity.getDestinationLat().toString()));
			transportationDelivery.setGetOrderAddress(saveEntity.getGetOrderAddress());
			transportationDelivery.setGetOrderAddressLng(Double.valueOf(saveEntity.getGetOrderAddressLng().toString()));
			transportationDelivery.setGetOrderAddressLat(Double.valueOf(saveEntity.getGetOrderAddressLat().toString()));
			transportationDelivery.setUpdateDate(new Date());
			transportationDelivery.setUpdatePerson(vo.getUserId());
			transportationDelivery.setPrice(saveEntity.getPrice());
			transportationDelivery.setPublishCompanyId(saveEntity.getPublishCompanyId());
			transportationDelivery.setOperateType("WEB");
			transportationDelivery.setDocuSource(vo.getDocuSource());
			transportationDelivery.setPickupDate(saveEntity.getPickupDate());
			transportationDelivery.setFdUserId(Integer.valueOf(saveEntity.getFdUserId().toString()));
			transportationDelivery.setIfCanShow(saveEntity.getIfCanShow());
			// 保存并返回调度单信息
			TransportationDeliveryEntity saveDeliveryEntity = transportationDeliveryService.save(transportationDelivery);
			
			// 运单上传信息保存
			TransportationdeliveryuploadEntity transportationdeliveryuploadEntity = new TransportationdeliveryuploadEntity();
			transportationdeliveryuploadEntity.setPublishId(saveEntity.getPublishId());
			transportationdeliveryuploadEntity.setTransId(saveEntity.getTransId());
			transportationdeliveryuploadEntity.setDeliveryId(saveDeliveryEntity.getDeliveryId());
			transportationdeliveryuploadEntity.setStatus("10");
			transportationdeliveryuploadEntity.setCreateDate(new Date());
			transportationdeliveryuploadEntity.setCreatePerson(vo.getUserId().toString());
			transportationdeliveryuploadEntity.setIsUploadEc("0");
			transportationdeliveryuploadEntity.setPlatFormId(vo.getPlatFormId());
			transportationdeliveryuploadEntity.setOperateType("WEB");
			transportationdeliveryuploadService.save(transportationdeliveryuploadEntity);
		}
		
		// 发送短信
		ShortmessageEntity shortMessage = new ShortmessageEntity();
		shortMessage.setPlatformId(vo.getPlatFormId());
		shortMessage.setSendType("01");
		shortMessage.setReceiver(vo.getContactMobile());
		shortMessage.setCreateTime(new Date());
		shortMessage.setMessage(vo.getConsignorName() + "将一张运单调度给您，请登录app查看详情！");
		List<GoodsorderquotationVo> messageList = goodsorderquotationService.getOtherBaojiaMessage(vo);
		List<ShortmessageEntity> shortMessageList = new ArrayList<>();
		shortMessageList.add(shortMessage);
		for (GoodsorderquotationVo goodsorderquotationVo : messageList) {
			ShortmessageEntity otherMessage = new ShortmessageEntity();
			otherMessage.setReceiver(goodsorderquotationVo.getReceiver());
			otherMessage.setMessage(goodsorderquotationVo.getMessage());
			otherMessage.setCreateTime(new Date());
			otherMessage.setPlatformId(goodsorderquotationVo.getPlatFormId());
			otherMessage.setSendType(goodsorderquotationVo.getSendType());
			shortMessageList.add(otherMessage);
		}
		shortMessageService.saveList(shortMessageList);
	}

	@Override
	public Page<GoodpricechangelogEntity> getGoodPriceLogPageList(GoodsordermQueryVo vo) {
		logger.info("Query goodsorderm goods’s price page data,publishId:{}",vo.getPublishId());
		return goodpricechangelogService.getGoodPriceLogPageList(vo);
	}
	
	@Override
	public List<GoodsordermadjustdetailVo> lookSxDatilList(GoodsordermQueryVo vo) {
		logger.info("query GoodsordermadjustdetailVo list,publishId is:{}",vo.getPublishId());	
		return goodsordermadjustDetailService.lookSxDatilList(vo);
	}

	@Override
	public void invalidGoodsordermjk(Long importId) {
		GoodsordermjkEntity goodsordermjkEntity  = goodsordermjkService.findById(importId);
		GoodsordermjkLogEntity goodsordermjkLogEntity = new GoodsordermjkLogEntity();
		BeanUtils.copyProperties(goodsordermjkEntity, goodsordermjkLogEntity);
		String batchId = getTimeMillisSequence();
		goodsordermjkLogEntity.setLogBatchId(Integer.valueOf(batchId));
		goodsordermjkLogEntity.setStatus("00");
		goodsordermjkLogEntity.setLogCreateDate(new Date());

		goodsordermjkService.delete(goodsordermjkEntity);
		goodsordermjkLogService.save(goodsordermjkLogEntity);
	}

}
