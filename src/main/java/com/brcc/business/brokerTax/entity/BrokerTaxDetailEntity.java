package com.brcc.business.brokerTax.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 	经纪人税额子表
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
@Entity
@Table(name="broker_tax_detail")
public class BrokerTaxDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="broker_tax_detail_id")
	private Long brokerTaxDetailId;
	
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
	
	@Column(name="broker_mobile")
	private String brokerMobile;
	
	@Column(name="payer_id")
	private Long payerId;
	
	/**
	 * 	付款公司
	 */
	@Column(name="payer_name")
	private String payerName;
	
	@Column(name="pay_bill_id")
	private Long payBillId;
	
	@Column(name="pay_bill_num")
	private String payBillNum;
	
	@Column(name="delivery_id")
	private Long deliveryId;
	
	@Column(name="trans_id")
	private Long transId;
	
	@Column(name="publish_id")
	private Long publishId;
	
	@Column(name="publish_depend_num")
	private String publishDependNum;
	
	@Column(name="publish_company_id")
	private Long publishCompanyId;
	
	@Column(name="publish_company_name")
	private String publishCompanyName;
	
	@Column(name="publish_company_tele")
	private String publishCompanyTele;
	
	@Column(name="driver_id")
	private Long driverId;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="vehicle_id")
	private Long vehicleId;
	
	@Column(name="vehicle_num")
	private String vehicleNum;
	
	/**
	 * 	支付已收金额
	 */
	@Column(name="payed_amt")
	private BigDecimal payedAmt;
	
	/**
	 * 	支付已收税额
	 */
	@Column(name="payed_tax")
	private BigDecimal payedTax;
	
	/**
	 * 	净收入金额
	 */
	@Column(name="profit_amt")
	private BigDecimal profitAmt;
	
	/**
	 * 	净收入税额
	 */
	@Column(name="profit_tax")
	private BigDecimal profitTax;
	
	/**
	 * 	0代表未纳入统计，1代表已纳入统计
	 */
	@Column(name="if_stat")
	private Integer ifStat;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="system_timestamp")
	private Date systemTimestamp;

	public Long getBrokerTaxDetailId() {
		return brokerTaxDetailId;
	}

	public void setBrokerTaxDetailId(Long brokerTaxDetailId) {
		this.brokerTaxDetailId = brokerTaxDetailId;
	}

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

	public Long getPayBillId() {
		return payBillId;
	}

	public void setPayBillId(Long payBillId) {
		this.payBillId = payBillId;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Long getTransId() {
		return transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public BigDecimal getPayedAmt() {
		return payedAmt;
	}

	public void setPayedAmt(BigDecimal payedAmt) {
		this.payedAmt = payedAmt;
	}

	public BigDecimal getPayedTax() {
		return payedTax;
	}

	public void setPayedTax(BigDecimal payedTax) {
		this.payedTax = payedTax;
	}

	public BigDecimal getProfitAmt() {
		return profitAmt;
	}

	public void setProfitAmt(BigDecimal profitAmt) {
		this.profitAmt = profitAmt;
	}

	public BigDecimal getProfitTax() {
		return profitTax;
	}

	public void setProfitTax(BigDecimal profitTax) {
		this.profitTax = profitTax;
	}

	public Integer getIfStat() {
		return ifStat;
	}

	public void setIfStat(Integer ifStat) {
		this.ifStat = ifStat;
	}

	public Date getSystemTimestamp() {
		return systemTimestamp;
	}

	public void setSystemTimestamp(Date systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	public String getPayBillNum() {
		return payBillNum;
	}

	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
	}

	public String getPublishDependNum() {
		return publishDependNum;
	}

	public void setPublishDependNum(String publishDependNum) {
		this.publishDependNum = publishDependNum;
	}

	public Long getPublishCompanyId() {
		return publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

	public String getPublishCompanyName() {
		return publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public String getPublishCompanyTele() {
		return publishCompanyTele;
	}

	public void setPublishCompanyTele(String publishCompanyTele) {
		this.publishCompanyTele = publishCompanyTele;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public String getBrokerMobile() {
		return brokerMobile;
	}

	public void setBrokerMobile(String brokerMobile) {
		this.brokerMobile = brokerMobile;
	}

}