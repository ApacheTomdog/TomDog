package com.brcc.business.invoice.service;

import java.util.HashMap;
import java.util.List;

import com.brcc.business.invoice.vo.*;
import org.springframework.data.domain.Page;

/**
 * @Description 发票逻辑接口
 * @author yangwenbin
 * @version 创建时间：2018年11月19日 上午11:02:12
 */
public interface InvoiceService {

	/**
	 * 查询发票通知单申请数据
	 * @param queryVo
	 * @return
	 */
	Page<InvoiceMasterVo> queryApplyListData(InvoiceQueryVo queryVo);

	/**
	 * 查询开票方
	 * @param queryVo
	 * @return
	 */
	List<InvoiceVo> queryVatCarryList(InvoiceQueryVo queryVo);

	/**
	 * 保存发票
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> saveInvoice(InvoiceQueryVo vo);

	/**
	 * 查询开票数据
	 * @param queryVo
	 * @return
	 */
	Page<PayBillInfoVo> queryDetailListData(InvoiceQueryVo queryVo);

	/**
	 * 查询发票数据合计信息
	 * @param queryVo
	 * @return
	 */
	SumTotalVo queryDetailListDataSum(InvoiceQueryVo queryVo);

	/**
	 * 添加明细
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> addInvoiceDetail(InvoiceQueryVo vo);

	/**
	 * 开票申请
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> applyInvoice(InvoiceQueryVo vo);

	/**
	 * 作废发票通知单
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> cancelInvoice(InvoiceQueryVo vo);

	/**
	 * 查询发票明细数据
	 * @param queryVo
	 * @return
	 */
	List<InvoiceDetailVo> queryInvoiceDetailListData(InvoiceQueryVo queryVo);

	/**
	 * 查询发票明细数据合计信息
	 * @param queryVo
	 * @return
	 */
	SumTotalVo queryInvoiceDetailListDataSum(InvoiceQueryVo queryVo);

	/**
	 * 删除发票明细
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> deleteInvoiceDetail(InvoiceQueryVo vo);

	/**
	 * 修改备注
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> saveRemark(InvoiceQueryVo vo);

	/**
	 * 查询发票详情数据
	 * @param queryVo
	 * @return
	 */
	Page<InvoicemastersplitVo> queryInvoiceListData(InvoiceQueryVo queryVo);

	/**
	 * 查询发票通知单数据
	 * @param queryVo
	 * @return
	 */
	List<InvoiceMasterVo> queryInvoiceApplyListInfo(InvoiceQueryVo queryVo);

	/**
	 * 作废剩余量
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> remaining(InvoiceQueryVo vo);

	/**
	 * 全部作废
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> voidAll(InvoiceQueryVo vo);

	/**
	 * 向下一级申请
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> applyToNext(InvoiceQueryVo vo);

	/**
	 * 自动拆分
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> autoSplit(InvoiceQueryVo vo);

	/**
	 * 发票拆分
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> invoiceSplit(InvoiceQueryVo vo);

	/**
	 * 发票管理合计
	 * @param queryVo
	 * @return
	 */
	SumTotalVo queryInvoiceManageListDataSum(InvoiceQueryVo queryVo);

	/**
	 * 保存发票维护
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> saveInvoiceMaintain(InvoiceQueryVo vo);

	/**
	 * 重新保存发票
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> saveInvoiceReMaintain(InvoiceQueryVo vo);

	/**
	 * 作废发票
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> cancelInvoiceSplit(InvoiceQueryVo vo);

	/**
	 * 查询发票管理数据
	 * @param queryVo
	 * @return
	 */
	List<InvoicemastersplitVo> queryInvoiceManageListInfo(InvoiceQueryVo queryVo);

	/**
	 * 增加发票打印次数
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> addPrintNum(InvoiceQueryVo vo);

	/**
	 * 发票红冲
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> redDashInvoice(InvoiceQueryVo vo);

	/**
	 * 查询红冲、作废发票发票管理数据
	 * @param queryVo
	 * @return
	 */
	Page<InvoiceMasterSrrVo> redInvoiceManageListData(InvoiceQueryVo queryVo);

	/**
	 * 作废、红冲发票管理合计
	 * @param queryVo
	 * @return
	 */
	SumTotalVo queryRedInvoiceManageListDataSum(InvoiceQueryVo queryVo);

	/**
	 * 查询作废、红冲发票明细数据
	 * @param queryVo
	 * @return
	 */
	Page<InvoiceDetailSrrVo> queryRedInvoiceDetailListData(InvoiceQueryVo queryVo);
	/**
	 * 查询作废、红冲发票明细数据合计
	 * @param queryVo
	 * @return
	 */
	SumTotalVo queryRedInvoiceDetailListDataSum(InvoiceQueryVo queryVo);

	/**
	 * 维护红冲发票信息
	 * @param vo
	 * @return
	 */
	HashMap<String, Object> saveRedInvoiceMaintain(InvoiceQueryVo vo);


}
