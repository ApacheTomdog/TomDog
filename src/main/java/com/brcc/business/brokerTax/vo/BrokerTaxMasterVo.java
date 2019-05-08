package com.brcc.business.brokerTax.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 	经纪人季度收入统计
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxMasterVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 *	季度税额周期
	 */
	private String brokerTaxQuarter;
	
	private Long brokerId;
	
	private String brokerName;
	
	private String brokerTele;
	
	private String brokerLoginName;
	
	private String brokerNo;
	
	/**
	 * 	支付已收金额
	 */
	private BigDecimal totPayedAmt;
	
	/**
	 * 	支付已收税额
	 */
	private BigDecimal totPayedTax;
	
	/**
	 * 	净收入金额
	 */
	private BigDecimal totProfitAmt;
	
	/**
	 * 	净收入税额
	 */
	private BigDecimal totProfitTax;
	
	/**
	 * 	退税金额
	 */
	private BigDecimal totDrawbackTax;
	
	/**
	 * 	10持续更新，20落地生效
	 */
	private String tblStatus;
	
	/**
	 * 	10未生成退税支付单，20已生成退税支付单
	 */
	private String drawbackTaxBillFlag;
	
	/**
	 * 	10未生成个税支付单，20已生成个税支付单
	 */
	private String personTaxBillFlag;

	public String getBrokerTaxQuarter() {
		return brokerTaxQuarter;
	}

	public void setBrokerTaxQuarter(String brokerTaxQuarter) {
		this.brokerTaxQuarter = brokerTaxQuarter;
	}

	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getBrokerLoginName() {
		return brokerLoginName;
	}

	public void setBrokerLoginName(String brokerLoginName) {
		this.brokerLoginName = brokerLoginName;
	}

	public String getBrokerNo() {
		return brokerNo;
	}

	public void setBrokerNo(String brokerNo) {
		this.brokerNo = brokerNo;
	}

	public BigDecimal getTotPayedAmt() {
		return totPayedAmt;
	}

	public void setTotPayedAmt(BigDecimal totPayedAmt) {
		this.totPayedAmt = totPayedAmt;
	}

	public BigDecimal getTotPayedTax() {
		return totPayedTax;
	}

	public void setTotPayedTax(BigDecimal totPayedTax) {
		this.totPayedTax = totPayedTax;
	}

	public BigDecimal getTotProfitAmt() {
		return totProfitAmt;
	}

	public void setTotProfitAmt(BigDecimal totProfitAmt) {
		this.totProfitAmt = totProfitAmt;
	}

	public BigDecimal getTotProfitTax() {
		return totProfitTax;
	}

	public void setTotProfitTax(BigDecimal totProfitTax) {
		this.totProfitTax = totProfitTax;
	}

	public BigDecimal getTotDrawbackTax() {
		return totDrawbackTax;
	}

	public void setTotDrawbackTax(BigDecimal totDrawbackTax) {
		this.totDrawbackTax = totDrawbackTax;
	}

	public String getTblStatus() {
		return tblStatus;
	}

	public void setTblStatus(String tblStatus) {
		this.tblStatus = tblStatus;
	}

	public String getDrawbackTaxBillFlag() {
		return drawbackTaxBillFlag;
	}

	public void setDrawbackTaxBillFlag(String drawbackTaxBillFlag) {
		this.drawbackTaxBillFlag = drawbackTaxBillFlag;
	}

	public String getPersonTaxBillFlag() {
		return personTaxBillFlag;
	}

	public void setPersonTaxBillFlag(String personTaxBillFlag) {
		this.personTaxBillFlag = personTaxBillFlag;
	}

	public String getBrokerTele() {
		return brokerTele;
	}

	public void setBrokerTele(String brokerTele) {
		this.brokerTele = brokerTele;
	}
	
}
