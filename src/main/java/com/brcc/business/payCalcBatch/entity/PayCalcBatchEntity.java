package com.brcc.business.payCalcBatch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pay_calc_batch database table.
 * 
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="pay_calc_batch")
@NamedQuery(name="PayCalcBatchEntity.findAll", query="SELECT p FROM PayCalcBatchEntity p")
public class PayCalcBatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_calc_id", unique=true, nullable=false)
	private Long payCalcId;

	@Column(name="batch_id", length=50)
	private String batchId;

	@Column(name="calc_status", length=2)
	private String calcStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name", length=100)
	private String createPersonName;

	@Column(name="deduct_ratio", precision=10, scale=3)
	private BigDecimal deductRatio;

	@Column(name="deduct_type")
	private Integer deductType;

	@Column(name="deduct_weight", precision=10, scale=4)
	private BigDecimal deductWeight;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="max_pay_amount", precision=10, scale=2)
	private BigDecimal maxPayAmount;

	@Column(name="min_pay_amount", precision=10, scale=2)
	private BigDecimal minPayAmount;

	@Column(name="pay_amount_type")
	private Integer payAmountType;

	@Column(name="platform_id", nullable=false, length=20)
	private String platformId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="proc_date")
	private Date procDate;

	@Column(name="proc_result")
	private Integer procResult;

	@Column(name="proc_result_reason", length=200)
	private String procResultReason;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="settle_weight_type")
	private Integer settleWeightType;

	@Column(name="bank_if_settle_flag")
	private Integer bankIfSettleFlag;

	@Column(name="trans_id")
	private Long transId;

	@Column(name="transportation_amount", precision=10, scale=2)
	private BigDecimal transportationAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_person_id")
	private Long updatePersonId;

	@Column(name="update_person_name", length=100)
	private String updatePersonName;

	public PayCalcBatchEntity() {
	}

	public Long getPayCalcId() {
		return this.payCalcId;
	}

	public void setPayCalcId(Long payCalcId) {
		this.payCalcId = payCalcId;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getCalcStatus() {
		return this.calcStatus;
	}

	public void setCalcStatus(String calcStatus) {
		this.calcStatus = calcStatus;
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

	public BigDecimal getDeductRatio() {
		return this.deductRatio;
	}

	public void setDeductRatio(BigDecimal deductRatio) {
		this.deductRatio = deductRatio;
	}

	public Integer getDeductType() {
		return this.deductType;
	}

	public void setDeductType(Integer deductType) {
		this.deductType = deductType;
	}

	public BigDecimal getDeductWeight() {
		return this.deductWeight;
	}

	public void setDeductWeight(BigDecimal deductWeight) {
		this.deductWeight = deductWeight;
	}

	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public BigDecimal getMaxPayAmount() {
		return this.maxPayAmount;
	}

	public void setMaxPayAmount(BigDecimal maxPayAmount) {
		this.maxPayAmount = maxPayAmount;
	}

	public BigDecimal getMinPayAmount() {
		return this.minPayAmount;
	}

	public void setMinPayAmount(BigDecimal minPayAmount) {
		this.minPayAmount = minPayAmount;
	}

	public Integer getPayAmountType() {
		return this.payAmountType;
	}

	public void setPayAmountType(Integer payAmountType) {
		this.payAmountType = payAmountType;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Date getProcDate() {
		return this.procDate;
	}

	public void setProcDate(Date procDate) {
		this.procDate = procDate;
	}

	public Integer getProcResult() {
		return this.procResult;
	}

	public void setProcResult(Integer procResult) {
		this.procResult = procResult;
	}

	public String getProcResultReason() {
		return this.procResultReason;
	}

	public void setProcResultReason(String procResultReason) {
		this.procResultReason = procResultReason;
	}

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Integer getSettleWeightType() {
		return this.settleWeightType;
	}

	public void setSettleWeightType(Integer settleWeightType) {
		this.settleWeightType = settleWeightType;
	}

	public Long getTransId() {
		return this.transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public BigDecimal getTransportationAmount() {
		return this.transportationAmount;
	}

	public void setTransportationAmount(BigDecimal transportationAmount) {
		this.transportationAmount = transportationAmount;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdatePersonId() {
		return this.updatePersonId;
	}

	public void setUpdatePersonId(Long updatePersonId) {
		this.updatePersonId = updatePersonId;
	}

	public String getUpdatePersonName() {
		return this.updatePersonName;
	}

	public void setUpdatePersonName(String updatePersonName) {
		this.updatePersonName = updatePersonName;
	}

	public Integer getBankIfSettleFlag() {
		return bankIfSettleFlag;
	}

	public void setBankIfSettleFlag(Integer bankIfSettleFlag) {
		this.bankIfSettleFlag = bankIfSettleFlag;
	}
}