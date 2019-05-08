package com.brcc.business.agencyInvoice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.brcc.business.agencyInvoice.entity.ReinvoicedetailEntity;
import com.brcc.business.agencyInvoice.entity.ReinvoicemasterEntity;
import com.brcc.business.agencyInvoice.entity.ReinvoicetempEntity;
import com.brcc.business.agencyInvoice.service.AgencyInvoiceService;
import com.brcc.business.agencyInvoice.service.ReinvoiceDetailService;
import com.brcc.business.agencyInvoice.service.ReinvoiceMasterService;
import com.brcc.business.agencyInvoice.service.ReinvoiceTempService;
import com.brcc.business.agencyInvoice.vo.AddAgencyInvoiceVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceQueryVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceUploadVo;
import com.brcc.business.agencyInvoice.vo.AgencyInvoiceVo;
import com.brcc.business.config.mybatis.MybatisQuery;

/**
 * 代开票管理
 * 
 * @author hui.liu
 * @date 2018年12月13日
 */
@Service
public class AgencyInvoiceServiceImpl implements AgencyInvoiceService {

    Logger logger = LoggerFactory.getLogger(AgencyInvoiceServiceImpl.class);
    
    @Autowired
    private MybatisQuery mybatisQuery;
    
    @Autowired
    private ReinvoiceMasterService reinvoiceMasterService;
    
    @Autowired
    private ReinvoiceDetailService reinvoiceDetailService;
    
    @Autowired
    private ReinvoiceTempService reinvoiceTempService;

	@Override
	public Page<AgencyInvoiceVo> queryAgencyInvoiceList(AgencyInvoiceQueryVo queryVo) {
		logger.info("queryAgencyInvoiceList,{}", queryVo.toString());
		return mybatisQuery.page("agencyInvoice.list", queryVo);
	}

	@Override
	@Transactional
	public void addAgencyInvoice(AddAgencyInvoiceVo addVo) {
		Assert.notNull(addVo, "新增参数不能为空");
		logger.info("addAgencyInvoice,{}", addVo.toString());
		
		String rqStartDlg = addVo.getRqStartDlg();
		Assert.isTrue(!StringUtils.isEmpty(rqStartDlg), "代开票日期不能为空");
		
		Long minAmount = addVo.getMinAmount();
		Assert.isTrue(minAmount != null && minAmount > 0, "最少开票金额不能为空");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("companyId", addVo.getCompanyId().toString());
		paramMap.put("rqStartDlg", addVo.getRqStartDlg());
		paramMap.put("minAmount", addVo.getMinAmount().toString());
		paramMap.put("userId", addVo.getUserId().toString());
		paramMap.put("userName", addVo.getUserName());
		paramMap.put("outResult", "");
		paramMap.put("outResultReason", "");
		
		// 调用存储过程
		mybatisQuery.selectOne("agencyInvoice.addAgencyInvoicePro", paramMap);
		// 处理返回的结果(0表示有异常)
		if (!"1".equals(paramMap.get("outResult"))) {
			logger.error((String) paramMap.get("outResultReason"));
			throw new RuntimeException((String) paramMap.get("outResultReason"));
		}
	}

	@Override
	@Transactional
	public Integer upLoadInvoiceNo(List<AgencyInvoiceUploadVo> uploadVoList, String platformId, Long userId,
			String userName) {
		Assert.isTrue(!CollectionUtils.isEmpty(uploadVoList), "发票编号上传数据不能为空");
		logger.info("upLoadInvoiceNo,上传数：{}", uploadVoList.size());
		
		// 处理成功数
		int successCount = 0;
		String batchId = String.valueOf(System.currentTimeMillis());
		Date now = new Date();
		
		//限制条数
		int pointsDataLimit = 50;
        Integer size = uploadVoList.size();
        if (pointsDataLimit < size) {
        	//判断是否有必要分批
            int part = size / pointsDataLimit;//分批数
            logger.info("共有 ： " + size + "条，！" + " 分为 ：" + part + "批");
            for (int i = 0; i < part; i++) {
                List<AgencyInvoiceUploadVo> listPage = uploadVoList.subList(0, pointsDataLimit);
                logger.info("第" + (i + 1) + "次,执行处理");
                successCount += excuteData(listPage, platformId, userId, userName, batchId, now);
                
                uploadVoList.subList(0, pointsDataLimit).clear();
            }
            if (!uploadVoList.isEmpty()) {
            	logger.info("最后一批数据,执行处理:" + uploadVoList.size());
            	successCount += excuteData(uploadVoList, platformId, userId, userName, batchId, now);
            }
        } else {
        	logger.info("不需要分批,执行处理");
        	successCount = excuteData(uploadVoList, platformId, userId, userName, batchId, now);
        }
		
		return successCount;
	}
	
	@Transactional
	private Integer excuteData(List<AgencyInvoiceUploadVo> uploadVoList, String platformId, Long userId,
			String userName, String batchId, Date now) {
		int successCount = 0;
		
		List<String> reinvoiceMasterNumList = new ArrayList<>();
		for(AgencyInvoiceUploadVo uploadVo : uploadVoList) {
			reinvoiceMasterNumList.add(uploadVo.getReinvoiceMasterNum());
		}
		
		// 获取代开票主项列表
		List<ReinvoicemasterEntity> masterList = reinvoiceMasterService.getReinvoiceMasterList(reinvoiceMasterNumList, platformId);
		Map<String, List<ReinvoicemasterEntity>> masterMap = initMasterMap(masterList);
		
		// 获取代开票明细列表
		Map<Long, List<ReinvoicedetailEntity>> detailMap = initDetailMap(masterList, platformId);
		
		List<ReinvoicetempEntity> reinvoiceTempList = new ArrayList<>();
		List<ReinvoicemasterEntity> updateMasterList = new ArrayList<>();
		List<ReinvoicedetailEntity> updateDetailList = new ArrayList<>();
		for(AgencyInvoiceUploadVo uploadVo : uploadVoList) {
			String reinvoiceMasterNum = uploadVo.getReinvoiceMasterNum();
			String reinvoiceNo = uploadVo.getReinvoiceNo();
			Date reinvoiceAgreeTime = uploadVo.getReinvoiceAgreeTime();
			
			boolean isUpdate = false;
			// 获取需更新的代开票主表
			List<ReinvoicemasterEntity> reinvoicemasterList = masterMap.get(reinvoiceMasterNum);
			if(!CollectionUtils.isEmpty(reinvoicemasterList)) {
				for(ReinvoicemasterEntity reinvoicemasterEntity : reinvoicemasterList) {
					List<ReinvoicedetailEntity> detailList = detailMap.get(reinvoicemasterEntity.getReinvoiceMasterId());
					if(!CollectionUtils.isEmpty(detailList)) {
						isUpdate = true;
						
						reinvoicemasterEntity.setReinvoiceNo(reinvoiceNo);
						reinvoicemasterEntity.setReinvoiceTime(reinvoiceAgreeTime);
						reinvoicemasterEntity.setReinvoiceStatus("30");
						reinvoicemasterEntity.setModifyDate(now);
						reinvoicemasterEntity.setModifyPersonId(userId);
						reinvoicemasterEntity.setModifyPersonName(userName);
						
						updateMasterList.add(reinvoicemasterEntity);
						
						for(ReinvoicedetailEntity reinvoicedetailEntity : detailList) {
							reinvoicedetailEntity.setReinvoiceNo(reinvoiceNo);
							reinvoicedetailEntity.setReinvoiceStatus("30");
							reinvoicedetailEntity.setModifyDate(now);
							reinvoicedetailEntity.setModifyPersonId(userId);
							reinvoicedetailEntity.setModifyPersonName(userName);
							
							updateDetailList.add(reinvoicedetailEntity);
						}
					}
				}
			}
			
			// 生成上传记录日志
			ReinvoicetempEntity reinvoicetemp = new ReinvoicetempEntity();
			reinvoicetemp.setReinvoiceMasterNum(reinvoiceMasterNum);
			reinvoicetemp.setReinvoiceNo(reinvoiceNo);
			reinvoicetemp.setReinvoiceAgreeTime(reinvoiceAgreeTime == null ? now : reinvoiceAgreeTime);
			reinvoicetemp.setPlatformId(platformId);
			reinvoicetemp.setBatchId(batchId);
			reinvoicetemp.setCreatePersonId(userId);
			reinvoicetemp.setCreatePersonName(userName);
			reinvoicetemp.setCreateDate(now);
			reinvoicetemp.setModifyDate(now);
			reinvoicetemp.setModifyPersonId(userId);
			reinvoicetemp.setModifyPersonName(userName);
			
			String updateFlag = "0";
			String remark = "没有找到单据，不做处理！";
			if(isUpdate) {
				successCount += 1;
				updateFlag = "1";
				remark = "已找到记录已更新！";
			}
			reinvoicetemp.setUpdateFlag(updateFlag);
			reinvoicetemp.setRemark(remark);
			
			reinvoiceTempList.add(reinvoicetemp);
		}
		
		
		if(!CollectionUtils.isEmpty(updateMasterList)) {
			reinvoiceMasterService.saveBetch(updateMasterList);	
		}
		
		if(!CollectionUtils.isEmpty(updateDetailList)) {
			reinvoiceDetailService.saveBetch(updateDetailList);
		}
		
		if(!CollectionUtils.isEmpty(reinvoiceTempList)) {
			reinvoiceTempService.saveBetch(reinvoiceTempList);
		}
		return successCount;
	}
	
	private Map<String, List<ReinvoicemasterEntity>> initMasterMap(List<ReinvoicemasterEntity> masterList){
		Map<String, List<ReinvoicemasterEntity>> masterMap = new HashMap<>();
		if(CollectionUtils.isEmpty(masterList)) {
			return masterMap;
		}
		
		for(ReinvoicemasterEntity masterEntity : masterList) {
			List<ReinvoicemasterEntity> childList = masterMap.get(masterEntity.getReinvoiceMasterNum());
			if(CollectionUtils.isEmpty(childList)) {
				childList = new ArrayList<>();
			}
			
			childList.add(masterEntity);
			masterMap.put(masterEntity.getReinvoiceMasterNum(), childList);
		}
		
		return masterMap;
	}
	
	private Map<Long, List<ReinvoicedetailEntity>> initDetailMap(List<ReinvoicemasterEntity> masterList, String platformId){
		Map<Long, List<ReinvoicedetailEntity>> detailMap = new HashMap<>();
		if(CollectionUtils.isEmpty(masterList)) {
			return detailMap;
		}
		
		List<Long> reinvoiceMasterIdList = masterList.stream().map(master -> master.getReinvoiceMasterId()).collect(Collectors.toList());
		List<ReinvoicedetailEntity> detailList = reinvoiceDetailService.getReinvoiceDetailList(reinvoiceMasterIdList, platformId);
		if(CollectionUtils.isEmpty(detailList))
		{
			return detailMap;
		}
		
		for(ReinvoicedetailEntity detailEntity : detailList) {
			List<ReinvoicedetailEntity> childList = detailMap.get(detailEntity.getReinvoiceMasterId());
			if(CollectionUtils.isEmpty(childList)) {
				childList = new ArrayList<>();
			}
			
			childList.add(detailEntity);
			detailMap.put(detailEntity.getReinvoiceMasterId(), childList);
		}
		
		return detailMap;
	}
}
