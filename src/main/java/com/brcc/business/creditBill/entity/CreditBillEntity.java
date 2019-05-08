package com.brcc.business.creditBill.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="credit_bill")
public class CreditBillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="credit_bill_id")
	private Long creditBillId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="credit_bill_amt")
	private BigDecimal creditBillAmt;

	@Column(name="credit_bill_date_str")
	private String creditBillDateStr;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="credit_bill_dies_date")
	private Date creditBillDiesDate;

	@Column(name="credit_bill_dies_flag")
	private String creditBillDiesFlag;

	@Column(name="credit_bill_no")
	private String creditBillNo;

	@Column(name="credit_bill_repay_amt")
	private BigDecimal creditBillRepayAmt;

	@Column(name="credit_bill_status")
	private String creditBillStatus;

	@Column(name="credit_company_id")
	private Long creditCompanyId;

	@Column(name="credit_company_name")
	private String creditCompanyName;

	@Column(name="invest_company_id")
	private Long investCompanyId;

	@Column(name="invest_company_name")
	private String investCompanyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="total_used_amount")
	private BigDecimal totalUsedAmount;

	public CreditBillEntity() {
	}

	public Long getCreditBillId() {
		return this.creditBillId;
	}

	public void setCreditBillId(Long creditBillId) {
		this.creditBillId = creditBillId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getCreditBillAmt() {
		return this.creditBillAmt;
	}

	public void setCreditBillAmt(BigDecimal creditBillAmt) {
		this.creditBillAmt = creditBillAmt;
	}

	public String getCreditBillDateStr() {
		return this.creditBillDateStr;
	}

	public void setCreditBillDateStr(String creditBillDateStr) {
		this.creditBillDateStr = creditBillDateStr;
	}

	public Date getCreditBillDiesDate() {
		return this.creditBillDiesDate;
	}

	public void setCreditBillDiesDate(Date creditBillDiesDate) {
		this.creditBillDiesDate = creditBillDiesDate;
	}

	public String getCreditBillDiesFlag() {
		return this.creditBillDiesFlag;
	}

	public void setCreditBillDiesFlag(String creditBillDiesFlag) {
		this.creditBillDiesFlag = creditBillDiesFlag;
	}

	public String getCreditBillNo() {
		return this.creditBillNo;
	}

	public void setCreditBillNo(String creditBillNo) {
		this.creditBillNo = creditBillNo;
	}

	public BigDecimal getCreditBillRepayAmt() {
		return this.creditBillRepayAmt;
	}

	public void setCreditBillRepayAmt(BigDecimal creditBillRepayAmt) {
		this.creditBillRepayAmt = creditBillRepayAmt;
	}

	public String getCreditBillStatus() {
		return this.creditBillStatus;
	}

	public void setCreditBillStatus(String creditBillStatus) {
		this.creditBillStatus = creditBillStatus;
	}

	public Long getCreditCompanyId() {
		return this.creditCompanyId;
	}

	public void setCreditCompanyId(Long creditCompanyId) {
		this.creditCompanyId = creditCompanyId;
	}

	public String getCreditCompanyName() {
		return this.creditCompanyName;
	}

	public void setCreditCompanyName(String creditCompanyName) {
		this.creditCompanyName = creditCompanyName;
	}

	public Long getInvestCompanyId() {
		return this.investCompanyId;
	}

	public void setInvestCompanyId(Long investCompanyId) {
		this.investCompanyId = investCompanyId;
	}

	public String getInvestCompanyName() {
		return this.investCompanyName;
	}

	public void setInvestCompanyName(String investCompanyName) {
		this.investCompanyName = investCompanyName;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public BigDecimal getTotalUsedAmount() {
		return this.totalUsedAmount;
	}

	public void setTotalUsedAmount(BigDecimal totalUsedAmount) {
		this.totalUsedAmount = totalUsedAmount;
	}

}