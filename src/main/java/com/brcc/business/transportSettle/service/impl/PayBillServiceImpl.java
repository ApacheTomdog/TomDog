package com.brcc.business.transportSettle.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.brcc.business.blackbroker.entity.BlackbrokerEntity;
import com.brcc.business.blackbroker.service.BlackbrokerService;
import com.brcc.business.brokerProfit.service.BrokerPpSwitchService;
import com.brcc.business.brokerProfit.service.BrokerProfitConfigService;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.goodsorderm.entity.GoodsordermEntity;
import com.brcc.business.goodsorderm.service.GoodsordermService;
import com.brcc.business.payCalcBatch.entity.PayCalcBatchEntity;
import com.brcc.business.paybillgoods.entity.PayBillGoodEntity;
import com.brcc.business.paybillgoods.service.PayBillGoodsService;
import com.brcc.business.transportSettle.entity.PayBillChildEntity;
import com.brcc.business.transportSettle.entity.PayBillEntity;
import com.brcc.business.transportSettle.entity.VNewPayBillEntity;
import com.brcc.business.transportSettle.repository.PayBillChildRepository;
import com.brcc.business.transportSettle.repository.PayBillRepository;
import com.brcc.business.transportSettle.service.PayBillService;
import com.brcc.business.transportSettle.service.PayCalcBatchService;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
import com.brcc.business.transportbill.vo.TransportBillQueryVo;
import com.brcc.business.transportbill.vo.TransportationDeliveryVo;
import com.brcc.business.util.Arith;

/**
 * 结算单业务逻辑接口实现
 * @author yangwenbin
 * @version 创建时间：2018年11月4日 上午11:38:20
 */
@Transactional
@Service
public class PayBillServiceImpl implements PayBillService {

    Logger logger = LoggerFactory.getLogger(PayBillServiceImpl.class);

    @Autowired
    PayBillRepository payBillRepository;
    @Autowired
    PayBillChildRepository payBillChildRepository;
    @Autowired
    MybatisQuery mybatisQuery;
    @Autowired
    TransportationDeliveryService transportationDeliveryService;
    @Autowired
    GoodsordermService goodsordermService;
    @Autowired
    BlackbrokerService blackbrokerService;
    @Autowired
    PayBillGoodsService payBillGoodsService;
    @Autowired
    PayCalcBatchService payCalcBatchService;
    @Autowired
    BrokerPpSwitchService brokerPpSwitchService;
    @Autowired
    BrokerProfitConfigService brokerProfitConfigService;
    // 经纪人最大分润比例
    private BigDecimal BROKER_RATE_MAX = new BigDecimal("0.2");
    // 经纪人最大交税金额比例
    private BigDecimal BROKER_TAX_AMT_RATE_MAX = new BigDecimal("0.2");
    // 经纪人税率
    private BigDecimal BROKER_TAX_RATE = new BigDecimal("0.015");

	@Override
	public Integer queryActiveCount(Long publishId) {
		logger.info("find PayBill active count,publishId:{}",publishId);
		return payBillRepository.queryActiveCount(publishId);
	}

	@Override
	public Integer queryActivePayApplyCount(Long publishId) {
		logger.info("find PayBill active payApply count,publishId:{}",publishId);
		return payBillRepository.queryActiveCount(publishId);
	}


	@Override
	public PayBillEntity findOne(Long zfId) {
		logger.info("find PayBill,zfId:{}",zfId);
		return payBillRepository.findById(zfId).get();
	}

	@Override
	public PayBillEntity save(PayBillEntity payBill) {
		logger.info("save PayBill");
		return payBillRepository.save(payBill);
	}

	@Override
	public List<PayBillEntity> findPayBillListByPublishId(Long publishId) {
		logger.info("query PayBill list by publishId:{}",publishId);
		return payBillRepository.findByPublishId(publishId);
	}

	@Override
	public void saveList(List<PayBillEntity> payBillList) {
		logger.info("save PayBill list");
		payBillRepository.saveAll(payBillList);
		
	}

	@Override
	public Integer queryCountByDeliveryId(Long deliveryId) {
		logger.info("query delivey is settle or not");
		return payBillRepository.queryCountByDeliveryId(deliveryId);
	}

	@Override
	public Integer countByDeliveryIdAndStatus(Long deliveryId, String status) {
		logger.info("count delivery is paying");
		return payBillRepository.countByDeliveryIdAndStatus(deliveryId, status);
	}

	@Override
	public List<PayBillEntity> queryActivedPayBill(Long deliveryId) {
		logger.info("query actived paybill");
		return payBillRepository.queryActivedPayBill(deliveryId);
	}
	
	@Override
	public PayBillEntity findPayBillByCondition(Long deliveryId) {
		logger.info("find paybill by delivery is pay and no invoice");
		return payBillRepository.findByStatusAndIfInvoiceAndDeliveryId(20, 0,deliveryId);
	}

	@Override
	public void revokeZFbill(TransportBillQueryVo vo) {
		logger.info("revoke ZFbill,deliveryId:{},zfId:{}",vo.getDeliveryId(), vo.getZfId());
		Integer payedNum = payBillChildRepository.queryPayedChildNum(vo.getZfId());
		Assert.isTrue(payedNum==0, "对不起，该支付单关联的单据已支付或正在支付，不能撤销！");
		
		Integer n = payBillRepository.updatePayBill(vo.getZfId(), vo.getPlatformId(), "00", "10", vo.getUserId());
		Integer c = payBillChildRepository.updatePayBillChild(vo.getZfId(), vo.getPlatformId(), "00", "10", vo.getUserId(), vo.getUserName());
		Assert.isTrue(n!=0&&c!=0, "对不起，该支付单已支付或已撤销，请刷新页面！");
		
		n = payBillRepository.queryActiveOilBillNum(vo.getDeliveryId(), vo.getPlatformId());
		Assert.isTrue(n==0, "对不起，与该计算单关联的点卡正在支付中或已经生效，不能撤销！");
		
		// 删除油卡
		payBillRepository.insertPayOilBillLog(vo);
		payBillRepository.deletePayOilBill(vo);
		
		// 调度单撤销计算
		TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
		transportationDeliveryEntity.setZfId(null);
		transportationDeliveryEntity.setZfNum(null);
		transportationDeliveryEntity.setSettleStatus("10");
		transportationDeliveryEntity.setSettleWeight(new BigDecimal("0"));
		transportationDeliveryEntity.setSettlePrice(new BigDecimal("0"));
		transportationDeliveryEntity.setSettleAmount(new BigDecimal("0"));
		transportationDeliveryEntity.setUpdatePerson(vo.getUserId());
		transportationDeliveryEntity.setUpdateDate(new Date());
		transportationDeliveryEntity.setJsType(null);
		transportationDeliveryEntity.setOilRatio(null);
		transportationDeliveryEntity.setPayOidId(null);
		transportationDeliveryEntity.setPayOidNum(null);
		String remark = transportationDeliveryEntity.getRemark();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append(remark==null?"":remark);
		sb.append("|");
		sb.append(sdf.format(new Date()));
		sb.append("撤销支付单by");
		sb.append(vo.getUserId());
		transportationDeliveryEntity.setRemark(sb.toString());
		transportationDeliveryEntity.setIfUploadReceiptFlag("".equals(transportationDeliveryEntity.getComfirmPic1Local()) 
				|| transportationDeliveryEntity.getComfirmPic1Local()==null ? "0" : "1");
		
		transportationDeliveryService.save(transportationDeliveryEntity);
	}

	@Override
	public Page<VNewPayBillEntity> listPayDetailData(TransportBillQueryVo vo) {
		return payBillChildRepository.findPayDetailData(vo);
	}

	@Override
	public PayBillEntity saveZFbill(TransportBillQueryVo vo) {
		Assert.notNull(vo, "结算信息不能为空");
    	logger.info("save ZFbill,deliveryId:{}",vo.getDeliveryId());
    	Assert.isTrue(vo.getPayAmount().compareTo(new BigDecimal("0")) > 0, "应付运费必须大于0");
    	
    	Long n = payBillRepository.queryActivedPayBillCount(vo.getDeliveryId());
    	Assert.isTrue(n == 0, "该调度单已结算");
    	
    	PayBillEntity payBillEntity = new PayBillEntity();
    	TransportationDeliveryVo receiveVo = null;
    	
    	// 查询第一级流程信息
    	receiveVo = mybatisQuery.selectOne("transportSettle.queryFirstVatFlowInfo", vo);
    	// 查询经纪人分润情况
    	TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
		// 查询货源单上点卡分配情况
		GoodsordermEntity goodsordermEntity = goodsordermService.findById(vo.getPublishId());
		
		payBillEntity.setZfNum(getSeqNum("6"));
		payBillEntity.setPublishId(vo.getPublishId());
		payBillEntity.setTransId(vo.getTransId());
		payBillEntity.setDeliveryId(vo.getDeliveryId());
		payBillEntity.setPublishCompanyId(vo.getPublishCompanyId());
		payBillEntity.setPublishCompanyName(vo.getPublishCompanyName());
		payBillEntity.setCompanyId(vo.getCompanyId());
		payBillEntity.setCompanyName(vo.getCompanyName());
		payBillEntity.setCreateCompanyId(vo.getCreateCompanyId());
		payBillEntity.setCreateCompanyName(vo.getCreateCompanyName());
		payBillEntity.setGroupId(vo.getGroupId());
		payBillEntity.setGroupName(vo.getGroupName());
		payBillEntity.setDriverId(vo.getDriverId());
		payBillEntity.setDriverName(vo.getDriverName());
		payBillEntity.setVehicleId(vo.getVehicleId());
		payBillEntity.setVehicleNum(vo.getVehicleNum());
		payBillEntity.setGoodType(vo.getGoodType());
		payBillEntity.setGoodTypeName(vo.getGoodTypeName());
		payBillEntity.setGoodTypeDesc(vo.getGoodTypeDesc());
		payBillEntity.setBillSender(goodsordermEntity.getBillSender());
		payBillEntity.setSender(goodsordermEntity.getSender());
		payBillEntity.setStartPlate(vo.getStartPlate());
		payBillEntity.setEndPlate(vo.getEndPlate());
		payBillEntity.setFinishTime(vo.getFinishTime());
		payBillEntity.setReceBankType(vo.getReceBankType());
		payBillEntity.setPrice(vo.getPrice());
		payBillEntity.setGoodPrice(vo.getGoodPrice());
		payBillEntity.setSettleWeight(vo.getSettleWeight());
		payBillEntity.setTruckLoadingWeight(vo.getTruckLoadingWeight());
		payBillEntity.setTakeDeliveryWeight(vo.getTakeDeliveryWeight());
		payBillEntity.setPayAmount(vo.getPayAmount());
		payBillEntity.setLossType(vo.getLossType());
		payBillEntity.setLossRatio(vo.getLossRatio());
		payBillEntity.setLossWeight(vo.getLossWeight());

		// 计算亏吨重量
        BigDecimal lossTons = vo.getTruckLoadingWeight().subtract(vo.getTakeDeliveryWeight()).subtract(vo.getLossWeight());
		if (lossTons.compareTo(new BigDecimal("0")) > 0) {
            lossTons = "Y".equals(vo.getIfOwnerLoss()) ? vo.getTruckLoadingWeight().subtract(vo.getTakeDeliveryWeight()) : lossTons;
        } else {
            lossTons = new BigDecimal("0");
        }
        Assert.isTrue(lossTons.compareTo(vo.getLossTons()) == 0 , "亏吨重量计算有误，请检查！");

		// 计算亏吨扣除金额
        BigDecimal deductAmount = Arith.round(lossTons.multiply(vo.getGoodPrice()), 2);
        Assert.isTrue(deductAmount.compareTo(vo.getDeductAmount()) == 0 , "亏吨扣除金额计算有误，请检查！");

		payBillEntity.setLossTons(vo.getLossTons());
		payBillEntity.setDeductAmount(vo.getDeductAmount());

		// 计算含税单价
		String ifTaxTransport, ifOwnerTaxpriceMf, vatRateChose, vatAccType;
    	BigDecimal vatStandardRate, vatPolicyRate, rate = null, price, priceTax;
    	ifTaxTransport = receiveVo.getIfTaxTransport();
    	ifOwnerTaxpriceMf = goodsordermEntity.getIfOwnerTaxpriceMf();
    	vatRateChose = receiveVo.getVatRateChose();
    	vatAccType = receiveVo.getVatAccType();
    	vatStandardRate = receiveVo.getVatStandardRate();
    	vatPolicyRate = receiveVo.getVatPolicyRate();
    	// 不含税价
    	price = vo.getPrice();
    	if ("Y".equals(ifTaxTransport)) {
	    	// 税率
	        rate = "1".equals(vatRateChose) ? vatStandardRate : vatPolicyRate;
	        // 含税价
	        priceTax = "1".equals(vatAccType) ? (new BigDecimal(1).add(rate)).multiply(price) : price.divide((new BigDecimal(1).subtract(rate)), 2, BigDecimal.ROUND_HALF_UP);
	        priceTax = Arith.round(priceTax, 2);
    	} else {
    		priceTax = Arith.round((new BigDecimal("1.10")).multiply(price), 2);
    	}
    	
    	// 货主含税单价抹分
    	if ("1".equals(ifOwnerTaxpriceMf)) {
    		priceTax = Arith.round(priceTax, 1); 
    	}
    	payBillEntity.setStandardTax(rate==null ? receiveVo.getStandardTax() : rate);
    	payBillEntity.setPriceTax(priceTax);
    	payBillEntity.setIfTaxTransport(ifTaxTransport);
    	payBillEntity.setVatFlowMasterId(receiveVo.getVatFlowMasterId());
    	payBillEntity.setIfBrokerPeopleTollFlag(transportationDeliveryEntity.getIfBrokerPeopleTollFlag());
    	payBillEntity.setChargeAmount(vo.getChargePriceTotal());
    	payBillEntity.setChargePrice(vo.getChargePrice());
    	payBillEntity.setChargePriceType(vo.getChargePriceType());
    	payBillEntity.setJsType(goodsordermEntity.getJsType());
    	payBillEntity.setOilFlag(goodsordermEntity.getOilFlag());
    	payBillEntity.setOilAmount(goodsordermEntity.getOilAmount());
    	payBillEntity.setOilRatio(goodsordermEntity.getOilRatio());
    	payBillEntity.setEraseAmount(vo.getEraseAmount());
    	payBillEntity.setTransportationAmount(vo.getTransportationAmount());
    	payBillEntity.setOwnerAdjustFlag(vo.getOwnerAdjustFlag());
    	payBillEntity.setOwnerAdjustType(vo.getOwnerAdjustType());
    	payBillEntity.setOwnerAdjustAmt(vo.getOwnerAdjustAmt());
    	payBillEntity.setOwnerAdjustTotAmt(vo.getOwnerAdjustAmount());
    	payBillEntity.setOwnerPayAmount(vo.getPayAmount().add(vo.getOwnerAdjustAmount()==null?new BigDecimal("0"):vo.getOwnerAdjustAmount()));
    	payBillEntity.setDumpTruckCharge(vo.getDumpTruckCharge());
    	payBillEntity.setIfOwnerTaxpriceMf(goodsordermEntity.getIfOwnerTaxpriceMf());
		payBillEntity.setStatus("10");
		payBillEntity.setCreateDate(new Date());
		payBillEntity.setCreatePerson(vo.getUserId());
		payBillEntity.setUpdateDate(new Date());
		payBillEntity.setUpdatePerson(vo.getUserId());
		payBillEntity.setBusinessMemo(vo.getBusinessMemo());
		payBillEntity.setPlatformId(vo.getPlatformId());
		// 保存支付单主表
		payBillRepository.save(payBillEntity);
		// 生成支付子单
		createPayBillChild(vo,payBillEntity, transportationDeliveryEntity, goodsordermEntity);
		// 生成货款支付单
		if ("Y".equals(vo.getIfPayment())) {
			createPayBillGoods(vo);
		}
		
		// 更新调度单表上的结算信息
		TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
		Assert.isTrue(!"20".equals(deliveryEntity.getSettleStatus()), "该调度单已结算");
		deliveryEntity.setZfId(payBillEntity.getZfId());
		deliveryEntity.setZfNum(payBillEntity.getZfNum());
		deliveryEntity.setSettleStatus("20");
		deliveryEntity.setSettleWeight(vo.getSettleWeight());
		deliveryEntity.setSettlePrice(vo.getPrice());
		deliveryEntity.setSettleAmount(vo.getPayAmount());
		deliveryEntity.setUpdateDate(new Date());
		deliveryEntity.setIfUploadReceiptFlag("2");
		String remark = deliveryEntity.getRemark();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append(remark==null?"":remark);
		sb.append("|");
		sb.append(sdf.format(new Date()));
		sb.append("被结算by");
		sb.append(vo.getUserId());
		deliveryEntity.setRemark(sb.toString());
		transportationDeliveryService.save(deliveryEntity);
		return payBillEntity;
	}
	
	/**
	 * 生成货款支付单
	 * @param vo
	 */
	private void createPayBillGoods(TransportBillQueryVo vo) {
		Assert.isTrue(vo.getSettleWeight().multiply(vo.getGoodPrice()).compareTo(new BigDecimal("0")) > 0, "货款金额必须大于0");
		TransportationDeliveryVo receiveVo = null;
		// 查询供应商银行账号
		receiveVo = mybatisQuery.selectOne("transportSettle.queryProviderBankInfo", vo);
		Assert.notNull(receiveVo, "该调度单包含货款结算，但未找到供应商银行账号信息");
		PayBillGoodEntity payBillGoodEntity = new PayBillGoodEntity();
		payBillGoodEntity.setPayGoodsNum(getSeqNum("22"));
		payBillGoodEntity.setPublishCompanyId(vo.getPublishCompanyId());
		payBillGoodEntity.setPublishCompanyName(vo.getPublishCompanyName());
		payBillGoodEntity.setPublishId(vo.getPublishId());
		payBillGoodEntity.setPublishNum(receiveVo.getPublishNum());
		payBillGoodEntity.setTransId(vo.getTransId());
		payBillGoodEntity.setTransNum(receiveVo.getTransNum());
		payBillGoodEntity.setDeliveryId(vo.getDeliveryId());
		payBillGoodEntity.setDeliveryNum(receiveVo.getDeliveryNum());
		payBillGoodEntity.setGoodType(vo.getGoodType());
		payBillGoodEntity.setGoodTypeName(vo.getGoodTypeName());
		payBillGoodEntity.setGoodTypeDesc(vo.getGoodTypeDesc());
		payBillGoodEntity.setSettleWeight(vo.getSettleWeight());
		payBillGoodEntity.setPayAmount(vo.getSettleWeight().multiply(vo.getGoodPrice()));
		payBillGoodEntity.setPayStatus("10");
		payBillGoodEntity.setCreateDate(new Date());
		payBillGoodEntity.setCreatePersonId(vo.getUserId());
		payBillGoodEntity.setCreatePersonName(vo.getUserName());
		payBillGoodEntity.setUpdateDate(new Date());
		payBillGoodEntity.setUpdatePersonId(vo.getUserId());
		payBillGoodEntity.setUpdatePersonName(vo.getUserName());
		payBillGoodEntity.setReceBankName(receiveVo.getGoodsBankName());
		payBillGoodEntity.setReceBankNum(receiveVo.getGoodsBankNo());
		payBillGoodEntity.setReceBankOwner(receiveVo.getGoodsBankOwner());
		payBillGoodEntity.setReceBankProvince(receiveVo.getGoodsBankProvince());
		payBillGoodEntity.setReceBankCity(receiveVo.getGoodsBankCity());
		payBillGoodEntity.setReceSubbranchName(receiveVo.getGoodsBankSubName());
		payBillGoodEntity.setReceLinkNum(receiveVo.getGoodsBankSubNo());
		payBillGoodEntity.setAccountType(receiveVo.getGoodsBankType());
		payBillGoodEntity.setPlatformId(vo.getPlatformId());
		payBillGoodsService.save(payBillGoodEntity);
	}

	/**
	 * 生成支付子单
	 * @param vo
	 * @param payBillEntity
	 * @param transportationDeliveryEntity
	 * @param goodsordermEntity
	 */
	private void createPayBillChild(TransportBillQueryVo vo, PayBillEntity payBillEntity,
			TransportationDeliveryEntity transportationDeliveryEntity, GoodsordermEntity goodsordermEntity) {
		logger.info("create payBillChild, payBillId:{}", payBillEntity.getZfId());
		Assert.isTrue(vo.getReceBankType()!=null&&!"".equals(vo.getReceBankType()), "收款人账号类型错误");
		TransportationDeliveryVo receiveVo = null;
		TransportBillQueryVo queryVo = new TransportBillQueryVo();
		
		String jsType, oilFlag;
		BigDecimal oilAmountAct = new BigDecimal("0"), oilRatio, oilAmount, payAmount;
		jsType = goodsordermEntity.getJsType();
		oilFlag = goodsordermEntity.getOilFlag();
		oilRatio = goodsordermEntity.getOilRatio();
		oilAmount = goodsordermEntity.getOilAmount();
		payAmount = vo.getPayAmount();
		
		// 计算点卡金额
		// 计算方式   01：全部运费， 02：运费+点卡
		if ("01".equals(jsType)) {
			oilAmountAct = new BigDecimal("0");
		} else if ("02".equals(jsType)) {
			oilAmountAct = Arith.round("0".equals(oilFlag) ? oilRatio.multiply(payAmount) : oilAmount, 2);
			//点卡超过100，抹零至百位数，否则抹零至个位数
			if (oilAmountAct.compareTo(new BigDecimal("100")) > 0) {
				BigDecimal[] results = oilAmountAct.divideAndRemainder(BigDecimal.valueOf(100));
				oilAmountAct = oilAmountAct.subtract(results[1]);
			} else {
				BigDecimal[] results = oilAmountAct.divideAndRemainder(BigDecimal.valueOf(1));
				oilAmountAct = oilAmountAct.subtract(results[1]);
			}
		}
		
		// 查询承运方收款银行账号
    	if ("1".equals(vo.getReceBankType())) { // 发单人维护的收款账号
    		receiveVo = mybatisQuery.selectOne("transportSettle.queryPublisherBankInfo", vo);
    		Assert.notNull(receiveVo, "该调度单收款账号为发单人维护的收款账号，但未找到发单人维护的收款账号");
    	} else if ("0".equals(vo.getReceBankType())) { // 承运人收款账号
			// 如果是经纪人，则查询经纪人收款账号
			/*if ("Y".equals(transportationDeliveryEntity.getIfBrokerPeopleTollFlag())) {
				receiveVo = mybatisQuery.selectOne("transportSettle.queryBrokerBankInfo", vo);
			} else {
				receiveVo = mybatisQuery.selectOne("transportSettle.queryCarrierBankInfo", vo);
			}*/
			receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", vo);
			receiveVo = receiveVo == null ? new TransportationDeliveryVo() : receiveVo;
    	}
    	
    	// 经纪人模式
    	if ("Y".equals(transportationDeliveryEntity.getIfBrokerPeopleTollFlag())) {
    		// 生成经纪人支付单
    		PayBillChildEntity payBillChildEntity = new PayBillChildEntity();
    		payBillChildEntity.setZfChildNum(getSeqNum("18"));
        	payBillChildEntity.setZfId(payBillEntity.getZfId());
        	payBillChildEntity.setZfNum(payBillEntity.getZfNum());
        	payBillChildEntity.setPayId(0L);
        	payBillChildEntity.setPayCompanyId(vo.getPublishCompanyId());
        	payBillChildEntity.setPayCompanyName(vo.getPublishCompanyName());
    		payBillChildEntity.setStatus("10");
    		payBillChildEntity.setCreateDate(new Date());
    		payBillChildEntity.setCreatePersonId(vo.getUserId());
    		payBillChildEntity.setCreatePersonName(vo.getUserName());
    		payBillChildEntity.setPlatformId(vo.getPlatformId());
    		payBillChildEntity.setUpdateDate(new Date());
    		payBillChildEntity.setUpdatePersonId(vo.getUserId());
    		payBillChildEntity.setUpdatePersonName(vo.getUserName());
    		payBillChildEntity.setReceBankType(vo.getReceBankType()); // 1:发单人维护的收款账号, 2:承运人收款账号
    		payBillChildEntity.setReceBankName(receiveVo.getBankName());
    		payBillChildEntity.setReceBankNum(receiveVo.getBankNum());
    		payBillChildEntity.setReceBankOwner(receiveVo.getBankOwner());
    		payBillChildEntity.setReceBankProvince(receiveVo.getProvince());
    		payBillChildEntity.setReceBankCity(receiveVo.getCity());
    		payBillChildEntity.setReceLinkNum(receiveVo.getLinkNum());
    		payBillChildEntity.setReceSubbranchName(receiveVo.getSubbranchName());
    		payBillChildEntity.setAccountType(receiveVo.getAccountType());
			payBillChildEntity.setReceBankOwnerNo(receiveVo.getBankOwnerNum());
			payBillChildEntity.setCompanyOwnerBankId(receiveVo.getCompanyOwnerBankId());
			payBillChildEntity.setCompanyOwnerId(receiveVo.getCompanyOwnerId());
			payBillChildEntity.setAuthorityFlag(receiveVo.getAuthorityFlag());
    		payBillChildEntity.setPayFromType("1"); // 1：经纪人支付单，2：司机（承运人）支付单
			payBillChildEntity.setReceCompanyId(vo.getCompanyId());// 经纪人companyId
			payBillChildEntity.setReceCompanyName(vo.getCompanyName());
			payBillChildEntity.setDumpTruckCharge(new BigDecimal("0")); // 卸车费


    		String brokerPeopleTollType;
    		BigDecimal brokerPeopleTollAmount, brokerPeopleTollRatio, payBrokerAmount, payDriverAmount;
    		brokerPeopleTollType = transportationDeliveryEntity.getBrokerPeopleTollType();
    		brokerPeopleTollAmount = transportationDeliveryEntity.getBrokerPeopleTollAmount();
    		brokerPeopleTollRatio = transportationDeliveryEntity.getBrokerPeopleTollRatio();

    		Assert.notNull(brokerPeopleTollType, "该调度单经纪人分润方式为null，无法计算！");

    		// 经纪人按定金模式收取
    		if ("dj".equals(brokerPeopleTollType)) {
    			Assert.notNull(brokerPeopleTollAmount, "该调度单经纪人按定额方式分润，分润金额为null，无法计算！");
    			Assert.isTrue(payAmount.compareTo(brokerPeopleTollAmount) >= 0, "应付运费不够扣除经纪人费用！");
    			payBrokerAmount = brokerPeopleTollAmount;
    			payDriverAmount = payAmount.subtract(payBrokerAmount);
    		} else {
    			Assert.notNull(brokerPeopleTollRatio, "该调度单经纪人按定率方式分润，分润比率为null，无法计算！");
    			payBrokerAmount = payAmount.multiply(brokerPeopleTollRatio);
    			Assert.isTrue(payAmount.compareTo(payBrokerAmount) >= 0, "应付运费不够扣除经纪人费用！");
    			payBrokerAmount = Arith.round(payBrokerAmount, 2);
    			payDriverAmount = payAmount.subtract(payBrokerAmount);
    		}
			
			payBillRepository.flush();
			// 计算经纪人需线下支付给司机的最小金额
			/*BigDecimal payCarryMinAmt = Arith.round(payBrokerAmount.subtract(payBillEntity.getPayAmount().multiply(BROKER_RATE_MAX)), 2);
			if(payCarryMinAmt.compareTo(new BigDecimal("0")) < 0) {
				payCarryMinAmt = new BigDecimal("0");
			}
			
			PayBillEntity payBillEntity2 = payBillRepository.findById(payBillEntity.getZfId()).get();
			payBillEntity2.setPayCarryMinAmt(payCarryMinAmt);
			payBillRepository.save(payBillEntity2);
			
			// 应收经纪人税额
			BigDecimal taxAmount = new BigDecimal("0");
			// 查询经纪人开关配置
			BrokerPpSwitchEntity brokerPpSwitchEntity = brokerPpSwitchService.findOne(vo.getCompanyId());
			// 需要收经纪人税额
			if (brokerPpSwitchEntity != null && brokerPpSwitchEntity.getIfPaymentControl() == 1) {
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
				// 非特例经纪人
				if ("0".equals(deliveryEntity.getIfFundsControlFlag()) || "".equals(deliveryEntity.getIfFundsControlFlag()) || deliveryEntity.getIfFundsControlFlag() == null) {
					taxAmount = payBrokerAmount.multiply(brokerPpSwitchEntity.getPaymentTaxRaito());
				} else {
					taxAmount = payBillEntity.getPayAmount().multiply(brokerPpSwitchEntity.getPaymentPayRatio()).multiply(brokerPpSwitchEntity.getPaymentTaxRaito());
				}
			}
			taxAmount = Arith.round(taxAmount, 2);*/
			
			// 判断经纪人是否需要上传资金流水
			/*if (brokerProfitConfigEntity != null && "1".equals(brokerProfitConfigEntity.getIfUploadCapitalFlow())) {
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
				deliveryEntity.setIfFundsControlFlag("0".equals(deliveryEntity.getIfFundsControlFlag()) ? "1" : deliveryEntity.getIfFundsControlFlag());
				transportationDeliveryService.save(deliveryEntity);
			} else {
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
				deliveryEntity.setIfFundsControlFlag("0");
				transportationDeliveryService.save(deliveryEntity);
			}*/
			
			// 应收经纪人税额
			BigDecimal taxAmount = new BigDecimal("0");
			
			// 经纪人收费大于0，才生成经纪人支付单
			if (payBrokerAmount.compareTo(new BigDecimal("0")) > 0) {
				payBillChildEntity.setPayAmount(payBrokerAmount.subtract(taxAmount));
				payBillChildEntity.setTaxAmount(taxAmount);
				payBillChildEntity.setTotAmount(payBrokerAmount);
				payBillChildEntity.setOilAmount(new BigDecimal("0"));  // 点卡金额
				// 保存经纪人支付单
				payBillChildRepository.save(payBillChildEntity);
			}
			
			//经纪人需要凭证,还需判断是否经纪人是否在黑名单中
			/*List<BlackbrokerEntity> blackbrokerEntityList = blackbrokerService.findActivedBlackBroker(vo.getCompanyId(), "20", vo.getPlatformId());
			if (blackbrokerEntityList == null || blackbrokerEntityList.size() == 0) {
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
				deliveryEntity.setIfFundsControlFlag("0");
				deliveryEntity.setFundsControlPic(null);
				transportationDeliveryService.save(deliveryEntity);
			}
			
			if (blackbrokerEntityList != null && blackbrokerEntityList.size() > 0 && "Y".equals(transportationDeliveryEntity.getIfTaxTransport())) {
				BlackbrokerEntity blackbrokerEntity = blackbrokerEntityList.get(0);
				if (payBrokerAmount.compareTo(payAmount.multiply(blackbrokerEntity.getBlockBrokerRatio())) > 0) {
					TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
					deliveryEntity.setIfFundsControlFlag("2".equals(deliveryEntity.getIfFundsControlFlag()) ? "2" : "1");
					deliveryEntity.setFundsControlPic("2".equals(deliveryEntity.getIfFundsControlFlag()) ? deliveryEntity.getFundsControlPic() : null);
					transportationDeliveryService.save(deliveryEntity);
				}
			}*/
			
			// 查询司机收款账号
			queryVo.setCompanyId(vo.getDriverCompanyId());
			queryVo.setPlatformId(vo.getPlatformId());
			receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", queryVo);
			receiveVo = receiveVo == null ? new TransportationDeliveryVo() : receiveVo;

			// 生成司机支付单
    		PayBillChildEntity payBillChildDriverEntity = new PayBillChildEntity();
    		payBillChildDriverEntity.setZfChildNum(getSeqNum("18"));
    		payBillChildDriverEntity.setZfId(payBillEntity.getZfId());
    		payBillChildDriverEntity.setZfNum(payBillEntity.getZfNum());
    		payBillChildDriverEntity.setPayId(0L);
    		payBillChildDriverEntity.setPayCompanyId(vo.getPublishCompanyId());
    		payBillChildDriverEntity.setPayCompanyName(vo.getPublishCompanyName());
    		payBillChildDriverEntity.setStatus("10");
    		payBillChildDriverEntity.setCreateDate(new Date());
    		payBillChildDriverEntity.setCreatePersonId(vo.getUserId());
    		payBillChildDriverEntity.setCreatePersonName(vo.getUserName());
    		payBillChildDriverEntity.setPlatformId(vo.getPlatformId());
    		payBillChildDriverEntity.setUpdateDate(new Date());
    		payBillChildDriverEntity.setUpdatePersonId(vo.getUserId());
    		payBillChildDriverEntity.setUpdatePersonName(vo.getUserName());
    		payBillChildDriverEntity.setReceBankType(vo.getReceBankType()); // 1:发单人维护的收款账号, 2:承运人收款账号
    		payBillChildDriverEntity.setReceBankName(receiveVo.getBankName());
    		payBillChildDriverEntity.setReceBankNum(receiveVo.getBankNum());
    		payBillChildDriverEntity.setReceBankOwner(receiveVo.getBankOwner());
    		payBillChildDriverEntity.setReceBankProvince(receiveVo.getProvince());
    		payBillChildDriverEntity.setReceBankCity(receiveVo.getCity());
    		payBillChildDriverEntity.setReceLinkNum(receiveVo.getLinkNum());
    		payBillChildDriverEntity.setReceSubbranchName(receiveVo.getSubbranchName());
    		payBillChildDriverEntity.setAccountType(receiveVo.getAccountType());
			payBillChildDriverEntity.setReceBankOwnerNo(receiveVo.getBankOwnerNum());
			payBillChildDriverEntity.setCompanyOwnerBankId(receiveVo.getCompanyOwnerBankId());
			payBillChildDriverEntity.setCompanyOwnerId(receiveVo.getCompanyOwnerId());
			payBillChildDriverEntity.setAuthorityFlag(receiveVo.getAuthorityFlag());
    		payBillChildDriverEntity.setPayFromType("2"); // 1：经纪人支付单，2：司机（承运人）支付单
    		payBillChildDriverEntity.setReceCompanyId(vo.getDriverCompanyId());// 司机companyId
    		payBillChildDriverEntity.setReceCompanyName(vo.getDriverName());
    		payBillChildDriverEntity.setDumpTruckCharge(vo.getDumpTruckCharge()); // 卸车费
    		
			// 如果司机收款金额大于0，才生成司机支付单
			if (payDriverAmount.compareTo(new BigDecimal("0")) > 0) {
				BigDecimal totPayAmount = payDriverAmount;
				// 收取司机卸车费
				if ("Y".equals(vo.getIfDumpTruckCharge())) {
					Assert.isTrue(payDriverAmount.compareTo(vo.getDumpTruckCharge()) > 0, "扣除卸车费司机收款金额小于等于0");
					payDriverAmount = payDriverAmount.subtract(vo.getDumpTruckCharge());
				}
				
				// 司机收款金额小于等于点卡数，则不分配点卡
				if (payDriverAmount.compareTo(oilAmountAct) <= 0) {
					oilAmountAct = new BigDecimal("0");
				}
				payBillChildDriverEntity.setPayAmount(payDriverAmount.subtract(oilAmountAct));
				payBillChildDriverEntity.setTotAmount(totPayAmount);
				payBillChildDriverEntity.setOilAmount(oilAmountAct);  // 点卡金额
				// 保存司机支付单
				payBillChildRepository.save(payBillChildDriverEntity);
			}
			
		// 非经纪人模式	
    	} else {
    		// 生成承运人支付单
    		PayBillChildEntity payBillChildCarrierEntity = new PayBillChildEntity();
    		payBillChildCarrierEntity.setZfChildNum(getSeqNum("18"));
    		payBillChildCarrierEntity.setZfId(payBillEntity.getZfId());
    		payBillChildCarrierEntity.setZfNum(payBillEntity.getZfNum());
    		payBillChildCarrierEntity.setPayId(0L);
    		payBillChildCarrierEntity.setPayCompanyId(vo.getPublishCompanyId());
    		payBillChildCarrierEntity.setPayCompanyName(vo.getPublishCompanyName());
    		payBillChildCarrierEntity.setStatus("10");
    		payBillChildCarrierEntity.setCreateDate(new Date());
    		payBillChildCarrierEntity.setCreatePersonId(vo.getUserId());
    		payBillChildCarrierEntity.setCreatePersonName(vo.getUserName());
    		payBillChildCarrierEntity.setPlatformId(vo.getPlatformId());
    		payBillChildCarrierEntity.setUpdateDate(new Date());
    		payBillChildCarrierEntity.setUpdatePersonId(vo.getUserId());
    		payBillChildCarrierEntity.setUpdatePersonName(vo.getUserName());
    		payBillChildCarrierEntity.setReceBankType(vo.getReceBankType()); // 1:发单人维护的收款账号, 2:承运人收款账号
    		payBillChildCarrierEntity.setReceBankName(receiveVo.getBankName());
    		payBillChildCarrierEntity.setReceBankNum(receiveVo.getBankNum());
    		payBillChildCarrierEntity.setReceBankOwner(receiveVo.getBankOwner());
    		payBillChildCarrierEntity.setReceBankProvince(receiveVo.getProvince());
    		payBillChildCarrierEntity.setReceBankCity(receiveVo.getCity());
    		payBillChildCarrierEntity.setReceLinkNum(receiveVo.getLinkNum());
    		payBillChildCarrierEntity.setReceSubbranchName(receiveVo.getSubbranchName());
    		payBillChildCarrierEntity.setAccountType(receiveVo.getAccountType());
			payBillChildCarrierEntity.setReceBankOwnerNo(receiveVo.getBankOwnerNum());
			payBillChildCarrierEntity.setCompanyOwnerBankId(receiveVo.getCompanyOwnerBankId());
			payBillChildCarrierEntity.setCompanyOwnerId(receiveVo.getCompanyOwnerId());
			payBillChildCarrierEntity.setAuthorityFlag(receiveVo.getAuthorityFlag());
    		payBillChildCarrierEntity.setPayFromType("2"); // 1：经纪人支付单，2：司机（承运人）支付单
    		payBillChildCarrierEntity.setReceCompanyId(vo.getCompanyId());// 承运人companyId
    		payBillChildCarrierEntity.setReceCompanyName(vo.getCompanyName());
    		payBillChildCarrierEntity.setDumpTruckCharge(vo.getDumpTruckCharge()); // 卸车费
    		
    		BigDecimal totPayAmount = payAmount;
			// 收取司机卸车费
			if ("Y".equals(vo.getIfDumpTruckCharge())) {
				Assert.isTrue(payAmount.compareTo(vo.getDumpTruckCharge()) > 0, "扣除卸车费承运人收款金额小于等于0");
				payAmount = payAmount.subtract(vo.getDumpTruckCharge());
			}
    		// 承运人收款金额小于等于点卡数，则不分配点卡
			if (payAmount.compareTo(oilAmountAct) <= 0) {
				oilAmountAct = new BigDecimal("0");
			}
			payBillChildCarrierEntity.setPayAmount(payAmount.subtract(oilAmountAct));
			payBillChildCarrierEntity.setTotAmount(totPayAmount);
			payBillChildCarrierEntity.setOilAmount(oilAmountAct);  // 点卡金额
			// 保存承运人支付单
			payBillChildRepository.save(payBillChildCarrierEntity);
    	}
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

	@Override
	public void autoApplyPay(PayBillEntity payBillEntity) {
		//判断货主是否自动付款申请
		Long n = payBillRepository.queryIfAutoApplyPay(payBillEntity.getPublishCompanyId(), payBillEntity.getPlatformId());
		if (n > 0) {
			//主表做自动付款申请
			String remark = payBillEntity.getRemark();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuffer sb = new StringBuffer();
			sb.append(remark==null?"":remark);
			sb.append("|");
			sb.append(sdf.format(new Date()));
			sb.append("自动付款申请by");
			sb.append(payBillEntity.getCreatePerson());
			payBillEntity.setRemark(sb.toString());
			payBillEntity.setUpdateDate(new Date());
			payBillEntity.setOwnerPayapplyFlag("1");
			payBillRepository.save(payBillEntity);
			
			//子表做自动付款申请
			List<PayBillChildEntity> payBillChildEntityList = payBillChildRepository.findByZfId(payBillEntity.getZfId());
			for (PayBillChildEntity payBillChildEntity : payBillChildEntityList) {
				remark = payBillChildEntity.getRemark();
				sb = new StringBuffer();
				sb.append(remark==null?"":remark);
				sb.append("|");
				sb.append(sdf.format(new Date()));
				sb.append("自动付款申请by");
				sb.append(payBillChildEntity.getCreatePersonId());
				payBillChildEntity.setRemark(sb.toString());
				payBillChildEntity.setUpdateDate(new Date());
				payBillChildEntity.setOwnerPayapplyFlag("1");
			}
			if (payBillChildEntityList != null && payBillChildEntityList.size() > 0) {
				payBillChildRepository.saveAll(payBillChildEntityList);
			}
		}
		
	}

	@Override
	public HashMap<String, Object> checkIfSamePay(TransportBillQueryVo vo) {
		TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryService.findById(vo.getDeliveryId());
		List<TransportationDeliveryVo> list = mybatisQuery.list("transportSettle.checkIfSamePay", transportationDeliveryEntity);
		String deliveryIdStr ="";
		StringBuffer sb = new StringBuffer();
		if (list != null && list.size() > 0) {
			for(TransportationDeliveryVo transportationDeliveryVo : list){
				deliveryIdStr += (deliveryIdStr == "") ? String.valueOf(transportationDeliveryVo.getDeliveryId()) : ("," + String.valueOf(transportationDeliveryVo.getDeliveryId())) ;
			}
			sb.append("尊敬的");
			sb.append(list.get(0).getPublishCompanyName());
			sb.append(",您好，系统通过大数据云计算的分析，帮您找出10天内疑似司机：(");
			sb.append(list.get(0).getDriverName());
			sb.append("车牌号：");
			sb.append(list.get(0).getVehicleNum());
			sb.append("重复拉运的单据");
			sb.append(deliveryIdStr);
			sb.append(")");
		}
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		if (sb.length() > 0) {
			data.put("outResult", "0");
		} else {
			data.put("outResult", "1");
		}
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", sb.toString());
		return resultMap;
	}

	@Override
	public HashMap<String, Object> checkZFbill(TransportBillQueryVo vo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		TransportationDeliveryVo receiveVo = null;
		int a = 0, b = 0, c = 0;
		// 检查收款方银行账号是否存在
    	if ("1".equals(vo.getReceBankType())) { // 发单人维护的收款账号
    		receiveVo = mybatisQuery.selectOne("transportSettle.queryPublisherBankInfo", vo);
    	} else if ("0".equals(vo.getReceBankType())) { // 承运人收款账号
			receiveVo = mybatisQuery.selectOne("transportSettle.queryReceBankInfo", vo);
    	}
    	if (receiveVo == null || receiveVo.getBankNum() == null || "".equals(receiveVo.getBankNum())) {
    		a = 1;
    	}
    	
    	// 检查运费单价是否合理
    	receiveVo = mybatisQuery.selectOne("transportSettle.queryTransPriceAvg", vo);
    	BigDecimal price = vo.getPrice(), minPrice = null, maxPrice = null;
    	if (receiveVo != null && receiveVo.getAvgPrice().compareTo(new BigDecimal("0")) > 0) {
        	minPrice = receiveVo.getMinPrice();
        	maxPrice = receiveVo.getMaxPrice();
        	if (price.compareTo(minPrice) < 0 && price.compareTo(maxPrice) > 0) {
        		b = 2;
        	} else {
        		b = 4;
        	}
    	}
    	
    	c = a + b;
		switch (c) {
			case 1: 
				data.put("outResult", "0");
				resultMap.put("msg","收款人银行账号未维护，是否仍计算运费？");
				break;
			case 2: 
				data.put("outResult", "0");
				resultMap.put("msg","当前运费单价不在合理区间（"+ minPrice.doubleValue() + " ~ " + maxPrice.doubleValue() +"），是否仍计算运费？");
				break;	
			case 3: 
				data.put("outResult", "0");
				resultMap.put("msg","收款人银行账号未维护，且当前运费单价不在合理区间（"+ minPrice.doubleValue() + " ~ " + maxPrice.doubleValue() +"），是否仍计算运费？");
				break;
			case 4: 
				data.put("outResult", "0");
				resultMap.put("msg","当前运费单价 " + price + "元，合理运费单价区间（"+ minPrice.doubleValue() + " ~ " + maxPrice.doubleValue() +"），是否计算运费？");
				break;
			case 5: 
				data.put("outResult", "0");
				resultMap.put("msg","收款人银行账号未维护，合理运费单价区间（"+ minPrice.doubleValue() + " ~ " + maxPrice.doubleValue() +"），是否仍计算运费？");
				break;
			case 0: 
				data.put("outResult", "1");
				break;
			default:
				data.put("outResult", "0");
				resultMap.put("msg","校验异常！");
		}
		
		resultMap.put("success", true);
		resultMap.put("data", data);
		return resultMap;
	}

	@Override
	public HashMap<String, Object> cancelPayApply(TransportBillQueryVo vo) {
		Assert.notNull(vo.getZfId(), "zfId不能为空");
    	logger.info("cancel pay apply,zfId:{}",vo.getZfId());
    	
    	//撤销主表的付款申请
    	PayBillEntity payBillEntity = payBillRepository.findById(vo.getZfId()).get();
    	
    	Long batchFlag = payBillEntity.getBatchFlag();
    	Assert.isTrue(batchFlag != 1, "此付款申请处于支付中，不能做撤销！");
    	
    	String status = payBillEntity.getStatus();
    	Assert.isTrue("10".equals(status), "此付款申请处于支付中，不能做撤销！！");
    	
    	String remark = payBillEntity.getRemark();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append(remark==null?"":remark);
		sb.append("|");
		sb.append(sdf.format(new Date()));
		sb.append("撤销付款申请审核by");
		sb.append(vo.getUserId());
		payBillEntity.setRemark(sb.toString());
		payBillEntity.setUpdatePerson(vo.getUserId());
		payBillEntity.setUpdateDate(new Date());
		payBillEntity.setOwnerPayapplyFlag("0");
		payBillEntity.setOwnerPayapplyCancelFlag("0");
		payBillRepository.save(payBillEntity);
		
		//撤销子表的付款申请
		List<PayBillChildEntity> payBillChildEntityList = payBillChildRepository.findByZfId(payBillEntity.getZfId());
		for (PayBillChildEntity payBillChildEntity : payBillChildEntityList) {
			remark = payBillChildEntity.getRemark();
			sb = new StringBuffer();
			sb.append(remark==null?"":remark);
			sb.append("|");
			sb.append(sdf.format(new Date()));
			sb.append("撤销付款申请审核by");
			sb.append(vo.getUserId());
			payBillChildEntity.setRemark(sb.toString());
			payBillChildEntity.setUpdatePersonId(vo.getUserId());
			payBillChildEntity.setUpdatePersonName(vo.getUserName());
			payBillChildEntity.setUpdateDate(new Date());
			payBillChildEntity.setOwnerPayapplyFlag("0");
			payBillChildEntity.setOwnerPayapplyCancelFlag("0");
		}
		if (payBillChildEntityList != null && payBillChildEntityList.size() > 0) {
			payBillChildRepository.saveAll(payBillChildEntityList);
		}
    	
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "操作成功！");
		return resultMap;
	}


	@Override
	public HashMap<String, Object> cancelPayApplyBatch(TransportBillQueryVo vo) {
		Assert.notNull(vo.getZfIdStr(), "zfIdStr不能为空");
    	logger.info("cancel pay apply batch,zfIdStr:{}",vo.getZfIdStr());
    	String[] zfIdArr = vo.getZfIdStr().split(",");
    	
    	for (String zfId : zfIdArr) {
    		//撤销主表的付款申请
        	PayBillEntity payBillEntity = payBillRepository.findById(Long.valueOf(zfId)).get();
        	
        	Long batchFlag = payBillEntity.getBatchFlag();
        	Assert.isTrue(batchFlag != 1, "此付款申请处于支付中，不能做撤销！");
        	
        	String status = payBillEntity.getStatus();
        	Assert.isTrue("10".equals(status), "此付款申请处于支付中，不能做撤销！！");
        	
        	String remark = payBillEntity.getRemark();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		StringBuffer sb = new StringBuffer();
    		sb.append(remark==null?"":remark);
    		sb.append("|");
    		sb.append(sdf.format(new Date()));
    		sb.append("撤销付款申请审核by");
    		sb.append(vo.getUserId());
    		payBillEntity.setRemark(sb.toString());
    		payBillEntity.setUpdatePerson(vo.getUserId());
    		payBillEntity.setUpdateDate(new Date());
    		payBillEntity.setOwnerPayapplyFlag("0");
    		payBillEntity.setOwnerPayapplyCancelFlag("0");
    		payBillRepository.save(payBillEntity);
    		
    		//撤销子表的付款申请
    		List<PayBillChildEntity> payBillChildEntityList = payBillChildRepository.findByZfId(payBillEntity.getZfId());
    		for (PayBillChildEntity payBillChildEntity : payBillChildEntityList) {
    			remark = payBillChildEntity.getRemark();
    			sb = new StringBuffer();
    			sb.append(remark==null?"":remark);
    			sb.append("|");
    			sb.append(sdf.format(new Date()));
    			sb.append("撤销付款申请审核by");
    			sb.append(vo.getUserId());
    			payBillChildEntity.setRemark(sb.toString());
    			payBillChildEntity.setUpdatePersonId(vo.getUserId());
    			payBillChildEntity.setUpdatePersonName(vo.getUserName());
    			payBillChildEntity.setUpdateDate(new Date());
    			payBillChildEntity.setOwnerPayapplyFlag("0");
    			payBillChildEntity.setOwnerPayapplyCancelFlag("0");
    		}
    		if (payBillChildEntityList != null && payBillChildEntityList.size() > 0) {
    			payBillChildRepository.saveAll(payBillChildEntityList);
    		}
    	}
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "操作成功！");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> batchCalc(TransportBillQueryVo vo) {
		Assert.notNull(vo.getDeliveryIds(), "调度单id不能为空");
		Assert.hasLength(vo.getDeliveryIds(), "调度单id不能为空");
    	logger.info("batch calc, deliveryIds:{}", vo.getDeliveryIds());
    	
    	String[] deliveryIdArr = vo.getDeliveryIds().split(",");
    	String batchId = getTimeMillisSequence();
    	List<PayCalcBatchEntity> payCalcBatchEntityList = new ArrayList<PayCalcBatchEntity>();
    	for (String deliveryId : deliveryIdArr) {
    		TransportationDeliveryEntity transportationDeliveryEntity = transportationDeliveryService.findById(Long.valueOf(deliveryId));
    		PayCalcBatchEntity payCalcBatchEntity = new PayCalcBatchEntity();
    		payCalcBatchEntity.setBatchId(batchId);
    		payCalcBatchEntity.setPublishId(transportationDeliveryEntity.getPublishId());
    		payCalcBatchEntity.setTransId(transportationDeliveryEntity.getTransId());
    		payCalcBatchEntity.setDeliveryId(transportationDeliveryEntity.getDeliveryId());
    		payCalcBatchEntity.setCalcStatus("10");
    		payCalcBatchEntity.setPayAmountType(vo.getPayAmountType());
    		payCalcBatchEntity.setMinPayAmount(vo.getMinPayAmount());
    		payCalcBatchEntity.setMaxPayAmount(vo.getMaxPayAmount());
    		payCalcBatchEntity.setDeductType(vo.getDeductType());
    		payCalcBatchEntity.setDeductWeight(vo.getDeductWeight());
    		payCalcBatchEntity.setDeductRatio(vo.getDeductRatio()==null?vo.getDeductRatio():vo.getDeductRatio().divide(new BigDecimal("1000")));
    		payCalcBatchEntity.setTransportationAmount(vo.getTransportationAmount());
    		payCalcBatchEntity.setSettleWeightType(vo.getSettleWeightType());
    		payCalcBatchEntity.setCreateDate(new Date());
    		payCalcBatchEntity.setCreatePersonId(vo.getUserId());
    		payCalcBatchEntity.setCreatePersonName(vo.getUserName());
    		payCalcBatchEntity.setUpdateDate(new Date());
    		payCalcBatchEntity.setUpdatePersonId(vo.getUserId());
    		payCalcBatchEntity.setUpdatePersonName(vo.getUserName());
    		payCalcBatchEntity.setPlatformId(vo.getPlatformId());
    		payCalcBatchEntity.setBankIfSettleFlag(vo.getBankIfSettleFlag() == null ? 0 : vo.getBankIfSettleFlag());
    		payCalcBatchEntityList.add(payCalcBatchEntity);
    	}
    	payCalcBatchService.saveAll(payCalcBatchEntityList);

    	payBillRepository.flush();

		/**
		 * 调用批量计算过程
		 */
		logger.info("call pro_paybill_batch_calc, batchId:{}", batchId);
		HashMap<String, Object> proMap = payBillRepository.callBatchCalcPro(batchId);

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", true);
		resultMap.put("data", proMap);
		resultMap.put("msg", (String)proMap.get("outResultReason"));
		return resultMap;
    	
	}
	
	private static String getTimeMillisSequence() {
		long nanoTime = System.nanoTime();
		if (nanoTime < 0) {
			nanoTime = nanoTime + Long.MAX_VALUE + 1;
		}
		String nanoTimeStr = String.valueOf(nanoTime);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 11; i++) {
			char c = nanoTimeStr.charAt(i);
			sb.append(c);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); // 24小时制
		String timeMillisSequence = sdf.format(System.currentTimeMillis()) + sb.toString();
		return timeMillisSequence;
	}

	@Override
	public TransportationDeliveryVo listDataSum(TransportBillQueryVo queryVo) {
		
		return mybatisQuery.selectOne("transportSettle.listDataSum", queryVo);
		
	}

}
