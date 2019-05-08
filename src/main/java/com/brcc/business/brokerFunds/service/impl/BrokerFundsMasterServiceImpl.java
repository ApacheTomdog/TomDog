package com.brcc.business.brokerFunds.service.impl;

import com.brcc.business.brokerFunds.entity.BrokerFundsPayeeInfoEntity;
import com.brcc.business.brokerFunds.entity.BrokerfundscontroldetailEntity;
import com.brcc.business.brokerFunds.entity.BrokerfundscontrolmasterEntity;
import com.brcc.business.brokerFunds.service.BrokerFundsDetailService;
import com.brcc.business.brokerFunds.service.BrokerFundsPayeeInfoService;
import com.brcc.business.brokerFunds.vo.*;
import com.brcc.business.brokerPayee.entity.BrokerPayeeEntity;
import com.brcc.business.brokerPayee.service.BrokerPayeeService;
import com.brcc.business.brokerTax.service.BrokerTaxCycleService;
import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.transportbill.entity.TransportationDeliveryEntity;
import com.brcc.business.transportbill.service.TransportationDeliveryService;
//import com.sun.corba.se.pept.broker.Broker;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.brcc.business.brokerFunds.repository.BrokerFundsMasterRepository;
import com.brcc.business.brokerFunds.service.BrokerFundsMasterService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 经纪人上传资金流水单(新版)
 * @Author pjy
 * @Date 2018-01-29
 **/
@Service
@Transactional
public class BrokerFundsMasterServiceImpl implements BrokerFundsMasterService{
	
	Logger logger = LoggerFactory.getLogger(BrokerFundsMasterServiceImpl.class);
    @Autowired
    BrokerFundsMasterRepository  brokerFundsMasterRepository;
    @Autowired
	TransportationDeliveryService  transportationDeliveryService;
    @Autowired
	BrokerFundsDetailService  brokerFundsDetailService;
	@Autowired
	MybatisQuery mybatisQuery;
	@Autowired
	BrokerPayeeService  brokerPayeeService;
	@Autowired
	BrokerTaxCycleService brokerTaxCycleService;
	@Autowired
	BrokerFundsPayeeInfoService brokerFundsPayeeInfoService;

	@Override
	public Page<BrokerFundsDetailVo> brokerFundsMasterAuditList(BrokerFundsDetailQueryVo queryvo) {
		
		return brokerFundsMasterRepository.brokerFundsMasterAuditList(queryvo);
	}
	
	
	//超限调度单查询
	@Override
	public Page<TransfiniteDispatchVo> transfiniteDispatchPage(TransfiniteDispatchQueryVo queryVo) {
		return brokerFundsMasterRepository.transfiniteDispatchPage(queryVo);
	}
    //经纪人资金流水批量上传查询
    @Override
    public Page<BrokerFundsVo> brokerFundsMasterList(BrokerFundsQueryVo queryvo) {
        logger.info("query brokerFundsMasterList by brokerCompanyId{}",queryvo.getCompanyId());
        return brokerFundsMasterRepository.brokerFundsMasterList(queryvo);
    }

	//保存单条资金流水上传记录
	@Override
	@Transactional
	public void saveCapitalFlow(BrokerFundsVo brokerFundsVo) {
		//更新调度单上的资金流水上传状态
		TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(brokerFundsVo.getDeliveryId());
		BrokerfundscontrolmasterEntity brokerfundscontrolmasterEntity = new  BrokerfundscontrolmasterEntity();
		brokerfundscontrolmasterEntity.setPlatformId(brokerFundsVo.getPlatformId());
		String fundsControllerMasterNum = getSeqNum("103");
		//插入资金流水单的主表
		brokerfundscontrolmasterEntity.setFundsControlMasterNum(fundsControllerMasterNum);
		brokerfundscontrolmasterEntity.setFundsPic(brokerFundsVo.getFundsPic());
		brokerfundscontrolmasterEntity.setFundsPicSec(brokerFundsVo.getFundsPicSec());
		brokerfundscontrolmasterEntity.setFundsPicThi(brokerFundsVo.getFundsPicThi());
		brokerfundscontrolmasterEntity.setBorkerCompanyId(brokerFundsVo.getBorkerCompanyId());
		brokerfundscontrolmasterEntity.setBorkerCompanyName(brokerFundsVo.getBorkerCompanyName());
		//代表该资金流水主单所有的资金明细都已上传完
		brokerfundscontrolmasterEntity.setMasterStatus("30");
		brokerfundscontrolmasterEntity.setCreateRemark(brokerFundsVo.getCreateRemark());
		brokerfundscontrolmasterEntity.setCreateDate(new Date());
		brokerfundscontrolmasterEntity.setCreatePersonId(brokerFundsVo.getCreatePersonId());
		brokerfundscontrolmasterEntity.setCreatePersonName(brokerFundsVo.getCreatePersonName());
		brokerfundscontrolmasterEntity.setModifyDate(new Date());
		brokerfundscontrolmasterEntity.setModifyPersonId(brokerFundsVo.getCreatePersonId());
		brokerfundscontrolmasterEntity.setModifyPersonName(brokerFundsVo.getCreatePersonName());
		brokerfundscontrolmasterEntity = brokerFundsMasterRepository.save(brokerfundscontrolmasterEntity);
		//代表该调度单已上传资金流水单
		deliveryEntity.setIfFundsControlFlag("3");
		deliveryEntity.setBrokerFundsControlMasterId(brokerfundscontrolmasterEntity.getFundsControlMasterId());
		transportationDeliveryService.save(deliveryEntity);
		BrokerfundscontroldetailEntity  brokerfundscontroldetailEntity = new BrokerfundscontroldetailEntity();
		//插入资金流水单的明细
		BrokerFundsDetailVo brokerFundsDetailVo = brokerFundsMasterRepository.getBrokerFundsDetailVo(brokerFundsVo);
		BeanUtils.copyProperties(brokerFundsDetailVo,brokerfundscontroldetailEntity);
		brokerfundscontroldetailEntity.setFundsControlMasterId(brokerfundscontrolmasterEntity.getFundsControlMasterId());
		brokerfundscontroldetailEntity.setFundsControlMasterNum(brokerfundscontrolmasterEntity.getFundsControlMasterNum());
		brokerfundscontroldetailEntity.setCreateDate(new Date());
		brokerfundscontroldetailEntity.setCreatePersonId(brokerFundsVo.getCreatePersonId());
		brokerfundscontroldetailEntity.setCreatePersonName(brokerFundsVo.getCreatePersonName());
		brokerfundscontroldetailEntity.setFcCarryName(brokerFundsVo.getFcCarryName());
		brokerfundscontroldetailEntity.setFcCarryAmount(brokerFundsVo.getFcCarryAmount());
		brokerfundscontroldetailEntity.setFcIfUpload(1);
		brokerfundscontroldetailEntity.setDetailStatus("10");
		brokerFundsDetailService.save(brokerfundscontroldetailEntity);

	}

	//对单条资金流水进行第一次审核操作
	@Override
	@Transactional
	public void saveFirstAudit(BrokerFundsDetailVo brokerFundsDetailVo){
		logger.info("first audit brokerfundsDetail by fundsControlDetailIdStr",brokerFundsDetailVo.getFundsControlDetailIdStr());
		Assert.notNull(brokerFundsDetailVo.getFundsControlDetailIdStr(),"一次审核获取操作数据id失败");
			String[] fundsControlDetailIdArr = brokerFundsDetailVo.getFundsControlDetailIdStr().split(",");
			for(int num=0;num<fundsControlDetailIdArr.length;num++) {
				BrokerfundscontroldetailEntity detailEntity = brokerFundsDetailService.findById(Long.parseLong(fundsControlDetailIdArr[num].toString()));
				Assert.isTrue("10".equals(detailEntity.getDetailStatus()),"该资金流水单据的状态无法进行一审");
				detailEntity.setDetailStatus(brokerFundsDetailVo.getDetailStatus());
				if(!StringUtils.isEmpty(brokerFundsDetailVo.getDetailStatusRemark())){
					detailEntity.setDetailStatusRemark(brokerFundsDetailVo.getDetailStatusRemark());
				}
				//更新对应的资金流水单明细
				detailEntity.setFirstAuditDate(new Date());
				detailEntity.setFirstAuditId(brokerFundsDetailVo.getFirstAuditId());
				detailEntity.setFirstAuditName(brokerFundsDetailVo.getFirstAuditName());
				brokerFundsDetailService.save(detailEntity);
				BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(detailEntity.getFundsControlMasterId()).get();
				masterEntity.setMasterStatus("40");
				// 判断当前资金流水主表中子表的状态如果全部审核完则置为"50"
				Integer noFinishCount = brokerFundsMasterRepository.queryNoFinishCount(detailEntity.getFundsControlMasterId(),detailEntity.getPlatformId());
				if(0==noFinishCount){
					masterEntity.setMasterStatus("50");
				}
				masterEntity.setModifyDate(new Date());
				masterEntity.setModifyPersonId(brokerFundsDetailVo.getFirstAuditId());
				masterEntity.setModifyPersonName(brokerFundsDetailVo.getFirstAuditName());
				brokerFundsMasterRepository.save(masterEntity);
				if("05".equals(brokerFundsDetailVo.getDetailStatus())){
					TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailEntity.getDeliveryId());
					deliveryEntity.setIfFundsControlFlag("1");
					deliveryEntity.setBrokerFundsControlMasterId(null);
					transportationDeliveryService.save(deliveryEntity);
				}

			}

	}

	//对单条资金流水进行第二次审核操作
	@Override
	@Transactional
	public void saveSecondAudit(BrokerFundsDetailVo brokerFundsDetailVo){
        HashMap resMap = new HashMap();
		logger.info("first audit brokerfundsDetail by fundsControlDetailIdStr",brokerFundsDetailVo.getFundsControlDetailIdStr());
		Assert.notNull(brokerFundsDetailVo.getFundsControlDetailIdStr(),"二次审核获取操作数据id失败");
		String[] FundsControlDetailIdArr = brokerFundsDetailVo.getFundsControlDetailIdStr().split(",");
		for(int num=0;num<FundsControlDetailIdArr.length;num++) {
			BrokerfundscontroldetailEntity detailEntity = brokerFundsDetailService.findById(Long.parseLong(FundsControlDetailIdArr[num].toString()));
			Assert.isTrue("20".equals(detailEntity.getDetailStatus()),"该资金流水单据的状态无法进行二审");
			detailEntity.setDetailStatus(brokerFundsDetailVo.getDetailStatus());
			if(!StringUtils.isEmpty(brokerFundsDetailVo.getDetailStatusRemark())){
				detailEntity.setDetailStatusRemark(brokerFundsDetailVo.getDetailStatusRemark());
			}
			//更新对应的资金流水单明细
			detailEntity.setSecondAuditDate(new Date());
			detailEntity.setSecondAuditId(brokerFundsDetailVo.getSecondAuditId());
			detailEntity.setSecondAuditName(brokerFundsDetailVo.getSecondAuditName());
			brokerFundsDetailService.save(detailEntity);
			BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(detailEntity.getFundsControlMasterId()).get();
			Integer noFinishCount = brokerFundsMasterRepository.queryNoFinishCount(detailEntity.getFundsControlMasterId(),detailEntity.getPlatformId());
			if(0==noFinishCount){
				masterEntity.setMasterStatus("50");
			}
			masterEntity.setModifyDate(new Date());
			masterEntity.setModifyPersonId(brokerFundsDetailVo.getSecondAuditId());
			masterEntity.setModifyPersonName(brokerFundsDetailVo.getSecondAuditName());
			brokerFundsMasterRepository.save(masterEntity);
			TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailEntity.getDeliveryId());
			if("05".equals(brokerFundsDetailVo.getDetailStatus())){
				deliveryEntity.setIfFundsControlFlag("1");
				deliveryEntity.setBrokerFundsControlMasterId(null);
                transportationDeliveryService.save(deliveryEntity);
			}
			if("30".equals(brokerFundsDetailVo.getDetailStatus())){
				deliveryEntity.setIfFundsControlFlag("2");
                transportationDeliveryService.save(deliveryEntity);
				//二审通过的时候调用存储过程
                logger.info("call  pro_broker_tax_process");
                ArrayList resList = (ArrayList)brokerFundsMasterRepository.saveSecondAuditPro(Integer.parseInt(detailEntity.getFundsControlDetailId().toString()),"10",brokerFundsDetailVo.getSecondAuditId().toString(),brokerFundsDetailVo.getSecondAuditName());
                logger.info(resList.toString());
                Object [] resArr = (Object [])resList.get(0);

                resMap.put("asResult", (String)resArr[0]);
                resMap.put("asResultReason", (String)resArr[1]);
                if(!"1".equals(resMap.get("asResult"))){
                    throw new RuntimeException(resMap.get("asResultReason").toString());
                }
			}

		}
	}

	/**
	 * 	增加经纪人上传流水
	 */
	@Override
	@Transactional
	public void addBrokerFundsMaster(BrokerFundsVo vo){
		logger.info("add BrokerFunds by fundsPic,createRemark",vo.getFundsPic(),vo.getCreateRemark());
		String fundsControllerMasterNum = getSeqNum("103");
		vo.setFundsControlMasterNum(fundsControllerMasterNum);
		vo.setCreateDate(new Date());
		vo.setModifyDate(new Date());
		vo.setModifyPersonId(vo.getCreatePersonId());
		vo.setModifyPersonName(vo.getCreatePersonName());
		BrokerfundscontrolmasterEntity entity = new BrokerfundscontrolmasterEntity();
		BeanUtils.copyProperties(vo,entity);
//		Long  companyPayeeId = brokerPayeeService.checkIfExist(vo.getBorkerCompanyId(),vo.getCompanyPayeeName(),vo.getCompanyPayeeNum(),vo.getCompanyPayeeCardNum(),"20");
//		if(companyPayeeId==null){
//			BrokerPayeeEntity payeeEntity = new BrokerPayeeEntity();
//			payeeEntity.setCompanyPayeeName(vo.getCompanyPayeeName());
//			payeeEntity.setCompanyPayeeNum(vo.getCompanyPayeeNum());
//		//	payeeEntity.setCompanyPayeeCardNum(vo.getCompanyPayeeCardNum());
//			payeeEntity.setCompanyId(vo.getBorkerCompanyId());
//			payeeEntity.setCompanyName(vo.getBorkerCompanyName());
//			payeeEntity.setCompanyPayeeStatus("20");
//			payeeEntity.setCreateDate(new Date());
//			payeeEntity.setCreatePersonId(vo.getCreatePersonId());
//			payeeEntity.setCreatePersonName(vo.getCreatePersonName());
//			payeeEntity.setModifyDate(new Date());
//			payeeEntity.setModifyPersonId(vo.getCreatePersonId());
//			payeeEntity.setModifyPersonName(vo.getCreatePersonName());
//			payeeEntity = brokerPayeeService.saveEntity(payeeEntity);
//			companyPayeeId = payeeEntity.getCompanyPayeeId();
//		}
//		entity.setCompanyPayeeId(companyPayeeId);
		brokerFundsMasterRepository.save(entity);
	}

	/**
	 * 	作废资金流水主单
	 */
	@Override
	@Transactional
	public void invalidMaster(BrokerFundsVo vo){
		logger.info("invalid  brokerFundsMaster  by fundsControlMasterId{}",vo.getFundsControlMasterId());
		BrokerfundscontrolmasterEntity maserEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
		maserEntity.setMasterStatus("00");
		maserEntity.setModifyPersonId(vo.getModifyPersonId());
		maserEntity.setModifyPersonName(vo.getModifyPersonName());
		maserEntity.setModifyDate(new Date());
		brokerFundsMasterRepository.save(maserEntity);
		List<BrokerfundscontroldetailEntity> detailEntityList=brokerFundsDetailService.findByFundsControlMasterId(vo.getFundsControlMasterId());
		for(BrokerfundscontroldetailEntity detailEntity:detailEntityList){
			//brokerFundsDetailService.deleteById(detailEntity.getFundsControlDetailId());
			detailEntity.setDetailStatus("00");
			brokerFundsDetailService.save(detailEntity);
			TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailEntity.getDeliveryId());
			deliveryEntity.setBrokerFundsControlMasterId(null);
			deliveryEntity.setIfFundsControlFlag("1");
			transportationDeliveryService.save(deliveryEntity);
		}
	}

	/**
	 * 	提交资金流水主单
	 */
	@Override
	@Transactional
	public void offerMaster(BrokerFundsVo vo){
		logger.info("offer  brokerFundsMaster  by fundsControlMasterId{}",vo.getFundsControlMasterId());
		Integer count = brokerFundsPayeeInfoService.countByFundsControlMasterId(vo.getFundsControlMasterId());
		if(count==null || count==0){
			throw new RuntimeException("该条资金流水单不存在分配信息，无法进行提交审核操作！");
		}
		if(count>2){
			throw new RuntimeException("该条资金流水单的分配信息不能超过两条！");
		}
		Integer detailCount = brokerFundsDetailService.countByFundsControlMasterId(vo.getFundsControlMasterId());
		if(detailCount ==null || detailCount ==0){
            throw new RuntimeException("该条资金流水单不存在明细，无法进行提交审核操作！");
        }
        BigDecimal payeeInfoAmount = brokerFundsPayeeInfoService.getPayeeInfoAmount(vo.getFundsControlMasterId());
		BigDecimal detailAmount = brokerFundsDetailService.getDetailAmount(vo.getFundsControlMasterId());
		Assert.isTrue(payeeInfoAmount.compareTo(detailAmount)==0,"分配的总金额与实际的明细总金额不符，无法进行提交审核操作！");
		BrokerfundscontrolmasterEntity maserEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
		maserEntity.setMasterStatus("15");
		maserEntity.setModifyPersonId(vo.getModifyPersonId());
		maserEntity.setModifyPersonName(vo.getModifyPersonName());
		maserEntity.setModifyDate(new Date());
		brokerFundsMasterRepository.save(maserEntity);
        List<BrokerFundsPayeeInfoEntity> list = brokerFundsPayeeInfoService.findByFundsControlMasterId(vo.getFundsControlMasterId());
        for(int i=0;i<list.size();i++){
            BrokerFundsPayeeInfoEntity payeeInfoEntity = list.get(i);
            payeeInfoEntity.setBrokerTaxCycleName(maserEntity.getBrokerTaxCycleName());
            brokerFundsPayeeInfoService.save(payeeInfoEntity);
        }

		List<BrokerfundscontroldetailEntity> detailEntityList=brokerFundsDetailService.findByFundsControlMasterId(vo.getFundsControlMasterId());
		for(BrokerfundscontroldetailEntity detailEntity:detailEntityList){
			//brokerFundsDetailService.deleteById(detailEntity.getFundsControlDetailId());
			detailEntity.setDetailStatus("15");
			brokerFundsDetailService.save(detailEntity);
		}

			HashMap  resMap = new HashMap();
			logger.info("call  check payee limit pro");
			//15代表提交的时候封锁一部分金额
			ArrayList resList = (ArrayList)brokerFundsPayeeInfoService.checkPayeeAmountPro(Integer.parseInt(vo.getFundsControlMasterId().toString()),"15",vo.getModifyPersonId().toString(),vo.getModifyPersonName());
			logger.info(resList.toString());
			Object [] resArr = (Object [])resList.get(0);

			resMap.put("asResult", (String)resArr[0]);
			resMap.put("asResultReason", (String)resArr[1]);
			if(!"1".equals(resMap.get("asResult"))){
				throw new RuntimeException(resMap.get("asResultReason").toString());
			}
	}



	/**
	 * 	查询可以添加进入资金流水明细的调度单信息
	 */
	@Override
	public Page<BrokerFundsDetailVo> addBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo){
		logger.info(vo.toString());
		return brokerFundsMasterRepository.addBrokerFundsMasterDetailList(vo);

	}
	/**
	 * 	查询添加进入经纪人资金流水明细的调度单信息
	 */
	@Override
	public Page<BrokerFundsDetailVo> lookBrokerFundsMasterDetailList(BrokerFundsDetailQueryVo vo){
		logger.info(vo.toString());
		return brokerFundsMasterRepository.lookBrokerFundsMasterDetailList(vo);
	}

	/**
	 * 	增加经纪人上传流水明细
	 */
	@Override
	@Transactional
	public void addDetailToBrokerFundsMaster(BrokerFundsDetailQueryVo vo){
		String[] payBillIdArr = vo.getPayBillIdStr().split(",");
		BrokerfundscontrolmasterEntity brokerfundscontrolmasterEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
		Assert.isTrue("10".equals(brokerfundscontrolmasterEntity.getMasterStatus()),"当前资金流水主单不是新增状态无法进行添加明细的操作！");
		for(int i=0;i<payBillIdArr.length;i++){
		//	brokerfundscontrolmasterEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
			BrokerFundsVo brokerFundsVo = new BrokerFundsVo();
			BrokerfundscontroldetailEntity detailEntity = new  BrokerfundscontroldetailEntity();
			brokerFundsVo.setPlatformId(vo.getPlatformId());
			brokerFundsVo.setBorkerCompanyId(vo.getCompanyId());
			brokerFundsVo.setZfId(Long.parseLong(payBillIdArr[i]));
			BrokerFundsDetailVo detailVo = brokerFundsMasterRepository.getBrokerFundsDetailVo(brokerFundsVo);
			//判断出属于第几季度,属于哪个经纪人持卡人id
			if(detailVo.getCompanyOwnerId()!=null && detailVo.getCompanyOwnerId()!=0){
				 if(brokerfundscontrolmasterEntity.getCompanyOwnerId()==null || brokerfundscontrolmasterEntity.getCompanyOwnerId()==0) {
					 brokerfundscontrolmasterEntity.setCompanyOwnerId(detailVo.getCompanyOwnerId());
				 }else{
				 	Assert.isTrue(detailVo.getCompanyOwnerId().intValue()
							== brokerfundscontrolmasterEntity.getCompanyOwnerId().intValue(),"必须选择相同运单收款人的单据！");
				 }
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String brokerTaxYearMonth =sdf.format(detailVo.getPayFinishDate());
			String brokerTaxCycleName = brokerTaxCycleService.getBrokerTaxCycleName(brokerTaxYearMonth);
			Assert.notNull(brokerTaxCycleName,"存在单据的支付完成时间不在季度表区间！");
			if(brokerfundscontrolmasterEntity.getBrokerTaxCycleName()==null){
				brokerfundscontrolmasterEntity.setBrokerTaxCycleName(brokerTaxCycleName);
			}
			else{
				Assert.isTrue(brokerfundscontrolmasterEntity.getBrokerTaxCycleName().equals(brokerTaxCycleName),"存在单据不在同一个季度内！");
			}
			brokerfundscontrolmasterEntity=brokerFundsMasterRepository.save(brokerfundscontrolmasterEntity);
			BeanUtils.copyProperties(detailVo,detailEntity);
			TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailVo.getDeliveryId());
			detailEntity.setFundsControlMasterId(vo.getFundsControlMasterId());
			detailEntity.setFundsControlMasterNum(brokerfundscontrolmasterEntity.getFundsControlMasterNum());
			detailEntity.setCreatePersonId(vo.getUserId());
			detailEntity.setCreateDate(new Date());
			detailEntity.setCreatePersonName(vo.getUserName());
			detailEntity.setBrokerTaxCycleName(brokerTaxCycleName);
			//目前已无用，因为可以上传多张图片
		//	deliveryEntity.setFundsControlPic(brokerfundscontrolmasterEntity.getFundsPic());
			deliveryEntity.setBrokerFundsControlMasterId(vo.getFundsControlMasterId());
			deliveryEntity.setIfFundsControlFlag("3");
			transportationDeliveryService.save(deliveryEntity);
			brokerFundsDetailService.save(detailEntity);
		}
	}

	/**
	 * 	删除经纪人上传流水明细
	 */
	@Override
	@Transactional
	public void deleteBrokerFundsMasterDetail(BrokerFundsDetailQueryVo vo){
		String[] fundsControlDetailIdArr = vo.getFundsControlDetailIdStr().split(",");
		BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
        Assert.isTrue("10".equals(masterEntity.getMasterStatus()),"当前资金流水主单不是新增状态无法进行删除明细的操作！");
		for(int i=0; i < fundsControlDetailIdArr.length; i++){
			vo.setFundsControlDetailId(Long.parseLong(fundsControlDetailIdArr[i].toString()));
			brokerFundsDetailService.updateDeliveryFundsFlag(vo.getFundsControlDetailId());
			brokerFundsDetailService.deleteById(vo.getFundsControlDetailId());
		}
		List<BrokerfundscontroldetailEntity> list = brokerFundsDetailService.findByFundsControlMasterId(vo.getFundsControlMasterId());
		if(list==null || list.size()==0){
			masterEntity.setBrokerTaxCycleName(null);
			masterEntity.setCompanyOwnerId(0);
		}
		//查询删除部分明细后查看主单下面是否存在不为0或者null的明细
		List<BrokerfundscontroldetailEntity> detailList = brokerFundsDetailService.findAllDetailInfo(vo.getFundsControlMasterId());
		if(detailList==null||detailList.size()==0){
			masterEntity.setCompanyOwnerId(0);
		}
		brokerFundsMasterRepository.save(masterEntity);
	}
    /**
     * 	经纪人的资金流水单明细导出
     */
    @Override
    @Transactional
    public List<BrokerFundsDetailVo> excelBrokerFunds(BrokerFundsDetailQueryVo vo){
        logger.info(vo.toString());
        return brokerFundsMasterRepository.excelBrokerFunds(vo);
    }

	/**
	 * 	经纪人资金分配导入
	 */
	@Override
	@Transactional
	public String uploadBrokerFunds(List<BrokerFundsUploadVo> excelList,Long companyId, Long fundsControlMasterId){
		String returnMsg="";
		//记录总共导入的行数
		int sumRow=0;
		int successRow=0;
		String notCorrectFundsMaster=""; //代表当前导入的资金流水明细不是当前的
		String notCurrectAmount ="";//代表导入的资金金额不在有效的金额区间之内
		String nullData="";//代表导入的明细信息主要字段为空
		BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(fundsControlMasterId).get();
		Assert.isTrue(!"40".equals(masterEntity.getMasterStatus()) && !"50".equals(masterEntity.getMasterStatus()),"当前资金流水主单已开始审核或者已审核完成，无法进行当前操作！");
		Assert.isTrue(!"00".equals(masterEntity.getMasterStatus()),"当前资金流水主单已作废！");
		for(int i=0;i<excelList.size();i++){
			sumRow++;
			BrokerFundsUploadVo brokerFundsUploadVo = excelList.get(i);
			if(brokerFundsUploadVo.getFundsControlDetailId()==null|| "".equals(brokerFundsUploadVo.getFundsControlDetailId()) || brokerFundsUploadVo.getFcCarryAmount()==null||"".equals(brokerFundsUploadVo.getFcCarryName())||brokerFundsUploadVo.getFcCarryName()==null){
				nullData ="".equals(nullData)? ""+(i+1):","+(i+1);
				continue;
			}
			try{
				Long.parseLong(brokerFundsUploadVo.getFundsControlDetailId());
			}catch (Exception e){
				notCorrectFundsMaster = "".equals(notCorrectFundsMaster)? ""+(i+1):","+(i+1);
				continue;
			}
			BrokerfundscontroldetailEntity detailEntity = brokerFundsDetailService.findById(Long.parseLong(brokerFundsUploadVo.getFundsControlDetailId()));
			if(detailEntity.getFundsControlMasterId()==null || detailEntity.getFundsControlMasterId()!=fundsControlMasterId){
				notCorrectFundsMaster = "".equals(notCorrectFundsMaster)? ""+(i+1):","+(i+1);
				continue;
			}
			BrokerFundsVo brokerFundsVo = new BrokerFundsVo();
			brokerFundsVo.setPlatformId(masterEntity.getPlatformId());
			brokerFundsVo.setBorkerCompanyId(masterEntity.getBorkerCompanyId());
			brokerFundsVo.setZfId(detailEntity.getPayBillId());
			BrokerFundsDetailVo detailVo = brokerFundsMasterRepository.getBrokerFundsDetailVo(brokerFundsVo);
			if(detailVo.getPayCarryMinAmt()==null){
				detailVo.setPayCarryMinAmt(new BigDecimal(0));
			}
			if(brokerFundsUploadVo.getFcCarryAmount().compareTo(detailVo.getPayJjrAmount())==1 || brokerFundsUploadVo.getFcCarryAmount().compareTo(detailVo.getPayCarryMinAmt())==-1){
				notCurrectAmount ="".equals(notCurrectAmount)? ""+(i+1):","+(i+1);
				continue;
			}
			detailEntity.setFcCarryName(brokerFundsUploadVo.getFcCarryName());
			detailEntity.setFcCarryAmount(brokerFundsUploadVo.getFcCarryAmount());
			detailEntity.setFcIfUpload(1);
			successRow++;
			brokerFundsDetailService.save(detailEntity);

		}
		//判断当前主单下所有上传和未上传流水单的数目如果都已上传则将主单置为30，
		Integer noFcUploadCount = brokerFundsDetailService.countByFundsControlMasterIdAndFcIfUpload(fundsControlMasterId,0);
		Integer hasFcUploadCount = brokerFundsDetailService.countByFundsControlMasterIdAndFcIfUpload(fundsControlMasterId,1);
		if(noFcUploadCount==0) {
			masterEntity.setMasterStatus("30");
		}
		else if(hasFcUploadCount==0) {
			masterEntity.setMasterStatus("10");
		}else{
			masterEntity.setMasterStatus("20");
		}
		brokerFundsMasterRepository.save(masterEntity);
		returnMsg = "总共"+sumRow+"条，成功"+successRow+"条";
		if(nullData!=""){
			returnMsg += ",第"+nullData +"条单据的流水号或分配信息为空。";
		}
		if(notCorrectFundsMaster!=""){
			returnMsg += ",第"+notCorrectFundsMaster +"条单据不属于当前资金流水单。";
		}
		if(notCurrectAmount!=""){
			returnMsg += ",第"+notCurrectAmount +"条的资金流水明细分配金额不在有效区间内。";
		}
		return returnMsg;
		}

    //保存单条资金流水上传记录
    @Override
    @Transactional
    public void saveFpInfo(BrokerFundsDetailVo brokerFundsDetailVo) {
	    BrokerfundscontroldetailEntity detailEntity = brokerFundsDetailService.findById(brokerFundsDetailVo.getFundsControlDetailId());
        BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(detailEntity.getFundsControlMasterId()).get();
        Assert.isTrue(!"40".equals(masterEntity.getMasterStatus()) && !"50".equals(masterEntity.getMasterStatus()),"当前资金流水主单已开始审核或者已审核完成，无法进行删除明细操作！");
        Assert.isTrue(!"00".equals(masterEntity.getMasterStatus()),"当前资金流水主单已作废！");
        detailEntity.setFcCarryAmount(brokerFundsDetailVo.getFcCarryAmount());
        detailEntity.setFcCarryName(brokerFundsDetailVo.getFcCarryName());
        detailEntity.setFcIfUpload(1);
        brokerFundsDetailService.save(detailEntity);
        //判断当前主单下所有上传和未上传流水单的数目如果都已上传则将主单置为30，
        Integer noFcUploadCount = brokerFundsDetailService.countByFundsControlMasterIdAndFcIfUpload(detailEntity.getFundsControlMasterId(),0);
        Integer hasFcUploadCount = brokerFundsDetailService.countByFundsControlMasterIdAndFcIfUpload(detailEntity.getFundsControlMasterId(),1);
        if(noFcUploadCount==0) {
            masterEntity.setMasterStatus("30");
        }
        else if(hasFcUploadCount==0) {
            masterEntity.setMasterStatus("10");
        }else{
            masterEntity.setMasterStatus("20");
        }
        masterEntity.setModifyDate(new Date());
        masterEntity.setModifyPersonId(brokerFundsDetailVo.getCreatePersonId());
        masterEntity.setModifyPersonName(brokerFundsDetailVo.getCreatePersonName());
        brokerFundsMasterRepository.save(masterEntity);

    }

	//查询经纪人经纪单主单审核查询
	@Override
	public Page<BrokerFundsVo> masterAuditList(BrokerFundsQueryVo queryvo) {
		logger.info("query brokerFundsMaster  auditList by brokerCompanyId{}",queryvo.getCompanyId());
		return brokerFundsMasterRepository.masterAuditList(queryvo);
	}


	//对资金流水进行第一次审核操作
	@Override
	@Transactional
	public void saveFirstMasterAudit(BrokerFundsVo brokerFundsVo){
		logger.info("first audit brokerfundsMaster by fundsControlMasterIdStr:{}",brokerFundsVo.getFundsControlMasterIdStr());
		Assert.notNull(brokerFundsVo.getFundsControlMasterIdStr(),"一次审核获取操作数据id失败");
		String[] fundsControlMasterIdArr = brokerFundsVo.getFundsControlMasterIdStr().split(",");
		for(int num=0;num<fundsControlMasterIdArr.length;num++) {
			BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(Long.parseLong(fundsControlMasterIdArr[num])).get();
			Assert.isTrue("15".equals(masterEntity.getMasterStatus()),"当前资金流水单的状态已发生变化，请刷新页面重试！");
			masterEntity.setMasterStatus(brokerFundsVo.getMasterStatus());
			if(StringUtils.isNotEmpty(brokerFundsVo.getMasterStatusRemark())){
				masterEntity.setMasterStatusRemark(brokerFundsVo.getMasterStatusRemark());
			}
			masterEntity.setFirstAuditDate(new Date());
			masterEntity.setFirstAuditId(brokerFundsVo.getFirstAuditId());
			masterEntity.setFirstAuditName(brokerFundsVo.getFirstAuditName());
			masterEntity= brokerFundsMasterRepository.save(masterEntity);
			List<BrokerfundscontroldetailEntity> detailEntityList = brokerFundsDetailService.findByFundsControlMasterId(masterEntity.getFundsControlMasterId());
			for(int detailEntityListCount =0;detailEntityListCount < detailEntityList.size();detailEntityListCount++){
				BrokerfundscontroldetailEntity detailEntity = detailEntityList.get(detailEntityListCount);
				detailEntity.setDetailStatus(brokerFundsVo.getMasterStatus());
				detailEntity.setFirstAuditDate(new Date());
				detailEntity.setFirstAuditId(brokerFundsVo.getFirstAuditId());
				detailEntity.setFirstAuditName(brokerFundsVo.getFirstAuditName());
				if(StringUtils.isNotEmpty(brokerFundsVo.getMasterStatusRemark())){
					detailEntity.setDetailStatusRemark(brokerFundsVo.getMasterStatusRemark());
				}
				if("05".equals(brokerFundsVo.getMasterStatus())){
					TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailEntity.getDeliveryId());
					deliveryEntity.setIfFundsControlFlag("1");
					deliveryEntity.setBrokerFundsControlMasterId(null);
					transportationDeliveryService.save(deliveryEntity);
				}
			}
			if("05".equals(brokerFundsVo.getMasterStatus())){
				HashMap  resMap = new HashMap();
				logger.info("call  check payee limit pro");
				//15代表提交的时候封锁一部分金额
				ArrayList resList = (ArrayList)brokerFundsPayeeInfoService.checkPayeeAmountPro(Integer.parseInt(masterEntity.getFundsControlMasterId().toString()),brokerFundsVo.getMasterStatus(),brokerFundsVo.getFirstAuditId().toString(),brokerFundsVo.getFirstAuditName());
				logger.info(resList.toString());
				Object [] resArr = (Object [])resList.get(0);

				resMap.put("asResult", (String)resArr[0]);
				resMap.put("asResultReason", (String)resArr[1]);
				if(!"1".equals(resMap.get("asResult"))){
					throw new RuntimeException(resMap.get("asResultReason").toString());
				}
			}
		}
	}

	//对资金流水进行第二次审核操作
	@Override
	@Transactional
	public void saveSecondMasterAudit(BrokerFundsVo brokerFundsVo){
		HashMap resMap = new HashMap();
		logger.info("second audit brokerfundsMaster by fundsControlMasterIdStr:{}",brokerFundsVo.getFundsControlMasterIdStr());
		Assert.notNull(brokerFundsVo.getFundsControlMasterIdStr(),"一次审核获取操作数据id失败");
		String[] fundsControlMasterIdArr = brokerFundsVo.getFundsControlMasterIdStr().split(",");
		for(int num=0;num<fundsControlMasterIdArr.length;num++) {
			BrokerfundscontrolmasterEntity masterEntity = brokerFundsMasterRepository.findById(Long.parseLong(fundsControlMasterIdArr[num])).get();
			Assert.isTrue("20".equals(masterEntity.getMasterStatus()),"当前资金流水单的状态已发生变化，请刷新页面重试！");
			masterEntity.setMasterStatus(brokerFundsVo.getMasterStatus());
			if(StringUtils.isNotEmpty(brokerFundsVo.getMasterStatusRemark())){
				masterEntity.setMasterStatusRemark(brokerFundsVo.getMasterStatusRemark());
			}
			masterEntity.setSecondAuditDate(new Date());
			masterEntity.setSecondAuditId(brokerFundsVo.getSecondAuditId());
			masterEntity.setSecondAuditName(brokerFundsVo.getSecondAuditName());
			masterEntity= brokerFundsMasterRepository.save(masterEntity);
			List<BrokerfundscontroldetailEntity> detailEntityList = brokerFundsDetailService.findByFundsControlMasterId(masterEntity.getFundsControlMasterId());
			for(int detailEntityListCount =0;detailEntityListCount < detailEntityList.size();detailEntityListCount++) {
				BrokerfundscontroldetailEntity detailEntity = detailEntityList.get(detailEntityListCount);
				detailEntity.setDetailStatus(brokerFundsVo.getMasterStatus());
				detailEntity.setSecondAuditDate(new Date());
				detailEntity.setSecondAuditId(brokerFundsVo.getSecondAuditId());
				detailEntity.setSecondAuditName(brokerFundsVo.getSecondAuditName());
				if (StringUtils.isNotEmpty(brokerFundsVo.getMasterStatusRemark())) {
					detailEntity.setDetailStatusRemark(brokerFundsVo.getMasterStatusRemark());
				}
				TransportationDeliveryEntity deliveryEntity = transportationDeliveryService.findById(detailEntity.getDeliveryId());
				if ("05".equals(brokerFundsVo.getMasterStatus())) {
					deliveryEntity.setIfFundsControlFlag("1");
					deliveryEntity.setBrokerFundsControlMasterId(null);
					transportationDeliveryService.save(deliveryEntity);
				}
				if ("30".equals(brokerFundsVo.getMasterStatus())) {
					deliveryEntity.setIfFundsControlFlag("2");
					transportationDeliveryService.save(deliveryEntity);
				}
			}
			logger.info("call  check payee limit pro");
			//15代表提交的时候封锁一部分金额
			ArrayList resList = (ArrayList)brokerFundsPayeeInfoService.checkPayeeAmountPro(Integer.parseInt(masterEntity.getFundsControlMasterId().toString()),brokerFundsVo.getMasterStatus(),brokerFundsVo.getSecondAuditId().toString(),brokerFundsVo.getSecondAuditName());
			logger.info(resList.toString());
			Object [] resArr = (Object [])resList.get(0);

			resMap.put("asResult", (String)resArr[0]);
			resMap.put("asResultReason", (String)resArr[1]);
			if(!"1".equals(resMap.get("asResult"))){
				throw new RuntimeException(resMap.get("asResultReason").toString());
			}
		}
	}


	/**
	 * 	增加经纪人流水单分配信息
	 */
	@Override
	@Transactional
	public void addPayeeDetail(BrokerFundsVo vo){
		logger.info("add addPayeeDetail by fundsControlMasterId",vo.getFundsControlMasterId());
		Assert.notNull(vo.getFundsControlMasterId(),"资金流水单id丢失！");
		Long  companyPayeeId = brokerPayeeService.checkIfExist(vo.getBorkerCompanyId(),vo.getCompanyPayeeName(),vo.getCompanyPayeeNum(),"20");
		if(companyPayeeId==null){
			BrokerPayeeEntity payeeEntity = new BrokerPayeeEntity();
			payeeEntity.setCompanyPayeeName(vo.getCompanyPayeeName());
			payeeEntity.setCompanyPayeeNum(vo.getCompanyPayeeNum());
		//	payeeEntity.setCompanyPayeeCardNum(vo.getCompanyPayeeCardNum());
			payeeEntity.setCompanyId(vo.getBorkerCompanyId());
			payeeEntity.setCompanyName(vo.getBorkerCompanyName());
			payeeEntity.setCompanyPayeeStatus("20");
			payeeEntity.setCreateDate(new Date());
			payeeEntity.setCreatePersonId(vo.getCreatePersonId());
			payeeEntity.setCreatePersonName(vo.getCreatePersonName());
			payeeEntity.setModifyDate(new Date());
			payeeEntity.setModifyPersonId(vo.getCreatePersonId());
			payeeEntity.setModifyPersonName(vo.getCreatePersonName());
			payeeEntity = brokerPayeeService.saveEntity(payeeEntity);
			companyPayeeId = payeeEntity.getCompanyPayeeId();
		}
		BrokerFundsPayeeInfoEntity  brokerFundsPayeeInfoEntity= brokerFundsPayeeInfoService.findByFundsControlMasterIdAndCompanyPayeeId(vo.getFundsControlMasterId(),companyPayeeId);
		Assert.isNull(brokerFundsPayeeInfoEntity,"该条收款信息已添加过，请勿重复添加！");
		BrokerFundsPayeeInfoEntity payeeInfoEntity = new BrokerFundsPayeeInfoEntity();
		payeeInfoEntity.setFundsControlMasterId(vo.getFundsControlMasterId());
		payeeInfoEntity.setCompanyPayeeId(companyPayeeId);
		payeeInfoEntity.setCompanyPayeeName(vo.getCompanyPayeeName());
		payeeInfoEntity.setCompanyPayeeNum(vo.getCompanyPayeeNum());
		payeeInfoEntity.setCompanyPayeeAmount(vo.getCompanyPayeeAmount());
		//	payeeEntity.setCompanyPayeeCardNum(vo.getCompanyPayeeCardNum());
		payeeInfoEntity.setCompanyId(vo.getBorkerCompanyId());
		payeeInfoEntity.setCompanyName(vo.getBorkerCompanyName());
		payeeInfoEntity.setCreateDate(new Date());
		payeeInfoEntity.setCreatePersonId(vo.getCreatePersonId());
		payeeInfoEntity.setCreatePersonName(vo.getCreatePersonName());
		payeeInfoEntity.setModifyDate(new Date());
		payeeInfoEntity.setModifyPersonId(vo.getCreatePersonId());
		payeeInfoEntity.setModifyPersonName(vo.getCreatePersonName());
		brokerFundsPayeeInfoService.save(payeeInfoEntity);

	}

	/**
	 * 	删除经纪人流水单分配信息
	 */
	@Override
	@Transactional
	public void deletePayeeDetail(BrokerFundsPayeeInfoVo vo){
		logger.info("deletePayeeDetail by getBrokerFundsPayeeInfoIdStr{}:",vo.getBrokerFundsPayeeInfoIdStr());
		Assert.notNull(vo.getFundsControlMasterId(),"资金流水单id丢失！");
		Assert.notNull(vo.getBrokerFundsPayeeInfoIdStr(),"操作单据丢失！");
		String[] payeeInfoArr= vo.getBrokerFundsPayeeInfoIdStr().split(",");
		for(int count=0;count<payeeInfoArr.length;count++){
			brokerFundsPayeeInfoService.deleteById(Long.parseLong(payeeInfoArr[count]));
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
	@Transactional
	public void uploadBrokerFundsPic(BrokerFundsVo vo) {
		logger.info("upload BrokerFunds by fundsPic:{},createRemark:{}",vo.getFundsPic());
		BrokerfundscontrolmasterEntity brokerfundscontrolmasterEntity = brokerFundsMasterRepository.findById(vo.getFundsControlMasterId()).get();
		Assert.notNull(brokerfundscontrolmasterEntity,"资金流水单不存在！");
		if(StringUtils.isNotEmpty(vo.getFundsPic())){
			brokerfundscontrolmasterEntity.setFundsPic(vo.getFundsPic());
		}
		if(StringUtils.isNotEmpty(vo.getFundsPicSec())){
			brokerfundscontrolmasterEntity.setFundsPicSec(vo.getFundsPicSec());
		}
		if(StringUtils.isNotEmpty(vo.getFundsPicThi())){
			brokerfundscontrolmasterEntity.setFundsPicThi(vo.getFundsPicThi());
		}
		// 更新资金流水图片
		brokerFundsMasterRepository.save(brokerfundscontrolmasterEntity);
	}

	@Override
	@Transactional
	public void removeBrokerFundsPic(Long fundsControlMasterId) {
		logger.info("remove BrokerFunds by fundsPic:{},createRemark:{}",fundsControlMasterId);
		BrokerfundscontrolmasterEntity brokerfundscontrolmasterEntity = brokerFundsMasterRepository.findById(fundsControlMasterId).get();
		Assert.notNull(brokerfundscontrolmasterEntity,"资金流水单不存在！");
		brokerfundscontrolmasterEntity.setFundsPic(null);
		brokerfundscontrolmasterEntity.setFundsPicSec(null);
		brokerfundscontrolmasterEntity.setFundsPicThi(null);
		brokerFundsMasterRepository.save(brokerfundscontrolmasterEntity);
	}
}
