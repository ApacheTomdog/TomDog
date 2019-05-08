package com.brcc.business.invoice.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.brcc.business.invoice.entity.*;
import com.brcc.business.invoice.repository.*;
import com.brcc.business.invoice.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.brcc.business.config.mybatis.MybatisQuery;
import com.brcc.business.invoice.service.InvoiceService;
import com.brcc.business.util.Arith;
import com.brcc.business.vatcapital.service.VatCapitalDetailService;

/**
 * @Description 发票逻辑接口实现
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:02:44
 */
@Transactional
@Service
public class InvoiceServiceImpl implements InvoiceService {

    Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    InvoiceMasterRepository invoiceMasterRepository;
    @Autowired
    InvoiceMasterLogRepository invoiceMasterLogRepository;
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    InvoiceDetailLogRepository invoiceDetailLogRepository;
    @Autowired
    InvoiceMasterSplitRepository invoiceMasterSplitRepository;
    @Autowired
    VatCapitalDetailService vatCapitalDetailService;
	@Autowired
	InvoicemastersplitLogRepository invoicemastersplitLogRepository;
	@Autowired
	InvoicedetailSrrRepository invoicedetailSrrRepository;
	@Autowired
	InvoicemastersplitSrrRepository  invoicemastersplitSrrRepository;
    @Autowired
    MybatisQuery mybatisQuery;
	
    @Override
	public Page<InvoiceMasterVo> queryApplyListData(InvoiceQueryVo queryVo) {
    	logger.info("query invoice apply list data, queryVo:{}", queryVo);
		Page<InvoiceMasterVo> page = mybatisQuery.page("invoice.applyList", queryVo);
		return page;
	}

	@Override
	public List<InvoiceVo> queryVatCarryList(InvoiceQueryVo queryVo) {
		logger.info("query query vat carry list data, queryVo:{}", queryVo);
		List<InvoiceVo> list = mybatisQuery.list("invoice.queryVatCarryList", queryVo);
		return list;
	}

	@Override
	public HashMap<String, Object> saveInvoice(InvoiceQueryVo vo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		InvoicemasterEntity invoicemasterEntity = new InvoicemasterEntity();
		invoicemasterEntity.setInvoiceMasterNum(getSeqNum("30"));
		invoicemasterEntity.setInvoiceTitleId(vo.getCompanyId());
		invoicemasterEntity.setInvoiceTitleName(vo.getInvoiceTitleName());
		invoicemasterEntity.setInvoiceClientId(vo.getInvoiceCarryId());
		invoicemasterEntity.setInvoiceClientName(vo.getInvoiceCarryName());
		invoicemasterEntity.setInvoiceStatus("10");
		invoicemasterEntity.setCreateDate(new Date());
		invoicemasterEntity.setCreatePersonId(vo.getUserId());
		invoicemasterEntity.setCreatePersonName(vo.getUserName());
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		invoicemasterEntity.setRemark(vo.getRemark());
		invoicemasterEntity.setGroupId(vo.getGroupId()==null?0:vo.getGroupId());
		invoicemasterEntity.setGroupName(vo.getGroupName());
		invoicemasterEntity.setPlatformId(vo.getPlatformId());
		invoicemasterEntity.setTicketOpeningMark(vo.getTicketOpeningMark());
		invoicemasterEntity.setInvoiceDesc(vo.getInvoiceDesc());
		invoicemasterEntity.setIfShowFlag("0");
		invoiceMasterRepository.save(invoicemasterEntity);
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		data.put("outResultReason", "保存成功");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "保存成功");
		return resultMap;
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
	public Page<PayBillInfoVo> queryDetailListData(InvoiceQueryVo queryVo) {

        logger.info("Query invoice detail list data page,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
		Page<PayBillInfoVo> page = mybatisQuery.page("invoice.queryDetailList", queryVo);
		return page;
	}

	@Override
	public SumTotalVo queryDetailListDataSum(InvoiceQueryVo queryVo) {

        logger.info("Query invoice detail list data sum,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
        SumTotalVo sumTotalVo = mybatisQuery.selectOne("invoice.queryDetailListSum", queryVo);

		return sumTotalVo;
	}

	@Override
	public HashMap<String, Object> addInvoiceDetail(InvoiceQueryVo vo) {
		logger.info("add invoice detail,zfIdStr:{}",vo.getZfIdStr());
		Assert.notNull(vo.getZfIdStr(), "没有要添加的支付单明细");
		Assert.isTrue(!"".equals(vo.getZfIdStr()), "没有要添加的支付单明细");
		// 查询流程数据
		InvoiceVo invoiceVo = mybatisQuery.selectOne("invoice.queryInvoiceParam", vo);
		// 添加发票通知单明细
		String zfIdArr[] = vo.getZfIdStr().split(",");
		for (String zfId : zfIdArr) {
			vo.setZfId(Long.valueOf(zfId));
			// 查询支付单信息
			PayBillInfoVo payBillInfoVo = mybatisQuery.selectOne("invoice.queryPayBillInfo", vo);
			InvoicedetailEntity invoicedetailEntity = new InvoicedetailEntity();
			invoicedetailEntity.setPayBillId(payBillInfoVo.getZfId());
			invoicedetailEntity.setDeliveryId(payBillInfoVo.getDeliveryId());
			invoicedetailEntity.setTransId(payBillInfoVo.getTransId());
			invoicedetailEntity.setPublishId(payBillInfoVo.getPublishId());
			invoicedetailEntity.setInvoiceActualAmount(payBillInfoVo.getOutAmount());
			invoicedetailEntity.setInvoiceActualWeight(payBillInfoVo.getSettleWeight());
			invoicedetailEntity.setInvoiceTitleId(vo.getInvoiceTitleId());
			invoicedetailEntity.setInvoiceTitleName(invoiceVo.getInvoiceTitleName());
			invoicedetailEntity.setInvoiceClientId(vo.getInvoiceCarryId());
			invoicedetailEntity.setInvoiceClientName(invoiceVo.getInvoiceClientName());
			invoicedetailEntity.setCreateDate(new Date());
			invoicedetailEntity.setCreatePersonId(vo.getUserId());
			invoicedetailEntity.setCreatePersonName(vo.getUserName());
			invoicedetailEntity.setModifyDate(new Date());
			invoicedetailEntity.setModifyPersonId(vo.getUserId());
			invoicedetailEntity.setModifyPersonName(vo.getUserName());
			invoicedetailEntity.setInvoiceMasterId(vo.getInvoiceMasterId());
			invoicedetailEntity.setIfInvoice("1"); //1表示开票中（未拆分），2表示已开票，3表示开票中（已拆分）
			invoicedetailEntity.setPlatformId(vo.getPlatformId());
			invoicedetailEntity.setIfBegin(invoiceVo.getIfBegin());
			invoicedetailEntity.setStartPlate(payBillInfoVo.getStartPlate());
			invoicedetailEntity.setEndPlate(payBillInfoVo.getEndPlate());
			invoicedetailEntity.setDriverId(payBillInfoVo.getDriverId());
			invoicedetailEntity.setDriverName(payBillInfoVo.getDriverName());
			invoicedetailEntity.setVehicleId(payBillInfoVo.getVehicleId());
			invoicedetailEntity.setVehicleNum(payBillInfoVo.getVehicleNum());
			invoicedetailEntity.setGoodTypeDesc(payBillInfoVo.getGoodTypeDesc());
			invoicedetailEntity.setVatFlowMasterId(payBillInfoVo.getVatFlowMasterId());
			invoicedetailEntity.setTicketOpeningMark(vo.getTicketOpeningMark());
			invoicedetailEntity.setTruckLoadingWeight(payBillInfoVo.getTruckLoadingWeight());
			invoicedetailEntity.setTakeDeliveryWeight(payBillInfoVo.getTakeDeliveryWeight());
			invoicedetailEntity.setVatCapitalDetailId(payBillInfoVo.getVatCapitalDetailId());
			// 保存明细
			invoiceDetailRepository.save(invoicedetailEntity);
		}
		// 更新发票主表
		updateInvoiceMaster(vo);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "保存成功");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> applyInvoice(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("apply invoice,vo:{}",vo.toString());
		// 查询发票通知单主表
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		invoicemasterEntity.setInvoiceStatus("20"); // 20：生效
		invoicemasterEntity.setApplyDate(new Date());
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		// 更新发票通知单主表
		invoiceMasterRepository.save(invoicemasterEntity);
		
		// 查询发票明细
		List<InvoicedetailEntity> invoicedetailEntityList = invoiceDetailRepository.findByInvoiceMasterId(vo.getInvoiceMasterId());
		Assert.isTrue(invoicedetailEntityList != null && invoicedetailEntityList.size() > 0, "该发票申请通知单没有发票明细，不能申请");
		for (InvoicedetailEntity invoicedetailEntity : invoicedetailEntityList) {
			invoicedetailEntity.setIfInvoice("1"); // 1表示开票中（未拆分），2表示已开票，3表示开票中（已拆分）
			invoicedetailEntity.setModifyDate(new Date());
			invoicedetailEntity.setModifyPersonId(vo.getUserId());
			invoicedetailEntity.setModifyPersonName(vo.getUserName());
		}
		// 更新发票明细
		invoiceDetailRepository.saveAll(invoicedetailEntityList);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "申请成功");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> cancelInvoice(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
		logger.info("cancel invoice,vo:{}",vo.toString());
		//主表的向下一级申请的标记字段修改
		List<InvoicemasterEntity> list = mybatisQuery.list("invoice.queryApplayFlagInvoiceMasterId", vo);
		for (InvoicemasterEntity entity : list) {
			InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(entity.getInvoiceMasterId()).get();
			invoicemasterEntity.setApplyFlag(0); // 点击向下一级申请按钮的标记字段
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		// 查询发票通知单主表
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		InvoicemasterLogEntity invoicemasterLogEntity = new InvoicemasterLogEntity();
		BeanUtils.copyProperties(invoicemasterEntity, invoicemasterLogEntity);
		invoicemasterLogEntity.setInvoiceMasterId(null);
		invoicemasterLogEntity.setCreateCompanyId(vo.getCompanyId());
		invoicemasterLogEntity.setIfDefault("N");
		// 保存到发票通知单日志表
		invoiceMasterLogRepository.save(invoicemasterLogEntity);
		// 删除发票通知单主表
		invoiceMasterRepository.delete(invoicemasterEntity);
		
		
		List<InvoicedetailLogEntity> invoicedetailLogEntityList = new ArrayList<InvoicedetailLogEntity>();
		// 查询发票明细
		List<InvoicedetailEntity> invoicedetailEntityList = invoiceDetailRepository.findByInvoiceMasterId(vo.getInvoiceMasterId());
		for (InvoicedetailEntity invoicedetailEntity : invoicedetailEntityList) {
			InvoicedetailLogEntity invoicedetailLogEntity = new InvoicedetailLogEntity();
			BeanUtils.copyProperties(invoicedetailEntity, invoicedetailLogEntity);
			invoicedetailLogEntity.setInvoiceDetailId(null);
			invoicedetailLogEntityList.add(invoicedetailLogEntity);
		}
		// 发票明细保存到日志表
		invoiceDetailLogRepository.saveAll(invoicedetailLogEntityList);
		// 删除发票明细
		invoiceDetailRepository.deleteAll(invoicedetailEntityList);
		
		// 取消pay_bill表上的是否开票的标记
		Integer n = invoiceDetailRepository.updatePayBillInvoiceFlag("0", vo.getPlatformId(), vo.getInvoiceMasterId());
		// 取消transportationdelivery表上的是否开票的标记
		Integer m = invoiceDetailRepository.updateDeliveryInvoiceFlag("0", vo.getPlatformId(), vo.getInvoiceMasterId());
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "作废成功");
		return resultMap;
	}

	@Override
	public List<InvoiceDetailVo> queryInvoiceDetailListData(InvoiceQueryVo queryVo) {
		logger.info("Query invoice detail list data page,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
		List<InvoiceDetailVo> page = mybatisQuery.list("invoice.queryInvoiceDetailListData", queryVo);
		return page;
	}

	@Override
	public SumTotalVo queryInvoiceDetailListDataSum(InvoiceQueryVo queryVo) {
		logger.info("Query invoice detail list data sum   ,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
		SumTotalVo sumTotalVo = mybatisQuery.readSelectOne("invoice.queryInvoiceDetailListDataSum", queryVo);
		logger.info("query sum: {}",sumTotalVo.getDeductAmountSum());
		return sumTotalVo;
	}

	@Override
	public HashMap<String, Object> deleteInvoiceDetail(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceDetailIdStr(), "发票明细id不能为空");
    	logger.info("delete invoice detail,vo:{}", vo.toString());
    	String[] invoiceDetailIdArr = vo.getInvoiceDetailIdStr().split(",");
    	for (String invoiceDetailId : invoiceDetailIdArr) {
    		InvoicedetailEntity invoicedetailEntity = invoiceDetailRepository.findById(Long.valueOf(invoiceDetailId)).get();
    		invoiceDetailRepository.delete(invoicedetailEntity);
    	}
    	// 更新发票主表
    	updateInvoiceMaster(vo);
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "删除成功");
		return resultMap;
	}
	
	/**
	 * 更新发票主表
	 * @param vo
	 */
	private void updateInvoiceMaster(InvoiceQueryVo vo) {
		invoiceDetailRepository.flush();
		// 查询发票通知单的明细合计
		SumTotalVo sumTotalVo = mybatisQuery.selectOne("invoice.queryInvoiceDetailSum", vo);
		// 查询发票通知单主表
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		invoicemasterEntity.setInvoiceActualAmount(sumTotalVo.getInvoiceAmtSum());
		invoicemasterEntity.setInvoiceActualWeight(sumTotalVo.getInvoiceWeightSum());
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		// 更新发票通知单主表上的实际申请总金额，总吨位
		invoiceMasterRepository.save(invoicemasterEntity);
	}

	@Override
	public HashMap<String, Object> saveRemark(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票备注信息不能为空");
    	logger.info("save remark,vo:{}",vo.toString());
    	
    	InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
    	invoicemasterEntity.setRemark(vo.getRemark());
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		invoiceMasterRepository.save(invoicemasterEntity);
    	
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "修改成功");
		return resultMap;
	}

	@Override
	public Page<InvoicemastersplitVo> queryInvoiceListData(InvoiceQueryVo queryVo) {
		logger.info("Query invoice list data page,queryVo:{}", queryVo);
		Page<InvoicemastersplitVo> page = mybatisQuery.page("invoice.listInvoiceSplit", queryVo);
		return page;
	}

	@Override
	public List<InvoiceMasterVo> queryInvoiceApplyListInfo(InvoiceQueryVo queryVo) {
		logger.info("query invoice apply list info data, queryVo:{}", queryVo);
		List<InvoiceMasterVo> page = mybatisQuery.list("invoice.applyList", queryVo);
		return page;
	}

	@Override
	public HashMap<String, Object> remaining(InvoiceQueryVo vo) {
		Assert.notNull(vo.getInvoiceMasterId(), "invoiceMasterId不能为空");
    	logger.info("remaining,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	// 查询剩余部分量合计
    	SumTotalVo sumTotalVo = mybatisQuery.selectOne("invoice.queryInvalidInvoiceDetailSum", vo);
    	Assert.notNull(sumTotalVo, "作废剩余量失败，当前单据沒有未拆分的剩余量或已同意开票！");
    	Assert.isTrue(sumTotalVo.getInvalidInvoiceAmountSum() != null && sumTotalVo.getInvalidInvoiceAmountSum().compareTo(new BigDecimal("0")) > 0, "作废剩余量失败，当前单据沒有未拆分的剩余量或已同意开票！");
    	
    	// 更新发票申请表上的申请总金额，总重量
    	InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
    	invoicemasterEntity.setInvoiceActualAmount(invoicemasterEntity.getInvoiceActualAmount().subtract(sumTotalVo.getInvalidInvoiceAmountSum()));
    	invoicemasterEntity.setInvoiceActualWeight(invoicemasterEntity.getInvoiceActualWeight().subtract(sumTotalVo.getInvalidInvoiceWeightSum()));
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		String remark = invoicemasterEntity.getRemark();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append(remark==null?"":remark);
		sb.append("|");
		sb.append(sdf.format(new Date()));
		sb.append("被作废剩余量by");
		sb.append(vo.getUserId());
		invoicemasterEntity.setRemark(sb.toString());
		invoiceMasterRepository.save(invoicemasterEntity);
    
		// 删除未开票的发票明细
		Integer n = invoiceDetailRepository.deleteNonInvoicedDetail(vo.getInvoiceMasterId());
		Assert.isTrue(n > 0, "作废剩余量失败，未拆分的发票明细已被移除！");
		
		invoiceMasterRepository.flush();
		invoiceDetailRepository.flush();
		
		// 判断是否拆分完毕
		InvoiceMasterVo invoiceMasterVo = mybatisQuery.selectOne("invoice.queryIfSplitCompleted", vo);
		if ("Y".equals(invoiceMasterVo.getIfAmountSplitCompleted()) && "Y".equals(invoiceMasterVo.getIfWeightSplitCompleted())) {
			invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
	    	invoicemasterEntity.setInvoiceStatus("60");// 60：拆分完毕
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		// 判断是否全部开票完成
		invoiceMasterVo = mybatisQuery.selectOne("invoice.queryInvoicedSum", vo);
		if (invoiceMasterVo.getInvoiceActualAmount().compareTo(invoiceMasterVo.getInvoicedAmount()) == 0
			&& invoiceMasterVo.getInvoiceActualWeight().compareTo(invoiceMasterVo.getInvoicedWeight()) == 0) {
			invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
	    	invoicemasterEntity.setInvoiceStatus("30");// 30：开票完成
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "作废剩余量成功！");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> voidAll(InvoiceQueryVo vo) {
		Assert.notNull(vo.getInvoiceMasterId(), "invoiceMasterId不能为空");
		Assert.notNull(vo.getRemark(), "remark不能为空");
		logger.info("voidAll,invoiceMasterId:{}",vo.getInvoiceMasterId());
		
		// 判断发票明细是否已拆分或已开票
		Integer n = invoiceDetailRepository.querySplitedOrInvoicedCount(vo.getInvoiceMasterId());
		Assert.isTrue(n == 0, "当前单据存在已拆分或已开票的子项发票单据，请先作废子项发票！");	
		
		// 作废发票通知单
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		invoicemasterEntity.setInvoiceStatus("10");
		invoicemasterEntity.setApplyFlag(0);
		invoicemasterEntity.setApplyDate(null);
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		String remark = invoicemasterEntity.getRemark();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append(remark==null?"":remark);
		sb.append("|");
		sb.append(sdf.format(new Date()));
		sb.append("被全部作废by");
		sb.append(vo.getUserId());
		invoicemasterEntity.setRemark(sb.toString());
		invoiceMasterRepository.save(invoicemasterEntity);
		
		// 作废发票明细
		List<InvoicedetailEntity> invoicedetailEntitylist = invoiceDetailRepository.findByInvoiceMasterId(vo.getInvoiceMasterId());
		for (InvoicedetailEntity invoicedetailEntity : invoicedetailEntitylist) {
			invoicedetailEntity.setIfInvoice("1");
			invoicedetailEntity.setInvoiceNo(null);
			invoicedetailEntity.setModifyDate(new Date());
			invoicedetailEntity.setModifyPersonId(vo.getUserId());
			invoicedetailEntity.setModifyPersonName(vo.getUserName());
			remark = invoicedetailEntity.getRemark();
			sb = new StringBuffer();
			sb.append(remark==null?"":remark);
			sb.append("|");
			sb.append(sdf.format(new Date()));
			sb.append("被全部作废by");
			sb.append(vo.getUserId());
			invoicedetailEntity.setRemark(sb.toString());
		}
		invoiceDetailRepository.saveAll(invoicedetailEntitylist);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "全部作废成功！");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> applyToNext(InvoiceQueryVo vo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("apply to next,invoiceMasterId:{}",vo.getInvoiceMasterId());
		
    	// 判断是否存在下一级
    	Long n = mybatisQuery.selectOne("invoice.queryIfExistsNext", vo);
    //	Assert.isTrue(n > 0, "不存在下一级，不能申请！");
		if(n==0L){
			data.put("outResult", "1");
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", "不存在下一级，不能申请！");
			InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
			//此处设置为2代表无法向下一级申请
			invoicemasterEntity.setApplyFlag(2);
			invoicemasterEntity.setApplyDate(new Date());
			invoiceMasterRepository.save(invoicemasterEntity);
			return resultMap;
		}
    	
    	// 判断发票明细是否已在其他发票通知单中申请
    	StringBuffer sb = new StringBuffer();
    	List<InvoiceMasterVo> invoiceMasterVoList = mybatisQuery.list("invoice.queryDetailAreadyApplyMasterId", vo);
    	for (InvoiceMasterVo invoiceMasterVo : invoiceMasterVoList) {
    		if (sb.length() == 0) {
    			sb.append(invoiceMasterVo.getInvoiceMasterId());
    		} else {
    			sb.append(",");
    			sb.append(invoiceMasterVo.getInvoiceMasterId());
    		}
    	}
    	if (sb.length() > 0) {
    		sb.insert(0, "部分单据在发票通知单：");
    		sb.append("中申请");
    	}
    	
    	// 调用自动向下一级申请的过程
    	invoiceMasterRepository.flush();
    	HashMap<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("companyId", vo.getCompanyId());
    	propMap.put("invoiceMasterId", vo.getInvoiceMasterId());
    	propMap.put("userId", vo.getUserId());
    	propMap.put("userName", vo.getUserName());
    	propMap.put("groupId", vo.getGroupId());
    	propMap.put("groupName", vo.getGroupName());
    	propMap.put("outResult", "");
    	propMap.put("outResultReason", "");
    	mybatisQuery.executePro("invoice.callAutoApplyToNextPro", propMap);
    	
    	if ("1".equals(propMap.get("outResult"))) {
    		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
    		invoicemasterEntity.setApplyFlag(1);
    		invoicemasterEntity.setApplyDate(new Date());
    		invoicemasterEntity.setModifyDate(new Date());
    		invoicemasterEntity.setModifyPersonId(vo.getUserId());
    		invoicemasterEntity.setModifyPersonName(vo.getUserName());
    		invoiceMasterRepository.save(invoicemasterEntity);
    	} else {
    		throw new RuntimeException(propMap.get("outResultReason").toString()); 
    	}
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", propMap.get("outResultReason").toString() + (sb.length() > 0 ? sb.toString() : ""));
		return resultMap;
	}

	@Override
	public HashMap<String, Object> autoSplit(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("auto split,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	
    	// 查询发票明细
    	List<DetailVo> detailVoList = mybatisQuery.list("invoice.queryDetailVoList", vo);
    	Assert.isTrue(detailVoList.size() > 0, "数据拆分完毕或数据异常！");
    	// 查询发票最大金额
    	InvoiceVo invoiceVo = mybatisQuery.selectOne("invoice.queryInvoiceMaxAmount", vo);
    	Assert.notNull(invoiceVo, "请设置您的发票限额！");
    	Assert.notNull(invoiceVo.getInvoiceConfigAmount(), "请设置您的发票限额！");
    	// 计算最优组合
    	String optimalCombination = calculateOptimal(detailVoList, invoiceVo);
    	Assert.notNull(optimalCombination, "系统自动拆分失败，请手工拆分！");
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		data.put("detailIds", optimalCombination.split("@@")[0]);
		data.put("detailAmtSum", optimalCombination.split("@@")[1]);
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "自动拆分成功");
		return resultMap;
	}

	/**
	 * 计算明细最优组合
	 * @param detailVoList
	 * @param invoiceVo
	 * @return
	 */
	private String calculateOptimal(List<DetailVo> detailVoList, InvoiceVo invoiceVo) {
		List<DetailVo> detailVoList2 = new ArrayList<DetailVo>();
    	List<DetailVo> detailVoList3 = new ArrayList<DetailVo>();
    	
    	detailVoList2.addAll(detailVoList);
    	detailVoList3.addAll(detailVoList);
    	
    	String maxCombination = maxCombination(detailVoList, invoiceVo);
    	logger.info("maxCombination:{}", maxCombination);
    	String minCombination = minCombination(detailVoList2, invoiceVo);
    	logger.info("minCombination:{}", minCombination);
    	String maxAndMinCombination = maxAndMinCombination(detailVoList3, invoiceVo);
    	logger.info("maxAndMinCombination:{}", maxAndMinCombination);
    	// 获取最优组合
    	String optimalCombination = optimalCombination(maxCombination, minCombination, maxAndMinCombination);
		return optimalCombination;
	}

	/**
	 * 获取最优组合
	 * @param maxCombination
	 * @param minCombination
	 * @param maxAndMinCombination
	 * @return
	 */
	private String optimalCombination(String maxCombination, String minCombination, String maxAndMinCombination) {
		List<DetailVo> detailVoList = new ArrayList<DetailVo>();
		if (maxCombination != null) {
			DetailVo detailVo = new DetailVo();
			detailVo.setInvoiceDetailId(1L);
			detailVo.setInvoiceDetailAmount(new BigDecimal(maxCombination.split("@@")[1]));
			detailVoList.add(detailVo);
		}
		if (minCombination != null) {
			DetailVo detailVo = new DetailVo();
			detailVo.setInvoiceDetailId(2L);
			detailVo.setInvoiceDetailAmount(new BigDecimal(minCombination.split("@@")[1]));
			detailVoList.add(detailVo);
		}
		if (maxAndMinCombination != null) {
			DetailVo detailVo = new DetailVo();
			detailVo.setInvoiceDetailId(3L);
			detailVo.setInvoiceDetailAmount(new BigDecimal(maxAndMinCombination.split("@@")[1]));
			detailVoList.add(detailVo);
		}
		if (detailVoList.size() == 0) {
			return null;
		}
		DetailVo maxDetailVo = Collections.max(detailVoList);
		if (maxDetailVo != null) {
			switch(String.valueOf(maxDetailVo.getInvoiceDetailId())) {
				case "1" : return maxCombination;
				case "2" : return minCombination;
				case "3" : return maxAndMinCombination;
				default  : return null;
			}
		}
		return null;
	}

	/**
	 * 最大加最小组合
	 * @param detailVoList
	 * @param invoiceVo
	 * @return
	 */
	private String maxAndMinCombination(List<DetailVo> detailVoList, InvoiceVo invoiceVo) {
		// 发票最大金额
		BigDecimal invoiceMaxAmount = invoiceVo.getInvoiceConfigAmount(), 
				   detailAmountSum = new BigDecimal("0");
		// 发票明细id拼接字符串
		StringBuffer sb = new StringBuffer("");
		
		for (int i=0; i < detailVoList.size(); ) {
			
			DetailVo maxDetailVo = detailVoList.size() % 2 == 0 ? Collections.max(detailVoList) : Collections.min(detailVoList);
			if (sb.length() == 0) {
				sb.append(String.valueOf(maxDetailVo.getInvoiceDetailId()));
			} else {
				sb.append(",");
				sb.append(String.valueOf(maxDetailVo.getInvoiceDetailId()));
			}
			detailAmountSum = detailAmountSum.add(maxDetailVo.getInvoiceDetailAmount());
			// 等于发票限额，退出循环
			if (detailAmountSum.compareTo(invoiceMaxAmount) == 0) {
				break;
			}
			// 超过发票限额
			if (detailAmountSum.compareTo(invoiceMaxAmount) > 0) {
				detailAmountSum = detailAmountSum.subtract(maxDetailVo.getInvoiceDetailAmount());
				sb.delete(sb.lastIndexOf(",") == -1 ? 0 : sb.lastIndexOf(","), sb.length());
			}
			// 移除当前最大的明细
			detailVoList.remove(detailVoList.indexOf(maxDetailVo));
			i = 0;
		}
		if (sb.length() > 0) {
			sb.append("@@");
			sb.append(detailAmountSum.toString());
			return sb.toString();
		}
		return null;
	}

	/**
	 * 最小值组合
	 * @param detailVoList
	 * @param invoiceVo
	 * @return
	 */
	private String minCombination(List<DetailVo> detailVoList, InvoiceVo invoiceVo) {
		// 发票最大金额
		BigDecimal invoiceMaxAmount = invoiceVo.getInvoiceConfigAmount(), 
				   detailAmountSum = new BigDecimal("0");
		// 发票明细id拼接字符串
		StringBuffer sb = new StringBuffer("");
		
		for (int i=0; i < detailVoList.size(); ) {
			DetailVo minDetailVo = Collections.min(detailVoList);
			if (sb.length() == 0) {
				sb.append(String.valueOf(minDetailVo.getInvoiceDetailId()));
			} else {
				sb.append(",");
				sb.append(String.valueOf(minDetailVo.getInvoiceDetailId()));
			}
			detailAmountSum = detailAmountSum.add(minDetailVo.getInvoiceDetailAmount());
			// 等于发票限额，退出循环
			if (detailAmountSum.compareTo(invoiceMaxAmount) == 0) {
				break;
			}
			// 超过发票限额
			if (detailAmountSum.compareTo(invoiceMaxAmount) > 0) {
				detailAmountSum = detailAmountSum.subtract(minDetailVo.getInvoiceDetailAmount());
				sb.delete(sb.lastIndexOf(",") == -1 ? 0 : sb.lastIndexOf(","), sb.length());
			}
			// 移除当前最小的明细
			detailVoList.remove(detailVoList.indexOf(minDetailVo));
			i = 0;
		}
		if (sb.length() > 0) {
			sb.append("@@");
			sb.append(Arith.round(detailAmountSum, 2).toString());
			return sb.toString();
		}
		return null;
	}

	/**
	 * 最大值组合
	 * @param detailVoList
	 * @param invoiceVo
	 * @return
	 */
	private String maxCombination(List<DetailVo> detailVoList, InvoiceVo invoiceVo) {
		// 发票最大金额
		BigDecimal invoiceMaxAmount = invoiceVo.getInvoiceConfigAmount(), 
				   detailAmountSum = new BigDecimal("0");
		// 发票明细id拼接字符串
		StringBuffer sb = new StringBuffer("");
		
		for (int i=0; i < detailVoList.size(); ) {
			DetailVo maxDetailVo = Collections.max(detailVoList);
			if (sb.length() == 0) {
				sb.append(String.valueOf(maxDetailVo.getInvoiceDetailId()));
			} else {
				sb.append(",");
				sb.append(String.valueOf(maxDetailVo.getInvoiceDetailId()));
			}
			detailAmountSum = detailAmountSum.add(maxDetailVo.getInvoiceDetailAmount());
			// 等于发票限额，退出循环
			if (detailAmountSum.compareTo(invoiceMaxAmount) == 0) {
				break;
			}
			// 超过发票限额
			if (detailAmountSum.compareTo(invoiceMaxAmount) > 0) {
				detailAmountSum = detailAmountSum.subtract(maxDetailVo.getInvoiceDetailAmount());
				sb.delete(sb.lastIndexOf(",") == -1 ? 0 : sb.lastIndexOf(","), sb.length());
			}
			// 移除当前最大的明细
			detailVoList.remove(detailVoList.indexOf(maxDetailVo));
			i = 0;
		}
		if (sb.length() > 0) {
			sb.append("@@");
			sb.append(detailAmountSum.toString());
			return sb.toString();
		}
		return null;
	}

	@Override
	public HashMap<String, Object> invoiceSplit(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
		Assert.notNull(vo.getDetailIds(), "发票明细id不能为空");
		logger.info("invoice split,invoiceMasterId:{},detailIds:{}",vo.getInvoiceMasterId(), vo.getDetailIds());
		
		//查询发票拆分明细合计
		InvoiceVo invoiceVo = mybatisQuery.selectOne("invoice.queryInvoiceSplitSum", vo);
		Assert.notNull(invoiceVo, "发票拆分失败");
		Assert.notNull(invoiceVo.getInvoiceTitleId(), "发票拆分失败");
		// 查询发票最大金额
    	InvoiceVo invoiceMaxAmountVo = mybatisQuery.selectOne("invoice.queryInvoiceMaxAmount", vo);
    	Assert.notNull(invoiceMaxAmountVo, "请设置您的发票限额！");
    	Assert.notNull(invoiceMaxAmountVo.getInvoiceConfigAmount(), "请设置您的发票限额！");
		
    	Assert.isTrue(invoiceVo.getInvoiceAmount().compareTo(invoiceMaxAmountVo.getInvoiceConfigAmount()) <= 0, "拆分金额大于开票公司的最大开票金额，拆分失败！");
    	Assert.isTrue(invoiceVo.getInvoiceAmount().compareTo(vo.getDetailAmtSum()) == 0, "发票拆分明细已变动，拆分失败！");
		
    	//获取拆分表Num
    	String splitNum = getSeqNum("16");
    	Integer n = invoiceDetailRepository.updateDetailSplitCompleted(Arrays.asList(vo.getDetailIds().split(",")), splitNum);
    	Assert.isTrue(n > 0, "拆分的单据对应的子单据更新拆分单号失败，拆分失败！");
    	
    	invoiceDetailRepository.flush();
    	
    	// 判断是否拆分完毕
		InvoiceMasterVo invoiceMasterVo = mybatisQuery.selectOne("invoice.queryIfSplitCompleted", vo);
		if ("Y".equals(invoiceMasterVo.getIfAmountSplitCompleted()) && "Y".equals(invoiceMasterVo.getIfWeightSplitCompleted())) {
			InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
	    	invoicemasterEntity.setInvoiceStatus("60");// 60：拆分完毕
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		// 生成发票表
		InvoicemastersplitEntity invoicemastersplitEntity = new InvoicemastersplitEntity();
		invoicemastersplitEntity.setInvoiceSplitNum(splitNum);
		invoicemastersplitEntity.setInvoiceMasterId(vo.getInvoiceMasterId());
		invoicemastersplitEntity.setInvoiceTitleId(invoiceVo.getInvoiceTitleId());
		invoicemastersplitEntity.setInvoiceTitleName(invoiceVo.getInvoiceTitleName());
		invoicemastersplitEntity.setInvoiceClientId(invoiceVo.getInvoiceClientId());
		invoicemastersplitEntity.setInvoiceClientName(invoiceVo.getInvoiceClientName());
		invoicemastersplitEntity.setInvoicePlanAmount(invoiceMaxAmountVo.getInvoiceConfigAmount());
		invoicemastersplitEntity.setInvoiceActualAmount(invoiceVo.getInvoiceAmount());
		invoicemastersplitEntity.setInvoiceActualWeight(invoiceVo.getInvoiceWeight());
		invoicemastersplitEntity.setInvoiceStatus("20");
		invoicemastersplitEntity.setCreateDate(new Date());
		invoicemastersplitEntity.setCreatePersonId(vo.getUserId());
		invoicemastersplitEntity.setCreatePersonName(vo.getUserName());
		invoicemastersplitEntity.setModifyDate(new Date());
		invoicemastersplitEntity.setModifyPersonId(vo.getUserId());
		invoicemastersplitEntity.setModifyPersonName(vo.getUserName());
		invoicemastersplitEntity.setPlatformId(vo.getPlatformId());
		invoicemastersplitEntity.setTicketOpeningMark(invoiceVo.getTicketOpeningMark());
		invoicemastersplitEntity.setRemark("ZD".equals(vo.getType()) ? "自动拆分" : "手动拆分");
		invoicemastersplitEntity.setType(vo.getType());
		invoicemastersplitEntity.setGroupId(invoiceVo.getGroupId()==null?0L:invoiceVo.getGroupId());
		invoicemastersplitEntity.setGroupName(invoiceVo.getGroupName());
		invoiceMasterSplitRepository.save(invoicemastersplitEntity);
		
		// 更新发票明细的拆分表id
		n = invoiceDetailRepository.updateDetailSplitId(Arrays.asList(vo.getDetailIds().split(",")), invoicemastersplitEntity.getInvoiceSplitId());
		Assert.isTrue(n > 0, "拆分的单据对应的子单据更新拆分单id失败，拆分失败！");
		
		invoiceDetailRepository.flush();
		
		// 更新发票通知单上的已拆分金额，重量
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
    	invoicemasterEntity.setInvoiceSplitAmount(invoicemasterEntity.getInvoiceSplitAmount().add(invoiceVo.getInvoiceAmount()));
    	invoicemasterEntity.setInvoiceSplitWeight(invoicemasterEntity.getInvoiceSplitWeight().add(invoiceVo.getInvoiceWeight()));
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		invoiceMasterRepository.save(invoicemasterEntity);
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "ZD".equals(vo.getType()) ? "自动拆分成功" : "手动拆分成功");
		return resultMap;
	}

	@Override
	public SumTotalVo queryInvoiceManageListDataSum(InvoiceQueryVo queryVo) {
		logger.info("Query invoice manage list data sum,queryVo:{}", queryVo);
		SumTotalVo sumTotalVo = mybatisQuery.selectOne("invoice.listInvoiceSplitSum", queryVo);
		return sumTotalVo;
	}

	@Override
	public HashMap<String, Object> saveInvoiceMaintain(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	Assert.notNull(vo.getInvoiceNo(), "发票号不能为空");
    	Assert.notNull(vo.getInvoiceAgreeTime(), "开票时间不能为空");
    	logger.info("save invoice maintain,invoiceSplitId:{}, invoiceNo:{}, invoiceAgreeTime:{}",vo.getInvoiceSplitId(), vo.getInvoiceNo(), vo.getInvoiceAgreeTime());
		
    	// 更新发票号，开票时间，开票状态
    	Integer n = invoiceMasterSplitRepository.updateInvoiceMasterSplit(vo.getInvoiceSplitId(),vo.getInvoiceNo(), vo.getInvoiceAgreeTime(), "30", vo.getUserId(), vo.getUserName());
    	Assert.isTrue(n > 0, "发票金额不能超过最大开票金额，请移除部分发票子项！");
    	
    	// 更新发票明细表的发票号，开票时间，标记
    	n = invoiceDetailRepository.updateInvoiceDetail(vo.getInvoiceSplitId(),vo.getInvoiceNo(), vo.getInvoiceAgreeTime(), "2", vo.getUserId(), vo.getUserName());
    	Assert.isTrue(n > 0, "该单据不存在明细，无法同意开票！");
    	
    	// 更新资金明细表上的开票标记
    	n = vatCapitalDetailService.updateIfInvoiceFlag(vo.getInvoiceSplitId(), vo.getPlatformId(), "1", "0");
    	Assert.isTrue(n > 0, "更新资金明细表的开票标记失败，同意开票失败！");
    	
    	invoiceMasterSplitRepository.flush();
    	
    	// 查询发票金额，重量
    	InvoicemastersplitEntity invoicemastersplitEntity = invoiceMasterSplitRepository.findById(vo.getInvoiceSplitId()).get();
    	// 更新发票通知单上的已开发票金额，重量
		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
    	invoicemasterEntity.setInvoiceAgreeAmount(invoicemasterEntity.getInvoiceAgreeAmount().add(invoicemastersplitEntity.getInvoiceActualAmount()));
    	invoicemasterEntity.setInvoiceAgreeWeight(invoicemasterEntity.getInvoiceAgreeWeight().add(invoicemastersplitEntity.getInvoiceActualWeight()));
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		invoiceMasterRepository.save(invoicemasterEntity);
    	
		invoiceMasterRepository.flush();
		
		// 判断是否全部开票完成
		InvoiceMasterVo invoiceMasterVo = mybatisQuery.selectOne("invoice.queryInvoicedSum", vo);
		if (invoiceMasterVo.getInvoiceActualAmount().compareTo(invoiceMasterVo.getInvoicedAmount()) == 0
			&& invoiceMasterVo.getInvoiceActualWeight().compareTo(invoiceMasterVo.getInvoicedWeight()) == 0) {
			invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
	    	invoicemasterEntity.setInvoiceStatus("30");// 30：开票完成
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "发票维护成功");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> saveInvoiceReMaintain(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	Assert.notNull(vo.getInvoiceNo(), "发票号不能为空");
    	Assert.notNull(vo.getInvoiceAgreeTime(), "开票时间不能为空");
    	logger.info("save invoice remaintain,invoiceSplitId:{}, invoiceNo:{}, invoiceAgreeTime:{}",vo.getInvoiceSplitId(), vo.getInvoiceNo(), vo.getInvoiceAgreeTime());
		
    	// 更新发票表的发票号，开票时间
    	InvoicemastersplitEntity invoicemastersplitEntity = invoiceMasterSplitRepository.findById(vo.getInvoiceSplitId()).get();
    	invoicemastersplitEntity.setInvoiceNo(vo.getInvoiceNo());
    	invoicemastersplitEntity.setInvoiceAgreeTime(vo.getInvoiceAgreeTime());
    	invoicemastersplitEntity.setModifyDate(new Date());
    	invoicemastersplitEntity.setModifyPersonId(vo.getUserId());
    	invoicemastersplitEntity.setModifyPersonName(vo.getUserName());
    	invoiceMasterSplitRepository.save(invoicemastersplitEntity);
    	
    	// 更新发票明细表的发票号，开票时间，标记
    	Integer n = invoiceDetailRepository.updateInvoiceDetail(vo.getInvoiceSplitId(),vo.getInvoiceNo(), vo.getInvoiceAgreeTime(), "2", vo.getUserId(), vo.getUserName());
    	Assert.isTrue(n > 0, "重新维护发票号失败");
    	
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "重新维护发票成功");
		return resultMap;
	}

	@Override
	public HashMap<String, Object> cancelInvoiceSplit(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	logger.info("cancel invoice split,invoiceSplitId:{}",vo.getInvoiceSplitId());
		
    	InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();;
    	// 如果发票通知单已拆分完毕，则回退状态到20
		InvoiceMasterVo invoiceMasterVo = mybatisQuery.selectOne("invoice.queryIfSplitCompleted", vo);
		if ("Y".equals(invoiceMasterVo.getIfAmountSplitCompleted()) && "Y".equals(invoiceMasterVo.getIfWeightSplitCompleted())) {
	    	invoicemasterEntity.setInvoiceStatus("20");// 20：生效，30：已开票，60：拆分完毕
	    	invoicemasterEntity.setInvoiceAgreeTime(null);
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		// 如果发票通知单已同意，则回退状态到20
		if ("30".equals(invoicemasterEntity.getInvoiceStatus())) {
			invoicemasterEntity.setInvoiceStatus("20");// 20：生效，30：已开票，60：拆分完毕
			invoicemasterEntity.setInvoiceAgreeTime(null);
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		
		// 查询发票信息
		InvoicemastersplitEntity invoicemastersplitEntity = invoiceMasterSplitRepository.findById(vo.getInvoiceSplitId()).get();
		// 如果发票已开票，则取消资金明细表上的已开票标记
		if ("30".equals(invoicemastersplitEntity.getInvoiceStatus())) {
			// 更新资金明细表上的开票标记
	    	Integer n = vatCapitalDetailService.updateIfInvoiceFlag(vo.getInvoiceSplitId(), vo.getPlatformId(), "0", "1");
	    	Assert.isTrue(n > 0, "更新资金明细表的开票标记失败，作废开票失败！");
	    	
	    	// 更新发票通知单上的已开发票，已拆分金额，重量
	    	invoicemasterEntity.setInvoiceAgreeAmount(invoicemasterEntity.getInvoiceAgreeAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
	    	invoicemasterEntity.setInvoiceAgreeWeight(invoicemasterEntity.getInvoiceAgreeWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
	    	invoicemasterEntity.setInvoiceSplitAmount(invoicemasterEntity.getInvoiceSplitAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
	    	invoicemasterEntity.setInvoiceSplitWeight(invoicemasterEntity.getInvoiceSplitWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		} else if ("20".equals(invoicemastersplitEntity.getInvoiceStatus())) { // 未开票
			// 更新发票通知单上的已拆分金额，重量
	    	invoicemasterEntity.setInvoiceSplitAmount(invoicemasterEntity.getInvoiceSplitAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
	    	invoicemasterEntity.setInvoiceSplitWeight(invoicemasterEntity.getInvoiceSplitWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
			invoicemasterEntity.setModifyDate(new Date());
			invoicemasterEntity.setModifyPersonId(vo.getUserId());
			invoicemasterEntity.setModifyPersonName(vo.getUserName());
			invoiceMasterRepository.save(invoicemasterEntity);
		}
		//通过发票拆分号找到对应的发票明细,如果该发票已生效才会加入到日志表中
		if ("30".equals(invoicemastersplitEntity.getInvoiceStatus())) {
			List<InvoicedetailEntity> invoicedetailEntityList = invoiceDetailRepository.findByInvoiceSplitId(vo.getInvoiceSplitId());
			List<InvoicedetailSrrEntity> invoicedetailSrrEntityList = new ArrayList();

			for (InvoicedetailEntity invoicedetailEntity : invoicedetailEntityList) {
				InvoicedetailSrrEntity invoicedetailSrrEntity = new InvoicedetailSrrEntity();
				BeanUtils.copyProperties(invoicedetailEntity, invoicedetailSrrEntity);
				invoicedetailSrrEntityList.add(invoicedetailSrrEntity);
			}
			// 删除发票明细，将发票明细保存到日志表
			invoicedetailSrrRepository.saveAll(invoicedetailSrrEntityList);

			InvoicemastersplitSrrEntity invoicemastersplitSrrEntity = new InvoicemastersplitSrrEntity();
			BeanUtils.copyProperties(invoicemastersplitEntity, invoicemastersplitSrrEntity);
			//代表该发票是通过红冲得到
			invoicemastersplitSrrEntity.setInvoiceType("ZF");
			//将作废的发票加入到日志表
			invoicemastersplitSrrRepository.save(invoicemastersplitSrrEntity);
		}
		// 删除发票
		invoiceMasterSplitRepository.deleteById(vo.getInvoiceSplitId());
		
		// 移除发票明细表的开票信息
		Integer n = invoiceDetailRepository.removeInvoiceInfo(vo.getInvoiceSplitId(),vo.getPlatformId(), vo.getInvoiceMasterId(), vo.getUserId(), vo.getUserName());
    	Assert.isTrue(n > 0, "移除发票明细表的开票信息失败，作废发票失败！");
		
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "发票作废成功");
		return resultMap;
	}

	@Override
	public List<InvoicemastersplitVo> queryInvoiceManageListInfo(InvoiceQueryVo queryVo) {
		logger.info("query invoice manage list info data, queryVo:{}", queryVo);
		List<InvoicemastersplitVo> page = mybatisQuery.list("invoice.listInvoiceSplit", queryVo);
		return page;
	}

	@Override
	public HashMap<String, Object> addPrintNum(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
		logger.info("add print num,invoiceSplitId:{},invoiceSplitNum:{}",vo.getInvoiceSplitId(), vo.getInvoiceSplitNum());
		
		InvoicemastersplitEntity invoicemastersplitEntity = invoiceMasterSplitRepository.findById(vo.getInvoiceSplitId()).get();
		Assert.notNull(invoicemastersplitEntity, "没有找到该发票");
		invoicemastersplitEntity.setPrintNum(invoicemastersplitEntity.getPrintNum()==null?0:invoicemastersplitEntity.getPrintNum() + 1);
		invoicemastersplitEntity.setModifyDate(new Date());
    	invoicemastersplitEntity.setModifyPersonId(vo.getUserId());
    	invoicemastersplitEntity.setModifyPersonName(vo.getUserName());
    	invoiceMasterSplitRepository.save(invoicemastersplitEntity);
		
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "发票打印次数增加成功");
		return resultMap;
	}


	@Override
	//红冲发票需要加入到发票红冲与作废日志表
	public HashMap<String, Object> redDashInvoice(InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
		logger.info("red Dash Invoice,invoiceSplitId:{}",vo.getInvoiceSplitId());

		InvoicemasterEntity invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		//扣除发票通知单的开票量和开票金额信息
		invoicemasterEntity.setModifyDate(new Date());
		invoicemasterEntity.setModifyPersonId(vo.getUserId());
		invoicemasterEntity.setModifyPersonName(vo.getUserName());
		// 查询发票信息
		InvoicemastersplitEntity invoicemastersplitEntity = invoiceMasterSplitRepository.findById(vo.getInvoiceSplitId()).get();
		Assert.isTrue("30".equals(invoicemastersplitEntity.getInvoiceStatus()),"只有已开票的才可以进行发票红冲操作！");
		// 更新资金流水表上面的开票标记
		Integer n = vatCapitalDetailService.updateIfInvoiceFlag(vo.getInvoiceSplitId(), vo.getPlatformId(), "0", "1");
		Assert.isTrue(n > 0, "更新资金明细表的开票标记失败，作废开票失败！");

		//生成新的发票通知单
		InvoicemasterEntity masterEntity = new InvoicemasterEntity();
		BeanUtils.copyProperties(invoicemasterEntity,masterEntity);
		masterEntity.setInvoiceMasterId(null);
		masterEntity.setInvoiceMasterNum(getSeqNum("30"));
		masterEntity.setInvoiceActualWeight(invoicemastersplitEntity.getInvoiceActualWeight());
		masterEntity.setInvoiceActualAmount(invoicemastersplitEntity.getInvoiceActualAmount());
		masterEntity.setInvoiceSplitAmount(new BigDecimal(0));
		masterEntity.setInvoiceSplitWeight(new BigDecimal(0));
		masterEntity.setInvoiceAgreeAmount(new BigDecimal(0));
		masterEntity.setInvoiceAgreeWeight(new BigDecimal(0));
		masterEntity.setInvoiceStatus("10");
		masterEntity.setCreateDate(new Date());
		masterEntity.setModifyDate(new Date());
		masterEntity.setModifyPersonId(invoicemasterEntity.getCreatePersonId());
		masterEntity.setModifyPersonName(invoicemasterEntity.getCreatePersonName());
		masterEntity.setRemark("通过发票红冲，发票号为" +invoicemastersplitEntity.getInvoiceNo());
		masterEntity = invoiceMasterRepository.save(masterEntity);
		//通过发票拆分号找到对应的发票明细
		List<InvoicedetailEntity> invoicedetailEntityList = invoiceDetailRepository.findByInvoiceSplitId(vo.getInvoiceSplitId());
		List<InvoicedetailSrrEntity> invoicedetailSrrEntityList = new ArrayList();

		for (InvoicedetailEntity invoicedetailEntity : invoicedetailEntityList) {
			InvoicedetailSrrEntity invoicedetailSrrEntity = new InvoicedetailSrrEntity();
			BeanUtils.copyProperties(invoicedetailEntity, invoicedetailSrrEntity);
			invoicedetailSrrEntityList.add(invoicedetailSrrEntity);
			InvoicedetailEntity  detailEntity = new InvoicedetailEntity();
			BeanUtils.copyProperties(invoicedetailEntity,detailEntity);
			invoiceDetailRepository.delete(invoicedetailEntity);
			invoiceDetailRepository.flush();
			detailEntity.setInvoiceMasterId(masterEntity.getInvoiceMasterId());
			detailEntity.setInvoiceDetailId(null);
			detailEntity.setInvoiceSplitId(null);
			detailEntity.setInvoiceSplitNum(null);
			detailEntity.setInvoiceNo(null);
			detailEntity.setInvoiceAgreeTime(null);
			detailEntity.setCreateDate(new Date());
			detailEntity.setModifyDate(new Date());
			detailEntity.setModifyPersonId(invoicemasterEntity.getCreatePersonId());
			detailEntity.setModifyPersonName(invoicemasterEntity.getCreatePersonName());
			detailEntity.setIfInvoice("1");
			invoiceDetailRepository.save(detailEntity);
		}
		// 删除发票明细，将发票明细保存到日志表
		invoicedetailSrrRepository.saveAll(invoicedetailSrrEntityList);
		invoicemasterEntity.setInvoiceAgreeAmount(invoicemasterEntity.getInvoiceAgreeAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
		invoicemasterEntity.setInvoiceAgreeWeight(invoicemasterEntity.getInvoiceAgreeWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
		invoicemasterEntity.setInvoiceSplitAmount(invoicemasterEntity.getInvoiceSplitAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
		invoicemasterEntity.setInvoiceSplitWeight(invoicemasterEntity.getInvoiceSplitWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
		invoicemasterEntity.setInvoiceActualAmount(invoicemasterEntity.getInvoiceActualAmount().subtract(invoicemastersplitEntity.getInvoiceActualAmount()));
		invoicemasterEntity.setInvoiceActualWeight(invoicemasterEntity.getInvoiceActualWeight().subtract(invoicemastersplitEntity.getInvoiceActualWeight()));
		invoiceMasterRepository.save(invoicemasterEntity);
		invoicemasterEntity = invoiceMasterRepository.findById(vo.getInvoiceMasterId()).get();
		if(invoicemasterEntity.getInvoiceActualWeight().compareTo(new BigDecimal(0))==0 && invoicemasterEntity.getInvoiceActualAmount().compareTo(new BigDecimal(0))==0){
			invoiceMasterRepository.deleteById(vo.getInvoiceMasterId());
		}
		//删除发票信息将发票表加入到发票日志表
		InvoicemastersplitSrrEntity  invoicemastersplitSrrEntity = new InvoicemastersplitSrrEntity();
		BeanUtils.copyProperties(invoicemastersplitEntity,invoicemastersplitSrrEntity);
		//代表该发票是通过红冲得到
		invoicemastersplitSrrEntity.setInvoiceType("HC");
		invoiceMasterSplitRepository.deleteById(vo.getInvoiceSplitId());
		invoicemastersplitSrrRepository.save(invoicemastersplitSrrEntity);

		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "发票红冲成功");
		return resultMap;
	}

	@Override
	public Page<InvoiceMasterSrrVo> redInvoiceManageListData(InvoiceQueryVo queryVo) {
		logger.info("query red invoice manage list info data, queryVo:{}", queryVo);
		Page<InvoiceMasterSrrVo> page = mybatisQuery.page("invoice.listRedInvoiceSplit", queryVo);
		return page;
	}

	@Override
	public SumTotalVo queryRedInvoiceManageListDataSum(InvoiceQueryVo queryVo) {
		logger.info("Query red invoice manage list data sum,queryVo:{}", queryVo);
		SumTotalVo sumTotalVo = mybatisQuery.selectOne("invoice.listRedInvoiceSplitSum", queryVo);
		return sumTotalVo;
	}

	@Override
	public Page<InvoiceDetailSrrVo> queryRedInvoiceDetailListData(InvoiceQueryVo queryVo) {
		logger.info("Query red invoice detail list data page,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
		Page<InvoiceDetailSrrVo> page = mybatisQuery.page("invoice.queryRedInvoiceDetailListData", queryVo);
		return page;
	}

	@Override
	public SumTotalVo queryRedInvoiceDetailListDataSum(InvoiceQueryVo queryVo) {
		logger.info("Query red invoice detail list data sum   ,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
		SumTotalVo sumTotalVo = mybatisQuery.readSelectOne("invoice.queryRedInvoiceDetailListDataSum", queryVo);
		logger.info("query sum: {}",sumTotalVo.getDeductAmountSum());
		return sumTotalVo;
	}


	@Override
	//维护红冲发票信息
	public HashMap<String, Object> saveRedInvoiceMaintain(InvoiceQueryVo vo) {
		InvoicemastersplitSrrEntity srrEntity = invoicemastersplitSrrRepository.findById(vo.getInvoiceSplitSrrId()).get();
		srrEntity.setRedInvoiceDate(vo.getRedInvoiceDate());
		srrEntity.setRedInvoiceNo(vo.getRedInvoiceNo());
		srrEntity.setRemark(vo.getRemark());
		srrEntity = invoicemastersplitSrrRepository.save(srrEntity);
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("outResult", "1");
		resultMap.put("success", true);
		resultMap.put("data", data);
		resultMap.put("msg", "发票红冲成功");
		return resultMap;
	}
}
