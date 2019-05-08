package com.brcc.business.brokerTax.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 	经纪人税额主表
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
@Entity
@Table(name="broker_tax_master")
public class BrokerTaxMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="broker_tax_master_id")
	private Long brokerTaxMasterId;

	/**
	 *	季度税额周期
	 */
	@Column(name="broker_tax_quarter")
	private String brokerTaxQuarter;
	
	@Column(name="broker_id")
	private Long brokerId;
	
	@Column(name="broker_name")
	private String brokerName;
	
	@Column(name="broker_tele")
	private String brokerTele;
	
	@Column(name="broker_login_name")
	private String brokerLoginName;
	
	@Column(name="broker_no")
	private String brokerNo;
	
	@Column(name="payer_id")
	private Long payerId;
	
	/**
	 * 	付款公司
	 */
	@Column(name="payer_name")
	private String payerName;
	
	/**
	 * 	支付已收金额
	 */
	@Column(name="tot_payed_amt")
	private BigDecimal totPayedAmt;
	
	/**
	 * 	支付已收税额
	 */
	@Column(name="tot_payed_tax")
	private BigDecimal totPayedTax;
	
	/**
	 * 	净收入金额
	 */
	@Column(name="tot_profit_amt")
	private BigDecimal totProfitAmt;
	
	/**
	 * 	净收入税额
	 */
	@Column(name="tot_profit_tax")
	private BigDecimal totProfitTax;
	
	/**
	 * 	退税金额
	 */
	@Column(name="tot_drawback_tax")
	private BigDecimal totDrawbackTax;
	
	/**
	 * 	10持续更新，20落地生效
	 */
	@Column(name="tbl_status")
	private String tblStatus;
	
	/**
	 * 	10未生成退税支付单，20已生成退税支付单
	 */
	@Column(name="drawback_tax_bill_flag")
	private String drawbackTaxBillFlag;
	
	/**
	 * 	10未生成个税支付单，20已生成个税支付单
	 */
	@Column(name="person_tax_bill_flag")
	private String personTaxBillFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="system_timestamp")
	private Date systemTimestamp;

	public Long getBrokerTaxMasterId() {
		return brokerTaxMasterId;
	}

	public void setBrokerTaxMasterId(Long brokerTaxMasterId) {
		this.brokerTaxMasterId = brokerTaxMasterId;
	}

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

	public Long getPayerId() {
		return payerId;
	}

	public void setPayerId(Long payerId) {
		this.payerId = payerId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
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

	public Date getSystemTimestamp() {
		return systemTimestamp;
	}

	public void setSystemTimestamp(Date systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	public String getBrokerTele() {
		return brokerTele;
	}

	public void setBrokerTele(String brokerTele) {
		this.brokerTele = brokerTele;
	}

}