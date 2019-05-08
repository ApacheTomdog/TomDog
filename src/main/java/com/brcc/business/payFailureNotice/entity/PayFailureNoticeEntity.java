package com.brcc.business.payFailureNotice.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pay_failure_notice database table.
 * 
 */
@Entity
@Table(name="pay_failure_notice")
/*@NamedQuery(name="PayFailureNoticeEntity.findAll", query="SELECT p FROM PayFailureNoticeEntity p")*/
public class PayFailureNoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_failure_id")
	private Long payFailureId;

	@Column(name="carry_company_id")
	private Long carryCompanyId;

	@Column(name="carry_company_name")
	private String carryCompanyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_num")
	private String deliveryNum;

	@Column(name="pay_bank_name")
	private String payBankName;

	@Column(name="pay_bank_no")
	private String payBankNo;

	@Column(name="pay_bank_owner")
	private String payBankOwner;

	@Column(name="pay_bill_child_id")
	private Long payBillChildId;

	@Column(name="pay_bill_child_num")
	private String payBillChildNum;

	@Column(name="pay_bill_id")
	private Long payBillId;

	@Column(name="pay_bill_num")
	private String payBillNum;

	@Column(name="pay_company_id")
	private Long payCompanyId;

	@Column(name="pay_company_name")
	private String payCompanyName;

	@Column(name="pay_from_type")
	private String payFromType;

	@Column(name="platform_id")
	private String platformId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="process_date")
	private Date processDate;

	@Column(name="process_flag")
	private String processFlag;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_company_name")
	private String publishCompanyName;

	@Column(name="vehicle_id")
	private Long vehicleId;

	@Column(name="vehicle_num")
	private String vehicleNum;


	public Long getPayFailureId() {
		return this.payFailureId;
	}

	public void setPayFailureId(Long payFailureId) {
		this.payFailureId = payFailureId;
	}

	public Long getCarryCompanyId() {
		return this.carryCompanyId;
	}

	public void setCarryCompanyId(Long carryCompanyId) {
		this.carryCompanyId = carryCompanyId;
	}

	public String getCarryCompanyName() {
		return this.carryCompanyName;
	}

	public void setCarryCompanyName(String carryCompanyName) {
		this.carryCompanyName = carryCompanyName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryNum() {
		return this.deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public String getPayBankName() {
		return this.payBankName;
	}

	public void setPayBankName(String payBankName) {
		this.payBankName = payBankName;
	}

	public String getPayBankNo() {
		return this.payBankNo;
	}

	public void setPayBankNo(String payBankNo) {
		this.payBankNo = payBankNo;
	}

	public String getPayBankOwner() {
		return this.payBankOwner;
	}

	public void setPayBankOwner(String payBankOwner) {
		this.payBankOwner = payBankOwner;
	}

	public Long getPayBillChildId() {
		return this.payBillChildId;
	}

	public void setPayBillChildId(Long payBillChildId) {
		this.payBillChildId = payBillChildId;
	}

	public String getPayBillChildNum() {
		return this.payBillChildNum;
	}

	public void setPayBillChildNum(String payBillChildNum) {
		this.payBillChildNum = payBillChildNum;
	}

	public Long getPayBillId() {
		return this.payBillId;
	}

	public void setPayBillId(Long payBillId) {
		this.payBillId = payBillId;
	}

	public String getPayBillNum() {
		return this.payBillNum;
	}

	public void setPayBillNum(String payBillNum) {
		this.payBillNum = payBillNum;
	}

	public Long getPayCompanyId() {
		return this.payCompanyId;
	}

	public void setPayCompanyId(Long payCompanyId) {
		this.payCompanyId = payCompanyId;
	}

	public String getPayCompanyName() {
		return this.payCompanyName;
	}

	public void setPayCompanyName(String payCompanyName) {
		this.payCompanyName = payCompanyName;
	}

	public String getPayFromType() {
		return this.payFromType;
	}

	public void setPayFromType(String payFromType) {
		this.payFromType = payFromType;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public String getProcessFlag() {
		return this.processFlag;
	}

	public void setProcessFlag(String processFlag) {
		this.processFlag = processFlag;
	}

	public Long getPublishCompanyId() {
		return this.publishCompanyId;
	}

	public void setPublishCompanyId(Long publishCompanyId) {
		this.publishCompanyId = publishCompanyId;
	}

	public String getPublishCompanyName() {
		return this.publishCompanyName;
	}

	public void setPublishCompanyName(String publishCompanyName) {
		this.publishCompanyName = publishCompanyName;
	}

	public Long getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

}