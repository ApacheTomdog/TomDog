package com.brcc.business.payoilbill.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the pay_oil_bill database table.
 * 
 */
@Entity
@Table(name="pay_oil_bill")
@NamedQuery(name="PayOilBillEntity.findAll", query="SELECT p FROM PayOilBillEntity p")
public class PayOilBillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pay_oil_id")
	private Long payOilId;

	@Column(name="card_id")
	private Long cardId;

	@Column(name="card_name")
	private String cardName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_person_id")
	private Long createPersonId;

	@Column(name="create_person_name")
	private String createPersonName;

	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_num")
	private String deliveryNum;

	@Column(name="docu_from_type")
	private String docuFromType;

	@Column(name="docu_status")
	private String docuStatus;

	@Column(name="driver_id")
	private Long driverId;

	@Column(name="driver_name")
	private String driverName;

	@Column(name="fk_company_id")
	private Long fkCompanyId;

	@Column(name="fk_company_name")
	private String fkCompanyName;

	@Column(name="modify_check_flag")
	private String modifyCheckFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	@Column(name="modify_person_id")
	private Long modifyPersonId;

	@Column(name="modify_person_name")
	private String modifyPersonName;

	@Column(name="oil_amount")
	private BigDecimal oilAmount;

	@Column(name="oil_amount_act")
	private BigDecimal oilAmountAct;

	@Column(name="pay_bill_child_id")
	private Long payBillChildId;

	@Column(name="pay_bill_child_num")
	private String payBillChildNum;

	@Column(name="pay_bill_id")
	private Long payBillId;

	@Column(name="pay_bill_num")
	private String payBillNum;

	@Column(name="pay_oil_num")
	private String payOilNum;

	@Column(name="platform_id")
	private String platformId;

	@Column(name="publish_company_id")
	private Long publishCompanyId;

	@Column(name="publish_company_name")
	private String publishCompanyName;

	@Column(name="publish_id")
	private Long publishId;

	@Column(name="publish_num")
	private String publishNum;

	@Column(name="sk_company_id")
	private Long skCompanyId;

	@Column(name="sk_company_name")
	private String skCompanyName;

	@Column(name="sk_company_nature")
	private String skCompanyNature;

	@Column(name="trans_id")
	private Long transId;

	@Column(name="trans_num")
	private String transNum;

	@Column(name="vehicle_id")
	private Long vehicleId;

	@Column(name="vehicle_num")
	private String vehicleNum;

	public PayOilBillEntity() {
	}

	public Long getPayOilId() {
		return this.payOilId;
	}

	public void setPayOilId(Long payOilId) {
		this.payOilId = payOilId;
	}

	public Long getCardId() {
		return this.cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
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

	public String getDocuFromType() {
		return this.docuFromType;
	}

	public void setDocuFromType(String docuFromType) {
		this.docuFromType = docuFromType;
	}

	public String getDocuStatus() {
		return this.docuStatus;
	}

	public void setDocuStatus(String docuStatus) {
		this.docuStatus = docuStatus;
	}

	public Long getDriverId() {
		return this.driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getFkCompanyId() {
		return this.fkCompanyId;
	}

	public void setFkCompanyId(Long fkCompanyId) {
		this.fkCompanyId = fkCompanyId;
	}

	public String getFkCompanyName() {
		return this.fkCompanyName;
	}

	public void setFkCompanyName(String fkCompanyName) {
		this.fkCompanyName = fkCompanyName;
	}

	public String getModifyCheckFlag() {
		return this.modifyCheckFlag;
	}

	public void setModifyCheckFlag(String modifyCheckFlag) {
		this.modifyCheckFlag = modifyCheckFlag;
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

	public BigDecimal getOilAmount() {
		return this.oilAmount;
	}

	public void setOilAmount(BigDecimal oilAmount) {
		this.oilAmount = oilAmount;
	}

	public BigDecimal getOilAmountAct() {
		return this.oilAmountAct;
	}

	public void setOilAmountAct(BigDecimal oilAmountAct) {
		this.oilAmountAct = oilAmountAct;
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

	public String getPayOilNum() {
		return this.payOilNum;
	}

	public void setPayOilNum(String payOilNum) {
		this.payOilNum = payOilNum;
	}

	public String getPlatformId() {
		return this.platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
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

	public Long getPublishId() {
		return this.publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public String getPublishNum() {
		return this.publishNum;
	}

	public void setPublishNum(String publishNum) {
		this.publishNum = publishNum;
	}

	public Long getSkCompanyId() {
		return this.skCompanyId;
	}

	public void setSkCompanyId(Long skCompanyId) {
		this.skCompanyId = skCompanyId;
	}

	public String getSkCompanyName() {
		return this.skCompanyName;
	}

	public void setSkCompanyName(String skCompanyName) {
		this.skCompanyName = skCompanyName;
	}

	public String getSkCompanyNature() {
		return this.skCompanyNature;
	}

	public void setSkCompanyNature(String skCompanyNature) {
		this.skCompanyNature = skCompanyNature;
	}

	public Long getTransId() {
		return this.transId;
	}

	public void setTransId(Long transId) {
		this.transId = transId;
	}

	public String getTransNum() {
		return this.transNum;
	}

	public void setTransNum(String transNum) {
		this.transNum = transNum;
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