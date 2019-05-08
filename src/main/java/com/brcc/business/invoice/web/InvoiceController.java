package com.brcc.business.invoice.web;

import java.util.HashMap;
import java.util.List;

import com.brcc.business.invoice.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brcc.business.invoice.service.InvoiceService;

/**
 * @Description 发票
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 下午1:38:23
 */
@RestController
@RequestMapping("/invoice/")
public class InvoiceController {
	
	Logger logger = LoggerFactory.getLogger(InvoiceController.class);
	
	@Autowired
    InvoiceService invoiceService;
	
	/**
	 * 查询发票通知单申请数据
	 * @param queryVo
	 * @return
	 */
    @RequestMapping("/queryApplyListData")
    public Page<InvoiceMasterVo> queryApplyListData(@RequestBody InvoiceQueryVo queryVo){
    	logger.info("query invoice apply list data, queryVo:{}", queryVo);
    	Page<InvoiceMasterVo> page = invoiceService.queryApplyListData(queryVo);
    	return page;
    }
    
    /**
     * 查询发票通知单管理页面数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/invoiceApplyManageListData")
    public Page<InvoiceMasterVo> invoiceApplyManageListData(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query invoice apply manage list data page,queryVo:{}", queryVo);
    	Page<InvoiceMasterVo> page = invoiceService.queryApplyListData(queryVo);
    	return page;
    }
    
    /**
     * 查询开票方
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryVatCarryList")
    public List<InvoiceVo> queryVatCarryList(@RequestBody InvoiceQueryVo queryVo){
    	logger.info("query query vat carry list data, queryVo:{}", queryVo);
    	List<InvoiceVo> list = invoiceService.queryVatCarryList(queryVo);
    	return list;
    }
    
    /**
     * 保存发票
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveInvoice")
    public HashMap<String, Object> saveInvoice(@RequestBody InvoiceQueryVo vo){
    	Assert.notNull(vo, "发票信息不能为空");
    	logger.info("save invoice,vo:{}",vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.saveInvoice(vo);
		} catch (Exception e) {
			logger.error("save invoice,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			data.put("outResultReason", e.getMessage());
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
    	return resultMap;
    }
    
    /**
     * 查询开票数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryDetailListData")
    public Page<PayBillInfoVo> queryDetailListData(@RequestBody InvoiceQueryVo queryVo){
    	logger.info("Query pay bill list data page,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
    	Page<PayBillInfoVo> page = invoiceService.queryDetailListData(queryVo);
    	return page;
    }
    
    /**
     * 查询发票数据合计信息
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryDetailListDataSum")
    public SumTotalVo queryDetailListDataSum(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query pay bill list data sum,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
    	return invoiceService.queryDetailListDataSum(queryVo);
    }
    
    /**
     * 添加明细
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addInvoiceDetail")
    public HashMap<String, Object> addInvoiceDetail(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票明细信息不能为空");
    	logger.info("add invoice detail,vo:{}",vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.addInvoiceDetail(vo);
		} catch (Exception e) {
			logger.error("add invoice detail,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
    	return resultMap;
    }
    
    /**
     * 开票申请
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applyInvoice")
    public HashMap<String, Object> applyInvoice(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("apply invoice,vo:{}",vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.applyInvoice(vo);
    	} catch (Exception e) {
    		logger.error("apply invoice,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 作废发票通知单
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelInvoice")
    public HashMap<String, Object> cancelInvoice(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
		logger.info("cancel invoice,vo:{}",vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.cancelInvoice(vo);
    	} catch (Exception e) {
    		logger.error("cancel invoice,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 查询发票明细数据
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryInvoiceDetailListData")
    public List<InvoiceDetailVo> queryInvoiceDetailListData(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query invoice detail list data page,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
    	List<InvoiceDetailVo> page = invoiceService.queryInvoiceDetailListData(queryVo);
    	return page;
    }
    
    /**
     * 查询发票明细数据合计信息
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryInvoiceDetailListDataSum")
    public SumTotalVo queryInvoiceDetailListDataSum(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query invoice detail list data sum,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
    	return invoiceService.queryInvoiceDetailListDataSum(queryVo);
    }
    /**
     * 查询红字发票明细数据合计信息
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryRedInvoiceDetailListDataSum")
    public SumTotalVo queryRedInvoiceDetailListDataSum(@RequestBody InvoiceQueryVo queryVo) {
        logger.info("Query red invoice detail list data sum,invoiceCarryId:{}", queryVo.getInvoiceCarryId());
        return invoiceService.queryRedInvoiceDetailListDataSum(queryVo);
    }

    /**
     * 删除发票明细
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteInvoiceDetail")
    public HashMap<String, Object> deleteInvoiceDetail(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceDetailIdStr(), "发票明细id不能为空");
    	logger.info("delete invoice detail,vo:{}", vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.deleteInvoiceDetail(vo);
    	} catch (Exception e) {
    		logger.error("apply invoice,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 修改备注
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveRemark")
    public HashMap<String, Object> saveRemark(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票备注信息不能为空");
    	logger.info("save remark,vo:{}",vo.toString());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.saveRemark(vo);
		} catch (Exception e) {
			logger.error("save remark,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			data.put("outResultReason", e.getMessage());
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
    	return resultMap;
    }
    
    /**
     * 查询发票详情数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryInvoiceListData")
    public Page<InvoicemastersplitVo> queryInvoiceListData(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query invoice list data page,queryVo:{}", queryVo);
    	Page<InvoicemastersplitVo> page = invoiceService.queryInvoiceListData(queryVo);
    	return page;
    }
    
    /**
     * 发票管理合计
     * @param queryVo
     * @return
     */
    @RequestMapping(value = "/queryInvoiceManageListDataSum")
    public SumTotalVo queryInvoiceManageListDataSum(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("Query invoice manage list data sum,queryVo:{}", queryVo);
    	return invoiceService.queryInvoiceManageListDataSum(queryVo);
    }
    
    /**
     * 查询发票通知单数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryInvoiceApplyListInfo")
    public List<InvoiceMasterVo> queryInvoiceApplyListInfo(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("query invoice apply list info data, queryVo:{}", queryVo);
    	List<InvoiceMasterVo> page = invoiceService.queryInvoiceApplyListInfo(queryVo);
    	return page;
    }
    
    /**
     * 作废剩余量
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/remaining")
    public HashMap<String, Object> remaining(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo.getInvoiceMasterId(), "invoiceMasterId不能为空");
    	logger.info("remaining,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.remaining(vo);
		} catch (Exception e) {
			logger.error("remaining,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
    	return resultMap;
    }
    
    /**
     * 全部作废
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping("/voidAll")
    public HashMap<String, Object> voidAll(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo.getInvoiceMasterId(), "invoiceMasterId不能为空");
		Assert.notNull(vo.getRemark(), "remark不能为空");
		logger.info("voidAll,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.voidAll(vo);
    	} catch (Exception e) {
    		logger.error("voidAll,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 向下一级申请
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/applyToNext")
    public HashMap<String, Object> applyToNext(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("apply to next,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.applyToNext(vo);
    	} catch (Exception e) {
    		logger.error("apply to next,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 自动拆分
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/autoSplit")
    public HashMap<String, Object> autoSplit(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
    	logger.info("auto split,invoiceMasterId:{}",vo.getInvoiceMasterId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.autoSplit(vo);
    	} catch (Exception e) {
    		logger.error("auto split,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 发票拆分
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/invoiceSplit")
    public HashMap<String, Object> invoiceSplit(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceMasterId(), "发票通知单编号不能为空");
		Assert.notNull(vo.getDetailIds(), "发票明细id不能为空");
		logger.info("invoice split,invoiceMasterId:{},detailIds:{}",vo.getInvoiceMasterId(), vo.getDetailIds());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.invoiceSplit(vo);
    	} catch (Exception e) {
    		logger.error("invoice split,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 保存发票维护
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveInvoiceMaintain")
    public HashMap<String, Object> saveInvoiceMaintain(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	Assert.notNull(vo.getInvoiceNo(), "发票号不能为空");
    	Assert.notNull(vo.getInvoiceAgreeTime(), "开票时间不能为空");
    	logger.info("save invoice maintain,invoiceSplitId:{}, invoiceNo:{}, invoiceAgreeTime:{}",vo.getInvoiceSplitId(), vo.getInvoiceNo(), vo.getInvoiceAgreeTime());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.saveInvoiceMaintain(vo);
    	} catch (Exception e) {
    		logger.error("save invoice maintain,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 重新保存发票
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveInvoiceReMaintain")
    public HashMap<String, Object> saveInvoiceReMaintain(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	Assert.notNull(vo.getInvoiceNo(), "发票号不能为空");
    	Assert.notNull(vo.getInvoiceAgreeTime(), "开票时间不能为空");
    	logger.info("save invoice remaintain,invoiceSplitId:{}, invoiceNo:{}, invoiceAgreeTime:{}",vo.getInvoiceSplitId(), vo.getInvoiceNo(), vo.getInvoiceAgreeTime());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.saveInvoiceReMaintain(vo);
    	} catch (Exception e) {
    		logger.error("save invoice maintain,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 作废发票
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelInvoiceSplit")
    public HashMap<String, Object> cancelInvoiceSplit(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
    	Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
    	logger.info("cancel invoice split,invoiceSplitId:{}",vo.getInvoiceSplitId());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.cancelInvoiceSplit(vo);
    	} catch (Exception e) {
    		logger.error("cancel invoice split,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }

	/**
	 * 发票红冲
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/redDashInvoice")
	public HashMap<String, Object> redDashInvoice(@RequestBody InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
		logger.info("red dash invoice,invoiceSplitId:{}",vo.getInvoiceSplitId());
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = invoiceService.redDashInvoice(vo);
		} catch (Exception e) {
			logger.error("cancel invoice split,message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}


	/**
     * 增加发票打印次数
     * @param vo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPrintNum")
    public HashMap<String, Object> addPrintNum(@RequestBody InvoiceQueryVo vo) {
    	Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
		logger.info("add print num,invoiceSplitId:{},invoiceSplitNum:{}",vo.getInvoiceSplitId(), vo.getInvoiceSplitNum());
    	HashMap<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = invoiceService.addPrintNum(vo);
    	} catch (Exception e) {
    		logger.error("add print num,message:{}",e.getMessage());
    		HashMap<String, String> data = new HashMap<String, String>();
    		data.put("outResult", "0");
    		resultMap.put("success", true);
    		resultMap.put("data", data);
    		resultMap.put("msg", e.getMessage());
    	}
    	return resultMap;
    }
    
    /**
     * 查询发票管理数据
     * @param queryVo
     * @return
     */
    @RequestMapping("/queryInvoiceManageListInfo")
    public List<InvoicemastersplitVo> queryInvoiceManageListInfo(@RequestBody InvoiceQueryVo queryVo) {
    	logger.info("query invoice manage list info data, queryVo:{}", queryVo);
    	List<InvoicemastersplitVo> page = invoiceService.queryInvoiceManageListInfo(queryVo);
    	return page;
    }


	/**
	 * 查询红冲、作废发票发票管理数据
	 * @param queryVo
	 * @return
	 */
	@RequestMapping("/redInvoiceManageListData")
	public Page<InvoiceMasterSrrVo> redInvoiceManageListData(@RequestBody InvoiceQueryVo queryVo) {
		logger.info("query red invoice manage list info data, queryVo:{}", queryVo);
		Page<InvoiceMasterSrrVo> page = invoiceService.redInvoiceManageListData(queryVo);
		return page;
	}

	/**
	 * 红冲、作废发票管理合计
	 * @param queryVo
	 * @return
	 */
	@RequestMapping(value = "/queryRedInvoiceManageListDataSum")
	public SumTotalVo queryRedInvoiceManageListDataSum(@RequestBody InvoiceQueryVo queryVo) {
		logger.info("Query red invoice manage list data sum,queryVo:{}", queryVo);
		return invoiceService.queryRedInvoiceManageListDataSum(queryVo);
	}

	/**
	 * @Desc 查询作废、红冲发票明细数据
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/queryRedInvoiceDetailListData")
	public Page<InvoiceDetailSrrVo> queryRedInvoiceDetailListData(@RequestBody InvoiceQueryVo vo){
		logger.info("Query red invoice detail list data page,queryVo:{}", vo);
		Assert.notNull(vo.getInvoiceSplitNum(),"无法获取到对应的发票编号");
		Page<InvoiceDetailSrrVo> page= invoiceService.queryRedInvoiceDetailListData(vo);
		return page;
	}

	/**
	 * 维护红冲发票信息
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveRedInvoiceMaintain")
	public HashMap<String, Object> saveRedInvoiceMaintain(@RequestBody InvoiceQueryVo vo) {
		Assert.notNull(vo, "发票信息不能为空");
		Assert.notNull(vo.getInvoiceSplitId(), "发票id不能为空");
		Assert.notNull(vo.getInvoiceSplitSrrId(),"找不到对应的操作单据");
		Assert.notNull(vo.getRedInvoiceNo(), "红冲发票号不能为空");
		Assert.notNull(vo.getRedInvoiceDate(),"红冲发票时间不能为空");
		logger.info("save red invoice maintain,:invoiceSplitSrrId{}, redInvoiceNo:{}, redInvoiceDate:{}",vo.getInvoiceSplitSrrId(), vo.getRedInvoiceNo(), vo.getRedInvoiceDate());
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = invoiceService.saveRedInvoiceMaintain(vo);
		} catch (Exception e) {
			logger.error("save red invoice maintain message:{}",e.getMessage());
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("outResult", "0");
			resultMap.put("success", true);
			resultMap.put("data", data);
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}

}
