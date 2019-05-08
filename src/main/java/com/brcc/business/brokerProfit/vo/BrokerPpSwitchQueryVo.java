package com.brcc.business.brokerProfit.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 经纪人分润支付开关查询类
 * @author TangYong
 * @date 2019-02-13
 */
public class BrokerPpSwitchQueryVo extends BaseQueryVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 经纪人id(companyId)
	 */
	private Long brokerId;
	
	/**
	 * 0代表调度分润不限制，1代表调度分润限制
	 */
	private Integer ifProfitControl;
 
	/**
	 * 0代表支付不扣税额，1代表支付扣税额
	 */
	private Integer if_payment_control;
	
	/**
	 * '20'代表有效，'00'代表无效
	 */
	private String tbl_status;

	
	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

	public Integer getIfProfitControl() {
		return ifProfitControl;
	}

	public void setIfProfitControl(Integer ifProfitControl) {
		this.ifProfitControl = ifProfitControl;
	}

	public Integer getIf_payment_control() {
		return if_payment_control;
	}

	public void setIf_payment_control(Integer if_payment_control) {
		this.if_payment_control = if_payment_control;
	}

	public String getTbl_status() {
		return tbl_status;
	}

	public void setTbl_status(String tbl_status) {
		this.tbl_status = tbl_status;
	}

	
}