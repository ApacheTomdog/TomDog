package com.brcc.business.capital.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the capital_flowing database table.
 *  资金流水记录
 */
@Entity
@Table(name="capital_flowing")
@NamedQuery(name="CapitalFlowingEntity.findAll", query="SELECT c FROM CapitalFlowingEntity c")
public class CapitalFlowingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="capital_flowing_id", unique=true, nullable=false)
	private Long capitalFlowingId;

	@Column(precision=10, scale=2)
	private BigDecimal amount;

	@Column(name="capital_flowing_num", length=45)
	private String capitalFlowingNum;

	@Column(name="company_id", length=45)
	private Long companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person", length=45)
	private Long createPerson;

	@Column(name="depend_id", length=45)
	private String dependId;

	@Column(name="from_type", length=10)
	private String fromType;

	@Column(length=500)
	private String memo;

	@Column(length=3)
	private String method;

	@Column(name="operation_name", length=45)
	private String operationName;

	@Column(name="operation_type", length=2)
	private String operationType;

	@Column(name="out_trade_no", length=45)
	private String outTradeNo;

	@Column(name="platform_id", length=45)
	private String platformId;

	@Column(length=200)
	private String remark;

	@Column(length=45)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person", length=45)
	private Long updatePerson;

	public CapitalFlowingEntity() {
	}

	public Long getCapitalFlowingId() {
		return this.capitalFlowingId;
	}

	public void setCapitalFlowingId(Long capitalFlowingId) {
		this.capitalFlowingId = capitalFlowingId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCapitalFlowingNum() {
		return this.capitalFlowingNum;
	}

	public void setCapitalFlowingNum(String capitalFlowingNum) {
		this.capitalFlowingNum = capitalFlowingNum;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreatePerson() {
		return this.createPerson;
	}

	public void setCreatePerson(Long createPerson) {
		this.createPerson = createPerson;
	}

	public String getDependId() {
		return this.dependId;
	}

	public void setDependId(String dependId) {
		this.dependId = dependId;
	}

	public String getFromType() {
		return this.fromType;
	}

	public void setFromType(String fromType) {
		this.fromType = fromType;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatePerson() {
		return this.updatePerson;
	}

	public void setUpdatePerson(Long updatePerson) {
		this.updatePerson = updatePerson;
	}

}