package com.brcc.business.blackbroker.vo;

import java.math.BigDecimal;
import java.util.Date;

public class blackBrokerVo {
	private Long blackBrokerId;
	private String platformId;// 平台id
	private Long brokerCompanyId;// 经纪人公司id
	private String brokerCompanyName;// 经纪人公司名字
	private String blockBrokerStatus;// 经纪人黑名单状态‘00’代表作废删除 ‘10’代表新增 ‘20’代表生效状态
	private BigDecimal blockBrokerRatio;// 经纪人分配的比率
	private Date createDate;
	private Long createPersonId;
	private String createPersonName;
	private Date modifyDate;
	private Long modifyPersonId;
	private String modifyPersonName;
	public Long getBlackBrokerId() {
		return blackBrokerId;
	}
	public void setBlackBrokerId(Long blackBrokerId) {
		this.blackBrokerId = blackBrokerId;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public Long getBrokerCompanyId() {
		return brokerCompanyId;
	}
	public void setBrokerCompanyId(Long brokerCompanyId) {
		this.brokerCompanyId = brokerCompanyId;
	}
	public String getBrokerCompanyName() {
		return brokerCompanyName;
	}
	public void setBrokerCompanyName(String brokerCompanyName) {
		this.brokerCompanyName = brokerCompanyName;
	}
	public String getBlockBrokerStatus() {
		return blockBrokerStatus;
	}
	public void setBlockBrokerStatus(String blockBrokerStatus) {
		this.blockBrokerStatus = blockBrokerStatus;
	}
	public BigDecimal getBlockBrokerRatio() {
		return blockBrokerRatio;
	}
	public void setBlockBrokerRatio(BigDecimal blockBrokerRatio) {
		this.blockBrokerRatio = blockBrokerRatio;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}
	public String getCreatePersonName() {
		return createPersonName;
	}
	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getModifyPersonId() {
		return modifyPersonId;
	}
	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}
	public String getModifyPersonName() {
		return modifyPersonName;
	}
	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}
	
}
