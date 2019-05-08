package com.brcc.business.brokerTax.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 	经纪人季度收入统计查询条件
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxDetailQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	
	private Long brokerId;
	private String brokerTaxQuarter;
	private String payBillNum;
	private Long deliveryId;
	private Long transId;
	private Long publishId;
	private String publishCompanyName;
	private String driverName;

	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerTaxQuarter() {
		return brokerTaxQuarter;
	}

	public void setBrokerTaxQuarter(String brokerTaxQuarter) {
		this.brokerTaxQuarter = brokerTaxQuarter;
	}

	public String getPayBillNum() {
		return payBillNum;
	}

	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
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

	public String getPublishCompanyName() {
		return publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "BrokerTaxDetailQueryVo [brokerId=" + brokerId + ", brokerTaxQuarter=" + brokerTaxQuarter
				+ ", payBillNum=" + payBillNum + ", deliveryId=" + deliveryId + ", transId=" + transId + ", publishId="
				+ publishId + ", publishCompanyName=" + publishCompanyName + ", driverName=" + driverName + "]";
	}

}
