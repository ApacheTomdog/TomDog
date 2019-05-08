package com.brcc.business.blackbroker.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the blackbroker database table.
 * 
 */
@Entity
@Table(name="blackbroker")
@NamedQuery(name="BlackbrokerEntity.findAll", query="SELECT b FROM BlackbrokerEntity b")
public class BlackbrokerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="black_broker_id")
	private Long blackBrokerId;

	@Column(name="block_broker_ratio")
	private BigDecimal blockBrokerRatio;

	@Column(name="block_broker_status")
	private String blockBrokerStatus;

	@Column(name="broker_company_id")
	private Long brokerCompanyId;

	@Column(name="broker_company_name")
	private String brokerCompanyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="platform_id")
	private String platformId;

	public BlackbrokerEntity() {
	}

	public Long getBlackBrokerId() {
		return this.blackBrokerId;
	}

	public void setBlackBrokerId(Long blackBrokerId) {
		this.blackBrokerId = blackBrokerId;
	}

	public BigDecimal getBlockBrokerRatio() {
		return this.blockBrokerRatio;
	}

	public void setBlockBrokerRatio(BigDecimal blockBrokerRatio) {
		this.blockBrokerRatio = blockBrokerRatio;
	}

	public String getBlockBrokerStatus() {
		return this.blockBrokerStatus;
	}

	public void setBlockBrokerStatus(String blockBrokerStatus) {
		this.blockBrokerStatus = blockBrokerStatus;
	}

	public Long getBrokerCompanyId() {
		return this.brokerCompanyId;
	}

	public void setBrokerCompanyId(Long brokerCompanyId) {
		this.brokerCompanyId = brokerCompanyId;
	}

	public String getBrokerCompanyName() {
		return this.brokerCompanyName;
	}

	public void setBrokerCompanyName(String brokerCompanyName) {
		this.brokerCompanyName = brokerCompanyName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(Long modifyPersonId) {
		this.modifyPersonId = modifyPersonId;
	}

	public String getModifyPersonName() {
		return this.modifyPersonName;
	}

	public void setModifyPersonName(String modifyPersonName) {
		this.modifyPersonName = modifyPersonName;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

}