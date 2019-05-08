package com.brcc.business.brokerTax.vo;

import com.esteel.common.vo.BaseQueryVo;

/**
 * 	经纪人季度收入统计查询条件
 * 
 * @author hui.liu
 * @date 2019年1月31日
 */
public class BrokerTaxMasterQueryVo extends BaseQueryVo {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 	10持续更新，20落地生效
	 */
	private String tblStatus;
	
	/**
	 *	季度税额周期
	 */
	private String brokerTaxQuarter;
	
	/**
	 * 	经纪人名称
	 */
	private String brokerName;
	
	private String brokerTele;
	/**
	 * 经纪人id
	 */
	private Long brokerId;
	
	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}
	public String getTblStatus() {
		return tblStatus;
	}

	public void setTblStatus(String tblStatus) {
		this.tblStatus = tblStatus;
	}

	public String getBrokerTaxQuarter() {
		return brokerTaxQuarter;
	}

	public void setBrokerTaxQuarter(String brokerTaxQuarter) {
		this.brokerTaxQuarter = brokerTaxQuarter;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getBrokerTele() {
		return brokerTele;
	}

	public void setBrokerTele(String brokerTele) {
		this.brokerTele = brokerTele;
	}

	@Override
	public String toString() {
		return "BrokerTaxMasterQueryVo [tblStatus=" + tblStatus + ", brokerTaxQuarter=" + brokerTaxQuarter
				+ ", brokerName=" + brokerName + ", brokerTele=" + brokerTele + "]";
	}

}
