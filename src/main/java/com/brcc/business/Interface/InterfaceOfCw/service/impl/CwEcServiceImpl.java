package com.brcc.business.Interface.InterfaceOfCw.service.impl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.*;

import com.brcc.business.Interface.InterfaceOfCw.entity.ReInfoEntity;
import com.brcc.business.Interface.InterfaceOfCw.repository.ReInfoRepositorys;
import com.brcc.business.Interface.InterfaceOfCw.vo.*;
import com.brcc.business.basedata.entity.*;
import com.brcc.business.basedata.service.CatalogService;
import com.brcc.business.basedata.service.JkSetplatClient;
import com.brcc.business.basedata.service.SwitchconfigService;
import com.brcc.business.basedata.vo.*;
import com.brcc.business.dispatchorder.service.TransportationDeliveryUploadService;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryDetailVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryQueryVo;
import com.brcc.business.dispatchorder.vo.CWDispatchDeliveryVo;
import com.brcc.business.util.Arith;
import com.brcc.business.util.HttpUtils;
import com.brcc.business.util.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.Interface.InterfaceOfCw.service.CwEcService;
import com.brcc.business.Interface.InterfaceOfCw.vo.CancelBillVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.CancelInfo;
import com.brcc.business.Interface.InterfaceOfCw.vo.DataInfo;
import com.brcc.business.Interface.InterfaceOfCw.vo.GoodsUploadVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.LoginInfo;
import com.brcc.business.Interface.InterfaceOfCw.vo.OutInfo;
import com.brcc.business.Interface.InterfaceOfCw.vo.OutWeightVo;
import com.brcc.business.Interface.InterfaceOfCw.vo.Result;
import com.brcc.business.basedata.service.JsonLogClient;
import com.brcc.business.basedata.service.TeamCompanyService;
import com.brcc.business.basedata.vo.BaseDataForeignQueryVo;
import com.brcc.business.basedata.vo.BaseDataForeignVo;
import com.brcc.business.basedata.vo.GoodsOrdermjkSetplatQueryVo;
import com.brcc.business.basedata.vo.GoodsTypeQueryVo;
import com.brcc.business.basedata.vo.UserQueryVo;
import com.brcc.business.basedata.vo.UserVo;
import com.brcc.business.company.entity.CompanyEntity;
import com.brcc.business.company.service.CompanyService;
import com.brcc.business.flow.service.VatflowmasterService;
import com.brcc.business.flow.vo.VatflowmasterQueryVo;
import com.brcc.business.flow.vo.VatflowmasterVo;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.goodsorderm.vo.GoodsordermQueryVo;
import com.brcc.business.goodsorderm.vo.GoodsordermVo;
import com.brcc.business.goodsordermjk.entity.GoodsordermjkEntity;
import com.brcc.business.goodsordermjk.service.GoodsordermjkService;
import com.brcc.business.transportation.entity.TransportationmEntity;
import com.brcc.business.transportation.service.TransportationmService;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.util.LatLngGetDistance;

import javax.xml.crypto.Data;

@Service
@Transactional
public class CwEcServiceImpl implements CwEcService {
	
	Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	GoodsordermjkService goodsordermjkService;
	
	@Autowired
	GoodsordermService goodsordermService;
	
	@Autowired
	CompanyService companyService;

	@Autowired
	SwitchconfigService switchconfigService;

	@Autowired
	JsonLogClient jsonLogClient;

	@Autowired
    TeamCompanyService teamCompanyService;

	@Autowired
	VatflowmasterService vatflowmasterService;

	@Autowired
	TransportationDeliveryService transportationDeliveryService;

	@Autowired
	TransportationmService transportationmService;
	
	@Autowired
	CatalogService catalogService;

	@Autowired
	ReInfoRepositorys reInfoRepositorys;

	@Autowired
	JkSetplatClient jkSetplatClient;

	@Autowired
	TransportationDeliveryUploadService transportationDeliveryUploadService;

	@Override
	@Transactional
	public Result goodsUpload(GoodsUploadVo vo) {
		Result result = new Result();
		GoodsordermVo GoodsordermVo = null;
		if(chack(vo.getLoginInfo())) {
			List<DataInfo> dataInfo = vo.getDataInfo();
			LoginInfo loginVo = vo.getLoginInfo();
			GoodsOrdermjkSetplatQueryVo queryVo = new GoodsOrdermjkSetplatQueryVo();
			queryVo.setPlatName(loginVo.getPlatName());
			queryVo.setUserName(loginVo.getUserName());
			queryVo.setPassword(loginVo.getPassword());
			List<GoodsOrdermjkSetplatEntity> list2 = jsonLogClient.chack(queryVo);
			//获取批次号
			Integer batchId = jsonLogClient.getBatchId(new UserQueryVo());
			for(DataInfo data:dataInfo) {
				GoodsordermjkEntity entity = change(data,list2.get(0).getId().getTmsPlatformId());
				entity.setBatchId(batchId);
				GoodsordermjkEntity ck = goodsordermjkService.findByRet2AndRet1(entity.getRet2(), entity.getRet1());
				Assert.isNull(ck, data.getDependId()+"dependId已存在！");
				goodsordermjkService.save(entity);
				GoodsordermVo = changePubilsh(data,entity);
				// 发布货源(保存到GoodsOrderM)
				GoodsordermEntity goodsordermEntity = goodsordermService.saveGoodsordermVo(GoodsordermVo);
				goodsordermEntity.setPriPublishId(goodsordermEntity.getPublishId());
				goodsordermService.save(goodsordermEntity);
				// 货源发布编号
				entity.setPublishId(goodsordermEntity.getPublishId());
				entity.setApproveTime(new Date());
				entity.setApproveUserId(entity.getFdUserId().toString());
				entity.setAmount(new BigDecimal(0));
				entity.setWeight(new BigDecimal(0));
				entity.setQty(new BigDecimal(0));
				goodsordermjkService.save(entity);
			}
			result.setOutResult("1");
			result.setOutResultReason("成功");
		}else {
			result.setOutResult("0");
			result.setOutResultReason("用户信息错误！");
		}
		return result;
	}

	@Override
	public Result outWeight(OutWeightVo vo) {
		Result result = new Result();
		List<DependForDsWeightjkEntity> outEntity=new ArrayList<DependForDsWeightjkEntity>();
		if(chack(vo.getLoginInfo())) {
			List<OutInfo> list =  vo.getOutInfo();
			//获取批次号
			Integer batchId = jsonLogClient.getOutBatchId(new UserQueryVo());
			for(int i=0;i<list.size();i++) {
				OutInfo outInfo =list.get(i);
				//封装数据
				DependForDsWeightjkEntity entity = outVoToEntity(outInfo);
				entity.setBatchId(batchId.longValue());
				//保存数据
				entity = jsonLogClient.saveOutWeightInfo(entity);
				outEntity.add(i,entity);
			}
			result.setOutResult("1");
			result.setOutResultReason("成功");
			for(int i=0;i<list.size();i++) {
				OutInfo outInfo =list.get(i);
				DependForDsWeightjkEntity entity = outEntity.get(i);
				//修改调度单
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(outInfo.getDeliveryId());
				if(null != deliveryEntity) {
					deliveryEntity.setRemark("U11接口更新");
					//返单次数
					if(null != deliveryEntity.getTruckLoadingWeight() && deliveryEntity.getTruckLoadingWeight() != outInfo.getOutWeight()) {
						if(deliveryEntity.getTruckLoadingWeight().compareTo(new BigDecimal(0)) != 0) {
							deliveryEntity.setReturnNum(deliveryEntity.getReturnNum()+1);
						}
					}
					deliveryEntity.setTruckLoadingWeight(outInfo.getOutWeight());
					//状态修改
					String statusOld =deliveryEntity.getStatus();
					if(("10".equals(statusOld) || "20".equals(statusOld)) && (outInfo.getOutWeight().compareTo(new BigDecimal(0)) != 0)) {
						deliveryEntity.setStatus("30");
					}
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(outInfo.getOutTime());
					} catch (ParseException e) {
						date=new Date();
						e.printStackTrace();
					}
					deliveryEntity.setDeliveryTime(date);
					deliveryEntity.setZcSureDate(date);
					entity.setResult("1");
					entity.setResultReason("已找到此记录，做更新！");
				}else {
					entity.setResult("0");
					entity.setResultReason("没有找到此记录，不做更新！");
				}
				transportationDeliveryService.save(deliveryEntity);
				jsonLogClient.saveOutWeightInfo(entity);
			}
		}else {
			result.setOutResult("0");
			result.setOutResultReason("用户信息错误！");
		}
		return result;
	}

	@Override
	@Transactional
	public void dispatchToCWEcTask() {
		SwitchconfigQueryVo switchconfigQueryVo=new SwitchconfigQueryVo();
		switchconfigQueryVo.setSwitchType("CW_DELIVERY_UPLOAD");
		//查询开关配置表SwitchConfig
		List<SwitchconfigEntity> list=switchconfigService.queryList(switchconfigQueryVo);
		for (int i = 0; i < list.size(); i++) {
			SwitchconfigEntity switchconfigEntity = list.get(i);
			String ecPlatName=switchconfigEntity.getParamValue2();
			//根据域名查询平台接口配置表GoodsOrdermjkSetplat
			List<GoodsOrdermjkSetplatEntity> jksetplatList=jkSetplatClient.getConfigCW(ecPlatName);
			if (jksetplatList!=null && jksetplatList.size()>0){
				GoodsOrdermjkSetplatEntity jksetplatEntity= jksetplatList.get(0);
				String switchValue = switchconfigEntity.getSwitchValue();
				if ("1".equals(switchValue)) {		//开关开启
					dispatchToCWEc(switchconfigEntity,jksetplatEntity);
				}
			}

		}
	}

	@Override
	@Transactional
	public void reinfotocwTask() {
		SwitchconfigQueryVo switchconfigQueryVo=new SwitchconfigQueryVo();
		switchconfigQueryVo.setSwitchType("CW_REINFO_UPLOAD");
		//查询开关配置表SwitchConfig
		List<SwitchconfigEntity> list=switchconfigService.queryList(switchconfigQueryVo);
		for (int i = 0; i < list.size(); i++) {
			SwitchconfigEntity switchconfigEntity = list.get(i);
			String ecPlatName=switchconfigEntity.getParamValue2();
			//根据域名查询平台接口配置表GoodsOrdermjkSetplat
			List<GoodsOrdermjkSetplatEntity> jksetplatList=jkSetplatClient.getConfigCW(ecPlatName);
			if (jksetplatList!=null && jksetplatList.size()>0){
				GoodsOrdermjkSetplatEntity jksetplatEntity= jksetplatList.get(0);
				String switchValue = switchconfigEntity.getSwitchValue();
				if ("1".equals(switchValue)) {		//开关开启
					reinfotocw(switchconfigEntity,jksetplatEntity);
				}
			}

		}
	}


	public void dispatchToCWEc(SwitchconfigEntity switchconfigEntity,GoodsOrdermjkSetplatEntity jksetplatEntity){

		//川威电商调度单下发查询(主单参数封装)
		CWDispatchDeliveryQueryVo queryVo=new CWDispatchDeliveryQueryVo();
		queryVo.setPlatformId(switchconfigEntity.getPlatFormId());
		queryVo.setDsPlatName(switchconfigEntity.getParamValue2());
		queryVo.setDsPlatJk(switchconfigEntity.getParamValue3());
		//川威电商调度单下发查询(主单)
		List<CWDispatchDeliveryVo> uploadList=transportationDeliveryUploadService.queryDispatch(queryVo);

		if(uploadList!=null && uploadList.size()>0){
			for (int j = 0; j < uploadList.size(); j++) {
				CWDispatchDeliveryVo cWDispatchDeliveryVo=uploadList.get(j);

				//川威电商调度单下发查询(子单参数封装)
				CWDispatchDeliveryDetailQueryVo detailQueryVo=new CWDispatchDeliveryDetailQueryVo();
				detailQueryVo.setPlatformId(switchconfigEntity.getPlatFormId());
				detailQueryVo.setDsPlatName(switchconfigEntity.getParamValue2());
				detailQueryVo.setDsPlatJk(switchconfigEntity.getParamValue3());
				//根据拼单号查询子单
				detailQueryVo.setPinDanNum(cWDispatchDeliveryVo.getPinDanNum());
				//川威电商调度单下发查询(子单)
				List<CWDispatchDeliveryDetailVo> uploadDetailList=transportationDeliveryUploadService.queryDispatchDetail(detailQueryVo);

				//组装要发送的数据
				DeliveryDispatchVo deliveryDispatchVo=new DeliveryDispatchVo();
				//1 验证数据信息
				LoginInfo loginInfo=new LoginInfo();
				loginInfo.setPlatName(jksetplatEntity.getEcPlatName());
				loginInfo.setUserName(jksetplatEntity.getUserName());
				loginInfo.setPassword(jksetplatEntity.getPassword());
				deliveryDispatchVo.setLoginInfo(loginInfo);
				//2 业务数据信息
				cWDispatchDeliveryVo.setDataDetail(uploadDetailList);
				List<CWDispatchDeliveryVo> dataInfo=new ArrayList<CWDispatchDeliveryVo>();
				dataInfo.add(cWDispatchDeliveryVo);
				deliveryDispatchVo.setDataInfo(dataInfo);

				//对象转化为json数据
				ObjectMapper mapper =new ObjectMapper();
				String jsonStr = "";
				try {
					jsonStr = mapper.writeValueAsString(deliveryDispatchVo);
				} catch (JsonProcessingException e) {
					logger.info("数据转换异常");
					e.printStackTrace();
				}

				//向川威电商发送请求
				HttpUtils utils=new HttpUtils();
				String url = switchconfigEntity.getParamValue3();
				String resultStr="";
				try {
					logger.info("url="+url);
					logger.info("jsonStr="+jsonStr);
					resultStr=utils.postJson(url,jsonStr);
					//resultStr="{\"outResult\":\"1\",\"outResultReason\":\"成功\"}";
				} catch (Exception e) {
					logger.info("请求超时");
					e.printStackTrace();
				}
				logger.info("resultStr="+resultStr);

				if(resultStr!=null && !"".equals(resultStr)){
					Result result= JSON.parseObject(resultStr,Result.class);
					if("1".equals(result.outResult)){
						transportationDeliveryUploadService.updateUploadEc("1",result.getOutResultReason(),cWDispatchDeliveryVo.getUploadId().toString());
						for (int k = 0; k < uploadDetailList.size(); k++) {
							transportationDeliveryUploadService.updateUploadEc("1",result.getOutResultReason(),uploadDetailList.get(k).getUploadId().toString());
						}
						logger.info("调度单上传成功（川威）");
					}else{
						transportationDeliveryUploadService.updateUploadEc("-1",result.getOutResultReason(),cWDispatchDeliveryVo.getUploadId().toString());
						for (int k = 0; k < uploadDetailList.size(); k++) {
							transportationDeliveryUploadService.updateUploadEc("-1",result.getOutResultReason(),uploadDetailList.get(k).getUploadId().toString());
						}
						logger.info("调度单上传失败（川威）outResultReason="+result.outResultReason);
					}
				}else{
					logger.info("未接收到响应数据");
					logger.info("resultStr="+resultStr+",jsonStr="+jsonStr);
				}
			}

		}else{
			logger.info("未查询到上传川威的调度单");
		}
	}



	/**
	 * 封装Goodsordermjk数据
	 * @param vo 封装的接收类
	 * @return
	 */
	private GoodsordermjkEntity change(DataInfo data,String platformId) {
		String cityName=null;
		String provinceName=null;
		BaseDataForeignVo basedata =null;
		//获取发单userId和公司ID
		UserQueryVo userQuery = new UserQueryVo();
		userQuery.setInterCode(data.getInterCode());
		userQuery.setPlatformId(platformId);
		UserVo userVo = jsonLogClient.queryFdUserInfo(userQuery);
		Assert.notNull(userVo,"该货主不存在");
		//封装Goodsordermjk数据
		GoodsordermjkEntity entity = new GoodsordermjkEntity();
		entity.setCreateDate(new Date());
		entity.setWeight(data.getWeight());
		entity.setQty(data.getQty());
		entity.setRobDeliveryType("1");
		entity.setBusinessMode("2");
		if(StringUtils.isNotEmpty(data.getIfPartition())) {
			if("Y".equals(data.getIfPartition())){
				entity.setDetachable("1");
			}else {
				entity.setDetachable("0");
			}
		}
		//取单地信息
		basedata = this.getCityName(data.getGetOrderCountry());
		entity.setGetOrderPlateCountry(basedata.getCountryName());
		cityName = basedata.getCityName();
		provinceName = this.getProvinceName(cityName);
		entity.setGetOrderPlateCity(cityName);
		entity.setGetOrderPlateProvince(provinceName);
		entity.setGetOrderPlate(provinceName+cityName+basedata.getCountryName()+data.getGetOrderPlate());
		entity.setGetOrderPlateLat(basedata.getCityLat().toString());
		entity.setGetOrderPlateLng(basedata.getCityLng().toString());
		//装货地信息
		basedata = this.getCityName(data.getLoadingAddrCountry());
		entity.setStartPlateCountry(basedata.getCountryName());
		cityName = basedata.getCityName();
		provinceName = this.getProvinceName(cityName);
		entity.setStartPlateCity(cityName);
		entity.setStartPlateProvince(provinceName);
		entity.setStartPlate(provinceName+cityName+basedata.getCountryName()+data.getStartPlate());
		entity.setStartPlateLat(basedata.getCityLat().toString());
		entity.setStartPlateLng(basedata.getCityLng().toString());
		entity.setAmount(data.getWeight().multiply(data.getDsTransportPrice()));
		entity.setStatus("20");
		entity.setLimitTime(data.getLimitTime().toString());
		entity.setDependNum(data.getDependNum());
		entity.setDependNum2(data.getDependId());
		entity.setSender(data.getSender());
		entity.setSenderMobile(data.getSenderMobile());
		//货物类型id
		GoodsTypeQueryVo goodsQueryVo= new GoodsTypeQueryVo();
		goodsQueryVo.setPlatformId(platformId);
		goodsQueryVo.setGoodsTypeDesc(data.getGoodTypeDesc());
		CatalogEntity goodsType = jsonLogClient.queryGoodsType(goodsQueryVo);
		Assert.notNull(goodsType,"该货物类型不存在，请通知物泊物流维护此品种！");
		entity.setGoodType(goodsType.getId());
		entity.setGoodTypeDesc(data.getGoodTypeDesc());
		//品种大类
		CatalogQueryVo queryVo = new CatalogQueryVo();
		queryVo.setGoodType(goodsType.getId());
		queryVo.setPlatformId(platformId);
		CatalogInfoVo catalog = catalogService.getCatalogInfo(queryVo);
		Assert.notNull(catalog,"该货物类型大类不存在，请通知物泊物流维护此品种大类！");
		entity.setCatalogName(catalog.getName());
		entity.setCatalogId(catalog.getId());
		entity.setFromType("JK_U11");
		entity.setRet1(data.getPlatName());
		entity.setRet2(data.getDependNum());
		entity.setBillSender(data.getBillSender());
		entity.setBillSenderMobile(data.getBillSenderMobile());
		entity.setProdDesc(data.getProdDesc());
		entity.setPlatformId(platformId);
		entity.setFdUserId(userVo.getFdUserId());
		entity.setCompanyId(userVo.getCompanyId());
		if(null != userVo.getGroupId()) {
			entity.setGroupId(userVo.getGroupId());
			entity.setGroupName(userVo.getGroupName());
		}
		entity.setIfCanShow("Y");
		entity.setIfInfoComplete("N");
		entity.setLogisticsMark("X");
		entity.setBillTaker(data.getBillTaker());
		entity.setBillTakerMobile(data.getBillTakerMobile());
		//收货地信息
		basedata = this.getCityName(data.getDsCountryName());
		entity.setEndPlateCountry(basedata.getCountryName());
		cityName = basedata.getCityName();
		provinceName = this.getProvinceName(cityName);
		entity.setEndPlateCity(cityName);
		entity.setEndPlateProvince(provinceName);
		entity.setEndPlate(provinceName+cityName+basedata.getCountryName()+data.getDsAddress());
		entity.setEndPlateAddress(provinceName+cityName+basedata.getCountryName()+data.getDsAddress());
		BaseDataForeignVo baseDataForeignVo = getCity(data.getDsCountryName());
		entity.setEndPlateLat(baseDataForeignVo.getCityLat().toString());
		entity.setEndPlateLng(baseDataForeignVo.getCityLng().toString());
		entity.setPrice(data.getDsTransportPrice());
		entity.setGoodPrice(data.getDsGoodsPrice());
		entity.setRemark(data.getRemark());
		entity.setReceiver(data.getReceiver());
		entity.setReceiverMobile(data.getReceiverMobile());
		entity.setIfTaxTransport(data.getIfTaxTransport());
		entity.setTakeGoodsType(data.getTakeGoodsType());
		entity.setInterCode(data.getInterCode());
		return entity;
	}
	/**
	 * 封装货源单数据
	 * @param vo 封装的接收类
	 * @return
	 */
	private GoodsordermVo changePubilsh(DataInfo data,GoodsordermjkEntity jkEntity) {
		GoodsordermVo goodsordermVo = new GoodsordermVo();
		BeanUtils.copyProperties(jkEntity, goodsordermVo);
		// 总价
		goodsordermVo.setAmount(jkEntity.getAmount());
		//货源单为有效状态
		goodsordermVo.setStatus("20");
		goodsordermVo.setPrice(jkEntity.getPrice());
		goodsordermVo.setCreateDate(new Date());
		//业务类型
		goodsordermVo.setLogisticsMark(jkEntity.getLogisticsMark());
		//电商采购的单据号 (电商采购的单据都是使用ret_2作为单据号)
		goodsordermVo.setDependNum(jkEntity.getRet2());
		goodsordermVo.setDependNum2(jkEntity.getDependNum2());
		// 含税价
//		if(vo.getPriceTax()!=null) {
//			goodsordermVo.setPriceTax(vo.getPriceTax());
//		}
		// 设置发单人id
		goodsordermVo.setUserId(jkEntity.getFdUserId());
		// 平台id
		goodsordermVo.setPlatformId(jkEntity.getPlatformId());
		// 委托人、收货人信息
		if(StringUtils.isNotEmpty(data.getBillTaker())) {    	
			goodsordermVo.setBillTaker(data.getBillTaker());
		}
		if(StringUtils.isNotEmpty(data.getBillTakerMobile())) { 
		    goodsordermVo.setBillTakerMobile(data.getBillTakerMobile());	
		}
		if(StringUtils.isNotEmpty(data.getReceiver())) { 
		    goodsordermVo.setBillTaker(data.getReceiver());	
		}
		if(StringUtils.isNotEmpty(data.getReceiverMobile())) { 
		    goodsordermVo.setReceiverMobile(data.getReceiverMobile());
		}
		// 装货地{"address":"山西省临汾市曲沃县立恒西门","lngLat":{"lng":111.527041,"lat":35.704201}}
		String startPlate = jkEntity.getStartPlate() == null ?  "" : jkEntity.getStartPlate();
		String startPlateLng = jkEntity.getStartPlateLng() == null ?  "" : jkEntity.getStartPlateLng();
		String startPlateLat = jkEntity.getStartPlateLat() == null ?  "" : jkEntity.getStartPlateLat();
		goodsordermVo.setDeparture("{\"address\":\""+ startPlate +"\",\"lngLat\":{\"lng\":"+ startPlateLng +",\"lat\":"+ startPlateLat +"}}");
		goodsordermVo.setDepartureLng(new BigDecimal(jkEntity.getStartPlateLng()));
		goodsordermVo.setDepartureLat(new BigDecimal(jkEntity.getStartPlateLat()));
		// 目的地
		String endPlate = jkEntity.getEndPlate() == null ?  "" : jkEntity.getEndPlate();
		String endPlateLng = jkEntity.getEndPlateLng() == null ?  "" : jkEntity.getEndPlateLng();
		String endPlateLat = jkEntity.getEndPlateLat() == null ?  "" : jkEntity.getEndPlateLat();
		goodsordermVo.setDestination("{\"address\":\""+ endPlate +"\",\"lngLat\":{\"lng\":"+ endPlateLng +",\"lat\":"+ endPlateLat +"}}");
		goodsordermVo.setDestinationLng(new BigDecimal(jkEntity.getEndPlateLng()));
		goodsordermVo.setDestinationLat(new BigDecimal(jkEntity.getEndPlateLat()));
		// 取单地
		String getOrderPlate = jkEntity.getGetOrderPlate() == null ?  "" : jkEntity.getGetOrderPlate();
		String getOrderPlateLng = jkEntity.getGetOrderPlateLng() == null ?  "" : jkEntity.getGetOrderPlateLng();
		String getOrderPlateLat = jkEntity.getGetOrderPlateLat() == null ?  "" : jkEntity.getGetOrderPlateLat();
		goodsordermVo.setGetOrderAddress("{\"address\":\""+ getOrderPlate +"\",\"lngLat\":{\"lng\":"+ getOrderPlateLng +",\"lat\":"+ getOrderPlateLat +"}}");
		goodsordermVo.setGetOrderAddressLng(new BigDecimal(jkEntity.getGetOrderPlateLng()));
		goodsordermVo.setGetOrderAddressLat(new BigDecimal(jkEntity.getGetOrderPlateLat()));
		// 推送距离
		goodsordermVo.setSendKM(10000);
		// 1为可拆单，0为不可拆单
		if(StringUtils.isNotEmpty(data.getIfPartition())) {
			if("Y".equals(data.getIfPartition())){
				goodsordermVo.setDetachable("1");
			}else {
				goodsordermVo.setDetachable("0");
			}
		}
		// 单据有效时间
		if(null != data.getLimitTime() && data.getLimitTime() > 0) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.add(calendar.HOUR, data.getLimitTime());
		    calendar.set(calendar.MINUTE, 0);
		    calendar.set(calendar.SECOND, 0);
		    goodsordermVo.setPickupDate(calendar.getTime());
		}else {
		    // 默认单据有效时间,第二天7点整
		    Calendar calendar = Calendar.getInstance();
		    calendar.add(calendar.DATE, 1);
		    calendar.set(calendar.HOUR_OF_DAY, 7);
		    calendar.set(calendar.MINUTE, 0);
		    calendar.set(calendar.SECOND, 0);
		    goodsordermVo.setPickupDate(calendar.getTime());
		}

		goodsordermVo.setInitQty(jkEntity.getQty());
		//初始金额
		goodsordermVo.setInitAmount(jkEntity.getAmount());
		goodsordermVo.setInitWeight(jkEntity.getWeight());
		//发单的公司id
		goodsordermVo.setCompanyId(jkEntity.getCompanyId());
		// 发送群组(APP,WEB,ALL)
		goodsordermVo.setSendGroup("ALL");	
		goodsordermVo.setQbType("0");
		goodsordermVo.setIfCanShow("Y");
		// 底价
		goodsordermVo.setFloorPrice(jkEntity.getPrice());
		// 最高价
		goodsordermVo.setMaxPrice(jkEntity.getPrice());
		//获取经纪人公司ID
		UserQueryVo userQuery = new UserQueryVo();
		userQuery.setInterCode(data.getappointCompanyCode());
		userQuery.setPlatformId(jkEntity.getPlatformId());
		UserVo userVo = jsonLogClient.queryFdUserInfo(userQuery);
		Assert.notNull(userVo,"该经纪人不存在");
		//获取货主parent_company_ID
		CompanyEntity company1=companyService.findCompanyById(jkEntity.getCompanyId());
		TeamCompanyEntity teamCompany = teamCompanyService.findTeamId(userVo.getCompanyId().intValue(), company1.getParentCompanyId().intValue(), jkEntity.getPlatformId());
		Assert.notNull(teamCompany,"货主未审核该经纪人");
		CompanyEntity company=companyService.findCompanyById(userVo.getCompanyId());
		// 定向承运名称
		if(StringUtils.isNotEmpty(company.getCompanyName())) {
			goodsordermVo.setAppointPersonInfo(company.getCompanyName());
		}
		goodsordermVo.setAppointTeamId(teamCompany.getTeamId());
		goodsordermVo.setAppointTeamName(teamCompany.getTeamName());
		// 默认1为不定向,其他为定向,不能为NULL, 2定向
		goodsordermVo.setAppointTeamType("2");
		// 单据来源
		goodsordermVo.setFromType(jkEntity.getFromType());
		double estimateKM = LatLngGetDistance.getDistanceActual(Double.parseDouble(jkEntity.getStartPlateLat()),Double.parseDouble(jkEntity.getEndPlateLat()),
				Double.parseDouble(jkEntity.getStartPlateLng()), Double.parseDouble(jkEntity.getEndPlateLng()));
		// 预计里程
		goodsordermVo.setEstimateKM(new BigDecimal(estimateKM));
		if(StringUtils.isNotEmpty(data.getLossType())){
		    goodsordermVo.setLossType(data.getLossType());
		}
		if(data.getLossRatio()!=null){
			goodsordermVo.setLossRatio(data.getLossRatio());
		}
		if(data.getLossWeight()!=null){
			goodsordermVo.setLossWeight(data.getLossWeight());
		}
		//提货名称
//		goodsordermVo.setPickUpGoodsName(vo.getPickUpGoodsName());
		// 货物信息
		if(null != jkEntity.getCatalogId()) {
			goodsordermVo.setCatalogId( jkEntity.getCatalogId());
		}
		if(StringUtils.isNotEmpty(jkEntity.getCatalogName())) {
			goodsordermVo.setCatalogName( jkEntity.getCatalogName());
		}
		// 备注
		goodsordermVo.setPs(jkEntity.getRemark());
		goodsordermVo.setHeavyPiece(new BigDecimal("0"));
		// 定向承运人（组）信息
		goodsordermVo.setAppointPersonInfo(teamCompany.getTeamName());
		// 集团信息
		goodsordermVo.setGroupId(jkEntity.getGroupId());
		goodsordermVo.setGroupName(jkEntity.getGroupName());
		// 流程id
		GoodsordermQueryVo qvo=new GoodsordermQueryVo();
		qvo.setCompanyId(jkEntity.getCompanyId());
		VatflowmasterVo vatflowVo = vatflowmasterService.findVatflowmasterByCompanyId(qvo).getContent().get(0);
		goodsordermVo.setVatFlowMasterId(vatflowVo.getVatFlowMasterId());
		String vatRateChose, vatAccType;
		BigDecimal vatStandardRate, vatPolicyRate, rate, price, priceTax;
    	vatRateChose = vatflowVo.getVatRateChose();
    	vatAccType = vatflowVo.getVatAccType();
    	vatStandardRate = vatflowVo.getVatStandardRate();
    	vatPolicyRate = vatflowVo.getVatPolicyRate();
    	// 不含税价
    	price = goodsordermVo.getPrice();
    	// 税率
        rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
        // 含税价
        priceTax = "1".equals(vatAccType) ? (new BigDecimal(1).add(rate)).multiply(price) : price.divide((new BigDecimal(1).subtract(rate)), 2, BigDecimal.ROUND_HALF_UP);
        priceTax = Arith.round(priceTax, 2);
        goodsordermVo.setPriceTax(priceTax);
		//是否含税
		goodsordermVo.setIfTaxTransport(data.getIfTaxTransport());
		goodsordermVo.setIfPartition(data.getIfPartition());
		if(StringUtils.isNotEmpty(jkEntity.getRet1())) {
			// 单据来源域名
			goodsordermVo.setFromPlatName(jkEntity.getRet1());
		}
		// docu_type(单据类型，1为双程单，0或空为单程单,2表示多单)
		goodsordermVo.setDocuType("0");
		// Beanutils copy的原因,清空货源单id防止一直在做更新
		goodsordermVo.setPublishId(null);
		goodsordermVo.setStartTakeDeliveryDate(null);
		goodsordermVo.setUpdateDate(null);
		// 抢单or报价
		goodsordermVo.setQbType("0");
		goodsordermVo.setRobDeliveryType(jkEntity.getRobDeliveryType());
		goodsordermVo.setBusinessMode(jkEntity.getBusinessMode());
		if(StringUtils.isNotEmpty(data.getIfPartition())) {
			if("Y".equals(data.getIfPartition())){
				goodsordermVo.setDetachable("1");
			}else {
				goodsordermVo.setDetachable("0");
			}
		}
		return goodsordermVo;
	}
	/**
	 * 校验用户信息
	 * @param vo 封装的接收类
	 * @return
	 */
	private boolean chack(LoginInfo vo) {
		boolean flag = true;
		GoodsOrdermjkSetplatQueryVo queryVo = new GoodsOrdermjkSetplatQueryVo();
		queryVo.setPlatName(vo.getPlatName());
		queryVo.setUserName(vo.getUserName());
		queryVo.setPassword(vo.getPassword());
		List<GoodsOrdermjkSetplatEntity> list = jsonLogClient.chack(queryVo);
		if(list == null || list.size()==0) {
			flag = false;
		}
		return flag;
	}
	/**
	 * 获取经纬度
	 * @param vo 封装的接收类
	 * @return
	 */
	private BaseDataForeignVo getCity(String address) {
		BaseDataForeignQueryVo vo = new BaseDataForeignQueryVo();
		vo.setDataName(address);
		List<BaseDataForeignVo> basedata = jsonLogClient.getCity(vo);
		Assert.isTrue(basedata.size()!=0,"不存在"+address+"该地址");
		Assert.isTrue(basedata.size()==1,"有多个"+address+"该地址，请确认详细");
		return basedata.get(0);
	}
	/**
	 * 获取市
	 * @param vo 封装的接收类
	 * @return
	 */
	private BaseDataForeignVo getCityName(String address) {
		BaseDataForeignQueryVo vo = new BaseDataForeignQueryVo();
		vo.setDataName(address);
		List<BaseDataForeignVo> basedata = jsonLogClient.getCity(vo);
		Assert.isTrue(basedata.size()!=0,"不存在"+address+"该地址");
		Assert.isTrue(basedata.size()==1,"有多个"+address+"该地址，请确认详细");
		return basedata.get(0);
	}
	/**
	 * 获取省
	 * @param vo 封装的接收类
	 * @return
	 */
	private String getProvinceName(String address) {
		BaseDataForeignQueryVo vo = new BaseDataForeignQueryVo();
		vo.setCityName(address);
		return jsonLogClient.getProvinceName(vo).getProvinceName();
	}
	private DependForDsWeightjkEntity outVoToEntity(OutInfo vo) {
		DependForDsWeightjkEntity entity = new DependForDsWeightjkEntity();
		entity.setCreateDate(new Date());
		entity.setDependId(vo.getDependId());
		entity.setDependNum(vo.getDependId());
		entity.setDsPlatName(vo.getDsPlatName());
		entity.setOutWeight(vo.getOutWeight());
		entity.setRet3(vo.getDeliveryId().toString());
		return entity;
	}

	@Override
	public Result cancelBill(CancelBillVo vo) {
		Result result = new Result();
		if(chack(vo.getLoginInfo())) {
			CancelInfo canVo = vo.getCancelInfo();
			//撤销方式， 0按拼单撤销，1按调度单撤销
			if("1".equals(canVo.getCancelType())) {
				//获取调度单
				TransportationDeliveryEntity entity = transportationDeliveryService.findById(canVo.getDeliveryId());
				if(null != entity) {
					if(!"90".equals(entity.getStatus()) && !"00".equals(entity.getStatus())) {
						TransportationmEntity ysEntity = transportationmService.findById(entity.getTransId());
						entity.setStatus("00");
						BigDecimal weight = ysEntity.getWeight().add(entity.getWeight());
						BigDecimal amount = ysEntity.getAmount().add(entity.getAmount());
						ysEntity.setAmount(amount);
						ysEntity.setWeight(weight);
						transportationDeliveryService.save(entity);
						transportationmService.save(ysEntity);
						result.setOutResult("1");
						result.setOutResultReason("撤销成功！");
					}else {
						result.setOutResult("0");
						result.setOutResultReason("该调度单已完成运输或已作废！");
					}
				}else {
					result.setOutResult("0");
					result.setOutResultReason("未找到该调度单！");
				}
			}else {
				//获取调度单
				List<TransportationDeliveryEntity> list = transportationDeliveryService.findAllBySpellListNum(canVo.getPinDanNum());
				boolean flag=true;
				if(null != list) {
					for(TransportationDeliveryEntity entity:list) {
						if(!"90".equals(entity.getStatus()) && !"00".equals(entity.getStatus())) {
							TransportationmEntity ysEntity = transportationmService.findById(entity.getTransId());
							entity.setStatus("00");
							BigDecimal weight = ysEntity.getWeight().add(entity.getWeight());
							BigDecimal amount = ysEntity.getAmount().add(entity.getAmount());
							ysEntity.setAmount(amount);
							ysEntity.setWeight(weight);
							transportationDeliveryService.save(entity);
							transportationmService.save(ysEntity);
						}else {
							flag=false;
							break;
						}
					}
					if(flag) {
						result.setOutResult("1");
						result.setOutResultReason("撤销成功！");
					}else {
						result.setOutResult("0");
						result.setOutResultReason("该拼单已完成运输或已作废！");
					}
				}else {
					result.setOutResult("0");
					result.setOutResultReason("未找到该拼单的调度单！");
				}
			}
		}else {
			result.setOutResult("0");
			result.setOutResultReason("用户信息错误！");
		}
		return result;
	}


	public void reinfotocw(SwitchconfigEntity switchconfigEntity,GoodsOrdermjkSetplatEntity jksetplatEntity){
        //确认收货信息回传
        CWDispatchDeliveryQueryVo queryVo=new CWDispatchDeliveryQueryVo();
        queryVo.setPlatformId(switchconfigEntity.getPlatFormId());
        queryVo.setDsPlatName(switchconfigEntity.getParamValue2());
        queryVo.setDsPlatJk(switchconfigEntity.getParamValue3());

        //把date转成以下格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        reInfoRepositorys.updatereinfotocwbefore();
		String ecPlatName = switchconfigEntity.getParamValue2();
		System.out.println("----------------");
		List<ReInfoEntity> reinfotocw=reInfoRepositorys.reinfotocw(ecPlatName);
        List reInfoToCw= new ArrayList<>();
        if(reinfotocw!=null&&reinfotocw.size()>0){
            for (int i = 0; i <reinfotocw.size() ; i++) {
                Map map=new LinkedHashMap();
                map.put("deliveryId",reinfotocw.get(i).getDeliveryId());
                map.put("lng",reinfotocw.get(i).getLng());
                map.put("lat",reinfotocw.get(i).getLat());
                map.put("address",reinfotocw.get(i).getAddress());
                map.put("arriveTime",sdf.format(reinfotocw.get(i).getArriveTime()));
                map.put("imageAddress",reinfotocw.get(i).getImageAddress());
                reInfoToCw.add(i,map);

            }
            //组装要发送的数据
            DeliveryDispatchVo deliveryDispatchVo=new DeliveryDispatchVo();
            //1 验证数据信息
            LoginInfo loginInfo=new LoginInfo();
            loginInfo.setPlatName(jksetplatEntity.getEcPlatName());
            loginInfo.setUserName(jksetplatEntity.getUserName());
            loginInfo.setPassword(jksetplatEntity.getPassword());
            deliveryDispatchVo.setLoginInfo(loginInfo);

            deliveryDispatchVo.setDataInfo(reInfoToCw);

            //对象转化为json数据
            ObjectMapper mapper =new ObjectMapper();
            String jsonStr = "";
            try {
                jsonStr = mapper.writeValueAsString(deliveryDispatchVo);
            } catch (JsonProcessingException e) {
                logger.info("数据转换异常");
                e.printStackTrace();
            }

            //向川威电商发送请求
            HttpUtils utils=new HttpUtils();
            String url = switchconfigEntity.getParamValue3();
            String resultStr="";
            try {
                logger.info("url="+url);
                logger.info("jsonStr="+jsonStr);
//                System.out.println(jsonStr);
                resultStr=utils.postJson(url,jsonStr);
                //resultStr="{\"outResult\":\"1\",\"outResultReason\":\"成功\"}";
            } catch (Exception e) {
                logger.info("请求超时");
                e.printStackTrace();
            }
            logger.info("resultStr="+resultStr);

            if(resultStr!=null && !"".equals(resultStr)){
                Result result= JSON.parseObject(resultStr,Result.class);
                //更新上传状态isupload
                if("1".equals(result.outResult)){
                    reInfoRepositorys.updatereinfotocwafter();
                    logger.info("确认收货信息回传成功");
                }else{
                	reInfoRepositorys.updatefail();
                    logger.info("确认收货信息回传失败 outResultReason="+result.outResultReason);
                }
            }else{
                logger.info("未接收到响应数据");
                logger.info("resultStr="+resultStr+",jsonStr="+jsonStr);
            }

        } else{
            logger.info("未查询到确认收货信息");
        }

	}
}






