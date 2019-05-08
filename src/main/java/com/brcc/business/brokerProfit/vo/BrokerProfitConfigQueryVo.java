package com.brcc.business.brokerProfit.vo;

import java.util.Date;
import com.esteel.common.vo.BaseQueryVo;

/**
 * 查询条件
 * @author dzj
 * @date 2019-01-29
 */
public class BrokerProfitConfigQueryVo extends BaseQueryVo {
	private static final long serialVersionUID = 1L;
	
	/**
	 * '0'代表常规，'1'代表特例
	 */
	private String ifSpecialCase;
 
	/**
	 * '10'代表新增，'00'代表作废，'20'代表生效
	 */
	private String brokerProfitConfigStatus;
 
	/**
	 * 修改日期开始
	 */
	private Date modifyDateStart;

	/**
	 * 修改日期结束
	 */
	private Date modifyDateEnd;
	
	/**
	 * 特例经纪人
	 */
	private String specialBrokerName;

	/**
	 * 平台id
	 */
	private String platformId;
	
	/**
	 * 经纪人id(公司Id)
	 */
	private Long specialBrokerId;
	
	/**
	 *创建日期开始
	 */
	private Date createDateStart;

	/**
	 * 创建日期结束
	 */
	private Date createDateEnd;
	
	public String getIfSpecialCase() {
		return ifSpecialCase;
	}

	public void setIfSpecialCase(String ifSpecialCase) {
		this.ifSpecialCase = ifSpecialCase;
	}

	public String getBrokerProfitConfigStatus() {
		return brokerProfitConfigStatus;
	}

	public void setBrokerProfitConfigStatus(String brokerProfitConfigStatus) {
		this.brokerProfitConfigStatus = brokerProfitConfigStatus;
	}

	public Date getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(Date createDateStart) {
		this.createDateStart = createDateStart;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public String getSpecialBrokerName() {
		return specialBrokerName;
	}

	public void setSpecialBrokerName(String specialBrokerName) {
		this.specialBrokerName = specialBrokerName;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getSpecialBrokerId() {
		return specialBrokerId;
	}

	public void setSpecialBrokerId(Long specialBrokerId) {
		this.specialBrokerId = specialBrokerId;
	}

	public Date getModifyDateStart() {
		return modifyDateStart;
	}

	public void setModifyDateStart(Date modifyDateStart) {
		this.modifyDateStart = modifyDateStart;
	}

	public Date getModifyDateEnd() {
		return modifyDateEnd;
	}

	public void setModifyDateEnd(Date modifyDateEnd) {
		this.modifyDateEnd = modifyDateEnd;
	}

	@Override
	public String toString() {
		return "BrokerProfitConfigQueryVo [ifSpecialCase=" + ifSpecialCase + ", brokerProfitConfigStatus="
				+ brokerProfitConfigStatus + ", modifyDateStart=" + modifyDateStart + ", modifyDateEnd=" + modifyDateEnd
				+ ", specialBrokerName=" + specialBrokerName + ", platformId=" + platformId + ", specialBrokerId="
				+ specialBrokerId + ", createDateStart=" + createDateStart + ", createDateEnd=" + createDateEnd + "]";
	}
}