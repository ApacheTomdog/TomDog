package com.brcc.business.brokerProfit.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the broker_pp_switch database table.
 * 
 */
@Entity
@Table(name="broker_pp_switch")
public class BrokerPpSwitchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="broker_pp_switch_id")
	private Long brokerPpSwitchId;

	@Column(name="broker_id")
	private Long brokerId;

	@Column(name="broker_name")
	private String brokerName;

	@Column(name="if_payment_control")
	private Integer ifPaymentControl;

	@Column(name="if_profit_control")
	private Integer ifProfitControl;
	
	@Column(name="payment_pay_ratio")
	private BigDecimal paymentPayRatio;
	
	@Column(name="payment_tax_raito")
	private BigDecimal paymentTaxRaito;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="system_timestamp")
	private Date systemTimestamp;

	@Column(name="tbl_status")
	private String tblStatus;

	public BrokerPpSwitchEntity() {
	}

	public Long getBrokerPpSwitchId() {
		return this.brokerPpSwitchId;
	}

	public void setBrokerPpSwitchId(Long brokerPpSwitchId) {
		this.brokerPpSwitchId = brokerPpSwitchId;
	}

	public Long getBrokerId() {
		return this.brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return this.brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public Integer getIfPaymentControl() {
		return this.ifPaymentControl;
	}

	public void setIfPaymentControl(Integer ifPaymentControl) {
		this.ifPaymentControl = ifPaymentControl;
	}

	public Integer getIfProfitControl() {
		return this.ifProfitControl;
	}

	public void setIfProfitControl(Integer ifProfitControl) {
		this.ifProfitControl = ifProfitControl;
	}

	public Date getSystemTimestamp() {
		return this.systemTimestamp;
	}

	public void setSystemTimestamp(Date systemTimestamp) {
		this.systemTimestamp = systemTimestamp;
	}

	public String getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(String tblStatus) {
		this.tblStatus = tblStatus;
	}

	public BigDecimal getPaymentPayRatio() {
		return paymentPayRatio;
	}

	public void setPaymentPayRatio(BigDecimal paymentPayRatio) {
		this.paymentPayRatio = paymentPayRatio;
	}

	public BigDecimal getPaymentTaxRaito() {
		return paymentTaxRaito;
	}

	public void setPaymentTaxRaito(BigDecimal paymentTaxRaito) {
		this.paymentTaxRaito = paymentTaxRaito;
	}

}