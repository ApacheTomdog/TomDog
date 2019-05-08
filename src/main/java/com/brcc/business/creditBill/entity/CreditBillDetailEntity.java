package com.brcc.business.creditBill.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="credit_bill_detail")
public class CreditBillDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="credit_bill_detail_id")
	private Long creditBillDetailId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private String createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="credit_bill_id")
	private Long creditBillId;

	@Column(name="credit_bill_no")
	private String creditBillNo;

	@Column(name="credit_company_id")
	private Long creditCompanyId;

	@Column(name="credit_company_name")
	private String creditCompanyName;

	@Column(name="credit_repay_id")
	private Long creditRepayId;

	@Column(name="credit_repay_no")
	private String creditRepayNo;

	@Column(name="invest_company_id")
	private Long investCompanyId;

	@Column(name="invest_company_name")
	private String investCompanyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private String modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="repay_amount")
	private BigDecimal repayAmount;

	public CreditBillDetailEntity() {
	}

	public Long getCreditBillDetailId() {
		return this.creditBillDetailId;
	}

	public void setCreditBillDetailId(Long creditBillDetailId) {
		this.creditBillDetailId = creditBillDetailId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatePersonId() {
		return this.createPersonId;
	}

	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}

	public String getCreatePersonName() {
		return this.createPersonName;
	}

	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	public Long getCreditBillId() {
		return this.creditBillId;
	}

	public void setCreditBillId(Long creditBillId) {
		this.creditBillId = creditBillId;
	}

	public String getCreditBillNo() {
		return this.creditBillNo;
	}

	public void setCreditBillNo(String creditBillNo) {
		this.creditBillNo = creditBillNo;
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

	public Long getCreditRepayId() {
		return this.creditRepayId;
	}

	public void setCreditRepayId(Long creditRepayId) {
		this.creditRepayId = creditRepayId;
	}

	public String getCreditRepayNo() {
		return this.creditRepayNo;
	}

	public void setCreditRepayNo(String creditRepayNo) {
		this.creditRepayNo = creditRepayNo;
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

	public String getModifyPersonId() {
		return this.modifyPersonId;
	}

	public void setModifyPersonId(String modifyPersonId) {
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

	public BigDecimal getRepayAmount() {
		return this.repayAmount;
	}

	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}

}